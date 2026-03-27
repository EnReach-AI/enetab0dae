package p105i;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import p012D.InterfaceMenuItemC0174a;
import p029J.AbstractC0355m;
import p108j.ActionProviderVisibilityListenerC1482p;
import p108j.C1481o;
import p108j.MenuItemC1486t;

/* JADX INFO: renamed from: i.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1441i {

    /* JADX INFO: renamed from: A */
    public CharSequence f5096A;

    /* JADX INFO: renamed from: B */
    public CharSequence f5097B;

    /* JADX INFO: renamed from: E */
    public final /* synthetic */ C1442j f5100E;

    /* JADX INFO: renamed from: a */
    public final Menu f5101a;

    /* JADX INFO: renamed from: h */
    public boolean f5108h;

    /* JADX INFO: renamed from: i */
    public int f5109i;

    /* JADX INFO: renamed from: j */
    public int f5110j;

    /* JADX INFO: renamed from: k */
    public CharSequence f5111k;

    /* JADX INFO: renamed from: l */
    public CharSequence f5112l;

    /* JADX INFO: renamed from: m */
    public int f5113m;

    /* JADX INFO: renamed from: n */
    public char f5114n;

    /* JADX INFO: renamed from: o */
    public int f5115o;

    /* JADX INFO: renamed from: p */
    public char f5116p;

    /* JADX INFO: renamed from: q */
    public int f5117q;

    /* JADX INFO: renamed from: r */
    public int f5118r;

    /* JADX INFO: renamed from: s */
    public boolean f5119s;

    /* JADX INFO: renamed from: t */
    public boolean f5120t;

    /* JADX INFO: renamed from: u */
    public boolean f5121u;

    /* JADX INFO: renamed from: v */
    public int f5122v;

    /* JADX INFO: renamed from: w */
    public int f5123w;

    /* JADX INFO: renamed from: x */
    public String f5124x;

    /* JADX INFO: renamed from: y */
    public String f5125y;

    /* JADX INFO: renamed from: z */
    public ActionProviderVisibilityListenerC1482p f5126z;

    /* JADX INFO: renamed from: C */
    public ColorStateList f5098C = null;

    /* JADX INFO: renamed from: D */
    public PorterDuff.Mode f5099D = null;

    /* JADX INFO: renamed from: b */
    public int f5102b = 0;

    /* JADX INFO: renamed from: c */
    public int f5103c = 0;

    /* JADX INFO: renamed from: d */
    public int f5104d = 0;

    /* JADX INFO: renamed from: e */
    public int f5105e = 0;

    /* JADX INFO: renamed from: f */
    public boolean f5106f = true;

    /* JADX INFO: renamed from: g */
    public boolean f5107g = true;

    public C1441i(C1442j c1442j, Menu menu) {
        this.f5100E = c1442j;
        this.f5101a = menu;
    }

    /* JADX INFO: renamed from: a */
    public final Object m3446a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.f5100E.f5131c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e3) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e3);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m3447b(MenuItem menuItem) {
        boolean z3 = false;
        menuItem.setChecked(this.f5119s).setVisible(this.f5120t).setEnabled(this.f5121u).setCheckable(this.f5118r >= 1).setTitleCondensed(this.f5112l).setIcon(this.f5113m);
        int i3 = this.f5122v;
        if (i3 >= 0) {
            menuItem.setShowAsAction(i3);
        }
        String str = this.f5125y;
        C1442j c1442j = this.f5100E;
        if (str != null) {
            if (c1442j.f5131c.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            if (c1442j.f5132d == null) {
                c1442j.f5132d = C1442j.m3448a(c1442j.f5131c);
            }
            Object obj = c1442j.f5132d;
            String str2 = this.f5125y;
            MenuItemOnMenuItemClickListenerC1440h menuItemOnMenuItemClickListenerC1440h = new MenuItemOnMenuItemClickListenerC1440h();
            menuItemOnMenuItemClickListenerC1440h.f5094a = obj;
            Class<?> cls = obj.getClass();
            try {
                menuItemOnMenuItemClickListenerC1440h.f5095b = cls.getMethod(str2, MenuItemOnMenuItemClickListenerC1440h.f5093c);
                menuItem.setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC1440h);
            } catch (Exception e3) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str2 + " in class " + cls.getName());
                inflateException.initCause(e3);
                throw inflateException;
            }
        }
        if (this.f5118r >= 2) {
            if (menuItem instanceof C1481o) {
                C1481o c1481o = (C1481o) menuItem;
                c1481o.f5397x = (c1481o.f5397x & (-5)) | 4;
            } else if (menuItem instanceof MenuItemC1486t) {
                MenuItemC1486t menuItemC1486t = (MenuItemC1486t) menuItem;
                try {
                    Method method = menuItemC1486t.f5409d;
                    InterfaceMenuItemC0174a interfaceMenuItemC0174a = menuItemC1486t.f5408c;
                    if (method == null) {
                        menuItemC1486t.f5409d = interfaceMenuItemC0174a.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    menuItemC1486t.f5409d.invoke(interfaceMenuItemC0174a, Boolean.TRUE);
                } catch (Exception e4) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e4);
                }
            }
        }
        String str3 = this.f5124x;
        if (str3 != null) {
            menuItem.setActionView((View) m3446a(str3, C1442j.f5127e, c1442j.f5129a));
            z3 = true;
        }
        int i4 = this.f5123w;
        if (i4 > 0) {
            if (z3) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i4);
            }
        }
        ActionProviderVisibilityListenerC1482p actionProviderVisibilityListenerC1482p = this.f5126z;
        if (actionProviderVisibilityListenerC1482p != null) {
            if (menuItem instanceof InterfaceMenuItemC0174a) {
                ((InterfaceMenuItemC0174a) menuItem).mo300a(actionProviderVisibilityListenerC1482p);
            } else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
        CharSequence charSequence = this.f5096A;
        boolean z4 = menuItem instanceof InterfaceMenuItemC0174a;
        if (z4) {
            ((InterfaceMenuItemC0174a) menuItem).setContentDescription(charSequence);
        } else {
            AbstractC0355m.m787h(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.f5097B;
        if (z4) {
            ((InterfaceMenuItemC0174a) menuItem).setTooltipText(charSequence2);
        } else {
            AbstractC0355m.m792m(menuItem, charSequence2);
        }
        char c3 = this.f5114n;
        int i5 = this.f5115o;
        if (z4) {
            ((InterfaceMenuItemC0174a) menuItem).setAlphabeticShortcut(c3, i5);
        } else {
            AbstractC0355m.m786g(menuItem, c3, i5);
        }
        char c4 = this.f5116p;
        int i6 = this.f5117q;
        if (z4) {
            ((InterfaceMenuItemC0174a) menuItem).setNumericShortcut(c4, i6);
        } else {
            AbstractC0355m.m790k(menuItem, c4, i6);
        }
        PorterDuff.Mode mode = this.f5099D;
        if (mode != null) {
            if (z4) {
                ((InterfaceMenuItemC0174a) menuItem).setIconTintMode(mode);
            } else {
                AbstractC0355m.m789j(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.f5098C;
        if (colorStateList != null) {
            if (z4) {
                ((InterfaceMenuItemC0174a) menuItem).setIconTintList(colorStateList);
            } else {
                AbstractC0355m.m788i(menuItem, colorStateList);
            }
        }
    }
}
