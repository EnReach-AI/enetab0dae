package com.fasterxml.jackson.databind.ser.std;

import java.util.concurrent.atomic.AtomicReference;
import p069X0.AbstractC0728s;
import p069X0.InterfaceC0714e;
import p100g1.AbstractC1399h;
import p114l1.C1668j;
import p118m1.AbstractC1757v;

/* JADX INFO: loaded from: classes.dex */
public class AtomicReferenceSerializer extends ReferenceTypeSerializer<AtomicReference<?>> {
    private static final long serialVersionUID = 1;

    public AtomicReferenceSerializer(C1668j c1668j, boolean z3, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s) {
        super(c1668j, z3, abstractC1399h, abstractC0728s);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ReferenceTypeSerializer
    public ReferenceTypeSerializer<AtomicReference<?>> withContentInclusion(Object obj, boolean z3) {
        return new AtomicReferenceSerializer(this, this._property, this._valueTypeSerializer, this._valueSerializer, this._unwrapper, obj, z3);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ReferenceTypeSerializer
    public ReferenceTypeSerializer<AtomicReference<?>> withResolved(InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, AbstractC1757v abstractC1757v) {
        return new AtomicReferenceSerializer(this, interfaceC0714e, abstractC1399h, abstractC0728s, abstractC1757v, this._suppressableValue, this._suppressNulls);
    }

    public AtomicReferenceSerializer(AtomicReferenceSerializer atomicReferenceSerializer, InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, AbstractC1757v abstractC1757v, Object obj, boolean z3) {
        super(atomicReferenceSerializer, interfaceC0714e, abstractC1399h, abstractC0728s, abstractC1757v, obj, z3);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ReferenceTypeSerializer
    public Object _getReferenced(AtomicReference<?> atomicReference) {
        return atomicReference.get();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ReferenceTypeSerializer
    public Object _getReferencedIfPresent(AtomicReference<?> atomicReference) {
        return atomicReference.get();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ReferenceTypeSerializer
    public boolean _isValuePresent(AtomicReference<?> atomicReference) {
        return atomicReference.get() != null;
    }
}
