package com.fasterxml.jackson.databind.deser.std;

import p042N0.AbstractC0545m;
import p042N0.C0538f;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p071Y0.InterfaceC0738b;
import p078a1.C0850b;
import p114l1.EnumC1664f;
import p118m1.C1730E;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class TokenBufferDeserializer extends StdScalarDeserializer<C1730E> {
    private static final long serialVersionUID = 1;

    public TokenBufferDeserializer() {
        super((Class<?>) C1730E.class);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5893i;
    }

    @Override // p069X0.AbstractC0722m
    public C1730E deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b, C0538f {
        EnumC0548p enumC0548pMo1177V;
        C1730E c1730eM1847l = abstractC0718i.m1847l(abstractC0545m);
        if (abstractC0545m.mo1168M(EnumC0548p.FIELD_NAME)) {
            c1730eM1847l.mo1120M();
            do {
                c1730eM1847l.m3862g0(abstractC0545m);
                enumC0548pMo1177V = abstractC0545m.mo1177V();
            } while (enumC0548pMo1177V == EnumC0548p.FIELD_NAME);
            EnumC0548p enumC0548p = EnumC0548p.END_OBJECT;
            if (enumC0548pMo1177V != enumC0548p) {
                throw AbstractC0718i.m1822Z(abstractC0718i.f2002k, enumC0548p, "Expected END_OBJECT after copying contents of a JsonParser into TokenBuffer, got " + enumC0548pMo1177V);
            }
            c1730eM1847l.mo1143p();
        } else {
            c1730eM1847l.m3862g0(abstractC0545m);
        }
        return c1730eM1847l;
    }
}
