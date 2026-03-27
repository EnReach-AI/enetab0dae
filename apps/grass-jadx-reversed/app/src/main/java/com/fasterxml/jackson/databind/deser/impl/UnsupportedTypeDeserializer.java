package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p078a1.C0850b;

/* JADX INFO: loaded from: classes.dex */
public class UnsupportedTypeDeserializer extends StdDeserializer<Object> {
    private static final long serialVersionUID = 1;
    protected final String _message;
    protected final AbstractC0721l _type;

    public UnsupportedTypeDeserializer(AbstractC0721l abstractC0721l, String str) {
        super(abstractC0721l);
        this._type = abstractC0721l;
        this._message = str;
    }

    @Override // p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        Object objMo1202q;
        if (abstractC0545m.mo1190e() == EnumC0548p.VALUE_EMBEDDED_OBJECT && ((objMo1202q = abstractC0545m.mo1202q()) == null || this._type.f2036e.isAssignableFrom(objMo1202q.getClass()))) {
            return objMo1202q;
        }
        abstractC0718i.mo1713k(this._message);
        throw null;
    }
}
