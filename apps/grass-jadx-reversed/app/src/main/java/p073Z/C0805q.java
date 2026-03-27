package p073Z;

import android.view.View;

/* JADX INFO: renamed from: Z.q */
/* JADX INFO: loaded from: classes.dex */
public final class C0805q {

    /* JADX INFO: renamed from: a */
    public AbstractC0811w f2368a;

    /* JADX INFO: renamed from: b */
    public int f2369b;

    /* JADX INFO: renamed from: c */
    public int f2370c;

    /* JADX INFO: renamed from: d */
    public boolean f2371d;

    /* JADX INFO: renamed from: e */
    public boolean f2372e;

    public C0805q() {
        m2103d();
    }

    /* JADX INFO: renamed from: a */
    public final void m2100a() {
        this.f2370c = this.f2371d ? this.f2368a.mo2118g() : this.f2368a.mo2122k();
    }

    /* JADX INFO: renamed from: b */
    public final void m2101b(View view, int i3) {
        if (this.f2371d) {
            this.f2370c = this.f2368a.m2128m() + this.f2368a.mo2113b(view);
        } else {
            this.f2370c = this.f2368a.mo2116e(view);
        }
        this.f2369b = i3;
    }

    /* JADX INFO: renamed from: c */
    public final void m2102c(View view, int i3) {
        int iM2128m = this.f2368a.m2128m();
        if (iM2128m >= 0) {
            m2101b(view, i3);
            return;
        }
        this.f2369b = i3;
        if (!this.f2371d) {
            int iMo2116e = this.f2368a.mo2116e(view);
            int iMo2122k = iMo2116e - this.f2368a.mo2122k();
            this.f2370c = iMo2116e;
            if (iMo2122k > 0) {
                int iMo2118g = (this.f2368a.mo2118g() - Math.min(0, (this.f2368a.mo2118g() - iM2128m) - this.f2368a.mo2113b(view))) - (this.f2368a.mo2114c(view) + iMo2116e);
                if (iMo2118g < 0) {
                    this.f2370c -= Math.min(iMo2122k, -iMo2118g);
                    return;
                }
                return;
            }
            return;
        }
        int iMo2118g2 = (this.f2368a.mo2118g() - iM2128m) - this.f2368a.mo2113b(view);
        this.f2370c = this.f2368a.mo2118g() - iMo2118g2;
        if (iMo2118g2 > 0) {
            int iMo2114c = this.f2370c - this.f2368a.mo2114c(view);
            int iMo2122k2 = this.f2368a.mo2122k();
            int iMin = iMo2114c - (Math.min(this.f2368a.mo2116e(view) - iMo2122k2, 0) + iMo2122k2);
            if (iMin < 0) {
                this.f2370c = Math.min(iMo2118g2, -iMin) + this.f2370c;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m2103d() {
        this.f2369b = -1;
        this.f2370c = Integer.MIN_VALUE;
        this.f2371d = false;
        this.f2372e = false;
    }

    public final String toString() {
        return "AnchorInfo{mPosition=" + this.f2369b + ", mCoordinate=" + this.f2370c + ", mLayoutFromEnd=" + this.f2371d + ", mValid=" + this.f2372e + '}';
    }
}
