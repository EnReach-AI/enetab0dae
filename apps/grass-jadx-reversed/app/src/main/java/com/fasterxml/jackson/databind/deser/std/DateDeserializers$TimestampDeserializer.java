package com.fasterxml.jackson.databind.deser.std;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;
import p069X0.InterfaceC0714e;
import p114l1.EnumC1664f;

/* JADX INFO: loaded from: classes.dex */
public class DateDeserializers$TimestampDeserializer extends DateDeserializers$DateBasedDeserializer<Timestamp> {
    public DateDeserializers$TimestampDeserializer() {
        super(Timestamp.class);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers$DateBasedDeserializer, com.fasterxml.jackson.databind.deser.InterfaceC1139f
    public /* bridge */ /* synthetic */ AbstractC0722m createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) {
        return super.createContextual(abstractC0718i, interfaceC0714e);
    }

    @Override // p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return new Timestamp(0L);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers$DateBasedDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
    public /* bridge */ /* synthetic */ EnumC1664f logicalType() {
        return super.logicalType();
    }

    public DateDeserializers$TimestampDeserializer(DateDeserializers$TimestampDeserializer dateDeserializers$TimestampDeserializer, DateFormat dateFormat, String str) {
        super(dateDeserializers$TimestampDeserializer, dateFormat, str);
    }

    @Override // p069X0.AbstractC0722m
    public Timestamp deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        Date date_parseDate = _parseDate(abstractC0545m, abstractC0718i);
        if (date_parseDate == null) {
            return null;
        }
        return new Timestamp(date_parseDate.getTime());
    }

    @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers$DateBasedDeserializer
    public DateDeserializers$DateBasedDeserializer<Timestamp> withDateFormat(DateFormat dateFormat, String str) {
        return new DateDeserializers$TimestampDeserializer(this, dateFormat, str);
    }
}
