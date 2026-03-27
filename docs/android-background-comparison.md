# Android 后台执行对比分析：Grass vs ARO Mobile

> 比较 `apps/grass-jadx-reversed`（反编译的 Grass 项目）与 `apps/aro_client`（ARO Mobile 项目）在 Android 后台执行方面的权限声明与功能实现差异。

---

## 一、权限对比

```
┌──────────────────────────────────────────────────────────┬───────┬─────────────┐
│ 权限                                                      │ Grass │ ARO Mobile  │
├──────────────────────────────────────────────────────────┼───────┼─────────────┤
│ INTERNET                                                  │   ✅  │     ✅      │
│ ACCESS_NETWORK_STATE                                      │   ✅  │     ✅      │
│ RECEIVE_BOOT_COMPLETED                                    │   ✅  │     ✅      │
│ FOREGROUND_SERVICE                                        │   ✅  │     ✅      │
│ FOREGROUND_SERVICE_REMOTE_MESSAGING                       │   ✅  │     ❌      │
│ FOREGROUND_SERVICE_DATA_SYNC                              │   ❌  │     ✅      │
│ WAKE_LOCK                                                 │   ✅  │     ✅      │
│ SYSTEM_ALERT_WINDOW                                       │   ✅  │     ❌      │
│ REQUEST_IGNORE_BATTERY_OPTIMIZATIONS                      │   ✅  │     ✅      │
│ POST_NOTIFICATIONS                                        │   ✅  │     ✅      │
│ REQUEST_INSTALL_PACKAGES                                  │   ✅  │     ❌      │
└──────────────────────────────────────────────────────────┴───────┴─────────────┘
```

### 权限差异说明

| 权限 | Grass 用途 | ARO Mobile 说明 |
|------|-----------|----------------|
| `FOREGROUND_SERVICE_REMOTE_MESSAGING` | 前台服务类型为 `remoteMessaging` | ARO 前台服务类型为 `dataSync`，不需要此权限 |
| `FOREGROUND_SERVICE_DATA_SYNC` | 未使用 | ARO 服务声明 `foregroundServiceType="dataSync"`，必须有此权限 |
| `SYSTEM_ALERT_WINDOW` | 允许在其他应用上显示悬浮窗 | ARO 无悬浮窗功能，不需要此权限 |
| `REQUEST_INSTALL_PACKAGES` | 支持应用内安装 APK（自动更新） | ARO 无安装包功能，不需要此权限 |

---

## 二、前台服务对比

### Grass — `io.getgrass.plugin.ForegroundService`

**文件：** `apps/grass-jadx-reversed/app/src/main/java/io/getgrass/plugin/ForegroundService.java`

```xml
<service
    android:name="io.getgrass.plugin.ForegroundService"
    android:enabled="true"
    android:exported="false"
    android:foregroundServiceType="remoteMessaging"/>
```

**关键行为：**
- `onStartCommand()` 返回 `START_STICKY`，进程被杀后系统自动重启
- 调用 Rust 原生库（`rust_wynd_proxy`）启动 WebSocket 代理
- 使用 `Handler` 启动定期轮询心跳
- 调用 `startForeground(-1, notification)` 保持前台状态

---

### ARO Mobile — `com.aro.aro_mobile.ForegroundService`

**文件：** `apps/aro_client/android/app/src/main/kotlin/com/aro/aro_mobile/ForegroundService.kt`

```xml
<service
    android:name=".ForegroundService"
    android:exported="false"
    android:process=":bg"
    android:foregroundServiceType="dataSync" />
```

**关键行为：**
- `onStartCommand()` 返回 `START_STICKY`，进程被杀后系统自动重启
- 在独立进程（`:bg`）中运行，与主进程隔离
- 通过 Flutter 无头引擎（`backgroundMain` 入口）执行 Dart 业务逻辑
- 使用 `Handler`（5 秒间隔）启动心跳日志
- 使用 `AlarmManager.setAndAllowWhileIdle()` 设置 15 分钟保活闹钟
- `onTaskRemoved()` 中主动重启服务，防止被系统彻底杀死
- `onDestroy()` 中保留 Flutter 引擎实例，供下次启动复用

---

### 前台服务对比表

