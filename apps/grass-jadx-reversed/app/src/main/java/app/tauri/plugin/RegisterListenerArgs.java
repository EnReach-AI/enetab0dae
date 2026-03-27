package app.tauri.plugin;

import app.tauri.annotation.InvokeArg;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class RegisterListenerArgs {
    public String event;
    public Channel handler;

    public final String getEvent() {
        String str = this.event;
        if (str != null) {
            return str;
        }
        AbstractC1766e.m3924i("event");
        throw null;
    }

    public final Channel getHandler() {
        Channel channel = this.handler;
        if (channel != null) {
            return channel;
        }
        AbstractC1766e.m3924i("handler");
        throw null;
    }

    public final void setEvent(String str) {
        AbstractC1766e.m3920e("<set-?>", str);
        this.event = str;
    }

    public final void setHandler(Channel channel) {
        AbstractC1766e.m3920e("<set-?>", channel);
        this.handler = channel;
    }
}
