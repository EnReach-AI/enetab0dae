package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import java.io.IOException;
import java.util.Map;
import p001A.C0009j;
import p039M0.EnumC0511z;
import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0728s;
import p069X0.C0724o;
import p069X0.InterfaceC0714e;
import p071Y0.InterfaceC0738b;
import p100g1.AbstractC1399h;
import p112k1.InterfaceC1638f;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class MapEntrySerializer extends ContainerSerializer<Map.Entry<?, ?>> implements InterfaceC1638f {
    public static final Object MARKER_FOR_EMPTY = EnumC0511z.f1184g;
    protected AbstractC1223k _dynamicValueSerializers;
    protected final AbstractC0721l _entryType;
    protected AbstractC0728s _keySerializer;
    protected final AbstractC0721l _keyType;
    protected final InterfaceC0714e _property;
    protected final boolean _suppressNulls;
    protected final Object _suppressableValue;
    protected AbstractC0728s _valueSerializer;
    protected final AbstractC0721l _valueType;
    protected final boolean _valueTypeIsStatic;
    protected final AbstractC1399h _valueTypeSerializer;

    public MapEntrySerializer(AbstractC0721l abstractC0721l, AbstractC0721l abstractC0721l2, AbstractC0721l abstractC0721l3, boolean z3, AbstractC1399h abstractC1399h, InterfaceC0714e interfaceC0714e) {
        super(abstractC0721l);
        this._entryType = abstractC0721l;
        this._keyType = abstractC0721l2;
        this._valueType = abstractC0721l3;
        this._valueTypeIsStatic = z3;
        this._valueTypeSerializer = abstractC1399h;
        this._property = interfaceC0714e;
        this._dynamicValueSerializers = C1219g.f4140b;
        this._suppressableValue = null;
        this._suppressNulls = false;
    }

    public final AbstractC0728s _findAndAddDynamic(AbstractC1223k abstractC1223k, Class<?> cls, AbstractC0709K abstractC0709K) {
        InterfaceC0714e interfaceC0714e = this._property;
        abstractC1223k.getClass();
        AbstractC0728s abstractC0728sM1721s = abstractC0709K.m1721s(cls, interfaceC0714e);
        AbstractC1223k abstractC1223kMo3091b = abstractC1223k.mo3091b(cls, abstractC0728sM1721s);
        if (abstractC1223k != abstractC1223kMo3091b) {
            this._dynamicValueSerializers = abstractC1223kMo3091b;
        }
        return abstractC0728sM1721s;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public ContainerSerializer<?> _withValueTypeSerializer(AbstractC1399h abstractC1399h) {
        return new MapEntrySerializer(this, this._property, abstractC1399h, this._keySerializer, this._valueSerializer, this._suppressableValue, this._suppressNulls);
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00be  */
    @Override // p112k1.InterfaceC1638f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p069X0.AbstractC0728s createContextual(p069X0.AbstractC0709K r11, p069X0.InterfaceC0714e r12) {
        /*
            r10 = this;
            X0.I r0 = r11.f1966e
            X0.b r0 = r0.m2149d()
            r1 = 0
            if (r12 != 0) goto Lb
            r2 = r1
            goto Lf
        Lb:
            b1.l r2 = r12.mo1805c()
        Lf:
            if (r2 == 0) goto L2c
            if (r0 == 0) goto L2c
            java.lang.Object r3 = r0.mo1792t(r2)
            if (r3 == 0) goto L1e
            X0.s r3 = r11.mo1709I(r2, r3)
            goto L1f
        L1e:
            r3 = r1
        L1f:
            java.lang.Object r0 = r0.mo1761d(r2)
            if (r0 == 0) goto L2a
            X0.s r0 = r11.mo1709I(r2, r0)
            goto L2e
        L2a:
            r0 = r1
            goto L2e
        L2c:
            r0 = r1
            r3 = r0
        L2e:
            if (r0 != 0) goto L32
            X0.s r0 = r10._valueSerializer
        L32:
            X0.s r0 = r10.findContextualConvertingSerializer(r11, r12, r0)
            if (r0 != 0) goto L4a
            boolean r2 = r10._valueTypeIsStatic
            if (r2 == 0) goto L4a
            X0.l r2 = r10._valueType
            boolean r2 = r2.m1889x()
            if (r2 != 0) goto L4a
            X0.l r0 = r10._valueType
            X0.s r0 = r11.m1720r(r0, r12)
        L4a:
            r7 = r0
            if (r3 != 0) goto L4f
            X0.s r3 = r10._keySerializer
        L4f:
            if (r3 != 0) goto L59
            X0.l r0 = r10._keyType
            X0.s r0 = r11.m1722t(r0, r12)
        L57:
            r6 = r0
            goto L5e
        L59:
            X0.s r0 = r11.m1704D(r3, r12)
            goto L57
        L5e:
            java.lang.Object r0 = r10._suppressableValue
            boolean r2 = r10._suppressNulls
            if (r12 == 0) goto Lbe
            X0.I r3 = r11.f1966e
            M0.A r3 = r12.mo1807e(r3, r1)
            if (r3 == 0) goto Lbe
            M0.z r4 = p039M0.EnumC0511z.f1186i
            M0.z r5 = r3.f1097f
            if (r5 == r4) goto Lbe
            int r0 = r5.ordinal()
            r2 = 1
            if (r0 == r2) goto L91
            r4 = 2
            if (r0 == r4) goto Lb3
            r4 = 3
            if (r0 == r4) goto Lb0
            r4 = 4
            if (r0 == r4) goto L99
            r4 = 5
            if (r0 == r4) goto L89
            r11 = 0
        L86:
            r9 = r11
            r8 = r1
            goto Lc0
        L89:
            java.lang.Class r0 = r3.f1099h
            java.lang.Object r1 = r11.mo1705E(r0)
            if (r1 != 0) goto L94
        L91:
            r8 = r1
        L92:
            r9 = r2
            goto Lc0
        L94:
            boolean r11 = r11.mo1706F(r1)
            goto L86
        L99:
            X0.l r11 = r10._valueType
            java.lang.Object r1 = p033K0.AbstractC0405c.m887h(r11)
            if (r1 == 0) goto L91
            java.lang.Class r11 = r1.getClass()
            boolean r11 = r11.isArray()
            if (r11 == 0) goto L91
            A.d r1 = p118m1.C1739d.m3869b(r1)
            goto L91
        Lb0:
            java.lang.Object r1 = com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer.MARKER_FOR_EMPTY
            goto L91
        Lb3:
            X0.l r11 = r10._valueType
            boolean r11 = r11.mo1629b()
            if (r11 == 0) goto L91
            java.lang.Object r1 = com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer.MARKER_FOR_EMPTY
            goto L91
        Lbe:
            r8 = r0
            goto L92
        Lc0:
            r4 = r10
            r5 = r12
            com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer r11 = r4.withResolved(r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer.createContextual(X0.K, X0.e):X0.s");
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public AbstractC0728s getContentSerializer() {
        return this._valueSerializer;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public AbstractC0721l getContentType() {
        return this._valueType;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(Map.Entry<?, ?> entry) {
        return true;
    }

    public void serializeDynamic(Map.Entry<?, ?> entry, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws IOException {
        AbstractC0728s abstractC0728s_findAndAddDynamic;
        AbstractC1399h abstractC1399h = this._valueTypeSerializer;
        Object key = entry.getKey();
        AbstractC0728s abstractC0728s = key == null ? abstractC0709K.f1974m : this._keySerializer;
        Object value = entry.getValue();
        if (value != null) {
            abstractC0728s_findAndAddDynamic = this._valueSerializer;
            if (abstractC0728s_findAndAddDynamic == null) {
                Class<?> cls = value.getClass();
                AbstractC0728s abstractC0728sMo3092c = this._dynamicValueSerializers.mo3092c(cls);
                abstractC0728s_findAndAddDynamic = abstractC0728sMo3092c == null ? this._valueType.mo1881p() ? _findAndAddDynamic(this._dynamicValueSerializers, abstractC0709K.m1718p(this._valueType, cls), abstractC0709K) : _findAndAddDynamic(this._dynamicValueSerializers, cls, abstractC0709K) : abstractC0728sMo3092c;
            }
            Object obj = this._suppressableValue;
            if (obj != null && ((obj == MARKER_FOR_EMPTY && abstractC0728s_findAndAddDynamic.isEmpty(abstractC0709K, value)) || this._suppressableValue.equals(value))) {
                return;
            }
        } else if (this._suppressNulls) {
            return;
        } else {
            abstractC0728s_findAndAddDynamic = abstractC0709K.f1973l;
        }
        abstractC0728s.serialize(key, abstractC0540h, abstractC0709K);
        try {
            if (abstractC1399h == null) {
                abstractC0728s_findAndAddDynamic.serialize(value, abstractC0540h, abstractC0709K);
            } else {
                abstractC0728s_findAndAddDynamic.serializeWithType(value, abstractC0540h, abstractC0709K, abstractC1399h);
            }
        } catch (Exception e3) {
            wrapAndThrow(abstractC0709K, e3, entry, "" + key);
        }
    }

    public MapEntrySerializer withContentInclusion(Object obj, boolean z3) {
        return (this._suppressableValue == obj && this._suppressNulls == z3) ? this : new MapEntrySerializer(this, this._property, this._valueTypeSerializer, this._keySerializer, this._valueSerializer, obj, z3);
    }

    public MapEntrySerializer withResolved(InterfaceC0714e interfaceC0714e, AbstractC0728s abstractC0728s, AbstractC0728s abstractC0728s2, Object obj, boolean z3) {
        return new MapEntrySerializer(this, interfaceC0714e, this._valueTypeSerializer, abstractC0728s, abstractC0728s2, obj, z3);
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, Map.Entry<?, ?> entry) {
        Object value = entry.getValue();
        if (value == null) {
            return this._suppressNulls;
        }
        if (this._suppressableValue == null) {
            return false;
        }
        AbstractC0728s abstractC0728s_findAndAddDynamic = this._valueSerializer;
        if (abstractC0728s_findAndAddDynamic == null) {
            Class<?> cls = value.getClass();
            AbstractC0728s abstractC0728sMo3092c = this._dynamicValueSerializers.mo3092c(cls);
            if (abstractC0728sMo3092c == null) {
                try {
                    abstractC0728s_findAndAddDynamic = _findAndAddDynamic(this._dynamicValueSerializers, cls, abstractC0709K);
                } catch (C0724o unused) {
                    return false;
                }
            } else {
                abstractC0728s_findAndAddDynamic = abstractC0728sMo3092c;
            }
        }
        Object obj = this._suppressableValue;
        return obj == MARKER_FOR_EMPTY ? abstractC0728s_findAndAddDynamic.isEmpty(abstractC0709K, value) : obj.equals(value);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(Map.Entry<?, ?> entry, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws IOException {
        abstractC0540h.mo1121N(entry);
        serializeDynamic(entry, abstractC0540h, abstractC0709K);
        abstractC0540h.mo1143p();
    }

    @Override // p069X0.AbstractC0728s
    public void serializeWithType(Map.Entry<?, ?> entry, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) throws IOException {
        abstractC0540h.mo1136i(entry);
        C0672b c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, abstractC1399h.m3406d(EnumC0548p.START_OBJECT, entry));
        serializeDynamic(entry, abstractC0540h, abstractC0709K);
        abstractC1399h.mo3104f(abstractC0540h, c0672bMo3103e);
    }

    public final AbstractC0728s _findAndAddDynamic(AbstractC1223k abstractC1223k, AbstractC0721l abstractC0721l, AbstractC0709K abstractC0709K) {
        C0009j c0009jM3093a = abstractC1223k.m3093a(abstractC0709K, this._property, abstractC0721l);
        AbstractC1223k abstractC1223k2 = (AbstractC1223k) c0009jM3093a.f31g;
        if (abstractC1223k != abstractC1223k2) {
            this._dynamicValueSerializers = abstractC1223k2;
        }
        return (AbstractC0728s) c0009jM3093a.f30f;
    }

    @Deprecated
    public MapEntrySerializer(MapEntrySerializer mapEntrySerializer, InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, AbstractC0728s abstractC0728s2) {
        this(mapEntrySerializer, interfaceC0714e, abstractC1399h, abstractC0728s, abstractC0728s2, mapEntrySerializer._suppressableValue, mapEntrySerializer._suppressNulls);
    }

    public MapEntrySerializer(MapEntrySerializer mapEntrySerializer, InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, AbstractC0728s abstractC0728s2, Object obj, boolean z3) {
        super(Map.class, false);
        this._entryType = mapEntrySerializer._entryType;
        this._keyType = mapEntrySerializer._keyType;
        this._valueType = mapEntrySerializer._valueType;
        this._valueTypeIsStatic = mapEntrySerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapEntrySerializer._valueTypeSerializer;
        this._keySerializer = abstractC0728s;
        this._valueSerializer = abstractC0728s2;
        this._dynamicValueSerializers = C1219g.f4140b;
        this._property = mapEntrySerializer._property;
        this._suppressableValue = obj;
        this._suppressNulls = z3;
    }
}
