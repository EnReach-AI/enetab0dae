package com.fasterxml.jackson.databind.ser.std;

import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p100g1.AbstractC1399h;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class NonTypedScalarSerializerBase<T> extends StdScalarSerializer<T> {
    public NonTypedScalarSerializerBase(Class<T> cls) {
        super(cls);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, p069X0.AbstractC0728s
    public final void serializeWithType(T t3, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
        serialize(t3, abstractC0540h, abstractC0709K);
    }

    public NonTypedScalarSerializerBase(Class<?> cls, boolean z3) {
        super(cls, z3);
    }
}
