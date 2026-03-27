package p029J;

import android.view.WindowInsets;
import p005B.C0029d;

/* JADX INFO: renamed from: J.j0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0350j0 extends AbstractC0348i0 {

    /* JADX INFO: renamed from: m */
    public C0029d f861m;

    public AbstractC0350j0(C0364q0 c0364q0, WindowInsets windowInsets) {
        super(c0364q0, windowInsets);
        this.f861m = null;
    }

    @Override // p029J.C0360o0
    /* JADX INFO: renamed from: b */
    public C0364q0 mo762b() {
        return C0364q0.m829g(this.f856c.consumeStableInsets(), null);
    }

    @Override // p029J.C0360o0
    /* JADX INFO: renamed from: c */
    public C0364q0 mo763c() {
        return C0364q0.m829g(this.f856c.consumeSystemWindowInsets(), null);
    }

    @Override // p029J.C0360o0
    /* JADX INFO: renamed from: h */
    public final C0029d mo764h() {
        if (this.f861m == null) {
            WindowInsets windowInsets = this.f856c;
            this.f861m = C0029d.m139a(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f861m;
    }

    @Override // p029J.C0360o0
    /* JADX INFO: renamed from: m */
    public boolean mo765m() {
        return this.f856c.isConsumed();
    }

    @Override // p029J.C0360o0
    /* JADX INFO: renamed from: q */
    public void mo766q(C0029d c0029d) {
        this.f861m = c0029d;
    }
}
