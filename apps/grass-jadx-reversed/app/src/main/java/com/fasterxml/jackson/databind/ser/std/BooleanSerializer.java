package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;
import p039M0.C0502q;
import p039M0.EnumC0501p;
import p042N0.AbstractC0540h;
import p042N0.EnumC0544l;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.AbstractC0728s;
import p069X0.InterfaceC0714e;
import p071Y0.InterfaceC0738b;
import p092e1.InterfaceC1338c;
import p100g1.AbstractC1399h;
import p112k1.InterfaceC1638f;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public final class BooleanSerializer extends StdScalarSerializer<Object> implements InterfaceC1638f {
    private static final long serialVersionUID = 1;
    protected final boolean _forPrimitive;

    public static final class AsNumber extends StdScalarSerializer<Object> implements InterfaceC1638f {
        private static final long serialVersionUID = 1;
        protected final boolean _forPrimitive;

        public AsNumber(boolean z3) {
            super(z3 ? Boolean.TYPE : Boolean.class, false);
            this._forPrimitive = z3;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
        public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
            visitIntFormat(interfaceC1338c, abstractC0721l, EnumC0544l.f1298e);
        }

        @Override // p112k1.InterfaceC1638f
        public AbstractC0728s createContextual(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e) {
            C0502q c0502qFindFormatOverrides = findFormatOverrides(abstractC0709K, interfaceC0714e, Boolean.class);
            return (c0502qFindFormatOverrides == null || c0502qFindFormatOverrides.f1170f.m1013a()) ? this : new BooleanSerializer(this._forPrimitive);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
        public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
            abstractC0540h.mo1149v(!Boolean.FALSE.equals(obj) ? 1 : 0);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, p069X0.AbstractC0728s
        public final void serializeWithType(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
            abstractC0540h.mo1140m(Boolean.TRUE.equals(obj));
        }
    }

    public BooleanSerializer(boolean z3) {
        super(z3 ? Boolean.TYPE : Boolean.class, false);
        this._forPrimitive = z3;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        interfaceC1338c.getClass();
    }

    @Override // p112k1.InterfaceC1638f
    public AbstractC0728s createContextual(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e) {
        C0502q c0502qFindFormatOverrides = findFormatOverrides(abstractC0709K, interfaceC0714e, handledType());
        if (c0502qFindFormatOverrides != null) {
            EnumC0501p enumC0501p = c0502qFindFormatOverrides.f1170f;
            if (enumC0501p.m1013a()) {
                return new AsNumber(this._forPrimitive);
            }
            if (enumC0501p == EnumC0501p.f1165m) {
                return new ToStringSerializer(this._handledType);
            }
        }
        return this;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
        return createSchemaNode("boolean", !this._forPrimitive);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        abstractC0540h.mo1140m(Boolean.TRUE.equals(obj));
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, p069X0.AbstractC0728s
    public final void serializeWithType(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
        abstractC0540h.mo1140m(Boolean.TRUE.equals(obj));
    }
}
