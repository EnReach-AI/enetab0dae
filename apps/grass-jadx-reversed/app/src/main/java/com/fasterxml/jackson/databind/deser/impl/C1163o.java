package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import java.lang.reflect.Method;
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
import p082b1.C1043n;
import p100g1.AbstractC1398g;
import p118m1.InterfaceC1737b;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.o */
/* JADX INFO: loaded from: classes.dex */
public final class C1163o extends AbstractC1204t {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: q */
    public final C1043n f4015q;

    /* JADX INFO: renamed from: r */
    public final transient Method f4016r;

    /* JADX INFO: renamed from: s */
    public final boolean f4017s;

    public C1163o(AbstractC1007C abstractC1007C, AbstractC0721l abstractC0721l, AbstractC1398g abstractC1398g, InterfaceC1737b interfaceC1737b, C1043n c1043n) {
        super(abstractC1007C, abstractC0721l, abstractC1398g, interfaceC1737b);
        this.f4015q = c1043n;
        this.f4016r = c1043n.f3704h;
        this.f4017s = C1165q.m3010a(this.f4106k);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: B */
    public final void mo2961B(Object obj, Object obj2) throws C0724o {
        try {
            this.f4016r.invoke(obj, obj2);
        } catch (Exception e3) {
            m3078h(null, e3, obj2);
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: C */
    public final Object mo2962C(Object obj, Object obj2) throws C0724o {
        try {
            Object objInvoke = this.f4016r.invoke(obj, obj2);
            return objInvoke == null ? obj : objInvoke;
        } catch (Exception e3) {
            m3078h(null, e3, obj2);
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: F */
    public final AbstractC1204t mo2963F(C0703E c0703e) {
        return new C1163o(this, c0703e);
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: G */
    public final AbstractC1204t mo2964G(InterfaceC1178m interfaceC1178m) {
        return new C1163o(this, this.f4104i, interfaceC1178m);
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
        return new C1163o(this, abstractC0722m, interfaceC1178m);
    }

    @Override // p069X0.InterfaceC0714e
    /* JADX INFO: renamed from: c */
    public final AbstractC1041l mo1805c() {
        return this.f4015q;
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: k */
    public final void mo2967k(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) throws C0724o {
        Object objDeserializeWithType;
        boolean zMo1168M = abstractC0545m.mo1168M(EnumC0548p.VALUE_NULL);
        InterfaceC1178m interfaceC1178m = this.f4106k;
        boolean z3 = this.f4017s;
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
            this.f4016r.invoke(obj, objDeserializeWithType);
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
        boolean z3 = this.f4017s;
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
            Object objInvoke = this.f4016r.invoke(obj, objDeserializeWithType);
            return objInvoke == null ? obj : objInvoke;
        } catch (Exception e3) {
            m3078h(abstractC0545m, e3, objDeserializeWithType);
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.AbstractC1204t
    /* JADX INFO: renamed from: n */
    public final void mo2969n(C0717h c0717h) {
        this.f4015q.m2799h(c0717h.m2157l(EnumC0731v.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public Object readResolve() {
        return new C1163o(this, this.f4015q.f3704h);
    }

    public C1163o(C1163o c1163o, AbstractC0722m abstractC0722m, InterfaceC1178m interfaceC1178m) {
        super(c1163o, abstractC0722m, interfaceC1178m);
        this.f4015q = c1163o.f4015q;
        this.f4016r = c1163o.f4016r;
        this.f4017s = C1165q.m3010a(interfaceC1178m);
    }

    public C1163o(C1163o c1163o, C0703E c0703e) {
        super(c1163o, c0703e);
        this.f4015q = c1163o.f4015q;
        this.f4016r = c1163o.f4016r;
        this.f4017s = c1163o.f4017s;
    }

    public C1163o(C1163o c1163o, Method method) {
        super(c1163o);
        this.f4015q = c1163o.f4015q;
        this.f4016r = method;
        this.f4017s = c1163o.f4017s;
    }
}
