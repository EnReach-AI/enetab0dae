package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.InterfaceC1179n;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.AbstractC0725p;
import p078a1.C0850b;
import p100g1.AbstractC1398g;

/* JADX INFO: loaded from: classes.dex */
public abstract class StdNodeBasedDeserializer<T> extends StdDeserializer<T> implements InterfaceC1179n {
    private static final long serialVersionUID = 1;
    protected AbstractC0722m _treeDeserializer;

    public StdNodeBasedDeserializer(AbstractC0721l abstractC0721l) {
        super(abstractC0721l);
    }

    public abstract T convert(AbstractC0725p abstractC0725p, AbstractC0718i abstractC0718i);

    public T convert(AbstractC0725p abstractC0725p, AbstractC0718i abstractC0718i, T t3) throws C0850b {
        abstractC0718i.m1858w(this);
        return convert(abstractC0725p, abstractC0718i);
    }

    @Override // p069X0.AbstractC0722m
    public T deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return convert((AbstractC0725p) this._treeDeserializer.deserialize(abstractC0545m, abstractC0718i), abstractC0718i);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        return convert((AbstractC0725p) this._treeDeserializer.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g), abstractC0718i);
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1179n
    public void resolve(AbstractC0718i abstractC0718i) {
        this._treeDeserializer = abstractC0718i.m1856u(abstractC0718i.m1848m(AbstractC0725p.class));
    }

    public StdNodeBasedDeserializer(Class<T> cls) {
        super((Class<?>) cls);
    }

    public StdNodeBasedDeserializer(StdNodeBasedDeserializer<?> stdNodeBasedDeserializer) {
        super(stdNodeBasedDeserializer);
        this._treeDeserializer = stdNodeBasedDeserializer._treeDeserializer;
    }

    @Override // p069X0.AbstractC0722m
    public T deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, T t3) {
        return convert((AbstractC0725p) this._treeDeserializer.deserialize(abstractC0545m, abstractC0718i), abstractC0718i, t3);
    }
}
