package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import p077a0.C0846e;
import p077a0.InterfaceC0844c;
import p077a0.InterfaceC0848g;

/* JADX INFO: renamed from: androidx.lifecycle.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0976i implements InterfaceC0844c {
    /* JADX INFO: renamed from: a */
    public final void m2511a(InterfaceC0848g interfaceC0848g) {
        Object obj;
        boolean z3;
        if (!(interfaceC0848g instanceof InterfaceC0967L)) {
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
        }
        C0966K c0966kMo2198c = ((InterfaceC0967L) interfaceC0848g).mo2198c();
        C0846e c0846eMo2186b = interfaceC0848g.mo2186b();
        c0966kMo2198c.getClass();
        Iterator it = new HashSet(c0966kMo2198c.f3303a.keySet()).iterator();
        while (it.hasNext()) {
            AbstractC0964I abstractC0964I = (AbstractC0964I) c0966kMo2198c.f3303a.get((String) it.next());
            C0986s c0986sMo2199d = interfaceC0848g.mo2199d();
            HashMap map = abstractC0964I.f3299a;
            if (map == null) {
                obj = null;
            } else {
                synchronized (map) {
                    obj = abstractC0964I.f3299a.get("androidx.lifecycle.savedstate.vm.tag");
                }
            }
            SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
            if (savedStateHandleController != null && !(z3 = savedStateHandleController.f3307a)) {
                if (z3) {
                    throw new IllegalStateException("Already attached to lifecycleOwner");
                }
                savedStateHandleController.f3307a = true;
                c0986sMo2199d.m2515a(savedStateHandleController);
                throw null;
            }
        }
        if (new HashSet(c0966kMo2198c.f3303a.keySet()).isEmpty()) {
            return;
        }
        c0846eMo2186b.m2177g();
    }
}
