package p108j;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import io.getgrass.www.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import p029J.AbstractC0308C;
import p029J.AbstractC0323S;
import p034K1.ViewOnAttachStateChangeListenerC0428o;
import p036L0.C0444d;
import p110k.AbstractC1520A0;
import p110k.C1528E0;
import p110k.C1604m0;

/* JADX INFO: renamed from: j.g */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnKeyListenerC1473g extends AbstractC1487u implements View.OnKeyListener, PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: A */
    public boolean f5303A;

    /* JADX INFO: renamed from: B */
    public InterfaceC1491y f5304B;

    /* JADX INFO: renamed from: C */
    public ViewTreeObserver f5305C;

    /* JADX INFO: renamed from: D */
    public PopupWindow.OnDismissListener f5306D;

    /* JADX INFO: renamed from: E */
    public boolean f5307E;

    /* JADX INFO: renamed from: f */
    public final Context f5308f;

    /* JADX INFO: renamed from: g */
    public final int f5309g;

    /* JADX INFO: renamed from: h */
    public final int f5310h;

    /* JADX INFO: renamed from: i */
    public final int f5311i;

    /* JADX INFO: renamed from: j */
    public final boolean f5312j;

    /* JADX INFO: renamed from: k */
    public final Handler f5313k;

    /* JADX INFO: renamed from: s */
    public View f5321s;

    /* JADX INFO: renamed from: t */
    public View f5322t;

    /* JADX INFO: renamed from: u */
    public int f5323u;

    /* JADX INFO: renamed from: v */
    public boolean f5324v;

    /* JADX INFO: renamed from: w */
    public boolean f5325w;

    /* JADX INFO: renamed from: x */
    public int f5326x;

    /* JADX INFO: renamed from: y */
    public int f5327y;

    /* JADX INFO: renamed from: l */
    public final ArrayList f5314l = new ArrayList();

    /* JADX INFO: renamed from: m */
    public final ArrayList f5315m = new ArrayList();

    /* JADX INFO: renamed from: n */
    public final ViewTreeObserverOnGlobalLayoutListenerC1470d f5316n = new ViewTreeObserverOnGlobalLayoutListenerC1470d(0, this);

    /* JADX INFO: renamed from: o */
    public final ViewOnAttachStateChangeListenerC0428o f5317o = new ViewOnAttachStateChangeListenerC0428o(2, this);

    /* JADX INFO: renamed from: p */
    public final C0444d f5318p = new C0444d(this);

    /* JADX INFO: renamed from: q */
    public int f5319q = 0;

    /* JADX INFO: renamed from: r */
    public int f5320r = 0;

    /* JADX INFO: renamed from: z */
    public boolean f5328z = false;

    public ViewOnKeyListenerC1473g(Context context, View view, int i3, int i4, boolean z3) {
        this.f5308f = context;
        this.f5321s = view;
        this.f5310h = i3;
        this.f5311i = i4;
        this.f5312j = z3;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        this.f5323u = AbstractC0308C.m607d(view) != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f5309g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f5313k = new Handler();
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: a */
    public final void mo3478a(MenuC1479m menuC1479m, boolean z3) {
        ArrayList arrayList = this.f5315m;
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (menuC1479m == ((C1472f) arrayList.get(i3)).f5301b) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 < 0) {
            return;
        }
        int i4 = i3 + 1;
        if (i4 < arrayList.size()) {
            ((C1472f) arrayList.get(i4)).f5301b.m3513c(false);
        }
        C1472f c1472f = (C1472f) arrayList.remove(i3);
        c1472f.f5301b.m3520r(this);
        boolean z4 = this.f5307E;
        C1528E0 c1528e0 = c1472f.f5300a;
        if (z4) {
            AbstractC1520A0.m3564b(c1528e0.f5769D, null);
            c1528e0.f5769D.setAnimationStyle(0);
        }
        c1528e0.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.f5323u = ((C1472f) arrayList.get(size2 - 1)).f5302c;
        } else {
            View view = this.f5321s;
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            this.f5323u = AbstractC0308C.m607d(view) == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z3) {
                ((C1472f) arrayList.get(0)).f5301b.m3513c(false);
                return;
            }
            return;
        }
        dismiss();
        InterfaceC1491y interfaceC1491y = this.f5304B;
        if (interfaceC1491y != null) {
            interfaceC1491y.mo533a(menuC1479m, true);
        }
        ViewTreeObserver viewTreeObserver = this.f5305C;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f5305C.removeGlobalOnLayoutListener(this.f5316n);
            }
            this.f5305C = null;
        }
        this.f5322t.removeOnAttachStateChangeListener(this.f5317o);
        this.f5306D.onDismiss();
    }

    @Override // p108j.InterfaceC1464D
    /* JADX INFO: renamed from: b */
    public final boolean mo3475b() {
        ArrayList arrayList = this.f5315m;
        return arrayList.size() > 0 && ((C1472f) arrayList.get(0)).f5300a.f5769D.isShowing();
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: d */
    public final boolean mo3479d() {
        return false;
    }

    @Override // p108j.InterfaceC1464D
    public final void dismiss() {
        ArrayList arrayList = this.f5315m;
        int size = arrayList.size();
        if (size > 0) {
            C1472f[] c1472fArr = (C1472f[]) arrayList.toArray(new C1472f[size]);
            for (int i3 = size - 1; i3 >= 0; i3--) {
                C1472f c1472f = c1472fArr[i3];
                if (c1472f.f5300a.f5769D.isShowing()) {
                    c1472f.f5300a.dismiss();
                }
            }
        }
    }

    @Override // p108j.InterfaceC1464D
    /* JADX INFO: renamed from: f */
    public final void mo3476f() {
        if (mo3475b()) {
            return;
        }
        ArrayList arrayList = this.f5314l;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m3503v((MenuC1479m) it.next());
        }
        arrayList.clear();
        View view = this.f5321s;
        this.f5322t = view;
        if (view != null) {
            boolean z3 = this.f5305C == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f5305C = viewTreeObserver;
            if (z3) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f5316n);
            }
            this.f5322t.addOnAttachStateChangeListener(this.f5317o);
        }
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: g */
    public final void mo3480g() {
        Iterator it = this.f5315m.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((C1472f) it.next()).f5300a.f5772g.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((C1476j) adapter).notifyDataSetChanged();
        }
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: i */
    public final void mo3481i(InterfaceC1491y interfaceC1491y) {
        this.f5304B = interfaceC1491y;
    }

    @Override // p108j.InterfaceC1464D
    /* JADX INFO: renamed from: j */
    public final C1604m0 mo3477j() {
        ArrayList arrayList = this.f5315m;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((C1472f) arrayList.get(arrayList.size() - 1)).f5300a.f5772g;
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: k */
    public final boolean mo3482k(SubMenuC1466F subMenuC1466F) {
        for (C1472f c1472f : this.f5315m) {
            if (subMenuC1466F == c1472f.f5301b) {
                c1472f.f5300a.f5772g.requestFocus();
                return true;
            }
        }
        if (!subMenuC1466F.hasVisibleItems()) {
            return false;
        }
        mo3483l(subMenuC1466F);
        InterfaceC1491y interfaceC1491y = this.f5304B;
        if (interfaceC1491y != null) {
            interfaceC1491y.mo534b(subMenuC1466F);
        }
        return true;
    }

    @Override // p108j.AbstractC1487u
    /* JADX INFO: renamed from: l */
    public final void mo3483l(MenuC1479m menuC1479m) {
        menuC1479m.m3512b(this, this.f5308f);
        if (mo3475b()) {
            m3503v(menuC1479m);
        } else {
            this.f5314l.add(menuC1479m);
        }
    }

    @Override // p108j.AbstractC1487u
    /* JADX INFO: renamed from: n */
    public final void mo3484n(View view) {
        if (this.f5321s != view) {
            this.f5321s = view;
            int i3 = this.f5319q;
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            this.f5320r = Gravity.getAbsoluteGravity(i3, AbstractC0308C.m607d(view));
        }
    }

    @Override // p108j.AbstractC1487u
    /* JADX INFO: renamed from: o */
    public final void mo3485o(boolean z3) {
        this.f5328z = z3;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        C1472f c1472f;
        ArrayList arrayList = this.f5315m;
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                c1472f = null;
                break;
            }
            c1472f = (C1472f) arrayList.get(i3);
            if (!c1472f.f5300a.f5769D.isShowing()) {
                break;
            } else {
                i3++;
            }
        }
        if (c1472f != null) {
            c1472f.f5301b.m3513c(false);
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
        if (this.f5319q != i3) {
            this.f5319q = i3;
            View view = this.f5321s;
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            this.f5320r = Gravity.getAbsoluteGravity(i3, AbstractC0308C.m607d(view));
        }
    }

    @Override // p108j.AbstractC1487u
    /* JADX INFO: renamed from: q */
    public final void mo3487q(int i3) {
        this.f5324v = true;
        this.f5326x = i3;
    }

    @Override // p108j.AbstractC1487u
    /* JADX INFO: renamed from: r */
    public final void mo3488r(PopupWindow.OnDismissListener onDismissListener) {
        this.f5306D = onDismissListener;
    }

    @Override // p108j.AbstractC1487u
    /* JADX INFO: renamed from: s */
    public final void mo3489s(boolean z3) {
        this.f5303A = z3;
    }

    @Override // p108j.AbstractC1487u
    /* JADX INFO: renamed from: t */
    public final void mo3490t(int i3) {
        this.f5325w = true;
        this.f5327y = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x017c  */
    /* JADX INFO: renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3503v(p108j.MenuC1479m r17) {
        /*
            Method dump skipped, instruction units count: 472
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p108j.ViewOnKeyListenerC1473g.m3503v(j.m):void");
    }
}
