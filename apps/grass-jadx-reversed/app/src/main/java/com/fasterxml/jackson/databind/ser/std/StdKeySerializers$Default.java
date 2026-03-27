package com.fasterxml.jackson.databind.ser.std;

import java.util.Calendar;
import java.util.Date;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.EnumC0708J;

/* JADX INFO: loaded from: classes.dex */
public class StdKeySerializers$Default extends StdSerializer<Object> {
    static final int TYPE_BYTE_ARRAY = 7;
    static final int TYPE_CALENDAR = 2;
    static final int TYPE_CLASS = 3;
    static final int TYPE_DATE = 1;
    static final int TYPE_ENUM = 4;
    static final int TYPE_INTEGER = 5;
    static final int TYPE_LONG = 6;
    static final int TYPE_TO_STRING = 8;
    protected final int _typeId;

    public StdKeySerializers$Default(int i3, Class<?> cls) {
        super(cls, false);
        this._typeId = i3;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        String strValueOf;
        switch (this._typeId) {
            case 1:
                Date date = (Date) obj;
                abstractC0709K.getClass();
                if (!abstractC0709K.f1966e.m1698r(EnumC0708J.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
                    abstractC0540h.mo1145r(abstractC0709K.m1717o().format(date));
                } else {
                    abstractC0540h.mo1145r(String.valueOf(date.getTime()));
                }
                break;
            case 2:
                long timeInMillis = ((Calendar) obj).getTimeInMillis();
                abstractC0709K.getClass();
                if (!abstractC0709K.f1966e.m1698r(EnumC0708J.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
                    abstractC0540h.mo1145r(abstractC0709K.m1717o().format(new Date(timeInMillis)));
                } else {
                    abstractC0540h.mo1145r(String.valueOf(timeInMillis));
                }
                break;
            case 3:
                abstractC0540h.mo1145r(((Class) obj).getName());
                break;
            case 4:
                if (abstractC0709K.f1966e.m1698r(EnumC0708J.WRITE_ENUMS_USING_TO_STRING)) {
                    strValueOf = obj.toString();
                } else {
                    Enum r4 = (Enum) obj;
                    strValueOf = abstractC0709K.f1966e.m1698r(EnumC0708J.WRITE_ENUM_KEYS_USING_INDEX) ? String.valueOf(r4.ordinal()) : r4.name();
                }
                abstractC0540h.mo1145r(strValueOf);
                break;
            case 5:
            case 6:
                long jLongValue = ((Number) obj).longValue();
                abstractC0540h.getClass();
                abstractC0540h.mo1145r(Long.toString(jLongValue));
                break;
            case 7:
                abstractC0540h.mo1145r(abstractC0709K.f1966e.f2481f.f2429o.m1075e((byte[]) obj));
                break;
            default:
                abstractC0540h.mo1145r(obj.toString());
                break;
        }
    }
}
