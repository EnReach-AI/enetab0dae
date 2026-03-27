package p108j;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import p098g.DialogC1366e;

/* JADX INFO: renamed from: j.n */
/* JADX INFO: loaded from: classes.dex */
public final class DialogInterfaceOnKeyListenerC1480n implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, InterfaceC1491y {

    /* JADX INFO: renamed from: e */
    public MenuC1479m f5368e;

    /* JADX INFO: renamed from: f */
    public DialogC1366e f5369f;

    /* JADX INFO: renamed from: g */
    public C1475i f5370g;

    @Override // p108j.InterfaceC1491y
    /* JADX INFO: renamed from: a */
    public final void mo533a(MenuC1479m menuC1479m, boolean z3) {
        DialogC1366e dialogC1366e;
        if ((z3 || menuC1479m == this.f5368e) && (dialogC1366e = this.f5369f) != null) {
            dialogC1366e.dismiss();
        }
    }

    @Override // p108j.InterfaceC1491y
    /* JADX INFO: renamed from: b */
    public final boolean mo534b(MenuC1479m menuC1479m) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i3) {
        C1475i c1475i = this.f5370g;
        if (c1475i.f5336j == null) {
            c1475i.f5336j = new C1474h(c1475i);
        }
        this.f5368e.m3519q(c1475i.f5336j.getItem(i3), null, 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f5370g.mo3478a(this.f5368e, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        MenuC1479m menuC1479m = this.f5368e;
        if (i3 == 82 || i3 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f5369f.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f5369f.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                menuC1479m.m3513c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return menuC1479m.performShortcut(i3, keyEvent, 0);
    }
}
