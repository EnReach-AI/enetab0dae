package p039M0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: M0.j */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0495j {

    /* JADX INFO: renamed from: e */
    public static final EnumC0495j f1142e;

    /* JADX INFO: renamed from: f */
    public static final EnumC0495j f1143f;

    /* JADX INFO: renamed from: g */
    public static final EnumC0495j f1144g;

    /* JADX INFO: renamed from: h */
    public static final EnumC0495j f1145h;

    /* JADX INFO: renamed from: i */
    public static final /* synthetic */ EnumC0495j[] f1146i;

    static {
        EnumC0495j enumC0495j = new EnumC0495j("DEFAULT", 0);
        f1142e = enumC0495j;
        EnumC0495j enumC0495j2 = new EnumC0495j("DELEGATING", 1);
        f1143f = enumC0495j2;
        EnumC0495j enumC0495j3 = new EnumC0495j("PROPERTIES", 2);
        f1144g = enumC0495j3;
        EnumC0495j enumC0495j4 = new EnumC0495j("DISABLED", 3);
        f1145h = enumC0495j4;
        f1146i = new EnumC0495j[]{enumC0495j, enumC0495j2, enumC0495j3, enumC0495j4};
    }

    public static EnumC0495j valueOf(String str) {
        return (EnumC0495j) Enum.valueOf(EnumC0495j.class, str);
    }

    public static EnumC0495j[] values() {
        return (EnumC0495j[]) f1146i.clone();
    }
}
