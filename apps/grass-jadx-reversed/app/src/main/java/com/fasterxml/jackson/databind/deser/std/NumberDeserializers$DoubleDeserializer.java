package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.exc.C1131b;
import p042N0.AbstractC0545m;
import p042N0.C0553u;
import p042N0.EnumC0548p;
import p042N0.EnumC0554v;
import p069X0.AbstractC0718i;
import p071Y0.InterfaceC0738b;
import p074Z0.EnumC0816b;
import p078a1.C0850b;
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;
import p118m1.EnumC1736a;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class NumberDeserializers$DoubleDeserializer extends NumberDeserializers$PrimitiveOrWrapperDeserializer<Double> {
    private static final long serialVersionUID = 1;
    static final NumberDeserializers$DoubleDeserializer primitiveInstance = new NumberDeserializers$DoubleDeserializer(Double.TYPE, Double.valueOf(0.0d));
    static final NumberDeserializers$DoubleDeserializer wrapperInstance = new NumberDeserializers$DoubleDeserializer(Double.class, null);

    public NumberDeserializers$DoubleDeserializer(Class<Double> cls, Double d) {
        super(cls, EnumC1664f.f5895k, d, Double.valueOf(0.0d));
    }

    public final Double _parseDouble(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C1131b, C0850b {
        int iMo1191f = abstractC0545m.mo1191f();
        if (iMo1191f == 1) {
            abstractC0718i.m1825C(abstractC0545m, this._valueClass);
            throw null;
        }
        if (iMo1191f == 3) {
            return _deserializeFromArray(abstractC0545m, abstractC0718i);
        }
        if (iMo1191f == 11) {
            return getNullValue(abstractC0718i);
        }
        EnumC0816b enumC0816b = EnumC0816b.f2433h;
        EnumC0816b enumC0816b2 = EnumC0816b.f2432g;
        if (iMo1191f != 6) {
            if (iMo1191f == 7) {
                EnumC0816b enumC0816b_checkIntToFloatCoercion = _checkIntToFloatCoercion(abstractC0545m, abstractC0718i, this._valueClass);
                if (enumC0816b_checkIntToFloatCoercion == enumC0816b2) {
                    return getNullValue(abstractC0718i);
                }
                if (enumC0816b_checkIntToFloatCoercion == enumC0816b) {
                    return (Double) getEmptyValue(abstractC0718i);
                }
            } else if (iMo1191f != 8) {
                abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
                throw null;
            }
            return Double.valueOf(abstractC0545m.mo1201p());
        }
        String strMo1157B = abstractC0545m.mo1157B();
        Double d_checkDoubleSpecialValue = _checkDoubleSpecialValue(strMo1157B);
        if (d_checkDoubleSpecialValue != null) {
            return d_checkDoubleSpecialValue;
        }
        EnumC0816b enumC0816b_checkFromStringCoercion = _checkFromStringCoercion(abstractC0718i, strMo1157B);
        if (enumC0816b_checkFromStringCoercion == enumC0816b2) {
            return getNullValue(abstractC0718i);
        }
        if (enumC0816b_checkFromStringCoercion == enumC0816b) {
            return (Double) getEmptyValue(abstractC0718i);
        }
        String strTrim = strMo1157B.trim();
        if (_checkTextualNull(abstractC0718i, strTrim)) {
            return getNullValue(abstractC0718i);
        }
        C0553u c0553uMo1189d0 = abstractC0545m.mo1189d0();
        int length = strTrim.length();
        c0553uMo1189d0.getClass();
        C0553u.m1237b(length);
        try {
            return Double.valueOf(StdDeserializer._parseDouble(strTrim, abstractC0545m.m1170O(EnumC0554v.USE_FAST_DOUBLE_PARSER)));
        } catch (IllegalArgumentException unused) {
            abstractC0718i.m1829G(this._valueClass, strTrim, "not a valid `Double` value", new Object[0]);
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers$PrimitiveOrWrapperDeserializer, p069X0.AbstractC0722m
    public /* bridge */ /* synthetic */ Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return super.getEmptyValue(abstractC0718i);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.NumberDeserializers$PrimitiveOrWrapperDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
    public /* bridge */ /* synthetic */ EnumC1736a getNullAccessPattern() {
        return super.getNullAccessPattern();
    }

    @Override // p069X0.AbstractC0722m
    public Double deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return abstractC0545m.mo1168M(EnumC0548p.VALUE_NUMBER_FLOAT) ? Double.valueOf(abstractC0545m.mo1201p()) : this._primitive ? Double.valueOf(_parseDoublePrimitive(abstractC0545m, abstractC0718i)) : _parseDouble(abstractC0545m, abstractC0718i);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Double deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        return abstractC0545m.mo1168M(EnumC0548p.VALUE_NUMBER_FLOAT) ? Double.valueOf(abstractC0545m.mo1201p()) : this._primitive ? Double.valueOf(_parseDoublePrimitive(abstractC0545m, abstractC0718i)) : _parseDouble(abstractC0545m, abstractC0718i);
    }
}
