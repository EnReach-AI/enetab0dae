package com.fasterxml.jackson.databind.deser.std;

import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p042N0.EnumC0554v;
import p050Q0.AbstractC0594g;
import p069X0.AbstractC0718i;
import p071Y0.InterfaceC0738b;
import p074Z0.EnumC0816b;
import p078a1.C0850b;
import p114l1.EnumC1664f;
import p118m1.EnumC1736a;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class NumberDeserializers$FloatDeserializer extends NumberDeserializers$PrimitiveOrWrapperDeserializer<Float> {
    private static final long serialVersionUID = 1;
    static final NumberDeserializers$FloatDeserializer primitiveInstance = new NumberDeserializers$FloatDeserializer(Float.TYPE, Float.valueOf(0.0f));
    static final NumberDeserializers$FloatDeserializer wrapperInstance = new NumberDeserializers$FloatDeserializer(Float.class, null);

    public NumberDeserializers$FloatDeserializer(Class<Float> cls, Float f3) {
        super(cls, EnumC1664f.f5895k, f3, Float.valueOf(0.0f));
    }

    public final Float _parseFloat(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
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
                    return (Float) getEmptyValue(abstractC0718i);
                }
            } else if (iMo1191f != 8) {
                abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
                throw null;
            }
            return Float.valueOf(abstractC0545m.mo1203r());
        }
        String strMo1157B = abstractC0545m.mo1157B();
        Float f_checkFloatSpecialValue = _checkFloatSpecialValue(strMo1157B);
        if (f_checkFloatSpecialValue != null) {
            return f_checkFloatSpecialValue;
        }
        EnumC0816b enumC0816b_checkFromStringCoercion = _checkFromStringCoercion(abstractC0718i, strMo1157B);
        if (enumC0816b_checkFromStringCoercion == enumC0816b2) {
            return getNullValue(abstractC0718i);
        }
        if (enumC0816b_checkFromStringCoercion == enumC0816b) {
            return (Float) getEmptyValue(abstractC0718i);
        }
        String strTrim = strMo1157B.trim();
        if (_checkTextualNull(abstractC0718i, strTrim)) {
            return getNullValue(abstractC0718i);
        }
        try {
            return Float.valueOf(AbstractC0594g.m1347d(strTrim, abstractC0545m.m1170O(EnumC0554v.USE_FAST_DOUBLE_PARSER)));
        } catch (IllegalArgumentException unused) {
            abstractC0718i.m1829G(this._valueClass, strTrim, "not a valid `Float` value", new Object[0]);
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
    public Float deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return abstractC0545m.mo1168M(EnumC0548p.VALUE_NUMBER_FLOAT) ? Float.valueOf(abstractC0545m.mo1203r()) : this._primitive ? Float.valueOf(_parseFloatPrimitive(abstractC0545m, abstractC0718i)) : _parseFloat(abstractC0545m, abstractC0718i);
    }
}
