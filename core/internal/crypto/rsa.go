package crypto

import (
	"aro-ext-app/core/internal/config"
	"aro-ext-app/core/internal/storage"
	"crypto"
	"crypto/rand"
	"crypto/rsa"
	"crypto/sha256"
	"crypto/x509"
	"encoding/base64"
	"encoding/pem"
	"fmt"
	"os"
	"path/filepath"
	"runtime"
	"strings"

	"github.com/google/uuid"
)

const (
	RSAKeySize  = 2048
	KeyFileName = "aro_rsa"
)

var cfg = config.GetConfig()

// KeyPair RSA 密钥对
type KeyPair struct {
	PrivateKey *rsa.PrivateKey
	PublicKey  *rsa.PublicKey
}

// GenerateRSAKeyPair 生成 RSA 密钥对
func GenerateRSAKeyPair() (*KeyPair, error) {
	privateKey, err := rsa.GenerateKey(rand.Reader, RSAKeySize)
	if err != nil {
		return nil, fmt.Errorf("failed to generate private key: %w", err)
	}

	return &KeyPair{
		PrivateKey: privateKey,
		PublicKey:  &privateKey.PublicKey,
	}, nil
}

func SaveKeyPairToFile(keyPair *KeyPair, baseDir string) error {
	fmt.Println("baseDir:", baseDir)
	if baseDir == "" {
		// 获取当前工作目录
		cwd, err := os.Getwd()
		if err != nil {
			return fmt.Errorf("getting the current directory failed: %w", err)
		}
		baseDir = cwd
	}

	//// 确保目录存在
	//if err := os.MkdirAll(baseDir, 0700); err != nil {
	//	return fmt.Errorf("catalog creation failed: %w", err)
	//}

	privateKeyPath := filepath.Join(baseDir, KeyFileName)
	publicKeyPath := filepath.Join(baseDir, KeyFileName+".pub")
	fmt.Println("privateKeyPath:", privateKeyPath)
	fmt.Println("publicKeyPath:", publicKeyPath)
	// 保存私钥
	privateKeyPEM := &pem.Block{
		Type:  "RSA PRIVATE KEY",
		Bytes: x509.MarshalPKCS1PrivateKey(keyPair.PrivateKey),
	}

	privateKeyFile, err := os.OpenFile(privateKeyPath, os.O_WRONLY|os.O_CREATE|os.O_TRUNC, 0600)
	if err != nil {
		return fmt.Errorf("creating a private key file failed: %w", err)
	}
	defer privateKeyFile.Close()

	if err := pem.Encode(privateKeyFile, privateKeyPEM); err != nil {
		return fmt.Errorf("writing the private key failed: %w", err)
	}

	// 保存公钥
	publicKeyBytes, err := x509.MarshalPKIXPublicKey(keyPair.PublicKey)
	if err != nil {
		return fmt.Errorf("serialization of public key failed: %w", err)
	}

	publicKeyPEM := &pem.Block{
		Type:  "PUBLIC KEY",
		Bytes: publicKeyBytes,
	}

	publicKeyFile, err := os.OpenFile(publicKeyPath, os.O_WRONLY|os.O_CREATE|os.O_TRUNC, 0644)
	if err != nil {
		return fmt.Errorf("failed to create a public key file: %w", err)
	}
	defer publicKeyFile.Close()

	if err := pem.Encode(publicKeyFile, publicKeyPEM); err != nil {
		return fmt.Errorf("failed to write the public key: %w", err)
	}
	storageApi := storage.GetStorage()
	storageApi.Set(storage.PRIVATE_KEY, string(privateKeyPEM.Bytes))
	storageApi.Set(storage.PUBLIC_KEY, publicKeyPEM.Bytes)
	return nil
}

