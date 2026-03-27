package p116m;

import java.util.Iterator;

/* JADX INFO: renamed from: m.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1703d implements Iterator, InterfaceC1704e {

    /* JADX INFO: renamed from: e */
    public C1702c f5965e;

    /* JADX INFO: renamed from: f */
    public boolean f5966f = true;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ C1705f f5967g;

    public C1703d(C1705f c1705f) {
        this.f5967g = c1705f;
    }

    @Override // p116m.InterfaceC1704e
    /* JADX INFO: renamed from: a */
    public final void mo3786a(C1702c c1702c) {
        C1702c c1702c2 = this.f5965e;
        if (c1702c == c1702c2) {
            C1702c c1702c3 = c1702c2.f5964h;
            this.f5965e = c1702c3;
            this.f5966f = c1702c3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f5966f) {
            return this.f5967g.f5968e != null;
        }
        C1702c c1702c = this.f5965e;
        return (c1702c == null || c1702c.f5963g == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f5966f) {
            this.f5966f = false;
            this.f5965e = this.f5967g.f5968e;
        } else {
            C1702c c1702c = this.f5965e;
            this.f5965e = c1702c != null ? c1702c.f5963g : null;
        }
        return this.f5965e;
    }
}
