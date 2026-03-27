package com.fasterxml.jackson.databind.deser.std;

import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.C0717h;
import p100g1.AbstractC1398g;

/* JADX INFO: loaded from: classes.dex */
public class NullifyingDeserializer extends StdDeserializer<Object> {
    public static final NullifyingDeserializer instance = new NullifyingDeserializer();
    private static final long serialVersionUID = 1;

    public NullifyingDeserializer() {
        super((Class<?>) Object.class);
    }

    @Override // p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        if (!abstractC0545m.mo1168M(EnumC0548p.FIELD_NAME)) {
            abstractC0545m.mo1187c0();
            return null;
        }
        while (true) {
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            if (enumC0548pMo1177V == null || enumC0548pMo1177V == EnumC0548p.END_OBJECT) {
                return null;
            }
            abstractC0545m.mo1187c0();
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        int iMo1191f = abstractC0545m.mo1191f();
        if (iMo1191f == 1 || iMo1191f == 3 || iMo1191f == 5) {
            return abstractC1398g.mo3400b(abstractC0545m, abstractC0718i);
        }
        return null;
    }

    @Override // p069X0.AbstractC0722m
    public Boolean supportsUpdate(C0717h c0717h) {
        return Boolean.FALSE;
    }
}
