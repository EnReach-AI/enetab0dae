package p073Z;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: Z.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0798j extends AbstractC0766L {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C0800l f2312a;

    public C0798j(C0800l c0800l) {
        this.f2312a = c0800l;
    }

    @Override // p073Z.AbstractC0766L
    /* JADX INFO: renamed from: b */
    public final void mo2031b(RecyclerView recyclerView, int i3, int i4) {
        int iComputeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
        int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        C0800l c0800l = this.f2312a;
        int iComputeVerticalScrollRange = c0800l.f2338s.computeVerticalScrollRange();
        int i5 = c0800l.f2337r;
        int i6 = iComputeVerticalScrollRange - i5;
        int i7 = c0800l.f2320a;
        c0800l.f2339t = i6 > 0 && i5 >= i7;
        int iComputeHorizontalScrollRange = c0800l.f2338s.computeHorizontalScrollRange();
        int i8 = c0800l.f2336q;
        boolean z3 = iComputeHorizontalScrollRange - i8 > 0 && i8 >= i7;
        c0800l.f2340u = z3;
        boolean z4 = c0800l.f2339t;
        if (!z4 && !z3) {
            if (c0800l.f2341v != 0) {
                c0800l.m2095f(0);
                return;
            }
            return;
        }
        if (z4) {
            float f3 = i5;
            c0800l.f2331l = (int) ((((f3 / 2.0f) + iComputeVerticalScrollOffset) * f3) / iComputeVerticalScrollRange);
            c0800l.f2330k = Math.min(i5, (i5 * i5) / iComputeVerticalScrollRange);
        }
        if (c0800l.f2340u) {
            float f4 = iComputeHorizontalScrollOffset;
            float f5 = i8;
            c0800l.f2334o = (int) ((((f5 / 2.0f) + f4) * f5) / iComputeHorizontalScrollRange);
            c0800l.f2333n = Math.min(i8, (i8 * i8) / iComputeHorizontalScrollRange);
        }
        int i9 = c0800l.f2341v;
        if (i9 == 0 || i9 == 1) {
            c0800l.m2095f(1);
        }
    }
}
