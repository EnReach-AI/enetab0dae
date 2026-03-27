package p065W;

import androidx.lifecycle.AbstractC0964I;
import p005B.AbstractC0032g;
import p128p.C1818l;
import p166z0.C2068f;

/* JADX INFO: renamed from: W.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0673a extends AbstractC0964I {

    /* JADX INFO: renamed from: d */
    public static final C2068f f1830d = new C2068f(5);

    /* JADX INFO: renamed from: c */
    public final C1818l f1831c = new C1818l();

    @Override // androidx.lifecycle.AbstractC0964I
    /* JADX INFO: renamed from: a */
    public final void mo1631a() {
        C1818l c1818l = this.f1831c;
        int i3 = c1818l.f6301g;
        if (i3 > 0) {
            AbstractC0032g.m162t(c1818l.f6300f[0]);
            throw null;
        }
        Object[] objArr = c1818l.f6300f;
        for (int i4 = 0; i4 < i3; i4++) {
            objArr[i4] = null;
        }
        c1818l.f6301g = 0;
    }
}
