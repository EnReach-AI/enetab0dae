package app.tauri.deep_link;

import app.tauri.annotation.InvokeArg;
import app.tauri.plugin.Channel;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class SetEventHandlerArgs {
    public Channel handler;

    public final Channel getHandler() {
        Channel channel = this.handler;
        if (channel != null) {
            return channel;
        }
        AbstractC1766e.m3924i("handler");
        throw null;
    }

    public final void setHandler(Channel channel) {
        AbstractC1766e.m3920e("<set-?>", channel);
        this.handler = channel;
    }
}
