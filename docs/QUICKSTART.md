# 快速开始指南

## 环境要求

- Go 1.21+
- Flutter SDK 3.0+（用于桌面和移动应用）
- 各平台开发工具：
  - Linux: GCC, Make
  - macOS: Xcode
  - Windows: Visual Studio / MinGW
  - Android: Android SDK, NDK
  - iOS: Xcode

## 安装依赖

### Go 依赖

```bash
cd core
go mod download
```

### 编译 Go 动态库

```bash
# Linux
GOOS=linux GOARCH=amd64 go build -buildmode=c-shared -o ../plugins/linux/libstudy.so ./pkg/libstudy

# macOS
GOOS=darwin GOARCH=arm64 go build -buildmode=c-shared -o ../plugins/macos/libstudy.dylib ./pkg/libstudy

# Windows
GOOS=windows GOARCH=amd64 go build -buildmode=c-shared -o ../plugins/windows/libstudy.dll ./pkg/libstudy
```

或使用便捷脚本：

```bash
chmod +x scripts/build_go_libs.sh
./scripts/build_go_libs.sh
```

## 后端交互设置

### 密钥对初始化

```bash
cd core/cmd/study_daemon

# 生成 RSA 密钥对 (2048-bit)
go run main.go actions.go ipc.go -action=init -keydir=.

# 查看公钥
cat aro_rsa.pub
```

**输出示例**:
```
✅ 密钥对已生成
公钥:
-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA...
-----END PUBLIC KEY-----
```

### 节点注册

```bash
# 向后端注册节点，获取序列号
go run main.go actions.go ipc.go \
    -action=register \
    -client=my-node-001 \
    -keydir=.
```

**输出示例**:
```
✅ 注册成功，序列号: LITEARO1L9NMAUHA
```

### 启动挖矿

```bash
# 启动挖矿服务（自动初始化密钥对和注册节点）
go run main.go actions.go ipc.go \
    -action=start \
    -client=my-node-001 \
    -keydir=.
```

### 检查状态

```bash
go run main.go actions.go ipc.go -action=status
```

## 运行 CLI 程序

### 初始化

```bash
cd core/cmd/study_daemon
go run main.go actions.go ipc.go -action=init
```

### 启动挖矿

```bash
go run main.go ipc.go -action=start
```

### 查看状态

```bash
go run main.go ipc.go -action=status
```

### 停止挖矿

```bash
go run main.go ipc.go -action=stop
```

## 构建 Flutter 应用

### 桌面应用

#### Linux

```bash
cd apps/desktop/flutter_app
flutter pub get
flutter build linux --release
```

输出目录：`build/linux/x64/release/bundle/`

#### macOS

```bash
flutter pub get
flutter build macos --release
```

输出目录：`build/macos/Build/Products/Release/`

#### Windows

```bash
flutter pub get
flutter build windows --release
```

输出目录：`build/windows/x64/runner/Release/`

### 移动应用

#### Android

```bash
cd apps/android
flutter pub get
flutter build apk --release
```

输出：`build/app/outputs/apk/release/app-release.apk`

#### iOS

```bash
cd apps/ios/Runner
flutter pub get
flutter build ios --release
```

输出目录：`build/ios/iphoneos/`

## 配置

### 环境变量

```bash
export API_BASE=https://testnet-api.aro.network
export WS_URL=https://testnet-ws.aro.network
```

### 配置文件（可选）

在项目根目录创建 `config.json`：

```json
{
  "apiBase": "https://testnet-api.aro.network",
  "wsUrl": "https://testnet-ws.aro.network",
  "environment": "testnet"
}
```

## 调试

### 启用详细日志

```bash
# 在代码中设置
log.SetFlags(log.LstdFlags | log.Lshortfile)
```

### 使用 Go 调试器

```bash
# 使用 dlv (Delve) 调试
go install github.com/go-delve/delve/cmd/dlv@latest

dlv debug ./cmd/study_daemon
```

## API 调用示例

### Go 代码调用 API

```go
package main

import (
    "fmt"
    "aro-ext-app/core/internal/api_client"
    "aro-ext-app/core/internal/crypto"
)

func main() {
    // 加载密钥对
    keyPair, err := crypto.LoadKeyPairFromFile(".")
    if err != nil {
        panic(err)
    }
    
    // 创建 API 客户端
    client := api_client.NewAPIClient(
        "https://testnet-api.aro.network",
        "my-node-001",
        keyPair.PrivateKey,
    )
    
    // 注册节点
    resp, err := client.RegisterNode()
    if err != nil {
        panic(err)
    }
    
    fmt.Printf("Code: %d\n", resp.Code)
    fmt.Printf("Message: %s\n", resp.Message)
    if serialNumber, ok := resp.Data["serialNumber"].(string); ok {
        fmt.Printf("Serial Number: %s\n", serialNumber)
    }
}
```

