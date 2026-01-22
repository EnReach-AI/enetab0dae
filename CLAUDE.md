# CLAUDE.md

此文件为 Claude Code (claude.ai/code) 在此仓库工作时提供指导。

## 项目概述

**aro-ext-app** 是一个跨平台加密货币挖矿客户端，支持桌面端（Windows/macOS/Linux）和移动端（Android/iOS）。它将 Flutter UI 层与处理挖矿、认证、WebSocket 连接和 ARO 后端 API 通信的 Go 核心引擎相结合。

### 技术栈
- **前端**：Flutter（Dart）用于桌面和移动 UI
- **核心引擎**：Go 1.21 用于跨平台挖矿逻辑和业务逻辑
- **IPC/FFI**：通过 libstudy 库在 Flutter 和 Go 之间的 C 绑定
- **WebSocket**：通过 gorilla/websocket 实现的 Socket.io 协议
- **HTTP 客户端**：具有请求签名功能的自定义 Go HTTP 客户端

## 项目结构

```
aro-ext-app/
├── core/                          # Go 核心引擎（跨平台）
│   ├── cmd/
│   │   ├── mainapp/              # 主应用入口
│   │   │   └── ipc.go            # IPC 服务（Flutter 通信）
│   │   └── study_daemon/        # CLI 守护进程（用于测试）
│   ├── internal/                 # 核心业务逻辑
│   │   ├── auth/                 # 认证与请求签名
│   │   ├── storage/              # 本地持久化存储
│   │   ├── api_client/           # HTTP REST API 客户端
│   │   ├── ws_client/            # WebSocket 客户端（自动重连）
│   │   ├── study/               # 挖矿引擎（任务处理、统计）
│   │   └── proxy/                # 代理管理（预留）
│   ├── pkg/libstudy/            # FFI 库导出到 C
│   └── go.mod
├── apps/
│   ├── desktop/                  # Flutter 桌面应用
│   │   └── flutter_app/
│   ├── android/                  # Android 原生壳
│   └── ios/                      # iOS 原生壳
├── plugins/                      # 编译输出目录
│   ├── linux/
│   ├── macos/
│   ├── windows/
│   └── android/
├── scripts/                      # 构建和部署脚本
├── docs/                         # 架构和设计文档
└── README.md
```

## 编译命令

### 编译所有平台的 Go 核心库
```bash
cd scripts
./build_go_libs.sh
```

将编译的 `.so`（Linux/Android）、`.dylib`（macOS）和 `.dll`（Windows）文件输出到 `plugins/` 目录。

### 编译单个平台库

**Linux x64**
```bash
cd core
GOOS=linux GOARCH=amd64 go build -buildmode=c-shared -o ../plugins/linux/libstudy.so ./pkg/libstudy
```

**macOS ARM64**
```bash
GOOS=darwin GOARCH=arm64 go build -buildmode=c-shared -o ../plugins/macos/libstudy.dylib ./pkg/libstudy
```

**Windows x64**
```bash
GOOS=windows GOARCH=amd64 go build -buildmode=c-shared -o ../plugins/windows/libstudy.dll ./pkg/libstudy
```

**Android ARM64**
```bash
GOOS=android GOARCH=arm64 go build -buildmode=c-shared -o ../plugins/android/libstudy.so ./pkg/libstudy
```

### 运行 CLI 守护进程（测试用）
```bash
cd core/cmd/study_daemon
go run main.go
```

### 运行测试
```bash
cd core
go test ./...
```

## 核心架构

### 高层通信流程

```
Flutter UI（桌面/移动）
    ↓ FFI/IPC
Go 挖矿引擎
    ├─ 认证模块：管理凭证和请求签名
    ├─ 存储模块：持久化本地数据（用户、节点、令牌）
    ├─ API 客户端：带自动签名/认证头的 HTTP 请求
    ├─ WebSocket 客户端：Socket.io 长连接，带自动重连
    └─ 挖矿引擎：任务执行、性能测量、结果上报
    ↓ 网络
ARO 后端（REST API & WebSocket）
```

### 关键模块说明

#### `core/internal/auth/` - 认证与签名
- 使用客户端 ID、时间戳和 HMAC 签名生成 Bearer 令牌
- 连接前验证凭证
- 管理请求中的认证状态

#### `core/internal/storage/` - 本地数据持久化
- 使用 `sync.RWMutex` 实现的线程安全存储
- 存储用户凭证、节点 ID、访问令牌、连接状态
- 持久化挖矿统计和状态

#### `core/internal/api_client/` - HTTP 客户端
- 使用自动授权头包装标准 HTTP 请求
- 支持 GET、POST、PUT、DELETE 操作
- 处理 JSON 序列化/反序列化
- 用于节点注册、TURN 服务器查询、启动命令

#### `core/internal/ws_client/` - WebSocket 客户端
- Socket.io 协议实现
- 自动重连逻辑（最多 5 次重试，指数退避）
- 心跳机制（每 3 分钟）
- 基于事件的消息处理（auth、ping、pong、task、result、disconnect）

#### `core/internal/study/` - 挖矿引擎
- 处理通过 WebSocket 接收的挖矿任务
- 维护挖矿统计（速度、运行时间、成功率）
- 向服务器报告结果
- 管理连接状态（idle、connecting、connected、forbidden）

