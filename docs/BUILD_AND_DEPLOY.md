# 编译和部署指南

## 编译 Go 库

### 前置条件

```bash
# 检查 Go 版本
go version
# 应该是 1.21 或更高版本

# 检查依赖
cd core
go mod tidy  # 更新依赖
go mod verify  # 验证依赖
```

### 对于 Linux/macOS

#### 编译为共享库 (Linux)

```bash
cd core

# 编译为 x86_64
GOOS=linux GOARCH=amd64 go build \
    -buildmode=c-shared \
    -o ../plugins/linux/libstudy.so \
    ./pkg/libstudy

# 验证编译
file ../plugins/linux/libstudy.so
# 输出: ELF 64-bit LSB shared object

# 检查导出的符号
nm -D ../plugins/linux/libstudy.so | grep -i init
# 应该看到 InitKeyPair 等函数
```

#### 编译为动态库 (macOS)

```bash
cd core

# M1/M2 芯片 (arm64)
GOOS=darwin GOARCH=arm64 go build \
    -buildmode=c-shared \
    -o ../plugins/macos/libstudy.dylib \
    ./pkg/libstudy

# Intel 芯片 (x86_64)
GOOS=darwin GOARCH=amd64 go build \
    -buildmode=c-shared \
    -o ../plugins/macos/libstudy_x86.dylib \
    ./pkg/libstudy

# 合并为通用库
lipo -create \
    ../plugins/macos/libstudy.dylib \
    ../plugins/macos/libstudy_x86.dylib \
    -output ../plugins/macos/libstudy_universal.dylib

# 验证
file ../plugins/macos/libstudy_universal.dylib
```

#### 编译为 DLL (Windows)

```bash
cd core

# 需要在 Windows 上编译或使用 MinGW
GOOS=windows GOARCH=amd64 go build \
    -buildmode=c-shared \
    -o ../plugins/windows/libstudy.dll \
    ./pkg/libstudy

# 验证
file ../plugins/windows/libstudy.dll
```

### 对于 Android

#### 使用 Go 交叉编译

```bash
cd core

# 为 arm64-v8a (主要架构)
GOOS=android GOARCH=arm64 CGO_ENABLED=1 \
    CC="${ANDROID_NDK}/toolchains/llvm/prebuilt/linux-x86_64/bin/aarch64-linux-android-gcc" \
    CXX="${ANDROID_NDK}/toolchains/llvm/prebuilt/linux-x86_64/bin/aarch64-linux-android-g++" \
    go build \
    -buildmode=c-shared \
    -o ../plugins/android/arm64-v8a/libstudy.so \
    ./pkg/libstudy

# 为 armeabi-v7a (32位支持)
GOOS=android GOARCH=arm CGO_ENABLED=1 \
    CC="${ANDROID_NDK}/toolchains/llvm/prebuilt/linux-x86_64/bin/armv7a-linux-androideabi-gcc" \
    CXX="${ANDROID_NDK}/toolchains/llvm/prebuilt/linux-x86_64/bin/armv7a-linux-androideabi-g++" \
    go build \
    -buildmode=c-shared \
    -o ../plugins/android/armeabi-v7a/libstudy.so \
    ./pkg/libstudy

# 为 x86_64 (模拟器)
GOOS=android GOARCH=amd64 CGO_ENABLED=1 \
    CC="${ANDROID_NDK}/toolchains/llvm/prebuilt/linux-x86_64/bin/x86_64-linux-android-gcc" \
    CXX="${ANDROID_NDK}/toolchains/llvm/prebuilt/linux-x86_64/bin/x86_64-linux-android-g++" \
    go build \
    -buildmode=c-shared \
    -o ../plugins/android/x86_64/libstudy.so \
    ./pkg/libstudy

# 验证编译
file ../plugins/android/arm64-v8a/libstudy.so
```

**必须设置的环境变量**:
```bash
export ANDROID_SDK_ROOT=/path/to/Android/Sdk
export ANDROID_NDK=/path/to/Android/Sdk/ndk/25.2.9519653  # 或您的 NDK 版本
```

