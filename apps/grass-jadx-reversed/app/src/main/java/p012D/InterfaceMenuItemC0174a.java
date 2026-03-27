package p012D;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import p108j.ActionProviderVisibilityListenerC1482p;

/* JADX INFO: renamed from: D.a */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceMenuItemC0174a extends MenuItem {
    /* JADX INFO: renamed from: a */
    InterfaceMenuItemC0174a mo300a(ActionProviderVisibilityListenerC1482p actionProviderVisibilityListenerC1482p);

    /* JADX INFO: renamed from: b */
    ActionProviderVisibilityListenerC1482p mo301b();

    @Override // android.view.MenuItem
    int getAlphabeticModifiers();

    @Override // android.view.MenuItem
    CharSequence getContentDescription();

    @Override // android.view.MenuItem
    ColorStateList getIconTintList();

    @Override // android.view.MenuItem
    PorterDuff.Mode getIconTintMode();

    @Override // android.view.MenuItem
    int getNumericModifiers();

    @Override // android.view.MenuItem
    CharSequence getTooltipText();

    @Override // android.view.MenuItem
    MenuItem setAlphabeticShortcut(char c3, int i3);

    @Override // android.view.MenuItem
    InterfaceMenuItemC0174a setContentDescription(CharSequence charSequence);

    @Override // android.view.MenuItem
    MenuItem setIconTintList(ColorStateList colorStateList);

    @Override // android.view.MenuItem
    MenuItem setIconTintMode(PorterDuff.Mode mode);

    @Override // android.view.MenuItem
    MenuItem setNumericShortcut(char c3, int i3);

    @Override // android.view.MenuItem
    MenuItem setShortcut(char c3, char c4, int i3, int i4);

    @Override // android.view.MenuItem
    InterfaceMenuItemC0174a setTooltipText(CharSequence charSequence);
}
