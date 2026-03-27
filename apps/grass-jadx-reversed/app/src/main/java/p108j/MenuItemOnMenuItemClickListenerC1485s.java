package p108j;

import android.view.MenuItem;

/* JADX INFO: renamed from: j.s */
/* JADX INFO: loaded from: classes.dex */
public final class MenuItemOnMenuItemClickListenerC1485s implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a */
    public final MenuItem.OnMenuItemClickListener f5406a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ MenuItemC1486t f5407b;

    public MenuItemOnMenuItemClickListenerC1485s(MenuItemC1486t menuItemC1486t, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f5407b = menuItemC1486t;
        this.f5406a = onMenuItemClickListener;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return this.f5406a.onMenuItemClick(this.f5407b.m2453h(menuItem));
    }
}
