package p039M0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: M0.n */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0499n {

    /* JADX INFO: renamed from: e */
    public static final EnumC0499n f1147e;

    /* JADX INFO: renamed from: f */
    public static final EnumC0499n f1148f;

    /* JADX INFO: renamed from: g */
    public static final EnumC0499n f1149g;

    /* JADX INFO: renamed from: h */
    public static final EnumC0499n f1150h;

    /* JADX INFO: renamed from: i */
    public static final EnumC0499n f1151i;

    /* JADX INFO: renamed from: j */
    public static final EnumC0499n f1152j;

    /* JADX INFO: renamed from: k */
    public static final /* synthetic */ EnumC0499n[] f1153k;

    static {
        EnumC0499n enumC0499n = new EnumC0499n("ACCEPT_SINGLE_VALUE_AS_ARRAY", 0);
        f1147e = enumC0499n;
        EnumC0499n enumC0499n2 = new EnumC0499n("ACCEPT_CASE_INSENSITIVE_PROPERTIES", 1);
        f1148f = enumC0499n2;
        EnumC0499n enumC0499n3 = new EnumC0499n("READ_UNKNOWN_ENUM_VALUES_AS_NULL", 2);
        f1149g = enumC0499n3;
        EnumC0499n enumC0499n4 = new EnumC0499n("READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE", 3);
        f1150h = enumC0499n4;
        EnumC0499n enumC0499n5 = new EnumC0499n("READ_DATE_TIMESTAMPS_AS_NANOSECONDS", 4);
        EnumC0499n enumC0499n6 = new EnumC0499n("ACCEPT_CASE_INSENSITIVE_VALUES", 5);
        EnumC0499n enumC0499n7 = new EnumC0499n("WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS", 6);
        EnumC0499n enumC0499n8 = new EnumC0499n("WRITE_DATES_WITH_ZONE_ID", 7);
        EnumC0499n enumC0499n9 = new EnumC0499n("WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED", 8);
        f1151i = enumC0499n9;
        EnumC0499n enumC0499n10 = new EnumC0499n("WRITE_SORTED_MAP_ENTRIES", 9);
        f1152j = enumC0499n10;
        f1153k = new EnumC0499n[]{enumC0499n, enumC0499n2, enumC0499n3, enumC0499n4, enumC0499n5, enumC0499n6, enumC0499n7, enumC0499n8, enumC0499n9, enumC0499n10, new EnumC0499n("ADJUST_DATES_TO_CONTEXT_TIME_ZONE", 10)};
    }

    public static EnumC0499n valueOf(String str) {
        return (EnumC0499n) Enum.valueOf(EnumC0499n.class, str);
    }

    public static EnumC0499n[] values() {
        return (EnumC0499n[]) f1153k.clone();
    }
}
