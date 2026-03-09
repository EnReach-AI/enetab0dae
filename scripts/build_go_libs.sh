#!/bin/bash
# 跨平台编译 Go 动态库 - 版本支持
# 
# 功能：
#   1. 编译五个平台的库（带完整版本注入）
#   2. 生成版本清单
#   3. 支持 Git action 集成
#   4. 生成压缩包（源文件保持不变）
#
# 用法：
#   ./scripts/build_go_libs.sh build          # 构建所有平台
#   ./scripts/build_go_libs.sh build-linux    # 仅构建 Linux
#   ./scripts/build_go_libs.sh version        # 显示版本信息
#   ./scripts/build_go_libs.sh clean          # 清理构建产物
#   ./scripts/build_go_libs.sh ci             # GitHub Actions 构建
#   ./scripts/build_go_libs.sh archive        # 仅生成压缩包（不重新构建）

set -e

# ============================================
# 配置
# ============================================

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
PROJECT_ROOT="$SCRIPT_DIR/.."
CORE_DIR="$PROJECT_ROOT/core"
BUILD_DIR="$PROJECT_ROOT/core/pkg/libstudy"
PLUGINS_DIR="$PROJECT_ROOT/plugins"
ARCHIVES_DIR="$PROJECT_ROOT/plugins/archives"
VERSION_FILE="$PROJECT_ROOT/core/version/version.go"

# 基础版本号
BASE_VERSION="0.0.1"
BUILD_DATE=$(date +%Y%m%d)

# 颜色输出
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# ============================================
# 日志函数
# ============================================

log_info() {
    echo -e "${BLUE}ℹ️  $1${NC}"
}

log_success() {
    echo -e "${GREEN}✓ $1${NC}"
}

log_error() {
    echo -e "${RED}✗ $1${NC}"
}

log_warning() {
    echo -e "${YELLOW}⚠️  $1${NC}"
}

# ============================================
# Git 函数
# ============================================

# 获取 Git 信息
get_git_info() {
    local commit=$(git rev-parse HEAD 2>/dev/null || echo "unknown")
    local branch=$(git rev-parse --abbrev-ref HEAD 2>/dev/null || echo "unknown")
    echo "$commit:$branch"
}

# 获取 Git 短提交哈希
get_git_short_commit() {
    git rev-parse --short HEAD 2>/dev/null || echo "unknown"
}

# 获取 Git 分支
get_git_branch() {
    git rev-parse --abbrev-ref HEAD 2>/dev/null || echo "unknown"
}

# 检查是否有未提交的更改
check_git_status() {
    if [ -z "$(git status --porcelain)" ]; then
        echo "clean"
    else
        echo "dirty"
    fi
}

# 生成 ldflags
generate_ldflags() {
    local commit=$(echo "$1" | cut -d: -f1)
    local branch=$(echo "$1" | cut -d: -f2)
    local buildtime=$(date -u +'%Y-%m-%dT%H:%M:%SZ')
    
    echo "-s -w \
-X aro-ext-app/core/version.VERSION=$BASE_VERSION \
-X aro-ext-app/core/version.BUILDTIME=$buildtime \
-X aro-ext-app/core/version.GITCOMMIT=$commit \
-X aro-ext-app/core/version.GITBRANCH=$branch"
}

# ============================================
# 编译器检查函数
# ============================================

# 函数：检查编译器是否可用
check_compiler() {
    local platform=$1
    case "$platform" in
        darwin|macos)
            # 优先检查是否在 macOS 上
            if [[ "$OSTYPE" == "darwin"* ]]; then
                if ! command -v clang &> /dev/null; then
                    log_warning "macOS 编译器 (clang/Xcode) 未找到，跳过 macOS 编译"
                    return 1
                fi
            else
                # 在非 macOS 系统上，检查是否有 osxcross
                if [ -z "$OSXCROSS_ROOT" ] || [ ! -d "$OSXCROSS_ROOT" ]; then
                    log_warning "OSXCross 未配置，无法在 Linux 上交叉编译 macOS"
                    echo "   提示: 安装 OSXCross 或在 macOS 机器上构建"
                    echo "   提示: 设置 OSXCROSS_ROOT=/path/to/osxcross"
                    return 1
                fi
            fi
            ;;
        windows)
            if ! command -v x86_64-w64-mingw32-gcc &> /dev/null; then
                log_warning "Windows 编译器 (MinGW) 未找到，跳过 Windows 编译"
                echo "   提示: 在 macOS 上可用 'brew install mingw-w64'"
                echo "   提示: 在 Linux 上可用 'apt install mingw-w64'"
                return 1
            fi
            ;;
        android)
            if [ -z "$ANDROID_NDK_ROOT" ]; then
                log_warning "Android NDK 未配置，跳过 Android 编译"
                echo "   提示: 设置 ANDROID_NDK_ROOT=/path/to/ndk"
                return 1
            fi
            ;;
    esac
    return 0
}

