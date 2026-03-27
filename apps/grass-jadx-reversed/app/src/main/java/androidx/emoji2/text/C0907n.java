package androidx.emoji2.text;

import android.util.SparseArray;
import java.nio.ByteBuffer;
import p052R.C0603a;

/* JADX INFO: renamed from: androidx.emoji2.text.n */
/* JADX INFO: loaded from: classes.dex */
public final class C0907n {

    /* JADX INFO: renamed from: a */
    public int f2991a = 1;

    /* JADX INFO: renamed from: b */
    public final C0910q f2992b;

    /* JADX INFO: renamed from: c */
    public C0910q f2993c;

    /* JADX INFO: renamed from: d */
    public C0910q f2994d;

    /* JADX INFO: renamed from: e */
    public int f2995e;

    /* JADX INFO: renamed from: f */
    public int f2996f;

    public C0907n(C0910q c0910q) {
        this.f2992b = c0910q;
        this.f2993c = c0910q;
    }

    /* JADX INFO: renamed from: a */
    public final int m2351a(int i3) {
        SparseArray sparseArray = this.f2993c.f3006a;
        C0910q c0910q = sparseArray == null ? null : (C0910q) sparseArray.get(i3);
        int i4 = 1;
        int i5 = 2;
        if (this.f2991a == 2) {
            if (c0910q != null) {
                this.f2993c = c0910q;
                this.f2996f++;
            } else if (i3 == 65038) {
                m2352b();
            } else if (i3 != 65039) {
                C0910q c0910q2 = this.f2993c;
                if (c0910q2.f3007b != null) {
                    i5 = 3;
                    if (this.f2996f != 1) {
                        this.f2994d = c0910q2;
                        m2352b();
                    } else if (m2353c()) {
                        this.f2994d = this.f2993c;
                        m2352b();
                    } else {
                        m2352b();
                    }
                } else {
                    m2352b();
                }
            }
            i4 = i5;
        } else if (c0910q == null) {
            m2352b();
        } else {
            this.f2991a = 2;
            this.f2993c = c0910q;
            this.f2996f = 1;
            i4 = i5;
        }
        this.f2995e = i3;
        return i4;
    }

    /* JADX INFO: renamed from: b */
    public final void m2352b() {
        this.f2991a = 1;
        this.f2993c = this.f2992b;
        this.f2996f = 0;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m2353c() {
        C0603a c0603aM2350c = this.f2993c.f3007b.m2350c();
        int iM843a = c0603aM2350c.m843a(6);
        return !(iM843a == 0 || ((ByteBuffer) c0603aM2350c.f888d).get(iM843a + c0603aM2350c.f885a) == 0) || this.f2995e == 65039;
    }
}
