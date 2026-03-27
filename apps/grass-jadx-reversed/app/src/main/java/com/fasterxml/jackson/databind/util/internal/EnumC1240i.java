package com.fasterxml.jackson.databind.util.internal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: com.fasterxml.jackson.databind.util.internal.i */
/* JADX INFO: loaded from: classes.dex */
public abstract class EnumC1240i {

    /* JADX INFO: renamed from: e */
    public static final C1237f f4172e;

    /* JADX INFO: renamed from: f */
    public static final C1238g f4173f;

    /* JADX INFO: renamed from: g */
    public static final C1239h f4174g;

    /* JADX INFO: renamed from: h */
    public static final /* synthetic */ EnumC1240i[] f4175h;

    static {
        C1237f c1237f = new C1237f();
        f4172e = c1237f;
        C1238g c1238g = new C1238g();
        f4173f = c1238g;
        C1239h c1239h = new C1239h();
        f4174g = c1239h;
        f4175h = new EnumC1240i[]{c1237f, c1238g, c1239h};
    }

    public static EnumC1240i valueOf(String str) {
        return (EnumC1240i) Enum.valueOf(EnumC1240i.class, str);
    }

    public static EnumC1240i[] values() {
        return (EnumC1240i[]) f4175h.clone();
    }

    /* JADX INFO: renamed from: a */
    public abstract boolean mo3112a(boolean z3);
}
