package com.fasterxml.jackson.databind.deser.impl;

import java.io.Serializable;
import java.util.Collection;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;
import p069X0.C0717h;
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;

/* JADX INFO: loaded from: classes.dex */
public final class TypeWrappedDeserializer extends AbstractC0722m implements Serializable {
    private static final long serialVersionUID = 1;
    protected final AbstractC0722m _deserializer;
    protected final AbstractC1398g _typeDeserializer;

    public TypeWrappedDeserializer(AbstractC1398g abstractC1398g, AbstractC0722m abstractC0722m) {
        this._typeDeserializer = abstractC1398g;
        this._deserializer = abstractC0722m;
    }

    @Override // p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return this._deserializer.deserializeWithType(abstractC0545m, abstractC0718i, this._typeDeserializer);
    }

    @Override // p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        throw new IllegalStateException("Type-wrapped deserializer's deserializeWithType should never get called");
    }

    @Override // p069X0.AbstractC0722m
    public AbstractC0722m getDelegatee() {
        return this._deserializer.getDelegatee();
    }

    @Override // p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return this._deserializer.getEmptyValue(abstractC0718i);
    }

    @Override // p069X0.AbstractC0722m
    public Collection<Object> getKnownPropertyNames() {
        return this._deserializer.getKnownPropertyNames();
    }

    @Override // p069X0.AbstractC0722m, com.fasterxml.jackson.databind.deser.InterfaceC1178m
    public Object getNullValue(AbstractC0718i abstractC0718i) {
        return this._deserializer.getNullValue(abstractC0718i);
    }

    @Override // p069X0.AbstractC0722m
    public Class<?> handledType() {
        return this._deserializer.handledType();
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return this._deserializer.logicalType();
    }

    @Override // p069X0.AbstractC0722m
    public Boolean supportsUpdate(C0717h c0717h) {
        return this._deserializer.supportsUpdate(c0717h);
    }

    @Override // p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) {
        return this._deserializer.deserialize(abstractC0545m, abstractC0718i, obj);
    }
}
