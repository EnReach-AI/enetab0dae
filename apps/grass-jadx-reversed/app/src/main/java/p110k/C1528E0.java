package p110k;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
import p108j.C1481o;
import p108j.MenuC1479m;

/* JADX INFO: renamed from: k.E0 */
/* JADX INFO: loaded from: classes.dex */
public final class C1528E0 extends C1628y0 implements InterfaceC1630z0 {

    /* JADX INFO: renamed from: H */
    public static final Method f5485H;

    /* JADX INFO: renamed from: G */
    public InterfaceC1630z0 f5486G;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f5485H = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    @Override // p110k.InterfaceC1630z0
    /* JADX INFO: renamed from: c */
    public final void mo979c(MenuC1479m menuC1479m, C1481o c1481o) {
        InterfaceC1630z0 interfaceC1630z0 = this.f5486G;
        if (interfaceC1630z0 != null) {
            interfaceC1630z0.mo979c(menuC1479m, c1481o);
        }
    }

    @Override // p110k.InterfaceC1630z0
    /* JADX INFO: renamed from: n */
    public final void mo981n(MenuC1479m menuC1479m, C1481o c1481o) {
        InterfaceC1630z0 interfaceC1630z0 = this.f5486G;
        if (interfaceC1630z0 != null) {
            interfaceC1630z0.mo981n(menuC1479m, c1481o);
        }
    }

    @Override // p110k.C1628y0
    /* JADX INFO: renamed from: q */
    public final C1604m0 mo3572q(Context context, boolean z3) {
        C1526D0 c1526d0 = new C1526D0(context, z3);
        c1526d0.setHoverListener(this);
        return c1526d0;
    }
}
