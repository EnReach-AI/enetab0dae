package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import com.fasterxml.jackson.databind.deser.InterfaceC1139f;
import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import com.fasterxml.jackson.databind.deser.InterfaceC1179n;
import com.fasterxml.jackson.databind.deser.impl.C1167s;
import java.util.Collection;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;
import p069X0.C0717h;
import p069X0.InterfaceC0714e;
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;
import p118m1.AbstractC1757v;
import p118m1.EnumC1736a;

/* JADX INFO: loaded from: classes.dex */
public abstract class DelegatingDeserializer extends StdDeserializer<Object> implements InterfaceC1139f, InterfaceC1179n {
    private static final long serialVersionUID = 1;
    protected final AbstractC0722m _delegatee;

    public DelegatingDeserializer(AbstractC0722m abstractC0722m) {
        super(abstractC0722m.handledType());
        this._delegatee = abstractC0722m;
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1139f
    public AbstractC0722m createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) {
        AbstractC0722m abstractC0722mM1823A = abstractC0718i.m1823A(this._delegatee, interfaceC0714e, abstractC0718i.m1848m(this._delegatee.handledType()));
        return abstractC0722mM1823A == this._delegatee ? this : newDelegatingInstance(abstractC0722mM1823A);
    }

    @Override // p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return this._delegatee.deserialize(abstractC0545m, abstractC0718i);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        return this._delegatee.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
    }

    @Override // p069X0.AbstractC0722m
    public AbstractC1204t findBackReference(String str) {
        return this._delegatee.findBackReference(str);
    }

    @Override // p069X0.AbstractC0722m, com.fasterxml.jackson.databind.deser.InterfaceC1178m
    public Object getAbsentValue(AbstractC0718i abstractC0718i) {
        return this._delegatee.getAbsentValue(abstractC0718i);
    }

    @Override // p069X0.AbstractC0722m
    public AbstractC0722m getDelegatee() {
        return this._delegatee;
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1736a getEmptyAccessPattern() {
        return this._delegatee.getEmptyAccessPattern();
    }

    @Override // p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return this._delegatee.getEmptyValue(abstractC0718i);
    }

    @Override // p069X0.AbstractC0722m
    public Collection<Object> getKnownPropertyNames() {
        return this._delegatee.getKnownPropertyNames();
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1736a getNullAccessPattern() {
        return this._delegatee.getNullAccessPattern();
    }

    @Override // p069X0.AbstractC0722m, com.fasterxml.jackson.databind.deser.InterfaceC1178m
    public Object getNullValue(AbstractC0718i abstractC0718i) {
        return this._delegatee.getNullValue(abstractC0718i);
    }

    @Override // p069X0.AbstractC0722m
    public C1167s getObjectIdReader() {
        return this._delegatee.getObjectIdReader();
    }

    @Override // p069X0.AbstractC0722m
    public boolean isCachable() {
        return this._delegatee.isCachable();
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return this._delegatee.logicalType();
    }

    public abstract AbstractC0722m newDelegatingInstance(AbstractC0722m abstractC0722m);

    @Override // p069X0.AbstractC0722m
    public AbstractC0722m replaceDelegatee(AbstractC0722m abstractC0722m) {
        return abstractC0722m == this._delegatee ? this : newDelegatingInstance(abstractC0722m);
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1179n
    public void resolve(AbstractC0718i abstractC0718i) {
        InterfaceC1178m interfaceC1178m = this._delegatee;
        if (interfaceC1178m instanceof InterfaceC1179n) {
            ((InterfaceC1179n) interfaceC1178m).resolve(abstractC0718i);
        }
    }

    @Override // p069X0.AbstractC0722m
    public Boolean supportsUpdate(C0717h c0717h) {
        return this._delegatee.supportsUpdate(c0717h);
    }

    @Override // p069X0.AbstractC0722m
    public AbstractC0722m unwrappingDeserializer(AbstractC1757v abstractC1757v) {
        AbstractC0722m abstractC0722mUnwrappingDeserializer = this._delegatee.unwrappingDeserializer(abstractC1757v);
        return abstractC0722mUnwrappingDeserializer == this._delegatee ? this : newDelegatingInstance(abstractC0722mUnwrappingDeserializer);
    }

    @Override // p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) {
        return this._delegatee.deserialize(abstractC0545m, abstractC0718i, obj);
    }
}
