package p119m2;

/* JADX INFO: renamed from: m2.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1768g implements InterfaceC1762a {

    /* JADX INFO: renamed from: a */
    public final Class f6145a;

    public C1768g(Class cls) {
        AbstractC1766e.m3920e("jClass", cls);
        this.f6145a = cls;
    }

    @Override // p119m2.InterfaceC1762a
    /* JADX INFO: renamed from: a */
    public final Class mo3914a() {
        return this.f6145a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1768g) {
            if (AbstractC1766e.m3916a(this.f6145a, ((C1768g) obj).f6145a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f6145a.hashCode();
    }

    public final String toString() {
        return this.f6145a.toString() + " (Kotlin reflection is not available)";
    }
}
