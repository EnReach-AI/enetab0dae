package com.fasterxml.jackson.databind.deser.std;

import java.lang.reflect.Constructor;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;
import p069X0.InterfaceC0714e;
import p071Y0.InterfaceC0738b;
import p078a1.C0850b;
import p114l1.EnumC1664f;
import p118m1.AbstractC1745j;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class DateDeserializers$CalendarDeserializer extends DateDeserializers$DateBasedDeserializer<Calendar> {
    protected final Constructor<Calendar> _defaultCtor;

    public DateDeserializers$CalendarDeserializer() {
        super(Calendar.class);
        this._defaultCtor = null;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers$DateBasedDeserializer, com.fasterxml.jackson.databind.deser.InterfaceC1139f
    public /* bridge */ /* synthetic */ AbstractC0722m createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) {
        return super.createContextual(abstractC0718i, interfaceC0714e);
    }

    @Override // p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(0L);
        return gregorianCalendar;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers$DateBasedDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
    public /* bridge */ /* synthetic */ EnumC1664f logicalType() {
        return super.logicalType();
    }

    @Override // p069X0.AbstractC0722m
    public Calendar deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        Date date_parseDate = _parseDate(abstractC0545m, abstractC0718i);
        if (date_parseDate == null) {
            return null;
        }
        Constructor<Calendar> constructor = this._defaultCtor;
        if (constructor == null) {
            Calendar calendar = Calendar.getInstance(abstractC0718i.f1998g.m2154i());
            calendar.setTime(date_parseDate);
            return calendar;
        }
        try {
            Calendar calendarNewInstance = constructor.newInstance(null);
            calendarNewInstance.setTimeInMillis(date_parseDate.getTime());
            TimeZone timeZoneM2154i = abstractC0718i.f1998g.m2154i();
            if (timeZoneM2154i != null) {
                calendarNewInstance.setTimeZone(timeZoneM2154i);
            }
            return calendarNewInstance;
        } catch (Exception e3) {
            abstractC0718i.m1859x(handledType(), e3);
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers$DateBasedDeserializer
    public DateDeserializers$DateBasedDeserializer<Calendar> withDateFormat(DateFormat dateFormat, String str) {
        return new DateDeserializers$CalendarDeserializer(this, dateFormat, str);
    }

    public DateDeserializers$CalendarDeserializer(Class<? extends Calendar> cls) {
        super(cls);
        this._defaultCtor = AbstractC1745j.m3888k(cls, false);
    }

    public DateDeserializers$CalendarDeserializer(DateDeserializers$CalendarDeserializer dateDeserializers$CalendarDeserializer, DateFormat dateFormat, String str) {
        super(dateDeserializers$CalendarDeserializer, dateFormat, str);
        this._defaultCtor = dateDeserializers$CalendarDeserializer._defaultCtor;
    }
}
