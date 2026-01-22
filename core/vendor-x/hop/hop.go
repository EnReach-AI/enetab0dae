package hop

import (
	"context"
	"encoding/json"
	"fmt"
	"io"
	"net"
	"sort"
	"strings"
	"sync"
	"time"

	"github.com/go-gost/core/bypass"
	"github.com/go-gost/core/chain"
	"github.com/go-gost/core/hop"
	"github.com/go-gost/core/logger"
	"github.com/go-gost/core/routing"
	"github.com/go-gost/core/selector"
	"github.com/go-gost/x/config"
	node_parser "github.com/go-gost/x/config/parsing/node"
	"github.com/go-gost/x/internal/loader"
	xlogger "github.com/go-gost/x/logger"
)

type options struct {
	name        string
	nodes       []*chain.Node
	bypass      bypass.Bypass
	selector    selector.Selector[*chain.Node]
	fileLoader  loader.Loader
	redisLoader loader.Loader
	httpLoader  loader.Loader
	period      time.Duration
	logger      logger.Logger
}

type Option func(*options)

func NameOption(name string) Option {
	return func(o *options) {
		o.name = name
	}
}

func NodeOption(nodes ...*chain.Node) Option {
	return func(o *options) {
		o.nodes = nodes
	}
}
func BypassOption(bp bypass.Bypass) Option {
	return func(o *options) {
		o.bypass = bp
	}
}

func SelectorOption(s selector.Selector[*chain.Node]) Option {
	return func(o *options) {
		o.selector = s
	}
}

func ReloadPeriodOption(period time.Duration) Option {
	return func(opts *options) {
		opts.period = period
	}
}

func FileLoaderOption(fileLoader loader.Loader) Option {
	return func(opts *options) {
		opts.fileLoader = fileLoader
	}
}

func RedisLoaderOption(redisLoader loader.Loader) Option {
	return func(opts *options) {
		opts.redisLoader = redisLoader
	}
}

func HTTPLoaderOption(httpLoader loader.Loader) Option {
	return func(opts *options) {
		opts.httpLoader = httpLoader
	}
}
func LoggerOption(logger logger.Logger) Option {
	return func(opts *options) {
		opts.logger = logger
	}
}

type chainHop struct {
	nodes      []*chain.Node
	options    options
	logger     logger.Logger
	mu         sync.RWMutex
	cancelFunc context.CancelFunc
}

func NewHop(opts ...Option) hop.Hop {
	var options options
	for _, opt := range opts {
		if opt != nil {
			opt(&options)
		}
	}

	ctx, cancel := context.WithCancel(context.TODO())
	p := &chainHop{
		nodes:      options.nodes,
		cancelFunc: cancel,
		options:    options,
		logger:     options.logger,
	}

	if p.logger == nil {
		p.logger = xlogger.Nop()
	}

	go p.periodReload(ctx)

	return p
}

func (p *chainHop) Nodes() []*chain.Node {
	if p == nil {
		return nil
	}
	p.mu.RLock()
	defer p.mu.RUnlock()
	return p.nodes
}

func (p *chainHop) Select(ctx context.Context, opts ...hop.SelectOption) *chain.Node {
	var options hop.SelectOptions
	for _, opt := range opts {
		opt(&options)
	}

	log := p.logger

	totalNodes := len(p.Nodes())
	fmt.Printf("[HOP SELECT] total nodes=%d, network=%s, addr=%s, host=%s\n", totalNodes, options.Network, options.Addr, options.Host)
	log.Debugf("[DEBUG HOP] Select: total nodes=%d, network=%s, addr=%s, host=%s", totalNodes, options.Network, options.Addr, options.Host)

	// hop level bypass
	if p.options.bypass != nil &&
		p.options.bypass.Contains(ctx, options.Network, options.Addr, bypass.WithHostOpton(options.Host)) {
		log.Debugf("[DEBUG HOP] Select: blocked by hop-level bypass")
		return nil
	}

	var nodes []*chain.Node
	for i, node := range p.Nodes() {
		if node == nil {
			log.Debugf("[DEBUG HOP] Select: node[%d] is nil, skipping", i)
			continue
		}
		log.Debugf("[DEBUG HOP] Select: checking node[%d]: %s@%s", i, node.Name, node.Addr)

		// node level bypass
		if node.Options().Bypass != nil &&
			node.Options().Bypass.Contains(ctx, options.Network, options.Addr, bypass.WithHostOpton(options.Host)) {
			log.Debugf("[DEBUG HOP] Select: node[%d] blocked by node-level bypass", i)
			continue
		}

		if matcher := node.Options().Matcher; matcher != nil {
			req := routing.Request{
				ClientIP: options.ClientIP,
				Host:     options.Host,
				Protocol: options.Protocol,
				Method:   options.Method,
				Path:     options.Path,
				Query:    options.Query,
				Header:   options.Header,
			}
			if !matcher.Match(&req) {
				log.Debugf("[DEBUG HOP] Select: node[%d] does not match request", i)
				continue
			}
			log.Debugf("node %s match request %s %s, priority %d", node.Name, req.Protocol, req.Host, node.Options().Priority)
		} else {
			if !p.isEligible(node, &options) {
				log.Debugf("[DEBUG HOP] Select: node[%d] is not eligible", i)
				continue
			}
		}

		log.Debugf("[DEBUG HOP] Select: node[%d] passed all checks, adding to candidates", i)
		nodes = append(nodes, node)
	}

	log.Debugf("[DEBUG HOP] Select: %d candidates after filtering", len(nodes))

	if len(nodes) == 0 {
		log.Warnf("[DEBUG HOP] Select: no eligible nodes, returning nil")
		return nil
	}
	if len(nodes) == 1 {
		log.Debugf("[DEBUG HOP] Select: only one candidate, returning it")
		return nodes[0]
	}

	sort.Slice(nodes, func(i, j int) bool {
		return nodes[i].Options().Priority > nodes[j].Options().Priority
	})

	if nodes[0].Options().Priority > 0 {
		log.Debugf("[DEBUG HOP] Select: returning highest priority node: %s", nodes[0].Name)
		return nodes[0]
	}

	if s := p.options.selector; s != nil {
		selected := s.Select(ctx, nodes...)
		log.Debugf("[DEBUG HOP] Select: selector returned: %s", selected.Name)
		return selected
	}
	log.Debugf("[DEBUG HOP] Select: returning first node: %s", nodes[0].Name)
	return nodes[0]
}

