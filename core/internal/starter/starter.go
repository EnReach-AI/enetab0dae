package starter

import (
	"context"
	"log"
	"time"

	"aro-ext-app/core/internal/agentservice"
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

func RunBackendThread(isExcuteBackendThreading chan bool) {

	agentConstant.Init2(cfg.Get(config.KeyAgentPath), constant.VERSION)

	const (
		pollInterval      = 20 * time.Second
		errorRetryDelay   = 20 * time.Second
		bindCheckInterval = 20 * time.Second
	)

	for {
		// Get device information
		deviceInfo, err := internalService.GetDeviceInfo()
		if err != nil {
			log.Printf("Failed to get device info: %v, retrying in %v", err, errorRetryDelay)
			time.Sleep(errorRetryDelay)
			continue
		}

		log.Printf("Device started: SN=%s, Type=%s, Version=%s",
			deviceInfo.SerialNumber, deviceInfo.DeviceType, deviceInfo.AgentVersion)

		// Check bind status
		backendService := service.NewBackendService(deviceInfo)
		bindResult, err := backendService.GetNodeBindStatus()
		if err != nil {
			log.Printf("Failed to get bind status: %v, retrying in %v", err, errorRetryDelay)
			time.Sleep(errorRetryDelay)
			continue
		}

		log.Printf("Bind result:%+v", bindResult)
		log.Printf("Device bind status: %t, NodeID: %s", bindResult.Binded, bindResult.UUID)
		agentservice.DetectEnvironment()
		AppBackendService = api_client.NewAPIClient(cfg.Get(config.KeyAPIURL), cfg.Get(config.KeyClientId), cfg.Get(config.KeySN), bindResult.UUID)

		// 发送初始化完成信号
		if isExcuteBackendThreading != nil {
			select {
			case isExcuteBackendThreading <- true:
				log.Println("Backend initialization completed, signal sent")
			default:
				log.Println("Backend initialization completed, but signal already sent")
			}
			if !bindResult.Binded {
				log.Println("Device not bound, waiting for binding...")
				time.Sleep(pollInterval)
				continue
			}

		}
		agentConstant.ENVIRONMENT_TYPE = model.PhysicalMachine
		// Device is bound, start services
		ctx, cancel := context.WithCancel(context.Background())
		log.Printf("environment type:%s", agentConstant.ENVIRONMENT_TYPE)
		// Start physical machine services
		// if constant.ENVIRONMENT_TYPE == model.PhysicalMachine && !bindResult.BanIP {

		// }
		go job.ConnectGrpcServer(ctx, backendService, bindResult.UUID)
		go service.LoopDetectX86SleepConfig(ctx)
		proxyManager := proxy.NewProxyManager(ctx, cancel)
		go proxyManager.KeepAliveStartProxy()
		// Start heartbeat
		go job.StartHeartBeat(ctx, bindResult.UUID, backendService)

		// Monitor bind status
		go monitorBindStatus(ctx, cancel, backendService, bindCheckInterval)

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
