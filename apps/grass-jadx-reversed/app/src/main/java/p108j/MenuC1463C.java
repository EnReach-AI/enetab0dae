package p108j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.fragment.app.AbstractC0935f;
import p012D.InterfaceMenuItemC0174a;
import p128p.C1817k;

/* JADX INFO: renamed from: j.C */
/* JADX INFO: loaded from: classes.dex */
public class MenuC1463C extends AbstractC0935f implements Menu {

    /* JADX INFO: renamed from: c */
    public final MenuC1479m f5252c;

    public MenuC1463C(Context context, MenuC1479m menuC1479m) {
        super(context);
        if (menuC1479m == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f5252c = menuC1479m;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return m2453h(this.f5252c.add(charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i3, int i4, int i5, ComponentName componentName, Intent[] intentArr, Intent intent, int i6, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.f5252c.addIntentOptions(i3, i4, i5, componentName, intentArr, intent, i6, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i7 = 0; i7 < length; i7++) {
                menuItemArr[i7] = m2453h(menuItemArr2[i7]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return this.f5252c.addSubMenu(charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        C1817k c1817k = (C1817k) this.f3161b;
        if (c1817k != null) {
            c1817k.clear();
        }
        this.f5252c.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        this.f5252c.close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i3) {
        return m2453h(this.f5252c.findItem(i3));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i3) {
        return m2453h(this.f5252c.getItem(i3));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.f5252c.hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i3, KeyEvent keyEvent) {
        return this.f5252c.isShortcutKey(i3, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i3, int i4) {
        return this.f5252c.performIdentifierAction(i3, i4);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i3, KeyEvent keyEvent, int i4) {
        return this.f5252c.performShortcut(i3, keyEvent, i4);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i3) {
        if (((C1817k) this.f3161b) != null) {
            int i4 = 0;
            while (true) {
                C1817k c1817k = (C1817k) this.f3161b;
                if (i4 >= c1817k.f6297g) {
                    break;
                }
                if (((InterfaceMenuItemC0174a) c1817k.m4039h(i4)).getGroupId() == i3) {
                    ((C1817k) this.f3161b).m4040i(i4);
                    i4--;
                }
                i4++;
            }
        }
        this.f5252c.removeGroup(i3);
    }

    @Override // android.view.Menu
    public final void removeItem(int i3) {
        if (((C1817k) this.f3161b) != null) {
            int i4 = 0;
            while (true) {
                C1817k c1817k = (C1817k) this.f3161b;
                if (i4 >= c1817k.f6297g) {
                    break;
                }
                if (((InterfaceMenuItemC0174a) c1817k.m4039h(i4)).getItemId() == i3) {
                    ((C1817k) this.f3161b).m4040i(i4);
                    break;
                }
                i4++;
            }
        }
        this.f5252c.removeItem(i3);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i3, boolean z3, boolean z4) {
        this.f5252c.setGroupCheckable(i3, z3, z4);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i3, boolean z3) {
        this.f5252c.setGroupEnabled(i3, z3);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i3, boolean z3) {
        this.f5252c.setGroupVisible(i3, z3);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z3) {
        this.f5252c.setQwertyMode(z3);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f5252c.size();
    }

    @Override // android.view.Menu
    public final MenuItem add(int i3) {
        return m2453h(this.f5252c.add(i3));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i3) {
        return this.f5252c.addSubMenu(i3);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i3, int i4, int i5, CharSequence charSequence) {
        return m2453h(this.f5252c.add(i3, i4, i5, charSequence));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i3, int i4, int i5, CharSequence charSequence) {
        return this.f5252c.addSubMenu(i3, i4, i5, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i3, int i4, int i5, int i6) {
        return m2453h(this.f5252c.add(i3, i4, i5, i6));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i3, int i4, int i5, int i6) {
        return this.f5252c.addSubMenu(i3, i4, i5, i6);
    }
}
