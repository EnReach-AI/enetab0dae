package com.fasterxml.jackson.databind.deser;

import java.io.Closeable;
import p039M0.C0480b;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.C0702D;
import p069X0.C0703E;
import p069X0.C0717h;
import p078a1.C0850b;
import p082b1.AbstractC1041l;
import p082b1.C1047r;
import p100g1.AbstractC1398g;
import p118m1.AbstractC1745j;
import p118m1.InterfaceC1737b;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1140g extends AbstractC1204t {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: q */
    public final C1047r f3946q;

    /* JADX INFO: renamed from: r */
    public final C0480b f3947r;

    /* JADX INFO: renamed from: s */
    public AbstractC1204t f3948s;

    /* JADX INFO: renamed from: t */
    public final int f3949t;

    /* JADX INFO: renamed from: u */
    public boolean f3950u;

    public C1140g(C0703E c0703e, AbstractC0721l abstractC0721l, AbstractC1398g abstractC1398g, InterfaceC1737b interfaceC1737b, C1047r c1047r, int i3, C0480b c0480b, C0702D c0702d) {
        super(c0703e, abstractC0721l, null, abstractC1398g, interfaceC1737b, c0702d);
        this.f3946q = c1047r;
        this.f3949t = i3;
        this.f3947r = c0480b;
        this.f3948s = null;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: A */
    public final void mo2960A() {
        this.f3950u = true;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: B */
    public final void mo2961B(Object obj, Object obj2) throws C0850b {
        m2966I();
        this.f3948s.mo2961B(obj, obj2);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: C */
    public final Object mo2962C(Object obj, Object obj2) throws C0850b {
        m2966I();
        return this.f3948s.mo2962C(obj, obj2);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: F */
    public final AbstractC1204t mo2963F(C0703E c0703e) {
        return new C1140g(this, c0703e);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: G */
    public final AbstractC1204t mo2964G(InterfaceC1178m interfaceC1178m) {
        return new C1140g(this, this.f4104i, interfaceC1178m);
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
        return new C1140g(this, abstractC0722m, interfaceC1178m);
    }

    /* JADX INFO: renamed from: I */
    public final void m2966I() throws C0850b {
        if (this.f3948s != null) {
            return;
        }
        throw new C0850b((Closeable) null, "No fallback setter/field defined for creator property " + AbstractC1745j.m3902y(this.f4102g.f1928e));
    }

    @Override // p082b1.AbstractC1010F, p069X0.InterfaceC0714e
    /* JADX INFO: renamed from: b */
    public final C0702D mo1804b() {
        AbstractC1204t abstractC1204t = this.f3948s;
        C0702D c0702d = this.f3593e;
        return abstractC1204t != null ? c0702d.m1685b(abstractC1204t.mo1804b().f1923i) : c0702d;
    }

    @Override // p069X0.InterfaceC0714e
    /* JADX INFO: renamed from: c */
    public final AbstractC1041l mo1805c() {
        return this.f3946q;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: k */
    public final void mo2967k(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) throws C0850b {
        m2966I();
        this.f3948s.mo2961B(obj, m3079j(abstractC0545m, abstractC0718i));
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: l */
    public final Object mo2968l(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) throws C0850b {
        m2966I();
        return this.f3948s.mo2962C(obj, m3079j(abstractC0545m, abstractC0718i));
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: n */
    public final void mo2969n(C0717h c0717h) {
        AbstractC1204t abstractC1204t = this.f3948s;
        if (abstractC1204t != null) {
            abstractC1204t.mo2969n(c0717h);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: o */
    public final int mo2970o() {
        return this.f3949t;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: p */
    public final Object mo2971p() {
        C0480b c0480b = this.f3947r;
        if (c0480b == null) {
            return null;
        }
        return c0480b.f1120e;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    public final String toString() {
        return "[creator property, name " + AbstractC1745j.m3902y(this.f4102g.f1928e) + "; inject id '" + mo2971p() + "']";
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: y */
    public final boolean mo2972y() {
        return this.f3950u;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: z */
    public final boolean mo2973z() {
        C0480b c0480b = this.f3947r;
        if (c0480b != null) {
            Boolean bool = c0480b.f1121f;
            if (!(bool == null ? true : bool.booleanValue())) {
                return true;
            }
        }
        return false;
    }

    public C1140g(C1140g c1140g, C0703E c0703e) {
        super(c1140g, c0703e);
        this.f3946q = c1140g.f3946q;
        this.f3947r = c1140g.f3947r;
        this.f3948s = c1140g.f3948s;
        this.f3949t = c1140g.f3949t;
        this.f3950u = c1140g.f3950u;
    }

    public C1140g(C1140g c1140g, AbstractC0722m abstractC0722m, InterfaceC1178m interfaceC1178m) {
        super(c1140g, abstractC0722m, interfaceC1178m);
        this.f3946q = c1140g.f3946q;
        this.f3947r = c1140g.f3947r;
        this.f3948s = c1140g.f3948s;
        this.f3949t = c1140g.f3949t;
        this.f3950u = c1140g.f3950u;
    }
}
