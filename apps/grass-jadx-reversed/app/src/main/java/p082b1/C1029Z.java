package p082b1;

import java.io.Serializable;
import p039M0.EnumC0490g;

/* JADX INFO: renamed from: b1.Z */
/* JADX INFO: loaded from: classes.dex */
public final class C1029Z implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final C1029Z f3655j;

    /* JADX INFO: renamed from: k */
    public static final C1029Z f3656k;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final EnumC0490g f3657e;

    /* JADX INFO: renamed from: f */
    public final EnumC0490g f3658f;

    /* JADX INFO: renamed from: g */
    public final EnumC0490g f3659g;

    /* JADX INFO: renamed from: h */
    public final EnumC0490g f3660h;

    /* JADX INFO: renamed from: i */
    public final EnumC0490g f3661i;

    static {
        EnumC0490g enumC0490g = EnumC0490g.f1133f;
        EnumC0490g enumC0490g2 = EnumC0490g.f1132e;
        f3655j = new C1029Z(enumC0490g, enumC0490g, enumC0490g2, enumC0490g2, enumC0490g);
        f3656k = new C1029Z(enumC0490g, enumC0490g, enumC0490g, enumC0490g, enumC0490g);
    }

    public C1029Z(EnumC0490g enumC0490g, EnumC0490g enumC0490g2, EnumC0490g enumC0490g3, EnumC0490g enumC0490g4, EnumC0490g enumC0490g5) {
        this.f3657e = enumC0490g;
        this.f3658f = enumC0490g2;
        this.f3659g = enumC0490g3;
        this.f3660h = enumC0490g4;
        this.f3661i = enumC0490g5;
    }

    public final String toString() {
        return "[Visibility: getter=" + this.f3657e + ",isGetter=" + this.f3658f + ",setter=" + this.f3659g + ",creator=" + this.f3660h + ",field=" + this.f3661i + "]";
    }
}
