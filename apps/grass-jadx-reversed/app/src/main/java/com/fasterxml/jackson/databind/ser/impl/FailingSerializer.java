package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.C0724o;
import p112k1.AbstractC1640h;

/* JADX INFO: loaded from: classes.dex */
public class FailingSerializer extends StdSerializer<Object> {
    protected final String _msg;

    public FailingSerializer(String str) {
        super(Object.class);
        this._msg = str;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws C0724o {
        String str = this._msg;
        abstractC0709K.getClass();
        throw new C0724o(((AbstractC1640h) abstractC0709K).f5838u, str, (Throwable) null);
    }
}
