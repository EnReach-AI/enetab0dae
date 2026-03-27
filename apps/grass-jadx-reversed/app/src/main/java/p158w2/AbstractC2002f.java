package p158w2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import kotlinx.coroutines.android.AndroidDispatcherFactory;
import p119m2.AbstractC1766e;
import p139r2.AbstractC1856c;
import p139r2.C1854a;
import p139r2.C1858e;
import p150u2.AbstractC1967p;

/* JADX INFO: renamed from: w2.f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2002f {

    /* JADX INFO: renamed from: a */
    public static final AbstractC1967p f7146a;

    static {
        String property;
        Object next;
        int i3 = AbstractC2004h.f7147a;
        AbstractC1967p abstractC1967pCreateDispatcher = null;
        try {
            property = System.getProperty("kotlinx.coroutines.fast.service.loader");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null) {
            Boolean.parseBoolean(property);
        }
        try {
            Iterator it = Arrays.asList(new AndroidDispatcherFactory()).iterator();
            AbstractC1766e.m3920e("<this>", it);
            List listM4134j = AbstractC1856c.m4134j(new C1854a(new C1858e(it)));
            Iterator it2 = listM4134j.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    int loadPriority = ((InterfaceC2001e) next).getLoadPriority();
                    do {
                        Object next2 = it2.next();
                        int loadPriority2 = ((InterfaceC2001e) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it2.hasNext());
                }
            } else {
                next = null;
            }
            InterfaceC2001e interfaceC2001e = (InterfaceC2001e) next;
            if (interfaceC2001e != null) {
                try {
                    abstractC1967pCreateDispatcher = interfaceC2001e.createDispatcher(listM4134j);
                } catch (Throwable th) {
                    interfaceC2001e.hintOnError();
                    throw th;
                }
            }
            if (abstractC1967pCreateDispatcher == null) {
                throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
            }
            f7146a = abstractC1967pCreateDispatcher;
        } catch (Throwable th2) {
            throw new ServiceConfigurationError(th2.getMessage(), th2);
        }
    }
}
