package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.util.Calendar;
import javax.xml.datatype.XMLGregorianCalendar;
import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0728s;
import p069X0.InterfaceC0714e;
import p092e1.InterfaceC1338c;
import p100g1.AbstractC1399h;
import p112k1.InterfaceC1638f;

/* JADX INFO: loaded from: classes.dex */
public class CoreXMLSerializers$XMLGregorianCalendarSerializer extends StdSerializer<XMLGregorianCalendar> implements InterfaceC1638f {
    static final CoreXMLSerializers$XMLGregorianCalendarSerializer instance = new CoreXMLSerializers$XMLGregorianCalendarSerializer();
    final AbstractC0728s _delegate;

    public CoreXMLSerializers$XMLGregorianCalendarSerializer() {
        this(CalendarSerializer.instance);
    }

    public Calendar _convert(XMLGregorianCalendar xMLGregorianCalendar) {
        if (xMLGregorianCalendar == null) {
            return null;
        }
        return xMLGregorianCalendar.toGregorianCalendar();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        this._delegate.acceptJsonFormatVisitor(interfaceC1338c, null);
    }

    @Override // p112k1.InterfaceC1638f
    public AbstractC0728s createContextual(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e) {
        AbstractC0728s abstractC0728sM1703C = abstractC0709K.m1703C(this._delegate, interfaceC0714e);
        return abstractC0728sM1703C != this._delegate ? new CoreXMLSerializers$XMLGregorianCalendarSerializer(abstractC0728sM1703C) : this;
    }

    @Override // p069X0.AbstractC0728s
    public AbstractC0728s getDelegatee() {
        return this._delegate;
    }

    public CoreXMLSerializers$XMLGregorianCalendarSerializer(AbstractC0728s abstractC0728s) {
        super(XMLGregorianCalendar.class);
        this._delegate = abstractC0728s;
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, XMLGregorianCalendar xMLGregorianCalendar) {
        return this._delegate.isEmpty(abstractC0709K, _convert(xMLGregorianCalendar));
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(XMLGregorianCalendar xMLGregorianCalendar, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        this._delegate.serialize(_convert(xMLGregorianCalendar), abstractC0540h, abstractC0709K);
    }

    @Override // p069X0.AbstractC0728s
    public void serializeWithType(XMLGregorianCalendar xMLGregorianCalendar, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
        C0672b c0672bM3406d = abstractC1399h.m3406d(EnumC0548p.VALUE_STRING, xMLGregorianCalendar);
        c0672bM3406d.f1824b = XMLGregorianCalendar.class;
        C0672b c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, c0672bM3406d);
        serialize(xMLGregorianCalendar, abstractC0540h, abstractC0709K);
        abstractC1399h.mo3104f(abstractC0540h, c0672bMo3103e);
    }
}
