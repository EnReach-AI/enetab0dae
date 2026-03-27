package androidx.fragment.app;

import androidx.lifecycle.C0966K;
import androidx.lifecycle.C0986s;
import androidx.lifecycle.EnumC0978k;
import androidx.lifecycle.InterfaceC0967L;
import androidx.lifecycle.InterfaceC0975h;
import p077a0.C0846e;
import p077a0.C0847f;
import p077a0.InterfaceC0848g;

/* JADX INFO: renamed from: androidx.fragment.app.K */
/* JADX INFO: loaded from: classes.dex */
public final class C0925K implements InterfaceC0975h, InterfaceC0848g, InterfaceC0967L {

    /* JADX INFO: renamed from: e */
    public final C0966K f3101e;

    /* JADX INFO: renamed from: f */
    public C0986s f3102f = null;

    /* JADX INFO: renamed from: g */
    public C0847f f3103g = null;

    public C0925K(C0966K c0966k) {
        this.f3101e = c0966k;
    }

    @Override // p077a0.InterfaceC0848g
    /* JADX INFO: renamed from: b */
    public final C0846e mo2186b() {
        m2433f();
        return this.f3103g.f2519b;
    }

    @Override // androidx.lifecycle.InterfaceC0967L
    /* JADX INFO: renamed from: c */
    public final C0966K mo2198c() {
        m2433f();
        return this.f3101e;
    }

    @Override // androidx.lifecycle.InterfaceC0984q
    /* JADX INFO: renamed from: d */
    public final C0986s mo2199d() {
        m2433f();
        return this.f3102f;
    }

    /* JADX INFO: renamed from: e */
    public final void m2432e(EnumC0978k enumC0978k) {
        this.f3102f.m2518d(enumC0978k);
    }

    /* JADX INFO: renamed from: f */
    public final void m2433f() {
        if (this.f3102f == null) {
            this.f3102f = new C0986s(this);
            this.f3103g = new C0847f(this);
        }
    }
}
