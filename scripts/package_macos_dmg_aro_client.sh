#!/usr/bin/env bash
set -euo pipefail

# Builds aro_client macOS release, fixes libstudy dylib linkage, then packages a DMG.
# Output DMG will be placed under apps/aro_client/build/macos/Build/Products/Release/

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
APP_DIR="$ROOT_DIR/apps/aro_client"
RELEASE_DIR="$APP_DIR/build/macos/Build/Products/Release"
APP_PATH="$RELEASE_DIR/aro_client.app"
FIX_SCRIPT="$ROOT_DIR/scripts/fix_macos_app_libstudy_links.sh"
UNINSTALL_SCRIPT_SRC="$ROOT_DIR/scripts/uninstall_aro_client_macos.command"

resolve_release_app_path() {
  if [[ -d "$APP_PATH" ]]; then
    echo "==> Using app bundle: $APP_PATH"
    return 0
  fi

  local app_list
  app_list=$(mktemp)
  find "$RELEASE_DIR" -maxdepth 1 -type d -name "*.app" >"$app_list"

  local newest_app=""
  local newest_mtime=0
  while IFS= read -r candidate; do
    [[ -z "$candidate" ]] && continue
    local mtime
    mtime=$(stat -f "%m" "$candidate" 2>/dev/null || echo 0)
    if [[ "$mtime" -gt "$newest_mtime" ]]; then
      newest_mtime="$mtime"
      newest_app="$candidate"
    fi
  done <"$app_list"
  rm -f "$app_list"

  if [[ -z "$newest_app" ]]; then
    echo "No .app found in release directory: $RELEASE_DIR" >&2
    return 1
  fi

  APP_PATH="$newest_app"
  echo "==> Auto-detected app bundle: $APP_PATH"
}

thin_app_to_arch() {
  local app_path="$1"
  local arch="$2" # arm64 | x86_64

  if ! command -v lipo >/dev/null 2>&1; then
    echo "lipo not found. Install Xcode Command Line Tools: xcode-select --install" >&2
    return 1
  fi

  echo "==> Thinning app to ${arch}: ${app_path}"

  local file_list
  file_list=$(mktemp)
  find "$app_path" -type f -print0 >"$file_list"

  while IFS= read -r -d '' f; do
    local archs
    archs=$(lipo -archs "$f" 2>/dev/null || true)
    if [[ -z "$archs" ]]; then
      continue
    fi

    local found="0"
    local count="0"
    for a in $archs; do
      count=$((count + 1))
      if [[ "$a" == "$arch" ]]; then
        found="1"
      fi
    done

    if [[ "$found" != "1" ]]; then
      echo "ERROR: Missing ${arch} slice in: ${f} (archs: ${archs})" >&2
      return 1
    fi

    if [[ "$count" -gt 1 ]]; then
      local tmp="${f}.thin"
      lipo -thin "$arch" "$f" -output "$tmp"
      mv "$tmp" "$f"
    fi
  done <"$file_list"

  rm -f "$file_list"

  if command -v codesign >/dev/null 2>&1; then
    codesign --force --deep --sign - "$app_path" >/dev/null 2>&1 || true
  fi
}

