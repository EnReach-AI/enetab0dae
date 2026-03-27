package p128p;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: p.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1809c implements Collection, Set {

    /* JADX INFO: renamed from: i */
    public static final int[] f6257i = new int[0];

    /* JADX INFO: renamed from: j */
    public static final Object[] f6258j = new Object[0];

    /* JADX INFO: renamed from: k */
    public static Object[] f6259k;

    /* JADX INFO: renamed from: l */
    public static int f6260l;

    /* JADX INFO: renamed from: m */
    public static Object[] f6261m;

    /* JADX INFO: renamed from: n */
    public static int f6262n;

    /* JADX INFO: renamed from: e */
    public int[] f6263e;

    /* JADX INFO: renamed from: f */
    public Object[] f6264f;

    /* JADX INFO: renamed from: g */
    public int f6265g;

    /* JADX INFO: renamed from: h */
    public C1807a f6266h;

    public C1809c(int i3) {
        if (i3 == 0) {
            this.f6263e = f6257i;
            this.f6264f = f6258j;
        } else {
            m4017a(i3);
        }
        this.f6265g = 0;
    }

    /* JADX INFO: renamed from: b */
    public static void m4016b(int[] iArr, Object[] objArr, int i3) {
        if (iArr.length == 8) {
            synchronized (C1809c.class) {
                try {
                    if (f6262n < 10) {
                        objArr[0] = f6261m;
                        objArr[1] = iArr;
                        for (int i4 = i3 - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        f6261m = objArr;
                        f6262n++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C1809c.class) {
                try {
                    if (f6260l < 10) {
                        objArr[0] = f6259k;
                        objArr[1] = iArr;
                        for (int i5 = i3 - 1; i5 >= 2; i5--) {
                            objArr[i5] = null;
                        }
                        f6259k = objArr;
                        f6260l++;
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m4017a(int i3) {
        if (i3 == 8) {
            synchronized (C1809c.class) {
                try {
                    Object[] objArr = f6261m;
                    if (objArr != null) {
                        this.f6264f = objArr;
                        f6261m = (Object[]) objArr[0];
                        this.f6263e = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f6262n--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i3 == 4) {
            synchronized (C1809c.class) {
                try {
                    Object[] objArr2 = f6259k;
                    if (objArr2 != null) {
                        this.f6264f = objArr2;
                        f6259k = (Object[]) objArr2[0];
                        this.f6263e = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f6260l--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f6263e = new int[i3];
        this.f6264f = new Object[i3];
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i3;
        int iM4018c;
        if (obj == null) {
            iM4018c = m4019d();
            i3 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i3 = iHashCode;
            iM4018c = m4018c(iHashCode, obj);
        }
        if (iM4018c >= 0) {
            return false;
        }
        int i4 = ~iM4018c;
        int i5 = this.f6265g;
        int[] iArr = this.f6263e;
        if (i5 >= iArr.length) {
            int i6 = 8;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 < 4) {
                i6 = 4;
            }
            Object[] objArr = this.f6264f;
            m4017a(i6);
            int[] iArr2 = this.f6263e;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f6264f, 0, objArr.length);
            }
            m4016b(iArr, objArr, this.f6265g);
        }
        int i7 = this.f6265g;
        if (i4 < i7) {
            int[] iArr3 = this.f6263e;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.f6264f;
            System.arraycopy(objArr2, i4, objArr2, i8, this.f6265g - i4);
        }
        this.f6263e[i4] = i3;
        this.f6264f[i4] = obj;
        this.f6265g++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        int size = collection.size() + this.f6265g;
        int[] iArr = this.f6263e;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.f6264f;
            m4017a(size);
            int i3 = this.f6265g;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f6263e, 0, i3);
                System.arraycopy(objArr, 0, this.f6264f, 0, this.f6265g);
            }
            m4016b(iArr, objArr, this.f6265g);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    /* JADX INFO: renamed from: c */
    public final int m4018c(int i3, Object obj) {
        int i4 = this.f6265g;
        if (i4 == 0) {
            return -1;
        }
        int iM4021a = AbstractC1810d.m4021a(i4, i3, this.f6263e);
        if (iM4021a < 0 || obj.equals(this.f6264f[iM4021a])) {
            return iM4021a;
        }
        int i5 = iM4021a + 1;
        while (i5 < i4 && this.f6263e[i5] == i3) {
            if (obj.equals(this.f6264f[i5])) {
                return i5;
            }
            i5++;
        }
        for (int i6 = iM4021a - 1; i6 >= 0 && this.f6263e[i6] == i3; i6--) {
            if (obj.equals(this.f6264f[i6])) {
                return i6;
            }
        }
        return ~i5;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        int i3 = this.f6265g;
        if (i3 != 0) {
            m4016b(this.f6263e, this.f6264f, i3);
            this.f6263e = f6257i;
            this.f6264f = f6258j;
            this.f6265g = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: d */
    public final int m4019d() {
        int i3 = this.f6265g;
        if (i3 == 0) {
            return -1;
        }
        int iM4021a = AbstractC1810d.m4021a(i3, 0, this.f6263e);
        if (iM4021a < 0 || this.f6264f[iM4021a] == null) {
            return iM4021a;
        }
        int i4 = iM4021a + 1;
        while (i4 < i3 && this.f6263e[i4] == 0) {
            if (this.f6264f[i4] == null) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iM4021a - 1; i5 >= 0 && this.f6263e[i5] == 0; i5--) {
            if (this.f6264f[i5] == null) {
                return i5;
            }
        }
        return ~i4;
    }

    /* JADX INFO: renamed from: e */
    public final void m4020e(int i3) {
        Object[] objArr = this.f6264f;
        Object obj = objArr[i3];
        int i4 = this.f6265g;
        if (i4 <= 1) {
            m4016b(this.f6263e, objArr, i4);
            this.f6263e = f6257i;
            this.f6264f = f6258j;
            this.f6265g = 0;
            return;
        }
        int[] iArr = this.f6263e;
        if (iArr.length <= 8 || i4 >= iArr.length / 3) {
            int i5 = i4 - 1;
            this.f6265g = i5;
            if (i3 < i5) {
                int i6 = i3 + 1;
                System.arraycopy(iArr, i6, iArr, i3, i5 - i3);
                Object[] objArr2 = this.f6264f;
                System.arraycopy(objArr2, i6, objArr2, i3, this.f6265g - i3);
            }
            this.f6264f[this.f6265g] = null;
            return;
        }
        m4017a(i4 > 8 ? i4 + (i4 >> 1) : 8);
        this.f6265g--;
        if (i3 > 0) {
            System.arraycopy(iArr, 0, this.f6263e, 0, i3);
            System.arraycopy(objArr, 0, this.f6264f, 0, i3);
        }
        int i7 = this.f6265g;
        if (i3 < i7) {
            int i8 = i3 + 1;
            System.arraycopy(iArr, i8, this.f6263e, i3, i7 - i3);
            System.arraycopy(objArr, i8, this.f6264f, i3, this.f6265g - i3);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.f6265g != set.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.f6265g; i3++) {
                try {
                    if (!set.contains(this.f6264f[i3])) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f6263e;
        int i3 = this.f6265g;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            i4 += iArr[i5];
        }
        return i4;
    }

    public final int indexOf(Object obj) {
        return obj == null ? m4019d() : m4018c(obj.hashCode(), obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f6265g <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        if (this.f6266h == null) {
            this.f6266h = new C1807a(1, this);
        }
        C1807a c1807a = this.f6266h;
        if (c1807a.f6252b == null) {
            c1807a.f6252b = new C1814h(c1807a, 1);
        }
        return c1807a.f6252b.iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        m4020e(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        boolean z3 = false;
        for (int i3 = this.f6265g - 1; i3 >= 0; i3--) {
            if (!collection.contains(this.f6264f[i3])) {
                m4020e(i3);
                z3 = true;
            }
        }
        return z3;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f6265g;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        int i3 = this.f6265g;
        Object[] objArr = new Object[i3];
        System.arraycopy(this.f6264f, 0, objArr, 0, i3);
        return objArr;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f6265g * 14);
        sb.append('{');
        for (int i3 = 0; i3 < this.f6265g; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object obj = this.f6264f[i3];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f6265g) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f6265g);
        }
        System.arraycopy(this.f6264f, 0, objArr, 0, this.f6265g);
        int length = objArr.length;
        int i3 = this.f6265g;
        if (length > i3) {
            objArr[i3] = null;
        }
        return objArr;
    }
}
