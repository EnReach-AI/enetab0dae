package p082b1;

import p019F0.C0221e;
import p069X0.AbstractC0721l;

/* JADX INFO: renamed from: b1.s */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1048s extends AbstractC1041l {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: g */
    public final C0221e[] f3717g;

    public AbstractC1048s(InterfaceC1027X interfaceC1027X, C0221e c0221e, C0221e[] c0221eArr) {
        super(interfaceC1027X, c0221e);
        this.f3717g = c0221eArr;
    }

    /* JADX INFO: renamed from: o */
    public abstract Object mo2787o();

    /* JADX INFO: renamed from: p */
    public abstract Object mo2788p(Object[] objArr);

    /* JADX INFO: renamed from: q */
    public abstract Object mo2789q(Object obj);

    /* JADX INFO: renamed from: r */
    public final C1047r m2805r(int i3) {
        AbstractC0721l abstractC0721lMo2791t = mo2791t(i3);
        C0221e[] c0221eArr = this.f3717g;
        return new C1047r(this, abstractC0721lMo2791t, this.f3699e, (c0221eArr == null || i3 < 0 || i3 >= c0221eArr.length) ? null : c0221eArr[i3], i3);
    }

    /* JADX INFO: renamed from: s */
    public abstract int mo2790s();

    /* JADX INFO: renamed from: t */
    public abstract AbstractC0721l mo2791t(int i3);

    /* JADX INFO: renamed from: u */
    public abstract Class mo2792u(int i3);
}
