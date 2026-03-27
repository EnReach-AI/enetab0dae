package app.tauri;

import app.tauri.annotation.InvokeArg;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class GetFileNameFromUriArgs {
    public String uri;

    public final String getUri() {
        String str = this.uri;
        if (str != null) {
            return str;
        }
        AbstractC1766e.m3924i("uri");
        throw null;
    }

    public final void setUri(String str) {
        AbstractC1766e.m3920e("<set-?>", str);
        this.uri = str;
    }
}
