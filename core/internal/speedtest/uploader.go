package speedtest

import (
	"bytes"
	"context"
	"enreach-agent/constant"
	"enreach-agent/util"
	"enreach-agent/database/model"
	"fmt"
	"io"
	"log"
	"net/http"
	"sync"
	"time"
)

// Uploader handles concurrent chunk uploads for bandwidth test
	task       *model.BandwidthTestTask
	httpClient *http.Client
	mu         sync.Mutex
	running    bool
}

// NewUploader creates a new Uploader instance
func NewUploader(task *model.BandwidthTestTask) *Uploader {
	return &Uploader{
		task: task,
		httpClient: &http.Client{
			Timeout: time.Duration(task.Challenge.DurationMs+5000) * time.Millisecond,
		},
	}
}

// StreamResult represents the result of a single stream upload
type StreamResult struct {
	StreamID   int
	ChunksSent int
	BytesSent  int64
	Duration   time.Duration
	Error      error
	Success    bool
}

// TestResult represents the overall test result
type TestResult struct {
	TestID        string
	TotalBytes    int64
	TotalChunks   int
	Duration      time.Duration
	StreamResults []StreamResult
	Success       bool
}

// Run executes the bandwidth test with concurrent uploads
func (u *Uploader) Run(ctx context.Context) (*TestResult, error) {
	u.mu.Lock()
	if u.running {
		u.mu.Unlock()
		return nil, fmt.Errorf("bandwidth test already running")
	}
	u.running = true
	u.mu.Unlock()

	defer func() {
		u.mu.Lock()
		u.running = false
		u.mu.Unlock()
	}()

	// Check if task is expired
	if time.Now().Unix() > u.task.Challenge.ExpiresAt {
		return nil, fmt.Errorf("bandwidth test task expired")
	}

	startTime := time.Now()
	concurrency := u.task.Challenge.Concurrency
	if concurrency <= 0 {
		concurrency = 4
	}

	// Create context with timeout based on duration_ms
	testCtx, cancel := context.WithTimeout(ctx, time.Duration(u.task.Challenge.DurationMs)*time.Millisecond)
	defer cancel()

	// Run concurrent streams
	var wg sync.WaitGroup
	resultChan := make(chan StreamResult, concurrency)

	for streamID := 0; streamID < concurrency; streamID++ {
		wg.Add(1)
		go func(sid int) {
			defer wg.Done()
			defer util.RecoverFromPanic()
			result := u.uploadStream(testCtx, sid)
			resultChan <- result
		}(streamID)
	}

	// Wait for all streams to complete
	go func() {
		wg.Wait()
		close(resultChan)
	}()

	// Collect results
	testResult := &TestResult{
		TestID:        u.task.TestID,
		StreamResults: make([]StreamResult, 0, concurrency),
		Success:       true,
	}

	for result := range resultChan {
		testResult.StreamResults = append(testResult.StreamResults, result)
		testResult.TotalBytes += result.BytesSent
		testResult.TotalChunks += result.ChunksSent
		if !result.Success {
			testResult.Success = false
		}
	}

	testResult.Duration = time.Since(startTime)

	// Log result summary
	log.Printf("Bandwidth test completed: test_id=%s, total_bytes=%d, total_chunks=%d, duration=%v, success=%v",
		testResult.TestID, testResult.TotalBytes, testResult.TotalChunks, testResult.Duration, testResult.Success)

	return testResult, nil
}

// uploadStream uploads chunks for a single stream
func (u *Uploader) uploadStream(ctx context.Context, streamID int) StreamResult {
	result := StreamResult{
		StreamID: streamID,
	}

	startTime := time.Now()

	// Create chunk generator
	generator, err := NewChunkGenerator(
		u.task.Challenge.Seed,
		u.task.Challenge.HmacKey,
		u.task.Challenge.ChunkSize,
		streamID,
	)
	if err != nil {
		result.Error = fmt.Errorf("failed to create chunk generator: %w", err)
		return result
	}

	// Build URL
	url := fmt.Sprintf("https://%s:%d/speed/upload?test_id=%s&nonce=%s&stream_id=%d",
		u.task.CheckerHost,
		u.task.CheckerPort,
		u.task.TestID,
		u.task.Challenge.Nonce,
		streamID,
	)

	// Generate bearer token
	bearerToken, err := util.GenerateBearerToken(constant.SERIAL_NUMBER)
	if err != nil {
		result.Error = fmt.Errorf("failed to generate bearer token: %w", err)
		return result
	}

	// Create pipe for streaming upload
	pr, pw := io.Pipe()

	// Start goroutine to write chunks to pipe
	go func() {
		defer pw.Close()
		defer util.RecoverFromPanic()

		totalChunks := u.task.Challenge.PerStreamTotalChunks
		for seq := 0; seq < totalChunks; seq++ {
			select {
			case <-ctx.Done():
				return
			default:
			}

			chunk := generator.GenerateChunk(uint32(seq))
			_, err := pw.Write(chunk)
			if err != nil {
				log.Printf("Stream %d: failed to write chunk %d: %v", streamID, seq, err)
				return
			}
			result.ChunksSent++
			result.BytesSent += int64(len(chunk))
		}
	}()

	// Create HTTP request
	req, err := http.NewRequestWithContext(ctx, http.MethodPost, url, pr)
	if err != nil {
		result.Error = fmt.Errorf("failed to create request: %w", err)
		return result
	}

	req.Header.Set("Content-Type", "application/octet-stream")
	req.Header.Set("Authorization", "Bearer "+bearerToken)

	// Send request
	resp, err := u.httpClient.Do(req)
	if err != nil {
		result.Error = fmt.Errorf("failed to send request: %w", err)
		return result
	}
	defer resp.Body.Close()

	// Read response body
	respBody, _ := io.ReadAll(resp.Body)

	if resp.StatusCode != http.StatusOK {
		result.Error = fmt.Errorf("server returned status %d: %s", resp.StatusCode, string(respBody))
		return result
	}

	result.Duration = time.Since(startTime)
	result.Success = true

	log.Printf("Stream %d completed: chunks=%d, bytes=%d, duration=%v",
		streamID, result.ChunksSent, result.BytesSent, result.Duration)

	return result
}

// IsRunning returns whether the uploader is currently running
func (u *Uploader) IsRunning() bool {
	u.mu.Lock()
	defer u.mu.Unlock()
	return u.running
}

// CalculateThroughput calculates throughput in Mbps
func (r *TestResult) CalculateThroughput() float64 {
	if r.Duration.Seconds() == 0 {
		return 0
	}
	// bytes to bits, then to Mbps
	return float64(r.TotalBytes*8) / r.Duration.Seconds() / 1_000_000
}

// chunkWriter wraps chunk generation for streaming upload
type chunkWriter struct {
	generator   *ChunkGenerator
	totalChunks int
	currentSeq  int
	buffer      *bytes.Buffer
	ctx         context.Context
}

func (w *chunkWriter) Read(p []byte) (n int, err error) {
	select {
	case <-w.ctx.Done():
		return 0, w.ctx.Err()
	default:
	}

	// If buffer has data, return it first
	if w.buffer.Len() > 0 {
		return w.buffer.Read(p)
	}

	// Check if we've sent all chunks
	if w.currentSeq >= w.totalChunks {
		return 0, io.EOF
	}

	// Generate next chunk
	chunk := w.generator.GenerateChunk(uint32(w.currentSeq))
	w.currentSeq++
	w.buffer.Write(chunk)

	return w.buffer.Read(p)
}
