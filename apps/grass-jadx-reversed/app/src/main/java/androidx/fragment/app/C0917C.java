package androidx.fragment.app;

import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.fragment.app.C */
/* JADX INFO: loaded from: classes.dex */
public final class C0917C implements InterfaceC0916B {

    /* JADX INFO: renamed from: a */
    public final int f3019a;

    /* JADX INFO: renamed from: b */
    public final int f3020b = 1;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C0918D f3021c;

    public C0917C(C0918D c0918d, int i3) {
        this.f3021c = c0918d;
        this.f3019a = i3;
    }

    @Override // androidx.fragment.app.InterfaceC0916B
    /* JADX INFO: renamed from: a */
    public final boolean mo2363a(ArrayList arrayList, ArrayList arrayList2) {
        C0918D c0918d = this.f3021c;
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = c0918d.f3045q;
        int i3 = this.f3019a;
        if (abstractComponentCallbacksC0944o == null || i3 >= 0 || !abstractComponentCallbacksC0944o.m2491i().m2372H()) {
            return c0918d.m2373I(arrayList, arrayList2, i3, this.f3020b);
        }
        return false;
    }
}
