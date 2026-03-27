package p069X0;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import com.fasterxml.jackson.databind.deser.impl.C1167s;
import java.util.Collection;
import p042N0.AbstractC0545m;
import p078a1.C0850b;
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;
import p118m1.AbstractC1757v;
import p118m1.EnumC1736a;

/* JADX INFO: renamed from: X0.m */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0722m implements InterfaceC1178m {
    public abstract Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i);

    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) throws C0850b {
        abstractC0718i.m1858w(this);
        return deserialize(abstractC0545m, abstractC0718i);
    }

    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        return abstractC1398g.mo3400b(abstractC0545m, abstractC0718i);
    }

    public AbstractC1204t findBackReference(String str) {
        throw new IllegalArgumentException("Cannot handle managed/back reference '" + str + "': type: value deserializer of type " + getClass().getName() + " does not support them");
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1178m
    public Object getAbsentValue(AbstractC0718i abstractC0718i) {
        return getNullValue(abstractC0718i);
    }

    public AbstractC0722m getDelegatee() {
        return null;
    }

    public EnumC1736a getEmptyAccessPattern() {
        return EnumC1736a.f6083g;
    }

    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return getNullValue(abstractC0718i);
    }

    public Collection<Object> getKnownPropertyNames() {
        return null;
    }

    public EnumC1736a getNullAccessPattern() {
        return EnumC1736a.f6082f;
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1178m
    public Object getNullValue(AbstractC0718i abstractC0718i) {
        return getNullValue();
    }

    public C1167s getObjectIdReader() {
        return null;
    }

    public Class<?> handledType() {
        return null;
    }

    public boolean isCachable() {
        return false;
    }

    public EnumC1664f logicalType() {
        return null;
    }

    public AbstractC0722m replaceDelegatee(AbstractC0722m abstractC0722m) {
        throw new UnsupportedOperationException();
    }

    public Boolean supportsUpdate(C0717h c0717h) {
        return null;
    }

    public AbstractC0722m unwrappingDeserializer(AbstractC1757v abstractC1757v) {
        return this;
    }

    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g, Object obj) throws C0850b {
        abstractC0718i.m1858w(this);
        return deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
    }

    @Deprecated
    public Object getEmptyValue() {
        return getNullValue();
    }

    @Deprecated
    public Object getNullValue() {
        return null;
    }
}
