package com.fasterxml.jackson.databind.deser.std;

import java.util.Arrays;
import java.util.UUID;
import p042N0.AbstractC0534b;
import p042N0.AbstractC0545m;
import p042N0.C0533a;
import p066W0.C0676c;
import p069X0.AbstractC0718i;
import p078a1.C0851c;

/* JADX INFO: loaded from: classes.dex */
public class UUIDDeserializer extends FromStringDeserializer<UUID> {
    static final int[] HEX_DIGITS;
    private static final long serialVersionUID = 1;

    static {
        int[] iArr = new int[127];
        HEX_DIGITS = iArr;
        Arrays.fill(iArr, -1);
        for (int i3 = 0; i3 < 10; i3++) {
            HEX_DIGITS[i3 + 48] = i3;
        }
        for (int i4 = 0; i4 < 6; i4++) {
            int[] iArr2 = HEX_DIGITS;
            int i5 = i4 + 10;
            iArr2[i4 + 97] = i5;
            iArr2[i4 + 65] = i5;
        }
    }

    public UUIDDeserializer() {
        super(UUID.class);
    }

    private UUID _badFormat(String str, AbstractC0718i abstractC0718i) throws C0851c {
        abstractC0718i.m1829G(handledType(), str, "UUID has to be represented by standard 36-char representation", new Object[0]);
        throw null;
    }

    private UUID _fromBytes(byte[] bArr, AbstractC0718i abstractC0718i) throws C0851c {
        if (bArr.length == 16) {
            return new UUID(_long(bArr, 0), _long(bArr, 8));
        }
        AbstractC0545m abstractC0545m = abstractC0718i.f2002k;
        String str = "Can only construct UUIDs from byte[16]; got " + bArr.length + " bytes";
        handledType();
        throw new C0851c(abstractC0545m, str, bArr);
    }

    private static int _int(byte[] bArr, int i3) {
        return (bArr[i3 + 3] & 255) | (bArr[i3] << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
    }

    private static long _long(byte[] bArr, int i3) {
        return ((((long) _int(bArr, i3 + 4)) << 32) >>> 32) | (((long) _int(bArr, i3)) << 32);
    }

    public int _badChar(String str, int i3, AbstractC0718i abstractC0718i, char c3) throws C0851c {
        throw abstractC0718i.m1846Y(str, handledType(), String.format("Non-hex character '%c' (value 0x%s), not valid for UUID String", Character.valueOf(c3), Integer.toHexString(c3)));
    }

    public int byteFromChars(String str, int i3, AbstractC0718i abstractC0718i) {
        char cCharAt = str.charAt(i3);
        int i4 = i3 + 1;
        char cCharAt2 = str.charAt(i4);
        if (cCharAt <= 127 && cCharAt2 <= 127) {
            int[] iArr = HEX_DIGITS;
            int i5 = iArr[cCharAt2] | (iArr[cCharAt] << 4);
            if (i5 >= 0) {
                return i5;
            }
        }
        return (cCharAt > 127 || HEX_DIGITS[cCharAt] < 0) ? _badChar(str, i3, abstractC0718i, cCharAt) : _badChar(str, i4, abstractC0718i, cCharAt2);
    }

    @Override // p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return new UUID(0L, 0L);
    }

    public int intFromChars(String str, int i3, AbstractC0718i abstractC0718i) {
        return byteFromChars(str, i3 + 6, abstractC0718i) + (byteFromChars(str, i3, abstractC0718i) << 24) + (byteFromChars(str, i3 + 2, abstractC0718i) << 16) + (byteFromChars(str, i3 + 4, abstractC0718i) << 8);
    }

    public int shortFromChars(String str, int i3, AbstractC0718i abstractC0718i) {
        return byteFromChars(str, i3 + 2, abstractC0718i) + (byteFromChars(str, i3, abstractC0718i) << 8);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
    public UUID _deserialize(String str, AbstractC0718i abstractC0718i) throws C0851c {
        if (str.length() != 36) {
            if (str.length() != 24) {
                return _badFormat(str, abstractC0718i);
            }
            C0533a c0533a = AbstractC0534b.f1228b;
            c0533a.getClass();
            C0676c c0676c = new C0676c(null);
            c0533a.m1072b(str, c0676c);
            return _fromBytes(c0676c.m1639f(), abstractC0718i);
        }
        if (str.charAt(8) != '-' || str.charAt(13) != '-' || str.charAt(18) != '-' || str.charAt(23) != '-') {
            _badFormat(str, abstractC0718i);
        }
        return new UUID((((long) intFromChars(str, 0, abstractC0718i)) << 32) + ((((long) shortFromChars(str, 9, abstractC0718i)) << 16) | ((long) shortFromChars(str, 14, abstractC0718i))), ((((long) intFromChars(str, 28, abstractC0718i)) << 32) >>> 32) | (((long) (shortFromChars(str, 24, abstractC0718i) | (shortFromChars(str, 19, abstractC0718i) << 16))) << 32));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
    public UUID _deserializeEmbedded(Object obj, AbstractC0718i abstractC0718i) {
        return obj instanceof byte[] ? _fromBytes((byte[]) obj, abstractC0718i) : (UUID) super._deserializeEmbedded(obj, abstractC0718i);
    }
}
