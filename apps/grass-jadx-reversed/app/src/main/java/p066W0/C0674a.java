package p066W0;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: renamed from: W0.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0674a {

    /* JADX INFO: renamed from: c */
    public static final int[] f1832c = {8000, 8000, 2000, 2000};

    /* JADX INFO: renamed from: d */
    public static final int[] f1833d = {4000, 4000, 200, 200};

    /* JADX INFO: renamed from: a */
    public final AtomicReferenceArray f1834a = new AtomicReferenceArray(4);

    /* JADX INFO: renamed from: b */
    public final AtomicReferenceArray f1835b = new AtomicReferenceArray(4);

    /* JADX INFO: renamed from: a */
    public final byte[] m1632a(int i3) {
        int i4 = f1832c[i3];
        if (i4 <= 0) {
            i4 = 0;
        }
        byte[] bArr = (byte[]) this.f1834a.getAndSet(i3, null);
        return (bArr == null || bArr.length < i4) ? new byte[i4] : bArr;
    }

    /* JADX INFO: renamed from: b */
    public final char[] m1633b(int i3, int i4) {
        int i5 = f1833d[i3];
        if (i4 < i5) {
            i4 = i5;
        }
        char[] cArr = (char[]) this.f1835b.getAndSet(i3, null);
        return (cArr == null || cArr.length < i4) ? new char[i4] : cArr;
    }
}
