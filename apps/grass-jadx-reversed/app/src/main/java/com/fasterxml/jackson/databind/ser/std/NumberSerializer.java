package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import p039M0.C0502q;
import p042N0.AbstractC0540h;
import p042N0.EnumC0539g;
import p042N0.EnumC0544l;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.AbstractC0728s;
import p069X0.C0724o;
import p069X0.InterfaceC0714e;
import p071Y0.InterfaceC0738b;
import p092e1.InterfaceC1338c;
import p112k1.AbstractC1640h;
import p112k1.InterfaceC1638f;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class NumberSerializer extends StdScalarSerializer<Number> implements InterfaceC1638f {
    protected static final int MAX_BIG_DECIMAL_SCALE = 9999;
    public static final NumberSerializer instance = new NumberSerializer(Number.class);
    protected final boolean _isInt;

    public static final class BigDecimalAsStringSerializer extends ToStringSerializerBase {
        static final BigDecimalAsStringSerializer BD_INSTANCE = new BigDecimalAsStringSerializer();

        public BigDecimalAsStringSerializer() {
            super(BigDecimal.class);
        }

        public boolean _verifyBigDecimalRange(AbstractC0540h abstractC0540h, BigDecimal bigDecimal) {
            int iScale = bigDecimal.scale();
            return iScale >= -9999 && iScale <= NumberSerializer.MAX_BIG_DECIMAL_SCALE;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ToStringSerializerBase, p069X0.AbstractC0728s
        public boolean isEmpty(AbstractC0709K abstractC0709K, Object obj) {
            return false;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ToStringSerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
        public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws C0724o {
            String string;
            if (abstractC0540h.mo1134g(EnumC0539g.WRITE_BIGDECIMAL_AS_PLAIN)) {
                BigDecimal bigDecimal = (BigDecimal) obj;
                if (!_verifyBigDecimalRange(abstractC0540h, bigDecimal)) {
                    String str = String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", Integer.valueOf(bigDecimal.scale()), Integer.valueOf(NumberSerializer.MAX_BIG_DECIMAL_SCALE), Integer.valueOf(NumberSerializer.MAX_BIG_DECIMAL_SCALE));
                    abstractC0709K.getClass();
                    throw new C0724o(((AbstractC1640h) abstractC0709K).f5838u, str, (Throwable) null);
                }
                string = bigDecimal.toPlainString();
            } else {
                string = obj.toString();
            }
            abstractC0540h.mo1125R(string);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ToStringSerializerBase
        public String valueToString(Object obj) {
            throw new IllegalStateException();
        }
    }

    public NumberSerializer(Class<? extends Number> cls) {
        super(cls, false);
        this._isInt = cls == BigInteger.class;
    }

    public static AbstractC0728s bigDecimalAsStringSerializer() {
        return BigDecimalAsStringSerializer.BD_INSTANCE;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        if (this._isInt) {
            visitIntFormat(interfaceC1338c, abstractC0721l, EnumC0544l.f1300g);
        } else if (handledType() == BigDecimal.class) {
            visitFloatFormat(interfaceC1338c, abstractC0721l, EnumC0544l.f1303j);
        } else {
            interfaceC1338c.getClass();
        }
    }

    @Override // p112k1.InterfaceC1638f
    public AbstractC0728s createContextual(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e) {
        C0502q c0502qFindFormatOverrides = findFormatOverrides(abstractC0709K, interfaceC0714e, handledType());
        return (c0502qFindFormatOverrides == null || c0502qFindFormatOverrides.f1170f.ordinal() != 8) ? this : handledType() == BigDecimal.class ? bigDecimalAsStringSerializer() : ToStringSerializer.instance;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
        return createSchemaNode(this._isInt ? "integer" : "number", true);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(Number number, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        if (number instanceof BigDecimal) {
            abstractC0540h.mo1152y((BigDecimal) number);
            return;
        }
        if (number instanceof BigInteger) {
            abstractC0540h.mo1153z((BigInteger) number);
            return;
        }
        if (number instanceof Long) {
            abstractC0540h.mo1150w(number.longValue());
            return;
        }
        if (number instanceof Double) {
            abstractC0540h.mo1147t(number.doubleValue());
            return;
        }
        if (number instanceof Float) {
            abstractC0540h.mo1148u(number.floatValue());
        } else if ((number instanceof Integer) || (number instanceof Byte) || (number instanceof Short)) {
            abstractC0540h.mo1149v(number.intValue());
        } else {
            abstractC0540h.mo1151x(number.toString());
        }
    }
}
