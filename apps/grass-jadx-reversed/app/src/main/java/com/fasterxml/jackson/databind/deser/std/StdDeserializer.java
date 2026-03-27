package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.exc.AbstractC1132c;
import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import com.fasterxml.jackson.databind.deser.AbstractC1208x;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import com.fasterxml.jackson.databind.deser.impl.C1160l;
import com.fasterxml.jackson.databind.deser.impl.C1164p;
import com.fasterxml.jackson.databind.deser.impl.C1165q;
import com.fasterxml.jackson.databind.deser.impl.C1166r;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import p001A.C0009j;
import p005B.AbstractC0032g;
import p039M0.C0502q;
import p039M0.EnumC0481b0;
import p039M0.EnumC0499n;
import p042N0.AbstractC0545m;
import p042N0.EnumC0544l;
import p042N0.EnumC0548p;
import p042N0.EnumC0552t;
import p042N0.EnumC0554v;
import p050Q0.AbstractC0594g;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.AbstractC0730u;
import p069X0.C0702D;
import p069X0.EnumC0719j;
import p069X0.EnumC0731v;
import p069X0.InterfaceC0714e;
import p074Z0.EnumC0816b;
import p074Z0.EnumC0819e;
import p078a1.C0850b;
import p078a1.C0851c;
import p078a1.C0855g;
import p082b1.AbstractC1041l;
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;
import p118m1.AbstractC1745j;
import p118m1.EnumC1736a;
import p118m1.InterfaceC1748m;
import p136r.AbstractC1849h;

/* JADX INFO: loaded from: classes.dex */
public abstract class StdDeserializer<T> extends AbstractC0722m implements Serializable {
    private static final long serialVersionUID = 1;
    protected final Class<?> _valueClass;
    protected final AbstractC0721l _valueType;
    protected static final int F_MASK_INT_COERCIONS = EnumC0719j.USE_BIG_INTEGER_FOR_INTS.f2035f | EnumC0719j.USE_LONG_FOR_INTS.f2035f;

    @Deprecated
    protected static final int F_MASK_ACCEPT_ARRAYS = EnumC0719j.UNWRAP_SINGLE_VALUE_ARRAYS.f2035f | EnumC0719j.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT.f2035f;

    public StdDeserializer(Class<?> cls) {
        this._valueClass = cls;
        this._valueType = null;
    }

