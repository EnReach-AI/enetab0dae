package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.util.internal.C1242k;
import java.util.Map;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0728s;
import p118m1.C1732G;
import p118m1.C1752q;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.ser.impl.m */
/* JADX INFO: loaded from: classes.dex */
public final class C1225m {

    /* JADX INFO: renamed from: a */
    public final C1224l[] f4152a;

    /* JADX INFO: renamed from: b */
    public final int f4153b;

    public C1225m(C1752q c1752q) {
        int size = c1752q.f6129g.f4194e.size();
        int i3 = 8;
        while (i3 < (size <= 64 ? size + size : size + (size >> 2))) {
            i3 += i3;
        }
        this.f4153b = i3 - 1;
        C1224l[] c1224lArr = new C1224l[i3];
        for (Map.Entry entry : (C1242k) c1752q.f6129g.entrySet()) {
            C1732G c1732g = (C1732G) entry.getKey();
            AbstractC0728s abstractC0728s = (AbstractC0728s) entry.getValue();
            int i4 = c1732g.f6074a & this.f4153b;
            c1224lArr[i4] = new C1224l(c1224lArr[i4], c1732g, abstractC0728s);
        }
        this.f4152a = c1224lArr;
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC0728s m3094a(AbstractC0721l abstractC0721l) {
        C1224l c1224l = this.f4152a[(abstractC0721l.hashCode() - 1) & this.f4153b];
        if (c1224l == null) {
            return null;
        }
        if (!c1224l.f4151e && abstractC0721l.equals(c1224l.f4150d)) {
            return c1224l.f4147a;
        }
        while (true) {
            c1224l = c1224l.f4148b;
            if (c1224l == null) {
                return null;
            }
            if (!c1224l.f4151e && abstractC0721l.equals(c1224l.f4150d)) {
                return c1224l.f4147a;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final AbstractC0728s m3095b(Class cls) {
        C1224l c1224l = this.f4152a[cls.getName().hashCode() & this.f4153b];
        if (c1224l == null) {
            return null;
        }
        if (c1224l.f4149c == cls && !c1224l.f4151e) {
            return c1224l.f4147a;
        }
        while (true) {
            c1224l = c1224l.f4148b;
            if (c1224l == null) {
                return null;
            }
            if (c1224l.f4149c == cls && !c1224l.f4151e) {
                return c1224l.f4147a;
            }
        }
    }
}
