package chain

import (
	"context"

	"github.com/go-gost/core/chain"
	"github.com/go-gost/core/hop"
	"github.com/go-gost/core/logger"
	"github.com/go-gost/core/metadata"
	"github.com/go-gost/core/selector"
)

var (
	_ chain.Chainer = (*chainGroup)(nil)
)

type ChainOptions struct {
	Metadata metadata.Metadata
	Logger   logger.Logger
}

type ChainOption func(*ChainOptions)

func MetadataChainOption(md metadata.Metadata) ChainOption {
	return func(opts *ChainOptions) {
		opts.Metadata = md
	}
}

func LoggerChainOption(logger logger.Logger) ChainOption {
	return func(opts *ChainOptions) {
		opts.Logger = logger
	}
}

type chainNamer interface {
	Name() string
}

type Chain struct {
	name     string
	hops     []hop.Hop
	marker   selector.Marker
	metadata metadata.Metadata
	logger   logger.Logger
}

func NewChain(name string, opts ...ChainOption) *Chain {
	var options ChainOptions
	for _, opt := range opts {
		if opt != nil {
			opt(&options)
		}
	}

	return &Chain{
		name:     name,
		metadata: options.Metadata,
		marker:   selector.NewFailMarker(),
		logger:   options.Logger,
	}
}

func (c *Chain) AddHop(hop hop.Hop) {
	c.hops = append(c.hops, hop)
}

// Metadata implements metadata.Metadatable interface.
func (c *Chain) Metadata() metadata.Metadata {
	return c.metadata
}

// Marker implements selector.Markable interface.
func (c *Chain) Marker() selector.Marker {
	return c.marker
}

func (c *Chain) Name() string {
	return c.name
}

func (c *Chain) Route(ctx context.Context, network, address string, opts ...chain.RouteOption) chain.Route {
	if c == nil || len(c.hops) == 0 {
		if c != nil && c.logger != nil {
			c.logger.Debugf("[DEBUG CHAIN] Route: no hops available")
		}
		return nil
	}

	var options chain.RouteOptions
	for _, opt := range opts {
		opt(&options)
	}

	c.logger.Debugf("[DEBUG CHAIN] Route: network=%s, address=%s, hops=%d", network, address, len(c.hops))
	rt := NewRoute(ChainRouteOption(c))
	for i, h := range c.hops {
		c.logger.Debugf("[DEBUG CHAIN] Route: selecting from hop[%d]", i)
		node := h.Select(ctx,
			hop.NetworkSelectOption(network),
			hop.AddrSelectOption(address),
			hop.HostSelectOption(options.Host),
		)
		if node == nil {
			c.logger.Warnf("[DEBUG CHAIN] Route: hop[%d].Select returned nil, returning empty route", i)
			return rt
		}
		c.logger.Debugf("[DEBUG CHAIN] Route: hop[%d].Select returned node: %s@%s", i, node.Name, node.Addr)
		if node.Options().Transport.Multiplex() {
			tr := node.Options().Transport.Copy()
			tr.Options().Route = rt
			node = node.Copy()
			node.Options().Transport = tr
			rt = NewRoute(ChainRouteOption(c))
		}

		rt.addNode(node)
	}
	c.logger.Debugf("[DEBUG CHAIN] Route: returning route with %d nodes", len(rt.Nodes()))
	return rt
}

type chainGroup struct {
	chains   []chain.Chainer
	selector selector.Selector[chain.Chainer]
}

func NewChainGroup(chains ...chain.Chainer) *chainGroup {
	return &chainGroup{chains: chains}
}

func (p *chainGroup) WithSelector(s selector.Selector[chain.Chainer]) *chainGroup {
	p.selector = s
	return p
}

func (p *chainGroup) Route(ctx context.Context, network, address string, opts ...chain.RouteOption) chain.Route {
	if chain := p.next(ctx); chain != nil {
		return chain.Route(ctx, network, address, opts...)
	}
	return nil
}

func (p *chainGroup) next(ctx context.Context) chain.Chainer {
	if p == nil || len(p.chains) == 0 {
		return nil
	}

	return p.selector.Select(ctx, p.chains...)
}
