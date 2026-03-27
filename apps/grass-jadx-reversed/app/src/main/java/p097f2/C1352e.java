package p097f2;

import android.os.Build;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: f2.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1352e {

    /* JADX INFO: renamed from: a */
    public Method f4818a;

    /* JADX INFO: renamed from: b */
    public Method f4819b;

    /* JADX INFO: renamed from: c */
    public Method f4820c;

    public C1352e(Method method, Method method2, Method method3) {
        this.f4818a = method;
        this.f4819b = method2;
        this.f4820c = method3;
    }

    /* JADX INFO: renamed from: a */
    public static void m3309a() {
        if (Build.VERSION.SDK_INT >= 29) {
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }
    }
}
