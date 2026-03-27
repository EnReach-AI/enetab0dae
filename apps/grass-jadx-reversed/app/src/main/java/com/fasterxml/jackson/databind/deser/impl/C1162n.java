package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.AbstractC1184s;
import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p082b1.AbstractC1041l;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.n */
/* JADX INFO: loaded from: classes.dex */
public final class C1162n extends AbstractC1184s {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: r */
    public final AbstractC1041l f4014r;

    public C1162n(AbstractC1204t abstractC1204t, AbstractC1041l abstractC1041l) {
        super(abstractC1204t);
        this.f4014r = abstractC1041l;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1184s, com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: B */
    public final void mo2961B(Object obj, Object obj2) {
        if (obj2 != null) {
            this.f4049q.mo2961B(obj, obj2);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1184s, com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: C */
    public final Object mo2962C(Object obj, Object obj2) {
        return obj2 != null ? this.f4049q.mo2962C(obj, obj2) : obj;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1184s
    /* JADX INFO: renamed from: I */
    public final AbstractC1204t mo3004I(AbstractC1204t abstractC1204t) {
        return new C1162n(abstractC1204t, this.f4014r);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: k */
    public final void mo2967k(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) {
        Object objMo2772l = this.f4014r.mo2772l(obj);
        AbstractC1204t abstractC1204t = this.f4049q;
        Object objM3079j = objMo2772l == null ? abstractC1204t.m3079j(abstractC0545m, abstractC0718i) : abstractC1204t.m3080m(abstractC0545m, abstractC0718i, objMo2772l);
        if (objM3079j != objMo2772l) {
            abstractC1204t.mo2961B(obj, objM3079j);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: l */
    public final Object mo2968l(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) {
        Object objMo2772l = this.f4014r.mo2772l(obj);
        AbstractC1204t abstractC1204t = this.f4049q;
        Object objM3079j = objMo2772l == null ? abstractC1204t.m3079j(abstractC0545m, abstractC0718i) : abstractC1204t.m3080m(abstractC0545m, abstractC0718i, objMo2772l);
        return (objM3079j == objMo2772l || objM3079j == null) ? obj : abstractC1204t.mo2962C(obj, objM3079j);
    }
}
