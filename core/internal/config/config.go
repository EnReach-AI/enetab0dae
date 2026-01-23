package config

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"path/filepath"
	"strings"
	"sync"
)

// Config 配置管理
type Config struct {
	mu   sync.RWMutex
	data map[string]string
	path string
}

// 全局配置单例
var (
	instance *Config
	once     sync.Once
)

// GetConfig 获取全局 Config 单例实例
// 使用 sync.Once 确保只初始化一次，线程安全
func GetConfig() *Config {
	once.Do(func() {
		instance = &Config{
			data: make(map[string]string),
		}
		instance.loadDefaults()
		instance.loadFromFile()
		instance.loadFromEnv()
	})
	return instance
}

// loadDefaults 加载默认配置
func (c *Config) loadDefaults() {
	defaults := map[string]string{
		"API_URL":        "https://testnet-api.aro.network",
		"WS_URL":         "https://testnet-ws.aro.network",
		"LOG_LEVEL":      "info",
		"LOG_FILE":       "",
		"KEYPAIR_PATH":   ".",
		"STORAGE_PATH":   ".",
		"TIMEOUT":        "30",
		"RETRY_COUNT":    "3",
		"RETRY_INTERVAL": "1000",
		"DEBUG":          "false",
		"ENV":            "testnet",
		"PROGRAM_APP":    "aro-ext",
	}

	for key, value := range defaults {
		c.data[key] = value
	}
}

// loadFromFile 从配置文件加载配置
func (c *Config) loadFromFile() {
	configPaths := []string{
		".env",
		"config.env",
		filepath.Join(os.Getenv("HOME"), ".aro", "config.env"),
	}

	// Windows 特定路径
	if os.Getenv("OS") == "Windows_NT" {
		configPaths = append(configPaths,
			filepath.Join(os.Getenv("APPDATA"), "ARO", "config.env"),
		)
	}

	// macOS 特定路径
	if os.Getenv("HOME") != "" {
		configPaths = append(configPaths,
			filepath.Join(os.Getenv("HOME"), "Library", "Application Support", "ARO", "config.env"),
		)
	}

	for _, path := range configPaths {
		if err := c.loadFromPath(path); err == nil {
			c.path = path
			log.Printf("Config loaded from: %s", path)
			return
		}
	}
}

// loadFromPath 从指定路径加载配置文件
func (c *Config) loadFromPath(path string) error {
	file, err := os.Open(path)
	if err != nil {
		return err
	}
	defer file.Close()

	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		line := strings.TrimSpace(scanner.Text())

		// 忽略空行和注释
		if line == "" || strings.HasPrefix(line, "#") {
			continue
		}

		// 解析 key=value
		parts := strings.SplitN(line, "=", 2)
		if len(parts) == 2 {
			key := strings.TrimSpace(parts[0])
			value := strings.TrimSpace(parts[1])
			// 移除引号
			value = strings.Trim(value, "\"'")
			c.data[key] = value
		}
	}

	return scanner.Err()
}

// loadFromEnv 从环境变量加载配置（覆盖文件配置）
func (c *Config) loadFromEnv() {
	envVars := []string{
		"API_URL",
		"WS_URL",
		"LOG_LEVEL",
		"LOG_FILE",
		"KEYPAIR_PATH",
		"STORAGE_PATH",
		"TIMEOUT",
		"RETRY_COUNT",
		"RETRY_INTERVAL",
		"DEBUG",
		"ENV",
		"PROGRAM_APP",
	}

	for _, key := range envVars {
		if value := os.Getenv(key); value != "" {
			c.data[key] = value
		}
	}
}

// Get 获取配置值
func (c *Config) Get(key string) string {
	c.mu.RLock()
	defer c.mu.RUnlock()
	return c.data[key]
}

// Set 设置配置值（仅在内存中，不写入文件）
func (c *Config) Set(key, value string) {
	c.mu.Lock()
	defer c.mu.Unlock()
	c.data[key] = value
}

// SetAndSave 设置配置值并写入文件
func (c *Config) SetAndSave(key, value string) error {
	c.Set(key, value)



	// 确定配置文件路径
	configPath := c.path
	if configPath == "" {
		configPath = ".env"
	}

	
	// 确保目录存在
	dir := filepath.Dir(configPath)
	if err := os.MkdirAll(dir, 0755); err != nil {
		return fmt.Errorf("failed to create config directory: %w", err)
	}

	// 读取现有配置文件
	lines := []string{}
	if file, err := os.Open(configPath); err == nil {
		scanner := bufio.NewScanner(file)
		for scanner.Scan() {
			line := scanner.Text()
			// 跳过要更新的 key 的行
			if !strings.HasPrefix(strings.TrimSpace(line), key+"=") {
				lines = append(lines, line)
			}
		}
		file.Close()
	}

	// 添加新行
	lines = append(lines, fmt.Sprintf("%s=%s", key, value))

	// 写入文件
	content := strings.Join(lines, "\n")
	if err := os.WriteFile(configPath, []byte(content+"\n"), 0644); err != nil {
		return fmt.Errorf("failed to write config file: %w", err)
	}

	c.path = configPath
	return nil
}

// GetAll 获取所有配置
func (c *Config) GetAll() map[string]string {
	c.mu.RLock()
	defer c.mu.RUnlock()

	result := make(map[string]string)
	for k, v := range c.data {
		result[k] = v
	}
	return result
}

// GetInt 获取整数配置值
func (c *Config) GetInt(key string) int {
	val := c.Get(key)
	var result int
	fmt.Sscanf(val, "%d", &result)
	return result
}

// GetBool 获取布尔配置值
func (c *Config) GetBool(key string) bool {
	val := strings.ToLower(c.Get(key))
	return val == "true" || val == "1" || val == "yes"
}

// Reset 重置配置为默认值
func (c *Config) Reset() {
	c.mu.Lock()
	defer c.mu.Unlock()
	c.data = make(map[string]string)
	instance.loadDefaults()
}

// Reload 重新加载配置（从文件和环境变量）
func (c *Config) Reload() {
	c.Reset()
	c.loadFromFile()
	c.loadFromEnv()
}
