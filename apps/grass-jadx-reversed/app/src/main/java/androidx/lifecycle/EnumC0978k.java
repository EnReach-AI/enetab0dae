package androidx.lifecycle;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: androidx.lifecycle.k */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0978k {
    private static final /* synthetic */ EnumC0978k[] $VALUES;
    public static final EnumC0978k ON_ANY;
    public static final EnumC0978k ON_CREATE;
    public static final EnumC0978k ON_DESTROY;
    public static final EnumC0978k ON_PAUSE;
    public static final EnumC0978k ON_RESUME;
    public static final EnumC0978k ON_START;
    public static final EnumC0978k ON_STOP;

    static {
        EnumC0978k enumC0978k = new EnumC0978k("ON_CREATE", 0);
        ON_CREATE = enumC0978k;
        EnumC0978k enumC0978k2 = new EnumC0978k("ON_START", 1);
        ON_START = enumC0978k2;
        EnumC0978k enumC0978k3 = new EnumC0978k("ON_RESUME", 2);
        ON_RESUME = enumC0978k3;
        EnumC0978k enumC0978k4 = new EnumC0978k("ON_PAUSE", 3);
        ON_PAUSE = enumC0978k4;
        EnumC0978k enumC0978k5 = new EnumC0978k("ON_STOP", 4);
        ON_STOP = enumC0978k5;
        EnumC0978k enumC0978k6 = new EnumC0978k("ON_DESTROY", 5);
        ON_DESTROY = enumC0978k6;
        EnumC0978k enumC0978k7 = new EnumC0978k("ON_ANY", 6);
        ON_ANY = enumC0978k7;
        $VALUES = new EnumC0978k[]{enumC0978k, enumC0978k2, enumC0978k3, enumC0978k4, enumC0978k5, enumC0978k6, enumC0978k7};
    }

    public static EnumC0978k valueOf(String str) {
        return (EnumC0978k) Enum.valueOf(EnumC0978k.class, str);
    }

    public static EnumC0978k[] values() {
        return (EnumC0978k[]) $VALUES.clone();
    }

    /* JADX INFO: renamed from: a */
    public final EnumC0979l m2512a() {
        switch (AbstractC0977j.f3317b[ordinal()]) {
            case 1:
            case 2:
                return EnumC0979l.f3320g;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                return EnumC0979l.f3321h;
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return EnumC0979l.f3322i;
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                return EnumC0979l.f3318e;
            default:
                throw new IllegalArgumentException(this + " has no target state");
        }
    }
}
