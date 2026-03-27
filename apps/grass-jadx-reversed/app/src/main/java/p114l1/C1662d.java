package p114l1;

import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;

/* JADX INFO: renamed from: l1.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1662d extends AbstractC1661c {
    private static final long serialVersionUID = 1;

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: B */
    public final AbstractC0721l mo1863B(Class cls, C1674p c1674p, AbstractC0721l abstractC0721l, AbstractC0721l[] abstractC0721lArr) {
        return new C1662d(cls, c1674p, abstractC0721l, abstractC0721lArr, this.f5888n, this.f2038g, this.f2039h, this.f2040i);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: C */
    public final AbstractC0721l mo1864C(AbstractC0721l abstractC0721l) {
        return this.f5888n == abstractC0721l ? this : new C1662d(this.f2036e, this.f5913l, this.f5911j, this.f5912k, abstractC0721l, this.f2038g, this.f2039h, this.f2040i);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: D */
    public final AbstractC0721l mo1865D(Object obj) {
        AbstractC0721l abstractC0721lMo1869H = this.f5888n.mo1869H(obj);
        return new C1662d(this.f2036e, this.f5913l, this.f5911j, this.f5912k, abstractC0721lMo1869H, this.f2038g, this.f2039h, this.f2040i);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: E */
    public final AbstractC0721l mo1866E(AbstractC0722m abstractC0722m) {
        AbstractC0721l abstractC0721lMo1870I = this.f5888n.mo1870I(abstractC0722m);
        return new C1662d(this.f2036e, this.f5913l, this.f5911j, this.f5912k, abstractC0721lMo1870I, this.f2038g, this.f2039h, this.f2040i);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: G */
    public final AbstractC0721l mo1868G() {
        if (this.f2040i) {
            return this;
        }
        return new C1662d(this.f2036e, this.f5913l, this.f5911j, this.f5912k, this.f5888n.mo1868G(), this.f2038g, this.f2039h, true);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: H */
    public final AbstractC0721l mo1869H(Object obj) {
        return new C1662d(this.f2036e, this.f5913l, this.f5911j, this.f5912k, this.f5888n, this.f2038g, obj, this.f2040i);
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: I */
    public final AbstractC0721l mo1870I(Object obj) {
        return new C1662d(this.f2036e, this.f5913l, this.f5911j, this.f5912k, this.f5888n, obj, this.f2039h, this.f2040i);
    }

    @Override // p069X0.AbstractC0721l
    public final String toString() {
        return "[collection type; class " + this.f2036e.getName() + ", contains " + this.f5888n + "]";
    }
}
