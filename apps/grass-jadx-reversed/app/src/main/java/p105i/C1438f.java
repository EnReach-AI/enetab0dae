package p105i;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;
import p108j.InterfaceC1477k;
import p108j.MenuC1479m;
import p110k.C1594i;

/* JADX INFO: renamed from: i.f */
/* JADX INFO: loaded from: classes.dex */
public final class C1438f extends AbstractC1434b implements InterfaceC1477k {

    /* JADX INFO: renamed from: g */
    public Context f5085g;

    /* JADX INFO: renamed from: h */
    public ActionBarContextView f5086h;

    /* JADX INFO: renamed from: i */
    public InterfaceC1433a f5087i;

    /* JADX INFO: renamed from: j */
    public WeakReference f5088j;

    /* JADX INFO: renamed from: k */
    public boolean f5089k;

    /* JADX INFO: renamed from: l */
    public MenuC1479m f5090l;

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: a */
    public final void mo3312a() {
        if (this.f5089k) {
            return;
        }
        this.f5089k = true;
        this.f5087i.mo47g(this);
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: b */
    public final View mo3313b() {
        WeakReference weakReference = this.f5088j;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // p108j.InterfaceC1477k
    /* JADX INFO: renamed from: c */
    public final void mo444c(MenuC1479m menuC1479m) {
        mo3318i();
        C1594i c1594i = this.f5086h.f2693h;
        if (c1594i != null) {
            c1594i.m3657l();
        }
    }

    @Override // p108j.InterfaceC1477k
    /* JADX INFO: renamed from: d */
    public final boolean mo445d(MenuC1479m menuC1479m, MenuItem menuItem) {
        return this.f5087i.mo41a(this, menuItem);
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: e */
    public final MenuC1479m mo3314e() {
        return this.f5090l;
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: f */
    public final MenuInflater mo3315f() {
        return new C1442j(this.f5086h.getContext());
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: g */
    public final CharSequence mo3316g() {
        return this.f5086h.getSubtitle();
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: h */
    public final CharSequence mo3317h() {
        return this.f5086h.getTitle();
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: i */
    public final void mo3318i() {
        this.f5087i.mo46f(this, this.f5090l);
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: j */
    public final boolean mo3319j() {
        return this.f5086h.f2708w;
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: k */
    public final void mo3320k(View view) {
        this.f5086h.setCustomView(view);
        this.f5088j = view != null ? new WeakReference(view) : null;
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: l */
    public final void mo3321l(int i3) {
        mo3322m(this.f5085g.getString(i3));
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: m */
    public final void mo3322m(CharSequence charSequence) {
        this.f5086h.setSubtitle(charSequence);
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: n */
    public final void mo3323n(int i3) {
        mo3324o(this.f5085g.getString(i3));
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: o */
    public final void mo3324o(CharSequence charSequence) {
        this.f5086h.setTitle(charSequence);
    }

    @Override // p105i.AbstractC1434b
    /* JADX INFO: renamed from: p */
    public final void mo3325p(boolean z3) {
        this.f5078f = z3;
        this.f5086h.setTitleOptional(z3);
    }
}
