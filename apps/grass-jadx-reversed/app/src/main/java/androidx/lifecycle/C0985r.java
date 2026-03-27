package androidx.lifecycle;

/* JADX INFO: renamed from: androidx.lifecycle.r */
/* JADX INFO: loaded from: classes.dex */
public final class C0985r {

    /* JADX INFO: renamed from: a */
    public EnumC0979l f3325a;

    /* JADX INFO: renamed from: b */
    public InterfaceC0982o f3326b;

    /* JADX INFO: renamed from: a */
    public final void m2514a(InterfaceC0984q interfaceC0984q, EnumC0978k enumC0978k) {
        EnumC0979l enumC0979lM2512a = enumC0978k.m2512a();
        EnumC0979l enumC0979l = this.f3325a;
        if (enumC0979lM2512a.compareTo(enumC0979l) < 0) {
            enumC0979l = enumC0979lM2512a;
        }
        this.f3325a = enumC0979l;
        this.f3326b.mo2170b(interfaceC0984q, enumC0978k);
        this.f3325a = enumC0979lM2512a;
    }
}
