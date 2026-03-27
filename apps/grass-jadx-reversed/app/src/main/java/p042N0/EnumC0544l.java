package p042N0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: N0.l */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0544l {

    /* JADX INFO: renamed from: e */
    public static final EnumC0544l f1298e;

    /* JADX INFO: renamed from: f */
    public static final EnumC0544l f1299f;

    /* JADX INFO: renamed from: g */
    public static final EnumC0544l f1300g;

    /* JADX INFO: renamed from: h */
    public static final EnumC0544l f1301h;

    /* JADX INFO: renamed from: i */
    public static final EnumC0544l f1302i;

    /* JADX INFO: renamed from: j */
    public static final EnumC0544l f1303j;

    /* JADX INFO: renamed from: k */
    public static final /* synthetic */ EnumC0544l[] f1304k;

    static {
        EnumC0544l enumC0544l = new EnumC0544l("INT", 0);
        f1298e = enumC0544l;
        EnumC0544l enumC0544l2 = new EnumC0544l("LONG", 1);
        f1299f = enumC0544l2;
        EnumC0544l enumC0544l3 = new EnumC0544l("BIG_INTEGER", 2);
        f1300g = enumC0544l3;
        EnumC0544l enumC0544l4 = new EnumC0544l("FLOAT", 3);
        f1301h = enumC0544l4;
        EnumC0544l enumC0544l5 = new EnumC0544l("DOUBLE", 4);
        f1302i = enumC0544l5;
        EnumC0544l enumC0544l6 = new EnumC0544l("BIG_DECIMAL", 5);
        f1303j = enumC0544l6;
        f1304k = new EnumC0544l[]{enumC0544l, enumC0544l2, enumC0544l3, enumC0544l4, enumC0544l5, enumC0544l6};
    }

    public static EnumC0544l valueOf(String str) {
        return (EnumC0544l) Enum.valueOf(EnumC0544l.class, str);
    }

    public static EnumC0544l[] values() {
        return (EnumC0544l[]) f1304k.clone();
    }
}
