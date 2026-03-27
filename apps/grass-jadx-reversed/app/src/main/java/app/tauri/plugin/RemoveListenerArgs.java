package app.tauri.plugin;

import app.tauri.annotation.InvokeArg;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class RemoveListenerArgs {
    private long channelId;
    public String event;

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getEvent() {
        String str = this.event;
        if (str != null) {
            return str;
        }
        AbstractC1766e.m3924i("event");
        throw null;
    }

    public final void setChannelId(long j2) {
        this.channelId = j2;
    }

    public final void setEvent(String str) {
        AbstractC1766e.m3920e("<set-?>", str);
        this.event = str;
    }
}
