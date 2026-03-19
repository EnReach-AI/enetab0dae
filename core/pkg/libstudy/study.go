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
	"aro-ext-app/core/internal/api_client"
	"aro-ext-app/core/internal/config"
	"aro-ext-app/core/internal/constant"
	"aro-ext-app/core/internal/crypto"
	logconfig "aro-ext-app/core/internal/log_config"
	"aro-ext-app/core/internal/starter"
	"aro-ext-app/core/internal/storage"
	"aro-ext-app/core/utils"
	"encoding/json"
	"fmt"
	"log"
	"os"
	"path"
	"sync"

	agentConstant "github.com/aro-network/aro-edge-agent/agent/constant"
	"github.com/sirupsen/logrus"
)

var cfg = config.GetConfig()

var backendThreadOnce sync.Once

// NodeSignUp 节点注册（/api/liteNode/signUp）
// 参数：publicKeyPem - RSA 公钥（PEM 格式）
// 返回：JSON formatted响应（包含用户和节点信息）
//
//export NodeSignUp
func NodeSignUp() *C.char {
	defer utils.RecoverAndLog("NodeSignUp")
	log.Println("NodeSignUp called")
	if agentConstant.DEVICE_INFO.SerialNumber != "" {
		sn := agentConstant.DEVICE_INFO.SerialNumber
		var apiResponse = api_client.APIResponse{
			Code:    200,
			Message: "success",
			Data: map[string]interface{}{
				"serialNumber": sn,
			},
		}
		return toCStringJSON("NodeSignUp", apiResponse)
	}
	var apiResponse = api_client.APIResponse{
		Code:    400,
		Message: "failed",
		Data:    nil,
	}

	return toCStringJSON("NodeSignUp", apiResponse)
}

//
//export InitLibstudy
func InitLibstudy(initParamsJSON *C.char) *C.char {
	defer utils.RecoverAndLog("InitLibstudy")
	details := map[string]interface{}{}

	// 解析初始化参数
	var initParams InitParams
	paramsStr := goStringFromC(initParamsJSON)
	if paramsStr != "" {
		if err := json.Unmarshal([]byte(paramsStr), &initParams); err != nil {
			details["params_error"] = err.Error()
			return reply("InitLibstudy", 400, fmt.Sprintf("Failed to parse init params: %v", err), details)
		}
		if initParams.AppDir != "" {
			appDir := initParams.AppDir
			cfg.SetPath(path.Join(appDir, ".env"))
			cfg.SetAndSave(config.KeyAgentPath, appDir)

		} else {
			reply("InitLibstudy", 400, "Libstudy initialized failed: AppDir is empty", details)
		}
		// 验证并更新服务器配置
		if initParams.Config.BaseAPIURL != "" {
			cfg.SetAndSave(config.KeyAPIURL, initParams.Config.BaseAPIURL)
			agentConstant.HTTP_SERVER_ENDPOINT = initParams.Config.BaseAPIURL
		}
		allConfig := cfg.GetAll()
		initLog()
		log.Printf("All config: %+v", allConfig)
		log.Printf("initLibStudy params: %+v", paramsStr)
		// 使用 sync.Once 确保后台线程只启动一次
		backendThreadOnce.Do(func() {
			go starter.RunBackendThread()
			log.Println("Backend thread started (first time only)")
		})

		// // 等待初始化完成，最多等待 40 秒
		// select {
		// case <-initDone:
		// 	log.Println("Backend thread initialization completed")
		// 	details["backend_status"] = "initialized"
		// case <-time.After(40 * time.Second):
		// 	log.Println("Backend thread initialization timeout, but continuing...")
		// 	details["backend_status"] = "timeout"
		// 	return reply("InitLibstudy", 400, "Libstudy initialized failed timeout", details)
		// }
	}
	return reply("InitLibstudy", 200, "Libstudy initialized successfully", details)

}

// getLogFilePath 获取日志文件路径，优先级：环境变量 > 当前工作目录/log > 临时目录

