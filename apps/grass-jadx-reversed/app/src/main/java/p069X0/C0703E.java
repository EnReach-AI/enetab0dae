package p069X0;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import p050Q0.C0597j;
import p066W0.C0682i;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: X0.E */
/* JADX INFO: loaded from: classes.dex */
public final class C0703E implements Serializable {

    /* JADX INFO: renamed from: h */
    public static final C0703E f1926h = new C0703E("", null);

    /* JADX INFO: renamed from: i */
    public static final C0703E f1927i = new C0703E(new String(""), null);
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final String f1928e;

    /* JADX INFO: renamed from: f */
    public final String f1929f;

    /* JADX INFO: renamed from: g */
    public C0597j f1930g;

    public C0703E(String str, String str2) {
        Annotation[] annotationArr = AbstractC1745j.f6110a;
        this.f1928e = str == null ? "" : str;
        this.f1929f = str2;
    }

    /* JADX INFO: renamed from: a */
    public static C0703E m1686a(String str) {
        return (str == null || str.isEmpty()) ? f1926h : new C0703E(C0682i.f1857f.m1642a(str), null);
    }

    /* JADX INFO: renamed from: b */
    public static C0703E m1687b(String str, String str2) {
        if (str == null) {
            str = "";
        }
        return (str2 == null && str.isEmpty()) ? f1926h : new C0703E(C0682i.f1857f.m1642a(str), str2);
    }

    /* JADX INFO: renamed from: c */
    public final boolean m1688c() {
        return this.f1929f == null && this.f1928e.isEmpty();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C0703E.class) {
            return false;
        }
        C0703E c0703e = (C0703E) obj;
        String str = c0703e.f1928e;
        String str2 = this.f1928e;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        String str3 = c0703e.f1929f;
        String str4 = this.f1929f;
        return str4 == null ? str3 == null : str4.equals(str3);
    }

    public final int hashCode() {
        String str = this.f1928e;
        String str2 = this.f1929f;
        if (str2 == null) {
            return str.hashCode();
        }
        return str.hashCode() ^ str2.hashCode();
    }

    public Object readResolve() {
        String str;
        return (this.f1929f == null && ((str = this.f1928e) == null || "".equals(str))) ? f1926h : this;
    }

    public final String toString() {
        String str = this.f1928e;
        String str2 = this.f1929f;
        if (str2 == null) {
            return str;
        }
        return "{" + str2 + "}" + str;
    }
}
