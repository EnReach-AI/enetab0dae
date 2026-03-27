package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import androidx.activity.InterfaceC0879n;
import androidx.activity.result.InterfaceC0887h;
import androidx.lifecycle.C0966K;
import androidx.lifecycle.C0986s;
import androidx.lifecycle.InterfaceC0967L;
import p125o0.AbstractC1794d;

/* JADX INFO: renamed from: androidx.fragment.app.q */
/* JADX INFO: loaded from: classes.dex */
public final class C0946q extends AbstractC1794d implements InterfaceC0967L, InterfaceC0879n, InterfaceC0887h, InterfaceC0921G {

    /* JADX INFO: renamed from: e */
    public final Activity f3246e;

    /* JADX INFO: renamed from: f */
    public final Context f3247f;

    /* JADX INFO: renamed from: g */
    public final Handler f3248g;

    /* JADX INFO: renamed from: h */
    public final C0918D f3249h;

    /* JADX INFO: renamed from: i */
    public final /* synthetic */ AbstractActivityC0947r f3250i;

    public C0946q(AbstractActivityC0947r abstractActivityC0947r) {
        this.f3250i = abstractActivityC0947r;
        Handler handler = new Handler();
        this.f3249h = new C0918D();
        this.f3246e = abstractActivityC0947r;
        this.f3247f = abstractActivityC0947r;
        this.f3248g = handler;
    }

    @Override // androidx.fragment.app.InterfaceC0921G
    /* JADX INFO: renamed from: a */
    public final void mo2414a() {
        this.f3250i.getClass();
    }

    @Override // androidx.lifecycle.InterfaceC0967L
    /* JADX INFO: renamed from: c */
    public final C0966K mo2198c() {
        return this.f3250i.mo2198c();
    }

    @Override // androidx.lifecycle.InterfaceC0984q
    /* JADX INFO: renamed from: d */
    public final C0986s mo2199d() {
        return this.f3250i.f3252t;
    }

    @Override // p125o0.AbstractC1794d
    /* JADX INFO: renamed from: j */
    public final View mo2464j(int i3) {
        return this.f3250i.findViewById(i3);
    }

    @Override // p125o0.AbstractC1794d
    /* JADX INFO: renamed from: k */
    public final boolean mo2465k() {
        Window window = this.f3250i.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }
}
