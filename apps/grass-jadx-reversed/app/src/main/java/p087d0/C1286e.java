package p087d0;

import android.view.ViewGroup;
import p039M0.AbstractC0493h0;

/* JADX INFO: renamed from: d0.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1286e extends AbstractC1294m {

    /* JADX INFO: renamed from: a */
    public boolean f4589a = false;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ViewGroup f4590b;

    public C1286e(ViewGroup viewGroup) {
        this.f4590b = viewGroup;
    }

    @Override // p087d0.AbstractC1294m, p087d0.InterfaceC1292k
    /* JADX INFO: renamed from: a */
    public final void mo3250a() {
        AbstractC0493h0.m1012e(this.f4590b, false);
        this.f4589a = true;
    }

    @Override // p087d0.AbstractC1294m, p087d0.InterfaceC1292k
    /* JADX INFO: renamed from: c */
    public final void mo3251c() {
        AbstractC0493h0.m1012e(this.f4590b, false);
    }

    @Override // p087d0.InterfaceC1292k
    /* JADX INFO: renamed from: d */
    public final void mo3252d(AbstractC1293l abstractC1293l) {
        if (!this.f4589a) {
            AbstractC0493h0.m1012e(this.f4590b, false);
        }
        abstractC1293l.m3274u(this);
    }

    @Override // p087d0.AbstractC1294m, p087d0.InterfaceC1292k
    /* JADX INFO: renamed from: e */
    public final void mo3253e() {
        AbstractC0493h0.m1012e(this.f4590b, true);
    }
}
