package p118m1;

import p069X0.AbstractC0721l;

/* JADX INFO: renamed from: m1.G */
/* JADX INFO: loaded from: classes.dex */
public final class C1732G {

    /* JADX INFO: renamed from: a */
    public final int f6074a;

    /* JADX INFO: renamed from: b */
    public final Class f6075b;

    /* JADX INFO: renamed from: c */
    public final AbstractC0721l f6076c;

    /* JADX INFO: renamed from: d */
    public final boolean f6077d;

    public C1732G(Class cls, boolean z3) {
        this.f6075b = cls;
        this.f6076c = null;
        this.f6077d = z3;
        this.f6074a = z3 ? cls.getName().hashCode() + 1 : cls.getName().hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != C1732G.class) {
            return false;
        }
        C1732G c1732g = (C1732G) obj;
        if (c1732g.f6077d != this.f6077d) {
            return false;
        }
        Class cls = this.f6075b;
        return cls != null ? c1732g.f6075b == cls : this.f6076c.equals(c1732g.f6076c);
    }

    public final int hashCode() {
        return this.f6074a;
    }

    public final String toString() {
        boolean z3 = this.f6077d;
        Class cls = this.f6075b;
        if (cls != null) {
            return "{class: " + cls.getName() + ", typed? " + z3 + "}";
        }
        return "{type: " + this.f6076c + ", typed? " + z3 + "}";
    }

    public C1732G(AbstractC0721l abstractC0721l, boolean z3) {
        int iHashCode;
        this.f6076c = abstractC0721l;
        this.f6075b = null;
        this.f6077d = z3;
        if (z3) {
            iHashCode = abstractC0721l.hashCode() - 2;
        } else {
            iHashCode = abstractC0721l.hashCode() - 1;
        }
        this.f6074a = iHashCode;
    }
}
