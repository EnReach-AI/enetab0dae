package p098g;

import android.view.Window;
import p108j.InterfaceC1491y;
import p108j.MenuC1479m;
import p110k.InterfaceC1580d0;

/* JADX INFO: renamed from: g.m */
/* JADX INFO: loaded from: classes.dex */
public final class C1374m implements InterfaceC1580d0, InterfaceC1491y {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ LayoutInflaterFactory2C1382u f4920e;

    public /* synthetic */ C1374m(LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u) {
        this.f4920e = layoutInflaterFactory2C1382u;
    }

    @Override // p108j.InterfaceC1491y
    /* JADX INFO: renamed from: a */
    public void mo533a(MenuC1479m menuC1479m, boolean z3) {
        C1381t c1381t;
        MenuC1479m menuC1479mMo3495k = menuC1479m.mo3495k();
        int i3 = 0;
        boolean z4 = menuC1479mMo3495k != menuC1479m;
        if (z4) {
            menuC1479m = menuC1479mMo3495k;
        }
        LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = this.f4920e;
        C1381t[] c1381tArr = layoutInflaterFactory2C1382u.f4967P;
        int length = c1381tArr != null ? c1381tArr.length : 0;
        while (true) {
            if (i3 < length) {
                c1381t = c1381tArr[i3];
                if (c1381t != null && c1381t.f4939h == menuC1479m) {
                    break;
                } else {
                    i3++;
                }
            } else {
                c1381t = null;
                break;
            }
        }
        if (c1381t != null) {
            if (!z4) {
                layoutInflaterFactory2C1382u.m3384s(c1381t, z3);
            } else {
                layoutInflaterFactory2C1382u.m3382q(c1381t.f4932a, c1381t, menuC1479mMo3495k);
                layoutInflaterFactory2C1382u.m3384s(c1381t, true);
            }
        }
    }

    @Override // p108j.InterfaceC1491y
    /* JADX INFO: renamed from: b */
    public boolean mo534b(MenuC1479m menuC1479m) {
        Window.Callback callback;
        if (menuC1479m != menuC1479m.mo3495k()) {
            return true;
        }
        LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = this.f4920e;
        if (!layoutInflaterFactory2C1382u.f4961J || (callback = layoutInflaterFactory2C1382u.f4991p.getCallback()) == null || layoutInflaterFactory2C1382u.f4972U) {
            return true;
        }
        callback.onMenuOpened(108, menuC1479m);
        return true;
    }
}
