package app.tauri.plugin;

import p069X0.C0734y;
import p115l2.InterfaceC1689l;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public final class Channel {

    /* JADX INFO: renamed from: a */
    public final long f3525a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1689l f3526b;

    /* JADX INFO: renamed from: c */
    public final C0734y f3527c;

    public Channel(long j2, InterfaceC1689l interfaceC1689l, C0734y c0734y) {
        AbstractC1766e.m3920e("objectMapper", c0734y);
        this.f3525a = j2;
        this.f3526b = interfaceC1689l;
        this.f3527c = c0734y;
    }

    /* JADX INFO: renamed from: a */
    public final void m2679a(JSObject jSObject) {
        AbstractC1766e.m3920e("data", jSObject);
        this.f3526b.mo249f(new PluginResult(jSObject).toString());
    }
}