// LoadKeyPairFromFile 从文件加载密钥对
func LoadKeyPairFromFile(baseDir string) (*KeyPair, error) {
	if baseDir == "" {
		cwd, err := os.Getwd()
		if err != nil {
			return nil, fmt.Errorf("getting the current directory failed: %w", err)
		}
		baseDir = cwd
	}

	privateKeyPath := filepath.Join(baseDir, KeyFileName)

	// 读取私钥文件
	privateKeyData, err := os.ReadFile(privateKeyPath)
	if err != nil {
		return nil, fmt.Errorf("failed to read the private key file: %w", err)
	}

	// 解析 PEM
	block, _ := pem.Decode(privateKeyData)
	if block == nil || block.Type != "RSA PRIVATE KEY" {
		return nil, fmt.Errorf("invalid private key format")
	}

	// 解析私钥
	privateKey, err := x509.ParsePKCS1PrivateKey(block.Bytes)
	if err != nil {
		return nil, fmt.Errorf("failed to resolve the private key: %w", err)
	}

	return &KeyPair{
		PrivateKey: privateKey,
		PublicKey:  &privateKey.PublicKey,
	}, nil
}

// GetOrCreateKeyPair 获取或创建密钥对
func GetOrCreateKeyPair(baseDir string) (*KeyPair, error) {
	// 尝试加载现有密钥
	keyPair, err := LoadKeyPairFromFile(baseDir)
	if err == nil {
		return keyPair, nil
	}

	// 如果加载失败，生成新密钥
	keyPair, err = GenerateRSAKeyPair()
	if err != nil {
		return nil, err
	}

	// 保存到文件
	if err := SaveKeyPairToFile(keyPair, baseDir); err != nil {
		return nil, err
	}

	return keyPair, nil
}

// SignMessage 使用私钥签名消息
func SignMessage(privateKey *rsa.PrivateKey, message string) (string, error) {
	// 计算消息的 SHA256 哈希
	hashed := sha256.Sum256([]byte(message))

	// 使用私钥签名
	signature, err := rsa.SignPKCS1v15(rand.Reader, privateKey, crypto.SHA256, hashed[:])
	if err != nil {
		return "", fmt.Errorf("signature failed: %w", err)
	}

	// 返回 Base64 编码的签名
	return base64.StdEncoding.EncodeToString(signature), nil
}

// VerifySignature 使用公钥验证签名
func VerifySignature(publicKey *rsa.PublicKey, message, signature string) error {
	// 解码 Base64 签名
	signatureBytes, err := base64.StdEncoding.DecodeString(signature)
	if err != nil {
		return fmt.Errorf("decoding the signature failed: %w", err)
	}

	// 计算消息的 SHA256 哈希
	hashed := sha256.Sum256([]byte(message))

	// 验证签名
	return rsa.VerifyPKCS1v15(publicKey, crypto.SHA256, hashed[:], signatureBytes)
}

// ExportPublicKeyToPEM 导出公钥为 PEM 格式字符串
func ExportPublicKeyToPEM(publicKey *rsa.PublicKey) (string, error) {
	publicKeyBytes, err := x509.MarshalPKIXPublicKey(publicKey)
	if err != nil {
		return "", err
	}

	publicKeyPEM := pem.EncodeToMemory(&pem.Block{
		Type:  "PUBLIC KEY",
		Bytes: publicKeyBytes,
	})

	return base64.StdEncoding.EncodeToString(publicKeyPEM), nil
}

// ExportPrivateKeyToPEM 导出私钥为 PEM 格式字符串
func ExportPrivateKeyToPEM(privateKey *rsa.PrivateKey) string {
	privateKeyPEM := pem.EncodeToMemory(&pem.Block{
		Type:  "RSA PRIVATE KEY",
		Bytes: x509.MarshalPKCS1PrivateKey(privateKey),
	})

	return string(privateKeyPEM)
}

// GenerateClientID 生成或读取客户端ID（隐式包含平台信息）
func GenerateClientID() string {
	clientId := cfg.Get(config.KeyClientId)
	if clientId != "" {
		return clientId
	}

	// 生成基础 UUID
	baseUUID := uuid.New().String()

	// 获取平台代码（1位数字）
	platformCode := getPlatformCode()

	// 将平台代码替换 UUID 的第一个字符，看起来像正常的 UUID
	clientID := platformCode +"-"+ baseUUID

	cfg.SetAndSave(config.KeyClientId, clientID)
	return clientID
}

// getPlatformCode 获取平台代码（单个数字，不易被察觉）
func getPlatformCode() string {
	goos := strings.ToLower(runtime.GOOS)
	switch goos {
	case "linux":
		return "1"
	case "windows":
		return "2"
	case "darwin":
		return "3" // macOS
	case "android":
		return "4"
	case "ios":
		return "5"
	default:
		return "9" // 未知平台
	}
}
