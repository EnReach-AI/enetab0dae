package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.ser.ContainerSerializer;
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
public class IterableSerializer extends AsArraySerializerBase<Iterable<?>> {
    public IterableSerializer(AbstractC0721l abstractC0721l, boolean z3, AbstractC1399h abstractC1399h) {
        super((Class<?>) Iterable.class, abstractC0721l, z3, abstractC1399h, (AbstractC0728s) null);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public ContainerSerializer<?> _withValueTypeSerializer(AbstractC1399h abstractC1399h) {
        return new IterableSerializer(this, this._property, abstractC1399h, this._elementSerializer, this._unwrapSingle);
    }

    public IterableSerializer(IterableSerializer iterableSerializer, InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, Boolean bool) {
        super(iterableSerializer, interfaceC0714e, abstractC1399h, abstractC0728s, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(Iterable<?> iterable) {
        if (iterable == null) {
            return false;
        }
        Iterator<?> it = iterable.iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next();
        return !it.hasNext();
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, Iterable<?> iterable) {
        return !iterable.iterator().hasNext();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void serialize(java.lang.Iterable<?> r3, p042N0.AbstractC0540h r4, p069X0.AbstractC0709K r5) {
        /*
            r2 = this;
            java.lang.Boolean r0 = r2._unwrapSingle
            if (r0 != 0) goto Le
            X0.J r0 = p069X0.EnumC0708J.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            X0.I r1 = r5.f1966e
            boolean r0 = r1.m1698r(r0)
            if (r0 != 0) goto L14
        Le:
            java.lang.Boolean r0 = r2._unwrapSingle
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            if (r0 != r1) goto L1e
        L14:
            boolean r0 = r2.hasSingleElement(r3)
            if (r0 == 0) goto L1e
            r2.serializeContents(r3, r4, r5)
            return
        L1e:
            r4.mo1118K(r3)
            r2.serializeContents(r3, r4, r5)
            r4.mo1142o()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.IterableSerializer.serialize(java.lang.Iterable, N0.h, X0.K):void");
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public void serializeContents(Iterable<?> iterable, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        AbstractC0728s abstractC0728s;
        Iterator<?> it = iterable.iterator();
        if (it.hasNext()) {
            AbstractC1399h abstractC1399h = this._valueTypeSerializer;
            Class<?> cls = null;
            AbstractC0728s abstractC0728sM1728z = null;
            do {
                Object next = it.next();
                if (next == null) {
                    abstractC0709K.m1719q(abstractC0540h);
                } else {
                    AbstractC0728s abstractC0728s2 = this._elementSerializer;
                    if (abstractC0728s2 == null) {
                        Class<?> cls2 = next.getClass();
                        if (cls2 != cls) {
                            abstractC0728sM1728z = abstractC0709K.m1728z(cls2, this._property);
                            cls = cls2;
                        }
                        abstractC0728s = abstractC0728sM1728z;
                    } else {
                        abstractC0728s = abstractC0728sM1728z;
                        abstractC0728sM1728z = abstractC0728s2;
                    }
                    if (abstractC1399h == null) {
                        abstractC0728sM1728z.serialize(next, abstractC0540h, abstractC0709K);
                    } else {
                        abstractC0728sM1728z.serializeWithType(next, abstractC0540h, abstractC0709K, abstractC1399h);
                    }
                    abstractC0728sM1728z = abstractC0728s;
                }
            } while (it.hasNext());
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    /* JADX INFO: renamed from: withResolved, reason: avoid collision after fix types in other method */
    public AsArraySerializerBase<Iterable<?>> withResolved2(InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, Boolean bool) {
        return new IterableSerializer(this, interfaceC0714e, abstractC1399h, abstractC0728s, bool);
    }
}
