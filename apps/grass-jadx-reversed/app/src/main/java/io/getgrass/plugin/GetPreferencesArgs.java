package io.getgrass.plugin;

import app.tauri.annotation.InvokeArg;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class GetPreferencesArgs {
    private String key;

    public final String getKey() {
        return this.key;
    }

    public final void setKey(String str) {
        this.key = str;
    }
}
