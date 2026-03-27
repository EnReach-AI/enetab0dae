package p103h1;

import p001A.C0009j;
import p005B.AbstractC0032g;
import p039M0.EnumC0471T;
import p042N0.AbstractC0545m;
import p042N0.C0538f;
import p042N0.EnumC0548p;
import p066W0.C0686m;
import p069X0.AbstractC0715f;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.EnumC0719j;
import p069X0.EnumC0731v;
import p069X0.InterfaceC0714e;
import p078a1.C0853e;
import p100g1.AbstractC1398g;
import p118m1.C1730E;

/* JADX INFO: renamed from: h1.g */
/* JADX INFO: loaded from: classes.dex */
public class C1419g extends C1413a {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: m */
    public final EnumC0471T f5044m;

    /* JADX INFO: renamed from: n */
    public final boolean f5045n;

    /* JADX INFO: renamed from: o */
    public final String f5046o;

    public C1419g(AbstractC0721l abstractC0721l, AbstractC1429q abstractC1429q, String str, boolean z3, AbstractC0721l abstractC0721l2, EnumC0471T enumC0471T, boolean z4) {
        super(abstractC0721l, abstractC1429q, str, z3, abstractC0721l2);
        this.f5046o = AbstractC0032g.m154l("missing type id property '", this.f5064i, "'");
        this.f5044m = enumC0471T;
        this.f5045n = z4;
    }

    @Override // p103h1.C1413a, p100g1.AbstractC1398g
    /* JADX INFO: renamed from: b */
    public final Object mo3400b(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return abstractC0545m.mo1168M(EnumC0548p.START_ARRAY) ? m3421k(abstractC0545m, abstractC0718i) : mo3402d(abstractC0545m, abstractC0718i);
    }

    @Override // p103h1.C1413a, p100g1.AbstractC1398g
    /* JADX INFO: renamed from: d */
    public Object mo3402d(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0538f {
        String strMo1165J;
        Object objMo1162G;
        if (abstractC0545m.mo1184b() && (objMo1162G = abstractC0545m.mo1162G()) != null) {
            return m3439h(abstractC0545m, abstractC0718i, objMo1162G);
        }
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        EnumC0548p enumC0548p = EnumC0548p.START_OBJECT;
        String str = this.f5046o;
        C1730E c1730eM1847l = null;
        if (enumC0548pMo1190e == enumC0548p) {
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        } else if (enumC0548pMo1190e != EnumC0548p.FIELD_NAME) {
            return m3425m(abstractC0545m, abstractC0718i, null, str);
        }
        boolean zM2157l = abstractC0718i.f1998g.m2157l(EnumC0731v.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        while (enumC0548pMo1190e == EnumC0548p.FIELD_NAME) {
            String strMo1188d = abstractC0545m.mo1188d();
            abstractC0545m.mo1177V();
            String str2 = this.f5064i;
            if ((strMo1188d.equals(str2) || (zM2157l && strMo1188d.equalsIgnoreCase(str2))) && (strMo1165J = abstractC0545m.mo1165J()) != null) {
                return m3424l(abstractC0545m, abstractC0718i, c1730eM1847l, strMo1165J);
            }
            if (c1730eM1847l == null) {
                c1730eM1847l = abstractC0718i.m1847l(abstractC0545m);
            }
            c1730eM1847l.mo1145r(strMo1188d);
            c1730eM1847l.m3862g0(abstractC0545m);
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        }
        return m3425m(abstractC0545m, abstractC0718i, c1730eM1847l, str);
    }

    @Override // p103h1.C1413a, p100g1.AbstractC1398g
    /* JADX INFO: renamed from: f */
    public AbstractC1398g mo3404f(InterfaceC0714e interfaceC0714e) {
        return interfaceC0714e == this.f5062g ? this : new C1419g(this, interfaceC0714e);
    }

    @Override // p103h1.C1413a, p100g1.AbstractC1398g
    /* JADX INFO: renamed from: g */
    public final EnumC0471T mo3405g() {
        return this.f5044m;
    }

    /* JADX INFO: renamed from: l */
    public final Object m3424l(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, C1730E c1730e, String str) throws C0853e, C0538f {
        AbstractC0722m abstractC0722mM3441j = m3441j(abstractC0718i, str);
        if (this.f5065j) {
            if (c1730e == null) {
                c1730e = abstractC0718i.m1847l(abstractC0545m);
            }
            c1730e.mo1145r(abstractC0545m.mo1188d());
            c1730e.mo1125R(str);
        }
        if (c1730e != null) {
            abstractC0545m.mo1186c();
            abstractC0545m = C0686m.m1645f0(c1730e.m3860e0(abstractC0545m), abstractC0545m);
        }
        if (abstractC0545m.mo1190e() != EnumC0548p.END_OBJECT) {
            abstractC0545m.mo1177V();
        }
        return abstractC0722mM3441j.deserialize(abstractC0545m, abstractC0718i);
    }

    /* JADX INFO: renamed from: m */
    public final Object m3425m(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, C1730E c1730e, String str) throws C0853e {
        boolean z3 = this.f5063h != null;
        AbstractC0721l abstractC0721l = this.f5061f;
        if (!z3) {
            Object objM3399a = AbstractC1398g.m3399a(abstractC0545m, abstractC0721l);
            if (objM3399a != null) {
                return objM3399a;
            }
            if (abstractC0545m.mo1172Q()) {
                return m3421k(abstractC0545m, abstractC0718i);
            }
            if (abstractC0545m.mo1168M(EnumC0548p.VALUE_STRING) && abstractC0718i.m1833K(EnumC0719j.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && abstractC0545m.mo1157B().trim().isEmpty()) {
                return null;
            }
        }
        AbstractC0722m abstractC0722mM3440i = m3440i(abstractC0718i);
        if (abstractC0722mM3440i == null) {
            if (this.f5045n) {
                C0009j c0009j = abstractC0718i.f1998g.f1987q;
                if (c0009j == null) {
                    throw new C0853e(abstractC0718i.f2002k, AbstractC0715f.m1809a(String.format("Could not resolve subtype of %s", abstractC0721l), str));
                }
                AbstractC0032g.m162t(c0009j.f30f);
                throw null;
            }
            if (abstractC0721l == null) {
                return null;
            }
            abstractC0722mM3440i = abstractC0718i.m1852q(abstractC0721l, this.f5062g);
        }
        if (c1730e != null) {
            c1730e.mo1143p();
            abstractC0545m = c1730e.m3860e0(abstractC0545m);
            abstractC0545m.mo1177V();
        }
        return abstractC0722mM3440i.deserialize(abstractC0545m, abstractC0718i);
    }

    public C1419g(C1419g c1419g, InterfaceC0714e interfaceC0714e) {
        String strM156n;
        super(c1419g, interfaceC0714e);
        InterfaceC0714e interfaceC0714e2 = this.f5062g;
        if (interfaceC0714e2 == null) {
            strM156n = AbstractC0032g.m154l("missing type id property '", this.f5064i, "'");
        } else {
            strM156n = AbstractC0032g.m156n("missing type id property '", this.f5064i, "' (for POJO property '", interfaceC0714e2.mo1808f(), "')");
        }
        this.f5046o = strM156n;
        this.f5044m = c1419g.f5044m;
        this.f5045n = c1419g.f5045n;
    }
}
