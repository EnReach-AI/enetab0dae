package p150u2;

import p089d2.AbstractC1307a;
import p089d2.C1313g;
import p089d2.C1318l;
import p089d2.InterfaceC1314h;
import p089d2.InterfaceC1315i;
import p089d2.InterfaceC1316j;
import p089d2.InterfaceC1317k;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: u2.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1954c extends AbstractC1307a implements InterfaceC1314h {

    /* JADX INFO: renamed from: e */
    public static final C1953b f6973e = new C1953b(C1313g.f4676a, C1952a.f6970f);

    public AbstractC1954c() {
        super(C1313g.f4676a);
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo3742a(InterfaceC1317k interfaceC1317k, Runnable runnable);

    /* JADX INFO: renamed from: b */
    public boolean mo4358b() {
        return !(this instanceof C1969r);
    }

    @Override // p089d2.AbstractC1307a, p089d2.InterfaceC1317k
    public final InterfaceC1315i get(InterfaceC1316j interfaceC1316j) {
        AbstractC1766e.m3920e("key", interfaceC1316j);
        if (!(interfaceC1316j instanceof C1953b)) {
            if (C1313g.f4676a == interfaceC1316j) {
                return this;
            }
            return null;
        }
        C1953b c1953b = (C1953b) interfaceC1316j;
        InterfaceC1316j key = getKey();
        AbstractC1766e.m3920e("key", key);
        if (key != c1953b && c1953b.f6972b != key) {
            return null;
        }
        InterfaceC1315i interfaceC1315i = (InterfaceC1315i) c1953b.f6971a.mo249f(this);
        if (interfaceC1315i instanceof InterfaceC1315i) {
            return interfaceC1315i;
        }
        return null;
    }

    @Override // p089d2.AbstractC1307a, p089d2.InterfaceC1317k
    public final InterfaceC1317k minusKey(InterfaceC1316j interfaceC1316j) {
        AbstractC1766e.m3920e("key", interfaceC1316j);
        boolean z3 = interfaceC1316j instanceof C1953b;
        C1318l c1318l = C1318l.f4678e;
        if (z3) {
            C1953b c1953b = (C1953b) interfaceC1316j;
            InterfaceC1316j key = getKey();
            AbstractC1766e.m3920e("key", key);
            if ((key == c1953b || c1953b.f6972b == key) && ((InterfaceC1315i) c1953b.f6971a.mo249f(this)) != null) {
                return c1318l;
            }
        } else if (C1313g.f4676a == interfaceC1316j) {
            return c1318l;
        }
        return this;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }
}
