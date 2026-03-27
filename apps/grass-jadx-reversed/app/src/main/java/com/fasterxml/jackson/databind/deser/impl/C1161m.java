package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.AbstractC1184s;
import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import java.util.Collection;
import java.util.Map;
import p005B.AbstractC0032g;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p069X0.C0717h;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.m */
/* JADX INFO: loaded from: classes.dex */
public final class C1161m extends AbstractC1184s {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: r */
    public final String f4011r;

    /* JADX INFO: renamed from: s */
    public final boolean f4012s;

    /* JADX INFO: renamed from: t */
    public final AbstractC1204t f4013t;

    public C1161m(AbstractC1204t abstractC1204t, String str, AbstractC1204t abstractC1204t2, boolean z3) {
        super(abstractC1204t);
        this.f4011r = str;
        this.f4013t = abstractC1204t2;
        this.f4012s = z3;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1184s, com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: B */
    public final void mo2961B(Object obj, Object obj2) {
        mo2962C(obj, obj2);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1184s, com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: C */
    public final Object mo2962C(Object obj, Object obj2) {
        if (obj2 != null) {
            boolean z3 = this.f4012s;
            AbstractC1204t abstractC1204t = this.f4013t;
            if (!z3) {
                abstractC1204t.mo2961B(obj2, obj);
            } else if (obj2 instanceof Object[]) {
                for (Object obj3 : (Object[]) obj2) {
                    if (obj3 != null) {
                        abstractC1204t.mo2961B(obj3, obj);
                    }
                }
            } else if (obj2 instanceof Collection) {
                for (Object obj4 : (Collection) obj2) {
                    if (obj4 != null) {
                        abstractC1204t.mo2961B(obj4, obj);
                    }
                }
            } else {
                if (!(obj2 instanceof Map)) {
                    StringBuilder sb = new StringBuilder("Unsupported container type (");
                    sb.append(obj2.getClass().getName());
                    sb.append(") when resolving reference '");
                    throw new IllegalStateException(AbstractC0032g.m157o(sb, this.f4011r, "'"));
                }
                for (Object obj5 : ((Map) obj2).values()) {
                    if (obj5 != null) {
                        abstractC1204t.mo2961B(obj5, obj);
                    }
                }
            }
        }
        return this.f4049q.mo2962C(obj, obj2);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1184s
    /* JADX INFO: renamed from: I */
    public final AbstractC1204t mo3004I(AbstractC1204t abstractC1204t) {
        throw new IllegalStateException("Should never try to reset delegate");
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: k */
    public final void mo2967k(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) {
        mo2962C(obj, this.f4049q.m3079j(abstractC0545m, abstractC0718i));
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: l */
    public final Object mo2968l(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) {
        return mo2962C(obj, m3079j(abstractC0545m, abstractC0718i));
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1184s, com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: n */
    public final void mo2969n(C0717h c0717h) {
        this.f4049q.mo2969n(c0717h);
        this.f4013t.mo2969n(c0717h);
    }
}
