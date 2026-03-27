package p029J;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import p117m0.AbstractC1717l;

/* JADX INFO: renamed from: J.s0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0368s0 extends AbstractC1717l {

    /* JADX INFO: renamed from: a */
    public final WindowInsetsController f878a;

    /* JADX INFO: renamed from: b */
    public final Window f879b;

    public C0368s0(Window window) {
        this.f878a = window.getInsetsController();
        this.f879b = window;
    }

    @Override // p117m0.AbstractC1717l
    /* JADX INFO: renamed from: m */
    public final void mo836m(boolean z3) {
        Window window = this.f879b;
        if (z3) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            this.f878a.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        this.f878a.setSystemBarsAppearance(0, 16);
    }

    @Override // p117m0.AbstractC1717l
    /* JADX INFO: renamed from: n */
    public final void mo837n(boolean z3) {
        Window window = this.f879b;
        if (z3) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            }
            this.f878a.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        this.f878a.setSystemBarsAppearance(0, 8);
    }
}
