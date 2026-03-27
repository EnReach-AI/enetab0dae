package p117m0;

import java.io.Serializable;

/* JADX INFO: renamed from: m0.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1710e implements Serializable {
    private static final long serialVersionUID = 20160803001L;

    /* JADX INFO: renamed from: e */
    public final String f5979e;

    /* JADX INFO: renamed from: f */
    public final boolean f5980f;

    /* JADX INFO: renamed from: g */
    public final boolean f5981g;

    /* JADX INFO: renamed from: h */
    public final String f5982h;

    public C1710e(String str, boolean z3, boolean z4, String str2) {
        this.f5979e = str;
        this.f5980f = z3;
        this.f5981g = z4;
        this.f5982h = str2;
    }

    private Object readResolve() {
        return new C1711f(this.f5979e, this.f5980f, this.f5981g, this.f5982h);
    }
}
