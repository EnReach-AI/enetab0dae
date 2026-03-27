package p117m0;

import java.io.Serializable;
import p166z0.AbstractC2056E;

/* JADX INFO: renamed from: m0.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1707b implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final String f5974e;

    /* JADX INFO: renamed from: f */
    public final String f5975f;

    public C1707b(String str, String str2) {
        this.f5974e = AbstractC2056E.m4550s(str) ? null : str;
        this.f5975f = str2;
    }

    private Object writeReplace() {
        return new C1706a(this.f5974e, this.f5975f);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1707b)) {
            return false;
        }
        C1707b c1707b = (C1707b) obj;
        String str = c1707b.f5974e;
        String str2 = this.f5974e;
        if (!(str == null ? str2 == null : str.equals(str2))) {
            return false;
        }
        String str3 = c1707b.f5975f;
        String str4 = this.f5975f;
        return str3 == null ? str4 == null : str3.equals(str4);
    }

    public final int hashCode() {
        String str = this.f5974e;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.f5975f;
        return (str2 != null ? str2.hashCode() : 0) ^ iHashCode;
    }
}
