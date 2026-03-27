package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import java.io.Serializable;
import p069X0.AbstractC0718i;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.q */
/* JADX INFO: loaded from: classes.dex */
public final class C1165q implements InterfaceC1178m, Serializable {

    /* JADX INFO: renamed from: f */
    public static final C1165q f4019f = new C1165q(null);

    /* JADX INFO: renamed from: g */
    public static final C1165q f4020g = new C1165q(null);
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final Object f4021e;

    public C1165q(Object obj) {
        this.f4021e = obj;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3010a(InterfaceC1178m interfaceC1178m) {
        return interfaceC1178m == f4019f;
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1178m
    public final Object getNullValue(AbstractC0718i abstractC0718i) {
        return this.f4021e;
    }
}
