package p110k;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: k.i0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1595i0 {

    /* JADX INFO: renamed from: a */
    public static final Method f5663a;

    /* JADX INFO: renamed from: b */
    public static final Method f5664b;

    /* JADX INFO: renamed from: c */
    public static final Method f5665c;

    /* JADX INFO: renamed from: d */
    public static final boolean f5666d;

    static {
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Boolean.TYPE;
            Class cls3 = Float.TYPE;
            Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, cls2, cls3, cls3);
            f5663a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
            f5664b = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
            f5665c = declaredMethod3;
            declaredMethod3.setAccessible(true);
            f5666d = true;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        }
    }
}
