package ws_client

import (
	"aro-ext-app/core/internal/config"
	"encoding/json"
	"fmt"
	"log"
	"time"

	"github.com/gorilla/websocket"
)

// WSClient WebSocket 客户端
type WSClient struct {
	url          string
	conn         *websocket.Conn
	reconnecting bool
	pingTicker   *time.Ticker

	// 消息处理回调
	onConnect    func()
	onDisconnect func(string)
	onMessage    func(string, interface{})
	onError      func(error)
}

var cfg = config.GetConfig()

// NewWSClient 创建 WebSocket 客户端
func NewWSClient(url string) *WSClient {
	return &WSClient{
		url: url,
	}
}

// OnConnect 设置连接回调
func (w *WSClient) OnConnect(cb func()) {
	w.onConnect = cb
}

// OnDisconnect 设置断开连接回调
func (w *WSClient) OnDisconnect(cb func(string)) {
	w.onDisconnect = cb
}

// OnMessage 设置消息回调
func (w *WSClient) OnMessage(cb func(string, interface{})) {
	w.onMessage = cb
}

// OnError 设置错误回调
func (w *WSClient) OnError(cb func(error)) {
	w.onError = cb
}

// Connect 连接到 WebSocket 服务器
func (w *WSClient) Connect() error {
	dialer := websocket.Dialer{
		HandshakeTimeout: 10 * time.Second,
	}

	authPayload := struct {
		UserId string `json:"userId"`
		NodeId string `json:"nodeId"`
	}{
		UserId: cfg.Get(config.USER_ID),
		NodeId: cfg.Get(config.KeyClientId),
	}
	// 构建 URL 并添加认证
	marshal, err := json.Marshal(&authPayload)
	if err != nil {
		return err
	}
	log.Printf("Connecting to WebSocket server with auth payload: %+v", string(marshal))

	connectURL := fmt.Sprintf("%s?auth=%v", w.url, marshal)

	conn, _, err := dialer.Dial(connectURL, nil)
	if err != nil {
		log.Printf("WebSocket connection failed: %v", err)
		return err
	}

	w.conn = conn
	log.Println("WebSocket connected successfully")

	// 触发连接回调
	if w.onConnect != nil {
		w.onConnect()
	}

	// 启动消息监听
	go w.readMessages()

	// 启动心跳
	go w.heartbeat()

	return nil
}

// Disconnect 断开连接
func (w *WSClient) Disconnect(reason string) {
	if w.conn == nil {
		return
	}

	if w.pingTicker != nil {
		w.pingTicker.Stop()
	}

	w.conn.Close()
	w.conn = nil

	if w.onDisconnect != nil {
		w.onDisconnect(reason)
	}
}

// Send 发送消息
func (w *WSClient) Send(event string, data interface{}) error {
	if w.conn == nil {
		return fmt.Errorf("the connection is broken")
	}

	payload := map[string]interface{}{
		"event": event,
		"data":  data,
	}

	msgBytes, _ := json.Marshal(payload)
	return w.conn.WriteMessage(websocket.TextMessage, msgBytes)
}

// readMessages 读取消息
func (w *WSClient) readMessages() {
	defer func() {
		if r := recover(); r != nil {
			log.Printf("readMessages panic: %v", r)
		}
	}()

	for {
		if w.conn == nil {
			break
		}

		_, msgBytes, err := w.conn.ReadMessage()
		if err != nil {
			if websocket.IsUnexpectedCloseError(err, websocket.CloseGoingAway, websocket.CloseAbnormalClosure) {
				log.Printf("WebSocket error: %v", err)
				if w.onError != nil {
					w.onError(err)
				}
			}
			// 尝试重新连接
			w.reconnect()
			break
		}

		// 解析消息
		var msg map[string]interface{}
		if err := json.Unmarshal(msgBytes, &msg); err != nil {
			log.Printf("Message parsing failed: %v", err)
			continue
		}

		event, _ := msg["event"].(string)
		data := msg["data"]

		log.Printf("Received message: event=%s, data=%v", event, data)

		if w.onMessage != nil {
			w.onMessage(event, data)
		}
	}
}

// heartbeat 心跳
func (w *WSClient) heartbeat() {
	w.pingTicker = time.NewTicker(3 * time.Minute)
	defer w.pingTicker.Stop()

	for range w.pingTicker.C {
		if w.conn == nil {
			break
		}

		if err := w.Send("ping", map[string]string{}); err != nil {
			log.Printf("Failed to send heartbeat: %v", err)
			w.reconnect()
			break
		}

		log.Println("Heartbeat sent")
	}
}

// reconnect 重新连接
func (w *WSClient) reconnect() {
	if w.reconnecting {
		return
	}

	w.reconnecting = true
	defer func() { w.reconnecting = false }()

	log.Println("Attempting to reconnect...")

	for i := 0; i < 5; i++ {
		backoff := time.Duration((i+1)*5) * time.Second
		time.Sleep(backoff)

		// 这里需要传入认证信息，实际应从存储中获取
		if err := w.Connect(); err == nil {
			log.Println("Reconnected successfully")
			return
		}

		log.Printf("Reconnection failed (attempt %d), waiting %v before retry", i+1, backoff)
	}

	log.Println("Too many reconnection attempts, giving up")
}

// IsConnected 检查是否已连接
func (w *WSClient) IsConnected() bool {
	return w.conn != nil
}
