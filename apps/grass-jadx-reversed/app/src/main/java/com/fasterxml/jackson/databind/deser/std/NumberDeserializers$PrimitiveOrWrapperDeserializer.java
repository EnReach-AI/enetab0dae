package com.fasterxml.jackson.databind.deser.std;

import p069X0.AbstractC0718i;
import p069X0.EnumC0719j;
import p078a1.C0850b;
import p114l1.EnumC1664f;
import p118m1.AbstractC1745j;
import p118m1.EnumC1736a;

/* JADX INFO: loaded from: classes.dex */
public abstract class NumberDeserializers$PrimitiveOrWrapperDeserializer<T> extends StdScalarDeserializer<T> {
    private static final long serialVersionUID = 1;
    protected final T _emptyValue;
    protected final EnumC1664f _logicalType;
    protected final T _nullValue;
    protected final boolean _primitive;

    public NumberDeserializers$PrimitiveOrWrapperDeserializer(Class<T> cls, EnumC1664f enumC1664f, T t3, T t4) {
        super((Class<?>) cls);
        this._logicalType = enumC1664f;
        this._nullValue = t3;
        this._emptyValue = t4;
        this._primitive = cls.isPrimitive();
    }

    @Override // p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return this._emptyValue;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
    public EnumC1736a getNullAccessPattern() {
        return this._primitive ? EnumC1736a.f6083g : this._nullValue == null ? EnumC1736a.f6081e : EnumC1736a.f6082f;
    }

    @Override // p069X0.AbstractC0722m, com.fasterxml.jackson.databind.deser.InterfaceC1178m
    public final T getNullValue(AbstractC0718i abstractC0718i) throws C0850b {
        if (!this._primitive || !abstractC0718i.m1833K(EnumC0719j.FAIL_ON_NULL_FOR_PRIMITIVES)) {
            return this._nullValue;
        }
        abstractC0718i.m1841S(this, "Cannot map `null` into type %s (set DeserializationConfig.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)", AbstractC1745j.m3883f(handledType()));
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
    public final EnumC1664f logicalType() {
        return this._logicalType;
    }

    @Deprecated
    public NumberDeserializers$PrimitiveOrWrapperDeserializer(Class<T> cls, T t3, T t4) {
        this(cls, EnumC1664f.f5901q, t3, t4);
    }
}
