package proxy_worker

import (
	"context"
	"fmt"
	"log"
	"os"
	"sync"
	"time"

	"github.com/go-gost/core/logger"
	"github.com/go-gost/x/config"
	"github.com/go-gost/x/config/cmd"
	gost_loader "github.com/go-gost/x/config/loader"
	xlogger "github.com/go-gost/x/logger"
	"github.com/go-gost/x/registry"
)

// Manager 代理工作节点管理器（内嵌 GOST）
type Manager struct {
	mu        sync.RWMutex
	config    *ProxyWorkerConfig
	services  []interface{ Serve() error }
	ctx       context.Context
	cancel    context.CancelFunc
	startTime int64
	isRunning bool
	errChan   chan error
}

var (
	globalManager     *Manager
	globalManagerOnce sync.Once
)

// GetManager 获取全局管理器实例
func GetManager() *Manager {
	globalManagerOnce.Do(func() {
		ctx, cancel := context.WithCancel(context.Background())
		globalManager = &Manager{
			ctx:    ctx,
			cancel: cancel,
		}
	})
	return globalManager
}

// Start 启动代理工作节点（内嵌模式）
func (m *Manager) Start(config ProxyWorkerConfig) error {
	m.mu.Lock()
	defer m.mu.Unlock()

	if m.isRunning {
		return fmt.Errorf("proxy worker is already running")
	}

	if err := m.validateConfig(&config); err != nil {
		return fmt.Errorf("invalid configuration: %w", err)
	}

	// 构建 GOST 配置
	cfg, err := m.buildGostConfig(&config)
	if err != nil {
		return fmt.Errorf("failed to build gost config: %w", err)
	}

	// 创建 logger (设置为Debug级别以输出调试信息)
	lg := xlogger.NewLogger(
		xlogger.LevelOption(logger.DebugLevel),
	)
	logger.SetDefault(lg)

	// ⚠️ 关键：使用 gost_loader.Load 来注册 chains, hops, services 到 registry
	// 这是 aro-proxy-worker 的正确启动方式
	if err := gost_loader.Load(cfg); err != nil {
		return fmt.Errorf("failed to load config: %w", err)
	}

	// 从 registry 获取所有已注册的服务并启动
	services, err := m.startGostServices(lg)
	if err != nil {
		return fmt.Errorf("failed to start gost services: %w", err)
	}

	m.config = &config
	m.services = services
	m.isRunning = true
	m.startTime = time.Now().Unix()
	m.errChan = make(chan error, 1)

	log.Println("Proxy worker started in embedded mode")
	return nil
}

// Stop 停止代理工作节点
func (m *Manager) Stop() error {
	m.mu.Lock()
	defer m.mu.Unlock()

	if !m.isRunning {
		return fmt.Errorf("proxy worker is not running")
	}

	log.Println("Stopping proxy worker services...")

	// 关闭我们创建的服务
	for i, svc := range m.services {
		if closable, ok := svc.(interface{ Close() error }); ok {
			if err := closable.Close(); err != nil {
				log.Printf("Warning: failed to close service %d: %v", i, err)
			} else {
				log.Printf("Service %d closed successfully", i)
			}
		}
	}

	// 清空服务列表
	m.services = nil

	// 取消上下文，停止所有 goroutines
	m.cancel()

	// 重新创建 context
	m.ctx, m.cancel = context.WithCancel(context.Background())

	// 等待端口完全释放
	time.Sleep(1 * time.Second)

	m.isRunning = false
	m.config = nil

	log.Println("Proxy worker stopped")
	return nil
}

// GetStatus 获取工作节点状态
func (m *Manager) GetStatus() WorkerStatus {
	m.mu.RLock()
	defer m.mu.RUnlock()

	status := WorkerStatus{
		IsRunning: m.isRunning,
		PID:       os.Getpid(),
		StartTime: m.startTime,
	}

	if m.config != nil {
		status.LocalPort = m.config.LocalPort
		status.FixedPort = m.config.FixedPort
		status.TunnelID = m.config.TunnelID
	}

	return status
}

// IsRunning 检查工作节点是否正在运行
func (m *Manager) IsRunning() bool {
	m.mu.RLock()
	defer m.mu.RUnlock()

	return m.isRunning
}

// Restart 重启代理工作节点
func (m *Manager) Restart() error {
	m.mu.RLock()
	config := m.config
	m.mu.RUnlock()

	if config == nil {
		return fmt.Errorf("no configuration available for restart")
	}

	if err := m.Stop(); err != nil {
		log.Printf("Warning: failed to stop worker during restart: %v", err)
	}

	time.Sleep(time.Second)

	return m.Start(*config)
}

func (m *Manager) validateConfig(config *ProxyWorkerConfig) error {
	if config.SN == "" {
		return fmt.Errorf("SN is required")
	}
	if config.Token == "" {
		return fmt.Errorf("Token is required")
	}
	if config.TunnelID == "" {
		return fmt.Errorf("TunnelID is required")
	}
	if config.ProxyServerIP == "" {
		return fmt.Errorf("ProxyServerIP is required")
	}
	if config.ProxyServerPort <= 0 {
		return fmt.Errorf("invalid ProxyServerPort: %d", config.ProxyServerPort)
	}
	if config.LocalPort <= 0 {
		return fmt.Errorf("invalid LocalPort: %d", config.LocalPort)
	}
	if config.NatType == 1 && config.FixedPort <= 0 {
		return fmt.Errorf("FixedPort is required for static IP")
	}
	return nil
}

