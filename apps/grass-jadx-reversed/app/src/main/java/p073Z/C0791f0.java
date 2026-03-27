package p073Z;

import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;

/* JADX INFO: renamed from: Z.f0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0791f0 {

    /* JADX INFO: renamed from: a */
    public final ArrayList f2273a = new ArrayList();

    /* JADX INFO: renamed from: b */
    public int f2274b = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: c */
    public int f2275c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d */
    public int f2276d = 0;

    /* JADX INFO: renamed from: e */
    public final int f2277e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ StaggeredGridLayoutManager f2278f;

    public C0791f0(StaggeredGridLayoutManager staggeredGridLayoutManager, int i3) {
        this.f2278f = staggeredGridLayoutManager;
        this.f2277e = i3;
    }

    /* JADX INFO: renamed from: a */
    public final void m2076a() {
        View view = (View) this.f2273a.get(r0.size() - 1);
        C0785c0 c0785c0 = (C0785c0) view.getLayoutParams();
        this.f2275c = this.f2278f.f3465r.mo2113b(view);
        c0785c0.getClass();
    }

    /* JADX INFO: renamed from: b */
    public final void m2077b() {
        this.f2273a.clear();
        this.f2274b = Integer.MIN_VALUE;
        this.f2275c = Integer.MIN_VALUE;
        this.f2276d = 0;
    }

    /* JADX INFO: renamed from: c */
    public final int m2078c() {
        return this.f2278f.f3470w ? m2080e(r1.size() - 1, -1) : m2080e(0, this.f2273a.size());
    }

    /* JADX INFO: renamed from: d */
    public final int m2079d() {
        return this.f2278f.f3470w ? m2080e(0, this.f2273a.size()) : m2080e(r1.size() - 1, -1);
    }

    /* JADX INFO: renamed from: e */
    public final int m2080e(int i3, int i4) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f2278f;
        int iMo2122k = staggeredGridLayoutManager.f3465r.mo2122k();
        int iMo2118g = staggeredGridLayoutManager.f3465r.mo2118g();
        int i5 = i4 > i3 ? 1 : -1;
        while (i3 != i4) {
            View view = (View) this.f2273a.get(i3);
            int iMo2116e = staggeredGridLayoutManager.f3465r.mo2116e(view);
            int iMo2113b = staggeredGridLayoutManager.f3465r.mo2113b(view);
            boolean z3 = iMo2116e <= iMo2118g;
            boolean z4 = iMo2113b >= iMo2122k;
            if (z3 && z4 && (iMo2116e < iMo2122k || iMo2113b > iMo2118g)) {
                return AbstractC0763I.m1958D(view);
            }
            i3 += i5;
        }
        return -1;
    }

    /* JADX INFO: renamed from: f */
    public final int m2081f(int i3) {
        int i4 = this.f2275c;
        if (i4 != Integer.MIN_VALUE) {
            return i4;
        }
        if (this.f2273a.size() == 0) {
            return i3;
        }
        m2076a();
        return this.f2275c;
    }

    /* JADX INFO: renamed from: g */
    public final View m2082g(int i3, int i4) {
        ArrayList arrayList = this.f2273a;
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f2278f;
        View view = null;
        if (i4 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.f3470w && AbstractC0763I.m1958D(view2) >= i3) || ((!staggeredGridLayoutManager.f3470w && AbstractC0763I.m1958D(view2) <= i3) || !view2.hasFocusable())) {
                    break;
                }
                size--;
                view = view2;
            }
        } else {
            int size2 = arrayList.size();
            int i5 = 0;
            while (i5 < size2) {
                View view3 = (View) arrayList.get(i5);
                if ((staggeredGridLayoutManager.f3470w && AbstractC0763I.m1958D(view3) <= i3) || ((!staggeredGridLayoutManager.f3470w && AbstractC0763I.m1958D(view3) >= i3) || !view3.hasFocusable())) {
                    break;
                }
                i5++;
                view = view3;
            }
        }
        return view;
    }

    /* JADX INFO: renamed from: h */
    public final int m2083h(int i3) {
        int i4 = this.f2274b;
        if (i4 != Integer.MIN_VALUE) {
            return i4;
        }
        if (this.f2273a.size() == 0) {
            return i3;
        }
        View view = (View) this.f2273a.get(0);
        C0785c0 c0785c0 = (C0785c0) view.getLayoutParams();
        this.f2274b = this.f2278f.f3465r.mo2116e(view);
        c0785c0.getClass();
        return this.f2274b;
    }
}
