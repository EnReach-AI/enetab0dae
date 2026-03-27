package app.tauri.plugin;

import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public final class PluginResult {

    /* JADX INFO: renamed from: a */
    public final JSObject f3558a;

    public PluginResult(JSObject jSObject) {
        this.f3558a = jSObject == null ? new JSObject() : jSObject;
    }

    public final String toString() {
        String string = this.f3558a.toString();
        AbstractC1766e.m3919d("toString(...)", string);
        return string;
    }
}
