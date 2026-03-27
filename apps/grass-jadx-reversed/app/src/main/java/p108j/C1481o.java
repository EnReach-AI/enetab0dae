package p108j;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import p009C.AbstractC0139b;
import p012D.InterfaceMenuItemC0174a;
import p019F0.C0221e;
import p125o0.AbstractC1800j;

/* JADX INFO: renamed from: j.o */
/* JADX INFO: loaded from: classes.dex */
public final class C1481o implements InterfaceMenuItemC0174a {

    /* JADX INFO: renamed from: A */
    public ActionProviderVisibilityListenerC1482p f5371A;

    /* JADX INFO: renamed from: B */
    public MenuItem.OnActionExpandListener f5372B;

    /* JADX INFO: renamed from: a */
    public final int f5374a;

    /* JADX INFO: renamed from: b */
    public final int f5375b;

    /* JADX INFO: renamed from: c */
    public final int f5376c;

    /* JADX INFO: renamed from: d */
    public final int f5377d;

    /* JADX INFO: renamed from: e */
    public CharSequence f5378e;

    /* JADX INFO: renamed from: f */
    public CharSequence f5379f;

    /* JADX INFO: renamed from: g */
    public Intent f5380g;

    /* JADX INFO: renamed from: h */
    public char f5381h;

    /* JADX INFO: renamed from: j */
    public char f5383j;

    /* JADX INFO: renamed from: l */
    public Drawable f5385l;

    /* JADX INFO: renamed from: n */
    public final MenuC1479m f5387n;

    /* JADX INFO: renamed from: o */
    public SubMenuC1466F f5388o;

    /* JADX INFO: renamed from: p */
    public MenuItem.OnMenuItemClickListener f5389p;

    /* JADX INFO: renamed from: q */
    public CharSequence f5390q;

    /* JADX INFO: renamed from: r */
    public CharSequence f5391r;

    /* JADX INFO: renamed from: y */
    public int f5398y;

    /* JADX INFO: renamed from: z */
    public View f5399z;

    /* JADX INFO: renamed from: i */
    public int f5382i = 4096;

    /* JADX INFO: renamed from: k */
    public int f5384k = 4096;

    /* JADX INFO: renamed from: m */
    public int f5386m = 0;

    /* JADX INFO: renamed from: s */
    public ColorStateList f5392s = null;

    /* JADX INFO: renamed from: t */
    public PorterDuff.Mode f5393t = null;

    /* JADX INFO: renamed from: u */
    public boolean f5394u = false;

    /* JADX INFO: renamed from: v */
    public boolean f5395v = false;

    /* JADX INFO: renamed from: w */
    public boolean f5396w = false;

    /* JADX INFO: renamed from: x */
    public int f5397x = 16;

    /* JADX INFO: renamed from: C */
    public boolean f5373C = false;

    public C1481o(MenuC1479m menuC1479m, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7) {
        this.f5387n = menuC1479m;
        this.f5374a = i4;
        this.f5375b = i3;
        this.f5376c = i5;
        this.f5377d = i6;
        this.f5378e = charSequence;
        this.f5398y = i7;
    }

    /* JADX INFO: renamed from: c */
    public static void m3526c(int i3, int i4, String str, StringBuilder sb) {
        if ((i3 & i4) == i4) {
            sb.append(str);
        }
    }

    @Override // p012D.InterfaceMenuItemC0174a
    /* JADX INFO: renamed from: a */
    public final InterfaceMenuItemC0174a mo300a(ActionProviderVisibilityListenerC1482p actionProviderVisibilityListenerC1482p) {
        ActionProviderVisibilityListenerC1482p actionProviderVisibilityListenerC1482p2 = this.f5371A;
        if (actionProviderVisibilityListenerC1482p2 != null) {
            actionProviderVisibilityListenerC1482p2.getClass();
        }
        this.f5399z = null;
        this.f5371A = actionProviderVisibilityListenerC1482p;
        this.f5387n.m3518p(true);
        ActionProviderVisibilityListenerC1482p actionProviderVisibilityListenerC1482p3 = this.f5371A;
        if (actionProviderVisibilityListenerC1482p3 != null) {
            actionProviderVisibilityListenerC1482p3.m3534d(new C0221e(17, this));
        }
        return this;
    }

