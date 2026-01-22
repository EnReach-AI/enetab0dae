#!/bin/bash
# 快速设置编译环境

set -e

PLATFORM=$(uname -s)

echo "🔧 ARO-EXT-APP 编译环境快速设置"
echo "当前平台: $PLATFORM"
echo ""

# macOS
if [ "$PLATFORM" = "Darwin" ]; then
    echo "📱 macOS 编译环境设置"
    echo ""
    
    echo "1️⃣  检查 Xcode 命令行工具..."
    if command -v clang &> /dev/null; then
        echo "   ✅ Xcode 命令行工具已安装"
        clang --version | head -1
    else
        echo "   ⚠️  Xcode 命令行工具未安装，正在安装..."
        xcode-select --install
        echo "   请完成 Xcode 安装后重新运行本脚本"
        exit 1
    fi
    
    echo ""
    echo "2️⃣  检查 MinGW (用于 Windows 交叉编译)..."
    if command -v x86_64-w64-mingw32-gcc &> /dev/null; then
        echo "   ✅ MinGW 已安装"
        x86_64-w64-mingw32-gcc --version | head -1
    else
        echo "   ⚠️  MinGW 未安装"
        echo "   ℹ️  运行: brew install mingw-w64"
        read -p "   要现在安装吗? (y/n) " -n 1 -r
        echo
        if [[ $REPLY =~ ^[Yy]$ ]]; then
            brew install mingw-w64
        fi
    fi
    
    echo ""
    echo "3️⃣  检查 Android NDK (可选)..."
    if [ -n "$ANDROID_NDK_ROOT" ] && [ -d "$ANDROID_NDK_ROOT" ]; then
        echo "   ✅ Android NDK 已配置"
        echo "      路径: $ANDROID_NDK_ROOT"
    else
        echo "   ⚠️  Android NDK 未配置"
        echo "   ℹ️  可通过 Android Studio 的 SDK 管理器安装"
        read -p "   输入 NDK 路径 (按 Enter 跳过): " -r NDK_PATH
        if [ -n "$NDK_PATH" ]; then
            echo "export ANDROID_NDK_ROOT=$NDK_PATH" >> ~/.bash_profile
            echo "export ANDROID_NDK_ROOT=$NDK_PATH" >> ~/.zprofile
            echo "   ✅ NDK 路径已添加到环境"
        fi
    fi

# Linux
elif [ "$PLATFORM" = "Linux" ]; then
    echo "🐧 Linux 编译环境设置"
    echo ""
    
    # 检测包管理器
    if command -v apt-get &> /dev/null; then
        PKG_MANAGER="apt-get"
        echo "📦 检测到 APT 包管理器"
    elif command -v dnf &> /dev/null; then
        PKG_MANAGER="dnf"
        echo "📦 检测到 DNF 包管理器"
    elif command -v pacman &> /dev/null; then
        PKG_MANAGER="pacman"
        echo "📦 检测到 Pacman 包管理器"
    else
        echo "❌ 无法识别包管理器"
        exit 1
    fi
    
    echo ""
    echo "1️⃣  检查 GCC/Clang..."
    if command -v gcc &> /dev/null; then
        echo "   ✅ GCC 已安装"
        gcc --version | head -1
    else
        echo "   ⚠️  GCC 未安装，正在安装..."
        sudo $PKG_MANAGER install -y build-essential
    fi
    
    echo ""
    echo "2️⃣  检查 MinGW (用于 Windows 交叉编译)..."
    if command -v x86_64-w64-mingw32-gcc &> /dev/null; then
        echo "   ✅ MinGW 已安装"
        x86_64-w64-mingw32-gcc --version | head -1
    else
        echo "   ⚠️  MinGW 未安装"
        echo "   ℹ️  运行: sudo apt install mingw-w64 (Ubuntu)"
        echo "          或: sudo dnf install mingw64-gcc (Fedora)"
        read -p "   要现在安装吗? (y/n) " -n 1 -r
        echo
        if [[ $REPLY =~ ^[Yy]$ ]]; then
            if [ "$PKG_MANAGER" = "apt-get" ]; then
                sudo apt-get update
                sudo apt-get install -y mingw-w64
            elif [ "$PKG_MANAGER" = "dnf" ]; then
                sudo dnf install -y mingw64-gcc
            elif [ "$PKG_MANAGER" = "pacman" ]; then
                sudo pacman -S mingw-w64-gcc
            fi
        fi
    fi
    
    echo ""
    echo "3️⃣  检查 Android NDK (可选)..."
    if [ -n "$ANDROID_NDK_ROOT" ] && [ -d "$ANDROID_NDK_ROOT" ]; then
        echo "   ✅ Android NDK 已配置"
        echo "      路径: $ANDROID_NDK_ROOT"
    else
        echo "   ⚠️  Android NDK 未配置"
        echo "   ℹ️  使用 Android Studio 的 SDK 管理器安装"
        read -p "   输入 NDK 路径 (按 Enter 跳过): " -r NDK_PATH
        if [ -n "$NDK_PATH" ]; then
            echo "export ANDROID_NDK_ROOT=$NDK_PATH" >> ~/.bashrc
            echo "   ✅ NDK 路径已添加到环境"
        fi
    fi

# Windows (Git Bash / WSL)
elif [[ "$PLATFORM" == *"MINGW"* ]] || [[ "$PLATFORM" == *"MSYS"* ]]; then
    echo "🪟 Windows 编译环境设置 (Git Bash)"
    echo ""
    echo "⚠️  建议在 WSL 中使用本脚本"
    echo ""
    echo "在 PowerShell 中运行以下命令进行编译:"
    echo '  $env:CGO_ENABLED = "1"'
    echo '  $env:GOOS = "windows"'
    echo '  $env:GOARCH = "amd64"'
    echo '  cd core'
    echo '  go build -buildmode=c-shared -o ..\plugins\windows\libstudy.dll .\pkg\libstudy'

else
    echo "❌ 不支持的平台: $PLATFORM"
    exit 1
fi

echo ""
echo "✅ 编译环境检查完成！"
echo ""
echo "现在可以运行:"
echo "  cd /opt/xinyun/web/aro-ext-app"
echo "  bash scripts/build_go_libs.sh"
echo ""
