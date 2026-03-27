package com.fasterxml.jackson.databind.deser.std;

import java.lang.reflect.Method;
import p069X0.AbstractC0718i;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.std.m */
/* JADX INFO: loaded from: classes.dex */
public final class C1197m extends C1199o {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: h */
    public final Method f4071h;

    public C1197m(Method method) {
        super(-1, method.getDeclaringClass(), null);
        this.f4071h = method;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.C1199o
    /* JADX INFO: renamed from: b */
    public final Object mo3043b(AbstractC0718i abstractC0718i, String str) {
        return this.f4071h.invoke(null, str);
    }
}