```
┌───────────────────────────────┬──────────────────────────┬─────────────────────────────┐
│ 特性                           │ Grass                    │ ARO Mobile                  │
├───────────────────────────────┼──────────────────────────┼─────────────────────────────┤
│ foregroundServiceType         │ remoteMessaging          │ dataSync                    │
│ 运行进程                       │ 主进程                    │ 独立进程 (:bg)               │
│ 核心执行引擎                   │ Rust 原生库               │ Flutter Dart 无头引擎        │
│ 心跳机制                       │ Handler（间隔不固定）      │ Handler（5 秒间隔）          │
│ 保活闹钟                       │ 无                       │ AlarmManager（15 分钟）      │
│ 任务移除后重启                  │ 无特殊处理                │ onTaskRemoved() 主动重启     │
│ 引擎持久化                     │ 销毁即释放                │ onDestroy() 中保留引擎       │
│ START_STICKY                  │ ✅                       │ ✅                          │
└───────────────────────────────┴──────────────────────────┴─────────────────────────────┘
```

---

## 三、唤醒锁（WakeLock）对比

### Grass

```java
// ForegroundService.java — onCreate()
PowerManager.WakeLock wakeLock = powerManager.newWakeLock(
    PowerManager.PARTIAL_WAKE_LOCK, // 值为 1
    "grass:wakeLock"
);
wakeLock.acquire();
```

### ARO Mobile

```kotlin
// ForegroundService.kt — acquireWakeLock()
wakeLock = pm.newWakeLock(
    PowerManager.PARTIAL_WAKE_LOCK,
    "AroMobile:BackgroundServiceLock"
).apply {
    setReferenceCounted(false)
    acquire()
}
```

### WakeLock 对比表

```
┌─────────────────────┬────────────────────┬────────────────────────────────┐
│ 特性                 │ Grass              │ ARO Mobile                     │
├─────────────────────┼────────────────────┼────────────────────────────────┤
│ 锁类型               │ PARTIAL_WAKE_LOCK  │ PARTIAL_WAKE_LOCK              │
│ 标签                 │ "grass:wakeLock"   │ "AroMobile:BackgroundServiceLock" │
│ 引用计数             │ 默认（开启）        │ 显式关闭（setReferenceCounted(false)） │
│ 获取时机             │ onCreate()         │ onStartCommand()               │
│ 释放检查             │ 直接释放            │ 先检查 isHeld()                 │
│ 错误处理             │ 无                 │ try-catch + 日志                │
└─────────────────────┴────────────────────┴────────────────────────────────┘
```

---

## 四、开机自启对比

### Grass — `app.tauri.notification.LocalNotificationRestoreReceiver`

```xml
<receiver
    android:name="app.tauri.notification.LocalNotificationRestoreReceiver"
    android:exported="false"
    android:directBootAware="true">
    <intent-filter>
        <action android:name="android.intent.action.LOCKED_BOOT_COMPLETED"/>
        <action android:name="android.intent.action.BOOT_COMPLETED"/>
        <action android:name="android.intent.action.QUICKBOOT_POWERON"/>
    </intent-filter>
</receiver>
```

**职责：** 设备启动后恢复通知调度，不直接启动前台服务。

---

### ARO Mobile — `com.aro.aro_mobile.BootReceiver`

```xml
<receiver
    android:name=".BootReceiver"
    android:enabled="true"
    android:exported="true"
    android:directBootAware="true">
    <intent-filter>
        <action android:name="android.intent.action.BOOT_COMPLETED" />
        <action android:name="android.intent.action.LOCKED_BOOT_COMPLETED" />
        <action android:name="android.intent.action.MY_PACKAGE_REPLACED" />
    </intent-filter>
</receiver>
```

**职责：** 检查用户是否已解锁，若未解锁则注册动态监听器等待 `ACTION_USER_UNLOCKED` 后再启动前台服务。额外监听 `MY_PACKAGE_REPLACED`，应用更新后自动重启服务。

### 开机接收器对比表

