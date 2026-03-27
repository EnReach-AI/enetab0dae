package p114l1;

import com.facebook.C1100C;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import p005B.AbstractC0032g;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p118m1.AbstractC1745j;
import p118m1.C1752q;

/* JADX INFO: renamed from: l1.q */
/* JADX INFO: loaded from: classes.dex */
public final class C1675q implements Serializable {

    /* JADX INFO: renamed from: g */
    public static final AbstractC0721l[] f5932g = new AbstractC0721l[0];

    /* JADX INFO: renamed from: h */
    public static final C1675q f5933h = new C1675q();

    /* JADX INFO: renamed from: i */
    public static final C1674p f5934i = C1674p.f5927k;

    /* JADX INFO: renamed from: j */
    public static final Class f5935j = String.class;

    /* JADX INFO: renamed from: k */
    public static final Class f5936k = Object.class;

    /* JADX INFO: renamed from: l */
    public static final Class f5937l = Comparable.class;

    /* JADX INFO: renamed from: m */
    public static final Class f5938m = Enum.class;

    /* JADX INFO: renamed from: n */
    public static final Class f5939n = AbstractC0725p.class;

    /* JADX INFO: renamed from: o */
    public static final Class f5940o;

    /* JADX INFO: renamed from: p */
    public static final Class f5941p;

    /* JADX INFO: renamed from: q */
    public static final Class f5942q;

    /* JADX INFO: renamed from: r */
    public static final C1670l f5943r;

    /* JADX INFO: renamed from: s */
    public static final C1670l f5944s;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: t */
    public static final C1670l f5945t;

    /* JADX INFO: renamed from: u */
    public static final C1670l f5946u;

    /* JADX INFO: renamed from: v */
    public static final C1670l f5947v;

    /* JADX INFO: renamed from: w */
    public static final C1670l f5948w;

    /* JADX INFO: renamed from: x */
    public static final C1670l f5949x;

    /* JADX INFO: renamed from: y */
    public static final C1670l f5950y;

    /* JADX INFO: renamed from: e */
    public final C1752q f5951e = new C1752q(16, 200);

    /* JADX INFO: renamed from: f */
    public final C1677s f5952f = new C1677s(this);

    static {
        Class cls = Boolean.TYPE;
        f5940o = cls;
        Class cls2 = Integer.TYPE;
        f5941p = cls2;
        Class cls3 = Long.TYPE;
        f5942q = cls3;
        f5943r = new C1670l(cls);
        f5944s = new C1670l(cls2);
        f5945t = new C1670l(cls3);
        f5946u = new C1670l(String.class);
        f5947v = new C1670l(Object.class);
        f5948w = new C1670l(Comparable.class);
        f5949x = new C1670l(Enum.class);
        f5950y = new C1670l(AbstractC0725p.class);
    }

