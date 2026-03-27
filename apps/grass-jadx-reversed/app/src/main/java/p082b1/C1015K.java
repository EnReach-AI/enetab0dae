package p082b1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: b1.K */
/* JADX INFO: loaded from: classes.dex */
public final class C1015K {

    /* JADX INFO: renamed from: c */
    public static final Class[] f3605c = new Class[0];

    /* JADX INFO: renamed from: a */
    public final String f3606a;

    /* JADX INFO: renamed from: b */
    public final Class[] f3607b;

    public C1015K(Method method) {
        this(method.getName(), method.getParameterTypes());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C1015K.class) {
            return false;
        }
        C1015K c1015k = (C1015K) obj;
        if (!this.f3606a.equals(c1015k.f3606a)) {
            return false;
        }
        Class[] clsArr = this.f3607b;
        int length = clsArr.length;
        Class[] clsArr2 = c1015k.f3607b;
        if (clsArr2.length != length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (clsArr2[i3] != clsArr[i3]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.f3606a.hashCode() + this.f3607b.length;
    }

    public final String toString() {
        return this.f3606a + "(" + this.f3607b.length + "-args)";
    }

    public C1015K(Constructor constructor) {
        this("", constructor.getParameterTypes());
    }

    public C1015K(String str, Class[] clsArr) {
        this.f3606a = str;
        this.f3607b = clsArr == null ? f3605c : clsArr;
    }
}
