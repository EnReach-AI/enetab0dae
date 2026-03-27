package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.C0724o;

/* JADX INFO: loaded from: classes.dex */
public class CoreXMLDeserializers$Std extends FromStringDeserializer<Object> {
    private static final long serialVersionUID = 1;
    protected final int _kind;

    public CoreXMLDeserializers$Std(Class<?> cls, int i3) {
        super(cls);
        this._kind = i3;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
    public Object _deserialize(String str, AbstractC0718i abstractC0718i) {
        int i3 = this._kind;
        if (i3 == 1) {
            return AbstractC1209a.f4116e.newDuration(str);
        }
        if (i3 == 2) {
            try {
                return _gregorianFromDate(abstractC0718i, _parseDate(str, abstractC0718i));
            } catch (C0724o unused) {
                return AbstractC1209a.f4116e.newXMLGregorianCalendar(str);
            }
        }
        if (i3 == 3) {
            return QName.valueOf(str);
        }
        throw new IllegalStateException();
    }

    public XMLGregorianCalendar _gregorianFromDate(AbstractC0718i abstractC0718i, Date date) {
        if (date == null) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        TimeZone timeZoneM2154i = abstractC0718i.f1998g.m2154i();
        if (timeZoneM2154i != null) {
            gregorianCalendar.setTimeZone(timeZoneM2154i);
        }
        return AbstractC1209a.f4116e.newXMLGregorianCalendar(gregorianCalendar);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer, p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return (this._kind == 2 && abstractC0545m.mo1168M(EnumC0548p.VALUE_NUMBER_INT)) ? _gregorianFromDate(abstractC0718i, _parseDate(abstractC0545m, abstractC0718i)) : super.deserialize(abstractC0545m, abstractC0718i);
    }
}
