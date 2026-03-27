package com.fasterxml.jackson.databind.ser.std;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p100g1.AbstractC1399h;

/* JADX INFO: loaded from: classes.dex */
public class InetSocketAddressSerializer extends StdScalarSerializer<InetSocketAddress> {
    public InetSocketAddressSerializer() {
        super(InetSocketAddress.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(InetSocketAddress inetSocketAddress, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        String strSubstring;
        InetAddress address = inetSocketAddress.getAddress();
        String hostName = address == null ? inetSocketAddress.getHostName() : address.toString().trim();
        int iIndexOf = hostName.indexOf(47);
        if (iIndexOf >= 0) {
            if (iIndexOf == 0) {
                if (address instanceof Inet6Address) {
                    strSubstring = "[" + hostName.substring(1) + "]";
                } else {
                    strSubstring = hostName.substring(1);
                }
                hostName = strSubstring;
            } else {
                hostName = hostName.substring(0, iIndexOf);
            }
        }
        abstractC0540h.mo1125R(hostName + ":" + inetSocketAddress.getPort());
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, p069X0.AbstractC0728s
    public void serializeWithType(InetSocketAddress inetSocketAddress, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
        C0672b c0672bM3406d = abstractC1399h.m3406d(EnumC0548p.VALUE_STRING, inetSocketAddress);
        c0672bM3406d.f1824b = InetSocketAddress.class;
        C0672b c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, c0672bM3406d);
        serialize(inetSocketAddress, abstractC0540h, abstractC0709K);
        abstractC1399h.mo3104f(abstractC0540h, c0672bMo3103e);
    }
}
