package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.InterfaceC1139f;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import p005B.AbstractC0032g;
import p039M0.C0502q;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;
import p069X0.InterfaceC0714e;
import p114l1.EnumC1664f;
import p118m1.C1727B;

/* JADX INFO: loaded from: classes.dex */
public abstract class DateDeserializers$DateBasedDeserializer<T> extends StdScalarDeserializer<T> implements InterfaceC1139f {
    protected final DateFormat _customFormat;
    protected final String _formatString;

    public DateDeserializers$DateBasedDeserializer(Class<?> cls) {
        super(cls);
        this._customFormat = null;
        this._formatString = null;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public Date _parseDate(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        Date date;
        if (this._customFormat == null || !abstractC0545m.mo1168M(EnumC0548p.VALUE_STRING)) {
            return super._parseDate(abstractC0545m, abstractC0718i);
        }
        String strTrim = abstractC0545m.mo1157B().trim();
        if (strTrim.isEmpty()) {
            if (_checkFromStringCoercion(abstractC0718i, strTrim).ordinal() != 3) {
                return null;
            }
            return new Date(0L);
        }
        synchronized (this._customFormat) {
            try {
                try {
                    date = this._customFormat.parse(strTrim);
                } catch (ParseException unused) {
                    abstractC0718i.m1829G(handledType(), strTrim, "expected format \"%s\"", this._formatString);
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return date;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12, types: [m1.B] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.text.DateFormat] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.text.DateFormat] */
    public AbstractC0722m createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) {
        DateFormat dateFormat;
        ?? c1727b;
        Boolean bool;
        C0502q c0502qFindFormatOverrides = findFormatOverrides(abstractC0718i, interfaceC0714e, handledType());
        if (c0502qFindFormatOverrides != null) {
            TimeZone timeZoneM1016c = c0502qFindFormatOverrides.m1016c();
            String str = c0502qFindFormatOverrides.f1169e;
            boolean z3 = str != null && str.length() > 0;
            Locale locale = c0502qFindFormatOverrides.f1171g;
            Boolean bool2 = c0502qFindFormatOverrides.f1173i;
            if (z3) {
                if (locale == null) {
                    locale = abstractC0718i.f1998g.f2481f.f2427m;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
                if (timeZoneM1016c == null) {
                    timeZoneM1016c = abstractC0718i.f1998g.m2154i();
                }
                simpleDateFormat.setTimeZone(timeZoneM1016c);
                if (bool2 != null) {
                    simpleDateFormat.setLenient(bool2.booleanValue());
                }
                return withDateFormat(simpleDateFormat, str);
            }
            if (timeZoneM1016c != null) {
                DateFormat dateFormat2 = abstractC0718i.f1998g.f2481f.f2426l;
                if (dateFormat2.getClass() == C1727B.class) {
                    if (locale == null) {
                        locale = abstractC0718i.f1998g.f2481f.f2427m;
                    }
                    C1727B c1727b2 = (C1727B) dateFormat2;
                    TimeZone timeZone = c1727b2.f6034e;
                    C1727B c1727b3 = c1727b2;
                    if (timeZoneM1016c != timeZone) {
                        c1727b3 = c1727b2;
                        if (!timeZoneM1016c.equals(timeZone)) {
                            c1727b3 = new C1727B(timeZoneM1016c, c1727b2.f6035f, c1727b2.f6036g, c1727b2.f6039j);
                        }
                    }
                    boolean zEquals = locale.equals(c1727b3.f6035f);
                    c1727b = c1727b3;
                    if (!zEquals) {
                        c1727b = new C1727B(c1727b3.f6034e, locale, c1727b3.f6036g, c1727b3.f6039j);
                    }
                    if (bool2 != null && bool2 != (bool = c1727b.f6036g) && !bool2.equals(bool)) {
                        c1727b = new C1727B(c1727b.f6034e, c1727b.f6035f, bool2, c1727b.f6039j);
                    }
                } else {
                    c1727b = (DateFormat) dateFormat2.clone();
                    c1727b.setTimeZone(timeZoneM1016c);
                    if (bool2 != null) {
                        c1727b.setLenient(bool2.booleanValue());
                    }
                }
                return withDateFormat(c1727b, this._formatString);
            }
            if (bool2 != null) {
                DateFormat dateFormat3 = abstractC0718i.f1998g.f2481f.f2426l;
                String strM157o = this._formatString;
                if (dateFormat3.getClass() == C1727B.class) {
                    C1727B c1727b4 = (C1727B) dateFormat3;
                    Boolean bool3 = c1727b4.f6036g;
                    C1727B c1727b5 = c1727b4;
                    if (bool2 != bool3) {
                        c1727b5 = c1727b4;
                        if (!bool2.equals(bool3)) {
                            c1727b5 = new C1727B(c1727b4.f6034e, c1727b4.f6035f, bool2, c1727b4.f6039j);
                        }
                    }
                    StringBuilder sb = new StringBuilder(100);
                    sb.append("[one of: 'yyyy-MM-dd'T'HH:mm:ss.SSSX', 'EEE, dd MMM yyyy HH:mm:ss zzz' (");
                    strM157o = AbstractC0032g.m157o(sb, Boolean.FALSE.equals(c1727b5.f6036g) ? "strict" : "lenient", ")]");
                    dateFormat = c1727b5;
                } else {
                    DateFormat dateFormat4 = (DateFormat) dateFormat3.clone();
                    dateFormat4.setLenient(bool2.booleanValue());
                    boolean z4 = dateFormat4 instanceof SimpleDateFormat;
                    dateFormat = dateFormat4;
                    if (z4) {
                        ((SimpleDateFormat) dateFormat4).toPattern();
                        dateFormat = dateFormat4;
                    }
                }
                if (strM157o == null) {
                    strM157o = "[unknown]";
                }
                return withDateFormat(dateFormat, strM157o);
            }
        }
        return this;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5900p;
    }

    public abstract DateDeserializers$DateBasedDeserializer<T> withDateFormat(DateFormat dateFormat, String str);

    public DateDeserializers$DateBasedDeserializer(DateDeserializers$DateBasedDeserializer<T> dateDeserializers$DateBasedDeserializer, DateFormat dateFormat, String str) {
        super(dateDeserializers$DateBasedDeserializer._valueClass);
        this._customFormat = dateFormat;
        this._formatString = str;
    }
}
