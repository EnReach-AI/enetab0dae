package com.fasterxml.jackson.databind.deser;

import p042N0.C0541i;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.v */
/* JADX INFO: loaded from: classes.dex */
public final class C1206v {

    /* JADX INFO: renamed from: a */
    public final Object f4112a;

    /* JADX INFO: renamed from: b */
    public final C0541i f4113b;

    /* JADX INFO: renamed from: c */
    public final Class f4114c;

    public C1206v(Object obj, Class cls, C0541i c0541i) {
        this.f4112a = obj;
        this.f4114c = cls;
        this.f4113b = c0541i;
    }

    public final String toString() {
        return String.format("Object id [%s] (for %s) at %s", this.f4112a, AbstractC1745j.m3903z(this.f4114c), this.f4113b);
    }
}
