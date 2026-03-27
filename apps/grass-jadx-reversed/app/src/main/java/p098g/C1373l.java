package p098g;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActionBarContextView;
import io.getgrass.www.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p005B.C0029d;
import p029J.AbstractC0307B;
import p029J.AbstractC0311F;
import p029J.AbstractC0314I;
import p029J.AbstractC0323S;
import p029J.AbstractC0346h0;
import p029J.C0340e0;
import p029J.C0342f0;
import p029J.C0344g0;
import p029J.C0364q0;
import p029J.InterfaceC0367s;
import p108j.InterfaceC1491y;
import p108j.MenuC1479m;
import p110k.AbstractC1596i1;
import p165z.AbstractC2048d;

/* JADX INFO: renamed from: g.l */
/* JADX INFO: loaded from: classes.dex */
public final class C1373l implements InterfaceC0367s, InterfaceC1491y {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ LayoutInflaterFactory2C1382u f4919e;

    public /* synthetic */ C1373l(LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u) {
        this.f4919e = layoutInflaterFactory2C1382u;
    }

    @Override // p108j.InterfaceC1491y
    /* JADX INFO: renamed from: a */
    public void mo533a(MenuC1479m menuC1479m, boolean z3) {
        this.f4919e.m3383r(menuC1479m);
    }

    @Override // p108j.InterfaceC1491y
    /* JADX INFO: renamed from: b */
    public boolean mo534b(MenuC1479m menuC1479m) {
        Window.Callback callback = this.f4919e.f4991p.getCallback();
        if (callback == null) {
            return true;
        }
        callback.onMenuOpened(108, menuC1479m);
        return true;
    }

    @Override // p029J.InterfaceC0367s
    /* JADX INFO: renamed from: h */
    public C0364q0 mo48h(View view, C0364q0 c0364q0) {
        boolean z3;
        C0364q0 c0364q0Mo736b;
        boolean z4;
        boolean z5;
        int iM833d = c0364q0.m833d();
        LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = this.f4919e;
        layoutInflaterFactory2C1382u.getClass();
        int iM833d2 = c0364q0.m833d();
        ActionBarContextView actionBarContextView = layoutInflaterFactory2C1382u.f5001z;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z3 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutInflaterFactory2C1382u.f5001z.getLayoutParams();
            if (layoutInflaterFactory2C1382u.f5001z.isShown()) {
                if (layoutInflaterFactory2C1382u.f4984g0 == null) {
                    layoutInflaterFactory2C1382u.f4984g0 = new Rect();
                    layoutInflaterFactory2C1382u.f4985h0 = new Rect();
                }
                Rect rect = layoutInflaterFactory2C1382u.f4984g0;
                Rect rect2 = layoutInflaterFactory2C1382u.f4985h0;
                rect.set(c0364q0.m831b(), c0364q0.m833d(), c0364q0.m832c(), c0364q0.m830a());
                ViewGroup viewGroup = layoutInflaterFactory2C1382u.f4956E;
                Method method = AbstractC1596i1.f5667a;
                if (method != null) {
                    try {
                        method.invoke(viewGroup, rect, rect2);
                    } catch (Exception e3) {
                        Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e3);
                    }
                }
                int i3 = rect.top;
                int i4 = rect.left;
                int i5 = rect.right;
                ViewGroup viewGroup2 = layoutInflaterFactory2C1382u.f4956E;
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                C0364q0 c0364q0M654a = AbstractC0314I.m654a(viewGroup2);
                int iM831b = c0364q0M654a == null ? 0 : c0364q0M654a.m831b();
                int iM832c = c0364q0M654a == null ? 0 : c0364q0M654a.m832c();
                if (marginLayoutParams.topMargin == i3 && marginLayoutParams.leftMargin == i4 && marginLayoutParams.rightMargin == i5) {
                    z5 = false;
                } else {
                    marginLayoutParams.topMargin = i3;
                    marginLayoutParams.leftMargin = i4;
                    marginLayoutParams.rightMargin = i5;
                    z5 = true;
                }
                Context context = layoutInflaterFactory2C1382u.f4990o;
                if (i3 <= 0 || layoutInflaterFactory2C1382u.f4958G != null) {
                    View view2 = layoutInflaterFactory2C1382u.f4958G;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i6 = marginLayoutParams2.height;
                        int i7 = marginLayoutParams.topMargin;
                        if (i6 != i7 || marginLayoutParams2.leftMargin != iM831b || marginLayoutParams2.rightMargin != iM832c) {
                            marginLayoutParams2.height = i7;
                            marginLayoutParams2.leftMargin = iM831b;
                            marginLayoutParams2.rightMargin = iM832c;
                            layoutInflaterFactory2C1382u.f4958G.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view3 = new View(context);
                    layoutInflaterFactory2C1382u.f4958G = view3;
                    view3.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iM831b;
                    layoutParams.rightMargin = iM832c;
                    layoutInflaterFactory2C1382u.f4956E.addView(layoutInflaterFactory2C1382u.f4958G, -1, layoutParams);
                }
                View view4 = layoutInflaterFactory2C1382u.f4958G;
                boolean z6 = view4 != null;
                if (z6 && view4.getVisibility() != 0) {
                    View view5 = layoutInflaterFactory2C1382u.f4958G;
                    view5.setBackgroundColor((AbstractC0307B.m591g(view5) & 8192) != 0 ? AbstractC2048d.m4520a(context, R.color.abc_decor_view_status_guard_light) : AbstractC2048d.m4520a(context, R.color.abc_decor_view_status_guard));
                }
                if (!layoutInflaterFactory2C1382u.f4963L && z6) {
                    iM833d2 = 0;
                }
                z3 = z6;
                z4 = z5;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z3 = false;
                z4 = true;
            } else {
                z3 = false;
                z4 = false;
            }
            if (z4) {
                layoutInflaterFactory2C1382u.f5001z.setLayoutParams(marginLayoutParams);
            }
        }
        View view6 = layoutInflaterFactory2C1382u.f4958G;
        if (view6 != null) {
            view6.setVisibility(z3 ? 0 : 8);
        }
        if (iM833d != iM833d2) {
            int iM831b2 = c0364q0.m831b();
            int iM832c2 = c0364q0.m832c();
            int iM830a = c0364q0.m830a();
            int i8 = Build.VERSION.SDK_INT;
            AbstractC0346h0 c0344g0 = i8 >= 30 ? new C0344g0(c0364q0) : i8 >= 29 ? new C0342f0(c0364q0) : new C0340e0(c0364q0);
            c0344g0.mo738d(C0029d.m139a(iM831b2, iM833d2, iM832c2, iM830a));
            c0364q0Mo736b = c0344g0.mo736b();
        } else {
            c0364q0Mo736b = c0364q0;
        }
        WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
        WindowInsets windowInsetsM834f = c0364q0Mo736b.m834f();
        if (windowInsetsM834f == null) {
            return c0364q0Mo736b;
        }
        WindowInsets windowInsetsM626b = AbstractC0311F.m626b(view, windowInsetsM834f);
        return !windowInsetsM626b.equals(windowInsetsM834f) ? C0364q0.m829g(windowInsetsM626b, view) : c0364q0Mo736b;
    }
}
