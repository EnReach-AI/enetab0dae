package io.getgrass.plugin;

import app.tauri.annotation.InvokeArg;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class PingArgs {
    private String value;

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }
}
