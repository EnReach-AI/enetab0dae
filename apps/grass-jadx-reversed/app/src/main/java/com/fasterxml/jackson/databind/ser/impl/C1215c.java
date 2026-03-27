package com.fasterxml.jackson.databind.ser.impl;

import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0728s;
import p112k1.C1635c;
import p118m1.AbstractC1757v;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.ser.impl.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1215c extends C1635c {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: w */
    public final C1635c f4128w;

    /* JADX INFO: renamed from: x */
    public final Class f4129x;

    public C1215c(Class cls, C1635c c1635c) {
        super(c1635c);
        this.f4128w = c1635c;
        this.f4129x = cls;
    }

    @Override // p112k1.C1635c
    /* JADX INFO: renamed from: k */
    public final void mo3084k(AbstractC0728s abstractC0728s) {
        this.f4128w.mo3084k(abstractC0728s);
    }

    @Override // p112k1.C1635c
    /* JADX INFO: renamed from: l */
    public final void mo3085l(AbstractC0728s abstractC0728s) {
        this.f4128w.mo3085l(abstractC0728s);
    }

    @Override // p112k1.C1635c
    /* JADX INFO: renamed from: m */
    public final C1635c mo3086m(AbstractC1757v abstractC1757v) {
        return new C1215c(this.f4129x, this.f4128w.mo3086m(abstractC1757v));
    }

    @Override // p112k1.C1635c
    /* JADX INFO: renamed from: n */
    public final void mo3087n(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        Class<?> cls = abstractC0709K.f1967f;
        C1635c c1635c = this.f4128w;
        if (cls == null || this.f4129x.isAssignableFrom(cls)) {
            c1635c.mo3087n(obj, abstractC0540h, abstractC0709K);
        } else {
            c1635c.m3717p(abstractC0540h, abstractC0709K);
        }
    }

    @Override // p112k1.C1635c
    /* JADX INFO: renamed from: o */
    public final void mo3088o(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        Class<?> cls = abstractC0709K.f1967f;
        C1635c c1635c = this.f4128w;
        if (cls == null || this.f4129x.isAssignableFrom(cls)) {
            c1635c.mo3088o(obj, abstractC0540h, abstractC0709K);
        } else {
            c1635c.getClass();
            abstractC0540h.getClass();
        }
    }
}
