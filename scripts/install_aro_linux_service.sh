#!/bin/bash
# Install and start aro_linux systemd service

SERVICE_FILE="$(dirname "$0")/../apps/aro_linux/aro_linux.service"
TARGET_SERVICE="/etc/systemd/system/aro_linux.service"

if [ "$(uname -s)" = "Linux" ]; then
    echo "🔄 Installing systemd service..."
     cp "$SERVICE_FILE" "$TARGET_SERVICE"
     systemctl daemon-reload
     systemctl enable aro_linux.service
     systemctl start aro_linux.service
    echo "✅ systemd service installed and started."
else
    echo "❌ Systemd service installation is not supported on this platform."
fi
