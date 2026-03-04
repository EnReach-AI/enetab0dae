//go:build linux || android
// +build linux android

package agentservice

import (
	"os/exec"
)

// hideCommandWindow 在Linux/Android平台上是空操作
func hideCommandWindow(cmd *exec.Cmd) {
	// 在Linux/Android平台上不需要做任何事情
}
