package p042N0;

/* JADX INFO: renamed from: N0.k */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0543k {
    AUTO_CLOSE_SOURCE(true),
    ALLOW_COMMENTS(false),
    ALLOW_YAML_COMMENTS(false),
    ALLOW_UNQUOTED_FIELD_NAMES(false),
    ALLOW_SINGLE_QUOTES(false),
    ALLOW_UNQUOTED_CONTROL_CHARS(false),
    ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),
    ALLOW_NUMERIC_LEADING_ZEROS(false),
    ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS(false),
    ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS(false),
    ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS(false),
    ALLOW_NON_NUMERIC_NUMBERS(false),
    ALLOW_MISSING_VALUES(false),
    ALLOW_TRAILING_COMMA(false),
    STRICT_DUPLICATE_DETECTION(false),
    IGNORE_UNDEFINED(false),
    INCLUDE_SOURCE_IN_LOCATION(true),
    USE_FAST_DOUBLE_PARSER(false),
    USE_FAST_BIG_NUMBER_PARSER(false);


    /* JADX INFO: renamed from: e */
    public final boolean f1296e;

    /* JADX INFO: renamed from: f */
    public final int f1297f = 1 << ordinal();

    EnumC0543k(boolean z3) {
        this.f1296e = z3;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1155a(int i3) {
        return (i3 & this.f1297f) != 0;
    }
}
