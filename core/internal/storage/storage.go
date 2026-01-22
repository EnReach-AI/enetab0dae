package storage

import (
	"encoding/json"
	"sync"
)

// UserInfo 用户信息
type BindInfo struct {
	SerialNumber string    `json:"serialNumber"`
	Bind         bool      `json:"bind"`
	BindUser     *BindUser `json:"bindUser"`
}

// BindUser 绑定用户信息
type BindUser struct {
	UUID  string `json:"uuid"`
	Email string `json:"email"`
}

// NodeInfo 节点信息
type NodeInfo struct {
	NodeID     string `json:"nodeId"`
	PrivateKey string `json:"privateKey"`
	PublicKey  string `json:"publicKey"`
}

// ConnectStatus 连接状态
type ConnectStatus string

const (
	StatusIdle       ConnectStatus = "idle"
	StatusConnecting ConnectStatus = "connecting"
	StatusConnected  ConnectStatus = "connected"
	StatusForbidden  ConnectStatus = "forbidden"
)

// Storage 本地存储管理
type Storage struct {
	mu   sync.RWMutex
	data map[string]interface{}
}

// 全局单例变量和初始化锁
var (
	instance *Storage
	once     sync.Once
)

// GetStorage 获取全局 Storage 单例实例
// 使用 sync.Once 确保只初始化一次，线程安全
func GetStorage() *Storage {
	once.Do(func() {
		instance = &Storage{
			data: make(map[string]interface{}),
		}
	})
	return instance
}

// Set 设置值
func (s *Storage) Set(key string, value interface{}) {
	s.mu.Lock()
	defer s.mu.Unlock()
	s.data[key] = value
}

// Get 获取值
func (s *Storage) Get(key string) (interface{}, bool) {
	s.mu.RLock()
	defer s.mu.RUnlock()
	val, exists := s.data[key]
	return val, exists
}

// GetString 获取字符串
func (s *Storage) GetString(key string) string {
	val, exists := s.Get(key)
	if !exists {
		return ""
	}
	if str, ok := val.(string); ok {
		return str
	}
	return ""
}

// GetUserInfo 获取用户信息
func (s *Storage) GetUserInfo() *BindInfo {
	val, exists := s.Get("userInfo")
	if !exists {
		return nil
	}
	if data, ok := val.(string); ok {
		var userInfo BindInfo
		json.Unmarshal([]byte(data), &userInfo)
		return &userInfo
	}
	return nil
}

// SetUserInfo 设置用户信息
func (s *Storage) SetUserInfo(userInfo *BindInfo) {
	data, _ := json.Marshal(userInfo)
	s.Set("userInfo", string(data))
}

// GetNodeInfo 获取节点信息
func (s *Storage) GetNodeInfo() *NodeInfo {
	val, exists := s.Get("nodeInfo")
	if !exists {
		return nil
	}
	if data, ok := val.(string); ok {
		var nodeInfo NodeInfo
		json.Unmarshal([]byte(data), &nodeInfo)
		return &nodeInfo
	}
	return nil
}

// SetNodeInfo 设置节点信息
func (s *Storage) SetNodeInfo(nodeInfo *NodeInfo) {
	data, _ := json.Marshal(nodeInfo)
	s.Set("nodeInfo", string(data))
}

// SetConnectStatus 设置连接状态
func (s *Storage) SetConnectStatus(status ConnectStatus) {
	s.Set("connectStatus", string(status))
}

// GetConnectStatus 获取连接状态
func (s *Storage) GetConnectStatus() ConnectStatus {
	status := s.GetString("connectStatus")
	return ConnectStatus(status)
}

// Clear 清空存储
func (s *Storage) Clear() {
	s.mu.Lock()
	defer s.mu.Unlock()
	s.data = make(map[string]interface{})
}
