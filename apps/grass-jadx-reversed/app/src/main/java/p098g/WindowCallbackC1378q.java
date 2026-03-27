package p098g;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;
import p005B.AbstractC0032g;
import p105i.AbstractC1445m;
import p105i.AbstractC1446n;
import p105i.AbstractC1447o;
import p108j.MenuC1479m;

/* JADX INFO: renamed from: g.q */
/* JADX INFO: loaded from: classes.dex */
public final class WindowCallbackC1378q implements Window.Callback {

    /* JADX INFO: renamed from: e */
    public final Window.Callback f4923e;

    /* JADX INFO: renamed from: f */
    public boolean f4924f;

    /* JADX INFO: renamed from: g */
    public boolean f4925g;

    /* JADX INFO: renamed from: h */
    public boolean f4926h;

    /* JADX INFO: renamed from: i */
    public final /* synthetic */ LayoutInflaterFactory2C1382u f4927i;

    public WindowCallbackC1378q(LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u, Window.Callback callback) {
        this.f4927i = layoutInflaterFactory2C1382u;
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f4923e = callback;
    }

    /* JADX INFO: renamed from: a */
    public final void m3365a(Window.Callback callback) {
        try {
            this.f4924f = true;
            callback.onContentChanged();
        } finally {
            this.f4924f = false;
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m3366b(int i3, Menu menu) {
        return this.f4923e.onMenuOpened(i3, menu);
    }

    /* JADX INFO: renamed from: c */
    public final void m3367c(int i3, Menu menu) {
        this.f4923e.onPanelClosed(i3, menu);
    }

    /* JADX INFO: renamed from: d */
    public final void m3368d(List list, Menu menu, int i3) {
        AbstractC1446n.m3454a(this.f4923e, list, menu, i3);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f4923e.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z3 = this.f4925g;
        Window.Callback callback = this.f4923e;
        return z3 ? callback.dispatchKeyEvent(keyEvent) : this.f4927i.m3385u(keyEvent) || callback.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    @Override // android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean dispatchKeyShortcutEvent(android.view.KeyEvent r7) {
        /*
            r6 = this;
            android.view.Window$Callback r0 = r6.f4923e
            boolean r0 = r0.dispatchKeyShortcutEvent(r7)
            r1 = 1
            if (r0 != 0) goto L6f
            int r0 = r7.getKeyCode()
            g.u r2 = r6.f4927i
            r2.m3371A()
            g.G r3 = r2.f4994s
            r4 = 0
            if (r3 == 0) goto L3d
            g.F r3 = r3.f4850i
            if (r3 != 0) goto L1d
        L1b:
            r0 = r4
            goto L39
        L1d:
            j.m r3 = r3.f4836h
            if (r3 == 0) goto L1b
            int r5 = r7.getDeviceId()
            android.view.KeyCharacterMap r5 = android.view.KeyCharacterMap.load(r5)
            int r5 = r5.getKeyboardType()
            if (r5 == r1) goto L31
            r5 = r1
            goto L32
        L31:
            r5 = r4
        L32:
            r3.setQwertyMode(r5)
            boolean r0 = r3.performShortcut(r0, r7, r4)
        L39:
            if (r0 == 0) goto L3d
        L3b:
            r7 = r1
            goto L6b
        L3d:
            g.t r0 = r2.f4968Q
            if (r0 == 0) goto L52
            int r3 = r7.getKeyCode()
            boolean r0 = r2.m3376F(r0, r3, r7)
            if (r0 == 0) goto L52
            g.t r7 = r2.f4968Q
            if (r7 == 0) goto L3b
            r7.f4943l = r1
            goto L3b
        L52:
            g.t r0 = r2.f4968Q
            if (r0 != 0) goto L6a
            g.t r0 = r2.m3390z(r4)
            r2.m3377G(r0, r7)
            int r3 = r7.getKeyCode()
            boolean r7 = r2.m3376F(r0, r3, r7)
            r0.f4942k = r4
            if (r7 == 0) goto L6a
            goto L3b
        L6a:
            r7 = r4
        L6b:
            if (r7 == 0) goto L6e
            goto L6f
        L6e:
            r1 = r4
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p098g.WindowCallbackC1378q.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f4923e.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f4923e.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f4923e.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f4923e.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f4923e.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f4923e.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.f4924f) {
            this.f4923e.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i3, Menu menu) {
        if (i3 != 0 || (menu instanceof MenuC1479m)) {
            return this.f4923e.onCreatePanelMenu(i3, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i3) {
        return this.f4923e.onCreatePanelView(i3);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f4923e.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        return this.f4923e.onMenuItemSelected(i3, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i3, Menu menu) {
        m3366b(i3, menu);
        LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = this.f4927i;
        if (i3 == 108) {
            layoutInflaterFactory2C1382u.m3371A();
            C1361G c1361g = layoutInflaterFactory2C1382u.f4994s;
            if (c1361g != null && true != c1361g.f4853l) {
                c1361g.f4853l = true;
                ArrayList arrayList = c1361g.f4854m;
                if (arrayList.size() > 0) {
                    AbstractC0032g.m162t(arrayList.get(0));
                    throw null;
                }
            }
        } else {
            layoutInflaterFactory2C1382u.getClass();
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i3, Menu menu) {
        if (this.f4926h) {
            this.f4923e.onPanelClosed(i3, menu);
            return;
        }
        m3367c(i3, menu);
        LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = this.f4927i;
        if (i3 != 108) {
            if (i3 != 0) {
                layoutInflaterFactory2C1382u.getClass();
                return;
            }
            C1381t c1381tM3390z = layoutInflaterFactory2C1382u.m3390z(i3);
            if (c1381tM3390z.f4944m) {
                layoutInflaterFactory2C1382u.m3384s(c1381tM3390z, false);
                return;
            }
            return;
        }
        layoutInflaterFactory2C1382u.m3371A();
        C1361G c1361g = layoutInflaterFactory2C1382u.f4994s;
        if (c1361g == null || !c1361g.f4853l) {
            return;
        }
        c1361g.f4853l = false;
        ArrayList arrayList = c1361g.f4854m;
        if (arrayList.size() <= 0) {
            return;
        }
        AbstractC0032g.m162t(arrayList.get(0));
        throw null;
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z3) {
        AbstractC1447o.m3455a(this.f4923e, z3);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i3, View view, Menu menu) {
        MenuC1479m menuC1479m = menu instanceof MenuC1479m ? (MenuC1479m) menu : null;
        if (i3 == 0 && menuC1479m == null) {
            return false;
        }
        if (menuC1479m != null) {
            menuC1479m.f5367x = true;
        }
        boolean zOnPreparePanel = this.f4923e.onPreparePanel(i3, view, menu);
        if (menuC1479m != null) {
            menuC1479m.f5367x = false;
        }
        return zOnPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i3) {
        MenuC1479m menuC1479m = this.f4927i.m3390z(0).f4939h;
        if (menuC1479m != null) {
            m3368d(list, menuC1479m, i3);
        } else {
            m3368d(list, menu, i3);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return AbstractC1445m.m3452a(this.f4923e, searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f4923e.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z3) {
        this.f4923e.onWindowFocusChanged(z3);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ea  */
    @Override // android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r9, int r10) {
        /*
            Method dump skipped, instruction units count: 523
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p098g.WindowCallbackC1378q.onWindowStartingActionMode(android.view.ActionMode$Callback, int):android.view.ActionMode");
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f4923e.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }
}
