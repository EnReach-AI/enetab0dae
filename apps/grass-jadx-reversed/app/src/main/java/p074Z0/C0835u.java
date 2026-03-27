package p074Z0;

import java.io.Serializable;
import p118m1.C1740e;
import p144t0.AbstractC1920f;
import p148u0.AbstractC1944c;

/* JADX INFO: renamed from: Z0.u */
/* JADX INFO: loaded from: classes.dex */
public final class C0835u implements Serializable {

    /* JADX INFO: renamed from: h */
    public static final AbstractC1944c[] f2492h = new AbstractC1944c[0];

    /* JADX INFO: renamed from: i */
    public static final AbstractC1920f[] f2493i = new AbstractC1920f[0];
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final AbstractC1944c[] f2494e;

    /* JADX INFO: renamed from: f */
    public final AbstractC1944c[] f2495f;

    /* JADX INFO: renamed from: g */
    public final AbstractC1920f[] f2496g;

    public C0835u() {
        AbstractC1944c[] abstractC1944cArr = f2492h;
        this.f2494e = abstractC1944cArr;
        this.f2495f = abstractC1944cArr;
        this.f2496g = f2493i;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m2160a() {
        return this.f2496g.length > 0;
    }

    /* JADX INFO: renamed from: b */
    public final C1740e m2161b() {
        return new C1740e(this.f2496g);
    }
}
