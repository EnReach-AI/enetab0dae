package p029J;

import android.view.View;
import android.view.Window;
import p117m0.AbstractC1717l;

/* JADX INFO: renamed from: J.r0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0366r0 extends AbstractC1717l {

    /* JADX INFO: renamed from: a */
    public final Window f877a;

    public C0366r0(Window window) {
        this.f877a = window;
    }

    @Override // p117m0.AbstractC1717l
    /* JADX INFO: renamed from: m */
    public final void mo836m(boolean z3) {
        Window window = this.f877a;
        if (!z3) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-17));
        } else {
            window.clearFlags(134217728);
            window.addFlags(Integer.MIN_VALUE);
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 16);
        }
    }

    @Override // p117m0.AbstractC1717l
    /* JADX INFO: renamed from: n */
    public final void mo837n(boolean z3) {
        Window window = this.f877a;
        if (!z3) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
        } else {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 8192);
        }
    }
}
