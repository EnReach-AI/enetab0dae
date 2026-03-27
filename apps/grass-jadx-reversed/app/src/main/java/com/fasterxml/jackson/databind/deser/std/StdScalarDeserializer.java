package com.fasterxml.jackson.databind.deser.std;

import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.C0717h;
import p078a1.C0850b;
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;
import p118m1.EnumC1736a;

/* JADX INFO: loaded from: classes.dex */
public abstract class StdScalarDeserializer<T> extends StdDeserializer<T> {
    private static final long serialVersionUID = 1;

    public StdScalarDeserializer(Class<?> cls) {
        super(cls);
    }

    @Override // p069X0.AbstractC0722m
    public T deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, T t3) throws C0850b {
        abstractC0718i.m1858w(this);
        return (T) deserialize(abstractC0545m, abstractC0718i);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        return abstractC1398g.mo3403e(abstractC0545m, abstractC0718i);
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1736a getEmptyAccessPattern() {
        return EnumC1736a.f6082f;
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1736a getNullAccessPattern() {
        return EnumC1736a.f6081e;
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5901q;
    }

    @Override // p069X0.AbstractC0722m
    public Boolean supportsUpdate(C0717h c0717h) {
        return Boolean.FALSE;
    }

    public StdScalarDeserializer(AbstractC0721l abstractC0721l) {
        super(abstractC0721l);
    }

    public StdScalarDeserializer(StdScalarDeserializer<?> stdScalarDeserializer) {
        super(stdScalarDeserializer);
    }
}
