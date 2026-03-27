package p074Z0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: Z0.e */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0819e {

    /* JADX INFO: renamed from: e */
    public static final EnumC0819e f2439e;

    /* JADX INFO: renamed from: f */
    public static final EnumC0819e f2440f;

    /* JADX INFO: renamed from: g */
    public static final EnumC0819e f2441g;

    /* JADX INFO: renamed from: h */
    public static final EnumC0819e f2442h;

    /* JADX INFO: renamed from: i */
    public static final EnumC0819e f2443i;

    /* JADX INFO: renamed from: j */
    public static final EnumC0819e f2444j;

    /* JADX INFO: renamed from: k */
    public static final /* synthetic */ EnumC0819e[] f2445k;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0819e EF0;

    static {
        EnumC0819e enumC0819e = new EnumC0819e("Array", 0);
        EnumC0819e enumC0819e2 = new EnumC0819e("Object", 1);
        EnumC0819e enumC0819e3 = new EnumC0819e("Integer", 2);
        f2439e = enumC0819e3;
        EnumC0819e enumC0819e4 = new EnumC0819e("Float", 3);
        f2440f = enumC0819e4;
        EnumC0819e enumC0819e5 = new EnumC0819e("Boolean", 4);
        f2441g = enumC0819e5;
        EnumC0819e enumC0819e6 = new EnumC0819e("String", 5);
        f2442h = enumC0819e6;
        EnumC0819e enumC0819e7 = new EnumC0819e("Binary", 6);
        EnumC0819e enumC0819e8 = new EnumC0819e("EmptyArray", 7);
        f2443i = enumC0819e8;
        EnumC0819e enumC0819e9 = new EnumC0819e("EmptyObject", 8);
        EnumC0819e enumC0819e10 = new EnumC0819e("EmptyString", 9);
        f2444j = enumC0819e10;
        f2445k = new EnumC0819e[]{enumC0819e, enumC0819e2, enumC0819e3, enumC0819e4, enumC0819e5, enumC0819e6, enumC0819e7, enumC0819e8, enumC0819e9, enumC0819e10};
    }

    public static EnumC0819e valueOf(String str) {
        return (EnumC0819e) Enum.valueOf(EnumC0819e.class, str);
    }

    public static EnumC0819e[] values() {
        return (EnumC0819e[]) f2445k.clone();
    }
}
