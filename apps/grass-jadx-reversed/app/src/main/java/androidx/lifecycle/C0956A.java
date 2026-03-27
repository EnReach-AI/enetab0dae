package androidx.lifecycle;

import android.os.Handler;
import p007B1.RunnableC0055o;
import p036L0.C0444d;

/* JADX INFO: renamed from: androidx.lifecycle.A */
/* JADX INFO: loaded from: classes.dex */
public final class C0956A implements InterfaceC0984q {

    /* JADX INFO: renamed from: m */
    public static final C0956A f3274m = new C0956A();

    /* JADX INFO: renamed from: i */
    public Handler f3279i;

    /* JADX INFO: renamed from: e */
    public int f3275e = 0;

    /* JADX INFO: renamed from: f */
    public int f3276f = 0;

    /* JADX INFO: renamed from: g */
    public boolean f3277g = true;

    /* JADX INFO: renamed from: h */
    public boolean f3278h = true;

    /* JADX INFO: renamed from: j */
    public final C0986s f3280j = new C0986s(this);

    /* JADX INFO: renamed from: k */
    public final RunnableC0055o f3281k = new RunnableC0055o(13, this);

    /* JADX INFO: renamed from: l */
    public final C0444d f3282l = new C0444d(this);

    /* JADX INFO: renamed from: a */
    public final void m2501a() {
        int i3 = this.f3276f + 1;
        this.f3276f = i3;
        if (i3 == 1) {
            if (!this.f3277g) {
                this.f3279i.removeCallbacks(this.f3281k);
            } else {
                this.f3280j.m2518d(EnumC0978k.ON_RESUME);
                this.f3277g = false;
            }
        }
    }

    @Override // androidx.lifecycle.InterfaceC0984q
    /* JADX INFO: renamed from: d */
    public final C0986s mo2199d() {
        return this.f3280j;
    }
}
