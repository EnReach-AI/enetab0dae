package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import p005B.AbstractC0032g;
import p069X0.C0703E;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1149a implements Iterable, Serializable {
    private static final long serialVersionUID = 2;

    /* JADX INFO: renamed from: e */
    public final boolean f3968e;

    /* JADX INFO: renamed from: f */
    public int f3969f;

    /* JADX INFO: renamed from: g */
    public int f3970g;

    /* JADX INFO: renamed from: h */
    public int f3971h;

    /* JADX INFO: renamed from: i */
    public Object[] f3972i;

    /* JADX INFO: renamed from: j */
    public final AbstractC1204t[] f3973j;

    /* JADX INFO: renamed from: k */
    public final Map f3974k;

    /* JADX INFO: renamed from: l */
    public final Map f3975l;

    /* JADX INFO: renamed from: m */
    public final Locale f3976m;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.HashMap] */
    public C1149a(boolean z3, Collection collection, Map map, Locale locale) {
        ?? EmptyMap;
        this.f3968e = z3;
        this.f3973j = (AbstractC1204t[]) collection.toArray(new AbstractC1204t[collection.size()]);
        this.f3974k = map;
        this.f3976m = locale;
        if (map == null || map.isEmpty()) {
            EmptyMap = Collections.emptyMap();
        } else {
            EmptyMap = new HashMap();
            for (Map.Entry entry : map.entrySet()) {
                String lowerCase = (String) entry.getKey();
                lowerCase = z3 ? lowerCase.toLowerCase(locale) : lowerCase;
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    String lowerCase2 = ((C0703E) it.next()).f1928e;
                    if (z3) {
                        lowerCase2 = lowerCase2.toLowerCase(locale);
                    }
                    EmptyMap.put(lowerCase2, lowerCase);
                }
            }
        }
        this.f3975l = EmptyMap;
        m2986f(collection);
    }

    /* JADX INFO: renamed from: a */
    public final int m2981a(AbstractC1204t abstractC1204t) {
        AbstractC1204t[] abstractC1204tArr = this.f3973j;
        int length = abstractC1204tArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (abstractC1204tArr[i3] == abstractC1204t) {
                return i3;
            }
        }
        throw new IllegalStateException(AbstractC0032g.m157o(new StringBuilder("Illegal state: property '"), abstractC1204t.f4102g.f1928e, "' missing from _propsInOrder"));
    }

    /* JADX INFO: renamed from: b */
    public final AbstractC1204t m2982b(String str) {
        if (str == null) {
            return null;
        }
        int iHashCode = str.hashCode() & this.f3969f;
        int i3 = iHashCode << 1;
        Object obj = this.f3972i[i3];
        if (str.equals(obj)) {
            return (AbstractC1204t) this.f3972i[i3 + 1];
        }
        if (obj == null) {
            return null;
        }
        int i4 = this.f3969f + 1;
        int i5 = ((iHashCode >> 1) + i4) << 1;
        Object obj2 = this.f3972i[i5];
        if (str.equals(obj2)) {
            return (AbstractC1204t) this.f3972i[i5 + 1];
        }
        if (obj2 == null) {
            return null;
        }
        int i6 = (i4 + (i4 >> 1)) << 1;
        int i7 = this.f3971h + i6;
        while (i6 < i7) {
            Object obj3 = this.f3972i[i6];
            if (obj3 == str || str.equals(obj3)) {
                return (AbstractC1204t) this.f3972i[i6 + 1];
            }
            i6 += 2;
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public final void m2983c() {
        int length = this.f3972i.length;
        int i3 = 0;
        for (int i4 = 1; i4 < length; i4 += 2) {
            AbstractC1204t abstractC1204t = (AbstractC1204t) this.f3972i[i4];
            if (abstractC1204t != null) {
                abstractC1204t.mo3028i(i3);
                i3++;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final AbstractC1204t m2984d(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Cannot pass null property name");
        }
        if (this.f3968e) {
            str = str.toLowerCase(this.f3976m);
        }
        int iHashCode = str.hashCode() & this.f3969f;
        int i3 = iHashCode << 1;
        Object obj = this.f3972i[i3];
        if (obj == str || str.equals(obj)) {
            return (AbstractC1204t) this.f3972i[i3 + 1];
        }
        Map map = this.f3975l;
        if (obj == null) {
            return m2982b((String) map.get(str));
        }
        int i4 = this.f3969f + 1;
        int i5 = ((iHashCode >> 1) + i4) << 1;
        Object obj2 = this.f3972i[i5];
        if (str.equals(obj2)) {
            return (AbstractC1204t) this.f3972i[i5 + 1];
        }
        if (obj2 != null) {
            int i6 = (i4 + (i4 >> 1)) << 1;
            int i7 = this.f3971h + i6;
            while (i6 < i7) {
                Object obj3 = this.f3972i[i6];
                if (obj3 == str || str.equals(obj3)) {
                    return (AbstractC1204t) this.f3972i[i6 + 1];
                }
                i6 += 2;
            }
        }
        return m2982b((String) map.get(str));
    }

    /* JADX INFO: renamed from: e */
    public final String m2985e(AbstractC1204t abstractC1204t) {
        return this.f3968e ? abstractC1204t.f4102g.f1928e.toLowerCase(this.f3976m) : abstractC1204t.f4102g.f1928e;
    }

    /* JADX INFO: renamed from: f */
    public final void m2986f(Collection collection) {
        int i3;
        int size = collection.size();
        this.f3970g = size;
        if (size <= 5) {
            i3 = 8;
        } else if (size <= 12) {
            i3 = 16;
        } else {
            int i4 = 32;
            while (i4 < size + (size >> 2)) {
                i4 += i4;
            }
            i3 = i4;
        }
        this.f3969f = i3 - 1;
        int i5 = (i3 >> 1) + i3;
        Object[] objArrCopyOf = new Object[i5 * 2];
        Iterator it = collection.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            AbstractC1204t abstractC1204t = (AbstractC1204t) it.next();
            if (abstractC1204t != null) {
                String strM2985e = m2985e(abstractC1204t);
                int iHashCode = strM2985e.hashCode() & this.f3969f;
                int i7 = iHashCode << 1;
                if (objArrCopyOf[i7] != null) {
                    i7 = ((iHashCode >> 1) + i3) << 1;
                    if (objArrCopyOf[i7] != null) {
                        i7 = (i5 << 1) + i6;
                        i6 += 2;
                        if (i7 >= objArrCopyOf.length) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, objArrCopyOf.length + 4);
                        }
                    }
                }
                objArrCopyOf[i7] = strM2985e;
                objArrCopyOf[i7 + 1] = abstractC1204t;
            }
        }
        this.f3972i = objArrCopyOf;
        this.f3971h = i6;
    }

    /* JADX INFO: renamed from: g */
    public final void m2987g(AbstractC1204t abstractC1204t) {
        ArrayList arrayList = new ArrayList(this.f3970g);
        String strM2985e = m2985e(abstractC1204t);
        int length = this.f3972i.length;
        boolean zEquals = false;
        for (int i3 = 1; i3 < length; i3 += 2) {
            Object[] objArr = this.f3972i;
            AbstractC1204t abstractC1204t2 = (AbstractC1204t) objArr[i3];
            if (abstractC1204t2 != null) {
                if (zEquals || !(zEquals = strM2985e.equals(objArr[i3 - 1]))) {
                    arrayList.add(abstractC1204t2);
                } else {
                    this.f3973j[m2981a(abstractC1204t2)] = null;
                }
            }
        }
        if (!zEquals) {
            throw new NoSuchElementException(AbstractC0032g.m157o(new StringBuilder("No entry '"), abstractC1204t.f4102g.f1928e, "' found, can't remove"));
        }
        m2986f(arrayList);
    }

    /* JADX INFO: renamed from: h */
    public final void m2988h(AbstractC1204t abstractC1204t, AbstractC1204t abstractC1204t2) {
        int length = this.f3972i.length;
        for (int i3 = 1; i3 < length; i3 += 2) {
            Object[] objArr = this.f3972i;
            if (objArr[i3] == abstractC1204t) {
                objArr[i3] = abstractC1204t2;
                this.f3973j[m2981a(abstractC1204t)] = abstractC1204t2;
                return;
            }
        }
        throw new NoSuchElementException(AbstractC0032g.m157o(new StringBuilder("No entry '"), abstractC1204t.f4102g.f1928e, "' found, can't replace"));
    }

    /* JADX INFO: renamed from: i */
    public final C1149a m2989i(C1169u c1169u) {
        String strM2985e = m2985e(c1169u);
        int length = this.f3972i.length;
        for (int i3 = 1; i3 < length; i3 += 2) {
            AbstractC1204t abstractC1204t = (AbstractC1204t) this.f3972i[i3];
            if (abstractC1204t != null && abstractC1204t.f4102g.f1928e.equals(strM2985e)) {
                return new C1149a(this, c1169u, i3, m2981a(abstractC1204t));
            }
        }
        return new C1149a(this, c1169u, strM2985e, strM2985e.hashCode() & this.f3969f);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        ArrayList arrayList = new ArrayList(this.f3970g);
        int length = this.f3972i.length;
        for (int i3 = 1; i3 < length; i3 += 2) {
            AbstractC1204t abstractC1204t = (AbstractC1204t) this.f3972i[i3];
            if (abstractC1204t != null) {
                arrayList.add(abstractC1204t);
            }
        }
        return arrayList.iterator();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Properties=[");
        Iterator it = iterator();
        int i3 = 0;
        while (it.hasNext()) {
            AbstractC1204t abstractC1204t = (AbstractC1204t) it.next();
            int i4 = i3 + 1;
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(abstractC1204t.f4102g.f1928e);
            sb.append('(');
            sb.append(abstractC1204t.f4103h);
            sb.append(')');
            i3 = i4;
        }
        sb.append(']');
        Map map = this.f3974k;
        if (!map.isEmpty()) {
            sb.append("(aliases: ");
            sb.append(map);
            sb.append(")");
        }
        return sb.toString();
    }

    public C1149a(C1149a c1149a, C1169u c1169u, int i3, int i4) {
        this.f3968e = c1149a.f3968e;
        this.f3976m = c1149a.f3976m;
        this.f3969f = c1149a.f3969f;
        this.f3970g = c1149a.f3970g;
        this.f3971h = c1149a.f3971h;
        this.f3974k = c1149a.f3974k;
        this.f3975l = c1149a.f3975l;
        Object[] objArr = c1149a.f3972i;
        this.f3972i = Arrays.copyOf(objArr, objArr.length);
        AbstractC1204t[] abstractC1204tArr = c1149a.f3973j;
        AbstractC1204t[] abstractC1204tArr2 = (AbstractC1204t[]) Arrays.copyOf(abstractC1204tArr, abstractC1204tArr.length);
        this.f3973j = abstractC1204tArr2;
        this.f3972i[i3] = c1169u;
        abstractC1204tArr2[i4] = c1169u;
    }

    public C1149a(C1149a c1149a, C1169u c1169u, String str, int i3) {
        this.f3968e = c1149a.f3968e;
        this.f3976m = c1149a.f3976m;
        this.f3969f = c1149a.f3969f;
        this.f3970g = c1149a.f3970g;
        this.f3971h = c1149a.f3971h;
        this.f3974k = c1149a.f3974k;
        this.f3975l = c1149a.f3975l;
        Object[] objArr = c1149a.f3972i;
        this.f3972i = Arrays.copyOf(objArr, objArr.length);
        AbstractC1204t[] abstractC1204tArr = c1149a.f3973j;
        int length = abstractC1204tArr.length;
        AbstractC1204t[] abstractC1204tArr2 = (AbstractC1204t[]) Arrays.copyOf(abstractC1204tArr, length + 1);
        this.f3973j = abstractC1204tArr2;
        abstractC1204tArr2[length] = c1169u;
        int i4 = this.f3969f + 1;
        int i5 = i3 << 1;
        Object[] objArr2 = this.f3972i;
        if (objArr2[i5] != null) {
            i5 = ((i3 >> 1) + i4) << 1;
            if (objArr2[i5] != null) {
                int i6 = this.f3971h;
                i5 = ((i4 + (i4 >> 1)) << 1) + i6;
                this.f3971h = i6 + 2;
                if (i5 >= objArr2.length) {
                    this.f3972i = Arrays.copyOf(objArr2, objArr2.length + 4);
                }
            }
        }
        Object[] objArr3 = this.f3972i;
        objArr3[i5] = str;
        objArr3[i5 + 1] = c1169u;
    }

    public C1149a(C1149a c1149a, boolean z3) {
        this.f3968e = z3;
        this.f3976m = c1149a.f3976m;
        this.f3974k = c1149a.f3974k;
        this.f3975l = c1149a.f3975l;
        AbstractC1204t[] abstractC1204tArr = c1149a.f3973j;
        AbstractC1204t[] abstractC1204tArr2 = (AbstractC1204t[]) Arrays.copyOf(abstractC1204tArr, abstractC1204tArr.length);
        this.f3973j = abstractC1204tArr2;
        m2986f(Arrays.asList(abstractC1204tArr2));
    }
}
