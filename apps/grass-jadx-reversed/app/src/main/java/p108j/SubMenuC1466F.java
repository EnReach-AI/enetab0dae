package p108j;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: renamed from: j.F */
/* JADX INFO: loaded from: classes.dex */
public final class SubMenuC1466F extends MenuC1479m implements SubMenu {

    /* JADX INFO: renamed from: A */
    public final C1481o f5273A;

    /* JADX INFO: renamed from: z */
    public final MenuC1479m f5274z;

    public SubMenuC1466F(Context context, MenuC1479m menuC1479m, C1481o c1481o) {
        super(context);
        this.f5274z = menuC1479m;
        this.f5273A = c1481o;
    }

    @Override // p108j.MenuC1479m
    /* JADX INFO: renamed from: d */
    public final boolean mo3491d(C1481o c1481o) {
        return this.f5274z.mo3491d(c1481o);
    }

    @Override // p108j.MenuC1479m
    /* JADX INFO: renamed from: e */
    public final boolean mo3492e(MenuC1479m menuC1479m, MenuItem menuItem) {
        return super.mo3492e(menuC1479m, menuItem) || this.f5274z.mo3492e(menuC1479m, menuItem);
    }

    @Override // p108j.MenuC1479m
    /* JADX INFO: renamed from: f */
    public final boolean mo3493f(C1481o c1481o) {
        return this.f5274z.mo3493f(c1481o);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.f5273A;
    }

    @Override // p108j.MenuC1479m
    /* JADX INFO: renamed from: j */
    public final String mo3494j() {
        C1481o c1481o = this.f5273A;
        int i3 = c1481o != null ? c1481o.f5374a : 0;
        if (i3 == 0) {
            return null;
        }
        return "android:menu:actionviewstates:" + i3;
    }

    @Override // p108j.MenuC1479m
    /* JADX INFO: renamed from: k */
    public final MenuC1479m mo3495k() {
        return this.f5274z.mo3495k();
    }

    @Override // p108j.MenuC1479m
    /* JADX INFO: renamed from: m */
    public final boolean mo3496m() {
        return this.f5274z.mo3496m();
    }

    @Override // p108j.MenuC1479m
    /* JADX INFO: renamed from: n */
    public final boolean mo3497n() {
        return this.f5274z.mo3497n();
    }

    @Override // p108j.MenuC1479m
    /* JADX INFO: renamed from: o */
    public final boolean mo3498o() {
        return this.f5274z.mo3498o();
    }

    @Override // p108j.MenuC1479m, android.view.Menu
    public final void setGroupDividerEnabled(boolean z3) {
        this.f5274z.setGroupDividerEnabled(z3);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        m3523u(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        m3523u(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        m3523u(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.f5273A.setIcon(drawable);
        return this;
    }

    @Override // p108j.MenuC1479m, android.view.Menu
    public final void setQwertyMode(boolean z3) {
        this.f5274z.setQwertyMode(z3);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i3) {
        m3523u(0, null, i3, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i3) {
        m3523u(i3, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i3) {
        this.f5273A.setIcon(i3);
        return this;
    }
}
