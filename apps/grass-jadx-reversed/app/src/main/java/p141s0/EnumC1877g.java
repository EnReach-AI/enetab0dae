package p141s0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: s0.g */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC1877g {

    /* JADX INFO: renamed from: e */
    public static final EnumC1877g f6610e;

    /* JADX INFO: renamed from: f */
    public static final EnumC1877g f6611f;

    /* JADX INFO: renamed from: g */
    public static final /* synthetic */ EnumC1877g[] f6612g;

    static {
        EnumC1877g enumC1877g = new EnumC1877g("MOBILE_INSTALL_EVENT", 0);
        f6610e = enumC1877g;
        EnumC1877g enumC1877g2 = new EnumC1877g("CUSTOM_APP_EVENTS", 1);
        f6611f = enumC1877g2;
        f6612g = new EnumC1877g[]{enumC1877g, enumC1877g2};
    }

    public static EnumC1877g valueOf(String str) {
        return (EnumC1877g) Enum.valueOf(EnumC1877g.class, str);
    }

    public static EnumC1877g[] values() {
        return (EnumC1877g[]) f6612g.clone();
    }
}
