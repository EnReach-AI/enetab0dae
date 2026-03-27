package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import p033K0.AbstractC0405c;
import p039M0.C0502q;
import p039M0.EnumC0501p;
import p042N0.AbstractC0540h;
import p042N0.EnumC0544l;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.AbstractC0728s;
import p069X0.EnumC0708J;
import p069X0.InterfaceC0714e;
import p092e1.EnumC1339d;
import p092e1.InterfaceC1338c;
import p112k1.InterfaceC1638f;
import p118m1.C1727B;

/* JADX INFO: loaded from: classes.dex */
public abstract class DateTimeSerializerBase<T> extends StdScalarSerializer<T> implements InterfaceC1638f {
    protected final DateFormat _customFormat;
    protected final AtomicReference<DateFormat> _reusedCustomFormat;
    protected final Boolean _useTimestamp;

    public DateTimeSerializerBase(Class<T> cls, Boolean bool, DateFormat dateFormat) {
        super(cls);
        this._useTimestamp = bool;
        this._customFormat = dateFormat;
        this._reusedCustomFormat = dateFormat == null ? null : new AtomicReference<>();
    }

    public void _acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l, boolean z3) {
        if (z3) {
            visitIntFormat(interfaceC1338c, abstractC0721l, EnumC0544l.f1299f, EnumC1339d.f4770g);
        } else {
            visitStringFormat(interfaceC1338c, abstractC0721l, EnumC1339d.f4769f);
        }
    }

    public boolean _asTimestamp(AbstractC0709K abstractC0709K) {
        Boolean bool = this._useTimestamp;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (this._customFormat != null) {
            return false;
        }
        if (abstractC0709K == null) {
            throw new IllegalArgumentException("Null SerializerProvider passed for ".concat(handledType().getName()));
        }
        return abstractC0709K.f1966e.m1698r(EnumC0708J.WRITE_DATES_AS_TIMESTAMPS);
    }

    public void _serializeAsString(Date date, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        if (this._customFormat == null) {
            abstractC0709K.getClass();
            if (abstractC0709K.f1966e.m1698r(EnumC0708J.WRITE_DATES_AS_TIMESTAMPS)) {
                abstractC0540h.mo1150w(date.getTime());
                return;
            } else {
                abstractC0540h.mo1125R(abstractC0709K.m1717o().format(date));
                return;
            }
        }
        DateFormat andSet = this._reusedCustomFormat.getAndSet(null);
        if (andSet == null) {
            andSet = (DateFormat) this._customFormat.clone();
        }
        abstractC0540h.mo1125R(andSet.format(date));
        AtomicReference<DateFormat> atomicReference = this._reusedCustomFormat;
        while (!atomicReference.compareAndSet(null, andSet) && atomicReference.get() == null) {
        }
    }

    public abstract long _timestamp(T t3);

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        ((AbstractC0405c) interfaceC1338c).getClass();
        _acceptJsonFormatVisitor(interfaceC1338c, abstractC0721l, _asTimestamp(null));
    }

    @Override // p112k1.InterfaceC1638f
    public AbstractC0728s createContextual(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e) {
        C0502q c0502qFindFormatOverrides = findFormatOverrides(abstractC0709K, interfaceC0714e, handledType());
        if (c0502qFindFormatOverrides == null) {
            return this;
        }
        EnumC0501p enumC0501p = c0502qFindFormatOverrides.f1170f;
        if (enumC0501p.m1013a()) {
            return withFormat2(Boolean.TRUE, null);
        }
        String str = c0502qFindFormatOverrides.f1169e;
        boolean z3 = str != null && str.length() > 0;
        Locale locale = c0502qFindFormatOverrides.f1171g;
        if (z3) {
            if (locale == null) {
                locale = abstractC0709K.f1966e.f2481f.f2427m;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
            simpleDateFormat.setTimeZone(c0502qFindFormatOverrides.m1017d() ? c0502qFindFormatOverrides.m1016c() : abstractC0709K.f1966e.m2154i());
            return withFormat2(Boolean.FALSE, simpleDateFormat);
        }
        boolean z4 = locale != null;
        boolean zM1017d = c0502qFindFormatOverrides.m1017d();
        boolean z5 = enumC0501p == EnumC0501p.f1165m;
        if (!z4 && !zM1017d && !z5) {
            return this;
        }
        DateFormat dateFormat = abstractC0709K.f1966e.f2481f.f2426l;
        if (dateFormat instanceof C1727B) {
            C1727B c1727b = (C1727B) dateFormat;
            if (locale != null && !locale.equals(c1727b.f6035f)) {
                c1727b = new C1727B(c1727b.f6034e, locale, c1727b.f6036g, c1727b.f6039j);
            }
            if (c0502qFindFormatOverrides.m1017d()) {
                TimeZone timeZoneM1016c = c0502qFindFormatOverrides.m1016c();
                c1727b.getClass();
                if (timeZoneM1016c == null) {
                    timeZoneM1016c = C1727B.f6029n;
                }
                TimeZone timeZone = c1727b.f6034e;
                if (timeZoneM1016c != timeZone && !timeZoneM1016c.equals(timeZone)) {
                    c1727b = new C1727B(timeZoneM1016c, c1727b.f6035f, c1727b.f6036g, c1727b.f6039j);
                }
            }
            return withFormat2(Boolean.FALSE, c1727b);
        }
        if (dateFormat instanceof SimpleDateFormat) {
            SimpleDateFormat simpleDateFormat2 = (SimpleDateFormat) dateFormat;
            SimpleDateFormat simpleDateFormat3 = z4 ? new SimpleDateFormat(simpleDateFormat2.toPattern(), locale) : (SimpleDateFormat) simpleDateFormat2.clone();
            TimeZone timeZoneM1016c2 = c0502qFindFormatOverrides.m1016c();
            if (timeZoneM1016c2 != null && !timeZoneM1016c2.equals(simpleDateFormat3.getTimeZone())) {
                simpleDateFormat3.setTimeZone(timeZoneM1016c2);
            }
            return withFormat2(Boolean.FALSE, simpleDateFormat3);
        }
        abstractC0709K.m1815j(handledType(), "Configured `DateFormat` (" + dateFormat.getClass().getName() + ") not a `SimpleDateFormat`; cannot configure `Locale` or `TimeZone`");
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
        return createSchemaNode(_asTimestamp(abstractC0709K) ? "number" : "string", true);
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, T t3) {
        return false;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public abstract void serialize(T t3, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K);

    /* JADX INFO: renamed from: withFormat */
    public abstract DateTimeSerializerBase<T> withFormat2(Boolean bool, DateFormat dateFormat);
}
