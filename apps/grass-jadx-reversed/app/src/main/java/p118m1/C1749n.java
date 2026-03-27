package p118m1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import p069X0.AbstractC0711b;
import p069X0.C0717h;
import p069X0.EnumC0731v;

/* JADX INFO: renamed from: m1.n */
/* JADX INFO: loaded from: classes.dex */
public final class C1749n implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final Class f6117e;

    /* JADX INFO: renamed from: f */
    public final Enum[] f6118f;

    /* JADX INFO: renamed from: g */
    public final HashMap f6119g;

    /* JADX INFO: renamed from: h */
    public final Enum f6120h;

    /* JADX INFO: renamed from: i */
    public final boolean f6121i;

    /* JADX INFO: renamed from: j */
    public final boolean f6122j;

    public C1749n(Class cls, Enum[] enumArr, HashMap map, Enum r4, boolean z3, boolean z4) {
        this.f6117e = cls;
        this.f6118f = enumArr;
        this.f6119g = map;
        this.f6120h = r4;
        this.f6121i = z3;
        this.f6122j = z4;
    }

    /* JADX INFO: renamed from: a */
    public static Enum[] m3905a(Class cls) {
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        if (enumArr != null) {
            return enumArr;
        }
        throw new IllegalArgumentException("No enum constants for class ".concat(cls.getName()));
    }

    /* JADX INFO: renamed from: c */
    public static C1749n m3906c(C0717h c0717h, Class cls) {
        AbstractC0711b abstractC0711bM2149d = c0717h.m2149d();
        boolean zM2157l = c0717h.m2157l(EnumC0731v.ACCEPT_CASE_INSENSITIVE_ENUMS);
        Enum[] enumArrM3905a = m3905a(cls);
        HashMap map = new HashMap();
        String[][] strArr = new String[enumArrM3905a.length][];
        if (abstractC0711bM2149d != null) {
            abstractC0711bM2149d.mo1775k(cls, enumArrM3905a, strArr);
        }
        int length = enumArrM3905a.length;
        while (true) {
            length--;
            if (length < 0) {
                break;
            }
            Enum r22 = enumArrM3905a[length];
            map.put(r22.toString(), r22);
            String[] strArr2 = strArr[length];
            if (strArr2 != null) {
                for (String str : strArr2) {
                    map.putIfAbsent(str, r22);
                }
            }
        }
        return new C1749n(cls, enumArrM3905a, map, abstractC0711bM2149d != null ? abstractC0711bM2149d.mo1767g(cls) : null, zM2157l, false);
    }

    /* JADX INFO: renamed from: b */
    public final C1746k m3907b() {
        int i3;
        HashMap map = this.f6119g;
        if (map.isEmpty()) {
            return C1746k.f6113h;
        }
        int size = map.size();
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
        int i5 = i3 - 1;
        int i6 = (i3 >> 1) + i3;
        Object[] objArrCopyOf = new Object[i6 * 2];
        int i7 = 0;
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str != null) {
                int iHashCode = str.hashCode() & i5;
                int i8 = iHashCode + iHashCode;
                if (objArrCopyOf[i8] != null) {
                    i8 = ((iHashCode >> 1) + i3) << 1;
                    if (objArrCopyOf[i8] != null) {
                        i8 = (i6 << 1) + i7;
                        i7 += 2;
                        if (i8 >= objArrCopyOf.length) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, objArrCopyOf.length + 4);
                        }
                    }
                }
                objArrCopyOf[i8] = str;
                objArrCopyOf[i8 + 1] = entry.getValue();
            }
        }
        return new C1746k(i5, i7, objArrCopyOf);
    }

    /* JADX INFO: renamed from: d */
    public final Enum m3908d(String str) {
        HashMap map = this.f6119g;
        Enum r12 = (Enum) map.get(str);
        if (r12 != null || !this.f6121i) {
            return r12;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                return (Enum) entry.getValue();
            }
        }
        return null;
    }
}
