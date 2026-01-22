package config

// 配置常量定义

// API 相关配置 key
const (
	KeyAPIURL   = "API_URL"
	KeyWSURL    = "WS_URL"
	KeyClientId = "CLIENT_ID"
	KeySN       = "SERIAL_NUMBER"
	USER_ID     = "USER_ID"
	EMAIL       = "EMAIL"
)

// 日志相关配置 key
const (
	KeyLogLevel = "LOG_LEVEL"
	KeyLogFile  = "LOG_FILE"
)

// 存储相关配置 key
const (
	KeyKeypairPath = "KEYPAIR_PATH"
	KeyStoragePath = "STORAGE_PATH"
)

// 网络相关配置 key
const (
	KeyTimeout       = "TIMEOUT"
	KeyRetryCount    = "RETRY_COUNT"
	KeyRetryInterval = "RETRY_INTERVAL"
)

// 环境相关配置 key
const (
	KeyEnv        = "ENV"
	KeyProgramApp = "PROGRAM_APP"
	KeyDebug      = "DEBUG"
)

// 环境值
const (
	EnvTestnet = "testnet"
	EnvMainnet = "mainnet"
)

// 日志级别
const (
	LogLevelDebug = "debug"
	LogLevelInfo  = "info"
	LogLevelWarn  = "warn"
	LogLevelError = "error"
)
