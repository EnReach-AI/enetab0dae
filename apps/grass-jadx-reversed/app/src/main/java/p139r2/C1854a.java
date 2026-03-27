package p139r2;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: r2.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1854a implements InterfaceC1855b {

    /* JADX INFO: renamed from: a */
    public final AtomicReference f6429a;

    public C1854a(C1858e c1858e) {
        this.f6429a = new AtomicReference(c1858e);
    }

    @Override // p139r2.InterfaceC1855b
    public final Iterator iterator() {
        InterfaceC1855b interfaceC1855b = (InterfaceC1855b) this.f6429a.getAndSet(null);
        if (interfaceC1855b != null) {
            return interfaceC1855b.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
