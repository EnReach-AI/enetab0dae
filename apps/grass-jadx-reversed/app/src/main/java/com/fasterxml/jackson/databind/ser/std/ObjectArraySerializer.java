package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.impl.AbstractC1223k;
import com.fasterxml.jackson.databind.ser.impl.C1219g;
import java.io.IOException;
import java.util.Objects;
import p001A.C0009j;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0728s;
import p069X0.InterfaceC0714e;
import p071Y0.InterfaceC0738b;
import p092e1.InterfaceC1338c;
import p100g1.AbstractC1399h;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class ObjectArraySerializer extends ArraySerializerBase<Object[]> {
    protected AbstractC1223k _dynamicSerializers;
    protected AbstractC0728s _elementSerializer;
    protected final AbstractC0721l _elementType;
    protected final boolean _staticTyping;
    protected final AbstractC1399h _valueTypeSerializer;

    public ObjectArraySerializer(AbstractC0721l abstractC0721l, boolean z3, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s) {
        super(Object[].class);
        this._elementType = abstractC0721l;
        this._staticTyping = z3;
        this._valueTypeSerializer = abstractC1399h;
        this._dynamicSerializers = C1219g.f4140b;
        this._elementSerializer = abstractC0728s;
    }

    public final AbstractC0728s _findAndAddDynamic(AbstractC1223k abstractC1223k, Class<?> cls, AbstractC0709K abstractC0709K) {
        InterfaceC0714e interfaceC0714e = this._property;
        abstractC1223k.getClass();
        AbstractC0728s abstractC0728sM1721s = abstractC0709K.m1721s(cls, interfaceC0714e);
        AbstractC1223k abstractC1223kMo3091b = abstractC1223k.mo3091b(cls, abstractC0728sM1721s);
        if (abstractC1223k != abstractC1223kMo3091b) {
            this._dynamicSerializers = abstractC1223kMo3091b;
        }
        return abstractC0728sM1721s;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
    public AbstractC0728s _withResolved(InterfaceC0714e interfaceC0714e, Boolean bool) {
        return new ObjectArraySerializer(this, interfaceC0714e, this._valueTypeSerializer, this._elementSerializer, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public ContainerSerializer<?> _withValueTypeSerializer(AbstractC1399h abstractC1399h) {
        return new ObjectArraySerializer(this._elementType, this._staticTyping, abstractC1399h, this._elementSerializer);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        interfaceC1338c.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase, p112k1.InterfaceC1638f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p069X0.AbstractC0728s createContextual(p069X0.AbstractC0709K r6, p069X0.InterfaceC0714e r7) {
        /*
            r5 = this;
            g1.h r0 = r5._valueTypeSerializer
            if (r0 == 0) goto L8
            g1.h r0 = r0.mo3422g(r7)
        L8:
            r1 = 0
            if (r7 == 0) goto L22
            b1.l r2 = r7.mo1805c()
            X0.I r3 = r6.f1966e
            X0.b r3 = r3.m2149d()
            if (r2 == 0) goto L22
            java.lang.Object r3 = r3.mo1761d(r2)
            if (r3 == 0) goto L22
            X0.s r2 = r6.mo1709I(r2, r3)
            goto L23
        L22:
            r2 = r1
        L23:
            java.lang.Class r3 = r5.handledType()
            M0.q r3 = r5.findFormatOverrides(r6, r7, r3)
            if (r3 == 0) goto L33
            M0.n r1 = p039M0.EnumC0499n.f1151i
            java.lang.Boolean r1 = r3.m1015b(r1)
        L33:
            if (r2 != 0) goto L37
            X0.s r2 = r5._elementSerializer
        L37:
            X0.s r2 = r5.findContextualConvertingSerializer(r6, r7, r2)
            if (r2 != 0) goto L51
            X0.l r3 = r5._elementType
            if (r3 == 0) goto L51
            boolean r4 = r5._staticTyping
            if (r4 == 0) goto L51
            boolean r3 = r3.m1889x()
            if (r3 != 0) goto L51
            X0.l r2 = r5._elementType
            X0.s r2 = r6.m1720r(r2, r7)
        L51:
            com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer r6 = r5.withResolved(r7, r0, r2, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer.createContextual(X0.K, X0.e):X0.s");
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public AbstractC0728s getContentSerializer() {
        return this._elementSerializer;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public AbstractC0721l getContentType() {
        return this._elementType;
    }

    public void serializeContentsUsing(Object[] objArr, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC0728s abstractC0728s) throws IOException {
        int length = objArr.length;
        AbstractC1399h abstractC1399h = this._valueTypeSerializer;
        Object obj = null;
        for (int i3 = 0; i3 < length; i3++) {
            try {
                obj = objArr[i3];
                if (obj == null) {
                    abstractC0709K.m1719q(abstractC0540h);
                } else if (abstractC1399h == null) {
                    abstractC0728s.serialize(obj, abstractC0540h, abstractC0709K);
                } else {
                    abstractC0728s.serializeWithType(obj, abstractC0540h, abstractC0709K, abstractC1399h);
                }
            } catch (Exception e3) {
                wrapAndThrow(abstractC0709K, e3, obj, i3);
                return;
            }
        }
    }

    public void serializeTypedContents(Object[] objArr, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws IOException {
        int length = objArr.length;
        AbstractC1399h abstractC1399h = this._valueTypeSerializer;
        int i3 = 0;
        Object obj = null;
        try {
            AbstractC1223k abstractC1223k = this._dynamicSerializers;
            while (i3 < length) {
                obj = objArr[i3];
                if (obj == null) {
                    abstractC0709K.m1719q(abstractC0540h);
                } else {
                    Class<?> cls = obj.getClass();
                    AbstractC0728s abstractC0728sMo3092c = abstractC1223k.mo3092c(cls);
                    if (abstractC0728sMo3092c == null) {
                        abstractC0728sMo3092c = _findAndAddDynamic(abstractC1223k, cls, abstractC0709K);
                    }
                    abstractC0728sMo3092c.serializeWithType(obj, abstractC0540h, abstractC0709K, abstractC1399h);
                }
                i3++;
            }
        } catch (Exception e3) {
            wrapAndThrow(abstractC0709K, e3, obj, i3);
        }
    }

    public ObjectArraySerializer withResolved(InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, Boolean bool) {
        return (this._property == interfaceC0714e && abstractC0728s == this._elementSerializer && this._valueTypeSerializer == abstractC1399h && Objects.equals(this._unwrapSingle, bool)) ? this : new ObjectArraySerializer(this, interfaceC0714e, abstractC1399h, abstractC0728s, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(Object[] objArr) {
        return objArr.length == 1;
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, Object[] objArr) {
        return objArr.length == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r2._unwrapSingle == java.lang.Boolean.TRUE) goto L10;
     */
    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void serialize(java.lang.Object[] r3, p042N0.AbstractC0540h r4, p069X0.AbstractC0709K r5) throws java.io.IOException {
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
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer.serialize(java.lang.Object[], N0.h, X0.K):void");
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
    public void serializeContents(Object[] objArr, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws IOException {
        int length = objArr.length;
        if (length == 0) {
            return;
        }
        AbstractC0728s abstractC0728s = this._elementSerializer;
        if (abstractC0728s != null) {
            serializeContentsUsing(objArr, abstractC0540h, abstractC0709K, abstractC0728s);
            return;
        }
        if (this._valueTypeSerializer != null) {
            serializeTypedContents(objArr, abstractC0540h, abstractC0709K);
            return;
        }
        int i3 = 0;
        Object obj = null;
        try {
            AbstractC1223k abstractC1223k = this._dynamicSerializers;
            while (i3 < length) {
                obj = objArr[i3];
                if (obj == null) {
                    abstractC0709K.m1719q(abstractC0540h);
                } else {
                    Class<?> cls = obj.getClass();
                    AbstractC0728s abstractC0728sMo3092c = abstractC1223k.mo3092c(cls);
                    if (abstractC0728sMo3092c == null) {
                        abstractC0728sMo3092c = this._elementType.mo1881p() ? _findAndAddDynamic(abstractC1223k, abstractC0709K.m1718p(this._elementType, cls), abstractC0709K) : _findAndAddDynamic(abstractC1223k, cls, abstractC0709K);
                    }
                    abstractC0728sMo3092c.serialize(obj, abstractC0540h, abstractC0709K);
                }
                i3++;
            }
        } catch (Exception e3) {
            wrapAndThrow(abstractC0709K, e3, obj, i3);
        }
    }

    public final AbstractC0728s _findAndAddDynamic(AbstractC1223k abstractC1223k, AbstractC0721l abstractC0721l, AbstractC0709K abstractC0709K) {
        C0009j c0009jM3093a = abstractC1223k.m3093a(abstractC0709K, this._property, abstractC0721l);
        AbstractC1223k abstractC1223k2 = (AbstractC1223k) c0009jM3093a.f31g;
        if (abstractC1223k != abstractC1223k2) {
            this._dynamicSerializers = abstractC1223k2;
        }
        return (AbstractC0728s) c0009jM3093a.f30f;
    }

    public ObjectArraySerializer(ObjectArraySerializer objectArraySerializer, AbstractC1399h abstractC1399h) {
        super(objectArraySerializer);
        this._elementType = objectArraySerializer._elementType;
        this._valueTypeSerializer = abstractC1399h;
        this._staticTyping = objectArraySerializer._staticTyping;
        this._dynamicSerializers = objectArraySerializer._dynamicSerializers;
        this._elementSerializer = objectArraySerializer._elementSerializer;
    }

    public ObjectArraySerializer(ObjectArraySerializer objectArraySerializer, InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, Boolean bool) {
        super(objectArraySerializer, interfaceC0714e, bool);
        this._elementType = objectArraySerializer._elementType;
        this._valueTypeSerializer = abstractC1399h;
        this._staticTyping = objectArraySerializer._staticTyping;
        this._dynamicSerializers = C1219g.f4140b;
        this._elementSerializer = abstractC0728s;
    }
}
