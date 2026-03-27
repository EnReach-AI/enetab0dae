package p069X0;

import java.lang.reflect.Type;
import p005B.AbstractC0032g;
import p039M0.AbstractC0485d0;
import p074Z0.AbstractC0832r;
import p078a1.C0853e;
import p082b1.C1018N;
import p114l1.C1675q;
import p118m1.AbstractC1745j;
import p118m1.AbstractC1747l;
import p118m1.InterfaceC1748m;

/* JADX INFO: renamed from: X0.f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0715f {
    /* JADX INFO: renamed from: a */
    public static String m1809a(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        return str + ": " + str2;
    }

    /* JADX INFO: renamed from: b */
    public static String m1810b(String str) {
        if (str == null) {
            return "[N/A]";
        }
        if (str.length() > 500) {
            str = str.substring(0, 500) + "]...[" + str.substring(str.length() - 500);
        }
        return AbstractC0032g.m154l("\"", str, "\"");
    }

    /* JADX INFO: renamed from: c */
    public final AbstractC0721l m1811c(Type type) {
        if (type == null) {
            return null;
        }
        return mo1711f().m3780j(type);
    }

    /* JADX INFO: renamed from: d */
    public final InterfaceC1748m m1812d(Object obj) {
        if (obj instanceof InterfaceC1748m) {
            return (InterfaceC1748m) obj;
        }
        if (!(obj instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + obj.getClass().getName() + "; expected type Converter or Class<Converter> instead");
        }
        Class cls = (Class) obj;
        if (cls == AbstractC1747l.class || AbstractC1745j.m3897t(cls)) {
            return null;
        }
        if (InterfaceC1748m.class.isAssignableFrom(cls)) {
            AbstractC0832r abstractC0832rMo1710e = mo1710e();
            abstractC0832rMo1710e.m2153h();
            return (InterfaceC1748m) AbstractC1745j.m3885h(cls, abstractC0832rMo1710e.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS));
        }
        throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<Converter>");
    }

    /* JADX INFO: renamed from: e */
    public abstract AbstractC0832r mo1710e();

    /* JADX INFO: renamed from: f */
    public abstract C1675q mo1711f();

    /* JADX INFO: renamed from: g */
    public abstract C0853e mo1712g(AbstractC0721l abstractC0721l, String str, String str2);

    /* JADX INFO: renamed from: h */
    public final AbstractC0485d0 m1813h(C1018N c1018n) {
        Class cls = c1018n.f3611b;
        AbstractC0832r abstractC0832rMo1710e = mo1710e();
        abstractC0832rMo1710e.m2153h();
        return ((AbstractC0485d0) AbstractC1745j.m3885h(cls, abstractC0832rMo1710e.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS))).mo1002b(c1018n.f3613d);
    }

    /* JADX INFO: renamed from: i */
    public final void m1814i(C1018N c1018n) {
        Class cls = c1018n.f3612c;
        AbstractC0832r abstractC0832rMo1710e = mo1710e();
        abstractC0832rMo1710e.m2153h();
        AbstractC0032g.m162t(AbstractC1745j.m3885h(cls, abstractC0832rMo1710e.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS)));
    }

    /* JADX INFO: renamed from: j */
    public final Object m1815j(Class cls, String str) {
        m1811c(cls);
        mo1713k(str);
        throw null;
    }

    /* JADX INFO: renamed from: k */
    public abstract Object mo1713k(String str);
}
