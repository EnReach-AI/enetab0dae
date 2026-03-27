package com.fasterxml.jackson.databind.ser.impl;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import p039M0.EnumC0511z;
import p042N0.AbstractC0540h;
import p050Q0.C0597j;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.AbstractC0728s;
import p100g1.AbstractC1399h;
import p109j1.C1514v;
import p112k1.C1635c;
import p118m1.AbstractC1757v;
import p118m1.C1755t;
import p118m1.C1756u;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.ser.impl.n */
/* JADX INFO: loaded from: classes.dex */
public final class C1226n extends C1635c {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: w */
    public final AbstractC1757v f4154w;

    public C1226n(C1226n c1226n, C1755t c1755t, C0597j c0597j) {
        super(c1226n, c0597j);
        this.f4154w = c1755t;
    }

    @Override // p112k1.C1635c
    /* JADX INFO: renamed from: h */
    public final void mo3096h(C1514v c1514v, AbstractC0725p abstractC0725p) {
        AbstractC0725p abstractC0725pMo1904l = abstractC0725p.mo1904l("properties");
        if (abstractC0725pMo1904l != null) {
            Iterator itMo1903k = abstractC0725pMo1904l.mo1903k();
            while (itMo1903k.hasNext()) {
                Map.Entry entry = (Map.Entry) itMo1903k.next();
                String strMo3911a = (String) entry.getKey();
                AbstractC1757v abstractC1757v = this.f4154w;
                if (abstractC1757v != null) {
                    strMo3911a = abstractC1757v.mo3911a(strMo3911a);
                }
                c1514v.m3559s(strMo3911a, (AbstractC0725p) entry.getValue());
            }
        }
    }

    @Override // p112k1.C1635c
    /* JADX INFO: renamed from: i */
    public final AbstractC0728s mo3097i(AbstractC1223k abstractC1223k, Class cls, AbstractC0709K abstractC0709K) {
        AbstractC0721l abstractC0721l = this.f5814k;
        AbstractC0728s abstractC0728sM1727y = abstractC0721l != null ? abstractC0709K.m1727y(abstractC0709K.m1718p(abstractC0721l, cls), this) : abstractC0709K.m1728z(cls, this);
        boolean zIsUnwrappingSerializer = abstractC0728sM1727y.isUnwrappingSerializer();
        AbstractC1757v c1755t = this.f4154w;
        if (zIsUnwrappingSerializer && (abstractC0728sM1727y instanceof UnwrappingBeanSerializer)) {
            AbstractC1757v abstractC1757v = ((UnwrappingBeanSerializer) abstractC0728sM1727y)._nameTransformer;
            C1756u c1756u = AbstractC1757v.f6136e;
            c1755t = new C1755t(c1755t, abstractC1757v);
        }
        AbstractC0728s abstractC0728sUnwrappingSerializer = abstractC0728sM1727y.unwrappingSerializer(c1755t);
        this.f5821r = this.f5821r.mo3091b(cls, abstractC0728sUnwrappingSerializer);
        return abstractC0728sUnwrappingSerializer;
    }

    @Override // p112k1.C1635c
    /* JADX INFO: renamed from: l */
    public final void mo3085l(AbstractC0728s abstractC0728s) {
        if (abstractC0728s != null) {
            boolean zIsUnwrappingSerializer = abstractC0728s.isUnwrappingSerializer();
            AbstractC1757v c1755t = this.f4154w;
            if (zIsUnwrappingSerializer && (abstractC0728s instanceof UnwrappingBeanSerializer)) {
                AbstractC1757v abstractC1757v = ((UnwrappingBeanSerializer) abstractC0728s)._nameTransformer;
                C1756u c1756u = AbstractC1757v.f6136e;
                c1755t = new C1755t(c1755t, abstractC1757v);
            }
            abstractC0728s = abstractC0728s.unwrappingSerializer(c1755t);
        }
        super.mo3085l(abstractC0728s);
    }

    @Override // p112k1.C1635c
    /* JADX INFO: renamed from: m */
    public final C1635c mo3086m(AbstractC1757v abstractC1757v) {
        return new C1226n(this, new C1755t(abstractC1757v, this.f4154w), new C0597j(abstractC1757v.mo3911a(this.f5810g.f1531e)));
    }

    @Override // p112k1.C1635c
    /* JADX INFO: renamed from: o */
    public final void mo3088o(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        Method method = this.f5816m;
        Object objInvoke = method == null ? this.f5817n.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
            return;
        }
        AbstractC0728s abstractC0728sMo3097i = this.f5818o;
        if (abstractC0728sMo3097i == null) {
            Class<?> cls = objInvoke.getClass();
            AbstractC1223k abstractC1223k = this.f5821r;
            AbstractC0728s abstractC0728sMo3092c = abstractC1223k.mo3092c(cls);
            abstractC0728sMo3097i = abstractC0728sMo3092c == null ? mo3097i(abstractC1223k, cls, abstractC0709K) : abstractC0728sMo3092c;
        }
        Object obj2 = this.f5823t;
        if (obj2 != null) {
            if (EnumC0511z.f1184g == obj2) {
                if (abstractC0728sMo3097i.isEmpty(abstractC0709K, objInvoke)) {
                    return;
                }
            } else if (obj2.equals(objInvoke)) {
                return;
            }
        }
        if (objInvoke == obj && m3716j(abstractC0540h, abstractC0709K, abstractC0728sMo3097i)) {
            return;
        }
        if (!abstractC0728sMo3097i.isUnwrappingSerializer()) {
            abstractC0540h.mo1144q(this.f5810g);
        }
        AbstractC1399h abstractC1399h = this.f5820q;
        if (abstractC1399h == null) {
            abstractC0728sMo3097i.serialize(objInvoke, abstractC0540h, abstractC0709K);
        } else {
            abstractC0728sMo3097i.serializeWithType(objInvoke, abstractC0540h, abstractC0709K, abstractC1399h);
        }
    }

    public C1226n(C1635c c1635c, AbstractC1757v abstractC1757v) {
        super(c1635c, c1635c.f5810g);
        this.f4154w = abstractC1757v;
    }
}
