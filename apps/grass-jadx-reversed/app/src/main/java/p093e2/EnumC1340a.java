package p093e2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: e2.a */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC1340a {

    /* JADX INFO: renamed from: e */
    public static final EnumC1340a f4774e;

    /* JADX INFO: renamed from: f */
    public static final /* synthetic */ EnumC1340a[] f4775f;

    static {
        EnumC1340a enumC1340a = new EnumC1340a("COROUTINE_SUSPENDED", 0);
        f4774e = enumC1340a;
        f4775f = new EnumC1340a[]{enumC1340a, new EnumC1340a("UNDECIDED", 1), new EnumC1340a("RESUMED", 2)};
    }

    public static EnumC1340a valueOf(String str) {
        return (EnumC1340a) Enum.valueOf(EnumC1340a.class, str);
    }

    public static EnumC1340a[] values() {
        return (EnumC1340a[]) f4775f.clone();
    }
}
