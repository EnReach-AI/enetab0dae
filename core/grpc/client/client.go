package client

import (
	probev1 "aro-ext-app/core/grpc/gen/grpc/message"
	"aro-ext-app/core/internal/auth"
	"aro-ext-app/core/internal/speedtest"
	"aro-ext-app/core/internal/workland"
	"context"
	"encoding/json"
	"fmt"
	"io"
	"log"
	"time"

	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials"
	"google.golang.org/grpc/keepalive"
	"google.golang.org/grpc/metadata"
)

// Client represents a gRPC client
type Client struct {
	conn   *grpc.ClientConn
	client probev1.ChatServiceClient // 根据实际服务名称调整
}

// NewClient creates a new gRPC client
func NewClient(address string) *Client {
	creds := credentials.NewClientTLSFromCert(nil, "")
	keepaliveParams := keepalive.ClientParameters{
		Time:                30 * time.Second, // 发送 ping 的间隔
		Timeout:             10 * time.Second, // ping 的超时时间
		PermitWithoutStream: true,             // 允许在没有活跃流的情况下发送 ping
	}
	opts := []grpc.DialOption{
		grpc.WithTransportCredentials(creds),
		grpc.WithDefaultCallOptions(grpc.MaxCallRecvMsgSize(16 * 1024 * 1024)), // 设置最大接收消息尺寸
		grpc.WithDefaultCallOptions(grpc.MaxCallSendMsgSize(16 * 1024 * 1024)), // 设置最大发送消息尺寸
		grpc.WithKeepaliveParams(keepaliveParams),
	}
	conn, err := grpc.Dial(address+":443", opts...)
	if err != nil {
		log.Printf("Failed to dial server: %v", err)
	}

	client := probev1.NewChatServiceClient(conn)

	return &Client{
		conn:   conn,
		client: client,
	}
}

func (c *Client) Chat(ctx context.Context, udpNatProbe *workland.UDPNatProbe) {
	//log.Printf("Starting chat with server...")
	credentials := auth.NewAuthCredentials(config., c.PrivateKey)
	//token := "YXJvOjAxOTllMTI1YzZhNTdmZjU5ZDFiNjUyNjMxNjlhMDc3MDAwMDAwMDA6MTc2MjkzNDMzMzpIZ09PZFhoMDJ5azdtTzJIY3k0cWVUdUY3ZDJSeW8rOFpuVGFuekdEemRsOG5KeXgrMG9rbXkwcEhvbEJ1WUxXSCtZZmp3cDhvK2xjLytoZU12Q0tVU2FtUEZueUxxVUZLWjFtMXpVdm5PeWUzVkh0eHFiTFM1RnpvbkIzQVJQZHUvYlVWQ0FGNlk4dlA5T2YzQTl3bG4rV0E1dXZadUVENThwRDhvL2xyL2pKYmZqYTl3RmRwOGREQVAwWUUydnFwcCtsYm5FQk16Mjg0MzF6K2owRjhSUXJMVWZBdmdSR0tjVEUrNFFsTmpMcUxMcXZ4WkJtQUl0QmJnUXc5MVI3OFp0cE5pRjcveWhIWjNZN0lVSGNVdXBFWHE0SU1IR0RtbkhMUHNFRjV0blpoODZ2WnlkQ1dhQXBCTFNtNlFiMzFKVDNSdG0yMXIzMVBsVTYxaTB2NFE9PQ=="
	//log.Printf("Chat token: %s", token)
	md := metadata.New(map[string]string{"authtoken": token})
	ctx = metadata.NewOutgoingContext(ctx, md)
	stream, err := c.client.Chat(ctx)
	if err != nil {
		log.Printf("Failed to open chat stream: %v", err)
		return
	}

	done := make(chan struct{})

	// Receive goroutine
	go func() {
		defer close(done)
		for {
			resp, err := stream.Recv()
			if err == io.EOF {
				log.Println("Server closed stream")
				time.Sleep(time.Second * 10)
				continue
			}
			if err != nil {
				log.Printf("Receive error: %v", err)
				time.Sleep(time.Second * 10)
				return
			}
			message := resp.Message
			log.Printf("Received message: %+v", message)
			if message != "" {
				// Parse message type first
				var msgType struct {
					Type string `json:"type"`
				}
				if err := json.Unmarshal([]byte(message), &msgType); err != nil {
					log.Printf("Failed to parse message type: %v", err)
					continue
				}

				// Handle different message types
				switch msgType.Type {
				case "bandwidth_test":
					// Handle bandwidth test task
					go speedtest.GetService().HandleTask(message)
					continue
				default:
					// Handle NAT probe task (original logic)
				}

				var natProbeTask = model.NATProbeTask{}
				err := json.Unmarshal([]byte(message), &natProbeTask)
				if err != nil {
					log.Printf("Chat Failed to unmarshal message: %v", err)
					time.Sleep(time.Second * 10)
					continue
				}

				err, payload := udpNatProbe.SendProbe(fmt.Sprintf("%s:%d", natProbeTask.CheckerIp, natProbeTask.CheckerPort), natProbeTask.TaskId, 0, natProbeTask.SubTaskId, token)
				log.Printf("Chat 0 Send probe: %+v", payload)
				if err != nil {
					log.Printf("Chat 0 Failed to send probe: %+v", err)
					continue
				}
				err, payload = udpNatProbe.SendProbe(fmt.Sprintf("%s:%d", payload.CheckerIp, payload.CheckerPort), payload.TaskId, payload.Stage, payload.SubTaskId, token)
				log.Printf("Chat 1 Send probe: %+v", payload)
				if err != nil {
					log.Printf("Chat 1 Failed to ack send probe:%+v", err)
					continue
				}
				err, payload = udpNatProbe.SendProbe(fmt.Sprintf("%s:%d", payload.CheckerIp, payload.CheckerPort), payload.TaskId, payload.Stage, payload.SubTaskId, token)
				log.Printf("Chat 2 Send probe: %+v", payload)
				if err != nil {
					log.Printf("Chat 2 Failed to ack send probe: %+v", err)
					continue
				}
				err, payload = udpNatProbe.SendProbe(fmt.Sprintf("%s:%d", payload.CheckerIp, payload.CheckerPort), payload.TaskId, payload.Stage, payload.SubTaskId, token)
				log.Printf("Chat 3 Send probe: %+v", payload)
				if err != nil {
					log.Printf("Chat 3 Failed to ack send probe: %+v", err)
				}

			}

			//err, payload = udpNatProbe.SendProbe(fmt.Sprintf("%s:%d", payload.CheckerIp, payload.CheckerPort), natProbeTask.TaskId, 2, payload.SubTaskId)
			//if err != nil {
			//	return
			//}
			//udpNatProbe.SendProbe(fmt.Sprintf("%s:%d", payload.CheckerIp, payload.CheckerPort), natProbeTask.TaskId, 2, payload.SubTaskId)

		}
	}()

	<-done
}

// Close closes the client connection
func (c *Client) Close() {
	if c.conn != nil {
		c.conn.Close()
	}
}

//func (c *Client) UnaryCall(name string) {
//	ctx, cancel := context.WithTimeout(context.Background(), 5*time.Second)
//	defer cancel()
//
//	req := &v1.GreetRequest{Name: name}
//	resp, err := c.client.Greet(ctx, req)
//	if err != nil {
//		log.Printf("Unary call error: %v", err)
//		return
//	}
//
//	fmt.Println("Unary response:", resp.GetMessage())
//}
