package p029J;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: J.d0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0338d0 {

    /* JADX INFO: renamed from: a */
    public static final Field f832a;

    /* JADX INFO: renamed from: b */
    public static final Field f833b;

    /* JADX INFO: renamed from: c */
    public static final Field f834c;

    /* JADX INFO: renamed from: d */
    public static final boolean f835d;

    static {
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            f832a = declaredField;
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            Field declaredField2 = cls.getDeclaredField("mStableInsets");
            f833b = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mContentInsets");
            f834c = declaredField3;
            declaredField3.setAccessible(true);
            f835d = true;
        } catch (ReflectiveOperationException e3) {
            Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e3.getMessage(), e3);
        }
    }
}
