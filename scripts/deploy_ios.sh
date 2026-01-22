#!/bin/bash
# iOS 专用构建脚本（含 NE 签名和部署）

set -e

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
PROJECT_ROOT="$SCRIPT_DIR/.."
IOS_DIR="$PROJECT_ROOT/apps/ios"

echo "🍎 iOS 构建与部署..."

# 1. 编译 Go 动态库
echo "🔨 编译 iOS Go 动态库..."
cd "$PROJECT_ROOT/core"
GOOS=ios GOARCH=arm64 go build -buildmode=c-shared -o "$IOS_DIR/Frameworks/libstudy.framework/libstudy" ./pkg/libstudy

# 2. 构建 Flutter iOS
echo "📱 构建 Flutter iOS..."
cd "$IOS_DIR/Runner"
flutter build ios --release

# 3. 签名 Network Extension Target
echo "🔐 签名 Network Extension..."
# 需要配置 Xcode Team ID 和证书
# xcode-select -p  # 检查 Xcode 路径

# 4. 构建 iOS 应用包
echo "📦 构建 iOS 应用包..."
# 使用 Xcode 构建
xcodebuild -workspace Runner.xcworkspace \
  -scheme Runner \
  -configuration Release \
  -derivedDataPath build \
  -arch arm64 \
  -sdk iphoneos

echo "✅ iOS 构建完成！"
echo "输出文件: build/Release-iphoneos/"

# 可选：生成 IPA 文件
# xcodebuild -exportArchive -archivePath build/Release.xcarchive \
#   -exportOptionsPlist ExportOptions.plist \
#   -exportPath build/
