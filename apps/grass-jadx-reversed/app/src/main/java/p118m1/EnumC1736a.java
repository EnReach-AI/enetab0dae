package p118m1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: m1.a */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC1736a {

    /* JADX INFO: renamed from: e */
    public static final EnumC1736a f6081e;

    /* JADX INFO: renamed from: f */
    public static final EnumC1736a f6082f;

    /* JADX INFO: renamed from: g */
    public static final EnumC1736a f6083g;

    /* JADX INFO: renamed from: h */
    public static final /* synthetic */ EnumC1736a[] f6084h;

    static {
        EnumC1736a enumC1736a = new EnumC1736a("ALWAYS_NULL", 0);
        f6081e = enumC1736a;
        EnumC1736a enumC1736a2 = new EnumC1736a("CONSTANT", 1);
        f6082f = enumC1736a2;
        EnumC1736a enumC1736a3 = new EnumC1736a("DYNAMIC", 2);
        f6083g = enumC1736a3;
        f6084h = new EnumC1736a[]{enumC1736a, enumC1736a2, enumC1736a3};
    }

    public static EnumC1736a valueOf(String str) {
        return (EnumC1736a) Enum.valueOf(EnumC1736a.class, str);
    }

    public static EnumC1736a[] values() {
        return (EnumC1736a[]) f6084h.clone();
    }
}
