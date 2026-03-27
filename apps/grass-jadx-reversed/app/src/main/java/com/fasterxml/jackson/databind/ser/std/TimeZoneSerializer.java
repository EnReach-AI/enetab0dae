package com.fasterxml.jackson.databind.ser.std;

import java.util.TimeZone;
import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p100g1.AbstractC1399h;

/* JADX INFO: loaded from: classes.dex */
public class TimeZoneSerializer extends StdScalarSerializer<TimeZone> {
    public TimeZoneSerializer() {
        super(TimeZone.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(TimeZone timeZone, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        abstractC0540h.mo1125R(timeZone.getID());
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, p069X0.AbstractC0728s
    public void serializeWithType(TimeZone timeZone, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
        C0672b c0672bM3406d = abstractC1399h.m3406d(EnumC0548p.VALUE_STRING, timeZone);
        c0672bM3406d.f1824b = TimeZone.class;
        C0672b c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, c0672bM3406d);
        serialize(timeZone, abstractC0540h, abstractC0709K);
        abstractC1399h.mo3104f(abstractC0540h, c0672bMo3103e);
    }
}
