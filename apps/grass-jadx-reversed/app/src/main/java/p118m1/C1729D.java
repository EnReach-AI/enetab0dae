package p118m1;

import java.util.TreeMap;
import p042N0.EnumC0548p;

/* JADX INFO: renamed from: m1.D */
/* JADX INFO: loaded from: classes.dex */
public final class C1729D {

    /* JADX INFO: renamed from: e */
    public static final EnumC0548p[] f6050e;

    /* JADX INFO: renamed from: a */
    public C1729D f6051a;

    /* JADX INFO: renamed from: b */
    public long f6052b;

    /* JADX INFO: renamed from: c */
    public final Object[] f6053c = new Object[16];

    /* JADX INFO: renamed from: d */
    public TreeMap f6054d;

    static {
        EnumC0548p[] enumC0548pArr = new EnumC0548p[16];
        f6050e = enumC0548pArr;
        EnumC0548p[] enumC0548pArrValues = EnumC0548p.values();
        System.arraycopy(enumC0548pArrValues, 1, enumC0548pArr, 1, Math.min(15, enumC0548pArrValues.length - 1));
    }

    /* JADX INFO: renamed from: a */
    public final C1729D m3847a(int i3, EnumC0548p enumC0548p) {
        if (i3 >= 16) {
            C1729D c1729d = new C1729D();
            this.f6051a = c1729d;
            c1729d.f6052b = ((long) enumC0548p.ordinal()) | c1729d.f6052b;
            return this.f6051a;
        }
        long jOrdinal = enumC0548p.ordinal();
        if (i3 > 0) {
            jOrdinal <<= i3 << 2;
        }
        this.f6052b |= jOrdinal;
        return null;
    }

    /* JADX INFO: renamed from: b */
    public final void m3848b(Object obj, int i3, Object obj2) {
        if (this.f6054d == null) {
            this.f6054d = new TreeMap();
        }
        if (obj != null) {
            this.f6054d.put(Integer.valueOf(i3 + i3 + 1), obj);
        }
        if (obj2 != null) {
            this.f6054d.put(Integer.valueOf(i3 + i3), obj2);
        }
    }

    /* JADX INFO: renamed from: c */
    public final Object m3849c(int i3) {
        TreeMap treeMap = this.f6054d;
        if (treeMap == null) {
            return null;
        }
        return treeMap.get(Integer.valueOf(i3 + i3 + 1));
    }

    /* JADX INFO: renamed from: d */
    public final EnumC0548p m3850d(int i3) {
        long j2 = this.f6052b;
        if (i3 > 0) {
            j2 >>= i3 << 2;
        }
        return f6050e[((int) j2) & 15];
    }
}
