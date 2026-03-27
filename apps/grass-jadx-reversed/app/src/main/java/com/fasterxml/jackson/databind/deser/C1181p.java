package com.fasterxml.jackson.databind.deser;

import java.util.Map;
import p005B.AbstractC0032g;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.AbstractC0730u;
import p069X0.C0713d;
import p069X0.C0724o;
import p082b1.AbstractC1041l;
import p082b1.C1039j;
import p100g1.AbstractC1398g;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.p */
/* JADX INFO: loaded from: classes.dex */
public final class C1181p extends AbstractC1183r {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: k */
    public final AbstractC1208x f4042k;

    public C1181p(C0713d c0713d, AbstractC1041l abstractC1041l, AbstractC0721l abstractC0721l, AbstractC0730u abstractC0730u, AbstractC0722m abstractC0722m, AbstractC1398g abstractC1398g, C1207w c1207w) {
        super(c0713d, abstractC1041l, abstractC0721l, abstractC0730u, abstractC0722m, abstractC1398g);
        this.f4042k = c1207w;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1183r
    /* JADX INFO: renamed from: a */
    public final void mo3021a(Object obj, Object obj2, Object obj3) throws C0724o {
        C1039j c1039j = (C1039j) this.f4044f;
        Map map = (Map) c1039j.mo2772l(obj);
        if (map == null) {
            AbstractC1208x abstractC1208x = this.f4042k;
            if (abstractC1208x == null) {
                throw new C0724o(null, AbstractC0032g.m156n("Cannot create an instance of ", AbstractC1745j.m3903z(this.f4045g.f2036e), " for use as \"any-setter\" '", this.f4043e.mo1808f(), "'"));
            }
            map = (Map) abstractC1208x.mo3007v(null);
            c1039j.m2798o(obj, map);
        }
        map.put(obj2, obj3);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1183r
    /* JADX INFO: renamed from: e */
    public final AbstractC1183r mo3024e(AbstractC0722m abstractC0722m) {
        return new C1181p((C0713d) this.f4043e, this.f4044f, this.f4045g, this.f4048j, abstractC0722m, this.f4047i, (C1207w) this.f4042k);
    }
}
