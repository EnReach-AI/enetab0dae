package p125o0;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Set;
import p010C0.AbstractC0147a;
import p129p0.C1819a;

/* JADX INFO: renamed from: o0.b */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC1792b implements View.OnClickListener {

    /* JADX INFO: renamed from: e */
    public C1819a f6183e;

    /* JADX INFO: renamed from: f */
    public WeakReference f6184f;

    /* JADX INFO: renamed from: g */
    public WeakReference f6185g;

    /* JADX INFO: renamed from: h */
    public View.OnClickListener f6186h;

    /* JADX INFO: renamed from: i */
    public boolean f6187i;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(this)) {
            return;
        }
        try {
            View.OnClickListener onClickListener = this.f6186h;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            WeakReference weakReference = this.f6185g;
            if (weakReference.get() != null) {
                WeakReference weakReference2 = this.f6184f;
                if (weakReference2.get() != null) {
                    C1819a c1819a = this.f6183e;
                    View view2 = (View) weakReference.get();
                    View view3 = (View) weakReference2.get();
                    if (set.contains(AbstractC1794d.class)) {
                        return;
                    }
                    try {
                        AbstractC1794d.m3953i(c1819a, view2, view3);
                    } catch (Throwable th) {
                        AbstractC0147a.m295a(th, AbstractC1794d.class);
                    }
                }
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, this);
        }
    }
}
