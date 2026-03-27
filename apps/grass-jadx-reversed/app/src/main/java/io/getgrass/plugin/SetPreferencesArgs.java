package io.getgrass.plugin;

import app.tauri.annotation.InvokeArg;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class SetPreferencesArgs {
    private String key;
    private String value;

    public final String getKey() {
        return this.key;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setKey(String str) {
        this.key = str;
    }

    public final void setValue(String str) {
        this.value = str;
    }
}
