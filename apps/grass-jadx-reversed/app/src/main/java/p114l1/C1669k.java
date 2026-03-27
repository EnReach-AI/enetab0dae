package p114l1;

import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;

/* JADX INFO: renamed from: l1.k */
/* JADX INFO: loaded from: classes.dex */
public final class C1669k extends AbstractC1663e {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: n */
    public AbstractC0721l f5909n;

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: B */
    public final AbstractC0721l mo1863B(Class cls, C1674p c1674p, AbstractC0721l abstractC0721l, AbstractC0721l[] abstractC0721lArr) {
        return null;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: C */
    public final AbstractC0721l mo1864C(AbstractC0721l abstractC0721l) {
        return this;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: D */
    public final AbstractC0721l mo1865D(Object obj) {
        return this;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: E */
    public final AbstractC0721l mo1866E(AbstractC0722m abstractC0722m) {
        return this;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: G */
    public final AbstractC0721l mo1868G() {
        return this;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: H */
    public final AbstractC0721l mo1869H(Object obj) {
        return this;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: I */
    public final AbstractC0721l mo1870I(Object obj) {
        return this;
    }

    @Override // p114l1.AbstractC1671m, p069X0.AbstractC0721l
    /* JADX INFO: renamed from: h */
    public final C1674p mo1873h() {
        AbstractC0721l abstractC0721l = this.f5909n;
        return abstractC0721l != null ? abstractC0721l.mo1873h() : this.f5913l;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: j */
    public final StringBuilder mo1875j(StringBuilder sb) {
        AbstractC0721l abstractC0721l = this.f5909n;
        return abstractC0721l != null ? abstractC0721l.mo1875j(sb) : sb;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: k */
    public final StringBuilder mo1876k(StringBuilder sb) {
        AbstractC0721l abstractC0721l = this.f5909n;
        if (abstractC0721l != null) {
            return abstractC0721l.mo1875j(sb);
        }
        sb.append("?");
        return sb;
    }

    @Override // p114l1.AbstractC1671m, p069X0.AbstractC0721l
    /* JADX INFO: renamed from: n */
    public final AbstractC0721l mo1879n() {
        AbstractC0721l abstractC0721l = this.f5909n;
        return abstractC0721l != null ? abstractC0721l.mo1879n() : this.f5911j;
    }

    @Override // p069X0.AbstractC0721l
    public final String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[recursive type; ");
        AbstractC0721l abstractC0721l = this.f5909n;
        if (abstractC0721l == null) {
            sb.append("UNRESOLVED");
        } else {
            sb.append(abstractC0721l.f2036e.getName());
        }
        return sb.toString();
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: v */
    public final boolean mo1887v() {
        return false;
    }
}
