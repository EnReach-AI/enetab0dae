package com.fasterxml.jackson.databind.deser.impl;

import androidx.fragment.app.AbstractC0935f;
import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import com.fasterxml.jackson.databind.deser.AbstractC1208x;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0718i;
import p069X0.C0703E;
import p069X0.C0717h;
import p069X0.EnumC0719j;
import p078a1.C0850b;
import p082b1.AbstractC1041l;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.w */
/* JADX INFO: loaded from: classes.dex */
public final class C1171w {

    /* JADX INFO: renamed from: a */
    public final int f4031a;

    /* JADX INFO: renamed from: b */
    public final AbstractC1208x f4032b;

    /* JADX INFO: renamed from: c */
    public final HashMap f4033c;

    /* JADX INFO: renamed from: d */
    public final AbstractC1204t[] f4034d;

    public C1171w(AbstractC0718i abstractC0718i, AbstractC1208x abstractC1208x, AbstractC1204t[] abstractC1204tArr, boolean z3, boolean z4) {
        AbstractC1041l abstractC1041lMo1805c;
        this.f4032b = abstractC1208x;
        if (z3) {
            this.f4033c = new C1170v(abstractC0718i.f1998g.f2481f.f2427m);
        } else {
            this.f4033c = new HashMap();
        }
        int length = abstractC1204tArr.length;
        this.f4031a = length;
        this.f4034d = new AbstractC1204t[length];
        if (z4) {
            C0717h c0717h = abstractC0718i.f1998g;
            for (AbstractC1204t abstractC1204t : abstractC1204tArr) {
                if (!abstractC1204t.mo2972y()) {
                    List listEmptyList = abstractC1204t.f3594f;
                    if (listEmptyList == null) {
                        AbstractC0711b abstractC0711bM2149d = c0717h.m2149d();
                        if (abstractC0711bM2149d != null && (abstractC1041lMo1805c = abstractC1204t.mo1805c()) != null) {
                            listEmptyList = abstractC0711bM2149d.mo1733E(abstractC1041lMo1805c);
                        }
                        listEmptyList = listEmptyList == null ? Collections.emptyList() : listEmptyList;
                        abstractC1204t.f3594f = listEmptyList;
                    }
                    if (!listEmptyList.isEmpty()) {
                        Iterator it = listEmptyList.iterator();
                        while (it.hasNext()) {
                            this.f4033c.put(((C0703E) it.next()).f1928e, abstractC1204t);
                        }
                    }
                }
            }
        }
        for (int i3 = 0; i3 < length; i3++) {
            AbstractC1204t abstractC1204t2 = abstractC1204tArr[i3];
            this.f4034d[i3] = abstractC1204t2;
            if (!abstractC1204t2.mo2972y()) {
                this.f4033c.put(abstractC1204t2.f4102g.f1928e, abstractC1204t2);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static C1171w m3011b(AbstractC0718i abstractC0718i, AbstractC1208x abstractC1208x, AbstractC1204t[] abstractC1204tArr, boolean z3) {
        int length = abstractC1204tArr.length;
        AbstractC1204t[] abstractC1204tArr2 = new AbstractC1204t[length];
        for (int i3 = 0; i3 < length; i3++) {
            AbstractC1204t abstractC1204tMo2965H = abstractC1204tArr[i3];
            if (!abstractC1204tMo2965H.mo3034v()) {
                abstractC1204tMo2965H = abstractC1204tMo2965H.mo2965H(abstractC0718i.m1852q(abstractC1204tMo2965H.f4103h, abstractC1204tMo2965H));
            }
            abstractC1204tArr2[i3] = abstractC1204tMo2965H;
        }
        return new C1171w(abstractC0718i, abstractC1208x, abstractC1204tArr2, z3, false);
    }

    /* JADX INFO: renamed from: a */
    public final Object m3012a(AbstractC0718i abstractC0718i, C1143A c1143a) throws C0850b {
        AbstractC1208x abstractC1208x = this.f4032b;
        abstractC1208x.getClass();
        int i3 = c1143a.f3957e;
        AbstractC1204t[] abstractC1204tArr = this.f4034d;
        Object[] objArr = c1143a.f3956d;
        if (i3 > 0) {
            BitSet bitSet = c1143a.f3959g;
            if (bitSet != null) {
                int length = objArr.length;
                int i4 = 0;
                while (true) {
                    int iNextClearBit = bitSet.nextClearBit(i4);
                    if (iNextClearBit >= length) {
                        break;
                    }
                    objArr[iNextClearBit] = c1143a.m2976a(abstractC1204tArr[iNextClearBit]);
                    i4 = iNextClearBit + 1;
                }
            } else {
                int i5 = c1143a.f3958f;
                int length2 = objArr.length;
                int i6 = 0;
                while (i6 < length2) {
                    if ((i5 & 1) == 0) {
                        objArr[i6] = c1143a.m2976a(abstractC1204tArr[i6]);
                    }
                    i6++;
                    i5 >>= 1;
                }
            }
        }
        EnumC0719j enumC0719j = EnumC0719j.FAIL_ON_NULL_CREATOR_PROPERTIES;
        AbstractC0718i abstractC0718i2 = c1143a.f3954b;
        if (abstractC0718i2.m1833K(enumC0719j)) {
            for (int i7 = 0; i7 < abstractC1204tArr.length; i7++) {
                if (objArr[i7] == null) {
                    AbstractC1204t abstractC1204t = abstractC1204tArr[i7];
                    abstractC0718i2.m1840R(abstractC1204t, "Null value for creator property '%s' (index %d); `DeserializationFeature.FAIL_ON_NULL_CREATOR_PROPERTIES` enabled", abstractC1204t.f4102g.f1928e, Integer.valueOf(abstractC1204t.mo2970o()));
                    throw null;
                }
            }
        }
        Object objMo3040s = abstractC1208x.mo3040s(abstractC0718i, objArr);
        if (objMo3040s != null) {
            C1167s c1167s = c1143a.f3955c;
            if (c1167s != null) {
                Object obj = c1143a.f3961i;
                if (obj != null) {
                    abstractC0718i.mo1855t(obj, c1167s.f4025g).getClass();
                    throw null;
                }
                abstractC0718i.getClass();
                abstractC0718i.m1840R(c1167s.f4027i, "No Object Id found for an instance of " + AbstractC1745j.m3883f(objMo3040s) + ", to assign to property '" + c1167s.f4024f + "'", new Object[0]);
                throw null;
            }
            for (AbstractC0935f abstractC0935f = c1143a.f3960h; abstractC0935f != null; abstractC0935f = (AbstractC0935f) abstractC0935f.f3160a) {
                abstractC0935f.mo2448c(objMo3040s);
            }
        }
        return objMo3040s;
    }

    /* JADX INFO: renamed from: c */
    public final AbstractC1204t m3013c(String str) {
        return (AbstractC1204t) this.f4033c.get(str);
    }

    /* JADX INFO: renamed from: d */
    public final C1143A m3014d(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, C1167s c1167s) {
        return new C1143A(abstractC0545m, abstractC0718i, this.f4031a, c1167s);
    }
}
