package p039M0;

import java.io.Serializable;

/* JADX INFO: renamed from: M0.N */
/* JADX INFO: loaded from: classes.dex */
public final class C0466N implements Serializable {

    /* JADX INFO: renamed from: g */
    public static final C0466N f1104g;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final EnumC0481b0 f1105e;

    /* JADX INFO: renamed from: f */
    public final EnumC0481b0 f1106f;

    static {
        EnumC0481b0 enumC0481b0 = EnumC0481b0.f1125h;
        f1104g = new C0466N(enumC0481b0, enumC0481b0);
    }

    public C0466N(EnumC0481b0 enumC0481b0, EnumC0481b0 enumC0481b02) {
        this.f1105e = enumC0481b0;
        this.f1106f = enumC0481b02;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C0466N.class) {
            return false;
        }
        C0466N c0466n = (C0466N) obj;
        return c0466n.f1105e == this.f1105e && c0466n.f1106f == this.f1106f;
    }

    public final int hashCode() {
        return this.f1105e.ordinal() + (this.f1106f.ordinal() << 2);
    }

    public Object readResolve() {
        EnumC0481b0 enumC0481b0 = EnumC0481b0.f1125h;
        return (this.f1105e == enumC0481b0 && this.f1106f == enumC0481b0) ? f1104g : this;
    }

    public final String toString() {
        return "JsonSetter.Value(valueNulls=" + this.f1105e + ",contentNulls=" + this.f1106f + ")";
    }
}
