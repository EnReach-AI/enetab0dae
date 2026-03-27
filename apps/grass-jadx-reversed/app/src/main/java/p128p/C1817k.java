package p128p;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: renamed from: p.k */
/* JADX INFO: loaded from: classes.dex */
public class C1817k {

    /* JADX INFO: renamed from: h */
    public static Object[] f6291h;

    /* JADX INFO: renamed from: i */
    public static int f6292i;

    /* JADX INFO: renamed from: j */
    public static Object[] f6293j;

    /* JADX INFO: renamed from: k */
    public static int f6294k;

    /* JADX INFO: renamed from: e */
    public int[] f6295e = AbstractC1810d.f6267a;

    /* JADX INFO: renamed from: f */
    public Object[] f6296f = AbstractC1810d.f6268b;

    /* JADX INFO: renamed from: g */
    public int f6297g = 0;

    /* JADX INFO: renamed from: c */
    public static void m4032c(int[] iArr, Object[] objArr, int i3) {
        if (iArr.length == 8) {
            synchronized (C1817k.class) {
                try {
                    if (f6294k < 10) {
                        objArr[0] = f6293j;
                        objArr[1] = iArr;
                        for (int i4 = (i3 << 1) - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        f6293j = objArr;
                        f6294k++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C1817k.class) {
                try {
                    if (f6292i < 10) {
                        objArr[0] = f6291h;
                        objArr[1] = iArr;
                        for (int i5 = (i3 << 1) - 1; i5 >= 2; i5--) {
                            objArr[i5] = null;
                        }
                        f6291h = objArr;
                        f6292i++;
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m4033a(int i3) {
        if (i3 == 8) {
            synchronized (C1817k.class) {
                try {
                    Object[] objArr = f6293j;
                    if (objArr != null) {
                        this.f6296f = objArr;
                        f6293j = (Object[]) objArr[0];
                        this.f6295e = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f6294k--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i3 == 4) {
            synchronized (C1817k.class) {
                try {
                    Object[] objArr2 = f6291h;
                    if (objArr2 != null) {
                        this.f6296f = objArr2;
                        f6291h = (Object[]) objArr2[0];
                        this.f6295e = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f6292i--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f6295e = new int[i3];
        this.f6296f = new Object[i3 << 1];
    }

    /* JADX INFO: renamed from: b */
    public final void m4034b(int i3) {
        int i4 = this.f6297g;
        int[] iArr = this.f6295e;
        if (iArr.length < i3) {
            Object[] objArr = this.f6296f;
            m4033a(i3);
            if (this.f6297g > 0) {
                System.arraycopy(iArr, 0, this.f6295e, 0, i4);
                System.arraycopy(objArr, 0, this.f6296f, 0, i4 << 1);
            }
            m4032c(iArr, objArr, i4);
        }
        if (this.f6297g != i4) {
            throw new ConcurrentModificationException();
        }
    }

    public final void clear() {
        int i3 = this.f6297g;
        if (i3 > 0) {
            int[] iArr = this.f6295e;
            Object[] objArr = this.f6296f;
            this.f6295e = AbstractC1810d.f6267a;
            this.f6296f = AbstractC1810d.f6268b;
            this.f6297g = 0;
            m4032c(iArr, objArr, i3);
        }
        if (this.f6297g > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean containsKey(Object obj) {
        return m4036e(obj) >= 0;
    }

    public final boolean containsValue(Object obj) {
        return m4038g(obj) >= 0;
    }

    /* JADX INFO: renamed from: d */
    public final int m4035d(int i3, Object obj) {
        int i4 = this.f6297g;
        if (i4 == 0) {
            return -1;
        }
        try {
            int iM4021a = AbstractC1810d.m4021a(i4, i3, this.f6295e);
            if (iM4021a < 0 || obj.equals(this.f6296f[iM4021a << 1])) {
                return iM4021a;
            }
            int i5 = iM4021a + 1;
            while (i5 < i4 && this.f6295e[i5] == i3) {
                if (obj.equals(this.f6296f[i5 << 1])) {
                    return i5;
                }
                i5++;
            }
            for (int i6 = iM4021a - 1; i6 >= 0 && this.f6295e[i6] == i3; i6--) {
                if (obj.equals(this.f6296f[i6 << 1])) {
                    return i6;
                }
            }
            return ~i5;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX INFO: renamed from: e */
    public final int m4036e(Object obj) {
        return obj == null ? m4037f() : m4035d(obj.hashCode(), obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1817k) {
            C1817k c1817k = (C1817k) obj;
            if (this.f6297g != c1817k.f6297g) {
                return false;
            }
            for (int i3 = 0; i3 < this.f6297g; i3++) {
                try {
                    Object objM4039h = m4039h(i3);
                    Object objM4041j = m4041j(i3);
                    Object orDefault = c1817k.getOrDefault(objM4039h, null);
                    if (objM4041j == null) {
                        if (orDefault != null || !c1817k.containsKey(objM4039h)) {
                            return false;
                        }
                    } else if (!objM4041j.equals(orDefault)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this.f6297g != map.size()) {
                return false;
            }
            for (int i4 = 0; i4 < this.f6297g; i4++) {
                try {
                    Object objM4039h2 = m4039h(i4);
                    Object objM4041j2 = m4041j(i4);
                    Object obj2 = map.get(objM4039h2);
                    if (objM4041j2 == null) {
                        if (obj2 != null || !map.containsKey(objM4039h2)) {
                            return false;
                        }
                    } else if (!objM4041j2.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: f */
    public final int m4037f() {
        int i3 = this.f6297g;
        if (i3 == 0) {
            return -1;
        }
        try {
            int iM4021a = AbstractC1810d.m4021a(i3, 0, this.f6295e);
            if (iM4021a < 0 || this.f6296f[iM4021a << 1] == null) {
                return iM4021a;
            }
            int i4 = iM4021a + 1;
            while (i4 < i3 && this.f6295e[i4] == 0) {
                if (this.f6296f[i4 << 1] == null) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = iM4021a - 1; i5 >= 0 && this.f6295e[i5] == 0; i5--) {
                if (this.f6296f[i5 << 1] == null) {
                    return i5;
                }
            }
            return ~i4;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX INFO: renamed from: g */
    public final int m4038g(Object obj) {
        int i3 = this.f6297g * 2;
        Object[] objArr = this.f6296f;
        if (obj == null) {
            for (int i4 = 1; i4 < i3; i4 += 2) {
                if (objArr[i4] == null) {
                    return i4 >> 1;
                }
            }
            return -1;
        }
        for (int i5 = 1; i5 < i3; i5 += 2) {
            if (obj.equals(objArr[i5])) {
                return i5 >> 1;
            }
        }
        return -1;
    }

    public final Object get(Object obj) {
        return getOrDefault(obj, null);
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int iM4036e = m4036e(obj);
        return iM4036e >= 0 ? this.f6296f[(iM4036e << 1) + 1] : obj2;
    }

    /* JADX INFO: renamed from: h */
    public final Object m4039h(int i3) {
        return this.f6296f[i3 << 1];
    }

    public final int hashCode() {
        int[] iArr = this.f6295e;
        Object[] objArr = this.f6296f;
        int i3 = this.f6297g;
        int i4 = 1;
        int i5 = 0;
        int iHashCode = 0;
        while (i5 < i3) {
            Object obj = objArr[i4];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i5];
            i5++;
            i4 += 2;
        }
        return iHashCode;
    }

    /* JADX INFO: renamed from: i */
    public final Object m4040i(int i3) {
        Object[] objArr = this.f6296f;
        int i4 = i3 << 1;
        Object obj = objArr[i4 + 1];
        int i5 = this.f6297g;
        int i6 = 0;
        if (i5 <= 1) {
            m4032c(this.f6295e, objArr, i5);
            this.f6295e = AbstractC1810d.f6267a;
            this.f6296f = AbstractC1810d.f6268b;
        } else {
            int i7 = i5 - 1;
            int[] iArr = this.f6295e;
            if (iArr.length <= 8 || i5 >= iArr.length / 3) {
                if (i3 < i7) {
                    int i8 = i3 + 1;
                    int i9 = i7 - i3;
                    System.arraycopy(iArr, i8, iArr, i3, i9);
                    Object[] objArr2 = this.f6296f;
                    System.arraycopy(objArr2, i8 << 1, objArr2, i4, i9 << 1);
                }
                Object[] objArr3 = this.f6296f;
                int i10 = i7 << 1;
                objArr3[i10] = null;
                objArr3[i10 + 1] = null;
            } else {
                m4033a(i5 > 8 ? i5 + (i5 >> 1) : 8);
                if (i5 != this.f6297g) {
                    throw new ConcurrentModificationException();
                }
                if (i3 > 0) {
                    System.arraycopy(iArr, 0, this.f6295e, 0, i3);
                    System.arraycopy(objArr, 0, this.f6296f, 0, i4);
                }
                if (i3 < i7) {
                    int i11 = i3 + 1;
                    int i12 = i7 - i3;
                    System.arraycopy(iArr, i11, this.f6295e, i3, i12);
                    System.arraycopy(objArr, i11 << 1, this.f6296f, i4, i12 << 1);
                }
            }
            i6 = i7;
        }
        if (i5 != this.f6297g) {
            throw new ConcurrentModificationException();
        }
        this.f6297g = i6;
        return obj;
    }

    public final boolean isEmpty() {
        return this.f6297g <= 0;
    }

    /* JADX INFO: renamed from: j */
    public final Object m4041j(int i3) {
        return this.f6296f[(i3 << 1) + 1];
    }

    public final Object put(Object obj, Object obj2) {
        int i3;
        int iM4035d;
        int i4 = this.f6297g;
        if (obj == null) {
            iM4035d = m4037f();
            i3 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i3 = iHashCode;
            iM4035d = m4035d(iHashCode, obj);
        }
        if (iM4035d >= 0) {
            int i5 = (iM4035d << 1) + 1;
            Object[] objArr = this.f6296f;
            Object obj3 = objArr[i5];
            objArr[i5] = obj2;
            return obj3;
        }
        int i6 = ~iM4035d;
        int[] iArr = this.f6295e;
        if (i4 >= iArr.length) {
            int i7 = 8;
            if (i4 >= 8) {
                i7 = (i4 >> 1) + i4;
            } else if (i4 < 4) {
                i7 = 4;
            }
            Object[] objArr2 = this.f6296f;
            m4033a(i7);
            if (i4 != this.f6297g) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f6295e;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f6296f, 0, objArr2.length);
            }
            m4032c(iArr, objArr2, i4);
        }
        if (i6 < i4) {
            int[] iArr3 = this.f6295e;
            int i8 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i8, i4 - i6);
            Object[] objArr3 = this.f6296f;
            System.arraycopy(objArr3, i6 << 1, objArr3, i8 << 1, (this.f6297g - i6) << 1);
        }
        int i9 = this.f6297g;
        if (i4 == i9) {
            int[] iArr4 = this.f6295e;
            if (i6 < iArr4.length) {
                iArr4[i6] = i3;
                Object[] objArr4 = this.f6296f;
                int i10 = i6 << 1;
                objArr4[i10] = obj;
                objArr4[i10 + 1] = obj2;
                this.f6297g = i9 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object orDefault = getOrDefault(obj, null);
        return orDefault == null ? put(obj, obj2) : orDefault;
    }

    public final Object remove(Object obj) {
        int iM4036e = m4036e(obj);
        if (iM4036e >= 0) {
            return m4040i(iM4036e);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int iM4036e = m4036e(obj);
        if (iM4036e < 0) {
            return null;
        }
        int i3 = (iM4036e << 1) + 1;
        Object[] objArr = this.f6296f;
        Object obj3 = objArr[i3];
        objArr[i3] = obj2;
        return obj3;
    }

    public final int size() {
        return this.f6297g;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f6297g * 28);
        sb.append('{');
        for (int i3 = 0; i3 < this.f6297g; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object objM4039h = m4039h(i3);
            if (objM4039h != this) {
                sb.append(objM4039h);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objM4041j = m4041j(i3);
            if (objM4041j != this) {
                sb.append(objM4041j);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final boolean remove(Object obj, Object obj2) {
        int iM4036e = m4036e(obj);
        if (iM4036e < 0) {
            return false;
        }
        Object objM4041j = m4041j(iM4036e);
        if (obj2 != objM4041j && (obj2 == null || !obj2.equals(objM4041j))) {
            return false;
        }
        m4040i(iM4036e);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iM4036e = m4036e(obj);
        if (iM4036e < 0) {
            return false;
        }
        Object objM4041j = m4041j(iM4036e);
        if (objM4041j != obj2 && (obj2 == null || !obj2.equals(objM4041j))) {
            return false;
        }
        int i3 = (iM4036e << 1) + 1;
        Object[] objArr = this.f6296f;
        Object obj4 = objArr[i3];
        objArr[i3] = obj3;
        return true;
    }
}
