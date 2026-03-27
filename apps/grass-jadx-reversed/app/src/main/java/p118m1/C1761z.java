package p118m1;

import java.io.Serializable;
import p069X0.C0703E;
import p074Z0.AbstractC0832r;
import p114l1.C1660b;

/* JADX INFO: renamed from: m1.z */
/* JADX INFO: loaded from: classes.dex */
public final class C1761z implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final transient C1752q f6139e = new C1752q(20, 200);

    /* JADX INFO: renamed from: a */
    public final C0703E m3913a(AbstractC0832r abstractC0832r, Class cls) {
        C1660b c1660b = new C1660b(cls);
        C1752q c1752q = this.f6139e;
        C0703E c0703e = (C0703E) c1752q.f6129g.get(c1660b);
        if (c0703e != null) {
            return c0703e;
        }
        C0703E c0703eMo1744P = abstractC0832r.m2149d().mo1744P(abstractC0832r.m2156k(cls).f3582e);
        if (c0703eMo1744P == null || !(!c0703eMo1744P.f1928e.isEmpty())) {
            c0703eMo1744P = C0703E.m1686a(cls.getSimpleName());
        }
        c1752q.f6129g.m3120f(c1660b, c0703eMo1744P, false);
        return c0703eMo1744P;
    }

    public Object readResolve() {
        return new C1761z();
    }
}
