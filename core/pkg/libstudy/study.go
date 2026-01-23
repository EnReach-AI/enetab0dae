package main

/*
#cgo CFLAGS: -fPIC
#cgo linux LDFLAGS: -shared
#cgo darwin LDFLAGS: -shared
#cgo windows LDFLAGS: -shared
#cgo android LDFLAGS: -shared
#include <stdlib.h>
#include <string.h>
*/
import "C"

import (
	"aro-ext-app/core/internal/constant"
	"aro-ext-app/core/internal/proxy_worker"
	"aro-ext-app/core/internal/storage"
	"encoding/json"
	"fmt"
	"log"
	"os"

	"aro-ext-app/core/internal/api_client"
	"aro-ext-app/core/internal/crypto"
	"aro-ext-app/core/internal/ws_client"
)

// goStringFromC 安全地将 C 字符串转换为 Go 字符串，处理 NULL 指针
func goStringFromC(s *C.char) string {
	if s == nil {
		return ""
	}
	return C.GoString(s)
}

// recoverAndLog 捕获 panic 并返回错误 JSON
func recoverAndLog(funcName string) {
	if r := recover(); r != nil {
		log.Printf("%s panic recovered: %v", funcName, r)
		os.Stderr.Sync() // 确保错误日志写入
	}
}

// ServerConfig 结构体用于管理服务器配置参数
type ServerConfig struct {
	BaseAPIURL string
	BaseWSURL  string
}

// InitParams 初始化参数结构体
type InitParams struct {
	Config ServerConfig `json:"config"`
}

// Global variables
var (
	apiClient    *api_client.APIClient
	wsClient     *ws_client.WSClient
	keyPair      *crypto.KeyPair
	clientID     string
	serverConfig = &ServerConfig{
		BaseAPIURL: constant.HTTP_SERVER_ENDPOINT,
		BaseWSURL:  constant.WS_SERVER_ENDPOINT,
	}
	storageApi *storage.Storage
)

const (
	Version string = "0.0.1"
)

// init package initialization function，automatically called when dynamic library is loaded
// auto initialize keypair and apiClient
// func init() {
// 	// try to load keypair from current directory
// 	var err error
// 	keyPair, err = crypto.GetOrCreateKeyPair("")
// 	if err != nil {
// 		log.Printf("Warning: unable to load keypair during package initialization: %v", err)
// 		return
// 	}
// 	log.Println("libstudy package initialization: keypair auto-loaded/generated")

// 	// auto initialize clientID and apiClient
// 	clientID = crypto.GenerateClientID()
// 	apiClient = api_client.NewAPIClient(serverConfig.BaseAPIURL, clientID, keyPair)
// 	log.Printf("API client auto-initialized with URL: %+v, ClientID: %s", apiClient, clientID)

// 	// auto initialize WebSocket client
// 	//wsClient = ws_client.NewWSClient(serverConfig.BaseWSURL)
// 	//log.Printf("WebSocket client initialized with URL: %s", serverConfig.BaseWSURL)
// }

// ======================
// API 调用导出函数（通过 dlopen 暴露）
// =============================
// 这些函数对应 client.go 中定义的各种 API 端点
// 供动态加载该库的应用（如 Flutter）通过 FFI 调用

// NodeSignUp 节点注册（/api/liteNode/signUp）
// 参数：publicKeyPem - RSA 公钥（PEM 格式）
// 返回：JSON formatted响应（包含用户和节点信息）
//
//export NodeSignUp
func NodeSignUp() *C.char {
	defer recoverAndLog("NodeSignUp")
	log.Println("NodeSignUp called")
	if apiClient == nil {
		return C.CString(`{"error":"apiClient not initialized, call InitLibstudy first"}`)
	}
	resp, err := apiClient.NodeSignUp()
	if err != nil {
		return C.CString(fmt.Sprintf(`{"error":"%s"}`, err.Error()))
	}

	data, _ := json.Marshal(resp)
	log.Println("NodeSignUp response: ", string(data))
	return C.CString(string(data))
}

