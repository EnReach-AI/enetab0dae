package com.fasterxml.jackson.databind.ser.std;

import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.ser.std.d */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1231d {

    /* JADX INFO: renamed from: a */
    public static final StdKeySerializers$StringKeySerializer f4161a;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.fasterxml.jackson.databind.ser.std.StdKeySerializers$StringKeySerializer] */
    static {
        new StdKeySerializer();
        f4161a = new StdSerializer<Object>() { // from class: com.fasterxml.jackson.databind.ser.std.StdKeySerializers$StringKeySerializer
            @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
            public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
                abstractC0540h.mo1145r((String) obj);
            }
        };
    }
}
