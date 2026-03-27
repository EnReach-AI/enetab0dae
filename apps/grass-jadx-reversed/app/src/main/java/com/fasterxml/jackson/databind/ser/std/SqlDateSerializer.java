package com.fasterxml.jackson.databind.ser.std;

import java.sql.Date;
import java.text.DateFormat;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p071Y0.InterfaceC0738b;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class SqlDateSerializer extends DateTimeSerializerBase<Date> {
    public SqlDateSerializer() {
        this(null, null);
    }

    public SqlDateSerializer(Boolean bool, DateFormat dateFormat) {
        super(Date.class, bool, dateFormat);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase
    public long _timestamp(Date date) {
        if (date == null) {
            return 0L;
        }
        return date.getTime();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(Date date, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        if (_asTimestamp(abstractC0709K)) {
            abstractC0540h.mo1150w(_timestamp(date));
        } else if (this._customFormat == null) {
            abstractC0540h.mo1125R(date.toString());
        } else {
            _serializeAsString(date, abstractC0540h, abstractC0709K);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase
    /* JADX INFO: renamed from: withFormat, reason: avoid collision after fix types in other method */
    public DateTimeSerializerBase<Date> withFormat2(Boolean bool, DateFormat dateFormat) {
        return new SqlDateSerializer(bool, dateFormat);
    }
}
