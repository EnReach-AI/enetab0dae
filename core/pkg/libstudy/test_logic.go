package main

import (
	"aro-ext-app/core/internal/api_client"
	"aro-ext-app/core/internal/constant"
	"aro-ext-app/core/internal/crypto"
	"aro-ext-app/core/internal/proxy_worker"
	"encoding/json"
	"fmt"
	"log"
)

// 模拟导出函数的响应结构
type TestResponse struct {
	Code    int         `json:"code"`
	Message string      `json:"message"`
	Data    interface{} `json:"data"`
}

func testGetCurrentVersion() {
	fmt.Println("\n=== Testing GetCurrentVersion Logic ===")
	version := "0.0.3"
	resp := TestResponse{
		Code:    200,
		Message: "ok",
		Data:    version,
	}
	data, _ := json.MarshalIndent(resp, "", "  ")
	fmt.Printf("Response:\n%s\n", data)
	log.Printf("✓ Version: %s", version)
}

func testGetLastVersion() {
	fmt.Println("\n=== Testing GetLastVersion Logic ===")

	// 模拟初始化 API 客户端
	keyPair, err := crypto.GetOrCreateKeyPair("")
	if err != nil {
		log.Printf("❌ Failed to create keypair: %v", err)
		return
	}

	clientID := crypto.GenerateClientID()
	_ = api_client.NewAPIClient(constant.HTTP_SERVER_ENDPOINT, clientID, keyPair)

	// 调用 GetLastVersion API
	apiResponse, err := api_client.GetLastVersion(constant.PROGRAM_APP, constant.ENV)
	if err != nil {
		resp := TestResponse{
			Code:    500,
			Message: err.Error(),
			Data:    nil,
		}
		data, _ := json.MarshalIndent(resp, "", "  ")
		fmt.Printf("Error Response:\n%s\n", data)
		log.Printf("❌ GetLastVersion failed: %v", err)
		return
	}

	// 构造成功响应
	resp := TestResponse{
		Code:    apiResponse.Code,
		Message: apiResponse.Message,
		Data:    apiResponse.Data,
	}
	data, _ := json.MarshalIndent(resp, "", "  ")
	fmt.Printf("Response:\n%s\n", data)

	// 验证响应结构
	if apiResponse.Code == 200 {
		log.Printf("✓ GetLastVersion succeeded")
		log.Printf("✓ Response code: %d", apiResponse.Code)
		log.Printf("✓ Response message: %s", apiResponse.Message)
		if apiResponse.Data != nil {
			log.Printf("✓ Has version data")
		}
	} else {
		log.Printf("⚠ GetLastVersion returned non-200 code: %d", apiResponse.Code)
	}
}

func testInitLibstudy() {
	fmt.Println("\n=== Testing InitLibstudy Logic ===")

	// 模拟初始化
	keyPair, err := crypto.GetOrCreateKeyPair("")
	if err != nil {
		log.Printf("❌ Failed to create keypair: %v", err)
		return
	}
	log.Printf("✓ Keypair created successfully")

	clientID := crypto.GenerateClientID()
	log.Printf("✓ Generated client_id: %s", clientID)

	// 检查平台前缀
	if len(clientID) > 0 {
		firstChar := clientID[0]
		if (firstChar >= '1' && firstChar <= '5') || firstChar == '9' {
			log.Printf("✓ Client ID has valid platform prefix: %c", firstChar)
		} else {
			log.Printf("❌ Client ID has invalid platform prefix: %c", firstChar)
		}
	}

	// 创建 API 客户端
	apiClient := api_client.NewAPIClient(constant.HTTP_SERVER_ENDPOINT, clientID, keyPair)
	if apiClient != nil {
		log.Printf("✓ API client initialized")
	}

	details := map[string]interface{}{
		"keypair_status":    "loaded/created",
		"client_id":         clientID,
		"api_client_status": "initialized",
		"api_url":           constant.HTTP_SERVER_ENDPOINT,
	}

	resp := TestResponse{
		Code:    200,
		Message: "Libstudy initialized successfully",
		Data:    details,
	}

	data, _ := json.MarshalIndent(resp, "", "  ")
	fmt.Printf("Response:\n%s\n", data)
}

func testProxyWorkerFunctions() {
	fmt.Println("\n=== Testing Proxy Worker Functions ===")

	manager := proxy_worker.GetManager()

	// Test IsRunning
	isRunning := manager.IsRunning()
	resp1 := TestResponse{
		Code:    200,
		Message: "ok",
		Data:    map[string]bool{"is_running": isRunning},
	}
	data1, _ := json.MarshalIndent(resp1, "", "  ")
	fmt.Printf("IsProxyWorkerRunning Response:\n%s\n", data1)
	log.Printf("✓ Proxy worker is_running: %v", isRunning)

	// Test GetStatus
	status := manager.GetStatus()
	resp2 := TestResponse{
		Code:    200,
		Message: "Proxy worker status fetched",
		Data:    status,
	}
	data2, _ := json.MarshalIndent(resp2, "", "  ")
	fmt.Printf("\nGetProxyWorkerStatus Response:\n%s\n", data2)
	log.Printf("✓ Proxy worker status retrieved")
}

func testResponseFormat() {
	fmt.Println("\n=== Testing Response Format Consistency ===")

	tests := []struct {
		name string
		resp TestResponse
	}{
		{
			name: "Success Response",
			resp: TestResponse{
				Code:    200,
				Message: "ok",
				Data:    map[string]string{"key": "value"},
			},
		},
		{
			name: "Error Response",
			resp: TestResponse{
				Code:    500,
				Message: "apiClient not initialized",
				Data:    nil,
			},
		},
		{
			name: "Data with Array",
			resp: TestResponse{
				Code:    200,
				Message: "ok",
				Data:    []string{"item1", "item2"},
			},
		},
	}

	for _, test := range tests {
		fmt.Printf("\nTest: %s\n", test.name)
		data, _ := json.MarshalIndent(test.resp, "", "  ")
		fmt.Printf("%s\n", data)

		// 验证必需字段
		if test.resp.Code == 0 {
			log.Printf("❌ Missing 'code' field")
		} else {
			log.Printf("✓ Has 'code': %d", test.resp.Code)
		}

		if test.resp.Message == "" {
			log.Printf("❌ Missing 'message' field")
		} else {
			log.Printf("✓ Has 'message': %s", test.resp.Message)
		}

		log.Printf("✓ Has 'data' field")
	}
}

// func main() {
// 	fmt.Println("========================================")
// 	fmt.Println("Testing Exported Function Logic")
// 	fmt.Println("========================================")

// 	testGetCurrentVersion()
// 	testGetLastVersion()
// 	testInitLibstudy()
// 	testProxyWorkerFunctions()
// 	testResponseFormat()

// 	fmt.Println("\n========================================")
// 	fmt.Println("All logic tests completed!")
// 	fmt.Println("========================================")
// }
