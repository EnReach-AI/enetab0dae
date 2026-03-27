package p109j1;

import java.io.IOException;
import java.io.Serializable;
import p042N0.AbstractC0540h;
import p042N0.AbstractC0546n;
import p042N0.EnumC0544l;
import p050Q0.C0596i;
import p066W0.C0690q;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0725p;
import p069X0.C0701C;
import p069X0.C0724o;

/* JADX INFO: renamed from: j1.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1494b extends AbstractC0725p implements Serializable {
    private static final long serialVersionUID = 1;

    @Override // p042N0.InterfaceC0557y
    /* JADX INFO: renamed from: a */
    public EnumC0544l mo1239a() {
        return null;
    }

    @Override // p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: c */
    public abstract void mo1909c(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K);

    public final String toString() {
        try {
            C0701C c0701c = AbstractC1504l.f5448b;
            C1503k c1503k = new C1503k(this);
            c0701c.getClass();
            C0596i c0596i = new C0596i(c0701c.f1913h.m1095l());
            try {
                c0701c.m1682a(c0701c.m1683b(c0596i), c1503k);
                C0690q c0690q = c0596i.f1529e;
                String strM1655h = c0690q.m1655h();
                c0690q.m1661n();
                return strM1655h;
            } catch (AbstractC0546n e3) {
                throw e3;
            } catch (IOException e4) {
                throw C0724o.m1893f(e4);
            }
        } catch (IOException e5) {
            throw new RuntimeException(e5);
        }
    }

    public Object writeReplace() {
        try {
            byte[] bArrM3550b = AbstractC1504l.m3550b(this);
            C1511s c1511s = new C1511s();
            c1511s.f5462e = bArrM3550b;
            return c1511s;
        } catch (IOException e3) {
            throw new IllegalArgumentException("Failed to JDK serialize `" + getClass().getSimpleName() + "` value: " + e3.getMessage(), e3);
        }
    }
}
