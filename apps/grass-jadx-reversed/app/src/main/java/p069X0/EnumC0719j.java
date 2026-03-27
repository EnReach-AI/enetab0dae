package p069X0;

import p074Z0.InterfaceC0820f;

/* JADX INFO: renamed from: X0.j */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0719j implements InterfaceC0820f {
    USE_BIG_DECIMAL_FOR_FLOATS(false),
    USE_BIG_INTEGER_FOR_INTS(false),
    USE_LONG_FOR_INTS(false),
    USE_JAVA_ARRAY_FOR_JSON_ARRAY(false),
    FAIL_ON_UNKNOWN_PROPERTIES(true),
    FAIL_ON_NULL_FOR_PRIMITIVES(false),
    FAIL_ON_NUMBERS_FOR_ENUMS(false),
    FAIL_ON_INVALID_SUBTYPE(true),
    FAIL_ON_READING_DUP_TREE_KEY(false),
    FAIL_ON_IGNORED_PROPERTIES(false),
    FAIL_ON_UNRESOLVED_OBJECT_IDS(true),
    FAIL_ON_MISSING_CREATOR_PROPERTIES(false),
    FAIL_ON_NULL_CREATOR_PROPERTIES(false),
    FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY(true),
    FAIL_ON_TRAILING_TOKENS(false),
    WRAP_EXCEPTIONS(true),
    ACCEPT_SINGLE_VALUE_AS_ARRAY(false),
    UNWRAP_SINGLE_VALUE_ARRAYS(false),
    UNWRAP_ROOT_VALUE(false),
    ACCEPT_EMPTY_STRING_AS_NULL_OBJECT(false),
    ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT(false),
    ACCEPT_FLOAT_AS_INT(true),
    READ_ENUMS_USING_TO_STRING(false),
    READ_UNKNOWN_ENUM_VALUES_AS_NULL(false),
    READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE(false),
    /* JADX INFO: Fake field, exist only in values array */
    ADJUST_DATES_TO_CONTEXT_TIME_ZONE(true),
    /* JADX INFO: Fake field, exist only in values array */
    ADJUST_DATES_TO_CONTEXT_TIME_ZONE(true),
    EAGER_DESERIALIZER_FETCH(true);


    /* JADX INFO: renamed from: e */
    public final boolean f2034e;

    /* JADX INFO: renamed from: f */
    public final int f2035f = 1 << ordinal();

    EnumC0719j(boolean z3) {
        this.f2034e = z3;
    }

    @Override // p074Z0.InterfaceC0820f
    /* JADX INFO: renamed from: a */
    public final int mo1699a() {
        return this.f2035f;
    }

    @Override // p074Z0.InterfaceC0820f
    /* JADX INFO: renamed from: b */
    public final boolean mo1700b() {
        return this.f2034e;
    }
}
