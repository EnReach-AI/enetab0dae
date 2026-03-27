package p011C2;

import p015D2.AbstractC0201y;
import p119m2.AbstractC1766e;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: C2.o */
/* JADX INFO: loaded from: classes.dex */
public final class C0162o extends AbstractC0172y {

    /* JADX INFO: renamed from: e */
    public final boolean f393e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC2095g f394f;

    /* JADX INFO: renamed from: g */
    public final String f395g;

    public C0162o(Object obj, boolean z3) {
        AbstractC1766e.m3920e("body", obj);
        this.f393e = z3;
        this.f394f = null;
        this.f395g = obj.toString();
    }

    @Override // p011C2.AbstractC0172y
    /* JADX INFO: renamed from: a */
    public final String mo299a() {
        return this.f395g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0162o.class != obj.getClass()) {
            return false;
        }
        C0162o c0162o = (C0162o) obj;
        return this.f393e == c0162o.f393e && AbstractC1766e.m3916a(this.f395g, c0162o.f395g);
    }

    public final int hashCode() {
        return this.f395g.hashCode() + (Boolean.hashCode(this.f393e) * 31);
    }

    @Override // p011C2.AbstractC0172y
    public final String toString() {
        String str = this.f395g;
        if (!this.f393e) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        AbstractC0201y.m394a(sb, str);
        String string = sb.toString();
        AbstractC1766e.m3919d("StringBuilder().apply(builderAction).toString()", string);
        return string;
    }
}
