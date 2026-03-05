#!/usr/bin/env bash
set -euo pipefail

APP_PATH="${1:-/Users/lee/aro-ext-app-other/apps/aro_client/build/macos/Build/Products/Release/aro_client.app}"
LIB_NAME="${2:-}"

if [[ ! -d "$APP_PATH" ]]; then
  echo "App not found: $APP_PATH" >&2
  echo "Usage: $0 /path/to/Your.app" >&2
  exit 1
fi

INFO_PLIST="$APP_PATH/Contents/Info.plist"
if [[ ! -f "$INFO_PLIST" ]]; then
  echo "Info.plist not found: $INFO_PLIST" >&2
  exit 1
fi

if ! command -v /usr/libexec/PlistBuddy >/dev/null 2>&1; then
  echo "PlistBuddy not found (/usr/libexec/PlistBuddy)" >&2
  exit 1
fi

EXECUTABLE_NAME=$(/usr/libexec/PlistBuddy -c 'Print :CFBundleExecutable' "$INFO_PLIST" 2>/dev/null || true)
if [[ -z "$EXECUTABLE_NAME" ]]; then
  echo "Failed to read CFBundleExecutable from $INFO_PLIST" >&2
  exit 1
fi

EXE_PATH="$APP_PATH/Contents/MacOS/$EXECUTABLE_NAME"
FRAMEWORKS_DIR="$APP_PATH/Contents/Frameworks"

if [[ ! -f "$EXE_PATH" ]]; then
  echo "Executable not found: $EXE_PATH" >&2
  exit 1
fi

if [[ -n "$LIB_NAME" ]]; then
  CANDIDATE_LIBS=("$LIB_NAME")
else
  CANDIDATE_LIBS=("libstudy-arm.dylib" "libstudy-amd.dylib" "libstudy.dylib")
fi

LIB_PATH=""
for candidate_name in "${CANDIDATE_LIBS[@]}"; do
  candidate_path="$FRAMEWORKS_DIR/$candidate_name"
  if [[ -f "$candidate_path" ]]; then
    LIB_NAME="$candidate_name"
    LIB_PATH="$candidate_path"
    break
  fi
done

if [[ -z "$LIB_PATH" ]]; then
  echo "Embedded study library not found in: $FRAMEWORKS_DIR" >&2
  echo "Tried names: ${CANDIDATE_LIBS[*]}" >&2
  echo "Expected it under Contents/Frameworks/." >&2
  exit 1
fi

TARGET_ID="@rpath/$LIB_NAME"

echo "Fixing macOS dylib linkage in: $APP_PATH (library: $LIB_NAME)"

# 1) Ensure the embedded dylib has a proper install name.
install_name_tool -id "$TARGET_ID" "$LIB_PATH"

# 2) Update the app executable to reference the embedded dylib via @rpath.
for old_name in \
  "libstudy.dylib" \
  "libstudy-arm.dylib" \
  "libstudy-amd.dylib" \
  "@rpath/libstudy.dylib" \
  "@rpath/libstudy-arm.dylib" \
  "@rpath/libstudy-amd.dylib"; do
  install_name_tool -change "$old_name" "$TARGET_ID" "$EXE_PATH" 2>/dev/null || true
done

# 3) Re-sign ad-hoc so the bundle remains runnable after modifications.
#    Gatekeeper will still reject unsigned/notarized apps, but this prevents
#    the app from failing due to an invalid code signature.
if command -v codesign >/dev/null 2>&1; then
  codesign --force --deep --sign - "$APP_PATH" >/dev/null 2>&1 || true
fi

echo "--- Verification (otool -L) ---"
otool -L "$EXE_PATH" | sed -n '1,80p'
echo "--- Embedded lib (otool -L) ---"
otool -L "$LIB_PATH" | sed -n '1,80p'

echo "Done. If you distribute this app, you still need to remove quarantine (xattr) or notarize/sign properly."