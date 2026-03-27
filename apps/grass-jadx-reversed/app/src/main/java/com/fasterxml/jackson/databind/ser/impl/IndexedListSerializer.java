package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase;
import java.io.IOException;
import java.util.List;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0728s;
import p069X0.InterfaceC0714e;
import p071Y0.InterfaceC0738b;
import p100g1.AbstractC1399h;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public final class IndexedListSerializer extends AsArraySerializerBase<List<?>> {
    private static final long serialVersionUID = 1;

    public IndexedListSerializer(AbstractC0721l abstractC0721l, boolean z3, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s) {
        super((Class<?>) List.class, abstractC0721l, z3, abstractC1399h, abstractC0728s);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public ContainerSerializer<?> _withValueTypeSerializer(AbstractC1399h abstractC1399h) {
        return new IndexedListSerializer(this, this._property, abstractC1399h, this._elementSerializer, this._unwrapSingle);
    }

    public void serializeContentsUsing(List<?> list, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC0728s abstractC0728s) throws IOException {
        int size = list.size();
        if (size == 0) {
            return;
        }
        AbstractC1399h abstractC1399h = this._valueTypeSerializer;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj == null) {
                try {
                    abstractC0709K.m1719q(abstractC0540h);
                } catch (Exception e3) {
                    wrapAndThrow(abstractC0709K, e3, list, i3);
                }
            } else if (abstractC1399h == null) {
                abstractC0728s.serialize(obj, abstractC0540h, abstractC0709K);
            } else {
                abstractC0728s.serializeWithType(obj, abstractC0540h, abstractC0709K, abstractC1399h);
            }
        }
    }

    public void serializeTypedContents(List<?> list, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws IOException {
        int size = list.size();
        if (size == 0) {
            return;
        }
        int i3 = 0;
        try {
            AbstractC1399h abstractC1399h = this._valueTypeSerializer;
            AbstractC1223k abstractC1223k = this._dynamicSerializers;
            while (i3 < size) {
                Object obj = list.get(i3);
                if (obj == null) {
                    abstractC0709K.m1719q(abstractC0540h);
                } else {
                    Class<?> cls = obj.getClass();
                    AbstractC0728s abstractC0728sMo3092c = abstractC1223k.mo3092c(cls);
                    if (abstractC0728sMo3092c == null) {
                        abstractC0728sMo3092c = this._elementType.mo1881p() ? _findAndAddDynamic(abstractC1223k, abstractC0709K.m1718p(this._elementType, cls), abstractC0709K) : _findAndAddDynamic(abstractC1223k, cls, abstractC0709K);
                        abstractC1223k = this._dynamicSerializers;
                    }
                    abstractC0728sMo3092c.serializeWithType(obj, abstractC0540h, abstractC0709K, abstractC1399h);
                }
                i3++;
            }
        } catch (Exception e3) {
            wrapAndThrow(abstractC0709K, e3, list, i3);
        }
    }

    public IndexedListSerializer(IndexedListSerializer indexedListSerializer, InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, Boolean bool) {
        super(indexedListSerializer, interfaceC0714e, abstractC1399h, abstractC0728s, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(List<?> list) {
        return list.size() == 1;
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, List<?> list) {
        return list.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if (r2._unwrapSingle == java.lang.Boolean.TRUE) goto L10;
     */
    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void serialize(java.util.List<?> r3, p042N0.AbstractC0540h r4, p069X0.AbstractC0709K r5) throws java.io.IOException {
        /*
            r2 = this;
            int r0 = r3.size()
            r1 = 1
            if (r0 != r1) goto L1f
            java.lang.Boolean r0 = r2._unwrapSingle
            if (r0 != 0) goto L15
            X0.J r0 = p069X0.EnumC0708J.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            X0.I r1 = r5.f1966e
            boolean r0 = r1.m1698r(r0)
            if (r0 != 0) goto L1b
        L15:
            java.lang.Boolean r0 = r2._unwrapSingle
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            if (r0 != r1) goto L1f
        L1b:
            r2.serializeContents(r3, r4, r5)
            return
        L1f:
            r4.mo1119L(r3)
            r2.serializeContents(r3, r4, r5)
            r4.mo1142o()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer.serialize(java.util.List, N0.h, X0.K):void");
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public void serializeContents(List<?> list, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws IOException {
        AbstractC0728s abstractC0728s = this._elementSerializer;
        if (abstractC0728s != null) {
            serializeContentsUsing(list, abstractC0540h, abstractC0709K, abstractC0728s);
            return;
        }
        if (this._valueTypeSerializer != null) {
            serializeTypedContents(list, abstractC0540h, abstractC0709K);
            return;
        }
        int size = list.size();
        if (size == 0) {
            return;
        }
        int i3 = 0;
        try {
            AbstractC1223k abstractC1223k = this._dynamicSerializers;
            while (i3 < size) {
                Object obj = list.get(i3);
                if (obj == null) {
                    abstractC0709K.m1719q(abstractC0540h);
                } else {
                    Class<?> cls = obj.getClass();
                    AbstractC0728s abstractC0728sMo3092c = abstractC1223k.mo3092c(cls);
                    if (abstractC0728sMo3092c == null) {
                        abstractC0728sMo3092c = this._elementType.mo1881p() ? _findAndAddDynamic(abstractC1223k, abstractC0709K.m1718p(this._elementType, cls), abstractC0709K) : _findAndAddDynamic(abstractC1223k, cls, abstractC0709K);
                        abstractC1223k = this._dynamicSerializers;
                    }
                    abstractC0728sMo3092c.serialize(obj, abstractC0540h, abstractC0709K);
                }
                i3++;
            }
        } catch (Exception e3) {
            wrapAndThrow(abstractC0709K, e3, list, i3);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    /* JADX INFO: renamed from: withResolved */
    public AsArraySerializerBase<List<?>> withResolved2(InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, Boolean bool) {
        return new IndexedListSerializer(this, interfaceC0714e, abstractC1399h, abstractC0728s, bool);
    }
}
