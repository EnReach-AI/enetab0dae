package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.impl.AbstractC1223k;
import com.fasterxml.jackson.databind.ser.impl.C1219g;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import p001A.C0009j;
import p033K0.AbstractC0405c;
import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.AbstractC0728s;
import p069X0.EnumC0708J;
import p069X0.InterfaceC0714e;
import p092e1.InterfaceC1338c;
import p100g1.AbstractC1399h;
import p109j1.C1505m;
import p109j1.C1514v;
import p112k1.InterfaceC1638f;

/* JADX INFO: loaded from: classes.dex */
public abstract class AsArraySerializerBase<T> extends ContainerSerializer<T> implements InterfaceC1638f {
    protected AbstractC1223k _dynamicSerializers;
    protected final AbstractC0728s _elementSerializer;
    protected final AbstractC0721l _elementType;
    protected final InterfaceC0714e _property;
    protected final boolean _staticTyping;
    protected final Boolean _unwrapSingle;
    protected final AbstractC1399h _valueTypeSerializer;

    public AsArraySerializerBase(Class<?> cls, AbstractC0721l abstractC0721l, boolean z3, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s) {
        this(cls, abstractC0721l, z3, abstractC1399h, null, abstractC0728s, null);
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

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        AbstractC0728s abstractC0728s = this._elementSerializer;
        if (abstractC0728s != null || this._elementType == null) {
            visitArrayFormat(interfaceC1338c, abstractC0721l, abstractC0728s, this._elementType);
        } else {
            ((AbstractC0405c) interfaceC1338c).getClass();
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    @Override // p112k1.InterfaceC1638f
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
            X0.I r2 = r6.f1966e
            X0.b r2 = r2.m2149d()
            b1.l r3 = r7.mo1805c()
            if (r3 == 0) goto L22
            java.lang.Object r2 = r2.mo1761d(r3)
            if (r2 == 0) goto L22
            X0.s r2 = r6.mo1709I(r3, r2)
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
            X0.s r6 = r5._elementSerializer
            if (r2 != r6) goto L67
            X0.e r6 = r5._property
            if (r7 != r6) goto L67
            g1.h r6 = r5._valueTypeSerializer
            if (r6 != r0) goto L67
            java.lang.Boolean r6 = r5._unwrapSingle
            boolean r6 = java.util.Objects.equals(r6, r1)
            if (r6 != 0) goto L66
            goto L67
        L66:
            return r5
        L67:
            com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase r6 = r5.withResolved(r7, r0, r2, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase.createContextual(X0.K, X0.e):X0.s");
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public AbstractC0728s getContentSerializer() {
        return this._elementSerializer;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public AbstractC0721l getContentType() {
        return this._elementType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [X0.p] */
    /* JADX WARN: Type inference failed for: r2v3, types: [j1.v] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r5v2, types: [X0.p, j1.v] */
    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
        ?? CreateSchemaNode = createSchemaNode("array", true);
        AbstractC0728s abstractC0728s = this._elementSerializer;
        if (abstractC0728s != null) {
            ?? schema = abstractC0728s instanceof StdSerializer ? ((StdSerializer) abstractC0728s).getSchema(abstractC0709K, null) : 0;
            if (schema == 0) {
                schema = new C1514v(C1505m.f5450e);
                schema.m3556p("type", "any");
            }
            CreateSchemaNode.m3559s("items", schema);
        }
        return CreateSchemaNode;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(T t3, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        if (abstractC0709K.f1966e.m1698r(EnumC0708J.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) && hasSingleElement(t3)) {
            serializeContents(t3, abstractC0540h, abstractC0709K);
            return;
        }
        abstractC0540h.mo1118K(t3);
        serializeContents(t3, abstractC0540h, abstractC0709K);
        abstractC0540h.mo1142o();
    }

    public abstract void serializeContents(T t3, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K);

    @Override // p069X0.AbstractC0728s
    public void serializeWithType(T t3, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
        C0672b c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, abstractC1399h.m3406d(EnumC0548p.START_ARRAY, t3));
        abstractC0540h.mo1136i(t3);
        serializeContents(t3, abstractC0540h, abstractC0709K);
        abstractC1399h.mo3104f(abstractC0540h, c0672bMo3103e);
    }

    @Deprecated
    public final AsArraySerializerBase<T> withResolved(InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s) {
        return withResolved(interfaceC0714e, abstractC1399h, abstractC0728s, this._unwrapSingle);
    }

    public abstract AsArraySerializerBase<T> withResolved(InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, Boolean bool);

    @Deprecated
    public AsArraySerializerBase(Class<?> cls, AbstractC0721l abstractC0721l, boolean z3, AbstractC1399h abstractC1399h, InterfaceC0714e interfaceC0714e, AbstractC0728s abstractC0728s) {
        this(cls, abstractC0721l, z3, abstractC1399h, interfaceC0714e, abstractC0728s, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsArraySerializerBase(Class<?> cls, AbstractC0721l abstractC0721l, boolean z3, AbstractC1399h abstractC1399h, InterfaceC0714e interfaceC0714e, AbstractC0728s abstractC0728s, Boolean bool) {
        super(cls, false);
        boolean z4 = false;
        this._elementType = abstractC0721l;
        if (z3 || (abstractC0721l != null && Modifier.isFinal(abstractC0721l.f2036e.getModifiers()))) {
            z4 = true;
        }
        this._staticTyping = z4;
        this._valueTypeSerializer = abstractC1399h;
        this._property = interfaceC0714e;
        this._elementSerializer = abstractC0728s;
        this._dynamicSerializers = C1219g.f4140b;
        this._unwrapSingle = bool;
    }

    public final AbstractC0728s _findAndAddDynamic(AbstractC1223k abstractC1223k, AbstractC0721l abstractC0721l, AbstractC0709K abstractC0709K) {
        C0009j c0009jM3093a = abstractC1223k.m3093a(abstractC0709K, this._property, abstractC0721l);
        AbstractC1223k abstractC1223k2 = (AbstractC1223k) c0009jM3093a.f31g;
        if (abstractC1223k != abstractC1223k2) {
            this._dynamicSerializers = abstractC1223k2;
        }
        return (AbstractC0728s) c0009jM3093a.f30f;
    }

    public AsArraySerializerBase(AsArraySerializerBase<?> asArraySerializerBase, InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, Boolean bool) {
        super(asArraySerializerBase);
        this._elementType = asArraySerializerBase._elementType;
        this._staticTyping = asArraySerializerBase._staticTyping;
        this._valueTypeSerializer = abstractC1399h;
        this._property = interfaceC0714e;
        this._elementSerializer = abstractC0728s;
        this._dynamicSerializers = C1219g.f4140b;
        this._unwrapSingle = bool;
    }

    @Deprecated
    public AsArraySerializerBase(AsArraySerializerBase<?> asArraySerializerBase, InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s) {
        this(asArraySerializerBase, interfaceC0714e, abstractC1399h, abstractC0728s, asArraySerializerBase._unwrapSingle);
    }
}
