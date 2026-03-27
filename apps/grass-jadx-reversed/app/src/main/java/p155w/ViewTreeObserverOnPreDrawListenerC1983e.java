package p155w;

import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: renamed from: w.e */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC1983e implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ CoordinatorLayout f7042e;

    public ViewTreeObserverOnPreDrawListenerC1983e(CoordinatorLayout coordinatorLayout) {
        this.f7042e = coordinatorLayout;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f7042e.m2308p(0);
        return true;
    }
}
