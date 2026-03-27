package p083b2;

import java.io.Serializable;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: b2.h */
/* JADX INFO: loaded from: classes.dex */
public final class C1063h implements Serializable {

    /* JADX INFO: renamed from: e */
    public final Object f3739e;

    public final boolean equals(Object obj) {
        if (obj instanceof C1063h) {
            return AbstractC1766e.m3916a(this.f3739e, ((C1063h) obj).f3739e);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f3739e;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f3739e;
        if (obj instanceof C1062g) {
            return ((C1062g) obj).toString();
        }
        return "Success(" + obj + ')';
    }
}
