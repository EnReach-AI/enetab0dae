//go:build windows
// +build windows

package agentservice

import (
	"os/exec"
	"syscall"
)

// hideCommandWindow 在Windows上隐藏命令行窗口
func hideCommandWindow(cmd *exec.Cmd) {
	cmd.SysProcAttr = &syscall.SysProcAttr{
		HideWindow:    true,
		CreationFlags: 0x08000000, // CREATE_NO_WINDOW
	}
}
