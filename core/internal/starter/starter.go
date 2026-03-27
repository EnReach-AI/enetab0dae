package starter

import (
	"context"
	"log"
	"time"

	internalService "aro-ext-app/core/internal/agent_service"
	"aro-ext-app/core/internal/api_client"
	"aro-ext-app/core/internal/config"
	"aro-ext-app/core/internal/constant"
	logconfig "aro-ext-app/core/internal/log_config"

	agentConstant "github.com/aro-network/aro-edge-agent/agent/constant"
	"github.com/aro-network/aro-edge-agent/agent/database/model"
	agentConfig "github.com/aro-network/aro-edge-agent/agent/pkg/config"
	"github.com/aro-network/aro-edge-agent/agent/pkg/job"
	"github.com/aro-network/aro-edge-agent/agent/pkg/proxy"
	"github.com/aro-network/aro-edge-agent/agent/pkg/service"
)

var cfg = config.GetConfig()

// var AppBackendService *api_client.APIClient

const (
	pollInterval      = 30 * time.Second
	errorRetryDelay   = 30 * time.Second
	bindCheckInterval = 30 * time.Second
	maxBindCheckError = 5
)

func RunBackendThread() {

	agentConstant.Init2(cfg.Get(config.KeyAgentPath), constant.VERSION)
	go agentConfig.Init()
	go logconfig.ClearLogAndLastVersion()

	// agentservice.DetectEnvironment()
	for {
		// Get device information
		deviceInfo, err := internalService.GetDeviceInfo()
		log.Printf("deviceInfo: %+v", deviceInfo)
		log.Printf("agentConstant.deviceInfo: %+v", agentConstant.DEVICE_INFO)
		if err != nil {
			log.Printf("Failed to get device info: %v, retrying in %v", err, errorRetryDelay)
			time.Sleep(errorRetryDelay)
			continue
		}
		// Check bind status
		backendService := service.NewBackendService(deviceInfo)
		apiBackendService := api_client.NewBackendService(deviceInfo)
		bindResult, err := apiBackendService.GetNodeBindStatus()

		if err != nil {
			log.Printf("Failed to get bind status: %v, retrying in %v", err, errorRetryDelay)
			time.Sleep(errorRetryDelay)
			continue
		}

		log.Printf("Bind result:%+v", bindResult)

		// AppBackendService = api_client.NewAPIClient(cfg.Get(config.KeyAPIURL), cfg.Get(config.KeyClientId), cfg.Get(config.KeySN), bindResult.UUID)

		// 检查设备是否已绑定
		if !bindResult.Binded {
			log.Println("Device not bound, waiting for binding...")
			time.Sleep(pollInterval)
			continue
		}

		// Device is bound, start services
		ctx, cancel := context.WithCancel(context.Background())
		if bindResult.Binded {
			if !bindResult.BanIP {
				go job.ConnectGrpcServer(ctx, backendService, bindResult.UUID)
				// go service.LoopDetectX86SleepConfig(ctx)
				proxyManager := proxy.NewProxyManager(ctx, cancel)
				go proxyManager.KeepAliveStartProxy()
			}
			go job.StartHeartBeat(ctx, bindResult.UUID, backendService)
		}

		// Monitor bind and BanIP status
		go monitorBindStatus(ctx, cancel, apiBackendService, bindResult.BanIP, bindCheckInterval)

		// Wait for context cancellation
		<-ctx.Done()
		log.Println("Services stopped due to unbinding or shutdown")

		time.Sleep(pollInterval)
	}
}

// bindChecker interface defines the method required for bind status checking
type bindChecker interface {
	GetNodeBindStatus() (model.BindResult, error)
}

// monitorBindStatus periodically checks if device bind/BanIP status changed.
// When state changes, it cancels current context so the outer loop can rebuild workers.
func monitorBindStatus(ctx context.Context, cancel context.CancelFunc, backendService bindChecker, initialBanIP bool, interval time.Duration) {
	ticker := time.NewTicker(interval)
	defer ticker.Stop()
	consecutiveErr := 0

	for {
		select {
		case <-ctx.Done():
			return
		case <-ticker.C:
			bindResult, err := backendService.GetNodeBindStatus()
			if err != nil {
				consecutiveErr++
				log.Printf("Failed to check bind status: %v", err)
				if consecutiveErr >= maxBindCheckError {
					log.Printf("Bind status check failed %d times, restarting services for recovery", consecutiveErr)
					cancel()
					return
				}
				continue
			}

			consecutiveErr = 0
			log.Printf("Bind result:%+v", bindResult)
			if !bindResult.Binded {
				log.Println("Device unbound, stopping services")
				cancel()
				return
			}

			if bindResult.BanIP != initialBanIP {
				log.Printf("BanIP changed from %v to %v, restarting services", initialBanIP, bindResult.BanIP)
				cancel()
				return
			}
		}
	}
}
