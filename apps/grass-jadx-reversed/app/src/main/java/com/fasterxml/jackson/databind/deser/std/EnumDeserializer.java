package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import com.fasterxml.jackson.databind.deser.AbstractC1208x;
import com.fasterxml.jackson.databind.deser.InterfaceC1139f;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import p039M0.EnumC0499n;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;
import p069X0.C0717h;
import p069X0.EnumC0719j;
import p069X0.EnumC0731v;
import p069X0.InterfaceC0714e;
import p071Y0.InterfaceC0738b;
import p074Z0.EnumC0816b;
import p074Z0.EnumC0819e;
import p078a1.C0850b;
import p078a1.C0851c;
import p082b1.C1043n;
import p114l1.EnumC1664f;
import p118m1.AbstractC1745j;
import p118m1.C1746k;
import p118m1.C1749n;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class EnumDeserializer extends StdScalarDeserializer<Object> implements InterfaceC1139f {
    private static final long serialVersionUID = 1;
    protected final Boolean _caseInsensitive;
    private final Enum<?> _enumDefaultValue;
    protected Object[] _enumsByIndex;
    protected final boolean _isFromIntValue;
    protected final C1746k _lookupByEnumNaming;
    protected final C1746k _lookupByName;
    protected volatile C1746k _lookupByToString;
    private Boolean _useDefaultValueForUnknownEnum;
    private Boolean _useNullForUnknownEnum;

    public EnumDeserializer(C1749n c1749n, Boolean bool) {
        this(c1749n, bool.booleanValue(), null);
    }

    private final Object _deserializeAltString(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, C1746k c1746k, String str) throws C0851c {
        char cCharAt;
        Object obj;
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            if (useDefaultValueForUnknownEnum(abstractC0718i)) {
                return this._enumDefaultValue;
            }
            if (useNullForUnknownEnum(abstractC0718i)) {
                return null;
            }
            int iOrdinal = (str.isEmpty() ? _checkCoercionFail(abstractC0718i, _findCoercionFromEmptyString(abstractC0718i), handledType(), str, "empty String (\"\")") : _checkCoercionFail(abstractC0718i, _findCoercionFromBlankString(abstractC0718i), handledType(), str, "blank String (all whitespace)")).ordinal();
            if (iOrdinal == 1 || iOrdinal == 3) {
                return getEmptyValue(abstractC0718i);
            }
            return null;
        }
        if (Boolean.TRUE.equals(this._caseInsensitive)) {
            Object[] objArr = c1746k.f6116g;
            int length = objArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    obj = null;
                    break;
                }
                Object obj2 = objArr[i3];
                if (obj2 != null && ((String) obj2).equalsIgnoreCase(strTrim)) {
                    obj = objArr[i3 + 1];
                    break;
                }
                i3 += 2;
            }
            if (obj != null) {
                return obj;
            }
        }
        if (!abstractC0718i.m1833K(EnumC0719j.FAIL_ON_NUMBERS_FOR_ENUMS) && !this._isFromIntValue && (cCharAt = strTrim.charAt(0)) >= '0' && cCharAt <= '9') {
            try {
                int i4 = Integer.parseInt(strTrim);
                if (!abstractC0718i.f1998g.m2157l(EnumC0731v.ALLOW_COERCION_OF_SCALARS)) {
                    abstractC0718i.m1829G(_enumClass(), strTrim, "value looks like quoted Enum index, but `MapperFeature.ALLOW_COERCION_OF_SCALARS` prevents use", new Object[0]);
                    throw null;
                }
                if (i4 >= 0) {
                    Object[] objArr2 = this._enumsByIndex;
                    if (i4 < objArr2.length) {
                        return objArr2[i4];
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        if (useDefaultValueForUnknownEnum(abstractC0718i)) {
            return this._enumDefaultValue;
        }
        if (useNullForUnknownEnum(abstractC0718i)) {
            return null;
        }
        Class<?> cls_enumClass = _enumClass();
        Object[] objArr3 = c1746k.f6116g;
        int length2 = objArr3.length;
        ArrayList arrayList = new ArrayList(length2 >> 2);
        for (int i5 = 0; i5 < length2; i5 += 2) {
            Object obj3 = objArr3[i5];
            if (obj3 != null) {
                arrayList.add((String) obj3);
            }
        }
        abstractC0718i.m1829G(cls_enumClass, strTrim, "not one of the values accepted for Enum class: %s", arrayList);
        throw null;
    }

    private C1746k _resolveCurrentLookup(AbstractC0718i abstractC0718i) {
        C1746k c1746k = this._lookupByEnumNaming;
        return c1746k != null ? c1746k : abstractC0718i.m1833K(EnumC0719j.READ_ENUMS_USING_TO_STRING) ? _getToStringLookup(abstractC0718i) : this._lookupByName;
    }

    @Deprecated
    public static AbstractC0722m deserializerForCreator(C0717h c0717h, Class<?> cls, C1043n c1043n) {
        return deserializerForCreator(c0717h, cls, c1043n, null, null);
    }

    public static AbstractC0722m deserializerForNoArgsCreator(C0717h c0717h, Class<?> cls, C1043n c1043n) {
        c0717h.getClass();
        if (c0717h.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            AbstractC1745j.m3882e(c1043n.f3704h, c0717h.m2157l(EnumC0731v.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return new FactoryBasedEnumDeserializer(cls, c1043n);
    }

    public Object _deserializeOther(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        if (abstractC0545m.mo1168M(EnumC0548p.START_ARRAY)) {
            return _deserializeFromArray(abstractC0545m, abstractC0718i);
        }
        abstractC0718i.m1825C(abstractC0545m, _enumClass());
        throw null;
    }

    public Class<?> _enumClass() {
        return handledType();
    }

    public Object _fromInteger(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, int i3) throws C0851c {
        EnumC0816b enumC0816bM1850o = abstractC0718i.m1850o(logicalType(), handledType(), EnumC0819e.f2439e);
        if (enumC0816bM1850o == EnumC0816b.f2430e) {
            if (abstractC0718i.m1833K(EnumC0719j.FAIL_ON_NUMBERS_FOR_ENUMS)) {
                abstractC0718i.m1828F(_enumClass(), Integer.valueOf(i3), "not allowed to deserialize Enum value out of number: disable DeserializationConfig.DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS to allow", new Object[0]);
                throw null;
            }
            _checkCoercionFail(abstractC0718i, enumC0816bM1850o, handledType(), Integer.valueOf(i3), "Integer value (" + i3 + ")");
        }
        int iOrdinal = enumC0816bM1850o.ordinal();
        if (iOrdinal == 2) {
            return null;
        }
        if (iOrdinal == 3) {
            return getEmptyValue(abstractC0718i);
        }
        if (i3 >= 0) {
            Object[] objArr = this._enumsByIndex;
            if (i3 < objArr.length) {
                return objArr[i3];
            }
        }
        if (useDefaultValueForUnknownEnum(abstractC0718i)) {
            return this._enumDefaultValue;
        }
        if (useNullForUnknownEnum(abstractC0718i)) {
            return null;
        }
        abstractC0718i.m1828F(_enumClass(), Integer.valueOf(i3), "index value outside legal index range [0..%s]", Integer.valueOf(this._enumsByIndex.length - 1));
        throw null;
    }

    public Object _fromString(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, String str) {
        Object objM3904a;
        C1746k c1746k_resolveCurrentLookup = _resolveCurrentLookup(abstractC0718i);
        Object objM3904a2 = c1746k_resolveCurrentLookup.m3904a(str);
        if (objM3904a2 != null) {
            return objM3904a2;
        }
        String strTrim = str.trim();
        return (strTrim == str || (objM3904a = c1746k_resolveCurrentLookup.m3904a(strTrim)) == null) ? _deserializeAltString(abstractC0545m, abstractC0718i, c1746k_resolveCurrentLookup, strTrim) : objM3904a;
    }

    public C1746k _getToStringLookup(AbstractC0718i abstractC0718i) {
        C1746k c1746k = this._lookupByToString;
        if (c1746k == null) {
            synchronized (this) {
                try {
                    c1746k = this._lookupByToString;
                    if (c1746k == null) {
                        C1746k c1746kM3907b = C1749n.m3906c(abstractC0718i.f1998g, _enumClass()).m3907b();
                        this._lookupByToString = c1746kM3907b;
                        c1746k = c1746kM3907b;
                    }
                } finally {
                }
            }
        }
        return c1746k;
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1139f
    public AbstractC0722m createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) {
        return withResolved((Boolean) Optional.ofNullable(findFormatFeature(abstractC0718i, interfaceC0714e, handledType(), EnumC0499n.f1148f)).orElse(this._caseInsensitive), (Boolean) Optional.ofNullable(findFormatFeature(abstractC0718i, interfaceC0714e, handledType(), EnumC0499n.f1150h)).orElse(this._useDefaultValueForUnknownEnum), (Boolean) Optional.ofNullable(findFormatFeature(abstractC0718i, interfaceC0714e, handledType(), EnumC0499n.f1149g)).orElse(this._useNullForUnknownEnum));
    }

    @Override // p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        if (abstractC0545m.mo1168M(EnumC0548p.VALUE_STRING)) {
            return _fromString(abstractC0545m, abstractC0718i, abstractC0545m.mo1157B());
        }
        if (abstractC0545m.mo1168M(EnumC0548p.VALUE_NUMBER_INT)) {
            return this._isFromIntValue ? _fromString(abstractC0545m, abstractC0718i, abstractC0545m.mo1157B()) : _fromInteger(abstractC0545m, abstractC0718i, abstractC0545m.mo1204s());
        }
        if (!abstractC0545m.mo1173R()) {
            return _deserializeOther(abstractC0545m, abstractC0718i);
        }
        abstractC0718i.m1825C(abstractC0545m, this._valueClass);
        throw null;
    }

    @Override // p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return this._enumDefaultValue;
    }

    @Override // p069X0.AbstractC0722m
    public boolean isCachable() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5897m;
    }

    public boolean useDefaultValueForUnknownEnum(AbstractC0718i abstractC0718i) {
        return this._enumDefaultValue != null && (Boolean.TRUE.equals(this._useDefaultValueForUnknownEnum) || abstractC0718i.m1833K(EnumC0719j.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE));
    }

    public boolean useNullForUnknownEnum(AbstractC0718i abstractC0718i) {
        return Boolean.TRUE.equals(this._useNullForUnknownEnum) || abstractC0718i.m1833K(EnumC0719j.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
    }

    public EnumDeserializer withResolved(Boolean bool, Boolean bool2, Boolean bool3) {
        return (Objects.equals(this._caseInsensitive, bool) && Objects.equals(this._useDefaultValueForUnknownEnum, bool2) && Objects.equals(this._useNullForUnknownEnum, bool3)) ? this : new EnumDeserializer(this, bool, bool2, bool3);
    }

    public EnumDeserializer(EnumDeserializer enumDeserializer, Boolean bool, Boolean bool2, Boolean bool3) {
        super(enumDeserializer);
        this._lookupByName = enumDeserializer._lookupByName;
        this._enumsByIndex = enumDeserializer._enumsByIndex;
        this._enumDefaultValue = enumDeserializer._enumDefaultValue;
        this._caseInsensitive = bool;
        this._isFromIntValue = enumDeserializer._isFromIntValue;
        this._useDefaultValueForUnknownEnum = bool2;
        this._useNullForUnknownEnum = bool3;
        this._lookupByEnumNaming = enumDeserializer._lookupByEnumNaming;
    }

    public static AbstractC0722m deserializerForCreator(C0717h c0717h, Class<?> cls, C1043n c1043n, AbstractC1208x abstractC1208x, AbstractC1204t[] abstractC1204tArr) {
        c0717h.getClass();
        if (c0717h.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            AbstractC1745j.m3882e(c1043n.f3704h, c0717h.m2157l(EnumC0731v.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return new FactoryBasedEnumDeserializer(cls, c1043n, c1043n.mo2791t(0), abstractC1208x, abstractC1204tArr);
    }

    @Deprecated
    public EnumDeserializer withResolved(Boolean bool) {
        return withResolved(bool, this._useDefaultValueForUnknownEnum, this._useNullForUnknownEnum);
    }

    @Deprecated
    public EnumDeserializer(EnumDeserializer enumDeserializer, Boolean bool) {
        this(enumDeserializer, bool, null, null);
    }

    @Deprecated
    public EnumDeserializer(C1749n c1749n) {
        this(c1749n, (Boolean) null);
    }

    public EnumDeserializer(C1749n c1749n, boolean z3, C1749n c1749n2) {
        super((Class<?>) c1749n.f6117e);
        this._lookupByName = c1749n.m3907b();
        this._enumsByIndex = c1749n.f6118f;
        this._enumDefaultValue = c1749n.f6120h;
        this._caseInsensitive = Boolean.valueOf(z3);
        this._isFromIntValue = c1749n.f6122j;
        this._lookupByEnumNaming = c1749n2 == null ? null : c1749n2.m3907b();
    }
}
