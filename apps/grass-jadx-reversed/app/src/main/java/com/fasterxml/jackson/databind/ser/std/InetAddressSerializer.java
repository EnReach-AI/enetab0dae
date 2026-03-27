package com.fasterxml.jackson.databind.ser.std;

import java.net.InetAddress;
import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p100g1.AbstractC1399h;
import p112k1.InterfaceC1638f;

/* JADX INFO: loaded from: classes.dex */
public class InetAddressSerializer extends StdScalarSerializer<InetAddress> implements InterfaceC1638f {
    protected final boolean _asNumeric;

    public InetAddressSerializer() {
        this(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
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
            if (r2 == 0) goto L18
            M0.p r2 = r2.f1170f
            boolean r3 = r2.m1013a()
            if (r3 != 0) goto L16
            M0.p r3 = p039M0.EnumC0501p.f1160h
            if (r2 != r3) goto L18
        L16:
            r2 = 1
            goto L19
        L18:
            r2 = 0
        L19:
            boolean r3 = r1._asNumeric
            if (r2 == r3) goto L23
            com.fasterxml.jackson.databind.ser.std.InetAddressSerializer r3 = new com.fasterxml.jackson.databind.ser.std.InetAddressSerializer
            r3.<init>(r2)
            return r3
        L23:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.InetAddressSerializer.createContextual(X0.K, X0.e):X0.s");
    }

    public InetAddressSerializer(boolean z3) {
        super(InetAddress.class);
        this._asNumeric = z3;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(InetAddress inetAddress, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        String strTrim;
        if (this._asNumeric) {
            strTrim = inetAddress.getHostAddress();
        } else {
            strTrim = inetAddress.toString().trim();
            int iIndexOf = strTrim.indexOf(47);
            if (iIndexOf >= 0) {
                strTrim = iIndexOf == 0 ? strTrim.substring(1) : strTrim.substring(0, iIndexOf);
            }
        }
        abstractC0540h.mo1125R(strTrim);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, p069X0.AbstractC0728s
    public void serializeWithType(InetAddress inetAddress, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
        C0672b c0672bM3406d = abstractC1399h.m3406d(EnumC0548p.VALUE_STRING, inetAddress);
        c0672bM3406d.f1824b = InetAddress.class;
        C0672b c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, c0672bM3406d);
        serialize(inetAddress, abstractC0540h, abstractC0709K);
        abstractC1399h.mo3104f(abstractC0540h, c0672bMo3103e);
    }
}
