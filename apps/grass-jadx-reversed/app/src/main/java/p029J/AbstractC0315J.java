package p029J;

import android.view.View;
import java.util.Collection;

/* JADX INFO: renamed from: J.J */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0315J {
    /* JADX INFO: renamed from: a */
    public static void m658a(View view, Collection<View> collection, int i3) {
        view.addKeyboardNavigationClusters(collection, i3);
    }

    /* JADX INFO: renamed from: b */
    public static int m659b(View view) {
        return view.getImportantForAutofill();
    }

    /* JADX INFO: renamed from: c */
    public static int m660c(View view) {
        return view.getNextClusterForwardId();
    }

    /* JADX INFO: renamed from: d */
    public static boolean m661d(View view) {
        return view.hasExplicitFocusable();
    }

    /* JADX INFO: renamed from: e */
    public static boolean m662e(View view) {
        return view.isFocusedByDefault();
    }

    /* JADX INFO: renamed from: f */
    public static boolean m663f(View view) {
        return view.isImportantForAutofill();
    }

    /* JADX INFO: renamed from: g */
    public static boolean m664g(View view) {
        return view.isKeyboardNavigationCluster();
    }

    /* JADX INFO: renamed from: h */
    public static View m665h(View view, View view2, int i3) {
        return view.keyboardNavigationClusterSearch(view2, i3);
    }

    /* JADX INFO: renamed from: i */
    public static boolean m666i(View view) {
        return view.restoreDefaultFocus();
    }

    /* JADX INFO: renamed from: j */
    public static void m667j(View view, String... strArr) {
        view.setAutofillHints(strArr);
    }

    /* JADX INFO: renamed from: k */
    public static void m668k(View view, boolean z3) {
        view.setFocusedByDefault(z3);
    }

    /* JADX INFO: renamed from: l */
    public static void m669l(View view, int i3) {
        view.setImportantForAutofill(i3);
    }

    /* JADX INFO: renamed from: m */
    public static void m670m(View view, boolean z3) {
        view.setKeyboardNavigationCluster(z3);
    }

    /* JADX INFO: renamed from: n */
    public static void m671n(View view, int i3) {
        view.setNextClusterForwardId(i3);
    }

    /* JADX INFO: renamed from: o */
    public static void m672o(View view, CharSequence charSequence) {
        view.setTooltipText(charSequence);
    }
}
