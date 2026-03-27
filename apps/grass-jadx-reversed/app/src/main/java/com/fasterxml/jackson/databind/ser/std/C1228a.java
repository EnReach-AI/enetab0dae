package com.fasterxml.jackson.databind.ser.std;

import p039M0.EnumC0471T;
import p042N0.AbstractC0540h;
import p064V0.C0672b;
import p069X0.InterfaceC0714e;
import p100g1.AbstractC1399h;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.ser.std.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1228a extends AbstractC1399h {

    /* JADX INFO: renamed from: a */
    public final AbstractC1399h f4158a;

    /* JADX INFO: renamed from: b */
    public final Object f4159b;

    public C1228a(AbstractC1399h abstractC1399h, Object obj) {
        this.f4158a = abstractC1399h;
        this.f4159b = obj;
    }

    @Override // p100g1.AbstractC1399h
    /* JADX INFO: renamed from: a */
    public final AbstractC1399h mo3100a(InterfaceC0714e interfaceC0714e) {
        throw new UnsupportedOperationException();
    }

    @Override // p100g1.AbstractC1399h
    /* JADX INFO: renamed from: b */
    public final String mo3101b() {
        return this.f4158a.mo3101b();
    }

    @Override // p100g1.AbstractC1399h
    /* JADX INFO: renamed from: c */
    public final EnumC0471T mo3102c() {
        return this.f4158a.mo3102c();
    }

    @Override // p100g1.AbstractC1399h
    /* JADX INFO: renamed from: e */
    public final C0672b mo3103e(AbstractC0540h abstractC0540h, C0672b c0672b) {
        c0672b.f1823a = this.f4159b;
        return this.f4158a.mo3103e(abstractC0540h, c0672b);
    }

    @Override // p100g1.AbstractC1399h
    /* JADX INFO: renamed from: f */
    public final C0672b mo3104f(AbstractC0540h abstractC0540h, C0672b c0672b) {
        return this.f4158a.mo3104f(abstractC0540h, c0672b);
    }
}
