package p069X0;

import p074Z0.InterfaceC0820f;

/* JADX INFO: renamed from: X0.J */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0708J implements InterfaceC0820f {
    WRAP_ROOT_VALUE(false),
    INDENT_OUTPUT(false),
    FAIL_ON_EMPTY_BEANS(true),
    FAIL_ON_SELF_REFERENCES(true),
    WRAP_EXCEPTIONS(true),
    FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS(true),
    WRITE_SELF_REFERENCES_AS_NULL(false),
    CLOSE_CLOSEABLE(false),
    FLUSH_AFTER_WRITE_VALUE(true),
    WRITE_DATES_AS_TIMESTAMPS(true),
    WRITE_DATE_KEYS_AS_TIMESTAMPS(false),
    /* JADX INFO: Fake field, exist only in values array */
    WRITE_DATES_WITH_ZONE_ID(false),
    /* JADX INFO: Fake field, exist only in values array */
    WRITE_DATES_WITH_CONTEXT_TIME_ZONE(true),
    /* JADX INFO: Fake field, exist only in values array */
    WRITE_DURATIONS_AS_TIMESTAMPS(true),
    WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS(false),
    WRITE_ENUMS_USING_TO_STRING(false),
    WRITE_ENUMS_USING_INDEX(false),
    WRITE_ENUM_KEYS_USING_INDEX(false),
    WRITE_NULL_MAP_VALUES(true),
    WRITE_EMPTY_JSON_ARRAYS(true),
    WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED(false),
    WRITE_BIGDECIMAL_AS_PLAIN(false),
    /* JADX INFO: Fake field, exist only in values array */
    EAGER_SERIALIZER_FETCH(true),
    ORDER_MAP_ENTRIES_BY_KEYS(false),
    /* JADX INFO: Fake field, exist only in values array */
    EAGER_SERIALIZER_FETCH(true),
    USE_EQUALITY_FOR_OBJECT_ID(false);


    /* JADX INFO: renamed from: e */
    public final boolean f1962e;

    /* JADX INFO: renamed from: f */
    public final int f1963f = 1 << ordinal();

    EnumC0708J(boolean z3) {
        this.f1962e = z3;
    }

    @Override // p074Z0.InterfaceC0820f
    /* JADX INFO: renamed from: a */
    public final int mo1699a() {
        return this.f1963f;
    }

    @Override // p074Z0.InterfaceC0820f
    /* JADX INFO: renamed from: b */
    public final boolean mo1700b() {
        return this.f1962e;
    }
}
