package p024H0;

import android.content.DialogInterface;

/* JADX INFO: renamed from: H0.e */
/* JADX INFO: loaded from: classes.dex */
public final class DialogInterfaceOnClickListenerC0251e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C0255i f613e;

    public DialogInterfaceOnClickListenerC0251e(C0255i c0255i) {
        this.f613e = c0255i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i3) {
        C0255i c0255i = this.f613e;
        c0255i.f638u0.setContentView(c0255i.m493U(false));
        c0255i.m499a0(c0255i.f641x0);
    }
}
