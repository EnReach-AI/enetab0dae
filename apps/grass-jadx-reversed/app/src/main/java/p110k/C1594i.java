package p110k;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import io.getgrass.www.R;
import java.util.ArrayList;
import p036L0.C0444d;
import p108j.AbstractC1487u;
import p108j.ActionProviderVisibilityListenerC1482p;
import p108j.C1481o;
import p108j.InterfaceC1461A;
import p108j.InterfaceC1462B;
import p108j.InterfaceC1491y;
import p108j.InterfaceC1492z;
import p108j.MenuC1479m;
import p108j.SubMenuC1466F;

/* JADX INFO: renamed from: k.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1594i implements InterfaceC1492z {

    /* JADX INFO: renamed from: e */
    public final Context f5641e;

    /* JADX INFO: renamed from: f */
    public Context f5642f;

    /* JADX INFO: renamed from: g */
    public MenuC1479m f5643g;

    /* JADX INFO: renamed from: h */
    public final LayoutInflater f5644h;

    /* JADX INFO: renamed from: i */
    public InterfaceC1491y f5645i;

    /* JADX INFO: renamed from: l */
    public InterfaceC1462B f5648l;

    /* JADX INFO: renamed from: m */
    public C1591h f5649m;

    /* JADX INFO: renamed from: n */
    public Drawable f5650n;

    /* JADX INFO: renamed from: o */
    public boolean f5651o;

    /* JADX INFO: renamed from: p */
    public boolean f5652p;

    /* JADX INFO: renamed from: q */
    public boolean f5653q;

    /* JADX INFO: renamed from: r */
    public int f5654r;

    /* JADX INFO: renamed from: s */
    public int f5655s;

    /* JADX INFO: renamed from: t */
    public int f5656t;

    /* JADX INFO: renamed from: u */
    public boolean f5657u;

    /* JADX INFO: renamed from: w */
    public C1582e f5659w;

    /* JADX INFO: renamed from: x */
    public C1582e f5660x;

    /* JADX INFO: renamed from: y */
    public RunnableC1588g f5661y;

    /* JADX INFO: renamed from: z */
    public C1585f f5662z;

    /* JADX INFO: renamed from: j */
    public final int f5646j = R.layout.abc_action_menu_layout;

    /* JADX INFO: renamed from: k */
    public final int f5647k = R.layout.abc_action_menu_item_layout;

    /* JADX INFO: renamed from: v */
    public final SparseBooleanArray f5658v = new SparseBooleanArray();

    /* JADX INFO: renamed from: A */
    public final C0444d f5640A = new C0444d(this);

    public C1594i(Context context) {
        this.f5641e = context;
        this.f5644h = LayoutInflater.from(context);
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: a */
    public final void mo3478a(MenuC1479m menuC1479m, boolean z3) {
        m3655f();
        C1582e c1582e = this.f5660x;
        if (c1582e != null && c1582e.m3539b()) {
            c1582e.f5421j.dismiss();
        }
        InterfaceC1491y interfaceC1491y = this.f5645i;
        if (interfaceC1491y != null) {
            interfaceC1491y.mo533a(menuC1479m, z3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: b */
    public final View m3654b(C1481o c1481o, View view, ViewGroup viewGroup) {
        View actionView = c1481o.getActionView();
        if (actionView == null || c1481o.m3528e()) {
            InterfaceC1461A interfaceC1461A = view instanceof InterfaceC1461A ? (InterfaceC1461A) view : (InterfaceC1461A) this.f5644h.inflate(this.f5647k, viewGroup, false);
            interfaceC1461A.mo2221d(c1481o);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) interfaceC1461A;
            actionMenuItemView.setItemInvoker((ActionMenuView) this.f5648l);
            if (this.f5662z == null) {
                this.f5662z = new C1585f(this);
            }
            actionMenuItemView.setPopupCallback(this.f5662z);
            actionView = (View) interfaceC1461A;
        }
        actionView.setVisibility(c1481o.f5373C ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof C1599k)) {
            actionView.setLayoutParams(ActionMenuView.m2242m(layoutParams));
        }
        return actionView;
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: c */
    public final void mo3506c(Context context, MenuC1479m menuC1479m) {
        this.f5642f = context;
        LayoutInflater.from(context);
        this.f5643g = menuC1479m;
        Resources resources = context.getResources();
        if (!this.f5653q) {
            this.f5652p = true;
        }
        int i3 = 2;
        this.f5654r = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i4 = configuration.screenWidthDp;
        int i5 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i4 > 600 || ((i4 > 960 && i5 > 720) || (i4 > 720 && i5 > 960))) {
            i3 = 5;
        } else if (i4 >= 500 || ((i4 > 640 && i5 > 480) || (i4 > 480 && i5 > 640))) {
            i3 = 4;
        } else if (i4 >= 360) {
            i3 = 3;
        }
        this.f5656t = i3;
        int measuredWidth = this.f5654r;
        if (this.f5652p) {
            if (this.f5649m == null) {
                C1591h c1591h = new C1591h(this, this.f5641e);
                this.f5649m = c1591h;
                if (this.f5651o) {
                    c1591h.setImageDrawable(this.f5650n);
                    this.f5650n = null;
                    this.f5651o = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f5649m.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f5649m.getMeasuredWidth();
        } else {
            this.f5649m = null;
        }
        this.f5655s = measuredWidth;
        float f3 = resources.getDisplayMetrics().density;
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: d */
    public final boolean mo3479d() {
        int size;
        ArrayList arrayListM3517l;
        int i3;
        boolean z3;
        MenuC1479m menuC1479m = this.f5643g;
        if (menuC1479m != null) {
            arrayListM3517l = menuC1479m.m3517l();
            size = arrayListM3517l.size();
        } else {
            size = 0;
            arrayListM3517l = null;
        }
        int i4 = this.f5656t;
        int i5 = this.f5655s;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f5648l;
        int i6 = 0;
        boolean z4 = false;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            i3 = 2;
            z3 = true;
            if (i6 >= size) {
                break;
            }
            C1481o c1481o = (C1481o) arrayListM3517l.get(i6);
            int i9 = c1481o.f5398y;
            if ((i9 & 2) == 2) {
                i7++;
            } else if ((i9 & 1) == 1) {
                i8++;
            } else {
                z4 = true;
            }
            if (this.f5657u && c1481o.f5373C) {
                i4 = 0;
            }
            i6++;
        }
        if (this.f5652p && (z4 || i8 + i7 > i4)) {
            i4--;
        }
        int i10 = i4 - i7;
        SparseBooleanArray sparseBooleanArray = this.f5658v;
        sparseBooleanArray.clear();
        int i11 = 0;
        int i12 = 0;
        while (i11 < size) {
            C1481o c1481o2 = (C1481o) arrayListM3517l.get(i11);
            int i13 = c1481o2.f5398y;
            boolean z5 = (i13 & 2) == i3 ? z3 : false;
            int i14 = c1481o2.f5375b;
            if (z5) {
                View viewM3654b = m3654b(c1481o2, null, viewGroup);
                viewM3654b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewM3654b.getMeasuredWidth();
                i5 -= measuredWidth;
                if (i12 == 0) {
                    i12 = measuredWidth;
                }
                if (i14 != 0) {
                    sparseBooleanArray.put(i14, z3);
                }
                c1481o2.m3530g(z3);
            } else if ((i13 & 1) == z3) {
                boolean z6 = sparseBooleanArray.get(i14);
                boolean z7 = ((i10 > 0 || z6) && i5 > 0) ? z3 : false;
                if (z7) {
                    View viewM3654b2 = m3654b(c1481o2, null, viewGroup);
                    viewM3654b2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    int measuredWidth2 = viewM3654b2.getMeasuredWidth();
                    i5 -= measuredWidth2;
                    if (i12 == 0) {
                        i12 = measuredWidth2;
                    }
                    z7 &= i5 + i12 > 0;
                }
                if (z7 && i14 != 0) {
                    sparseBooleanArray.put(i14, true);
                } else if (z6) {
                    sparseBooleanArray.put(i14, false);
                    for (int i15 = 0; i15 < i11; i15++) {
                        C1481o c1481o3 = (C1481o) arrayListM3517l.get(i15);
                        if (c1481o3.f5375b == i14) {
                            if (c1481o3.m3529f()) {
                                i10++;
                            }
                            c1481o3.m3530g(false);
                        }
                    }
                }
                if (z7) {
                    i10--;
                }
                c1481o2.m3530g(z7);
            } else {
                c1481o2.m3530g(false);
                i11++;
                i3 = 2;
                z3 = true;
            }
            i11++;
            i3 = 2;
            z3 = true;
        }
        return z3;
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: e */
    public final boolean mo3507e(C1481o c1481o) {
        return false;
    }

    /* JADX INFO: renamed from: f */
    public final boolean m3655f() {
        Object obj;
        RunnableC1588g runnableC1588g = this.f5661y;
        if (runnableC1588g != null && (obj = this.f5648l) != null) {
            ((View) obj).removeCallbacks(runnableC1588g);
            this.f5661y = null;
            return true;
        }
        C1582e c1582e = this.f5659w;
        if (c1582e == null) {
            return false;
        }
        if (c1582e.m3539b()) {
            c1582e.f5421j.dismiss();
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: g */
    public final void mo3480g() {
        int i3;
        ViewGroup viewGroup = (ViewGroup) this.f5648l;
        ArrayList arrayList = null;
        boolean z3 = false;
        if (viewGroup != null) {
            MenuC1479m menuC1479m = this.f5643g;
            if (menuC1479m != null) {
                menuC1479m.m3516i();
                ArrayList arrayListM3517l = this.f5643g.m3517l();
                int size = arrayListM3517l.size();
                i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    C1481o c1481o = (C1481o) arrayListM3517l.get(i4);
                    if (c1481o.m3529f()) {
                        View childAt = viewGroup.getChildAt(i3);
                        C1481o itemData = childAt instanceof InterfaceC1461A ? ((InterfaceC1461A) childAt).getItemData() : null;
                        View viewM3654b = m3654b(c1481o, childAt, viewGroup);
                        if (c1481o != itemData) {
                            viewM3654b.setPressed(false);
                            viewM3654b.jumpDrawablesToCurrentState();
                        }
                        if (viewM3654b != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) viewM3654b.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(viewM3654b);
                            }
                            ((ViewGroup) this.f5648l).addView(viewM3654b, i3);
                        }
                        i3++;
                    }
                }
            } else {
                i3 = 0;
            }
            while (i3 < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i3) == this.f5649m) {
                    i3++;
                } else {
                    viewGroup.removeViewAt(i3);
                }
            }
        }
        ((View) this.f5648l).requestLayout();
        MenuC1479m menuC1479m2 = this.f5643g;
        if (menuC1479m2 != null) {
            menuC1479m2.m3516i();
            ArrayList arrayList2 = menuC1479m2.f5352i;
            int size2 = arrayList2.size();
            for (int i5 = 0; i5 < size2; i5++) {
                ActionProviderVisibilityListenerC1482p actionProviderVisibilityListenerC1482p = ((C1481o) arrayList2.get(i5)).f5371A;
            }
        }
        MenuC1479m menuC1479m3 = this.f5643g;
        if (menuC1479m3 != null) {
            menuC1479m3.m3516i();
            arrayList = menuC1479m3.f5353j;
        }
        if (this.f5652p && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z3 = !((C1481o) arrayList.get(0)).f5373C;
            } else if (size3 > 0) {
                z3 = true;
            }
        }
        if (z3) {
            if (this.f5649m == null) {
                this.f5649m = new C1591h(this, this.f5641e);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f5649m.getParent();
            if (viewGroup3 != this.f5648l) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.f5649m);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f5648l;
                C1591h c1591h = this.f5649m;
                actionMenuView.getClass();
                C1599k c1599kM2241l = ActionMenuView.m2241l();
                c1599kM2241l.f5668a = true;
                actionMenuView.addView(c1591h, c1599kM2241l);
            }
        } else {
            C1591h c1591h2 = this.f5649m;
            if (c1591h2 != null) {
                Object parent = c1591h2.getParent();
                Object obj = this.f5648l;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f5649m);
                }
            }
        }
        ((ActionMenuView) this.f5648l).setOverflowReserved(this.f5652p);
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: h */
    public final boolean mo3508h(C1481o c1481o) {
        return false;
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: i */
    public final void mo3481i(InterfaceC1491y interfaceC1491y) {
        this.f5645i = interfaceC1491y;
    }

    /* JADX INFO: renamed from: j */
    public final boolean m3656j() {
        C1582e c1582e = this.f5659w;
        return c1582e != null && c1582e.m3539b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: k */
    public final boolean mo3482k(SubMenuC1466F subMenuC1466F) {
        boolean z3;
        if (!subMenuC1466F.hasVisibleItems()) {
            return false;
        }
        SubMenuC1466F subMenuC1466F2 = subMenuC1466F;
        while (true) {
            MenuC1479m menuC1479m = subMenuC1466F2.f5274z;
            if (menuC1479m == this.f5643g) {
                break;
            }
            subMenuC1466F2 = (SubMenuC1466F) menuC1479m;
        }
        ViewGroup viewGroup = (ViewGroup) this.f5648l;
        View view = null;
        view = null;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i3);
                if ((childAt instanceof InterfaceC1461A) && ((InterfaceC1461A) childAt).getItemData() == subMenuC1466F2.f5273A) {
                    view = childAt;
                    break;
                }
                i3++;
            }
        }
        if (view == null) {
            return false;
        }
        subMenuC1466F.f5273A.getClass();
        int size = subMenuC1466F.f5349f.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                z3 = false;
                break;
            }
            MenuItem item = subMenuC1466F.getItem(i4);
            if (item.isVisible() && item.getIcon() != null) {
                z3 = true;
                break;
            }
            i4++;
        }
        C1582e c1582e = new C1582e(this, this.f5642f, subMenuC1466F, view);
        this.f5660x = c1582e;
        c1582e.f5419h = z3;
        AbstractC1487u abstractC1487u = c1582e.f5421j;
        if (abstractC1487u != null) {
            abstractC1487u.mo3485o(z3);
        }
        C1582e c1582e2 = this.f5660x;
        if (!c1582e2.m3539b()) {
            if (c1582e2.f5417f == null) {
                throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
            }
            c1582e2.m3541d(0, 0, false, false);
        }
        InterfaceC1491y interfaceC1491y = this.f5645i;
        if (interfaceC1491y != null) {
            interfaceC1491y.mo534b(subMenuC1466F);
        }
        return true;
    }

    /* JADX INFO: renamed from: l */
    public final boolean m3657l() {
        MenuC1479m menuC1479m;
        if (!this.f5652p || m3656j() || (menuC1479m = this.f5643g) == null || this.f5648l == null || this.f5661y != null) {
            return false;
        }
        menuC1479m.m3516i();
        if (menuC1479m.f5353j.isEmpty()) {
            return false;
        }
        RunnableC1588g runnableC1588g = new RunnableC1588g(this, new C1582e(this, this.f5642f, this.f5643g, this.f5649m));
        this.f5661y = runnableC1588g;
        ((View) this.f5648l).post(runnableC1588g);
        return true;
    }
}
