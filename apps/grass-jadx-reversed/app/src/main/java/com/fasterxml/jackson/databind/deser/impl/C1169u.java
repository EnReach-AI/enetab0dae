package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;
import p069X0.C0702D;
import p069X0.C0703E;
import p082b1.AbstractC1041l;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.u */
/* JADX INFO: loaded from: classes.dex */
public final class C1169u extends AbstractC1204t {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: q */
    public final C1167s f4029q;

    public C1169u(C1167s c1167s, C0702D c0702d) {
        super(c1167s.f4024f, c1167s.f4023e, c0702d, c1167s.f4026h);
        this.f4029q = c1167s;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: B */
    public final void mo2961B(Object obj, Object obj2) {
        mo2962C(obj, obj2);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: C */
    public final Object mo2962C(Object obj, Object obj2) {
        AbstractC1204t abstractC1204t = this.f4029q.f4027i;
        if (abstractC1204t != null) {
            return abstractC1204t.mo2962C(obj, obj2);
        }
        throw new UnsupportedOperationException("Should not call set() on ObjectIdProperty that has no SettableBeanProperty");
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: F */
    public final AbstractC1204t mo2963F(C0703E c0703e) {
        return new C1169u(this, c0703e);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: G */
    public final AbstractC1204t mo2964G(InterfaceC1178m interfaceC1178m) {
        return new C1169u(this, this.f4104i, interfaceC1178m);
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
        return new C1169u(this, abstractC0722m, interfaceC1178m);
    }

    @Override // p069X0.InterfaceC0714e
    /* JADX INFO: renamed from: c */
    public final AbstractC1041l mo1805c() {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: k */
    public final void mo2967k(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) {
        mo2968l(abstractC0545m, abstractC0718i, obj);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: l */
    public final Object mo2968l(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) {
        if (abstractC0545m.mo1168M(EnumC0548p.VALUE_NULL)) {
            return null;
        }
        abstractC0718i.mo1855t(this.f4104i.deserialize(abstractC0545m, abstractC0718i), this.f4029q.f4025g).getClass();
        throw null;
    }

    public C1169u(C1169u c1169u, AbstractC0722m abstractC0722m, InterfaceC1178m interfaceC1178m) {
        super(c1169u, abstractC0722m, interfaceC1178m);
        this.f4029q = c1169u.f4029q;
    }

    public C1169u(C1169u c1169u, C0703E c0703e) {
        super(c1169u, c0703e);
        this.f4029q = c1169u.f4029q;
    }
}
