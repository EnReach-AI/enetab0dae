#!/usr/bin/env bash
set -euo pipefail

APP_NAME="ARO Desktop"
BUNDLE_ID="com.aro.aroApp"

# If this script is run via sudo, $HOME may point to /var/root.
# Always remove data for the original user running the script.
TARGET_USER="${SUDO_USER:-${USER}}"
TARGET_HOME="$(dscl . -read "/Users/${TARGET_USER}" NFSHomeDirectory 2>/dev/null | awk '{print $2}' || true)"
if [[ -z "${TARGET_HOME}" ]]; then
  TARGET_HOME="$(eval echo "~${TARGET_USER}" 2>/dev/null || true)"
fi
if [[ -z "${TARGET_HOME}" || ! -d "${TARGET_HOME}" ]]; then
  echo "Failed to resolve home directory for user: ${TARGET_USER}" >&2
  exit 1
fi

echo "This will uninstall ${APP_NAME} and delete related data files." 
echo
echo "It will remove (if present):"
echo "- /Applications/${APP_NAME}.app"
echo "- ${TARGET_HOME}/Library/Application Support/${BUNDLE_ID}"
echo "- ${TARGET_HOME}/Library/Application Support/${APP_NAME}"
echo "- ${TARGET_HOME}/Library/Caches/${BUNDLE_ID}"
echo "- ${TARGET_HOME}/Library/Preferences/${BUNDLE_ID}.plist"
echo "- ${TARGET_HOME}/Library/Saved Application State/${BUNDLE_ID}.savedState"
echo "- ${TARGET_HOME}/Library/Application Support/ARO (config.env)"
echo "- ${TARGET_HOME}/.aro (config.env)"
echo "- ${TARGET_HOME}/Library/Logs/libstudy.log"
echo
read -r -p "Continue? [y/N] " REPLY
case "${REPLY}" in
  y|Y|yes|YES) ;;
  *) echo "Aborted."; exit 1 ;;
esac

echo
echo "==> Quit running app (best-effort)"
osascript -e 'tell application "ARO Desktop" to quit' >/dev/null 2>&1 || true
sleep 1

echo "==> Remove app bundle"
if [[ -d "/Applications/${APP_NAME}.app" ]]; then
  if rm -rf "/Applications/${APP_NAME}.app" >/dev/null 2>&1; then
    :
  else
    echo "    Permission denied; trying with sudo (you may be prompted)"
    sudo rm -rf "/Applications/${APP_NAME}.app" >/dev/null 2>&1 || true
  fi
fi

echo "==> Remove user data"
rm -rf "${TARGET_HOME}/Library/Application Support/${BUNDLE_ID}" || true
rm -rf "${TARGET_HOME}/Library/Application Support/com.aro.aroApp" || true
rm -rf "${TARGET_HOME}/Library/Application Support/${APP_NAME}" || true
rm -rf "${TARGET_HOME}/Library/Caches/${BUNDLE_ID}" || true
rm -f  "${TARGET_HOME}/Library/Preferences/${BUNDLE_ID}.plist" || true
rm -rf "${TARGET_HOME}/Library/Saved Application State/${BUNDLE_ID}.savedState" || true

echo "==> Remove shared config/log locations"
rm -rf "${TARGET_HOME}/Library/Application Support/ARO" || true
rm -rf "${TARGET_HOME}/.aro" || true
rm -f  "${TARGET_HOME}/Library/Logs/libstudy.log" || true

echo
echo "Done. If Finder still shows the app, reopen Finder or log out/in." 
