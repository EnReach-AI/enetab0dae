package p110k;

import android.R;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: renamed from: k.g0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1589g0 {

    /* JADX INFO: renamed from: a */
    public static final int[] f5636a = {R.attr.state_checked};

    /* JADX INFO: renamed from: b */
    public static final int[] f5637b = new int[0];

    static {
        new Rect();
    }

    /* JADX INFO: renamed from: a */
    public static void m3651a(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 29 || i3 >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            return;
        }
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f5636a);
        } else {
            drawable.setState(f5637b);
        }
        drawable.setState(state);
    }

    /* JADX INFO: renamed from: b */
    public static PorterDuff.Mode m3652b(int i3, PorterDuff.Mode mode) {
        if (i3 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i3 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i3 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i3) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
