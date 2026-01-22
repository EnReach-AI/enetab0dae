package main

import (
	"log"
	"time"

	"aro-ext-app/core/internal/proxy_worker"
)

func main() {
	log.Println("Testing Proxy Worker (Embedded GOST Mode)...")

	// 创建测试配置
	config := proxy_worker.ProxyWorkerConfig{
		SN:              "NLYN2Q0PYRAFQOWHK5R",
		Token:           "1",
		TunnelID:        "4dd56d7f-df87-4f7b-9dd3-5f74465d8f74",
		ProxyServerIP:   "127.0.0.1",
		ProxyServerPort: 8000,
		LocalPort:       10800,
		NatType:         1, // 动态 IP
		FixedPort:       10800,
	}

	// 获取管理器
	manager := proxy_worker.GetManager()

	// 测试 1: 启动 Worker
	log.Println("\n=== Test 1: Starting Proxy Worker ===")
	err := manager.Start(config)
	if err != nil {
		log.Fatalf("Failed to start worker: %v", err)
	}
	log.Println("✓ Worker started successfully")

	// 等待一下让服务启动
	time.Sleep(2 * time.Second)

	for {
		running := manager.IsRunning()
		log.Printf("Is Running: %v\n", running)
		time.Sleep(3 * time.Second)
	}

	// 测试 2: 获取状态
	// log.Println("\n=== Test 2: Getting Worker Status ===")
	// status := manager.GetStatus()
	// statusJSON, _ := json.MarshalIndent(status, "", "  ")
	// fmt.Printf("Status:\n%s\n", statusJSON)
	// log.Println("✓ Status retrieved successfully")

	// // 测试 3: 检查是否运行
	// log.Println("\n=== Test 3: Checking if Running ===")
	// isRunning := manager.IsRunning()
	// log.Printf("Is Running: %v\n", isRunning)
	// if !isRunning {
	// 	log.Fatalf("Worker should be running but it's not!")
	// }
	// log.Println("✓ Worker is running")

	// // 测试 4: 停止 Worker
	// log.Println("\n=== Test 4: Stopping Worker ===")
	// err = manager.Stop()
	// if err != nil {
	// 	log.Fatalf("Failed to stop worker: %v", err)
	// }
	// log.Println("✓ Worker stopped successfully")

	// // 测试 5: 验证已停止
	// log.Println("\n=== Test 5: Verifying Worker Stopped ===")
	// isRunning = manager.IsRunning()
	// log.Printf("Is Running: %v\n", isRunning)
	// if isRunning {
	// 	log.Fatalf("Worker should be stopped but it's still running!")
	// }
	// log.Println("✓ Worker is stopped")

	// // 测试 6: 重启测试
	// log.Println("\n=== Test 6: Restarting Worker ===")
	// time.Sleep(3 * time.Second) // 等待端口完全释放
	// err = manager.Start(config)
	// if err != nil {
	// 	log.Fatalf("Failed to restart worker: %v", err)
	// }
	// log.Println("✓ Worker restarted successfully")

	// time.Sleep(1 * time.Second)

	// // 测试 7: 使用 Restart 方法
	// log.Println("\n=== Test 7: Using Restart Method ===")
	// err = manager.Restart()
	// if err != nil {
	// 	log.Fatalf("Failed to restart using Restart method: %v", err)
	// }
	// log.Println("✓ Restart method works")

	// time.Sleep(1 * time.Second)

	// // 清理
	// log.Println("\n=== Cleanup ===")
	// manager.Stop()

	// log.Println("\n=== All Tests Passed! ===")
	// log.Println("The embedded GOST proxy worker is working correctly.")
}
