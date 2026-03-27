package p097f2;

import p089d2.C1318l;
import p089d2.InterfaceC1312f;
import p089d2.InterfaceC1317k;

/* JADX INFO: renamed from: f2.g */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1354g extends AbstractC1348a {
    public AbstractC1354g(InterfaceC1312f interfaceC1312f) {
        super(interfaceC1312f);
        if (interfaceC1312f != null && interfaceC1312f.mo3283d() != C1318l.f4678e) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
        }
    }

    @Override // p089d2.InterfaceC1312f
    /* JADX INFO: renamed from: d */
    public final InterfaceC1317k mo3283d() {
        return C1318l.f4678e;
    }
}
