package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* JADX INFO: renamed from: androidx.fragment.app.j */
/* JADX INFO: loaded from: classes.dex */
public final class DialogInterfaceOnDismissListenerC0939j implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ DialogInterfaceOnCancelListenerC0941l f3169e;

    public DialogInterfaceOnDismissListenerC0939j(DialogInterfaceOnCancelListenerC0941l dialogInterfaceOnCancelListenerC0941l) {
        this.f3169e = dialogInterfaceOnCancelListenerC0941l;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        DialogInterfaceOnCancelListenerC0941l dialogInterfaceOnCancelListenerC0941l = this.f3169e;
        Dialog dialog = dialogInterfaceOnCancelListenerC0941l.f3183h0;
        if (dialog != null) {
            dialogInterfaceOnCancelListenerC0941l.onDismiss(dialog);
        }
    }
}
