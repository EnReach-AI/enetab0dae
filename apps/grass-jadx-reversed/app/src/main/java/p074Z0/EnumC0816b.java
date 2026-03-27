package p074Z0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: Z0.b */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0816b {

    /* JADX INFO: renamed from: e */
    public static final EnumC0816b f2430e;

    /* JADX INFO: renamed from: f */
    public static final EnumC0816b f2431f;

    /* JADX INFO: renamed from: g */
    public static final EnumC0816b f2432g;

    /* JADX INFO: renamed from: h */
    public static final EnumC0816b f2433h;

    /* JADX INFO: renamed from: i */
    public static final /* synthetic */ EnumC0816b[] f2434i;

    static {
        EnumC0816b enumC0816b = new EnumC0816b("Fail", 0);
        f2430e = enumC0816b;
        EnumC0816b enumC0816b2 = new EnumC0816b("TryConvert", 1);
        f2431f = enumC0816b2;
        EnumC0816b enumC0816b3 = new EnumC0816b("AsNull", 2);
        f2432g = enumC0816b3;
        EnumC0816b enumC0816b4 = new EnumC0816b("AsEmpty", 3);
        f2433h = enumC0816b4;
        f2434i = new EnumC0816b[]{enumC0816b, enumC0816b2, enumC0816b3, enumC0816b4};
    }

    public static EnumC0816b valueOf(String str) {
        return (EnumC0816b) Enum.valueOf(EnumC0816b.class, str);
    }

    public static EnumC0816b[] values() {
        return (EnumC0816b[]) f2434i.clone();
    }
}
