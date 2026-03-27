package p039M0;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: renamed from: M0.w */
/* JADX INFO: loaded from: classes.dex */
public final class C0508w implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final C0508w f1176j = new C0508w(Collections.emptySet(), false, false, false, true);
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final Set f1177e;

    /* JADX INFO: renamed from: f */
    public final boolean f1178f;

    /* JADX INFO: renamed from: g */
    public final boolean f1179g;

    /* JADX INFO: renamed from: h */
    public final boolean f1180h;

    /* JADX INFO: renamed from: i */
    public final boolean f1181i;

    public C0508w(Set set, boolean z3, boolean z4, boolean z5, boolean z6) {
        if (set == null) {
            this.f1177e = Collections.emptySet();
        } else {
            this.f1177e = set;
        }
        this.f1178f = z3;
        this.f1179g = z4;
        this.f1180h = z5;
        this.f1181i = z6;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1019a(Set set, boolean z3, boolean z4, boolean z5, boolean z6) {
        C0508w c0508w = f1176j;
        if (z3 == c0508w.f1178f && z4 == c0508w.f1179g && z5 == c0508w.f1180h && z6 == c0508w.f1181i) {
            return set == null || set.size() == 0;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == C0508w.class) {
            C0508w c0508w = (C0508w) obj;
            if (this.f1178f == c0508w.f1178f && this.f1181i == c0508w.f1181i && this.f1179g == c0508w.f1179g && this.f1180h == c0508w.f1180h && this.f1177e.equals(c0508w.f1177e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f1177e.size() + (this.f1178f ? 1 : -3) + (this.f1179g ? 3 : -7) + (this.f1180h ? 7 : -11) + (this.f1181i ? 11 : -13);
    }

    public Object readResolve() {
        return m1019a(this.f1177e, this.f1178f, this.f1179g, this.f1180h, this.f1181i) ? f1176j : this;
    }

    public final String toString() {
        return String.format("JsonIgnoreProperties.Value(ignored=%s,ignoreUnknown=%s,allowGetters=%s,allowSetters=%s,merge=%s)", this.f1177e, Boolean.valueOf(this.f1178f), Boolean.valueOf(this.f1179g), Boolean.valueOf(this.f1180h), Boolean.valueOf(this.f1181i));
    }
}
