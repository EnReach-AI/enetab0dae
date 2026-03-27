package p098g;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;
import p001A.C0009j;
import p105i.AbstractC1434b;
import p105i.C1442j;
import p105i.InterfaceC1433a;
import p108j.InterfaceC1477k;
import p108j.MenuC1479m;
import p110k.C1594i;

/* JADX INFO: renamed from: g.F */
/* JADX INFO: loaded from: classes.dex */
public final class C1360F extends AbstractC1434b implements InterfaceC1477k {

    /* JADX INFO: renamed from: g */
    public final Context f4835g;

    /* JADX INFO: renamed from: h */
    public final MenuC1479m f4836h;

    /* JADX INFO: renamed from: i */
    public InterfaceC1433a f4837i;

    /* JADX INFO: renamed from: j */
    public WeakReference f4838j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C1361G f4839k;

    public C1360F(C1361G c1361g, Context context, C0009j c0009j) {
        this.f4839k = c1361g;
        this.f4835g = context;
        this.f4837i = c0009j;
        MenuC1479m menuC1479m = new MenuC1479m(context);
        menuC1479m.f5355l = 1;
        this.f4836h = menuC1479m;
        menuC1479m.f5348e = this;
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: a */
    public final void mo3312a() {
        C1361G c1361g = this.f4839k;
        if (c1361g.f4850i != this) {
            return;
        }
        if (c1361g.f4857p) {
            c1361g.f4851j = this;
            c1361g.f4852k = this.f4837i;
        } else {
            this.f4837i.mo47g(this);
        }
        this.f4837i = null;
        c1361g.m3326j(false);
        ActionBarContextView actionBarContextView = c1361g.f4847f;
        if (actionBarContextView.f2700o == null) {
            actionBarContextView.m2232e();
        }
        c1361g.f4844c.setHideOnContentScrollEnabled(c1361g.f4862u);
        c1361g.f4850i = null;
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: b */
    public final View mo3313b() {
        WeakReference weakReference = this.f4838j;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // p108j.InterfaceC1477k
    /* JADX INFO: renamed from: c */
    public final void mo444c(MenuC1479m menuC1479m) {
        if (this.f4837i == null) {
            return;
        }
        mo3318i();
        C1594i c1594i = this.f4839k.f4847f.f2693h;
        if (c1594i != null) {
            c1594i.m3657l();
        }
    }

    @Override // p108j.InterfaceC1477k
    /* JADX INFO: renamed from: d */
    public final boolean mo445d(MenuC1479m menuC1479m, MenuItem menuItem) {
        InterfaceC1433a interfaceC1433a = this.f4837i;
        if (interfaceC1433a != null) {
            return interfaceC1433a.mo41a(this, menuItem);
        }
        return false;
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: e */
    public final MenuC1479m mo3314e() {
        return this.f4836h;
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: f */
    public final MenuInflater mo3315f() {
        return new C1442j(this.f4835g);
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: g */
    public final CharSequence mo3316g() {
        return this.f4839k.f4847f.getSubtitle();
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: h */
    public final CharSequence mo3317h() {
        return this.f4839k.f4847f.getTitle();
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: i */
    public final void mo3318i() {
        if (this.f4839k.f4850i != this) {
            return;
        }
        MenuC1479m menuC1479m = this.f4836h;
        menuC1479m.m3525w();
        try {
            this.f4837i.mo46f(this, menuC1479m);
        } finally {
            menuC1479m.m3524v();
        }
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: j */
    public final boolean mo3319j() {
        return this.f4839k.f4847f.f2708w;
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: k */
    public final void mo3320k(View view) {
        this.f4839k.f4847f.setCustomView(view);
        this.f4838j = new WeakReference(view);
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: l */
    public final void mo3321l(int i3) {
        mo3322m(this.f4839k.f4842a.getResources().getString(i3));
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: m */
    public final void mo3322m(CharSequence charSequence) {
        this.f4839k.f4847f.setSubtitle(charSequence);
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: n */
    public final void mo3323n(int i3) {
        mo3324o(this.f4839k.f4842a.getResources().getString(i3));
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: o */
    public final void mo3324o(CharSequence charSequence) {
        this.f4839k.f4847f.setTitle(charSequence);
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: p */
    public final void mo3325p(boolean z3) {
        this.f5078f = z3;
        this.f4839k.f4847f.setTitleOptional(z3);
    }
}
