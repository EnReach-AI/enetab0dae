package auth

import (
	"bytes"
	"context"
	"crypto/aes"
	"crypto/cipher"
	"crypto/rand"
	"encoding/json"
	"fmt"
	"io"
	"net/http"
	"os"
	"path/filepath"
	"strings"
	"sync"
	"time"

	"github.com/go-gost/core/auth"
	"github.com/go-gost/core/logger"
	xctx "github.com/go-gost/x/ctx"
	xlogger "github.com/go-gost/x/logger"
)

type AuthResult struct {
	IpResource string `json:"ip_resource"`
	DateEnd    int64  `json:"date_end"`
}

// CacheEntry represents a single cache entry with expiration
type CacheEntry struct {
	Username    string    `json:"username"`
	Password    string    `json:"password"`
	ExpiresAt   time.Time `json:"expires_at"`
	LastUsed    time.Time `json:"last_used"`
	AccessCount int       `json:"access_count"`
}

// aroAuthenticator implements backend API verification with local memory caching
type aroAuthenticator struct {
	logger        logger.Logger
	httpClient    *http.Client
	backendURL    string
	header        http.Header
	cacheDir      string // directory to persist cache
	encryptionKey []byte // key for cache encryption

	// Cache management
	cacheMu sync.RWMutex
	cache   map[string]*CacheEntry // key: username:password_hash
	maxSize int                    // max cache entries

	// Persistence
	cacheFile     string
	persistTicker *time.Ticker
	stopChan      chan struct{}
}

// NewAROAuthenticator creates a new ARO authenticator with caching and persistence
// deviceType: "pod", "client", "desktop", or "mobile"
// backendURL: HTTP endpoint for backend verification
// cacheDir: directory to persist encrypted cache (optional)
// encryptionKey: key for cache encryption (should be agent's private key)
func NewAROAuthenticator(backendURL string, opts ...Option) auth.Authenticator {
	var options Options
	for _, opt := range opts {
		opt(&options)
	}

	// Determine max cache size based on device type
	maxSize := 1000 // default for pod/client/desktop

	a := &aroAuthenticator{
		logger:        options.Logger,
		backendURL:    backendURL,
		header:        options.Header,
		cacheDir:      options.CacheDir,
		encryptionKey: options.EncryptionKey,
		cache:         make(map[string]*CacheEntry),
		maxSize:       maxSize,
		stopChan:      make(chan struct{}),
	}

	if a.logger == nil {
		a.logger = xlogger.Nop()
	}

	if options.HTTPClient != nil {
		a.httpClient = options.HTTPClient
	} else {
		a.httpClient = &http.Client{Timeout: 10 * time.Second}
	}

	// Initialize cache file path
	if a.cacheDir != "" {
		a.cacheFile = filepath.Join(a.cacheDir, fmt.Sprintf("aro_auth_cache.enc"))

		// Create cache directory if not exists
		if err := os.MkdirAll(a.cacheDir, 0755); err != nil {
			a.logger.Warnf("failed to create cache directory %s: %v", a.cacheDir, err)
		} else {
			// Load cached credentials from file
			if err := a.loadCacheFromFile(); err != nil {
				a.logger.Warnf("failed to load cache from file: %v", err)
			}
		}
	}

	// Start periodic persistence goroutine (every 5 minutes)
	go a.persistCache()

	return a
}

// Authenticate verifies credentials with caching and backend fallback
func (a *aroAuthenticator) Authenticate(ctx context.Context, user, password string, opts ...auth.Option) (string, bool) {
	if user == "" || password == "" {
		a.logger.Warn("ARO auth: empty username or password")
		return "", false
	}

	cacheKey := fmt.Sprintf("%s:%s", user, hashString(password))

	// Check local cache first
	a.cacheMu.RLock()
	if entry, exists := a.cache[cacheKey]; exists {
		a.cacheMu.RUnlock()

		// Check if cache entry is still valid
		if time.Now().Before(entry.ExpiresAt) {
			// Update access statistics
			a.cacheMu.Lock()
			entry.LastUsed = time.Now()
			entry.AccessCount++
			a.cacheMu.Unlock()

			a.logger.Debugf("ARO auth: user '%s' authenticated from cache", user)
			return entry.Username, true
		}

		// Cache expired, remove it
		a.cacheMu.Lock()
		delete(a.cache, cacheKey)
		a.cacheMu.Unlock()
	} else {
		a.cacheMu.RUnlock()
	}

	// Cache miss or expired - verify with backend API
	AuthResult, ok := a.verifyWithBackend(ctx, user, password, opts...)

	if ok {
		// Cache the successful authentication
		a.cacheMu.Lock()

		// Check if cache is full, evict LRU entry if needed
		if len(a.cache) >= a.maxSize {
			a.evictLRU()
		}

		a.cache[cacheKey] = &CacheEntry{
			Username:    user,
			Password:    hashString(password),
			ExpiresAt:   time.Unix(AuthResult.DateEnd, 0),
			LastUsed:    time.Now(),
			AccessCount: 1,
		}
		a.cacheMu.Unlock()

		a.logger.Debugf("ARO auth: user '%s' authenticated via backend API", user)
		return user, true
	}

	a.logger.Warnf("ARO auth: authentication failed for user '%s'", user)
	return "", false
}

