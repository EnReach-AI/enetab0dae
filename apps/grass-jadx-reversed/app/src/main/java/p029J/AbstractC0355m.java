package p029J;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;

/* JADX INFO: renamed from: J.m */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0355m {
    /* JADX INFO: renamed from: a */
    public static int m780a(MenuItem menuItem) {
        return menuItem.getAlphabeticModifiers();
    }

    /* JADX INFO: renamed from: b */
    public static CharSequence m781b(MenuItem menuItem) {
        return menuItem.getContentDescription();
    }

    /* JADX INFO: renamed from: c */
    public static ColorStateList m782c(MenuItem menuItem) {
        return menuItem.getIconTintList();
    }

    /* JADX INFO: renamed from: d */
    public static PorterDuff.Mode m783d(MenuItem menuItem) {
        return menuItem.getIconTintMode();
    }

    /* JADX INFO: renamed from: e */
    public static int m784e(MenuItem menuItem) {
        return menuItem.getNumericModifiers();
    }

    /* JADX INFO: renamed from: f */
    public static CharSequence m785f(MenuItem menuItem) {
        return menuItem.getTooltipText();
    }

    /* JADX INFO: renamed from: g */
    public static MenuItem m786g(MenuItem menuItem, char c3, int i3) {
        return menuItem.setAlphabeticShortcut(c3, i3);
    }

    /* JADX INFO: renamed from: h */
    public static MenuItem m787h(MenuItem menuItem, CharSequence charSequence) {
        return menuItem.setContentDescription(charSequence);
    }

    /* JADX INFO: renamed from: i */
    public static MenuItem m788i(MenuItem menuItem, ColorStateList colorStateList) {
        return menuItem.setIconTintList(colorStateList);
    }

    /* JADX INFO: renamed from: j */
    public static MenuItem m789j(MenuItem menuItem, PorterDuff.Mode mode) {
        return menuItem.setIconTintMode(mode);
    }

    /* JADX INFO: renamed from: k */
    public static MenuItem m790k(MenuItem menuItem, char c3, int i3) {
        return menuItem.setNumericShortcut(c3, i3);
    }

    /* JADX INFO: renamed from: l */
    public static MenuItem m791l(MenuItem menuItem, char c3, char c4, int i3, int i4) {
        return menuItem.setShortcut(c3, c4, i3, i4);
    }

    /* JADX INFO: renamed from: m */
    public static MenuItem m792m(MenuItem menuItem, CharSequence charSequence) {
        return menuItem.setTooltipText(charSequence);
    }
}
