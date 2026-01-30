package speedtest

import (
	"crypto/hmac"
	"crypto/sha256"
	"encoding/binary"
	"encoding/hex"
	"fmt"
)

// ChunkGenerator generates chunk data for bandwidth test
type ChunkGenerator struct {
	seed      []byte
	hmacKey   []byte
	chunkSize int
	streamID  int
}

// NewChunkGenerator creates a new ChunkGenerator
func NewChunkGenerator(seedHex, hmacKeyHex string, chunkSize, streamID int) (*ChunkGenerator, error) {
	seed, err := hex.DecodeString(seedHex)
	if err != nil {
		return nil, fmt.Errorf("failed to decode seed: %w", err)
	}

	hmacKey, err := hex.DecodeString(hmacKeyHex)
	if err != nil {
		return nil, fmt.Errorf("failed to decode hmac_key: %w", err)
	}

	return &ChunkGenerator{
		seed:      seed,
		hmacKey:   hmacKey,
		chunkSize: chunkSize,
		streamID:  streamID,
	}, nil
}

// GenerateChunk generates a chunk with the given sequence number
// Format: | seq (4 bytes, uint32 big-endian) | payload (chunk_size bytes) | hmac (32 bytes) |
func (g *ChunkGenerator) GenerateChunk(seq uint32) []byte {
	// Generate payload using SHA256 expansion
	payload := g.generatePayload(seq)

	// Build chunk: seq + payload + hmac
	chunk := make([]byte, SeqSize+g.chunkSize+HmacSize)

	// Write seq (4 bytes, big-endian)
	binary.BigEndian.PutUint32(chunk[0:SeqSize], seq)

	// Write payload
	copy(chunk[SeqSize:SeqSize+g.chunkSize], payload)

	// Calculate HMAC-SHA256 over seq + payload
	h := hmac.New(sha256.New, g.hmacKey)
	h.Write(chunk[0 : SeqSize+g.chunkSize])
	hmacSum := h.Sum(nil)

	// Write hmac
	copy(chunk[SeqSize+g.chunkSize:], hmacSum)

	return chunk
}

// generatePayload generates payload using SHA256 expansion
// Uses SHA256(seed + stream_id + seq + block_index) to fill chunk_size bytes
func (g *ChunkGenerator) generatePayload(seq uint32) []byte {
	payload := make([]byte, g.chunkSize)
	hashSize := sha256.Size // 32 bytes

	// Calculate how many SHA256 blocks we need
	blocksNeeded := (g.chunkSize + hashSize - 1) / hashSize

	offset := 0
	for blockIdx := 0; blockIdx < blocksNeeded && offset < g.chunkSize; blockIdx++ {
		// Build input: seed + stream_id (4 bytes) + seq (4 bytes) + block_index (4 bytes)
		input := make([]byte, len(g.seed)+12)
		copy(input, g.seed)
		binary.BigEndian.PutUint32(input[len(g.seed):], uint32(g.streamID))
		binary.BigEndian.PutUint32(input[len(g.seed)+4:], seq)
		binary.BigEndian.PutUint32(input[len(g.seed)+8:], uint32(blockIdx))

		// SHA256 hash
		hash := sha256.Sum256(input)

		// Copy to payload
		copyLen := hashSize
		if offset+copyLen > g.chunkSize {
			copyLen = g.chunkSize - offset
		}
		copy(payload[offset:offset+copyLen], hash[:copyLen])
		offset += copyLen
	}

	return payload
}
