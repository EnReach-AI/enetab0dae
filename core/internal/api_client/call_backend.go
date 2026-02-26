package api_client

import (
	"aro-ext-app/core/internal/constant"
	"aro-ext-app/core/utils"
	"crypto/rand"
	"crypto/rsa"
	"crypto/sha256"
	"crypto/x509"
	base64 "encoding/base64"
	"encoding/json"
	"encoding/pem"
	"fmt"
	"io"
	"log"
	"net/http"
	"path/filepath"
	"runtime"
	"time"

	"github.com/aro-network/aro-edge-agent/agent/common"
	agentConstant "github.com/aro-network/aro-edge-agent/agent/constant"
	"github.com/aro-network/aro-edge-agent/agent/database/model"
	"github.com/aro-network/aro-edge-agent/agent/util"
	httputil "github.com/aro-network/aro-edge-agent/agent/util/http"
)

type DeviceType string

const (
	DeviceTypeAndroid DeviceType = "android"
	DeviceTypeLinux   DeviceType = "linux"
	DeviceTypeDarwin  DeviceType = "darwin"
	DeviceTypeWindows DeviceType = "windows"
	DeviceTypeIOS     DeviceType = "ios"
)

type BackendService struct {
	deviceInfo model.DeviceInfo
	authToken  string
}

// Package-level singleton instance (可选，用于直接调用)
var defaultBackendService *BackendService

func PublicEncrypt(publicKeyBase64 string, message string) (string, error) {
	// decode the base64 encoded public key
	publicKeyBytes, err := base64.StdEncoding.DecodeString(publicKeyBase64)
	if err != nil {
		return "", fmt.Errorf("failed to decode base64 public key: %v", err)
	}

	// decode the public key in pem format
	block, _ := pem.Decode(publicKeyBytes)
	if block == nil || block.Type != "RSA PUBLIC KEY" {
		return "", fmt.Errorf("failed to decode PEM block containing public key")
	}

	// resolve the public key
	pub, err := x509.ParsePKCS1PublicKey(block.Bytes)
	if err != nil {
		return "", fmt.Errorf("failed to parse public key: %v", err)
	}

	// encryption using rsa oaep
	label := []byte("")
	encryptedBytes, err := rsa.EncryptOAEP(sha256.New(), rand.Reader, pub, []byte(message), label)
	if err != nil {
		return "", fmt.Errorf("failed to encrypt data: %v", err)
	}

	encryptedStr := base64.StdEncoding.EncodeToString(encryptedBytes)
	// returns base64 encoded encrypted data
	return encryptedStr, nil
}

func getAuthToken(deviceInfo model.DeviceInfo) (string, error) {
	msg := fmt.Sprintf("enreach:%s:%s", deviceInfo.DeviceType, deviceInfo.SerialNumber)
	return PublicEncrypt(constant.BACKEND_ENCODE_PUBLIC_KEY, msg)
}