// NodeReportBaseInfo 上报节点基础信息（/api/liteNode/node/reportBaseInfo）
// 参数：sysInfoJSON - JSON formatted系统信息
// 返回：JSON formatted响应
//
//export NodeReportBaseInfo
func NodeReportBaseInfo(sysInfoJSON *C.char) *C.char {
	defer recoverAndLog("NodeReportBaseInfo")
	log.Println("NodeReportBaseInfo called")
	if apiClient == nil {
		return C.CString(`{"error":"apiClient not initialized, call InitLibstudy first"}`)
	}
	var sysInfo api_client.NodeReportBaseInfoRequest
	if err := json.Unmarshal([]byte(goStringFromC(sysInfoJSON)), &sysInfo); err != nil {
		return C.CString(fmt.Sprintf(`{"error":"JSON parsing failed: %s"}`, err.Error()))
	}

	resp, err := apiClient.NodeReportBaseInfo(sysInfo)
	if err != nil {
		return C.CString(fmt.Sprintf(`{"error":"%s"}`, err.Error()))
	}

	data, _ := json.Marshal(resp)
	log.Println("NodeReportBaseInfo response: ", string(data))
	return C.CString(string(data))
}

// GetNodeStat 获取节点统计信息（/api/liteNode/stat）
// 返回：JSON formatted响应（包含用户信息、节点状态、积分等）
//
//export GetNodeStat
func GetNodeStat() *C.char {
	defer recoverAndLog("GetNodeStat")
	log.Println("GetNodeStat called")
	if apiClient == nil {
		return C.CString(`{"error":"apiClient not initialized, call InitLibstudy first"}`)
	}
	resp, err := apiClient.GetNodeStat()
	if err != nil {
		return C.CString(fmt.Sprintf(`{"error":"%s"}`, err.Error()))
	}

	data, _ := json.Marshal(resp)
	log.Println("GetNodeStat response: ", string(data))
	return C.CString(string(data))
}

// GetRewards 获取奖励信息（/api/liteNode/rewards）
// 返回：JSON formatted响应（包含最后网络点数、总奖励、7天数据等）
//
//export GetRewards
func GetRewards() *C.char {
	defer recoverAndLog("GetRewards")
	log.Println("GetRewards called")
	if apiClient == nil {
		return C.CString(`{"error":"apiClient not initialized, call InitLibstudy first"}`)
	}
	resp, err := apiClient.GetRewards()
	if err != nil {
		return C.CString(fmt.Sprintf(`{"error":"%s"}`, err.Error()))
	}

	data, _ := json.Marshal(resp)
	log.Println("GetRewards response: ", string(data))
	return C.CString(string(data))
}

// InitLibstudy 初始化 libstudy 库
// 加载或创建密钥对、初始化 API 客户端和 WebSocket 客户端
// 参数：initParamsJSON - JSON 格式的初始化参数，包含 ServerConfig
// 返回：JSON formatted响应（包含初始化状态和各个组件的信息）
//
//export InitLibstudy
func InitLibstudy(initParamsJSON *C.char) *C.char {
	defer recoverAndLog("InitLibstudy")
	log.Println("InitLibstudy called")

	result := map[string]interface{}{
		"success": true,
		"message": "Libstudy initialized successfully",
		"details": map[string]interface{}{},
	}
	details := result["details"].(map[string]interface{})

	// 解析初始化参数
	var initParams InitParams
	paramsStr := goStringFromC(initParamsJSON)
	log.Printf("InitLibstudy params: %s", paramsStr)
	if paramsStr != "" {
		if err := json.Unmarshal([]byte(paramsStr), &initParams); err != nil {
			result["success"] = false
			result["message"] = fmt.Sprintf("Failed to parse init params: %v", err)
			details["params_error"] = err.Error()
			data, _ := json.Marshal(result)
			return C.CString(string(data))
		}

		// 验证并更新服务器配置
		if initParams.Config.BaseAPIURL != "" {
			serverConfig.BaseAPIURL = initParams.Config.BaseAPIURL
		}
		if initParams.Config.BaseWSURL != "" {
			serverConfig.BaseWSURL = initParams.Config.BaseWSURL
		}
	}

	// 加载或创建密钥对
	var err error
	keyPair, err = crypto.GetOrCreateKeyPair("")
	if err != nil {
		result["success"] = false
		result["message"] = fmt.Sprintf("Failed to initialize libstudy: %v", err)
		details["keypair_error"] = err.Error()
		data, _ := json.Marshal(result)
		return C.CString(string(data))
	}
	details["keypair_status"] = "loaded/created"
	details["keypair_path"] = ""

	// 更新全局 Server Config
	details["api_url"] = serverConfig.BaseAPIURL
	details["ws_url"] = serverConfig.BaseWSURL

	// 初始化客户端 ID
	clientID = crypto.GenerateClientID()
	details["client_id"] = clientID

	// 初始化 API 客户端
	apiClient = api_client.NewAPIClient(serverConfig.BaseAPIURL, clientID, keyPair)
	details["api_client_status"] = "initialized"

	data, _ := json.Marshal(result)
	cstr := C.CString(string(data))
	log.Println("InitLibstudy result: ", string(data))
	os.Stderr.Sync() // 确保日志完全写入
	return cstr
}

