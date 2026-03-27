package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.AbstractC1184s;
import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import java.lang.reflect.Constructor;
import p005B.AbstractC0032g;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;
import p078a1.C0850b;
import p082b1.C1036g;
import p100g1.AbstractC1398g;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1155g extends AbstractC1184s {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: r */
    public final transient Constructor f4003r;

    /* JADX INFO: renamed from: s */
    public final C1036g f4004s;

    public C1155g(AbstractC1204t abstractC1204t, Constructor constructor) {
        super(abstractC1204t);
        this.f4003r = constructor;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1184s
    /* JADX INFO: renamed from: I */
    public final AbstractC1204t mo3004I(AbstractC1204t abstractC1204t) {
        return abstractC1204t == this.f4049q ? this : new C1155g(abstractC1204t, this.f4003r);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: k */
    public final void mo2967k(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) throws C0850b {
        Object objDeserializeWithType;
        Constructor constructor = this.f4003r;
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        EnumC0548p enumC0548p = EnumC0548p.VALUE_NULL;
        AbstractC0722m abstractC0722m = this.f4104i;
        if (enumC0548pMo1190e == enumC0548p) {
            objDeserializeWithType = abstractC0722m.getNullValue(abstractC0718i);
        } else {
            AbstractC1398g abstractC1398g = this.f4105j;
            if (abstractC1398g != null) {
                objDeserializeWithType = abstractC0722m.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
            } else {
                try {
                    Object objNewInstance = constructor.newInstance(obj);
                    abstractC0722m.deserialize(abstractC0545m, abstractC0718i, objNewInstance);
                    objDeserializeWithType = objNewInstance;
                } catch (Exception e3) {
                    String strM155m = AbstractC0032g.m155m("Failed to instantiate class ", constructor.getDeclaringClass().getName(), ", problem: ", e3.getMessage());
                    Throwable thM3894q = AbstractC1745j.m3894q(e3);
                    AbstractC1745j.m3875E(thM3894q);
                    AbstractC1745j.m3873C(thM3894q);
                    throw new IllegalArgumentException(strM155m, thM3894q);
                }
            }
        }
        mo2961B(obj, objDeserializeWithType);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: l */
    public final Object mo2968l(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) {
        return this.f4049q.mo2962C(obj, m3079j(abstractC0545m, abstractC0718i));
    }

    public Object readResolve() {
        return new C1155g(this, this.f4004s);
    }

    public Object writeReplace() {
        return this.f4004s == null ? new C1155g(this, new C1036g(null, this.f4003r, null, null)) : this;
    }

    public C1155g(AbstractC1204t abstractC1204t, C1036g c1036g) {
        super(abstractC1204t);
        this.f4004s = c1036g;
        Constructor constructor = c1036g == null ? null : c1036g.f3687h;
        this.f4003r = constructor;
        if (constructor == null) {
            throw new IllegalArgumentException("Missing constructor (broken JDK (de)serialization?)");
        }
    }
}
