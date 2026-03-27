package com.fasterxml.jackson.databind.ser.impl;

import p039M0.AbstractC0485d0;
import p042N0.InterfaceC0551s;
import p050Q0.C0597j;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0728s;
import p069X0.C0703E;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.ser.impl.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1216d {

    /* JADX INFO: renamed from: a */
    public final AbstractC0721l f4130a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC0551s f4131b;

    /* JADX INFO: renamed from: c */
    public final AbstractC0485d0 f4132c;

    /* JADX INFO: renamed from: d */
    public final AbstractC0728s f4133d;

    /* JADX INFO: renamed from: e */
    public final boolean f4134e;

    public C1216d(AbstractC0721l abstractC0721l, C0597j c0597j, AbstractC0485d0 abstractC0485d0, AbstractC0728s abstractC0728s, boolean z3) {
        this.f4130a = abstractC0721l;
        this.f4131b = c0597j;
        this.f4132c = abstractC0485d0;
        this.f4133d = abstractC0728s;
        this.f4134e = z3;
    }

    /* JADX INFO: renamed from: a */
    public static C1216d m3090a(AbstractC0721l abstractC0721l, C0703E c0703e, AbstractC0485d0 abstractC0485d0, boolean z3) {
        String str = c0703e == null ? null : c0703e.f1928e;
        return new C1216d(abstractC0721l, str != null ? new C0597j(str) : null, abstractC0485d0, null, z3);
    }
}