// 返回：版本号字符串（C 字符串，调用方需要 free）
//
//export GetCurrentVersion
func GetCurrentVersion() *C.char {
	defer recoverAndLog("GetCurrentVersion")
	log.Println("GetCurrentVersion called")
	// 从 core/version 包读取注入的版本信息
	cstr := C.CString(string(Version))
	os.Stderr.Sync()
	return cstr
}

//export GetLastVersion
func GetLastVersion() *C.char {
	defer recoverAndLog("GetLastVersion")
	log.Println("GetLastVersion called")
	apiResponse, err := api_client.GetLastVersion(constant.PROGRAM_APP, constant.ENV)
	if err != nil {
		return C.CString(fmt.Sprintf(`{"error":"%s"}`, err.Error()))
	}
	bytes, _ := json.Marshal(apiResponse)
	return C.CString(string(bytes))
}

// ======================
// Proxy Worker 相关导出函数
// ======================

// StartProxyWorker 启动代理工作节点
// 参数：configJSON - JSON 格式的配置字符串，包含以下字段：
//   - sn: 设备序列号
//   - token: 认证 Token
//   - tunnel_id: 隧道 ID
//   - proxy_server_ip: 代理服务器 IP
//   - proxy_server_port: 代理服务器端口
//   - local_port: 本地端口
//   - nat_type: NAT 类型 (0: 动态IP, 1: 静态IP)
//   - fixed_port: 固定端口（仅用于静态 IP）
//   - disable_tls: 是否禁用 TLS（可选，默认 false，即默认使用 wss 加密连接）
//   - tls_secure: 是否验证服务器证书（可选，默认 false，即跳过证书验证）
//   - server_name: TLS ServerName（可选，用于证书验证，为空时使用 proxy_server_ip）
//
// 返回：JSON 格式的响应，包含成功状态和错误信息
//
//export StartProxyWorker
func StartProxyWorker(configJSON *C.char) *C.char {
	defer recoverAndLog("StartProxyWorker")
	log.Println("StartProxyWorker called")
	var config proxy_worker.ProxyWorkerConfig

	// 解析 JSON 配置
	if err := json.Unmarshal([]byte(goStringFromC(configJSON)), &config); err != nil {
		return C.CString(fmt.Sprintf(`{"success":false,"error":"JSON parsing failed: %s"}`, err.Error()))
	}

	// 获取管理器实例
	manager := proxy_worker.GetManager()

	// 启动 worker
	if err := manager.Start(config); err != nil {
		return C.CString(fmt.Sprintf(`{"success":false,"error":"%s"}`, err.Error()))
	}

	// 获取状态
	status := manager.GetStatus()
	statusJSON, _ := json.Marshal(status)

	result := map[string]interface{}{
		"success": true,
		"message": "Proxy worker started successfully",
		"status":  json.RawMessage(statusJSON),
	}

	data, _ := json.Marshal(result)
	log.Println("StartProxyWorker result: ", string(data))
	return C.CString(string(data))
}

