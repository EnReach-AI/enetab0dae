#!/bin/bash
# 统一的多平台编译脚本 - 支持本地和 Docker 编译

set -e

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
PROJECT_ROOT="$SCRIPT_DIR/.."

show_usage() {
    cat << EOF
🔨 ARO-EXT-APP 多平台编译脚本

用法: $0 [选项]

选项:
  local     编译当前平台可用的库（推荐，快速）
  docker    使用 Docker 编译所有平台的库（需要 Docker）
  ci        CI/CD 模式，自动选择最佳方法
  
其他命令:
  check     检查编译环境
  help      显示此帮助信息

示例:
  # 快速本地编译（只编译支持的平台）
  bash build.sh local
  
  # Docker 编译所有平台
  bash build.sh docker
  
  # 检查编译器
  bash build.sh check

默认行为（不带参数）: 自动选择方法
EOF
}

# 默认方法
METHOD=${1:-auto}

case "$METHOD" in
    local)
        echo "🔨 本地编译模式（快速）"
        bash "$SCRIPT_DIR/build_go_libs.sh"
        ;;
    docker)
        echo "🐳 Docker 编译模式（多平台）"
        bash "$SCRIPT_DIR/build_with_docker.sh"
        ;;
    ci)
        echo "🔄 CI/CD 模式"
        # 在 CI 中总是使用本地编译器
        bash "$SCRIPT_DIR/build_go_libs.sh"
        ;;
    check)
        echo "🔍 检查编译环境"
        bash "$SCRIPT_DIR/check_compilers.sh"
        ;;
    help|--help|-h)
        show_usage
        ;;
    auto)
        echo "🤖 自动选择编译方法"
        echo ""
        
        # 检查 Docker
        if command -v docker &> /dev/null; then
            echo "✅ Docker 可用"
            read -p "是否使用 Docker 编译所有平台? (y/n) [默认: n] " -n 1 -r
            echo
            if [[ $REPLY =~ ^[Yy]$ ]]; then
                bash "$SCRIPT_DIR/build_with_docker.sh"
            else
                bash "$SCRIPT_DIR/build_go_libs.sh"
            fi
        else
            echo "⚠️  Docker 未安装，使用本地编译"
            bash "$SCRIPT_DIR/build_go_libs.sh"
        fi
        ;;
    *)
        echo "❌ 未知的方法: $METHOD"
        echo ""
        show_usage
        exit 1
        ;;
esac
