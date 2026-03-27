package p110k;

import android.view.View;
import p108j.InterfaceC1477k;
import p108j.MenuC1479m;

/* JADX INFO: renamed from: k.g */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1588g implements Runnable {

    /* JADX INFO: renamed from: e */
    public final C1582e f5634e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ C1594i f5635f;

    public RunnableC1588g(C1594i c1594i, C1582e c1582e) {
        this.f5635f = c1594i;
        this.f5634e = c1582e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC1477k interfaceC1477k;
        C1594i c1594i = this.f5635f;
        MenuC1479m menuC1479m = c1594i.f5643g;
        if (menuC1479m != null && (interfaceC1477k = menuC1479m.f5348e) != null) {
            interfaceC1477k.mo444c(menuC1479m);
        }
        View view = (View) c1594i.f5648l;
        if (view != null && view.getWindowToken() != null) {
            C1582e c1582e = this.f5634e;
            if (c1582e.m3539b()) {
                c1594i.f5659w = c1582e;
            } else if (c1582e.f5417f != null) {
                c1582e.m3541d(0, 0, false, false);
                c1594i.f5659w = c1582e;
            }
        }
        c1594i.f5661y = null;
    }
}
