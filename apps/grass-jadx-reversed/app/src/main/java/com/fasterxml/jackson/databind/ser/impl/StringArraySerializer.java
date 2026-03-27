package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.std.ArraySerializerBase;
import java.lang.reflect.Type;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.AbstractC0728s;
import p069X0.InterfaceC0714e;
import p071Y0.InterfaceC0738b;
import p092e1.EnumC1337b;
import p092e1.InterfaceC1338c;
import p100g1.AbstractC1399h;
import p109j1.C1514v;
import p114l1.C1675q;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class StringArraySerializer extends ArraySerializerBase<String[]> {
    private static final AbstractC0721l VALUE_TYPE;
    public static final StringArraySerializer instance;
    protected final AbstractC0728s _elementSerializer;

    static {
        C1675q.f5933h.getClass();
        VALUE_TYPE = C1675q.m3772m(String.class);
        instance = new StringArraySerializer();
    }

    public StringArraySerializer() {
        super(String[].class);
        this._elementSerializer = null;
    }

    private void serializeContentsSlow(String[] strArr, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC0728s abstractC0728s) {
        for (String str : strArr) {
            if (str == null) {
                abstractC0709K.m1719q(abstractC0540h);
            } else {
                abstractC0728s.serialize(str, abstractC0540h, abstractC0709K);
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
    public AbstractC0728s _withResolved(InterfaceC0714e interfaceC0714e, Boolean bool) {
        return new StringArraySerializer(this, interfaceC0714e, this._elementSerializer, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public ContainerSerializer<?> _withValueTypeSerializer(AbstractC1399h abstractC1399h) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        visitArrayFormat(interfaceC1338c, abstractC0721l, EnumC1337b.f4763e);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase, p112k1.InterfaceC1638f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p069X0.AbstractC0728s createContextual(p069X0.AbstractC0709K r5, p069X0.InterfaceC0714e r6) {
        /*
            r4 = this;
            r0 = 0
            if (r6 == 0) goto L1a
            X0.I r1 = r5.f1966e
            X0.b r1 = r1.m2149d()
            b1.l r2 = r6.mo1805c()
            if (r2 == 0) goto L1a
            java.lang.Object r1 = r1.mo1761d(r2)
            if (r1 == 0) goto L1a
            X0.s r1 = r5.mo1709I(r2, r1)
            goto L1b
        L1a:
            r1 = r0
        L1b:
            M0.n r2 = p039M0.EnumC0499n.f1151i
            java.lang.Class<java.lang.String[]> r3 = java.lang.String[].class
            java.lang.Boolean r2 = r4.findFormatFeature(r5, r6, r3, r2)
            if (r1 != 0) goto L27
            X0.s r1 = r4._elementSerializer
        L27:
            X0.s r1 = r4.findContextualConvertingSerializer(r5, r6, r1)
            if (r1 != 0) goto L33
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            X0.s r1 = r5.m1721s(r1, r6)
        L33:
            boolean r5 = r4.isDefaultSerializer(r1)
            if (r5 == 0) goto L3a
            goto L3b
        L3a:
            r0 = r1
        L3b:
            X0.s r5 = r4._elementSerializer
            if (r0 != r5) goto L48
            java.lang.Boolean r5 = r4._unwrapSingle
            boolean r5 = java.util.Objects.equals(r2, r5)
            if (r5 == 0) goto L48
            return r4
        L48:
            com.fasterxml.jackson.databind.ser.impl.StringArraySerializer r5 = new com.fasterxml.jackson.databind.ser.impl.StringArraySerializer
            r5.<init>(r4, r6, r0, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.impl.StringArraySerializer.createContextual(X0.K, X0.e):X0.s");
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public AbstractC0728s getContentSerializer() {
        return this._elementSerializer;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public AbstractC0721l getContentType() {
        return VALUE_TYPE;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
        C1514v c1514vCreateSchemaNode = createSchemaNode("array", true);
        c1514vCreateSchemaNode.m3559s("items", createSchemaNode("string"));
        return c1514vCreateSchemaNode;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(String[] strArr) {
        return strArr.length == 1;
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, String[] strArr) {
        return strArr.length == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r2._unwrapSingle == java.lang.Boolean.TRUE) goto L10;
     */
    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void serialize(java.lang.String[] r3, p042N0.AbstractC0540h r4, p069X0.AbstractC0709K r5) {
        /*
            r2 = this;
            int r0 = r3.length
            r1 = 1
            if (r0 != r1) goto L1c
            java.lang.Boolean r0 = r2._unwrapSingle
            if (r0 != 0) goto L12
            X0.J r0 = p069X0.EnumC0708J.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            X0.I r1 = r5.f1966e
            boolean r0 = r1.m1698r(r0)
            if (r0 != 0) goto L18
        L12:
            java.lang.Boolean r0 = r2._unwrapSingle
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            if (r0 != r1) goto L1c
        L18:
            r2.serializeContents(r3, r4, r5)
            return
        L1c:
            r4.mo1119L(r3)
            r2.serializeContents(r3, r4, r5)
            r4.mo1142o()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.impl.StringArraySerializer.serialize(java.lang.String[], N0.h, X0.K):void");
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
    public void serializeContents(String[] strArr, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        if (strArr.length == 0) {
            return;
        }
        AbstractC0728s abstractC0728s = this._elementSerializer;
        if (abstractC0728s != null) {
            serializeContentsSlow(strArr, abstractC0540h, abstractC0709K, abstractC0728s);
            return;
        }
        for (String str : strArr) {
            if (str == null) {
                abstractC0540h.mo1146s();
            } else {
                abstractC0540h.mo1125R(str);
            }
        }
    }

    public StringArraySerializer(StringArraySerializer stringArraySerializer, InterfaceC0714e interfaceC0714e, AbstractC0728s abstractC0728s, Boolean bool) {
        super(stringArraySerializer, interfaceC0714e, bool);
        this._elementSerializer = abstractC0728s;
    }
}
