package p069X0;

import java.io.Serializable;
import p039M0.C0453A;
import p039M0.C0502q;
import p074Z0.AbstractC0832r;
import p074Z0.AbstractC0833s;
import p082b1.AbstractC1041l;

/* JADX INFO: renamed from: X0.d */
/* JADX INFO: loaded from: classes.dex */
public class C0713d implements InterfaceC0714e, Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final C0703E f1981e;

    /* JADX INFO: renamed from: f */
    public final AbstractC0721l f1982f;

    /* JADX INFO: renamed from: g */
    public final C0702D f1983g;

    /* JADX INFO: renamed from: h */
    public final AbstractC1041l f1984h;

    public C0713d(C0703E c0703e, AbstractC0721l abstractC0721l, C0703E c0703e2, AbstractC1041l abstractC1041l, C0702D c0702d) {
        this.f1981e = c0703e;
        this.f1982f = abstractC0721l;
        this.f1983g = c0702d;
        this.f1984h = abstractC1041l;
    }

    @Override // p069X0.InterfaceC0714e
    /* JADX INFO: renamed from: a */
    public final C0703E mo1803a() {
        return this.f1981e;
    }

    @Override // p069X0.InterfaceC0714e
    /* JADX INFO: renamed from: b */
    public final C0702D mo1804b() {
        return this.f1983g;
    }

    @Override // p069X0.InterfaceC0714e
    /* JADX INFO: renamed from: c */
    public final AbstractC1041l mo1805c() {
        return this.f1984h;
    }

    @Override // p069X0.InterfaceC0714e
    /* JADX INFO: renamed from: d */
    public final C0502q mo1806d(AbstractC0832r abstractC0832r, Class cls) {
        AbstractC1041l abstractC1041l;
        C0502q c0502qMo1783o;
        C0502q c0502qMo2151f = abstractC0832r.mo2151f(cls);
        AbstractC0711b abstractC0711bM2149d = abstractC0832r.m2149d();
        return (abstractC0711bM2149d == null || (abstractC1041l = this.f1984h) == null || (c0502qMo1783o = abstractC0711bM2149d.mo1783o(abstractC1041l)) == null) ? c0502qMo2151f : c0502qMo2151f.m1018e(c0502qMo1783o);
    }

    @Override // p069X0.InterfaceC0714e
    /* JADX INFO: renamed from: e */
    public final C0453A mo1807e(AbstractC0832r abstractC0832r, Class cls) {
        AbstractC1041l abstractC1041l;
        AbstractC0833s abstractC0833s = (AbstractC0833s) abstractC0832r;
        abstractC0833s.mo2150e(this.f1982f.f2036e);
        abstractC0833s.mo2150e(cls);
        C0453A c0453a = abstractC0833s.f2490m.f2448f;
        if (c0453a == null) {
            c0453a = null;
        }
        C0453A c0453a2 = c0453a != null ? c0453a : null;
        AbstractC0711b abstractC0711bM2149d = abstractC0832r.m2149d();
        return (abstractC0711bM2149d == null || (abstractC1041l = this.f1984h) == null) ? c0453a2 : c0453a2.m989a(abstractC0711bM2149d.mo1739K(abstractC1041l));
    }

    @Override // p118m1.InterfaceC1758w
    /* JADX INFO: renamed from: f */
    public final String mo1808f() {
        return this.f1981e.f1928e;
    }

    @Override // p069X0.InterfaceC0714e
    public final AbstractC0721l getType() {
        return this.f1982f;
    }
}
