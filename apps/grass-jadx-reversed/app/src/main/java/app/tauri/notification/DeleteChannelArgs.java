package app.tauri.notification;

import app.tauri.annotation.InvokeArg;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class DeleteChannelArgs {

    /* JADX INFO: renamed from: id */
    public String f3500id;

    public final String getId() {
        String str = this.f3500id;
        if (str != null) {
            return str;
        }
        AbstractC1766e.m3924i("id");
        throw null;
    }

    public final void setId(String str) {
        AbstractC1766e.m3920e("<set-?>", str);
        this.f3500id = str;
    }
}
