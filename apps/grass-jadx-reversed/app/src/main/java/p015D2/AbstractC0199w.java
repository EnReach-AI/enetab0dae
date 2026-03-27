package p015D2;

import java.util.LinkedHashSet;
import p008B2.C0061B0;
import p008B2.C0123s0;
import p008B2.C0129v0;
import p008B2.C0135y0;
import p086c2.AbstractC1097p;
import p119m2.AbstractC1766e;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: D2.w */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0199w {

    /* JADX INFO: renamed from: a */
    public static final LinkedHashSet f474a;

    static {
        InterfaceC2095g[] interfaceC2095gArr = {C0129v0.f333b, C0135y0.f348b, C0123s0.f323b, C0061B0.f211b};
        LinkedHashSet linkedHashSet = new LinkedHashSet(AbstractC1097p.m2840i(4));
        for (int i3 = 0; i3 < 4; i3++) {
            linkedHashSet.add(interfaceC2095gArr[i3]);
        }
        f474a = linkedHashSet;
    }

    /* JADX INFO: renamed from: a */
    public static final boolean m368a(InterfaceC2095g interfaceC2095g) {
        AbstractC1766e.m3920e("<this>", interfaceC2095g);
        return interfaceC2095g.mo231b() && f474a.contains(interfaceC2095g);
    }
}