# ============================================
# 平台构建函数
# ============================================

build_for_platform() {
    local goos=$1
    local goarch=$2
    local platform_name="${goos}_${goarch}"
    local output_name=$3
    
    log_info "构建 $platform_name"
    
    # 检查编译器是否可用
    if ! check_compiler "$goos"; then
        log_warning "跳过 $platform_name 构建"
        return 0
    fi
    
    local git_info=$(get_git_info)
    local ldflags=$(generate_ldflags "$git_info")
    
    # 确定输出目录和文件扩展名
    local output_dir=""
    local output_ext=""
    case $goos in
        linux)
            output_dir="$PLUGINS_DIR/linux"
            output_ext="so"
            ;;
        darwin)
            output_dir="$PLUGINS_DIR/macos"
            output_ext="dylib"
            ;;
        windows)
            output_dir="$PLUGINS_DIR/windows"
            output_ext="dll"
            ;;
        android)
            output_dir="$PLUGINS_DIR/android"
            output_ext="so"
            ;;
    esac
    
    mkdir -p "$output_dir"
    
    # 构建库
    log_info "  编译: GOOS=$goos GOARCH=$goarch"
    log_info "  输出: $output_dir/$output_name.$output_ext"
    
    cd "$BUILD_DIR"
    
    # 使用 set +e 允许构建失败时继续
    set +e
    
    case $goos in
        linux)
            CGO_ENABLED=1 GOOS=$goos GOARCH=$goarch go build \
                -buildmode=c-shared \
                -ldflags "$ldflags" \
                -o "$output_dir/$output_name.$output_ext" \
                .
            ;;
        darwin)
            # 检测当前系统，区分原生构建和交叉编译
            if [[ "$OSTYPE" == "darwin"* ]]; then
                # 在 macOS 上原生构建
                CGO_ENABLED=1 GOOS=$goos GOARCH=$goarch go build \
                    -buildmode=c-shared \
                    -ldflags "$ldflags" \
                    -o "$output_dir/$output_name.$output_ext" \
                    .
            elif [ -n "$OSXCROSS_ROOT" ] && [ -d "$OSXCROSS_ROOT" ]; then
                # 在 Linux 上使用 osxcross 交叉编译
                local osxcross_bin="$OSXCROSS_ROOT/target/bin"
                local cc_compiler=""
                
                if [ "$goarch" = "arm64" ]; then
                    cc_compiler="$osxcross_bin/oa64-clang"
                else
                    cc_compiler="$osxcross_bin/o64-clang"
                fi
                
                if [ ! -f "$cc_compiler" ]; then
                    log_error "OSXCross 编译器未找到: $cc_compiler"
                    set -e
                    return 1
                fi
                
                log_info "  使用 OSXCross: $cc_compiler"
                CC="$cc_compiler" CGO_ENABLED=1 GOOS=$goos GOARCH=$goarch go build \
                    -buildmode=c-shared \
                    -ldflags "$ldflags" \
                    -o "$output_dir/$output_name.$output_ext" \
                    .
            else
                log_warning "macOS 动态库需要在 macOS 系统上构建或配置 OSXCross"
                log_warning "如需构建 macOS 版本，请："
                log_warning "  1. 在 macOS 机器上运行此脚本，或"
                log_warning "  2. 安装 OSXCross 并设置 OSXCROSS_ROOT 环境变量"
                set -e
                return 0
            fi
            ;;
        windows)
            CC=x86_64-w64-mingw32-gcc CGO_ENABLED=1 GOOS=$goos GOARCH=$goarch go build \
                -buildmode=c-shared \
                -ldflags "$ldflags" \
                -o "$output_dir/$output_name.$output_ext" \
                .
            ;;
        android)
            CGO_ENABLED=1 GOOS=$goos GOARCH=$goarch \
            CC="$ANDROID_NDK_ROOT/toolchains/llvm/prebuilt/linux-x86_64/bin/aarch64-linux-android21-clang" \
            go build \
                -buildmode=c-shared \
                -ldflags "$ldflags" \
                -o "$output_dir/$output_name.$output_ext" \
                .
            ;;
    esac
    
    local build_status=$?
    set -e
    
    if [ $build_status -eq 0 ]; then
        log_success "构建完成: $output_dir/$output_name.$output_ext"
    else
        log_error "构建失败: $platform_name (退出码: $build_status)"
        log_warning "继续执行其他平台的构建..."
    fi
}

