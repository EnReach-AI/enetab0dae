package p101g2;

import java.lang.reflect.Method;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: g2.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1400a {

    /* JADX INFO: renamed from: a */
    public static final Method f5027a;

    static {
        Method method;
        Method[] methods = Throwable.class.getMethods();
        AbstractC1766e.m3917b(methods);
        int length = methods.length;
        int i3 = 0;
        while (true) {
            method = null;
            if (i3 >= length) {
                break;
            }
            Method method2 = methods[i3];
            if (AbstractC1766e.m3916a(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                AbstractC1766e.m3919d("getParameterTypes(...)", parameterTypes);
                if (AbstractC1766e.m3916a(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i3++;
        }
        f5027a = method;
        int length2 = methods.length;
        for (int i4 = 0; i4 < length2 && !AbstractC1766e.m3916a(methods[i4].getName(), "getSuppressed"); i4++) {
        }
    }
}
