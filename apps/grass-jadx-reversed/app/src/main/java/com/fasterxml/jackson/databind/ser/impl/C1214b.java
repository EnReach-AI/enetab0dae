package com.fasterxml.jackson.databind.ser.impl;

import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0728s;
import p112k1.C1635c;
import p118m1.AbstractC1757v;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.ser.impl.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1214b extends C1635c {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: w */
    public final C1635c f4126w;

    /* JADX INFO: renamed from: x */
    public final Class[] f4127x;

    public C1214b(C1635c c1635c, Class[] clsArr) {
        super(c1635c);
        this.f4126w = c1635c;
        this.f4127x = clsArr;
    }

    @Override // p112k1.C1635c
    /* JADX INFO: renamed from: k */
    public final void mo3084k(AbstractC0728s abstractC0728s) {
        this.f4126w.mo3084k(abstractC0728s);
    }

    @Override // p112k1.C1635c
    /* JADX INFO: renamed from: l */
    public final void mo3085l(AbstractC0728s abstractC0728s) {
        this.f4126w.mo3085l(abstractC0728s);
    }

    @Override // p112k1.C1635c
    /* JADX INFO: renamed from: m */
    public final C1635c mo3086m(AbstractC1757v abstractC1757v) {
        return new C1214b(this.f4126w.mo3086m(abstractC1757v), this.f4127x);
    }

    @Override // p112k1.C1635c
    /* JADX INFO: renamed from: n */
    public final void mo3087n(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        boolean zM3089q = m3089q(abstractC0709K.f1967f);
        C1635c c1635c = this.f4126w;
        if (zM3089q) {
            c1635c.mo3087n(obj, abstractC0540h, abstractC0709K);
        } else {
            c1635c.m3717p(abstractC0540h, abstractC0709K);
        }
    }

    @Override // p112k1.C1635c
    /* JADX INFO: renamed from: o */
    public final void mo3088o(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        boolean zM3089q = m3089q(abstractC0709K.f1967f);
        C1635c c1635c = this.f4126w;
        if (zM3089q) {
            c1635c.mo3088o(obj, abstractC0540h, abstractC0709K);
        } else {
            c1635c.getClass();
            abstractC0540h.getClass();
        }
    }

    /* JADX INFO: renamed from: q */
    public final boolean m3089q(Class cls) {
        if (cls == null) {
            return true;
        }
        for (Class cls2 : this.f4127x) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }
}
