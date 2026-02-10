package embedded

import (
	"embed"
	"fmt"
	"github.com/aro-network/aro-edge-agent/agent/constant"
	"io/fs"
	"io/ioutil"
	"log"
	"os"
	"os/exec"
	"path/filepath"
)

//go:embed scripts/*
var scriptFiles embed.FS

// GetScriptContent 获取脚本内容
func GetScriptContent(filename string) ([]byte, error) {
	return scriptFiles.ReadFile(filename) // 修正：直接使用文件名
}

// ListScripts 列出所有可用的脚本
func ListScripts() ([]string, error) {
	var scripts []string

	err := fs.WalkDir(scriptFiles, ".", func(path string, d fs.DirEntry, err error) error { // 修正：使用 "."
		if err != nil {
			return err
		}
		if !d.IsDir() && filepath.Ext(path) == ".sh" {
			scripts = append(scripts, filepath.Base(path))
		}
		return nil
	})

	return scripts, err
}

func GetAllScripts() (map[string][]byte, error) {
	scripts := make(map[string][]byte)

	// 遍历所有嵌入的文件
	err := fs.WalkDir(scriptFiles, ".", func(path string, d fs.DirEntry, err error) error {
		if err != nil {
			return err
		}
		if !d.IsDir() {
			content, err := scriptFiles.ReadFile(path)
			if err != nil {
				return err
			}
			scripts[filepath.Base(path)] = content
		}
		return nil
	})

	return scripts, err
}

// ExtractAndRunScript 提取并执行脚本
func ExtractAndRunScript(scriptName string) error {
	// 获取脚本内容
	scriptContent, err := GetScriptContent(scriptName)
	if err != nil {
		return fmt.Errorf("failed to get script %s: %v", scriptName, err)
	}

	// 创建scripts目录
	scriptsDir := filepath.Join(".", "scripts")
	err = os.MkdirAll(scriptsDir, 0755)
	if err != nil {
		return fmt.Errorf("failed to create scripts directory: %v", err)
	}

	// 在scripts目录下创建脚本文件
	scriptPath := filepath.Join(scriptsDir, scriptName)

	// 写入脚本内容
	err = ioutil.WriteFile(scriptPath, scriptContent, 0755)
	if err != nil {
		return fmt.Errorf("failed to write script to file: %v", err)
	}

	// 执行脚本
	cmd := exec.Command("bash", scriptPath)
	cmd.Stdout = os.Stdout
	cmd.Stderr = os.Stderr

	log.Printf("Executing script: %s\n", scriptPath)
	err = cmd.Run()
	if err != nil {
		return fmt.Errorf("failed to execute script %s: %v", scriptName, err)
	}

	return nil
}

func ExtractAllScripts() error {
	scripts, err := GetAllScripts()
	if err != nil {
		log.Printf("Failed to get all scripts:%+v", err)
		return err
	}
	// 创建scripts目录在程序当前目录下
	scriptsDir := filepath.Join(constant.AGENT_DIR_PATH, "scripts")
	err = os.MkdirAll(scriptsDir, 0755)
	if err != nil {
		log.Printf("Failed to create scripts directory:%+v", err)
		return fmt.Errorf("failed to create scripts directory: %v", err)
	}

	// 提取所有脚本到scripts目录
	for name, content := range scripts {
		scriptPath := filepath.Join(scriptsDir, name)
		err = ioutil.WriteFile(scriptPath, content, 0755)
		if err != nil {
			log.Printf("Failed to write script %s:%+v", name, err)
			return fmt.Errorf("failed to write script %s: %v", name, err)
		}
		log.Printf("Extracted script: %s\n", scriptPath)
	}
	return nil
}

// ExtractScript 提取单个脚本到scripts目录
func ExtractScript(scriptName string) error {
	// 获取脚本内容
	scriptContent, err := GetScriptContent(scriptName)
	if err != nil {
		return fmt.Errorf("failed to get script %s: %v", scriptName, err)
	}

	// 创建scripts目录
	scriptsDir := filepath.Join(".", "scripts")
	err = os.MkdirAll(scriptsDir, 0755)
	if err != nil {
		return fmt.Errorf("failed to create scripts directory: %v", err)
	}

	// 写入脚本文件
	scriptPath := filepath.Join(scriptsDir, scriptName)
	err = ioutil.WriteFile(scriptPath, scriptContent, 0755)
	if err != nil {
		return fmt.Errorf("failed to write script %s: %v", scriptName, err)
	}

	log.Printf("Extracted script: %s\n", scriptPath)
	return nil
}
