package api_client

import (
	"sync"
	"time"
)

// 内嵌网页每 20s 通过 GetRewards / GetLastVersion 轮询一次, 上万台客户端会把 testnet-api 入口负载均衡打满。
// 收益数据后端本身缓存 30 分钟, 版本检查 Flutter 另有 10 分钟定时器, 所以在客户端缓存成功结果, 过期前不再请求后端。
const (
	rewardsCacheTTL     = 5 * time.Minute
	lastVersionCacheTTL = 10 * time.Minute
)

type cachedResponse struct {
	resp      *APIResponse
	expiresAt time.Time
}

var (
	pollCacheMu sync.Mutex
	pollCache   = map[string]cachedResponse{}
)

// cachedGet 只缓存成功的响应; 出错时不写缓存, 下次调用照常请求后端。
func cachedGet(key string, ttl time.Duration, fetch func() (*APIResponse, error)) (*APIResponse, error) {
	pollCacheMu.Lock()
	if c, ok := pollCache[key]; ok && time.Now().Before(c.expiresAt) {
		pollCacheMu.Unlock()
		return c.resp, nil
	}
	pollCacheMu.Unlock()

	resp, err := fetch()
	if err != nil {
		return resp, err
	}
	pollCacheMu.Lock()
	pollCache[key] = cachedResponse{resp: resp, expiresAt: time.Now().Add(ttl)}
	pollCacheMu.Unlock()
	return resp, nil
}
