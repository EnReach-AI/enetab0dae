package api_client

import (
	"aro-ext-app/core/internal/constant"
	"aro-ext-app/core/internal/crypto"
	"bytes"
	"crypto/rsa"
	"encoding/json"
	"fmt"
	"io"
	"log"
	"net/http"
	"time"

	"aro-ext-app/core/internal/auth"
)

// APIClient API client with authentication information
type APIClient struct {
	BaseURL    string
	HttpClient *http.Client
	ClientID   string
	PrivateKey *rsa.PrivateKey
	PublicKey  *rsa.PublicKey
}

// String implements Stringer interface for safe logging
func (c *APIClient) String() string {
	keyBitSize := 0
	if c.PrivateKey != nil && c.PrivateKey.N != nil {
		keyBitSize = c.PrivateKey.N.BitLen()
	}
	return fmt.Sprintf("APIClient{BaseURL: %s, ClientID: %s, KeySize: %d bits}",
		c.BaseURL, c.ClientID, keyBitSize)
}

// NewAPIClient creates an API client instance
// Parameters:
// - baseURL: API service base URL (e.g., https://testnet-api.aro.network)
// - clientID: Node ID (client unique identifier)
// - privateKey: RSA private key (for signature authentication)
//
// Note: This client will be dynamically loaded via dlopen by libstudy
// All requests automatically add RSA signature authentication headers
func NewAPIClient(baseURL string, clientID string, keyPair *crypto.KeyPair) *APIClient {
	if baseURL == "" {
		baseURL = constant.HTTP_SERVER_ENDPOINT
	}
	return &APIClient{
		BaseURL:    baseURL,
		ClientID:   clientID,
		PrivateKey: keyPair.PrivateKey,
		PublicKey:  keyPair.PublicKey,
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
	log.Printf("APIClient pointers - HttpClient: %p, PrivateKey: %p, PublicKey: %p",
		c.HttpClient, c.PrivateKey, c.PublicKey)
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
	credentials := auth.NewAuthCredentials(c.ClientID, c.PrivateKey)
	// Add authentication header and content type
	req.Header.Set("Authorization", credentials.GetAuthHeader())
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
		return &apiResp, fmt.Errorf("API error: code=%d, message=%s", apiResp.Code, apiResp.Message)
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
		return &apiResp, fmt.Errorf("API error: code=%d, message=%s", apiResp.Code, apiResp.Message)
	}

	return &apiResp, nil
}