    public static final boolean _isBlank(String str) {
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (str.charAt(i3) > ' ') {
                return false;
            }
        }
        return true;
    }

    public static final boolean _neitherNull(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? false : true;
    }

    public static final double _parseDouble(String str) {
        return _parseDouble(str, false);
    }

    public final boolean _byteOverflow(int i3) {
        return i3 < -128 || i3 > 255;
    }

    public EnumC0816b _checkBooleanToStringCoercion(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Class<?> cls) {
        return _checkToStringCoercion(abstractC0545m, abstractC0718i, cls, Boolean.valueOf(abstractC0545m.mo1194i()), EnumC0819e.f2441g);
    }

    public EnumC0816b _checkCoercionFail(AbstractC0718i abstractC0718i, EnumC0816b enumC0816b, Class<?> cls, Object obj, String str) throws C0851c {
        if (enumC0816b != EnumC0816b.f2430e) {
            return enumC0816b;
        }
        Object[] objArr = {str, _coercedTypeDesc(cls)};
        abstractC0718i.getClass();
        throw new C0851c(abstractC0718i.f2002k, String.format("Cannot coerce %s to %s (but could if coercion was enabled using `CoercionConfig`)", objArr), obj);
    }

    public Double _checkDoubleSpecialValue(String str) {
        if (str.isEmpty()) {
            return null;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == '-') {
            if (_isNegInf(str)) {
                return Double.valueOf(Double.NEGATIVE_INFINITY);
            }
            return null;
        }
        if (cCharAt == 'I') {
            if (_isPosInf(str)) {
                return Double.valueOf(Double.POSITIVE_INFINITY);
            }
            return null;
        }
        if (cCharAt == 'N' && _isNaN(str)) {
            return Double.valueOf(Double.NaN);
        }
        return null;
    }

    public Float _checkFloatSpecialValue(String str) {
        if (str.isEmpty()) {
            return null;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == '-') {
            if (_isNegInf(str)) {
                return Float.valueOf(Float.NEGATIVE_INFINITY);
            }
            return null;
        }
        if (cCharAt == 'I') {
            if (_isPosInf(str)) {
                return Float.valueOf(Float.POSITIVE_INFINITY);
            }
            return null;
        }
        if (cCharAt == 'N' && _isNaN(str)) {
            return Float.valueOf(Float.NaN);
        }
        return null;
    }

    public EnumC0816b _checkFloatToIntCoercion(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Class<?> cls) {
        EnumC0816b enumC0816bM1850o = abstractC0718i.m1850o(EnumC1664f.f5894j, cls, EnumC0819e.f2440f);
        if (enumC0816bM1850o != EnumC0816b.f2430e) {
            return enumC0816bM1850o;
        }
        return _checkCoercionFail(abstractC0718i, enumC0816bM1850o, cls, abstractC0545m.mo1207v(), "Floating-point value (" + abstractC0545m.mo1157B() + ")");
    }

    public EnumC0816b _checkFloatToStringCoercion(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Class<?> cls) {
        return _checkToStringCoercion(abstractC0545m, abstractC0718i, cls, abstractC0545m.mo1207v(), EnumC0819e.f2440f);
    }

    public EnumC0816b _checkFromStringCoercion(AbstractC0718i abstractC0718i, String str) {
        return _checkFromStringCoercion(abstractC0718i, str, logicalType(), handledType());
    }

    public EnumC0816b _checkIntToFloatCoercion(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Class<?> cls) {
        EnumC0816b enumC0816bM1850o = abstractC0718i.m1850o(EnumC1664f.f5895k, cls, EnumC0819e.f2439e);
        if (enumC0816bM1850o != EnumC0816b.f2430e) {
            return enumC0816bM1850o;
        }
        return _checkCoercionFail(abstractC0718i, enumC0816bM1850o, cls, abstractC0545m.mo1207v(), "Integer value (" + abstractC0545m.mo1157B() + ")");
    }

    public EnumC0816b _checkIntToStringCoercion(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Class<?> cls) {
        return _checkToStringCoercion(abstractC0545m, abstractC0718i, cls, abstractC0545m.mo1207v(), EnumC0819e.f2439e);
    }

    public boolean _checkTextualNull(AbstractC0718i abstractC0718i, String str) throws C0850b {
        if (!_hasTextualNull(str)) {
            return false;
        }
        EnumC0731v enumC0731v = EnumC0731v.ALLOW_COERCION_OF_SCALARS;
        if (!abstractC0718i.f1998g.m2157l(enumC0731v)) {
            _reportFailedNullCoerce(abstractC0718i, true, enumC0731v, "String \"null\"");
        }
        return true;
    }

    public EnumC0816b _checkToStringCoercion(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Class<?> cls, Object obj, EnumC0819e enumC0819e) {
        EnumC0816b enumC0816bM1850o = abstractC0718i.m1850o(EnumC1664f.f5898n, cls, enumC0819e);
        if (enumC0816bM1850o != EnumC0816b.f2430e) {
            return enumC0816bM1850o;
        }
        return _checkCoercionFail(abstractC0718i, enumC0816bM1850o, cls, obj, enumC0819e.name() + " value (" + abstractC0545m.mo1157B() + ")");
    }

    public Boolean _coerceBooleanFromInt(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Class<?> cls) throws C0851c {
        EnumC0816b enumC0816bM1850o = abstractC0718i.m1850o(EnumC1664f.f5896l, cls, EnumC0819e.f2439e);
        int iOrdinal = enumC0816bM1850o.ordinal();
        if (iOrdinal == 0) {
            _checkCoercionFail(abstractC0718i, enumC0816bM1850o, cls, abstractC0545m.mo1207v(), "Integer value (" + abstractC0545m.mo1157B() + ")");
            return Boolean.FALSE;
        }
        if (iOrdinal == 2) {
            return null;
        }
        if (iOrdinal == 3) {
            return Boolean.FALSE;
        }
        if (abstractC0545m.mo1206u() == EnumC0544l.f1298e) {
            return Boolean.valueOf(abstractC0545m.mo1204s() != 0);
        }
        return Boolean.valueOf(!"0".equals(abstractC0545m.mo1157B()));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Deprecated
    public Object _coerceEmptyString(AbstractC0718i abstractC0718i, boolean z3) throws C0850b {
        boolean z4;
        Enum<?> r02;
        EnumC0731v enumC0731v = EnumC0731v.ALLOW_COERCION_OF_SCALARS;
        if (abstractC0718i.f1998g.m2157l(enumC0731v)) {
            if (z3) {
                EnumC0719j enumC0719j = EnumC0719j.FAIL_ON_NULL_FOR_PRIMITIVES;
                if (abstractC0718i.m1833K(enumC0719j)) {
                    z4 = false;
                    r02 = enumC0719j;
                }
            }
            return getNullValue(abstractC0718i);
        }
        z4 = true;
        r02 = enumC0731v;
        _reportFailedNullCoerce(abstractC0718i, z4, r02, "empty String (\"\")");
        return null;
    }

    public Object _coerceIntegral(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return abstractC0718i.m1833K(EnumC0719j.USE_BIG_INTEGER_FOR_INTS) ? abstractC0545m.mo1192g() : abstractC0718i.m1833K(EnumC0719j.USE_LONG_FOR_INTS) ? Long.valueOf(abstractC0545m.mo1205t()) : abstractC0545m.mo1207v();
    }

    @Deprecated
    public Object _coerceNullToken(AbstractC0718i abstractC0718i, boolean z3) throws C0850b {
        if (z3) {
            _verifyNullForPrimitive(abstractC0718i);
        }
        return getNullValue(abstractC0718i);
    }

    @Deprecated
    public Object _coerceTextualNull(AbstractC0718i abstractC0718i, boolean z3) throws C0850b {
        EnumC0731v enumC0731v = EnumC0731v.ALLOW_COERCION_OF_SCALARS;
        if (!abstractC0718i.f1998g.m2157l(enumC0731v)) {
            _reportFailedNullCoerce(abstractC0718i, true, enumC0731v, "String \"null\"");
        }
        return getNullValue(abstractC0718i);
    }

    public String _coercedTypeDesc() {
        String strM3890m;
        AbstractC0721l valueType = getValueType();
        boolean z3 = true;
        if (valueType == null || valueType.f2036e.isPrimitive()) {
            Class<?> clsHandledType = handledType();
            Annotation[] annotationArr = AbstractC1745j.f6110a;
            if (!clsHandledType.isArray() && !Collection.class.isAssignableFrom(clsHandledType) && !Map.class.isAssignableFrom(clsHandledType)) {
                z3 = false;
            }
            strM3890m = AbstractC1745j.m3890m(clsHandledType);
        } else {
            if (!valueType.mo1887v() && !valueType.mo1629b()) {
                z3 = false;
            }
            strM3890m = AbstractC1745j.m3895r(valueType);
        }
        return z3 ? AbstractC0032g.m152j("element of ", strM3890m) : AbstractC1849h.m4117a(strM3890m, " value");
    }

    public T _deserializeFromArray(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        EnumC0816b enumC0816b_findCoercionFromEmptyArray = _findCoercionFromEmptyArray(abstractC0718i);
        boolean zM1833K = abstractC0718i.m1833K(EnumC0719j.UNWRAP_SINGLE_VALUE_ARRAYS);
        if (zM1833K || enumC0816b_findCoercionFromEmptyArray != EnumC0816b.f2430e) {
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            EnumC0548p enumC0548p = EnumC0548p.END_ARRAY;
            if (enumC0548pMo1177V == enumC0548p) {
                int iOrdinal = enumC0816b_findCoercionFromEmptyArray.ordinal();
                if (iOrdinal == 1 || iOrdinal == 2) {
                    return (T) getNullValue(abstractC0718i);
                }
                if (iOrdinal == 3) {
                    return (T) getEmptyValue(abstractC0718i);
                }
            } else if (zM1833K) {
                T t_deserializeWrappedValue = _deserializeWrappedValue(abstractC0545m, abstractC0718i);
                if (abstractC0545m.mo1177V() != enumC0548p) {
                    handleMissingEndArrayForSingle(abstractC0545m, abstractC0718i);
                }
                return t_deserializeWrappedValue;
            }
        }
        abstractC0718i.m1826D(getValueType(abstractC0718i), EnumC0548p.START_ARRAY, abstractC0545m, null, new Object[0]);
        throw null;
    }

    @Deprecated
    public T _deserializeFromEmpty(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        if (!abstractC0545m.mo1168M(EnumC0548p.START_ARRAY) || !abstractC0718i.m1833K(EnumC0719j.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)) {
            abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
            throw null;
        }
        if (abstractC0545m.mo1177V() == EnumC0548p.END_ARRAY) {
            return null;
        }
        abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
        throw null;
    }

    public Object _deserializeFromEmptyString(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, EnumC0816b enumC0816b, Class<?> cls, String str) throws C0851c {
        int iOrdinal = enumC0816b.ordinal();
        if (iOrdinal == 0) {
            _checkCoercionFail(abstractC0718i, enumC0816b, cls, "", "empty String (\"\")");
            return null;
        }
        if (iOrdinal != 3) {
            return null;
        }
        return getEmptyValue(abstractC0718i);
    }

    public T _deserializeFromString(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        AbstractC1208x valueInstantiator = getValueInstantiator();
        Class<?> clsHandledType = handledType();
        String strMo1165J = abstractC0545m.mo1165J();
        if (valueInstantiator != null && valueInstantiator.mo3059h()) {
            return (T) valueInstantiator.mo3068t(abstractC0718i, strMo1165J);
        }
        if (strMo1165J.isEmpty()) {
            return (T) _deserializeFromEmptyString(abstractC0545m, abstractC0718i, abstractC0718i.m1850o(logicalType(), clsHandledType, EnumC0819e.f2444j), clsHandledType, "empty String (\"\")");
        }
        if (_isBlank(strMo1165J)) {
            return (T) _deserializeFromEmptyString(abstractC0545m, abstractC0718i, abstractC0718i.m1851p(logicalType(), clsHandledType), clsHandledType, "blank String (all whitespace)");
        }
        if (valueInstantiator != null) {
            strMo1165J = strMo1165J.trim();
            boolean zMo3056e = valueInstantiator.mo3056e();
            EnumC1664f enumC1664f = EnumC1664f.f5894j;
            EnumC0816b enumC0816b = EnumC0816b.f2431f;
            EnumC0819e enumC0819e = EnumC0819e.f2442h;
            if (zMo3056e && abstractC0718i.m1850o(enumC1664f, Integer.class, enumC0819e) == enumC0816b) {
                return (T) valueInstantiator.mo3066q(abstractC0718i, _parseIntPrimitive(abstractC0718i, strMo1165J));
            }
            if (valueInstantiator.mo3057f() && abstractC0718i.m1850o(enumC1664f, Long.class, enumC0819e) == enumC0816b) {
                return (T) valueInstantiator.mo3067r(abstractC0718i, _parseLongPrimitive(abstractC0718i, strMo1165J));
            }
            if (valueInstantiator.mo3054c() && abstractC0718i.m1850o(EnumC1664f.f5896l, Boolean.class, enumC0819e) == enumC0816b) {
                String strTrim = strMo1165J.trim();
                if ("true".equals(strTrim)) {
                    return (T) valueInstantiator.mo3064o(abstractC0718i, true);
                }
                if ("false".equals(strTrim)) {
                    return (T) valueInstantiator.mo3064o(abstractC0718i, false);
                }
            }
        }
        AbstractC0545m abstractC0545m2 = abstractC0718i.f2002k;
        abstractC0718i.m1860y(clsHandledType, valueInstantiator, "no String-argument constructor/factory method to deserialize from String value ('%s')", strMo1165J);
        throw null;
    }

    public T _deserializeWrappedValue(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return abstractC0545m.mo1168M(EnumC0548p.START_ARRAY) ? (T) handleNestedArrayForSingle(abstractC0545m, abstractC0718i) : (T) deserialize(abstractC0545m, abstractC0718i);
    }

    @Deprecated
    public void _failDoubleToIntCoercion(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, String str) throws C0850b {
        handledType();
        Object[] objArr = {abstractC0545m.mo1165J(), str};
        abstractC0718i.getClass();
        throw new C0850b((Closeable) abstractC0718i.f2002k, String.format("Cannot coerce a floating-point value ('%s') into %s (enable `DeserializationFeature.ACCEPT_FLOAT_AS_INT` to allow)", objArr));
    }

    public EnumC0816b _findCoercionFromBlankString(AbstractC0718i abstractC0718i) {
        return abstractC0718i.m1851p(logicalType(), handledType());
    }

    public EnumC0816b _findCoercionFromEmptyArray(AbstractC0718i abstractC0718i) {
        return abstractC0718i.m1850o(logicalType(), handledType(), EnumC0819e.f2443i);
    }

    public EnumC0816b _findCoercionFromEmptyString(AbstractC0718i abstractC0718i) {
        return abstractC0718i.m1850o(logicalType(), handledType(), EnumC0819e.f2444j);
    }

    public final InterfaceC1178m _findNullProvider(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e, EnumC0481b0 enumC0481b0, AbstractC0722m abstractC0722m) throws C0850b {
        if (enumC0481b0 == EnumC0481b0.f1123f) {
            if (interfaceC0714e == null) {
                return new C1166r(null, abstractC0718i.m1848m(abstractC0722m == null ? Object.class : abstractC0722m.handledType()));
            }
            return new C1166r(interfaceC0714e.mo1803a(), interfaceC0714e.getType());
        }
        if (enumC0481b0 != EnumC0481b0.f1124g) {
            if (enumC0481b0 == EnumC0481b0.f1122e) {
                return C1165q.f4019f;
            }
            return null;
        }
        if (abstractC0722m == null) {
            return null;
        }
        if (abstractC0722m instanceof BeanDeserializerBase) {
            BeanDeserializerBase beanDeserializerBase = (BeanDeserializerBase) abstractC0722m;
            if (!beanDeserializerBase.getValueInstantiator().mo3005j()) {
                abstractC0718i.mo1713k(String.format("Cannot create empty instance of %s, no default Creator", interfaceC0714e == null ? beanDeserializerBase.getValueType() : interfaceC0714e.getType()));
                throw null;
            }
        }
        EnumC1736a emptyAccessPattern = abstractC0722m.getEmptyAccessPattern();
        EnumC1736a enumC1736a = EnumC1736a.f6081e;
        C1165q c1165q = C1165q.f4020g;
        if (emptyAccessPattern == enumC1736a) {
            return c1165q;
        }
        if (emptyAccessPattern != EnumC1736a.f6082f) {
            return new C1164p(abstractC0722m);
        }
        Object emptyValue = abstractC0722m.getEmptyValue(abstractC0718i);
        return emptyValue == null ? c1165q : new C1165q(emptyValue);
    }

    public boolean _hasTextualNull(String str) {
        return "null".equals(str);
    }

    public final boolean _intOverflow(long j2) {
        return j2 < -2147483648L || j2 > 2147483647L;
    }

    @Deprecated
    public boolean _isEmptyOrTextualNull(String str) {
        return str.isEmpty() || "null".equals(str);
    }

    public boolean _isFalse(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt == 'f') {
            return "false".equals(str);
        }
        if (cCharAt == 'F') {
            return "FALSE".equals(str) || "False".equals(str);
        }
        return false;
    }

    public final boolean _isIntNumber(String str) {
        int i3;
        int length = str.length();
        if (length <= 0) {
            return false;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt != '-' && cCharAt != '+') {
            i3 = 0;
        } else {
            if (length == 1) {
                return false;
            }
            i3 = 1;
        }
        while (i3 < length) {
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                return false;
            }
            i3++;
        }
        return true;
    }

    public final boolean _isNaN(String str) {
        return "NaN".equals(str);
    }

    public final boolean _isNegInf(String str) {
        return "-Infinity".equals(str) || "-INF".equals(str);
    }

    public final boolean _isPosInf(String str) {
        return "Infinity".equals(str) || "INF".equals(str);
    }

    public boolean _isTrue(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt == 't') {
            return "true".equals(str);
        }
        if (cCharAt == 'T') {
            return "TRUE".equals(str) || "True".equals(str);
        }
        return false;
    }

    public Number _nonNullNumber(Number number) {
        if (number == null) {
            return 0;
        }
        return number;
    }

    public final Boolean _parseBoolean(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Class<?> cls) throws C0850b {
        int iMo1191f = abstractC0545m.mo1191f();
        if (iMo1191f == 1) {
            abstractC0718i.m1825C(abstractC0545m, cls);
            throw null;
        }
        if (iMo1191f == 3) {
            return (Boolean) _deserializeFromArray(abstractC0545m, abstractC0718i);
        }
        if (iMo1191f != 6) {
            if (iMo1191f == 7) {
                return _coerceBooleanFromInt(abstractC0545m, abstractC0718i, cls);
            }
            switch (iMo1191f) {
                case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                    return Boolean.TRUE;
                case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                    return Boolean.FALSE;
                case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                    return null;
                default:
                    abstractC0718i.m1825C(abstractC0545m, cls);
                    throw null;
            }
        }
        String strMo1157B = abstractC0545m.mo1157B();
        EnumC0816b enumC0816b_checkFromStringCoercion = _checkFromStringCoercion(abstractC0718i, strMo1157B, EnumC1664f.f5896l, cls);
        if (enumC0816b_checkFromStringCoercion == EnumC0816b.f2432g) {
            return null;
        }
        if (enumC0816b_checkFromStringCoercion == EnumC0816b.f2433h) {
            return Boolean.FALSE;
        }
        String strTrim = strMo1157B.trim();
        int length = strTrim.length();
        if (length == 4) {
            if (_isTrue(strTrim)) {
                return Boolean.TRUE;
            }
        } else if (length == 5 && _isFalse(strTrim)) {
            return Boolean.FALSE;
        }
        if (_checkTextualNull(abstractC0718i, strTrim)) {
            return null;
        }
        abstractC0718i.m1829G(cls, strTrim, "only \"true\" or \"false\" recognized", new Object[0]);
        throw null;
    }

    @Deprecated
    public boolean _parseBooleanFromInt(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        _verifyNumberForScalarCoercion(abstractC0718i, abstractC0545m);
        return !"0".equals(abstractC0545m.mo1157B());
    }

    @Deprecated
    public final boolean _parseBooleanPrimitive(AbstractC0718i abstractC0718i, AbstractC0545m abstractC0545m, Class<?> cls) {
        return _parseBooleanPrimitive(abstractC0545m, abstractC0718i);
    }

    public final byte _parseBytePrimitive(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        int iMo1191f = abstractC0545m.mo1191f();
        if (iMo1191f == 1) {
            abstractC0718i.m1825C(abstractC0545m, Byte.TYPE);
            throw null;
        }
        if (iMo1191f != 3) {
            if (iMo1191f == 11) {
                _verifyNullForPrimitive(abstractC0718i);
                return (byte) 0;
            }
            EnumC0816b enumC0816b = EnumC0816b.f2433h;
            EnumC0816b enumC0816b2 = EnumC0816b.f2432g;
            if (iMo1191f == 6) {
                String strMo1157B = abstractC0545m.mo1157B();
                EnumC0816b enumC0816b_checkFromStringCoercion = _checkFromStringCoercion(abstractC0718i, strMo1157B, EnumC1664f.f5894j, Byte.TYPE);
                if (enumC0816b_checkFromStringCoercion == enumC0816b2) {
                    _verifyNullForPrimitive(abstractC0718i);
                    return (byte) 0;
                }
                if (enumC0816b_checkFromStringCoercion == enumC0816b) {
                    return (byte) 0;
                }
                String strTrim = strMo1157B.trim();
                if (_hasTextualNull(strTrim)) {
                    _verifyNullForPrimitiveCoercion(abstractC0718i, strTrim);
                    return (byte) 0;
                }
                try {
                    int iM1349f = AbstractC0594g.m1349f(strTrim);
                    if (!_byteOverflow(iM1349f)) {
                        return (byte) iM1349f;
                    }
                    abstractC0718i.m1829G(this._valueClass, strTrim, "overflow, value cannot be represented as 8-bit value", new Object[0]);
                    throw null;
                } catch (IllegalArgumentException unused) {
                    abstractC0718i.m1829G(this._valueClass, strTrim, "not a valid `byte` value", new Object[0]);
                    throw null;
                }
            }
            if (iMo1191f == 7) {
                return abstractC0545m.mo1195j();
            }
            if (iMo1191f == 8) {
                EnumC0816b enumC0816b_checkFloatToIntCoercion = _checkFloatToIntCoercion(abstractC0545m, abstractC0718i, Byte.TYPE);
                if (enumC0816b_checkFloatToIntCoercion == enumC0816b2 || enumC0816b_checkFloatToIntCoercion == enumC0816b) {
                    return (byte) 0;
                }
                return abstractC0545m.mo1195j();
            }
        } else if (abstractC0718i.m1833K(EnumC0719j.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            if (abstractC0545m.mo1177V() == EnumC0548p.START_ARRAY) {
                return ((Byte) handleNestedArrayForSingle(abstractC0545m, abstractC0718i)).byteValue();
            }
            byte b_parseBytePrimitive = _parseBytePrimitive(abstractC0545m, abstractC0718i);
            _verifyEndArrayForSingle(abstractC0545m, abstractC0718i);
            return b_parseBytePrimitive;
        }
        abstractC0718i.m1824B(abstractC0545m, abstractC0718i.m1848m(Byte.TYPE));
        throw null;
    }

    public Date _parseDate(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        int iMo1191f = abstractC0545m.mo1191f();
        if (iMo1191f == 1) {
            abstractC0718i.m1825C(abstractC0545m, this._valueClass);
            throw null;
        }
        if (iMo1191f == 3) {
            return _parseDateFromArray(abstractC0545m, abstractC0718i);
        }
        if (iMo1191f == 11) {
            return (Date) getNullValue(abstractC0718i);
        }
        if (iMo1191f == 6) {
            return _parseDate(abstractC0545m.mo1157B().trim(), abstractC0718i);
        }
        if (iMo1191f != 7) {
            abstractC0718i.m1825C(abstractC0545m, this._valueClass);
            throw null;
        }
        try {
            return new Date(abstractC0545m.mo1205t());
        } catch (AbstractC1132c unused) {
            abstractC0718i.m1828F(this._valueClass, abstractC0545m.mo1207v(), "not a valid 64-bit `long` for creating `java.util.Date`", new Object[0]);
            throw null;
        }
    }

    public Date _parseDateFromArray(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        EnumC0816b enumC0816b_findCoercionFromEmptyArray = _findCoercionFromEmptyArray(abstractC0718i);
        boolean zM1833K = abstractC0718i.m1833K(EnumC0719j.UNWRAP_SINGLE_VALUE_ARRAYS);
        if (zM1833K || enumC0816b_findCoercionFromEmptyArray != EnumC0816b.f2430e) {
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            if (enumC0548pMo1177V == EnumC0548p.END_ARRAY) {
                int iOrdinal = enumC0816b_findCoercionFromEmptyArray.ordinal();
                if (iOrdinal == 1 || iOrdinal == 2) {
                    return (Date) getNullValue(abstractC0718i);
                }
                if (iOrdinal == 3) {
                    return (Date) getEmptyValue(abstractC0718i);
                }
            } else if (zM1833K) {
                if (enumC0548pMo1177V == EnumC0548p.START_ARRAY) {
                    return (Date) handleNestedArrayForSingle(abstractC0545m, abstractC0718i);
                }
                Date date_parseDate = _parseDate(abstractC0545m, abstractC0718i);
                _verifyEndArrayForSingle(abstractC0545m, abstractC0718i);
                return date_parseDate;
            }
        }
        abstractC0718i.m1826D(abstractC0718i.m1848m(this._valueClass), EnumC0548p.START_ARRAY, abstractC0545m, null, new Object[0]);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
    
        if (r0 == 8) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final double _parseDoublePrimitive(p042N0.AbstractC0545m r8, p069X0.AbstractC0718i r9) throws p078a1.C0850b {
        /*
            r7 = this;
            int r0 = r8.mo1191f()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L91
            r1 = 3
            if (r0 == r1) goto L68
            r1 = 11
            r3 = 0
            if (r0 == r1) goto L64
            Z0.b r1 = p074Z0.EnumC0816b.f2433h
            Z0.b r5 = p074Z0.EnumC0816b.f2432g
            r6 = 6
            if (r0 == r6) goto L31
            r6 = 7
            if (r0 == r6) goto L20
            r1 = 8
            if (r0 != r1) goto L8b
            goto L2c
        L20:
            java.lang.Class r0 = java.lang.Double.TYPE
            Z0.b r9 = r7._checkIntToFloatCoercion(r8, r9, r0)
            if (r9 != r5) goto L29
            return r3
        L29:
            if (r9 != r1) goto L2c
            return r3
        L2c:
            double r8 = r8.mo1201p()
            return r8
        L31:
            java.lang.String r0 = r8.mo1157B()
            java.lang.Double r2 = r7._checkDoubleSpecialValue(r0)
            if (r2 == 0) goto L40
            double r8 = r2.doubleValue()
            return r8
        L40:
            l1.f r2 = p114l1.EnumC1664f.f5894j
            java.lang.Class r6 = java.lang.Double.TYPE
            Z0.b r2 = r7._checkFromStringCoercion(r9, r0, r2, r6)
            if (r2 != r5) goto L4e
            r7._verifyNullForPrimitive(r9)
            return r3
        L4e:
            if (r2 != r1) goto L51
            return r3
        L51:
            java.lang.String r0 = r0.trim()
            boolean r1 = r7._hasTextualNull(r0)
            if (r1 == 0) goto L5f
            r7._verifyNullForPrimitiveCoercion(r9, r0)
            return r3
        L5f:
            double r8 = r7._parseDoublePrimitive(r8, r9, r0)
            return r8
        L64:
            r7._verifyNullForPrimitive(r9)
            return r3
        L68:
            X0.j r0 = p069X0.EnumC0719j.UNWRAP_SINGLE_VALUE_ARRAYS
            boolean r0 = r9.m1833K(r0)
            if (r0 == 0) goto L8b
            N0.p r0 = r8.mo1177V()
            N0.p r1 = p042N0.EnumC0548p.START_ARRAY
            if (r0 != r1) goto L83
            java.lang.Object r8 = r7.handleNestedArrayForSingle(r8, r9)
            java.lang.Double r8 = (java.lang.Double) r8
            double r8 = r8.doubleValue()
            return r8
        L83:
            double r0 = r7._parseDoublePrimitive(r8, r9)
            r7._verifyEndArrayForSingle(r8, r9)
            return r0
        L8b:
            java.lang.Class r0 = java.lang.Double.TYPE
            r9.m1825C(r8, r0)
            throw r2
        L91:
            java.lang.Class r0 = java.lang.Double.TYPE
            r9.m1825C(r8, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StdDeserializer._parseDoublePrimitive(N0.m, X0.i):double");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        if (r0 == 8) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float _parseFloatPrimitive(p042N0.AbstractC0545m r7, p069X0.AbstractC0718i r8) throws p078a1.C0850b {
        /*
            r6 = this;
            int r0 = r7.mo1191f()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L90
            r1 = 3
            if (r0 == r1) goto L67
            r1 = 11
            r3 = 0
            if (r0 == r1) goto L63
            Z0.b r1 = p074Z0.EnumC0816b.f2433h
            Z0.b r4 = p074Z0.EnumC0816b.f2432g
            r5 = 6
            if (r0 == r5) goto L30
            r5 = 7
            if (r0 == r5) goto L1f
            r1 = 8
            if (r0 != r1) goto L8a
            goto L2b
        L1f:
            java.lang.Class r0 = java.lang.Float.TYPE
            Z0.b r8 = r6._checkIntToFloatCoercion(r7, r8, r0)
            if (r8 != r4) goto L28
            return r3
        L28:
            if (r8 != r1) goto L2b
            return r3
        L2b:
            float r7 = r7.mo1203r()
            return r7
        L30:
            java.lang.String r0 = r7.mo1157B()
            java.lang.Float r2 = r6._checkFloatSpecialValue(r0)
            if (r2 == 0) goto L3f
            float r7 = r2.floatValue()
            return r7
        L3f:
            l1.f r2 = p114l1.EnumC1664f.f5894j
            java.lang.Class r5 = java.lang.Float.TYPE
            Z0.b r2 = r6._checkFromStringCoercion(r8, r0, r2, r5)
            if (r2 != r4) goto L4d
            r6._verifyNullForPrimitive(r8)
            return r3
        L4d:
            if (r2 != r1) goto L50
            return r3
        L50:
            java.lang.String r0 = r0.trim()
            boolean r1 = r6._hasTextualNull(r0)
            if (r1 == 0) goto L5e
            r6._verifyNullForPrimitiveCoercion(r8, r0)
            return r3
        L5e:
            float r7 = r6._parseFloatPrimitive(r7, r8, r0)
            return r7
        L63:
            r6._verifyNullForPrimitive(r8)
            return r3
        L67:
            X0.j r0 = p069X0.EnumC0719j.UNWRAP_SINGLE_VALUE_ARRAYS
            boolean r0 = r8.m1833K(r0)
            if (r0 == 0) goto L8a
            N0.p r0 = r7.mo1177V()
            N0.p r1 = p042N0.EnumC0548p.START_ARRAY
            if (r0 != r1) goto L82
            java.lang.Object r7 = r6.handleNestedArrayForSingle(r7, r8)
            java.lang.Float r7 = (java.lang.Float) r7
            float r7 = r7.floatValue()
            return r7
        L82:
            float r0 = r6._parseFloatPrimitive(r7, r8)
            r6._verifyEndArrayForSingle(r7, r8)
            return r0
        L8a:
            java.lang.Class r0 = java.lang.Float.TYPE
            r8.m1825C(r7, r0)
            throw r2
        L90:
            java.lang.Class r0 = java.lang.Float.TYPE
            r8.m1825C(r7, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StdDeserializer._parseFloatPrimitive(N0.m, X0.i):float");
    }

    public final int _parseIntPrimitive(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        int iMo1191f = abstractC0545m.mo1191f();
        if (iMo1191f == 1) {
            abstractC0718i.m1825C(abstractC0545m, Integer.TYPE);
            throw null;
        }
        if (iMo1191f != 3) {
            if (iMo1191f == 11) {
                _verifyNullForPrimitive(abstractC0718i);
                return 0;
            }
            EnumC0816b enumC0816b = EnumC0816b.f2433h;
            EnumC0816b enumC0816b2 = EnumC0816b.f2432g;
            if (iMo1191f == 6) {
                String strMo1157B = abstractC0545m.mo1157B();
                EnumC0816b enumC0816b_checkFromStringCoercion = _checkFromStringCoercion(abstractC0718i, strMo1157B, EnumC1664f.f5894j, Integer.TYPE);
                if (enumC0816b_checkFromStringCoercion == enumC0816b2) {
                    _verifyNullForPrimitive(abstractC0718i);
                    return 0;
                }
                if (enumC0816b_checkFromStringCoercion == enumC0816b) {
                    return 0;
                }
                String strTrim = strMo1157B.trim();
                if (!_hasTextualNull(strTrim)) {
                    return _parseIntPrimitive(abstractC0718i, strTrim);
                }
                _verifyNullForPrimitiveCoercion(abstractC0718i, strTrim);
                return 0;
            }
            if (iMo1191f == 7) {
                return abstractC0545m.mo1204s();
            }
            if (iMo1191f == 8) {
                EnumC0816b enumC0816b_checkFloatToIntCoercion = _checkFloatToIntCoercion(abstractC0545m, abstractC0718i, Integer.TYPE);
                if (enumC0816b_checkFloatToIntCoercion == enumC0816b2 || enumC0816b_checkFloatToIntCoercion == enumC0816b) {
                    return 0;
                }
                return abstractC0545m.mo1163H();
            }
        } else if (abstractC0718i.m1833K(EnumC0719j.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            if (abstractC0545m.mo1177V() == EnumC0548p.START_ARRAY) {
                return ((Integer) handleNestedArrayForSingle(abstractC0545m, abstractC0718i)).intValue();
            }
            int i_parseIntPrimitive = _parseIntPrimitive(abstractC0545m, abstractC0718i);
            _verifyEndArrayForSingle(abstractC0545m, abstractC0718i);
            return i_parseIntPrimitive;
        }
        abstractC0718i.m1825C(abstractC0545m, Integer.TYPE);
        throw null;
    }

    public final Integer _parseInteger(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Class<?> cls) throws C0850b {
        int iMo1191f = abstractC0545m.mo1191f();
        if (iMo1191f == 1) {
            abstractC0718i.m1825C(abstractC0545m, cls);
            throw null;
        }
        if (iMo1191f == 3) {
            return (Integer) _deserializeFromArray(abstractC0545m, abstractC0718i);
        }
        if (iMo1191f == 11) {
            return (Integer) getNullValue(abstractC0718i);
        }
        EnumC0816b enumC0816b = EnumC0816b.f2433h;
        EnumC0816b enumC0816b2 = EnumC0816b.f2432g;
        if (iMo1191f != 6) {
            if (iMo1191f == 7) {
                return Integer.valueOf(abstractC0545m.mo1204s());
            }
            if (iMo1191f == 8) {
                EnumC0816b enumC0816b_checkFloatToIntCoercion = _checkFloatToIntCoercion(abstractC0545m, abstractC0718i, cls);
                return enumC0816b_checkFloatToIntCoercion == enumC0816b2 ? (Integer) getNullValue(abstractC0718i) : enumC0816b_checkFloatToIntCoercion == enumC0816b ? (Integer) getEmptyValue(abstractC0718i) : Integer.valueOf(abstractC0545m.mo1163H());
            }
            abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
            throw null;
        }
        String strMo1157B = abstractC0545m.mo1157B();
        EnumC0816b enumC0816b_checkFromStringCoercion = _checkFromStringCoercion(abstractC0718i, strMo1157B);
        if (enumC0816b_checkFromStringCoercion == enumC0816b2) {
            return (Integer) getNullValue(abstractC0718i);
        }
        if (enumC0816b_checkFromStringCoercion == enumC0816b) {
            return (Integer) getEmptyValue(abstractC0718i);
        }
        String strTrim = strMo1157B.trim();
        return _checkTextualNull(abstractC0718i, strTrim) ? (Integer) getNullValue(abstractC0718i) : _parseInteger(abstractC0718i, strTrim);
    }

    public final Long _parseLong(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Class<?> cls) throws C0850b {
        int iMo1191f = abstractC0545m.mo1191f();
        if (iMo1191f == 1) {
            abstractC0718i.m1825C(abstractC0545m, cls);
            throw null;
        }
        if (iMo1191f == 3) {
            return (Long) _deserializeFromArray(abstractC0545m, abstractC0718i);
        }
        if (iMo1191f == 11) {
            return (Long) getNullValue(abstractC0718i);
        }
        EnumC0816b enumC0816b = EnumC0816b.f2433h;
        EnumC0816b enumC0816b2 = EnumC0816b.f2432g;
        if (iMo1191f != 6) {
            if (iMo1191f == 7) {
                return Long.valueOf(abstractC0545m.mo1205t());
            }
            if (iMo1191f == 8) {
                EnumC0816b enumC0816b_checkFloatToIntCoercion = _checkFloatToIntCoercion(abstractC0545m, abstractC0718i, cls);
                return enumC0816b_checkFloatToIntCoercion == enumC0816b2 ? (Long) getNullValue(abstractC0718i) : enumC0816b_checkFloatToIntCoercion == enumC0816b ? (Long) getEmptyValue(abstractC0718i) : Long.valueOf(abstractC0545m.mo1164I());
            }
            abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
            throw null;
        }
        String strMo1157B = abstractC0545m.mo1157B();
        EnumC0816b enumC0816b_checkFromStringCoercion = _checkFromStringCoercion(abstractC0718i, strMo1157B);
        if (enumC0816b_checkFromStringCoercion == enumC0816b2) {
            return (Long) getNullValue(abstractC0718i);
        }
        if (enumC0816b_checkFromStringCoercion == enumC0816b) {
            return (Long) getEmptyValue(abstractC0718i);
        }
        String strTrim = strMo1157B.trim();
        return _checkTextualNull(abstractC0718i, strTrim) ? (Long) getNullValue(abstractC0718i) : _parseLong(abstractC0718i, strTrim);
    }

    public final long _parseLongPrimitive(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        int iMo1191f = abstractC0545m.mo1191f();
        if (iMo1191f == 1) {
            abstractC0718i.m1825C(abstractC0545m, Long.TYPE);
            throw null;
        }
        if (iMo1191f != 3) {
            if (iMo1191f == 11) {
                _verifyNullForPrimitive(abstractC0718i);
                return 0L;
            }
            EnumC0816b enumC0816b = EnumC0816b.f2433h;
            EnumC0816b enumC0816b2 = EnumC0816b.f2432g;
            if (iMo1191f == 6) {
                String strMo1157B = abstractC0545m.mo1157B();
                EnumC0816b enumC0816b_checkFromStringCoercion = _checkFromStringCoercion(abstractC0718i, strMo1157B, EnumC1664f.f5894j, Long.TYPE);
                if (enumC0816b_checkFromStringCoercion == enumC0816b2) {
                    _verifyNullForPrimitive(abstractC0718i);
                    return 0L;
                }
                if (enumC0816b_checkFromStringCoercion == enumC0816b) {
                    return 0L;
                }
                String strTrim = strMo1157B.trim();
                if (!_hasTextualNull(strTrim)) {
                    return _parseLongPrimitive(abstractC0718i, strTrim);
                }
                _verifyNullForPrimitiveCoercion(abstractC0718i, strTrim);
                return 0L;
            }
            if (iMo1191f == 7) {
                return abstractC0545m.mo1205t();
            }
            if (iMo1191f == 8) {
                EnumC0816b enumC0816b_checkFloatToIntCoercion = _checkFloatToIntCoercion(abstractC0545m, abstractC0718i, Long.TYPE);
                if (enumC0816b_checkFloatToIntCoercion == enumC0816b2 || enumC0816b_checkFloatToIntCoercion == enumC0816b) {
                    return 0L;
                }
                return abstractC0545m.mo1164I();
            }
        } else if (abstractC0718i.m1833K(EnumC0719j.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            if (abstractC0545m.mo1177V() == EnumC0548p.START_ARRAY) {
                return ((Long) handleNestedArrayForSingle(abstractC0545m, abstractC0718i)).longValue();
            }
            long j_parseLongPrimitive = _parseLongPrimitive(abstractC0545m, abstractC0718i);
            _verifyEndArrayForSingle(abstractC0545m, abstractC0718i);
            return j_parseLongPrimitive;
        }
        abstractC0718i.m1825C(abstractC0545m, Long.TYPE);
        throw null;
    }

    public final short _parseShortPrimitive(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        int iMo1191f = abstractC0545m.mo1191f();
        if (iMo1191f == 1) {
            abstractC0718i.m1825C(abstractC0545m, Short.TYPE);
            throw null;
        }
        if (iMo1191f != 3) {
            if (iMo1191f == 11) {
                _verifyNullForPrimitive(abstractC0718i);
                return (short) 0;
            }
            EnumC0816b enumC0816b = EnumC0816b.f2433h;
            EnumC0816b enumC0816b2 = EnumC0816b.f2432g;
            if (iMo1191f == 6) {
                String strMo1157B = abstractC0545m.mo1157B();
                EnumC1664f enumC1664f = EnumC1664f.f5894j;
                Class cls = Short.TYPE;
                EnumC0816b enumC0816b_checkFromStringCoercion = _checkFromStringCoercion(abstractC0718i, strMo1157B, enumC1664f, cls);
                if (enumC0816b_checkFromStringCoercion == enumC0816b2) {
                    _verifyNullForPrimitive(abstractC0718i);
                    return (short) 0;
                }
                if (enumC0816b_checkFromStringCoercion == enumC0816b) {
                    return (short) 0;
                }
                String strTrim = strMo1157B.trim();
                if (_hasTextualNull(strTrim)) {
                    _verifyNullForPrimitiveCoercion(abstractC0718i, strTrim);
                    return (short) 0;
                }
                try {
                    int iM1349f = AbstractC0594g.m1349f(strTrim);
                    if (!_shortOverflow(iM1349f)) {
                        return (short) iM1349f;
                    }
                    abstractC0718i.m1829G(cls, strTrim, "overflow, value cannot be represented as 16-bit value", new Object[0]);
                    throw null;
                } catch (IllegalArgumentException unused) {
                    abstractC0718i.m1829G(Short.TYPE, strTrim, "not a valid `short` value", new Object[0]);
                    throw null;
                }
            }
            if (iMo1191f == 7) {
                return abstractC0545m.mo1156A();
            }
            if (iMo1191f == 8) {
                EnumC0816b enumC0816b_checkFloatToIntCoercion = _checkFloatToIntCoercion(abstractC0545m, abstractC0718i, Short.TYPE);
                if (enumC0816b_checkFloatToIntCoercion == enumC0816b2 || enumC0816b_checkFloatToIntCoercion == enumC0816b) {
                    return (short) 0;
                }
                return abstractC0545m.mo1156A();
            }
        } else if (abstractC0718i.m1833K(EnumC0719j.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            if (abstractC0545m.mo1177V() == EnumC0548p.START_ARRAY) {
                return ((Short) handleNestedArrayForSingle(abstractC0545m, abstractC0718i)).shortValue();
            }
            short s_parseShortPrimitive = _parseShortPrimitive(abstractC0545m, abstractC0718i);
            _verifyEndArrayForSingle(abstractC0545m, abstractC0718i);
            return s_parseShortPrimitive;
        }
        abstractC0718i.m1824B(abstractC0545m, abstractC0718i.m1848m(Short.TYPE));
        throw null;
    }

    @Deprecated
    public final String _parseString(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return _parseString(abstractC0545m, abstractC0718i, C1165q.f4020g);
    }

    public void _reportFailedNullCoerce(AbstractC0718i abstractC0718i, boolean z3, Enum<?> r5, String str) throws C0850b {
        abstractC0718i.m1841S(this, "Cannot coerce %s to Null value as %s (%s `%s.%s` to allow)", str, _coercedTypeDesc(), z3 ? "enable" : "disable", r5.getDeclaringClass().getSimpleName(), r5.name());
        throw null;
    }

    public final boolean _shortOverflow(int i3) {
        return i3 < -32768 || i3 > 32767;
    }

    public void _verifyEndArrayForSingle(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        if (abstractC0545m.mo1177V() != EnumC0548p.END_ARRAY) {
            handleMissingEndArrayForSingle(abstractC0545m, abstractC0718i);
        }
    }

    public final void _verifyNullForPrimitive(AbstractC0718i abstractC0718i) throws C0850b {
        if (abstractC0718i.m1833K(EnumC0719j.FAIL_ON_NULL_FOR_PRIMITIVES)) {
            abstractC0718i.m1841S(this, "Cannot coerce `null` to %s (disable `DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES` to allow)", _coercedTypeDesc());
            throw null;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void _verifyNullForPrimitiveCoercion(AbstractC0718i abstractC0718i, String str) throws C0850b {
        boolean z3;
        Enum<?> r02;
        EnumC0731v enumC0731v = EnumC0731v.ALLOW_COERCION_OF_SCALARS;
        if (abstractC0718i.f1998g.m2157l(enumC0731v)) {
            EnumC0719j enumC0719j = EnumC0719j.FAIL_ON_NULL_FOR_PRIMITIVES;
            if (!abstractC0718i.m1833K(enumC0719j)) {
                return;
            }
            z3 = false;
            r02 = enumC0719j;
        } else {
            z3 = true;
            r02 = enumC0731v;
        }
        _reportFailedNullCoerce(abstractC0718i, z3, r02, str.isEmpty() ? "empty String (\"\")" : AbstractC0032g.m154l("String \"", str, "\""));
    }

    @Deprecated
    public final void _verifyNullForScalarCoercion(AbstractC0718i abstractC0718i, String str) throws C0850b {
        EnumC0731v enumC0731v = EnumC0731v.ALLOW_COERCION_OF_SCALARS;
        if (abstractC0718i.f1998g.m2157l(enumC0731v)) {
            return;
        }
        _reportFailedNullCoerce(abstractC0718i, true, enumC0731v, str.isEmpty() ? "empty String (\"\")" : AbstractC0032g.m154l("String \"", str, "\""));
    }

    @Deprecated
    public void _verifyNumberForScalarCoercion(AbstractC0718i abstractC0718i, AbstractC0545m abstractC0545m) throws C0850b {
        EnumC0731v enumC0731v = EnumC0731v.ALLOW_COERCION_OF_SCALARS;
        if (abstractC0718i.f1998g.m2157l(enumC0731v)) {
            return;
        }
        abstractC0718i.m1841S(this, "Cannot coerce Number (%s) to %s (enable `%s.%s` to allow)", abstractC0545m.mo1157B(), _coercedTypeDesc(), enumC0731v.getDeclaringClass().getSimpleName(), "ALLOW_COERCION_OF_SCALARS");
        throw null;
    }

    @Deprecated
    public void _verifyStringForScalarCoercion(AbstractC0718i abstractC0718i, String str) throws C0850b {
        EnumC0731v enumC0731v = EnumC0731v.ALLOW_COERCION_OF_SCALARS;
        if (abstractC0718i.f1998g.m2157l(enumC0731v)) {
            return;
        }
        abstractC0718i.m1841S(this, "Cannot coerce String \"%s\" to %s (enable `%s.%s` to allow)", str, _coercedTypeDesc(), enumC0731v.getDeclaringClass().getSimpleName(), "ALLOW_COERCION_OF_SCALARS");
        throw null;
    }

    @Override // p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        return abstractC1398g.mo3400b(abstractC0545m, abstractC0718i);
    }

    public InterfaceC1178m findContentNullProvider(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e, AbstractC0722m abstractC0722m) throws C0850b {
        EnumC0481b0 enumC0481b0FindContentNullStyle = findContentNullStyle(abstractC0718i, interfaceC0714e);
        if (enumC0481b0FindContentNullStyle == EnumC0481b0.f1122e) {
            return C1165q.f4019f;
        }
        if (enumC0481b0FindContentNullStyle != EnumC0481b0.f1123f) {
            InterfaceC1178m interfaceC1178m_findNullProvider = _findNullProvider(abstractC0718i, interfaceC0714e, enumC0481b0FindContentNullStyle, abstractC0722m);
            return interfaceC1178m_findNullProvider != null ? interfaceC1178m_findNullProvider : abstractC0722m;
        }
        if (interfaceC0714e != null) {
            return new C1166r(interfaceC0714e.mo1803a(), interfaceC0714e.getType().mo1874i());
        }
        AbstractC0721l abstractC0721lM1848m = abstractC0718i.m1848m(abstractC0722m.handledType());
        if (abstractC0721lM1848m.mo1887v()) {
            abstractC0721lM1848m = abstractC0721lM1848m.mo1874i();
        }
        return new C1166r(null, abstractC0721lM1848m);
    }

    public EnumC0481b0 findContentNullStyle(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) {
        return interfaceC0714e != null ? interfaceC0714e.mo1804b().f1925k : abstractC0718i.f1998g.f2490m.f2449g.f1106f;
    }

    public AbstractC0722m findConvertingContentDeserializer(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e, AbstractC0722m abstractC0722m) {
        AbstractC1041l abstractC1041lMo1805c;
        Object objMo1769h;
        AbstractC0711b abstractC0711bM2149d = abstractC0718i.f1998g.m2149d();
        if (!_neitherNull(abstractC0711bM2149d, interfaceC0714e) || (abstractC1041lMo1805c = interfaceC0714e.mo1805c()) == null || (objMo1769h = abstractC0711bM2149d.mo1769h(abstractC1041lMo1805c)) == null) {
            return abstractC0722m;
        }
        interfaceC0714e.mo1805c();
        InterfaceC1748m interfaceC1748mM1812d = abstractC0718i.m1812d(objMo1769h);
        abstractC0718i.mo1711f();
        AbstractC0721l abstractC0721l = ((C1160l) interfaceC1748mM1812d).f4009a;
        if (abstractC0722m == null) {
            abstractC0722m = abstractC0718i.m1852q(abstractC0721l, interfaceC0714e);
        }
        return new StdDelegatingDeserializer(interfaceC1748mM1812d, abstractC0721l, abstractC0722m);
    }

    public AbstractC0722m findDeserializer(AbstractC0718i abstractC0718i, AbstractC0721l abstractC0721l, InterfaceC0714e interfaceC0714e) {
        return abstractC0718i.m1852q(abstractC0721l, interfaceC0714e);
    }

    public Boolean findFormatFeature(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e, Class<?> cls, EnumC0499n enumC0499n) {
        C0502q c0502qFindFormatOverrides = findFormatOverrides(abstractC0718i, interfaceC0714e, cls);
        if (c0502qFindFormatOverrides != null) {
            return c0502qFindFormatOverrides.m1015b(enumC0499n);
        }
        return null;
    }

    public C0502q findFormatOverrides(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e, Class<?> cls) {
        return interfaceC0714e != null ? interfaceC0714e.mo1806d(abstractC0718i.f1998g, cls) : abstractC0718i.f1998g.mo2151f(cls);
    }

    public final InterfaceC1178m findValueNullProvider(AbstractC0718i abstractC0718i, AbstractC1204t abstractC1204t, C0702D c0702d) {
        if (abstractC1204t != null) {
            return _findNullProvider(abstractC0718i, abstractC1204t, c0702d.f1924j, abstractC1204t.mo3032t());
        }
        return null;
    }

    @Deprecated
    public final Class<?> getValueClass() {
        return this._valueClass;
    }

    public AbstractC1208x getValueInstantiator() {
        return null;
    }

    public AbstractC0721l getValueType() {
        return this._valueType;
    }

    public void handleMissingEndArrayForSingle(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        abstractC0718i.m1844W(this, EnumC0548p.END_ARRAY, "Attempted to unwrap '%s' value from an array (with `DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS`) but it contains more than one value", handledType().getName());
        throw null;
    }

    public Object handleNestedArrayForSingle(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        abstractC0718i.m1826D(getValueType(abstractC0718i), abstractC0545m.mo1190e(), abstractC0545m, "Cannot deserialize instance of " + AbstractC1745j.m3903z(this._valueClass) + " out of " + EnumC0548p.START_ARRAY + " token: nested Arrays not allowed with DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS", new Object[0]);
        throw null;
    }

    public void handleUnknownProperty(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj, String str) throws C0855g {
        if (obj == null) {
            obj = handledType();
        }
        C0009j c0009j = abstractC0718i.f1998g.f1987q;
        if (c0009j != null) {
            AbstractC0032g.m162t(c0009j.f30f);
            throw null;
        }
        if (!abstractC0718i.m1833K(EnumC0719j.FAIL_ON_UNKNOWN_PROPERTIES)) {
            abstractC0545m.mo1187c0();
            return;
        }
        Collection<Object> knownPropertyNames = getKnownPropertyNames();
        int i3 = C0855g.f2525k;
        String strM156n = AbstractC0032g.m156n("Unrecognized field \"", str, "\" (class ", (obj instanceof Class ? obj : obj.getClass()).getName(), "), not marked as ignorable");
        AbstractC0545m abstractC0545m2 = abstractC0718i.f2002k;
        C0855g c0855g = new C0855g(abstractC0545m2, strM156n, abstractC0545m2.mo1197l(), knownPropertyNames);
        c0855g.mo1816d(str, obj);
        throw c0855g;
    }

    @Override // p069X0.AbstractC0722m
    public Class<?> handledType() {
        return this._valueClass;
    }

    public boolean isDefaultDeserializer(AbstractC0722m abstractC0722m) {
        return AbstractC1745j.m3899v(abstractC0722m);
    }

    public boolean isDefaultKeyDeserializer(AbstractC0730u abstractC0730u) {
        return AbstractC1745j.m3899v(abstractC0730u);
    }

    public static final double _parseDouble(String str, boolean z3) {
        return AbstractC0594g.m1346c(str, z3);
    }

    public EnumC0816b _checkFromStringCoercion(AbstractC0718i abstractC0718i, String str, EnumC1664f enumC1664f, Class<?> cls) throws C0850b {
        if (str.isEmpty()) {
            return _checkCoercionFail(abstractC0718i, abstractC0718i.m1850o(enumC1664f, cls, EnumC0819e.f2444j), cls, str, "empty String (\"\")");
        }
        boolean z_isBlank = _isBlank(str);
        EnumC0816b enumC0816b = EnumC0816b.f2430e;
        if (z_isBlank) {
            return _checkCoercionFail(abstractC0718i, abstractC0718i.m1851p(enumC1664f, cls), cls, str, "blank String (all whitespace)");
        }
        if (abstractC0718i.m1832J(EnumC0552t.f1336g)) {
            return EnumC0816b.f2431f;
        }
        EnumC0816b enumC0816bM1850o = abstractC0718i.m1850o(enumC1664f, cls, EnumC0819e.f2442h);
        if (enumC0816bM1850o != enumC0816b) {
            return enumC0816bM1850o;
        }
        abstractC0718i.m1841S(this, "Cannot coerce String value (\"%s\") to %s (but might if coercion using `CoercionConfig` was enabled)", str, _coercedTypeDesc());
        throw null;
    }

    public final boolean _parseBooleanPrimitive(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        int iMo1191f = abstractC0545m.mo1191f();
        if (iMo1191f == 1) {
            abstractC0718i.m1825C(abstractC0545m, Boolean.TYPE);
            throw null;
        }
        if (iMo1191f != 3) {
            if (iMo1191f == 6) {
                String strMo1157B = abstractC0545m.mo1157B();
                EnumC1664f enumC1664f = EnumC1664f.f5896l;
                Class cls = Boolean.TYPE;
                EnumC0816b enumC0816b_checkFromStringCoercion = _checkFromStringCoercion(abstractC0718i, strMo1157B, enumC1664f, cls);
                if (enumC0816b_checkFromStringCoercion == EnumC0816b.f2432g) {
                    _verifyNullForPrimitive(abstractC0718i);
                    return false;
                }
                if (enumC0816b_checkFromStringCoercion == EnumC0816b.f2433h) {
                    return false;
                }
                String strTrim = strMo1157B.trim();
                int length = strTrim.length();
                if (length == 4) {
                    if (_isTrue(strTrim)) {
                        return true;
                    }
                } else if (length == 5 && _isFalse(strTrim)) {
                    return false;
                }
                if (_hasTextualNull(strTrim)) {
                    _verifyNullForPrimitiveCoercion(abstractC0718i, strTrim);
                    return false;
                }
                abstractC0718i.m1829G(cls, strTrim, "only \"true\"/\"True\"/\"TRUE\" or \"false\"/\"False\"/\"FALSE\" recognized", new Object[0]);
                throw null;
            }
            if (iMo1191f == 7) {
                return Boolean.TRUE.equals(_coerceBooleanFromInt(abstractC0545m, abstractC0718i, Boolean.TYPE));
            }
            switch (iMo1191f) {
                case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                    return true;
                case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                    _verifyNullForPrimitive(abstractC0718i);
                case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                    return false;
            }
        } else if (abstractC0718i.m1833K(EnumC0719j.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            if (abstractC0545m.mo1177V() == EnumC0548p.START_ARRAY) {
                return ((Boolean) handleNestedArrayForSingle(abstractC0545m, abstractC0718i)).booleanValue();
            }
            boolean z_parseBooleanPrimitive = _parseBooleanPrimitive(abstractC0545m, abstractC0718i);
            _verifyEndArrayForSingle(abstractC0545m, abstractC0718i);
            return z_parseBooleanPrimitive;
        }
        abstractC0718i.m1825C(abstractC0545m, Boolean.TYPE);
        throw null;
    }

    public AbstractC0721l getValueType(AbstractC0718i abstractC0718i) {
        AbstractC0721l abstractC0721l = this._valueType;
        return abstractC0721l != null ? abstractC0721l : abstractC0718i.m1848m(this._valueClass);
    }

    public final String _parseString(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, InterfaceC1178m interfaceC1178m) throws C0850b {
        String strMo1165J;
        EnumC0816b enumC0816b_checkIntToStringCoercion = EnumC0816b.f2431f;
        int iMo1191f = abstractC0545m.mo1191f();
        if (iMo1191f == 1) {
            abstractC0718i.m1825C(abstractC0545m, this._valueClass);
            throw null;
        }
        if (iMo1191f != 12) {
            switch (iMo1191f) {
                case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                    return abstractC0545m.mo1157B();
                case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                    enumC0816b_checkIntToStringCoercion = _checkIntToStringCoercion(abstractC0545m, abstractC0718i, String.class);
                    break;
                case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                    enumC0816b_checkIntToStringCoercion = _checkFloatToStringCoercion(abstractC0545m, abstractC0718i, String.class);
                    break;
                case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                    enumC0816b_checkIntToStringCoercion = _checkBooleanToStringCoercion(abstractC0545m, abstractC0718i, String.class);
                    break;
            }
            if (enumC0816b_checkIntToStringCoercion == EnumC0816b.f2432g) {
                return (String) interfaceC1178m.getNullValue(abstractC0718i);
            }
            if (enumC0816b_checkIntToStringCoercion == EnumC0816b.f2433h) {
                return "";
            }
            if (abstractC0545m.mo1190e().f1332l && (strMo1165J = abstractC0545m.mo1165J()) != null) {
                return strMo1165J;
            }
            abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
            throw null;
        }
        Object objMo1202q = abstractC0545m.mo1202q();
        if (objMo1202q instanceof byte[]) {
            return abstractC0718i.f1998g.f2481f.f2429o.m1075e((byte[]) objMo1202q);
        }
        if (objMo1202q == null) {
            return null;
        }
        return objMo1202q.toString();
    }

    public StdDeserializer(AbstractC0721l abstractC0721l) {
        this._valueClass = abstractC0721l == null ? Object.class : abstractC0721l.f2036e;
        this._valueType = abstractC0721l;
    }

    public StdDeserializer(StdDeserializer<?> stdDeserializer) {
        this._valueClass = stdDeserializer._valueClass;
        this._valueType = stdDeserializer._valueType;
    }

    public Date _parseDate(String str, AbstractC0718i abstractC0718i) throws C0851c {
        try {
            if (str.isEmpty()) {
                if (_checkFromStringCoercion(abstractC0718i, str).ordinal() != 3) {
                    return null;
                }
                return new Date(0L);
            }
            if (_hasTextualNull(str)) {
                return null;
            }
            return abstractC0718i.m1836N(str);
        } catch (IllegalArgumentException e3) {
            abstractC0718i.m1829G(this._valueClass, str, "not a valid representation (error: %s)", AbstractC1745j.m3886i(e3));
            throw null;
        }
    }

    public final Integer _parseInteger(AbstractC0718i abstractC0718i, String str) throws C0851c {
        try {
            if (str.length() > 9) {
                long jM1351h = AbstractC0594g.m1351h(str);
                if (!_intOverflow(jM1351h)) {
                    return Integer.valueOf((int) jM1351h);
                }
                abstractC0718i.m1829G(Integer.class, str, "Overflow: numeric value (%s) out of range of `java.lang.Integer` (%d -%d)", str, Integer.MIN_VALUE, Integer.MAX_VALUE);
                throw null;
            }
            return Integer.valueOf(AbstractC0594g.m1349f(str));
        } catch (IllegalArgumentException unused) {
            abstractC0718i.m1829G(Integer.class, str, "not a valid `java.lang.Integer` value", new Object[0]);
            throw null;
        }
    }

    public final Long _parseLong(AbstractC0718i abstractC0718i, String str) throws C0851c {
        try {
            return Long.valueOf(AbstractC0594g.m1351h(str));
        } catch (IllegalArgumentException unused) {
            abstractC0718i.m1829G(Long.class, str, "not a valid `java.lang.Long` value", new Object[0]);
            throw null;
        }
    }

    public final int _parseIntPrimitive(AbstractC0718i abstractC0718i, String str) throws C0851c {
        try {
            if (str.length() > 9) {
                long jM1351h = AbstractC0594g.m1351h(str);
                if (!_intOverflow(jM1351h)) {
                    return (int) jM1351h;
                }
                abstractC0718i.m1829G(Integer.TYPE, str, "Overflow: numeric value (%s) out of range of int (%d -%d)", str, Integer.MIN_VALUE, Integer.MAX_VALUE);
                throw null;
            }
            return AbstractC0594g.m1349f(str);
        } catch (IllegalArgumentException unused) {
            abstractC0718i.m1829G(Integer.TYPE, str, "not a valid `int` value", new Object[0]);
            throw null;
        }
    }

    public final long _parseLongPrimitive(AbstractC0718i abstractC0718i, String str) throws C0851c {
        try {
            return AbstractC0594g.m1351h(str);
        } catch (IllegalArgumentException unused) {
            abstractC0718i.m1829G(Long.TYPE, str, "not a valid `long` value", new Object[0]);
            throw null;
        }
    }

    public final double _parseDoublePrimitive(AbstractC0718i abstractC0718i, String str) throws C0851c {
        try {
            return _parseDouble(str);
        } catch (IllegalArgumentException unused) {
            abstractC0718i.m1829G(Double.TYPE, str, "not a valid `double` value (as String to convert)", new Object[0]);
            throw null;
        }
    }

    public final float _parseFloatPrimitive(AbstractC0718i abstractC0718i, String str) throws C0851c {
        try {
            String str2 = AbstractC0594g.f1522a;
            return Float.parseFloat(str);
        } catch (IllegalArgumentException unused) {
            abstractC0718i.m1829G(Float.TYPE, str, "not a valid `float` value", new Object[0]);
            throw null;
        }
    }

    public String _coercedTypeDesc(Class<?> cls) {
        String strM3890m = AbstractC1745j.m3890m(cls);
        if (cls.isArray() || Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls)) {
            return AbstractC0032g.m152j("element of ", strM3890m);
        }
        return AbstractC1849h.m4117a(strM3890m, " value");
    }

    public final double _parseDoublePrimitive(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, String str) throws C0851c {
        try {
            return _parseDouble(str, abstractC0545m.m1170O(EnumC0554v.USE_FAST_DOUBLE_PARSER));
        } catch (IllegalArgumentException unused) {
            abstractC0718i.m1829G(Double.TYPE, str, "not a valid `double` value (as String to convert)", new Object[0]);
            throw null;
        }
    }

    public final float _parseFloatPrimitive(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, String str) throws C0851c {
        try {
            return AbstractC0594g.m1347d(str, abstractC0545m.m1170O(EnumC0554v.USE_FAST_DOUBLE_PARSER));
        } catch (IllegalArgumentException unused) {
            abstractC0718i.m1829G(Float.TYPE, str, "not a valid `float` value", new Object[0]);
            throw null;
        }
    }
}
