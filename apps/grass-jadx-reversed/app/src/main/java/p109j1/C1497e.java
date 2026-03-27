package p109j1;

import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p069X0.AbstractC0709K;

/* JADX INFO: renamed from: j1.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1497e extends AbstractC1518z {

    /* JADX INFO: renamed from: f */
    public static final C1497e f5432f = new C1497e(true);

    /* JADX INFO: renamed from: g */
    public static final C1497e f5433g = new C1497e(false);
    private static final long serialVersionUID = 2;

    /* JADX INFO: renamed from: e */
    public final boolean f5434e;

    public C1497e(boolean z3) {
        this.f5434e = z3;
    }

    @Override // p042N0.InterfaceC0557y
    /* JADX INFO: renamed from: b */
    public final EnumC0548p mo1240b() {
        return this.f5434e ? EnumC0548p.VALUE_TRUE : EnumC0548p.VALUE_FALSE;
    }

    @Override // p109j1.AbstractC1494b, p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: c */
    public final void mo1909c(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        abstractC0540h.mo1140m(this.f5434e);
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: e */
    public final String mo1897e() {
        return this.f5434e ? "true" : "false";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof C1497e)) {
            return this.f5434e == ((C1497e) obj).f5434e;
        }
        return false;
    }

    public final int hashCode() {
        return this.f5434e ? 3 : 1;
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: m */
    public final int mo1905m() {
        return 3;
    }

    public Object readResolve() {
        return this.f5434e ? f5432f : f5433g;
    }
}
