package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import java.lang.reflect.Method;
import p005B.AbstractC0032g;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.C0703E;
import p069X0.C0717h;
import p069X0.C0724o;
import p069X0.EnumC0731v;
import p082b1.AbstractC1007C;
import p082b1.AbstractC1041l;
import p082b1.C1043n;
import p100g1.AbstractC1398g;
import p118m1.AbstractC1745j;
import p118m1.InterfaceC1737b;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.D */
/* JADX INFO: loaded from: classes.dex */
public final class C1146D extends AbstractC1204t {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: q */
    public final C1043n f3964q;

    /* JADX INFO: renamed from: r */
    public final Method f3965r;

    public C1146D(AbstractC1007C abstractC1007C, AbstractC0721l abstractC0721l, AbstractC1398g abstractC1398g, InterfaceC1737b interfaceC1737b, C1043n c1043n) {
        super(abstractC1007C, abstractC0721l, abstractC1398g, interfaceC1737b);
        this.f3964q = c1043n;
        this.f3965r = c1043n.f3704h;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: B */
    public final void mo2961B(Object obj, Object obj2) {
        throw new UnsupportedOperationException(AbstractC0032g.m157o(new StringBuilder("Should never call `set()` on setterless property ('"), this.f4102g.f1928e, "')"));
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: C */
    public final Object mo2962C(Object obj, Object obj2) {
        mo2961B(obj, obj2);
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: F */
    public final AbstractC1204t mo2963F(C0703E c0703e) {
        return new C1146D(this, c0703e);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: G */
    public final AbstractC1204t mo2964G(InterfaceC1178m interfaceC1178m) {
        return new C1146D(this, this.f4104i, interfaceC1178m);
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
        return new C1146D(this, abstractC0722m, interfaceC1178m);
    }

    @Override // p069X0.InterfaceC0714e
    /* JADX INFO: renamed from: c */
    public final AbstractC1041l mo1805c() {
        return this.f3964q;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: k */
    public final void mo2967k(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) throws C0724o {
        if (abstractC0545m.mo1168M(EnumC0548p.VALUE_NULL)) {
            return;
        }
        AbstractC1398g abstractC1398g = this.f4105j;
        C0703E c0703e = this.f4102g;
        if (abstractC1398g != null) {
            abstractC0718i.mo1713k("Problem deserializing 'setterless' property (\"" + c0703e.f1928e + "\"): no way to handle typed deser with setterless yet");
            throw null;
        }
        try {
            Object objInvoke = this.f3965r.invoke(obj, null);
            if (objInvoke != null) {
                this.f4104i.deserialize(abstractC0545m, abstractC0718i, objInvoke);
                return;
            }
            abstractC0718i.mo1713k("Problem deserializing 'setterless' property '" + c0703e.f1928e + "': get method returned null");
            throw null;
        } catch (Exception e3) {
            AbstractC1745j.m3874D(e3);
            AbstractC1745j.m3875E(e3);
            Throwable thM3894q = AbstractC1745j.m3894q(e3);
            throw new C0724o(abstractC0545m, AbstractC1745j.m3886i(thM3894q), thM3894q);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: l */
    public final Object mo2968l(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) throws C0724o {
        mo2967k(abstractC0545m, abstractC0718i, obj);
        return obj;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: n */
    public final void mo2969n(C0717h c0717h) {
        this.f3964q.m2799h(c0717h.m2157l(EnumC0731v.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public C1146D(C1146D c1146d, AbstractC0722m abstractC0722m, InterfaceC1178m interfaceC1178m) {
        super(c1146d, abstractC0722m, interfaceC1178m);
        this.f3964q = c1146d.f3964q;
        this.f3965r = c1146d.f3965r;
    }

    public C1146D(C1146D c1146d, C0703E c0703e) {
        super(c1146d, c0703e);
        this.f3964q = c1146d.f3964q;
        this.f3965r = c1146d.f3965r;
    }
}
