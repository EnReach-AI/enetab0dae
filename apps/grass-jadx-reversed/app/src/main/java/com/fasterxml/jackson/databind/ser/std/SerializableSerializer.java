package com.fasterxml.jackson.databind.ser.std;

import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0726q;
import p069X0.InterfaceC0727r;
import p071Y0.InterfaceC0738b;
import p092e1.InterfaceC1338c;
import p100g1.AbstractC1399h;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class SerializableSerializer extends StdSerializer<InterfaceC0727r> {
    public static final SerializableSerializer instance = new SerializableSerializer();

    public SerializableSerializer() {
        super(InterfaceC0727r.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        interfaceC1338c.getClass();
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, InterfaceC0727r interfaceC0727r) {
        if (interfaceC0727r instanceof AbstractC0726q) {
            return ((AbstractC0726q) interfaceC0727r).isEmpty();
        }
        return false;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(InterfaceC0727r interfaceC0727r, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        interfaceC0727r.mo1909c(abstractC0540h, abstractC0709K);
    }

    @Override // p069X0.AbstractC0728s
    public final void serializeWithType(InterfaceC0727r interfaceC0727r, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
        interfaceC0727r.mo1908d(abstractC0540h, abstractC0709K, abstractC1399h);
    }
}
