package com.fasterxml.jackson.databind.deser.impl;

import androidx.fragment.app.AbstractC0935f;
import com.fasterxml.jackson.databind.deser.AbstractC1183r;
import java.io.IOException;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.y */
/* JADX INFO: loaded from: classes.dex */
public final class C1173y extends AbstractC0935f {

    /* JADX INFO: renamed from: c */
    public final AbstractC1183r f4035c;

    /* JADX INFO: renamed from: d */
    public final String f4036d;

    public C1173y(AbstractC0935f abstractC0935f, Object obj, AbstractC1183r abstractC1183r, String str) {
        super(abstractC0935f, obj);
        this.f4035c = abstractC1183r;
        this.f4036d = str;
    }

    @Override // androidx.fragment.app.AbstractC0935f
    /* JADX INFO: renamed from: c */
    public final void mo2448c(Object obj) throws IOException {
        this.f4035c.m3026d(obj, this.f4036d, this.f3161b);
    }
}
