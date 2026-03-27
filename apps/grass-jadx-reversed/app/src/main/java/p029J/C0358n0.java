package p029J;

import android.view.View;
import android.view.WindowInsets;
import p005B.C0029d;

/* JADX INFO: renamed from: J.n0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0358n0 extends C0354l0 {

    /* JADX INFO: renamed from: q */
    public static final C0364q0 f865q = C0364q0.m829g(WindowInsets.CONSUMED, null);

    public C0358n0(C0364q0 c0364q0, WindowInsets windowInsets) {
        super(c0364q0, windowInsets);
    }

    @Override // p029J.AbstractC0348i0, p029J.C0360o0
    /* JADX INFO: renamed from: d */
    public final void mo750d(View view) {
    }

    @Override // p029J.AbstractC0348i0, p029J.C0360o0
    /* JADX INFO: renamed from: f */
    public C0029d mo751f(int i3) {
        return C0029d.m140b(this.f856c.getInsets(AbstractC0362p0.m826a(i3)));
    }
}
