//go:build darwin
// +build darwin

package agentservice

import (
	"os/exec"
	"syscall"
)

// hideCommandWindow 在macOS上隐藏命令行窗口
// 使用 Setpgid 将进程放到新的进程组，避免终端窗口闪现
func hideCommandWindow(cmd *exec.Cmd) {
	cmd.SysProcAttr = &syscall.SysProcAttr{
		// 在新的进程组中运行，避免终端窗口显示
		Setpgid: true,
		Pgid:    0,
	}
}
