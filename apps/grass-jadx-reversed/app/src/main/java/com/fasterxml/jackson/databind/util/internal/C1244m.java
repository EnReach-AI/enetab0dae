package com.fasterxml.jackson.databind.util.internal;

import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.util.internal.m */
/* JADX INFO: loaded from: classes.dex */
public final class C1244m implements Serializable {
    static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final HashMap f4186e;

    /* JADX INFO: renamed from: f */
    public final long f4187f;

    public C1244m(ConcurrentMapC1248q concurrentMapC1248q) {
        int i3 = concurrentMapC1248q.f4195f;
        this.f4186e = new HashMap(concurrentMapC1248q);
        this.f4187f = concurrentMapC1248q.f4199j.get();
    }

    public Object readResolve() {
        C1236e c1236e = new C1236e();
        long j2 = this.f4187f;
        boolean z3 = j2 >= 0;
        int i3 = ConcurrentMapC1248q.f4192t;
        if (!z3) {
            throw new IllegalArgumentException();
        }
        c1236e.f4171c = j2;
        if (!(j2 >= 0)) {
            throw new IllegalStateException();
        }
        ConcurrentMapC1248q concurrentMapC1248q = new ConcurrentMapC1248q(c1236e);
        concurrentMapC1248q.putAll(this.f4186e);
        return concurrentMapC1248q;
    }
}
