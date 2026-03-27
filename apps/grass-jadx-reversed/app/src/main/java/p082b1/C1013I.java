package p082b1;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import p069X0.AbstractC0721l;
import p069X0.EnumC0731v;
import p074Z0.AbstractC0832r;

/* JADX INFO: renamed from: b1.I */
/* JADX INFO: loaded from: classes.dex */
public class C1013I {

    /* JADX INFO: renamed from: a */
    public final boolean f3596a;

    /* JADX INFO: renamed from: b */
    public final boolean f3597b;

    /* JADX INFO: renamed from: c */
    public final String f3598c = "get";

    /* JADX INFO: renamed from: d */
    public final String f3599d = "is";

    /* JADX INFO: renamed from: e */
    public final String f3600e;

    public C1013I(AbstractC0832r abstractC0832r, String str) {
        this.f3596a = abstractC0832r.m2157l(EnumC0731v.USE_STD_BEAN_NAMING);
        this.f3597b = abstractC0832r.m2157l(EnumC0731v.ALLOW_IS_GETTERS_FOR_NON_BOOLEAN);
        this.f3600e = str;
    }

    /* JADX INFO: renamed from: d */
    public static String m2730d(int i3, String str) {
        int length = str.length();
        if (length == i3) {
            return null;
        }
        char cCharAt = str.charAt(i3);
        char lowerCase = Character.toLowerCase(cCharAt);
        if (cCharAt == lowerCase) {
            return str.substring(i3);
        }
        StringBuilder sb = new StringBuilder(length - i3);
        sb.append(lowerCase);
        while (true) {
            i3++;
            if (i3 >= length) {
                break;
            }
            char cCharAt2 = str.charAt(i3);
            char lowerCase2 = Character.toLowerCase(cCharAt2);
            if (cCharAt2 == lowerCase2) {
                sb.append((CharSequence) str, i3, length);
                break;
            }
            sb.append(lowerCase2);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: e */
    public static String m2731e(int i3, String str) {
        int length = str.length();
        if (length == i3) {
            return null;
        }
        char cCharAt = str.charAt(i3);
        char lowerCase = Character.toLowerCase(cCharAt);
        if (cCharAt == lowerCase) {
            return str.substring(i3);
        }
        int i4 = i3 + 1;
        if (i4 < length && Character.isUpperCase(str.charAt(i4))) {
            return str.substring(i3);
        }
        StringBuilder sb = new StringBuilder(length - i3);
        sb.append(lowerCase);
        sb.append((CharSequence) str, i4, length);
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public final String m2732a(C1043n c1043n, String str) {
        String str2 = this.f3599d;
        if (str2 == null) {
            return null;
        }
        if (!this.f3597b) {
            AbstractC0721l abstractC0721lMo2769f = c1043n.mo2769f();
            if (abstractC0721lMo2769f.mo1629b()) {
                abstractC0721lMo2769f = abstractC0721lMo2769f.mo1628a();
            }
            if (!abstractC0721lMo2769f.m1883r(Boolean.TYPE) && !abstractC0721lMo2769f.m1883r(Boolean.class) && !abstractC0721lMo2769f.m1883r(AtomicBoolean.class)) {
                return null;
            }
        }
        if (str.startsWith(str2)) {
            return this.f3596a ? m2731e(str2.length(), str) : m2730d(str2.length(), str);
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public final String m2733b(String str) {
        String str2 = this.f3600e;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        return this.f3596a ? m2731e(str2.length(), str) : m2730d(str2.length(), str);
    }

    /* JADX INFO: renamed from: c */
    public String mo2729c(C1043n c1043n, String str) {
        String str2 = this.f3598c;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        boolean zEquals = "getCallbacks".equals(str);
        Method method = c1043n.f3704h;
        if (zEquals) {
            Class<?> returnType = method.getReturnType();
            if (returnType.isArray()) {
                String name = returnType.getComponentType().getName();
                if (name.contains(".cglib") && (name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib") || name.startsWith("org.springframework.cglib"))) {
                    return null;
                }
            }
        } else if ("getMetaClass".equals(str) && method.getReturnType().getName().startsWith("groovy.lang")) {
            return null;
        }
        return this.f3596a ? m2731e(str2.length(), str) : m2730d(str2.length(), str);
    }
}
