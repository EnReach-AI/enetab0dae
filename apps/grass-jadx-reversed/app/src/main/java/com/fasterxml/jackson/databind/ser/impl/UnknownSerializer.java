package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.ser.std.ToEmptyObjectSerializer;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.EnumC0708J;
import p100g1.AbstractC1399h;
import p118m1.AbstractC1759x;

/* JADX INFO: loaded from: classes.dex */
public class UnknownSerializer extends ToEmptyObjectSerializer {
    public UnknownSerializer() {
        super((Class<?>) Object.class);
    }

    public void failForEmpty(AbstractC0709K abstractC0709K, Object obj) {
        Class<?> cls = obj.getClass();
        if (AbstractC1759x.m3912a(cls)) {
            abstractC0709K.m1815j(handledType(), "No serializer found for class " + cls.getName() + " and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS). This appears to be a native image, in which case you may need to configure reflection for the class that is to be serialized");
            return;
        }
        abstractC0709K.m1815j(handledType(), "No serializer found for class " + cls.getName() + " and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)");
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ToEmptyObjectSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        if (abstractC0709K.f1966e.m1698r(EnumC0708J.FAIL_ON_EMPTY_BEANS)) {
            failForEmpty(abstractC0709K, obj);
        }
        super.serialize(obj, abstractC0540h, abstractC0709K);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ToEmptyObjectSerializer, p069X0.AbstractC0728s
    public void serializeWithType(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
        if (abstractC0709K.f1966e.m1698r(EnumC0708J.FAIL_ON_EMPTY_BEANS)) {
            failForEmpty(abstractC0709K, obj);
        }
        super.serializeWithType(obj, abstractC0540h, abstractC0709K, abstractC1399h);
    }

    public UnknownSerializer(Class<?> cls) {
        super(cls);
    }
}
