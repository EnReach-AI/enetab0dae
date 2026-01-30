package model

// BandwidthTestTask represents the bandwidth test task from scheduler
type BandwidthTestTask struct {
	Type        string    `json:"type"`
	TestID      string    `json:"test_id"`
	CheckerHost string    `json:"checker_host"`
	CheckerPort int       `json:"checker_port"`
	Challenge   Challenge `json:"challenge"`
}

// Challenge contains the parameters for bandwidth test
type Challenge struct {
	Seed                 string `json:"seed"`
	HmacKey              string `json:"hmac_key"`
	Nonce                string `json:"nonce"`
	ExpiresAt            int64  `json:"expires_at"`
	DurationMs           int    `json:"duration_ms"`
	ChunkSize            int    `json:"chunk_size"`
	PerStreamTotalChunks int    `json:"per_stream_total_chunks"`
	Concurrency          int    `json:"concurrency"`
}

const (
	SeqSize  = 4
	HmacSize = 32
)

func (c *Challenge) GetChunkTotalSize() int {
	return SeqSize + c.ChunkSize + HmacSize
}
