package config

import (
	"os"
	"testing"
)

func TestGetConfig(t *testing.T) {
	cfg := GetConfig()
	if cfg == nil {
		t.Fatal("GetConfig returned nil")
	}
}

func TestConfigSingleton(t *testing.T) {
	cfg1 := GetConfig()
	cfg2 := GetConfig()

	if cfg1 != cfg2 {
		t.Fatal("GetConfig should return the same instance (singleton)")
	}
}

func TestGetConfigValue(t *testing.T) {
	cfg := GetConfig()

	tests := []struct {
		key          string
		expectedType string
	}{
		{KeyAPIURL, "string"},
		{KeyWSURL, "string"},
		{KeyLogLevel, "string"},
		{KeyTimeout, "int"},
	}

	for _, tt := range tests {
		value := cfg.Get(tt.key)
		if value == "" && tt.expectedType != "empty" {
			t.Errorf("Get(%s) returned empty string", tt.key)
		}
	}
}

func TestSetConfigValue(t *testing.T) {
	cfg := GetConfig()
	testKey := "TEST_KEY"
	testValue := "test_value"

	cfg.Set(testKey, testValue)
	retrieved := cfg.Get(testKey)

	if retrieved != testValue {
		t.Errorf("Expected %s, got %s", testValue, retrieved)
	}
}

func TestGetInt(t *testing.T) {
	cfg := GetConfig()

	timeout := cfg.GetInt(KeyTimeout)
	if timeout <= 0 {
		t.Errorf("Expected positive timeout, got %d", timeout)
	}
}

func TestGetBool(t *testing.T) {
	cfg := GetConfig()

	// 测试 DEBUG 配置
	cfg.Set("TEST_BOOL_TRUE", "true")
	if !cfg.GetBool("TEST_BOOL_TRUE") {
		t.Error("GetBool should return true for 'true'")
	}

	cfg.Set("TEST_BOOL_FALSE", "false")
	if cfg.GetBool("TEST_BOOL_FALSE") {
		t.Error("GetBool should return false for 'false'")
	}
}

func TestGetAll(t *testing.T) {
	cfg := GetConfig()
	all := cfg.GetAll()

	if len(all) == 0 {
		t.Fatal("GetAll should not return empty map")
	}

	if _, ok := all[KeyAPIURL]; !ok {
		t.Error("GetAll should contain API_URL")
	}
}

func TestEnvironmentVariableOverride(t *testing.T) {
	testKey := "TEST_ENV_VAR"
	testValue := "env_value"

	os.Setenv(testKey, testValue)
	defer os.Unsetenv(testKey)

	// 注意：由于使用单例模式，这个测试可能需要改进
	// 实际环境变量加载发生在初始化时
	t.Log("Environment variable override test requires config reload")
}

func TestConfigConstants(t *testing.T) {
	tests := []struct {
		constant string
		expected string
	}{
		{KeyAPIURL, "API_URL"},
		{KeyWSURL, "WS_URL"},
		{KeyLogLevel, "LOG_LEVEL"},
		{KeyTimeout, "TIMEOUT"},
		{KeyRetryCount, "RETRY_COUNT"},
		{KeyRetryInterval, "RETRY_INTERVAL"},
		{KeyKeypairPath, "KEYPAIR_PATH"},
		{KeyStoragePath, "STORAGE_PATH"},
		{KeyEnv, "ENV"},
		{KeyProgramApp, "PROGRAM_APP"},
		{KeyDebug, "DEBUG"},
	}

	for _, tt := range tests {
		if tt.constant != tt.expected {
			t.Errorf("Constant mismatch: got %s, expected %s", tt.constant, tt.expected)
		}
	}
}

func TestDefaultValues(t *testing.T) {
	cfg := GetConfig()

	// 验证重要的默认值
	if cfg.Get(KeyAPIURL) != "https://testnet-api.aro.network" {
		t.Error("API_URL default value mismatch")
	}

	if cfg.Get(KeyWSURL) != "https://testnet-ws.aro.network" {
		t.Error("WS_URL default value mismatch")
	}

	if cfg.GetInt(KeyTimeout) != 30 {
		t.Error("TIMEOUT default value should be 30")
	}

	if cfg.GetInt(KeyRetryCount) != 3 {
		t.Error("RETRY_COUNT default value should be 3")
	}
}