create_dmg_for_arch() {
  local arch="$1" # arm64 | x86_64
  local dmg_path="$2"

  echo "==> Create DMG (${arch}): ${dmg_path}"

  local staging_dir
  staging_dir=$(mktemp -d)

  local app_bundle_name
  app_bundle_name="$(basename "$APP_PATH")"
  local dmg_volume_name="${app_bundle_name%.app}"
  if [[ -z "$dmg_volume_name" ]]; then
    dmg_volume_name="aro_client"
  fi
  local staged_app_path="$staging_dir/$app_bundle_name"

  cp -R "$APP_PATH" "$staged_app_path"

  local lib_name
  if [[ "$arch" == "arm64" ]]; then
    lib_name="libstudy-arm.dylib"
  elif [[ "$arch" == "x86_64" ]]; then
    lib_name="libstudy-amd.dylib"
  else
    echo "Unsupported arch: $arch" >&2
    rm -rf "$staging_dir"
    return 1
  fi

  local frameworks_dir="$staged_app_path/Contents/Frameworks"
  mkdir -p "$frameworks_dir"
  if [[ ! -f "$LIBSTUDY_DIR/$lib_name" ]]; then
    echo "Missing built dylib: $LIBSTUDY_DIR/$lib_name" >&2
    rm -rf "$staging_dir"
    return 1
  fi

  cp -f "$LIBSTUDY_DIR/$lib_name" "$frameworks_dir/$lib_name"

  if [[ "$arch" == "arm64" ]]; then
    rm -f "$frameworks_dir/libstudy-amd.dylib"
  else
    rm -f "$frameworks_dir/libstudy-arm.dylib"
  fi

  echo "==> Fix dylib install_name / linkage (${arch}, ${lib_name})"
  "$FIX_SCRIPT" "$staged_app_path" "$lib_name"

  thin_app_to_arch "$staged_app_path" "$arch"

  # Include an uninstall helper script (macOS drag-to-trash doesn't run uninstall hooks).
  if [[ -f "$UNINSTALL_SCRIPT_SRC" ]]; then
    cp "$UNINSTALL_SCRIPT_SRC" "$staging_dir/Uninstall ARO.command"
    chmod +x "$staging_dir/Uninstall ARO.command" || true
  fi
  ln -s /Applications "$staging_dir/Applications"

  # Best-effort remove quarantine attributes locally (won't affect files after download on another Mac).
  if command -v xattr >/dev/null 2>&1; then
    xattr -cr "$staged_app_path" >/dev/null 2>&1 || true
  fi

  rm -f "$dmg_path" || true
  hdiutil create -volname "$dmg_volume_name" -srcfolder "$staging_dir" -ov -format UDZO "$dmg_path" >/dev/null

  rm -rf "$staging_dir"
}

cd "$APP_DIR"

VERSION=$(grep '^version:' pubspec.yaml | awk '{print $2}' | cut -d+ -f1)
DATE_TAG=$(date +%Y%m%d_%H%M)
DMG_NAME_ARM64="aro_client-${VERSION}-${DATE_TAG}.dmg"
DMG_NAME_INTEL="aro_client-${VERSION}-${DATE_TAG}-intel.dmg"

DMG_PATH_ARM64="$RELEASE_DIR/$DMG_NAME_ARM64"
DMG_PATH_INTEL="$RELEASE_DIR/$DMG_NAME_INTEL"

echo "==> Build libstudy dylibs for macOS (arm64 + x86_64)"
LIBSTUDY_DIR="$ROOT_DIR/core/pkg/libstudy"
cd "$LIBSTUDY_DIR"
rm -f libstudy-arm.dylib libstudy-amd.dylib || true

echo "    - arm64"
CGO_ENABLED=1 GOOS=darwin GOARCH=arm64 \
  CGO_CFLAGS="-arch arm64" CGO_LDFLAGS="-arch arm64" \
  go build -buildmode=c-shared -ldflags="-w -s" -o libstudy-arm.dylib study.go

echo "    - x86_64"
CGO_ENABLED=1 GOOS=darwin GOARCH=amd64 \
  CGO_CFLAGS="-arch x86_64" CGO_LDFLAGS="-arch x86_64" \
  go build -buildmode=c-shared -ldflags="-w -s" -o libstudy-amd.dylib study.go

FLUTTER_MACOS_FFI_DIR="$APP_DIR/lib/ffi/macos"
mkdir -p "$FLUTTER_MACOS_FFI_DIR"
cp -f "$LIBSTUDY_DIR/libstudy-arm.dylib" "$FLUTTER_MACOS_FFI_DIR/libstudy-arm.dylib"
cp -f "$LIBSTUDY_DIR/libstudy-amd.dylib" "$FLUTTER_MACOS_FFI_DIR/libstudy-amd.dylib"
echo "    Copied to: $FLUTTER_MACOS_FFI_DIR/libstudy-arm.dylib, libstudy-amd.dylib"

cd "$APP_DIR"

echo "==> Flutter deps"
flutter pub get

echo "==> Build macOS release"
flutter build macos --release

echo "==> Resolve built app bundle"
resolve_release_app_path
APP_BUNDLE_NAME="$(basename "$APP_PATH")"

if [[ ! -x "$FIX_SCRIPT" ]]; then
  echo "Fix script not found/executable: $FIX_SCRIPT" >&2
  echo "Expected it from repo root." >&2
  exit 1
fi

create_dmg_for_arch arm64 "$DMG_PATH_ARM64"
create_dmg_for_arch x86_64 "$DMG_PATH_INTEL"

echo "==> Done"
echo "DMG (arm64): $DMG_PATH_ARM64"
echo "DMG (intel): $DMG_PATH_INTEL"
echo "Tip for testers (if blocked): right-click Open, or run: xattr -dr com.apple.quarantine /Applications/$APP_BUNDLE_NAME"