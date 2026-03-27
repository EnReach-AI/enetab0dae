package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase;
import java.io.IOException;
import java.util.List;
import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0725p;
import p069X0.AbstractC0728s;
import p069X0.InterfaceC0714e;
import p071Y0.InterfaceC0738b;
import p092e1.EnumC1337b;
import p092e1.InterfaceC1336a;
import p100g1.AbstractC1399h;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public final class IndexedStringListSerializer extends StaticListSerializerBase<List<String>> {
    public static final IndexedStringListSerializer instance = new IndexedStringListSerializer();
    private static final long serialVersionUID = 1;

    public IndexedStringListSerializer() {
        super(List.class);
    }

    private final void serializeContents(List<String> list, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, int i3) throws IOException {
        for (int i4 = 0; i4 < i3; i4++) {
            try {
                String str = list.get(i4);
                if (str == null) {
                    abstractC0709K.m1719q(abstractC0540h);
                } else {
                    abstractC0540h.mo1125R(str);
                }
            } catch (Exception e3) {
                wrapAndThrow(abstractC0709K, e3, list, i4);
                return;
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase
    public AbstractC0728s _withResolved(InterfaceC0714e interfaceC0714e, Boolean bool) {
        return new IndexedStringListSerializer(this, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase
    public void acceptContentVisitor(InterfaceC1336a interfaceC1336a) {
        EnumC1337b enumC1337b = EnumC1337b.f4763e;
        interfaceC1336a.m3290a();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase
    public AbstractC0725p contentSchema() {
        return createSchemaNode("string", true);
    }

    public IndexedStringListSerializer(IndexedStringListSerializer indexedStringListSerializer, Boolean bool) {
        super(indexedStringListSerializer, bool);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if (r4._unwrapSingle == java.lang.Boolean.TRUE) goto L10;
     */
    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void serialize(java.util.List<java.lang.String> r5, p042N0.AbstractC0540h r6, p069X0.AbstractC0709K r7) throws java.io.IOException {
        /*
            r4 = this;
            int r0 = r5.size()
            r1 = 1
            if (r0 != r1) goto L1f
            java.lang.Boolean r2 = r4._unwrapSingle
            if (r2 != 0) goto L15
            X0.J r2 = p069X0.EnumC0708J.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            X0.I r3 = r7.f1966e
            boolean r2 = r3.m1698r(r2)
            if (r2 != 0) goto L1b
        L15:
            java.lang.Boolean r2 = r4._unwrapSingle
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            if (r2 != r3) goto L1f
        L1b:
            r4.serializeContents(r5, r6, r7, r1)
            return
        L1f:
            r6.mo1119L(r5)
            r4.serializeContents(r5, r6, r7, r0)
            r6.mo1142o()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.impl.IndexedStringListSerializer.serialize(java.util.List, N0.h, X0.K):void");
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase
    public void serializeWithType(List<String> list, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) throws IOException {
        C0672b c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, abstractC1399h.m3406d(EnumC0548p.START_ARRAY, list));
        abstractC0540h.mo1136i(list);
        serializeContents(list, abstractC0540h, abstractC0709K, list.size());
        abstractC1399h.mo3104f(abstractC0540h, c0672bMo3103e);
    }
}
