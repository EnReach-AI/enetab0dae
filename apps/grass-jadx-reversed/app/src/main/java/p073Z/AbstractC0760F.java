package p073Z;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.C1100C;
import java.util.ArrayList;
import p029J.C0365r;

/* JADX INFO: renamed from: Z.F */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0760F {

    /* JADX INFO: renamed from: a */
    public C0755A f2129a;

    /* JADX INFO: renamed from: b */
    public ArrayList f2130b;

    /* JADX INFO: renamed from: c */
    public long f2131c;

    /* JADX INFO: renamed from: d */
    public long f2132d;

    /* JADX INFO: renamed from: e */
    public long f2133e;

    /* JADX INFO: renamed from: f */
    public long f2134f;

    /* JADX INFO: renamed from: b */
    public static void m1949b(AbstractC0777X abstractC0777X) {
        RecyclerView recyclerView;
        int i3 = abstractC0777X.f2211j;
        if (abstractC0777X.m2056g() || (i3 & 4) != 0 || (recyclerView = abstractC0777X.f2219r) == null) {
            return;
        }
        recyclerView.m2581F(abstractC0777X);
    }

    /* JADX INFO: renamed from: a */
    public abstract boolean mo1950a(AbstractC0777X abstractC0777X, AbstractC0777X abstractC0777X2, C0365r c0365r, C0365r c0365r2);

    /* JADX INFO: renamed from: c */
    public void m1951c(AbstractC0777X abstractC0777X) {
        m1952d(abstractC0777X);
    }

    /* JADX INFO: renamed from: d */
    public final void m1952d(AbstractC0777X abstractC0777X) {
        C0755A c0755a = this.f2129a;
        if (c0755a != null) {
            boolean z3 = true;
            abstractC0777X.m2064o(true);
            if (abstractC0777X.f2209h != null && abstractC0777X.f2210i == null) {
                abstractC0777X.f2209h = null;
            }
            abstractC0777X.f2210i = null;
            if ((abstractC0777X.f2211j & 16) != 0) {
                return;
            }
            RecyclerView recyclerView = c0755a.f2126a;
            recyclerView.m2603c0();
            C1100C c1100c = recyclerView.f3420i;
            C0755A c0755a2 = (C0755A) c1100c.f3799f;
            RecyclerView recyclerView2 = c0755a2.f2126a;
            View view = abstractC0777X.f2202a;
            int iIndexOfChild = recyclerView2.indexOfChild(view);
            if (iIndexOfChild == -1) {
                c1100c.m2861s(view);
            } else {
                C0782b c0782b = (C0782b) c1100c.f3800g;
                if (c0782b.m2070d(iIndexOfChild)) {
                    c0782b.m2072f(iIndexOfChild);
                    c1100c.m2861s(view);
                    c0755a2.m1943a(iIndexOfChild);
                } else {
                    z3 = false;
                }
            }
            if (z3) {
                AbstractC0777X abstractC0777XM2571I = RecyclerView.m2571I(view);
                C0769O c0769o = recyclerView.f3414f;
                c0769o.m2042j(abstractC0777XM2571I);
                c0769o.m2039g(abstractC0777XM2571I);
            }
            recyclerView.m2604d0(!z3);
            if (z3 || !abstractC0777X.m2060k()) {
                return;
            }
            recyclerView.removeDetachedView(view, false);
        }
    }

    /* JADX INFO: renamed from: e */
    public abstract void mo1953e(AbstractC0777X abstractC0777X);

    /* JADX INFO: renamed from: f */
    public abstract void mo1954f();

    /* JADX INFO: renamed from: g */
    public abstract boolean mo1955g();
}
