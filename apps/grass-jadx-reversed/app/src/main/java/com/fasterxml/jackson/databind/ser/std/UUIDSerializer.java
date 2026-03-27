package com.fasterxml.jackson.databind.ser.std;

import java.util.UUID;
import p042N0.AbstractC0534b;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p092e1.EnumC1339d;
import p092e1.InterfaceC1338c;
import p112k1.InterfaceC1638f;
import p118m1.C1730E;

/* JADX INFO: loaded from: classes.dex */
public class UUIDSerializer extends StdScalarSerializer<UUID> implements InterfaceC1638f {
    static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();
    protected final Boolean _asBinary;

    public UUIDSerializer() {
        this(null);
    }

    private static void _appendInt(int i3, char[] cArr, int i4) {
        _appendShort(i3 >> 16, cArr, i4);
        _appendShort(i3, cArr, i4 + 4);
    }

    private static void _appendShort(int i3, char[] cArr, int i4) {
        char[] cArr2 = HEX_CHARS;
        cArr[i4] = cArr2[(i3 >> 12) & 15];
        cArr[i4 + 1] = cArr2[(i3 >> 8) & 15];
        cArr[i4 + 2] = cArr2[(i3 >> 4) & 15];
        cArr[i4 + 3] = cArr2[i3 & 15];
    }

    private static final byte[] _asBytes(UUID uuid) {
        byte[] bArr = new byte[16];
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        _appendInt((int) (mostSignificantBits >> 32), bArr, 0);
        _appendInt((int) mostSignificantBits, bArr, 4);
        _appendInt((int) (leastSignificantBits >> 32), bArr, 8);
        _appendInt((int) leastSignificantBits, bArr, 12);
        return bArr;
    }

    public boolean _writeAsBinary(AbstractC0540h abstractC0540h) {
        Boolean bool = this._asBinary;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (!(abstractC0540h instanceof C1730E)) {
            abstractC0540h.getClass();
            if (abstractC0540h instanceof C1730E) {
                return true;
            }
        }
        return false;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        visitStringFormat(interfaceC1338c, abstractC0721l, EnumC1339d.f4771h);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    @Override // p112k1.InterfaceC1638f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p069X0.AbstractC0728s createContextual(p069X0.AbstractC0709K r2, p069X0.InterfaceC0714e r3) {
        /*
            r1 = this;
            java.lang.Class r0 = r1.handledType()
            M0.q r2 = r1.findFormatOverrides(r2, r3, r0)
            if (r2 == 0) goto L1a
            M0.p r3 = p039M0.EnumC0501p.f1166n
            M0.p r2 = r2.f1170f
            if (r2 != r3) goto L13
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            goto L1b
        L13:
            M0.p r3 = p039M0.EnumC0501p.f1165m
            if (r2 != r3) goto L1a
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            goto L1b
        L1a:
            r2 = 0
        L1b:
            java.lang.Boolean r3 = r1._asBinary
            boolean r3 = java.util.Objects.equals(r2, r3)
            if (r3 != 0) goto L29
            com.fasterxml.jackson.databind.ser.std.UUIDSerializer r3 = new com.fasterxml.jackson.databind.ser.std.UUIDSerializer
            r3.<init>(r2)
            return r3
        L29:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.UUIDSerializer.createContextual(X0.K, X0.e):X0.s");
    }

    public UUIDSerializer(Boolean bool) {
        super(UUID.class);
        this._asBinary = bool;
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, UUID uuid) {
        return uuid.getLeastSignificantBits() == 0 && uuid.getMostSignificantBits() == 0;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(UUID uuid, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        if (_writeAsBinary(abstractC0540h)) {
            byte[] bArr_asBytes = _asBytes(uuid);
            abstractC0540h.getClass();
            abstractC0540h.mo1139l(AbstractC0534b.f1228b, bArr_asBytes, 0, bArr_asBytes.length);
            return;
        }
        char[] cArr = new char[36];
        long mostSignificantBits = uuid.getMostSignificantBits();
        _appendInt((int) (mostSignificantBits >> 32), cArr, 0);
        cArr[8] = '-';
        int i3 = (int) mostSignificantBits;
        _appendShort(i3 >>> 16, cArr, 9);
        cArr[13] = '-';
        _appendShort(i3, cArr, 14);
        cArr[18] = '-';
        long leastSignificantBits = uuid.getLeastSignificantBits();
        _appendShort((int) (leastSignificantBits >>> 48), cArr, 19);
        cArr[23] = '-';
        _appendShort((int) (leastSignificantBits >>> 32), cArr, 24);
        _appendInt((int) leastSignificantBits, cArr, 28);
        abstractC0540h.mo1123P(0, cArr, 36);
    }

    private static final void _appendInt(int i3, byte[] bArr, int i4) {
        bArr[i4] = (byte) (i3 >> 24);
        bArr[i4 + 1] = (byte) (i3 >> 16);
        bArr[i4 + 2] = (byte) (i3 >> 8);
        bArr[i4 + 3] = (byte) i3;
    }
}
