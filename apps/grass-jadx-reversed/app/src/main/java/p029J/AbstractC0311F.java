package p029J;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: renamed from: J.F */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0311F {
    /* JADX INFO: renamed from: a */
    public static WindowInsets m625a(View view, WindowInsets windowInsets) {
        return view.dispatchApplyWindowInsets(windowInsets);
    }

    /* JADX INFO: renamed from: b */
    public static WindowInsets m626b(View view, WindowInsets windowInsets) {
        return view.onApplyWindowInsets(windowInsets);
    }

    /* JADX INFO: renamed from: c */
    public static void m627c(View view) {
        view.requestApplyInsets();
    }
}
