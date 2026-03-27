package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import com.fasterxml.jackson.databind.deser.C1140g;
import com.fasterxml.jackson.databind.deser.C1207w;
import p042N0.C0541i;
import p050Q0.C0590c;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.C0702D;
import p069X0.C0703E;
import p069X0.C0717h;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.std.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1189e extends C1207w {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: F */
    public static C1140g m3038F(String str, AbstractC0721l abstractC0721l, int i3) {
        return new C1140g(C0703E.m1686a(str), abstractC0721l, null, null, null, i3, null, C0702D.f1916l);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: D */
    public final AbstractC1204t[] mo3039D(C0717h c0717h) {
        AbstractC0721l abstractC0721lM2148c = c0717h.m2148c(Integer.TYPE);
        AbstractC0721l abstractC0721lM2148c2 = c0717h.m2148c(Long.TYPE);
        return new AbstractC1204t[]{m3038F("sourceRef", c0717h.m2148c(Object.class), 0), m3038F("byteOffset", abstractC0721lM2148c2, 1), m3038F("charOffset", abstractC0721lM2148c2, 2), m3038F("lineNr", abstractC0721lM2148c, 3), m3038F("columnNr", abstractC0721lM2148c, 4)};
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: s */
    public final Object mo3040s(AbstractC0718i abstractC0718i, Object[] objArr) {
        Object obj = objArr[0];
        C0590c c0590c = obj instanceof C0590c ? (C0590c) obj : new C0590c(obj, false);
        Object obj2 = objArr[1];
        long jLongValue = obj2 == null ? 0L : ((Number) obj2).longValue();
        Object obj3 = objArr[2];
        long jLongValue2 = obj3 == null ? 0L : ((Number) obj3).longValue();
        Object obj4 = objArr[3];
        int iIntValue = obj4 == null ? 0 : ((Number) obj4).intValue();
        Object obj5 = objArr[4];
        return new C0541i(c0590c, jLongValue, jLongValue2, iIntValue, obj5 != null ? ((Number) obj5).intValue() : 0);
    }
}