### Flutter FFI 调用

```dart
import 'services/study_service.dart';

void main() async {
    final service = MiningService();
    
    // 初始化服务
    await service.initialize(
        libPath: 'libstudy.so',
        apiUrl: 'https://testnet-api.aro.network',
        wsUrl: 'https://testnet-ws.aro.network',
    );
    
    // 注册节点
    final response = await service.registerNode('my-node-001');
    if (response != null) {
        print('Serial Number: ${response.serialNumber}');
    }
    
    // 启动挖矿
    await service.startMining();
    
    // 监听统计信息
    service.statsStream.listen((event) {
        print('Hashrate: ${event.stats.hashrate} H/s');
    });
}
```

## 环境配置

### 测试网

默认配置（可在代码中修改）：
- **API URL**: https://testnet-api.aro.network
- **WebSocket URL**: https://testnet-ws.aro.network

### 主网

修改配置：

```go
// Go 代码
client := api_client.NewAPIClient(
    "https://api.aro.network",           // 主网 API
    "my-node-001",
    keyPair.PrivateKey,
)
client.SetWSURL("https://ws.aro.network") // 主网 WebSocket
```

```dart
// Dart 代码
await service.initialize(
    libPath: 'libstudy.so',
    apiUrl: 'https://api.aro.network',     // 主网 API
    wsUrl: 'https://ws.aro.network'        // 主网 WebSocket
);
```

## 文件和文档

- [Backend API 文档](./BACKEND_API.md) - 详细的 API 参考和各端点说明
- [Flutter FFI 集成指南](./FLUTTER_FFI_INTEGRATION.md) - FFI 完整集成和编译说明
- [Go 源代码](../core) - 核心库源代码和架构设计

## 常见问题

### Q: 如何更改 API 端点？

A: 通过命令行参数或代码配置：

```bash
# CLI
go run main.go actions.go -action=start \
    -client=my-node \
    -keydir=. \
    -api=https://api.aro.network
```

### Q: 密钥对丢失如何恢复？

A: 重新初始化会生成新的密钥对：

```bash
go run main.go actions.go -action=init -keydir=.
```

**警告**: 这会覆盖现有密钥，旧节点数据将无法使用。

### Q: 挖矿时 API 调用失败？

A: 检查项：
1. 网络连接是否正常
2. API URL 是否正确
3. 系统时间是否准确（对签名验证很重要）
4. 密钥对是否正确初始化

### Q: 如何查看详细日志？

A: 使用日志重定向：

```bash
go run main.go actions.go -action=start \
    -client=my-node-001 \
    -keydir=. > study.log 2>&1 &
tail -f study.log
```

## 获取帮助

- 查看完整的 [Backend API 文档](./BACKEND_API.md)
- 查看 [Flutter FFI 集成指南](./FLUTTER_FFI_INTEGRATION.md)
- 检查日志输出中的错误信息
- 验证密钥对和系统时间

### Flutter 调试

```bash
# 开启调试模式
flutter run -v

# 连接到正在运行的应用
flutter attach
```

## 常见问题

### Q: 编译时出现 "undefined reference"

**A**: 确保 Go 环境变量设置正确：

```bash
go env
# 检查 GOOS, GOARCH 等是否符合预期
```

### Q: WebSocket 连接失败

**A**: 

1. 检查网络连接
2. 验证 API 和 WebSocket 服务地址是否正确
3. 查看日志获取详细错误信息

### Q: Flutter 编译失败

**A**: 清理构建并重试：

```bash
flutter clean
flutter pub get
flutter build <platform>
```

### Q: FFI 符号找不到

**A**: 确保：

1. Go 库已正确编译（检查是否生成了 .so/.dll/.dylib 文件）
2. Flutter 项目的 pubspec.yaml 中配置了正确的库路径
3. 库文件权限正确（Unix系统需要可执行权限）

## 下一步

- 参考 [架构设计](ARCHITECTURE.md) 了解系统架构
- 参考 [API 文档](API.md) 了解 API 细节
- 参考 [开发指南](DEVELOPMENT.md) 进行开发
