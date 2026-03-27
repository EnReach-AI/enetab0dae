package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p166z0.DialogC2062K;

/* JADX INFO: renamed from: androidx.fragment.app.i */
/* JADX INFO: loaded from: classes.dex */
public final class DialogInterfaceOnCancelListenerC0938i implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f3167e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ View.OnCreateContextMenuListener f3168f;

    public /* synthetic */ DialogInterfaceOnCancelListenerC0938i(View.OnCreateContextMenuListener onCreateContextMenuListener, int i3) {
        this.f3167e = i3;
        this.f3168f = onCreateContextMenuListener;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        switch (this.f3167e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                DialogInterfaceOnCancelListenerC0941l dialogInterfaceOnCancelListenerC0941l = (DialogInterfaceOnCancelListenerC0941l) this.f3168f;
                Dialog dialog = dialogInterfaceOnCancelListenerC0941l.f3183h0;
                if (dialog != null) {
                    dialogInterfaceOnCancelListenerC0941l.onCancel(dialog);
                }
                break;
            default:
                ((DialogC2062K) this.f3168f).cancel();
                break;
        }
    }
}
