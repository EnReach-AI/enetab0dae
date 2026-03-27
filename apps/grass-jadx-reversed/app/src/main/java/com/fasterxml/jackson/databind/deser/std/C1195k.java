package com.fasterxml.jackson.databind.deser.std;

import java.util.HashMap;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0718i;
import p069X0.C0717h;
import p069X0.EnumC0719j;
import p069X0.EnumC0731v;
import p074Z0.EnumC0830p;
import p078a1.C0851c;
import p082b1.C1043n;
import p118m1.AbstractC1745j;
import p118m1.C1749n;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.std.k */
/* JADX INFO: loaded from: classes.dex */
public final class C1195k extends C1199o {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: h */
    public final C1749n f4064h;

    /* JADX INFO: renamed from: i */
    public final C1043n f4065i;

    /* JADX INFO: renamed from: j */
    public volatile C1749n f4066j;

    /* JADX INFO: renamed from: k */
    public volatile C1749n f4067k;

    /* JADX INFO: renamed from: l */
    public final C1749n f4068l;

    /* JADX INFO: renamed from: m */
    public final Enum f4069m;

    public C1195k(C1749n c1749n, C1043n c1043n) {
        super(-1, c1749n.f6117e, null);
        this.f4064h = c1749n;
        this.f4065i = c1043n;
        this.f4069m = c1749n.f6120h;
        this.f4068l = null;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.C1199o
    /* JADX INFO: renamed from: b */
    public final Object mo3043b(AbstractC0718i abstractC0718i, String str) throws C0851c {
        C1043n c1043n = this.f4065i;
        if (c1043n != null) {
            try {
                return c1043n.mo2789q(str);
            } catch (Exception e3) {
                Throwable thM3894q = AbstractC1745j.m3894q(e3);
                String message = thM3894q.getMessage();
                AbstractC1745j.m3875E(thM3894q);
                AbstractC1745j.m3873C(thM3894q);
                throw new IllegalArgumentException(message, thM3894q);
            }
        }
        C1749n c1749n = this.f4068l;
        if (c1749n == null) {
            if (abstractC0718i.m1833K(EnumC0719j.READ_ENUMS_USING_TO_STRING)) {
                c1749n = this.f4066j;
                if (c1749n == null) {
                    synchronized (this) {
                        try {
                            c1749n = this.f4066j;
                            if (c1749n == null) {
                                c1749n = C1749n.m3906c(abstractC0718i.f1998g, this.f4064h.f6117e);
                                this.f4066j = c1749n;
                            }
                        } finally {
                        }
                    }
                }
            } else {
                c1749n = this.f4064h;
            }
        }
        Enum enumM3908d = c1749n.m3908d(str);
        if (enumM3908d == null) {
            if (abstractC0718i.f1998g.f2491n.m2143a(EnumC0830p.f2471f)) {
                c1749n = this.f4067k;
                if (c1749n == null) {
                    synchronized (this) {
                        try {
                            c1749n = this.f4067k;
                            if (c1749n == null) {
                                C0717h c0717h = abstractC0718i.f1998g;
                                Class cls = this.f4064h.f6117e;
                                AbstractC0711b abstractC0711bM2149d = c0717h.m2149d();
                                boolean zM2157l = c0717h.m2157l(EnumC0731v.ACCEPT_CASE_INSENSITIVE_ENUMS);
                                Enum[] enumArrM3905a = C1749n.m3905a(cls);
                                HashMap map = new HashMap();
                                int length = enumArrM3905a.length;
                                while (true) {
                                    length--;
                                    if (length < 0) {
                                        break;
                                    }
                                    map.put(String.valueOf(length), enumArrM3905a[length]);
                                }
                                c1749n = new C1749n(cls, enumArrM3905a, map, abstractC0711bM2149d != null ? abstractC0711bM2149d.mo1767g(cls) : null, zM2157l, false);
                                this.f4067k = c1749n;
                            }
                        } finally {
                        }
                    }
                }
                enumM3908d = c1749n.m3908d(str);
            }
        }
        if (enumM3908d != null) {
            return enumM3908d;
        }
        if (this.f4069m != null && abstractC0718i.m1833K(EnumC0719j.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)) {
            return this.f4069m;
        }
        if (abstractC0718i.m1833K(EnumC0719j.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
            return enumM3908d;
        }
        abstractC0718i.m1827E(this.f4075f, str, "not one of the values accepted for Enum class: %s", c1749n.f6119g.keySet());
        throw null;
    }
}
