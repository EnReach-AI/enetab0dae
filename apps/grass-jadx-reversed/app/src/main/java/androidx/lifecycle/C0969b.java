package androidx.lifecycle;

import java.lang.reflect.Method;

/* JADX INFO: renamed from: androidx.lifecycle.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0969b {

    /* JADX INFO: renamed from: a */
    public final int f3310a;

    /* JADX INFO: renamed from: b */
    public final Method f3311b;

    public C0969b(int i3, Method method) {
        this.f3310a = i3;
        this.f3311b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0969b)) {
            return false;
        }
        C0969b c0969b = (C0969b) obj;
        return this.f3310a == c0969b.f3310a && this.f3311b.getName().equals(c0969b.f3311b.getName());
    }

    public final int hashCode() {
        return this.f3311b.getName().hashCode() + (this.f3310a * 31);
    }
}
