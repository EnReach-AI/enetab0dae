package p155w;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: renamed from: w.g */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1985g {

    /* JADX INFO: renamed from: a */
    public static final ThreadLocal f7044a = new ThreadLocal();

    /* JADX INFO: renamed from: b */
    public static final ThreadLocal f7045b = new ThreadLocal();

    /* JADX INFO: renamed from: a */
    public static void m4372a(ViewParent viewParent, View view, Matrix matrix) {
        Object parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            m4372a(viewParent, (View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        if (view.getMatrix().isIdentity()) {
            return;
        }
        matrix.preConcat(view.getMatrix());
    }
}
