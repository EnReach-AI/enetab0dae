package p118m1;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: renamed from: m1.p */
/* JADX INFO: loaded from: classes.dex */
public final class C1751p implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final Set f6125e;

    /* JADX INFO: renamed from: f */
    public final Set f6126f;

    public C1751p(Set set, Set set2) {
        this.f6125e = set == null ? Collections.emptySet() : set;
        this.f6126f = set2;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3910a(Object obj) {
        Set set = this.f6126f;
        return !(set == null || set.contains(obj)) || this.f6125e.contains(obj);
    }
}
