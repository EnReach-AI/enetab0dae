package com.fasterxml.jackson.databind.deser.std;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import p069X0.C0717h;
import p069X0.EnumC0731v;
import p082b1.AbstractC1048s;
import p082b1.C1036g;
import p082b1.C1043n;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.std.q */
/* JADX INFO: loaded from: classes.dex */
public final class C1201q implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a */
    public static C1199o m3045a(C0717h c0717h, AbstractC1048s abstractC1048s) {
        if (abstractC1048s instanceof C1036g) {
            Constructor constructor = ((C1036g) abstractC1048s).f3687h;
            c0717h.getClass();
            if (c0717h.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                AbstractC1745j.m3882e(constructor, c0717h.m2157l(EnumC0731v.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            return new C1196l(constructor);
        }
        Method method = ((C1043n) abstractC1048s).f3704h;
        c0717h.getClass();
        if (c0717h.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            AbstractC1745j.m3882e(method, c0717h.m2157l(EnumC0731v.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return new C1197m(method);
    }
}
