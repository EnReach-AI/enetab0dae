package api_client

import (
	"aro-ext-app/core/internal/auth"
	"aro-ext-app/core/internal/config"
	"aro-ext-app/core/internal/constant"
	"aro-ext-app/core/internal/crypto"
	"aro-ext-app/core/internal/storage"
	"aro-ext-app/core/internal/ws_client"
	"encoding/json"
	"fmt"
	"runtime"
	"time"
)

// ======================
// ARO Lite Node Endpoints
// ======================

// NodeSignUp Node registration: create new node or update existing node info
// Corresponds to /api/liteNode/signUp POST request in aro-ext-ui
// Returns user and node information
//
// Request body:
//   - clientId: Node ID
//   - publicKey: RSA public key (PEM format, base64 encoded)
//   - signature: Digital signature
//   - timestamp: Request timestamp (milliseconds)
//
// Response data:
//   - user: User information
//   - node: Node information (nodeId, status, etc.)

var storageApi = storage.GetStorage()
var cfg = config.GetConfig()

func (c *APIClient) NodeSignUp() (*APIResponse, error) {
	sn := cfg.Get(config.KeySN)
	if sn != "" {
		var apiResponse = APIResponse{
			Code:    200,
			Message: "success",
			Data: map[string]interface{}{
				"serialNumber": sn,
			},
		}
		return &apiResponse, nil
	}
	timestamp := time.Now().UTC().Unix()
	signature := auth.GenerateRSASignature(c.ClientID, timestamp, c.PrivateKey)
	//storageApi.GetString(storage.PUBLIC_KEY)
	publicKey, err := crypto.ExportPublicKeyToPEM(c.PublicKey)
	if err != nil {
		return nil, err
	}

	req := NodeSignUpRequest{
		ClientID:  c.ClientID,
		PublicKey: publicKey,
		Signature: signature,
		Timestamp: time.Now().UTC().Unix(),
	}

	apiResponse, err := c.Post("/api/liteNode/signUp", req)
	if err != nil {
		return nil, err
	}

	sn = apiResponse.Data.(map[string]interface{})["serialNumber"].(string)
	NewBackendService(runtime.GOOS, sn)
	cfg.SetAndSave(config.KeySN, sn)

	return &APIResponse{
		Code:    apiResponse.Code,
		Message: apiResponse.Message,
		Data:    apiResponse.Data,
	}, nil
}

// NodeReportBaseInfo Report node basic information
// Endpoint: POST /api/liteNode/node/reportBaseInfo
//
// Used to report system information when node starts or updates
// This information helps the ARO network understand node capabilities
//
// Request body:
//   - userAgent: Browser User-Agent string
//   - language: Language preference (e.g., "en", "zh")
//   - isMobile: Whether running on mobile device
//   - sysPlatform: OS platform (e.g., "linux", "macos", "windows", "android")
//   - sysCpu: Number of CPU cores
//   - timeZone: Timezone offset
//   - nodeId: Node ID
//
// Response: Operation result (success/failure)
func (c *APIClient) NodeReportBaseInfo(sysInfo NodeReportBaseInfoRequest) (*APIResponse, error) {
	return c.Post("/api/liteNode/node/reportBaseInfo", sysInfo)
}

// GetNodeStat Get node statistics
// Endpoint: GET /api/liteNode/stat
//
// Returns current node status and statistics including:
// - User information (userId, walletAddress, etc.)
// - Node status (online/offline, uptime, etc.)
// - Current points balance
// - Network participation info
//
// Response data typically contains:
//   - user: User information
//   - node: Node status
//   - points: Current points balance
//   - stats: Various statistics
func (c *APIClient) GetNodeStat() (*APIResponse, error) {
	apiResponse, err := c.Get("/api/liteNode/stat")
	if err != nil {
		return nil, err
	}
	dataBytes, err := json.Marshal(apiResponse.Data)
	if err != nil {
		return nil, err
	}
	var bindUser storage.BindInfo
	err = json.Unmarshal(dataBytes, &bindUser)
	if err != nil {
		return nil, err
	}

	NewBackendService(runtime.GOOS, bindUser.SerialNumber)
	cfg.SetAndSave(config.KeySN, bindUser.SerialNumber)
	if bindUser.BindUser != nil {
		cfg.SetAndSave(config.USER_ID, bindUser.BindUser.UUID)
		cfg.SetAndSave(config.EMAIL, bindUser.BindUser.Email)
	}
	// Only start WebSocket if bound and not already running
	if bindUser.Bind && !ws_client.IsWebSocketRunning() {
		ws_client.StartWebSocketClient()
	}
	return apiResponse, nil
}

// GetRewards Get reward information
// Endpoint: GET /api/liteNode/rewards
//
// Returns reward-related information including:
// - Last network points earned
// - Total accumulated rewards
// - 7-day reward history
// - Reward calculation info
//
// Response data typically contains:
//   - lastNetworkPoints: Points from last cycle
//   - totalRewards: Total accumulated rewards
//   - weeklyRewards: 7-day reward breakdown
//   - rewardInfo: Detailed reward information
func (c *APIClient) GetRewards() (*APIResponse, error) {
	return c.Get("/api/liteNode/rewards")
}


