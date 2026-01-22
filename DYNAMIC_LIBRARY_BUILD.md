# 动态库编译指南

## 概述

该项目的 Go 核心模块已配置为编译成动态库（.so/.dylib/.dll），可通过 dlopen 被外部程序调用（如 Flutter FFI、Python ctypes 等）。

## 编译模式

使用 `c-shared` buildmode，这是唯一支持 dlopen 调用的模式。

**不支持泛型**：c-shared 模式不支持 Go 的泛型。API 设计使用 `interface{}` 处理动态类型。

## 编译命令

### Linux x64

```bash
cd core
GOOS=linux GOARCH=amd64 CGO_ENABLED=1 go build -buildmode=c-shared -o ../plugins/linux/libstudy.so ./pkg/libstudy
```

**输出**：
- 库文件：`plugins/linux/libstudy.so`
- 大小：约 9.2MB（包含调试符号）
- 剥离调试符号：`strip libstudy.so`（减至 ~4-5MB）

### macOS ARM64 (Apple Silicon)

```bash
GOOS=darwin GOARCH=arm64 CGO_ENABLED=1 go build -buildmode=c-shared -o ../plugins/macos/libstudy.dylib ./pkg/libstudy
```

**输出**：`plugins/macos/libstudy.dylib`

### macOS x64 (Intel)

```bash
GOOS=darwin GOARCH=amd64 CGO_ENABLED=1 go build -buildmode=c-shared -o ../plugins/macos/libstudy_x64.dylib ./pkg/libstudy
```

**输出**：`plugins/macos/libstudy_x64.dylib`

### Windows x64

```bash
GOOS=windows GOARCH=amd64 CGO_ENABLED=1 go build -buildmode=c-shared -o ../plugins/windows/libstudy.dll ./pkg/libstudy
```

**输出**：`plugins/windows/libstudy.dll`

### Android ARM64

```bash
GOOS=android GOARCH=arm64 CGO_ENABLED=1 go build -buildmode=c-shared -o ../plugins/android/libstudy.so ./pkg/libstudy
```

**输出**：`plugins/android/libstudy.so`

## 一键编译脚本

项目提供 `scripts/build_go_libs.sh`：

```bash
cd scripts
./build_go_libs.sh
```

该脚本自动编译所有支持的平台。

## 导出的 C 函数

所有函数都以 `//export` 注释标记，供 C/FFI 调用：

### 密钥管理
- `InitKeyPair(baseDir *C.char) int` - 初始化密钥对
- `GetPublicKey() *C.char` - 获取公钥
- `RegisterNode(clientId *C.char, ip *C.char, port C.int) *C.char` - 注册节点

### API 调用
- `SetAPIURL(url *C.char)` - 设置 API URL
- `SetWSURL(url *C.char)` - 设置 WebSocket URL
- `NodeSignUp(publicKeyPem *C.char) *C.char` - 节点注册
- `GetNodeStat() *C.char` - 获取节点统计
- `GetRewards() *C.char` - 获取奖励信息


## 返回值格式

所有返回字符串的函数都返回 JSON 格式的响应：

```json
{
  "code": 0,
  "message": "success",
  "data": {
    // 具体数据
  }
}
```

错误响应：

```json
{
  "error": "error message"
}
```

## 调用示例

### Flutter FFI 调用

```dart
import 'dart:ffi' as ffi;

class StudyLib {
  final ffi.DynamicLibrary _lib;
  
  StudyLib(String libPath) 
    : _lib = ffi.DynamicLibrary.open(libPath);
  
  void initKeyPair(String keyDir) {
    final initKeyPair = _lib
      .lookup<ffi.NativeFunction<ffi.Int Function(ffi.Pointer<ffi.Char>)>>('InitKeyPair')
      .asFunction<int Function(ffi.Pointer<ffi.Char>)>();
    
    final dir = keyDir.toNativeUtf8();
    final result = initKeyPair(dir.cast());
    // 处理结果
  }
  
  String getNodeStat() {
    final getStat = _lib
      .lookup<ffi.NativeFunction<ffi.Pointer<ffi.Char> Function()>>('GetNodeStat')
      .asFunction<ffi.Pointer<ffi.Char> Function()>();
    
    final result = getStat();
    final jsonString = ffi.Utf8.fromUtf8(result.cast());
    return jsonString;
  }
}
```

### Python ctypes 调用

```python
import ctypes
import json

lib = ctypes.CDLL('./libstudy.so')

# 初始化密钥对
result = lib.InitKeyPair(b'.')

# 获取节点统计
get_stat = lib.GetNodeStat
get_stat.restype = ctypes.c_char_p
json_result = get_stat()
data = json.loads(json_result)
print(data)
```

### C 代码调用

```c
#include "libstudy.h"
#include <stdio.h>

int main() {
    // 初始化密钥对
    int result = InitKeyPair(".");
    if (result != 0) {
        printf("Failed to initialize keypair\n");
        return 1;
    }
    
    // 获取节点统计
    char *json_result = GetNodeStat();
    printf("Node stat: %s\n", json_result);
    
    return 0;
}
```

## 编译选项详解

### GOOS 和 GOARCH

| GOOS   | GOARCH  | 平台           |
|--------|---------|-----------------|
| linux  | amd64   | Linux x64       |
| linux  | arm64   | Linux ARM64     |
| darwin | amd64   | macOS Intel     |
| darwin | arm64   | macOS Apple Si  |
| windows| amd64   | Windows x64     |
| android| arm64   | Android ARM64   |

### CGO_ENABLED

必须设置为 1，因为代码使用了 C 类型（C.char 等）

### buildmode=c-shared

- 生成共享库，支持 dlopen 动态加载
- 包含完整的 Go runtime
- 库文件较大（~9MB）

## 故障排除

### 错误："method must have no type parameters"

**原因**：c-shared 不支持泛型

**解决**：使用 interface{} 或具体类型

### 编译找不到编译器

**Linux**：安装 build-essential
```bash
sudo apt-get install build-essential
```

**macOS**：安装 Xcode Command Line Tools
```bash
xcode-select --install
```

**Windows**：安装 MinGW 或 Visual Studio

### 库太大

**解决**：剥离调试符号
```bash
strip libstudy.so
```

## 性能优化

1. **禁用符号**：
   ```bash
   go build -ldflags="-s -w" -buildmode=c-shared ...
   ```

2. **优化编译**：
   ```bash
   go build -ldflags="-s -w" -gcflags="-O=3" -buildmode=c-shared ...
   ```

## 版本管理

在 libstudy/study.go 中定义版本常数：

```go
const LibVersion = "1.0.0"

//export GetVersion
func GetVersion() *C.char {
    return C.CString(LibVersion)
}
```

## 支持的平台

✅ Linux x64, ARM64
✅ macOS x64, ARM64 (Apple Silicon)
✅ Windows x64
✅ Android ARM64

⚠️ iOS：需要特殊处理（静态库）
⚠️ WebAssembly：不支持 dlopen

## 相关文档

- [Go CGO 文档](https://golang.org/cmd/cgo/)
- [Go buildmode 参考](https://golang.org/pkg/cmd/go/internal/load/)
- [Flutter FFI 指南](https://flutter.dev/docs/development/platform-integration/c-interop)
