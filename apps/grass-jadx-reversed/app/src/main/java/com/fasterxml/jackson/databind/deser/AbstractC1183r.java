package com.fasterxml.jackson.databind.deser;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.AbstractC0730u;
import p069X0.C0713d;
import p069X0.C0724o;
import p069X0.InterfaceC0714e;
import p082b1.AbstractC1041l;
import p082b1.C1039j;
import p100g1.AbstractC1398g;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.r */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1183r implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final InterfaceC0714e f4043e;

    /* JADX INFO: renamed from: f */
    public final AbstractC1041l f4044f;

    /* JADX INFO: renamed from: g */
    public final AbstractC0721l f4045g;

    /* JADX INFO: renamed from: h */
    public final AbstractC0722m f4046h;

    /* JADX INFO: renamed from: i */
    public final AbstractC1398g f4047i;

    /* JADX INFO: renamed from: j */
    public final AbstractC0730u f4048j;

    public AbstractC1183r(C0713d c0713d, AbstractC1041l abstractC1041l, AbstractC0721l abstractC0721l, AbstractC0730u abstractC0730u, AbstractC0722m abstractC0722m, AbstractC1398g abstractC1398g) {
        this.f4043e = c0713d;
        this.f4044f = abstractC1041l;
        this.f4045g = abstractC0721l;
        this.f4046h = abstractC0722m;
        this.f4047i = abstractC1398g;
        this.f4048j = abstractC0730u;
        boolean z3 = abstractC1041l instanceof C1039j;
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo3021a(Object obj, Object obj2, Object obj3);

    /* JADX INFO: renamed from: b */
    public Object mo3022b(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        boolean zMo1168M = abstractC0545m.mo1168M(EnumC0548p.VALUE_NULL);
        AbstractC0722m abstractC0722m = this.f4046h;
        if (zMo1168M) {
            return abstractC0722m.getNullValue(abstractC0718i);
        }
        AbstractC1398g abstractC1398g = this.f4047i;
        return abstractC1398g != null ? abstractC0722m.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g) : abstractC0722m.deserialize(abstractC0545m, abstractC0718i);
    }

    /* JADX INFO: renamed from: c */
    public void mo3023c(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj, String str) throws IOException {
        try {
            AbstractC0730u abstractC0730u = this.f4048j;
            m3026d(obj, abstractC0730u == null ? str : abstractC0730u.mo1910a(abstractC0718i, str), mo3022b(abstractC0545m, abstractC0718i));
        } catch (C1205u e3) {
            if (this.f4046h.getObjectIdReader() == null) {
                throw new C0724o(abstractC0545m, "Unresolved forward reference but no identity info.", e3);
            }
            Class cls = this.f4045g.f2036e;
            throw null;
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m3026d(Object obj, Object obj2, Object obj3) throws IOException {
        try {
            mo3021a(obj, obj2, obj3);
        } catch (IOException e3) {
            throw e3;
        } catch (Exception e4) {
            if (!(e4 instanceof IllegalArgumentException)) {
                AbstractC1745j.m3874D(e4);
                AbstractC1745j.m3875E(e4);
                Throwable thM3894q = AbstractC1745j.m3894q(e4);
                throw new C0724o((Closeable) null, AbstractC1745j.m3886i(thM3894q), thM3894q);
            }
            String strM3883f = AbstractC1745j.m3883f(obj3);
            StringBuilder sb = new StringBuilder("Problem deserializing \"any-property\" '");
            sb.append(obj2);
            sb.append("' of class " + AbstractC1745j.m3903z(this.f4044f.mo2770i()) + " (expected type: ");
            sb.append(this.f4045g);
            sb.append("; actual type: ");
            sb.append(strM3883f);
            sb.append(")");
            String strM3886i = AbstractC1745j.m3886i(e4);
            if (strM3886i != null) {
                sb.append(", problem: ");
                sb.append(strM3886i);
            } else {
                sb.append(" (no error message provided)");
            }
            throw new C0724o((Closeable) null, sb.toString(), e4);
        }
    }

    /* JADX INFO: renamed from: e */
    public abstract AbstractC1183r mo3024e(AbstractC0722m abstractC0722m);

    public Object readResolve() {
        AbstractC1041l abstractC1041l = this.f4044f;
        if (abstractC1041l == null || abstractC1041l.mo2766a() == null) {
            throw new IllegalArgumentException("Missing method/field (broken JDK (de)serialization?)");
        }
        return this;
    }

    public final String toString() {
        return "[any property on class " + AbstractC1745j.m3903z(this.f4044f.mo2770i()) + "]";
    }
}
