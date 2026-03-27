package com.fasterxml.jackson.databind.deser.impl;

import p039M0.AbstractC0485d0;
import p039M0.AbstractC0489f0;
import p039M0.C0483c0;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.x */
/* JADX INFO: loaded from: classes.dex */
public final class C1172x extends AbstractC0489f0 {
    private static final long serialVersionUID = 1;

    @Override // p039M0.AbstractC0485d0
    /* JADX INFO: renamed from: b */
    public final AbstractC0485d0 mo1002b(Class cls) {
        return cls == this.f1131e ? this : new C1172x(cls);
    }

    @Override // p039M0.AbstractC0485d0
    /* JADX INFO: renamed from: c */
    public final Object mo1003c(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // p039M0.AbstractC0485d0
    /* JADX INFO: renamed from: d */
    public final C0483c0 mo1004d(Object obj) {
        if (obj == null) {
            return null;
        }
        return new C0483c0(C1172x.class, this.f1131e, obj);
    }

    @Override // p039M0.AbstractC0485d0
    /* JADX INFO: renamed from: e */
    public final AbstractC0485d0 mo1005e() {
        return this;
    }
}
