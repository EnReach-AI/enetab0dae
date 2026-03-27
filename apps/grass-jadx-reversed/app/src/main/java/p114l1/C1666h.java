package p114l1;

import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;

/* JADX INFO: renamed from: l1.h */
/* JADX INFO: loaded from: classes.dex */
public final class C1666h extends AbstractC1665g {
    private static final long serialVersionUID = 1;

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: B */
    public final AbstractC0721l mo1863B(Class cls, C1674p c1674p, AbstractC0721l abstractC0721l, AbstractC0721l[] abstractC0721lArr) {
        return new C1666h(cls, c1674p, abstractC0721l, abstractC0721lArr, this.f5903n, this.f5904o, this.f2038g, this.f2039h, this.f2040i);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: C */
    public final AbstractC0721l mo1864C(AbstractC0721l abstractC0721l) {
        return this.f5904o == abstractC0721l ? this : new C1666h(this.f2036e, this.f5913l, this.f5911j, this.f5912k, this.f5903n, abstractC0721l, this.f2038g, this.f2039h, this.f2040i);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: D */
    public final AbstractC0721l mo1865D(Object obj) {
        AbstractC0721l abstractC0721lMo1869H = this.f5904o.mo1869H(obj);
        return new C1666h(this.f2036e, this.f5913l, this.f5911j, this.f5912k, this.f5903n, abstractC0721lMo1869H, this.f2038g, this.f2039h, this.f2040i);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: E */
    public final AbstractC0721l mo1866E(AbstractC0722m abstractC0722m) {
        AbstractC0721l abstractC0721lMo1870I = this.f5904o.mo1870I(abstractC0722m);
        return new C1666h(this.f2036e, this.f5913l, this.f5911j, this.f5912k, this.f5903n, abstractC0721lMo1870I, this.f2038g, this.f2039h, this.f2040i);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: G */
    public final AbstractC0721l mo1868G() {
        if (this.f2040i) {
            return this;
        }
        return new C1666h(this.f2036e, this.f5913l, this.f5911j, this.f5912k, this.f5903n.mo1868G(), this.f5904o.mo1868G(), this.f2038g, this.f2039h, true);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: H */
    public final AbstractC0721l mo1869H(Object obj) {
        return new C1666h(this.f2036e, this.f5913l, this.f5911j, this.f5912k, this.f5903n, this.f5904o, this.f2038g, obj, this.f2040i);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: I */
    public final AbstractC0721l mo1870I(Object obj) {
        return new C1666h(this.f2036e, this.f5913l, this.f5911j, this.f5912k, this.f5903n, this.f5904o, obj, this.f2039h, this.f2040i);
    }

    @Override // p114l1.AbstractC1665g
    /* JADX INFO: renamed from: M */
    public final C1666h mo3750M(AbstractC0721l abstractC0721l) {
        if (abstractC0721l == this.f5903n) {
            return this;
        }
        return new C1666h(this.f2036e, this.f5913l, this.f5911j, this.f5912k, abstractC0721l, this.f5904o, this.f2038g, this.f2039h, this.f2040i);
    }

    @Override // p069X0.AbstractC0721l
    public final String toString() {
        return "[map type; class " + this.f2036e.getName() + ", " + this.f5903n + " -> " + this.f5904o + "]";
    }
}
