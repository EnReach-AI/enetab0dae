package p077a0;

import android.os.Bundle;
import androidx.lifecycle.C0986s;
import androidx.lifecycle.EnumC0978k;
import androidx.lifecycle.EnumC0979l;
import androidx.lifecycle.InterfaceC0982o;
import androidx.lifecycle.InterfaceC0984q;
import androidx.savedstate.Recreator;
import java.util.Map;
import p116m.C1703d;
import p116m.C1705f;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: a0.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0847f {

    /* JADX INFO: renamed from: a */
    public final InterfaceC0848g f2518a;

    /* JADX INFO: renamed from: b */
    public final C0846e f2519b = new C0846e();

    /* JADX INFO: renamed from: c */
    public boolean f2520c;

    public C0847f(InterfaceC0848g interfaceC0848g) {
        this.f2518a = interfaceC0848g;
    }

    /* JADX INFO: renamed from: a */
    public final void m2183a() {
        InterfaceC0848g interfaceC0848g = this.f2518a;
        C0986s c0986sMo2199d = interfaceC0848g.mo2199d();
        AbstractC1766e.m3919d("owner.lifecycle", c0986sMo2199d);
        if (c0986sMo2199d.f3328b != EnumC0979l.f3319f) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        c0986sMo2199d.m2515a(new Recreator(interfaceC0848g));
        final C0846e c0846e = this.f2519b;
        c0846e.getClass();
        if (!(!c0846e.f2512b)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        c0986sMo2199d.m2515a(new InterfaceC0982o() { // from class: a0.b
            @Override // androidx.lifecycle.InterfaceC0982o
            /* JADX INFO: renamed from: b */
            public final void mo2170b(InterfaceC0984q interfaceC0984q, EnumC0978k enumC0978k) {
                C0846e c0846e2 = c0846e;
                AbstractC1766e.m3920e("this$0", c0846e2);
                if (enumC0978k == EnumC0978k.ON_START) {
                    c0846e2.f2514d = true;
                } else if (enumC0978k == EnumC0978k.ON_STOP) {
                    c0846e2.f2514d = false;
                }
            }
        });
        c0846e.f2512b = true;
        this.f2520c = true;
    }

    /* JADX INFO: renamed from: b */
    public final void m2184b(Bundle bundle) {
        if (!this.f2520c) {
            m2183a();
        }
        C0986s c0986sMo2199d = this.f2518a.mo2199d();
        AbstractC1766e.m3919d("owner.lifecycle", c0986sMo2199d);
        if (!(!c0986sMo2199d.f3328b.m2513a(EnumC0979l.f3321h))) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + c0986sMo2199d.f3328b).toString());
        }
        C0846e c0846e = this.f2519b;
        if (!c0846e.f2512b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!c0846e.f2513c)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        c0846e.f2516f = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        c0846e.f2513c = true;
    }

    /* JADX INFO: renamed from: c */
    public final void m2185c(Bundle bundle) {
        AbstractC1766e.m3920e("outBundle", bundle);
        C0846e c0846e = this.f2519b;
        c0846e.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = (Bundle) c0846e.f2516f;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        C1705f c1705f = (C1705f) c0846e.f2515e;
        c1705f.getClass();
        C1703d c1703d = new C1703d(c1705f);
        c1705f.f5970g.put(c1703d, Boolean.FALSE);
        while (c1703d.hasNext()) {
            Map.Entry entry = (Map.Entry) c1703d.next();
            bundle2.putBundle((String) entry.getKey(), ((InterfaceC0845d) entry.getValue()).mo2169a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
