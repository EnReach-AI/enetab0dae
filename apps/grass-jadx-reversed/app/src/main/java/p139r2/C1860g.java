package p139r2;

import java.util.Iterator;
import p008B2.C0085Z;
import p115l2.InterfaceC1689l;
import p142s2.C1888c;

/* JADX INFO: renamed from: r2.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1860g implements InterfaceC1855b {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1855b f6433a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1689l f6434b;

    public C1860g(C1888c c1888c, C0085Z c0085z) {
        this.f6433a = c1888c;
        this.f6434b = c0085z;
    }

    @Override // p139r2.InterfaceC1855b
    public final Iterator iterator() {
        return new C1859f(this);
    }
}
