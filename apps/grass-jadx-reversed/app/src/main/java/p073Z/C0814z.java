package p073Z;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import p029J.C0365r;

/* JADX INFO: renamed from: Z.z */
/* JADX INFO: loaded from: classes.dex */
public final class C0814z {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ RecyclerView f2417a;

    public /* synthetic */ C0814z(RecyclerView recyclerView) {
        this.f2417a = recyclerView;
    }

    /* JADX INFO: renamed from: a */
    public void m2135a(C0780a c0780a) {
        int i3 = c0780a.f2224a;
        RecyclerView recyclerView = this.f2417a;
        if (i3 == 1) {
            recyclerView.f3434p.mo1978R(c0780a.f2225b, c0780a.f2227d);
            return;
        }
        if (i3 == 2) {
            recyclerView.f3434p.mo1981U(c0780a.f2225b, c0780a.f2227d);
        } else if (i3 == 4) {
            recyclerView.f3434p.mo1982V(c0780a.f2225b, c0780a.f2227d);
        } else {
            if (i3 != 8) {
                return;
            }
            recyclerView.f3434p.mo1980T(c0780a.f2225b, c0780a.f2227d);
        }
    }

    /* JADX INFO: renamed from: b */
    public AbstractC0777X m2136b(int i3) {
        RecyclerView recyclerView = this.f2417a;
        int iM2855l = recyclerView.f3420i.m2855l();
        int i4 = 0;
        AbstractC0777X abstractC0777X = null;
        while (true) {
            if (i4 >= iM2855l) {
                break;
            }
            AbstractC0777X abstractC0777XM2571I = RecyclerView.m2571I(recyclerView.f3420i.m2854k(i4));
            if (abstractC0777XM2571I != null && !abstractC0777XM2571I.m2058i() && abstractC0777XM2571I.f2204c == i3) {
                if (!recyclerView.f3420i.m2857n(abstractC0777XM2571I.f2202a)) {
                    abstractC0777X = abstractC0777XM2571I;
                    break;
                }
                abstractC0777X = abstractC0777XM2571I;
            }
            i4++;
        }
        if (abstractC0777X == null || recyclerView.f3420i.m2857n(abstractC0777X.f2202a)) {
            return null;
        }
        return abstractC0777X;
    }