// buildGostConfig 构建 GOST 配置
func (m *Manager) buildGostConfig(config *ProxyWorkerConfig) (*config.Config, error) {
	var serviceStrs []string
	var nodeStrs []string

	// 根据 NAT 类型构建服务列表
	if config.NatType == 1 {
		// 静态 IP 模式：需要在固定端口监听
		serviceStrs = []string{
			fmt.Sprintf("auto://:%d", config.FixedPort),
			fmt.Sprintf("auto://127.0.0.1:%d", config.LocalPort),
			// rtcp 监听在随机端口，转发到本地代理服务
			fmt.Sprintf("rtcp://:0/127.0.0.1:%d", config.LocalPort),
		}
	} else {
		// 动态 IP 模式：
		// 1. auto service 监听在本地端口，提供代理服务
		// 2. rtcp service 监听在随机端口，用于与 proxy-server 建立反向隧道
		//    转发目标是本地的代理服务端口
		serviceStrs = []string{
			fmt.Sprintf("auto://127.0.0.1:%d", config.LocalPort),
			fmt.Sprintf("rtcp://:0/127.0.0.1:%d", config.LocalPort),
		}
	}

	// 构建转发节点（chain node）
	nodeStrs = []string{
		fmt.Sprintf("tunnel+ws://%s:%s@%s:%d?tunnel.id=%s",
			config.SN, config.Token, config.ProxyServerIP, config.ProxyServerPort, config.TunnelID),
	}

	// 使用 cmd.BuildConfigFromCmd 从命令行字符串构建配置
	cfg, err := cmd.BuildConfigFromCmd(serviceStrs, nodeStrs)
	if err != nil {
		return nil, fmt.Errorf("failed to build config from cmd: %w", err)
	}

	// ⚠️ 关键修复：正确设置 chain
	// 架构说明（基于成功测试的两个独立进程模式）：
	// - 进程1: auto://:24443 (无 -F) → auto handler 直接连接互联网，不需要 chain
	// - 进程2: rtcp://:0/:24443 -F tunnel+ws://... → rtcp listener 通过 tunnel 建立反向隧道
	//
	// 合并到一个进程时：
	// - auto handler: 不需要 chain（直接连接互联网）
	// - rtcp handler: 不需要 chain（直接转发到本地 auto 服务）
	// - rtcp listener: 需要 chain（用于建立反向隧道）
	//
	// BuildConfigFromCmd 会错误地给 auto handler 设置 chain，需要清除
	for _, svc := range cfg.Services {
		if svc.Handler != nil {
			// auto handler 不应该有 chain，它直接连接互联网
			if svc.Handler.Type == "auto" && svc.Handler.Chain != "" {
				log.Printf("DEBUG: Clearing handler.chain for auto service %s (was %s) - auto should connect directly", svc.Name, svc.Handler.Chain)
				svc.Handler.Chain = ""
			}
			// rtcp handler 不应该有 chain，它直接转发到本地
			if svc.Handler.Type == "rtcp" && svc.Handler.Chain != "" {
				log.Printf("DEBUG: Clearing handler.chain for rtcp service %s (was %s)", svc.Name, svc.Handler.Chain)
				svc.Handler.Chain = ""
			}
		}
	}

	// 调试：打印生成的配置（修复后）
	log.Printf("DEBUG: serviceStrs = %v", serviceStrs)
	log.Printf("DEBUG: nodeStrs = %v", nodeStrs)
	log.Printf("DEBUG: Generated config has %d services, %d chains", len(cfg.Services), len(cfg.Chains))
	for i, svc := range cfg.Services {
		log.Printf("DEBUG: Service[%d]: name=%s, handler.type=%s, listener.type=%s, listener.chain=%s, handler.chain=%s",
			i, svc.Name, svc.Handler.Type, svc.Listener.Type, svc.Listener.Chain, svc.Handler.Chain)
	}
	for i, chain := range cfg.Chains {
		log.Printf("DEBUG: Chain[%d]: name=%s, hops=%d", i, chain.Name, len(chain.Hops))
		for j, hop := range chain.Hops {
			log.Printf("DEBUG:   Hop[%d]: name=%s, nodes=%d", j, hop.Name, len(hop.Nodes))
			for k, node := range hop.Nodes {
				log.Printf("DEBUG:     Node[%d]: name=%s, addr=%s, connector.type=%s, dialer.type=%s",
					k, node.Name, node.Addr, node.Connector.Type, node.Dialer.Type)
			}
		}
	}

	return cfg, nil
}

// startGostServices 启动 GOST 服务（从 registry 获取）
func (m *Manager) startGostServices(lg logger.Logger) ([]interface{ Serve() error }, error) {
	services := make([]interface{ Serve() error }, 0)

	// 从 registry 获取所有已注册的服务
	for _, svc := range registry.ServiceRegistry().GetAll() {
		svc := svc // 捕获循环变量
		services = append(services, svc)

		// 在单独的 goroutine 中启动服务
		go func() {
			if err := svc.Serve(); err != nil {
				log.Printf("Service error: %v", err)
				select {
				case m.errChan <- err:
				default:
				}
			}
		}()
	}

	log.Printf("Started %d services from registry", len(services))
	return services, nil
}