func NewBackendService(deviceInfo model.DeviceInfo) *BackendService {
	authToken, _ := getAuthToken(deviceInfo)
	bs := &BackendService{
		deviceInfo: deviceInfo,
		authToken:  authToken,
	}
	// Set as default instance for direct calls
	defaultBackendService = bs
	return bs
}
func (b *BackendService) GetNodeBindStatus() (model.BindResult, error) {
	var data = model.BindResult{}

	// log.Println("GetNodeBindStatus authToken:" + b.authToken)
	client := httputil.NewClient(constant.HTTP_SERVER_ENDPOINT, b.authToken)
	if b.deviceInfo.SerialNumber == "" {
		return data, fmt.Errorf("device info issure :%+v", b)
	}
	deviceBaseInfo := utils.GetDeviceBaseInfo()
	if agentConstant.PAGE_MESSGE != nil && agentConstant.PAGE_MESSGE.Source == "agent" {
		deviceBaseInfo.DeviceInfo.WorkStatusInfo = *agentConstant.PAGE_MESSGE
	}
	if agentConstant.HOST_INFO != nil {
		deviceBaseInfo.DeviceInfo.HostInfo = *agentConstant.HOST_INFO
	}
	resp, err := client.Post("/api/keeper/report", deviceBaseInfo)

	if err != nil {
		return data, fmt.Errorf("failed to send request: %v", err)
	}
	defer resp.Body.Close()
	if resp.StatusCode == 200 {
		body, err := io.ReadAll(resp.Body)
		if err != nil {
			return data, fmt.Errorf("failed to read the response body: %v", err)
		}
		var apiResponse httputil.CommonResponse[model.BindResult]
		if err := json.Unmarshal(body, &apiResponse); err != nil {
			return data, fmt.Errorf("JSON parsing failed: %v", err)
		}

		if apiResponse.Data.PublicKey == "" {
			//1. Check whether there is a private key file in the local area
			//2. Delete the file if there is a private key file
			//3. Generate a new pair of public and private keys to save
			go b.ReportPubKey()

			return apiResponse.Data, nil
		} else if apiResponse.Data.Binded {
			//check local aro_rsa file exist
			exist, _ := common.IsExist(filepath.Join(agentConstant.AGENT_DIR_PATH, agentConstant.ARO_PRIVATE_KEY_NAME))
			if !exist {
				err := b.ResetPubKey()
				if err != nil {
					log.Println("failed to reset pubkey", err)
				}
			}
		}
		if apiResponse.Data.WorkStatusResp.Status != "Normal" {
			statusResp := apiResponse.Data.WorkStatusResp
			if agentConstant.PAGE_MESSGE != nil && agentConstant.PAGE_MESSGE.Priority > statusResp.Priority {
				agentConstant.PAGE_MESSGE = &model.WorkStatusInfo{
					Status:   statusResp.Status,
					Code:     statusResp.Code,
					Message:  statusResp.Msg,
					Priority: statusResp.Priority,
					Source:   "backend",
				}
			}
		}
		agentConstant.NODE_INFO = apiResponse.Data
		return apiResponse.Data, nil
	} else {
		return data, fmt.Errorf("request failed with code: %d", resp.StatusCode)
	}
}

// 接收者方法版本（用于面向对象调用）
func GetLastVersion(program constant.OtaProgram, env string) (*APIResponse, error) {
	isa := 0
	if runtime.GOARCH == "arm64" {
		isa = 1
	}

	path := fmt.Sprintf("/api/keeper/ota/%s/%s/%d/%s/lastest", program, env, isa, runtime.GOOS)
	backendService := NewBackendService(agentConstant.DEVICE_INFO)
	log.Printf("backendService: %+v", backendService)
	log.Printf("GetLastVersion params: program=%s, env=%s, isa=%d, os=%s, path=%s", program, env, isa, runtime.GOOS, path)
	apiResponse, err := backendService.get(path)
	if err != nil {
		return nil, err
	}
	log.Printf("getLastVersion apiResponse:%+v", apiResponse)
	return apiResponse, nil
}

func GetRewards() (*APIResponse, error) {
	backendService := NewBackendService(agentConstant.DEVICE_INFO)
	apiResponse, err := backendService.get("/api/keeper/rewards")
	if err != nil {
		return nil, err
	}
	return apiResponse, nil
}
func (b *BackendService) ReportPubKey() (string, error) {
	client := httputil.NewClient(agentConstant.HTTP_SERVER_ENDPOINT, b.authToken)
	exist, _ := common.IsExist(agentConstant.AGENT_DIR_PATH + agentConstant.ARO_PRIVATE_KEY_NAME)
	var pubKey, priKey string
	if exist {
		priKey, _ = util.GetKeyField(agentConstant.AGENT_DIR_PATH+agentConstant.ARO_PRIVATE_KEY_NAME, "Private Key")
		pubKey, _ = util.GetKeyField(agentConstant.AGENT_DIR_PATH+agentConstant.ARO_PRIVATE_KEY_NAME, "Public Key")
	} else {
		//sn-signature
		pubKey, priKey = util.InitAuth()
	}

	sign, _ := util.SignWithPrivateKey(priKey, b.deviceInfo.SerialNumber)
	// assemble the json request body
	request := struct {
		PubKey      string `json:"publicKey"`
		SnSignature string `json:"signature"`
	}{
		PubKey:      pubKey,
		SnSignature: sign,
	}
	resp, err := client.Post("/api/keeper/publicKey", request)
	if err != nil {
		return "", fmt.Errorf("failed to send request: %v", err)
	}
	defer resp.Body.Close()
	if resp.StatusCode == 200 {
		// 等待20秒等待数据同步
		time.Sleep(30 * time.Second)
		body, _ := io.ReadAll(resp.Body)
		var response = httputil.CommonResponse[string]{}
		if err := json.Unmarshal(body, &response); err != nil {
			return "", fmt.Errorf("JSON parsing failed: %v", err)
		}
		return response.Message, nil
	}
	body, _ := io.ReadAll(resp.Body)
	log.Printf("failed to report pubkey:%+v", string(body))
	return "", fmt.Errorf("request failed with code: %d", resp.StatusCode)
}

