package com.fasterxml.jackson.databind.ser.std;

import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.EnumC0708J;
import p118m1.C1750o;

/* JADX INFO: loaded from: classes.dex */
public class StdKeySerializers$EnumKeySerializer extends StdSerializer<Object> {
    protected final C1750o _values;
    protected final C1750o _valuesByEnumNaming;

    public StdKeySerializers$EnumKeySerializer(Class<?> cls, C1750o c1750o) {
        super(cls, false);
        this._values = c1750o;
        this._valuesByEnumNaming = null;
    }

    public static StdKeySerializers$EnumKeySerializer construct(Class<?> cls, C1750o c1750o) {
        return new StdKeySerializers$EnumKeySerializer(cls, c1750o);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        if (abstractC0709K.f1966e.m1698r(EnumC0708J.WRITE_ENUMS_USING_TO_STRING)) {
            abstractC0540h.mo1145r(obj.toString());
            return;
        }
        Enum r3 = (Enum) obj;
        C1750o c1750o = this._valuesByEnumNaming;
        if (c1750o != null) {
            abstractC0540h.mo1144q(c1750o.f6124f[r3.ordinal()]);
            return;
        }
        if (abstractC0709K.f1966e.m1698r(EnumC0708J.WRITE_ENUM_KEYS_USING_INDEX)) {
            abstractC0540h.mo1145r(String.valueOf(r3.ordinal()));
        } else {
            abstractC0540h.mo1144q(this._values.f6124f[r3.ordinal()]);
        }
    }

    public static StdKeySerializers$EnumKeySerializer construct(Class<?> cls, C1750o c1750o, C1750o c1750o2) {
        return new StdKeySerializers$EnumKeySerializer(cls, c1750o, c1750o2);
    }

    public StdKeySerializers$EnumKeySerializer(Class<?> cls, C1750o c1750o, C1750o c1750o2) {
        super(cls, false);
        this._values = c1750o;
        this._valuesByEnumNaming = c1750o2;
    }
}
