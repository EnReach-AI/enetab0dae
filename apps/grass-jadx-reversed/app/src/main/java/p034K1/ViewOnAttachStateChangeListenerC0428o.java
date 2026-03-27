package p034K1;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import java.util.WeakHashMap;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p029J.AbstractC0310E;
import p029J.AbstractC0311F;
import p029J.AbstractC0323S;
import p032K.AbstractC0385c;
import p032K.InterfaceC0386d;
import p108j.ViewOnKeyListenerC1465E;
import p108j.ViewOnKeyListenerC1473g;

/* JADX INFO: renamed from: K1.o */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnAttachStateChangeListenerC0428o implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f983e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f984f;

    public /* synthetic */ ViewOnAttachStateChangeListenerC0428o(int i3, Object obj) {
        this.f983e = i3;
        this.f984f = obj;
    }

    /* JADX INFO: renamed from: a */
    private final void m936a(View view) {
    }

    /* JADX INFO: renamed from: b */
    private final void m937b(View view) {
    }

    /* JADX INFO: renamed from: c */
    private final void m938c(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        AccessibilityManager accessibilityManager;
        Object obj = this.f984f;
        switch (this.f983e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0430q c0430q = (C0430q) obj;
                if (c0430q.f1009y != null && (accessibilityManager = c0430q.f1008x) != null) {
                    WeakHashMap weakHashMap = AbstractC0323S.f816a;
                    if (AbstractC0310E.m619b(c0430q)) {
                        AbstractC0385c.m851a(accessibilityManager, c0430q.f1009y);
                    }
                    break;
                }
                break;
            case 1:
                View view2 = (View) obj;
                view2.removeOnAttachStateChangeListener(this);
                WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
                AbstractC0311F.m627c(view2);
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        switch (this.f983e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0430q c0430q = (C0430q) this.f984f;
                InterfaceC0386d interfaceC0386d = c0430q.f1009y;
                if (interfaceC0386d != null && (accessibilityManager = c0430q.f1008x) != null) {
                    AbstractC0385c.m852b(accessibilityManager, interfaceC0386d);
                    break;
                }
                break;
            case 1:
                break;
            case 2:
                ViewOnKeyListenerC1473g viewOnKeyListenerC1473g = (ViewOnKeyListenerC1473g) this.f984f;
                ViewTreeObserver viewTreeObserver = viewOnKeyListenerC1473g.f5305C;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        viewOnKeyListenerC1473g.f5305C = view.getViewTreeObserver();
                    }
                    viewOnKeyListenerC1473g.f5305C.removeGlobalOnLayoutListener(viewOnKeyListenerC1473g.f5316n);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            default:
                ViewOnKeyListenerC1465E viewOnKeyListenerC1465E = (ViewOnKeyListenerC1465E) this.f984f;
                ViewTreeObserver viewTreeObserver2 = viewOnKeyListenerC1465E.f5267t;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        viewOnKeyListenerC1465E.f5267t = view.getViewTreeObserver();
                    }
                    viewOnKeyListenerC1465E.f5267t.removeGlobalOnLayoutListener(viewOnKeyListenerC1465E.f5261n);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
        }
    }
}
