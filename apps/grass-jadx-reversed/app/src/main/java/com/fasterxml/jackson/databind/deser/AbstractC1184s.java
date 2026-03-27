package com.fasterxml.jackson.databind.deser;

import p069X0.AbstractC0722m;
import p069X0.C0703E;
import p069X0.C0717h;
import p082b1.AbstractC1041l;
import p082b1.C1018N;
import p100g1.AbstractC1398g;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.s */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1184s extends AbstractC1204t {

    /* JADX INFO: renamed from: q */
    public final AbstractC1204t f4049q;

    public AbstractC1184s(AbstractC1204t abstractC1204t) {
        super(abstractC1204t);
        this.f4049q = abstractC1204t;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: B */
    public void mo2961B(Object obj, Object obj2) {
        this.f4049q.mo2961B(obj, obj2);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: C */
    public Object mo2962C(Object obj, Object obj2) {
        return this.f4049q.mo2962C(obj, obj2);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: E */
    public final boolean mo3027E(Class cls) {
        return this.f4049q.mo3027E(cls);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: F */
    public final AbstractC1204t mo2963F(C0703E c0703e) {
        AbstractC1204t abstractC1204t = this.f4049q;
        AbstractC1204t abstractC1204tMo2963F = abstractC1204t.mo2963F(c0703e);
        return abstractC1204tMo2963F == abstractC1204t ? this : mo3004I(abstractC1204tMo2963F);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: G */
    public final AbstractC1204t mo2964G(InterfaceC1178m interfaceC1178m) {
        AbstractC1204t abstractC1204t = this.f4049q;
        AbstractC1204t abstractC1204tMo2964G = abstractC1204t.mo2964G(interfaceC1178m);
        return abstractC1204tMo2964G == abstractC1204t ? this : mo3004I(abstractC1204tMo2964G);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: H */
    public final AbstractC1204t mo2965H(AbstractC0722m abstractC0722m) {
        AbstractC1204t abstractC1204t = this.f4049q;
        AbstractC1204t abstractC1204tMo2965H = abstractC1204t.mo2965H(abstractC0722m);
        return abstractC1204tMo2965H == abstractC1204t ? this : mo3004I(abstractC1204tMo2965H);
    }

    /* JADX INFO: renamed from: I */
    public abstract AbstractC1204t mo3004I(AbstractC1204t abstractC1204t);

    @Override // p069X0.InterfaceC0714e
    /* JADX INFO: renamed from: c */
    public final AbstractC1041l mo1805c() {
        return this.f4049q.mo1805c();
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: i */
    public final void mo3028i(int i3) {
        this.f4049q.mo3028i(i3);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: n */
    public void mo2969n(C0717h c0717h) {
        this.f4049q.mo2969n(c0717h);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: o */
    public final int mo2970o() {
        return this.f4049q.mo2970o();
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: p */
    public final Object mo2971p() {
        return this.f4049q.mo2971p();
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: q */
    public final String mo3029q() {
        return this.f4049q.mo3029q();
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: r */
    public final C1018N mo3030r() {
        return this.f4049q.mo3030r();
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: s */
    public final int mo3031s() {
        return this.f4049q.mo3031s();
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: t */
    public final AbstractC0722m mo3032t() {
        return this.f4049q.mo3032t();
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: u */
    public final AbstractC1398g mo3033u() {
        return this.f4049q.mo3033u();
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: v */
    public final boolean mo3034v() {
        return this.f4049q.mo3034v();
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: w */
    public final boolean mo3035w() {
        return this.f4049q.mo3035w();
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: x */
    public final boolean mo3036x() {
        return this.f4049q.mo3036x();
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: z */
    public final boolean mo2973z() {
        return this.f4049q.mo2973z();
    }
}
