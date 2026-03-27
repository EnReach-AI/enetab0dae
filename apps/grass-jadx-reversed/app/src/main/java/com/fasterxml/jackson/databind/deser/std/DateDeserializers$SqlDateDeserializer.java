package com.fasterxml.jackson.databind.deser.std;

import java.sql.Date;
import java.text.DateFormat;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;
import p069X0.InterfaceC0714e;
import p114l1.EnumC1664f;

/* JADX INFO: loaded from: classes.dex */
public class DateDeserializers$SqlDateDeserializer extends DateDeserializers$DateBasedDeserializer<Date> {
    public DateDeserializers$SqlDateDeserializer() {
        super(Date.class);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers$DateBasedDeserializer, com.fasterxml.jackson.databind.deser.InterfaceC1139f
    public /* bridge */ /* synthetic */ AbstractC0722m createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) {
        return super.createContextual(abstractC0718i, interfaceC0714e);
    }

    @Override // p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return new Date(0L);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers$DateBasedDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
    public /* bridge */ /* synthetic */ EnumC1664f logicalType() {
        return super.logicalType();
    }

    public DateDeserializers$SqlDateDeserializer(DateDeserializers$SqlDateDeserializer dateDeserializers$SqlDateDeserializer, DateFormat dateFormat, String str) {
        super(dateDeserializers$SqlDateDeserializer, dateFormat, str);
    }

    @Override // p069X0.AbstractC0722m
    public Date deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        java.util.Date date_parseDate = _parseDate(abstractC0545m, abstractC0718i);
        if (date_parseDate == null) {
            return null;
        }
        return new Date(date_parseDate.getTime());
    }

    @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers$DateBasedDeserializer
    public DateDeserializers$DateBasedDeserializer<Date> withDateFormat(DateFormat dateFormat, String str) {
        return new DateDeserializers$SqlDateDeserializer(this, dateFormat, str);
    }
}
