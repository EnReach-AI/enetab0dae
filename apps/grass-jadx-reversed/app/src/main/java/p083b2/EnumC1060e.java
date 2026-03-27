package p083b2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: b2.e */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC1060e {

    /* JADX INFO: renamed from: e */
    public static final /* synthetic */ EnumC1060e[] f3735e = {new EnumC1060e("SYNCHRONIZED", 0), new EnumC1060e("PUBLICATION", 1), new EnumC1060e("NONE", 2)};

    /* JADX INFO: Fake field, exist only in values array */
    EnumC1060e EF5;

    public static EnumC1060e valueOf(String str) {
        return (EnumC1060e) Enum.valueOf(EnumC1060e.class, str);
    }

    public static EnumC1060e[] values() {
        return (EnumC1060e[]) f3735e.clone();
    }
}
