package p039M0;

import java.io.Serializable;

/* JADX INFO: renamed from: M0.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0480b implements Serializable {

    /* JADX INFO: renamed from: g */
    public static final C0480b f1119g = new C0480b(null, null);
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final Object f1120e;

    /* JADX INFO: renamed from: f */
    public final Boolean f1121f;

    public C0480b(Object obj, Boolean bool) {
        this.f1120e = obj;
        this.f1121f = bool;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == C0480b.class) {
            C0480b c0480b = (C0480b) obj;
            Boolean bool = this.f1121f;
            Boolean bool2 = c0480b.f1121f;
            if (bool == null ? bool2 == null : bool.equals(bool2)) {
                Object obj2 = c0480b.f1120e;
                Object obj3 = this.f1120e;
                return obj3 == null ? obj2 == null : obj3.equals(obj2);
            }
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f1120e;
        int iHashCode = obj != null ? 1 + obj.hashCode() : 1;
        Boolean bool = this.f1121f;
        return bool != null ? iHashCode + bool.hashCode() : iHashCode;
    }

    public final String toString() {
        return String.format("JacksonInject.Value(id=%s,useInput=%s)", this.f1120e, this.f1121f);
    }
}
