package com.fasterxml.jackson.databind.ser.std;

import java.text.DateFormat;
import java.util.Calendar;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p071Y0.InterfaceC0738b;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class CalendarSerializer extends DateTimeSerializerBase<Calendar> {
    public static final CalendarSerializer instance = new CalendarSerializer();

    public CalendarSerializer() {
        this(null, null);
    }

    public CalendarSerializer(Boolean bool, DateFormat dateFormat) {
        super(Calendar.class, bool, dateFormat);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase
    public long _timestamp(Calendar calendar) {
        if (calendar == null) {
            return 0L;
        }
        return calendar.getTimeInMillis();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(Calendar calendar, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        if (_asTimestamp(abstractC0709K)) {
            abstractC0540h.mo1150w(_timestamp(calendar));
        } else {
            _serializeAsString(calendar.getTime(), abstractC0540h, abstractC0709K);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase
    /* JADX INFO: renamed from: withFormat */
    public DateTimeSerializerBase<Calendar> withFormat2(Boolean bool, DateFormat dateFormat) {
        return new CalendarSerializer(bool, dateFormat);
    }
}
