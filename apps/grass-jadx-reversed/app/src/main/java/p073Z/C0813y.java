package p073Z;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: Z.y */
/* JADX INFO: loaded from: classes.dex */
public final class C0813y extends AbstractC0765K {

    /* JADX INFO: renamed from: a */
    public RecyclerView f2413a;

    /* JADX INFO: renamed from: b */
    public final C0781a0 f2414b = new C0781a0(this);

    /* JADX INFO: renamed from: c */
    public C0810v f2415c;

    /* JADX INFO: renamed from: d */
    public C0810v f2416d;

    /* JADX INFO: renamed from: b */
    public static int m2129b(View view, AbstractC0811w abstractC0811w) {
        return ((abstractC0811w.mo2114c(view) / 2) + abstractC0811w.mo2116e(view)) - ((abstractC0811w.mo2123l() / 2) + abstractC0811w.mo2122k());
    }

    /* JADX INFO: renamed from: c */
    public static View m2130c(AbstractC0763I abstractC0763I, AbstractC0811w abstractC0811w) {
        int iM2027v = abstractC0763I.m2027v();
        View view = null;
        if (iM2027v == 0) {
            return null;
        }
        int iMo2123l = (abstractC0811w.mo2123l() / 2) + abstractC0811w.mo2122k();
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < iM2027v; i4++) {
            View viewM2025u = abstractC0763I.m2025u(i4);
            int iAbs = Math.abs(((abstractC0811w.mo2114c(viewM2025u) / 2) + abstractC0811w.mo2116e(viewM2025u)) - iMo2123l);
            if (iAbs < i3) {
                view = viewM2025u;
                i3 = iAbs;
            }
        }
        return view;
    }

    /* JADX INFO: renamed from: a */
    public final int[] m2131a(AbstractC0763I abstractC0763I, View view) {
        int[] iArr = new int[2];
        if (abstractC0763I.mo1992d()) {
            iArr[0] = m2129b(view, m2132d(abstractC0763I));
        } else {
            iArr[0] = 0;
        }
        if (abstractC0763I.mo1994e()) {
            iArr[1] = m2129b(view, m2133e(abstractC0763I));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* JADX INFO: renamed from: d */
    public final AbstractC0811w m2132d(AbstractC0763I abstractC0763I) {
        C0810v c0810v = this.f2416d;
        if (c0810v == null || ((AbstractC0763I) c0810v.f2410b) != abstractC0763I) {
            this.f2416d = new C0810v(abstractC0763I, 0);
        }
        return this.f2416d;
    }

    /* JADX INFO: renamed from: e */
    public final AbstractC0811w m2133e(AbstractC0763I abstractC0763I) {
        C0810v c0810v = this.f2415c;
        if (c0810v == null || ((AbstractC0763I) c0810v.f2410b) != abstractC0763I) {
            this.f2415c = new C0810v(abstractC0763I, 1);
        }
        return this.f2415c;
    }

    /* JADX INFO: renamed from: f */
    public final void m2134f() {
        AbstractC0763I layoutManager;
        RecyclerView recyclerView = this.f2413a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return;
        }
        View viewM2130c = layoutManager.mo1994e() ? m2130c(layoutManager, m2133e(layoutManager)) : layoutManager.mo1992d() ? m2130c(layoutManager, m2132d(layoutManager)) : null;
        if (viewM2130c == null) {
            return;
        }
        int[] iArrM2131a = m2131a(layoutManager, viewM2130c);
        int i3 = iArrM2131a[0];
        if (i3 == 0 && iArrM2131a[1] == 0) {
            return;
        }
        this.f2413a.m2602b0(i3, iArrM2131a[1], false);
    }
}