    /* JADX INFO: renamed from: a */
    public static C1670l m3767a(Class cls) {
        if (cls.isPrimitive()) {
            if (cls == f5940o) {
                return f5943r;
            }
            if (cls == f5941p) {
                return f5944s;
            }
            if (cls == f5942q) {
                return f5945t;
            }
            return null;
        }
        if (cls == f5935j) {
            return f5946u;
        }
        if (cls == f5936k) {
            return f5947v;
        }
        if (cls == f5939n) {
            return f5950y;
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    public static boolean m3768e(AbstractC0721l abstractC0721l, AbstractC0721l abstractC0721l2) {
        if (abstractC0721l2 instanceof C1667i) {
            ((C1667i) abstractC0721l2).f5906o = abstractC0721l;
            return true;
        }
        if (abstractC0721l.f2036e != abstractC0721l2.f2036e) {
            return false;
        }
        List listM3765e = abstractC0721l.mo1873h().m3765e();
        List listM3765e2 = abstractC0721l2.mo1873h().m3765e();
        int size = listM3765e.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!m3768e((AbstractC0721l) listM3765e.get(i3), (AbstractC0721l) listM3765e2.get(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: g */
    public static AbstractC0721l m3769g(AbstractC0721l abstractC0721l, Class cls) {
        Class cls2 = abstractC0721l.f2036e;
        if (cls2 == cls) {
            return abstractC0721l;
        }
        AbstractC0721l abstractC0721lMo1872g = abstractC0721l.mo1872g(cls);
        if (abstractC0721lMo1872g != null) {
            return abstractC0721lMo1872g;
        }
        if (cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(String.format("Internal error: class %s not included as super-type for %s", cls.getName(), abstractC0721l));
        }
        throw new IllegalArgumentException(String.format("Class %s not a super-type of %s", cls.getName(), abstractC0721l));
    }

    /* JADX INFO: renamed from: k */
    public static Class m3770k(String str) throws ClassNotFoundException {
        Throwable thM3894q = null;
        if (str.indexOf(46) < 0) {
            Class cls = "int".equals(str) ? Integer.TYPE : "long".equals(str) ? Long.TYPE : "float".equals(str) ? Float.TYPE : "double".equals(str) ? Double.TYPE : "boolean".equals(str) ? Boolean.TYPE : "byte".equals(str) ? Byte.TYPE : "char".equals(str) ? Character.TYPE : "short".equals(str) ? Short.TYPE : "void".equals(str) ? Void.TYPE : null;
            if (cls != null) {
                return cls;
            }
        }
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                return Class.forName(str, true, contextClassLoader);
            } catch (Exception e3) {
                thM3894q = AbstractC1745j.m3894q(e3);
            }
        }
        try {
            return Class.forName(str);
        } catch (Exception e4) {
            if (thM3894q == null) {
                thM3894q = AbstractC1745j.m3894q(e4);
            }
            AbstractC1745j.m3875E(thM3894q);
            throw new ClassNotFoundException(thM3894q.getMessage(), thM3894q);
        }
    }

    /* JADX INFO: renamed from: l */
    public static AbstractC0721l[] m3771l(AbstractC0721l abstractC0721l, Class cls) {
        AbstractC0721l abstractC0721lMo1872g = abstractC0721l.mo1872g(cls);
        return abstractC0721lMo1872g == null ? f5932g : abstractC0721lMo1872g.mo1873h().f5929f;
    }

    /* JADX INFO: renamed from: m */
    public static C1670l m3772m(Class cls) {
        C1670l c1670lM3767a;
        C1674p c1674p = f5934i;
        return (!c1674p.m3766f() || (c1670lM3767a = m3767a(cls)) == null) ? new C1670l(cls, c1674p, null, null) : c1670lM3767a;
    }

    /* JADX INFO: renamed from: n */
    public static C1670l m3773n() {
        f5933h.getClass();
        return f5947v;
    }

    /* JADX INFO: renamed from: b */
    public final AbstractC0721l m3774b(C1100C c1100c, Type type, C1674p c1674p) {
        AbstractC0721l abstractC0721l;
        Type[] bounds;
        AbstractC0721l abstractC0721l2;
        C1674p c1674pM3763c;
        if (type instanceof Class) {
            return m3775c(c1100c, (Class) type, f5934i);
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = (Class) parameterizedType.getRawType();
            if (cls == f5938m) {
                return f5949x;
            }
            if (cls == f5937l) {
                return f5948w;
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments == null ? 0 : actualTypeArguments.length;
            if (length == 0) {
                c1674pM3763c = f5934i;
            } else {
                AbstractC0721l[] abstractC0721lArr = new AbstractC0721l[length];
                for (int i3 = 0; i3 < length; i3++) {
                    abstractC0721lArr[i3] = m3774b(c1100c, actualTypeArguments[i3], c1674p);
                }
                c1674pM3763c = C1674p.m3763c(cls, abstractC0721lArr);
            }
            return m3775c(c1100c, cls, c1674pM3763c);
        }
        if (type instanceof AbstractC0721l) {
            return (AbstractC0721l) type;
        }
        if (type instanceof GenericArrayType) {
            AbstractC0721l abstractC0721lM3774b = m3774b(c1100c, ((GenericArrayType) type).getGenericComponentType(), c1674p);
            int i4 = C1659a.f5882p;
            return new C1659a(abstractC0721lM3774b, c1674p, Array.newInstance((Class<?>) abstractC0721lM3774b.f2036e, 0), null, null, false);
        }
        if (!(type instanceof TypeVariable)) {
            if (type instanceof WildcardType) {
                return m3774b(c1100c, ((WildcardType) type).getUpperBounds()[0], c1674p);
            }
            StringBuilder sb = new StringBuilder("Unrecognized Type: ");
            sb.append(type == null ? "[null]" : type.toString());
            throw new IllegalArgumentException(sb.toString());
        }
        TypeVariable typeVariable = (TypeVariable) type;
        String name = typeVariable.getName();
        if (c1674p == null) {
            throw new IllegalArgumentException(AbstractC0032g.m154l("Null `bindings` passed (type variable \"", name, "\")"));
        }
        String[] strArr = c1674p.f5928e;
        int length2 = strArr.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length2) {
                abstractC0721l = null;
                break;
            }
            if (name.equals(strArr[i5])) {
                abstractC0721l = c1674p.f5929f[i5];
                if ((abstractC0721l instanceof C1669k) && (abstractC0721l2 = ((C1669k) abstractC0721l).f5909n) != null) {
                    abstractC0721l = abstractC0721l2;
                }
            } else {
                i5++;
            }
        }
        if (abstractC0721l != null) {
            return abstractC0721l;
        }
        String[] strArr2 = c1674p.f5930g;
        if (strArr2 != null) {
            int length3 = strArr2.length;
            do {
                length3--;
                if (length3 >= 0) {
                }
            } while (!name.equals(strArr2[length3]));
            return f5947v;
        }
        String[] strArr3 = c1674p.f5930g;
        int length4 = strArr3 == null ? 0 : strArr3.length;
        String[] strArr4 = length4 == 0 ? new String[1] : (String[]) Arrays.copyOf(strArr3, 1 + length4);
        strArr4[length4] = name;
        C1674p c1674p2 = new C1674p(c1674p.f5928e, c1674p.f5929f, strArr4);
        synchronized (typeVariable) {
            bounds = typeVariable.getBounds();
        }
        return m3774b(c1100c, bounds[0], c1674p2);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x023e  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p069X0.AbstractC0721l m3775c(com.facebook.C1100C r24, java.lang.Class r25, p114l1.C1674p r26) {
        /*
            Method dump skipped, instruction units count: 655
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p114l1.C1675q.m3775c(com.facebook.C, java.lang.Class, l1.p):X0.l");
    }

    /* JADX INFO: renamed from: d */
    public final AbstractC0721l[] m3776d(C1100C c1100c, Class cls, C1674p c1674p) {
        Annotation[] annotationArr = AbstractC1745j.f6110a;
        Type[] genericInterfaces = cls.getGenericInterfaces();
        if (genericInterfaces == null || genericInterfaces.length == 0) {
            return f5932g;
        }
        int length = genericInterfaces.length;
        AbstractC0721l[] abstractC0721lArr = new AbstractC0721l[length];
        for (int i3 = 0; i3 < length; i3++) {
            abstractC0721lArr[i3] = m3774b(c1100c, genericInterfaces[i3], c1674p);
        }
        return abstractC0721lArr;
    }

    /* JADX INFO: renamed from: f */
    public final C1662d m3777f(AbstractC0721l abstractC0721l, Class cls) {
        C1674p c1674p;
        String[] strArr = C1674p.f5925i;
        TypeVariable[] typeParameters = cls.getTypeParameters();
        int length = typeParameters == null ? 0 : typeParameters.length;
        if (length == 0) {
            c1674p = C1674p.f5927k;
        } else {
            if (length != 1) {
                throw new IllegalArgumentException("Cannot create TypeBindings for class " + cls.getName() + " with 1 type parameter: class expects " + length);
            }
            c1674p = new C1674p(new String[]{typeParameters[0].getName()}, new AbstractC0721l[]{abstractC0721l}, null);
        }
        C1662d c1662d = (C1662d) m3775c(null, cls, c1674p);
        if (c1674p.m3766f() && abstractC0721l != null) {
            AbstractC0721l abstractC0721lMo1874i = c1662d.mo1872g(Collection.class).mo1874i();
            if (!abstractC0721lMo1874i.equals(abstractC0721l)) {
                throw new IllegalArgumentException(String.format("Non-generic Collection class %s did not resolve to something with element type %s but %s ", AbstractC1745j.m3903z(cls), abstractC0721l, abstractC0721lMo1874i));
            }
        }
        return c1662d;
    }

    /* JADX INFO: renamed from: h */
    public final C1666h m3778h(Class cls, AbstractC0721l abstractC0721l, AbstractC0721l abstractC0721l2) {
        C1674p c1674p;
        AbstractC0721l[] abstractC0721lArr = {abstractC0721l, abstractC0721l2};
        String[] strArr = C1674p.f5925i;
        TypeVariable[] typeParameters = cls.getTypeParameters();
        if (typeParameters == null || typeParameters.length == 0) {
            c1674p = C1674p.f5927k;
        } else {
            int length = typeParameters.length;
            String[] strArr2 = new String[length];
            for (int i3 = 0; i3 < length; i3++) {
                strArr2[i3] = typeParameters[i3].getName();
            }
            if (length != 2) {
                throw new IllegalArgumentException("Cannot create TypeBindings for class " + cls.getName() + " with 2 type parameters: class expects " + length);
            }
            c1674p = new C1674p(strArr2, abstractC0721lArr, null);
        }
        C1666h c1666h = (C1666h) m3775c(null, cls, c1674p);
        if (c1674p.m3766f()) {
            AbstractC0721l abstractC0721lMo1872g = c1666h.mo1872g(Map.class);
            AbstractC0721l abstractC0721lMo1877l = abstractC0721lMo1872g.mo1877l();
            if (!abstractC0721lMo1877l.equals(abstractC0721l)) {
                throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with key type %s but %s ", AbstractC1745j.m3903z(cls), abstractC0721l, abstractC0721lMo1877l));
            }
            AbstractC0721l abstractC0721lMo1874i = abstractC0721lMo1872g.mo1874i();
            if (!abstractC0721lMo1874i.equals(abstractC0721l2)) {
                throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with value type %s but %s ", AbstractC1745j.m3903z(cls), abstractC0721l2, abstractC0721lMo1874i));
            }
        }
        return c1666h;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0099 A[LOOP:0: B:45:0x0097->B:46:0x0099, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0186  */
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p069X0.AbstractC0721l m3779i(p069X0.AbstractC0721l r17, java.lang.Class r18, boolean r19) {
        /*
            Method dump skipped, instruction units count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p114l1.C1675q.m3779i(X0.l, java.lang.Class, boolean):X0.l");
    }

    /* JADX INFO: renamed from: j */
    public final AbstractC0721l m3780j(Type type) {
        return m3774b(null, type, f5934i);
    }
}
