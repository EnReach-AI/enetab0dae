package p108j;

import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import p019F0.C0221e;

/* JADX INFO: renamed from: j.p */
/* JADX INFO: loaded from: classes.dex */
public final class ActionProviderVisibilityListenerC1482p implements ActionProvider.VisibilityListener {

    /* JADX INFO: renamed from: a */
    public final ActionProvider f5400a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ MenuItemC1486t f5401b;

    /* JADX INFO: renamed from: c */
    public C0221e f5402c;

    public ActionProviderVisibilityListenerC1482p(MenuItemC1486t menuItemC1486t, ActionProvider actionProvider) {
        this.f5401b = menuItemC1486t;
        this.f5400a = actionProvider;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3531a() {
        return this.f5400a.isVisible();
    }

    /* JADX INFO: renamed from: b */
    public final View m3532b(MenuItem menuItem) {
        return this.f5400a.onCreateActionView(menuItem);
    }

    /* JADX INFO: renamed from: c */
    public final boolean m3533c() {
        return this.f5400a.overridesItemVisibility();
    }

    /* JADX INFO: renamed from: d */
    public final void m3534d(C0221e c0221e) {
        this.f5402c = c0221e;
        this.f5400a.setVisibilityListener(this);
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z3) {
        C0221e c0221e = this.f5402c;
        if (c0221e != null) {
            MenuC1479m menuC1479m = ((C1481o) c0221e.f534f).f5387n;
            menuC1479m.f5351h = true;
            menuC1479m.m3518p(true);
        }
    }
}
