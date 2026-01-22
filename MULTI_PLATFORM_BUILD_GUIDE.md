# 🌍 完整的多平台编译解决方案

## 概述

aro-ext-app Go 核心提供了 **3 种编译方式**，可以编译 Linux、Windows、macOS 和 Android 的动态库：

1. **本地编译** - 快速，编译当前平台和支持的交叉编译目标
2. **Docker 编译** - 完整，在容器中编译所有平台
3. **GitHub Actions** - 自动化，每次提交自动编译所有平台

---

## 🚀 快速开始

### 方式 1️⃣: 本地编译（推荐新手）

**最简单、最快**

```bash
cd /opt/xinyun/web/aro-ext-app
bash scripts/build.sh local
```

**特点**:
- ✅ 快速（几秒钟）
- ✅ 无需 Docker
- ✅ 自动检测支持的平台
- ⚠️ 只能编译当前系统支持的平台

**支持的平台**:
- Linux: ✅ (原生)
- Windows: ✅ (如果装了 MinGW)
- macOS: ✅ (在 macOS 上)
- Android: ✅ (如果配置了 NDK)

---

### 方式 2️⃣: Docker 编译（推荐生产）

**编译所有平台，一条命令**

```bash
cd /opt/xinyun/web/aro-ext-app
bash scripts/build.sh docker
```

**前置条件**:
```bash
# 安装 Docker
# macOS/Windows: https://www.docker.com/products/docker-desktop
# Linux: sudo apt install docker.io
```

**特点**:
- ✅ 编译所有 4 个平台
- ✅ 无需安装各平台工具
- ✅ 完全隔离，不影响系统
- ⚠️ 第一次运行较慢（下载镜像）

**支持的平台**:
- Linux x64: ✅
- Windows x64: ✅
- macOS ARM64/x64: ✅
- Android ARM64: ✅

---

### 方式 3️⃣: GitHub Actions（推荐团队）

**自动化编译，每次提交都编译所有平台**

1. 推送代码到 GitHub
2. GitHub Actions 自动编译所有平台
3. 编译结果作为 Release 发布

```bash
# 无需本地操作，所有都在 GitHub 上自动运行
git push origin main
```

**工作流文件**: `.github/workflows/build.yml`

---

## 📊 编译方式对比

| 特性 | 本地编译 | Docker | GitHub Actions |
|------|---------|--------|-----------------|
| **速度** | ⚡ 快 | ⏱️ 中等 | ⏱️ 中等 |
| **设置难度** | 简单 | 中等 | 简单 |
| **支持平台** | 当前系统 + 交叉 | 全部 | 全部 |
| **系统依赖** | 必需 | Docker | 无 |
| **编译时间** | 5-10 秒 | 2-5 分钟 | 10-15 分钟 |
| **适用场景** | 开发/测试 | 本地生产 | CI/CD 自动化 |

---

## 详细指南

### 本地编译

#### 第一步：检查环境

```bash
bash scripts/check_compilers.sh
```

输出示例：
```
✅ Linux x64: 可编译
⚠️  Windows x64: 需要 MinGW
⚠️  macOS: 需要 Xcode 命令行工具
⚠️  Android ARM64: 需要 Android NDK
```

#### 第二步：安装缺失的工具（可选）

**如果想编译其他平台，需要安装对应工具**

**在 macOS 上**:
```bash
# macOS 开发工具
xcode-select --install

# Windows 交叉编译
brew install mingw-w64

# Android NDK（可选）
brew install android-ndk
```

**在 Linux 上**:
```bash
# Windows 交叉编译
sudo apt install mingw-w64

# Android NDK（可选）
# 通过 Android Studio 或手动下载
export ANDROID_NDK_ROOT=/path/to/ndk
```

#### 第三步：编译

```bash
bash scripts/build.sh local
```

输出示例：
```
🔨 本地编译模式（快速）
📦 编译 Linux x64...
   ✅ Linux x64 编译完成
⚠️  macOS 编译器 (clang/Xcode) 未找到，跳过 macOS 编译
⚠️  Windows 编译器 (MinGW) 未找到，跳过 Windows 编译
...
✅ 编译完成！
```

---

### Docker 编译

#### 第一步：安装 Docker

