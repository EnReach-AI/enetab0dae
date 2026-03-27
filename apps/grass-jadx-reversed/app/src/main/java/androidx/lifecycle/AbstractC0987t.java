package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import p005B.AbstractC0032g;

/* JADX INFO: renamed from: androidx.lifecycle.t */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0987t {

    /* JADX INFO: renamed from: a */
    public static final HashMap f3335a = new HashMap();

    /* JADX INFO: renamed from: b */
    public static final HashMap f3336b = new HashMap();

    /* JADX INFO: renamed from: a */
    public static void m2522a(Constructor constructor, Object obj) {
        try {
            AbstractC0032g.m162t(constructor.newInstance(obj));
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        } catch (InstantiationException e4) {
            throw new RuntimeException(e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m2523b(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0116 A[SYNTHETIC] */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m2524c(java.lang.Class r13) {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.AbstractC0987t.m2524c(java.lang.Class):int");
    }
}
