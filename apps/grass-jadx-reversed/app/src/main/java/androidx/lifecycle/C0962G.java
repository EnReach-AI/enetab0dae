package androidx.lifecycle;

import android.os.Bundle;
import androidx.fragment.app.AbstractActivityC0947r;
import java.util.Iterator;
import java.util.Map;
import p005B.AbstractC0032g;
import p077a0.C0846e;
import p077a0.InterfaceC0845d;
import p083b2.C1065j;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: androidx.lifecycle.G */
/* JADX INFO: loaded from: classes.dex */
public final class C0962G implements InterfaceC0845d {

    /* JADX INFO: renamed from: a */
    public final C0846e f3294a;

    /* JADX INFO: renamed from: b */
    public boolean f3295b;

    /* JADX INFO: renamed from: c */
    public Bundle f3296c;

    /* JADX INFO: renamed from: d */
    public final C1065j f3297d;

    public C0962G(C0846e c0846e, AbstractActivityC0947r abstractActivityC0947r) {
        AbstractC1766e.m3920e("savedStateRegistry", c0846e);
        this.f3294a = c0846e;
        this.f3297d = new C1065j(new C0961F(0, abstractActivityC0947r));
    }

    @Override // p077a0.InterfaceC0845d
    /* JADX INFO: renamed from: a */
    public final Bundle mo2169a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f3296c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        Iterator it = ((C0963H) this.f3297d.getValue()).f3298c.entrySet().iterator();
        if (!it.hasNext()) {
            this.f3295b = false;
            return bundle;
        }
        Map.Entry entry = (Map.Entry) it.next();
        AbstractC0032g.m162t(entry.getValue());
        throw null;
    }
}
