package p154v2;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.InvocationTargetException;
import p083b2.C1062g;

/* JADX INFO: renamed from: v2.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1978b {
    private static volatile Choreographer choreographer;

    static {
        Object c1062g;
        try {
            c1062g = new C1977a(m4370a(Looper.getMainLooper()));
        } catch (Throwable th) {
            c1062g = new C1062g(th);
        }
        if (c1062g instanceof C1062g) {
            c1062g = null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static final Handler m4370a(Looper looper) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        if (objInvoke != null) {
            return (Handler) objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
    }
}
