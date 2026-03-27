package p117m0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: m0.p */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC1721p {

    /* JADX INFO: renamed from: e */
    public static final EnumC1721p f6006e;

    /* JADX INFO: renamed from: f */
    public static final EnumC1721p f6007f;

    /* JADX INFO: renamed from: g */
    public static final EnumC1721p f6008g;

    /* JADX INFO: renamed from: h */
    public static final /* synthetic */ EnumC1721p[] f6009h;

    static {
        EnumC1721p enumC1721p = new EnumC1721p("SUCCESS", 0);
        f6006e = enumC1721p;
        EnumC1721p enumC1721p2 = new EnumC1721p("SERVER_ERROR", 1);
        f6007f = enumC1721p2;
        EnumC1721p enumC1721p3 = new EnumC1721p("NO_CONNECTIVITY", 2);
        f6008g = enumC1721p3;
        f6009h = new EnumC1721p[]{enumC1721p, enumC1721p2, enumC1721p3, new EnumC1721p("UNKNOWN_ERROR", 3)};
    }

    public static EnumC1721p valueOf(String str) {
        return (EnumC1721p) Enum.valueOf(EnumC1721p.class, str);
    }

    public static EnumC1721p[] values() {
        return (EnumC1721p[]) f6009h.clone();
    }
}