```
┌──────────────────────────┬──────────────────────────┬────────────────────────────────┐
│ 特性                      │ Grass                    │ ARO Mobile                     │
├──────────────────────────┼──────────────────────────┼────────────────────────────────┤
│ 监听事件                  │ BOOT_COMPLETED           │ BOOT_COMPLETED                 │
│                          │ LOCKED_BOOT_COMPLETED    │ LOCKED_BOOT_COMPLETED          │
│                          │ QUICKBOOT_POWERON        │ MY_PACKAGE_REPLACED            │
│ exported                 │ false                    │ false ✅（已修复）              │
│ directBootAware          │ true                     │ true                           │
│ 启动行为                  │ 恢复通知调度              │ 启动前台服务                    │
│ 解锁检测                  │ 无动态注册                │ 注册 ACTION_USER_UNLOCKED 监听  │
│ 安装后自启                │ 无                       │ 支持（MY_PACKAGE_REPLACED）     │
└──────────────────────────┴──────────────────────────┴────────────────────────────────┘
```

> ⚠️ **安全注意**：ARO 的 `BootReceiver` 原先设置了 `android:exported="true"`，外部应用可以发送 Intent 触发此接收器，存在被恶意第三方触发服务启动的风险。已将其修改为 `exported="false"`——系统广播（`BOOT_COMPLETED`、`LOCKED_BOOT_COMPLETED`、`MY_PACKAGE_REPLACED`）仍可正常接收，但外部应用无法直接触发。

---

## 五、电池优化豁免对比

### Grass

```java
// ExamplePlugin.java（Tauri 插件 @Command）
@Command
@SuppressLint({"BatteryLife"})
public final void disableBatteryOptimizations(Invoke invoke) {
    Intent intent = new Intent(
        Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
    );
    intent.setData(Uri.parse("package:" + packageName));
    startActivity(intent);
}
```

### ARO Mobile

```kotlin
// MainActivity.kt（Flutter MethodChannel）
"requestIgnoreBatteryOptimizations" -> {
    val pm = getSystemService(POWER_SERVICE) as PowerManager
    if (!pm.isIgnoringBatteryOptimizations(packageName)) {
        val intent = Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS).apply {
            data = Uri.parse("package:$packageName")
        }
        startActivity(intent)
    }
    result.success(true)
}
```

两者功能相同，调用方式不同：Grass 通过 Tauri 插件暴露，ARO Mobile 通过 Flutter `MethodChannel` 暴露。ARO 额外检查当前状态，仅在未豁免时才弹出系统对话框。

---

## 六、保活策略总结

```
┌──────────────────────────────────┬──────────┬─────────────────────────────────────────────┐
│ 保活机制                          │ Grass    │ ARO Mobile                                  │
├──────────────────────────────────┼──────────┼─────────────────────────────────────────────┤
│ 前台服务 (START_STICKY)           │ ✅       │ ✅                                          │
│ WakeLock (PARTIAL_WAKE_LOCK)     │ ✅       │ ✅                                          │
│ 电池优化豁免请求                  │ ✅       │ ✅                                          │
│ 开机自启 (BOOT_COMPLETED)        │ ✅       │ ✅                                          │
│ AlarmManager 保活（15 分钟）      │ ❌       │ ✅                                          │
│ onTaskRemoved() 主动重启          │ ❌       │ ✅                                          │
│ 独立进程运行                      │ ❌       │ ✅ (android:process=":bg")                  │
│ 应用更新后自启                    │ ❌       │ ✅ (MY_PACKAGE_REPLACED)                    │
│ 直接启动感知 (directBootAware)    │ ✅       │ ✅                                          │
└──────────────────────────────────┴──────────┴─────────────────────────────────────────────┘
```

---

## 七、结论

| 维度 | Grass | ARO Mobile |
|------|-------|-----------|
| **技术栈** | Tauri + Rust 原生库 | Flutter + Dart 无头引擎 |
| **前台服务类型** | `remoteMessaging` | `dataSync` |
| **保活层次** | 单层（前台服务 + WakeLock） | 多层（前台服务 + WakeLock + AlarmManager + onTaskRemoved） |
| **权限精简度** | 权限较多（含悬浮窗、安装包等）| 权限按需申请，去除未使用项 |
| **安全风险** | BootReceiver exported=false（较安全）| BootReceiver exported=false（已修复，与 Grass 一致）|

ARO Mobile 在后台保活策略上比 Grass 更全面（多层保活），同时权限声明更精简，仅保留实际使用的权限。主要待优化点是将 `BootReceiver` 的 `exported` 属性设为 `false`，减少外部攻击面。