**快速设置脚本** (save as `scripts/build_android.sh`):
```bash
#!/bin/bash
set -e

ANDROID_NDK=${ANDROID_NDK:-$ANDROID_SDK_ROOT/ndk/25.2.9519653}
cd core

echo "编译 Android arm64-v8a..."
GOOS=android GOARCH=arm64 CGO_ENABLED=1 \
    CC="$ANDROID_NDK/toolchains/llvm/prebuilt/linux-x86_64/bin/aarch64-linux-android21-clang" \
    go build -buildmode=c-shared -o ../plugins/android/arm64-v8a/libstudy.so ./pkg/libstudy

echo "编译 Android armeabi-v7a..."
GOOS=android GOARCH=arm CGO_ENABLED=1 \
    CC="$ANDROID_NDK/toolchains/llvm/prebuilt/linux-x86_64/bin/armv7a-linux-androideabi21-clang" \
    go build -buildmode=c-shared -o ../plugins/android/armeabi-v7a/libstudy.so ./pkg/libstudy

echo "✅ Android 编译完成"
```

### 对于 iOS

#### 使用 Go 交叉编译

```bash
cd core

# 为真实设备 (arm64)
GOOS=ios GOARCH=arm64 CGO_ENABLED=1 \
    CC=$(xcrun --find clang) \
    IPHONEOS_DEPLOYMENT_TARGET=11.0 \
    go build \
    -buildmode=c-archive \
    -o ../plugins/ios/libstudy_device.a \
    ./pkg/libstudy

# 为模拟器 (amd64)
GOOS=ios GOARCH=amd64 CGO_ENABLED=1 \
    CC=$(xcrun --find clang) \
    IPHONEOS_DEPLOYMENT_TARGET=11.0 \
    go build \
    -buildmode=c-archive \
    -o ../plugins/ios/libstudy_sim.a \
    ./pkg/libstudy

# 为模拟器 (arm64) - Apple Silicon
GOOS=ios GOARCH=arm64 CGO_ENABLED=1 \
    CC=$(xcrun --find clang) \
    IPHONEOS_DEPLOYMENT_TARGET=11.0 \
    go build \
    -buildmode=c-archive \
    -o ../plugins/ios/libstudy_sim_arm.a \
    ./pkg/libstudy

# 使用 lipo 合并
lipo -create \
    ../plugins/ios/libstudy_device.a \
    ../plugins/ios/libstudy_sim.a \
    -output ../plugins/ios/libstudy.a

# 验证
file ../plugins/ios/libstudy.a
# 输出: current ar archive random library
```

**快速设置脚本** (save as `scripts/build_ios.sh`):
```bash
#!/bin/bash
set -e

cd core

echo "编译 iOS 真实设备..."
GOOS=ios GOARCH=arm64 CGO_ENABLED=1 \
    go build -buildmode=c-archive \
    -o ../plugins/ios/libstudy_device.a \
    ./pkg/libstudy

echo "编译 iOS 模拟器 (Intel)..."
GOOS=ios GOARCH=amd64 CGO_ENABLED=1 \
    go build -buildmode=c-archive \
    -o ../plugins/ios/libstudy_sim.a \
    ./pkg/libstudy

echo "合并为通用库..."
lipo -create \
    ../plugins/ios/libstudy_device.a \
    ../plugins/ios/libstudy_sim.a \
    -output ../plugins/ios/libstudy.a

echo "✅ iOS 编译完成"
```

## Flutter 集成

### 1. 放置库文件

```
项目结构:
pubspec.yaml
lib/
plugins/
├── linux/
│   └── libstudy.so
├── windows/
│   └── libstudy.dll
├── macos/
│   └── libstudy.dylib
├── android/
│   ├── arm64-v8a/libstudy.so
│   └── armeabi-v7a/libstudy.so
└── ios/
    └── libstudy.a
```

### 2. 配置 pubspec.yaml

