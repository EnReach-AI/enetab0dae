package p082b1;

import p039M0.AbstractC0493h0;
import p069X0.C0703E;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: b1.N */
/* JADX INFO: loaded from: classes.dex */
public final class C1018N {

    /* JADX INFO: renamed from: f */
    public static final C1018N f3609f = new C1018N(C0703E.f1927i, Object.class, null, false, null);

    /* JADX INFO: renamed from: a */
    public final C0703E f3610a;

    /* JADX INFO: renamed from: b */
    public final Class f3611b;

    /* JADX INFO: renamed from: c */
    public final Class f3612c;

    /* JADX INFO: renamed from: d */
    public final Class f3613d;

    /* JADX INFO: renamed from: e */
    public final boolean f3614e;

    public C1018N(C0703E c0703e, Class cls, Class cls2, boolean z3, Class cls3) {
        this.f3610a = c0703e;
        this.f3613d = cls;
        this.f3611b = cls2;
        this.f3614e = z3;
        this.f3612c = cls3 == null ? AbstractC0493h0.class : cls3;
    }

    public final String toString() {
        return "ObjectIdInfo: propName=" + this.f3610a + ", scope=" + AbstractC1745j.m3903z(this.f3613d) + ", generatorType=" + AbstractC1745j.m3903z(this.f3611b) + ", alwaysAsId=" + this.f3614e;
    }
}
