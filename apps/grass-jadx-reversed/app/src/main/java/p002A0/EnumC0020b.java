package p002A0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: A0.b */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0020b {

    /* JADX INFO: renamed from: e */
    public static final EnumC0020b f59e;

    /* JADX INFO: renamed from: f */
    public static final EnumC0020b f60f;

    /* JADX INFO: renamed from: g */
    public static final EnumC0020b f61g;

    /* JADX INFO: renamed from: h */
    public static final EnumC0020b f62h;

    /* JADX INFO: renamed from: i */
    public static final EnumC0020b f63i;

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ EnumC0020b[] f64j;

    static {
        EnumC0020b enumC0020b = new EnumC0020b("Unknown", 0);
        f59e = enumC0020b;
        EnumC0020b enumC0020b2 = new EnumC0020b("Analysis", 1);
        f60f = enumC0020b2;
        EnumC0020b enumC0020b3 = new EnumC0020b("CrashReport", 2);
        f61g = enumC0020b3;
        EnumC0020b enumC0020b4 = new EnumC0020b("CrashShield", 3);
        f62h = enumC0020b4;
        EnumC0020b enumC0020b5 = new EnumC0020b("ThreadCheck", 4);
        f63i = enumC0020b5;
        f64j = new EnumC0020b[]{enumC0020b, enumC0020b2, enumC0020b3, enumC0020b4, enumC0020b5};
    }

    public static EnumC0020b valueOf(String str) {
        return (EnumC0020b) Enum.valueOf(EnumC0020b.class, str);
    }

    public static EnumC0020b[] values() {
        return (EnumC0020b[]) f64j.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        int iOrdinal = ordinal();
        return iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? "Unknown" : "ThreadCheck" : "CrashShield" : "CrashReport" : "Analysis";
    }
}
