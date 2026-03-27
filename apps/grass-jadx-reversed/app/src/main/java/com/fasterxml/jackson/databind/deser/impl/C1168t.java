package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import com.fasterxml.jackson.databind.deser.C1205u;
import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;
import p069X0.C0703E;
import p069X0.C0717h;
import p069X0.C0724o;
import p082b1.AbstractC1041l;
import p082b1.C1018N;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.t */
/* JADX INFO: loaded from: classes.dex */
public final class C1168t extends AbstractC1204t {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: q */
    public final AbstractC1204t f4028q;

    public C1168t(AbstractC1204t abstractC1204t, C1018N c1018n) {
        super(abstractC1204t);
        this.f4028q = abstractC1204t;
        this.f4108m = c1018n;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: B */
    public final void mo2961B(Object obj, Object obj2) {
        this.f4028q.mo2961B(obj, obj2);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: C */
    public final Object mo2962C(Object obj, Object obj2) {
        return this.f4028q.mo2962C(obj, obj2);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: F */
    public final AbstractC1204t mo2963F(C0703E c0703e) {
        return new C1168t(this, c0703e);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: G */
    public final AbstractC1204t mo2964G(InterfaceC1178m interfaceC1178m) {
        return new C1168t(this, this.f4104i, interfaceC1178m);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: H */
    public final AbstractC1204t mo2965H(AbstractC0722m abstractC0722m) {
        AbstractC0722m abstractC0722m2 = this.f4104i;
        if (abstractC0722m2 == abstractC0722m) {
            return this;
        }
        InterfaceC1178m interfaceC1178m = this.f4106k;
        if (abstractC0722m2 == interfaceC1178m) {
            interfaceC1178m = abstractC0722m;
        }
        return new C1168t(this, abstractC0722m, interfaceC1178m);
    }

    @Override // p069X0.InterfaceC0714e
    /* JADX INFO: renamed from: c */
    public final AbstractC1041l mo1805c() {
        return this.f4028q.mo1805c();
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: k */
    public final void mo2967k(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) throws C0724o {
        mo2968l(abstractC0545m, abstractC0718i, obj);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: l */
    public final Object mo2968l(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) throws C0724o {
        try {
            return this.f4028q.mo2962C(obj, m3079j(abstractC0545m, abstractC0718i));
        } catch (C1205u e3) {
            if (this.f4108m == null && this.f4104i.getObjectIdReader() == null) {
                throw new C0724o(abstractC0545m, "Unresolved forward reference but no identity info", e3);
            }
            Class cls = this.f4103h.f2036e;
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: n */
    public final void mo2969n(C0717h c0717h) {
        AbstractC1204t abstractC1204t = this.f4028q;
        if (abstractC1204t != null) {
            abstractC1204t.mo2969n(c0717h);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: o */
    public final int mo2970o() {
        return this.f4028q.mo2970o();
    }

    public C1168t(C1168t c1168t, AbstractC0722m abstractC0722m, InterfaceC1178m interfaceC1178m) {
        super(c1168t, abstractC0722m, interfaceC1178m);
        this.f4028q = c1168t.f4028q;
        this.f4108m = c1168t.f4108m;
    }

    public C1168t(C1168t c1168t, C0703E c0703e) {
        super(c1168t, c0703e);
        this.f4028q = c1168t.f4028q;
        this.f4108m = c1168t.f4108m;
    }
}
