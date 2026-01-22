# 配置系统快速开始

## 概述

本配置系统为 ARO 项目的五个客户端（Go、Flutter、Web、macOS、Android）提供统一的配置管理方案。

## 特点

✅ **统一格式**：所有客户端使用相同的 `key=value` 配置格式  
✅ **跨平台**：支持 Linux、macOS、Windows、iOS、Android  
✅ **优先级管理**：环境变量 > 文件 > 默认配置  
✅ **类型支持**：字符串、整数、布尔值  
✅ **单例模式**：确保全局唯一配置实例  
✅ **线程安全**：支持并发读写（Go 实现）  
✅ **不通过 dylib 暴露**：配置系统独立，与动态库解耦  

## 快速集成

### 1. Go 后端

```go
import "aro-ext-app/core/internal/config"

func init() {
    cfg := config.GetConfig()
    apiURL := cfg.Get(config.KeyAPIURL)
    wsURL := cfg.Get(config.KeyWSURL)
}
```

### 2. Flutter（iOS/Android）

复制 `clients/flutter/config_service.dart` 到你的项目：

```dart
final config = ConfigService();
await config.initialize();

final apiUrl = config.get('API_URL');
final timeout = config.getInt('TIMEOUT');
```

### 3. Web（React/Vue/Angular）

复制 `clients/web/configManager.ts` 到你的项目：

```typescript
const config = ConfigManager.getInstance();
const apiUrl = config.get('API_URL');
const debug = config.getBool('DEBUG');
```

### 4. macOS

复制 `clients/macos/ConfigManager.swift` 到你的项目：

```swift
let apiUrl = ConfigManager.shared.get("API_URL")
let timeout = ConfigManager.shared.getInt("TIMEOUT")
```

### 5. Android

复制 `clients/android/ConfigManager.kt` 到你的项目：

```kotlin
val config = ConfigManager.getInstance(context)
val apiUrl = config.get("API_URL")
val timeout = config.getInt("TIMEOUT")
```

## 配置文件位置

系统会按以下优先级查找配置文件（从高到低）：

1. **环境变量** (最高)
   ```bash
   export API_URL=https://api.example.com
   export DEBUG=true
   ```

2. **.env** 文件（当前目录）
   ```
   API_URL=https://testnet-api.aro.network
   DEBUG=false
   ```

3. **config.env** 文件（当前目录）

4. **用户主目录**
   - Linux: `~/.config/aro/config.env`
   - macOS: `~/.aro/config.env`
   - Windows: `%APPDATA%\ARO\config.env`

5. **系统特定位置**
   - macOS: `~/Library/Application Support/ARO/config.env`

6. **默认配置** (最低)

## 配置文件示例

创建 `.env` 或 `config.env` 文件：

```bash
# API 服务器配置
API_URL=https://testnet-api.aro.network
WS_URL=https://testnet-ws.aro.network

# 日志配置
LOG_LEVEL=info
LOG_FILE=./logs/app.log

# 网络超时和重试
TIMEOUT=30
RETRY_COUNT=3
RETRY_INTERVAL=1000

# 环境和应用信息
ENV=testnet
PROGRAM_APP=aro-ext
DEBUG=false

# 存储路径
KEYPAIR_PATH=./keys
STORAGE_PATH=./data
```

## 支持的配置项

| 配置项 | 类型 | 默认值 | 说明 |
|--------|------|-------|------|
| `API_URL` | string | https://testnet-api.aro.network | API 服务器地址 |
| `WS_URL` | string | https://testnet-ws.aro.network | WebSocket 服务器地址 |
| `LOG_LEVEL` | string | info | 日志级别（debug/info/warn/error） |
| `LOG_FILE` | string | 空 | 日志文件路径 |
| `TIMEOUT` | int | 30 | 请求超时（秒） |
| `RETRY_COUNT` | int | 3 | 重试次数 |
| `RETRY_INTERVAL` | int | 1000 | 重试间隔（毫秒） |
| `KEYPAIR_PATH` | string | . | 密钥对存储路径 |
| `STORAGE_PATH` | string | . | 本地存储路径 |
| `ENV` | string | testnet | 环境（testnet/mainnet） |
| `PROGRAM_APP` | string | aro-ext | 应用名称 |
| `DEBUG` | bool | false | 调试模式 |

## 使用 API

### Go 版本

```go
cfg := config.GetConfig()

// 获取字符串配置
apiUrl := cfg.Get("API_URL")

// 获取默认值
logLevel := cfg.Get("LOG_LEVEL", "info")

// 获取整数配置
timeout := cfg.GetInt("TIMEOUT")

// 获取布尔配置
debug := cfg.GetBool("DEBUG")

// 设置配置（仅内存）
cfg.Set("DEBUG", "true")

// 设置并保存到文件
cfg.SetAndSave("LOG_LEVEL", "debug")

// 获取所有配置
allConfig := cfg.GetAll()

// 重新加载配置
cfg.Reload()
```

### Dart/Flutter 版本

```dart
final config = ConfigService();
await config.initialize();

final apiUrl = config.get('API_URL');
final timeout = config.getInt('TIMEOUT', defaultValue: 30);
final debug = config.getBool('DEBUG', defaultValue: false);

await config.set('DEBUG', 'true', save: true);
```

### TypeScript/Web 版本

```typescript
const config = ConfigManager.getInstance();

const apiUrl = config.get('API_URL');
const timeout = config.getInt('TIMEOUT', 30);
const debug = config.getBool('DEBUG', false);

config.set('DEBUG', 'true', true);
```

## 常见任务

### 切换环境

```bash
# 使用环境变量切换
export ENV=mainnet
export API_URL=https://api.aro.network

# 或编辑配置文件
echo "ENV=mainnet" >> config.env
```

### 启用调试模式

```go
cfg := config.GetConfig()
cfg.SetAndSave(config.KeyDebug, "true")
```

### 修改 API 地址

```go
cfg := config.GetConfig()
cfg.SetAndSave(config.KeyAPIURL, "https://custom-api.example.com")
```

### 获取当前配置

```go
cfg := config.GetConfig()
for key, value := range cfg.GetAll() {
    fmt.Printf("%s=%s\n", key, value)
}
```

## 测试配置

运行配置系统测试：

```bash
cd /opt/xinyun/web/aro-ext-app/core
go test ./internal/config -v
```

## 最佳实践

1. **初始化早期**：在应用启动时立即初始化配置
2. **使用常量**：使用 `config.Key*` 常量而不是硬编码字符串
3. **验证配置**：在关键位置验证必要的配置项
4. **环境特定**：不同环境使用不同的配置文件
5. **安全敏感信息**：不要在配置文件中存储密码，改用环境变量或密钥管理系统

## 文件结构

```
core/internal/config/
├── config.go                    # 核心配置管理（Go）
├── constants.go                 # 配置常量定义
├── config_test.go               # 单元测试
├── config.example               # 配置文件示例
├── config.schema.json           # JSON Schema 定义
├── INTEGRATION_GUIDE.md         # 详细集成指南
├── README.md                    # 配置系统说明
└── clients/                     # 其他语言实现
    ├── flutter/config_service.dart
    ├── web/configManager.ts
    ├── macos/ConfigManager.swift
    └── android/ConfigManager.kt
```

## 支持和问题

- 查看 `INTEGRATION_GUIDE.md` 获取详细集成说明
- 查看 `config.example` 获取完整配置示例
- 运行 `config_test.go` 验证实现

## 许可证

MIT License - 与项目保持一致
