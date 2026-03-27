package com.fasterxml.jackson.databind.deser.impl;

import p039M0.C0480b;
import p069X0.AbstractC0711b;
import p069X0.C0703E;
import p082b1.AbstractC1007C;
import p082b1.AbstractC1048s;
import p082b1.C1047r;
import p166z0.C2071i;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1150b {

    /* JADX INFO: renamed from: a */
    public final AbstractC0711b f3977a;

    /* JADX INFO: renamed from: b */
    public final AbstractC1048s f3978b;

    /* JADX INFO: renamed from: c */
    public final int f3979c;

    /* JADX INFO: renamed from: d */
    public final C2071i[] f3980d;

    public C1150b(AbstractC0711b abstractC0711b, AbstractC1048s abstractC1048s, C2071i[] c2071iArr, int i3) {
        this.f3977a = abstractC0711b;
        this.f3978b = abstractC1048s;
        this.f3980d = c2071iArr;
        this.f3979c = i3;
    }

    /* JADX INFO: renamed from: a */
    public static C1150b m2990a(AbstractC0711b abstractC0711b, AbstractC1048s abstractC1048s, AbstractC1007C[] abstractC1007CArr) {
        int iMo2790s = abstractC1048s.mo2790s();
        C2071i[] c2071iArr = new C2071i[iMo2790s];
        for (int i3 = 0; i3 < iMo2790s; i3++) {
            C1047r c1047rM2805r = abstractC1048s.m2805r(i3);
            C0480b c0480bMo1787q = abstractC0711b.mo1787q(c1047rM2805r);
            AbstractC1007C abstractC1007C = abstractC1007CArr == null ? null : abstractC1007CArr[i3];
            C2071i c2071i = new C2071i();
            c2071i.f7314a = c1047rM2805r;
            c2071i.f7315b = abstractC1007C;
            c2071i.f7316c = c0480bMo1787q;
            c2071iArr[i3] = c2071i;
        }
        return new C1150b(abstractC0711b, abstractC1048s, c2071iArr, iMo2790s);
    }

    /* JADX INFO: renamed from: b */
    public final C0703E m2991b(int i3) {
        this.f3977a.mo1785p((C1047r) this.f3980d[i3].f7314a);
        return null;
    }

    /* JADX INFO: renamed from: c */
    public final C0703E m2992c(int i3) {
        AbstractC1007C abstractC1007C = (AbstractC1007C) this.f3980d[i3].f7315b;
        if (abstractC1007C != null) {
            return abstractC1007C.mo2706a();
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public final AbstractC1007C m2993d(int i3) {
        return (AbstractC1007C) this.f3980d[i3].f7315b;
    }

    public final String toString() {
        return this.f3978b.toString();
    }
}
