package p009C;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;

/* JADX INFO: renamed from: C.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0138a {
    /* JADX INFO: renamed from: a */
    public static int m268a(Drawable drawable) {
        return drawable.getAlpha();
    }

    /* JADX INFO: renamed from: b */
    public static Drawable m269b(DrawableContainer.DrawableContainerState drawableContainerState, int i3) {
        return drawableContainerState.getChild(i3);
    }

    /* JADX INFO: renamed from: c */
    public static Drawable m270c(InsetDrawable insetDrawable) {
        return insetDrawable.getDrawable();
    }

    /* JADX INFO: renamed from: d */
    public static boolean m271d(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    /* JADX INFO: renamed from: e */
    public static void m272e(Drawable drawable, boolean z3) {
        drawable.setAutoMirrored(z3);
    }
}
