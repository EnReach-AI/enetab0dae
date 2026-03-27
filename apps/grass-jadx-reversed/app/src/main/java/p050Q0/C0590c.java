package p050Q0;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URI;
import java.net.URL;
import java.util.Objects;

/* JADX INFO: renamed from: Q0.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0590c implements Serializable {

    /* JADX INFO: renamed from: g */
    public static final C0590c f1511g = new C0590c(null, false);
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final transient Object f1512e;

    /* JADX INFO: renamed from: f */
    public final boolean f1513f;

    public C0590c(Object obj, boolean z3) {
        this.f1513f = z3;
        this.f1512e = obj;
    }

    /* JADX INFO: renamed from: a */
    public static void m1337a(int[] iArr, int i3) {
        int i4 = iArr[0];
        if (i4 < 0) {
            i4 = 0;
        } else if (i4 >= i3) {
            i4 = i3;
        }
        iArr[0] = i4;
        int i5 = iArr[1];
        int i6 = i3 - i4;
        if (i5 < 0 || i5 > i6) {
            iArr[1] = i6;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof C0590c)) {
            return false;
        }
        Object obj2 = ((C0590c) obj).f1512e;
        Object obj3 = this.f1512e;
        if (obj3 == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return ((obj3 instanceof File) || (obj3 instanceof URL) || (obj3 instanceof URI)) ? obj3.equals(obj2) : obj3 == obj2;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f1512e);
    }

    public Object readResolve() {
        return f1511g;
    }
}
