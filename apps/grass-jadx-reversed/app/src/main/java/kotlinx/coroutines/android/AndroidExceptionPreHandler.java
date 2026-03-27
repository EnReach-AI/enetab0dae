package kotlinx.coroutines.android;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import p089d2.AbstractC1307a;
import p089d2.InterfaceC1317k;
import p090e.InterfaceC1319a;
import p150u2.C1955d;
import p150u2.InterfaceC1956e;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC1319a
public final class AndroidExceptionPreHandler extends AbstractC1307a implements InterfaceC1956e {
    private volatile Object _preHandler;

    public AndroidExceptionPreHandler() {
        super(C1955d.f6974a);
        this._preHandler = this;
    }

    private final Method preHandler() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        try {
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", null);
            if (Modifier.isPublic(declaredMethod.getModifiers())) {
                if (Modifier.isStatic(declaredMethod.getModifiers())) {
                    method = declaredMethod;
                }
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    @Override // p150u2.InterfaceC1956e
    public void handleException(InterfaceC1317k interfaceC1317k, Throwable th) {
    }
}
