package p009C;

import android.graphics.Bitmap;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;

/* JADX INFO: renamed from: C.e */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0142e {
    /* JADX INFO: renamed from: a */
    public static Drawable m287a(Drawable drawable, Drawable drawable2) {
        return new AdaptiveIconDrawable(drawable, drawable2);
    }

    /* JADX INFO: renamed from: b */
    public static Icon m288b(Bitmap bitmap) {
        return Icon.createWithAdaptiveBitmap(bitmap);
    }
}
