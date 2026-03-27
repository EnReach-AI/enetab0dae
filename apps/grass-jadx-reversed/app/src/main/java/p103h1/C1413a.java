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

/* JADX INFO: renamed from: h1.a */
/* JADX INFO: loaded from: classes.dex */
public class C1413a extends AbstractC1428p {
    private static final long serialVersionUID = 1;

    @Override // p100g1.AbstractC1398g
    /* JADX INFO: renamed from: b */
    public Object mo3400b(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return m3421k(abstractC0545m, abstractC0718i);
    }

    @Override // p100g1.AbstractC1398g
    /* JADX INFO: renamed from: c */
    public final Object mo3401c(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return m3421k(abstractC0545m, abstractC0718i);
    }

    @Override // p100g1.AbstractC1398g
    /* JADX INFO: renamed from: d */
    public Object mo3402d(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return m3421k(abstractC0545m, abstractC0718i);
    }

    @Override // p100g1.AbstractC1398g
    /* JADX INFO: renamed from: e */
    public final Object mo3403e(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return m3421k(abstractC0545m, abstractC0718i);
    }

    @Override // p100g1.AbstractC1398g
    /* JADX INFO: renamed from: f */
    public AbstractC1398g mo3404f(InterfaceC0714e interfaceC0714e) {
        return interfaceC0714e == this.f5062g ? this : new C1413a(this, interfaceC0714e);
    }

    @Override // p100g1.AbstractC1398g
    /* JADX INFO: renamed from: g */
    public EnumC0471T mo3405g() {
        return EnumC0471T.f1109g;
    }

    /* JADX INFO: renamed from: k */
    public final Object m3421k(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b, C0538f {
        String strMo1157B;
        Object objMo1162G;
        if (abstractC0545m.mo1184b() && (objMo1162G = abstractC0545m.mo1162G()) != null) {
            return m3439h(abstractC0545m, abstractC0718i, objMo1162G);
        }
        boolean zMo1172Q = abstractC0545m.mo1172Q();
        boolean zMo1172Q2 = abstractC0545m.mo1172Q();
        AbstractC0721l abstractC0721l = this.f5061f;
        if (zMo1172Q2) {
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            EnumC0548p enumC0548p = EnumC0548p.VALUE_STRING;
            if (enumC0548pMo1177V != enumC0548p && (enumC0548pMo1177V == null || !enumC0548pMo1177V.f1332l)) {
                abstractC0718i.m1843V(enumC0548p, "need String, Number of Boolean value that contains type id (for subtype of %s)", abstractC0721l.f2036e.getName());
                throw null;
            }
            strMo1157B = abstractC0545m.mo1157B();
            abstractC0545m.mo1177V();
        } else {
            if (this.f5063h == null) {
                abstractC0718i.m1843V(EnumC0548p.START_ARRAY, "need Array value to contain `As.WRAPPER_ARRAY` type information for class ".concat(abstractC0721l.f2036e.getName()), new Object[0]);
                throw null;
            }
            AbstractC1429q abstractC1429q = this.f5060e;
            strMo1157B = abstractC1429q.mo3429c(null, abstractC1429q.f5069b.f2036e);
        }
        AbstractC0722m abstractC0722mM3441j = m3441j(abstractC0718i, strMo1157B);
        if (this.f5065j && !(this instanceof C1417e) && abstractC0545m.mo1168M(EnumC0548p.START_OBJECT)) {
            C1730E c1730eM1847l = abstractC0718i.m1847l(abstractC0545m);
            c1730eM1847l.mo1120M();
            c1730eM1847l.mo1145r(this.f5064i);
            c1730eM1847l.mo1125R(strMo1157B);
            abstractC0545m.mo1186c();
            abstractC0545m = C0686m.m1645f0(c1730eM1847l.m3860e0(abstractC0545m), abstractC0545m);
            abstractC0545m.mo1177V();
        }
        if (zMo1172Q && abstractC0545m.mo1190e() == EnumC0548p.END_ARRAY) {
            return abstractC0722mM3441j.getNullValue(abstractC0718i);
        }
        Object objDeserialize = abstractC0722mM3441j.deserialize(abstractC0545m, abstractC0718i);
        if (zMo1172Q) {
            EnumC0548p enumC0548pMo1177V2 = abstractC0545m.mo1177V();
            EnumC0548p enumC0548p2 = EnumC0548p.END_ARRAY;
            if (enumC0548pMo1177V2 != enumC0548p2) {
                abstractC0718i.m1843V(enumC0548p2, "expected closing `JsonToken.END_ARRAY` after type information and deserialized value", new Object[0]);
                throw null;
            }
        }
        return objDeserialize;
    }
}
