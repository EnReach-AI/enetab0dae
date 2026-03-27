package p039M0;

import java.io.Serializable;
import java.util.Set;

/* JADX INFO: renamed from: M0.C */
/* JADX INFO: loaded from: classes.dex */
public final class C0455C implements Serializable {

    /* JADX INFO: renamed from: f */
    public static final C0455C f1100f = new C0455C(null);
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final Set f1101e;

    public C0455C(Set set) {
        this.f1101e = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == C0455C.class) {
            Set set = this.f1101e;
            Set set2 = ((C0455C) obj).f1101e;
            if (set == null ? set2 == null : set.equals(set2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Set set = this.f1101e;
        if (set == null) {
            return 0;
        }
        return set.size();
    }

    public final String toString() {
        return String.format("JsonIncludeProperties.Value(included=%s)", this.f1101e);
    }
}
