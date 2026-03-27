package p049Q;

import android.graphics.Rect;
import java.util.Comparator;
import p019F0.C0217a;
import p032K.C0391i;

/* JADX INFO: renamed from: Q.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0585c implements Comparator {

    /* JADX INFO: renamed from: a */
    public final Rect f1471a = new Rect();

    /* JADX INFO: renamed from: b */
    public final Rect f1472b = new Rect();

    /* JADX INFO: renamed from: c */
    public final boolean f1473c;

    /* JADX INFO: renamed from: d */
    public final C0217a f1474d;

    public C0585c(boolean z3, C0217a c0217a) {
        this.f1473c = z3;
        this.f1474d = c0217a;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        this.f1474d.getClass();
        Rect rect = this.f1471a;
        ((C0391i) obj).m871d(rect);
        Rect rect2 = this.f1472b;
        ((C0391i) obj2).m871d(rect2);
        int i3 = rect.top;
        int i4 = rect2.top;
        if (i3 < i4) {
            return -1;
        }
        if (i3 > i4) {
            return 1;
        }
        int i5 = rect.left;
        int i6 = rect2.left;
        boolean z3 = this.f1473c;
        if (i5 < i6) {
            return z3 ? 1 : -1;
        }
        if (i5 > i6) {
            return z3 ? -1 : 1;
        }
        int i7 = rect.bottom;
        int i8 = rect2.bottom;
        if (i7 < i8) {
            return -1;
        }
        if (i7 > i8) {
            return 1;
        }
        int i9 = rect.right;
        int i10 = rect2.right;
        if (i9 < i10) {
            return z3 ? 1 : -1;
        }
        if (i9 > i10) {
            return z3 ? -1 : 1;
        }
        return 0;
    }
}
