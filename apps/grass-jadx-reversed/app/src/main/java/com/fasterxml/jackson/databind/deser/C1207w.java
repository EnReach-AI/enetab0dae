package com.fasterxml.jackson.databind.deser;

import java.io.Serializable;
import p069X0.AbstractC0721l;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.w */
/* JADX INFO: loaded from: classes.dex */
public class C1207w extends AbstractC1208x implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final Class f4115e;

    public C1207w(Class cls) {
        this.f4115e = cls;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1208x
    /* JADX INFO: renamed from: E */
    public final Class mo3049E() {
        return this.f4115e;
    }

    public C1207w(AbstractC0721l abstractC0721l) {
        this.f4115e = abstractC0721l.f2036e;
    }
}
