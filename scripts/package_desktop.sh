#!/bin/bash
# 打包桌面端安装包

set -e

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
PROJECT_ROOT="$SCRIPT_DIR/.."
DESKTOP_DIR="$PROJECT_ROOT/apps/desktop/flutter_app"

echo "📦 打包桌面端应用..."

# 1. 先编译 Go 动态库
echo "🔨 编译 Go 动态库..."
bash "$SCRIPT_DIR/build_go_libs.sh"

# 2. 进入 Flutter 项目目录
cd "$DESKTOP_DIR"

# 3. 获取依赖
echo "📥 获取 Flutter 依赖..."
flutter pub get

# 4. 为不同平台构建
echo "🔨 构建 Linux 版本..."
flutter build linux --release

echo "🔨 构建 Windows 版本..."
flutter build windows --release

echo "🔨 构建 macOS 版本..."
flutter build macos --release

echo "✅ 所有平台构建完成！"
echo "输出文件："
echo "  - Linux: build/linux/x64/release/bundle/"
echo "  - Windows: build/windows/x64/runner/Release/"
echo "  - macOS: build/macos/Build/Products/Release/"
