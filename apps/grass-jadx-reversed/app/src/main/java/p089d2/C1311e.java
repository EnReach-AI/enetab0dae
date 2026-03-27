package p089d2;

import java.io.Serializable;
import p083b2.C1077v;
import p115l2.InterfaceC1693p;
import p119m2.AbstractC1766e;
import p119m2.C1769h;

/* JADX INFO: renamed from: d2.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1311e implements InterfaceC1317k, Serializable {

    /* JADX INFO: renamed from: e */
    public final InterfaceC1317k f4674e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC1315i f4675f;

    public C1311e(InterfaceC1317k interfaceC1317k, InterfaceC1315i interfaceC1315i) {
        AbstractC1766e.m3920e("left", interfaceC1317k);
        AbstractC1766e.m3920e("element", interfaceC1315i);
        this.f4674e = interfaceC1317k;
        this.f4675f = interfaceC1315i;
    }

    private final Object writeReplace() {
        int iM3282a = m3282a();
        InterfaceC1317k[] interfaceC1317kArr = new InterfaceC1317k[iM3282a];
        C1769h c1769h = new C1769h();
        fold(C1077v.f3761a, new C1310d(interfaceC1317kArr, c1769h));
        if (c1769h.f6146e == iM3282a) {
            return new C1308b(interfaceC1317kArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX INFO: renamed from: a */
    public final int m3282a() {
        int i3 = 2;
        C1311e c1311e = this;
        while (true) {
            InterfaceC1317k interfaceC1317k = c1311e.f4674e;
            c1311e = interfaceC1317k instanceof C1311e ? (C1311e) interfaceC1317k : null;
            if (c1311e == null) {
                return i3;
            }
            i3++;
        }
    }

    public final boolean equals(Object obj) {
        boolean zM3916a;
        if (this != obj) {
            if (!(obj instanceof C1311e)) {
                return false;
            }
            C1311e c1311e = (C1311e) obj;
            if (c1311e.m3282a() != m3282a()) {
                return false;
            }
            C1311e c1311e2 = this;
            while (true) {
                InterfaceC1315i interfaceC1315i = c1311e2.f4675f;
                if (!AbstractC1766e.m3916a(c1311e.get(interfaceC1315i.getKey()), interfaceC1315i)) {
                    zM3916a = false;
                    break;
                }
                InterfaceC1317k interfaceC1317k = c1311e2.f4674e;
                if (!(interfaceC1317k instanceof C1311e)) {
                    AbstractC1766e.m3918c("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element", interfaceC1317k);
                    InterfaceC1315i interfaceC1315i2 = (InterfaceC1315i) interfaceC1317k;
                    zM3916a = AbstractC1766e.m3916a(c1311e.get(interfaceC1315i2.getKey()), interfaceC1315i2);
                    break;
                }
                c1311e2 = (C1311e) interfaceC1317k;
            }
            if (!zM3916a) {
                return false;
            }
        }
        return true;
    }

    @Override // p089d2.InterfaceC1317k
    public final Object fold(Object obj, InterfaceC1693p interfaceC1693p) {
        return interfaceC1693p.mo317c(this.f4674e.fold(obj, interfaceC1693p), this.f4675f);
    }

    @Override // p089d2.InterfaceC1317k
    public final InterfaceC1315i get(InterfaceC1316j interfaceC1316j) {
        AbstractC1766e.m3920e("key", interfaceC1316j);
        C1311e c1311e = this;
        while (true) {
            InterfaceC1315i interfaceC1315i = c1311e.f4675f.get(interfaceC1316j);
            if (interfaceC1315i != null) {
                return interfaceC1315i;
            }
            InterfaceC1317k interfaceC1317k = c1311e.f4674e;
            if (!(interfaceC1317k instanceof C1311e)) {
                return interfaceC1317k.get(interfaceC1316j);
            }
            c1311e = (C1311e) interfaceC1317k;
        }
    }

    public final int hashCode() {
        return this.f4675f.hashCode() + this.f4674e.hashCode();
    }

    @Override // p089d2.InterfaceC1317k
    public final InterfaceC1317k minusKey(InterfaceC1316j interfaceC1316j) {
        AbstractC1766e.m3920e("key", interfaceC1316j);
        InterfaceC1315i interfaceC1315i = this.f4675f;
        InterfaceC1315i interfaceC1315i2 = interfaceC1315i.get(interfaceC1316j);
        InterfaceC1317k interfaceC1317k = this.f4674e;
        if (interfaceC1315i2 != null) {
            return interfaceC1317k;
        }
        InterfaceC1317k interfaceC1317kMinusKey = interfaceC1317k.minusKey(interfaceC1316j);
        return interfaceC1317kMinusKey == interfaceC1317k ? this : interfaceC1317kMinusKey == C1318l.f4678e ? interfaceC1315i : new C1311e(interfaceC1317kMinusKey, interfaceC1315i);
    }

    @Override // p089d2.InterfaceC1317k
    public final InterfaceC1317k plus(InterfaceC1317k interfaceC1317k) {
        AbstractC1766e.m3920e("context", interfaceC1317k);
        return interfaceC1317k == C1318l.f4678e ? this : (InterfaceC1317k) interfaceC1317k.fold(this, C1309c.f4670h);
    }

    public final String toString() {
        return "[" + ((String) fold("", C1309c.f4669g)) + ']';
    }
}
