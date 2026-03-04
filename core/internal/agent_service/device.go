package agentservice

import (
	"aro-ext-app/core/internal/config"
	"aro-ext-app/core/internal/constant"
	"aro-ext-app/core/internal/embedded"
	"io/ioutil"
	"log"
	"os"
	"os/exec"
	"path"
	"strings"

	"aro-ext-app/core/internal/crypto"
	"fmt"
	"runtime"

	agentConstant "github.com/aro-network/aro-edge-agent/agent/constant"
	"github.com/aro-network/aro-edge-agent/agent/pkg/service"
	agentUtil "github.com/aro-network/aro-edge-agent/agent/util"
	"github.com/shirou/gopsutil/v4/cpu"
	"github.com/shirou/gopsutil/v4/host"

	"github.com/aro-network/aro-edge-agent/agent/database/model"
)

var cfg = config.GetConfig()

func GetDeviceInfo() (model.DeviceInfo, error) {
	if agentConstant.DEVICE_INFO.SerialNumber != "" {
		return agentConstant.DEVICE_INFO, nil
	}
	keySn := cfg.Get(config.KeySN)
	clientId := cfg.Get(config.KeyClientId)
	if keySn != "" && clientId != "" {
		
		deviceInfo := model.DeviceInfo{
		HSerialNumber: clientId,
		SerialNumber:  keySn,
		DeviceType:    model.DeviceType(runtime.GOOS),
		AgentVersion:  constant.VERSION,
	}
	agentConstant.DEVICE_INFO = deviceInfo
	return deviceInfo, nil
	}
	clientId = crypto.GenerateClientID()
	device := model.DeviceInfo{
		HSerialNumber: clientId,
		SerialNumber:  clientId,
		DeviceType:    model.DeviceType(runtime.GOOS),
		AgentVersion:  constant.VERSION,
	}
	backendService := service.NewBackendService(device)
	enreachSerialNumber, err := backendService.GenerateEnReachSerialNumber()
	if err != nil {
		return device, fmt.Errorf("failed to generate EnReach serial number: %v", err)
	}
	cfg.SetAndSave(config.KeySN, enreachSerialNumber)
	device.SerialNumber = enreachSerialNumber
	agentConstant.DEVICE_INFO = device
	return device, nil
}

func DetectEnvironment() {

	DetectEnvironmentReliable()
	if agentConstant.ENVIRONMENT_TYPE != model.PhysicalMachine {
		statusInfo := model.WorkStatusInfo{
			Status:   "Error",
			Code:     "Err_NotSupportVM",
			Message:  "Virtual Machine installation is not supported.",
			Priority: 1,
			Source:   "agent",
		}
		if agentConstant.PAGE_MESSGE == nil {
			agentConstant.PAGE_MESSGE = &statusInfo
			return
		}
		if agentConstant.PAGE_MESSGE.Priority > statusInfo.Priority {
			agentConstant.PAGE_MESSGE = &statusInfo
		}
	}
}

