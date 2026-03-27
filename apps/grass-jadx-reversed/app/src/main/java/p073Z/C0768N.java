package p073Z;

import android.util.SparseArray;

/* JADX INFO: renamed from: Z.N */
/* JADX INFO: loaded from: classes.dex */
public final class C0768N {

    /* JADX INFO: renamed from: a */
    public SparseArray f2162a;

    /* JADX INFO: renamed from: b */
    public int f2163b;

    /* JADX INFO: renamed from: a */
    public final C0767M m2032a(int i3) {
        SparseArray sparseArray = this.f2162a;
        C0767M c0767m = (C0767M) sparseArray.get(i3);
        if (c0767m != null) {
            return c0767m;
        }
        C0767M c0767m2 = new C0767M();
        sparseArray.put(i3, c0767m2);
        return c0767m2;
    }
}
