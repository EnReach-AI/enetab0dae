#!/usr/bin/env sh
set -e

# Refresh desktop database (if available)
if command -v update-desktop-database >/dev/null 2>&1; then
  update-desktop-database -q || true
fi

# Refresh icon cache (if available)
if command -v gtk-update-icon-cache >/dev/null 2>&1; then
  gtk-update-icon-cache -q -t -f /usr/share/icons/hicolor || true
fi
