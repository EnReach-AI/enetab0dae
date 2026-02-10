package api_client

import (
	"bytes"
	"encoding/json"
	"fmt"
	"io"
	"log"
	"net/http"
	"time"
	agentUtil "github.com/aro-network/aro-edge-agent/agent/util"

)

// APIClient API client with authentication information
type APIClient struct {
	BaseURL    string
	HttpClient *http.Client
	ClientID   string
	NodeId     string
	SerialNumber string
	
}

// String implements Stringer interface for safe logging


// NewAPIClient creates an API client instance
// Parameters:
// - baseURL: API service base URL (e.g., https://testnet-api.aro.network)
// - clientID: Node ID (client unique identifier)
// - privateKey: RSA private key (for signature authentication)
//
// Note: This client will be dynamically loaded via dlopen by libstudy
// All requests automatically add RSA signature authentication headers
func NewAPIClient(baseURL string, clientID string, serialNumber string,nodeId string) *APIClient {
	return &APIClient{
		BaseURL:    baseURL,
		ClientID:   clientID,
		NodeId:     nodeId,
		SerialNumber: serialNumber,
		HttpClient: &http.Client{
			Timeout: 30 * time.Second,
		},
	}
}

// Request sends an HTTP request with automatic authentication header
// Implementation mimics aro-ext-ui axios interceptor:
// 1. Generate timestamp
// 2. Sign with private key: SHA256(clientID:timestamp)
// 3. Generate Bearer Token: Bearer base64("aro:clientID:timestamp:signature")
func (c *APIClient) Request(method, path string, body interface{}) ([]byte, int, error) {
	log.Printf("APIClient: %v", c)
	url := fmt.Sprintf("%s%s", c.BaseURL, path)

	var reqBody io.Reader
	if body != nil {
		data, _ := json.Marshal(body)
		reqBody = bytes.NewReader(data)
	}
	log.Printf("Requesting %s %+v", url, body)
	req, err := http.NewRequest(method, url, reqBody)
	if err != nil {
		return nil, 0, err
	}

	// Generate authentication credentials
	token, err := agentUtil.GenerateBearerToken(c.NodeId)
	// Add authentication header and content type
	req.Header.Set("Authorization", "Bearer "+token)
	req.Header.Set("Content-Type", "application/json")

	// Send request
	resp, err := c.HttpClient.Do(req)
	if err != nil {
		return nil, 0, fmt.Errorf("request failed: %w", err)
	}
	defer resp.Body.Close()

	// Read response body
	respBody, err := io.ReadAll(resp.Body)
	if err != nil {
		return nil, resp.StatusCode, fmt.Errorf("failed to read response: %w", err)
	}

	return respBody, resp.StatusCode, nil
}

// Get sends a GET request and returns parsed response
func (c *APIClient) Get(path string) (*APIResponse, error) {
	respBody, statusCode, err := c.Request("GET", path, nil)
	if err != nil {
		return nil, err
	}

	var apiResp APIResponse
	if err := json.Unmarshal(respBody, &apiResp); err != nil {
		return nil, fmt.Errorf("failed to parse response (HTTP %d): %w", statusCode, err)
	}

	if apiResp.Code != 0 && apiResp.Code != 200 {
		return &apiResp, fmt.Errorf("API error:path=%s code=%d, message=%s", path, apiResp.Code, apiResp.Message)
	}

	return &apiResp, nil
}

// Post sends a POST request and returns parsed response
func (c *APIClient) Post(path string, body interface{}) (*APIResponse, error) {
	respBody, statusCode, err := c.Request("POST", path, body)
	if err != nil {
		return nil, err
	}

	var apiResp APIResponse
	if err := json.Unmarshal(respBody, &apiResp); err != nil {
		return nil, fmt.Errorf("failed to parse response (HTTP %d): %w", statusCode, err)
	}

	if apiResp.Code != 0 && apiResp.Code != 200 {
		return &apiResp, fmt.Errorf("API error:path=%s code=%d, message=%s", path, apiResp.Code, apiResp.Message)
	}

	return &apiResp, nil
}
