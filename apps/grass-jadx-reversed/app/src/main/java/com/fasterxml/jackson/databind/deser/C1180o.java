package com.fasterxml.jackson.databind.deser;

import p005B.AbstractC0032g;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.AbstractC0725p;
import p069X0.C0713d;
import p069X0.C0724o;
import p082b1.C1039j;
import p109j1.C1505m;
import p109j1.C1514v;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.o */
/* JADX INFO: loaded from: classes.dex */
public final class C1180o extends AbstractC1183r {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: k */
    public final C1505m f4041k;

    public C1180o(C0713d c0713d, C1039j c1039j, AbstractC0721l abstractC0721l, AbstractC0722m abstractC0722m, C1505m c1505m) {
        super(c0713d, c1039j, abstractC0721l, null, abstractC0722m, null);
        this.f4041k = c1505m;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1183r
    /* JADX INFO: renamed from: a */
    public final void mo3021a(Object obj, Object obj2, Object obj3) throws C0724o {
        m3025f(obj, (String) obj2, (AbstractC0725p) obj3);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1183r
    /* JADX INFO: renamed from: b */
    public final Object mo3022b(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return this.f4046h.deserialize(abstractC0545m, abstractC0718i);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1183r
    /* JADX INFO: renamed from: c */
    public final void mo3023c(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj, String str) throws C0724o {
        m3025f(obj, str, (AbstractC0725p) this.f4046h.deserialize(abstractC0545m, abstractC0718i));
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1183r
    /* JADX INFO: renamed from: e */
    public final AbstractC1183r mo3024e(AbstractC0722m abstractC0722m) {
        return this;
    }

    /* JADX INFO: renamed from: f */
    public final void m3025f(Object obj, String str, AbstractC0725p abstractC0725p) throws C0724o {
        C1514v c1514v;
        C1039j c1039j = (C1039j) this.f4044f;
        Object objMo2772l = c1039j.mo2772l(obj);
        if (objMo2772l == null) {
            C1505m c1505m = this.f4041k;
            c1505m.getClass();
            c1514v = new C1514v(c1505m);
            c1039j.m2798o(obj, c1514v);
        } else {
            if (!(objMo2772l instanceof C1514v)) {
                throw new C0724o(null, AbstractC0032g.m155m("Value \"any-setter\" '", this.f4043e.mo1808f(), "' not `ObjectNode` but ", AbstractC1745j.m3903z(objMo2772l.getClass())));
            }
            c1514v = (C1514v) objMo2772l;
        }
        c1514v.m3559s(str, abstractC0725p);
    }
}
