package auth

import (
	"crypto"
	"crypto/rand"
	"crypto/rsa"
	"crypto/sha256"
	"encoding/base64"
	"fmt"
	"time"
)

// AuthCredentials 认证凭证
type AuthCredentials struct {
	ClientID  string
	Timestamp int64
	Signature string
	Token     string
}

// NewAuthCredentials 创建新认证凭证，使用 RSA 私钥签名
func NewAuthCredentials(clientID string, privateKey *rsa.PrivateKey) *AuthCredentials {
	timestamp := time.Now().UTC().Unix()

	// 使用 RSA 私钥生成签名
	signature := GenerateRSASignature(clientID, timestamp, privateKey)

	// 生成 Bearer Token
	auth := fmt.Sprintf("aro:%s:%d:%s", clientID, timestamp, signature)
	token := base64.StdEncoding.EncodeToString([]byte(auth))

	return &AuthCredentials{
		ClientID:  clientID,
		Timestamp: timestamp,
		Signature: signature,
		Token:     token,
	}
}

// generateRSASignature 使用 RSA 私钥生成数字签名
func GenerateRSASignature(clientID string, timestamp int64, privateKey *rsa.PrivateKey) string {
	// 要签名的数据
	data := fmt.Sprintf("%s:%d", clientID, timestamp)

	// 计算 SHA256 哈希
	hash := sha256.Sum256([]byte(data))

	// 使用 RSA 私钥对哈希进行签名
	signature, err := rsa.SignPKCS1v15(rand.Reader, privateKey, crypto.SHA256, hash[:])
	if err != nil {
		return "" // 在实际应用中应该处理错误
	}

	// 返回 base64 编码的签名
	return base64.StdEncoding.EncodeToString(signature)
}

// GetAuthHeader 获取授权头
func (a *AuthCredentials) GetAuthHeader() string {
	return fmt.Sprintf("Bearer %s", a.Token)
}
