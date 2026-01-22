package proxy_worker

import (
	// Connectors - needed for proxy functionality
	_ "github.com/go-gost/x/connector/direct"   // Direct connection
	_ "github.com/go-gost/x/connector/forward"  // Forward handler needs this
	_ "github.com/go-gost/x/connector/http"     // Default connector (fallback in cmd.go)
	_ "github.com/go-gost/x/connector/socks/v5" // SOCKS5 connector
	_ "github.com/go-gost/x/connector/tunnel"   // Connect to proxy-server via tunnel

	// Dialers - needed for tunnel+ws connection
	_ "github.com/go-gost/x/dialer/direct" // Direct dialer
	_ "github.com/go-gost/x/dialer/tcp"    // TCP dialer (default)
	_ "github.com/go-gost/x/dialer/tls"    // TLS dialer (for wss)
	_ "github.com/go-gost/x/dialer/ws"     // WebSocket dialer

	// Handlers - for proxy functionality
	_ "github.com/go-gost/x/handler/auto"           // Auto handler (http/https/socks5)
	_ "github.com/go-gost/x/handler/forward/local"  // Local forward
	_ "github.com/go-gost/x/handler/forward/remote" // Remote forward (rtcp handler)
	_ "github.com/go-gost/x/handler/http"           // HTTP proxy handler
	_ "github.com/go-gost/x/handler/socks/v5"       // SOCKS5 proxy handler

	// Listeners
	_ "github.com/go-gost/x/listener/rtcp" // Reverse TCP for tunnel connection
	_ "github.com/go-gost/x/listener/tcp"  // TCP listener for local proxy
)
