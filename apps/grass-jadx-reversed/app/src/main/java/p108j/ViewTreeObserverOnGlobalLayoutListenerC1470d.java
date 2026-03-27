package p108j;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p029J.AbstractC0310E;
import p029J.AbstractC0323S;
import p110k.AbstractC1529F;
import p110k.AbstractC1531G;
import p110k.C1541L;
import p110k.C1547O;

/* JADX INFO: renamed from: j.d */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC1470d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f5293e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f5294f;

    public /* synthetic */ ViewTreeObserverOnGlobalLayoutListenerC1470d(int i3, Object obj) {
        this.f5293e = i3;
        this.f5294f = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Object obj = this.f5294f;
        switch (this.f5293e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ViewOnKeyListenerC1473g viewOnKeyListenerC1473g = (ViewOnKeyListenerC1473g) obj;
                if (viewOnKeyListenerC1473g.mo3475b()) {
                    ArrayList arrayList = viewOnKeyListenerC1473g.f5315m;
                    if (arrayList.size() > 0 && !((C1472f) arrayList.get(0)).f5300a.f5768C) {
                        View view = viewOnKeyListenerC1473g.f5322t;
                        if (view != null && view.isShown()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((C1472f) it.next()).f5300a.mo3476f();
                            }
                        } else {
                            viewOnKeyListenerC1473g.dismiss();
                        }
                        break;
                    }
                }
                break;
            case 1:
                ViewOnKeyListenerC1465E viewOnKeyListenerC1465E = (ViewOnKeyListenerC1465E) obj;
                if (viewOnKeyListenerC1465E.mo3475b() && !viewOnKeyListenerC1465E.f5260m.f5768C) {
                    View view2 = viewOnKeyListenerC1465E.f5265r;
                    if (view2 != null && view2.isShown()) {
                        viewOnKeyListenerC1465E.f5260m.mo3476f();
                    } else {
                        viewOnKeyListenerC1465E.dismiss();
                    }
                    break;
                }
                break;
            case 2:
                C1547O c1547o = (C1547O) obj;
                if (!c1547o.getInternalPopup().mo3589b()) {
                    c1547o.f5529j.mo3591e(AbstractC1531G.m3575b(c1547o), AbstractC1531G.m3574a(c1547o));
                }
                ViewTreeObserver viewTreeObserver = c1547o.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    AbstractC1529F.m3573a(viewTreeObserver, this);
                }
                break;
            default:
                C1541L c1541l = (C1541L) obj;
                C1547O c1547o2 = c1541l.f5517K;
                c1541l.getClass();
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                if (AbstractC0310E.m619b(c1547o2) && c1547o2.getGlobalVisibleRect(c1541l.f5515I)) {
                    c1541l.m3601s();
                    c1541l.mo3476f();
                } else {
                    c1541l.dismiss();
                }
                break;
        }
    }
}
