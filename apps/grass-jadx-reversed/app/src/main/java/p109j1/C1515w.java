package p109j1;

import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p069X0.AbstractC0709K;
import p069X0.InterfaceC0727r;

/* JADX INFO: renamed from: j1.w */
/* JADX INFO: loaded from: classes.dex */
public final class C1515w extends AbstractC1518z {
    private static final long serialVersionUID = 2;

    /* JADX INFO: renamed from: e */
    public final Object f5465e;

    public C1515w(Object obj) {
        this.f5465e = obj;
    }

    @Override // p042N0.InterfaceC0557y
    /* JADX INFO: renamed from: b */
    public final EnumC0548p mo1240b() {
        return EnumC0548p.VALUE_EMBEDDED_OBJECT;
    }

    @Override // p109j1.AbstractC1494b, p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: c */
    public final void mo1909c(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        Object obj = this.f5465e;
        if (obj == null) {
            abstractC0709K.m1719q(abstractC0540h);
        } else if (obj instanceof InterfaceC0727r) {
            ((InterfaceC0727r) obj).mo1909c(abstractC0540h, abstractC0709K);
        } else {
            abstractC0709K.getClass();
            abstractC0709K.m1726x(obj.getClass()).serialize(obj, abstractC0540h, abstractC0709K);
        }
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: e */
    public final String mo1897e() {
        Object obj = this.f5465e;
        return obj == null ? "null" : obj.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof C1515w)) {
            return false;
        }
        Object obj2 = ((C1515w) obj).f5465e;
        Object obj3 = this.f5465e;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: g */
    public final byte[] mo1899g() {
        Object obj = this.f5465e;
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        return null;
    }

    public final int hashCode() {
        return this.f5465e.hashCode();
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: m */
    public final int mo1905m() {
        return 8;
    }
}
