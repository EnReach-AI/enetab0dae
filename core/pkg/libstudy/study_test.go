package main

/*
#include <stdlib.h>
#include <string.h>
*/
import "C"

import (
	"encoding/json"
	"testing"
)

// Helper function to convert C string to Go string
func cStringToGoTest(s *C.char) string {
	if s == nil {
		return ""
	}
	return C.GoString(s)
}

// Helper to create C string from Go string  
func toCStringTest(s string) *C.char {
	if s == "" {
		return nil
	}
	return C.CString(s)
}

// Test InitLibstudy
func TestInitLibstudy(t *testing.T) {
	config := `{
		"config": {
			"BaseAPIURL": "https://staging-api.aro.network",
			"BaseWSURL": "wss://staging-ws.aro.network"
		}
	}`
	
	configPtr := toCStringTest(config)
	
	result := InitLibstudy(configPtr)
	resultStr := cStringToGoTest(result)
	
	t.Logf("InitLibstudy result: %s", resultStr)
	
	var response map[string]interface{}
	if err := json.Unmarshal([]byte(resultStr), &response); err != nil {
		t.Fatalf("Failed to parse response: %v", err)
	}
	
	if code, ok := response["code"].(float64); !ok || code != 200 {
		t.Errorf("Expected code 200, got %v", response["code"])
	}
	
	if data, ok := response["data"].(map[string]interface{}); ok {
		if clientID, exists := data["client_id"].(string); exists {
			t.Logf("Generated client_id: %s", clientID)
			
			// 检查 clientID 是否以平台代码开头（1-5, 9）
			if len(clientID) > 0 {
				firstChar := clientID[0]
				if firstChar >= '1' && firstChar <= '5' || firstChar == '9' {
					t.Logf("Client ID has valid platform prefix: %c", firstChar)
				} else {
					t.Errorf("Client ID has invalid platform prefix: %c", firstChar)
				}
			}
		} else {
			t.Error("client_id not found in response data")
		}
	} else {
		t.Error("data not found in response")
	}
}

// Test GetCurrentVersion
func TestGetCurrentVersion(t *testing.T) {
	result := GetCurrentVersion()
	resultStr := cStringToGoTest(result)
	
	t.Logf("GetCurrentVersion result: %s", resultStr)
	
	var response map[string]interface{}
	if err := json.Unmarshal([]byte(resultStr), &response); err != nil {
		t.Fatalf("Failed to parse response: %v", err)
	}
	
	if code, ok := response["code"].(float64); !ok || code != 200 {
		t.Errorf("Expected code 200, got %v", response["code"])
	}
	
	if data, ok := response["data"].(string); ok {
		t.Logf("Version: %s", data)
		if data == "" {
			t.Error("Version should not be empty")
		}
	}
}

// Test NodeSignUp (requires InitLibstudy first)
func TestNodeSignUp(t *testing.T) {
	// First initialize
	config := `{
		"config": {
			"BaseAPIURL": "https://staging-api.aro.network",
			"BaseWSURL": "wss://staging-ws.aro.network"
		}
	}`
	configPtr := toCStringTest(config)
	InitLibstudy(configPtr)
	
	// Now test NodeSignUp
	result := NodeSignUp()
	resultStr := cStringToGoTest(result)
	
	t.Logf("NodeSignUp result: %s", resultStr)
	
	var response map[string]interface{}
	if err := json.Unmarshal([]byte(resultStr), &response); err != nil {
		t.Fatalf("Failed to parse response: %v", err)
	}
	
	// Check if we have a valid response structure
	if _, ok := response["code"]; !ok {
		t.Error("Response missing 'code' field")
	}
	if _, ok := response["message"]; !ok {
		t.Error("Response missing 'message' field")
	}
}

// Test GetNodeStat (requires InitLibstudy first)
func TestGetNodeStat(t *testing.T) {
	// First initialize
	config := `{
		"config": {
			"BaseAPIURL": "https://staging-api.aro.network",
			"BaseWSURL": "wss://staging-ws.aro.network"
		}
	}`
	configPtr := toCStringTest(config)
	InitLibstudy(configPtr)
	
	// Now test GetNodeStat
	result := GetNodeStat()
	resultStr := cStringToGoTest(result)
	
	t.Logf("GetNodeStat result: %s", resultStr)
	
	var response map[string]interface{}
	if err := json.Unmarshal([]byte(resultStr), &response); err != nil {
		t.Fatalf("Failed to parse response: %v", err)
	}
	
	if _, ok := response["code"]; !ok {
		t.Error("Response missing 'code' field")
	}
}

// Test IsProxyWorkerRunning
func TestIsProxyWorkerRunning(t *testing.T) {
	result := IsProxyWorkerRunning()
	resultStr := cStringToGoTest(result)
	
	t.Logf("IsProxyWorkerRunning result: %s", resultStr)
	
	var response map[string]interface{}
	if err := json.Unmarshal([]byte(resultStr), &response); err != nil {
		t.Fatalf("Failed to parse response: %v", err)
	}
	
	if code, ok := response["code"].(float64); !ok || code != 200 {
		t.Errorf("Expected code 200, got %v", response["code"])
	}
	
	if data, ok := response["data"].(map[string]interface{}); ok {
		if isRunning, exists := data["is_running"].(bool); exists {
			t.Logf("Proxy worker is_running: %v", isRunning)
		}
	}
}

// Test GetProxyWorkerStatus
func TestGetProxyWorkerStatus(t *testing.T) {
	result := GetProxyWorkerStatus()
	resultStr := cStringToGoTest(result)
	
	t.Logf("GetProxyWorkerStatus result: %s", resultStr)
	
	var response map[string]interface{}
	if err := json.Unmarshal([]byte(resultStr), &response); err != nil {
		t.Fatalf("Failed to parse response: %v", err)
	}
	
	if code, ok := response["code"].(float64); !ok || code != 200 {
		t.Errorf("Expected code 200, got %v", response["code"])
	}
}

// Test Cleanup
func TestCleanup(t *testing.T) {
	result := Cleanup()
	resultStr := cStringToGoTest(result)
	
	t.Logf("Cleanup result: %s", resultStr)
	
	var response map[string]interface{}
	if err := json.Unmarshal([]byte(resultStr), &response); err != nil {
		t.Fatalf("Failed to parse response: %v", err)
	}
	
	if code, ok := response["code"].(float64); !ok || code != 200 {
		t.Errorf("Expected code 200, got %v", response["code"])
	}
}

// Test response format consistency
func TestResponseFormatConsistency(t *testing.T) {
	functions := []struct {
		name string
		fn   func() *C.char
	}{
		{"GetCurrentVersion", GetCurrentVersion},
		{"IsProxyWorkerRunning", IsProxyWorkerRunning},
		{"GetProxyWorkerStatus", GetProxyWorkerStatus},
	}
	
	for _, test := range functions {
		t.Run(test.name, func(t *testing.T) {
			result := test.fn()
			resultStr := cStringToGoTest(result)
			
			var response map[string]interface{}
			if err := json.Unmarshal([]byte(resultStr), &response); err != nil {
				t.Fatalf("%s: Failed to parse response: %v", test.name, err)
			}
			
			// Check required fields
			if _, ok := response["code"]; !ok {
				t.Errorf("%s: Response missing 'code' field", test.name)
			}
			if _, ok := response["message"]; !ok {
				t.Errorf("%s: Response missing 'message' field", test.name)
			}
			if _, ok := response["data"]; !ok {
				t.Errorf("%s: Response missing 'data' field", test.name)
			}
		})
	}
}
