package com.fasterxml.jackson.databind.ser.impl;

import p069X0.AbstractC0728s;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.ser.impl.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1221i extends AbstractC1223k {

    /* JADX INFO: renamed from: b */
    public final Class f4142b;

    /* JADX INFO: renamed from: c */
    public final AbstractC0728s f4143c;

    public C1221i(AbstractC1223k abstractC1223k, Class cls, AbstractC0728s abstractC0728s) {
        super(abstractC1223k);
        this.f4142b = cls;
        this.f4143c = abstractC0728s;
    }

    @Override // com.fasterxml.jackson.databind.ser.impl.AbstractC1223k
    /* JADX INFO: renamed from: b */
    public final AbstractC1223k mo3091b(Class cls, AbstractC0728s abstractC0728s) {
        return new C1218f(this, this.f4142b, this.f4143c, cls, abstractC0728s);
    }

    @Override // com.fasterxml.jackson.databind.ser.impl.AbstractC1223k
    /* JADX INFO: renamed from: c */
    public final AbstractC0728s mo3092c(Class cls) {
        if (cls == this.f4142b) {
            return this.f4143c;
        }
        return null;
    }
}
