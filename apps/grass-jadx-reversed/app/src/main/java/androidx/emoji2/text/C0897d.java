package androidx.emoji2.text;

import android.support.v4.media.session.AbstractC0864a;
import p125o0.C1803m;
import p166z0.C2068f;
import p166z0.C2071i;

/* JADX INFO: renamed from: androidx.emoji2.text.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0897d extends AbstractC0864a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C0898e f2966a;

    public C0897d(C0898e c0898e) {
        this.f2966a = c0898e;
    }

    @Override // android.support.v4.media.session.AbstractC0864a
    /* JADX INFO: renamed from: h */
    public final void mo2191h(Throwable th) {
        this.f2966a.f2967a.m2344d(th);
    }

    @Override // android.support.v4.media.session.AbstractC0864a
    /* JADX INFO: renamed from: i */
    public final void mo2192i(C1803m c1803m) {
        C0898e c0898e = this.f2966a;
        c0898e.f2969c = c1803m;
        C1803m c1803m2 = c0898e.f2969c;
        C2068f c2068f = new C2068f(6);
        C0896c c0896c = c0898e.f2967a.f2979h;
        C2071i c2071i = new C2071i();
        c2071i.f7314a = c2068f;
        c2071i.f7315b = c1803m2;
        c2071i.f7316c = c0896c;
        c0898e.f2968b = c2071i;
        c0898e.f2967a.m2345e();
    }
}
