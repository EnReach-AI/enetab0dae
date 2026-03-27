package p008B2;

import java.util.List;
import p119m2.AbstractC1766e;
import p135q2.InterfaceC1840a;
import p135q2.InterfaceC1841b;
import p148u0.AbstractC1946e;

/* JADX INFO: renamed from: B2.L */
/* JADX INFO: loaded from: classes.dex */
public final class C0072L implements InterfaceC1841b {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1841b f233a;

    public C0072L(InterfaceC1841b interfaceC1841b) {
        AbstractC1766e.m3920e("origin", interfaceC1841b);
        this.f233a = interfaceC1841b;
    }

    @Override // p135q2.InterfaceC1841b
    /* JADX INFO: renamed from: a */
    public final List mo246a() {
        return this.f233a.mo246a();
    }

    @Override // p135q2.InterfaceC1841b
    /* JADX INFO: renamed from: b */
    public final boolean mo247b() {
        return this.f233a.mo247b();
    }

    @Override // p135q2.InterfaceC1841b
    /* JADX INFO: renamed from: c */
    public final InterfaceC1840a mo248c() {
        return this.f233a.mo248c();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C0072L c0072l = obj instanceof C0072L ? (C0072L) obj : null;
        InterfaceC1841b interfaceC1841b = c0072l != null ? c0072l.f233a : null;
        InterfaceC1841b interfaceC1841b2 = this.f233a;
        if (!AbstractC1766e.m3916a(interfaceC1841b2, interfaceC1841b)) {
            return false;
        }
        InterfaceC1840a interfaceC1840aMo248c = interfaceC1841b2.mo248c();
        if (interfaceC1840aMo248c instanceof InterfaceC1840a) {
            InterfaceC1841b interfaceC1841b3 = obj instanceof InterfaceC1841b ? (InterfaceC1841b) obj : null;
            InterfaceC1840a interfaceC1840aMo248c2 = interfaceC1841b3 != null ? interfaceC1841b3.mo248c() : null;
            if (interfaceC1840aMo248c2 != null && (interfaceC1840aMo248c2 instanceof InterfaceC1840a)) {
                return AbstractC1946e.m4344b(interfaceC1840aMo248c).equals(AbstractC1946e.m4344b(interfaceC1840aMo248c2));
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f233a.hashCode();
    }

    public final String toString() {
        return "KTypeWrapper: " + this.f233a;
    }
}
