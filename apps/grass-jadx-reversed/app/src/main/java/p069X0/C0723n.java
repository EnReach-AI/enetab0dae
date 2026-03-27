package p069X0;

import java.io.Serializable;

/* JADX INFO: renamed from: X0.n */
/* JADX INFO: loaded from: classes.dex */
public final class C0723n implements Serializable {
    private static final long serialVersionUID = 2;

    /* JADX INFO: renamed from: e */
    public transient Object f2041e;

    /* JADX INFO: renamed from: f */
    public final String f2042f;

    /* JADX INFO: renamed from: g */
    public int f2043g = -1;

    /* JADX INFO: renamed from: h */
    public String f2044h;

    public C0723n(String str, Object obj) {
        this.f2041e = obj;
        if (str == null) {
            throw new NullPointerException("Cannot pass null fieldName");
        }
        this.f2042f = str;
    }

    /* JADX INFO: renamed from: a */
    public final String m1892a() {
        if (this.f2044h == null) {
            StringBuilder sb = new StringBuilder();
            Object obj = this.f2041e;
            if (obj != null) {
                Class<?> componentType = obj instanceof Class ? (Class) obj : obj.getClass();
                int i3 = 0;
                while (componentType.isArray()) {
                    componentType = componentType.getComponentType();
                    i3++;
                }
                sb.append(componentType.getName());
                while (true) {
                    i3--;
                    if (i3 < 0) {
                        break;
                    }
                    sb.append("[]");
                }
            } else {
                sb.append("UNKNOWN");
            }
            sb.append('[');
            String str = this.f2042f;
            if (str != null) {
                sb.append('\"');
                sb.append(str);
                sb.append('\"');
            } else {
                int i4 = this.f2043g;
                if (i4 >= 0) {
                    sb.append(i4);
                } else {
                    sb.append('?');
                }
            }
            sb.append(']');
            this.f2044h = sb.toString();
        }
        return this.f2044h;
    }

    public final String toString() {
        return m1892a();
    }

    public Object writeReplace() {
        m1892a();
        return this;
    }
}
