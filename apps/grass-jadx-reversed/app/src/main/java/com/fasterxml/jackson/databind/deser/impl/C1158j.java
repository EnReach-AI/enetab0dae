package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.C1207w;
import java.util.HashMap;
import p069X0.AbstractC0718i;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.j */
/* JADX INFO: loaded from: classes.dex */
public final class C1158j extends C1207w {

    /* JADX INFO: renamed from: f */
    public static final C1158j f4007f = new C1158j(HashMap.class);
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
        return new HashMap();
    }
}
