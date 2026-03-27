package com.fasterxml.jackson.databind.ser.impl;

import p001A.C0009j;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0728s;
import p069X0.InterfaceC0714e;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.ser.impl.k */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1223k {

    /* JADX INFO: renamed from: a */
    public final boolean f4146a;

    public AbstractC1223k() {
        this.f4146a = false;
    }

    /* JADX INFO: renamed from: a */
    public final C0009j m3093a(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e, AbstractC0721l abstractC0721l) {
        AbstractC0728s abstractC0728sM1720r = abstractC0709K.m1720r(abstractC0721l, interfaceC0714e);
        return new C0009j(abstractC0728sM1720r, 22, mo3091b(abstractC0721l.f2036e, abstractC0728sM1720r));
    }

    /* JADX INFO: renamed from: b */
    public abstract AbstractC1223k mo3091b(Class cls, AbstractC0728s abstractC0728s);

    /* JADX INFO: renamed from: c */
    public abstract AbstractC0728s mo3092c(Class cls);

    public AbstractC1223k(AbstractC1223k abstractC1223k) {
        this.f4146a = abstractC1223k.f4146a;
    }
}
