package com.fasterxml.jackson.databind.ser.impl;

import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0728s;
import p069X0.InterfaceC0714e;
import p100g1.AbstractC1399h;
import p112k1.InterfaceC1638f;

/* JADX INFO: loaded from: classes.dex */
public final class TypeWrappedSerializer extends AbstractC0728s implements InterfaceC1638f {
    protected final AbstractC0728s _serializer;
    protected final AbstractC1399h _typeSerializer;

    public TypeWrappedSerializer(AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s) {
        this._typeSerializer = abstractC1399h;
        this._serializer = abstractC0728s;
    }

    @Override // p112k1.InterfaceC1638f
    public AbstractC0728s createContextual(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e) {
        AbstractC0728s abstractC0728sM1704D = this._serializer;
        if (abstractC0728sM1704D instanceof InterfaceC1638f) {
            abstractC0728sM1704D = abstractC0709K.m1704D(abstractC0728sM1704D, interfaceC0714e);
        }
        return abstractC0728sM1704D == this._serializer ? this : new TypeWrappedSerializer(this._typeSerializer, abstractC0728sM1704D);
    }

    @Override // p069X0.AbstractC0728s
    public Class<Object> handledType() {
        return Object.class;
    }

    @Override // p069X0.AbstractC0728s
    public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        this._serializer.serializeWithType(obj, abstractC0540h, abstractC0709K, this._typeSerializer);
    }

    @Override // p069X0.AbstractC0728s
    public void serializeWithType(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
        this._serializer.serializeWithType(obj, abstractC0540h, abstractC0709K, abstractC1399h);
    }

    public AbstractC1399h typeSerializer() {
        return this._typeSerializer;
    }

    public AbstractC0728s valueSerializer() {
        return this._serializer;
    }
}
