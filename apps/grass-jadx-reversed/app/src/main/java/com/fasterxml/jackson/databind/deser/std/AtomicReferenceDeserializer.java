package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.AbstractC1208x;
import java.util.concurrent.atomic.AtomicReference;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.C0717h;
import p100g1.AbstractC1398g;

/* JADX INFO: loaded from: classes.dex */
public class AtomicReferenceDeserializer extends ReferenceTypeDeserializer<AtomicReference<Object>> {
    private static final long serialVersionUID = 1;

    public AtomicReferenceDeserializer(AbstractC0721l abstractC0721l, AbstractC1208x abstractC1208x, AbstractC1398g abstractC1398g, AbstractC0722m abstractC0722m) {
        super(abstractC0721l, abstractC1208x, abstractC1398g, abstractC0722m);
    }

    @Override // p069X0.AbstractC0722m, com.fasterxml.jackson.databind.deser.InterfaceC1178m
    public Object getAbsentValue(AbstractC0718i abstractC0718i) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ReferenceTypeDeserializer, p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return getNullValue(abstractC0718i);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ReferenceTypeDeserializer, p069X0.AbstractC0722m
    public Boolean supportsUpdate(C0717h c0717h) {
        return Boolean.TRUE;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ReferenceTypeDeserializer, p069X0.AbstractC0722m, com.fasterxml.jackson.databind.deser.InterfaceC1178m
    public AtomicReference<Object> getNullValue(AbstractC0718i abstractC0718i) {
        return new AtomicReference<>(this._valueDeserializer.getNullValue(abstractC0718i));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ReferenceTypeDeserializer
    public Object getReferenced(AtomicReference<Object> atomicReference) {
        return atomicReference.get();
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ReferenceTypeDeserializer
    public AtomicReference<Object> referenceValue(Object obj) {
        return new AtomicReference<>(obj);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ReferenceTypeDeserializer
    public AtomicReference<Object> updateReference(AtomicReference<Object> atomicReference, Object obj) {
        atomicReference.set(obj);
        return atomicReference;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ReferenceTypeDeserializer
    /* JADX INFO: renamed from: withResolved, reason: merged with bridge method [inline-methods] */
    public ReferenceTypeDeserializer<AtomicReference<Object>> withResolved2(AbstractC1398g abstractC1398g, AbstractC0722m abstractC0722m) {
        return new AtomicReferenceDeserializer(this._fullType, this._valueInstantiator, abstractC1398g, abstractC0722m);
    }
}
