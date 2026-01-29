#!/usr/bin/env bash
set -euo pipefail

# 1) 基础依赖
retry() {
  local attempts="${1:-5}"
  local sleep_seconds="${2:-3}"
  shift 2 || true
  local n=0
  until "$@"; do
    n=$((n + 1))
    if [ "$n" -ge "$attempts" ]; then
      return 1
    fi
    sleep $((sleep_seconds * n))
  done
}

if [ -f /etc/debian_version ]; then
  retry 5 3 sudo apt-get -o Acquire::Retries=5 -o Acquire::http::Timeout=60 -o Acquire::https::Timeout=60 update
  retry 5 3 sudo env DEBIAN_FRONTEND=noninteractive apt-get -o Acquire::Retries=5 -o Acquire::http::Timeout=60 -o Acquire::https::Timeout=60 install -y --no-install-recommends --fix-missing \
    git curl jq clang cmake ninja-build pkg-config libgtk-3-dev ruby ruby-dev build-essential unzip debianutils
  if ! sudo env DEBIAN_FRONTEND=noninteractive apt-get -o Acquire::Retries=5 -o Acquire::http::Timeout=60 -o Acquire::https::Timeout=60 install -y --no-install-recommends --fix-missing libwebkit2gtk-4.1-dev; then
    retry 3 3 sudo env DEBIAN_FRONTEND=noninteractive apt-get -o Acquire::Retries=5 -o Acquire::http::Timeout=60 -o Acquire::https::Timeout=60 install -y --no-install-recommends --fix-missing libwebkit2gtk-4.0-dev
  fi
  retry 5 5 sudo gem install --no-document fpm
else
  echo "当前脚本只适配 Debian/Ubuntu。若需 Rocky/Fedora，请参考 workflow 中 dnf 安装段。"
  exit 1
fi

# 2) Go 核心库 (linux x64 + arm64)
cd "$(dirname "$0")/.."
cd core
go env -w GOTOOLCHAIN=local
CGO_ENABLED=1 GOOS=linux GOARCH=amd64 go build -buildmode=c-shared -trimpath -ldflags="-s -w -buildid=" -o ../plugins/linux/libstudy.so ./pkg/libstudy
CC=aarch64-linux-gnu-gcc CGO_ENABLED=1 GOOS=linux GOARCH=arm64 go build -buildmode=c-shared -trimpath -ldflags="-s -w -buildid=" -o ../plugins/linux-arm64/libstudy.so ./pkg/libstudy

# 3) 拷贝核心库到 Flutter FFI 目录
cd ..
mkdir -p apps/aro_client/lib/ffi/linux apps/aro_client/lib/ffi/linux-arm64
cp -f plugins/linux/libstudy.so apps/aro_client/lib/ffi/linux/
cp -f plugins/linux-arm64/libstudy.so apps/aro_client/lib/ffi/linux-arm64/

# 4) Flutter 构建 Linux 应用
cd apps/aro_client
flutter config --enable-linux-desktop
flutter precache --linux
flutter pub get
flutter build linux --release

# 5) 打包 DEB
VERSION=$(grep 'version:' pubspec.yaml | cut -d ' ' -f2 | cut -d '+' -f1)
mkdir -p build/linux/x64/release/bundle/lib
cp lib/ffi/linux/*.so build/linux/x64/release/bundle/lib/ || true
fpm -s dir -t deb \
  -n aro-client -v "$VERSION" \
  --description "ARO Client" \
  --depends libgtk-3-0 \
  --depends "libwebkit2gtk-4.0-37 | libwebkit2gtk-4.1-0" \
  build/linux/x64/release/bundle/=/opt/aro-client/ \
  aro-client.desktop=/usr/share/applications/aro-client.desktop

echo "✅ 构建完成,DEB 包位于 apps/aro_client/ 目录下"