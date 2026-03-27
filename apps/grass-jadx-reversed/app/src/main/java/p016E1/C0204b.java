package p016E1;

import android.graphics.Typeface;
import p001A.AbstractC0001b;
import p148u0.AbstractC1944c;

/* JADX INFO: renamed from: E1.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0204b extends AbstractC0001b {

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ AbstractC1944c f492h;

    /* JADX INFO: renamed from: i */
    public final /* synthetic */ C0206d f493i;

    public C0204b(C0206d c0206d, AbstractC1944c abstractC1944c) {
        this.f493i = c0206d;
        this.f492h = abstractC1944c;
    }

    @Override // p001A.AbstractC0001b
    /* JADX INFO: renamed from: g */
    public final void mo13g(int i3) {
        this.f493i.f510m = true;
        this.f492h.mo209d(i3);
    }

    @Override // p001A.AbstractC0001b
    /* JADX INFO: renamed from: h */
    public final void mo14h(Typeface typeface) {
        C0206d c0206d = this.f493i;
        c0206d.f511n = Typeface.create(typeface, c0206d.f500c);
        c0206d.f510m = true;
        this.f492h.mo210e(c0206d.f511n, false);
    }
}
