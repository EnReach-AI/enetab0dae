package com.fasterxml.jackson.databind.ser.impl;

import p039M0.AbstractC0485d0;
import p042N0.AbstractC0540h;
import p042N0.C0538f;
import p042N0.InterfaceC0551s;
import p069X0.AbstractC0709K;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.ser.impl.o */
/* JADX INFO: loaded from: classes.dex */
public final class C1227o {

    /* JADX INFO: renamed from: a */
    public final AbstractC0485d0 f4155a;

    /* JADX INFO: renamed from: b */
    public Object f4156b;

    /* JADX INFO: renamed from: c */
    public boolean f4157c = false;

    public C1227o(AbstractC0485d0 abstractC0485d0) {
        this.f4155a = abstractC0485d0;
    }

    /* JADX INFO: renamed from: a */
    public final void m3098a(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, C1216d c1216d) throws C0538f {
        this.f4157c = true;
        if (abstractC0540h.mo1130c()) {
            Object obj = this.f4156b;
            abstractC0540h.mo1110C(obj == null ? null : String.valueOf(obj));
            return;
        }
        InterfaceC0551s interfaceC0551s = c1216d.f4131b;
        if (interfaceC0551s != null) {
            abstractC0540h.mo1144q(interfaceC0551s);
            c1216d.f4133d.serialize(this.f4156b, abstractC0540h, abstractC0709K);
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m3099b(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, C1216d c1216d) throws C0538f {
        if (this.f4156b == null) {
            return false;
        }
        if (!this.f4157c && !c1216d.f4134e) {
            return false;
        }
        if (abstractC0540h.mo1130c()) {
            String.valueOf(this.f4156b);
            throw new C0538f("No native support for writing Object Ids", abstractC0540h);
        }
        c1216d.f4133d.serialize(this.f4156b, abstractC0540h, abstractC0709K);
        return true;
    }
}
