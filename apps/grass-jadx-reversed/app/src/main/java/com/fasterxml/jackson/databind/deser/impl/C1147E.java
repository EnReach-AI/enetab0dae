package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import java.util.ArrayList;
import java.util.List;
import p042N0.AbstractC0545m;
import p042N0.C0553u;
import p069X0.AbstractC0718i;
import p118m1.C1728C;
import p118m1.C1730E;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.E */
/* JADX INFO: loaded from: classes.dex */
public final class C1147E {

    /* JADX INFO: renamed from: a */
    public final List f3966a;

    public C1147E() {
        this.f3966a = new ArrayList();
    }

    /* JADX INFO: renamed from: a */
    public final void m2980a(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj, C1730E c1730e) {
        List list = this.f3966a;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            AbstractC1204t abstractC1204t = (AbstractC1204t) list.get(i3);
            C0553u c0553uMo1189d0 = abstractC0545m.mo1189d0();
            c1730e.getClass();
            C1728C c1728c = new C1728C(c1730e.f6063m, c1730e.f6056f, c1730e.f6060j, c1730e.f6061k, c1730e.f6057g, c0553uMo1189d0);
            c1728c.mo1177V();
            abstractC1204t.mo2967k(c1728c, abstractC0718i, obj);
        }
    }

    public C1147E(ArrayList arrayList) {
        this.f3966a = arrayList;
    }
}
