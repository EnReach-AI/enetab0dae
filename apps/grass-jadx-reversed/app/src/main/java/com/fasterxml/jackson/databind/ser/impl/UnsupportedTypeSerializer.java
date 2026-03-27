package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p078a1.C0850b;

/* JADX INFO: loaded from: classes.dex */
public class UnsupportedTypeSerializer extends StdSerializer<Object> {
    private static final long serialVersionUID = 1;
    protected final String _message;
    protected final AbstractC0721l _type;

    public UnsupportedTypeSerializer(AbstractC0721l abstractC0721l, String str) {
        super(Object.class);
        this._type = abstractC0721l;
        this._message = str;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws C0850b {
        abstractC0709K.mo1713k(this._message);
        throw null;
    }
}
