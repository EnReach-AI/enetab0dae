#!/bin/bash
# 使用 Docker 编译多平台 Go 动态库 (兼容所有 Docker 版本)

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
PROJECT_ROOT="$SCRIPT_DIR/.."
PLUGINS_DIR="$PROJECT_ROOT/plugins"

echo "🐳 Docker 多平台编译"
echo ""

# 检查 Docker 是否安装
if ! command -v docker &> /dev/null; then
    echo "❌ Docker 未安装"
    echo "请安装 Docker: https://docs.docker.com/get-docker/"
    exit 1
fi

echo "✅ Docker 已安装"
echo ""

# 编译函数 - 统一处理所有平台
compile_with_docker() {
    local platform_name=$1
    local dockerfile=$2
    local output_file=$3
    local tag=$4
    
    echo "📦 编译 $platform_name..."
    mkdir -p "$PLUGINS_DIR/$platform_name"
    
    # Step 1: 构建镜像
    if ! docker build -f "$dockerfile" \
        -t "$tag" \
        "$PROJECT_ROOT" >/dev/null 2>&1; then
        echo "   ⚠️  $platform_name 镜像构建失败"
        return 1
    fi
    
    # Step 2: 创建临时容器并提取文件
    local temp_container=$(docker create "$tag" 2>/dev/null)
    if [ -z "$temp_container" ]; then
        echo "   ⚠️  $platform_name 容器创建失败"
        return 1
    fi
    
    # Step 3: 复制文件到本地
    docker cp "$temp_container:/build/$output_file" "$PLUGINS_DIR/$platform_name/" 2>/dev/null || {
        docker rm -f "$temp_container" 2>/dev/null
        echo "   ⚠️  $platform_name 编译失败（未生成输出文件）"
        return 1
    }
    
    docker cp "$temp_container:/build/libstudy.h" "$PLUGINS_DIR/$platform_name/" 2>/dev/null || true
    docker rm -f "$temp_container" 2>/dev/null
    
    # Step 4: 验证
    if [ -f "$PLUGINS_DIR/$platform_name/$output_file" ]; then
        local size=$(ls -lh "$PLUGINS_DIR/$platform_name/$output_file" | awk '{print $5}')
        echo "   ✅ $platform_name 编译完成 ($size)"
        return 0
    else
        echo "   ⚠️  $platform_name 编译失败"
        return 1
    fi
}

# 执行编译
compile_with_docker "linux" "$PROJECT_ROOT/Dockerfile.linux" "libstudy.so" "libstudy-linux:latest"
echo ""
compile_with_docker "windows" "$PROJECT_ROOT/Dockerfile.windows" "libstudy.dll" "libstudy-windows:latest"
echo ""
compile_with_docker "android" "$PROJECT_ROOT/Dockerfile.android" "libstudy.so" "libstudy-android:latest"

echo ""
echo "✅ 所有 Docker 编译完成！"
echo ""
echo "📂 输出文件:"
for dir in linux windows android; do
    if [ -d "$PLUGINS_DIR/$dir" ]; then
        has_files=false
        for file in "$PLUGINS_DIR/$dir"/*; do
            [ -f "$file" ] || continue
            if [ "$has_files" = false ]; then
                echo ""
                echo "  📦 $dir:"
                has_files=true
            fi
            size=$(ls -lh "$file" | awk '{print $5}')
            echo "     └─ $(basename "$file") ($size)"
        done
    fi
done

echo ""
echo "💡 提示: 使用 Docker 编译可以在任何平台上生成所有目标平台的库" do
    if [ -d "$PLUGINS_DIR/$dir" ]; then
        echo ""
        echo "  📦 $dir:"
        find "$PLUGINS_DIR/$dir" -type f | while read file; do
            size=$(ls -lh "$file" | awk '{print $5}')
            echo "     └─ $(basename "$file") ($size)"
        done
    fi
done

echo ""
echo "💡 提示: 使用 Docker 编译可以在任何平台上生成所有目标平台的库"
