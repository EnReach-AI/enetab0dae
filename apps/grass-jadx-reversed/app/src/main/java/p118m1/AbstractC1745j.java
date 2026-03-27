package p118m1;

import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import p005B.AbstractC0032g;
import p042N0.AbstractC0535c;
import p042N0.AbstractC0540h;
import p042N0.EnumC0539g;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.C0724o;
import p071Y0.AbstractC0752p;
import p071Y0.InterfaceC0738b;
import p114l1.AbstractC1671m;

/* JADX INFO: renamed from: m1.j */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1745j {

    /* JADX INFO: renamed from: a */
    public static final Annotation[] f6110a = new Annotation[0];

    /* JADX INFO: renamed from: b */
    public static final C1743h[] f6111b = new C1743h[0];

    /* JADX INFO: renamed from: c */
    public static final Iterator f6112c = Collections.emptyIterator();

    /* JADX INFO: renamed from: A */
    public static Class m3871A(Class cls) {
        if (cls.isPrimitive()) {
            return cls;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        return null;
    }

    /* JADX INFO: renamed from: B */
    public static void m3872B(AbstractC0718i abstractC0718i, IOException iOException) throws C0724o {
        if (iOException instanceof C0724o) {
            throw ((C0724o) iOException);
        }
        C0724o c0724o = new C0724o(abstractC0718i == null ? null : abstractC0718i.f2002k, iOException.getMessage());
        c0724o.initCause(iOException);
        throw c0724o;
    }

    /* JADX INFO: renamed from: C */
    public static void m3873C(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
    }

    /* JADX INFO: renamed from: D */
    public static void m3874D(Throwable th) {
        if (th instanceof IOException) {
            throw ((IOException) th);
        }
    }

    /* JADX INFO: renamed from: E */
    public static void m3875E(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
    }

    /* JADX INFO: renamed from: F */
    public static void m3876F(Class cls, Object obj, String str) {
        if (obj.getClass() == cls) {
            return;
        }
        String name = obj.getClass().getName();
        String name2 = cls.getName();
        StringBuilder sb = new StringBuilder("Sub-class ");
        sb.append(name);
        sb.append(" (of class ");
        sb.append(name2);
        sb.append(") must override method '");
        throw new IllegalStateException(AbstractC0032g.m157o(sb, str, "'"));
    }

    /* JADX INFO: renamed from: G */
    public static Class m3877G(Class cls) {
        if (cls == Integer.TYPE) {
            return Integer.class;
        }
        if (cls == Long.TYPE) {
            return Long.class;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.class;
        }
        if (cls == Double.TYPE) {
            return Double.class;
        }
        if (cls == Float.TYPE) {
            return Float.class;
        }
        if (cls == Byte.TYPE) {
            return Byte.class;
        }
        if (cls == Short.TYPE) {
            return Short.class;
        }
        if (cls == Character.TYPE) {
            return Character.class;
        }
        throw new IllegalArgumentException("Class " + cls.getName() + " is not a primitive type");
    }

    /* JADX INFO: renamed from: a */
    public static void m3878a(Class cls, Class cls2, ArrayList arrayList) {
        if (cls == cls2 || cls == null || cls == Object.class || arrayList.contains(cls)) {
            return;
        }
        arrayList.add(cls);
        for (Class<?> cls3 : cls.getInterfaces()) {
            m3878a(cls3, cls2, arrayList);
        }
        m3878a(cls.getSuperclass(), cls2, arrayList);
    }

    /* JADX INFO: renamed from: b */
    public static void m3879b(Class cls, Throwable th) {
        throw new IllegalArgumentException("Failed on call to `getDeclaredMethods()` on class `" + cls.getName() + "`, problem: (" + th.getClass().getName() + ") " + th.getMessage(), th);
    }

    /* JADX INFO: renamed from: c */
    public static String m3880c(String str) {
        if (str == null) {
            return "[null]";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append('\'');
        sb.append(str);
        sb.append('\'');
        return sb.toString();
    }

    /* JADX INFO: renamed from: d */
    public static String m3881d(Class cls) {
        if (cls.isAnnotation()) {
            return "annotation";
        }
        if (cls.isArray()) {
            return "array";
        }
        if (Enum.class.isAssignableFrom(cls)) {
            return "enum";
        }
        if (cls.isPrimitive()) {
            return "primitive";
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: e */
    public static void m3882e(Member member, boolean z3) {
        AccessibleObject accessibleObject = (AccessibleObject) member;
        try {
            Class<?> declaringClass = member.getDeclaringClass();
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(declaringClass.getModifiers()) && (!z3 || m3898u(declaringClass))) {
                return;
            }
            accessibleObject.setAccessible(true);
        } catch (SecurityException e3) {
            if (accessibleObject.isAccessible()) {
                return;
            }
            throw new IllegalArgumentException("Cannot access " + member + " (from class " + member.getDeclaringClass().getName() + "; failed to set access: " + e3.getMessage());
        } catch (RuntimeException e4) {
            if (!"InaccessibleObjectException".equals(e4.getClass().getSimpleName())) {
                throw e4;
            }
            throw new IllegalArgumentException("Failed to call `setAccess()` on " + member.getClass().getSimpleName() + " '" + member.getName() + "' (of class " + m3903z(member.getDeclaringClass()) + ") due to `" + e4.getClass().getName() + "`, problem: " + e4.getMessage(), e4);
        }
    }

    /* JADX INFO: renamed from: f */
    public static String m3883f(Object obj) {
        if (obj == null) {
            return "[null]";
        }
        return m3903z(obj instanceof Class ? (Class) obj : obj.getClass());
    }

    /* JADX INFO: renamed from: g */
    public static void m3884g(AbstractC0540h abstractC0540h, Closeable closeable, Exception exc) {
        if (abstractC0540h != null) {
            abstractC0540h.mo1132e(EnumC0539g.AUTO_CLOSE_JSON_CONTENT);
            try {
                abstractC0540h.close();
            } catch (Exception e3) {
                exc.addSuppressed(e3);
            }
        }
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e4) {
                exc.addSuppressed(e4);
            }
        }
        m3874D(exc);
        m3875E(exc);
        throw new RuntimeException(exc);
    }

    /* JADX INFO: renamed from: h */
    public static Object m3885h(Class cls, boolean z3) {
        Constructor constructorM3888k = m3888k(cls, z3);
        if (constructorM3888k == null) {
            throw new IllegalArgumentException("Class " + cls.getName() + " has no default (no arg) constructor");
        }
        try {
            return constructorM3888k.newInstance(null);
        } catch (Exception e3) {
            String str = "Failed to instantiate class " + cls.getName() + ", problem: " + e3.getMessage();
            Throwable thM3894q = m3894q(e3);
            m3875E(thM3894q);
            m3873C(thM3894q);
            throw new IllegalArgumentException(str, thM3894q);
        }
    }

    /* JADX INFO: renamed from: i */
    public static String m3886i(Throwable th) {
        return th instanceof AbstractC0535c ? ((AbstractC0535c) th).mo1082a() : (!(th instanceof InvocationTargetException) || th.getCause() == null) ? th.getMessage() : th.getCause().getMessage();
    }

    /* JADX INFO: renamed from: j */
    public static Annotation[] m3887j(Class cls) {
        return m3900w(cls) ? f6110a : cls.getDeclaredAnnotations();
    }

    /* JADX INFO: renamed from: k */
    public static Constructor m3888k(Class cls, boolean z3) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            if (z3) {
                m3882e(declaredConstructor, z3);
            } else if (!Modifier.isPublic(declaredConstructor.getModifiers())) {
                throw new IllegalArgumentException("Default constructor for " + cls.getName() + " is not accessible (non-public?): not allowed to try modify access via Reflection: cannot instantiate type");
            }
            return declaredConstructor;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (Exception e3) {
            String str = "Failed to find default constructor of class " + cls.getName() + ", problem: " + e3.getMessage();
            Throwable thM3894q = m3894q(e3);
            m3875E(thM3894q);
            m3873C(thM3894q);
            throw new IllegalArgumentException(str, thM3894q);
        }
    }

    /* JADX INFO: renamed from: l */
    public static ArrayList m3889l(Class cls, Class cls2, boolean z3) {
        ArrayList arrayList = new ArrayList(8);
        if (cls != null && cls != cls2) {
            if (z3) {
                arrayList.add(cls);
            }
            while (true) {
                cls = cls.getSuperclass();
                if (cls == null || cls == cls2) {
                    break;
                }
                arrayList.add(cls);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: m */
    public static String m3890m(Object obj) {
        if (obj == null) {
            return "unknown";
        }
        return m3903z(obj instanceof Class ? (Class) obj : obj.getClass());
    }

    /* JADX INFO: renamed from: n */
    public static Method[] m3891n(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (Exception e3) {
            m3879b(cls, e3);
            throw null;
        } catch (NoClassDefFoundError e4) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                m3879b(cls, e4);
                throw null;
            }
            try {
                try {
                    return contextClassLoader.loadClass(cls.getName()).getDeclaredMethods();
                } catch (Exception e5) {
                    m3879b(cls, e5);
                    throw null;
                }
            } catch (ClassNotFoundException e6) {
                e4.addSuppressed(e6);
                m3879b(cls, e4);
                throw null;
            }
        }
    }

    /* JADX INFO: renamed from: o */
    public static C1743h[] m3892o(Class cls) {
        if (cls.isInterface() || m3900w(cls)) {
            return f6111b;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        C1743h[] c1743hArr = new C1743h[length];
        for (int i3 = 0; i3 < length; i3++) {
            c1743hArr[i3] = new C1743h(declaredConstructors[i3]);
        }
        return c1743hArr;
    }

    /* JADX INFO: renamed from: p */
    public static Class m3893p(Class cls) {
        if (Modifier.isStatic(cls.getModifiers())) {
            return null;
        }
        try {
            if ((m3900w(cls) || cls.getEnclosingMethod() == null) && !m3900w(cls)) {
                return cls.getEnclosingClass();
            }
            return null;
        } catch (SecurityException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: q */
    public static Throwable m3894q(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    /* JADX INFO: renamed from: r */
    public static String m3895r(AbstractC0721l abstractC0721l) {
        if (abstractC0721l == null) {
            return "[null]";
        }
        StringBuilder sb = new StringBuilder(80);
        sb.append('`');
        sb.append(((AbstractC1671m) abstractC0721l).mo3749L());
        sb.append('`');
        return sb.toString();
    }

    /* JADX INFO: renamed from: s */
    public static boolean m3896s(Object obj, Class cls) {
        return obj != null && obj.getClass() == cls;
    }

    /* JADX INFO: renamed from: t */
    public static boolean m3897t(Class cls) {
        return cls == Void.class || cls == Void.TYPE || cls == AbstractC0752p.class;
    }

    /* JADX INFO: renamed from: u */
    public static boolean m3898u(Class cls) {
        String name = cls.getName();
        return name.startsWith("java.") || name.startsWith("javax.");
    }

    /* JADX INFO: renamed from: v */
    public static boolean m3899v(Object obj) {
        return obj == null || obj.getClass().getAnnotation(InterfaceC0738b.class) != null;
    }

    /* JADX INFO: renamed from: w */
    public static boolean m3900w(Class cls) {
        return cls == Object.class || cls.isPrimitive();
    }

    /* JADX INFO: renamed from: x */
    public static boolean m3901x(Class cls) {
        Class superclass = cls.getSuperclass();
        return superclass != null && "com.android.tools.r8.RecordTag".equals(superclass.getName());
    }

    /* JADX INFO: renamed from: y */
    public static String m3902y(String str) {
        return str == null ? "[null]" : m3880c(str);
    }

    /* JADX INFO: renamed from: z */
    public static String m3903z(Class cls) {
        if (cls == null) {
            return "[null]";
        }
        int i3 = 0;
        while (cls.isArray()) {
            i3++;
            cls = cls.getComponentType();
        }
        String simpleName = cls.isPrimitive() ? cls.getSimpleName() : cls.getName();
        if (i3 > 0) {
            StringBuilder sb = new StringBuilder(simpleName);
            do {
                sb.append("[]");
                i3--;
            } while (i3 > 0);
            simpleName = sb.toString();
        }
        if (simpleName == null) {
            return "[null]";
        }
        StringBuilder sb2 = new StringBuilder(simpleName.length() + 2);
        sb2.append('`');
        sb2.append(simpleName);
        sb2.append('`');
        return sb2.toString();
    }
}
