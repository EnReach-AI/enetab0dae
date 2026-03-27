package com.fasterxml.jackson.databind.deser.impl;

import androidx.fragment.app.AbstractC0935f;
import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import java.util.BitSet;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0716g;
import p069X0.AbstractC0718i;
import p069X0.C0703E;
import p069X0.EnumC0719j;
import p082b1.AbstractC1041l;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.A */
/* JADX INFO: loaded from: classes.dex */
public final class C1143A {

    /* JADX INFO: renamed from: a */
    public final AbstractC0545m f3953a;

    /* JADX INFO: renamed from: b */
    public final AbstractC0718i f3954b;

    /* JADX INFO: renamed from: c */
    public final C1167s f3955c;

    /* JADX INFO: renamed from: d */
    public final Object[] f3956d;

    /* JADX INFO: renamed from: e */
    public int f3957e;

    /* JADX INFO: renamed from: f */
    public int f3958f;

    /* JADX INFO: renamed from: g */
    public final BitSet f3959g;

    /* JADX INFO: renamed from: h */
    public AbstractC0935f f3960h;

    /* JADX INFO: renamed from: i */
    public Object f3961i;

    public C1143A(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, int i3, C1167s c1167s) {
        this.f3953a = abstractC0545m;
        this.f3954b = abstractC0718i;
        this.f3957e = i3;
        this.f3955c = c1167s;
        this.f3956d = new Object[i3];
        if (i3 < 32) {
            this.f3959g = null;
        } else {
            this.f3959g = new BitSet();
        }
    }

    /* JADX INFO: renamed from: a */
    public final Object m2976a(AbstractC1204t abstractC1204t) throws AbstractC0716g {
        Object objMo2971p = abstractC1204t.mo2971p();
        AbstractC0718i abstractC0718i = this.f3954b;
        if (objMo2971p != null) {
            abstractC0718i.m1853r(abstractC1204t.mo2971p());
            throw null;
        }
        boolean zM2728g = abstractC1204t.m2728g();
        C0703E c0703e = abstractC1204t.f4102g;
        if (zM2728g) {
            abstractC0718i.m1840R(abstractC1204t, "Missing required creator property '%s' (index %d)", c0703e.f1928e, Integer.valueOf(abstractC1204t.mo2970o()));
            throw null;
        }
        if (abstractC0718i.m1833K(EnumC0719j.FAIL_ON_MISSING_CREATOR_PROPERTIES)) {
            abstractC0718i.m1840R(abstractC1204t, "Missing creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES` enabled", c0703e.f1928e, Integer.valueOf(abstractC1204t.mo2970o()));
            throw null;
        }
        try {
            Object absentValue = abstractC1204t.f4106k.getAbsentValue(abstractC0718i);
            return absentValue != null ? absentValue : abstractC1204t.mo3032t().getAbsentValue(abstractC0718i);
        } catch (AbstractC0716g e3) {
            AbstractC1041l abstractC1041lMo1805c = abstractC1204t.mo1805c();
            if (abstractC1041lMo1805c != null) {
                e3.mo1816d(c0703e.f1928e, abstractC1041lMo1805c.mo2770i());
            }
            throw e3;
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m2977b(AbstractC1204t abstractC1204t, Object obj) {
        int iMo2970o = abstractC1204t.mo2970o();
        this.f3956d[iMo2970o] = obj;
        BitSet bitSet = this.f3959g;
        if (bitSet == null) {
            int i3 = this.f3958f;
            int i4 = (1 << iMo2970o) | i3;
            if (i3 != i4) {
                this.f3958f = i4;
                int i5 = this.f3957e - 1;
                this.f3957e = i5;
                if (i5 <= 0) {
                    return this.f3955c == null || this.f3961i != null;
                }
            }
        } else if (!bitSet.get(iMo2970o)) {
            bitSet.set(iMo2970o);
            this.f3957e--;
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    public final void m2978c(AbstractC1204t abstractC1204t, Object obj) {
        this.f3960h = new C1174z(this.f3960h, obj, abstractC1204t, 1);
    }

    /* JADX INFO: renamed from: d */
    public final boolean m2979d(String str) {
        C1167s c1167s = this.f3955c;
        if (c1167s == null || !str.equals(c1167s.f4024f.f1928e)) {
            return false;
        }
        this.f3961i = c1167s.f4026h.deserialize(this.f3953a, this.f3954b);
        return true;
    }
}
