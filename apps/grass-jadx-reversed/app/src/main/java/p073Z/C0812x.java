package p073Z;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: renamed from: Z.x */
/* JADX INFO: loaded from: classes.dex */
public final class C0812x extends C0809u {

    /* JADX INFO: renamed from: q */
    public final /* synthetic */ C0813y f2412q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0812x(C0813y c0813y, Context context) {
        super(context);
        this.f2412q = c0813y;
    }

    @Override // p073Z.C0809u
    /* JADX INFO: renamed from: b */
    public final float mo2107b(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // p073Z.C0809u
    /* JADX INFO: renamed from: c */
    public final int mo2108c(int i3) {
        return Math.min(100, super.mo2108c(i3));
    }

    @Override // p073Z.C0809u
    /* JADX INFO: renamed from: f */
    public final void mo2111f(View view, C0772S c0772s) {
        C0813y c0813y = this.f2412q;
        int[] iArrM2131a = c0813y.m2131a(c0813y.f2413a.getLayoutManager(), view);
        int i3 = iArrM2131a[0];
        int i4 = iArrM2131a[1];
        int iCeil = (int) Math.ceil(((double) mo2108c(Math.max(Math.abs(i3), Math.abs(i4)))) / 0.3356d);
        if (iCeil > 0) {
            DecelerateInterpolator decelerateInterpolator = this.f2401j;
            c0772s.f2173a = i3;
            c0772s.f2174b = i4;
            c0772s.f2175c = iCeil;
            c0772s.f2177e = decelerateInterpolator;
            c0772s.f2178f = true;
        }
    }
}
