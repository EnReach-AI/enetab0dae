package p092e1;

import java.util.HashMap;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: e1.b */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC1337b {

    /* JADX INFO: renamed from: e */
    public static final EnumC1337b f4763e;

    /* JADX INFO: renamed from: f */
    public static final EnumC1337b f4764f;

    /* JADX INFO: renamed from: g */
    public static final EnumC1337b f4765g;

    /* JADX INFO: renamed from: h */
    public static final EnumC1337b f4766h;

    /* JADX INFO: renamed from: i */
    public static final HashMap f4767i;

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ EnumC1337b[] f4768j;

    static {
        EnumC1337b enumC1337b = new EnumC1337b("STRING", 0);
        f4763e = enumC1337b;
        EnumC1337b enumC1337b2 = new EnumC1337b("NUMBER", 1);
        f4764f = enumC1337b2;
        EnumC1337b enumC1337b3 = new EnumC1337b("INTEGER", 2);
        f4765g = enumC1337b3;
        EnumC1337b enumC1337b4 = new EnumC1337b("BOOLEAN", 3);
        f4766h = enumC1337b4;
        f4768j = new EnumC1337b[]{enumC1337b, enumC1337b2, enumC1337b3, enumC1337b4, new EnumC1337b("OBJECT", 4), new EnumC1337b("ARRAY", 5), new EnumC1337b("NULL", 6), new EnumC1337b("ANY", 7)};
        f4767i = new HashMap();
        for (EnumC1337b enumC1337b5 : values()) {
            f4767i.put(enumC1337b5.name().toLowerCase(), enumC1337b5);
        }
    }

    public static EnumC1337b valueOf(String str) {
        return (EnumC1337b) Enum.valueOf(EnumC1337b.class, str);
    }

    public static EnumC1337b[] values() {
        return (EnumC1337b[]) f4768j.clone();
    }
}
