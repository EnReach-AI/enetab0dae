#!/bin/bash
# 检查编译器可用性

echo "🔍 编译器可用性检查"
echo ""

# Go 版本
echo "📦 Go 版本:"
if command -v go &> /dev/null; then
    go version
    echo "   ✅ Go 已安装"
else
    echo "   ❌ Go 未安装"
fi

# 本地编译器
echo ""
echo "🐧 Linux 编译器 (本地编译):"
if command -v gcc &> /dev/null; then
    echo "   ✅ GCC: $(gcc --version | head -1)"
else
    echo "   ⚠️  GCC 未安装"
fi

if command -v clang &> /dev/null; then
    echo "   ✅ Clang: $(clang --version | head -1 | awk '{print $1, $2, $3}')"
else
    echo "   ⚠️  Clang 未安装"
fi

# Windows 交叉编译器
echo ""
echo "🪟 Windows x64 编译器 (交叉编译):"
if command -v x86_64-w64-mingw32-gcc &> /dev/null; then
    echo "   ✅ MinGW: $(x86_64-w64-mingw32-gcc --version | head -1)"
else
    echo "   ⚠️  MinGW 未安装"
    echo "      macOS: brew install mingw-w64"
    echo "      Linux: sudo apt install mingw-w64"
fi

# macOS 编译器
echo ""
echo "🍎 macOS 编译器 (交叉编译):"
if command -v clang &> /dev/null && clang --version 2>/dev/null | grep -q "Apple"; then
    echo "   ✅ Xcode Clang: $(clang --version | head -1)"
else
    echo "   ⚠️  Xcode 未安装"
    echo "      运行: xcode-select --install"
fi

# Android NDK
echo ""
echo "🤖 Android NDK:"
if [ -z "$ANDROID_NDK_ROOT" ]; then
    echo "   ⚠️  ANDROID_NDK_ROOT 未设置"
    echo "      设置: export ANDROID_NDK_ROOT=/path/to/ndk"
else
    if [ -d "$ANDROID_NDK_ROOT" ]; then
        echo "   ✅ ANDROID_NDK_ROOT: $ANDROID_NDK_ROOT"
        
        # 检查 clang
        if [ -f "$ANDROID_NDK_ROOT/toolchains/llvm/prebuilt/linux-x86_64/bin/aarch64-linux-android21-clang" ]; then
            echo "   ✅ ARM64 Clang: 可用"
        else
            echo "   ⚠️  ARM64 Clang: 未找到"
        fi
    else
        echo "   ❌ ANDROID_NDK_ROOT 路径无效: $ANDROID_NDK_ROOT"
    fi
fi

# 总结
echo ""
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo ""
echo "📋 编译支持情况:"
echo ""

# Linux
if command -v gcc &> /dev/null || command -v clang &> /dev/null; then
    echo "   ✅ Linux x64: 可编译"
else
    echo "   ❌ Linux x64: 需要安装编译器"
fi

# Windows
if command -v x86_64-w64-mingw32-gcc &> /dev/null; then
    echo "   ✅ Windows x64: 可编译"
else
    echo "   ⚠️  Windows x64: 需要 MinGW"
fi

# macOS
if command -v clang &> /dev/null; then
    echo "   ✅ macOS: 可编译"
else
    echo "   ⚠️  macOS: 需要 Xcode 命令行工具"
fi

# Android
if [ -n "$ANDROID_NDK_ROOT" ] && [ -d "$ANDROID_NDK_ROOT" ]; then
    echo "   ✅ Android ARM64: 可编译"
else
    echo "   ⚠️  Android ARM64: 需要 Android NDK"
fi

echo ""
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo ""
echo "运行编译:"
echo "  bash scripts/build_go_libs.sh"
echo ""
