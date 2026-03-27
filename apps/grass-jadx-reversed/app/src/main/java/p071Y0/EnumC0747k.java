package p071Y0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: Y0.k */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0747k {

    /* JADX INFO: renamed from: e */
    public static final EnumC0747k f2108e;

    /* JADX INFO: renamed from: f */
    public static final EnumC0747k f2109f;

    /* JADX INFO: renamed from: g */
    public static final EnumC0747k f2110g;

    /* JADX INFO: renamed from: h */
    public static final /* synthetic */ EnumC0747k[] f2111h;

    static {
        EnumC0747k enumC0747k = new EnumC0747k("DYNAMIC", 0);
        f2108e = enumC0747k;
        EnumC0747k enumC0747k2 = new EnumC0747k("STATIC", 1);
        f2109f = enumC0747k2;
        EnumC0747k enumC0747k3 = new EnumC0747k("DEFAULT_TYPING", 2);
        f2110g = enumC0747k3;
        f2111h = new EnumC0747k[]{enumC0747k, enumC0747k2, enumC0747k3};
    }

    public static EnumC0747k valueOf(String str) {
        return (EnumC0747k) Enum.valueOf(EnumC0747k.class, str);
    }

    public static EnumC0747k[] values() {
        return (EnumC0747k[]) f2111h.clone();
    }
}
