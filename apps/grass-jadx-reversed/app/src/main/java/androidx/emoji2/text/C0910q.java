package androidx.emoji2.text;

import android.util.SparseArray;

/* JADX INFO: renamed from: androidx.emoji2.text.q */
/* JADX INFO: loaded from: classes.dex */
public final class C0910q {

    /* JADX INFO: renamed from: a */
    public final SparseArray f3006a;

    /* JADX INFO: renamed from: b */
    public C0906m f3007b;

    public C0910q(int i3) {
        this.f3006a = new SparseArray(i3);
    }

    /* JADX INFO: renamed from: a */
    public final void m2357a(C0906m c0906m, int i3, int i4) {
        int iM2348a = c0906m.m2348a(i3);
        SparseArray sparseArray = this.f3006a;
        C0910q c0910q = sparseArray == null ? null : (C0910q) sparseArray.get(iM2348a);
        if (c0910q == null) {
            c0910q = new C0910q(1);
            sparseArray.put(c0906m.m2348a(i3), c0910q);
        }
        if (i4 > i3) {
            c0910q.m2357a(c0906m, i3 + 1, i4);
        } else {
            c0910q.f3007b = c0906m;
        }
    }
}
