package api_client

import (
	"aro-ext-app/core/internal/constant"
	"crypto/rand"
	"crypto/rsa"
	"crypto/sha256"
	"crypto/x509"
	base64 "encoding/base64"
	"encoding/json"
	"encoding/pem"
	"fmt"
	"io"
	"net/http"
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
	SerialNumber string
	DeviceType   string
	authToken    string
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

func getAuthToken(deviceType string, serialNumber string) (string, error) {
	msg := fmt.Sprintf("enreach:%s:%s", deviceType, serialNumber)
	return PublicEncrypt(constant.BACKEND_ENCODE_PUBLIC_KEY, msg)
}

func NewBackendService(deviceType string, serialNumber string) *BackendService {
	authToken, _ := getAuthToken(deviceType, serialNumber)
	bs := &BackendService{
		SerialNumber: serialNumber,
		DeviceType:   deviceType,
		authToken:    authToken,
	}
	// Set as default instance for direct calls
	defaultBackendService = bs
	return bs
}


// 辅助函数：从指定 URL 获取版本信息
// 内部实现细节
func (b *BackendService) get(path string) (*APIResponse, error) {
	url := fmt.Sprintf("%s%s", constant.HTTP_SERVER_ENDPOINT, path)

	req, err := http.NewRequest("GET", url, nil)
	if err != nil {
		return nil, fmt.Errorf("failed to create request: %v", err)
	}

	// Add auth header
	req.Header.Set("Authorization", b.authToken)

	client := &http.Client{}
	resp, err := client.Do(req)
	if err != nil {
		return nil, fmt.Errorf("failed to send request: %v", err)
	}
	defer resp.Body.Close()
	respBody, err := io.ReadAll(resp.Body)
	var apiResp APIResponse
	if err := json.Unmarshal(respBody, &apiResp); err != nil {
		return nil, fmt.Errorf("failed to parse response (HTTP %d): %w", resp.StatusCode, err)
	}

	if apiResp.Code != 0 && apiResp.Code != 200 {
		return &apiResp, fmt.Errorf("API error: code=%d, message=%s", apiResp.Code, apiResp.Message)
	}
	return &apiResp, nil
}
