package androidx.fragment.app;

import android.content.Context;
import android.content.IntentFilter;
import android.view.MenuItem;
import java.util.HashSet;
import p012D.InterfaceMenuItemC0174a;
import p018F.C0210b;
import p098g.LayoutInflaterFactory2C1382u;
import p108j.MenuItemC1486t;
import p128p.C1817k;
import p166z0.C2065c;

/* JADX INFO: renamed from: androidx.fragment.app.f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0935f {

    /* JADX INFO: renamed from: a */
    public Object f3160a;

    /* JADX INFO: renamed from: b */
    public Object f3161b;

    public /* synthetic */ AbstractC0935f(Object obj, Object obj2) {
        this.f3160a = obj;
        this.f3161b = obj2;
    }

    /* JADX INFO: renamed from: c */
    public abstract void mo2448c(Object obj);

    /* JADX INFO: renamed from: d */
    public void m2449d() {
        C2065c c2065c = (C2065c) this.f3160a;
        if (c2065c != null) {
            try {
                ((LayoutInflaterFactory2C1382u) this.f3161b).f4990o.unregisterReceiver(c2065c);
            } catch (IllegalArgumentException unused) {
            }
            this.f3160a = null;
        }
    }

    /* JADX INFO: renamed from: e */
    public void m2450e() {
        C0928N c0928n = (C0928N) this.f3160a;
        HashSet hashSet = c0928n.f3113e;
        if (hashSet.remove((C0210b) this.f3161b) && hashSet.isEmpty()) {
            c0928n.m2436b();
        }
    }

    /* JADX INFO: renamed from: f */
    public abstract IntentFilter mo2451f();

    /* JADX INFO: renamed from: g */
    public abstract int mo2452g();

    /* JADX INFO: renamed from: h */
    public MenuItem m2453h(MenuItem menuItem) {
        if (!(menuItem instanceof InterfaceMenuItemC0174a)) {
            return menuItem;
        }
        InterfaceMenuItemC0174a interfaceMenuItemC0174a = (InterfaceMenuItemC0174a) menuItem;
        if (((C1817k) this.f3161b) == null) {
            this.f3161b = new C1817k();
        }
        MenuItem menuItem2 = (MenuItem) ((C1817k) this.f3161b).getOrDefault(interfaceMenuItemC0174a, null);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemC1486t menuItemC1486t = new MenuItemC1486t((Context) this.f3160a, interfaceMenuItemC0174a);
        ((C1817k) this.f3161b).put(interfaceMenuItemC0174a, menuItemC1486t);
        return menuItemC1486t;
    }

    /* JADX INFO: renamed from: i */
    public abstract void mo2454i();

    /* JADX INFO: renamed from: j */
    public void m2455j() {
        m2449d();
        IntentFilter intentFilterMo2451f = mo2451f();
        if (intentFilterMo2451f.countActions() == 0) {
            return;
        }
        if (((C2065c) this.f3160a) == null) {
            this.f3160a = new C2065c(3, this);
        }
        ((LayoutInflaterFactory2C1382u) this.f3161b).f4990o.registerReceiver((C2065c) this.f3160a, intentFilterMo2451f);
    }

    public AbstractC0935f(Context context) {
        this.f3160a = context;
    }

    public AbstractC0935f(LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u) {
        this.f3161b = layoutInflaterFactory2C1382u;
    }
}
