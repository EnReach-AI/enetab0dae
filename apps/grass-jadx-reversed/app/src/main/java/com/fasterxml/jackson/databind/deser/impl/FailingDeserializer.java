package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p078a1.C0850b;

/* JADX INFO: loaded from: classes.dex */
public class FailingDeserializer extends StdDeserializer<Object> {
    private static final long serialVersionUID = 1;
    protected final String _message;

    public FailingDeserializer(String str) {
        this(Object.class, str);
    }

    @Override // p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        abstractC0718i.m1841S(this, this._message, new Object[0]);
        throw null;
    }

    public FailingDeserializer(Class<?> cls, String str) {
        super(cls);
        this._message = str;
    }
}
