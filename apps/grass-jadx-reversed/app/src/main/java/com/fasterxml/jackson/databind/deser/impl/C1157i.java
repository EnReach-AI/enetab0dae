package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.C1207w;
import p069X0.AbstractC0718i;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1157i extends C1207w {
    private static final long serialVersionUID = 2;

    /* JADX INFO: renamed from: f */
    public final Object f4006f;

    public C1157i(Object obj) {
        super(obj.getClass());
        this.f4006f = obj;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: j */
    public final boolean mo3005j() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: l */
    public final boolean mo3006l() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: v */
    public final Object mo3007v(AbstractC0718i abstractC0718i) {
        return this.f4006f;
    }
}
