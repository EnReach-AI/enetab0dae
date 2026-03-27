package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.C1207w;
import java.util.LinkedHashMap;
import p069X0.AbstractC0718i;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.k */
/* JADX INFO: loaded from: classes.dex */
public final class C1159k extends C1207w {

    /* JADX INFO: renamed from: f */
    public static final C1159k f4008f = new C1159k(LinkedHashMap.class);
    private static final long serialVersionUID = 2;

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
        return new LinkedHashMap();
    }
}
