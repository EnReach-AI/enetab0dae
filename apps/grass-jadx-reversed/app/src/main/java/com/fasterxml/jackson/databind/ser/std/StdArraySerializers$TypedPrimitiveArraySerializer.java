package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import p069X0.InterfaceC0714e;
import p100g1.AbstractC1399h;

/* JADX INFO: loaded from: classes.dex */
public abstract class StdArraySerializers$TypedPrimitiveArraySerializer<T> extends ArraySerializerBase<T> {
    public StdArraySerializers$TypedPrimitiveArraySerializer(Class<T> cls) {
        super(cls);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public final ContainerSerializer<?> _withValueTypeSerializer(AbstractC1399h abstractC1399h) {
        return this;
    }

    public StdArraySerializers$TypedPrimitiveArraySerializer(StdArraySerializers$TypedPrimitiveArraySerializer<T> stdArraySerializers$TypedPrimitiveArraySerializer, InterfaceC0714e interfaceC0714e, Boolean bool) {
        super(stdArraySerializers$TypedPrimitiveArraySerializer, interfaceC0714e, bool);
    }
}
