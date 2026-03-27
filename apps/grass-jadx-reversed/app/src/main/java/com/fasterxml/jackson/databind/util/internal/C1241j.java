package com.fasterxml.jackson.databind.util.internal;

import java.util.Iterator;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.util.internal.j */
/* JADX INFO: loaded from: classes.dex */
public final class C1241j implements Iterator {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f4176e;

    /* JADX INFO: renamed from: f */
    public final Iterator f4177f;

    /* JADX INFO: renamed from: g */
    public Object f4178g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ ConcurrentMapC1248q f4179h;

    public C1241j(ConcurrentMapC1248q concurrentMapC1248q, int i3) {
        this.f4176e = i3;
        switch (i3) {
            case 1:
                this.f4179h = concurrentMapC1248q;
                this.f4177f = concurrentMapC1248q.f4194e.values().iterator();
                break;
            case 2:
                this.f4179h = concurrentMapC1248q;
                this.f4177f = concurrentMapC1248q.f4194e.keySet().iterator();
                break;
            default:
                this.f4179h = concurrentMapC1248q;
                this.f4177f = concurrentMapC1248q.f4194e.values().iterator();
                break;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f4176e) {
        }
        return this.f4177f.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f4176e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                this.f4178g = (C1243l) this.f4177f.next();
                return new C1247p(this.f4179h, (C1243l) this.f4178g);
            case 1:
                C1243l c1243l = (C1243l) this.f4177f.next();
                this.f4178g = c1243l;
                return c1243l.m3113a();
            default:
                Object next = this.f4177f.next();
                this.f4178g = next;
                return next;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        boolean z3;
        ConcurrentMapC1248q concurrentMapC1248q = this.f4179h;
        switch (this.f4176e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C1243l c1243l = (C1243l) this.f4178g;
                z3 = c1243l != null;
                int i3 = ConcurrentMapC1248q.f4192t;
                if (!z3) {
                    throw new IllegalStateException();
                }
                concurrentMapC1248q.remove(c1243l.f4183e);
                this.f4178g = null;
                return;
            case 1:
                C1243l c1243l2 = (C1243l) this.f4178g;
                z3 = c1243l2 != null;
                int i4 = ConcurrentMapC1248q.f4192t;
                if (!z3) {
                    throw new IllegalStateException();
                }
                concurrentMapC1248q.remove(c1243l2.f4183e);
                this.f4178g = null;
                return;
            default:
                Object obj = this.f4178g;
                z3 = obj != null;
                int i5 = ConcurrentMapC1248q.f4192t;
                if (!z3) {
                    throw new IllegalStateException();
                }
                concurrentMapC1248q.remove(obj);
                this.f4178g = null;
                return;
        }
    }
}
