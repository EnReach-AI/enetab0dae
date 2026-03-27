package p015D2;

import java.io.Serializable;
import p005B.AbstractC0032g;
import p083b2.InterfaceC1057b;
import p115l2.InterfaceC1693p;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1770i;
import p119m2.C1768g;
import p119m2.InterfaceC1762a;
import p119m2.InterfaceC1765d;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: D2.k */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0187k implements InterfaceC1693p, InterfaceC1765d, Serializable, InterfaceC1057b {

    /* JADX INFO: renamed from: e */
    public transient C0187k f430e;

    /* JADX INFO: renamed from: f */
    public final Object f431f;

    /* JADX INFO: renamed from: g */
    public final Class f432g = C0188l.class;

    /* JADX INFO: renamed from: h */
    public final String f433h = "readIfAbsent";

    /* JADX INFO: renamed from: i */
    public final String f434i = "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z";

    /* JADX INFO: renamed from: j */
    public final boolean f435j = false;

    /* JADX INFO: renamed from: k */
    public final int f436k = 2;

    /* JADX INFO: renamed from: l */
    public final int f437l = 0;

    public C0187k(Object obj) {
        this.f431f = obj;
    }

    @Override // p119m2.InterfaceC1765d
    /* JADX INFO: renamed from: b */
    public final int mo316b() {
        return this.f436k;
    }

    @Override // p115l2.InterfaceC1693p
    /* JADX INFO: renamed from: c */
    public final Object mo317c(Object obj, Object obj2) {
        InterfaceC2095g interfaceC2095g = (InterfaceC2095g) obj;
        int iIntValue = ((Number) obj2).intValue();
        AbstractC1766e.m3920e("p0", interfaceC2095g);
        C0188l c0188l = (C0188l) this.f431f;
        c0188l.getClass();
        boolean z3 = !interfaceC2095g.mo238j(iIntValue) && interfaceC2095g.mo236h(iIntValue).mo234f();
        c0188l.f439b = z3;
        return Boolean.valueOf(z3);
    }

    /* JADX INFO: renamed from: d */
    public final InterfaceC1762a m318d() {
        Class cls = this.f432g;
        if (cls == null) {
            return null;
        }
        if (!this.f435j) {
            return AbstractC1770i.m3927a(cls);
        }
        AbstractC1770i.f6147a.getClass();
        return new C1768g(cls);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0187k) {
            C0187k c0187k = (C0187k) obj;
            return this.f433h.equals(c0187k.f433h) && this.f434i.equals(c0187k.f434i) && this.f437l == c0187k.f437l && this.f436k == c0187k.f436k && AbstractC1766e.m3916a(this.f431f, c0187k.f431f) && AbstractC1766e.m3916a(m318d(), c0187k.m318d());
        }
        if (!(obj instanceof C0187k)) {
            return false;
        }
        C0187k c0187k2 = this.f430e;
        if (c0187k2 == null) {
            AbstractC1770i.f6147a.getClass();
            this.f430e = this;
            c0187k2 = this;
        }
        return obj.equals(c0187k2);
    }

    public final int hashCode() {
        return this.f434i.hashCode() + ((this.f433h.hashCode() + (m318d() == null ? 0 : m318d().hashCode() * 31)) * 31);
    }

    public final String toString() {
        C0187k c0187k = this.f430e;
        if (c0187k == null) {
            AbstractC1770i.f6147a.getClass();
            this.f430e = this;
            c0187k = this;
        }
        if (c0187k != this) {
            return c0187k.toString();
        }
        String str = this.f433h;
        return "<init>".equals(str) ? "constructor (Kotlin reflection is not available)" : AbstractC0032g.m154l("function ", str, " (Kotlin reflection is not available)");
    }
}
