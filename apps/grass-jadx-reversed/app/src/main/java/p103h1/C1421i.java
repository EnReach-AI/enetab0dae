package p103h1;

import p039M0.EnumC0471T;
import p042N0.AbstractC0545m;
import p042N0.C0538f;
import p042N0.EnumC0548p;
import p066W0.C0686m;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.InterfaceC0714e;
import p078a1.C0850b;
import p100g1.AbstractC1398g;
import p118m1.C1730E;

/* JADX INFO: renamed from: h1.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1421i extends AbstractC1428p {
    private static final long serialVersionUID = 1;

    @Override // p100g1.AbstractC1398g
    /* JADX INFO: renamed from: b */
    public final Object mo3400b(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return m3426k(abstractC0545m, abstractC0718i);
    }

    @Override // p100g1.AbstractC1398g
    /* JADX INFO: renamed from: c */
    public final Object mo3401c(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return m3426k(abstractC0545m, abstractC0718i);
    }

    @Override // p100g1.AbstractC1398g
    /* JADX INFO: renamed from: d */
    public final Object mo3402d(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return m3426k(abstractC0545m, abstractC0718i);
    }

    @Override // p100g1.AbstractC1398g
    /* JADX INFO: renamed from: e */
    public final Object mo3403e(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return m3426k(abstractC0545m, abstractC0718i);
    }

    @Override // p100g1.AbstractC1398g
    /* JADX INFO: renamed from: f */
    public final AbstractC1398g mo3404f(InterfaceC0714e interfaceC0714e) {
        return interfaceC0714e == this.f5062g ? this : new C1421i(this, interfaceC0714e);
    }

    @Override // p100g1.AbstractC1398g
    /* JADX INFO: renamed from: g */
    public final EnumC0471T mo3405g() {
        return EnumC0471T.f1108f;
    }

    /* JADX INFO: renamed from: k */
    public final Object m3426k(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b, C0538f {
        Object objMo1162G;
        if (abstractC0545m.mo1184b() && (objMo1162G = abstractC0545m.mo1162G()) != null) {
            return m3439h(abstractC0545m, abstractC0718i, objMo1162G);
        }
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        EnumC0548p enumC0548p = EnumC0548p.START_OBJECT;
        AbstractC0721l abstractC0721l = this.f5061f;
        if (enumC0548pMo1190e == enumC0548p) {
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            EnumC0548p enumC0548p2 = EnumC0548p.FIELD_NAME;
            if (enumC0548pMo1177V != enumC0548p2) {
                abstractC0718i.m1843V(enumC0548p2, "need JSON String that contains type id (for subtype of " + abstractC0721l.f2036e.getName() + ")", new Object[0]);
                throw null;
            }
        } else if (enumC0548pMo1190e != EnumC0548p.FIELD_NAME) {
            abstractC0718i.m1843V(enumC0548p, "need JSON Object to contain As.WRAPPER_OBJECT type information for class ".concat(abstractC0721l.f2036e.getName()), new Object[0]);
            throw null;
        }
        String strMo1157B = abstractC0545m.mo1157B();
        AbstractC0722m abstractC0722mM3441j = m3441j(abstractC0718i, strMo1157B);
        abstractC0545m.mo1177V();
        if (this.f5065j && abstractC0545m.mo1168M(enumC0548p)) {
            C1730E c1730eM1847l = abstractC0718i.m1847l(abstractC0545m);
            c1730eM1847l.mo1120M();
            c1730eM1847l.mo1145r(this.f5064i);
            c1730eM1847l.mo1125R(strMo1157B);
            abstractC0545m.mo1186c();
            abstractC0545m = C0686m.m1645f0(c1730eM1847l.m3860e0(abstractC0545m), abstractC0545m);
            abstractC0545m.mo1177V();
        }
        Object objDeserialize = abstractC0722mM3441j.deserialize(abstractC0545m, abstractC0718i);
        EnumC0548p enumC0548pMo1177V2 = abstractC0545m.mo1177V();
        EnumC0548p enumC0548p3 = EnumC0548p.END_OBJECT;
        if (enumC0548pMo1177V2 == enumC0548p3) {
            return objDeserialize;
        }
        abstractC0718i.m1843V(enumC0548p3, "expected closing END_OBJECT after type information and deserialized value", new Object[0]);
        throw null;
    }
}
