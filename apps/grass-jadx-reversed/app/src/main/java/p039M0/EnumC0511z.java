package p039M0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: M0.z */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0511z {

    /* JADX INFO: renamed from: e */
    public static final EnumC0511z f1182e;

    /* JADX INFO: renamed from: f */
    public static final EnumC0511z f1183f;

    /* JADX INFO: renamed from: g */
    public static final EnumC0511z f1184g;

    /* JADX INFO: renamed from: h */
    public static final EnumC0511z f1185h;

    /* JADX INFO: renamed from: i */
    public static final EnumC0511z f1186i;

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ EnumC0511z[] f1187j;

    static {
        EnumC0511z enumC0511z = new EnumC0511z("ALWAYS", 0);
        f1182e = enumC0511z;
        EnumC0511z enumC0511z2 = new EnumC0511z("NON_NULL", 1);
        f1183f = enumC0511z2;
        EnumC0511z enumC0511z3 = new EnumC0511z("NON_ABSENT", 2);
        EnumC0511z enumC0511z4 = new EnumC0511z("NON_EMPTY", 3);
        f1184g = enumC0511z4;
        EnumC0511z enumC0511z5 = new EnumC0511z("NON_DEFAULT", 4);
        f1185h = enumC0511z5;
        EnumC0511z enumC0511z6 = new EnumC0511z("CUSTOM", 5);
        EnumC0511z enumC0511z7 = new EnumC0511z("USE_DEFAULTS", 6);
        f1186i = enumC0511z7;
        f1187j = new EnumC0511z[]{enumC0511z, enumC0511z2, enumC0511z3, enumC0511z4, enumC0511z5, enumC0511z6, enumC0511z7};
    }

    public static EnumC0511z valueOf(String str) {
        return (EnumC0511z) Enum.valueOf(EnumC0511z.class, str);
    }

    public static EnumC0511z[] values() {
        return (EnumC0511z[]) f1187j.clone();
    }
}