func (p *chainHop) isEligible(node *chain.Node, opts *hop.SelectOptions) bool {
	hostCheck := p.checkHost(opts.Host, node)
	protocolCheck := p.checkProtocol(opts.Protocol, node)
	pathCheck := p.checkPath(opts.Path, node)

	filterHost := getFilterHost(node)
	fmt.Printf("[HOP isEligible] node=%s: host=%v (filter=%s, opts.Host='%s'), protocol=%v, path=%v\n",
		node.Name,
		hostCheck, filterHost, opts.Host,
		protocolCheck,
		pathCheck,
	)

	if !hostCheck || !protocolCheck || !pathCheck {
		return false
	}
	return true
}

func getFilterHost(node *chain.Node) string {
	if filter := node.Options().Filter; filter != nil {
		return filter.Host
	}
	return ""
}

func (p *chainHop) checkHost(host string, node *chain.Node) bool {
	var vhost string
	if filter := node.Options().Filter; filter != nil {
		vhost = filter.Host
	}
	if vhost == "" { // backup node
		return true
	}

	if host == "" {
		return false
	}

	if v, _, _ := net.SplitHostPort(host); v != "" {
		host = v
	}

	if vhost == host || vhost[0] == '.' && strings.HasSuffix(host, vhost[1:]) {
		return true
	}

	return false
}

func (p *chainHop) checkProtocol(protocol string, node *chain.Node) bool {
	var prot string
	if filter := node.Options().Filter; filter != nil {
		prot = filter.Protocol
	}
	if prot == "" {
		return true
	}
	return prot == protocol
}

func (p *chainHop) checkPath(path string, node *chain.Node) bool {
	var pathFilter string
	if filter := node.Options().Filter; filter != nil {
		pathFilter = filter.Path
	}

	if pathFilter == "" {
		return true
	}

	return strings.HasPrefix(path, pathFilter)
}

func (p *chainHop) periodReload(ctx context.Context) error {
	if err := p.reload(ctx); err != nil {
		p.logger.Warnf("reload: %v", err)
	}

	period := p.options.period
	if period <= 0 {
		return nil
	}
	if period < time.Second {
		period = time.Second
	}

	ticker := time.NewTicker(period)
	defer ticker.Stop()

	for {
		select {
		case <-ticker.C:
			if err := p.reload(ctx); err != nil {
				p.logger.Warnf("reload: %v", err)
				// return err
			}
			p.logger.Debug("hop reload done")
		case <-ctx.Done():
			return ctx.Err()
		}
	}
}

func (p *chainHop) reload(ctx context.Context) (err error) {
	nodes := p.options.nodes

	nl, err := p.load(ctx)

	nodes = append(nodes, nl...)

	p.logger.Debugf("load items %d", len(nodes))

	p.mu.Lock()
	defer p.mu.Unlock()

	p.nodes = nodes

	return
}

func (p *chainHop) load(ctx context.Context) (nodes []*chain.Node, err error) {
	if loader := p.options.fileLoader; loader != nil {
		r, er := loader.Load(ctx)
		if er != nil {
			p.logger.Warnf("file loader: %v", er)
		}
		nodes, _ = p.parseNode(r)
	}

	if loader := p.options.redisLoader; loader != nil {
		r, er := loader.Load(ctx)
		if er != nil {
			p.logger.Warnf("redis loader: %v", er)
		}
		ns, _ := p.parseNode(r)
		nodes = append(nodes, ns...)
	}

	if loader := p.options.httpLoader; loader != nil {
		r, er := loader.Load(ctx)
		if er != nil {
			p.logger.Warnf("http loader: %v", er)
		}
		if ns, _ := p.parseNode(r); ns != nil {
			nodes = append(nodes, ns...)
		}
	}

	return
}

func (p *chainHop) parseNode(r io.Reader) ([]*chain.Node, error) {
	if r == nil {
		return nil, nil
	}

	var ncs []*config.NodeConfig
	if err := json.NewDecoder(r).Decode(&ncs); err != nil {
		return nil, err
	}

	var nodes []*chain.Node
	for _, nc := range ncs {
		if nc == nil {
			continue
		}

		node, err := node_parser.ParseNode(p.options.name, nc, logger.Default())
		if err != nil {
			return nodes, err
		}
		nodes = append(nodes, node)
	}
	return nodes, nil
}

func (p *chainHop) Close() error {
	p.cancelFunc()
	if p.options.fileLoader != nil {
		p.options.fileLoader.Close()
	}
	if p.options.redisLoader != nil {
		p.options.redisLoader.Close()
	}
	return nil
}
