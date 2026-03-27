package p110k;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p029J.AbstractC0308C;
import p029J.AbstractC0323S;

/* JADX INFO: renamed from: k.i1 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1596i1 {

    /* JADX INFO: renamed from: a */
    public static final Method f5667a;

    static {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            f5667a = declaredMethod;
            if (declaredMethod.isAccessible()) {
                return;
            }
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3658a(View view) {
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        return AbstractC0308C.m607d(view) == 1;
    }
}
