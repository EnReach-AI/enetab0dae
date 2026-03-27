package p082b1;

import java.io.Serializable;
import java.util.List;
import p039M0.C0453A;
import p039M0.C0502q;
import p069X0.AbstractC0711b;
import p069X0.C0702D;
import p069X0.InterfaceC0714e;
import p074Z0.AbstractC0832r;
import p074Z0.AbstractC0833s;

/* JADX INFO: renamed from: b1.F */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1010F implements InterfaceC0714e, Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final C0702D f3593e;

    /* JADX INFO: renamed from: f */
    public transient List f3594f;

    public AbstractC1010F(C0702D c0702d) {
        this.f3593e = c0702d == null ? C0702D.f1918n : c0702d;
    }

    @Override // p069X0.InterfaceC0714e
    /* JADX INFO: renamed from: b */
    public C0702D mo1804b() {
        return this.f3593e;
    }

    @Override // p069X0.InterfaceC0714e
    /* JADX INFO: renamed from: d */
    public final C0502q mo1806d(AbstractC0832r abstractC0832r, Class cls) {
        AbstractC1041l abstractC1041lMo1805c;
        C0502q c0502qMo2151f = abstractC0832r.mo2151f(cls);
        AbstractC0711b abstractC0711bM2149d = abstractC0832r.m2149d();
        C0502q c0502qMo1783o = (abstractC0711bM2149d == null || (abstractC1041lMo1805c = mo1805c()) == null) ? null : abstractC0711bM2149d.mo1783o(abstractC1041lMo1805c);
        return c0502qMo2151f == null ? c0502qMo1783o == null ? InterfaceC0714e.f1985c : c0502qMo1783o : c0502qMo1783o == null ? c0502qMo2151f : c0502qMo2151f.m1018e(c0502qMo1783o);
    }

    @Override // p069X0.InterfaceC0714e
    /* JADX INFO: renamed from: e */
    public final C0453A mo1807e(AbstractC0832r abstractC0832r, Class cls) {
        AbstractC0711b abstractC0711bM2149d = abstractC0832r.m2149d();
        AbstractC1041l abstractC1041lMo1805c = mo1805c();
        if (abstractC1041lMo1805c == null) {
            AbstractC0833s abstractC0833s = (AbstractC0833s) abstractC0832r;
            abstractC0833s.mo2150e(cls);
            C0453A c0453a = abstractC0833s.f2490m.f2448f;
            if (c0453a == null) {
                return null;
            }
            return c0453a;
        }
        AbstractC0833s abstractC0833s2 = (AbstractC0833s) abstractC0832r;
        abstractC0833s2.mo2150e(abstractC1041lMo1805c.mo2768e());
        abstractC0833s2.mo2150e(cls);
        C0453A c0453a2 = abstractC0833s2.f2490m.f2448f;
        if (c0453a2 == null) {
            c0453a2 = null;
        }
        C0453A c0453a3 = c0453a2 != null ? c0453a2 : null;
        if (abstractC0711bM2149d == null) {
            return c0453a3;
        }
        C0453A c0453aMo1739K = abstractC0711bM2149d.mo1739K(abstractC1041lMo1805c);
        return c0453a3 == null ? c0453aMo1739K : c0453a3.m989a(c0453aMo1739K);
    }

    /* JADX INFO: renamed from: g */
    public final boolean m2728g() {
        Boolean bool = this.f3593e.f1919e;
        return bool != null && bool.booleanValue();
    }

    public AbstractC1010F(AbstractC1010F abstractC1010F) {
        this.f3593e = abstractC1010F.f3593e;
    }
}