    @Override // p012D.InterfaceMenuItemC0174a
    /* JADX INFO: renamed from: b */
    public final ActionProviderVisibilityListenerC1482p mo301b() {
        return this.f5371A;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.f5398y & 8) == 0) {
            return false;
        }
        if (this.f5399z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f5372B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f5387n.mo3491d(this);
        }
        return false;
    }

    /* JADX INFO: renamed from: d */
    public final Drawable m3527d(Drawable drawable) {
        if (drawable != null && this.f5396w && (this.f5394u || this.f5395v)) {
            drawable = drawable.mutate();
            if (this.f5394u) {
                AbstractC0139b.m280h(drawable, this.f5392s);
            }
            if (this.f5395v) {
                AbstractC0139b.m281i(drawable, this.f5393t);
            }
            this.f5396w = false;
        }
        return drawable;
    }

    /* JADX INFO: renamed from: e */
    public final boolean m3528e() {
        ActionProviderVisibilityListenerC1482p actionProviderVisibilityListenerC1482p;
        if ((this.f5398y & 8) == 0) {
            return false;
        }
        if (this.f5399z == null && (actionProviderVisibilityListenerC1482p = this.f5371A) != null) {
            this.f5399z = actionProviderVisibilityListenerC1482p.m3532b(this);
        }
        return this.f5399z != null;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!m3528e()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f5372B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f5387n.mo3493f(this);
        }
        return false;
    }

    /* JADX INFO: renamed from: f */
    public final boolean m3529f() {
        return (this.f5397x & 32) == 32;
    }

    /* JADX INFO: renamed from: g */
    public final void m3530g(boolean z3) {
        if (z3) {
            this.f5397x |= 32;
        } else {
            this.f5397x &= -33;
        }
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.f5399z;
        if (view != null) {
            return view;
        }
        ActionProviderVisibilityListenerC1482p actionProviderVisibilityListenerC1482p = this.f5371A;
        if (actionProviderVisibilityListenerC1482p == null) {
            return null;
        }
        View viewM3532b = actionProviderVisibilityListenerC1482p.m3532b(this);
        this.f5399z = viewM3532b;
        return viewM3532b;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f5384k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f5383j;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f5390q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f5375b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f5385l;
        if (drawable != null) {
            return m3527d(drawable);
        }
        int i3 = this.f5386m;
        if (i3 == 0) {
            return null;
        }
        Drawable drawableM3991i = AbstractC1800j.m3991i(this.f5387n.f5344a, i3);
        this.f5386m = 0;
        this.f5385l = drawableM3991i;
        return m3527d(drawableM3991i);
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f5392s;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f5393t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f5380g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f5374a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f5382i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f5381h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f5376c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f5388o;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f5378e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f5379f;
        return charSequence != null ? charSequence : this.f5378e;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f5391r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f5388o != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.f5373C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f5397x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f5397x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f5397x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        ActionProviderVisibilityListenerC1482p actionProviderVisibilityListenerC1482p = this.f5371A;
        return (actionProviderVisibilityListenerC1482p == null || !actionProviderVisibilityListenerC1482p.m3533c()) ? (this.f5397x & 8) == 0 : (this.f5397x & 8) == 0 && this.f5371A.m3531a();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i3;
        this.f5399z = view;
        this.f5371A = null;
        if (view != null && view.getId() == -1 && (i3 = this.f5374a) > 0) {
            view.setId(i3);
        }
        MenuC1479m menuC1479m = this.f5387n;
        menuC1479m.f5354k = true;
        menuC1479m.m3518p(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c3) {
        if (this.f5383j == c3) {
            return this;
        }
        this.f5383j = Character.toLowerCase(c3);
        this.f5387n.m3518p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z3) {
        int i3 = this.f5397x;
        int i4 = (z3 ? 1 : 0) | (i3 & (-2));
        this.f5397x = i4;
        if (i3 != i4) {
            this.f5387n.m3518p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z3) {
        int i3 = this.f5397x;
        if ((i3 & 4) != 0) {
            MenuC1479m menuC1479m = this.f5387n;
            menuC1479m.getClass();
            ArrayList arrayList = menuC1479m.f5349f;
            int size = arrayList.size();
            menuC1479m.m3525w();
            for (int i4 = 0; i4 < size; i4++) {
                C1481o c1481o = (C1481o) arrayList.get(i4);
                if (c1481o.f5375b == this.f5375b && (c1481o.f5397x & 4) != 0 && c1481o.isCheckable()) {
                    boolean z4 = c1481o == this;
                    int i5 = c1481o.f5397x;
                    int i6 = (z4 ? 2 : 0) | (i5 & (-3));
                    c1481o.f5397x = i6;
                    if (i5 != i6) {
                        c1481o.f5387n.m3518p(false);
                    }
                }
            }
            menuC1479m.m3524v();
        } else {
            int i7 = (i3 & (-3)) | (z3 ? 2 : 0);
            this.f5397x = i7;
            if (i3 != i7) {
                this.f5387n.m3518p(false);
            }
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z3) {
        if (z3) {
            this.f5397x |= 16;
        } else {
            this.f5397x &= -17;
        }
        this.f5387n.m3518p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f5386m = 0;
        this.f5385l = drawable;
        this.f5396w = true;
        this.f5387n.m3518p(false);
        return this;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f5392s = colorStateList;
        this.f5394u = true;
        this.f5396w = true;
        this.f5387n.m3518p(false);
        return this;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f5393t = mode;
        this.f5395v = true;
        this.f5396w = true;
        this.f5387n.m3518p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f5380g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c3) {
        if (this.f5381h == c3) {
            return this;
        }
        this.f5381h = c3;
        this.f5387n.m3518p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f5372B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f5389p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c3, char c4) {
        this.f5381h = c3;
        this.f5383j = Character.toLowerCase(c4);
        this.f5387n.m3518p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i3) {
        int i4 = i3 & 3;
        if (i4 != 0 && i4 != 1 && i4 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f5398y = i3;
        MenuC1479m menuC1479m = this.f5387n;
        menuC1479m.f5354k = true;
        menuC1479m.m3518p(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i3) {
        setShowAsAction(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f5378e = charSequence;
        this.f5387n.m3518p(false);
        SubMenuC1466F subMenuC1466F = this.f5388o;
        if (subMenuC1466F != null) {
            subMenuC1466F.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f5379f = charSequence;
        this.f5387n.m3518p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z3) {
        int i3 = this.f5397x;
        int i4 = (z3 ? 0 : 8) | (i3 & (-9));
        this.f5397x = i4;
        if (i3 != i4) {
            MenuC1479m menuC1479m = this.f5387n;
            menuC1479m.f5351h = true;
            menuC1479m.m3518p(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f5378e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final InterfaceMenuItemC0174a setContentDescription(CharSequence charSequence) {
        this.f5390q = charSequence;
        this.f5387n.m3518p(false);
        return this;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final InterfaceMenuItemC0174a setTooltipText(CharSequence charSequence) {
        this.f5391r = charSequence;
        this.f5387n.m3518p(false);
        return this;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c3, int i3) {
        if (this.f5383j == c3 && this.f5384k == i3) {
            return this;
        }
        this.f5383j = Character.toLowerCase(c3);
        this.f5384k = KeyEvent.normalizeMetaState(i3);
        this.f5387n.m3518p(false);
        return this;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c3, int i3) {
        if (this.f5381h == c3 && this.f5382i == i3) {
            return this;
        }
        this.f5381h = c3;
        this.f5382i = KeyEvent.normalizeMetaState(i3);
        this.f5387n.m3518p(false);
        return this;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final MenuItem setShortcut(char c3, char c4, int i3, int i4) {
        this.f5381h = c3;
        this.f5382i = KeyEvent.normalizeMetaState(i3);
        this.f5383j = Character.toLowerCase(c4);
        this.f5384k = KeyEvent.normalizeMetaState(i4);
        this.f5387n.m3518p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i3) {
        this.f5385l = null;
        this.f5386m = i3;
        this.f5396w = true;
        this.f5387n.m3518p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i3) {
        setTitle(this.f5387n.f5344a.getString(i3));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i3) {
        int i4;
        Context context = this.f5387n.f5344a;
        View viewInflate = LayoutInflater.from(context).inflate(i3, (ViewGroup) new LinearLayout(context), false);
        this.f5399z = viewInflate;
        this.f5371A = null;
        if (viewInflate != null && viewInflate.getId() == -1 && (i4 = this.f5374a) > 0) {
            viewInflate.setId(i4);
        }
        MenuC1479m menuC1479m = this.f5387n;
        menuC1479m.f5354k = true;
        menuC1479m.m3518p(true);
        return this;
    }
}
