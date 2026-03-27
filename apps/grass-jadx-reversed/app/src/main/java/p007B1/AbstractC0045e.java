package p007B1;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: renamed from: B1.e */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0045e {

    /* JADX INFO: renamed from: a */
    public static final ThreadLocal f169a = new ThreadLocal();

    /* JADX INFO: renamed from: b */
    public static final ThreadLocal f170b = new ThreadLocal();

    /* JADX INFO: renamed from: a */
    public static void m206a(ViewParent viewParent, View view, Matrix matrix) {
        Object parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            m206a(viewParent, (View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        if (view.getMatrix().isIdentity()) {
            return;
        }
        matrix.preConcat(view.getMatrix());
    }
}
