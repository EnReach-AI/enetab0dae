package p073Z;

import android.view.View;
import java.util.List;

/* JADX INFO: renamed from: Z.s */
/* JADX INFO: loaded from: classes.dex */
public final class C0807s {

    /* JADX INFO: renamed from: a */
    public boolean f2377a;

    /* JADX INFO: renamed from: b */
    public int f2378b;

    /* JADX INFO: renamed from: c */
    public int f2379c;

    /* JADX INFO: renamed from: d */
    public int f2380d;

    /* JADX INFO: renamed from: e */
    public int f2381e;

    /* JADX INFO: renamed from: f */
    public int f2382f;

    /* JADX INFO: renamed from: g */
    public int f2383g;

    /* JADX INFO: renamed from: h */
    public int f2384h;

    /* JADX INFO: renamed from: i */
    public int f2385i;

    /* JADX INFO: renamed from: j */
    public int f2386j;

    /* JADX INFO: renamed from: k */
    public List f2387k;

    /* JADX INFO: renamed from: l */
    public boolean f2388l;

    /* JADX INFO: renamed from: a */
    public final void m2104a(View view) {
        int iM2051b;
        int size = this.f2387k.size();
        View view2 = null;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < size; i4++) {
            View view3 = ((AbstractC0777X) this.f2387k.get(i4)).f2202a;
            C0764J c0764j = (C0764J) view3.getLayoutParams();
            if (view3 != view && !c0764j.f2154a.m2058i() && (iM2051b = (c0764j.f2154a.m2051b() - this.f2380d) * this.f2381e) >= 0 && iM2051b < i3) {
                view2 = view3;
                if (iM2051b == 0) {
                    break;
                } else {
                    i3 = iM2051b;
                }
            }
        }
        if (view2 == null) {
            this.f2380d = -1;
        } else {
            this.f2380d = ((C0764J) view2.getLayoutParams()).f2154a.m2051b();
        }
    }

    /* JADX INFO: renamed from: b */
    public final View m2105b(C0769O c0769o) {
        List list = this.f2387k;
        if (list == null) {
            View view = c0769o.m2041i(this.f2380d, Long.MAX_VALUE).f2202a;
            this.f2380d += this.f2381e;
            return view;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = ((AbstractC0777X) this.f2387k.get(i3)).f2202a;
            C0764J c0764j = (C0764J) view2.getLayoutParams();
            if (!c0764j.f2154a.m2058i() && this.f2380d == c0764j.f2154a.m2051b()) {
                m2104a(view2);
                return view2;
            }
        }
        return null;
    }
}
