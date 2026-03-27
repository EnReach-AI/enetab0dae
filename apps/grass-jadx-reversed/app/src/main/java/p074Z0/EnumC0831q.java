package p074Z0;

/* JADX INFO: renamed from: Z0.q */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0831q implements InterfaceC0826l {
    f2475f,
    f2476g,
    f2477h;


    /* JADX INFO: renamed from: e */
    public final int f2479e = 1 << ordinal();

    EnumC0831q() {
    }

    @Override // p066W0.InterfaceC0683j
    /* JADX INFO: renamed from: a */
    public final int mo1234a() {
        return this.f2479e;
    }

    @Override // p066W0.InterfaceC0683j
    /* JADX INFO: renamed from: b */
    public final boolean mo1235b() {
        return true;
    }

    @Override // p066W0.InterfaceC0683j
    /* JADX INFO: renamed from: c */
    public final boolean mo1643c(int i3) {
        return (i3 & this.f2479e) != 0;
    }

    @Override // p074Z0.InterfaceC0826l
    /* JADX INFO: renamed from: d */
    public final int mo2142d() {
        return 1;
    }
}
