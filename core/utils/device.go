package utils

import (
	"fmt"
	"log"
	"time"

	"aro-ext-app/core/internal/constant"

	"github.com/aro-network/aro-edge-agent/agent/util"
	"github.com/shirou/gopsutil/v4/cpu"
	"github.com/shirou/gopsutil/v4/mem"
)

func GetDeviceBaseInfo() util.DeviceInfoRequest {
	// --- CPU Info (cross-platform) ---
	cpuCores := 0
	// Get logical core count
	if cores, err := cpu.Counts(true); err == nil {
		cpuCores = cores
	} else {
		log.Println("Error retrieving CPU core count:", err)
	}

	// --- Memory Info (cross-platform) ---
	memTotal := 0
	memAvailable := 0
	memUse := 0
	if vm, err := mem.VirtualMemory(); err == nil {
		// Use bits (not MB): bytes * 8
		memTotal = int(vm.Total * 8)
		memAvailable = int(vm.Available * 8)
		memUse = memTotal - memAvailable
	} else {
		log.Println("Error retrieving memory info:", err)
	}
	ipStats := util.GetLocalIPStat()
	// --- Network, Disk Info ---
	return util.DeviceInfoRequest{
		DeviceInfo: util.DeviceBaseInfo{
			Date:              fmt.Sprintf("%d", time.Now().Unix()),
			CPUCores:          cpuCores,
			MemTotal:          memTotal,
			MemAvailable:      memAvailable,
			MemUse:            memUse,
			NetworkInterfaces: ipStats,
			Version:           constant.VERSION,
		},
	}
}
