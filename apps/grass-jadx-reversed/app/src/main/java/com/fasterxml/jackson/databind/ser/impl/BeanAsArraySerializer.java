package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import java.io.IOException;
import java.util.Set;
import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0728s;
import p069X0.C0724o;
import p069X0.EnumC0708J;
import p100g1.AbstractC1399h;
import p112k1.C1635c;
import p118m1.AbstractC1757v;

/* JADX INFO: loaded from: classes.dex */
public class BeanAsArraySerializer extends BeanSerializerBase {
    private static final long serialVersionUID = 1;
    protected final BeanSerializerBase _defaultSerializer;

    public BeanAsArraySerializer(BeanSerializerBase beanSerializerBase) {
        super(beanSerializerBase, (C1216d) null);
        this._defaultSerializer = beanSerializerBase;
    }

    private boolean hasSingleElement(AbstractC0709K abstractC0709K) {
        C1635c[] c1635cArr = this._filteredProps;
        if (c1635cArr == null || abstractC0709K.f1967f == null) {
            c1635cArr = this._props;
        }
        return c1635cArr.length == 1;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public BeanSerializerBase asArraySerializer() {
        return this;
    }

    @Override // p069X0.AbstractC0728s
    public boolean isUnwrappingSerializer() {
        return false;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public final void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws IOException {
        if (abstractC0709K.f1966e.m1698r(EnumC0708J.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) && hasSingleElement(abstractC0709K)) {
            serializeAsArray(obj, abstractC0540h, abstractC0709K);
            return;
        }
        abstractC0540h.mo1118K(obj);
        serializeAsArray(obj, abstractC0540h, abstractC0709K);
        abstractC0540h.mo1142o();
    }

    public final void serializeAsArray(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws IOException {
        C1635c[] c1635cArr = this._filteredProps;
        if (c1635cArr == null || abstractC0709K.f1967f == null) {
            c1635cArr = this._props;
        }
        int i3 = 0;
        try {
            int length = c1635cArr.length;
            while (i3 < length) {
                C1635c c1635c = c1635cArr[i3];
                if (c1635c == null) {
                    abstractC0540h.mo1146s();
                } else {
                    c1635c.mo3087n(obj, abstractC0540h, abstractC0709K);
                }
                i3++;
            }
        } catch (Exception e3) {
            wrapAndThrow(abstractC0709K, e3, obj, c1635cArr[i3].f5810g.f1531e);
        } catch (StackOverflowError e4) {
            C0724o c0724o = new C0724o(abstractC0540h, "Infinite recursion (StackOverflowError)", e4);
            c0724o.mo1816d(c1635cArr[i3].f5810g.f1531e, obj);
            throw c0724o;
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase, p069X0.AbstractC0728s
    public void serializeWithType(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) throws IOException {
        if (this._objectIdWriter != null) {
            _serializeWithObjectId(obj, abstractC0540h, abstractC0709K, abstractC1399h);
            return;
        }
        C0672b c0672b_typeIdDef = _typeIdDef(abstractC1399h, obj, EnumC0548p.START_ARRAY);
        abstractC1399h.mo3103e(abstractC0540h, c0672b_typeIdDef);
        abstractC0540h.mo1136i(obj);
        serializeAsArray(obj, abstractC0540h, abstractC0709K);
        abstractC1399h.mo3104f(abstractC0540h, c0672b_typeIdDef);
    }

    public String toString() {
        return "BeanAsArraySerializer for ".concat(handledType().getName());
    }

    @Override // p069X0.AbstractC0728s
    public AbstractC0728s unwrappingSerializer(AbstractC1757v abstractC1757v) {
        return this._defaultSerializer.unwrappingSerializer(abstractC1757v);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public /* bridge */ /* synthetic */ BeanSerializerBase withByNameInclusion(Set set, Set set2) {
        return withByNameInclusion((Set<String>) set, (Set<String>) set2);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public BeanSerializerBase withObjectIdWriter(C1216d c1216d) {
        return this._defaultSerializer.withObjectIdWriter(c1216d);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public BeanSerializerBase withProperties(C1635c[] c1635cArr, C1635c[] c1635cArr2) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public BeanAsArraySerializer withByNameInclusion(Set<String> set, Set<String> set2) {
        return new BeanAsArraySerializer(this, set, set2);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase, p069X0.AbstractC0728s
    public BeanSerializerBase withFilterId(Object obj) {
        return new BeanAsArraySerializer(this, this._objectIdWriter, obj);
    }

    public BeanAsArraySerializer(BeanSerializerBase beanSerializerBase, Set<String> set) {
        this(beanSerializerBase, set, (Set<String>) null);
    }

    public BeanAsArraySerializer(BeanSerializerBase beanSerializerBase, Set<String> set, Set<String> set2) {
        super(beanSerializerBase, set, set2);
        this._defaultSerializer = beanSerializerBase;
    }

    public BeanAsArraySerializer(BeanSerializerBase beanSerializerBase, C1216d c1216d, Object obj) {
        super(beanSerializerBase, c1216d, obj);
        this._defaultSerializer = beanSerializerBase;
    }
}
