package com.fasterxml.jackson.databind.ser.impl;

import java.lang.reflect.Method;
import p039M0.AbstractC0485d0;
import p039M0.AbstractC0489f0;
import p039M0.C0483c0;
import p112k1.C1635c;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.ser.impl.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1217e extends AbstractC0489f0 {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: f */
    public final C1635c f4135f;

    public C1217e(Class cls, C1635c c1635c) {
        super(cls);
        this.f4135f = c1635c;
    }

    @Override // p039M0.AbstractC0489f0, p039M0.AbstractC0485d0
    /* JADX INFO: renamed from: a */
    public final boolean mo1001a(AbstractC0485d0 abstractC0485d0) {
        if (abstractC0485d0.getClass() != C1217e.class) {
            return false;
        }
        C1217e c1217e = (C1217e) abstractC0485d0;
        return c1217e.f1131e == this.f1131e && c1217e.f4135f == this.f4135f;
    }

    @Override // p039M0.AbstractC0485d0
    /* JADX INFO: renamed from: b */
    public final AbstractC0485d0 mo1002b(Class cls) {
        return cls == this.f1131e ? this : new C1217e(cls, this.f4135f);
    }

    @Override // p039M0.AbstractC0485d0
    /* JADX INFO: renamed from: c */
    public final Object mo1003c(Object obj) {
        C1635c c1635c = this.f4135f;
        try {
            Method method = c1635c.f5816m;
            return method == null ? c1635c.f5817n.get(obj) : method.invoke(obj, null);
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new IllegalStateException("Problem accessing property '" + c1635c.f5810g.f1531e + "': " + e4.getMessage(), e4);
        }
    }

    @Override // p039M0.AbstractC0485d0
    /* JADX INFO: renamed from: d */
    public final C0483c0 mo1004d(Object obj) {
        if (obj == null) {
            return null;
        }
        return new C0483c0(C1217e.class, this.f1131e, obj);
    }

    @Override // p039M0.AbstractC0485d0
    /* JADX INFO: renamed from: e */
    public final AbstractC0485d0 mo1005e() {
        return this;
    }
}
