package p087d0;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: renamed from: d0.t */
/* JADX INFO: loaded from: classes.dex */
public final class C1301t extends C1300s {
    @Override // p071Y0.AbstractC0752p
    /* JADX INFO: renamed from: f */
    public final float mo1939f(View view) {
        return view.getTransitionAlpha();
    }

    @Override // p071Y0.AbstractC0752p
    /* JADX INFO: renamed from: h */
    public final void mo1940h(View view, float f3) {
        view.setTransitionAlpha(f3);
    }

    @Override // p087d0.C1300s, p071Y0.AbstractC0752p
    /* JADX INFO: renamed from: i */
    public final void mo1941i(View view, int i3) {
        view.setTransitionVisibility(i3);
    }

    @Override // p087d0.C1300s
    /* JADX INFO: renamed from: k */
    public final void mo3278k(View view, int i3, int i4, int i5, int i6) {
        view.setLeftTopRightBottom(i3, i4, i5, i6);
    }

    @Override // p087d0.C1300s
    /* JADX INFO: renamed from: l */
    public final void mo3279l(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // p087d0.C1300s
    /* JADX INFO: renamed from: m */
    public final void mo3280m(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
