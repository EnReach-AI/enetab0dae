package p050Q0;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import p042N0.InterfaceC0551s;

/* JADX INFO: renamed from: Q0.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0597j implements InterfaceC0551s, Serializable {

    /* JADX INFO: renamed from: j */
    public static final C0592e f1530j = C0592e.f1516c;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final String f1531e;

    /* JADX INFO: renamed from: f */
    public byte[] f1532f;

    /* JADX INFO: renamed from: g */
    public byte[] f1533g;

    /* JADX INFO: renamed from: h */
    public char[] f1534h;

    /* JADX INFO: renamed from: i */
    public transient String f1535i;

    public C0597j(String str) {
        if (str == null) {
            throw new IllegalStateException("Null String illegal for SerializedString");
        }
        this.f1531e = str;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.f1535i = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.f1531e);
    }

    /* JADX INFO: renamed from: a */
    public final int m1364a(byte[] bArr, int i3) {
        byte[] bArrM1342e = this.f1532f;
        if (bArrM1342e == null) {
            f1530j.getClass();
            bArrM1342e = C0592e.m1342e(this.f1531e);
            this.f1532f = bArrM1342e;
        }
        int length = bArrM1342e.length;
        if (i3 + length > bArr.length) {
            return -1;
        }
        System.arraycopy(bArrM1342e, 0, bArr, i3, length);
        return length;
    }

    /* JADX INFO: renamed from: b */
    public final char[] m1365b() {
        char[] cArr = this.f1534h;
        if (cArr != null) {
            return cArr;
        }
        f1530j.getClass();
        char[] cArrM1341d = C0592e.m1341d(this.f1531e);
        this.f1534h = cArrM1341d;
        return cArrM1341d;
    }

    /* JADX INFO: renamed from: c */
    public final byte[] m1366c() {
        byte[] bArr = this.f1532f;
        if (bArr != null) {
            return bArr;
        }
        f1530j.getClass();
        byte[] bArrM1342e = C0592e.m1342e(this.f1531e);
        this.f1532f = bArrM1342e;
        return bArrM1342e;
    }

    /* JADX INFO: renamed from: d */
    public final byte[] m1367d() {
        byte[] bArr = this.f1533g;
        if (bArr != null) {
            return bArr;
        }
        f1530j.getClass();
        byte[] bArrM1340c = C0592e.m1340c(this.f1531e);
        this.f1533g = bArrM1340c;
        return bArrM1340c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C0597j.class) {
            return false;
        }
        return this.f1531e.equals(((C0597j) obj).f1531e);
    }

    public final int hashCode() {
        return this.f1531e.hashCode();
    }

    public Object readResolve() {
        return new C0597j(this.f1535i);
    }

    public final String toString() {
        return this.f1531e;
    }
}
