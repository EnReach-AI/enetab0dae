package p098g;

import android.support.v4.media.session.AbstractC0864a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.WeakHashMap;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p001A.C0009j;
import p029J.AbstractC0311F;
import p029J.AbstractC0323S;

/* JADX INFO: renamed from: g.n */
/* JADX INFO: loaded from: classes.dex */
public final class C1375n extends AbstractC0864a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4921a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f4922b;

    public /* synthetic */ C1375n(int i3, Object obj) {
        this.f4921a = i3;
        this.f4922b = obj;
    }

    @Override // p029J.InterfaceC0332a0
    /* JADX INFO: renamed from: a */
    public final void mo341a() {
        Object obj = this.f4922b;
        switch (this.f4921a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                RunnableC1372k runnableC1372k = (RunnableC1372k) obj;
                runnableC1372k.f4918f.f5001z.setAlpha(1.0f);
                LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = runnableC1372k.f4918f;
                layoutInflaterFactory2C1382u.f4954C.m718d(null);
                layoutInflaterFactory2C1382u.f4954C = null;
                break;
            case 1:
                LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u2 = (LayoutInflaterFactory2C1382u) obj;
                layoutInflaterFactory2C1382u2.f5001z.setAlpha(1.0f);
                layoutInflaterFactory2C1382u2.f4954C.m718d(null);
                layoutInflaterFactory2C1382u2.f4954C = null;
                break;
            default:
                C0009j c0009j = (C0009j) obj;
                ((LayoutInflaterFactory2C1382u) c0009j.f31g).f5001z.setVisibility(8);
                LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u3 = (LayoutInflaterFactory2C1382u) c0009j.f31g;
                PopupWindow popupWindow = layoutInflaterFactory2C1382u3.f4952A;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (layoutInflaterFactory2C1382u3.f5001z.getParent() instanceof View) {
                    View view = (View) layoutInflaterFactory2C1382u3.f5001z.getParent();
                    WeakHashMap weakHashMap = AbstractC0323S.f816a;
                    AbstractC0311F.m627c(view);
                }
                layoutInflaterFactory2C1382u3.f5001z.m2232e();
                layoutInflaterFactory2C1382u3.f4954C.m718d(null);
                layoutInflaterFactory2C1382u3.f4954C = null;
                ViewGroup viewGroup = layoutInflaterFactory2C1382u3.f4956E;
                WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
                AbstractC0311F.m627c(viewGroup);
                break;
        }
    }

    @Override // android.support.v4.media.session.AbstractC0864a, p029J.InterfaceC0332a0
    /* JADX INFO: renamed from: c */
    public void mo343c() {
        Object obj = this.f4922b;
        switch (this.f4921a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ((RunnableC1372k) obj).f4918f.f5001z.setVisibility(0);
                break;
            case 1:
                LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = (LayoutInflaterFactory2C1382u) obj;
                layoutInflaterFactory2C1382u.f5001z.setVisibility(0);
                if (layoutInflaterFactory2C1382u.f5001z.getParent() instanceof View) {
                    View view = (View) layoutInflaterFactory2C1382u.f5001z.getParent();
                    WeakHashMap weakHashMap = AbstractC0323S.f816a;
                    AbstractC0311F.m627c(view);
                }
                break;
        }
    }
}
