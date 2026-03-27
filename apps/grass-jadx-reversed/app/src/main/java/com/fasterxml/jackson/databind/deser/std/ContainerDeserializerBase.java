package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import com.fasterxml.jackson.databind.deser.AbstractC1208x;
import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import com.fasterxml.jackson.databind.deser.impl.C1165q;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import p005B.AbstractC0032g;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.C0717h;
import p069X0.C0723n;
import p069X0.C0724o;
import p069X0.EnumC0719j;
import p114l1.C1675q;
import p118m1.AbstractC1745j;
import p118m1.EnumC1736a;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContainerDeserializerBase<T> extends StdDeserializer<T> {
    protected final AbstractC0721l _containerType;
    protected final InterfaceC1178m _nullProvider;
    protected final boolean _skipNullValues;
    protected final Boolean _unwrapSingle;

    public ContainerDeserializerBase(AbstractC0721l abstractC0721l, InterfaceC1178m interfaceC1178m, Boolean bool) {
        super(abstractC0721l);
        this._containerType = abstractC0721l;
        this._unwrapSingle = bool;
        this._nullProvider = interfaceC1178m;
        this._skipNullValues = C1165q.m3010a(interfaceC1178m);
    }

    @Override // p069X0.AbstractC0722m
    public AbstractC1204t findBackReference(String str) {
        AbstractC0722m contentDeserializer = getContentDeserializer();
        if (contentDeserializer != null) {
            return contentDeserializer.findBackReference(str);
        }
        throw new IllegalArgumentException(AbstractC0032g.m156n("Cannot handle managed/back reference '", str, "': type: container deserializer of type ", getClass().getName(), " returned null for 'getContentDeserializer()'"));
    }

    public abstract AbstractC0722m getContentDeserializer();

    public AbstractC0721l getContentType() {
        AbstractC0721l abstractC0721l = this._containerType;
        return abstractC0721l == null ? C1675q.m3773n() : abstractC0721l.mo1874i();
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1736a getEmptyAccessPattern() {
        return EnumC1736a.f6083g;
    }

    @Override // p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) throws C0724o {
        AbstractC1208x valueInstantiator = getValueInstantiator();
        if (valueInstantiator == null || !valueInstantiator.mo3005j()) {
            abstractC0718i.mo1713k(String.format("Cannot create empty instance of %s, no default Creator", getValueType()));
            throw null;
        }
        try {
            return valueInstantiator.mo3007v(abstractC0718i);
        } catch (IOException e3) {
            AbstractC1745j.m3872B(abstractC0718i, e3);
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public AbstractC0721l getValueType() {
        return this._containerType;
    }

    @Override // p069X0.AbstractC0722m
    public Boolean supportsUpdate(C0717h c0717h) {
        return Boolean.TRUE;
    }

    @Deprecated
    public <BOGUS> BOGUS wrapAndThrow(Throwable th, Object obj, String str) {
        return (BOGUS) wrapAndThrow(null, th, obj, str);
    }

    public <BOGUS> BOGUS wrapAndThrow(AbstractC0718i abstractC0718i, Throwable th, Object obj, String str) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        AbstractC1745j.m3873C(th);
        if (abstractC0718i != null && !abstractC0718i.m1833K(EnumC0719j.WRAP_EXCEPTIONS)) {
            AbstractC1745j.m3875E(th);
        }
        if ((th instanceof IOException) && !(th instanceof C0724o)) {
            throw ((IOException) th);
        }
        if (str == null) {
            str = "N/A";
        }
        int i3 = C0724o.f2045h;
        throw C0724o.m1894g(th, new C0723n(str, obj));
    }

    public ContainerDeserializerBase(AbstractC0721l abstractC0721l) {
        this(abstractC0721l, (InterfaceC1178m) null, (Boolean) null);
    }

    public ContainerDeserializerBase(ContainerDeserializerBase<?> containerDeserializerBase) {
        this(containerDeserializerBase, containerDeserializerBase._nullProvider, containerDeserializerBase._unwrapSingle);
    }

    public ContainerDeserializerBase(ContainerDeserializerBase<?> containerDeserializerBase, InterfaceC1178m interfaceC1178m, Boolean bool) {
        super(containerDeserializerBase._containerType);
        this._containerType = containerDeserializerBase._containerType;
        this._nullProvider = interfaceC1178m;
        this._unwrapSingle = bool;
        this._skipNullValues = C1165q.m3010a(interfaceC1178m);
    }
}
