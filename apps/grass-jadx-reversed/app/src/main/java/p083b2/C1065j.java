package p083b2;

import java.io.Serializable;
import p115l2.InterfaceC1678a;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: b2.j */
/* JADX INFO: loaded from: classes.dex */
public final class C1065j implements InterfaceC1059d, Serializable {

    /* JADX INFO: renamed from: e */
    public InterfaceC1678a f3743e;

    /* JADX INFO: renamed from: f */
    public volatile Object f3744f = C1074s.f3758a;

    /* JADX INFO: renamed from: g */
    public final Object f3745g = this;

    public C1065j(InterfaceC1678a interfaceC1678a) {
        this.f3743e = interfaceC1678a;
    }

    private final Object writeReplace() {
        return new C1058c(getValue());
    }

    @Override // p083b2.InterfaceC1059d
    public final Object getValue() {
        Object objMo263a;
        Object obj = this.f3744f;
        C1074s c1074s = C1074s.f3758a;
        if (obj != c1074s) {
            return obj;
        }
        synchronized (this.f3745g) {
            objMo263a = this.f3744f;
            if (objMo263a == c1074s) {
                InterfaceC1678a interfaceC1678a = this.f3743e;
                AbstractC1766e.m3917b(interfaceC1678a);
                objMo263a = interfaceC1678a.mo263a();
                this.f3744f = objMo263a;
                this.f3743e = null;
            }
        }
        return objMo263a;
    }

    public final String toString() {
        return this.f3744f != C1074s.f3758a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
