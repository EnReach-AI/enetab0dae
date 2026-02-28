package starter

import (
	"context"
	"log"
	"time"

	internalService "aro-ext-app/core/internal/agentservice"
	"aro-ext-app/core/internal/api_client"
	"aro-ext-app/core/internal/config"
	"aro-ext-app/core/internal/constant"

	agentConstant "github.com/aro-network/aro-edge-agent/agent/constant"
	"github.com/aro-network/aro-edge-agent/agent/database/model"
	"github.com/aro-network/aro-edge-agent/agent/pkg/job"
	"github.com/aro-network/aro-edge-agent/agent/pkg/proxy"
	"github.com/aro-network/aro-edge-agent/agent/pkg/service"
)

var cfg = config.GetConfig()

var AppBackendService *api_client.APIClient

func RunBackendThread() {

	agentConstant.Init2(cfg.Get(config.KeyAgentPath), constant.VERSION)

	const (
		pollInterval      = 30 * time.Second
		errorRetryDelay   = 30 * time.Second
		bindCheckInterval = 30 * time.Second
	)

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
		log.Printf("start request GetNodeBindStatus start time:%s", time.Now().Format(time.RFC3339Nano))
		bindResult, err := apiBackendService.GetNodeBindStatus()
		log.Printf("start request GetNodeBindStatus end time:%s", time.Now().Format(time.RFC3339Nano))

		if err != nil {
			log.Printf("Failed to get bind status: %v, retrying in %v", err, errorRetryDelay)
			time.Sleep(errorRetryDelay)
			continue
		}

		log.Printf("Bind result:%+v", bindResult)

		AppBackendService = api_client.NewAPIClient(cfg.Get(config.KeyAPIURL), cfg.Get(config.KeyClientId), cfg.Get(config.KeySN), bindResult.UUID)

		// 检查设备是否已绑定
		if !bindResult.Binded {
			log.Println("Device not bound, waiting for binding...")
			time.Sleep(pollInterval)
			continue
		}

		// Device is bound, start services
		ctx, cancel := context.WithCancel(context.Background())
		// Start physical machine services
		// if constant.ENVIRONMENT_TYPE == model.PhysicalMachine && !bindResult.BanIP {

		// }
		if bindResult.Binded {
			if !bindResult.BanIP {
				go job.ConnectGrpcServer(ctx, backendService, bindResult.UUID)
				// go service.LoopDetectX86SleepConfig(ctx)
				proxyManager := proxy.NewProxyManager(ctx, cancel)
				go proxyManager.KeepAliveStartProxy()
			}
			go job.StartHeartBeat(ctx, bindResult.UUID, backendService)
		}

		// Monitor bind status
		go monitorBindStatus(ctx, cancel, apiBackendService, bindCheckInterval)

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

// monitorBindStatus periodically checks if device is still bound
func monitorBindStatus(ctx context.Context, cancel context.CancelFunc, backendService bindChecker, interval time.Duration) {
	ticker := time.NewTicker(interval)
	defer ticker.Stop()

	for {
		select {
		case <-ctx.Done():
			return
		case <-ticker.C:
			bindResult, err := backendService.GetNodeBindStatus()
			log.Printf("Bind result:%+v", bindResult)
			if err != nil {
				log.Printf("Failed to check bind status: %v", err)
				continue
			}
			if !bindResult.Binded {
				log.Println("Device unbound, stopping services")
				cancel()
				return
			}
		}
	}
}
