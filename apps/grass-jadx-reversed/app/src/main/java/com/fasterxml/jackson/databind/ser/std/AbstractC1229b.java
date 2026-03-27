package com.fasterxml.jackson.databind.ser.std;

import java.util.HashMap;
import p042N0.AbstractC0540h;
import p042N0.EnumC0544l;
import p042N0.EnumC0548p;
import p050Q0.AbstractC0595h;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p100g1.AbstractC1399h;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.ser.std.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1229b {
    /* JADX INFO: renamed from: a */
    public static void m3105a(HashMap map) {
        final Class<Integer> cls = Integer.class;
        map.put(Integer.class.getName(), new NumberSerializers$Base<Object>(cls) { // from class: com.fasterxml.jackson.databind.ser.std.NumberSerializers$IntegerSerializer
            {
                EnumC0544l enumC0544l = EnumC0544l.f1298e;
            }

            @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
            public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
                abstractC0540h.mo1149v(((Integer) obj).intValue());
            }

            @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, p069X0.AbstractC0728s
            public void serializeWithType(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
                serialize(obj, abstractC0540h, abstractC0709K);
            }
        });
        final Class cls2 = Integer.TYPE;
        map.put(cls2.getName(), new NumberSerializers$Base<Object>(cls2) { // from class: com.fasterxml.jackson.databind.ser.std.NumberSerializers$IntegerSerializer
            {
                EnumC0544l enumC0544l = EnumC0544l.f1298e;
            }

            @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
            public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
                abstractC0540h.mo1149v(((Integer) obj).intValue());
            }

            @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, p069X0.AbstractC0728s
            public void serializeWithType(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
                serialize(obj, abstractC0540h, abstractC0709K);
            }
        });
        final Class<Long> cls3 = Long.class;
        map.put(Long.class.getName(), new NumberSerializers$Base<Object>(cls3) { // from class: com.fasterxml.jackson.databind.ser.std.NumberSerializers$LongSerializer
            {
                EnumC0544l enumC0544l = EnumC0544l.f1299f;
            }

            @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
            public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
                abstractC0540h.mo1150w(((Long) obj).longValue());
            }
        });
        final Class cls4 = Long.TYPE;
        map.put(cls4.getName(), new NumberSerializers$Base<Object>(cls4) { // from class: com.fasterxml.jackson.databind.ser.std.NumberSerializers$LongSerializer
            {
                EnumC0544l enumC0544l = EnumC0544l.f1299f;
            }

            @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
            public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
                abstractC0540h.mo1150w(((Long) obj).longValue());
            }
        });
        String name = Byte.class.getName();
        NumberSerializers$IntLikeSerializer numberSerializers$IntLikeSerializer = NumberSerializers$IntLikeSerializer.instance;
        map.put(name, numberSerializers$IntLikeSerializer);
        map.put(Byte.TYPE.getName(), numberSerializers$IntLikeSerializer);
        String name2 = Short.class.getName();
        NumberSerializers$ShortSerializer numberSerializers$ShortSerializer = NumberSerializers$ShortSerializer.instance;
        map.put(name2, numberSerializers$ShortSerializer);
        map.put(Short.TYPE.getName(), numberSerializers$ShortSerializer);
        final Class<Double> cls5 = Double.class;
        map.put(Double.class.getName(), new NumberSerializers$Base<Object>(cls5) { // from class: com.fasterxml.jackson.databind.ser.std.NumberSerializers$DoubleSerializer
            {
                EnumC0544l enumC0544l = EnumC0544l.f1302i;
            }

            @Deprecated
            public static boolean notFinite(double d) {
                String str = AbstractC0595h.f1524a;
                return !Double.isFinite(d);
            }

            @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
            public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
                abstractC0540h.mo1147t(((Double) obj).doubleValue());
            }

            @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, p069X0.AbstractC0728s
            public void serializeWithType(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
                Double d = (Double) obj;
                double dDoubleValue = d.doubleValue();
                String str = AbstractC0595h.f1524a;
                if (!(!Double.isFinite(dDoubleValue))) {
                    abstractC0540h.mo1147t(d.doubleValue());
                    return;
                }
                C0672b c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, abstractC1399h.m3406d(EnumC0548p.VALUE_NUMBER_FLOAT, obj));
                abstractC0540h.mo1147t(d.doubleValue());
                abstractC1399h.mo3104f(abstractC0540h, c0672bMo3103e);
            }
        });
        final Class cls6 = Double.TYPE;
        map.put(cls6.getName(), new NumberSerializers$Base<Object>(cls6) { // from class: com.fasterxml.jackson.databind.ser.std.NumberSerializers$DoubleSerializer
            {
                EnumC0544l enumC0544l = EnumC0544l.f1302i;
            }

            @Deprecated
            public static boolean notFinite(double d) {
                String str = AbstractC0595h.f1524a;
                return !Double.isFinite(d);
            }

            @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
            public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
                abstractC0540h.mo1147t(((Double) obj).doubleValue());
            }

            @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, p069X0.AbstractC0728s
            public void serializeWithType(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
                Double d = (Double) obj;
                double dDoubleValue = d.doubleValue();
                String str = AbstractC0595h.f1524a;
                if (!(!Double.isFinite(dDoubleValue))) {
                    abstractC0540h.mo1147t(d.doubleValue());
                    return;
                }
                C0672b c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, abstractC1399h.m3406d(EnumC0548p.VALUE_NUMBER_FLOAT, obj));
                abstractC0540h.mo1147t(d.doubleValue());
                abstractC1399h.mo3104f(abstractC0540h, c0672bMo3103e);
            }
        });
        String name3 = Float.class.getName();
        NumberSerializers$FloatSerializer numberSerializers$FloatSerializer = NumberSerializers$FloatSerializer.instance;
        map.put(name3, numberSerializers$FloatSerializer);
        map.put(Float.TYPE.getName(), numberSerializers$FloatSerializer);
    }
}