func DetectEnvironmentReliable() {
	// 1. 首先尝试 gopsutil (跨平台)
	info, err := host.Info()
	log.Printf("Host info: %+v;err;%+v", info, err)
	// 2. 检查 CPU 标志 (跨平台，但 Linux 特定的标志检查应该在 Linux 上)
	cpuInfos, err := cpu.Info()
	log.Printf("cpu Infos:%+v;err:%+v", cpuInfos, err)
	agentConstant.HOST_INFO = &model.HostInfo{
		Platform:        info.Platform,
		KernelArch:      info.KernelArch,
		PlatformVersion: info.PlatformVersion,
	}
	// 仅在 Linux 系统上执行 systemd-detect-virt
	if runtime.GOOS == "linux" {
		embedded.ExtractAllScripts()
		detectVirtResult := agentUtil.ExecuteCommandShell(agentConstant.LINUX_SYSTEMD_DETECT_VIRT)
		if detectVirtResult.Success && detectVirtResult.Stdout != "none" {
			agentConstant.ENVIRONMENT_TYPE = model.VirtualMachine
			return
		}
		localDetectVirtCmd := path.Join(agentConstant.AGENT_DIR_PATH, "/scripts", agentConstant.LINUX_SYSTEMD_DETECT_VIRT)
		localDetectVirtResult := agentUtil.ExecuteCommandShell(localDetectVirtCmd)
		if localDetectVirtResult.Success && localDetectVirtResult.Stdout != "none" {
			agentConstant.ENVIRONMENT_TYPE = model.VirtualMachine
			return
		}
	}

	// 所有平台都检查容器环境
	isContainer, _ := InContainer()
	if isContainer {
		agentConstant.ENVIRONMENT_TYPE = "container"
		return
	}

	if err == nil {
		// 关键修改：检查 virtualizationRole
		if info.VirtualizationSystem != "" && info.VirtualizationRole == "guest" {
			agentConstant.ENVIRONMENT_TYPE = "virtual_machine"
			return
		}
		// 如果是宿主机，应该视为物理机
		if info.VirtualizationRole == "host" {
			agentConstant.ENVIRONMENT_TYPE = "physical_machine"
			return
		}
	}
	if err == nil && runtime.GOOS == "linux" {
		for _, cpuInfo := range cpuInfos {
			for _, flag := range cpuInfo.Flags {
				if flag == "hypervisor" {
					// 进一步检查是否为虚拟机客户机
					if isVirtualMachineGuest() {
						agentConstant.ENVIRONMENT_TYPE = "virtual_machine"
						return
					}
				}
			}
		}
	}

	// 3. 平台特定检查
	switch runtime.GOOS {
	case "linux":
		// Linux: 检查 DMI 信息
		detectLinuxVirtualMachine()

	case "windows":
		// Windows: 检查 Hyper-V 和 VMware 标志
		detectWindowsVirtualMachine()

	case "darwin":
		// macOS: 检查虚拟化标志
		detectDarwinVirtualMachine()

	case "android":
		// Android: 检查虚拟化属性
		detectAndroidVirtualMachine()
	}

}

// Linux: 检查 DMI 信息判断虚拟机
func detectLinuxVirtualMachine() {
	vendorList := []string{"virtual", "vmware", "virtualbox", "kvm", "qemu",
		"microsoft", "vm", ".innotek", "parallels", "xen",
		"tencent", "amazon", "alibaba", "google", "huawei",
		"oracle", "digitalocean"}
	vendor, err := ioutil.ReadFile("/sys/class/dmi/id/sys_vendor")
	log.Printf("vendor:%+v;err:%+v", vendor, err)
	if err == nil {
		vendorStr := strings.ToLower(strings.TrimSpace(string(vendor)))
		for _, v := range vendorList {
			if strings.Contains(vendorStr, v) {
				agentConstant.ENVIRONMENT_TYPE = "virtual_machine"
				return
			}
		}
	}
}

// Windows: 检查 WMI 或注册表判断虚拟机
func detectWindowsVirtualMachine() {
	// Windows 下可以通过查询 WMI 或注册表来判断虚拟化
	// 常见虚拟机标志：Hyper-V, VMware, VirtualBox, KVM 等

	// 简单的检查方法：运行命令
	// 检查 Hyper-V
	cmd := exec.Command("powershell", "-WindowStyle", "Hidden", "-Command", "Get-WmiObject Win32_ComputerSystem | Select-Object Manufacturer,Model")

	// 隐藏命令行窗口
	hideCommandWindow(cmd)

	output, err := cmd.Output()
	if err == nil {
		outputStr := strings.ToLower(string(output))
		vmIndicators := []string{"vmware", "virtualbox", "hyperv", "kvm", "qemu", "virtualpc"}
		for _, indicator := range vmIndicators {
			if strings.Contains(outputStr, indicator) {
				agentConstant.ENVIRONMENT_TYPE = "virtual_machine"
				log.Printf("Detected Windows VM: %s", indicator)
				return
			}
		}
	}
}

