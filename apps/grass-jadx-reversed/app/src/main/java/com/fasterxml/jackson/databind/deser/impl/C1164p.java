package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import java.io.Serializable;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.p */
/* JADX INFO: loaded from: classes.dex */
public final class C1164p implements InterfaceC1178m, Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final AbstractC0722m f4018e;

    public C1164p(AbstractC0722m abstractC0722m) {
        this.f4018e = abstractC0722m;
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1178m
    public final Object getNullValue(AbstractC0718i abstractC0718i) {
        return this.f4018e.getEmptyValue(abstractC0718i);
    }
}
