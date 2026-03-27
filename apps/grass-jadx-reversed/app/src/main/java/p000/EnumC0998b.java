package p000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: b */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0998b {

    /* JADX INFO: renamed from: e */
    public static final EnumC0998b f3564e;

    /* JADX INFO: renamed from: f */
    public static final EnumC0998b f3565f;

    /* JADX INFO: renamed from: g */
    public static final EnumC0998b f3566g;

    /* JADX INFO: renamed from: h */
    public static final EnumC0998b f3567h;

    /* JADX INFO: renamed from: i */
    public static final /* synthetic */ EnumC0998b[] f3568i;

    static {
        EnumC0998b enumC0998b = new EnumC0998b("WIFI", 0);
        f3564e = enumC0998b;
        EnumC0998b enumC0998b2 = new EnumC0998b("CELLULAR", 1);
        f3565f = enumC0998b2;
        EnumC0998b enumC0998b3 = new EnumC0998b("NONE", 2);
        f3566g = enumC0998b3;
        EnumC0998b enumC0998b4 = new EnumC0998b("UNKNOWN", 3);
        f3567h = enumC0998b4;
        f3568i = new EnumC0998b[]{enumC0998b, enumC0998b2, enumC0998b3, enumC0998b4};
    }

    public static EnumC0998b valueOf(String str) {
        return (EnumC0998b) Enum.valueOf(EnumC0998b.class, str);
    }

    public static EnumC0998b[] values() {
        return (EnumC0998b[]) f3568i.clone();
    }
}