// 日志初始化（Logrus + Lumberjack）
func initLog() {
	// cfg.SetAndSave(config.KeyAgentPath, workDir)
	// 创建日志文件路径
	logPath := logconfig.GetLogFilePath()

	// 以追加模式打开日志文件
	logFile, err := os.OpenFile(logPath, os.O_CREATE|os.O_APPEND|os.O_WRONLY, 0644)
	if err != nil {
		log.Printf("failed to open log file, fallback to stdout: %v", err)
		// logFile = os.Stdout
	}

	// 配置 logrus
	logrus.SetFormatter(&logrus.TextFormatter{
		FullTimestamp:   true,
		TimestampFormat: "2006-01-02 15:04:05.000",
	})
	logrus.SetOutput(logFile)
	logrus.SetLevel(logrus.InfoLevel)

	// 配置标准 log 包，使用同一个日志文件
	log.SetOutput(logFile)
	log.SetFlags(log.Ldate | log.Ltime | log.Lshortfile)
	logrus.Info("==== libstudy started ====")
	log.Println("[INFO] libstudy standard logger initialized")
}

// goStringFromC 安全地将 C 字符串转换为 Go 字符串，处理 NULL 指针
func goStringFromC(s *C.char) string {
	if s == nil {
		return ""
	}
	return C.GoString(s)
}

// recoverAndLog 捕获 panic 并返回错误 JSON

func toCStringJSON(methodName string, v interface{}) *C.char {
	data, _ := json.Marshal(v)
	log.Printf("[%s] response json: %+v", methodName, v)
	return C.CString(string(data))
}

func reply(methodName string, code int, message string, data interface{}) *C.char {
	return toCStringJSON(methodName, api_client.APIResponse{
		Code:    code,
		Message: message,
		Data:    data,
	})
}

// ServerConfig 结构体用于管理服务器配置参数
type ServerConfig struct {
	BaseAPIURL string `json:"BaseAPIURL"`
}

// InitParams 初始化参数结构体
type InitParams struct {
	Config ServerConfig `json:"config"`
	AppDir string       `json:"appDir"`
}

// Global variables
var (
	apiClient  *api_client.APIClient
	keyPair    *crypto.KeyPair
	clientID   string
	storageApi *storage.Storage
)

// ======================
// API 调用导出函数（通过 dlopen 暴露）
// =============================
// 这些函数对应 client.go 中定义的各种 API 端点
// 供动态加载该库的应用（如 Flutter）通过 FFI 调用

// GetNodeStat 获取节点统计信息（/api/liteNode/stat）
// 返回：JSON formatted响应（包含用户信息、节点状态、积分等）
//
//export GetNodeStat
func GetNodeStat() *C.char {
	defer utils.RecoverAndLog("GetNodeStat")
	log.Println("GetNodeStat called")
	var status = "connected"
	if agentConstant.GRPC_STATUS == 0 {
		status = "disconnected"
	}
	NodeBindResponse := api_client.NodeBindResponse{
		Connect:      status,
		Message:      nil,
		SerialNumber: agentConstant.DEVICE_INFO.SerialNumber,
	}
	if agentConstant.NODE_INFO.UUID != "" {
		if agentConstant.NODE_INFO.BanIP {
			NodeBindResponse.Connect = "Restricted ip"
		}
		NodeBindResponse.Bind = &agentConstant.NODE_INFO.Binded
		NodeBindResponse.BindUser = &api_client.BindUserInfo{
			UUID:       agentConstant.NODE_INFO.UUID,
			Email:      agentConstant.NODE_INFO.Email,
			InviteCode: agentConstant.NODE_INFO.InviteCode,
			PublicIP:   agentConstant.NODE_INFO.PublicIp,
		}
	}
	var apiResponse = api_client.APIResponse{
		Code:    200,
		Message: "success",
		Data:    NodeBindResponse,
	}
	return toCStringJSON("GetNodeStat", apiResponse)
}

// GetRewards 获取奖励信息
// 返回：JSON formatted响应（包含最后网络点数、总奖励、7天数据等）
//
//export GetRewards
func GetRewards() *C.char {
	defer utils.RecoverAndLog("GetRewards")
	log.Println("GetRewards called")
	response, err := api_client.GetRewards()
	if err != nil {
		return reply("GetRewards", 500, err.Error(), nil)
	}
	return toCStringJSON("GetRewards", response)
}

// 返回：版本号字符串（C 字符串，调用方需要 free）
//
//export GetCurrentVersion
func GetCurrentVersion() *C.char {
	defer utils.RecoverAndLog("GetCurrentVersion")
	// 从 core/version 包读取注入的版本信息
	return reply("GetCurrentVersion", 200, "success", constant.VERSION)
}

