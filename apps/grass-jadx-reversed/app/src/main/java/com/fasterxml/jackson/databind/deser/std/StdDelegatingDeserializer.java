package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.InterfaceC1139f;
import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import com.fasterxml.jackson.databind.deser.InterfaceC1179n;
import com.fasterxml.jackson.databind.deser.impl.C1160l;
import java.util.Collection;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.C0717h;
import p069X0.InterfaceC0714e;
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;
import p118m1.AbstractC1745j;
import p118m1.AbstractC1757v;
import p118m1.EnumC1736a;
import p118m1.InterfaceC1748m;

/* JADX INFO: loaded from: classes.dex */
public class StdDelegatingDeserializer<T> extends StdDeserializer<T> implements InterfaceC1139f, InterfaceC1179n {
    private static final long serialVersionUID = 1;
    protected final InterfaceC1748m _converter;
    protected final AbstractC0722m _delegateDeserializer;
    protected final AbstractC0721l _delegateType;

    public StdDelegatingDeserializer(InterfaceC1748m interfaceC1748m) {
        super((Class<?>) Object.class);
        this._converter = interfaceC1748m;
        this._delegateType = null;
        this._delegateDeserializer = null;
    }

    public T _convertIfNonNull(Object obj) {
        if (obj == null) {
            return null;
        }
        return (T) ((C1160l) this._converter).m3009b(obj);
    }

    public Object _handleIncompatibleUpdateValue(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) {
        throw new UnsupportedOperationException(String.format("Cannot update object of type %s (using deserializer for type %s)".concat(obj.getClass().getName()), this._delegateType));
    }

    public T convertValue(Object obj) {
        return (T) ((C1160l) this._converter).m3009b(obj);
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1139f
    public AbstractC0722m createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) {
        AbstractC0722m abstractC0722m = this._delegateDeserializer;
        if (abstractC0722m != null) {
            AbstractC0722m abstractC0722mM1823A = abstractC0718i.m1823A(abstractC0722m, interfaceC0714e, this._delegateType);
            return abstractC0722mM1823A != this._delegateDeserializer ? withDelegate(this._converter, this._delegateType, abstractC0722mM1823A) : this;
        }
        InterfaceC1748m interfaceC1748m = this._converter;
        abstractC0718i.mo1711f();
        AbstractC0721l abstractC0721l = ((C1160l) interfaceC1748m).f4009a;
        return withDelegate(this._converter, abstractC0721l, abstractC0718i.m1852q(abstractC0721l, interfaceC0714e));
    }

