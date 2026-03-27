package p073Z;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import p005B.AbstractC0032g;
import p029J.C0365r;

/* JADX INFO: renamed from: Z.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0796i extends AbstractC0760F {

    /* JADX INFO: renamed from: s */
    public static TimeInterpolator f2295s;

    /* JADX INFO: renamed from: g */
    public boolean f2296g;

    /* JADX INFO: renamed from: h */
    public ArrayList f2297h;

    /* JADX INFO: renamed from: i */
    public ArrayList f2298i;

    /* JADX INFO: renamed from: j */
    public ArrayList f2299j;

    /* JADX INFO: renamed from: k */
    public ArrayList f2300k;

    /* JADX INFO: renamed from: l */
    public ArrayList f2301l;

    /* JADX INFO: renamed from: m */
    public ArrayList f2302m;

    /* JADX INFO: renamed from: n */
    public ArrayList f2303n;

    /* JADX INFO: renamed from: o */
    public ArrayList f2304o;

    /* JADX INFO: renamed from: p */
    public ArrayList f2305p;

    /* JADX INFO: renamed from: q */
    public ArrayList f2306q;

    /* JADX INFO: renamed from: r */
    public ArrayList f2307r;

    /* JADX INFO: renamed from: i */
    public static void m2085i(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((AbstractC0777X) arrayList.get(size)).f2202a.animate().cancel();
        }
    }

    @Override // p073Z.AbstractC0760F
    /* JADX INFO: renamed from: a */
    public final boolean mo1950a(AbstractC0777X abstractC0777X, AbstractC0777X abstractC0777X2, C0365r c0365r, C0365r c0365r2) {
        int i3;
        int i4;
        int i5 = c0365r.f875a;
        int i6 = c0365r.f876b;
        if (abstractC0777X2.m2065p()) {
            int i7 = c0365r.f875a;
            i4 = c0365r.f876b;
            i3 = i7;
        } else {
            i3 = c0365r2.f875a;
            i4 = c0365r2.f876b;
        }
        if (abstractC0777X == abstractC0777X2) {
            return m2086h(abstractC0777X, i5, i6, i3, i4);
        }
        View view = abstractC0777X.f2202a;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        float alpha = view.getAlpha();
        m2090m(abstractC0777X);
        view.setTranslationX(translationX);
        view.setTranslationY(translationY);
        view.setAlpha(alpha);
        m2090m(abstractC0777X2);
        float f3 = -((int) ((i3 - i5) - translationX));
        View view2 = abstractC0777X2.f2202a;
        view2.setTranslationX(f3);
        view2.setTranslationY(-((int) ((i4 - i6) - translationY)));
        view2.setAlpha(0.0f);
        ArrayList arrayList = this.f2300k;
        C0792g c0792g = new C0792g();
        c0792g.f2279a = abstractC0777X;
        c0792g.f2280b = abstractC0777X2;
        c0792g.f2281c = i5;
        c0792g.f2282d = i6;
        c0792g.f2283e = i3;
        c0792g.f2284f = i4;
        arrayList.add(c0792g);
        return true;
    }

    @Override // p073Z.AbstractC0760F
    /* JADX INFO: renamed from: e */
    public final void mo1953e(AbstractC0777X abstractC0777X) {
        View view = abstractC0777X.f2202a;
        view.animate().cancel();
        ArrayList arrayList = this.f2299j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((C0794h) arrayList.get(size)).f2290a == abstractC0777X) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                m1952d(abstractC0777X);
                arrayList.remove(size);
            }
        }
        m2088k(this.f2300k, abstractC0777X);
        if (this.f2297h.remove(abstractC0777X)) {
            view.setAlpha(1.0f);
            m1952d(abstractC0777X);
        }
        if (this.f2298i.remove(abstractC0777X)) {
            view.setAlpha(1.0f);
            m1951c(abstractC0777X);
        }
        ArrayList arrayList2 = this.f2303n;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList3 = (ArrayList) arrayList2.get(size2);
            m2088k(arrayList3, abstractC0777X);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList arrayList4 = this.f2302m;
        for (int size3 = arrayList4.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList5 = (ArrayList) arrayList4.get(size3);
            int size4 = arrayList5.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((C0794h) arrayList5.get(size4)).f2290a == abstractC0777X) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    m1952d(abstractC0777X);
                    arrayList5.remove(size4);
                    if (arrayList5.isEmpty()) {
                        arrayList4.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        ArrayList arrayList6 = this.f2301l;
        for (int size5 = arrayList6.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList7 = (ArrayList) arrayList6.get(size5);
            if (arrayList7.remove(abstractC0777X)) {
                view.setAlpha(1.0f);
                m1951c(abstractC0777X);
                if (arrayList7.isEmpty()) {
                    arrayList6.remove(size5);
                }
            }
        }
        this.f2306q.remove(abstractC0777X);
        this.f2304o.remove(abstractC0777X);
        this.f2307r.remove(abstractC0777X);
        this.f2305p.remove(abstractC0777X);
        m2087j();
    }

    @Override // p073Z.AbstractC0760F
    /* JADX INFO: renamed from: f */
    public final void mo1954f() {
        ArrayList arrayList = this.f2299j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            C0794h c0794h = (C0794h) arrayList.get(size);
            View view = c0794h.f2290a.f2202a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            m1952d(c0794h.f2290a);
            arrayList.remove(size);
        }
        ArrayList arrayList2 = this.f2297h;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            m1952d((AbstractC0777X) arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList arrayList3 = this.f2298i;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            AbstractC0777X abstractC0777X = (AbstractC0777X) arrayList3.get(size3);
            abstractC0777X.f2202a.setAlpha(1.0f);
            m1952d(abstractC0777X);
            arrayList3.remove(size3);
        }
        ArrayList arrayList4 = this.f2300k;
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            C0792g c0792g = (C0792g) arrayList4.get(size4);
            AbstractC0777X abstractC0777X2 = c0792g.f2279a;
            if (abstractC0777X2 != null) {
                m2089l(c0792g, abstractC0777X2);
            }
            AbstractC0777X abstractC0777X3 = c0792g.f2280b;
            if (abstractC0777X3 != null) {
                m2089l(c0792g, abstractC0777X3);
            }
        }
        arrayList4.clear();
        if (mo1955g()) {
            ArrayList arrayList5 = this.f2302m;
            for (int size5 = arrayList5.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList6 = (ArrayList) arrayList5.get(size5);
                for (int size6 = arrayList6.size() - 1; size6 >= 0; size6--) {
                    C0794h c0794h2 = (C0794h) arrayList6.get(size6);
                    View view2 = c0794h2.f2290a.f2202a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    m1952d(c0794h2.f2290a);
                    arrayList6.remove(size6);
                    if (arrayList6.isEmpty()) {
                        arrayList5.remove(arrayList6);
                    }
                }
            }
            ArrayList arrayList7 = this.f2301l;
            for (int size7 = arrayList7.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList8 = (ArrayList) arrayList7.get(size7);
                for (int size8 = arrayList8.size() - 1; size8 >= 0; size8--) {
                    AbstractC0777X abstractC0777X4 = (AbstractC0777X) arrayList8.get(size8);
                    abstractC0777X4.f2202a.setAlpha(1.0f);
                    m1952d(abstractC0777X4);
                    arrayList8.remove(size8);
                    if (arrayList8.isEmpty()) {
                        arrayList7.remove(arrayList8);
                    }
                }
            }
            ArrayList arrayList9 = this.f2303n;
            for (int size9 = arrayList9.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList10 = (ArrayList) arrayList9.get(size9);
                for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                    C0792g c0792g2 = (C0792g) arrayList10.get(size10);
                    AbstractC0777X abstractC0777X5 = c0792g2.f2279a;
                    if (abstractC0777X5 != null) {
                        m2089l(c0792g2, abstractC0777X5);
                    }
                    AbstractC0777X abstractC0777X6 = c0792g2.f2280b;
                    if (abstractC0777X6 != null) {
                        m2089l(c0792g2, abstractC0777X6);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList9.remove(arrayList10);
                    }
                }
            }
            m2085i(this.f2306q);
            m2085i(this.f2305p);
            m2085i(this.f2304o);
            m2085i(this.f2307r);
            ArrayList arrayList11 = this.f2130b;
            if (arrayList11.size() > 0) {
                AbstractC0032g.m162t(arrayList11.get(0));
                throw null;
            }
            arrayList11.clear();
        }
    }

    @Override // p073Z.AbstractC0760F
    /* JADX INFO: renamed from: g */
    public final boolean mo1955g() {
        return (this.f2298i.isEmpty() && this.f2300k.isEmpty() && this.f2299j.isEmpty() && this.f2297h.isEmpty() && this.f2305p.isEmpty() && this.f2306q.isEmpty() && this.f2304o.isEmpty() && this.f2307r.isEmpty() && this.f2302m.isEmpty() && this.f2301l.isEmpty() && this.f2303n.isEmpty()) ? false : true;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m2086h(AbstractC0777X abstractC0777X, int i3, int i4, int i5, int i6) {
        View view = abstractC0777X.f2202a;
        int translationX = i3 + ((int) view.getTranslationX());
        int translationY = i4 + ((int) abstractC0777X.f2202a.getTranslationY());
        m2090m(abstractC0777X);
        int i7 = i5 - translationX;
        int i8 = i6 - translationY;
        if (i7 == 0 && i8 == 0) {
            m1952d(abstractC0777X);
            return false;
        }
        if (i7 != 0) {
            view.setTranslationX(-i7);
        }
        if (i8 != 0) {
            view.setTranslationY(-i8);
        }
        ArrayList arrayList = this.f2299j;
        C0794h c0794h = new C0794h();
        c0794h.f2290a = abstractC0777X;
        c0794h.f2291b = translationX;
        c0794h.f2292c = translationY;
        c0794h.f2293d = i5;
        c0794h.f2294e = i6;
        arrayList.add(c0794h);
        return true;
    }

    /* JADX INFO: renamed from: j */
    public final void m2087j() {
        if (mo1955g()) {
            return;
        }
        ArrayList arrayList = this.f2130b;
        if (arrayList.size() <= 0) {
            arrayList.clear();
        } else {
            AbstractC0032g.m162t(arrayList.get(0));
            throw null;
        }
    }

    /* JADX INFO: renamed from: k */
    public final void m2088k(List list, AbstractC0777X abstractC0777X) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C0792g c0792g = (C0792g) list.get(size);
            if (m2089l(c0792g, abstractC0777X) && c0792g.f2279a == null && c0792g.f2280b == null) {
                list.remove(c0792g);
            }
        }
    }

    /* JADX INFO: renamed from: l */
    public final boolean m2089l(C0792g c0792g, AbstractC0777X abstractC0777X) {
        if (c0792g.f2280b == abstractC0777X) {
            c0792g.f2280b = null;
        } else {
            if (c0792g.f2279a != abstractC0777X) {
                return false;
            }
            c0792g.f2279a = null;
        }
        abstractC0777X.f2202a.setAlpha(1.0f);
        View view = abstractC0777X.f2202a;
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        m1952d(abstractC0777X);
        return true;
    }

    /* JADX INFO: renamed from: m */
    public final void m2090m(AbstractC0777X abstractC0777X) {
        if (f2295s == null) {
            f2295s = new ValueAnimator().getInterpolator();
        }
        abstractC0777X.f2202a.animate().setInterpolator(f2295s);
        mo1953e(abstractC0777X);
    }
}
