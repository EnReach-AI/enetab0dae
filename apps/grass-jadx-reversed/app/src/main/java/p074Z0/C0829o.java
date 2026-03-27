package p074Z0;

import com.fasterxml.jackson.databind.deser.AbstractC1177l;
import com.fasterxml.jackson.databind.deser.std.C1201q;
import java.io.Serializable;
import p033K0.AbstractC0406d;
import p118m1.C1740e;
import p148u0.AbstractC1946e;
import p156w0.AbstractC1986a;

/* JADX INFO: renamed from: Z0.o */
/* JADX INFO: loaded from: classes.dex */
public final class C0829o implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final AbstractC1177l[] f2461j = new AbstractC1177l[0];

    /* JADX INFO: renamed from: k */
    public static final AbstractC1946e[] f2462k = new AbstractC1946e[0];

    /* JADX INFO: renamed from: l */
    public static final AbstractC0406d[] f2463l = new AbstractC0406d[0];

    /* JADX INFO: renamed from: m */
    public static final AbstractC1986a[] f2464m = new AbstractC1986a[0];

    /* JADX INFO: renamed from: n */
    public static final C1201q[] f2465n = {new C1201q()};
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final AbstractC1177l[] f2466e;

    /* JADX INFO: renamed from: f */
    public final C1201q[] f2467f;

    /* JADX INFO: renamed from: g */
    public final AbstractC1946e[] f2468g;

    /* JADX INFO: renamed from: h */
    public final AbstractC0406d[] f2469h;

    /* JADX INFO: renamed from: i */
    public final AbstractC1986a[] f2470i;

    public C0829o(AbstractC1177l[] abstractC1177lArr, C1201q[] c1201qArr, AbstractC1946e[] abstractC1946eArr, AbstractC0406d[] abstractC0406dArr, AbstractC1986a[] abstractC1986aArr) {
        this.f2466e = abstractC1177lArr == null ? f2461j : abstractC1177lArr;
        this.f2467f = c1201qArr == null ? f2465n : c1201qArr;
        this.f2468g = abstractC1946eArr == null ? f2462k : abstractC1946eArr;
        this.f2469h = abstractC0406dArr == null ? f2463l : abstractC0406dArr;
        this.f2470i = abstractC1986aArr == null ? f2464m : abstractC1986aArr;
    }

    /* JADX INFO: renamed from: a */
    public final C1740e m2144a() {
        return new C1740e(this.f2468g);
    }

    /* JADX INFO: renamed from: b */
    public final C1740e m2145b() {
        return new C1740e(this.f2466e);
    }

    /* JADX INFO: renamed from: c */
    public final boolean m2146c() {
        return this.f2468g.length > 0;
    }
}
