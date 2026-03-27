package p042N0;

/* JADX INFO: renamed from: N0.g */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0539g {
    AUTO_CLOSE_TARGET(true),
    AUTO_CLOSE_JSON_CONTENT(true),
    FLUSH_PASSED_TO_STREAM(true),
    QUOTE_FIELD_NAMES(true),
    QUOTE_NON_NUMERIC_NUMBERS(true),
    ESCAPE_NON_ASCII(false),
    WRITE_NUMBERS_AS_STRINGS(false),
    WRITE_BIGDECIMAL_AS_PLAIN(false),
    STRICT_DUPLICATE_DETECTION(false),
    /* JADX INFO: Fake field, exist only in values array */
    IGNORE_UNKNOWN(false),
    USE_FAST_DOUBLE_WRITER(false),
    WRITE_HEX_UPPER_CASE(true);


    /* JADX INFO: renamed from: e */
    public final boolean f1266e;

    /* JADX INFO: renamed from: f */
    public final int f1267f = 1 << ordinal();

    EnumC0539g(boolean z3) {
        this.f1266e = z3;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1106a(int i3) {
        return (i3 & this.f1267f) != 0;
    }
}
