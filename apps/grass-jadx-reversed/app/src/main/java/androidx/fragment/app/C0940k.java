package androidx.fragment.app;

import android.app.Dialog;
import android.view.View;
import p125o0.AbstractC1794d;

/* JADX INFO: renamed from: androidx.fragment.app.k */
/* JADX INFO: loaded from: classes.dex */
public final class C0940k extends AbstractC1794d {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ AbstractC1794d f3170e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ DialogInterfaceOnCancelListenerC0941l f3171f;

    public C0940k(DialogInterfaceOnCancelListenerC0941l dialogInterfaceOnCancelListenerC0941l, C0942m c0942m) {
        this.f3171f = dialogInterfaceOnCancelListenerC0941l;
        this.f3170e = c0942m;
    }

    @Override // p125o0.AbstractC1794d
    /* JADX INFO: renamed from: j */
    public final View mo2464j(int i3) {
        AbstractC1794d abstractC1794d = this.f3170e;
        if (abstractC1794d.mo2465k()) {
            return abstractC1794d.mo2464j(i3);
        }
        Dialog dialog = this.f3171f.f3183h0;
        if (dialog != null) {
            return dialog.findViewById(i3);
        }
        return null;
    }

    @Override // p125o0.AbstractC1794d
    /* JADX INFO: renamed from: k */
    public final boolean mo2465k() {
        return this.f3170e.mo2465k() || this.f3171f.f3187l0;
    }
}