func (b *BackendService) ResetPubKey() error {
	log.Printf("ResetPubKey")
	client := httputil.NewClient(agentConstant.HTTP_SERVER_ENDPOINT, b.authToken)
	exist, _ := common.IsExist(filepath.Join(agentConstant.AGENT_DIR_PATH, agentConstant.ARO_PRIVATE_KEY_NAME))
	var pubKey, priKey string
	if exist {
		priKey, _ = util.GetKeyField(filepath.Join(agentConstant.AGENT_DIR_PATH, agentConstant.ARO_PRIVATE_KEY_NAME), "Private Key")
		pubKey, _ = util.GetKeyField(filepath.Join(agentConstant.AGENT_DIR_PATH, agentConstant.ARO_PRIVATE_KEY_NAME), "Public Key")
	} else {
		//sn-signature
		pubKey, priKey = util.InitAuth()
	}
	sign, _ := util.SignWithPrivateKey(priKey, b.deviceInfo.SerialNumber)
	request := struct {
		PubKey      string `json:"publicKey"`
		SnSignature string `json:"signature"`
	}{
		PubKey:      pubKey,
		SnSignature: sign,
	}
	resp, err := client.Post("/api/keeper/publicKey/reset", request)
	if err != nil {
		return fmt.Errorf("failed to send request: %v", err)
	}
	defer resp.Body.Close()
	if resp.StatusCode == 200 {
		body, _ := io.ReadAll(resp.Body)
		var response = httputil.CommonResponse[string]{}
		if err := json.Unmarshal(body, &response); err != nil {
			return fmt.Errorf("JSON ResetPubKey: %v", err)
		}
		return nil
	}
	return fmt.Errorf("request failed with code: %d", resp.StatusCode)
}
// 辅助函数：从指定 URL 获取版本信息
// 内部实现细节
func (b *BackendService) get(path string) (*APIResponse, error) {
	url := fmt.Sprintf("%s%s", agentConstant.HTTP_SERVER_ENDPOINT, path)

	req, err := http.NewRequest("GET", url, nil)
	if err != nil {
		return nil, fmt.Errorf("failed to create request: %v", err)
	}

	// Add auth header
	req.Header.Set("Authorization", "Bearer "+b.authToken)
	client := &http.Client{}
	resp, err := client.Do(req)
	if err != nil {
		return nil, fmt.Errorf("failed to send request: %v", err)
	}
	defer resp.Body.Close()
	respBody, err := io.ReadAll(resp.Body)
	if err != nil {
		return nil, fmt.Errorf("failed to read response body: %v", err)
	}

	// 打印原始响应体，用于调试
	log.Printf("Raw response body: %s", string(respBody))

	var apiResp APIResponse
	if err := json.Unmarshal(respBody, &apiResp); err != nil {
		return nil, fmt.Errorf("failed to parse response (HTTP %d): %w", resp.StatusCode, err)
	}

	if apiResp.Code != 0 && apiResp.Code != 200 {
		return &apiResp, fmt.Errorf("API error: path=%s code=%d, message=%s", path, apiResp.Code, apiResp.Message)
	}
	return &apiResp, nil
}
