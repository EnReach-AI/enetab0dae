package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.deser.impl.C1165q;
import com.fasterxml.jackson.databind.deser.impl.FailingDeserializer;
import p005B.AbstractC0032g;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p066W0.C0682i;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.C0702D;
import p069X0.C0703E;
import p069X0.C0717h;
import p069X0.C0724o;
import p078a1.C0850b;
import p082b1.AbstractC1007C;
import p082b1.AbstractC1010F;
import p082b1.C1018N;
import p100g1.AbstractC1398g;
import p118m1.AbstractC1745j;
import p118m1.C1733H;
import p118m1.C1734I;
import p118m1.C1735J;
import p118m1.InterfaceC1737b;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.t */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1204t extends AbstractC1010F {

    /* JADX INFO: renamed from: p */
    public static final FailingDeserializer f4101p = new FailingDeserializer("No _valueDeserializer assigned");

    /* JADX INFO: renamed from: g */
    public final C0703E f4102g;

    /* JADX INFO: renamed from: h */
    public final AbstractC0721l f4103h;

    /* JADX INFO: renamed from: i */
    public final AbstractC0722m f4104i;

    /* JADX INFO: renamed from: j */
    public final AbstractC1398g f4105j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC1178m f4106k;

    /* JADX INFO: renamed from: l */
    public String f4107l;

    /* JADX INFO: renamed from: m */
    public C1018N f4108m;

    /* JADX INFO: renamed from: n */
    public C1735J f4109n;

    /* JADX INFO: renamed from: o */
    public int f4110o;

    /* JADX WARN: Illegal instructions before constructor call */
    public AbstractC1204t(AbstractC1007C abstractC1007C, AbstractC0721l abstractC0721l, AbstractC1398g abstractC1398g, InterfaceC1737b interfaceC1737b) {
        C0703E c0703eMo2706a = abstractC1007C.mo2706a();
        abstractC1007C.mo2722u();
        this(c0703eMo2706a, abstractC0721l, null, abstractC1398g, interfaceC1737b, abstractC1007C.mo2707b());
    }

    /* JADX INFO: renamed from: A */
    public void mo2960A() {
    }

    /* JADX INFO: renamed from: B */
    public abstract void mo2961B(Object obj, Object obj2);

    /* JADX INFO: renamed from: C */
    public abstract Object mo2962C(Object obj, Object obj2);

    /* JADX INFO: renamed from: D */
    public final void m3077D(Class[] clsArr) {
        if (clsArr == null) {
            this.f4109n = null;
            return;
        }
        C1735J c1733h = C1735J.f6080e;
        int length = clsArr.length;
        if (length != 0) {
            c1733h = length != 1 ? new C1733H(clsArr) : new C1734I(clsArr[0]);
        }
        this.f4109n = c1733h;
    }

    /* JADX INFO: renamed from: E */
    public boolean mo3027E(Class cls) {
        C1735J c1735j = this.f4109n;
        return c1735j == null || c1735j.mo3863a(cls);
    }

    /* JADX INFO: renamed from: F */
    public abstract AbstractC1204t mo2963F(C0703E c0703e);

    /* JADX INFO: renamed from: G */
    public abstract AbstractC1204t mo2964G(InterfaceC1178m interfaceC1178m);

    /* JADX INFO: renamed from: H */
    public abstract AbstractC1204t mo2965H(AbstractC0722m abstractC0722m);

    @Override // p069X0.InterfaceC0714e
    /* JADX INFO: renamed from: a */
    public final C0703E mo1803a() {
        return this.f4102g;
    }

    @Override // p118m1.InterfaceC1758w
    /* JADX INFO: renamed from: f */
    public final String mo1808f() {
        return this.f4102g.f1928e;
    }

    @Override // p069X0.InterfaceC0714e
    public final AbstractC0721l getType() {
        return this.f4103h;
    }

    /* JADX INFO: renamed from: h */
    public final void m3078h(AbstractC0545m abstractC0545m, Exception exc, Object obj) throws C0724o {
        if (!(exc instanceof IllegalArgumentException)) {
            AbstractC1745j.m3874D(exc);
            AbstractC1745j.m3875E(exc);
            Throwable thM3894q = AbstractC1745j.m3894q(exc);
            throw new C0724o(abstractC0545m, AbstractC1745j.m3886i(thM3894q), thM3894q);
        }
        String strM3883f = AbstractC1745j.m3883f(obj);
        StringBuilder sb = new StringBuilder("Problem deserializing property '");
        sb.append(this.f4102g.f1928e);
        sb.append("' (expected type: ");
        sb.append(this.f4103h);
        sb.append("; actual type: ");
        sb.append(strM3883f);
        sb.append(")");
        String strM3886i = AbstractC1745j.m3886i(exc);
        if (strM3886i != null) {
            sb.append(", problem: ");
            sb.append(strM3886i);
        } else {
            sb.append(" (no error message provided)");
        }
        throw new C0724o(abstractC0545m, sb.toString(), exc);
    }

    /* JADX INFO: renamed from: i */
    public void mo3028i(int i3) {
        if (this.f4110o == -1) {
            this.f4110o = i3;
            return;
        }
        throw new IllegalStateException("Property '" + this.f4102g.f1928e + "' already had index (" + this.f4110o + "), trying to assign " + i3);
    }

    /* JADX INFO: renamed from: j */
    public final Object m3079j(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        boolean zMo1168M = abstractC0545m.mo1168M(EnumC0548p.VALUE_NULL);
        InterfaceC1178m interfaceC1178m = this.f4106k;
        if (zMo1168M) {
            return interfaceC1178m.getNullValue(abstractC0718i);
        }
        AbstractC0722m abstractC0722m = this.f4104i;
        AbstractC1398g abstractC1398g = this.f4105j;
        if (abstractC1398g != null) {
            return abstractC0722m.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
        }
        Object objDeserialize = abstractC0722m.deserialize(abstractC0545m, abstractC0718i);
        return objDeserialize == null ? interfaceC1178m.getNullValue(abstractC0718i) : objDeserialize;
    }

    /* JADX INFO: renamed from: k */
    public abstract void mo2967k(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj);

    /* JADX INFO: renamed from: l */
    public abstract Object mo2968l(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj);

    /* JADX INFO: renamed from: m */
    public final Object m3080m(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) throws C0850b {
        boolean zMo1168M = abstractC0545m.mo1168M(EnumC0548p.VALUE_NULL);
        InterfaceC1178m interfaceC1178m = this.f4106k;
        if (zMo1168M) {
            return C1165q.m3010a(interfaceC1178m) ? obj : interfaceC1178m.getNullValue(abstractC0718i);
        }
        if (this.f4105j != null) {
            return abstractC0718i.m1852q(abstractC0718i.mo1711f().m3780j(obj.getClass()), this).deserialize(abstractC0545m, abstractC0718i, obj);
        }
        Object objDeserialize = this.f4104i.deserialize(abstractC0545m, abstractC0718i, obj);
        return objDeserialize == null ? C1165q.m3010a(interfaceC1178m) ? obj : interfaceC1178m.getNullValue(abstractC0718i) : objDeserialize;
    }

    /* JADX INFO: renamed from: n */
    public void mo2969n(C0717h c0717h) {
    }

    /* JADX INFO: renamed from: o */
    public int mo2970o() {
        throw new IllegalStateException(AbstractC0032g.m156n("Internal error: no creator index for property '", this.f4102g.f1928e, "' (of type ", getClass().getName(), ")"));
    }

    /* JADX INFO: renamed from: p */
    public Object mo2971p() {
        return null;
    }

    /* JADX INFO: renamed from: q */
    public String mo3029q() {
        return this.f4107l;
    }

    /* JADX INFO: renamed from: r */
    public C1018N mo3030r() {
        return this.f4108m;
    }

    /* JADX INFO: renamed from: s */
    public int mo3031s() {
        return this.f4110o;
    }

    /* JADX INFO: renamed from: t */
    public AbstractC0722m mo3032t() {
        FailingDeserializer failingDeserializer = f4101p;
        AbstractC0722m abstractC0722m = this.f4104i;
        if (abstractC0722m == failingDeserializer) {
            return null;
        }
        return abstractC0722m;
    }

    public String toString() {
        return AbstractC0032g.m157o(new StringBuilder("[property '"), this.f4102g.f1928e, "']");
    }

    /* JADX INFO: renamed from: u */
    public AbstractC1398g mo3033u() {
        return this.f4105j;
    }

    /* JADX INFO: renamed from: v */
    public boolean mo3034v() {
        AbstractC0722m abstractC0722m = this.f4104i;
        return (abstractC0722m == null || abstractC0722m == f4101p) ? false : true;
    }

    /* JADX INFO: renamed from: w */
    public boolean mo3035w() {
        return this.f4105j != null;
    }

    /* JADX INFO: renamed from: x */
    public boolean mo3036x() {
        return this.f4109n != null;
    }

    /* JADX INFO: renamed from: y */
    public boolean mo2972y() {
        return false;
    }

    /* JADX INFO: renamed from: z */
    public boolean mo2973z() {
        return false;
    }

    public AbstractC1204t(C0703E c0703e, AbstractC0721l abstractC0721l, C0703E c0703e2, AbstractC1398g abstractC1398g, InterfaceC1737b interfaceC1737b, C0702D c0702d) {
        String strM1642a;
        super(c0702d);
        this.f4110o = -1;
        if (c0703e == null) {
            this.f4102g = C0703E.f1927i;
        } else {
            String str = c0703e.f1928e;
            if (!str.isEmpty() && (strM1642a = C0682i.f1857f.m1642a(str)) != str) {
                c0703e = new C0703E(strM1642a, c0703e.f1929f);
            }
            this.f4102g = c0703e;
        }
        this.f4103h = abstractC0721l;
        this.f4109n = null;
        this.f4105j = abstractC1398g != null ? abstractC1398g.mo3404f(this) : abstractC1398g;
        FailingDeserializer failingDeserializer = f4101p;
        this.f4104i = failingDeserializer;
        this.f4106k = failingDeserializer;
    }

    public AbstractC1204t(C0703E c0703e, AbstractC0721l abstractC0721l, C0702D c0702d, AbstractC0722m abstractC0722m) {
        String strM1642a;
        super(c0702d);
        this.f4110o = -1;
        if (c0703e == null) {
            this.f4102g = C0703E.f1927i;
        } else {
            String str = c0703e.f1928e;
            if (!str.isEmpty() && (strM1642a = C0682i.f1857f.m1642a(str)) != str) {
                c0703e = new C0703E(strM1642a, c0703e.f1929f);
            }
            this.f4102g = c0703e;
        }
        this.f4103h = abstractC0721l;
        this.f4109n = null;
        this.f4105j = null;
        this.f4104i = abstractC0722m;
        this.f4106k = abstractC0722m;
    }

    public AbstractC1204t(AbstractC1204t abstractC1204t) {
        super(abstractC1204t);
        this.f4110o = -1;
        this.f4102g = abstractC1204t.f4102g;
        this.f4103h = abstractC1204t.f4103h;
        this.f4104i = abstractC1204t.f4104i;
        this.f4105j = abstractC1204t.f4105j;
        this.f4107l = abstractC1204t.f4107l;
        this.f4110o = abstractC1204t.f4110o;
        this.f4109n = abstractC1204t.f4109n;
        this.f4108m = abstractC1204t.f4108m;
        this.f4106k = abstractC1204t.f4106k;
    }

    public AbstractC1204t(AbstractC1204t abstractC1204t, AbstractC0722m abstractC0722m, InterfaceC1178m interfaceC1178m) {
        super(abstractC1204t);
        this.f4110o = -1;
        this.f4102g = abstractC1204t.f4102g;
        this.f4103h = abstractC1204t.f4103h;
        this.f4105j = abstractC1204t.f4105j;
        this.f4107l = abstractC1204t.f4107l;
        this.f4110o = abstractC1204t.f4110o;
        FailingDeserializer failingDeserializer = f4101p;
        if (abstractC0722m == null) {
            this.f4104i = failingDeserializer;
        } else {
            this.f4104i = abstractC0722m;
        }
        this.f4109n = abstractC1204t.f4109n;
        this.f4108m = abstractC1204t.f4108m;
        this.f4106k = interfaceC1178m == failingDeserializer ? this.f4104i : interfaceC1178m;
    }

    public AbstractC1204t(AbstractC1204t abstractC1204t, C0703E c0703e) {
        super(abstractC1204t);
        this.f4110o = -1;
        this.f4102g = c0703e;
        this.f4103h = abstractC1204t.f4103h;
        this.f4104i = abstractC1204t.f4104i;
        this.f4105j = abstractC1204t.f4105j;
        this.f4107l = abstractC1204t.f4107l;
        this.f4110o = abstractC1204t.f4110o;
        this.f4109n = abstractC1204t.f4109n;
        this.f4108m = abstractC1204t.f4108m;
        this.f4106k = abstractC1204t.f4106k;
    }
}
