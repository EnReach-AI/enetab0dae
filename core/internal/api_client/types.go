package api_client

// APIResponse Standard response structure (compatible with aro-ext-ui design)
// Uses interface{} instead of generics for c-shared compatibility
type APIResponse struct {
	Code    int         `json:"code"`
	Message string      `json:"message"`
	Data    interface{} `json:"data"`
}

// APIResponseWith Generic version of APIResponse to support typed data
type APIResponseWith[T any] struct {
	Code    int    `json:"code"`
	Message string `json:"message"`
	Data    T      `json:"data"`
}

// ======================
// ARO Lite Node APIs
// ======================

// NodeSignUpRequest Node registration request body (mimics aro-ext-ui /api/liteNode/signUp)
type NodeSignUpRequest struct {
	ClientID  string `json:"clientId"`  // Node ID
	PublicKey string `json:"publicKey"` // RSA public key (base64 encoded)
	Signature string `json:"signature"` // Signature
	Timestamp int64  `json:"timestamp"` // Timestamp
}

// NodeReportBaseInfoRequest System information report request
type NodeReportBaseInfoRequest struct {
	UserAgent   string `json:"userAgent"`   // Browser User-Agent
	Language    string `json:"language"`    // Language setting
	IsMobile    bool   `json:"isMobile"`    // Is mobile device
	SysPlatform string `json:"sysPlatform"` // System platform
	SysCPU      int    `json:"sysCpu"`      // CPU cores
	TimeZone    string `json:"timeZone"`    // Timezone
	NodeID      string `json:"nodeId"`      // Node ID
}
