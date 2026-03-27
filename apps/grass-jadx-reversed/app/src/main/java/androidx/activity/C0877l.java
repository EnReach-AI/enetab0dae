package androidx.activity;

import androidx.fragment.app.C0952w;
import java.util.ArrayDeque;
import p156w0.AbstractC1986a;

/* JADX INFO: renamed from: androidx.activity.l */
/* JADX INFO: loaded from: classes.dex */
public final class C0877l implements InterfaceC0866a {

    /* JADX INFO: renamed from: a */
    public final C0952w f2614a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C0878m f2615b;

    public C0877l(C0878m c0878m, C0952w c0952w) {
        this.f2615b = c0878m;
        this.f2614a = c0952w;
    }

    @Override // androidx.activity.InterfaceC0866a
    public final void cancel() {
        C0878m c0878m = this.f2615b;
        ArrayDeque arrayDeque = c0878m.f2617b;
        C0952w c0952w = this.f2614a;
        arrayDeque.remove(c0952w);
        c0952w.f3267b.remove(this);
        if (AbstractC1986a.m4379g()) {
            c0952w.f3268c = null;
            c0878m.m2212c();
        }
    }
}
