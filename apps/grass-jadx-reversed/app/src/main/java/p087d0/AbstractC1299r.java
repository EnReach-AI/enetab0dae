package p087d0;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;

/* JADX INFO: renamed from: d0.r */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1299r {

    /* JADX INFO: renamed from: a */
    public static final C1300s f4645a;

    /* JADX INFO: renamed from: b */
    public static final C1284c f4646b;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f4645a = new C1301t();
        } else {
            f4645a = new C1300s();
        }
        f4646b = new C1284c(Float.class, "translationAlpha", 5);
        new C1284c(Rect.class, "clipBounds", 6);
    }

    /* JADX INFO: renamed from: a */
    public static void m3277a(View view, int i3, int i4, int i5, int i6) {
        f4645a.mo3278k(view, i3, i4, i5, i6);
    }
}