// StopProxyWorker 停止代理工作节点
// 返回：JSON 格式的响应，包含成功状态和错误信息
//
//export StopProxyWorker
func StopProxyWorker() *C.char {
	defer recoverAndLog("StopProxyWorker")
	log.Println("StopProxyWorker called")
	manager := proxy_worker.GetManager()

	if err := manager.Stop(); err != nil {
		return C.CString(fmt.Sprintf(`{"success":false,"error":"%s"}`, err.Error()))
	}

	result := map[string]interface{}{
		"success": true,
		"message": "Proxy worker stopped successfully",
	}

	data, _ := json.Marshal(result)
	log.Println("StopProxyWorker result: ", string(data))
	return C.CString(string(data))
}

// GetProxyWorkerStatus 获取代理工作节点状态
// 返回：JSON 格式的状态信息，包含以下字段：
//   - is_running: 是否正在运行
//   - pid: 进程 ID
//   - local_port: 本地端口
//   - fixed_port: 固定端口（静态IP时使用）
//   - tunnel_id: 隧道 ID
//   - start_time: 启动时间（Unix 时间戳）
//   - error: 错误信息（如果有）
//
//export GetProxyWorkerStatus
func GetProxyWorkerStatus() *C.char {
	defer recoverAndLog("GetProxyWorkerStatus")
	log.Println("GetProxyWorkerStatus called")
	manager := proxy_worker.GetManager()
	status := manager.GetStatus()

	data, _ := json.Marshal(status)
	log.Println("GetProxyWorkerStatus result: ", string(data))
	return C.CString(string(data))
}

// RestartProxyWorker 重启代理工作节点
// 使用之前的配置重新启动 worker
// 返回：JSON 格式的响应，包含成功状态和错误信息
//
//export RestartProxyWorker
func RestartProxyWorker() *C.char {
	defer recoverAndLog("RestartProxyWorker")
	log.Println("RestartProxyWorker called")
	manager := proxy_worker.GetManager()

	if err := manager.Restart(); err != nil {
		return C.CString(fmt.Sprintf(`{"success":false,"error":"%s"}`, err.Error()))
	}

	// 获取新的状态
	status := manager.GetStatus()
	statusJSON, _ := json.Marshal(status)

	result := map[string]interface{}{
		"success": true,
		"message": "Proxy worker restarted successfully",
		"status":  json.RawMessage(statusJSON),
	}

	data, _ := json.Marshal(result)
	log.Println("RestartProxyWorker result: ", string(data))
	return C.CString(string(data))
}

// IsProxyWorkerRunning 检查代理工作节点是否正在运行
// 返回：JSON 格式的响应，包含运行状态
//
//export IsProxyWorkerRunning
func IsProxyWorkerRunning() *C.char {
	defer recoverAndLog("IsProxyWorkerRunning")
	log.Println("IsProxyWorkerRunning called")
	manager := proxy_worker.GetManager()
	isRunning := manager.IsRunning()

	result := map[string]interface{}{
		"is_running": isRunning,
	}

	data, _ := json.Marshal(result)
	log.Println("IsProxyWorkerRunning result: ", string(data))
	return C.CString(string(data))
}

// Cleanup 清理所有资源，在应用退出前调用
// 停止所有后台任务，关闭连接，释放资源
// 返回：JSON 格式的响应
//
//export Cleanup
func Cleanup() *C.char {
	defer recoverAndLog("Cleanup")
	log.Println("Cleanup called")

	result := map[string]interface{}{
		"success": true,
		"message": "Cleanup completed",
	}

	// 停止 proxy worker（如果在运行）
	manager := proxy_worker.GetManager()
	if manager.IsRunning() {
		if err := manager.Stop(); err != nil {
			log.Printf("Cleanup: failed to stop proxy worker: %v", err)
			result["proxy_worker_stop_error"] = err.Error()
		} else {
			log.Println("Cleanup: proxy worker stopped")
		}
	}

	// 清空全局变量
	apiClient = nil
	wsClient = nil
	keyPair = nil
	clientID = ""

	log.Println("Cleanup: all resources cleaned")
	os.Stderr.Sync() // 确保日志写入

	data, _ := json.Marshal(result)
	return C.CString(string(data))
}

// main 是空的，仅作为编译共享库的入口点
// 所有功能都通过导出的 C 函数实现
func main() {
}