**macOS/Windows**:
1. 下载 [Docker Desktop](https://www.docker.com/products/docker-desktop)
2. 安装并启动
3. 验证: `docker --version`

**Linux**:
```bash
sudo apt install docker.io
sudo usermod -aG docker $USER  # 添加当前用户到 docker 组
# 退出并重新登录
```

#### 第二步：运行编译

```bash
cd /opt/xinyun/web/aro-ext-app
bash scripts/build.sh docker
```

**首次运行注意事项**:
- 需要下载 Go 镜像（约 500MB）
- 需要下载 Android NDK（约 500MB）
- 总耗时：3-10 分钟（取决于网络）

#### 第三步：检查输出

```bash
# 查看所有生成的库
ls -lh plugins/*/libstudy.*

# 输出:
# plugins/linux/libstudy.so (9.2 MB)
# plugins/windows/libstudy.dll (9.3 MB)
# plugins/macos/libstudy.dylib (8.5 MB)
# plugins/android/libstudy.so (8.8 MB)
```

---

### GitHub Actions 自动化

#### 第一步：将代码推送到 GitHub

```bash
git remote add origin https://github.com/your-org/aro-ext-app.git
git push -u origin main
```

#### 第二步：查看自动编译

1. 访问 GitHub 仓库
2. 点击 **Actions** 选项卡
3. 查看运行中的 **Cross-Platform Build** 工作流

#### 第三步：下载编译结果

**方式 A: 从 Actions 中下载**
1. 点击完成的工作流
2. 向下滚动到 **Artifacts**
3. 下载各平台的库

**方式 B: 从 Release 下载**
```bash
# 创建 Git 标签来触发 Release 创建
git tag v1.0.0
git push origin v1.0.0

# 结果会自动发布到 Releases 页面
```

---

## 编译结果

### 输出文件结构

```
plugins/
├── linux/
│   ├── libstudy.so         (9.2 MB, ELF 64-bit)
│   └── libstudy.h          (C 头文件)
├── windows/
│   ├── libstudy.dll        (9.3 MB, PE 32-bit)
│   └── libstudy.h
├── macos/
│   ├── libstudy.dylib      (8.5 MB, Mach-O ARM64)
│   ├── libstudy_x64.dylib  (8.7 MB, Mach-O x64)
│   └── libstudy.h
└── android/
    ├── libstudy.so         (8.8 MB, ELF ARM64)
    └── libstudy.h
```

### 验证编译结果

```bash
# 检查文件格式
file plugins/linux/libstudy.so
# 输出: ELF 64-bit LSB shared object, x86-64

file plugins/windows/libstudy.dll
# 输出: PE32+ executable (DLL), x86-64

file plugins/macos/libstudy.dylib
# 输出: Mach-O 64-bit dynamically linked shared library arm64

file plugins/android/libstudy.so
# 输出: ELF 64-bit LSB shared object (not stripped), ARM aarch64
```

---

## 故障排除

### Docker 编译失败

**错误**: `Cannot connect to Docker daemon`

```bash
# 解决方案：启动 Docker
docker run hello-world

# 如果仍失败：
sudo systemctl start docker  # Linux
# 或重启 Docker Desktop      # macOS/Windows
```

**错误**: `Permission denied while trying to connect to Docker daemon`

```bash
# Linux 用户需要添加到 docker 组
sudo usermod -aG docker $USER
newgrp docker
```

### 本地编译失败

**错误**: `compiler not found`

```bash
# 检查环境
bash scripts/check_compilers.sh

# 根据提示安装缺失的工具
# 详见 CROSS_PLATFORM_BUILD_GUIDE.md
```

### 快速修复

```bash
# 清空编译缓存并重新编译
cd core
go clean -cache
cd ..
bash scripts/build.sh local
```

---

## 脚本参考

### build.sh - 统一编译脚本

```bash
# 自动选择方法（推荐）
bash scripts/build.sh

# 本地编译
bash scripts/build.sh local

# Docker 编译
bash scripts/build.sh docker

# CI 模式
bash scripts/build.sh ci

# 检查环境
bash scripts/build.sh check

# 帮助
bash scripts/build.sh help
```

### build_go_libs.sh - 本地编译脚本

```bash
# 直接编译当前平台支持的所有目标
bash scripts/build_go_libs.sh
```

### build_with_docker.sh - Docker 编译脚本

```bash
# 使用 Docker 编译所有平台
bash scripts/build_with_docker.sh
```

---

## 集成到 CI/CD

### GitHub Actions

工作流已配置，每次提交自动编译所有平台。

**工作流文件**: `.github/workflows/build.yml`

**自定义**:
```yaml
on:
  push:
    paths:
      - 'core/**'        # 只在 core 目录有改动时编译
      - '.github/workflows/build.yml'
```

### GitLab CI

```yaml
stages:
  - build

build:linux:
  stage: build
  image: golang:1.25-alpine
  before_script:
    - apk add --no-cache gcc musl-dev
  script:
    - cd core
    - CGO_ENABLED=1 GOOS=linux GOARCH=amd64 go build -buildmode=c-shared -o ../plugins/linux/libstudy.so ./pkg/libstudy
  artifacts:
    paths:
      - plugins/linux/

build:windows:
  stage: build
  image: golang:1.25-alpine
  before_script:
    - apk add --no-cache mingw-w64-gcc
  script:
    - cd core
    - CC=x86_64-w64-mingw32-gcc CGO_ENABLED=1 GOOS=windows GOARCH=amd64 go build -buildmode=c-shared -o ../plugins/windows/libstudy.dll ./pkg/libstudy
  artifacts:
    paths:
      - plugins/windows/
```

---

## 最佳实践

### 开发阶段
```bash
# 快速本地编译测试
bash scripts/build.sh local
```

### 发布前
```bash
# Docker 编译所有平台确保兼容性
bash scripts/build.sh docker
```

### 自动化（推荐）
```bash
# 让 GitHub Actions 自动编译
git push origin main
# → 自动编译所有平台
# → 附加到 Release 中
```

---

## 下一步

1. ✅ 选择编译方式（本地/Docker/GitHub Actions）
2. ✅ 运行编译: `bash scripts/build.sh`
3. ✅ 验证输出: `ls -lh plugins/*/libstudy.*`
4. ✅ 集成到前端应用

---

## 常见问题

**Q: 我应该选择哪种编译方式？**

A: 根据您的场景：
- **开发测试**: 本地编译（快速）
- **本地生产**: Docker 编译（完整）
- **团队项目**: GitHub Actions（自动化）

**Q: Docker 编译会改变我的系统吗？**

A: 不会。Docker 完全隔离，不会安装任何系统级依赖。

**Q: 如何加速编译？**

A: 
- 使用本地编译（最快）
- Docker 第一次运行后会缓存镜像，后续编译更快
- GitHub Actions 有并行编译，最高效

**Q: 支持其他架构吗？**

A: 可以修改脚本添加：
- ARMv7: `GOARCH=arm`
- ARM64: `GOARCH=arm64`
- x86: `GOARCH=386`
- MIPS: `GOARCH=mips`

---

**Status**: ✅ **完全支持多平台编译**  
**建议**: 🐳 **使用 Docker 方案获得最佳体验**
