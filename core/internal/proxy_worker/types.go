package proxy_worker

// ProxyWorkerConfig 代理工作节点配置
type ProxyWorkerConfig struct {
	SN              string `json:"sn"`
	Token           string `json:"token"`
	TunnelID        string `json:"tunnel_id"`
	ProxyServerIP   string `json:"proxy_server_ip"`
	ProxyServerPort int    `json:"proxy_server_port"`
	LocalPort       int    `json:"local_port"`
	NatType         int    `json:"nat_type"`
	FixedPort       int    `json:"fixed_port"`
	// TLS 相关配置
	DisableTLS bool   `json:"disable_tls"` // 是否禁用 TLS，默认 false（即默认使用 wss）
	TLSSecure  bool   `json:"tls_secure"`  // 是否验证服务器证书，默认 false（跳过验证）
	ServerName string `json:"server_name"` // TLS ServerName，用于证书验证，为空时使用 ProxyServerIP
}

// WorkerStatus 工作节点状态
type WorkerStatus struct {
	IsRunning bool   `json:"is_running"`
	PID       int    `json:"pid"`
	LocalPort int    `json:"local_port"`
	FixedPort int    `json:"fixed_port"`
	TunnelID  string `json:"tunnel_id"`
	StartTime int64  `json:"start_time"`
	Error     string `json:"error,omitempty"`
}
