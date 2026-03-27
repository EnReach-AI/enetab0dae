package p029J;

import android.view.View;
import io.getgrass.www.R;
import java.util.Objects;
import p128p.C1817k;

/* JADX INFO: renamed from: J.L */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0317L {
    /* JADX INFO: renamed from: a */
    public static void m673a(View view, InterfaceC0322Q interfaceC0322Q) {
        C1817k c1817k = (C1817k) view.getTag(R.id.tag_unhandled_key_listeners);
        if (c1817k == null) {
            c1817k = new C1817k();
            view.setTag(R.id.tag_unhandled_key_listeners, c1817k);
        }
        Objects.requireNonNull(interfaceC0322Q);
        View.OnUnhandledKeyEventListener viewOnUnhandledKeyEventListenerC0316K = new ViewOnUnhandledKeyEventListenerC0316K();
        c1817k.put(interfaceC0322Q, viewOnUnhandledKeyEventListenerC0316K);
        view.addOnUnhandledKeyEventListener(viewOnUnhandledKeyEventListenerC0316K);
    }

    /* JADX INFO: renamed from: b */
    public static CharSequence m674b(View view) {
        return view.getAccessibilityPaneTitle();
    }

    /* JADX INFO: renamed from: c */
    public static boolean m675c(View view) {
        return view.isAccessibilityHeading();
    }

    /* JADX INFO: renamed from: d */
    public static boolean m676d(View view) {
        return view.isScreenReaderFocusable();
    }

    /* JADX INFO: renamed from: e */
    public static void m677e(View view, InterfaceC0322Q interfaceC0322Q) {
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
        C1817k c1817k = (C1817k) view.getTag(R.id.tag_unhandled_key_listeners);
        if (c1817k == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) c1817k.getOrDefault(interfaceC0322Q, null)) == null) {
            return;
        }
        view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
    }

    /* JADX INFO: renamed from: f */
    public static <T> T m678f(View view, int i3) {
        return (T) view.requireViewById(i3);
    }

    /* JADX INFO: renamed from: g */
    public static void m679g(View view, boolean z3) {
        view.setAccessibilityHeading(z3);
    }

    /* JADX INFO: renamed from: h */
    public static void m680h(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    /* JADX INFO: renamed from: i */
    public static void m681i(View view, boolean z3) {
        view.setScreenReaderFocusable(z3);
    }
}
