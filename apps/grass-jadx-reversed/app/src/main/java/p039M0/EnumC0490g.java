package p039M0;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: M0.g */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0490g {

    /* JADX INFO: renamed from: e */
    public static final EnumC0490g f1132e;

    /* JADX INFO: renamed from: f */
    public static final EnumC0490g f1133f;

    /* JADX INFO: renamed from: g */
    public static final EnumC0490g f1134g;

    /* JADX INFO: renamed from: h */
    public static final EnumC0490g f1135h;

    /* JADX INFO: renamed from: i */
    public static final /* synthetic */ EnumC0490g[] f1136i;

    static {
        EnumC0490g enumC0490g = new EnumC0490g("ANY", 0);
        f1132e = enumC0490g;
        EnumC0490g enumC0490g2 = new EnumC0490g("NON_PRIVATE", 1);
        EnumC0490g enumC0490g3 = new EnumC0490g("PROTECTED_AND_PUBLIC", 2);
        EnumC0490g enumC0490g4 = new EnumC0490g("PUBLIC_ONLY", 3);
        f1133f = enumC0490g4;
        EnumC0490g enumC0490g5 = new EnumC0490g("NONE", 4);
        f1134g = enumC0490g5;
        EnumC0490g enumC0490g6 = new EnumC0490g("DEFAULT", 5);
        f1135h = enumC0490g6;
        f1136i = new EnumC0490g[]{enumC0490g, enumC0490g2, enumC0490g3, enumC0490g4, enumC0490g5, enumC0490g6};
    }

    public static EnumC0490g valueOf(String str) {
        return (EnumC0490g) Enum.valueOf(EnumC0490g.class, str);
    }

    public static EnumC0490g[] values() {
        return (EnumC0490g[]) f1136i.clone();
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1006a(Member member) {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return true;
        }
        if (iOrdinal == 1) {
            return !Modifier.isPrivate(member.getModifiers());
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                return false;
            }
        } else if (Modifier.isProtected(member.getModifiers())) {
            return true;
        }
        return Modifier.isPublic(member.getModifiers());
    }
}