    /* JADX INFO: renamed from: c */
    public void m2137c(int i3, int i4) {
        int i5;
        int i6;
        RecyclerView recyclerView = this.f2417a;
        int iM2855l = recyclerView.f3420i.m2855l();
        int i7 = i4 + i3;
        for (int i8 = 0; i8 < iM2855l; i8++) {
            View viewM2854k = recyclerView.f3420i.m2854k(i8);
            AbstractC0777X abstractC0777XM2571I = RecyclerView.m2571I(viewM2854k);
            if (abstractC0777XM2571I != null && !abstractC0777XM2571I.m2065p() && (i6 = abstractC0777XM2571I.f2204c) >= i3 && i6 < i7) {
                abstractC0777XM2571I.m2050a(2);
                abstractC0777XM2571I.m2050a(1024);
                ((C0764J) viewM2854k.getLayoutParams()).f2156c = true;
            }
        }
        C0769O c0769o = recyclerView.f3414f;
        ArrayList arrayList = c0769o.f2166c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            AbstractC0777X abstractC0777X = (AbstractC0777X) arrayList.get(size);
            if (abstractC0777X != null && (i5 = abstractC0777X.f2204c) >= i3 && i5 < i7) {
                abstractC0777X.m2050a(2);
                c0769o.m2037e(size);
            }
        }
        recyclerView.f3425k0 = true;
    }

    /* JADX INFO: renamed from: d */
    public void m2138d(int i3, int i4) {
        RecyclerView recyclerView = this.f2417a;
        int iM2855l = recyclerView.f3420i.m2855l();
        for (int i5 = 0; i5 < iM2855l; i5++) {
            AbstractC0777X abstractC0777XM2571I = RecyclerView.m2571I(recyclerView.f3420i.m2854k(i5));
            if (abstractC0777XM2571I != null && !abstractC0777XM2571I.m2065p() && abstractC0777XM2571I.f2204c >= i3) {
                abstractC0777XM2571I.m2062m(i4, false);
                recyclerView.f3417g0.f2185f = true;
            }
        }
        ArrayList arrayList = recyclerView.f3414f.f2166c;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            AbstractC0777X abstractC0777X = (AbstractC0777X) arrayList.get(i6);
            if (abstractC0777X != null && abstractC0777X.f2204c >= i3) {
                abstractC0777X.m2062m(i4, true);
            }
        }
        recyclerView.requestLayout();
        recyclerView.f3423j0 = true;
    }

    /* JADX INFO: renamed from: e */
    public void m2139e(int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        RecyclerView recyclerView = this.f2417a;
        int iM2855l = recyclerView.f3420i.m2855l();
        int i12 = -1;
        if (i3 < i4) {
            i6 = i3;
            i5 = i4;
            i7 = -1;
        } else {
            i5 = i3;
            i6 = i4;
            i7 = 1;
        }
        for (int i13 = 0; i13 < iM2855l; i13++) {
            AbstractC0777X abstractC0777XM2571I = RecyclerView.m2571I(recyclerView.f3420i.m2854k(i13));
            if (abstractC0777XM2571I != null && (i11 = abstractC0777XM2571I.f2204c) >= i6 && i11 <= i5) {
                if (i11 == i3) {
                    abstractC0777XM2571I.m2062m(i4 - i3, false);
                } else {
                    abstractC0777XM2571I.m2062m(i7, false);
                }
                recyclerView.f3417g0.f2185f = true;
            }
        }
        C0769O c0769o = recyclerView.f3414f;
        c0769o.getClass();
        if (i3 < i4) {
            i9 = i3;
            i8 = i4;
        } else {
            i8 = i3;
            i9 = i4;
            i12 = 1;
        }
        ArrayList arrayList = c0769o.f2166c;
        int size = arrayList.size();
        for (int i14 = 0; i14 < size; i14++) {
            AbstractC0777X abstractC0777X = (AbstractC0777X) arrayList.get(i14);
            if (abstractC0777X != null && (i10 = abstractC0777X.f2204c) >= i9 && i10 <= i8) {
                if (i10 == i3) {
                    abstractC0777X.m2062m(i4 - i3, false);
                } else {
                    abstractC0777X.m2062m(i12, false);
                }
            }
        }
        recyclerView.requestLayout();
        recyclerView.f3423j0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2140f(p073Z.AbstractC0777X r9, p029J.C0365r r10, p029J.C0365r r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r8.f2417a
            r0.getClass()
            r1 = 0
            r9.m2064o(r1)
            Z.F r1 = r0.f3396L
            r2 = r1
            Z.i r2 = (p073Z.C0796i) r2
            if (r10 == 0) goto L29
            r2.getClass()
            int r4 = r10.f875a
            int r6 = r11.f875a
            if (r4 != r6) goto L1f
            int r1 = r10.f876b
            int r3 = r11.f876b
            if (r1 == r3) goto L29
        L1f:
            int r5 = r10.f876b
            int r7 = r11.f876b
            r3 = r9
            boolean r9 = r2.m2086h(r3, r4, r5, r6, r7)
            goto L38
        L29:
            r2.m2090m(r9)
            android.view.View r10 = r9.f2202a
            r11 = 0
            r10.setAlpha(r11)
            java.util.ArrayList r10 = r2.f2298i
            r10.add(r9)
            r9 = 1
        L38:
            if (r9 == 0) goto L3d
            r0.m2593S()
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p073Z.C0814z.m2140f(Z.X, J.r, J.r):void");
    }

    /* JADX INFO: renamed from: g */
    public void m2141g(AbstractC0777X abstractC0777X, C0365r c0365r, C0365r c0365r2) {
        boolean zM2086h;
        RecyclerView recyclerView = this.f2417a;
        recyclerView.f3414f.m2042j(abstractC0777X);
        recyclerView.m2606f(abstractC0777X);
        abstractC0777X.m2064o(false);
        C0796i c0796i = (C0796i) recyclerView.f3396L;
        c0796i.getClass();
        int i3 = c0365r.f875a;
        int i4 = c0365r.f876b;
        View view = abstractC0777X.f2202a;
        int left = c0365r2 == null ? view.getLeft() : c0365r2.f875a;
        int top = c0365r2 == null ? view.getTop() : c0365r2.f876b;
        if (abstractC0777X.m2058i() || (i3 == left && i4 == top)) {
            c0796i.m2090m(abstractC0777X);
            c0796i.f2297h.add(abstractC0777X);
            zM2086h = true;
        } else {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            zM2086h = c0796i.m2086h(abstractC0777X, i3, i4, left, top);
        }
        if (zM2086h) {
            recyclerView.m2593S();
        }
    }
}
