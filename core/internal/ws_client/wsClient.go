package ws_client

import (
	"aro-ext-app/core/internal/config"
	"encoding/json"
	"fmt"
	"log"
	"net/url"
	"os"
	"os/signal"
	"sync"
	"time"

	"github.com/gorilla/websocket"
)

type AuthToken struct {
	UserID string `json:"userId"`
	NodeID string `json:"nodeId"`
}

type AuthWrapper struct {
	Token AuthToken `json:"token"`
}

// WebSocket 客户端配置
type WSConfig struct {
	AutoConnect          bool
	Reconnection         bool
	ReconnectionAttempts int
	ReconnectionDelay    time.Duration
	ReconnectionDelayMax time.Duration
}

// WebSocket客户端单例
var (
	websocketClientInstance *WebSocketClient
	once                    sync.Once
)

// WebSocketClient 结构体
type WebSocketClient struct {
	conn        *websocket.Conn
	config      WSConfig
	isConnected bool
	mutex       sync.Mutex
}

// GetWebSocketClient 获取WebSocket客户端单例实例
func GetWebSocketClient() *WebSocketClient {
	once.Do(func() {
		cfg := config.GetConfig()

		// 创建带重连配置的客户端
		wsConfig := WSConfig{
			AutoConnect:          false,                                                                  // 默认 false
			Reconnection:         true,                                                                   // 默认 true
			ReconnectionAttempts: 5,                                                                      // 默认 5
			ReconnectionDelay:    time.Duration(cfg.GetInt("RECONNECTION_DELAY")) * time.Millisecond,     // 默认 5000
			ReconnectionDelayMax: time.Duration(cfg.GetInt("RECONNECTION_DELAY_MAX")) * time.Millisecond, // 默认 10000
		}

		websocketClientInstance = &WebSocketClient{
			config: wsConfig,
		}
	})
	return websocketClientInstance
}

// Start 启动WebSocket客户端
func (wsc *WebSocketClient) Start() {
	// 如果 AutoConnect 为 false，则直接返回
	//if !wsc.config.AutoConnect {
	//	log.Println("AutoConnect is disabled, skipping WebSocket connection")
	//	return
	//}

	// 启动带重连机制的客户端
	go wsc.startWebSocketClientWithReconnect()
}

// startWebSocketClientWithReconnect 带重连机制的启动方法
func (wsc *WebSocketClient) startWebSocketClientWithReconnect() {
	attempts := 0

	for {
		success := wsc.connectToWebSocket()
		if success {
			// 连接成功，重置尝试次数
			attempts = 0
		} else {
			// 连接失败，处理重连逻辑
			attempts++
			log.Printf("WebSocket connection attempt %d failed", attempts)

			// 检查是否超过最大重试次数
			if wsc.config.Reconnection && (wsc.config.ReconnectionAttempts <= 0 || attempts < wsc.config.ReconnectionAttempts) {
				// 计算延迟时间，使用指数退避算法，但不超过最大延迟
				delay := time.Duration(attempts) * wsc.config.ReconnectionDelay
				if delay > wsc.config.ReconnectionDelayMax {
					delay = wsc.config.ReconnectionDelayMax
				}

				log.Printf("Reconnecting in %v...", delay)
				time.Sleep(delay)
				continue
			} else {
				log.Println("Maximum reconnection attempts reached or reconnection disabled")
				break
			}
		}

		// 等待中断信号以优雅地关闭连接
		interrupt := make(chan os.Signal, 1)
		signal.Notify(interrupt, os.Interrupt)
		<-interrupt

		log.Println("Interrupt received, closing connection...")
		break
	}
}

// connectToWebSocket 连接到WebSocket服务器
func (wsc *WebSocketClient) connectToWebSocket() bool {
	cfg := config.GetConfig()

	u := url.URL{
		Scheme:   "ws",
		Host:     "staging-ws.aro.network", // 你的端口
		Path:     "/socket.io/",
		RawQuery: "EIO=4&transport=websocket",
	}
	log.Printf("Connecting to: %s", u.String())

	// 建立 WebSocket 连接
	requestHeader := make(map[string][]string)

	c, _, err := websocket.DefaultDialer.Dial(u.String(), requestHeader)
	if err != nil {
		log.Printf("Connection failed: %v", err)
		return false
	}

	// 更新连接状态
	wsc.mutex.Lock()
	wsc.conn = c
	wsc.isConnected = true
	wsc.mutex.Unlock()

	// 准备 Auth 数据
	authToken := AuthToken{
		UserID: cfg.Get(config.USER_ID),
		NodeID: cfg.Get(config.KeyClientId),
	}
	authWrapper := AuthWrapper{
		Token: authToken,
	}
	connected := true
	// 序列化为 JSON
	authJson, _ := json.Marshal(authWrapper)

	done := make(chan struct{})

	// 启动读取循环
	go func() {
		defer close(done)
		defer func() {
			// 连接断开时的通知
			wsc.mutex.Lock()
			if connected && wsc.isConnected {
				log.Println("WebSocket connection is broken")
				wsc.isConnected = false
				wsc.conn = nil
			}
			wsc.mutex.Unlock()
		}()
		for {
			_, message, err := c.ReadMessage()
			if err != nil {
				log.Println("Read error:", err)
				return
			}
			msgStr := string(message)

			// 简单协议解析
			if len(msgStr) == 0 {
				continue
			}
			packetType := msgStr[0] // 第一个字符是包类型

			switch packetType {
			case '0': // '0' = Open 包 (握手开始)
				fmt.Println(">>> Received server side handshake package (Open)")

				// 发送 Connect 包 (Type '40') + Auth JSON
				connectPacket := "40" + string(authJson)

				err := c.WriteMessage(websocket.TextMessage, []byte(connectPacket))
				if err != nil {
					log.Println("Failed to send auth:", err)
					return
				}
				fmt.Printf(">>> Auth data has been sent: %+v\n", authWrapper)
			case '1': // '1' = Close 包 (连接关闭)
				fmt.Println("Server actively closed the connection")
				connected = false
			case '2': // '2' = Ping (心跳)
				// 必须回复 '3' (Pong) 保持连接
				c.WriteMessage(websocket.TextMessage, []byte("3"))

			case '4': // '4' = Message (业务消息)
				// 40 代表连接成功确认
				if len(msgStr) > 1 && msgStr[1] == '0' {
					fmt.Println(">>> Server confirmed connection successful (SID generated)")
				} else {
					fmt.Printf("Received message: %s\n", msgStr)
				}
			}
		}
	}()

	// 等待连接完成或出错
	<-done
	return true
}

// StartWebSocketClient 兼容旧接口
func StartWebSocketClient() {
	client := GetWebSocketClient()
	client.Start()
}

// IsWebSocketRunning 检查WebSocket是否正在运行
func IsWebSocketRunning() bool {
	client := GetWebSocketClient()
	client.mutex.Lock()
	defer client.mutex.Unlock()
	return client.isConnected
}
