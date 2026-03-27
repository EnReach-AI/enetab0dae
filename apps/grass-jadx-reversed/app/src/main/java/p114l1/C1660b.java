package p114l1;

import java.io.Serializable;

/* JADX INFO: renamed from: l1.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1660b implements Comparable, Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final String f5885e;

    /* JADX INFO: renamed from: f */
    public final Class f5886f;

    /* JADX INFO: renamed from: g */
    public final int f5887g;

    public C1660b(Class cls) {
        this.f5886f = cls;
        String name = cls.getName();
        this.f5885e = name;
        this.f5887g = name.hashCode();
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f5885e.compareTo(((C1660b) obj).f5885e);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass() == C1660b.class && ((C1660b) obj).f5886f == this.f5886f;
    }

    public final int hashCode() {
        return this.f5887g;
    }

    public final String toString() {
        return this.f5885e;
    }
}
