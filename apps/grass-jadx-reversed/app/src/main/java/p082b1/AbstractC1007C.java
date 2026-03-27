package p082b1;

import java.util.Iterator;
import p039M0.C0453A;
import p069X0.AbstractC0721l;
import p069X0.C0702D;
import p069X0.C0703E;
import p069X0.C0710a;
import p118m1.InterfaceC1758w;

/* JADX INFO: renamed from: b1.C */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1007C implements InterfaceC1758w {

    /* JADX INFO: renamed from: e */
    public static final C0453A f3592e = C0453A.f1095i;

    /* JADX INFO: renamed from: A */
    public abstract boolean mo2704A();

    /* JADX INFO: renamed from: B */
    public boolean mo2705B() {
        return false;
    }

    /* JADX INFO: renamed from: a */
    public abstract C0703E mo2706a();

    /* JADX INFO: renamed from: b */
    public abstract C0702D mo2707b();

    /* JADX INFO: renamed from: g */
    public boolean mo2708g() {
        AbstractC1041l abstractC1041lMo2715n = mo2715n();
        if (abstractC1041lMo2715n == null && (abstractC1041lMo2715n = mo2721t()) == null) {
            abstractC1041lMo2715n = mo2717p();
        }
        return abstractC1041lMo2715n != null;
    }

    /* JADX INFO: renamed from: h */
    public boolean mo2709h() {
        return m2714m() != null;
    }

    /* JADX INFO: renamed from: i */
    public abstract C0453A mo2710i();

    /* JADX INFO: renamed from: j */
    public C1018N mo2711j() {
        return null;
    }

    /* JADX INFO: renamed from: k */
    public C0710a mo2712k() {
        return null;
    }

    /* JADX INFO: renamed from: l */
    public Class[] mo2713l() {
        return null;
    }

    /* JADX INFO: renamed from: m */
    public final AbstractC1041l m2714m() {
        C1043n c1043nMo2718q = mo2718q();
        return c1043nMo2718q == null ? mo2717p() : c1043nMo2718q;
    }

    /* JADX INFO: renamed from: n */
    public abstract C1047r mo2715n();

    /* JADX INFO: renamed from: o */
    public abstract Iterator mo2716o();

    /* JADX INFO: renamed from: p */
    public abstract C1039j mo2717p();

    /* JADX INFO: renamed from: q */
    public abstract C1043n mo2718q();

    /* JADX INFO: renamed from: r */
    public abstract AbstractC0721l mo2719r();

    /* JADX INFO: renamed from: s */
    public abstract Class mo2720s();

    /* JADX INFO: renamed from: t */
    public abstract C1043n mo2721t();

    /* JADX INFO: renamed from: u */
    public abstract C0703E mo2722u();

    /* JADX INFO: renamed from: v */
    public abstract boolean mo2723v();

    /* JADX INFO: renamed from: w */
    public abstract boolean mo2724w();

    /* JADX INFO: renamed from: x */
    public abstract boolean mo2725x(C0703E c0703e);

    /* JADX INFO: renamed from: y */
    public abstract boolean mo2726y();

    /* JADX INFO: renamed from: z */
    public abstract boolean mo2727z();
}
