package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: androidx.lifecycle.l */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0979l {

    /* JADX INFO: renamed from: e */
    public static final EnumC0979l f3318e;

    /* JADX INFO: renamed from: f */
    public static final EnumC0979l f3319f;

    /* JADX INFO: renamed from: g */
    public static final EnumC0979l f3320g;

    /* JADX INFO: renamed from: h */
    public static final EnumC0979l f3321h;

    /* JADX INFO: renamed from: i */
    public static final EnumC0979l f3322i;

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ EnumC0979l[] f3323j;

    static {
        EnumC0979l enumC0979l = new EnumC0979l("DESTROYED", 0);
        f3318e = enumC0979l;
        EnumC0979l enumC0979l2 = new EnumC0979l("INITIALIZED", 1);
        f3319f = enumC0979l2;
        EnumC0979l enumC0979l3 = new EnumC0979l("CREATED", 2);
        f3320g = enumC0979l3;
        EnumC0979l enumC0979l4 = new EnumC0979l("STARTED", 3);
        f3321h = enumC0979l4;
        EnumC0979l enumC0979l5 = new EnumC0979l("RESUMED", 4);
        f3322i = enumC0979l5;
        f3323j = new EnumC0979l[]{enumC0979l, enumC0979l2, enumC0979l3, enumC0979l4, enumC0979l5};
    }

    public static EnumC0979l valueOf(String str) {
        return (EnumC0979l) Enum.valueOf(EnumC0979l.class, str);
    }

    public static EnumC0979l[] values() {
        return (EnumC0979l[]) f3323j.clone();
    }

    /* JADX INFO: renamed from: a */
    public final boolean m2513a(EnumC0979l enumC0979l) {
        return compareTo(enumC0979l) >= 0;
    }
}
