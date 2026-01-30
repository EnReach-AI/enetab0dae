package speedtest

import (
	"context"
	"encoding/json"
	"enreach-agent/database/model"
	"log"
	"sync"
	"time"
)

// Service manages bandwidth test execution
type Service struct {
	mu       sync.Mutex
	running  bool
	uploader *Uploader
}

var (
	serviceInstance *Service
	serviceOnce     sync.Once
)

// GetService returns the singleton Service instance
func GetService() *Service {
	serviceOnce.Do(func() {
		serviceInstance = &Service{}
	})
	return serviceInstance
}

// HandleTask processes a bandwidth test task from gRPC message
func (s *Service) HandleTask(message string) {
	s.mu.Lock()
	if s.running {
		s.mu.Unlock()
		log.Printf("Bandwidth test already running, skipping new task")
		return
	}
	s.running = true
	s.mu.Unlock()

	defer func() {
		s.mu.Lock()
		s.running = false
		s.uploader = nil
		s.mu.Unlock()
	}()

	// Parse task
	var task model.BandwidthTestTask
	if err := json.Unmarshal([]byte(message), &task); err != nil {
		log.Printf("Failed to parse bandwidth test task: %v", err)
		return
	}

	// Validate task
	if err := s.validateTask(&task); err != nil {
		log.Printf("Invalid bandwidth test task: %v", err)
		return
	}

	log.Printf("Starting bandwidth test: test_id=%s, checker=%s:%d, concurrency=%d, chunks_per_stream=%d",
		task.TestID, task.CheckerHost, task.CheckerPort,
		task.Challenge.Concurrency, task.Challenge.PerStreamTotalChunks)

	// Create uploader
	s.uploader = NewUploader(&task)

	// Run test with context
	ctx, cancel := context.WithTimeout(context.Background(), time.Duration(task.Challenge.DurationMs+10000)*time.Millisecond)
	defer cancel()

	result, err := s.uploader.Run(ctx)
	if err != nil {
		log.Printf("Bandwidth test failed: %v", err)
		return
	}

	// Log result
	throughput := result.CalculateThroughput()
	log.Printf("Bandwidth test result: test_id=%s, throughput=%.2f Mbps, total_bytes=%d, duration=%v, success=%v",
		result.TestID, throughput, result.TotalBytes, result.Duration, result.Success)
}

// validateTask validates the bandwidth test task
func (s *Service) validateTask(task *model.BandwidthTestTask) error {
	if task.TestID == "" {
		return &ValidationError{Field: "test_id", Message: "test_id is required"}
	}
	if task.CheckerHost == "" {
		return &ValidationError{Field: "checker_host", Message: "checker_host is required"}
	}
	if task.CheckerPort <= 0 {
		return &ValidationError{Field: "checker_port", Message: "checker_port must be positive"}
	}
	if task.Challenge.Seed == "" {
		return &ValidationError{Field: "challenge.seed", Message: "seed is required"}
	}
	if task.Challenge.HmacKey == "" {
		return &ValidationError{Field: "challenge.hmac_key", Message: "hmac_key is required"}
	}
	if task.Challenge.Nonce == "" {
		return &ValidationError{Field: "challenge.nonce", Message: "nonce is required"}
	}
	if task.Challenge.ChunkSize <= 0 {
		return &ValidationError{Field: "challenge.chunk_size", Message: "chunk_size must be positive"}
	}
	if task.Challenge.PerStreamTotalChunks <= 0 {
		return &ValidationError{Field: "challenge.per_stream_total_chunks", Message: "per_stream_total_chunks must be positive"}
	}
	if task.Challenge.ExpiresAt > 0 && time.Now().Unix() > task.Challenge.ExpiresAt {
		return &ValidationError{Field: "challenge.expires_at", Message: "task has expired"}
	}
	return nil
}

// IsRunning returns whether a bandwidth test is currently running
func (s *Service) IsRunning() bool {
	s.mu.Lock()
	defer s.mu.Unlock()
	return s.running
}

// ValidationError represents a validation error
type ValidationError struct {
	Field   string
	Message string
}

func (e *ValidationError) Error() string {
	return e.Field + ": " + e.Message
}
