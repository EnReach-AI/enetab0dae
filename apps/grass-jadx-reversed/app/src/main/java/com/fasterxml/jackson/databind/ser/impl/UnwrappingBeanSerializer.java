package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import java.io.IOException;
import java.io.Serializable;
import java.util.Set;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0728s;
import p069X0.EnumC0708J;
import p100g1.AbstractC1399h;
import p112k1.C1635c;
import p118m1.AbstractC1757v;

/* JADX INFO: loaded from: classes.dex */
public class UnwrappingBeanSerializer extends BeanSerializerBase implements Serializable {
    private static final long serialVersionUID = 1;
    protected final AbstractC1757v _nameTransformer;

    public UnwrappingBeanSerializer(BeanSerializerBase beanSerializerBase, AbstractC1757v abstractC1757v) {
        super(beanSerializerBase, abstractC1757v);
        this._nameTransformer = abstractC1757v;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public BeanSerializerBase asArraySerializer() {
        return this;
    }

    @Override // p069X0.AbstractC0728s
    public boolean isUnwrappingSerializer() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public final void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws IOException {
        abstractC0540h.mo1136i(obj);
        if (this._objectIdWriter != null) {
            _serializeWithObjectId(obj, abstractC0540h, abstractC0709K, false);
        } else if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, abstractC0540h, abstractC0709K);
        } else {
            serializeFields(obj, abstractC0540h, abstractC0709K);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase, p069X0.AbstractC0728s
    public void serializeWithType(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) throws IOException {
        if (abstractC0709K.f1966e.m1698r(EnumC0708J.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS)) {
            abstractC0709K.m1815j(handledType(), "Unwrapped property requires use of type information: cannot serialize without disabling `SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS`");
        }
        abstractC0540h.mo1136i(obj);
        if (this._objectIdWriter != null) {
            _serializeWithObjectId(obj, abstractC0540h, abstractC0709K, abstractC1399h);
        } else if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, abstractC0540h, abstractC0709K);
        } else {
            serializeFields(obj, abstractC0540h, abstractC0709K);
        }
    }

    public String toString() {
        return "UnwrappingBeanSerializer for ".concat(handledType().getName());
    }

    @Override // p069X0.AbstractC0728s
    public AbstractC0728s unwrappingSerializer(AbstractC1757v abstractC1757v) {
        return new UnwrappingBeanSerializer(this, abstractC1757v);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public BeanSerializerBase withByNameInclusion(Set<String> set, Set<String> set2) {
        return new UnwrappingBeanSerializer(this, set, set2);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public BeanSerializerBase withObjectIdWriter(C1216d c1216d) {
        return new UnwrappingBeanSerializer(this, c1216d);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public BeanSerializerBase withProperties(C1635c[] c1635cArr, C1635c[] c1635cArr2) {
        return new UnwrappingBeanSerializer(this, c1635cArr, c1635cArr2);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase, p069X0.AbstractC0728s
    public BeanSerializerBase withFilterId(Object obj) {
        return new UnwrappingBeanSerializer(this, this._objectIdWriter, obj);
    }

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, C1216d c1216d) {
        super(unwrappingBeanSerializer, c1216d);
        this._nameTransformer = unwrappingBeanSerializer._nameTransformer;
    }

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, C1216d c1216d, Object obj) {
        super(unwrappingBeanSerializer, c1216d, obj);
        this._nameTransformer = unwrappingBeanSerializer._nameTransformer;
    }

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, Set<String> set) {
        this(unwrappingBeanSerializer, set, (Set<String>) null);
    }

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, Set<String> set, Set<String> set2) {
        super(unwrappingBeanSerializer, set, set2);
        this._nameTransformer = unwrappingBeanSerializer._nameTransformer;
    }

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, C1635c[] c1635cArr, C1635c[] c1635cArr2) {
        super(unwrappingBeanSerializer, c1635cArr, c1635cArr2);
        this._nameTransformer = unwrappingBeanSerializer._nameTransformer;
    }
}
