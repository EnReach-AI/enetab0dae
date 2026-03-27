package p029J;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: J.Z */
/* JADX INFO: loaded from: classes.dex */
public final class C0330Z {

    /* JADX INFO: renamed from: a */
    public final WeakReference f827a;

    public C0330Z(View view) {
        this.f827a = new WeakReference(view);
    }

    /* JADX INFO: renamed from: a */
    public final void m715a(float f3) {
        View view = (View) this.f827a.get();
        if (view != null) {
            view.animate().alpha(f3);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m716b() {
        View view = (View) this.f827a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m717c(long j2) {
        View view = (View) this.f827a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m718d(InterfaceC0332a0 interfaceC0332a0) {
        View view = (View) this.f827a.get();
        if (view != null) {
            if (interfaceC0332a0 != null) {
                view.animate().setListener(new C0328X(interfaceC0332a0, view));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m719e(float f3) {
        View view = (View) this.f827a.get();
        if (view != null) {
            view.animate().translationY(f3);
        }
    }
}
