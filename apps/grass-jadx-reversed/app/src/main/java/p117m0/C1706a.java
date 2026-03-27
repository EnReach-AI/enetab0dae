package p117m0;

import java.io.Serializable;

/* JADX INFO: renamed from: m0.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1706a implements Serializable {
    private static final long serialVersionUID = -2488473066578201069L;

    /* JADX INFO: renamed from: e */
    public final String f5972e;

    /* JADX INFO: renamed from: f */
    public final String f5973f;

    public C1706a(String str, String str2) {
        this.f5972e = str;
        this.f5973f = str2;
    }

    private Object readResolve() {
        return new C1707b(this.f5972e, this.f5973f);
    }
}
