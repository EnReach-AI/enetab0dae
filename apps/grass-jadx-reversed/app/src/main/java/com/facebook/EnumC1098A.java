package com.facebook;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: com.facebook.A */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC1098A {

    /* JADX INFO: renamed from: e */
    public static final EnumC1098A f3788e;

    /* JADX INFO: renamed from: f */
    public static final EnumC1098A f3789f;

    /* JADX INFO: renamed from: g */
    public static final /* synthetic */ EnumC1098A[] f3790g;

    static {
        EnumC1098A enumC1098A = new EnumC1098A("REQUESTS", 0);
        f3788e = enumC1098A;
        EnumC1098A enumC1098A2 = new EnumC1098A("INCLUDE_ACCESS_TOKENS", 1);
        EnumC1098A enumC1098A3 = new EnumC1098A("INCLUDE_RAW_RESPONSES", 2);
        EnumC1098A enumC1098A4 = new EnumC1098A("CACHE", 3);
        EnumC1098A enumC1098A5 = new EnumC1098A("APP_EVENTS", 4);
        EnumC1098A enumC1098A6 = new EnumC1098A("DEVELOPER_ERRORS", 5);
        f3789f = enumC1098A6;
        f3790g = new EnumC1098A[]{enumC1098A, enumC1098A2, enumC1098A3, enumC1098A4, enumC1098A5, enumC1098A6, new EnumC1098A("GRAPH_API_DEBUG_WARNING", 6), new EnumC1098A("GRAPH_API_DEBUG_INFO", 7)};
    }

    public static EnumC1098A valueOf(String str) {
        return (EnumC1098A) Enum.valueOf(EnumC1098A.class, str);
    }

    public static EnumC1098A[] values() {
        return (EnumC1098A[]) f3790g.clone();
    }
}
