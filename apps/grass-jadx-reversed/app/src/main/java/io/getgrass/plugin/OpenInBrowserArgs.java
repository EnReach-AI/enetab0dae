package io.getgrass.plugin;

import app.tauri.annotation.InvokeArg;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class OpenInBrowserArgs {
    public String url;

    public final String getUrl() {
        String str = this.url;
        if (str != null) {
            return str;
        }
        AbstractC1766e.m3924i("url");
        throw null;
    }

    public final void setUrl(String str) {
        AbstractC1766e.m3920e("<set-?>", str);
        this.url = str;
    }
}
