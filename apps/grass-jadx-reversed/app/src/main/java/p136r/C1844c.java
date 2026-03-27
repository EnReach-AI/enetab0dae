package p136r;

import java.util.ArrayList;
import p125o0.C1803m;

/* JADX INFO: renamed from: r.c */
/* JADX INFO: loaded from: classes.dex */
public class C1844c {

    /* JADX INFO: renamed from: d */
    public InterfaceC1843b f6374d;

    /* JADX INFO: renamed from: a */
    public C1850i f6371a = null;

    /* JADX INFO: renamed from: b */
    public float f6372b = 0.0f;

    /* JADX INFO: renamed from: c */
    public ArrayList f6373c = new ArrayList();

    /* JADX INFO: renamed from: e */
    public boolean f6375e = false;

    public C1844c(C1803m c1803m) {
        this.f6374d = new C1842a(this, c1803m);
    }

    /* JADX INFO: renamed from: a */
    public final void m4089a(C1846e c1846e, int i3) {
        this.f6374d.mo4085h(c1846e.m4106i(i3), 1.0f);
        this.f6374d.mo4085h(c1846e.m4106i(i3), -1.0f);
    }

    /* JADX INFO: renamed from: b */
    public final void m4090b(C1850i c1850i, C1850i c1850i2, C1850i c1850i3, int i3) {
        boolean z3 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z3 = true;
            }
            this.f6372b = i3;
        }
        if (z3) {
            this.f6374d.mo4085h(c1850i, 1.0f);
            this.f6374d.mo4085h(c1850i2, -1.0f);
            this.f6374d.mo4085h(c1850i3, -1.0f);
        } else {
            this.f6374d.mo4085h(c1850i, -1.0f);
            this.f6374d.mo4085h(c1850i2, 1.0f);
            this.f6374d.mo4085h(c1850i3, 1.0f);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m4091c(C1850i c1850i, C1850i c1850i2, C1850i c1850i3, int i3) {
        boolean z3 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z3 = true;
            }
            this.f6372b = i3;
        }
        if (z3) {
            this.f6374d.mo4085h(c1850i, 1.0f);
            this.f6374d.mo4085h(c1850i2, -1.0f);
            this.f6374d.mo4085h(c1850i3, 1.0f);
        } else {
            this.f6374d.mo4085h(c1850i, -1.0f);
            this.f6374d.mo4085h(c1850i2, 1.0f);
            this.f6374d.mo4085h(c1850i3, -1.0f);
        }
    }

    /* JADX INFO: renamed from: d */
    public C1850i mo4092d(boolean[] zArr) {
        return m4093e(zArr, null);
    }

    /* JADX INFO: renamed from: e */
    public final C1850i m4093e(boolean[] zArr, C1850i c1850i) {
        int i3;
        int iMo4088k = this.f6374d.mo4088k();
        C1850i c1850i2 = null;
        float f3 = 0.0f;
        for (int i4 = 0; i4 < iMo4088k; i4++) {
            float fMo4078a = this.f6374d.mo4078a(i4);
            if (fMo4078a < 0.0f) {
                C1850i c1850iMo4082e = this.f6374d.mo4082e(i4);
                if ((zArr == null || !zArr[c1850iMo4082e.f6400b]) && c1850iMo4082e != c1850i && (((i3 = c1850iMo4082e.f6410l) == 3 || i3 == 4) && fMo4078a < f3)) {
                    f3 = fMo4078a;
                    c1850i2 = c1850iMo4082e;
                }
            }
        }
        return c1850i2;
    }

    /* JADX INFO: renamed from: f */
    public final void m4094f(C1850i c1850i) {
        C1850i c1850i2 = this.f6371a;
        if (c1850i2 != null) {
            this.f6374d.mo4085h(c1850i2, -1.0f);
            this.f6371a = null;
        }
        float fMo4081d = this.f6374d.mo4081d(c1850i, true) * (-1.0f);
        this.f6371a = c1850i;
        if (fMo4081d == 1.0f) {
            return;
        }
        this.f6372b /= fMo4081d;
        this.f6374d.mo4084g(fMo4081d);
    }

    /* JADX INFO: renamed from: g */
    public final void m4095g(C1850i c1850i, boolean z3) {
        if (c1850i.f6404f) {
            float fMo4080c = this.f6374d.mo4080c(c1850i);
            this.f6372b = (c1850i.f6403e * fMo4080c) + this.f6372b;
            this.f6374d.mo4081d(c1850i, z3);
            if (z3) {
                c1850i.m4120b(this);
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public void mo4096h(C1844c c1844c, boolean z3) {
        float fMo4086i = this.f6374d.mo4086i(c1844c, z3);
        this.f6372b = (c1844c.f6372b * fMo4086i) + this.f6372b;
        if (z3) {
            c1844c.f6371a.m4120b(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r10 = this;
            r.i r0 = r10.f6371a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            r.i r1 = r10.f6371a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = p136r.AbstractC1849h.m4117a(r0, r1)
            float r1 = r10.f6372b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L39
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r10.f6372b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = r3
            goto L3a
        L39:
            r1 = r4
        L3a:
            r.b r5 = r10.f6374d
            int r5 = r5.mo4088k()
        L40:
            if (r4 >= r5) goto La0
            r.b r6 = r10.f6374d
            r.i r6 = r6.mo4082e(r4)
            if (r6 != 0) goto L4b
            goto L9d
        L4b:
            r.b r7 = r10.f6374d
            float r7 = r7.mo4078a(r4)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L56
            goto L9d
        L56:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L6a
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L7a
            java.lang.String r1 = "- "
            java.lang.String r0 = p136r.AbstractC1849h.m4117a(r0, r1)
        L68:
            float r7 = r7 * r9
            goto L7a
        L6a:
            if (r8 <= 0) goto L73
            java.lang.String r1 = " + "
            java.lang.String r0 = p136r.AbstractC1849h.m4117a(r0, r1)
            goto L7a
        L73:
            java.lang.String r1 = " - "
            java.lang.String r0 = p136r.AbstractC1849h.m4117a(r0, r1)
            goto L68
        L7a:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L85
            java.lang.String r0 = p136r.AbstractC1849h.m4117a(r0, r6)
            goto L9c
        L85:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L9c:
            r1 = r3
        L9d:
            int r4 = r4 + 1
            goto L40
        La0:
            if (r1 != 0) goto La8
            java.lang.String r1 = "0.0"
            java.lang.String r0 = p136r.AbstractC1849h.m4117a(r0, r1)
        La8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p136r.C1844c.toString():java.lang.String");
    }
}
