package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase;
import java.util.Iterator;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0728s;
import p069X0.InterfaceC0714e;
import p071Y0.InterfaceC0738b;
import p100g1.AbstractC1399h;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class IteratorSerializer extends AsArraySerializerBase<Iterator<?>> {
    public IteratorSerializer(AbstractC0721l abstractC0721l, boolean z3, AbstractC1399h abstractC1399h) {
        super((Class<?>) Iterator.class, abstractC0721l, z3, abstractC1399h, (AbstractC0728s) null);
    }

    public void _serializeDynamicContents(Iterator<?> it, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        AbstractC1399h abstractC1399h = this._valueTypeSerializer;
        AbstractC1223k abstractC1223k = this._dynamicSerializers;
        do {
            Object next = it.next();
            if (next == null) {
                abstractC0709K.m1719q(abstractC0540h);
            } else {
                Class<?> cls = next.getClass();
                AbstractC0728s abstractC0728sMo3092c = abstractC1223k.mo3092c(cls);
                if (abstractC0728sMo3092c == null) {
                    abstractC0728sMo3092c = this._elementType.mo1881p() ? _findAndAddDynamic(abstractC1223k, abstractC0709K.m1718p(this._elementType, cls), abstractC0709K) : _findAndAddDynamic(abstractC1223k, cls, abstractC0709K);
                    abstractC1223k = this._dynamicSerializers;
                }
                if (abstractC1399h == null) {
                    abstractC0728sMo3092c.serialize(next, abstractC0540h, abstractC0709K);
                } else {
                    abstractC0728sMo3092c.serializeWithType(next, abstractC0540h, abstractC0709K, abstractC1399h);
                }
            }
        } while (it.hasNext());
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public ContainerSerializer<?> _withValueTypeSerializer(AbstractC1399h abstractC1399h) {
        return new IteratorSerializer(this, this._property, abstractC1399h, this._elementSerializer, this._unwrapSingle);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(Iterator<?> it) {
        return false;
    }

    public IteratorSerializer(IteratorSerializer iteratorSerializer, InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, Boolean bool) {
        super(iteratorSerializer, interfaceC0714e, abstractC1399h, abstractC0728s, bool);
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, Iterator<?> it) {
        return !it.hasNext();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public final void serialize(Iterator<?> it, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        abstractC0540h.mo1118K(it);
        serializeContents(it, abstractC0540h, abstractC0709K);
        abstractC0540h.mo1142o();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public void serializeContents(Iterator<?> it, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        if (it.hasNext()) {
            AbstractC0728s abstractC0728s = this._elementSerializer;
            if (abstractC0728s == null) {
                _serializeDynamicContents(it, abstractC0540h, abstractC0709K);
                return;
            }
            AbstractC1399h abstractC1399h = this._valueTypeSerializer;
            do {
                Object next = it.next();
                if (next == null) {
                    abstractC0709K.m1719q(abstractC0540h);
                } else if (abstractC1399h == null) {
                    abstractC0728s.serialize(next, abstractC0540h, abstractC0709K);
                } else {
                    abstractC0728s.serializeWithType(next, abstractC0540h, abstractC0709K, abstractC1399h);
                }
            } while (it.hasNext());
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    /* JADX INFO: renamed from: withResolved, reason: merged with bridge method [inline-methods] */
    public AsArraySerializerBase<Iterator<?>> withResolved2(InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, Boolean bool) {
        return new IteratorSerializer(this, interfaceC0714e, abstractC1399h, abstractC0728s, bool);
    }
}
