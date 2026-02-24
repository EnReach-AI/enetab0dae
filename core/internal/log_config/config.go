package logconfig

import (
	"aro-ext-app/core/internal/config"
	"aro-ext-app/core/internal/constant"
	"fmt"
	"io"
	"io/ioutil"
	"log"
	"os"
	"path"
	"path/filepath"
	"runtime"
	"strings"
	"time"
)

var cfg = config.GetConfig()



func GetLogFilePath() string {
	// 尝试在当前工作目录的 log 子目录中创建日志
	workDir := cfg.Get(config.KeyAgentPath)
	logDir := filepath.Join(workDir, "log")
	if err := os.MkdirAll(logDir, 0755); err == nil {
		logPath := filepath.Join(logDir, "libstudy.log")
		// 测试是否可写
		if f, err := os.OpenFile(logPath, os.O_CREATE|os.O_APPEND|os.O_WRONLY, 0644); err == nil {
			f.Close()
			return logPath
		}
	}
	// 备选方案：根据平台选择合适的默认位置
	switch runtime.GOOS {
	case "darwin":

		homeDir, err := os.UserHomeDir()
		if err != nil {
			break
		}
		logDir := filepath.Join(homeDir, "Library", "Logs")
		log.Printf("darwin log:%s", logDir)
		os.MkdirAll(logDir, 0755)
		return filepath.Join(logDir, "libstudy.log")
	case "windows":
		appDataDir := os.Getenv("APPDATA")
		if appDataDir == "" {
			break
		}
		logDir := filepath.Join(appDataDir, "libstudy", "log")
		os.MkdirAll(logDir, 0755)
		log.Printf("windows log:%s", logDir)
		return filepath.Join(logDir, "libstudy.log")
	}
	return filepath.Join(logDir, "libstudy.log")
}


func ClearLogAndLastVersion() {
	logPath := GetLogFilePath()
	ticker := time.NewTicker(constant.LOG_CHECK_INTERVAL)
	defer ticker.Stop()

	for range ticker.C {
		if err := truncateOversizedLogs(logPath); err != nil {
			log.Printf("Error truncating log files: %v", err)
		}
		if err := truncateOversizedLogs(filepath.Join(path.Dir(logPath), "proxy-worker.log")); err != nil {
			log.Printf("Error cleaning proxy-worker log: %v", err)
		}
	}
}


// TruncateOversizedLogs  truncate log files that exceed their size
func truncateOversizedLogs(dir string) error {
	files, err := ioutil.ReadDir(dir)
	if err != nil {
		return fmt.Errorf("failed to read directory: %v", err)
	}

	for _, file := range files {
		if file.IsDir() {
			continue
		}

		// Check whether it is a log file (adjust the extension according to the actual situation)
		if strings.HasSuffix(file.Name(), ".log") && file.Size() > int64(constant.MAX_LOG_SIZE) {
			log.Printf("Truncating log file %s (size: %d > max: %d)",
				file.Name(), file.Size(), constant.MAX_LOG_SIZE)

			if err := truncateFile(filepath.Join(dir, file.Name())); err != nil {
				return fmt.Errorf("failed to truncate log file %s: %v", file.Name(), err)
			}
		}
	}

	return nil
}

// truncateFile truncate the file to a specified size
func truncateFile(filePath string) error {
	file, err := os.OpenFile(filePath, os.O_RDWR, 0644)
	if err != nil {
		return err
	}
	defer file.Close()

	fileInfo, err := file.Stat()
	if err != nil {
		return err
	}

	// Calculate the amount of data that needs to be retained (from the end of the file)
	triggerSize := int64(constant.MAX_LOG_SIZE)
	if fileInfo.Size() < triggerSize {
		return nil
	}
	keepSize := int64(constant.RETAIN_LOG_SIZE) // 1MB
	// Calculate the amount of data that needs to be discarded
	discardSize := fileInfo.Size() - keepSize
	buf := make([]byte, keepSize)

	// read the last keepsize byte of data
	n, err := file.ReadAt(buf, discardSize)
	if err != nil && err != io.EOF {
		return fmt.Errorf("failed to read file: %v", err)
	}

	// truncate the file and write the retained data
	if err := file.Truncate(0); err != nil {
		return err
	}

	_, err = file.WriteAt(buf[:n], 0)
	return err
}
