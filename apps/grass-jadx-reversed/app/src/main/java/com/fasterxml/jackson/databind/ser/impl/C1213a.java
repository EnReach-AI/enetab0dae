package com.fasterxml.jackson.databind.ser.impl;

import p039M0.C0453A;
import p039M0.EnumC0511z;
import p069X0.AbstractC0721l;
import p112k1.AbstractC1645m;
import p118m1.C1726A;
import p118m1.InterfaceC1737b;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.ser.impl.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1213a extends AbstractC1645m {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: w */
    public final String f4125w;

    /* JADX WARN: Illegal instructions before constructor call */
    public C1213a(String str, C1726A c1726a, InterfaceC1737b interfaceC1737b, AbstractC0721l abstractC0721l) {
        EnumC0511z enumC0511z;
        Object obj;
        EnumC0511z enumC0511z2 = EnumC0511z.f1186i;
        EnumC0511z enumC0511z3 = EnumC0511z.f1182e;
        C0453A c0453a = c1726a.f6025j;
        boolean z3 = false;
        if (c0453a != null && (enumC0511z = c0453a.f1096e) != enumC0511z3 && enumC0511z != enumC0511z2) {
            z3 = true;
        }
        boolean z4 = z3;
        if (c0453a == null) {
            obj = Boolean.FALSE;
        } else {
            EnumC0511z enumC0511z4 = c0453a.f1096e;
            obj = (enumC0511z4 == enumC0511z3 || enumC0511z4 == EnumC0511z.f1183f || enumC0511z4 == enumC0511z2) ? null : EnumC0511z.f1184g;
        }
        super(c1726a, c1726a.f6022g, interfaceC1737b, abstractC0721l, null, null, null, z4, obj, null);
        this.f4125w = str;
    }
}
