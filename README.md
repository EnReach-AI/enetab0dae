# aro-ext-app

多端挖矿客户端工程，支持桌面端（Windows/macOS/Linux）与移动端（Android/iOS）。

## 项目结构

```
aro-ext-app/
├── apps/                  # 各平台入口（Flutter 封装）
│   ├── desktop/          # 桌面端应用
│   ├── android/          # Android 原生壳
│   └── ios/              # iOS 原生壳（含 NetworkExtension）
├── core/                 # 挖矿核心逻辑（Go）
│   ├── cmd/              # CLI 程序入口
│   ├── internal/         # 内部实现
│   │   ├── auth.go       # 认证与签名
│   │   ├── storage.go    # 本地存储
│   │   ├── api_client/   # API 客户端
│   │   ├── ws_client/    # WebSocket 客户端
│   │   ├── study/       # 挖矿引擎
│   │   └── proxy/        # 代理（预留）
│   └── pkg/libstudy/    # FFI 接口（供 Flutter 调用）
├── plugins/              # 动态库输出
│   ├── windows/
│   ├── macos/
│   ├── linux/
│   └── android/
├── scripts/              # 构建与部署脚本
├── infra/                # 基础设施
├── docs/                 # 设计文档
└── README.md
```

## 核心功能

### 1. 身份认证与授权
- 用户登录/退出管理
- ACCESS_TOKEN 存储与刷新
- 基于私钥的请求签名

### 2. 节点管理
- 节点注册与ID生成
- 节点密钥对管理
- IP 地址获取与验证
- 节点在线状态查询

### 3. WebSocket 连接
- Socket.io 长连接维护
- 自动心跳检测（3分钟间隔）
- 5次自动重连机制
- 连接状态管理（idle/connecting/connected/forbidden）

### 4. 挖矿功能
- 挖矿任务分发与执行
- P2P 连接（基于 PeerJS）
- TURN 服务器配置
- 流量转发与优化
- 实时速度测量
- 挖矿统计与上报


## 快速开始

### 编译 Go 核心模块

```bash
cd core
go build -buildmode=c-shared -o ../plugins/linux/libstudy.so ./pkg/libstudy
```



## API 接口

### WebSocket 事件

- `auth` - 认证成功，接收分配的 IP
- `ping` - 心跳请求
- `pong` - 心跳响应
- `task` - 挖矿任务
- `result` - 上报挖矿结果

## 配置

环境变量：
- `API_BASE`: API 服务地址（默认：https://testnet-api.aro.network）
- `WS_URL`: WebSocket 服务地址（默认：https://testnet-ws.aro.network）


