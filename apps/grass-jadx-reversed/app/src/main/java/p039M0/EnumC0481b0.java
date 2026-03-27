package p039M0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: M0.b0 */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0481b0 {

    /* JADX INFO: renamed from: e */
    public static final EnumC0481b0 f1122e;

    /* JADX INFO: renamed from: f */
    public static final EnumC0481b0 f1123f;

    /* JADX INFO: renamed from: g */
    public static final EnumC0481b0 f1124g;

    /* JADX INFO: renamed from: h */
    public static final EnumC0481b0 f1125h;

    /* JADX INFO: renamed from: i */
    public static final /* synthetic */ EnumC0481b0[] f1126i;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0481b0 EF0;

    static {
        EnumC0481b0 enumC0481b0 = new EnumC0481b0("SET", 0);
        EnumC0481b0 enumC0481b02 = new EnumC0481b0("SKIP", 1);
        f1122e = enumC0481b02;
        EnumC0481b0 enumC0481b03 = new EnumC0481b0("FAIL", 2);
        f1123f = enumC0481b03;
        EnumC0481b0 enumC0481b04 = new EnumC0481b0("AS_EMPTY", 3);
        f1124g = enumC0481b04;
        EnumC0481b0 enumC0481b05 = new EnumC0481b0("DEFAULT", 4);
        f1125h = enumC0481b05;
        f1126i = new EnumC0481b0[]{enumC0481b0, enumC0481b02, enumC0481b03, enumC0481b04, enumC0481b05};
    }

    public static EnumC0481b0 valueOf(String str) {
        return (EnumC0481b0) Enum.valueOf(EnumC0481b0.class, str);
    }

    public static EnumC0481b0[] values() {
        return (EnumC0481b0[]) f1126i.clone();
    }
}
