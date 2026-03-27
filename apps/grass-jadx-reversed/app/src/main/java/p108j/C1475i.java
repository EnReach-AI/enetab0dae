package p108j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;
import p015D2.C0192p;
import p098g.C1363b;
import p098g.DialogC1366e;

/* JADX INFO: renamed from: j.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1475i implements InterfaceC1492z, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: e */
    public Context f5331e;

    /* JADX INFO: renamed from: f */
    public LayoutInflater f5332f;

    /* JADX INFO: renamed from: g */
    public MenuC1479m f5333g;

    /* JADX INFO: renamed from: h */
    public ExpandedMenuView f5334h;

    /* JADX INFO: renamed from: i */
    public InterfaceC1491y f5335i;

    /* JADX INFO: renamed from: j */
    public C1474h f5336j;

    public C1475i(Context context) {
        this.f5331e = context;
        this.f5332f = LayoutInflater.from(context);
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: a */
    public final void mo3478a(MenuC1479m menuC1479m, boolean z3) {
        InterfaceC1491y interfaceC1491y = this.f5335i;
        if (interfaceC1491y != null) {
            interfaceC1491y.mo533a(menuC1479m, z3);
        }
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: c */
    public final void mo3506c(Context context, MenuC1479m menuC1479m) {
        if (this.f5331e != null) {
            this.f5331e = context;
            if (this.f5332f == null) {
                this.f5332f = LayoutInflater.from(context);
            }
        }
        this.f5333g = menuC1479m;
        C1474h c1474h = this.f5336j;
        if (c1474h != null) {
            c1474h.notifyDataSetChanged();
        }
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: d */
    public final boolean mo3479d() {
        return false;
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: e */
    public final boolean mo3507e(C1481o c1481o) {
        return false;
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: g */
    public final void mo3480g() {
        C1474h c1474h = this.f5336j;
        if (c1474h != null) {
            c1474h.notifyDataSetChanged();
        }
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: h */
    public final boolean mo3508h(C1481o c1481o) {
        return false;
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: i */
    public final void mo3481i(InterfaceC1491y interfaceC1491y) {
        this.f5335i = interfaceC1491y;
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: k */
    public final boolean mo3482k(SubMenuC1466F subMenuC1466F) {
        if (!subMenuC1466F.hasVisibleItems()) {
            return false;
        }
        DialogInterfaceOnKeyListenerC1480n dialogInterfaceOnKeyListenerC1480n = new DialogInterfaceOnKeyListenerC1480n();
        dialogInterfaceOnKeyListenerC1480n.f5368e = subMenuC1466F;
        Context context = subMenuC1466F.f5344a;
        C0192p c0192p = new C0192p(context);
        C1363b c1363b = (C1363b) c0192p.f444g;
        C1475i c1475i = new C1475i(c1363b.f4868a);
        dialogInterfaceOnKeyListenerC1480n.f5370g = c1475i;
        c1475i.f5335i = dialogInterfaceOnKeyListenerC1480n;
        subMenuC1466F.m3512b(c1475i, context);
        C1475i c1475i2 = dialogInterfaceOnKeyListenerC1480n.f5370g;
        if (c1475i2.f5336j == null) {
            c1475i2.f5336j = new C1474h(c1475i2);
        }
        c1363b.f4874g = c1475i2.f5336j;
        c1363b.f4875h = dialogInterfaceOnKeyListenerC1480n;
        View view = subMenuC1466F.f5358o;
        if (view != null) {
            c1363b.f4872e = view;
        } else {
            c1363b.f4870c = subMenuC1466F.f5357n;
            c1363b.f4871d = subMenuC1466F.f5356m;
        }
        c1363b.f4873f = dialogInterfaceOnKeyListenerC1480n;
        DialogC1366e dialogC1366eM334a = c0192p.m334a();
        dialogInterfaceOnKeyListenerC1480n.f5369f = dialogC1366eM334a;
        dialogC1366eM334a.setOnDismissListener(dialogInterfaceOnKeyListenerC1480n);
        WindowManager.LayoutParams attributes = dialogInterfaceOnKeyListenerC1480n.f5369f.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        dialogInterfaceOnKeyListenerC1480n.f5369f.show();
        InterfaceC1491y interfaceC1491y = this.f5335i;
        if (interfaceC1491y == null) {
            return true;
        }
        interfaceC1491y.mo534b(subMenuC1466F);
        return true;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i3, long j2) {
        this.f5333g.m3519q(this.f5336j.getItem(i3), this, 0);
    }
}
