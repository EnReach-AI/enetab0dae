package com.fasterxml.jackson.databind.deser.std;

import java.io.Serializable;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;
import p069X0.AbstractC0730u;
import p078a1.C0851c;
import p118m1.C1728C;
import p118m1.C1730E;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.std.j */
/* JADX INFO: loaded from: classes.dex */
public final class C1194j extends AbstractC0730u implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final Class f4062e;

    /* JADX INFO: renamed from: f */
    public final AbstractC0722m f4063f;

    public C1194j(Class cls, AbstractC0722m abstractC0722m) {
        this.f4062e = cls;
        this.f4063f = abstractC0722m;
    }

    @Override // p069X0.AbstractC0730u
    /* JADX INFO: renamed from: a */
    public final Object mo1910a(AbstractC0718i abstractC0718i, String str) throws C0851c {
        Class cls = this.f4062e;
        if (str == null) {
            return null;
        }
        C1730E c1730eM1847l = abstractC0718i.m1847l(abstractC0718i.f2002k);
        c1730eM1847l.mo1125R(str);
        try {
            C1728C c1728cM3861f0 = c1730eM1847l.m3861f0(c1730eM1847l.f6056f);
            c1728cM3861f0.mo1177V();
            Object objDeserialize = this.f4063f.deserialize(c1728cM3861f0, abstractC0718i);
            if (objDeserialize != null) {
                return objDeserialize;
            }
            abstractC0718i.m1827E(cls, str, "not a valid representation", new Object[0]);
            throw null;
        } catch (Exception e3) {
            abstractC0718i.m1827E(cls, str, "not a valid representation: %s", e3.getMessage());
            throw null;
        }
    }
}
