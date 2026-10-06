package api_client

import (
	"errors"
	"testing"
	"time"
)

func TestCachedGet(t *testing.T) {
	calls := 0
	ok := func() (*APIResponse, error) { calls++; return &APIResponse{Code: 200}, nil }
	for i := 0; i < 5; i++ {
		if _, err := cachedGet("k1", time.Minute, ok); err != nil {
			t.Fatal(err)
		}
	}
	if calls != 1 {
		t.Fatalf("TTL 内应只请求 1 次, 实际 %d", calls)
	}

	// 出错不缓存
	fails := 0
	bad := func() (*APIResponse, error) { fails++; return nil, errors.New("x") }
	cachedGet("k2", time.Minute, bad)
	cachedGet("k2", time.Minute, bad)
	if fails != 2 {
		t.Fatalf("出错时不应缓存, 实际请求 %d 次", fails)
	}

	// 过期后重新请求
	calls = 0
	cachedGet("k3", time.Millisecond, ok)
	time.Sleep(5 * time.Millisecond)
	cachedGet("k3", time.Millisecond, ok)
	if calls != 2 {
		t.Fatalf("过期后应重新请求, 实际 %d", calls)
	}
}
