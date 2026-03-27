package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.exc.C1131b;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import p042N0.AbstractC0545m;
import p042N0.C0553u;
import p042N0.EnumC0554v;
import p050Q0.AbstractC0594g;
import p069X0.AbstractC0718i;
import p069X0.EnumC0719j;
import p074Z0.EnumC0816b;
import p078a1.C0850b;
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.std.h */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1192h {

    /* JADX INFO: renamed from: a */
    public static final HashSet f4061a = new HashSet();

    static {
        Class[] clsArr = {Boolean.class, Byte.class, Short.class, Character.class, Integer.class, Long.class, Float.class, Double.class, Number.class, BigDecimal.class, BigInteger.class};
        for (int i3 = 0; i3 < 11; i3++) {
            f4061a.add(clsArr[i3].getName());
        }
    }

    /* JADX INFO: renamed from: a */
    public static StdDeserializer m3042a(Class cls, String str) {
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return NumberDeserializers$IntegerDeserializer.primitiveInstance;
            }
            if (cls == Boolean.TYPE) {
                return NumberDeserializers$BooleanDeserializer.primitiveInstance;
            }
            if (cls == Long.TYPE) {
                return NumberDeserializers$LongDeserializer.primitiveInstance;
            }
            if (cls == Double.TYPE) {
                return NumberDeserializers$DoubleDeserializer.primitiveInstance;
            }
            if (cls == Character.TYPE) {
                return NumberDeserializers$CharacterDeserializer.primitiveInstance;
            }
            if (cls == Byte.TYPE) {
                return NumberDeserializers$ByteDeserializer.primitiveInstance;
            }
            if (cls == Short.TYPE) {
                return NumberDeserializers$ShortDeserializer.primitiveInstance;
            }
            if (cls == Float.TYPE) {
                return NumberDeserializers$FloatDeserializer.primitiveInstance;
            }
            if (cls == Void.TYPE) {
                return NullifyingDeserializer.instance;
            }
        } else {
            if (!f4061a.contains(str)) {
                return null;
            }
            if (cls == Integer.class) {
                return NumberDeserializers$IntegerDeserializer.wrapperInstance;
            }
            if (cls == Boolean.class) {
                return NumberDeserializers$BooleanDeserializer.wrapperInstance;
            }
            if (cls == Long.class) {
                return NumberDeserializers$LongDeserializer.wrapperInstance;
            }
            if (cls == Double.class) {
                return NumberDeserializers$DoubleDeserializer.wrapperInstance;
            }
            if (cls == Character.class) {
                return NumberDeserializers$CharacterDeserializer.wrapperInstance;
            }
            if (cls == Byte.class) {
                return NumberDeserializers$ByteDeserializer.wrapperInstance;
            }
            if (cls == Short.class) {
                return NumberDeserializers$ShortDeserializer.wrapperInstance;
            }
            if (cls == Float.class) {
                return NumberDeserializers$FloatDeserializer.wrapperInstance;
            }
            if (cls == Number.class) {
                return new StdScalarDeserializer<Object>() { // from class: com.fasterxml.jackson.databind.deser.std.NumberDeserializers$NumberDeserializer
                    @Override // p069X0.AbstractC0722m
                    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C1131b, C0850b {
                        int iMo1191f = abstractC0545m.mo1191f();
                        if (iMo1191f == 1) {
                            abstractC0718i.m1825C(abstractC0545m, this._valueClass);
                            throw null;
                        }
                        if (iMo1191f == 3) {
                            return _deserializeFromArray(abstractC0545m, abstractC0718i);
                        }
                        if (iMo1191f != 6) {
                            if (iMo1191f == 7) {
                                return abstractC0718i.m1830H(StdDeserializer.F_MASK_INT_COERCIONS) ? _coerceIntegral(abstractC0545m, abstractC0718i) : abstractC0545m.mo1207v();
                            }
                            if (iMo1191f == 8) {
                                return (!abstractC0718i.m1833K(EnumC0719j.USE_BIG_DECIMAL_FOR_FLOATS) || abstractC0545m.mo1174S()) ? abstractC0545m.mo1207v() : abstractC0545m.mo1200o();
                            }
                            abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
                            throw null;
                        }
                        String strMo1157B = abstractC0545m.mo1157B();
                        EnumC0816b enumC0816b_checkFromStringCoercion = _checkFromStringCoercion(abstractC0718i, strMo1157B);
                        if (enumC0816b_checkFromStringCoercion == EnumC0816b.f2432g) {
                            return getNullValue(abstractC0718i);
                        }
                        if (enumC0816b_checkFromStringCoercion == EnumC0816b.f2433h) {
                            return getEmptyValue(abstractC0718i);
                        }
                        String strTrim = strMo1157B.trim();
                        if (_hasTextualNull(strTrim)) {
                            return getNullValue(abstractC0718i);
                        }
                        if (_isPosInf(strTrim)) {
                            return Double.valueOf(Double.POSITIVE_INFINITY);
                        }
                        if (_isNegInf(strTrim)) {
                            return Double.valueOf(Double.NEGATIVE_INFINITY);
                        }
                        if (_isNaN(strTrim)) {
                            return Double.valueOf(Double.NaN);
                        }
                        try {
                            if (!_isIntNumber(strTrim)) {
                                C0553u c0553uMo1189d0 = abstractC0545m.mo1189d0();
                                int length = strTrim.length();
                                c0553uMo1189d0.getClass();
                                C0553u.m1237b(length);
                                return abstractC0718i.m1833K(EnumC0719j.USE_BIG_DECIMAL_FOR_FLOATS) ? AbstractC0594g.m1344a(strTrim, abstractC0545m.m1170O(EnumC0554v.USE_FAST_BIG_NUMBER_PARSER)) : Double.valueOf(AbstractC0594g.m1346c(strTrim, abstractC0545m.m1170O(EnumC0554v.USE_FAST_DOUBLE_PARSER)));
                            }
                            C0553u c0553uMo1189d02 = abstractC0545m.mo1189d0();
                            int length2 = strTrim.length();
                            c0553uMo1189d02.getClass();
                            C0553u.m1238c(length2);
                            if (abstractC0718i.m1833K(EnumC0719j.USE_BIG_INTEGER_FOR_INTS)) {
                                return AbstractC0594g.m1345b(strTrim, abstractC0545m.m1170O(EnumC0554v.USE_FAST_BIG_NUMBER_PARSER));
                            }
                            long jM1351h = AbstractC0594g.m1351h(strTrim);
                            return (abstractC0718i.m1833K(EnumC0719j.USE_LONG_FOR_INTS) || jM1351h > 2147483647L || jM1351h < -2147483648L) ? Long.valueOf(jM1351h) : Integer.valueOf((int) jM1351h);
                        } catch (IllegalArgumentException unused) {
                            abstractC0718i.m1829G(this._valueClass, strTrim, "not a valid number", new Object[0]);
                            throw null;
                        }
                    }

                    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
                    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
                        int iMo1191f = abstractC0545m.mo1191f();
                        return (iMo1191f == 6 || iMo1191f == 7 || iMo1191f == 8) ? deserialize(abstractC0545m, abstractC0718i) : abstractC1398g.mo3403e(abstractC0545m, abstractC0718i);
                    }

                    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
                    public final EnumC1664f logicalType() {
                        return EnumC1664f.f5894j;
                    }
                };
            }
            if (cls == BigDecimal.class) {
                return new StdScalarDeserializer<BigDecimal>() { // from class: com.fasterxml.jackson.databind.deser.std.NumberDeserializers$BigDecimalDeserializer
                    @Override // p069X0.AbstractC0722m
                    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
                        return BigDecimal.ZERO;
                    }

                    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
                    public final EnumC1664f logicalType() {
                        return EnumC1664f.f5895k;
                    }

                    @Override // p069X0.AbstractC0722m
                    public BigDecimal deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C1131b, C0850b {
                        int iMo1191f = abstractC0545m.mo1191f();
                        if (iMo1191f == 1) {
                            abstractC0718i.m1825C(abstractC0545m, this._valueClass);
                            throw null;
                        }
                        if (iMo1191f == 3) {
                            return _deserializeFromArray(abstractC0545m, abstractC0718i);
                        }
                        EnumC0816b enumC0816b = EnumC0816b.f2433h;
                        EnumC0816b enumC0816b2 = EnumC0816b.f2432g;
                        if (iMo1191f != 6) {
                            if (iMo1191f == 7) {
                                EnumC0816b enumC0816b_checkIntToFloatCoercion = _checkIntToFloatCoercion(abstractC0545m, abstractC0718i, this._valueClass);
                                if (enumC0816b_checkIntToFloatCoercion == enumC0816b2) {
                                    return (BigDecimal) getNullValue(abstractC0718i);
                                }
                                if (enumC0816b_checkIntToFloatCoercion == enumC0816b) {
                                    return (BigDecimal) getEmptyValue(abstractC0718i);
                                }
                            } else if (iMo1191f != 8) {
                                abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
                                throw null;
                            }
                            return abstractC0545m.mo1200o();
                        }
                        String strMo1157B = abstractC0545m.mo1157B();
                        EnumC0816b enumC0816b_checkFromStringCoercion = _checkFromStringCoercion(abstractC0718i, strMo1157B);
                        if (enumC0816b_checkFromStringCoercion == enumC0816b2) {
                            return (BigDecimal) getNullValue(abstractC0718i);
                        }
                        if (enumC0816b_checkFromStringCoercion == enumC0816b) {
                            return (BigDecimal) getEmptyValue(abstractC0718i);
                        }
                        String strTrim = strMo1157B.trim();
                        if (_hasTextualNull(strTrim)) {
                            return (BigDecimal) getNullValue(abstractC0718i);
                        }
                        C0553u c0553uMo1189d0 = abstractC0545m.mo1189d0();
                        int length = strTrim.length();
                        c0553uMo1189d0.getClass();
                        C0553u.m1237b(length);
                        try {
                            return AbstractC0594g.m1344a(strTrim, abstractC0545m.m1170O(EnumC0554v.USE_FAST_BIG_NUMBER_PARSER));
                        } catch (IllegalArgumentException unused) {
                            abstractC0718i.m1829G(this._valueClass, strTrim, "not a valid representation", new Object[0]);
                            throw null;
                        }
                    }
                };
            }
            if (cls == BigInteger.class) {
                return new StdScalarDeserializer<BigInteger>() { // from class: com.fasterxml.jackson.databind.deser.std.NumberDeserializers$BigIntegerDeserializer
                    @Override // p069X0.AbstractC0722m
                    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
                        return BigInteger.ZERO;
                    }

                    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
                    public final EnumC1664f logicalType() {
                        return EnumC1664f.f5894j;
                    }

                    @Override // p069X0.AbstractC0722m
                    public BigInteger deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C1131b, C0850b {
                        if (abstractC0545m.mo1171P()) {
                            return abstractC0545m.mo1192g();
                        }
                        int iMo1191f = abstractC0545m.mo1191f();
                        if (iMo1191f == 1) {
                            abstractC0718i.m1825C(abstractC0545m, this._valueClass);
                            throw null;
                        }
                        if (iMo1191f == 3) {
                            return _deserializeFromArray(abstractC0545m, abstractC0718i);
                        }
                        EnumC0816b enumC0816b = EnumC0816b.f2433h;
                        EnumC0816b enumC0816b2 = EnumC0816b.f2432g;
                        if (iMo1191f != 6) {
                            if (iMo1191f != 8) {
                                abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
                                throw null;
                            }
                            EnumC0816b enumC0816b_checkFloatToIntCoercion = _checkFloatToIntCoercion(abstractC0545m, abstractC0718i, this._valueClass);
                            if (enumC0816b_checkFloatToIntCoercion == enumC0816b2) {
                                return (BigInteger) getNullValue(abstractC0718i);
                            }
                            if (enumC0816b_checkFloatToIntCoercion == enumC0816b) {
                                return (BigInteger) getEmptyValue(abstractC0718i);
                            }
                            BigDecimal bigDecimalMo1200o = abstractC0545m.mo1200o();
                            C0553u c0553uMo1189d0 = abstractC0545m.mo1189d0();
                            int iScale = bigDecimalMo1200o.scale();
                            c0553uMo1189d0.getClass();
                            C0553u.m1236a(iScale);
                            return bigDecimalMo1200o.toBigInteger();
                        }
                        String strMo1157B = abstractC0545m.mo1157B();
                        EnumC0816b enumC0816b_checkFromStringCoercion = _checkFromStringCoercion(abstractC0718i, strMo1157B);
                        if (enumC0816b_checkFromStringCoercion == enumC0816b2) {
                            return (BigInteger) getNullValue(abstractC0718i);
                        }
                        if (enumC0816b_checkFromStringCoercion == enumC0816b) {
                            return (BigInteger) getEmptyValue(abstractC0718i);
                        }
                        String strTrim = strMo1157B.trim();
                        if (_hasTextualNull(strTrim)) {
                            return (BigInteger) getNullValue(abstractC0718i);
                        }
                        C0553u c0553uMo1189d02 = abstractC0545m.mo1189d0();
                        int length = strTrim.length();
                        c0553uMo1189d02.getClass();
                        C0553u.m1238c(length);
                        try {
                            return AbstractC0594g.m1345b(strTrim, abstractC0545m.m1170O(EnumC0554v.USE_FAST_BIG_NUMBER_PARSER));
                        } catch (IllegalArgumentException unused) {
                            abstractC0718i.m1829G(this._valueClass, strTrim, "not a valid representation", new Object[0]);
                            throw null;
                        }
                    }
                };
            }
        }
        throw new IllegalArgumentException("Internal error: can't find deserializer for ".concat(cls.getName()));
    }
}
