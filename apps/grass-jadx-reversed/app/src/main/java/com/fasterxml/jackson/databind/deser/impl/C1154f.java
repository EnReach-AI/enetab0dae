package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import java.lang.reflect.Field;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.C0703E;
import p069X0.C0717h;
import p069X0.C0724o;
import p069X0.EnumC0731v;
import p082b1.AbstractC1007C;
import p082b1.AbstractC1041l;
import p082b1.C1039j;
import p100g1.AbstractC1398g;
import p118m1.AbstractC1745j;
import p118m1.InterfaceC1737b;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.f */
/* JADX INFO: loaded from: classes.dex */
public final class C1154f extends AbstractC1204t {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: q */
    public final C1039j f4000q;

    /* JADX INFO: renamed from: r */
    public final transient Field f4001r;

    /* JADX INFO: renamed from: s */
    public final boolean f4002s;

    public C1154f(AbstractC1007C abstractC1007C, AbstractC0721l abstractC0721l, AbstractC1398g abstractC1398g, InterfaceC1737b interfaceC1737b, C1039j c1039j) {
        super(abstractC1007C, abstractC0721l, abstractC1398g, interfaceC1737b);
        this.f4000q = c1039j;
        this.f4001r = c1039j.f3694g;
        this.f4002s = C1165q.m3010a(this.f4106k);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: B */
    public final void mo2961B(Object obj, Object obj2) throws C0724o {
        try {
            this.f4001r.set(obj, obj2);
        } catch (Exception e3) {
            m3078h(null, e3, obj2);
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: C */
    public final Object mo2962C(Object obj, Object obj2) throws C0724o {
        try {
            this.f4001r.set(obj, obj2);
            return obj;
        } catch (Exception e3) {
            m3078h(null, e3, obj2);
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: F */
    public final AbstractC1204t mo2963F(C0703E c0703e) {
        return new C1154f(this, c0703e);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: G */
    public final AbstractC1204t mo2964G(InterfaceC1178m interfaceC1178m) {
        return new C1154f(this, this.f4104i, interfaceC1178m);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: H */
    public final AbstractC1204t mo2965H(AbstractC0722m abstractC0722m) {
        AbstractC0722m abstractC0722m2 = this.f4104i;
        if (abstractC0722m2 == abstractC0722m) {
            return this;
        }
        InterfaceC1178m interfaceC1178m = this.f4106k;
        if (abstractC0722m2 == interfaceC1178m) {
            interfaceC1178m = abstractC0722m;
        }
        return new C1154f(this, abstractC0722m, interfaceC1178m);
    }

    @Override // p069X0.InterfaceC0714e
    /* JADX INFO: renamed from: c */
    public final AbstractC1041l mo1805c() {
        return this.f4000q;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: k */
    public final void mo2967k(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) throws C0724o {
        Object objDeserializeWithType;
        boolean zMo1168M = abstractC0545m.mo1168M(EnumC0548p.VALUE_NULL);
        InterfaceC1178m interfaceC1178m = this.f4106k;
        boolean z3 = this.f4002s;
        if (!zMo1168M) {
            AbstractC0722m abstractC0722m = this.f4104i;
            AbstractC1398g abstractC1398g = this.f4105j;
            if (abstractC1398g == null) {
                Object objDeserialize = abstractC0722m.deserialize(abstractC0545m, abstractC0718i);
                if (objDeserialize != null) {
                    objDeserializeWithType = objDeserialize;
                } else if (z3) {
                    return;
                } else {
                    objDeserializeWithType = interfaceC1178m.getNullValue(abstractC0718i);
                }
            } else {
                objDeserializeWithType = abstractC0722m.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
            }
        } else if (z3) {
            return;
        } else {
            objDeserializeWithType = interfaceC1178m.getNullValue(abstractC0718i);
        }
        try {
            this.f4001r.set(obj, objDeserializeWithType);
        } catch (Exception e3) {
            m3078h(abstractC0545m, e3, objDeserializeWithType);
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: l */
    public final Object mo2968l(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) throws C0724o {
        Object objDeserializeWithType;
        boolean zMo1168M = abstractC0545m.mo1168M(EnumC0548p.VALUE_NULL);
        InterfaceC1178m interfaceC1178m = this.f4106k;
        boolean z3 = this.f4002s;
        if (!zMo1168M) {
            AbstractC0722m abstractC0722m = this.f4104i;
            AbstractC1398g abstractC1398g = this.f4105j;
            if (abstractC1398g == null) {
                Object objDeserialize = abstractC0722m.deserialize(abstractC0545m, abstractC0718i);
                if (objDeserialize != null) {
                    objDeserializeWithType = objDeserialize;
                } else {
                    if (z3) {
                        return obj;
                    }
                    objDeserializeWithType = interfaceC1178m.getNullValue(abstractC0718i);
                }
            } else {
                objDeserializeWithType = abstractC0722m.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
            }
        } else {
            if (z3) {
                return obj;
            }
            objDeserializeWithType = interfaceC1178m.getNullValue(abstractC0718i);
        }
        try {
            this.f4001r.set(obj, objDeserializeWithType);
            return obj;
        } catch (Exception e3) {
            m3078h(abstractC0545m, e3, objDeserializeWithType);
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: n */
    public final void mo2969n(C0717h c0717h) {
        AbstractC1745j.m3882e(this.f4001r, c0717h.m2157l(EnumC0731v.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public Object readResolve() {
        return new C1154f(this);
    }

    public C1154f(C1154f c1154f, AbstractC0722m abstractC0722m, InterfaceC1178m interfaceC1178m) {
        super(c1154f, abstractC0722m, interfaceC1178m);
        this.f4000q = c1154f.f4000q;
        this.f4001r = c1154f.f4001r;
        this.f4002s = C1165q.m3010a(interfaceC1178m);
    }

    public C1154f(C1154f c1154f, C0703E c0703e) {
        super(c1154f, c0703e);
        this.f4000q = c1154f.f4000q;
        this.f4001r = c1154f.f4001r;
        this.f4002s = c1154f.f4002s;
    }

    public C1154f(C1154f c1154f) {
        super(c1154f);
        C1039j c1039j = c1154f.f4000q;
        this.f4000q = c1039j;
        Field field = c1039j.f3694g;
        if (field != null) {
            this.f4001r = field;
            this.f4002s = c1154f.f4002s;
            return;
        }
        throw new IllegalArgumentException("Missing field (broken JDK (de)serialization?)");
    }
}
