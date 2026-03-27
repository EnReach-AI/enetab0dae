package p103h1;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0721l;
import p074Z0.AbstractC0832r;
import p082b1.AbstractC1041l;
import p082b1.C1033d;
import p082b1.C1034e;
import p100g1.AbstractC1397f;
import p100g1.C1394c;

/* JADX INFO: renamed from: h1.m */
/* JADX INFO: loaded from: classes.dex */
public final class C1425m extends AbstractC1397f implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: d */
    public static void m3433d(C1033d c1033d, C1394c c1394c, AbstractC0832r abstractC0832r, AbstractC0711b abstractC0711b, HashMap map) {
        String strMo1753Y;
        if (!c1394c.m3395a() && (strMo1753Y = abstractC0711b.mo1753Y(c1033d)) != null) {
            c1394c = new C1394c(c1394c.f5024e, strMo1753Y);
        }
        C1394c c1394c2 = new C1394c(c1394c.f5024e, null);
        if (map.containsKey(c1394c2)) {
            if (!c1394c.m3395a() || ((C1394c) map.get(c1394c2)).m3395a()) {
                return;
            }
            map.put(c1394c2, c1394c);
            return;
        }
        map.put(c1394c2, c1394c);
        List listMo1752X = abstractC0711b.mo1752X(c1033d);
        if (listMo1752X != null) {
            ArrayList<C1394c> arrayList = (ArrayList) listMo1752X;
            if (arrayList.isEmpty()) {
                return;
            }
            for (C1394c c1394c3 : arrayList) {
                m3433d(C1034e.m2781h(abstractC0832r, c1394c3.f5024e), c1394c3, abstractC0832r, abstractC0711b, map);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m3434e(C1033d c1033d, C1394c c1394c, AbstractC0832r abstractC0832r, HashSet hashSet, LinkedHashMap linkedHashMap) {
        List listMo1752X;
        String strMo1753Y;
        AbstractC0711b abstractC0711bM2149d = abstractC0832r.m2149d();
        if (!c1394c.m3395a() && (strMo1753Y = abstractC0711bM2149d.mo1753Y(c1033d)) != null) {
            c1394c = new C1394c(c1394c.f5024e, strMo1753Y);
        }
        if (c1394c.m3395a()) {
            linkedHashMap.put(c1394c.f5026g, c1394c);
        }
        if (!hashSet.add(c1394c.f5024e) || (listMo1752X = abstractC0711bM2149d.mo1752X(c1033d)) == null) {
            return;
        }
        ArrayList<C1394c> arrayList = (ArrayList) listMo1752X;
        if (arrayList.isEmpty()) {
            return;
        }
        for (C1394c c1394c2 : arrayList) {
            m3434e(C1034e.m2781h(abstractC0832r, c1394c2.f5024e), c1394c2, abstractC0832r, hashSet, linkedHashMap);
        }
    }

    /* JADX INFO: renamed from: f */
    public static ArrayList m3435f(Class cls, HashSet hashSet, LinkedHashMap linkedHashMap) {
        ArrayList arrayList = new ArrayList(linkedHashMap.values());
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            hashSet.remove(((C1394c) it.next()).f5024e);
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            Class cls2 = (Class) it2.next();
            if (cls2 != cls || !Modifier.isAbstract(cls2.getModifiers())) {
                arrayList.add(new C1394c(cls2, null));
            }
        }
        return arrayList;
    }

    @Override // p100g1.AbstractC1397f
    /* JADX INFO: renamed from: a */
    public final ArrayList mo3396a(AbstractC0832r abstractC0832r, AbstractC1041l abstractC1041l, AbstractC0721l abstractC0721l) {
        Class clsMo2768e;
        List listMo1752X;
        AbstractC0711b abstractC0711bM2149d = abstractC0832r.m2149d();
        if (abstractC0721l != null) {
            clsMo2768e = abstractC0721l.f2036e;
        } else {
            if (abstractC1041l == null) {
                throw new IllegalArgumentException("Both property and base type are nulls");
            }
            clsMo2768e = abstractC1041l.mo2768e();
        }
        HashMap map = new HashMap();
        if (abstractC1041l != null && (listMo1752X = abstractC0711bM2149d.mo1752X(abstractC1041l)) != null) {
            for (C1394c c1394c : (ArrayList) listMo1752X) {
                m3433d(C1034e.m2781h(abstractC0832r, c1394c.f5024e), c1394c, abstractC0832r, abstractC0711bM2149d, map);
            }
        }
        m3433d(C1034e.m2781h(abstractC0832r, clsMo2768e), new C1394c(clsMo2768e, null), abstractC0832r, abstractC0711bM2149d, map);
        return new ArrayList(map.values());
    }

    @Override // p100g1.AbstractC1397f
    /* JADX INFO: renamed from: b */
    public final ArrayList mo3397b(AbstractC0832r abstractC0832r, C1033d c1033d) {
        Class cls = c1033d.f3666f;
        HashSet hashSet = new HashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        m3434e(c1033d, new C1394c(cls, null), abstractC0832r, hashSet, linkedHashMap);
        return m3435f(cls, hashSet, linkedHashMap);
    }

    @Override // p100g1.AbstractC1397f
    /* JADX INFO: renamed from: c */
    public final ArrayList mo3398c(AbstractC0832r abstractC0832r, AbstractC1041l abstractC1041l, AbstractC0721l abstractC0721l) {
        List listMo1752X;
        AbstractC0711b abstractC0711bM2149d = abstractC0832r.m2149d();
        Class cls = abstractC0721l.f2036e;
        HashSet hashSet = new HashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        m3434e(C1034e.m2781h(abstractC0832r, cls), new C1394c(cls, null), abstractC0832r, hashSet, linkedHashMap);
        if (abstractC1041l != null && (listMo1752X = abstractC0711bM2149d.mo1752X(abstractC1041l)) != null) {
            for (C1394c c1394c : (ArrayList) listMo1752X) {
                m3434e(C1034e.m2781h(abstractC0832r, c1394c.f5024e), c1394c, abstractC0832r, hashSet, linkedHashMap);
            }
        }
        return m3435f(cls, hashSet, linkedHashMap);
    }
}
