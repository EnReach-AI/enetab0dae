package com.fasterxml.jackson.databind.deser.std;

import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p071Y0.InterfaceC0738b;
import p074Z0.EnumC0816b;
import p074Z0.EnumC0819e;
import p078a1.C0850b;
import p114l1.EnumC1664f;
import p118m1.EnumC1736a;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class NumberDeserializers$CharacterDeserializer extends NumberDeserializers$PrimitiveOrWrapperDeserializer<Character> {
    private static final long serialVersionUID = 1;
    static final NumberDeserializers$CharacterDeserializer primitiveInstance = new NumberDeserializers$CharacterDeserializer(Character.TYPE, 0);
    static final NumberDeserializers$CharacterDeserializer wrapperInstance = new NumberDeserializers$CharacterDeserializer(Character.class, null);

    public NumberDeserializers$CharacterDeserializer(Class<Character> cls, Character ch) {
        super(cls, EnumC1664f.f5894j, ch, (char) 0);
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
    public Character deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        int iMo1191f = abstractC0545m.mo1191f();
        if (iMo1191f == 1) {
            abstractC0718i.m1825C(abstractC0545m, this._valueClass);
            throw null;
        }
        if (iMo1191f == 3) {
            return _deserializeFromArray(abstractC0545m, abstractC0718i);
        }
        if (iMo1191f == 11) {
            if (this._primitive) {
                _verifyNullForPrimitive(abstractC0718i);
            }
            return getNullValue(abstractC0718i);
        }
        if (iMo1191f == 6) {
            String strMo1157B = abstractC0545m.mo1157B();
            if (strMo1157B.length() == 1) {
                return Character.valueOf(strMo1157B.charAt(0));
            }
            EnumC0816b enumC0816b_checkFromStringCoercion = _checkFromStringCoercion(abstractC0718i, strMo1157B);
            if (enumC0816b_checkFromStringCoercion == EnumC0816b.f2432g) {
                return getNullValue(abstractC0718i);
            }
            if (enumC0816b_checkFromStringCoercion == EnumC0816b.f2433h) {
                return (Character) getEmptyValue(abstractC0718i);
            }
            String strTrim = strMo1157B.trim();
            if (_checkTextualNull(abstractC0718i, strTrim)) {
                return getNullValue(abstractC0718i);
            }
            abstractC0718i.m1829G(handledType(), strTrim, "Expected either Integer value code or 1-character String", new Object[0]);
            throw null;
        }
        if (iMo1191f != 7) {
            abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
            throw null;
        }
        EnumC0816b enumC0816bM1850o = abstractC0718i.m1850o(logicalType(), this._valueClass, EnumC0819e.f2439e);
        int iOrdinal = enumC0816bM1850o.ordinal();
        if (iOrdinal == 0) {
            _checkCoercionFail(abstractC0718i, enumC0816bM1850o, this._valueClass, abstractC0545m.mo1207v(), "Integer value (" + abstractC0545m.mo1157B() + ")");
        } else if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return (Character) getEmptyValue(abstractC0718i);
            }
            int iMo1204s = abstractC0545m.mo1204s();
            if (iMo1204s >= 0 && iMo1204s <= 65535) {
                return Character.valueOf((char) iMo1204s);
            }
            abstractC0718i.m1828F(handledType(), Integer.valueOf(iMo1204s), "value outside valid Character range (0x0000 - 0xFFFF)", new Object[0]);
            throw null;
        }
        return getNullValue(abstractC0718i);
    }
}
