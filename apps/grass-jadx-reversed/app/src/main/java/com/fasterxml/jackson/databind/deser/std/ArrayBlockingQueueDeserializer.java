package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.AbstractC1208x;
import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.C0724o;
import p100g1.AbstractC1398g;

/* JADX INFO: loaded from: classes.dex */
public class ArrayBlockingQueueDeserializer extends CollectionDeserializer {
    private static final long serialVersionUID = 1;

    public ArrayBlockingQueueDeserializer(AbstractC0721l abstractC0721l, AbstractC0722m abstractC0722m, AbstractC1398g abstractC1398g, AbstractC1208x abstractC1208x) {
        super(abstractC0721l, abstractC0722m, abstractC1398g, abstractC1208x);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.CollectionDeserializer
    public Collection<Object> _deserializeFromArray(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Collection<Object> collection) throws C0724o {
        if (collection == null) {
            collection = new ArrayList<>();
        }
        Collection<Object> collection_deserializeFromArray = super._deserializeFromArray(abstractC0545m, abstractC0718i, collection);
        return collection_deserializeFromArray.isEmpty() ? new ArrayBlockingQueue(1, false) : new ArrayBlockingQueue(collection_deserializeFromArray.size(), false, collection_deserializeFromArray);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.CollectionDeserializer
    public Collection<Object> createDefaultInstance(AbstractC0718i abstractC0718i) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.CollectionDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        return abstractC1398g.mo3401c(abstractC0545m, abstractC0718i);
    }

    public ArrayBlockingQueueDeserializer(AbstractC0721l abstractC0721l, AbstractC0722m abstractC0722m, AbstractC1398g abstractC1398g, AbstractC1208x abstractC1208x, AbstractC0722m abstractC0722m2, InterfaceC1178m interfaceC1178m, Boolean bool) {
        super(abstractC0721l, abstractC0722m, abstractC1398g, abstractC1208x, abstractC0722m2, interfaceC1178m, bool);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.CollectionDeserializer
    public ArrayBlockingQueueDeserializer withResolved(AbstractC0722m abstractC0722m, AbstractC0722m abstractC0722m2, AbstractC1398g abstractC1398g, InterfaceC1178m interfaceC1178m, Boolean bool) {
        return new ArrayBlockingQueueDeserializer(this._containerType, abstractC0722m2, abstractC1398g, this._valueInstantiator, abstractC0722m, interfaceC1178m, bool);
    }

    public ArrayBlockingQueueDeserializer(ArrayBlockingQueueDeserializer arrayBlockingQueueDeserializer) {
        super(arrayBlockingQueueDeserializer);
    }
}
