package p024H0;

import android.content.DialogInterface;
import java.util.Date;
import p166z0.C2071i;

/* JADX INFO: renamed from: H0.f */
/* JADX INFO: loaded from: classes.dex */
public final class DialogInterfaceOnClickListenerC0252f implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ String f614e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ C2071i f615f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ String f616g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ Date f617h;

    /* JADX INFO: renamed from: i */
    public final /* synthetic */ Date f618i;

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C0255i f619j;

    public DialogInterfaceOnClickListenerC0252f(C0255i c0255i, String str, C2071i c2071i, String str2, Date date, Date date2) {
        this.f619j = c0255i;
        this.f614e = str;
        this.f615f = c2071i;
        this.f616g = str2;
        this.f617h = date;
        this.f618i = date2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i3) {
        C0255i.m491T(this.f619j, this.f614e, this.f615f, this.f616g, this.f617h, this.f618i);
    }
}
