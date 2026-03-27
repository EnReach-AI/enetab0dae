package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleAttacher implements InterfaceC0982o {

    /* JADX INFO: renamed from: a */
    public final C0962G f3306a;

    public SavedStateHandleAttacher(C0962G c0962g) {
        this.f3306a = c0962g;
    }

    @Override // androidx.lifecycle.InterfaceC0982o
    /* JADX INFO: renamed from: b */
    public final void mo2170b(InterfaceC0984q interfaceC0984q, EnumC0978k enumC0978k) {
        if (enumC0978k != EnumC0978k.ON_CREATE) {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + enumC0978k).toString());
        }
        interfaceC0984q.mo2199d().m2520f(this);
        C0962G c0962g = this.f3306a;
        if (c0962g.f3295b) {
            return;
        }
        c0962g.f3296c = c0962g.f3294a.m2174d("androidx.lifecycle.internal.SavedStateHandlesProvider");
        c0962g.f3295b = true;
    }
}
