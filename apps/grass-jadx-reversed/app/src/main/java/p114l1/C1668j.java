package p114l1;

import java.util.Objects;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;

/* JADX INFO: renamed from: l1.j */
/* JADX INFO: loaded from: classes.dex */
public final class C1668j extends C1670l {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: n */
    public final AbstractC0721l f5907n;

    /* JADX INFO: renamed from: o */
    public final AbstractC0721l f5908o;

    public C1668j(Class cls, C1674p c1674p, AbstractC0721l abstractC0721l, AbstractC0721l[] abstractC0721lArr, AbstractC0721l abstractC0721l2, AbstractC0721l abstractC0721l3, Object obj, Object obj2, boolean z3) {
        super(cls, c1674p, abstractC0721l, abstractC0721lArr, Objects.hashCode(abstractC0721l2), obj, obj2, z3);
        this.f5907n = abstractC0721l2;
        this.f5908o = abstractC0721l3 == null ? this : abstractC0721l3;
    }

    @Override // p114l1.C1670l, p069X0.AbstractC0721l
    /* JADX INFO: renamed from: B */
    public final AbstractC0721l mo1863B(Class cls, C1674p c1674p, AbstractC0721l abstractC0721l, AbstractC0721l[] abstractC0721lArr) {
        return new C1668j(cls, this.f5913l, abstractC0721l, abstractC0721lArr, this.f5907n, this.f5908o, this.f2038g, this.f2039h, this.f2040i);
    }

    @Override // p114l1.C1670l, p069X0.AbstractC0721l
    /* JADX INFO: renamed from: C */
    public final AbstractC0721l mo1864C(AbstractC0721l abstractC0721l) {
        if (this.f5907n == abstractC0721l) {
            return this;
        }
        return new C1668j(this.f2036e, this.f5913l, this.f5911j, this.f5912k, abstractC0721l, this.f5908o, this.f2038g, this.f2039h, this.f2040i);
    }

    @Override // p114l1.C1670l, p069X0.AbstractC0721l
    /* JADX INFO: renamed from: D */
    public final AbstractC0721l mo1865D(Object obj) {
        AbstractC0721l abstractC0721l = this.f5907n;
        if (obj == abstractC0721l.f2039h) {
            return this;
        }
        return new C1668j(this.f2036e, this.f5913l, this.f5911j, this.f5912k, abstractC0721l.mo1869H(obj), this.f5908o, this.f2038g, this.f2039h, this.f2040i);
    }

    @Override // p114l1.C1670l, p069X0.AbstractC0721l
    /* JADX INFO: renamed from: H */
    public final AbstractC0721l mo1869H(Object obj) {
        if (obj == this.f2039h) {
            return this;
        }
        return new C1668j(this.f2036e, this.f5913l, this.f5911j, this.f5912k, this.f5907n, this.f5908o, this.f2038g, obj, this.f2040i);
    }

    @Override // p114l1.C1670l, p069X0.AbstractC0721l
    /* JADX INFO: renamed from: I */
    public final AbstractC0721l mo1870I(Object obj) {
        if (obj == this.f2038g) {
            return this;
        }
        return new C1668j(this.f2036e, this.f5913l, this.f5911j, this.f5912k, this.f5907n, this.f5908o, obj, this.f2039h, this.f2040i);
    }

    @Override // p114l1.C1670l, p114l1.AbstractC1671m
    /* JADX INFO: renamed from: L */
    public final String mo3749L() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2036e.getName());
        AbstractC0721l abstractC0721l = this.f5907n;
        if (abstractC0721l != null && m3760K(1)) {
            sb.append('<');
            sb.append(abstractC0721l.mo1630e());
            sb.append('>');
        }
        return sb.toString();
    }

    @Override // p114l1.C1670l
    /* JADX INFO: renamed from: P */
    public final C1670l mo1869H(Object obj) {
        if (obj == this.f2039h) {
            return this;
        }
        return new C1668j(this.f2036e, this.f5913l, this.f5911j, this.f5912k, this.f5907n, this.f5908o, this.f2038g, obj, this.f2040i);
    }

    @Override // p114l1.C1670l
    /* JADX INFO: renamed from: Q */
    public final C1670l mo1870I(Object obj) {
        if (obj == this.f2038g) {
            return this;
        }
        return new C1668j(this.f2036e, this.f5913l, this.f5911j, this.f5912k, this.f5907n, this.f5908o, obj, this.f2039h, this.f2040i);
    }

    @Override // p114l1.C1670l
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public final C1668j mo1866E(AbstractC0722m abstractC0722m) {
        AbstractC0721l abstractC0721l = this.f5907n;
        if (abstractC0722m == abstractC0721l.f2038g) {
            return this;
        }
        return new C1668j(this.f2036e, this.f5913l, this.f5911j, this.f5912k, abstractC0721l.mo1870I(abstractC0722m), this.f5908o, this.f2038g, this.f2039h, this.f2040i);
    }

    @Override // p114l1.C1670l
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public final C1668j mo1868G() {
        if (this.f2040i) {
            return this;
        }
        return new C1668j(this.f2036e, this.f5913l, this.f5911j, this.f5912k, this.f5907n.mo1868G(), this.f5908o, this.f2038g, this.f2039h, true);
    }

    @Override // p069X0.AbstractC0721l, p064V0.AbstractC0671a
    /* JADX INFO: renamed from: a */
    public final AbstractC0721l mo1628a() {
        return this.f5907n;
    }

    @Override // p064V0.AbstractC0671a
    /* JADX INFO: renamed from: b */
    public final boolean mo1629b() {
        return true;
    }

    @Override // p114l1.C1670l, p069X0.AbstractC0721l
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C1668j.class) {
            return false;
        }
        C1668j c1668j = (C1668j) obj;
        if (c1668j.f2036e != this.f2036e) {
            return false;
        }
        return this.f5907n.equals(c1668j.f5907n);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: i */
    public final AbstractC0721l mo1874i() {
        return this.f5907n;
    }

    @Override // p114l1.C1670l, p069X0.AbstractC0721l
    /* JADX INFO: renamed from: j */
    public final StringBuilder mo1875j(StringBuilder sb) {
        AbstractC1671m.m3759J(this.f2036e, sb, true);
        return sb;
    }

    @Override // p114l1.C1670l, p069X0.AbstractC0721l
    /* JADX INFO: renamed from: k */
    public final StringBuilder mo1876k(StringBuilder sb) {
        AbstractC1671m.m3759J(this.f2036e, sb, false);
        sb.append('<');
        StringBuilder sbMo1876k = this.f5907n.mo1876k(sb);
        sbMo1876k.append(">;");
        return sbMo1876k;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: m */
    public final AbstractC0721l mo1628a() {
        return this.f5907n;
    }

    @Override // p114l1.C1670l, p069X0.AbstractC0721l
    public final String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[reference type, class ");
        sb.append(mo3749L());
        sb.append('<');
        sb.append(this.f5907n);
        sb.append(">]");
        return sb.toString();
    }
}
