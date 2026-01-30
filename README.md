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

### 构建依赖（Linux 环境）

在 Linux 系统下本地构建不同平台的动态库，需要安装以下依赖：

#### 1. Linux 构建（原生）
无需额外依赖，使用系统自带的 GCC 即可。

#### 2. Windows 构建
需要安装 MinGW-w64 交叉编译工具链：

```bash
# Ubuntu/Debian
sudo apt-get update
sudo apt-get install -y gcc-mingw-w64-x86-64

# 验证安装
x86_64-w64-mingw32-gcc --version
```

#### 3. macOS 构建
需要安装 OSXCross 工具链（从 Xcode SDK 提取的交叉编译工具）：

```bash
# 1. 克隆 OSXCross
git clone https://github.com/tpoechtrager/osxcross
cd osxcross

# 2. 下载 MacOSX SDK（需要 Apple 账号或从 Xcode 提取）
# 方法一：从公开源下载
wget -nc https://github.com/joseluisq/macosx-sdks/releases/download/12.3/MacOSX12.3.sdk.tar.xz
mv MacOSX12.3.sdk.tar.xz tarballs/

# 3. 构建工具链
UNATTENDED=yes ./build.sh

# 4. 设置环境变量
export OSXCROSS_ROOT=$(pwd)
echo 'export OSXCROSS_ROOT=/path/to/osxcross' >> ~/.bashrc
```

**注意**：macOS 构建也可以在 macOS 原生系统上进行，只需安装 Xcode Command Line Tools：
```bash
xcode-select --install
```

#### 4. Android 构建
需要安装 Android NDK：

**方法一：使用 Android SDK Manager（推荐）**
```bash
# 下载 Android Command Line Tools
cd ~
wget https://dl.google.com/android/repository/commandlinetools-linux-9477386_latest.zip
unzip commandlinetools-linux-9477386_latest.zip -d android-sdk
mkdir -p android-sdk/cmdline-tools/latest
mv android-sdk/cmdline-tools/{bin,lib,NOTICE.txt,source.properties} android-sdk/cmdline-tools/latest/

# 安装 NDK
export ANDROID_HOME=~/android-sdk
export PATH=$PATH:$ANDROID_HOME/cmdline-tools/latest/bin
sdkmanager --install "ndk;25.2.9519653"

# 设置环境变量
export ANDROID_NDK_ROOT=~/android-sdk/ndk/25.2.9519653
echo 'export ANDROID_NDK_ROOT=~/android-sdk/ndk/25.2.9519653' >> ~/.bashrc
```

**方法二：直接下载 NDK**
```bash
cd ~
wget https://dl.google.com/android/repository/android-ndk-r25c-linux.zip
unzip android-ndk-r25c-linux.zip
export ANDROID_NDK_ROOT=~/android-ndk-r25c
echo 'export ANDROID_NDK_ROOT=~/android-ndk-r25c' >> ~/.bashrc
```

### 编译 Go 核心模块

#### 使用构建脚本（推荐）

```bash
# 构建所有平台（会自动跳过缺少依赖的平台）
./scripts/build.sh local

# 仅构建 Linux
./scripts/build_go_libs.sh build-linux

# 仅构建 Windows（需要先安装 MinGW-w64）
./scripts/build_go_libs.sh build-windows

# 仅构建 macOS（需要先配置 OSXCross 或在 macOS 上运行）
OSXCROSS_ROOT=/path/to/osxcross ./scripts/build_go_libs.sh build-macos

# 仅构建 Android（需要先安装 NDK）
ANDROID_NDK_ROOT=/path/to/ndk ./scripts/build_go_libs.sh build-android
```

#### 手动编译单个平台

```bash
cd core/pkg/libstudy

# Linux
CGO_ENABLED=1 GOOS=linux GOARCH=amd64 go build \
  -buildmode=c-shared \
  -ldflags="-s -w" \
  -o ../../../plugins/linux/libstudy.so .

# Windows
CC=x86_64-w64-mingw32-gcc CGO_ENABLED=1 GOOS=windows GOARCH=amd64 go build \
  -buildmode=c-shared \
  -ldflags="-s -w" \
  -o ../../../plugins/windows/libstudy.dll .

# macOS（在 macOS 系统上）
CGO_ENABLED=1 GOOS=darwin GOARCH=arm64 go build \
  -buildmode=c-shared \
  -ldflags="-s -w" \
  -o ../../../plugins/macos/libstudy.dylib .
```

### 构建产物说明

构建完成后，动态库文件位于 `plugins/` 目录：

```
plugins/
├── linux/libstudy_0.0.1_linux_amd64.so       # ~24MB（已优化）
├── windows/libstudy_0.0.1_windows_amd64.dll   # ~22MB
├── macos/libstudy_0.0.1_darwin_arm64.dylib    # ARM64 版本
├── macos/libstudy_0.0.1_darwin_amd64.dylib    # Intel 版本
└── android/libstudy_0.0.1_android_arm64.so    # ~22MB
```

**优化说明**：使用 `-ldflags="-s -w"` 参数可去除调试符号，减少约 25-30% 的文件大小



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


