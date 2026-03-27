package p029J;

import android.view.WindowInsets;
import p005B.AbstractC0027b;
import p005B.C0029d;

/* JADX INFO: renamed from: J.f0 */
/* JADX INFO: loaded from: classes.dex */
public class C0342f0 extends AbstractC0346h0 {

    /* JADX INFO: renamed from: a */
    public final WindowInsets.Builder f848a;

    public C0342f0() {
        this.f848a = AbstractC0027b.m116e();
    }

    @Override // p029J.AbstractC0346h0
    /* JADX INFO: renamed from: b */
    public C0364q0 mo736b() {
        m745a();
        C0364q0 c0364q0M829g = C0364q0.m829g(this.f848a.build(), null);
        c0364q0M829g.f874a.mo755o(null);
        return c0364q0M829g;
    }

    @Override // p029J.AbstractC0346h0
    /* JADX INFO: renamed from: c */
    public void mo737c(C0029d c0029d) {
        this.f848a.setStableInsets(c0029d.m141c());
    }

    @Override // p029J.AbstractC0346h0
    /* JADX INFO: renamed from: d */
    public void mo738d(C0029d c0029d) {
        this.f848a.setSystemWindowInsets(c0029d.m141c());
    }

    public C0342f0(C0364q0 c0364q0) {
        WindowInsets.Builder builderM116e;
        super(c0364q0);
        WindowInsets windowInsetsM834f = c0364q0.m834f();
        if (windowInsetsM834f != null) {
            builderM116e = AbstractC0027b.m117f(windowInsetsM834f);
        } else {
            builderM116e = AbstractC0027b.m116e();
        }
        this.f848a = builderM116e;
    }
}
