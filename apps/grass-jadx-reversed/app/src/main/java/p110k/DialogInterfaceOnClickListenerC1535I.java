package p110k;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;
import p015D2.C0192p;
import p098g.C1363b;
import p098g.DialogC1366e;

/* JADX INFO: renamed from: k.I */
/* JADX INFO: loaded from: classes.dex */
public final class DialogInterfaceOnClickListenerC1535I implements InterfaceC1545N, DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: e */
    public DialogC1366e f5495e;

    /* JADX INFO: renamed from: f */
    public ListAdapter f5496f;

    /* JADX INFO: renamed from: g */
    public CharSequence f5497g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ C1547O f5498h;

    public DialogInterfaceOnClickListenerC1535I(C1547O c1547o) {
        this.f5498h = c1547o;
    }

    @Override // p110k.InterfaceC1545N
    /* JADX INFO: renamed from: a */
    public final void mo3588a(int i3) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // p110k.InterfaceC1545N
    /* JADX INFO: renamed from: b */
    public final boolean mo3589b() {
        DialogC1366e dialogC1366e = this.f5495e;
        if (dialogC1366e != null) {
            return dialogC1366e.isShowing();
        }
        return false;
    }

    @Override // p110k.InterfaceC1545N
    /* JADX INFO: renamed from: d */
    public final int mo3590d() {
        return 0;
    }

    @Override // p110k.InterfaceC1545N
    public final void dismiss() {
        DialogC1366e dialogC1366e = this.f5495e;
        if (dialogC1366e != null) {
            dialogC1366e.dismiss();
            this.f5495e = null;
        }
    }

    @Override // p110k.InterfaceC1545N
    /* JADX INFO: renamed from: e */
    public final void mo3591e(int i3, int i4) {
        if (this.f5496f == null) {
            return;
        }
        C1547O c1547o = this.f5498h;
        C0192p c0192p = new C0192p(c1547o.getPopupContext());
        CharSequence charSequence = this.f5497g;
        C1363b c1363b = (C1363b) c0192p.f444g;
        if (charSequence != null) {
            c1363b.f4871d = charSequence;
        }
        ListAdapter listAdapter = this.f5496f;
        int selectedItemPosition = c1547o.getSelectedItemPosition();
        c1363b.f4874g = listAdapter;
        c1363b.f4875h = this;
        c1363b.f4877j = selectedItemPosition;
        c1363b.f4876i = true;
        DialogC1366e dialogC1366eM334a = c0192p.m334a();
        this.f5495e = dialogC1366eM334a;
        AlertController$RecycleListView alertController$RecycleListView = dialogC1366eM334a.f4906i.f4882e;
        AbstractC1531G.m3577d(alertController$RecycleListView, i3);
        AbstractC1531G.m3576c(alertController$RecycleListView, i4);
        this.f5495e.show();
    }

    @Override // p110k.InterfaceC1545N
    /* JADX INFO: renamed from: g */
    public final int mo3592g() {
        return 0;
    }

    @Override // p110k.InterfaceC1545N
    /* JADX INFO: renamed from: h */
    public final Drawable mo3593h() {
        return null;
    }

    @Override // p110k.InterfaceC1545N
    /* JADX INFO: renamed from: i */
    public final CharSequence mo3594i() {
        return this.f5497g;
    }

    @Override // p110k.InterfaceC1545N
    /* JADX INFO: renamed from: k */
    public final void mo3595k(CharSequence charSequence) {
        this.f5497g = charSequence;
    }

    @Override // p110k.InterfaceC1545N
    /* JADX INFO: renamed from: l */
    public final void mo3596l(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // p110k.InterfaceC1545N
    /* JADX INFO: renamed from: m */
    public final void mo3597m(int i3) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // p110k.InterfaceC1545N
    /* JADX INFO: renamed from: o */
    public final void mo3598o(ListAdapter listAdapter) {
        this.f5496f = listAdapter;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i3) {
        C1547O c1547o = this.f5498h;
        c1547o.setSelection(i3);
        if (c1547o.getOnItemClickListener() != null) {
            c1547o.performItemClick(null, i3, this.f5496f.getItemId(i3));
        }
        dismiss();
    }

    @Override // p110k.InterfaceC1545N
    /* JADX INFO: renamed from: p */
    public final void mo3599p(int i3) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }
}
