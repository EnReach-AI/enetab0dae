package p118m1;

/* JADX INFO: renamed from: m1.x */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1759x {

    /* JADX INFO: renamed from: a */
    public static final boolean f6137a;

    static {
        f6137a = System.getProperty("org.graalvm.nativeimage.imagecode") != null;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3912a(Class cls) {
        if (f6137a && "runtime".equals(System.getProperty("org.graalvm.nativeimage.imagecode"))) {
            return (cls.getDeclaredFields().length == 0 || AbstractC1745j.m3901x(cls)) && cls.getDeclaredMethods().length == 0 && cls.getDeclaredConstructors().length == 0;
        }
        return false;
    }
}