#### `core/pkg/libstudy/` - FFI/CGO 接口
- 导出的 C 函数可从 Flutter 通过 FFI 调用
- 桥接 Go 引擎和 Flutter UI
- 在 Dart 类型和 Go 结构之间进行转换

### 数据流示例

**初始化流程**
```
Flutter: SetUserInfo() → IPC → Go: StoreUserInfo()
Flutter: SetNodeInfo() → IPC → Go: StoreNodeInfo()
Flutter: StartMining() → IPC → Go: ConnectWebSocket() + BeginMiningLoop()
```

**WebSocket 连接流程**
```
Go: Connect(auth)
    → 建立 WebSocket 连接
    → 发送认证信息
    → 服务器响应 "auth" 事件（分配的 IP）
    → 启动 3 分钟心跳计时器
    → 监听 task/ping 事件
    → 断开连接时自动重连
```

**挖矿任务流程**
```
WebSocket: "task" 事件（包含挖矿参数）
    → Go: ParseTask()
    → Go: ExecuteMiningLogic()
    → Go: MeasurePerformance()
    → WebSocket: 发送 "result" 事件
    → 服务器: 确认
```

## 重要的开发模式

### 线程安全性
所有共享数据结构都使用 `sync.RWMutex` 实现线程安全访问：
- 读操作使用 `RLock()` / `RUnlock()`
- 写操作使用 `Lock()` / `Unlock()`
- 确保多个 goroutine 的并发访问安全

### 错误处理
- 使用标准 Go 错误包装：`fmt.Errorf("context: %w", err)`
- 通过字符串编码从 FFI 函数返回错误（C 兼容性）
- 使用适当的前缀记录错误以便调试

### WebSocket 连接状态
引擎使用四种连接状态：
- `idle` - 未连接，准备连接
- `connecting` - 活跃连接尝试
- `connected` - 成功连接，可正常工作
- `forbidden` - IP 受限，无法继续

### 认证机制
请求使用以下方式签名：
```
auth = "aro:{clientId}:{timestamp}:{signature}"
token = base64(auth)
Authorization: "Bearer {token}"
```

## 配置

环境变量（在启动 Go 引擎前设置）：
- `API_BASE` - REST API 端点（默认：`https://testnet-api.aro.network`）
- `WS_URL` - WebSocket 端点（默认：`https://testnet-ws.aro.network`）

这些通常从 Flutter 传递或在环境中设置。

## 常见开发任务

### 添加新的 REST API 端点
编辑 `core/internal/api_client/client.go`：
```go
func (c *APIClient) GetNewData(id string) (map[string]interface{}, error) {
    path := fmt.Sprintf("/api/data/%s", id)
    data, err := c.Request("GET", path, nil)
    if err != nil {
        return nil, err
    }
    var result map[string]interface{}
    json.Unmarshal(data, &result)
    return result, nil
}
```

### 处理新的 WebSocket 事件
编辑 `core/internal/study/engine.go` 中的 `onWSMessage` 方法，然后添加处理程序：
```go
case "newEvent":
    m.onNewEventMessage(data)
```

### 添加本地存储
编辑 `core/internal/storage/storage.go`：
```go
// 添加字段、getter 和 setter，使用适当的互斥锁锁定
func (s *Storage) GetNewField() string {
    s.mu.RLock()
    defer s.mu.RUnlock()
    return s.newField
}
```

### 导出新的 FFI 函数
编辑 `core/pkg/libstudy/study.go`：
```go
//export NewFunction
func NewFunction(param *C.char) *C.char {
    result := engine.DoSomething()
    return C.CString(result)
}
```

## 调试技巧

### 启用调试日志
在相关模块中添加条件日志：
```go
const DEBUG = true
if DEBUG {
    log.Printf("[DEBUG] message: %v", value)
}
```

### 使用 Go 调试器
```bash
dlv debug ./cmd/study_daemon
(dlv) break main.main
(dlv) continue
(dlv) print variable
```

### 常见问题

**签名验证失败**：检查认证模块中的私钥、客户端 ID 和时间戳是否正确设置。

**WebSocket 连接断开**：查看 ws_client/client.go 中的重连逻辑 - 验证 TURN 服务器配置和网络稳定性。

**挖矿结果未报告**：检查挖矿引擎是否正确编码结果 JSON 并通过 "result" 事件发送。

**IPC 通信问题**：确保 libstudy 中的 FFI 函数签名与 Flutter FFI 声明完全匹配。

## 测试策略

- **单元测试**：在 core 目录中运行 `go test ./...`
- **集成测试**：运行 CLI 守护进程并手动触发操作
- **平台特定**：在目标平台上编译和测试，因为存在平台特定的代码路径（特别是 IPC/原生集成）

## 首先需要理解的关键文件

1. `core/internal/study/engine.go` - 所有子系统的主要协调
2. `core/internal/ws_client/client.go` - 连接生命周期和重连逻辑
3. `core/internal/auth/auth.go` - 请求签名和凭证管理
4. `core/internal/api_client/client.go` - API 端点定义
5. `core/pkg/libstudy/study.go` - Flutter 的 FFI 入口点
