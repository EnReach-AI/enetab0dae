package p071Y0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: Y0.j */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0746j {

    /* JADX INFO: renamed from: e */
    public static final EnumC0746j f2106e;

    /* JADX INFO: renamed from: f */
    public static final /* synthetic */ EnumC0746j[] f2107f;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0746j EF0;

    static {
        EnumC0746j enumC0746j = new EnumC0746j("ALWAYS", 0);
        EnumC0746j enumC0746j2 = new EnumC0746j("NON_NULL", 1);
        EnumC0746j enumC0746j3 = new EnumC0746j("NON_DEFAULT", 2);
        EnumC0746j enumC0746j4 = new EnumC0746j("NON_EMPTY", 3);
        EnumC0746j enumC0746j5 = new EnumC0746j("DEFAULT_INCLUSION", 4);
        f2106e = enumC0746j5;
        f2107f = new EnumC0746j[]{enumC0746j, enumC0746j2, enumC0746j3, enumC0746j4, enumC0746j5};
    }

    public static EnumC0746j valueOf(String str) {
        return (EnumC0746j) Enum.valueOf(EnumC0746j.class, str);
    }

    public static EnumC0746j[] values() {
        return (EnumC0746j[]) f2107f.clone();
    }
}
