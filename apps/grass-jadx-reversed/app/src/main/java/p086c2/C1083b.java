package p086c2;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: c2.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1083b extends AbstractList implements List {

    /* JADX INFO: renamed from: h */
    public static final Object[] f3777h = new Object[0];

    /* JADX INFO: renamed from: e */
    public int f3778e;

    /* JADX INFO: renamed from: f */
    public Object[] f3779f = f3777h;

    /* JADX INFO: renamed from: g */
    public int f3780g;

    /* JADX INFO: renamed from: a */
    public final void m2823a(int i3, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f3779f.length;
        while (i3 < length && it.hasNext()) {
            this.f3779f[i3] = it.next();
            i3++;
        }
        int i4 = this.f3778e;
        for (int i5 = 0; i5 < i4 && it.hasNext(); i5++) {
            this.f3779f[i5] = it.next();
        }
        this.f3780g = collection.size() + this.f3780g;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i3, Object obj) {
        int length;
        int i4 = this.f3780g;
        if (i3 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException("index: " + i3 + ", size: " + i4);
        }
        if (i3 == i4) {
            addLast(obj);
            return;
        }
        if (i3 == 0) {
            addFirst(obj);
            return;
        }
        m2824b(i4 + 1);
        int iM2826d = m2826d(this.f3778e + i3);
        int i5 = this.f3780g;
        if (i3 < ((i5 + 1) >> 1)) {
            if (iM2826d == 0) {
                Object[] objArr = this.f3779f;
                AbstractC1766e.m3920e("<this>", objArr);
                iM2826d = objArr.length;
            }
            int i6 = iM2826d - 1;
            int i7 = this.f3778e;
            if (i7 == 0) {
                Object[] objArr2 = this.f3779f;
                AbstractC1766e.m3920e("<this>", objArr2);
                length = objArr2.length - 1;
            } else {
                length = i7 - 1;
            }
            int i8 = this.f3778e;
            if (i6 >= i8) {
                Object[] objArr3 = this.f3779f;
                objArr3[length] = objArr3[i8];
                AbstractC1084c.m2831y(objArr3, objArr3, i8, i8 + 1, i6 + 1);
            } else {
                Object[] objArr4 = this.f3779f;
                AbstractC1084c.m2831y(objArr4, objArr4, i8 - 1, i8, objArr4.length);
                Object[] objArr5 = this.f3779f;
                objArr5[objArr5.length - 1] = objArr5[0];
                AbstractC1084c.m2831y(objArr5, objArr5, 0, 1, i6 + 1);
            }
            this.f3779f[i6] = obj;
            this.f3778e = length;
        } else {
            int iM2826d2 = m2826d(this.f3778e + i5);
            if (iM2826d < iM2826d2) {
                Object[] objArr6 = this.f3779f;
                AbstractC1084c.m2831y(objArr6, objArr6, iM2826d + 1, iM2826d, iM2826d2);
            } else {
                Object[] objArr7 = this.f3779f;
                AbstractC1084c.m2831y(objArr7, objArr7, 1, 0, iM2826d2);
                Object[] objArr8 = this.f3779f;
                objArr8[0] = objArr8[objArr8.length - 1];
                AbstractC1084c.m2831y(objArr8, objArr8, iM2826d + 1, iM2826d, objArr8.length - 1);
            }
            this.f3779f[iM2826d] = obj;
        }
        this.f3780g++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i3, Collection collection) {
        AbstractC1766e.m3920e("elements", collection);
        int i4 = this.f3780g;
        if (i3 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException("index: " + i3 + ", size: " + i4);
        }
        if (collection.isEmpty()) {
            return false;
        }
        int i5 = this.f3780g;
        if (i3 == i5) {
            return addAll(collection);
        }
        m2824b(collection.size() + i5);
        int iM2826d = m2826d(this.f3778e + this.f3780g);
        int iM2826d2 = m2826d(this.f3778e + i3);
        int size = collection.size();
        if (i3 < ((this.f3780g + 1) >> 1)) {
            int i6 = this.f3778e;
            int length = i6 - size;
            if (iM2826d2 < i6) {
                Object[] objArr = this.f3779f;
                AbstractC1084c.m2831y(objArr, objArr, length, i6, objArr.length);
                if (size >= iM2826d2) {
                    Object[] objArr2 = this.f3779f;
                    AbstractC1084c.m2831y(objArr2, objArr2, objArr2.length - size, 0, iM2826d2);
                } else {
                    Object[] objArr3 = this.f3779f;
                    AbstractC1084c.m2831y(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f3779f;
                    AbstractC1084c.m2831y(objArr4, objArr4, 0, size, iM2826d2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f3779f;
                AbstractC1084c.m2831y(objArr5, objArr5, length, i6, iM2826d2);
            } else {
                Object[] objArr6 = this.f3779f;
                length += objArr6.length;
                int i7 = iM2826d2 - i6;
                int length2 = objArr6.length - length;
                if (length2 >= i7) {
                    AbstractC1084c.m2831y(objArr6, objArr6, length, i6, iM2826d2);
                } else {
                    AbstractC1084c.m2831y(objArr6, objArr6, length, i6, i6 + length2);
                    Object[] objArr7 = this.f3779f;
                    AbstractC1084c.m2831y(objArr7, objArr7, 0, this.f3778e + length2, iM2826d2);
                }
            }
            this.f3778e = length;
            int length3 = iM2826d2 - size;
            if (length3 < 0) {
                length3 += this.f3779f.length;
            }
            m2823a(length3, collection);
        } else {
            int i8 = iM2826d2 + size;
            if (iM2826d2 < iM2826d) {
                int i9 = size + iM2826d;
                Object[] objArr8 = this.f3779f;
                if (i9 <= objArr8.length) {
                    AbstractC1084c.m2831y(objArr8, objArr8, i8, iM2826d2, iM2826d);
                } else if (i8 >= objArr8.length) {
                    AbstractC1084c.m2831y(objArr8, objArr8, i8 - objArr8.length, iM2826d2, iM2826d);
                } else {
                    int length4 = iM2826d - (i9 - objArr8.length);
                    AbstractC1084c.m2831y(objArr8, objArr8, 0, length4, iM2826d);
                    Object[] objArr9 = this.f3779f;
                    AbstractC1084c.m2831y(objArr9, objArr9, i8, iM2826d2, length4);
                }
            } else {
                Object[] objArr10 = this.f3779f;
                AbstractC1084c.m2831y(objArr10, objArr10, size, 0, iM2826d);
                Object[] objArr11 = this.f3779f;
                if (i8 >= objArr11.length) {
                    AbstractC1084c.m2831y(objArr11, objArr11, i8 - objArr11.length, iM2826d2, objArr11.length);
                } else {
                    AbstractC1084c.m2831y(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f3779f;
                    AbstractC1084c.m2831y(objArr12, objArr12, i8, iM2826d2, objArr12.length - size);
                }
            }
            m2823a(iM2826d2, collection);
        }
        return true;
    }

    public final void addFirst(Object obj) {
        m2824b(this.f3780g + 1);
        int length = this.f3778e;
        if (length == 0) {
            Object[] objArr = this.f3779f;
            AbstractC1766e.m3920e("<this>", objArr);
            length = objArr.length;
        }
        int i3 = length - 1;
        this.f3778e = i3;
        this.f3779f[i3] = obj;
        this.f3780g++;
    }

    public final void addLast(Object obj) {
        m2824b(this.f3780g + 1);
        this.f3779f[m2826d(this.f3778e + this.f3780g)] = obj;
        this.f3780g++;
    }

    /* JADX INFO: renamed from: b */
    public final void m2824b(int i3) {
        if (i3 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f3779f;
        if (i3 <= objArr.length) {
            return;
        }
        if (objArr == f3777h) {
            if (i3 < 10) {
                i3 = 10;
            }
            this.f3779f = new Object[i3];
            return;
        }
        int length = objArr.length;
        int i4 = length + (length >> 1);
        if (i4 - i3 < 0) {
            i4 = i3;
        }
        if (i4 - 2147483639 > 0) {
            i4 = i3 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i4];
        AbstractC1084c.m2831y(objArr, objArr2, 0, this.f3778e, objArr.length);
        Object[] objArr3 = this.f3779f;
        int length2 = objArr3.length;
        int i5 = this.f3778e;
        AbstractC1084c.m2831y(objArr3, objArr2, length2 - i5, 0, i5);
        this.f3778e = 0;
        this.f3779f = objArr2;
    }

    /* JADX INFO: renamed from: c */
    public final int m2825c(int i3) {
        AbstractC1766e.m3920e("<this>", this.f3779f);
        if (i3 == r0.length - 1) {
            return 0;
        }
        return i3 + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        int iM2826d = m2826d(this.f3778e + this.f3780g);
        int i3 = this.f3778e;
        if (i3 < iM2826d) {
            Object[] objArr = this.f3779f;
            AbstractC1766e.m3920e("<this>", objArr);
            Arrays.fill(objArr, i3, iM2826d, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f3779f;
            Arrays.fill(objArr2, this.f3778e, objArr2.length, (Object) null);
            Object[] objArr3 = this.f3779f;
            AbstractC1766e.m3920e("<this>", objArr3);
            Arrays.fill(objArr3, 0, iM2826d, (Object) null);
        }
        this.f3778e = 0;
        this.f3780g = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /* JADX INFO: renamed from: d */
    public final int m2826d(int i3) {
        Object[] objArr = this.f3779f;
        return i3 >= objArr.length ? i3 - objArr.length : i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i3) {
        int i4 = this.f3780g;
        if (i3 >= 0 && i3 < i4) {
            return this.f3779f[m2826d(this.f3778e + i3)];
        }
        throw new IndexOutOfBoundsException("index: " + i3 + ", size: " + i4);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i3;
        int iM2826d = m2826d(this.f3778e + this.f3780g);
        int length = this.f3778e;
        if (length < iM2826d) {
            while (length < iM2826d) {
                if (AbstractC1766e.m3916a(obj, this.f3779f[length])) {
                    i3 = this.f3778e;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iM2826d) {
            return -1;
        }
        int length2 = this.f3779f.length;
        while (true) {
            if (length >= length2) {
                for (int i4 = 0; i4 < iM2826d; i4++) {
                    if (AbstractC1766e.m3916a(obj, this.f3779f[i4])) {
                        length = i4 + this.f3779f.length;
                        i3 = this.f3778e;
                    }
                }
                return -1;
            }
            if (AbstractC1766e.m3916a(obj, this.f3779f[length])) {
                i3 = this.f3778e;
                break;
            }
            length++;
        }
        return length - i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f3780g == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i3;
        int iM2826d = m2826d(this.f3778e + this.f3780g);
        int i4 = this.f3778e;
        if (i4 < iM2826d) {
            length = iM2826d - 1;
            if (i4 <= length) {
                while (!AbstractC1766e.m3916a(obj, this.f3779f[length])) {
                    if (length != i4) {
                        length--;
                    }
                }
                i3 = this.f3778e;
                return length - i3;
            }
            return -1;
        }
        if (i4 > iM2826d) {
            int i5 = iM2826d - 1;
            while (true) {
                if (-1 >= i5) {
                    Object[] objArr = this.f3779f;
                    AbstractC1766e.m3920e("<this>", objArr);
                    length = objArr.length - 1;
                    int i6 = this.f3778e;
                    if (i6 <= length) {
                        while (!AbstractC1766e.m3916a(obj, this.f3779f[length])) {
                            if (length != i6) {
                                length--;
                            }
                        }
                        i3 = this.f3778e;
                    }
                } else {
                    if (AbstractC1766e.m3916a(obj, this.f3779f[i5])) {
                        length = i5 + this.f3779f.length;
                        i3 = this.f3778e;
                        break;
                    }
                    i5--;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i3) {
        int i4 = this.f3780g;
        if (i3 < 0 || i3 >= i4) {
            throw new IndexOutOfBoundsException("index: " + i3 + ", size: " + i4);
        }
        if (i3 == AbstractC1086e.m2836t(this)) {
            return removeLast();
        }
        if (i3 == 0) {
            return removeFirst();
        }
        int iM2826d = m2826d(this.f3778e + i3);
        Object[] objArr = this.f3779f;
        Object obj = objArr[iM2826d];
        if (i3 < (this.f3780g >> 1)) {
            int i5 = this.f3778e;
            if (iM2826d >= i5) {
                AbstractC1084c.m2831y(objArr, objArr, i5 + 1, i5, iM2826d);
            } else {
                AbstractC1084c.m2831y(objArr, objArr, 1, 0, iM2826d);
                Object[] objArr2 = this.f3779f;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i6 = this.f3778e;
                AbstractC1084c.m2831y(objArr2, objArr2, i6 + 1, i6, objArr2.length - 1);
            }
            Object[] objArr3 = this.f3779f;
            int i7 = this.f3778e;
            objArr3[i7] = null;
            this.f3778e = m2825c(i7);
        } else {
            int iM2826d2 = m2826d(AbstractC1086e.m2836t(this) + this.f3778e);
            if (iM2826d <= iM2826d2) {
                Object[] objArr4 = this.f3779f;
                AbstractC1084c.m2831y(objArr4, objArr4, iM2826d, iM2826d + 1, iM2826d2 + 1);
            } else {
                Object[] objArr5 = this.f3779f;
                AbstractC1084c.m2831y(objArr5, objArr5, iM2826d, iM2826d + 1, objArr5.length);
                Object[] objArr6 = this.f3779f;
                objArr6[objArr6.length - 1] = objArr6[0];
                AbstractC1084c.m2831y(objArr6, objArr6, 0, 1, iM2826d2 + 1);
            }
            this.f3779f[iM2826d2] = null;
        }
        this.f3780g--;
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int iM2826d;
        AbstractC1766e.m3920e("elements", collection);
        boolean z3 = false;
        z3 = false;
        z3 = false;
        if (!isEmpty() && this.f3779f.length != 0) {
            int iM2826d2 = m2826d(this.f3778e + this.f3780g);
            int i3 = this.f3778e;
            if (i3 < iM2826d2) {
                iM2826d = i3;
                while (i3 < iM2826d2) {
                    Object obj = this.f3779f[i3];
                    if (!collection.contains(obj)) {
                        this.f3779f[iM2826d] = obj;
                        iM2826d++;
                    } else {
                        z3 = true;
                    }
                    i3++;
                }
                Object[] objArr = this.f3779f;
                AbstractC1766e.m3920e("<this>", objArr);
                Arrays.fill(objArr, iM2826d, iM2826d2, (Object) null);
            } else {
                int length = this.f3779f.length;
                boolean z4 = false;
                int i4 = i3;
                while (i3 < length) {
                    Object[] objArr2 = this.f3779f;
                    Object obj2 = objArr2[i3];
                    objArr2[i3] = null;
                    if (!collection.contains(obj2)) {
                        this.f3779f[i4] = obj2;
                        i4++;
                    } else {
                        z4 = true;
                    }
                    i3++;
                }
                iM2826d = m2826d(i4);
                for (int i5 = 0; i5 < iM2826d2; i5++) {
                    Object[] objArr3 = this.f3779f;
                    Object obj3 = objArr3[i5];
                    objArr3[i5] = null;
                    if (!collection.contains(obj3)) {
                        this.f3779f[iM2826d] = obj3;
                        iM2826d = m2825c(iM2826d);
                    } else {
                        z4 = true;
                    }
                }
                z3 = z4;
            }
            if (z3) {
                int length2 = iM2826d - this.f3778e;
                if (length2 < 0) {
                    length2 += this.f3779f.length;
                }
                this.f3780g = length2;
            }
        }
        return z3;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.f3779f;
        int i3 = this.f3778e;
        Object obj = objArr[i3];
        objArr[i3] = null;
        this.f3778e = m2825c(i3);
        this.f3780g--;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int iM2826d = m2826d(AbstractC1086e.m2836t(this) + this.f3778e);
        Object[] objArr = this.f3779f;
        Object obj = objArr[iM2826d];
        objArr[iM2826d] = null;
        this.f3780g--;
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int iM2826d;
        AbstractC1766e.m3920e("elements", collection);
        boolean z3 = false;
        z3 = false;
        z3 = false;
        if (!isEmpty() && this.f3779f.length != 0) {
            int iM2826d2 = m2826d(this.f3778e + this.f3780g);
            int i3 = this.f3778e;
            if (i3 < iM2826d2) {
                iM2826d = i3;
                while (i3 < iM2826d2) {
                    Object obj = this.f3779f[i3];
                    if (collection.contains(obj)) {
                        this.f3779f[iM2826d] = obj;
                        iM2826d++;
                    } else {
                        z3 = true;
                    }
                    i3++;
                }
                Object[] objArr = this.f3779f;
                AbstractC1766e.m3920e("<this>", objArr);
                Arrays.fill(objArr, iM2826d, iM2826d2, (Object) null);
            } else {
                int length = this.f3779f.length;
                boolean z4 = false;
                int i4 = i3;
                while (i3 < length) {
                    Object[] objArr2 = this.f3779f;
                    Object obj2 = objArr2[i3];
                    objArr2[i3] = null;
                    if (collection.contains(obj2)) {
                        this.f3779f[i4] = obj2;
                        i4++;
                    } else {
                        z4 = true;
                    }
                    i3++;
                }
                iM2826d = m2826d(i4);
                for (int i5 = 0; i5 < iM2826d2; i5++) {
                    Object[] objArr3 = this.f3779f;
                    Object obj3 = objArr3[i5];
                    objArr3[i5] = null;
                    if (collection.contains(obj3)) {
                        this.f3779f[iM2826d] = obj3;
                        iM2826d = m2825c(iM2826d);
                    } else {
                        z4 = true;
                    }
                }
                z3 = z4;
            }
            if (z3) {
                int length2 = iM2826d - this.f3778e;
                if (length2 < 0) {
                    length2 += this.f3779f.length;
                }
                this.f3780g = length2;
            }
        }
        return z3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i3, Object obj) {
        int i4 = this.f3780g;
        if (i3 < 0 || i3 >= i4) {
            throw new IndexOutOfBoundsException("index: " + i3 + ", size: " + i4);
        }
        int iM2826d = m2826d(this.f3778e + i3);
        Object[] objArr = this.f3779f;
        Object obj2 = objArr[iM2826d];
        objArr[iM2826d] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3780g;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[this.f3780g]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        AbstractC1766e.m3920e("array", objArr);
        int length = objArr.length;
        int i3 = this.f3780g;
        if (length < i3) {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i3);
            AbstractC1766e.m3918c("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>", objNewInstance);
            objArr = (Object[]) objNewInstance;
        }
        int iM2826d = m2826d(this.f3778e + this.f3780g);
        int i4 = this.f3778e;
        if (i4 < iM2826d) {
            AbstractC1084c.m2831y(this.f3779f, objArr, 0, i4, iM2826d);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f3779f;
            AbstractC1084c.m2831y(objArr2, objArr, 0, this.f3778e, objArr2.length);
            Object[] objArr3 = this.f3779f;
            AbstractC1084c.m2831y(objArr3, objArr, objArr3.length - this.f3778e, 0, iM2826d);
        }
        int i5 = this.f3780g;
        if (i5 < objArr.length) {
            objArr[i5] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        AbstractC1766e.m3920e("elements", collection);
        if (collection.isEmpty()) {
            return false;
        }
        m2824b(collection.size() + this.f3780g);
        m2823a(m2826d(this.f3778e + this.f3780g), collection);
        return true;
    }
}
