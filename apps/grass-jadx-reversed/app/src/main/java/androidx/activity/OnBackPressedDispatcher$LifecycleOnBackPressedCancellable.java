package androidx.activity;

import androidx.fragment.app.C0952w;
import androidx.lifecycle.C0986s;
import androidx.lifecycle.EnumC0978k;
import androidx.lifecycle.InterfaceC0982o;
import androidx.lifecycle.InterfaceC0984q;
import java.util.ArrayDeque;
import p156w0.AbstractC1986a;

/* JADX INFO: loaded from: classes.dex */
class OnBackPressedDispatcher$LifecycleOnBackPressedCancellable implements InterfaceC0982o, InterfaceC0866a {

    /* JADX INFO: renamed from: a */
    public final C0986s f2585a;

    /* JADX INFO: renamed from: b */
    public final C0952w f2586b;

    /* JADX INFO: renamed from: c */
    public C0877l f2587c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ C0878m f2588d;

    public OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(C0878m c0878m, C0986s c0986s, C0952w c0952w) {
        this.f2588d = c0878m;
        this.f2585a = c0986s;
        this.f2586b = c0952w;
        c0986s.m2515a(this);
    }

    @Override // androidx.lifecycle.InterfaceC0982o
    /* JADX INFO: renamed from: b */
    public final void mo2170b(InterfaceC0984q interfaceC0984q, EnumC0978k enumC0978k) {
        if (enumC0978k != EnumC0978k.ON_START) {
            if (enumC0978k != EnumC0978k.ON_STOP) {
                if (enumC0978k == EnumC0978k.ON_DESTROY) {
                    cancel();
                    return;
                }
                return;
            } else {
                C0877l c0877l = this.f2587c;
                if (c0877l != null) {
                    c0877l.cancel();
                    return;
                }
                return;
            }
        }
        C0878m c0878m = this.f2588d;
        ArrayDeque arrayDeque = c0878m.f2617b;
        C0952w c0952w = this.f2586b;
        arrayDeque.add(c0952w);
        C0877l c0877l2 = new C0877l(c0878m, c0952w);
        c0952w.f3267b.add(c0877l2);
        if (AbstractC1986a.m4379g()) {
            c0878m.m2212c();
            c0952w.f3268c = c0878m.f2618c;
        }
        this.f2587c = c0877l2;
    }

    @Override // androidx.activity.InterfaceC0866a
    public final void cancel() {
        this.f2585a.m2520f(this);
        this.f2586b.f3267b.remove(this);
        C0877l c0877l = this.f2587c;
        if (c0877l != null) {
            c0877l.cancel();
            this.f2587c = null;
        }
    }
}
