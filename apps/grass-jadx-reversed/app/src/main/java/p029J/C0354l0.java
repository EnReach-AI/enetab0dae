package p029J;

import android.view.WindowInsets;
import p005B.C0029d;

/* JADX INFO: renamed from: J.l0 */
/* JADX INFO: loaded from: classes.dex */
public class C0354l0 extends C0352k0 {

    /* JADX INFO: renamed from: n */
    public C0029d f862n;

    /* JADX INFO: renamed from: o */
    public C0029d f863o;

    /* JADX INFO: renamed from: p */
    public C0029d f864p;

    public C0354l0(C0364q0 c0364q0, WindowInsets windowInsets) {
        super(c0364q0, windowInsets);
        this.f862n = null;
        this.f863o = null;
        this.f864p = null;
    }

    @Override // p029J.C0360o0
    /* JADX INFO: renamed from: g */
    public C0029d mo777g() {
        if (this.f863o == null) {
            this.f863o = C0029d.m140b(this.f856c.getMandatorySystemGestureInsets());
        }
        return this.f863o;
    }

    @Override // p029J.C0360o0
    /* JADX INFO: renamed from: i */
    public C0029d mo778i() {
        if (this.f862n == null) {
            this.f862n = C0029d.m140b(this.f856c.getSystemGestureInsets());
        }
        return this.f862n;
    }

    @Override // p029J.C0360o0
    /* JADX INFO: renamed from: k */
    public C0029d mo779k() {
        if (this.f864p == null) {
            this.f864p = C0029d.m140b(this.f856c.getTappableElementInsets());
        }
        return this.f864p;
    }

    @Override // p029J.AbstractC0348i0, p029J.C0360o0
    /* JADX INFO: renamed from: l */
    public C0364q0 mo753l(int i3, int i4, int i5, int i6) {
        return C0364q0.m829g(this.f856c.inset(i3, i4, i5, i6), null);
    }

    @Override // p029J.AbstractC0350j0, p029J.C0360o0
    /* JADX INFO: renamed from: q */
    public void mo766q(C0029d c0029d) {
    }
}
