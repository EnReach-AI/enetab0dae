package com.fasterxml.jackson.databind.ser.std;

import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class StdKeySerializer extends StdSerializer<Object> {
    public StdKeySerializer() {
        super(Object.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        abstractC0540h.mo1145r(obj.toString());
    }
}
