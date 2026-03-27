package p039M0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: M0.H */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0460H {

    /* JADX INFO: renamed from: e */
    public static final EnumC0460H f1102e;

    /* JADX INFO: renamed from: f */
    public static final /* synthetic */ EnumC0460H[] f1103f;

    static {
        EnumC0460H enumC0460H = new EnumC0460H("AUTO", 0);
        f1102e = enumC0460H;
        f1103f = new EnumC0460H[]{enumC0460H, new EnumC0460H("READ_ONLY", 1), new EnumC0460H("WRITE_ONLY", 2), new EnumC0460H("READ_WRITE", 3)};
    }

    public static EnumC0460H valueOf(String str) {
        return (EnumC0460H) Enum.valueOf(EnumC0460H.class, str);
    }

    public static EnumC0460H[] values() {
        return (EnumC0460H[]) f1103f.clone();
    }
}