// verifyWithBackend calls the backend API to verify credentials
func (a *aroAuthenticator) verifyWithBackend(ctx context.Context, user, password string, opts ...auth.Option) (*AuthResult, bool) {
	if a.backendURL == "" {
		a.logger.Error("ARO auth: backend URL not configured")
		return nil, false
	}

	var options auth.Options
	for _, opt := range opts {
		opt(&options)
	}

	var port string
	if v := xctx.SrcAddrFromContext(ctx); v != nil {
		//192.0.2.1:25", "[2001:db8::1]:80
		addrStr := v.String()
		if idx := strings.LastIndex(addrStr, ":"); idx != -1 {
			port = addrStr[idx+1:]
		}
	}

	// Prepare request payload
	type authRequest struct {
		Port     string `json:"port"`
		Username string `json:"username"`
		Password string `json:"password"`
	}

	type authResponse struct {
		Code    int        `json:"code"`
		Message string     `json:"message"`
		Data    AuthResult `json:"data"`
	}

	reqPayload := authRequest{
		Username: user,
		Password: password,
		Port:     port,
	}

	v, err := json.Marshal(&reqPayload)
	if err != nil {
		a.logger.Errorf("ARO auth: failed to marshal request: %v", err)
		return nil, false
	}

	req, err := http.NewRequestWithContext(ctx, http.MethodPost, a.backendURL, bytes.NewReader(v))
	if err != nil {
		a.logger.Errorf("ARO auth: failed to create request: %v", err)
		return nil, false
	}

	if a.header != nil {
		req.Header = a.header.Clone()
	}
	req.Header.Set("Content-Type", "application/json")

	resp, err := a.httpClient.Do(req)
	if err != nil {
		a.logger.Errorf("ARO auth: backend API call failed: %v", err)
		return nil, false
	}
	defer resp.Body.Close()

	if resp.StatusCode != http.StatusOK {
		a.logger.Warnf("ARO auth: backend API returned status %d", resp.StatusCode)
		return nil, false
	}

	var respPayload authResponse
	if err := json.NewDecoder(resp.Body).Decode(&respPayload); err != nil {
		a.logger.Errorf("ARO auth: failed to decode response: %v", err)
		return nil, false
	}

	return &respPayload.Data, true
}

// evictLRU evicts the least recently used cache entry
func (a *aroAuthenticator) evictLRU() {
	var lruKey string
	var lruTime time.Time = time.Now()

	for key, entry := range a.cache {
		if entry.LastUsed.Before(lruTime) {
			lruTime = entry.LastUsed
			lruKey = key
		}
	}

	if lruKey != "" {
		delete(a.cache, lruKey)
		a.logger.Debugf("ARO auth: evicted LRU cache entry: %s", lruKey)
	}
}

// persistCache periodically saves cache to encrypted file
func (a *aroAuthenticator) persistCache() {
	if a.cacheDir == "" || a.cacheFile == "" {
		return
	}

	ticker := time.NewTicker(5 * time.Minute)
	defer ticker.Stop()

	for {
		select {
		case <-ticker.C:
			if err := a.saveCacheToFile(); err != nil {
				a.logger.Errorf("ARO auth: failed to persist cache: %v", err)
			}
		case <-a.stopChan:
			return
		}
	}
}

// saveCacheToFile saves cache to encrypted file
func (a *aroAuthenticator) saveCacheToFile() error {
	if a.encryptionKey == nil || len(a.encryptionKey) == 0 {
		a.logger.Debug("ARO auth: encryption key not set, skipping cache persistence")
		return nil
	}

	a.cacheMu.RLock()
	defer a.cacheMu.RUnlock()

	// Prepare cache data
	data, err := json.MarshalIndent(a.cache, "", "  ")
	if err != nil {
		return fmt.Errorf("marshal cache failed: %w", err)
	}

	// Encrypt cache data
	encrypted, err := a.encryptData(data)
	if err != nil {
		return fmt.Errorf("encrypt cache failed: %w", err)
	}

	// Write to file
	if err := os.WriteFile(a.cacheFile, encrypted, 0600); err != nil {
		return fmt.Errorf("write cache file failed: %w", err)
	}

	a.logger.Debugf("ARO auth: cache persisted to %s (%d entries)", a.cacheFile, len(a.cache))
	return nil
}