```yaml
name: aro_extension
description: ARO Extension Mining Application

dependencies:
  flutter:
    sdk: flutter
  
  # FFI 相关
  ffi: ^2.0.0
  path_provider: ^2.0.0
  
  # 其他依赖
  uuid: ^4.0.0
  intl: ^0.18.0

dev_dependencies:
  flutter_test:
    sdk: flutter
  
  ffigen: ^10.0.0

flutter:
  plugin:
    platforms:
      linux:
        ffiPlugin: true
      macos:
        ffiPlugin: true
      windows:
        ffiPlugin: true
      android:
        ffiPlugin: true
      ios:
        ffiPlugin: true
```

### 3. Linux 配置

在 `linux/CMakeLists.txt` 中添加：

```cmake
add_library(study SHARED IMPORTED)
set_target_properties(study PROPERTIES
    IMPORTED_LOCATION "${CMAKE_CURRENT_SOURCE_DIR}/../plugins/linux/libstudy.so"
)

target_link_libraries(${PLUGIN_NAME} PRIVATE study)
```

### 4. Android 配置

在 `android/build.gradle` 中配置：

```gradle
android {
    defaultConfig {
        ndk {
            abiFilters 'arm64-v8a', 'armeabi-v7a'
        }
    }
}

dependencies {
    // 添加 native 库依赖
}
```

库文件放置：
```
android/app/src/main/jniLibs/
├── arm64-v8a/libstudy.so
└── armeabi-v7a/libstudy.so
```

### 5. iOS 配置

在 Xcode 中：

1. 打开 `ios/Runner.xcodeproj`
2. 在 Build Phases 中添加 `libstudy.a`
3. 在 Build Settings 中配置链接：
   - Linked Frameworks and Libraries: 添加 libstudy.a
   - Other Linker Flags: `-lstudy`

### 6. 验证编译

```bash
# 测试编译
flutter pub get
flutter build linux    # 或 macos, windows, android, ios
```

## 部署

### 开发环境

```bash
# 清理旧的编译
flutter clean
go clean -modcache

# 编译和运行
flutter pub get
flutter run

# 在特定设备上运行
flutter run -d linux   # 或其他设备
```

### 生产环境

```bash
# Linux
flutter build linux --release

# macOS
flutter build macos --release

# Windows
flutter build windows --release

# Android
flutter build apk --release
flutter build appbundle --release  # Google Play

# iOS
flutter build ios --release
```

### 分布

#### Linux
```bash
# 创建 AppImage
cd build/linux/x64/release/bundle
# 使用 appimagetool 创建 AppImage
```

#### macOS
```bash
# 创建 DMG
flutter build macos --release
cd build/macos/Build/Products/Release
hdiutil create -volname "ARO Extension" \
    -srcfolder ./Runner.app \
    -ov -format UDZO Runner.dmg
```

#### Android
```bash
# Play Store 上传
flutter build appbundle --release
# 上传 build/app/outputs/bundle/release/app-release.aab

# 直接分发
flutter build apk --release
# 分发 build/app/outputs/flutter-apk/app-release.apk
```

#### iOS
```bash
# App Store 上传
flutter build ios --release
# 在 Xcode 中: Product > Archive > Distribute App
```

## 编译脚本

### 统一编译脚本 (save as `scripts/build_all.sh`)