# 清理构建产物
clean_build() {
    log_info "清理构建产物"
    
    for dir in linux windows macos android; do
        if [ -d "$PLUGINS_DIR/$dir" ]; then
            rm -f "$PLUGINS_DIR/$dir"/libstudy*.*
            log_success "  清理: $dir"
        fi
    done
}

# 生成版本清单
generate_manifest() {
    log_info "生成版本清单"
    
    local manifest_file="$PLUGINS_DIR/VERSION_MANIFEST.json"
    
    cat > "$manifest_file" << EOF
{
  "base_version": "$BASE_VERSION",
  "build_date": "$BUILD_DATE",
  "build_time": "$(date -u +'%Y-%m-%dT%H:%M:%SZ')",
  "git_commit": "$(git rev-parse HEAD 2>/dev/null || echo 'unknown')",
  "git_branch": "$(git rev-parse --abbrev-ref HEAD 2>/dev/null || echo 'unknown')",
  "git_status": "$(check_git_status)",
  "platforms": {
    "linux_amd64": {
      "os": "linux",
      "arch": "amd64",
      "file": "linux/libstudy_${BASE_VERSION}_linux_amd64.so",
      "format": "ELF 64-bit"
    },
    "windows_amd64": {
      "os": "windows",
      "arch": "amd64",
      "file": "windows/libstudy_${BASE_VERSION}_windows_amd64.dll",
      "format": "PE 32-bit"
    },
    "darwin_arm64": {
      "os": "darwin",
      "arch": "arm64",
      "file": "macos/libstudy_${BASE_VERSION}_darwin_arm64.dylib",
      "format": "Mach-O 64-bit ARM64"
    },
    "darwin_amd64": {
      "os": "darwin",
      "arch": "amd64",
      "file": "macos/libstudy_${BASE_VERSION}_darwin_amd64.dylib",
      "format": "Mach-O 64-bit x86_64"
    },
    "android_arm64": {
      "os": "android",
      "arch": "arm64",
      "file": "android/libstudy_${BASE_VERSION}_android_arm64.so",
      "format": "ELF 64-bit ARM64"
    }
  }
}
EOF
    
    log_success "版本清单: $manifest_file"
}

# 显示版本信息
show_version_info() {
    log_info "版本信息"
    echo ""
    echo "基础版本:    $BASE_VERSION"
    echo "构建日期:    $BUILD_DATE"
    echo "Git 提交:    $(get_git_short_commit)"
    echo "Git 分支:    $(get_git_branch)"
    echo "工作目录:    $(check_git_status)"
    echo ""
    echo "完整版本号示例:"
    echo "  linux_amd64_${BASE_VERSION}_${BUILD_DATE}"
    echo "  windows_amd64_${BASE_VERSION}_${BUILD_DATE}"
    echo "  darwin_arm64_${BASE_VERSION}_${BUILD_DATE}"
    echo "  darwin_amd64_${BASE_VERSION}_${BASE_VERSION}_${BUILD_DATE}"
    echo "  android_arm64_${BASE_VERSION}_${BUILD_DATE}"
    echo ""
}

