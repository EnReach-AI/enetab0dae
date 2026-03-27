package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0728s;
import p069X0.InterfaceC0714e;
import p100g1.AbstractC1399h;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContainerSerializer<T> extends StdSerializer<T> {
    public ContainerSerializer(Class<T> cls) {
        super(cls);
    }

    public abstract ContainerSerializer<?> _withValueTypeSerializer(AbstractC1399h abstractC1399h);

    public abstract AbstractC0728s getContentSerializer();

    public abstract AbstractC0721l getContentType();

    @Deprecated
    public boolean hasContentTypeAnnotation(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e) {
        return false;
    }

    public abstract boolean hasSingleElement(T t3);

    /* JADX WARN: Multi-variable type inference failed */
    public ContainerSerializer<?> withValueTypeSerializer(AbstractC1399h abstractC1399h) {
        return abstractC1399h == null ? this : _withValueTypeSerializer(abstractC1399h);
    }

    public ContainerSerializer(AbstractC0721l abstractC0721l) {
        super(abstractC0721l);
    }

    public ContainerSerializer(Class<?> cls, boolean z3) {
        super(cls, z3);
    }

    public ContainerSerializer(ContainerSerializer<?> containerSerializer) {
        super(containerSerializer._handledType, false);
    }
}
