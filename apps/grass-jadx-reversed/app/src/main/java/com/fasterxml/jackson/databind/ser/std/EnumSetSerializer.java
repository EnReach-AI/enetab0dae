package com.fasterxml.jackson.databind.ser.std;

import java.util.EnumSet;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0728s;
import p069X0.InterfaceC0714e;
import p100g1.AbstractC1399h;

/* JADX INFO: loaded from: classes.dex */
public class EnumSetSerializer extends AsArraySerializerBase<EnumSet<? extends Enum<?>>> {
    public EnumSetSerializer(AbstractC0721l abstractC0721l) {
        super((Class<?>) EnumSet.class, abstractC0721l, true, (AbstractC1399h) null, (AbstractC0728s) null);
    }

    public EnumSetSerializer(EnumSetSerializer enumSetSerializer, InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, Boolean bool) {
        super(enumSetSerializer, interfaceC0714e, abstractC1399h, abstractC0728s, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public EnumSetSerializer _withValueTypeSerializer(AbstractC1399h abstractC1399h) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(EnumSet<? extends Enum<?>> enumSet) {
        return enumSet.size() == 1;
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, EnumSet<? extends Enum<?>> enumSet) {
        return enumSet.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if (r2._unwrapSingle == java.lang.Boolean.TRUE) goto L10;
     */
    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void serialize(java.util.EnumSet<? extends java.lang.Enum<?>> r3, p042N0.AbstractC0540h r4, p069X0.AbstractC0709K r5) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.EnumSetSerializer.serialize(java.util.EnumSet, N0.h, X0.K):void");
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    public void serializeContents(EnumSet<? extends Enum<?>> enumSet, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        AbstractC0728s abstractC0728sM1721s = this._elementSerializer;
        for (Enum<?> r12 : enumSet) {
            if (abstractC0728sM1721s == null) {
                abstractC0728sM1721s = abstractC0709K.m1721s(r12.getDeclaringClass(), this._property);
            }
            abstractC0728sM1721s.serialize(r12, abstractC0540h, abstractC0709K);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase
    /* JADX INFO: renamed from: withResolved, reason: avoid collision after fix types in other method */
    public AsArraySerializerBase<EnumSet<? extends Enum<?>>> withResolved2(InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, Boolean bool) {
        return new EnumSetSerializer(this, interfaceC0714e, abstractC1399h, abstractC0728s, bool);
    }
}
