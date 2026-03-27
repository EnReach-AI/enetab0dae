package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: androidx.fragment.app.t */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnAttachStateChangeListenerC0949t implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C0923I f3261e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ LayoutInflaterFactory2C0950u f3262f;

    public ViewOnAttachStateChangeListenerC0949t(LayoutInflaterFactory2C0950u layoutInflaterFactory2C0950u, C0923I c0923i) {
        this.f3262f = layoutInflaterFactory2C0950u;
        this.f3261e = c0923i;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        C0923I c0923i = this.f3261e;
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = c0923i.f3090c;
        c0923i.m2425k();
        C0937h.m2456f((ViewGroup) abstractComponentCallbacksC0944o.f3210J.getParent(), this.f3262f.f3263e.m2368A()).m2461e();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
