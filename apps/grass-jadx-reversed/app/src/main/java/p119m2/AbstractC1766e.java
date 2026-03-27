package p119m2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import p005B.AbstractC0032g;
import p069X0.C0706H;

/* JADX INFO: renamed from: m2.e */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1766e {

    /* JADX INFO: renamed from: a */
    public static final Object[] f6143a = new Object[0];

    /* JADX INFO: renamed from: a */
    public static boolean m3916a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* JADX INFO: renamed from: b */
    public static void m3917b(Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        m3922g(nullPointerException, AbstractC1766e.class.getName());
        throw nullPointerException;
    }

    /* JADX INFO: renamed from: c */
    public static void m3918c(String str, Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str);
        m3922g(nullPointerException, AbstractC1766e.class.getName());
        throw nullPointerException;
    }

    /* JADX INFO: renamed from: d */
    public static void m3919d(String str, Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str.concat(" must not be null"));
        m3922g(nullPointerException, AbstractC1766e.class.getName());
        throw nullPointerException;
    }

    /* JADX INFO: renamed from: e */
    public static void m3920e(String str, Object obj) {
        if (obj == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = AbstractC1766e.class.getName();
            int i3 = 0;
            while (!stackTrace[i3].getClassName().equals(name)) {
                i3++;
            }
            while (stackTrace[i3].getClassName().equals(name)) {
                i3++;
            }
            StackTraceElement stackTraceElement = stackTrace[i3];
            NullPointerException nullPointerException = new NullPointerException("Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str);
            m3922g(nullPointerException, AbstractC1766e.class.getName());
            throw nullPointerException;
        }
    }

    /* JADX INFO: renamed from: f */
    public static int m3921f(int i3, int i4) {
        if (i3 < i4) {
            return -1;
        }
        return i3 == i4 ? 0 : 1;
    }

    /* JADX INFO: renamed from: g */
    public static void m3922g(RuntimeException runtimeException, String str) {
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            if (str.equals(stackTrace[i4].getClassName())) {
                i3 = i4;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i3 + 1, length));
    }

    /* JADX INFO: renamed from: h */
    public static String m3923h(String str, Object obj) {
        return str + obj;
    }

    /* JADX INFO: renamed from: i */
    public static void m3924i(String str) {
        C0706H c0706h = new C0706H(AbstractC0032g.m154l("lateinit property ", str, " has not been initialized"));
        m3922g(c0706h, AbstractC1766e.class.getName());
        throw c0706h;
    }

    /* JADX INFO: renamed from: j */
    public static final Object[] m3925j(Collection collection) {
        m3920e("collection", collection);
        int size = collection.size();
        Object[] objArr = f6143a;
        if (size == 0) {
            return objArr;
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return objArr;
        }
        Object[] objArrCopyOf = new Object[size];
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            objArrCopyOf[i3] = it.next();
            if (i4 >= objArrCopyOf.length) {
                if (!it.hasNext()) {
                    return objArrCopyOf;
                }
                int i5 = ((i4 * 3) + 1) >>> 1;
                if (i5 <= i4) {
                    i5 = 2147483645;
                    if (i4 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i5);
                m3919d("copyOf(...)", objArrCopyOf);
            } else if (!it.hasNext()) {
                Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i4);
                m3919d("copyOf(...)", objArrCopyOf2);
                return objArrCopyOf2;
            }
            i3 = i4;
        }
    }

    /* JADX INFO: renamed from: k */
    public static final Object[] m3926k(Collection collection, Object[] objArr) {
        Object[] objArrCopyOf;
        m3920e("collection", collection);
        objArr.getClass();
        int size = collection.size();
        int i3 = 0;
        if (size == 0) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        if (size <= objArr.length) {
            objArrCopyOf = objArr;
        } else {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            m3918c("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>", objNewInstance);
            objArrCopyOf = (Object[]) objNewInstance;
        }
        while (true) {
            int i4 = i3 + 1;
            objArrCopyOf[i3] = it.next();
            if (i4 >= objArrCopyOf.length) {
                if (!it.hasNext()) {
                    return objArrCopyOf;
                }
                int i5 = ((i4 * 3) + 1) >>> 1;
                if (i5 <= i4) {
                    i5 = 2147483645;
                    if (i4 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i5);
                m3919d("copyOf(...)", objArrCopyOf);
            } else if (!it.hasNext()) {
                if (objArrCopyOf == objArr) {
                    objArr[i4] = null;
                    return objArr;
                }
                Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i4);
                m3919d("copyOf(...)", objArrCopyOf2);
                return objArrCopyOf2;
            }
            i3 = i4;
        }
    }
}
