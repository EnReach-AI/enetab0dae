package p114l1;

import p069X0.AbstractC0721l;

/* JADX INFO: renamed from: l1.g */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1665g extends AbstractC1671m {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: n */
    public final AbstractC0721l f5903n;

    /* JADX INFO: renamed from: o */
    public final AbstractC0721l f5904o;

    public AbstractC1665g(Class cls, C1674p c1674p, AbstractC0721l abstractC0721l, AbstractC0721l[] abstractC0721lArr, AbstractC0721l abstractC0721l2, AbstractC0721l abstractC0721l3, Object obj, Object obj2, boolean z3) {
        super(cls, c1674p, abstractC0721l, abstractC0721lArr, abstractC0721l3.hashCode() + (abstractC0721l2.hashCode() * 31), obj, obj2, z3);
        this.f5903n = abstractC0721l2;
        this.f5904o = abstractC0721l3;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: F */
    public final AbstractC0721l mo1867F(AbstractC0721l abstractC0721l) {
        AbstractC0721l abstractC0721l2;
        AbstractC0721l abstractC0721lMo1867F;
        AbstractC0721l abstractC0721l3;
        AbstractC0721l abstractC0721lMo1867F2;
        AbstractC0721l abstractC0721lMo1867F3 = super.mo1867F(abstractC0721l);
        AbstractC0721l abstractC0721lMo1877l = abstractC0721l.mo1877l();
        if ((abstractC0721lMo1867F3 instanceof AbstractC1665g) && abstractC0721lMo1877l != null && (abstractC0721lMo1867F2 = (abstractC0721l3 = this.f5903n).mo1867F(abstractC0721lMo1877l)) != abstractC0721l3) {
            abstractC0721lMo1867F3 = ((AbstractC1665g) abstractC0721lMo1867F3).mo3750M(abstractC0721lMo1867F2);
        }
        AbstractC0721l abstractC0721lMo1874i = abstractC0721l.mo1874i();
        return (abstractC0721lMo1874i == null || (abstractC0721lMo1867F = (abstractC0721l2 = this.f5904o).mo1867F(abstractC0721lMo1874i)) == abstractC0721l2) ? abstractC0721lMo1867F3 : abstractC0721lMo1867F3.mo1864C(abstractC0721lMo1867F);
    }

    @Override // p114l1.AbstractC1671m
    /* JADX INFO: renamed from: L */
    public final String mo3749L() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2036e.getName());
        AbstractC0721l abstractC0721l = this.f5903n;
        if (abstractC0721l != null && m3760K(2)) {
            sb.append('<');
            sb.append(abstractC0721l.mo1630e());
            sb.append(',');
            sb.append(this.f5904o.mo1630e());
            sb.append('>');
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: M */
    public abstract C1666h mo3750M(AbstractC0721l abstractC0721l);

    @Override // p069X0.AbstractC0721l
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        AbstractC1665g abstractC1665g = (AbstractC1665g) obj;
        return this.f2036e == abstractC1665g.f2036e && this.f5903n.equals(abstractC1665g.f5903n) && this.f5904o.equals(abstractC1665g.f5904o);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: i */
    public final AbstractC0721l mo1874i() {
        return this.f5904o;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: j */
    public final StringBuilder mo1875j(StringBuilder sb) {
        AbstractC1671m.m3759J(this.f2036e, sb, true);
        return sb;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: k */
    public final StringBuilder mo1876k(StringBuilder sb) {
        AbstractC1671m.m3759J(this.f2036e, sb, false);
        sb.append('<');
        this.f5903n.mo1876k(sb);
        this.f5904o.mo1876k(sb);
        sb.append(">;");
        return sb;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: l */
    public final AbstractC0721l mo1877l() {
        return this.f5903n;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: q */
    public final boolean mo1882q() {
        return super.mo1882q() || this.f5904o.mo1882q() || this.f5903n.mo1882q();
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: v */
    public final boolean mo1887v() {
        return true;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: y */
    public final boolean mo1890y() {
        return true;
    }
}
