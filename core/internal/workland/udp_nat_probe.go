package workland

import (
	"context"
	"encoding/json"
	"enreach-agent/constant"
	"fmt"
	"log"
	"net"
	"strings"
	"sync"
	"time"
)

type NATProbePayload struct {
	TaskID    string `json:"task_id"`
	SubTaskId string `json:"sub_task_id"`
	NodeId    string `json:"node_id"`
	Round     int    `json:"round"`
	Seq       int    `json:"seq"`
	TimeStamp int64  `json:"timestamp"`
	Token     string `json:"token"`
	Stage     int    `json:"stage"`
}

type UDPNatProbe struct {
	conn      *net.UDPConn
	localAddr *net.UDPAddr
	mutex     sync.Mutex
}

type NATProbeACKPayload struct {
	TaskId      string `json:"task_id"`
	SubTaskId   string `json:"sub_task_id"`
	NodeId      string `json:"node_id"`
	Round       int    `json:"round"`
	Seq         int    `json:"seq"`
	TimeStamp   int64  `json:"time_stamp"`
	Stage       int    `json:"stage"`
	CheckerIp   string `json:"checker_ip"`
	CheckerPort int    `json:"checker_port"`
}

func NewUDPNatProbe() (*UDPNatProbe, error) {
	// 在端口53000启动UDP监听
	localAddr, err := net.ResolveUDPAddr("udp", ":53000")
	if err != nil {
		return nil, fmt.Errorf("failed to resolve local UDP address: %v", err)
	}

	conn, err := net.ListenUDP("udp", localAddr)
	if err != nil {
		if !isPortInUseError(err) {
			return nil, fmt.Errorf("failed to listen on UDP port 53000: %v", err)
		}

	}

	probe := &UDPNatProbe{
		conn:      conn,
		localAddr: localAddr,
	}
	return probe, nil
}

func (u *UDPNatProbe) SendProbe(address, taskId string, stage int, subTaskId, token string) (error, *NATProbeACKPayload) {
	checkerAddr, err := net.ResolveUDPAddr("udp", address)
	if err != nil {
		return fmt.Errorf("resolve checker addr: %v", err), nil
	}

	ctx, cancel := context.WithTimeout(context.Background(), 6*time.Second)
	defer cancel()

	ackCh := make(chan *NATProbeACKPayload, 1)

	go func() {
		for {
			select {
			case <-ctx.Done():
				return
			default:
				ok, ack := u.waitForACK(ctx, checkerAddr)
				if ok {
					select {
					case ackCh <- ack:
						log.Printf("✅ Received valid ACK: %+v", ack)
					case <-ctx.Done():
						return
					}
					return
				}
			}
		}
	}()
	//"0199e125c6a57ff59d1b65263169a07700000000"
	for round := 1; round <= 3; round++ {
		log.Printf("Sending probe packets - Round %d", round)

		for seq := 1; seq <= 3; seq++ {
			payload := &NATProbePayload{
				TaskID:    taskId,
				SubTaskId: subTaskId,
				NodeId:    constant.NODE_INFO.UUID,
				Round:     round,
				Seq:       seq,
				TimeStamp: time.Now().UnixNano() / 1e6,
				Token:     token,
				Stage:     stage,
			}
			data, _ := json.Marshal(payload)
			log.Printf("Sending UDP packet to %s: %+v", checkerAddr.String(), payload)
			_, err := u.conn.WriteToUDP(data, checkerAddr)
			if err != nil {
				return fmt.Errorf("send UDP: %v", err), nil
			}

		}
		select {
		case ack := <-ackCh:
			if ack != nil {
				log.Printf("✅ Got ACK in round %d ack: %+v", round, ack)
				cancel()
				return nil, ack
			}
		case <-time.After(50 * time.Millisecond):
			log.Printf("⌛50 No ACK yet (round %d)", round)
			continue
		case <-ctx.Done():
			return fmt.Errorf("timeout waiting for ack"), nil
		}
		log.Printf("No ACK yet, current round:%d", round)
	}

	return fmt.Errorf("failed to receive ACK after 3 rounds of probing"), nil
}

func (u *UDPNatProbe) waitForACK(ctx context.Context, checkerAddr *net.UDPAddr) (bool, *NATProbeACKPayload) {
	buffer := make([]byte, 2048)

	for {
		// 每次循环检查 ctx 是否已取消
		select {
		case <-ctx.Done():
			return false, nil
		default:
		}

		// 给 socket 设置短超时，避免永久阻塞
		_ = u.conn.SetReadDeadline(time.Now().Add(200 * time.Millisecond))

		n, addr, err := u.conn.ReadFromUDP(buffer)
		if err != nil {
			// 超时重试
			if ne, ok := err.(net.Error); ok && ne.Timeout() {
				continue
			}
			// 其他错误
			return false, nil
		}

		var ack NATProbeACKPayload
		if err := json.Unmarshal(buffer[:n], &ack); err != nil {
			continue
		}

		log.Printf("✅111 Received ACK packet from %s: %+v", addr.String(), ack)
		return true, &ack
	}
}

func (u *UDPNatProbe) Close() error {
	//u.mutex.Lock()
	//defer u.mutex.Unlock()	//u.mutex.Lock()
	return u.conn.Close()
}

// GenerateTestTask 生成测试用的NATProbeTask
func isPortInUseError(err error) bool {
	// 根据操作系统的不同，错误信息可能不同
	// Linux/Unix系统通常包含"address already in use"
	// Windows系统通常包含"Only one usage of each socket address"
	return err != nil &&
		(strings.Contains(err.Error(), "address already in use") ||
			strings.Contains(err.Error(), "Only one usage of each socket address"))
}
