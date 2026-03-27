package p108j;

import android.view.MenuItem;

/* JADX INFO: renamed from: j.r */
/* JADX INFO: loaded from: classes.dex */
public final class MenuItemOnActionExpandListenerC1484r implements MenuItem.OnActionExpandListener {

    /* JADX INFO: renamed from: a */
    public final MenuItem.OnActionExpandListener f5404a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ MenuItemC1486t f5405b;

    public MenuItemOnActionExpandListenerC1484r(MenuItemC1486t menuItemC1486t, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f5405b = menuItemC1486t;
        this.f5404a = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f5404a.onMenuItemActionCollapse(this.f5405b.m2453h(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f5404a.onMenuItemActionExpand(this.f5405b.m2453h(menuItem));
    }
}
