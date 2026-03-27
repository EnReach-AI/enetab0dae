package p029J;

import android.view.View;
import android.view.Window;

/* JADX INFO: renamed from: J.b0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0334b0 {
    /* JADX INFO: renamed from: a */
    public static void m722a(Window window, boolean z3) {
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z3 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
    }
}
