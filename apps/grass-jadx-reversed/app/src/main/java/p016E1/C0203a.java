package p016E1;

import android.graphics.Typeface;
import p007B1.C0044d;
import p036L0.C0444d;
import p148u0.AbstractC1944c;

/* JADX INFO: renamed from: E1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0203a extends AbstractC1944c {

    /* JADX INFO: renamed from: a */
    public final Typeface f489a;

    /* JADX INFO: renamed from: b */
    public final C0444d f490b;

    /* JADX INFO: renamed from: c */
    public boolean f491c;

    public C0203a(C0444d c0444d, Typeface typeface) {
        this.f489a = typeface;
        this.f490b = c0444d;
    }

    @Override // p148u0.AbstractC1944c
    /* JADX INFO: renamed from: d */
    public final void mo209d(int i3) {
        if (this.f491c) {
            return;
        }
        C0044d c0044d = (C0044d) this.f490b.f1085e;
        if (c0044d.m202j(this.f489a)) {
            c0044d.m200h(false);
        }
    }

    @Override // p148u0.AbstractC1944c
    /* JADX INFO: renamed from: e */
    public final void mo210e(Typeface typeface, boolean z3) {
        if (this.f491c) {
            return;
        }
        C0044d c0044d = (C0044d) this.f490b.f1085e;
        if (c0044d.m202j(typeface)) {
            c0044d.m200h(false);
        }
    }
}
