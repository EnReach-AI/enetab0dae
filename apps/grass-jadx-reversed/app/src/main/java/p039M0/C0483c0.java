package p039M0;

import java.io.Serializable;

/* JADX INFO: renamed from: M0.c0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0483c0 implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final Class f1127e;

    /* JADX INFO: renamed from: f */
    public final Class f1128f;

    /* JADX INFO: renamed from: g */
    public final Object f1129g;

    /* JADX INFO: renamed from: h */
    public final int f1130h;

    public C0483c0(Class cls, Class cls2, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Can not construct IdKey for null key");
        }
        this.f1127e = cls;
        this.f1128f = cls2;
        this.f1129g = obj;
        int iHashCode = cls.getName().hashCode() + obj.hashCode();
        this.f1130h = cls2 != null ? iHashCode ^ cls2.getName().hashCode() : iHashCode;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C0483c0.class) {
            return false;
        }
        C0483c0 c0483c0 = (C0483c0) obj;
        return c0483c0.f1129g.equals(this.f1129g) && c0483c0.f1127e == this.f1127e && c0483c0.f1128f == this.f1128f;
    }

    public final int hashCode() {
        return this.f1130h;
    }

    public final String toString() {
        Class cls = this.f1127e;
        String name = cls == null ? "NONE" : cls.getName();
        Class cls2 = this.f1128f;
        return String.format("[ObjectId: key=%s, type=%s, scope=%s]", this.f1129g, name, cls2 != null ? cls2.getName() : "NONE");
    }
}
