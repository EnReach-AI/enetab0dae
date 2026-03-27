package p108j;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import io.getgrass.www.R;
import java.util.WeakHashMap;
import p029J.AbstractC0308C;
import p029J.AbstractC0323S;

/* JADX INFO: renamed from: j.x */
/* JADX INFO: loaded from: classes.dex */
public class C1490x {

    /* JADX INFO: renamed from: a */
    public final Context f5412a;

    /* JADX INFO: renamed from: b */
    public final MenuC1479m f5413b;

    /* JADX INFO: renamed from: c */
    public final boolean f5414c;

    /* JADX INFO: renamed from: d */
    public final int f5415d;

    /* JADX INFO: renamed from: e */
    public final int f5416e;

    /* JADX INFO: renamed from: f */
    public View f5417f;

    /* JADX INFO: renamed from: h */
    public boolean f5419h;

    /* JADX INFO: renamed from: i */
    public InterfaceC1491y f5420i;

    /* JADX INFO: renamed from: j */
    public AbstractC1487u f5421j;

    /* JADX INFO: renamed from: k */
    public PopupWindow.OnDismissListener f5422k;

    /* JADX INFO: renamed from: g */
    public int f5418g = 8388611;

    /* JADX INFO: renamed from: l */
    public final C1488v f5423l = new C1488v(this);

    public C1490x(int i3, int i4, Context context, View view, MenuC1479m menuC1479m, boolean z3) {
        this.f5412a = context;
        this.f5413b = menuC1479m;
        this.f5417f = view;
        this.f5414c = z3;
        this.f5415d = i3;
        this.f5416e = i4;
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC1487u m3538a() {
        AbstractC1487u viewOnKeyListenerC1465E;
        if (this.f5421j == null) {
            Context context = this.f5412a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            AbstractC1489w.m3537a(defaultDisplay, point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                viewOnKeyListenerC1465E = new ViewOnKeyListenerC1473g(this.f5412a, this.f5417f, this.f5415d, this.f5416e, this.f5414c);
            } else {
                View view = this.f5417f;
                int i3 = this.f5416e;
                boolean z3 = this.f5414c;
                viewOnKeyListenerC1465E = new ViewOnKeyListenerC1465E(this.f5415d, i3, this.f5412a, view, this.f5413b, z3);
            }
            viewOnKeyListenerC1465E.mo3483l(this.f5413b);
            viewOnKeyListenerC1465E.mo3488r(this.f5423l);
            viewOnKeyListenerC1465E.mo3484n(this.f5417f);
            viewOnKeyListenerC1465E.mo3481i(this.f5420i);
            viewOnKeyListenerC1465E.mo3485o(this.f5419h);
            viewOnKeyListenerC1465E.mo3486p(this.f5418g);
            this.f5421j = viewOnKeyListenerC1465E;
        }
        return this.f5421j;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m3539b() {
        AbstractC1487u abstractC1487u = this.f5421j;
        return abstractC1487u != null && abstractC1487u.mo3475b();
    }

    /* JADX INFO: renamed from: c */
    public void mo3540c() {
        this.f5421j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f5422k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m3541d(int i3, int i4, boolean z3, boolean z4) {
        AbstractC1487u abstractC1487uM3538a = m3538a();
        abstractC1487uM3538a.mo3489s(z4);
        if (z3) {
            int i5 = this.f5418g;
            View view = this.f5417f;
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            if ((Gravity.getAbsoluteGravity(i5, AbstractC0308C.m607d(view)) & 7) == 5) {
                i3 -= this.f5417f.getWidth();
            }
            abstractC1487uM3538a.mo3487q(i3);
            abstractC1487uM3538a.mo3490t(i4);
            int i6 = (int) ((this.f5412a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            abstractC1487uM3538a.f5410e = new Rect(i3 - i6, i4 - i6, i3 + i6, i4 + i6);
        }
        abstractC1487uM3538a.mo3476f();
    }
}
