package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import java.io.Serializable;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.C0703E;
import p078a1.C0852d;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.r */
/* JADX INFO: loaded from: classes.dex */
public final class C1166r implements InterfaceC1178m, Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final C0703E f4022e;

    public C1166r(C0703E c0703e, AbstractC0721l abstractC0721l) {
        this.f4022e = c0703e;
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1178m
    public final Object getNullValue(AbstractC0718i abstractC0718i) throws C0852d {
        throw C0852d.m2187i(abstractC0718i, this.f4022e);
    }
}
