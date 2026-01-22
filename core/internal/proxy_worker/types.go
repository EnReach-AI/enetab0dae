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
