#!/bin/bash

# Linux WebView 依赖检查脚本

echo "检查 Linux WebView 依赖..."

# 检查 WebKitGTK
echo -n "检查 libwebkit2gtk-4.0-dev: "
if pkg-config --exists webkit2gtk-4.0; then
    VERSION=$(pkg-config --modversion webkit2gtk-4.0)
    echo "✓ 已安装 (版本: $VERSION)"
else
    echo "✗ 未安装"
    echo "  请运行: sudo apt-get install -y libwebkit2gtk-4.0-dev"
fi

# 检查 GTK
echo -n "检查 libgtk-3-dev: "
if pkg-config --exists gtk+-3.0; then
    VERSION=$(pkg-config --modversion gtk+-3.0)
    echo "✓ 已安装 (版本: $VERSION)"
else
    echo "✗ 未安装"
    echo "  请运行: sudo apt-get install -y libgtk-3-dev"
fi

# 检查运行时库
echo -n "检查 libwebkit2gtk-4.0 运行时库: "
if ldconfig -p | grep -q libwebkit2gtk-4.0; then
    echo "✓ 已安装"
else
    echo "✗ 未安装"
    echo "  请运行: sudo apt-get install -y libwebkit2gtk-4.0-37"
fi

# 检查其他必需依赖
echo -n "检查 libjavascriptcoregtk-4.0: "
if ldconfig -p | grep -q libjavascriptcoregtk-4.0; then
    echo "✓ 已安装"
else
    echo "✗ 未安装"
    echo "  请运行: sudo apt-get install -y libjavascriptcoregtk-4.0-dev"
fi

echo ""
echo "如果所有依赖都已安装但仍出现问题，请尝试："
echo "  1. flutter clean"
echo "  2. flutter pub get"
echo "  3. flutter build linux"
echo "  4. 重新运行应用"
