package p039M0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: M0.p */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0501p {

    /* JADX INFO: renamed from: e */
    public static final EnumC0501p f1157e;

    /* JADX INFO: renamed from: f */
    public static final EnumC0501p f1158f;

    /* JADX INFO: renamed from: g */
    public static final EnumC0501p f1159g;

    /* JADX INFO: renamed from: h */
    public static final EnumC0501p f1160h;

    /* JADX INFO: renamed from: i */
    public static final EnumC0501p f1161i;

    /* JADX INFO: renamed from: j */
    public static final EnumC0501p f1162j;

    /* JADX INFO: renamed from: k */
    public static final EnumC0501p f1163k;

    /* JADX INFO: renamed from: l */
    public static final EnumC0501p f1164l;

    /* JADX INFO: renamed from: m */
    public static final EnumC0501p f1165m;

    /* JADX INFO: renamed from: n */
    public static final EnumC0501p f1166n;

    /* JADX INFO: renamed from: o */
    public static final /* synthetic */ EnumC0501p[] f1167o;

    static {
        EnumC0501p enumC0501p = new EnumC0501p("ANY", 0);
        f1157e = enumC0501p;
        EnumC0501p enumC0501p2 = new EnumC0501p("NATURAL", 1);
        f1158f = enumC0501p2;
        EnumC0501p enumC0501p3 = new EnumC0501p("SCALAR", 2);
        f1159g = enumC0501p3;
        EnumC0501p enumC0501p4 = new EnumC0501p("ARRAY", 3);
        f1160h = enumC0501p4;
        EnumC0501p enumC0501p5 = new EnumC0501p("OBJECT", 4);
        f1161i = enumC0501p5;
        EnumC0501p enumC0501p6 = new EnumC0501p("NUMBER", 5);
        f1162j = enumC0501p6;
        EnumC0501p enumC0501p7 = new EnumC0501p("NUMBER_FLOAT", 6);
        f1163k = enumC0501p7;
        EnumC0501p enumC0501p8 = new EnumC0501p("NUMBER_INT", 7);
        f1164l = enumC0501p8;
        EnumC0501p enumC0501p9 = new EnumC0501p("STRING", 8);
        f1165m = enumC0501p9;
        EnumC0501p enumC0501p10 = new EnumC0501p("BOOLEAN", 9);
        EnumC0501p enumC0501p11 = new EnumC0501p("BINARY", 10);
        f1166n = enumC0501p11;
        f1167o = new EnumC0501p[]{enumC0501p, enumC0501p2, enumC0501p3, enumC0501p4, enumC0501p5, enumC0501p6, enumC0501p7, enumC0501p8, enumC0501p9, enumC0501p10, enumC0501p11};
    }

    public static EnumC0501p valueOf(String str) {
        return (EnumC0501p) Enum.valueOf(EnumC0501p.class, str);
    }

    public static EnumC0501p[] values() {
        return (EnumC0501p[]) f1167o.clone();
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1013a() {
        return this == f1162j || this == f1164l || this == f1163k;
    }
}
