package proxy

// ProxyManager IP 代理管理器（预留接口）
type ProxyManager struct {
	// TODO: 实现 IP 代理转发功能
}

// NewProxyManager 创建代理管理器
func NewProxyManager() *ProxyManager {
	return &ProxyManager{}
}

// Start 启动代理
func (p *ProxyManager) Start() error {
	// TODO: 实现代理启动逻辑
	return nil
}

// Stop 停止代理
func (p *ProxyManager) Stop() error {
	// TODO: 实现代理停止逻辑
	return nil
}
