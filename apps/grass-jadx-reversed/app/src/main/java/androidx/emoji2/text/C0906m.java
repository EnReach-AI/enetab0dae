package androidx.emoji2.text;

import java.nio.ByteBuffer;
import p052R.C0603a;
import p052R.C0604b;
import p125o0.C1803m;

/* JADX INFO: renamed from: androidx.emoji2.text.m */
/* JADX INFO: loaded from: classes.dex */
public final class C0906m {

    /* JADX INFO: renamed from: d */
    public static final ThreadLocal f2987d = new ThreadLocal();

    /* JADX INFO: renamed from: a */
    public final int f2988a;

    /* JADX INFO: renamed from: b */
    public final C1803m f2989b;

    /* JADX INFO: renamed from: c */
    public volatile int f2990c = 0;

    public C0906m(C1803m c1803m, int i3) {
        this.f2989b = c1803m;
        this.f2988a = i3;
    }

    /* JADX INFO: renamed from: a */
    public final int m2348a(int i3) {
        C0603a c0603aM2350c = m2350c();
        int iM843a = c0603aM2350c.m843a(16);
        if (iM843a == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) c0603aM2350c.f888d;
        int i4 = iM843a + c0603aM2350c.f885a;
        return byteBuffer.getInt((i3 * 4) + byteBuffer.getInt(i4) + i4 + 4);
    }

    /* JADX INFO: renamed from: b */
    public final int m2349b() {
        C0603a c0603aM2350c = m2350c();
        int iM843a = c0603aM2350c.m843a(16);
        if (iM843a == 0) {
            return 0;
        }
        int i3 = iM843a + c0603aM2350c.f885a;
        return ((ByteBuffer) c0603aM2350c.f888d).getInt(((ByteBuffer) c0603aM2350c.f888d).getInt(i3) + i3);
    }

    /* JADX INFO: renamed from: c */
    public final C0603a m2350c() {
        ThreadLocal threadLocal = f2987d;
        C0603a c0603a = (C0603a) threadLocal.get();
        if (c0603a == null) {
            c0603a = new C0603a();
            threadLocal.set(c0603a);
        }
        C0604b c0604b = (C0604b) this.f2989b.f6220f;
        int iM843a = c0604b.m843a(6);
        if (iM843a != 0) {
            int i3 = iM843a + c0604b.f885a;
            int i4 = (this.f2988a * 4) + ((ByteBuffer) c0604b.f888d).getInt(i3) + i3 + 4;
            int i5 = ((ByteBuffer) c0604b.f888d).getInt(i4) + i4;
            ByteBuffer byteBuffer = (ByteBuffer) c0604b.f888d;
            c0603a.f888d = byteBuffer;
            if (byteBuffer != null) {
                c0603a.f885a = i5;
                int i6 = i5 - byteBuffer.getInt(i5);
                c0603a.f886b = i6;
                c0603a.f887c = ((ByteBuffer) c0603a.f888d).getShort(i6);
            } else {
                c0603a.f885a = 0;
                c0603a.f886b = 0;
                c0603a.f887c = 0;
            }
        }
        return c0603a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        C0603a c0603aM2350c = m2350c();
        int iM843a = c0603aM2350c.m843a(4);
        sb.append(Integer.toHexString(iM843a != 0 ? ((ByteBuffer) c0603aM2350c.f888d).getInt(iM843a + c0603aM2350c.f885a) : 0));
        sb.append(", codepoints:");
        int iM2349b = m2349b();
        for (int i3 = 0; i3 < iM2349b; i3++) {
            sb.append(Integer.toHexString(m2348a(i3)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
