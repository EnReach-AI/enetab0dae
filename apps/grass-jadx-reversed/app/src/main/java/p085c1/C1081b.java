package p085c1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p005B.AbstractC0032g;
import p118m1.AbstractC1745j;
import p118m1.AbstractC1759x;

/* JADX INFO: renamed from: c1.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1081b {

    /* JADX INFO: renamed from: d */
    public static final C1081b f3770d;

    /* JADX INFO: renamed from: e */
    public static final RuntimeException f3771e;

    /* JADX INFO: renamed from: a */
    public final Method f3772a;

    /* JADX INFO: renamed from: b */
    public final Method f3773b;

    /* JADX INFO: renamed from: c */
    public final Method f3774c;

    static {
        C1081b c1081b = null;
        try {
            e = null;
            c1081b = new C1081b();
        } catch (RuntimeException e3) {
            e = e3;
        }
        f3770d = c1081b;
        f3771e = e;
    }

    public C1081b() {
        try {
            this.f3772a = Class.class.getMethod("getRecordComponents", null);
            Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
            this.f3773b = cls.getMethod("getName", null);
            this.f3774c = cls.getMethod("getType", null);
        } catch (Exception e3) {
            throw new RuntimeException(AbstractC0032g.m155m("Failed to access Methods needed to support `java.lang.Record`: (", e3.getClass().getName(), ") ", e3.getMessage()), e3);
        }
    }

    /* JADX INFO: renamed from: a */
    public final Object[] m2822a(Class cls) {
        boolean zEquals;
        try {
            return (Object[]) this.f3772a.invoke(cls, null);
        } catch (Exception e3) {
            e = e3;
            if (AbstractC1759x.f6137a && "runtime".equals(System.getProperty("org.graalvm.nativeimage.imagecode"))) {
                if (e instanceof InvocationTargetException) {
                    e = e.getCause();
                }
                zEquals = e.getClass().getName().equals("com.oracle.svm.core.jdk.UnsupportedFeatureError");
            } else {
                zEquals = false;
            }
            if (zEquals) {
                return null;
            }
            throw new IllegalArgumentException("Failed to access RecordComponents of type " + AbstractC1745j.m3903z(cls));
        }
    }
}
