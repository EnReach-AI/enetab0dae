package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;
import java.util.HashMap;
import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.EnumC0708J;
import p092e1.EnumC1337b;
import p092e1.InterfaceC1338c;
import p100g1.AbstractC1399h;
import p109j1.C1514v;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.ser.std.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1230c {

    /* JADX INFO: renamed from: a */
    public static final HashMap f4160a;

    static {
        HashMap map = new HashMap();
        f4160a = map;
        map.put(boolean[].class.getName(), new StdArraySerializers$BooleanArraySerializer());
        map.put(byte[].class.getName(), new ByteArraySerializer());
        map.put(char[].class.getName(), new StdSerializer<char[]>() { // from class: com.fasterxml.jackson.databind.ser.std.StdArraySerializers$CharArraySerializer
            private final void _writeArrayContents(AbstractC0540h abstractC0540h, char[] cArr) {
                int length = cArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    abstractC0540h.mo1123P(i3, cArr, 1);
                }
            }

            @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
            public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
                visitArrayFormat(interfaceC1338c, abstractC0721l, EnumC1337b.f4763e);
            }

            @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer
            @Deprecated
            public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
                C1514v c1514vCreateSchemaNode = createSchemaNode("array", true);
                C1514v c1514vCreateSchemaNode2 = createSchemaNode("string");
                c1514vCreateSchemaNode2.m3556p("type", "string");
                c1514vCreateSchemaNode.m3559s("items", c1514vCreateSchemaNode2);
                return c1514vCreateSchemaNode;
            }

            @Override // p069X0.AbstractC0728s
            public boolean isEmpty(AbstractC0709K abstractC0709K, char[] cArr) {
                return cArr.length == 0;
            }

            @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
            public void serialize(char[] cArr, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
                if (!abstractC0709K.f1966e.m1698r(EnumC0708J.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                    abstractC0540h.mo1123P(0, cArr, cArr.length);
                    return;
                }
                int length = cArr.length;
                abstractC0540h.mo1119L(cArr);
                _writeArrayContents(abstractC0540h, cArr);
                abstractC0540h.mo1142o();
            }

            @Override // p069X0.AbstractC0728s
            public void serializeWithType(char[] cArr, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
                C0672b c0672bMo3103e;
                if (abstractC0709K.f1966e.m1698r(EnumC0708J.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                    c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, abstractC1399h.m3406d(EnumC0548p.START_ARRAY, cArr));
                    _writeArrayContents(abstractC0540h, cArr);
                } else {
                    c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, abstractC1399h.m3406d(EnumC0548p.VALUE_STRING, cArr));
                    abstractC0540h.mo1123P(0, cArr, cArr.length);
                }
                abstractC1399h.mo3104f(abstractC0540h, c0672bMo3103e);
            }
        });
        map.put(short[].class.getName(), new StdArraySerializers$ShortArraySerializer());
        map.put(int[].class.getName(), new StdArraySerializers$IntArraySerializer());
        map.put(long[].class.getName(), new StdArraySerializers$LongArraySerializer());
        map.put(float[].class.getName(), new StdArraySerializers$FloatArraySerializer());
        map.put(double[].class.getName(), new StdArraySerializers$DoubleArraySerializer());
    }
}
