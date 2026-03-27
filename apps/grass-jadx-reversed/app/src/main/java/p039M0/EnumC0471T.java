package p039M0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: M0.T */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0471T {

    /* JADX INFO: renamed from: e */
    public static final EnumC0471T f1107e;

    /* JADX INFO: renamed from: f */
    public static final EnumC0471T f1108f;

    /* JADX INFO: renamed from: g */
    public static final EnumC0471T f1109g;

    /* JADX INFO: renamed from: h */
    public static final EnumC0471T f1110h;

    /* JADX INFO: renamed from: i */
    public static final EnumC0471T f1111i;

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ EnumC0471T[] f1112j;

    static {
        EnumC0471T enumC0471T = new EnumC0471T("PROPERTY", 0);
        f1107e = enumC0471T;
        EnumC0471T enumC0471T2 = new EnumC0471T("WRAPPER_OBJECT", 1);
        f1108f = enumC0471T2;
        EnumC0471T enumC0471T3 = new EnumC0471T("WRAPPER_ARRAY", 2);
        f1109g = enumC0471T3;
        EnumC0471T enumC0471T4 = new EnumC0471T("EXTERNAL_PROPERTY", 3);
        f1110h = enumC0471T4;
        EnumC0471T enumC0471T5 = new EnumC0471T("EXISTING_PROPERTY", 4);
        f1111i = enumC0471T5;
        f1112j = new EnumC0471T[]{enumC0471T, enumC0471T2, enumC0471T3, enumC0471T4, enumC0471T5};
    }

    public static EnumC0471T valueOf(String str) {
        return (EnumC0471T) Enum.valueOf(EnumC0471T.class, str);
    }

    public static EnumC0471T[] values() {
        return (EnumC0471T[]) f1112j.clone();
    }
}
