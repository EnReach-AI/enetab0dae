package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.deser.std.C1189e;
import java.math.BigDecimal;
import java.math.BigInteger;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.C0717h;
import p078a1.C0850b;
import p082b1.AbstractC1048s;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.x */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1208x {
    /* JADX INFO: renamed from: A */
    public AbstractC1048s mo3046A() {
        return null;
    }

    /* JADX INFO: renamed from: B */
    public AbstractC1048s mo3047B() {
        return null;
    }

    /* JADX INFO: renamed from: C */
    public AbstractC0721l mo3048C() {
        return null;
    }

    /* JADX INFO: renamed from: D */
    public AbstractC1204t[] mo3039D(C0717h c0717h) {
        return null;
    }

    /* JADX INFO: renamed from: E */
    public abstract Class mo3049E();

    /* JADX INFO: renamed from: a */
    public boolean mo3052a() {
        return false;
    }

    /* JADX INFO: renamed from: b */
    public boolean mo3053b() {
        return false;
    }

    /* JADX INFO: renamed from: c */
    public boolean mo3054c() {
        return false;
    }

    /* JADX INFO: renamed from: d */
    public boolean mo3055d() {
        return false;
    }

    /* JADX INFO: renamed from: e */
    public boolean mo3056e() {
        return false;
    }

    /* JADX INFO: renamed from: f */
    public boolean mo3057f() {
        return false;
    }

    /* JADX INFO: renamed from: g */
    public boolean mo3058g() {
        return this instanceof C1189e;
    }

    /* JADX INFO: renamed from: h */
    public boolean mo3059h() {
        return false;
    }

    /* JADX INFO: renamed from: i */
    public boolean mo3060i() {
        return false;
    }

    /* JADX INFO: renamed from: j */
    public boolean mo3005j() {
        return mo3046A() != null;
    }

    /* JADX INFO: renamed from: k */
    public boolean mo3061k() {
        return false;
    }

    /* JADX INFO: renamed from: l */
    public boolean mo3006l() {
        return mo3005j() || mo3061k() || mo3060i() || mo3058g() || mo3059h() || mo3056e() || mo3057f() || mo3055d() || mo3054c();
    }

    /* JADX INFO: renamed from: m */
    public Object mo3062m(AbstractC0718i abstractC0718i, BigDecimal bigDecimal) throws C0850b {
        abstractC0718i.m1860y(mo3049E(), this, "no BigDecimal/double/Double-argument constructor/factory method to deserialize from Number value (%s)", bigDecimal);
        throw null;
    }

    /* JADX INFO: renamed from: n */
    public Object mo3063n(AbstractC0718i abstractC0718i, BigInteger bigInteger) throws C0850b {
        abstractC0718i.m1860y(mo3049E(), this, "no BigInteger-argument constructor/factory method to deserialize from Number value (%s)", bigInteger);
        throw null;
    }

    /* JADX INFO: renamed from: o */
    public Object mo3064o(AbstractC0718i abstractC0718i, boolean z3) throws C0850b {
        abstractC0718i.m1860y(mo3049E(), this, "no boolean/Boolean-argument constructor/factory method to deserialize from boolean value (%s)", Boolean.valueOf(z3));
        throw null;
    }

    /* JADX INFO: renamed from: p */
    public Object mo3065p(AbstractC0718i abstractC0718i, double d) throws C0850b {
        abstractC0718i.m1860y(mo3049E(), this, "no double/Double-argument constructor/factory method to deserialize from Number value (%s)", Double.valueOf(d));
        throw null;
    }

    /* JADX INFO: renamed from: q */
    public Object mo3066q(AbstractC0718i abstractC0718i, int i3) throws C0850b {
        abstractC0718i.m1860y(mo3049E(), this, "no int/Int-argument constructor/factory method to deserialize from Number value (%s)", Integer.valueOf(i3));
        throw null;
    }

    /* JADX INFO: renamed from: r */
    public Object mo3067r(AbstractC0718i abstractC0718i, long j2) throws C0850b {
        abstractC0718i.m1860y(mo3049E(), this, "no long/Long-argument constructor/factory method to deserialize from Number value (%s)", Long.valueOf(j2));
        throw null;
    }

    /* JADX INFO: renamed from: s */
    public Object mo3040s(AbstractC0718i abstractC0718i, Object[] objArr) throws C0850b {
        abstractC0718i.m1860y(mo3049E(), this, "no creator with arguments specified", new Object[0]);
        throw null;
    }

    /* JADX INFO: renamed from: t */
    public Object mo3068t(AbstractC0718i abstractC0718i, String str) throws C0850b {
        Class clsMo3049E = mo3049E();
        AbstractC0545m abstractC0545m = abstractC0718i.f2002k;
        abstractC0718i.m1860y(clsMo3049E, this, "no String-argument constructor/factory method to deserialize from String value ('%s')", str);
        throw null;
    }

    /* JADX INFO: renamed from: u */
    public Object mo3069u(AbstractC0718i abstractC0718i, Object obj) throws C0850b {
        abstractC0718i.m1860y(mo3049E(), this, "no array delegate creator specified", new Object[0]);
        throw null;
    }

    /* JADX INFO: renamed from: v */
    public Object mo3007v(AbstractC0718i abstractC0718i) throws C0850b {
        abstractC0718i.m1860y(mo3049E(), this, "no default no-arguments constructor found", new Object[0]);
        throw null;
    }

    /* JADX INFO: renamed from: w */
    public Object mo3070w(AbstractC0718i abstractC0718i) throws C0850b {
        abstractC0718i.m1860y(mo3049E(), this, "neither default (no-arguments) nor with-arguments Creator found", new Object[0]);
        throw null;
    }

    /* JADX INFO: renamed from: x */
    public Object mo3071x(AbstractC0718i abstractC0718i, Object obj) throws C0850b {
        abstractC0718i.m1860y(mo3049E(), this, "no delegate creator specified", new Object[0]);
        throw null;
    }

    /* JADX INFO: renamed from: y */
    public AbstractC1048s mo3072y() {
        return null;
    }

    /* JADX INFO: renamed from: z */
    public AbstractC0721l mo3073z() {
        return null;
    }
}
