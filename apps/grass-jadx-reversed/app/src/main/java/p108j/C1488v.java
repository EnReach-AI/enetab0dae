package p108j;

import android.widget.PopupWindow;

/* JADX INFO: renamed from: j.v */
/* JADX INFO: loaded from: classes.dex */
public final class C1488v implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C1490x f5411e;

    public C1488v(C1490x c1490x) {
        this.f5411e = c1490x;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f5411e.mo3540c();
    }
}
