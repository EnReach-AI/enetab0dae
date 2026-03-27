package com.fasterxml.jackson.databind.deser.std;

import java.lang.reflect.Constructor;
import p069X0.AbstractC0718i;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.std.l */
/* JADX INFO: loaded from: classes.dex */
public final class C1196l extends C1199o {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: h */
    public final Constructor f4070h;

    public C1196l(Constructor constructor) {
        super(-1, constructor.getDeclaringClass(), null);
        this.f4070h = constructor;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.C1199o
    /* JADX INFO: renamed from: b */
    public final Object mo3043b(AbstractC0718i abstractC0718i, String str) {
        return this.f4070h.newInstance(str);
    }
}
