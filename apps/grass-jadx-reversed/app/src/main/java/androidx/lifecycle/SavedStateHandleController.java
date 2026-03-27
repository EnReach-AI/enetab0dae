package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
final class SavedStateHandleController implements InterfaceC0982o {

    /* JADX INFO: renamed from: a */
    public boolean f3307a;

    @Override // androidx.lifecycle.InterfaceC0982o
    /* JADX INFO: renamed from: b */
    public final void mo2170b(InterfaceC0984q interfaceC0984q, EnumC0978k enumC0978k) {
        if (enumC0978k == EnumC0978k.ON_DESTROY) {
            this.f3307a = false;
            interfaceC0984q.mo2199d().m2520f(this);
        }
    }
}
