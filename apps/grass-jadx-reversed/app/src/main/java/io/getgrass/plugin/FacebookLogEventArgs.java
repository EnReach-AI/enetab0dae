package io.getgrass.plugin;

import app.tauri.annotation.InvokeArg;
import java.util.List;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class FacebookLogEventArgs {
    public String eventName;
    private List<? extends Object> parameters;

    public final String getEventName() {
        String str = this.eventName;
        if (str != null) {
            return str;
        }
        AbstractC1766e.m3924i("eventName");
        throw null;
    }

    public final List<Object> getParameters() {
        return this.parameters;
    }

    public final void setEventName(String str) {
        AbstractC1766e.m3920e("<set-?>", str);
        this.eventName = str;
    }

    public final void setParameters(List<? extends Object> list) {
        this.parameters = list;
    }
}
