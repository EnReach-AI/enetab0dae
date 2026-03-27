package p118m1;

import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.EnumSet;
import p005B.AbstractC0032g;

/* JADX INFO: renamed from: m1.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1744i {

    /* JADX INFO: renamed from: e */
    public static final C1744i f6105e = new C1744i();

    /* JADX INFO: renamed from: a */
    public final Field f6106a;

    /* JADX INFO: renamed from: b */
    public final Field f6107b;

    /* JADX INFO: renamed from: c */
    public final String f6108c;

    /* JADX INFO: renamed from: d */
    public final String f6109d;

    public C1744i() {
        String string;
        Field fieldM3870a;
        String string2;
        Field fieldM3870a2 = null;
        try {
            fieldM3870a = m3870a(EnumSet.class, "elementType");
            string = null;
        } catch (Exception e3) {
            string = e3.toString();
            fieldM3870a = null;
        }
        this.f6106a = fieldM3870a;
        this.f6108c = string;
        try {
            string2 = null;
            fieldM3870a2 = m3870a(EnumMap.class, "keyType");
        } catch (Exception e4) {
            string2 = e4.toString();
        }
        this.f6107b = fieldM3870a2;
        this.f6109d = string2;
    }

    /* JADX INFO: renamed from: a */
    public static Field m3870a(Class cls, String str) {
        for (Field field : cls.getDeclaredFields()) {
            if (str.equals(field.getName()) && field.getType() == Class.class) {
                field.setAccessible(true);
                return field;
            }
        }
        throw new IllegalStateException(AbstractC0032g.m156n("No field named '", str, "' in class '", cls.getName(), "'"));
    }
}
