// +build ignore

package main

/*
#include <stdlib.h>
*/
import "C"

import (
	"encoding/json"
	"fmt"
	"log"
)

func testGetCurrentVersion() {
	fmt.Println("\n=== Testing GetCurrentVersion ===")
	result := GetCurrentVersion()
	resultStr := C.GoString(result)
	
	fmt.Printf("Result: %s\n", resultStr)
	
	var response map[string]interface{}
	if err := json.Unmarshal([]byte(resultStr), &response); err != nil {
		log.Fatalf("Failed to parse response: %v", err)
	}
	
	if code, ok := response["code"].(float64); !ok || code != 200 {
		log.Printf("❌ Expected code 200, got %v", response["code"])
	} else {
		log.Printf("✓ Code: %.0f", code)
	}
	
	if data, ok := response["data"].(string); ok {
		log.Printf("✓ Version: %s", data)
	}
}

func testInitLibstudy() {
	fmt.Println("\n=== Testing InitLibstudy ===")
	config := `{
		"config": {
			"BaseAPIURL": "https://staging-api.aro.network",
			"BaseWSURL": "wss://staging-ws.aro.network"
		}
	}`
	
	configPtr := C.CString(config)
	result := InitLibstudy(configPtr)
	resultStr := C.GoString(result)
	
	fmt.Printf("Result: %s\n", resultStr)
	
	var response map[string]interface{}
	if err := json.Unmarshal([]byte(resultStr), &response); err != nil {
		log.Fatalf("Failed to parse response: %v", err)
	}
	
	if code, ok := response["code"].(float64); !ok || code != 200 {
		log.Printf("❌ Expected code 200, got %v", response["code"])
	} else {
		log.Printf("✓ Code: %.0f", code)
	}
	
	if data, ok := response["data"].(map[string]interface{}); ok {
		if clientID, exists := data["client_id"].(string); exists {
			log.Printf("✓ Generated client_id: %s", clientID)
			
			// 检查 clientID 平台前缀
			if len(clientID) > 0 {
				firstChar := clientID[0]
				if (firstChar >= '1' && firstChar <= '5') || firstChar == '9' {
					log.Printf("✓ Client ID has valid platform prefix: %c", firstChar)
				} else {
					log.Printf("❌ Client ID has invalid platform prefix: %c", firstChar)
				}
			}
		}
	}
}

func testIsProxyWorkerRunning() {
	fmt.Println("\n=== Testing IsProxyWorkerRunning ===")
	result := IsProxyWorkerRunning()
	resultStr := C.GoString(result)
	
	fmt.Printf("Result: %s\n", resultStr)
	
	var response map[string]interface{}
	if err := json.Unmarshal([]byte(resultStr), &response); err != nil {
		log.Fatalf("Failed to parse response: %v", err)
	}
	
	if code, ok := response["code"].(float64); !ok || code != 200 {
		log.Printf("❌ Expected code 200, got %v", response["code"])
	} else {
		log.Printf("✓ Code: %.0f", code)
	}
	
	if data, ok := response["data"].(map[string]interface{}); ok {
		if isRunning, exists := data["is_running"].(bool); exists {
			log.Printf("✓ Proxy worker is_running: %v", isRunning)
		}
	}
}

func testGetProxyWorkerStatus() {
	fmt.Println("\n=== Testing GetProxyWorkerStatus ===")
	result := GetProxyWorkerStatus()
	resultStr := C.GoString(result)
	
	fmt.Printf("Result: %s\n", resultStr)
	
	var response map[string]interface{}
	if err := json.Unmarshal([]byte(resultStr), &response); err != nil {
		log.Fatalf("Failed to parse response: %v", err)
	}
	
	if code, ok := response["code"].(float64); !ok || code != 200 {
		log.Printf("❌ Expected code 200, got %v", response["code"])
	} else {
		log.Printf("✓ Code: %.0f", code)
	}
}

func testNodeSignUp() {
	fmt.Println("\n=== Testing NodeSignUp ===")
	result := NodeSignUp()
	resultStr := C.GoString(result)
	
	fmt.Printf("Result: %s\n", resultStr)
	
	var response map[string]interface{}
	if err := json.Unmarshal([]byte(resultStr), &response); err != nil {
		log.Fatalf("Failed to parse response: %v", err)
	}
	
	if code, ok := response["code"]; ok {
		log.Printf("✓ Code: %v", code)
	}
	if msg, ok := response["message"]; ok {
		log.Printf("✓ Message: %v", msg)
	}
}

func testCleanup() {
	fmt.Println("\n=== Testing Cleanup ===")
	result := Cleanup()
	resultStr := C.GoString(result)
	
	fmt.Printf("Result: %s\n", resultStr)
	
	var response map[string]interface{}
	if err := json.Unmarshal([]byte(resultStr), &response); err != nil {
		log.Fatalf("Failed to parse response: %v", err)
	}
	
	if code, ok := response["code"].(float64); !ok || code != 200 {
		log.Printf("❌ Expected code 200, got %v", response["code"])
	} else {
		log.Printf("✓ Code: %.0f", code)
	}
}

func main() {
	fmt.Println("========================================")
	fmt.Println("Testing Exported Functions")
	fmt.Println("========================================")
	
	testGetCurrentVersion()
	testInitLibstudy()
	testIsProxyWorkerRunning()
	testGetProxyWorkerStatus()
	testNodeSignUp()
	testCleanup()
	
	fmt.Println("\n========================================")
	fmt.Println("All tests completed!")
	fmt.Println("========================================")
}
