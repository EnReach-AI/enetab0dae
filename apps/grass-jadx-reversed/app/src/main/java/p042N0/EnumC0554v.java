package p042N0;

import p066W0.InterfaceC0683j;

/* JADX INFO: renamed from: N0.v */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0554v implements InterfaceC0683j {
    /* JADX INFO: Fake field, exist only in values array */
    AUTO_CLOSE_SOURCE(EnumC0543k.AUTO_CLOSE_SOURCE),
    /* JADX INFO: Fake field, exist only in values array */
    STRICT_DUPLICATE_DETECTION(EnumC0543k.STRICT_DUPLICATE_DETECTION),
    /* JADX INFO: Fake field, exist only in values array */
    IGNORE_UNDEFINED(EnumC0543k.IGNORE_UNDEFINED),
    /* JADX INFO: Fake field, exist only in values array */
    INCLUDE_SOURCE_IN_LOCATION(EnumC0543k.INCLUDE_SOURCE_IN_LOCATION),
    USE_FAST_DOUBLE_PARSER(EnumC0543k.USE_FAST_DOUBLE_PARSER),
    USE_FAST_BIG_NUMBER_PARSER(EnumC0543k.USE_FAST_BIG_NUMBER_PARSER);


    /* JADX INFO: renamed from: e */
    public final boolean f1343e;

    /* JADX INFO: renamed from: f */
    public final int f1344f;

    /* JADX INFO: renamed from: g */
    public final EnumC0543k f1345g;

    EnumC0554v(EnumC0543k enumC0543k) {
        this.f1345g = enumC0543k;
        this.f1344f = enumC0543k.f1297f;
        this.f1343e = enumC0543k.f1296e;
    }

    @Override // p066W0.InterfaceC0683j
    /* JADX INFO: renamed from: a */
    public final int mo1234a() {
        return this.f1344f;
    }

    @Override // p066W0.InterfaceC0683j
    /* JADX INFO: renamed from: b */
    public final boolean mo1235b() {
        return this.f1343e;
    }
}
