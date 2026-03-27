package p109j1;

import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p069X0.AbstractC0709K;

/* JADX INFO: renamed from: j1.t */
/* JADX INFO: loaded from: classes.dex */
public final class C1512t extends AbstractC1518z {

    /* JADX INFO: renamed from: e */
    public static final C1512t f5463e = new C1512t();
    private static final long serialVersionUID = 1;

    @Override // p042N0.InterfaceC0557y
    /* JADX INFO: renamed from: b */
    public final EnumC0548p mo1240b() {
        return EnumC0548p.VALUE_NULL;
    }

    @Override // p109j1.AbstractC1494b, p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: c */
    public final void mo1909c(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        abstractC0709K.m1719q(abstractC0540h);
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: e */
    public final String mo1897e() {
        return "null";
    }

    public final boolean equals(Object obj) {
        return obj == this || (obj instanceof C1512t);
    }

    public final int hashCode() {
        return 4;
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: m */
    public final int mo1905m() {
        return 5;
    }

    public Object readResolve() {
        return f5463e;
    }
}
