package service

import (
	"aro-ext-app/core/internal/config"
	"aro-ext-app/core/internal/constant"
	"log"

	"aro-ext-app/core/internal/crypto"
	"fmt"
	"runtime"

	agentConstant "github.com/aro-network/aro-edge-agent/agent/constant"
	"github.com/aro-network/aro-edge-agent/agent/pkg/service"

	"github.com/aro-network/aro-edge-agent/agent/database/model"
)

var cfg = config.GetConfig()
func GetDeviceInfo() (model.DeviceInfo, error) {
	if agentConstant.DEVICE_INFO.SerialNumber != "" {
		return agentConstant.DEVICE_INFO, nil
	}
	clientId := crypto.GenerateClientID()
	device := model.DeviceInfo{
		HSerialNumber: clientId,
		SerialNumber: clientId,
		DeviceType:   model.DeviceType(runtime.GOOS),
		AgentVersion: constant.VERSION,
	}
	log.Println("GetDeviceInfo deviceInfo:", device)
	backendService := service.NewBackendService(device)
	enreachSerialNumber, err := backendService.GenerateEnReachSerialNumber()
	if err != nil {
		return device, fmt.Errorf("failed to generate EnReach serial number: %v", err)
	}
	cfg.SetAndSave(config.KeySN,enreachSerialNumber)
	device.SerialNumber = enreachSerialNumber
	agentConstant.DEVICE_INFO = device
	return device, nil
}
