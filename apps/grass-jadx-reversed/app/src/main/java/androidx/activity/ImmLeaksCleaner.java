package androidx.activity;

import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.EnumC0978k;
import androidx.lifecycle.InterfaceC0982o;
import androidx.lifecycle.InterfaceC0984q;

/* JADX INFO: loaded from: classes.dex */
final class ImmLeaksCleaner implements InterfaceC0982o {

    /* JADX INFO: renamed from: a */
    public static int f2584a;

    @Override // androidx.lifecycle.InterfaceC0982o
    /* JADX INFO: renamed from: b */
    public final void mo2170b(InterfaceC0984q interfaceC0984q, EnumC0978k enumC0978k) {
        if (enumC0978k != EnumC0978k.ON_DESTROY) {
            return;
        }
        if (f2584a == 0) {
            try {
                f2584a = 2;
                InputMethodManager.class.getDeclaredField("mServedView").setAccessible(true);
                InputMethodManager.class.getDeclaredField("mNextServedView").setAccessible(true);
                InputMethodManager.class.getDeclaredField("mH").setAccessible(true);
                f2584a = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (f2584a == 1) {
            throw null;
        }
    }
}
