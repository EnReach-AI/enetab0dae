package p103h1;

import p042N0.AbstractC0540h;
import p042N0.C0538f;
import p064V0.C0672b;
import p069X0.InterfaceC0714e;
import p100g1.AbstractC1399h;

/* JADX INFO: renamed from: h1.s */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1431s extends AbstractC1399h {

    /* JADX INFO: renamed from: a */
    public final AbstractC1429q f5074a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC0714e f5075b;

    public AbstractC1431s(AbstractC1429q abstractC1429q, InterfaceC0714e interfaceC0714e) {
        this.f5074a = abstractC1429q;
        this.f5075b = interfaceC0714e;
    }

    @Override // p100g1.AbstractC1399h
    /* JADX INFO: renamed from: b */
    public String mo3101b() {
        return null;
    }

    @Override // p100g1.AbstractC1399h
    /* JADX INFO: renamed from: e */
    public C0672b mo3103e(AbstractC0540h abstractC0540h, C0672b c0672b) throws C0538f {
        if (c0672b.f1825c == null) {
            Object obj = c0672b.f1823a;
            Class cls = c0672b.f1824b;
            AbstractC1429q abstractC1429q = this.f5074a;
            c0672b.f1825c = cls == null ? abstractC1429q.mo3428b(obj) : abstractC1429q.mo3429c(obj, cls);
        }
        if (c0672b.f1825c == null) {
            return null;
        }
        abstractC0540h.m1127T(c0672b);
        return c0672b;
    }

    @Override // p100g1.AbstractC1399h
    /* JADX INFO: renamed from: f */
    public C0672b mo3104f(AbstractC0540h abstractC0540h, C0672b c0672b) {
        if (c0672b == null) {
            return null;
        }
        abstractC0540h.m1128U(c0672b);
        return c0672b;
    }
}