// macOS: 检查系统信息判断虚拟机
func detectDarwinVirtualMachine() {
	// 优先使用轻量级的 sysctl 命令，避免 system_profiler 可能触发的弹窗

	// 1. 检查 hw.model
	cmd := exec.Command("sysctl", "-n", "hw.model")
	hideCommandWindow(cmd)
	output, err := cmd.Output()
	if err == nil {
		model := strings.ToLower(strings.TrimSpace(string(output)))
		vmIndicators := []string{"vm", "virtual", "vmware", "parallels"}
		for _, indicator := range vmIndicators {
			if strings.Contains(model, indicator) {
				agentConstant.ENVIRONMENT_TYPE = "virtual_machine"
				log.Printf("Detected macOS VM via hw.model: %s", model)
				return
			}
		}
	}

	// 2. 检查 machdep.cpu.brand_string (CPU 品牌信息)
	cmd = exec.Command("sysctl", "-n", "machdep.cpu.brand_string")
	hideCommandWindow(cmd)
	output, err = cmd.Output()
	if err == nil {
		cpuBrand := strings.ToLower(strings.TrimSpace(string(output)))
		// 虚拟机通常会在 CPU 品牌中包含虚拟化标识
		if strings.Contains(cpuBrand, "qemu") || strings.Contains(cpuBrand, "kvm") {
			agentConstant.ENVIRONMENT_TYPE = "virtual_machine"
			log.Printf("Detected macOS VM via CPU brand: %s", cpuBrand)
			return
		}
	}

	// 3. 检查 kern.hv_support
	cmd = exec.Command("sysctl", "-n", "kern.hv_support")
	hideCommandWindow(cmd)
	output, err = cmd.Output()
	if err == nil {
		hvSupport := strings.TrimSpace(string(output))
		// 如果是 "1"，说明支持虚拟化，但这不一定意味着是虚拟机
		// 需要结合其他信息判断
		if hvSupport == "0" {
			// 不支持虚拟化可能意味着是虚拟机
			log.Printf("macOS hypervisor support: %s", hvSupport)
		}
	}

	// 4. 检查 ioreg 命令 (不会触发弹窗，轻量级)
	cmd = exec.Command("ioreg", "-l")
	hideCommandWindow(cmd)
	output, err = cmd.Output()
	if err == nil {
		ioregOutput := strings.ToLower(string(output))
		vmIndicators := []string{"vmware", "virtualbox", "parallels", "qemu", "virtual"}
		for _, indicator := range vmIndicators {
			if strings.Contains(ioregOutput, indicator) {
				agentConstant.ENVIRONMENT_TYPE = "virtual_machine"
				log.Printf("Detected macOS VM via ioreg: %s", indicator)
				return
			}
		}
	}
}

// Android: 检查虚拟化属性
func detectAndroidVirtualMachine() {
	// Android 虚拟机检查 ro.kernel.qemu 或其他虚拟化属性
	// 通过读取 /system/build.prop 或使用 getprop 命令

	// 检查常见的虚拟机标识属性
	vmProperties := []string{
		"ro.kernel.qemu",       // QEMU 虚拟机
		"ro.hardware.keystore", // 某些模拟器
		"ro.hardware",          // 硬件标识
		"ro.product.model",     // 设备型号
	}

	for _, prop := range vmProperties {
		cmd := exec.Command("getprop", prop)

		// 隐藏命令行窗口
		hideCommandWindow(cmd)

		output, err := cmd.Output()
		if err == nil {
			propValue := strings.ToLower(strings.TrimSpace(string(output)))
			vmIndicators := []string{"qemu", "emulator", "genymotion", "bluestacks", "noxplayer"}
			for _, indicator := range vmIndicators {
				if strings.Contains(propValue, indicator) {
					agentConstant.ENVIRONMENT_TYPE = "virtual_machine"
					log.Printf("Detected Android VM via %s: %s", prop, propValue)
					return
				}
			}
		}
	}
}

