package com.fasterxml.jackson.databind.deser.std;

import p042N0.AbstractC0545m;
import p050Q0.AbstractC0594g;
import p069X0.AbstractC0718i;
import p071Y0.InterfaceC0738b;
import p074Z0.EnumC0816b;
import p078a1.C0850b;
import p114l1.EnumC1664f;
import p118m1.EnumC1736a;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class NumberDeserializers$ByteDeserializer extends NumberDeserializers$PrimitiveOrWrapperDeserializer<Byte> {
    private static final long serialVersionUID = 1;
    static final NumberDeserializers$ByteDeserializer primitiveInstance = new NumberDeserializers$ByteDeserializer(Byte.TYPE, (byte) 0);
    static final NumberDeserializers$ByteDeserializer wrapperInstance = new NumberDeserializers$ByteDeserializer(Byte.class, null);

    public NumberDeserializers$ByteDeserializer(Class<Byte> cls, Byte b3) {
        super(cls, EnumC1664f.f5894j, b3, (byte) 0);
    }

    public Byte _parseByte(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
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
                return Byte.valueOf(abstractC0545m.mo1195j());
            }
            if (iMo1191f == 8) {
                EnumC0816b enumC0816b_checkFloatToIntCoercion = _checkFloatToIntCoercion(abstractC0545m, abstractC0718i, this._valueClass);
                return enumC0816b_checkFloatToIntCoercion == enumC0816b2 ? getNullValue(abstractC0718i) : enumC0816b_checkFloatToIntCoercion == enumC0816b ? (Byte) getEmptyValue(abstractC0718i) : Byte.valueOf(abstractC0545m.mo1195j());
            }
            abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
            throw null;
        }
        String strMo1157B = abstractC0545m.mo1157B();
        EnumC0816b enumC0816b_checkFromStringCoercion = _checkFromStringCoercion(abstractC0718i, strMo1157B);
        if (enumC0816b_checkFromStringCoercion == enumC0816b2) {
            return getNullValue(abstractC0718i);
        }
        if (enumC0816b_checkFromStringCoercion == enumC0816b) {
            return (Byte) getEmptyValue(abstractC0718i);
        }
        String strTrim = strMo1157B.trim();
        if (_checkTextualNull(abstractC0718i, strTrim)) {
            return getNullValue(abstractC0718i);
        }
        try {
            int iM1349f = AbstractC0594g.m1349f(strTrim);
            if (!_byteOverflow(iM1349f)) {
                return Byte.valueOf((byte) iM1349f);
            }
            abstractC0718i.m1829G(this._valueClass, strTrim, "overflow, value cannot be represented as 8-bit value", new Object[0]);
            throw null;
        } catch (IllegalArgumentException unused) {
            abstractC0718i.m1829G(this._valueClass, strTrim, "not a valid Byte value", new Object[0]);
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
    public Byte deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return abstractC0545m.mo1171P() ? Byte.valueOf(abstractC0545m.mo1195j()) : this._primitive ? Byte.valueOf(_parseBytePrimitive(abstractC0545m, abstractC0718i)) : _parseByte(abstractC0545m, abstractC0718i);
    }
}
