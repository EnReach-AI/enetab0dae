package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import p039M0.C0502q;
import p042N0.EnumC0544l;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.AbstractC0728s;
import p069X0.InterfaceC0714e;
import p092e1.InterfaceC1338c;
import p112k1.InterfaceC1638f;

/* JADX INFO: loaded from: classes.dex */
public abstract class NumberSerializers$Base<T> extends StdScalarSerializer<T> implements InterfaceC1638f {
    protected final boolean _isInt;
    protected final EnumC0544l _numberType;
    protected final String _schemaType;

    public NumberSerializers$Base(Class<?> cls, EnumC0544l enumC0544l, String str) {
        super(cls, false);
        this._numberType = enumC0544l;
        this._schemaType = str;
        this._isInt = enumC0544l == EnumC0544l.f1298e || enumC0544l == EnumC0544l.f1299f || enumC0544l == EnumC0544l.f1300g;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        if (this._isInt) {
            visitIntFormat(interfaceC1338c, abstractC0721l, this._numberType);
        } else {
            visitFloatFormat(interfaceC1338c, abstractC0721l, this._numberType);
        }
    }

    @Override // p112k1.InterfaceC1638f
    public AbstractC0728s createContextual(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e) {
        C0502q c0502qFindFormatOverrides = findFormatOverrides(abstractC0709K, interfaceC0714e, handledType());
        return (c0502qFindFormatOverrides == null || c0502qFindFormatOverrides.f1170f.ordinal() != 8) ? this : handledType() == BigDecimal.class ? NumberSerializer.bigDecimalAsStringSerializer() : ToStringSerializer.instance;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
        return createSchemaNode(this._schemaType, true);
    }
}