//export GetLastVersion
func GetLastVersion() *C.char {
	defer utils.RecoverAndLog("GetLastVersion")
	resp, err := api_client.GetLastVersion(constant.PROGRAM_APP, constant.ENV)
	if err != nil {
		return reply("GetLastVersion", 500, err.Error(), nil)
	}

	return toCStringJSON("GetLastVersion", resp)
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
// func StartProxyWorker(configJSON *C.char) *C.char {
// 	// defer utils.RecoverAndLog("StartProxyWorker")
// 	// log.Println("StartProxyWorker called")
// 	// var config proxy_worker.ProxyWorkerConfig

// 	// // 解析 JSON 配置
// 	// if err := json.Unmarshal([]byte(goStringFromC(configJSON)), &config); err != nil {
// 	// 	return reply(400, fmt.Sprintf("JSON parsing failed: %s", err.Error()), nil)
// 	// }

// 	// // 获取管理器实例
// 	// manager := proxy_worker.GetManager()

// 	// // 启动 worker
// 	// if err := manager.Start(config); err != nil {
// 	// 	return reply(500, err.Error(), nil)
// 	// }

// 	// // 获取状态
// 	// status := manager.GetStatus()
// 	// statusJSON, _ := json.Marshal(status)

// 	// _ = statusJSON
// 	return reply(200, "Proxy worker started successfully", nil)
// }

// StopProxyWorker 停止代理工作节点
// 返回：JSON 格式的响应，包含成功状态和错误信息
//
//export StopProxyWorker
// func StopProxyWorker() *C.char {
// 	defer utils.RecoverAndLog("StopProxyWorker")
// 	log.Println("StopProxyWorker called")
// 	manager := proxy_worker.GetManager()

// 	if err := manager.Stop(); err != nil {
// 		return reply(500, err.Error(), nil)
// 	}
// 	return reply(200, "Proxy worker stopped successfully", nil)
// }

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
// func GetProxyWorkerStatus() *C.char {
// 	defer utils.RecoverAndLog("GetProxyWorkerStatus")
// 	log.Println("GetProxyWorkerStatus called")
// 	manager := proxy_worker.GetManager()
// 	status := manager.GetStatus()
// 	return reply(200, "Proxy worker status fetched", status)
// }

// // RestartProxyWorker 重启代理工作节点
// // 使用之前的配置重新启动 worker
// // 返回：JSON 格式的响应，包含成功状态和错误信息
// //
// //export RestartProxyWorker
// func RestartProxyWorker() *C.char {
// 	defer utils.RecoverAndLog("RestartProxyWorker")
// 	log.Println("RestartProxyWorker called")
// 	manager := proxy_worker.GetManager()

// 	if err := manager.Restart(); err != nil {
// 		return reply(500, err.Error(), nil)
// 	}

// 	// 获取新的状态
// 	status := manager.GetStatus()
// 	statusJSON, _ := json.Marshal(status)

// 	_ = statusJSON
// 	return reply(200, "Proxy worker restarted successfully", status)
// }

// // IsProxyWorkerRunning 检查代理工作节点是否正在运行
// // 返回：JSON 格式的响应，包含运行状态
// //
// //export IsProxyWorkerRunning
// func IsProxyWorkerRunning() *C.char {
// 	defer utils.RecoverAndLog("IsProxyWorkerRunning")
// 	log.Println("IsProxyWorkerRunning called")
// 	manager := proxy_worker.GetManager()
// 	isRunning := manager.IsRunning()
// 	return reply(200, "ok", map[string]bool{"is_running": isRunning})
// }

// // Cleanup 清理所有资源，在应用退出前调用
// // 停止所有后台任务，关闭连接，释放资源
// // 返回：JSON 格式的响应
// //
// //export Cleanup
// func Cleanup() *C.char {
// 	defer utils.RecoverAndLog("Cleanup")
// 	log.Println("Cleanup called")

// 	data := map[string]interface{}{}

// 	// 停止 proxy worker（如果在运行）
// 	manager := proxy_worker.GetManager()
// 	if manager.IsRunning() {
// 		if err := manager.Stop(); err != nil {
// 			log.Printf("Cleanup: failed to stop proxy worker: %v", err)
// 			data["proxy_worker_stop_error"] = err.Error()
// 		} else {
// 			log.Println("Cleanup: proxy worker stopped")
// 		}
// 	}

// 	// 清空全局变量
// 	apiClient = nil
// 	keyPair = nil
// 	clientID = ""

// 	log.Println("Cleanup: all resources cleaned")
// 	os.Stderr.Sync() // 确保日志写入
// 	return reply(200, "Cleanup completed", data)
// }

// main 是空的，仅作为编译共享库的入口点
// 所有功能都通过导出的 C 函数实现

func main() {
}
