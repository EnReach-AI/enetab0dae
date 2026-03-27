package p008B2;

import p119m2.AbstractC1766e;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.f0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0097f0 extends AbstractC0073M {

    /* JADX INFO: renamed from: c */
    public final String f283c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0097f0(InterfaceC2095g interfaceC2095g) {
        super(interfaceC2095g);
        AbstractC1766e.m3920e("primitive", interfaceC2095g);
        this.f283c = interfaceC2095g.mo233d() + "Array";
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: d */
    public final String mo233d() {
        return this.f283c;
    }
}
