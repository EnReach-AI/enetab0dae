package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import java.sql.Blob;
import java.sql.SQLException;
import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.C0724o;
import p071Y0.InterfaceC0738b;
import p092e1.InterfaceC1338c;
import p100g1.AbstractC1399h;
import p112k1.AbstractC1640h;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class SqlBlobSerializer extends StdScalarSerializer<Blob> {
    public SqlBlobSerializer() {
        super(Blob.class);
    }

    public void _writeValue(Blob blob, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws C0724o {
        try {
            abstractC0540h.mo1138k(abstractC0709K.f1966e.f2481f.f2429o, blob.getBinaryStream(), -1);
        } catch (SQLException e3) {
            abstractC0709K.getClass();
            throw new C0724o(((AbstractC1640h) abstractC0709K).f5838u, "Failed to access `java.sql.Blob` value to write as binary value", e3);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        interfaceC1338c.getClass();
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, Blob blob) {
        return blob == null;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(Blob blob, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws C0724o {
        _writeValue(blob, abstractC0540h, abstractC0709K);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, p069X0.AbstractC0728s
    public void serializeWithType(Blob blob, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) throws C0724o {
        C0672b c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, abstractC1399h.m3406d(EnumC0548p.VALUE_EMBEDDED_OBJECT, blob));
        _writeValue(blob, abstractC0540h, abstractC0709K);
        abstractC1399h.mo3104f(abstractC0540h, c0672bMo3103e);
    }
}
