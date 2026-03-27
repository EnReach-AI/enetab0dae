package p087d0;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import p071Y0.AbstractC0752p;

/* JADX INFO: renamed from: d0.s */
/* JADX INFO: loaded from: classes.dex */
public class C1300s extends AbstractC0752p {

    /* JADX INFO: renamed from: d */
    public static boolean f4647d = true;

    /* JADX INFO: renamed from: e */
    public static boolean f4648e = true;

    /* JADX INFO: renamed from: f */
    public static boolean f4649f = true;

    /* JADX INFO: renamed from: g */
    public static boolean f4650g = true;

    @Override // p071Y0.AbstractC0752p
    /* JADX INFO: renamed from: i */
    public void mo1941i(View view, int i3) {
        if (Build.VERSION.SDK_INT == 28) {
            super.mo1941i(view, i3);
        } else if (f4650g) {
            try {
                view.setTransitionVisibility(i3);
            } catch (NoSuchMethodError unused) {
                f4650g = false;
            }
        }
    }

    /* JADX INFO: renamed from: k */
    public void mo3278k(View view, int i3, int i4, int i5, int i6) {
        if (f4649f) {
            try {
                view.setLeftTopRightBottom(i3, i4, i5, i6);
            } catch (NoSuchMethodError unused) {
                f4649f = false;
            }
        }
    }

    /* JADX INFO: renamed from: l */
    public void mo3279l(View view, Matrix matrix) {
        if (f4647d) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f4647d = false;
            }
        }
    }

    /* JADX INFO: renamed from: m */
    public void mo3280m(View view, Matrix matrix) {
        if (f4648e) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f4648e = false;
            }
        }
    }
}
