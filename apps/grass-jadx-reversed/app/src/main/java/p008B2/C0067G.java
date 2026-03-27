package p008B2;

import java.util.Arrays;
import p119m2.AbstractC1766e;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.G */
/* JADX INFO: loaded from: classes.dex */
public final class C0067G extends AbstractC0093d0 {

    /* JADX INFO: renamed from: l */
    public final boolean f225l;

    public C0067G(String str, C0068H c0068h) {
        super(str, c0068h, 1);
        this.f225l = true;
    }

    @Override // p008B2.AbstractC0093d0, p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: b */
    public final boolean mo231b() {
        return this.f225l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0067G) {
            InterfaceC2095g interfaceC2095g = (InterfaceC2095g) obj;
            if (AbstractC1766e.m3916a(this.f269a, interfaceC2095g.mo233d())) {
                C0067G c0067g = (C0067G) obj;
                if (c0067g.f225l && Arrays.equals((InterfaceC2095g[]) this.f278j.getValue(), (InterfaceC2095g[]) c0067g.f278j.getValue())) {
                    int iMo240l = interfaceC2095g.mo240l();
                    int i3 = this.f271c;
                    if (i3 == iMo240l) {
                        for (int i4 = 0; i4 < i3; i4++) {
                            if (AbstractC1766e.m3916a(mo236h(i4).mo233d(), interfaceC2095g.mo236h(i4).mo233d()) && AbstractC1766e.m3916a(mo236h(i4).mo237i(), interfaceC2095g.mo236h(i4).mo237i())) {
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // p008B2.AbstractC0093d0
    public final int hashCode() {
        return super.hashCode() * 31;
    }
}
