package p110k;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import p105i.InterfaceC1435c;
import p108j.C1481o;
import p108j.InterfaceC1492z;
import p108j.MenuC1479m;
import p108j.SubMenuC1466F;

/* JADX INFO: renamed from: k.Z0 */
/* JADX INFO: loaded from: classes.dex */
public final class C1569Z0 implements InterfaceC1492z {

    /* JADX INFO: renamed from: e */
    public MenuC1479m f5592e;

    /* JADX INFO: renamed from: f */
    public C1481o f5593f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Toolbar f5594g;

    public C1569Z0(Toolbar toolbar) {
        this.f5594g = toolbar;
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: a */
    public final void mo3478a(MenuC1479m menuC1479m, boolean z3) {
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: c */
    public final void mo3506c(Context context, MenuC1479m menuC1479m) {
        C1481o c1481o;
        MenuC1479m menuC1479m2 = this.f5592e;
        if (menuC1479m2 != null && (c1481o = this.f5593f) != null) {
            menuC1479m2.mo3491d(c1481o);
        }
        this.f5592e = menuC1479m;
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: d */
    public final boolean mo3479d() {
        return false;
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: e */
    public final boolean mo3507e(C1481o c1481o) {
        Toolbar toolbar = this.f5594g;
        toolbar.m2271c();
        ViewParent parent = toolbar.f2837l.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.f2837l);
            }
            toolbar.addView(toolbar.f2837l);
        }
        View actionView = c1481o.getActionView();
        toolbar.f2838m = actionView;
        this.f5593f = c1481o;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.f2838m);
            }
            C1572a1 c1572a1M2265h = Toolbar.m2265h();
            c1572a1M2265h.f5596a = (toolbar.f2843r & 112) | 8388611;
            c1572a1M2265h.f5597b = 2;
            toolbar.f2838m.setLayoutParams(c1572a1M2265h);
            toolbar.addView(toolbar.f2838m);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((C1572a1) childAt.getLayoutParams()).f5597b != 2 && childAt != toolbar.f2830e) {
                toolbar.removeViewAt(childCount);
                toolbar.f2818I.add(childAt);
            }
        }
        toolbar.requestLayout();
        c1481o.f5373C = true;
        c1481o.f5387n.m3518p(false);
        KeyEvent.Callback callback = toolbar.f2838m;
        if (callback instanceof InterfaceC1435c) {
            ((InterfaceC1435c) callback).mo2248c();
        }
        toolbar.m2284t();
        return true;
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: g */
    public final void mo3480g() {
        if (this.f5593f != null) {
            MenuC1479m menuC1479m = this.f5592e;
            if (menuC1479m != null) {
                int size = menuC1479m.f5349f.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (this.f5592e.getItem(i3) == this.f5593f) {
                        return;
                    }
                }
            }
            mo3508h(this.f5593f);
        }
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: h */
    public final boolean mo3508h(C1481o c1481o) {
        Toolbar toolbar = this.f5594g;
        KeyEvent.Callback callback = toolbar.f2838m;
        if (callback instanceof InterfaceC1435c) {
            ((InterfaceC1435c) callback).mo2249e();
        }
        toolbar.removeView(toolbar.f2838m);
        toolbar.removeView(toolbar.f2837l);
        toolbar.f2838m = null;
        ArrayList arrayList = toolbar.f2818I;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f5593f = null;
        toolbar.requestLayout();
        c1481o.f5373C = false;
        c1481o.f5387n.m3518p(false);
        toolbar.m2284t();
        return true;
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: k */
    public final boolean mo3482k(SubMenuC1466F subMenuC1466F) {
        return false;
    }
}
