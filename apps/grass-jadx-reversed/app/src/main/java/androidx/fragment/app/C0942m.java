package androidx.fragment.app;

import android.view.View;
import p125o0.AbstractC1794d;

/* JADX INFO: renamed from: androidx.fragment.app.m */
/* JADX INFO: loaded from: classes.dex */
public final class C0942m extends AbstractC1794d {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ AbstractComponentCallbacksC0944o f3188e;

    public C0942m(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        this.f3188e = abstractComponentCallbacksC0944o;
    }

    @Override // p125o0.AbstractC1794d
    /* JADX INFO: renamed from: j */
    public final View mo2464j(int i3) {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3188e;
        View view = abstractComponentCallbacksC0944o.f3210J;
        if (view != null) {
            return view.findViewById(i3);
        }
        throw new IllegalStateException("Fragment " + abstractComponentCallbacksC0944o + " does not have a view");
    }

    @Override // p125o0.AbstractC1794d
    /* JADX INFO: renamed from: k */
    public final boolean mo2465k() {
        return this.f3188e.f3210J != null;
    }
}
