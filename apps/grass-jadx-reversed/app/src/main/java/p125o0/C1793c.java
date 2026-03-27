package p125o0;

import android.view.View;
import android.widget.AdapterView;
import java.lang.ref.WeakReference;
import p010C0.AbstractC0147a;
import p129p0.C1819a;

/* JADX INFO: renamed from: o0.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1793c implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: e */
    public C1819a f6188e;

    /* JADX INFO: renamed from: f */
    public WeakReference f6189f;

    /* JADX INFO: renamed from: g */
    public WeakReference f6190g;

    /* JADX INFO: renamed from: h */
    public AdapterView.OnItemClickListener f6191h;

    /* JADX INFO: renamed from: i */
    public boolean f6192i;

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i3, long j2) {
        AdapterView.OnItemClickListener onItemClickListener = this.f6191h;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(adapterView, view, i3, j2);
        }
        WeakReference weakReference = this.f6190g;
        if (weakReference.get() != null) {
            WeakReference weakReference2 = this.f6189f;
            if (weakReference2.get() != null) {
                View view2 = (View) weakReference.get();
                View view3 = (View) weakReference2.get();
                C1819a c1819a = this.f6188e;
                if (AbstractC0147a.f354a.contains(AbstractC1794d.class)) {
                    return;
                }
                try {
                    AbstractC1794d.m3953i(c1819a, view2, view3);
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, AbstractC1794d.class);
                }
            }
        }
    }
}