    @Override // p069X0.AbstractC0722m
    public T deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        Object objDeserialize = this._delegateDeserializer.deserialize(abstractC0545m, abstractC0718i);
        if (objDeserialize == null) {
            return null;
        }
        return convertValue(objDeserialize);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        Object objDeserialize = this._delegateDeserializer.deserialize(abstractC0545m, abstractC0718i);
        if (objDeserialize == null) {
            return null;
        }
        return convertValue(objDeserialize);
    }

    @Override // p069X0.AbstractC0722m, com.fasterxml.jackson.databind.deser.InterfaceC1178m
    public Object getAbsentValue(AbstractC0718i abstractC0718i) {
        return _convertIfNonNull(this._delegateDeserializer.getAbsentValue(abstractC0718i));
    }

    @Override // p069X0.AbstractC0722m
    public AbstractC0722m getDelegatee() {
        return this._delegateDeserializer;
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1736a getEmptyAccessPattern() {
        return this._delegateDeserializer.getEmptyAccessPattern();
    }

    @Override // p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return _convertIfNonNull(this._delegateDeserializer.getEmptyValue(abstractC0718i));
    }

    @Override // p069X0.AbstractC0722m
    public Collection<Object> getKnownPropertyNames() {
        return this._delegateDeserializer.getKnownPropertyNames();
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1736a getNullAccessPattern() {
        return this._delegateDeserializer.getNullAccessPattern();
    }

    @Override // p069X0.AbstractC0722m, com.fasterxml.jackson.databind.deser.InterfaceC1178m
    public T getNullValue(AbstractC0718i abstractC0718i) {
        return _convertIfNonNull(this._delegateDeserializer.getNullValue(abstractC0718i));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Class<?> handledType() {
        return this._delegateDeserializer.handledType();
    }

    @Override // p069X0.AbstractC0722m
    public boolean isCachable() {
        AbstractC0722m abstractC0722m = this._delegateDeserializer;
        return abstractC0722m != null && abstractC0722m.isCachable();
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return this._delegateDeserializer.logicalType();
    }

    @Override // p069X0.AbstractC0722m
    public AbstractC0722m replaceDelegatee(AbstractC0722m abstractC0722m) {
        AbstractC1745j.m3876F(StdDelegatingDeserializer.class, this, "replaceDelegatee");
        return abstractC0722m == this._delegateDeserializer ? this : new StdDelegatingDeserializer(this._converter, this._delegateType, abstractC0722m);
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1179n
    public void resolve(AbstractC0718i abstractC0718i) {
        InterfaceC1178m interfaceC1178m = this._delegateDeserializer;
        if (interfaceC1178m == null || !(interfaceC1178m instanceof InterfaceC1179n)) {
            return;
        }
        ((InterfaceC1179n) interfaceC1178m).resolve(abstractC0718i);
    }

    @Override // p069X0.AbstractC0722m
    public Boolean supportsUpdate(C0717h c0717h) {
        return this._delegateDeserializer.supportsUpdate(c0717h);
    }

    @Override // p069X0.AbstractC0722m
    public AbstractC0722m unwrappingDeserializer(AbstractC1757v abstractC1757v) {
        AbstractC1745j.m3876F(StdDelegatingDeserializer.class, this, "unwrappingDeserializer");
        return replaceDelegatee(this._delegateDeserializer.unwrappingDeserializer(abstractC1757v));
    }

    public StdDelegatingDeserializer<T> withDelegate(InterfaceC1748m interfaceC1748m, AbstractC0721l abstractC0721l, AbstractC0722m abstractC0722m) {
        AbstractC1745j.m3876F(StdDelegatingDeserializer.class, this, "withDelegate");
        return new StdDelegatingDeserializer<>(interfaceC1748m, abstractC0721l, abstractC0722m);
    }

    @Override // p069X0.AbstractC0722m
    public T deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) {
        if (this._delegateType.f2036e.isAssignableFrom(obj.getClass())) {
            return (T) this._delegateDeserializer.deserialize(abstractC0545m, abstractC0718i, obj);
        }
        return (T) _handleIncompatibleUpdateValue(abstractC0545m, abstractC0718i, obj);
    }

    @Override // p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g, T t3) {
        if (!this._delegateType.f2036e.isAssignableFrom(t3.getClass())) {
            return _handleIncompatibleUpdateValue(abstractC0545m, abstractC0718i, t3);
        }
        return this._delegateDeserializer.deserialize(abstractC0545m, abstractC0718i, t3);
    }

    public StdDelegatingDeserializer(InterfaceC1748m interfaceC1748m, AbstractC0721l abstractC0721l, AbstractC0722m abstractC0722m) {
        super(abstractC0721l);
        this._converter = interfaceC1748m;
        this._delegateType = abstractC0721l;
        this._delegateDeserializer = abstractC0722m;
    }

    public StdDelegatingDeserializer(StdDelegatingDeserializer<T> stdDelegatingDeserializer) {
        super(stdDelegatingDeserializer);
        this._converter = stdDelegatingDeserializer._converter;
        this._delegateType = stdDelegatingDeserializer._delegateType;
        this._delegateDeserializer = stdDelegatingDeserializer._delegateDeserializer;
    }
}
