package p008B2;

import p015D2.C0187k;
import p115l2.InterfaceC1693p;
import p119m2.AbstractC1766e;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.w */
/* JADX INFO: loaded from: classes.dex */
public final class C0130w {

    /* JADX INFO: renamed from: e */
    public static final long[] f334e = new long[0];

    /* JADX INFO: renamed from: a */
    public final InterfaceC2095g f335a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1693p f336b;

    /* JADX INFO: renamed from: c */
    public long f337c;

    /* JADX INFO: renamed from: d */
    public final long[] f338d;

    public C0130w(InterfaceC2095g interfaceC2095g, C0187k c0187k) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        this.f335a = interfaceC2095g;
        this.f336b = c0187k;
        int iMo240l = interfaceC2095g.mo240l();
        if (iMo240l <= 64) {
            this.f337c = iMo240l != 64 ? (-1) << iMo240l : 0L;
            this.f338d = f334e;
            return;
        }
        this.f337c = 0L;
        int i3 = (iMo240l - 1) >>> 6;
        long[] jArr = new long[i3];
        if ((iMo240l & 63) != 0) {
            jArr[i3 - 1] = (-1) << iMo240l;
        }
        this.f338d = jArr;
    }
}
