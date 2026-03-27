package p108j;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import io.getgrass.www.R;
import java.util.WeakHashMap;
import p029J.AbstractC0308C;
import p029J.AbstractC0323S;
import p034K1.ViewOnAttachStateChangeListenerC0428o;
import p110k.C1528E0;
import p110k.C1604m0;

/* JADX INFO: renamed from: j.E */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnKeyListenerC1465E extends AbstractC1487u implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* JADX INFO: renamed from: f */
    public final Context f5253f;

    /* JADX INFO: renamed from: g */
    public final MenuC1479m f5254g;

    /* JADX INFO: renamed from: h */
    public final C1476j f5255h;

    /* JADX INFO: renamed from: i */
    public final boolean f5256i;

    /* JADX INFO: renamed from: j */
    public final int f5257j;

    /* JADX INFO: renamed from: k */
    public final int f5258k;

    /* JADX INFO: renamed from: l */
    public final int f5259l;

    /* JADX INFO: renamed from: m */
    public final C1528E0 f5260m;

    /* JADX INFO: renamed from: p */
    public PopupWindow.OnDismissListener f5263p;

    /* JADX INFO: renamed from: q */
    public View f5264q;

    /* JADX INFO: renamed from: r */
    public View f5265r;

    /* JADX INFO: renamed from: s */
    public InterfaceC1491y f5266s;

    /* JADX INFO: renamed from: t */
    public ViewTreeObserver f5267t;

    /* JADX INFO: renamed from: u */
    public boolean f5268u;

    /* JADX INFO: renamed from: v */
    public boolean f5269v;

    /* JADX INFO: renamed from: w */
    public int f5270w;

    /* JADX INFO: renamed from: y */
    public boolean f5272y;

    /* JADX INFO: renamed from: n */
    public final ViewTreeObserverOnGlobalLayoutListenerC1470d f5261n = new ViewTreeObserverOnGlobalLayoutListenerC1470d(1, this);

    /* JADX INFO: renamed from: o */
    public final ViewOnAttachStateChangeListenerC0428o f5262o = new ViewOnAttachStateChangeListenerC0428o(3, this);

    /* JADX INFO: renamed from: x */
    public int f5271x = 0;

    public ViewOnKeyListenerC1465E(int i3, int i4, Context context, View view, MenuC1479m menuC1479m, boolean z3) {
        this.f5253f = context;
        this.f5254g = menuC1479m;
        this.f5256i = z3;
        this.f5255h = new C1476j(menuC1479m, LayoutInflater.from(context), z3, R.layout.abc_popup_menu_item_layout);
        this.f5258k = i3;
        this.f5259l = i4;
        Resources resources = context.getResources();
        this.f5257j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f5264q = view;
        this.f5260m = new C1528E0(context, null, i3, i4);
        menuC1479m.m3512b(this, context);
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: a */
    public final void mo3478a(MenuC1479m menuC1479m, boolean z3) {
        if (menuC1479m != this.f5254g) {
            return;
        }
        dismiss();
        InterfaceC1491y interfaceC1491y = this.f5266s;
        if (interfaceC1491y != null) {
            interfaceC1491y.mo533a(menuC1479m, z3);
        }
    }

    @Override // p108j.InterfaceC1464D
    /* JADX INFO: renamed from: b */
    public final boolean mo3475b() {
        return !this.f5268u && this.f5260m.f5769D.isShowing();
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: d */
    public final boolean mo3479d() {
        return false;
    }

    @Override // p108j.InterfaceC1464D
    public final void dismiss() {
        if (mo3475b()) {
            this.f5260m.dismiss();
        }
    }

    @Override // p108j.InterfaceC1464D
    /* JADX INFO: renamed from: f */
    public final void mo3476f() {
        View view;
        if (mo3475b()) {
            return;
        }
        if (this.f5268u || (view = this.f5264q) == null) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
        this.f5265r = view;
        C1528E0 c1528e0 = this.f5260m;
        c1528e0.f5769D.setOnDismissListener(this);
        c1528e0.f5785t = this;
        c1528e0.f5768C = true;
        c1528e0.f5769D.setFocusable(true);
        View view2 = this.f5265r;
        boolean z3 = this.f5267t == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f5267t = viewTreeObserver;
        if (z3) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f5261n);
        }
        view2.addOnAttachStateChangeListener(this.f5262o);
        c1528e0.f5784s = view2;
        c1528e0.f5781p = this.f5271x;
        boolean z4 = this.f5269v;
        Context context = this.f5253f;
        C1476j c1476j = this.f5255h;
        if (!z4) {
            this.f5270w = AbstractC1487u.m3535m(c1476j, context, this.f5257j);
            this.f5269v = true;
        }
        c1528e0.m3705r(this.f5270w);
        c1528e0.f5769D.setInputMethodMode(2);
        Rect rect = this.f5410e;
        c1528e0.f5767B = rect != null ? new Rect(rect) : null;
        c1528e0.mo3476f();
        C1604m0 c1604m0 = c1528e0.f5772g;
        c1604m0.setOnKeyListener(this);
        if (this.f5272y) {
            MenuC1479m menuC1479m = this.f5254g;
            if (menuC1479m.f5356m != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) c1604m0, false);
                TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                if (textView != null) {
                    textView.setText(menuC1479m.f5356m);
                }
                frameLayout.setEnabled(false);
                c1604m0.addHeaderView(frameLayout, null, false);
            }
        }
        c1528e0.mo3598o(c1476j);
        c1528e0.mo3476f();
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: g */
    public final void mo3480g() {
        this.f5269v = false;
        C1476j c1476j = this.f5255h;
        if (c1476j != null) {
            c1476j.notifyDataSetChanged();
        }
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: i */
    public final void mo3481i(InterfaceC1491y interfaceC1491y) {
        this.f5266s = interfaceC1491y;
    }

    @Override // p108j.InterfaceC1464D
    /* JADX INFO: renamed from: j */
    public final C1604m0 mo3477j() {
        return this.f5260m.f5772g;
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: k */
    public final boolean mo3482k(SubMenuC1466F subMenuC1466F) {
        if (subMenuC1466F.hasVisibleItems()) {
            View view = this.f5265r;
            C1490x c1490x = new C1490x(this.f5258k, this.f5259l, this.f5253f, view, subMenuC1466F, this.f5256i);
            InterfaceC1491y interfaceC1491y = this.f5266s;
            c1490x.f5420i = interfaceC1491y;
            AbstractC1487u abstractC1487u = c1490x.f5421j;
            if (abstractC1487u != null) {
                abstractC1487u.mo3481i(interfaceC1491y);
            }
            boolean zM3536u = AbstractC1487u.m3536u(subMenuC1466F);
            c1490x.f5419h = zM3536u;
            AbstractC1487u abstractC1487u2 = c1490x.f5421j;
            if (abstractC1487u2 != null) {
                abstractC1487u2.mo3485o(zM3536u);
            }
            c1490x.f5422k = this.f5263p;
            this.f5263p = null;
            this.f5254g.m3513c(false);
            C1528E0 c1528e0 = this.f5260m;
            int width = c1528e0.f5775j;
            int iM3701g = c1528e0.m3701g();
            int i3 = this.f5271x;
            View view2 = this.f5264q;
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            if ((Gravity.getAbsoluteGravity(i3, AbstractC0308C.m607d(view2)) & 7) == 5) {
                width += this.f5264q.getWidth();
            }
            if (!c1490x.m3539b()) {
                if (c1490x.f5417f != null) {
                    c1490x.m3541d(width, iM3701g, true, true);
                }
            }
            InterfaceC1491y interfaceC1491y2 = this.f5266s;
            if (interfaceC1491y2 != null) {
                interfaceC1491y2.mo534b(subMenuC1466F);
            }
            return true;
        }
        return false;
    }

    @Override // p108j.AbstractC1487u
    /* JADX INFO: renamed from: l */
    public final void mo3483l(MenuC1479m menuC1479m) {
    }

    @Override // p108j.AbstractC1487u
    /* JADX INFO: renamed from: n */
    public final void mo3484n(View view) {
        this.f5264q = view;
    }

    @Override // p108j.AbstractC1487u
    /* JADX INFO: renamed from: o */
    public final void mo3485o(boolean z3) {
        this.f5255h.f5339g = z3;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f5268u = true;
        this.f5254g.m3513c(true);
        ViewTreeObserver viewTreeObserver = this.f5267t;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f5267t = this.f5265r.getViewTreeObserver();
            }
            this.f5267t.removeGlobalOnLayoutListener(this.f5261n);
            this.f5267t = null;
        }
        this.f5265r.removeOnAttachStateChangeListener(this.f5262o);
        PopupWindow.OnDismissListener onDismissListener = this.f5263p;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i3 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // p108j.AbstractC1487u
    /* JADX INFO: renamed from: p */
    public final void mo3486p(int i3) {
        this.f5271x = i3;
    }

    @Override // p108j.AbstractC1487u
    /* JADX INFO: renamed from: q */
    public final void mo3487q(int i3) {
        this.f5260m.f5775j = i3;
    }

    @Override // p108j.AbstractC1487u
    /* JADX INFO: renamed from: r */
    public final void mo3488r(PopupWindow.OnDismissListener onDismissListener) {
        this.f5263p = onDismissListener;
    }

    @Override // p108j.AbstractC1487u
    /* JADX INFO: renamed from: s */
    public final void mo3489s(boolean z3) {
        this.f5272y = z3;
    }

    @Override // p108j.AbstractC1487u
    /* JADX INFO: renamed from: t */
    public final void mo3490t(int i3) {
        this.f5260m.m3704m(i3);
    }
}
