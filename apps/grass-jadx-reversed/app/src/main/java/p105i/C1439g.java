package p105i;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import p108j.MenuC1463C;

/* JADX INFO: renamed from: i.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1439g extends ActionMode {

    /* JADX INFO: renamed from: a */
    public final Context f5091a;

    /* JADX INFO: renamed from: b */
    public final AbstractC1434b f5092b;

    public C1439g(Context context, AbstractC1434b abstractC1434b) {
        this.f5091a = context;
        this.f5092b = abstractC1434b;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f5092b.mo3312a();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f5092b.mo3313b();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new MenuC1463C(this.f5091a, this.f5092b.mo3314e());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f5092b.mo3315f();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f5092b.mo3316g();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f5092b.f5077e;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f5092b.mo3317h();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f5092b.f5078f;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f5092b.mo3318i();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f5092b.mo3319j();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f5092b.mo3320k(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f5092b.mo3322m(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f5092b.f5077e = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f5092b.mo3324o(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z3) {
        this.f5092b.mo3325p(z3);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i3) {
        this.f5092b.mo3321l(i3);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i3) {
        this.f5092b.mo3323n(i3);
    }
}
