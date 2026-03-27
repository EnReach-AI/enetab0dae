package p008B2;

import java.util.List;
import p039M0.AbstractC0493h0;
import p086c2.C1093l;
import p119m2.AbstractC1766e;
import p142s2.AbstractC1899n;
import p167z2.C2100l;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.M */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0073M implements InterfaceC2095g {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2095g f234a;

    /* JADX INFO: renamed from: b */
    public final int f235b = 1;

    public AbstractC0073M(InterfaceC2095g interfaceC2095g) {
        this.f234a = interfaceC2095g;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: a */
    public final String mo230a(int i3) {
        return String.valueOf(i3);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: b */
    public final boolean mo231b() {
        return false;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: c */
    public final int mo232c(String str) {
        AbstractC1766e.m3920e("name", str);
        Integer numM4229f = AbstractC1899n.m4229f(str);
        if (numM4229f != null) {
            return numM4229f.intValue();
        }
        throw new IllegalArgumentException(str.concat(" is not a valid list index"));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC0073M)) {
            return false;
        }
        AbstractC0073M abstractC0073M = (AbstractC0073M) obj;
        return AbstractC1766e.m3916a(this.f234a, abstractC0073M.f234a) && AbstractC1766e.m3916a(mo233d(), abstractC0073M.mo233d());
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: f */
    public final boolean mo234f() {
        return false;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: g */
    public final List mo235g(int i3) {
        if (i3 >= 0) {
            return C1093l.f3782e;
        }
        throw new IllegalArgumentException(("Illegal index " + i3 + ", " + mo233d() + " expects only non-negative indices").toString());
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: h */
    public final InterfaceC2095g mo236h(int i3) {
        if (i3 >= 0) {
            return this.f234a;
        }
        throw new IllegalArgumentException(("Illegal index " + i3 + ", " + mo233d() + " expects only non-negative indices").toString());
    }

    public final int hashCode() {
        return mo233d().hashCode() + (this.f234a.hashCode() * 31);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: i */
    public final AbstractC0493h0 mo237i() {
        return C2100l.f7425d;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: j */
    public final boolean mo238j(int i3) {
        if (i3 >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + i3 + ", " + mo233d() + " expects only non-negative indices").toString());
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: k */
    public final List mo239k() {
        return C1093l.f3782e;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: l */
    public final int mo240l() {
        return this.f235b;
    }

    public final String toString() {
        return mo233d() + '(' + this.f234a + ')';
    }
}
