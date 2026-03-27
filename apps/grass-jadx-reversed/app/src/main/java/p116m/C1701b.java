package p116m;

import java.util.Iterator;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: m.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1701b implements Iterator, InterfaceC1704e {

    /* JADX INFO: renamed from: e */
    public C1702c f5958e;

    /* JADX INFO: renamed from: f */
    public C1702c f5959f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ int f5960g;

    public C1701b(C1702c c1702c, C1702c c1702c2, int i3) {
        this.f5960g = i3;
        this.f5958e = c1702c2;
        this.f5959f = c1702c;
    }

    @Override // p116m.InterfaceC1704e
    /* JADX INFO: renamed from: a */
    public final void mo3786a(C1702c c1702c) {
        C1702c c1702cM3788c = null;
        if (this.f5958e == c1702c && c1702c == this.f5959f) {
            this.f5959f = null;
            this.f5958e = null;
        }
        C1702c c1702c2 = this.f5958e;
        if (c1702c2 == c1702c) {
            this.f5958e = m3787b(c1702c2);
        }
        C1702c c1702c3 = this.f5959f;
        if (c1702c3 == c1702c) {
            C1702c c1702c4 = this.f5958e;
            if (c1702c3 != c1702c4 && c1702c4 != null) {
                c1702cM3788c = m3788c(c1702c3);
            }
            this.f5959f = c1702cM3788c;
        }
    }

    /* JADX INFO: renamed from: b */
    public final C1702c m3787b(C1702c c1702c) {
        switch (this.f5960g) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return c1702c.f5964h;
            default:
                return c1702c.f5963g;
        }
    }

    /* JADX INFO: renamed from: c */
    public final C1702c m3788c(C1702c c1702c) {
        switch (this.f5960g) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return c1702c.f5963g;
            default:
                return c1702c.f5964h;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5959f != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        C1702c c1702c = this.f5959f;
        C1702c c1702c2 = this.f5958e;
        this.f5959f = (c1702c == c1702c2 || c1702c2 == null) ? null : m3788c(c1702c);
        return c1702c;
    }
}
