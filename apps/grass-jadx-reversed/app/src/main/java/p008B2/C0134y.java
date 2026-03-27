package p008B2;

import p039M0.AbstractC0493h0;
import p082b1.C1046q;
import p083b2.C1065j;
import p086c2.AbstractC1085d;
import p119m2.AbstractC1766e;
import p167z2.C2097i;
import p167z2.C2099k;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.y */
/* JADX INFO: loaded from: classes.dex */
public final class C0134y extends AbstractC0093d0 {

    /* JADX INFO: renamed from: l */
    public final C2099k f345l;

    /* JADX INFO: renamed from: m */
    public final C1065j f346m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0134y(int i3, String str) {
        super(str, null, i3);
        AbstractC1766e.m3920e("name", str);
        this.f345l = C2099k.f7423d;
        this.f346m = new C1065j(new C0132x(i3, str, this));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InterfaceC2095g)) {
            return false;
        }
        InterfaceC2095g interfaceC2095g = (InterfaceC2095g) obj;
        if (interfaceC2095g.mo237i() != C2099k.f7423d) {
            return false;
        }
        return AbstractC1766e.m3916a(this.f269a, interfaceC2095g.mo233d()) && AbstractC1766e.m3916a(AbstractC0089b0.m255b(this), AbstractC0089b0.m255b(interfaceC2095g));
    }

    @Override // p008B2.AbstractC0093d0, p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: h */
    public final InterfaceC2095g mo236h(int i3) {
        return ((InterfaceC2095g[]) this.f346m.getValue())[i3];
    }

    @Override // p008B2.AbstractC0093d0
    public final int hashCode() {
        int iHashCode = this.f269a.hashCode();
        C2097i c2097i = new C2097i(this, 1);
        int iHashCode2 = 1;
        while (c2097i.hasNext()) {
            int i3 = iHashCode2 * 31;
            String str = (String) c2097i.next();
            iHashCode2 = i3 + (str != null ? str.hashCode() : 0);
        }
        return (iHashCode * 31) + iHashCode2;
    }

    @Override // p008B2.AbstractC0093d0, p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: i */
    public final AbstractC0493h0 mo237i() {
        return this.f345l;
    }

    @Override // p008B2.AbstractC0093d0
    public final String toString() {
        return AbstractC1085d.m2834x(new C1046q(2, this), ", ", this.f269a + '(', ")", null, 56);
    }
}