# 生成压缩包（源文件保持不变）
generate_archives() {
    local platform_filter="${1:-}"   # 可选：指定平台，例如 "linux"
    local archive_date=$(date +%Y%m%d_%H%M%S)

    log_info "生成压缩包（源文件保持不变）"
    mkdir -p "$ARCHIVES_DIR"

    local generated=0

    for platform_dir in "$PLUGINS_DIR"/*/; do
        [ -d "$platform_dir" ] || continue
        local platform_name
        platform_name=$(basename "$platform_dir")

        # 跳过 archives 目录本身
        [ "$platform_name" = "archives" ] && continue

        # 如果指定了平台过滤，则跳过不匹配的平台
        if [ -n "$platform_filter" ] && [ "$platform_name" != "$platform_filter" ]; then
            continue
        fi

        # 查找该平台目录下的库文件（so / dll / dylib），排除 .h 头文件
        local lib_files=()
        while IFS= read -r -d '' f; do
            lib_files+=("$f")
        done < <(find "$platform_dir" -maxdepth 1 -type f \
            \( -name "*.so" -o -name "*.dll" -o -name "*.dylib" \) -print0)

        if [ ${#lib_files[@]} -eq 0 ]; then
            log_warning "  $platform_name: 未找到库文件，跳过"
            continue
        fi

        for lib_file in "${lib_files[@]}"; do
            local lib_basename
            lib_basename=$(basename "$lib_file")
            local lib_stem="${lib_basename%.*}"
            local archive_name="${lib_stem}_${archive_date}.zip"
            local archive_path="$ARCHIVES_DIR/$archive_name"

            # -j 只存文件名，不含路径——源文件不动
            zip -j "$archive_path" "$lib_file"

            local size
            size=$(ls -lh "$archive_path" | awk '{print $5}')
            log_success "  压缩包: $archive_path ($size)"
            (( generated++ )) || true
        done
    done

    if [ "$generated" -eq 0 ]; then
        log_warning "没有找到可打包的库文件（请先执行 build）"
    else
        log_success "共生成 $generated 个压缩包 → $ARCHIVES_DIR"
    fi
}

# 显示已生成的文件
show_build_output() {
    echo ""
    echo "✅ 编译完成！"
    echo "📂 输出文件位置："
    echo ""

    # 显示已生成的文件
    if [ -d "$PLUGINS_DIR" ]; then
        for platform_dir in "$PLUGINS_DIR"/*; do
            if [ -d "$platform_dir" ]; then
                platform_name=$(basename "$platform_dir")
                echo "📦 $platform_name:"
                find "$platform_dir" -type f | while read file; do
                    size=$(ls -lh "$file" | awk '{print $5}')
                    echo "   └─ $(basename "$file") ($size)"
                done
                echo ""
            fi
        done
    else
        echo "   (无输出文件)"
    fi
}

# ============================================
# GitHub Actions CI/CD 支持
# ============================================

build_ci() {
    log_info "GitHub Actions CI 构建模式"
    
    # 在 CI 环境中，通常只能构建当前平台
    local current_platform="$RUNNER_OS"
    
    case "$current_platform" in
        Linux)
            log_info "检测到 Linux 环境"
            build_for_platform "linux" "amd64" "libstudy_${BASE_VERSION}_linux_amd64"
            ;;
        macOS)
            log_info "检测到 macOS 环境"
            build_for_platform "darwin" "arm64" "libstudy_${BASE_VERSION}_darwin_arm64"
            build_for_platform "darwin" "amd64" "libstudy_${BASE_VERSION}_darwin_amd64"
            ;;
        Windows)
            log_info "检测到 Windows 环境"
            build_for_platform "windows" "amd64" "libstudy_${BASE_VERSION}_windows_amd64"
            ;;
        *)
            # 默认情况下构建 Linux
            log_warning "未知的环境，默认构建 Linux"
            build_for_platform "linux" "amd64" "libstudy_${BASE_VERSION}_linux_amd64"
            ;;
    esac
    
    # 输出 GitHub Actions 环境变量
    if [ -n "$GITHUB_OUTPUT" ]; then
        echo "build_version=${BASE_VERSION}_${BUILD_DATE}" >> "$GITHUB_OUTPUT"
        echo "git_commit=$(get_git_short_commit)" >> "$GITHUB_OUTPUT"
        echo "git_branch=$(get_git_branch)" >> "$GITHUB_OUTPUT"
        log_success "GitHub Actions 输出已设置"
    fi
}

# ============================================
# 主流程
# ============================================

main() {
    local command="${1:-build}"
    
    case $command in
        build)
            log_info "开始构建所有平台"
            clean_build
            
            build_for_platform "linux" "amd64" "libstudy_${BASE_VERSION}_linux_amd64"
            build_for_platform "windows" "amd64" "libstudy_${BASE_VERSION}_windows_amd64"
            build_for_platform "darwin" "arm64" "libstudy_${BASE_VERSION}_darwin_arm64"
            build_for_platform "darwin" "amd64" "libstudy_${BASE_VERSION}_darwin_amd64"
            build_for_platform "android" "arm64" "libstudy_${BASE_VERSION}_android_arm64"
            
            generate_manifest
            generate_archives
            show_build_output
            show_version_info
            
            log_success "所有平台构建完成！"
            ;;
            
        build-linux)
            log_info "构建 Linux 平台"
            build_for_platform "linux" "amd64" "libstudy_${BASE_VERSION}_linux_amd64"
            generate_archives "linux"
            log_success "Linux 构建完成"
            ;;
            
        build-windows)
            log_info "构建 Windows 平台"
            build_for_platform "windows" "amd64" "libstudy_${BASE_VERSION}_windows_amd64"
            generate_archives "windows"
            log_success "Windows 构建完成"
            ;;
            
        build-macos)
            log_info "构建 macOS 平台"
            build_for_platform "darwin" "arm64" "libstudy_${BASE_VERSION}_darwin_arm64"
            build_for_platform "darwin" "amd64" "libstudy_${BASE_VERSION}_darwin_amd64"
            generate_archives "macos"
            log_success "macOS 构建完成"
            ;;
            
        build-android)
            log_info "构建 Android 平台"
            build_for_platform "android" "arm64" "libstudy_${BASE_VERSION}_android_arm64"
            generate_archives "android"
            log_success "Android 构建完成"
            ;;
            
        ci)
            build_ci
            generate_archives
            log_success "CI 构建完成"
            ;;
            
        archive)
            generate_archives "${2:-}"
            ;;
            
        version)
            show_version_info
            ;;
            
        clean)
            clean_build
            log_success "清理完成"
            ;;
            
        *)
            cat << EOF
用法: $0 <command>

命令:
  build           构建所有五个平台并生成 zip 压缩包
  build-linux     仅构建 Linux (amd64) 并生成 zip 压缩包
  build-windows   仅构建 Windows (amd64) 并生成 zip 压缩包
  build-macos     构建 macOS (arm64 + amd64) 并生成 zip 压缩包
  build-android   仅构建 Android (arm64) 并生成 zip 压缩包
  ci              GitHub Actions CI 构建（检测环境自动选择平台）并生成 zip 压缩包
  archive [平台]  仅对已有库文件生成 zip 压缩包（源文件不动），可指定平台
  version         显示版本信息
  clean           清理构建产物

压缩包输出目录:
  plugins/archives/

环境变量:
  ANDROID_NDK_ROOT    Android NDK 路径（Android 构建必需）
  OSXCROSS_ROOT       OSXCross 路径（Linux 上构建 macOS 时必需）
  RUNNER_OS           GitHub Actions 环境（可选，用于 ci 模式）

示例:
  $0 build
  $0 build-linux
  $0 archive              # 对所有平台已有库文件打包
  $0 archive linux        # 仅打包 linux 平台
  $0 version
  ANDROID_NDK_ROOT=/path/to/ndk $0 build-android
  OSXCROSS_ROOT=/path/to/osxcross $0 build-macos

GitHub Actions 示例:
  $0 ci

详情见: https://github.com/your-repo/docs/build.md
EOF
            exit 1
            ;;
    esac
}

main "$@"