// loadCacheFromFile loads cache from encrypted file
func (a *aroAuthenticator) loadCacheFromFile() error {
	if a.encryptionKey == nil || len(a.encryptionKey) == 0 {
		a.logger.Debug("ARO auth: encryption key not set, skipping cache loading")
		return nil
	}

	if _, err := os.Stat(a.cacheFile); os.IsNotExist(err) {
		a.logger.Debugf("ARO auth: cache file not found: %s", a.cacheFile)
		return nil
	}

	// Read encrypted file
	encrypted, err := os.ReadFile(a.cacheFile)
	if err != nil {
		return fmt.Errorf("read cache file failed: %w", err)
	}

	// Decrypt data
	data, err := a.decryptData(encrypted)
	if err != nil {
		return fmt.Errorf("decrypt cache failed: %w", err)
	}

	// Unmarshal cache
	var cache map[string]*CacheEntry
	if err := json.Unmarshal(data, &cache); err != nil {
		return fmt.Errorf("unmarshal cache failed: %w", err)
	}

	a.cacheMu.Lock()
	a.cache = cache
	a.cacheMu.Unlock()

	// Cleanup expired entries
	a.cleanupExpiredEntries()

	a.logger.Debugf("ARO auth: cache loaded from %s (%d entries)", a.cacheFile, len(cache))
	return nil
}

// cleanupExpiredEntries removes expired entries from cache
func (a *aroAuthenticator) cleanupExpiredEntries() {
	a.cacheMu.Lock()
	defer a.cacheMu.Unlock()

	now := time.Now()
	count := 0
	for key, entry := range a.cache {
		if now.After(entry.ExpiresAt) {
			delete(a.cache, key)
			count++
		}
	}

	if count > 0 {
		a.logger.Debugf("ARO auth: cleaned up %d expired cache entries", count)
	}
}

// encryptData encrypts data using AES-256-GCM
func (a *aroAuthenticator) encryptData(plaintext []byte) ([]byte, error) {
	if len(a.encryptionKey) < 32 {
		return nil, fmt.Errorf("encryption key too short, need at least 32 bytes")
	}

	// Use first 32 bytes as AES-256 key
	key := a.encryptionKey[:32]

	block, err := aes.NewCipher(key)
	if err != nil {
		return nil, err
	}

	gcm, err := cipher.NewGCM(block)
	if err != nil {
		return nil, err
	}

	nonce := make([]byte, gcm.NonceSize())
	if _, err := io.ReadFull(rand.Reader, nonce); err != nil {
		return nil, err
	}

	return gcm.Seal(nonce, nonce, plaintext, nil), nil
}

// decryptData decrypts data encrypted with encryptData
func (a *aroAuthenticator) decryptData(ciphertext []byte) ([]byte, error) {
	if len(a.encryptionKey) < 32 {
		return nil, fmt.Errorf("encryption key too short, need at least 32 bytes")
	}

	key := a.encryptionKey[:32]

	block, err := aes.NewCipher(key)
	if err != nil {
		return nil, err
	}

	gcm, err := cipher.NewGCM(block)
	if err != nil {
		return nil, err
	}

	nonceSize := gcm.NonceSize()
	if len(ciphertext) < nonceSize {
		return nil, fmt.Errorf("ciphertext too short")
	}

	nonce, ciphertext := ciphertext[:nonceSize], ciphertext[nonceSize:]
	return gcm.Open(nil, nonce, ciphertext, nil)
}

// Close stops the persistence goroutine
func (a *aroAuthenticator) Close() error {
	close(a.stopChan)
	// Final save before shutdown
	if a.cacheFile != "" {
		return a.saveCacheToFile()
	}
	return nil
}

// GetCacheStats returns cache statistics
func (a *aroAuthenticator) GetCacheStats() map[string]interface{} {
	a.cacheMu.RLock()
	defer a.cacheMu.RUnlock()

	totalAccess := 0
	for _, entry := range a.cache {
		totalAccess += entry.AccessCount
	}

	return map[string]interface{}{
		"size":         len(a.cache),
		"max_size":     a.maxSize,
		"total_access": totalAccess,
		"cache_file":   a.cacheFile,
	}
}

// Options for ARO authenticator
type Options struct {
	Logger        logger.Logger
	HTTPClient    *http.Client
	Header        http.Header
	CacheDir      string // directory to persist cache
	EncryptionKey []byte // encryption key (agent's private key)
}

// Option is a function that configures Options
type Option func(*Options)

// LoggerOption sets the logger
func LoggerOption(logger logger.Logger) Option {
	return func(opts *Options) {
		opts.Logger = logger
	}
}

// HTTPClientOption sets the HTTP client
func HTTPClientOption(client *http.Client) Option {
	return func(opts *Options) {
		opts.HTTPClient = client
	}
}

// HeaderOption sets the HTTP header
func HeaderOption(header http.Header) Option {
	return func(opts *Options) {
		opts.Header = header
	}
}

// CacheDirOption sets the cache directory
func CacheDirOption(dir string) Option {
	return func(opts *Options) {
		opts.CacheDir = dir
	}
}

// EncryptionKeyOption sets the encryption key
func EncryptionKeyOption(key []byte) Option {
	return func(opts *Options) {
		opts.EncryptionKey = key
	}
}

// hashString creates a simple hash of a string for cache keys
func hashString(s string) string {
	// In production, use a proper hash function like SHA256
	// For now, use a simple approach
	h := 0
	for _, c := range s {
		h = 31*h + int(c)
	}
	return fmt.Sprintf("%d", h)
}
