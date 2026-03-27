package app.tauri.plugin;

import app.tauri.Logger;
import p042N0.AbstractC0546n;
import p069X0.C0734y;
import p115l2.InterfaceC1693p;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public final class Invoke {

    /* JADX INFO: renamed from: a */
    public final String f3531a;

    /* JADX INFO: renamed from: b */
    public final long f3532b;

    /* JADX INFO: renamed from: c */
    public final long f3533c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC1693p f3534d;

    /* JADX INFO: renamed from: e */
    public final String f3535e;

    /* JADX INFO: renamed from: f */
    public final C0734y f3536f;

    public Invoke(String str, InterfaceC1693p interfaceC1693p, String str2, C0734y c0734y) {
        AbstractC1766e.m3920e("command", str);
        AbstractC1766e.m3920e("argsJson", str2);
        AbstractC1766e.m3920e("jsonMapper", c0734y);
        this.f3531a = str;
        this.f3532b = 0L;
        this.f3533c = 1L;
        this.f3534d = interfaceC1693p;
        this.f3535e = str2;
        this.f3536f = c0734y;
    }

    /* JADX INFO: renamed from: a */
    public final Object m2680a(Class cls) {
        return this.f3536f.m1918k(cls, this.f3535e);
    }

    /* JADX INFO: renamed from: b */
    public final void m2681b(String str) {
        PluginResult pluginResult = new PluginResult(new JSObject());
        try {
            pluginResult.f3558a.put("message", (Object) str);
        } catch (Exception unused) {
            Logger.Companion.m2656a(Logger.Companion.m2657b("Plugin"), "");
        }
        this.f3534d.mo317c(Long.valueOf(this.f3533c), pluginResult.toString());
    }

    /* JADX INFO: renamed from: c */
    public final void m2682c() {
        this.f3534d.mo317c(Long.valueOf(this.f3532b), "null");
    }

    /* JADX INFO: renamed from: d */
    public final void m2683d(JSObject jSObject) {
        this.f3534d.mo317c(Long.valueOf(this.f3532b), new PluginResult(jSObject).toString());
    }

    /* JADX INFO: renamed from: e */
    public final void m2684e(Object obj) throws AbstractC0546n {
        Long lValueOf = Long.valueOf(this.f3532b);
        String strM1921n = this.f3536f.m1921n(obj);
        AbstractC1766e.m3919d("writeValueAsString(...)", strM1921n);
        this.f3534d.mo317c(lValueOf, strM1921n);
    }
}
