package auto

import (
	mdata "github.com/go-gost/core/metadata"
	mdutil "github.com/go-gost/x/metadata/util"
)

type metadata struct {
	enableAroAuther bool
	backUrl         string
}

func (h *autoHandler) parseMetadata(md mdata.Metadata) error {
	h.md.enableAroAuther = mdutil.GetBool(md, "enableAroAuther", "enable_aro_auther")
	h.md.backUrl = mdutil.GetString(md, "backUrl", "back_url")
	return nil
}
