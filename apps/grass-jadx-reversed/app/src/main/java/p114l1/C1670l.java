package p114l1;

import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;

/* JADX INFO: renamed from: l1.l */
/* JADX INFO: loaded from: classes.dex */
public class C1670l extends AbstractC1671m {
    private static final long serialVersionUID = 1;

    public C1670l(Class cls, C1674p c1674p, AbstractC0721l abstractC0721l, AbstractC0721l[] abstractC0721lArr) {
        this(cls, c1674p, abstractC0721l, abstractC0721lArr, null, null, false);
    }

    /* JADX INFO: renamed from: M */
    public static C1670l m3758M(Class cls) {
        return new C1670l(cls, null, null, null, null, null, false);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: B */
    public AbstractC0721l mo1863B(Class cls, C1674p c1674p, AbstractC0721l abstractC0721l, AbstractC0721l[] abstractC0721lArr) {
        return null;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: C */
    public AbstractC0721l mo1864C(AbstractC0721l abstractC0721l) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContentType()");
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: D */
    public AbstractC0721l mo1865D(Object obj) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContenTypeHandler()");
    }

    @Override // p114l1.AbstractC1671m
    /* JADX INFO: renamed from: L */
    public String mo3749L() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2036e.getName());
        C1674p c1674p = this.f5913l;
        int length = c1674p.f5929f.length;
        if (length > 0 && m3760K(length)) {
            sb.append('<');
            for (int i3 = 0; i3 < length; i3++) {
                AbstractC0721l abstractC0721lM3764d = c1674p.m3764d(i3);
                if (i3 > 0) {
                    sb.append(',');
                }
                sb.append(abstractC0721lM3764d.mo1630e());
            }
            sb.append('>');
        }
        return sb.toString();
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public C1670l mo1866E(AbstractC0722m abstractC0722m) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContenValueHandler()");
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public C1670l mo1868G() {
        if (this.f2040i) {
            return this;
        }
        return new C1670l(this.f2036e, this.f5913l, this.f5911j, this.f5912k, this.f2038g, this.f2039h, true);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public C1670l mo1869H(Object obj) {
        if (this.f2039h == obj) {
            return this;
        }
        return new C1670l(this.f2036e, this.f5913l, this.f5911j, this.f5912k, this.f2038g, obj, this.f2040i);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public C1670l mo1870I(Object obj) {
        if (obj == this.f2038g) {
            return this;
        }
        return new C1670l(this.f2036e, this.f5913l, this.f5911j, this.f5912k, obj, this.f2039h, this.f2040i);
    }

    @Override // p069X0.AbstractC0721l
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        C1670l c1670l = (C1670l) obj;
        if (c1670l.f2036e != this.f2036e) {
            return false;
        }
        return this.f5913l.equals(c1670l.f5913l);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: j */
    public StringBuilder mo1875j(StringBuilder sb) {
        AbstractC1671m.m3759J(this.f2036e, sb, true);
        return sb;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: k */
    public StringBuilder mo1876k(StringBuilder sb) {
        AbstractC1671m.m3759J(this.f2036e, sb, false);
        C1674p c1674p = this.f5913l;
        int length = c1674p.f5929f.length;
        if (length > 0) {
            sb.append('<');
            for (int i3 = 0; i3 < length; i3++) {
                sb = c1674p.m3764d(i3).mo1876k(sb);
            }
            sb.append('>');
        }
        sb.append(';');
        return sb;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: o */
    public boolean mo1880o() {
        return this instanceof C1668j;
    }

    @Override // p069X0.AbstractC0721l
    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[simple type, class ");
        sb.append(mo3749L());
        sb.append(']');
        return sb.toString();
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: v */
    public final boolean mo1887v() {
        return false;
    }

    public C1670l(Class cls) {
        this(cls, C1674p.f5927k, null, null);
    }

    public C1670l(Class cls, C1674p c1674p, AbstractC0721l abstractC0721l, AbstractC0721l[] abstractC0721lArr, Object obj, Object obj2, boolean z3) {
        super(cls, c1674p, abstractC0721l, abstractC0721lArr, (c1674p == null ? C1674p.f5927k : c1674p).f5931h, obj, obj2, z3);
    }
}
