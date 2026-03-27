package p083b2;

import java.io.Serializable;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: b2.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1062g implements Serializable {

    /* JADX INFO: renamed from: e */
    public final Throwable f3738e;

    public C1062g(Throwable th) {
        this.f3738e = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1062g) {
            if (AbstractC1766e.m3916a(this.f3738e, ((C1062g) obj).f3738e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f3738e.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f3738e + ')';
    }
}
