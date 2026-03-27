package com.fasterxml.jackson.databind.deser;

import java.lang.reflect.InvocationTargetException;
import p069X0.AbstractC0722m;
import p069X0.C0713d;
import p082b1.C1043n;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.q */
/* JADX INFO: loaded from: classes.dex */
public final class C1182q extends AbstractC1183r {
    private static final long serialVersionUID = 1;

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1183r
    /* JADX INFO: renamed from: a */
    public final void mo3021a(Object obj, Object obj2, Object obj3) throws IllegalAccessException, InvocationTargetException {
        ((C1043n) this.f4044f).f3704h.invoke(obj, obj2, obj3);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1183r
    /* JADX INFO: renamed from: e */
    public final AbstractC1183r mo3024e(AbstractC0722m abstractC0722m) {
        return new C1182q((C0713d) this.f4043e, this.f4044f, this.f4045g, this.f4048j, abstractC0722m, this.f4047i);
    }
}
