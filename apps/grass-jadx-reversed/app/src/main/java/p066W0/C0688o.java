package p066W0;

import com.fasterxml.jackson.core.exc.C1131b;
import p042N0.C0553u;

/* JADX INFO: renamed from: W0.o */
/* JADX INFO: loaded from: classes.dex */
public final class C0688o extends C0690q {

    /* JADX INFO: renamed from: m */
    public final C0553u f1867m;

    public C0688o(C0553u c0553u, C0674a c0674a) {
        super(c0674a);
        this.f1867m = c0553u;
    }

    @Override // p066W0.C0690q
    /* JADX INFO: renamed from: s */
    public final void mo1647s(int i3) throws C1131b {
        this.f1867m.getClass();
        if (i3 > 20000000) {
            throw new C1131b(String.format("String length (%d) exceeds the maximum length (%d)", Integer.valueOf(i3), 20000000));
        }
    }
}
