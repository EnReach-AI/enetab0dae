package p039M0;

import java.io.Serializable;

/* JADX INFO: renamed from: M0.A */
/* JADX INFO: loaded from: classes.dex */
public final class C0453A implements Serializable {

    /* JADX INFO: renamed from: i */
    public static final C0453A f1095i;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final EnumC0511z f1096e;

    /* JADX INFO: renamed from: f */
    public final EnumC0511z f1097f;

    /* JADX INFO: renamed from: g */
    public final Class f1098g;

    /* JADX INFO: renamed from: h */
    public final Class f1099h;

    static {
        EnumC0511z enumC0511z = EnumC0511z.f1186i;
        f1095i = new C0453A(enumC0511z, enumC0511z, null, null);
    }

    public C0453A(EnumC0511z enumC0511z, EnumC0511z enumC0511z2, Class cls, Class cls2) {
        EnumC0511z enumC0511z3 = EnumC0511z.f1186i;
        this.f1096e = enumC0511z == null ? enumC0511z3 : enumC0511z;
        this.f1097f = enumC0511z2 == null ? enumC0511z3 : enumC0511z2;
        this.f1098g = cls == Void.class ? null : cls;
        this.f1099h = cls2 == Void.class ? null : cls2;
    }

    /* JADX INFO: renamed from: a */
    public final C0453A m989a(C0453A c0453a) {
        if (c0453a != null && c0453a != f1095i) {
            EnumC0511z enumC0511z = EnumC0511z.f1186i;
            EnumC0511z enumC0511z2 = c0453a.f1096e;
            EnumC0511z enumC0511z3 = this.f1096e;
            boolean z3 = (enumC0511z2 == enumC0511z3 || enumC0511z2 == enumC0511z) ? false : true;
            EnumC0511z enumC0511z4 = c0453a.f1097f;
            EnumC0511z enumC0511z5 = this.f1097f;
            boolean z4 = (enumC0511z4 == enumC0511z5 || enumC0511z4 == enumC0511z) ? false : true;
            Class cls = c0453a.f1098g;
            Class cls2 = c0453a.f1099h;
            Class cls3 = this.f1098g;
            boolean z5 = (cls == cls3 && cls2 == cls3) ? false : true;
            if (z3) {
                return z4 ? new C0453A(enumC0511z2, enumC0511z4, cls, cls2) : new C0453A(enumC0511z2, enumC0511z5, cls, cls2);
            }
            if (z4) {
                return new C0453A(enumC0511z3, enumC0511z4, cls, cls2);
            }
            if (z5) {
                return new C0453A(enumC0511z3, enumC0511z5, cls, cls2);
            }
        }
        return this;
    }

    /* JADX INFO: renamed from: b */
    public final C0453A m990b(EnumC0511z enumC0511z) {
        if (enumC0511z == this.f1096e) {
            return this;
        }
        return new C0453A(enumC0511z, this.f1097f, this.f1098g, this.f1099h);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C0453A.class) {
            return false;
        }
        C0453A c0453a = (C0453A) obj;
        return c0453a.f1096e == this.f1096e && c0453a.f1097f == this.f1097f && c0453a.f1098g == this.f1098g && c0453a.f1099h == this.f1099h;
    }

    public final int hashCode() {
        return this.f1097f.hashCode() + (this.f1096e.hashCode() << 2);
    }

    public Object readResolve() {
        EnumC0511z enumC0511z = EnumC0511z.f1186i;
        return (this.f1096e == enumC0511z && this.f1097f == enumC0511z && this.f1098g == null && this.f1099h == null) ? f1095i : this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(80);
        sb.append("JsonInclude.Value(value=");
        sb.append(this.f1096e);
        sb.append(",content=");
        sb.append(this.f1097f);
        Class cls = this.f1098g;
        if (cls != null) {
            sb.append(",valueFilter=");
            sb.append(cls.getName());
            sb.append(".class");
        }
        Class cls2 = this.f1099h;
        if (cls2 != null) {
            sb.append(",contentFilter=");
            sb.append(cls2.getName());
            sb.append(".class");
        }
        sb.append(')');
        return sb.toString();
    }
}
