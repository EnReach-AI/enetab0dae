package com.fasterxml.jackson.databind.ser.std;

import p042N0.AbstractC0540h;
import p042N0.EnumC0544l;
import p069X0.AbstractC0709K;
import p071Y0.InterfaceC0738b;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class NumberSerializers$FloatSerializer extends NumberSerializers$Base<Object> {
    static final NumberSerializers$FloatSerializer instance = new NumberSerializers$FloatSerializer();

    public NumberSerializers$FloatSerializer() {
        super(Float.class, EnumC0544l.f1301h, "number");
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        abstractC0540h.mo1148u(((Float) obj).floatValue());
    }
}
