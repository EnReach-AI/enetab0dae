package p059T1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: T1.f */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0650f {

    /* JADX INFO: renamed from: e */
    public static final EnumC0650f f1746e;

    /* JADX INFO: renamed from: f */
    public static final EnumC0650f f1747f;

    /* JADX INFO: renamed from: g */
    public static final EnumC0650f f1748g;

    /* JADX INFO: renamed from: h */
    public static final /* synthetic */ EnumC0650f[] f1749h;

    static {
        EnumC0650f enumC0650f = new EnumC0650f("FORCE_NONE", 0);
        f1746e = enumC0650f;
        EnumC0650f enumC0650f2 = new EnumC0650f("FORCE_SQUARE", 1);
        f1747f = enumC0650f2;
        EnumC0650f enumC0650f3 = new EnumC0650f("FORCE_RECTANGLE", 2);
        f1748g = enumC0650f3;
        f1749h = new EnumC0650f[]{enumC0650f, enumC0650f2, enumC0650f3};
    }

    public static EnumC0650f valueOf(String str) {
        return (EnumC0650f) Enum.valueOf(EnumC0650f.class, str);
    }

    public static EnumC0650f[] values() {
        return (EnumC0650f[]) f1749h.clone();
    }
}