```bash
#!/bin/bash
set -e

echo "🔨 开始编译所有平台..."

cd core

# Linux
echo "📦 编译 Linux..."
GOOS=linux GOARCH=amd64 go build \
    -buildmode=c-shared \
    -o ../plugins/linux/libstudy.so \
    ./pkg/libstudy

# macOS
echo "📦 编译 macOS..."
GOOS=darwin GOARCH=arm64 go build \
    -buildmode=c-shared \
    -o ../plugins/macos/libstudy_arm.dylib \
    ./pkg/libstudy

GOOS=darwin GOARCH=amd64 go build \
    -buildmode=c-shared \
    -o ../plugins/macos/libstudy_x86.dylib \
    ./pkg/libstudy

lipo -create \
    ../plugins/macos/libstudy_arm.dylib \
    ../plugins/macos/libstudy_x86.dylib \
    -output ../plugins/macos/libstudy.dylib

# Windows (需要在 Windows 或使用 MinGW)
if [[ "$OSTYPE" == "msys" || "$OSTYPE" == "win32" ]]; then
    echo "📦 编译 Windows..."
    GOOS=windows GOARCH=amd64 go build \
        -buildmode=c-shared \
        -o ../plugins/windows/libstudy.dll \
        ./pkg/libstudy
fi

cd ..
echo "✅ Go 库编译完成"

# 编译 Flutter
echo "🎯 编译 Flutter 应用..."
flutter pub get

echo "✅ 所有编译完成"
```

### 清理脚本 (save as `scripts/clean_all.sh`)

```bash
#!/bin/bash

echo "🧹 清理编译文件..."

# 清理 Go
cd core
go clean -modcache
rm -rf ../plugins/linux/libstudy.so
rm -rf ../plugins/macos/libstudy*
rm -rf ../plugins/windows/libstudy.dll
rm -rf ../plugins/android/*/libstudy.so
rm -rf ../plugins/ios/libstudy*
cd ..

# 清理 Flutter
flutter clean

echo "✅ 清理完成"
```

## 故障排查

### 编译错误

#### "could not determine kind of name"

**原因**: CGO 配置错误

**解决**:
```bash
# 检查 C 编译器
gcc --version

# 设置 CGO_ENABLED
export CGO_ENABLED=1
```

#### "permission denied"

**原因**: 库文件权限不正确

**解决**:
```bash
chmod +x plugins/linux/libstudy.so
chmod +x plugins/macos/libstudy.dylib
```

#### "undefined reference"

**原因**: 缺少依赖库

**解决**:
```bash
# Linux
ldd plugins/linux/libstudy.so

# macOS
otool -L plugins/macos/libstudy.dylib
```

### 运行时错误

#### "library not found"

**检查**:
```bash
# Flutter 是否能找到库
flutter doctor -v

# 检查库路径
ls -la plugins/*/libstudy*
```

#### "FFI error"

**检查**:
```dart
// 验证库路径
final libPath = 'libstudy.so';
print('Trying to load: $libPath');

// 使用绝对路径
final dir = await getApplicationDocumentsDirectory();
final libPath = '${dir.path}/../plugins/linux/libstudy.so';
```

## 性能优化

### 编译优化

```bash
# 启用优化
go build -ldflags="-s -w" \
    -buildmode=c-shared \
    -o libstudy.so \
    ./pkg/libstudy

# 减少文件大小
strip libstudy.so
```

### 运行时优化

```go
// 在 main.go 中
import _ "net/http/pprof"

// 监控性能
go func() {
    log.Println(http.ListenAndServe("localhost:6060", nil))
}()

// 访问: http://localhost:6060/debug/pprof
```

## 持续集成

### GitHub Actions 示例

```yaml
name: Build

on:
  push:
    branches: [main]
  pull_request:
    branches: [main]

jobs:
  build:
    runs-on: ${{ matrix.os }}
    strategy:
      matrix:
        os: [ubuntu-latest, macos-latest, windows-latest]
    
    steps:
      - uses: actions/checkout@v3
      
      - name: Setup Go
        uses: actions/setup-go@v4
        with:
          go-version: '1.21'
      
      - name: Setup Flutter
        uses: subosito/flutter-action@v2
        with:
          flutter-version: '3.10.0'
      
      - name: Build Go Library
        run: |
          cd core
          go mod tidy
          go build -buildmode=c-shared -o ../plugins/libstudy.so ./pkg/libstudy
      
      - name: Build Flutter
        run: flutter pub get && flutter build linux --release
```

## 总结

✅ 编译脚本已提供
✅ 平台特定配置已说明
✅ 部署说明已完善
✅ 故障排查指南已编写

**下一步**: 运行编译脚本并测试生成的库文件。
