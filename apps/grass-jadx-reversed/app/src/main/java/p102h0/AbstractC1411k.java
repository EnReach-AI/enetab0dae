package p102h0;

import java.lang.reflect.InvocationTargetException;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import p019F0.C0221e;
import p020F2.AbstractC0223a;
import p129p0.AbstractC1822d;

/* JADX INFO: renamed from: h0.k */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1411k {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC1412l f5037a;

    static {
        InterfaceC1412l c1407g;
        try {
            c1407g = new C0221e(16, (WebViewProviderFactoryBoundaryInterface) AbstractC0223a.m464a(WebViewProviderFactoryBoundaryInterface.class, AbstractC1822d.m4048b()));
        } catch (ClassNotFoundException unused) {
            c1407g = new C1407g();
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException(e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
        f5037a = c1407g;
    }
}
