package p108j;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import p009C.AbstractC0139b;
import p012D.InterfaceMenuItemC0174a;
import p165z.AbstractC2047c;

/* JADX INFO: renamed from: j.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1467a implements InterfaceMenuItemC0174a {

    /* JADX INFO: renamed from: a */
    public CharSequence f5275a;

    /* JADX INFO: renamed from: b */
    public CharSequence f5276b;

    /* JADX INFO: renamed from: c */
    public Intent f5277c;

    /* JADX INFO: renamed from: d */
    public char f5278d;

    /* JADX INFO: renamed from: f */
    public char f5280f;

    /* JADX INFO: renamed from: h */
    public Drawable f5282h;

    /* JADX INFO: renamed from: i */
    public final Context f5283i;

    /* JADX INFO: renamed from: j */
    public CharSequence f5284j;

    /* JADX INFO: renamed from: k */
    public CharSequence f5285k;

    /* JADX INFO: renamed from: e */
    public int f5279e = 4096;

    /* JADX INFO: renamed from: g */
    public int f5281g = 4096;

    /* JADX INFO: renamed from: l */
    public ColorStateList f5286l = null;

    /* JADX INFO: renamed from: m */
    public PorterDuff.Mode f5287m = null;

    /* JADX INFO: renamed from: n */
    public boolean f5288n = false;

    /* JADX INFO: renamed from: o */
    public boolean f5289o = false;

    /* JADX INFO: renamed from: p */
    public int f5290p = 16;

    public C1467a(Context context, CharSequence charSequence) {
        this.f5283i = context;
        this.f5275a = charSequence;
    }

    @Override // p012D.InterfaceMenuItemC0174a
    /* JADX INFO: renamed from: a */
    public final InterfaceMenuItemC0174a mo300a(ActionProviderVisibilityListenerC1482p actionProviderVisibilityListenerC1482p) {
        throw new UnsupportedOperationException();
    }

    @Override // p012D.InterfaceMenuItemC0174a
    /* JADX INFO: renamed from: b */
    public final ActionProviderVisibilityListenerC1482p mo301b() {
        return null;
    }

    /* JADX INFO: renamed from: c */
    public final void m3499c() {
        Drawable drawable = this.f5282h;
        if (drawable != null) {
            if (this.f5288n || this.f5289o) {
                this.f5282h = drawable;
                Drawable drawableMutate = drawable.mutate();
                this.f5282h = drawableMutate;
                if (this.f5288n) {
                    AbstractC0139b.m280h(drawableMutate, this.f5286l);
                }
                if (this.f5289o) {
                    AbstractC0139b.m281i(this.f5282h, this.f5287m);
                }
            }
        }
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f5281g;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f5280f;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f5284j;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f5282h;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f5286l;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f5287m;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f5277c;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return R.id.home;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f5279e;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f5278d;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f5275a;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f5276b;
        return charSequence != null ? charSequence : this.f5275a;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f5285k;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f5290p & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f5290p & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f5290p & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f5290p & 8) == 0;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c3) {
        this.f5280f = Character.toLowerCase(c3);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z3) {
        this.f5290p = (z3 ? 1 : 0) | (this.f5290p & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z3) {
        this.f5290p = (z3 ? 2 : 0) | (this.f5290p & (-3));
        return this;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final InterfaceMenuItemC0174a setContentDescription(CharSequence charSequence) {
        this.f5284j = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z3) {
        this.f5290p = (z3 ? 16 : 0) | (this.f5290p & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f5282h = drawable;
        m3499c();
        return this;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f5286l = colorStateList;
        this.f5288n = true;
        m3499c();
        return this;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f5287m = mode;
        this.f5289o = true;
        m3499c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f5277c = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c3) {
        this.f5278d = c3;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c3, char c4) {
        this.f5278d = c3;
        this.f5280f = Character.toLowerCase(c4);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i3) {
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i3) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f5275a = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f5276b = charSequence;
        return this;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final InterfaceMenuItemC0174a setTooltipText(CharSequence charSequence) {
        this.f5285k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z3) {
        this.f5290p = (this.f5290p & 8) | (z3 ? 0 : 8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c3, int i3) {
        this.f5280f = Character.toLowerCase(c3);
        this.f5281g = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f5284j = charSequence;
        return this;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c3, int i3) {
        this.f5278d = c3;
        this.f5279e = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i3) {
        this.f5275a = this.f5283i.getResources().getString(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f5285k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i3) {
        this.f5282h = AbstractC2047c.m4518b(this.f5283i, i3);
        m3499c();
        return this;
    }

    @Override // p012D.InterfaceMenuItemC0174a, android.view.MenuItem
    public final MenuItem setShortcut(char c3, char c4, int i3, int i4) {
        this.f5278d = c3;
        this.f5279e = KeyEvent.normalizeMetaState(i3);
        this.f5280f = Character.toLowerCase(c4);
        this.f5281g = KeyEvent.normalizeMetaState(i4);
        return this;
    }
}
