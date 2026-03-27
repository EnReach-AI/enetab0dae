package p103h1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import p039M0.EnumC0471T;
import p039M0.EnumC0472U;
import p069X0.AbstractC0721l;
import p069X0.C0707I;
import p069X0.EnumC0731v;
import p069X0.InterfaceC0714e;
import p074Z0.AbstractC0832r;
import p100g1.AbstractC1396e;
import p100g1.C1393b;
import p100g1.C1394c;

/* JADX INFO: renamed from: h1.n */
/* JADX INFO: loaded from: classes.dex */
public final class C1426n {

    /* JADX INFO: renamed from: a */
    public EnumC0472U f5052a;

    /* JADX INFO: renamed from: b */
    public EnumC0471T f5053b;

    /* JADX INFO: renamed from: c */
    public String f5054c;

    /* JADX INFO: renamed from: d */
    public boolean f5055d = false;

    /* JADX INFO: renamed from: e */
    public Class f5056e;

    /* JADX INFO: renamed from: f */
    public AbstractC1429q f5057f;

    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008d  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p103h1.AbstractC1428p m3436a(p069X0.C0717h r17, p069X0.AbstractC0721l r18, java.util.ArrayList r19) {
        /*
            Method dump skipped, instruction units count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p103h1.C1426n.m3436a(X0.h, X0.l, java.util.ArrayList):h1.p");
    }

    /* JADX INFO: renamed from: b */
    public final AbstractC1431s m3437b(C0707I c0707i, AbstractC0721l abstractC0721l, ArrayList arrayList) {
        InterfaceC0714e interfaceC0714e = null;
        if (this.f5052a == EnumC0472U.f1113f || abstractC0721l.f2036e.isPrimitive()) {
            return null;
        }
        if (this.f5052a == EnumC0472U.f1116i) {
            return C1415c.f5041d;
        }
        AbstractC1396e c1393b = c0707i.f2481f.f2425k;
        if (c1393b == C1423k.f5049e && c0707i.m2157l(EnumC0731v.BLOCK_UNSAFE_POLYMORPHIC_BASE_TYPES)) {
            c1393b = new C1393b();
        }
        AbstractC1429q abstractC1429qM3438c = m3438c(c0707i, abstractC0721l, c1393b, arrayList, true, false);
        int iOrdinal = this.f5053b.ordinal();
        if (iOrdinal == 0) {
            return new C1420h(abstractC1429qM3438c, null, this.f5054c);
        }
        if (iOrdinal == 1) {
            return new C1415c(abstractC1429qM3438c, interfaceC0714e, 2);
        }
        if (iOrdinal == 2) {
            return new C1415c(abstractC1429qM3438c, interfaceC0714e, 1);
        }
        if (iOrdinal == 3) {
            return new C1418f(abstractC1429qM3438c, null, this.f5054c);
        }
        if (iOrdinal == 4) {
            return new C1416d(abstractC1429qM3438c, null, this.f5054c);
        }
        throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.f5053b);
    }

    /* JADX INFO: renamed from: c */
    public final AbstractC1429q m3438c(AbstractC0832r abstractC0832r, AbstractC0721l abstractC0721l, AbstractC1396e abstractC1396e, ArrayList arrayList, boolean z3, boolean z4) {
        ConcurrentHashMap concurrentHashMap;
        String name;
        AbstractC1429q abstractC1429q = this.f5057f;
        if (abstractC1429q != null) {
            return abstractC1429q;
        }
        EnumC0472U enumC0472U = this.f5052a;
        if (enumC0472U == null) {
            throw new IllegalStateException("Cannot build, 'init()' not yet called");
        }
        int iOrdinal = enumC0472U.ordinal();
        HashMap map = null;
        if (iOrdinal == 0) {
            return null;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return new C1424l(abstractC0721l, abstractC0832r.f2481f.f2419e, abstractC1396e);
            }
            if (iOrdinal == 3) {
                if (z3 == z4) {
                    throw new IllegalArgumentException();
                }
                if (z3) {
                    concurrentHashMap = new ConcurrentHashMap();
                } else {
                    map = new HashMap();
                    concurrentHashMap = new ConcurrentHashMap(4);
                }
                boolean zM2157l = abstractC0832r.m2157l(EnumC0731v.ACCEPT_CASE_INSENSITIVE_VALUES);
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        C1394c c1394c = (C1394c) it.next();
                        Class cls = c1394c.f5024e;
                        if (c1394c.m3395a()) {
                            name = c1394c.f5026g;
                        } else {
                            name = cls.getName();
                            int iLastIndexOf = name.lastIndexOf(46);
                            if (iLastIndexOf >= 0) {
                                name = name.substring(iLastIndexOf + 1);
                            }
                        }
                        if (z3) {
                            concurrentHashMap.put(cls.getName(), name);
                        }
                        if (z4) {
                            if (zM2157l) {
                                name = name.toLowerCase();
                            }
                            AbstractC0721l abstractC0721l2 = (AbstractC0721l) map.get(name);
                            if (abstractC0721l2 == null || !cls.isAssignableFrom(abstractC0721l2.f2036e)) {
                                map.put(name, abstractC0832r.m2148c(cls));
                            }
                        }
                    }
                }
                return new C1430r(abstractC0832r, abstractC0721l, concurrentHashMap, map);
            }
            if (iOrdinal != 4) {
                throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + this.f5052a);
            }
        }
        return new C1422j(abstractC0721l, abstractC0832r.f2481f.f2419e, abstractC1396e);
    }
}
