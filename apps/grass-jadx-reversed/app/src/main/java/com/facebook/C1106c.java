package com.facebook;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import p001A.C0009j;

/* JADX INFO: renamed from: com.facebook.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1106c {

    /* JADX INFO: renamed from: a */
    public int f3841a;

    /* JADX INFO: renamed from: b */
    public Object f3842b;

    /* JADX INFO: renamed from: c */
    public Object f3843c;

    /* JADX INFO: renamed from: d */
    public Serializable f3844d;

    /* JADX INFO: renamed from: a */
    public void m2879a(Object obj, int i3, Object[] objArr, int i4) {
        int i5 = 0;
        for (C0009j c0009j = (C0009j) this.f3842b; c0009j != null; c0009j = (C0009j) c0009j.f31g) {
            Object[] objArr2 = (Object[]) c0009j.f30f;
            int length = objArr2.length;
            System.arraycopy(objArr2, 0, obj, i5, length);
            i5 += length;
        }
        System.arraycopy(objArr, 0, obj, i5, i4);
        int i6 = i5 + i4;
        if (i6 == i3) {
            return;
        }
        throw new IllegalStateException("Should have gotten " + i3 + " entries, got " + i6);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Serializable, java.lang.Object[]] */
    /* JADX INFO: renamed from: b */
    public void m2880b() {
        C0009j c0009j = (C0009j) this.f3843c;
        if (c0009j != null) {
            this.f3844d = (Object[]) c0009j.f30f;
        }
        this.f3843c = null;
        this.f3842b = null;
        this.f3841a = 0;
    }

    /* JADX INFO: renamed from: c */
    public Object[] m2881c(Object[] objArr) {
        C0009j c0009j = new C0009j(objArr, 25, (Object) null);
        if (((C0009j) this.f3842b) == null) {
            this.f3843c = c0009j;
            this.f3842b = c0009j;
        } else {
            C0009j c0009j2 = (C0009j) this.f3843c;
            if (((C0009j) c0009j2.f31g) != null) {
                throw new IllegalStateException();
            }
            c0009j2.f31g = c0009j;
            this.f3843c = c0009j;
        }
        int length = objArr.length;
        this.f3841a += length;
        if (length < 16384) {
            length += length;
        } else if (length < 262144) {
            length += length >> 2;
        }
        return new Object[length];
    }

    /* JADX INFO: renamed from: d */
    public void m2882d(Object[] objArr, int i3, ArrayList arrayList) {
        int i4;
        Object obj = this.f3842b;
        while (true) {
            C0009j c0009j = (C0009j) obj;
            i4 = 0;
            if (c0009j == null) {
                break;
            }
            Object[] objArr2 = (Object[]) c0009j.f30f;
            int length = objArr2.length;
            while (i4 < length) {
                arrayList.add(objArr2[i4]);
                i4++;
            }
            obj = c0009j.f31g;
        }
        while (i4 < i3) {
            arrayList.add(objArr[i4]);
            i4++;
        }
        m2880b();
    }

    /* JADX INFO: renamed from: e */
    public Object[] m2883e(Object[] objArr, int i3) {
        int i4 = this.f3841a + i3;
        Object[] objArr2 = new Object[i4];
        m2879a(objArr2, i4, objArr, i3);
        m2880b();
        return objArr2;
    }

    /* JADX INFO: renamed from: f */
    public Object[] m2884f(Object[] objArr, int i3, Class cls) {
        int i4 = this.f3841a + i3;
        Object[] objArr2 = (Object[]) Array.newInstance((Class<?>) cls, i4);
        m2879a(objArr2, i4, objArr, i3);
        m2880b();
        return objArr2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Serializable, java.lang.Object[]] */
    /* JADX INFO: renamed from: g */
    public Object[] m2885g() {
        m2880b();
        Object[] objArr = (Object[]) this.f3844d;
        if (objArr != null) {
            return objArr;
        }
        ?? r02 = new Object[12];
        this.f3844d = r02;
        return r02;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Serializable, java.lang.Object[]] */
    /* JADX INFO: renamed from: h */
    public Object[] m2886h(Object[] objArr, int i3) {
        m2880b();
        Object[] objArr2 = (Object[]) this.f3844d;
        if (objArr2 == null || objArr2.length < i3) {
            this.f3844d = new Object[Math.max(12, i3)];
        }
        System.arraycopy(objArr, 0, (Object[]) this.f3844d, 0, i3);
        return (Object[]) this.f3844d;
    }
}
