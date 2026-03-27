package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.AbstractC1208x;
import com.fasterxml.jackson.databind.deser.InterfaceC1139f;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.C0717h;
import p069X0.InterfaceC0714e;
import p078a1.C0850b;
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;
import p118m1.EnumC1736a;

/* JADX INFO: loaded from: classes.dex */
public abstract class ReferenceTypeDeserializer<T> extends StdDeserializer<T> implements InterfaceC1139f {
    private static final long serialVersionUID = 2;
    protected final AbstractC0721l _fullType;
    protected final AbstractC0722m _valueDeserializer;
    protected final AbstractC1208x _valueInstantiator;
    protected final AbstractC1398g _valueTypeDeserializer;

    public ReferenceTypeDeserializer(AbstractC0721l abstractC0721l, AbstractC1208x abstractC1208x, AbstractC1398g abstractC1398g, AbstractC0722m abstractC0722m) {
        super(abstractC0721l);
        this._valueInstantiator = abstractC1208x;
        this._fullType = abstractC0721l;
        this._valueDeserializer = abstractC0722m;
        this._valueTypeDeserializer = abstractC1398g;
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1139f
    public AbstractC0722m createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) {
        AbstractC0722m abstractC0722m = this._valueDeserializer;
        AbstractC0722m abstractC0722mM1852q = abstractC0722m == null ? abstractC0718i.m1852q(this._fullType.mo1628a(), interfaceC0714e) : abstractC0718i.m1823A(abstractC0722m, interfaceC0714e, this._fullType.mo1628a());
        AbstractC1398g abstractC1398gMo3404f = this._valueTypeDeserializer;
        if (abstractC1398gMo3404f != null) {
            abstractC1398gMo3404f = abstractC1398gMo3404f.mo3404f(interfaceC0714e);
        }
        return (abstractC0722mM1852q == this._valueDeserializer && abstractC1398gMo3404f == this._valueTypeDeserializer) ? this : withResolved(abstractC1398gMo3404f, abstractC0722mM1852q);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p069X0.AbstractC0722m
    public T deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        AbstractC1208x abstractC1208x = this._valueInstantiator;
        if (abstractC1208x != null) {
            return (T) deserialize(abstractC0545m, abstractC0718i, abstractC1208x.mo3007v(abstractC0718i));
        }
        AbstractC1398g abstractC1398g = this._valueTypeDeserializer;
        return (T) referenceValue(abstractC1398g == null ? this._valueDeserializer.deserialize(abstractC0545m, abstractC0718i) : this._valueDeserializer.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        if (abstractC0545m.mo1168M(EnumC0548p.VALUE_NULL)) {
            return getNullValue(abstractC0718i);
        }
        AbstractC1398g abstractC1398g2 = this._valueTypeDeserializer;
        return abstractC1398g2 == null ? deserialize(abstractC0545m, abstractC0718i) : referenceValue(abstractC1398g2.mo3400b(abstractC0545m, abstractC0718i));
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1736a getEmptyAccessPattern() {
        return EnumC1736a.f6083g;
    }

    @Override // p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return getNullValue(abstractC0718i);
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1736a getNullAccessPattern() {
        return EnumC1736a.f6083g;
    }

    @Override // p069X0.AbstractC0722m, com.fasterxml.jackson.databind.deser.InterfaceC1178m
    public abstract T getNullValue(AbstractC0718i abstractC0718i);

    public abstract Object getReferenced(T t3);

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public AbstractC1208x getValueInstantiator() {
        return this._valueInstantiator;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public AbstractC0721l getValueType() {
        return this._fullType;
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        AbstractC0722m abstractC0722m = this._valueDeserializer;
        return abstractC0722m != null ? abstractC0722m.logicalType() : super.logicalType();
    }

    public abstract T referenceValue(Object obj);

    @Override // p069X0.AbstractC0722m
    public Boolean supportsUpdate(C0717h c0717h) {
        AbstractC0722m abstractC0722m = this._valueDeserializer;
        if (abstractC0722m == null) {
            return null;
        }
        return abstractC0722m.supportsUpdate(c0717h);
    }

    public abstract T updateReference(T t3, Object obj);

    public abstract ReferenceTypeDeserializer<T> withResolved(AbstractC1398g abstractC1398g, AbstractC0722m abstractC0722m);

    @Deprecated
    public ReferenceTypeDeserializer(AbstractC0721l abstractC0721l, AbstractC1398g abstractC1398g, AbstractC0722m abstractC0722m) {
        this(abstractC0721l, null, abstractC1398g, abstractC0722m);
    }

    @Override // p069X0.AbstractC0722m
    public T deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, T t3) throws C0850b {
        Object objDeserializeWithType;
        Object objDeserializeWithType2;
        if (!this._valueDeserializer.supportsUpdate(abstractC0718i.f1998g).equals(Boolean.FALSE) && this._valueTypeDeserializer == null) {
            Object referenced = getReferenced(t3);
            if (referenced == null) {
                AbstractC1398g abstractC1398g = this._valueTypeDeserializer;
                if (abstractC1398g == null) {
                    objDeserializeWithType2 = this._valueDeserializer.deserialize(abstractC0545m, abstractC0718i);
                } else {
                    objDeserializeWithType2 = this._valueDeserializer.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
                }
                return referenceValue(objDeserializeWithType2);
            }
            objDeserializeWithType = this._valueDeserializer.deserialize(abstractC0545m, abstractC0718i, referenced);
        } else {
            AbstractC1398g abstractC1398g2 = this._valueTypeDeserializer;
            if (abstractC1398g2 == null) {
                objDeserializeWithType = this._valueDeserializer.deserialize(abstractC0545m, abstractC0718i);
            } else {
                objDeserializeWithType = this._valueDeserializer.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g2);
            }
        }
        return updateReference(t3, objDeserializeWithType);
    }
}
