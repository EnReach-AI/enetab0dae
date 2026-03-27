package p100g1;

import java.io.Serializable;
import java.util.Objects;
import p005B.AbstractC0032g;

/* JADX INFO: renamed from: g1.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1394c implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final Class f5024e;

    /* JADX INFO: renamed from: f */
    public final int f5025f;

    /* JADX INFO: renamed from: g */
    public final String f5026g;

    public C1394c(Class cls, String str) {
        this.f5024e = cls;
        this.f5025f = cls.getName().hashCode() + (str == null ? 0 : str.hashCode());
        this.f5026g = (str == null || str.isEmpty()) ? null : str;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3395a() {
        return this.f5026g != null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C1394c.class) {
            return false;
        }
        C1394c c1394c = (C1394c) obj;
        return this.f5024e == c1394c.f5024e && Objects.equals(this.f5026g, c1394c.f5026g);
    }

    public final int hashCode() {
        return this.f5025f;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[NamedType, class ");
        sb.append(this.f5024e.getName());
        sb.append(", name: ");
        return AbstractC0032g.m157o(sb, this.f5026g == null ? "null" : AbstractC0032g.m157o(new StringBuilder("'"), this.f5026g, "'"), "]");
    }
}
