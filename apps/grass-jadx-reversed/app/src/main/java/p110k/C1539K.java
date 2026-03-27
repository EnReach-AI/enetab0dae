package p110k;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import p108j.ViewTreeObserverOnGlobalLayoutListenerC1470d;

/* JADX INFO: renamed from: k.K */
/* JADX INFO: loaded from: classes.dex */
public final class C1539K implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f5509e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ C1541L f5510f;

    public C1539K(C1541L c1541l, ViewTreeObserverOnGlobalLayoutListenerC1470d viewTreeObserverOnGlobalLayoutListenerC1470d) {
        this.f5510f = c1541l;
        this.f5509e = viewTreeObserverOnGlobalLayoutListenerC1470d;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f5510f.f5517K.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f5509e);
        }
    }
}
