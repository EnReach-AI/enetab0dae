package com.facebook;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: com.facebook.z */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC1129z {

    /* JADX INFO: renamed from: e */
    public static final EnumC1129z f3922e;

    /* JADX INFO: renamed from: f */
    public static final EnumC1129z f3923f;

    /* JADX INFO: renamed from: g */
    public static final /* synthetic */ EnumC1129z[] f3924g;

    static {
        EnumC1129z enumC1129z = new EnumC1129z("GET", 0);
        f3922e = enumC1129z;
        EnumC1129z enumC1129z2 = new EnumC1129z("POST", 1);
        f3923f = enumC1129z2;
        f3924g = new EnumC1129z[]{enumC1129z, enumC1129z2, new EnumC1129z("DELETE", 2)};
    }

    public static EnumC1129z valueOf(String str) {
        return (EnumC1129z) Enum.valueOf(EnumC1129z.class, str);
    }

    public static EnumC1129z[] values() {
        return (EnumC1129z[]) f3924g.clone();
    }
}
