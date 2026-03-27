package com.fasterxml.jackson.databind.ser.impl;

import p069X0.AbstractC0728s;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.ser.impl.f */
/* JADX INFO: loaded from: classes.dex */
public final class C1218f extends AbstractC1223k {

    /* JADX INFO: renamed from: b */
    public final Class f4136b;

    /* JADX INFO: renamed from: c */
    public final Class f4137c;

    /* JADX INFO: renamed from: d */
    public final AbstractC0728s f4138d;

    /* JADX INFO: renamed from: e */
    public final AbstractC0728s f4139e;

    public C1218f(AbstractC1223k abstractC1223k, Class cls, AbstractC0728s abstractC0728s, Class cls2, AbstractC0728s abstractC0728s2) {
        super(abstractC1223k);
        this.f4136b = cls;
        this.f4138d = abstractC0728s;
        this.f4137c = cls2;
        this.f4139e = abstractC0728s2;
    }

    @Override // com.fasterxml.jackson.databind.ser.impl.AbstractC1223k
    /* JADX INFO: renamed from: b */
    public final AbstractC1223k mo3091b(Class cls, AbstractC0728s abstractC0728s) {
        return new C1220h(this, new C1222j[]{new C1222j(this.f4136b, this.f4138d), new C1222j(this.f4137c, this.f4139e), new C1222j(cls, abstractC0728s)});
    }

    @Override // com.fasterxml.jackson.databind.ser.impl.AbstractC1223k
    /* JADX INFO: renamed from: c */
    public final AbstractC0728s mo3092c(Class cls) {
        if (cls == this.f4136b) {
            return this.f4138d;
        }
        if (cls == this.f4137c) {
            return this.f4139e;
        }
        return null;
    }
}
