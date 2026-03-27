package p166z0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: z0.s */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC2081s {

    /* JADX INFO: renamed from: e */
    public static final EnumC2081s f7365e;

    /* JADX INFO: renamed from: f */
    public static final EnumC2081s f7366f;

    /* JADX INFO: renamed from: g */
    public static final EnumC2081s f7367g;

    /* JADX INFO: renamed from: h */
    public static final EnumC2081s f7368h;

    /* JADX INFO: renamed from: i */
    public static final /* synthetic */ EnumC2081s[] f7369i;

    static {
        EnumC2081s enumC2081s = new EnumC2081s("NOT_LOADED", 0);
        f7365e = enumC2081s;
        EnumC2081s enumC2081s2 = new EnumC2081s("LOADING", 1);
        f7366f = enumC2081s2;
        EnumC2081s enumC2081s3 = new EnumC2081s("SUCCESS", 2);
        f7367g = enumC2081s3;
        EnumC2081s enumC2081s4 = new EnumC2081s("ERROR", 3);
        f7368h = enumC2081s4;
        f7369i = new EnumC2081s[]{enumC2081s, enumC2081s2, enumC2081s3, enumC2081s4};
    }

    public static EnumC2081s valueOf(String str) {
        return (EnumC2081s) Enum.valueOf(EnumC2081s.class, str);
    }

    public static EnumC2081s[] values() {
        return (EnumC2081s[]) f7369i.clone();
    }
}
