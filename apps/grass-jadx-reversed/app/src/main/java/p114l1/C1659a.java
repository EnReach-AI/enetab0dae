package p114l1;

import java.lang.reflect.Array;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;

/* JADX INFO: renamed from: l1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1659a extends AbstractC1671m {

    /* JADX INFO: renamed from: p */
    public static final /* synthetic */ int f5882p = 0;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: n */
    public final AbstractC0721l f5883n;

    /* JADX INFO: renamed from: o */
    public final Object f5884o;

    public C1659a(AbstractC0721l abstractC0721l, C1674p c1674p, Object obj, Object obj2, Object obj3, boolean z3) {
        super(obj.getClass(), c1674p, null, null, abstractC0721l.hashCode(), obj2, obj3, z3);
        this.f5883n = abstractC0721l;
        this.f5884o = obj;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: B */
    public final AbstractC0721l mo1863B(Class cls, C1674p c1674p, AbstractC0721l abstractC0721l, AbstractC0721l[] abstractC0721lArr) {
        return null;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: C */
    public final AbstractC0721l mo1864C(AbstractC0721l abstractC0721l) {
        return new C1659a(abstractC0721l, this.f5913l, Array.newInstance((Class<?>) abstractC0721l.f2036e, 0), this.f2038g, this.f2039h, this.f2040i);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: D */
    public final AbstractC0721l mo1865D(Object obj) {
        AbstractC0721l abstractC0721l = this.f5883n;
        if (obj == abstractC0721l.f2039h) {
            return this;
        }
        return new C1659a(abstractC0721l.mo1869H(obj), this.f5913l, this.f5884o, this.f2038g, this.f2039h, this.f2040i);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: E */
    public final AbstractC0721l mo1866E(AbstractC0722m abstractC0722m) {
        AbstractC0721l abstractC0721l = this.f5883n;
        if (abstractC0722m == abstractC0721l.f2038g) {
            return this;
        }
        return new C1659a(abstractC0721l.mo1870I(abstractC0722m), this.f5913l, this.f5884o, this.f2038g, this.f2039h, this.f2040i);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: G */
    public final AbstractC0721l mo1868G() {
        if (this.f2040i) {
            return this;
        }
        return new C1659a(this.f5883n.mo1868G(), this.f5913l, this.f5884o, this.f2038g, this.f2039h, true);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: H */
    public final AbstractC0721l mo1869H(Object obj) {
        if (obj == this.f2039h) {
            return this;
        }
        return new C1659a(this.f5883n, this.f5913l, this.f5884o, this.f2038g, obj, this.f2040i);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: I */
    public final AbstractC0721l mo1870I(Object obj) {
        if (obj == this.f2038g) {
            return this;
        }
        return new C1659a(this.f5883n, this.f5913l, this.f5884o, obj, this.f2039h, this.f2040i);
    }

    @Override // p069X0.AbstractC0721l
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == C1659a.class) {
            return this.f5883n.equals(((C1659a) obj).f5883n);
        }
        return false;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: i */
    public final AbstractC0721l mo1874i() {
        return this.f5883n;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: j */
    public final StringBuilder mo1875j(StringBuilder sb) {
        sb.append('[');
        return this.f5883n.mo1875j(sb);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: k */
    public final StringBuilder mo1876k(StringBuilder sb) {
        sb.append('[');
        return this.f5883n.mo1876k(sb);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: p */
    public final boolean mo1881p() {
        return this.f5883n.mo1881p();
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: q */
    public final boolean mo1882q() {
        return super.mo1882q() || this.f5883n.mo1882q();
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: s */
    public final boolean mo1884s() {
        return false;
    }

    @Override // p069X0.AbstractC0721l
    public final String toString() {
        return "[array type, component type: " + this.f5883n + "]";
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: u */
    public final boolean mo1886u() {
        return true;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: v */
    public final boolean mo1887v() {
        return true;
    }
}
