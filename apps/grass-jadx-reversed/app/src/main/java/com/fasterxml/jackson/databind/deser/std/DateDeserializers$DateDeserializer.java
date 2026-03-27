package com.fasterxml.jackson.databind.deser.std;

import java.text.DateFormat;
import java.util.Date;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;
import p069X0.InterfaceC0714e;
import p071Y0.InterfaceC0738b;
import p114l1.EnumC1664f;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class DateDeserializers$DateDeserializer extends DateDeserializers$DateBasedDeserializer<Date> {
    public static final DateDeserializers$DateDeserializer instance = new DateDeserializers$DateDeserializer();

    public DateDeserializers$DateDeserializer() {
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

    public DateDeserializers$DateDeserializer(DateDeserializers$DateDeserializer dateDeserializers$DateDeserializer, DateFormat dateFormat, String str) {
        super(dateDeserializers$DateDeserializer, dateFormat, str);
    }

    @Override // p069X0.AbstractC0722m
    public Date deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return _parseDate(abstractC0545m, abstractC0718i);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers$DateBasedDeserializer
    public DateDeserializers$DateBasedDeserializer<Date> withDateFormat(DateFormat dateFormat, String str) {
        return new DateDeserializers$DateDeserializer(this, dateFormat, str);
    }
}