// 辅助函数：进一步确认是否为虚拟机客户机
func isVirtualMachineGuest() bool {
	// 检查DMI信息中的具体虚拟机标识
	productNames := []string{
		"/sys/class/dmi/id/product_name",
		"/sys/class/dmi/id/chassis_vendor",
	}

	virtualMachineIndicators := []string{
		"virtual", "vmware", "virtualbox", "kvm", "qemu",
		"microsoft", "vm", ".innotek", "parallels", "xen", "cvm", "alibaba", "google", "huawei", "oracle",
		"digitalocean",
	}

	for _, productFile := range productNames {
		if content, err := ioutil.ReadFile(productFile); err == nil {
			contentStr := strings.ToLower(string(content))
			for _, indicator := range virtualMachineIndicators {
				if strings.Contains(contentStr, indicator) {
					return true
				}
			}
		}
	}

	return false
}

func checkBySystemdDetectVirt() (bool, string) {
	cmd := exec.Command("systemd-detect-virt", "-c")

	// 隐藏命令行窗口
	hideCommandWindow(cmd)

	out, err := cmd.Output()
	if err != nil {
		return false, "systemd-detect-virt not available"
	}
	result := strings.TrimSpace(string(out))
	if result != "none" {
		return true, result
	}
	return false, "none"
}

// 通用容器检测（fallback）
func checkByGenericMethods() (bool, string) {
	// 1. 检查特征文件（仅 Linux）
	if runtime.GOOS == "linux" {
		if _, err := os.Stat("/.dockerenv"); err == nil {
			return true, "/.dockerenv"
		}
		if _, err := os.Stat("/run/.containerenv"); err == nil {
			return true, "/run/.containerenv"
		}

		// 2. 检查 cgroup (兼容 v1/v2，仅 Linux)
		if data, err := os.ReadFile("/proc/1/cgroup"); err == nil {
			content := string(data)
			if strings.Contains(content, "docker") ||
				strings.Contains(content, "kubepods") ||
				strings.Contains(content, "containerd") {
				return true, "cgroup contains container keyword"
			}
		}

		// 3. 检查 /proc/1/exe (仅 Linux)
		if exe, err := os.Readlink("/proc/1/exe"); err == nil {
			if !strings.Contains(exe, "init") && !strings.Contains(exe, "systemd") {
				return true, "pid1_exe=" + exe
			}
		}
	}

	// 4. 检查环境变量（所有平台）
	if os.Getenv("container") != "" {
		return true, "env: container=" + os.Getenv("container")
	}
	if os.Getenv("KUBERNETES_SERVICE_HOST") != "" {
		return true, "env: KUBERNETES_SERVICE_HOST"
	}

	return false, "no container evidence found"
}

// 容器检测（跨平台）
func InContainer() (bool, string) {
	if runtime.GOOS == "linux" {
		// 优先尝试 systemd-detect-virt (仅 Linux)
		if ok, reason := checkBySystemdDetectVirt(); ok {
			return true, "systemd-detect-virt: " + reason
		}
	}
	// fallback 到通用方法
	return checkByGenericMethods()
}
func IsPhysicalInterfaceByName(ifName string) bool {
	physicalPrefixes := []string{
		"eth",  // 以太网卡
		"enp",  // PCI以太网卡 (e.g., enp0s3)
		"ens",  // PCI以太网卡 (e.g., ens33)
		"eno",  // 板载以太网卡
		"em",   // 企业网卡
		"peth", // 物理以太网卡
	}

	virtualPrefixes := []string{
		"lo",     // 回环接口
		"virbr",  // 虚拟网桥
		"vnet",   // 虚拟网络接口
		"docker", // Docker虚拟接口
		"br-",    // Docker网桥
		"cali",   // Calico网络
		"tun",    // TUN/TAP接口
		"tap",    // TAP接口
		"wlan",   // 无线网卡（可能是USB）
		"wl",     // 无线网卡
		"ww",     // WWAN接口
	}

	for _, prefix := range virtualPrefixes {
		if strings.HasPrefix(ifName, prefix) {
			return false
		}
	}

	for _, prefix := range physicalPrefixes {
		if strings.HasPrefix(ifName, prefix) {
			return true
		}
	}

	return false
}
