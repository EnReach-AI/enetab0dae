package p058T0;

import p042N0.EnumC0543k;
import p066W0.InterfaceC0683j;

/* JADX INFO: renamed from: T0.d */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0639d implements InterfaceC0683j {
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_JAVA_COMMENTS(EnumC0543k.ALLOW_COMMENTS),
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_YAML_COMMENTS(EnumC0543k.ALLOW_YAML_COMMENTS),
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_SINGLE_QUOTES(EnumC0543k.ALLOW_SINGLE_QUOTES),
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_UNQUOTED_FIELD_NAMES(EnumC0543k.ALLOW_UNQUOTED_FIELD_NAMES),
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_UNESCAPED_CONTROL_CHARS(EnumC0543k.ALLOW_UNQUOTED_CONTROL_CHARS),
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(EnumC0543k.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER),
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_LEADING_ZEROS_FOR_NUMBERS(EnumC0543k.ALLOW_NUMERIC_LEADING_ZEROS),
    ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS(EnumC0543k.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS),
    ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS(EnumC0543k.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS),
    ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS(EnumC0543k.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS),
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_NON_NUMERIC_NUMBERS(EnumC0543k.ALLOW_NON_NUMERIC_NUMBERS),
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_MISSING_VALUES(EnumC0543k.ALLOW_MISSING_VALUES),
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_TRAILING_COMMA(EnumC0543k.ALLOW_TRAILING_COMMA);


    /* JADX INFO: renamed from: e */
    public final int f1656e = 1 << ordinal();

    /* JADX INFO: renamed from: f */
    public final EnumC0543k f1657f;

    EnumC0639d(EnumC0543k enumC0543k) {
        this.f1657f = enumC0543k;
    }

    @Override // p066W0.InterfaceC0683j
    /* JADX INFO: renamed from: a */
    public final int mo1234a() {
        return this.f1656e;
    }

    @Override // p066W0.InterfaceC0683j
    /* JADX INFO: renamed from: b */
    public final boolean mo1235b() {
        return false;
    }
}
