package p137r0;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import android.widget.EdgeEffect;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import p010C0.AbstractC0147a;
import p041N.AbstractC0516d;
import p041N.AbstractC0517e;
import p142s2.AbstractC1899n;
import p144t0.AbstractC1918d;
import p158w2.AbstractC2004h;

/* JADX INFO: renamed from: r0.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1852a {

    /* JADX INFO: renamed from: a */
    public static boolean f6422a = false;

    /* JADX INFO: renamed from: b */
    public static boolean f6423b = false;

    /* JADX INFO: renamed from: c */
    public static long f6424c;

    /* JADX INFO: renamed from: d */
    public static Method f6425d;

    /* JADX INFO: renamed from: a */
    public static int m4126a(int i3, int i4, int i5) {
        return i3 < i4 ? i4 : i3 > i5 ? i5 : i3;
    }

    /* JADX INFO: renamed from: b */
    public static float m4127b(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return AbstractC0517e.m1029b(edgeEffect);
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m4128c() {
        try {
            if (f6425d == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (f6425d == null) {
                f6424c = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f6425d = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f6425d.invoke(null, Long.valueOf(f6424c))).booleanValue();
        } catch (Exception e3) {
            if (!(e3 instanceof InvocationTargetException)) {
                Log.v("Trace", "Unable to call isTagEnabled via reflection", e3);
                return false;
            }
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    /* JADX INFO: renamed from: d */
    public static float m4129d(EdgeEffect edgeEffect, float f3, float f4) {
        if (Build.VERSION.SDK_INT >= 31) {
            return AbstractC0517e.m1030c(edgeEffect, f3, f4);
        }
        AbstractC0516d.m1027a(edgeEffect, f3, f4);
        return f3;
    }

    /* JADX INFO: renamed from: e */
    public static boolean m4130e(String str) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(AbstractC1852a.class)) {
            return false;
        }
        try {
            String str2 = null;
            if (!set.contains(AbstractC1852a.class)) {
                try {
                    float[] fArr = new float[30];
                    Arrays.fill(fArr, 0.0f);
                    String[] strArrM4277g = AbstractC1918d.m4277g(1, new float[][]{fArr}, new String[]{str});
                    str2 = strArrM4277g == null ? "none" : strArrM4277g[0];
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, AbstractC1852a.class);
                }
            }
            return !"none".equals(str2);
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, AbstractC1852a.class);
            return false;
        }
    }

    /* JADX INFO: renamed from: f */
    public static final long m4131f(String str, long j2, long j3, long j4) {
        String property;
        int i3 = AbstractC2004h.f7147a;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j2;
        }
        Long lM4230g = AbstractC1899n.m4230g(property);
        if (lM4230g == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = lM4230g.longValue();
        if (j3 <= jLongValue && jLongValue <= j4) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j3 + ".." + j4 + ", but is '" + jLongValue + '\'').toString());
    }

    /* JADX INFO: renamed from: g */
    public static int m4132g(String str, int i3, int i4, int i5, int i6) {
        if ((i6 & 4) != 0) {
            i4 = 1;
        }
        if ((i6 & 8) != 0) {
            i5 = Integer.MAX_VALUE;
        }
        return (int) m4131f(str, i3, i4, i5);
    }
}
