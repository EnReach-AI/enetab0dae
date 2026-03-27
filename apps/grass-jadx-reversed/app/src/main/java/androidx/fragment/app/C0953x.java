package androidx.fragment.app;

import java.lang.reflect.InvocationTargetException;
import p005B.AbstractC0032g;
import p069X0.C0706H;
import p128p.C1817k;

/* JADX INFO: renamed from: androidx.fragment.app.x */
/* JADX INFO: loaded from: classes.dex */
public final class C0953x {

    /* JADX INFO: renamed from: b */
    public static final C1817k f3270b = new C1817k();

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C0918D f3271a;

    public C0953x(C0918D c0918d) {
        this.f3271a = c0918d;
    }

    /* JADX INFO: renamed from: b */
    public static Class m2498b(ClassLoader classLoader, String str) throws ClassNotFoundException {
        C1817k c1817k = f3270b;
        C1817k c1817k2 = (C1817k) c1817k.getOrDefault(classLoader, null);
        if (c1817k2 == null) {
            c1817k2 = new C1817k();
            c1817k.put(classLoader, c1817k2);
        }
        Class cls = (Class) c1817k2.getOrDefault(str, null);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        c1817k2.put(str, cls2);
        return cls2;
    }

    /* JADX INFO: renamed from: c */
    public static Class m2499c(ClassLoader classLoader, String str) {
        try {
            return m2498b(classLoader, str);
        } catch (ClassCastException e3) {
            throw new C0706H(AbstractC0032g.m154l("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e3);
        } catch (ClassNotFoundException e4) {
            throw new C0706H(AbstractC0032g.m154l("Unable to instantiate fragment ", str, ": make sure class name exists"), e4);
        }
    }

    /* JADX INFO: renamed from: a */
    public final AbstractComponentCallbacksC0944o m2500a(String str) {
        try {
            return (AbstractComponentCallbacksC0944o) m2499c(this.f3271a.f3042n.f3247f.getClassLoader(), str).getConstructor(null).newInstance(null);
        } catch (IllegalAccessException e3) {
            throw new C0706H(AbstractC0032g.m154l("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e3);
        } catch (InstantiationException e4) {
            throw new C0706H(AbstractC0032g.m154l("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e4);
        } catch (NoSuchMethodException e5) {
            throw new C0706H(AbstractC0032g.m154l("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e5);
        } catch (InvocationTargetException e6) {
            throw new C0706H(AbstractC0032g.m154l("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e6);
        }
    }
}
