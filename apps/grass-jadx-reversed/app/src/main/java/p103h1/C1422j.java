package p103h1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.EnumSet;
import p001A.C0009j;
import p005B.AbstractC0032g;
import p069X0.AbstractC0715f;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.EnumC0719j;
import p074Z0.AbstractC0832r;
import p078a1.C0853e;
import p100g1.AbstractC1396e;
import p114l1.C1674p;
import p114l1.C1675q;
import p114l1.C1676r;
import p114l1.C1677s;
import p118m1.AbstractC1745j;
import p118m1.C1744i;

/* JADX INFO: renamed from: h1.j */
/* JADX INFO: loaded from: classes.dex */
public class C1422j extends AbstractC1429q {

    /* JADX INFO: renamed from: c */
    public final AbstractC1396e f5048c;

    public C1422j(AbstractC0721l abstractC0721l, C1675q c1675q, AbstractC1396e abstractC1396e) {
        super(abstractC0721l, c1675q);
        this.f5048c = abstractC1396e;
    }

    @Override // p103h1.AbstractC1429q
    /* JADX INFO: renamed from: a */
    public final String mo3427a() {
        return "class name used as type id";
    }

    @Override // p103h1.AbstractC1429q
    /* JADX INFO: renamed from: b */
    public String mo3428b(Object obj) {
        return m3431e(obj, obj.getClass(), this.f5068a);
    }

    @Override // p103h1.AbstractC1429q
    /* JADX INFO: renamed from: c */
    public final String mo3429c(Object obj, Class cls) {
        return m3431e(obj, cls, this.f5068a);
    }

    @Override // p103h1.AbstractC1429q
    /* JADX INFO: renamed from: d */
    public final AbstractC0721l mo3430d(AbstractC0715f abstractC0715f, String str) {
        return mo3432f(abstractC0715f, str);
    }

    /* JADX INFO: renamed from: e */
    public final String m3431e(Object obj, Class cls, C1675q c1675q) {
        Class declaringClass;
        Class declaringClass2;
        Annotation[] annotationArr = AbstractC1745j.f6110a;
        if (Enum.class.isAssignableFrom(cls) && !cls.isEnum()) {
            cls = cls.getSuperclass();
        }
        String name = cls.getName();
        if (!name.startsWith("java.util.")) {
            if (name.indexOf(36) < 0 || AbstractC1745j.m3893p(cls) == null) {
                return name;
            }
            AbstractC0721l abstractC0721l = this.f5069b;
            return AbstractC1745j.m3893p(abstractC0721l.f2036e) == null ? abstractC0721l.f2036e.getName() : name;
        }
        if (obj instanceof EnumSet) {
            EnumSet enumSet = (EnumSet) obj;
            if (enumSet.isEmpty()) {
                C1744i c1744i = C1744i.f6105e;
                Field field = c1744i.f6106a;
                if (field == null) {
                    throw new IllegalStateException("Cannot figure out type parameter for `EnumSet` (odd JDK platform?), problem: " + c1744i.f6108c);
                }
                try {
                    declaringClass2 = (Class) field.get(enumSet);
                } catch (Exception e3) {
                    throw new IllegalArgumentException(e3);
                }
            } else {
                declaringClass2 = ((Enum) enumSet.iterator().next()).getDeclaringClass();
            }
            return c1675q.m3777f(c1675q.m3775c(null, declaringClass2, C1675q.f5934i), EnumSet.class).mo3749L();
        }
        if (!(obj instanceof EnumMap)) {
            return name;
        }
        EnumMap enumMap = (EnumMap) obj;
        if (enumMap.isEmpty()) {
            C1744i c1744i2 = C1744i.f6105e;
            Field field2 = c1744i2.f6107b;
            if (field2 == null) {
                throw new IllegalStateException("Cannot figure out type parameter for `EnumMap` (odd JDK platform?), problem: " + c1744i2.f6109d);
            }
            try {
                declaringClass = (Class) field2.get(enumMap);
            } catch (Exception e4) {
                throw new IllegalArgumentException(e4);
            }
        } else {
            declaringClass = ((Enum) enumMap.keySet().iterator().next()).getDeclaringClass();
        }
        C1674p c1674p = C1675q.f5934i;
        return c1675q.m3778h(EnumMap.class, c1675q.m3775c(null, declaringClass, c1674p), c1675q.m3775c(null, Object.class, c1674p)).mo3749L();
    }

    /* JADX INFO: renamed from: f */
    public AbstractC0721l mo3432f(AbstractC0715f abstractC0715f, String str) throws C0853e {
        AbstractC0721l abstractC0721lM3779i;
        abstractC0715f.getClass();
        int iIndexOf = str.indexOf(60);
        AbstractC0721l abstractC0721l = this.f5069b;
        AbstractC1396e abstractC1396e = this.f5048c;
        if (iIndexOf > 0) {
            str.substring(0, iIndexOf);
            if (abstractC1396e.mo3394b() == 2) {
                throw abstractC0715f.mo1712g(abstractC0721l, str, "Configured `PolymorphicTypeValidator` (of type " + AbstractC1745j.m3883f(abstractC1396e) + ") denied resolution");
            }
            C1677s c1677s = abstractC0715f.mo1711f().f5952f;
            c1677s.getClass();
            C1676r c1676r = new C1676r(str.trim());
            abstractC0721lM3779i = c1677s.m3782b(c1676r);
            if (c1676r.hasMoreTokens()) {
                throw C1677s.m3781a(c1676r, "Unexpected tokens after complete type");
            }
            if (!abstractC0721lM3779i.m1891z(abstractC0721l.f2036e)) {
                throw abstractC0715f.mo1712g(abstractC0721l, str, "Not a subtype");
            }
        } else {
            AbstractC0832r abstractC0832rMo1710e = abstractC0715f.mo1710e();
            if (abstractC1396e.mo3394b() == 2) {
                throw abstractC0715f.mo1712g(abstractC0721l, str, "Configured `PolymorphicTypeValidator` (of type " + AbstractC1745j.m3883f(abstractC1396e) + ") denied resolution");
            }
            try {
                abstractC0715f.mo1711f().getClass();
                Class clsM3770k = C1675q.m3770k(str);
                if (!abstractC0721l.m1862A(clsM3770k)) {
                    throw abstractC0715f.mo1712g(abstractC0721l, str, "Not a subtype");
                }
                abstractC0721lM3779i = abstractC0832rMo1710e.f2481f.f2419e.m3779i(abstractC0721l, clsM3770k, false);
            } catch (ClassNotFoundException unused) {
                abstractC0721lM3779i = null;
            } catch (Exception e3) {
                throw abstractC0715f.mo1712g(abstractC0721l, str, AbstractC0032g.m155m("problem: (", e3.getClass().getName(), ") ", AbstractC1745j.m3886i(e3)));
            }
        }
        if (abstractC0721lM3779i != null || !(abstractC0715f instanceof AbstractC0718i)) {
            return abstractC0721lM3779i;
        }
        AbstractC0718i abstractC0718i = (AbstractC0718i) abstractC0715f;
        C0009j c0009j = abstractC0718i.f1998g.f1987q;
        if (c0009j != null) {
            AbstractC0032g.m162t(c0009j.f30f);
            throw null;
        }
        if (abstractC0718i.m1833K(EnumC0719j.FAIL_ON_INVALID_SUBTYPE)) {
            throw abstractC0718i.mo1712g(abstractC0721l, str, "no such class found");
        }
        return null;
    }
}
