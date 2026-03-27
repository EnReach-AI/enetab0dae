package p039M0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: M0.g0 */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0491g0 {

    /* JADX INFO: renamed from: e */
    public static final EnumC0491g0 f1137e;

    /* JADX INFO: renamed from: f */
    public static final EnumC0491g0 f1138f;

    /* JADX INFO: renamed from: g */
    public static final /* synthetic */ EnumC0491g0[] f1139g;

    static {
        EnumC0491g0 enumC0491g0 = new EnumC0491g0("TRUE", 0);
        f1137e = enumC0491g0;
        EnumC0491g0 enumC0491g02 = new EnumC0491g0("FALSE", 1);
        EnumC0491g0 enumC0491g03 = new EnumC0491g0("DEFAULT", 2);
        f1138f = enumC0491g03;
        f1139g = new EnumC0491g0[]{enumC0491g0, enumC0491g02, enumC0491g03};
    }

    public static EnumC0491g0 valueOf(String str) {
        return (EnumC0491g0) Enum.valueOf(EnumC0491g0.class, str);
    }

    public static EnumC0491g0[] values() {
        return (EnumC0491g0[]) f1139g.clone();
    }

    /* JADX INFO: renamed from: a */
    public final Boolean m1007a() {
        if (this == f1138f) {
            return null;
        }
        return this == f1137e ? Boolean.TRUE : Boolean.FALSE;
    }
}
