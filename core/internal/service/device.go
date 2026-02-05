package service

import (
	"aro-ext-app/core/internal/constant"

	"aro-ext-app/core/internal/crypto"
	"fmt"
	"runtime"

	"github.com/aro-network/aro-edge-agent/agent/pkg/service"
	 agentConstant "github.com/aro-network/aro-edge-agent/agent/constant"

	"github.com/aro-network/aro-edge-agent/agent/database/model"
)

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
	fmt.Println("GetDeviceInfo deviceInfo:", device)
	backendService := service.NewBackendService(device)

	enreachSerialNumber, err := backendService.GenerateEnReachSerialNumber()
	if err != nil {
		return device, fmt.Errorf("failed to generate EnReach serial number: %v", err)
	}
	device.SerialNumber = enreachSerialNumber
	agentConstant.DEVICE_INFO = device
	return device, nil
}
