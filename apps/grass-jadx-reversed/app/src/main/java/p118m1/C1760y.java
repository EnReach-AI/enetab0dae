package p118m1;

import p005B.AbstractC0032g;
import p042N0.AbstractC0540h;
import p042N0.InterfaceC0551s;
import p069X0.AbstractC0709K;
import p069X0.InterfaceC0727r;
import p100g1.AbstractC1399h;

/* JADX INFO: renamed from: m1.y */
/* JADX INFO: loaded from: classes.dex */
public final class C1760y implements InterfaceC0727r {

    /* JADX INFO: renamed from: e */
    public String f6138e;

    @Override // p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: c */
    public final void mo1909c(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        CharSequence charSequence = this.f6138e;
        if (charSequence instanceof InterfaceC0727r) {
            ((InterfaceC0727r) charSequence).mo1909c(abstractC0540h, abstractC0709K);
        } else if (charSequence instanceof InterfaceC0551s) {
            abstractC0540h.mo1115H((InterfaceC0551s) charSequence);
        } else {
            abstractC0540h.mo1116I(String.valueOf(charSequence));
        }
    }

    @Override // p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: d */
    public final void mo1908d(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
        CharSequence charSequence = this.f6138e;
        if (charSequence instanceof InterfaceC0727r) {
            ((InterfaceC0727r) charSequence).mo1908d(abstractC0540h, abstractC0709K, abstractC1399h);
        } else if (charSequence instanceof InterfaceC0551s) {
            mo1909c(abstractC0540h, abstractC0709K);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1760y)) {
            return false;
        }
        String str = this.f6138e;
        String str2 = ((C1760y) obj).f6138e;
        if (str == str2) {
            return true;
        }
        return str != null && str.equals(str2);
    }

    public final int hashCode() {
        String str = this.f6138e;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        return AbstractC0032g.m154l("[RawValue of type ", AbstractC1745j.m3883f(this.f6138e), "]");
    }
}
