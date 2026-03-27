package p136r;

import java.util.Arrays;
import p026I.C0296d;
import p125o0.C1803m;
import p140s.C1863c;

/* JADX INFO: renamed from: r.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1846e {

    /* JADX INFO: renamed from: o */
    public static int f6376o = 1000;

    /* JADX INFO: renamed from: p */
    public static boolean f6377p = true;

    /* JADX INFO: renamed from: b */
    public final C1848g f6379b;

    /* JADX INFO: renamed from: e */
    public C1844c[] f6382e;

    /* JADX INFO: renamed from: k */
    public final C1803m f6388k;

    /* JADX INFO: renamed from: n */
    public C1844c f6391n;

    /* JADX INFO: renamed from: a */
    public int f6378a = 0;

    /* JADX INFO: renamed from: c */
    public int f6380c = 32;

    /* JADX INFO: renamed from: d */
    public int f6381d = 32;

    /* JADX INFO: renamed from: f */
    public boolean f6383f = false;

    /* JADX INFO: renamed from: g */
    public boolean[] f6384g = new boolean[32];

    /* JADX INFO: renamed from: h */
    public int f6385h = 1;

    /* JADX INFO: renamed from: i */
    public int f6386i = 0;

    /* JADX INFO: renamed from: j */
    public int f6387j = 32;

    /* JADX INFO: renamed from: l */
    public C1850i[] f6389l = new C1850i[f6376o];

    /* JADX INFO: renamed from: m */
    public int f6390m = 0;

    public C1846e() {
        this.f6382e = null;
        this.f6382e = new C1844c[32];
        m4113q();
        C1803m c1803m = new C1803m();
        c1803m.f6220f = new C0296d();
        c1803m.f6221g = new C0296d();
        c1803m.f6222h = new C0296d();
        c1803m.f6219e = new C1850i[32];
        this.f6388k = c1803m;
        C1848g c1848g = new C1848g(c1803m);
        c1848g.f6394f = new C1850i[128];
        c1848g.f6395g = new C1850i[128];
        c1848g.f6396h = 0;
        c1848g.f6397i = new C1847f(c1848g);
        this.f6379b = c1848g;
        if (f6377p) {
            this.f6391n = new C1845d(c1803m);
        } else {
            this.f6391n = new C1844c(c1803m);
        }
    }

    /* JADX INFO: renamed from: m */
    public static int m4097m(Object obj) {
        C1850i c1850i = ((C1863c) obj).f6461g;
        if (c1850i != null) {
            return (int) (c1850i.f6403e + 0.5f);
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public final C1850i m4098a(int i3) {
        C1850i c1850i = (C1850i) ((C0296d) this.f6388k.f6222h).mo571a();
        if (c1850i == null) {
            c1850i = new C1850i(i3);
            c1850i.f6410l = i3;
        } else {
            c1850i.m4121c();
            c1850i.f6410l = i3;
        }
        int i4 = this.f6390m;
        int i5 = f6376o;
        if (i4 >= i5) {
            int i6 = i5 * 2;
            f6376o = i6;
            this.f6389l = (C1850i[]) Arrays.copyOf(this.f6389l, i6);
        }
        C1850i[] c1850iArr = this.f6389l;
        int i7 = this.f6390m;
        this.f6390m = i7 + 1;
        c1850iArr[i7] = c1850i;
        return c1850i;
    }

    /* JADX INFO: renamed from: b */
    public final void m4099b(C1850i c1850i, C1850i c1850i2, int i3, float f3, C1850i c1850i3, C1850i c1850i4, int i4, int i5) {
        C1844c c1844cM4108k = m4108k();
        if (c1850i2 == c1850i3) {
            c1844cM4108k.f6374d.mo4085h(c1850i, 1.0f);
            c1844cM4108k.f6374d.mo4085h(c1850i4, 1.0f);
            c1844cM4108k.f6374d.mo4085h(c1850i2, -2.0f);
        } else if (f3 == 0.5f) {
            c1844cM4108k.f6374d.mo4085h(c1850i, 1.0f);
            c1844cM4108k.f6374d.mo4085h(c1850i2, -1.0f);
            c1844cM4108k.f6374d.mo4085h(c1850i3, -1.0f);
            c1844cM4108k.f6374d.mo4085h(c1850i4, 1.0f);
            if (i3 > 0 || i4 > 0) {
                c1844cM4108k.f6372b = (-i3) + i4;
            }
        } else if (f3 <= 0.0f) {
            c1844cM4108k.f6374d.mo4085h(c1850i, -1.0f);
            c1844cM4108k.f6374d.mo4085h(c1850i2, 1.0f);
            c1844cM4108k.f6372b = i3;
        } else if (f3 >= 1.0f) {
            c1844cM4108k.f6374d.mo4085h(c1850i4, -1.0f);
            c1844cM4108k.f6374d.mo4085h(c1850i3, 1.0f);
            c1844cM4108k.f6372b = -i4;
        } else {
            float f4 = 1.0f - f3;
            c1844cM4108k.f6374d.mo4085h(c1850i, f4 * 1.0f);
            c1844cM4108k.f6374d.mo4085h(c1850i2, f4 * (-1.0f));
            c1844cM4108k.f6374d.mo4085h(c1850i3, (-1.0f) * f3);
            c1844cM4108k.f6374d.mo4085h(c1850i4, 1.0f * f3);
            if (i3 > 0 || i4 > 0) {
                c1844cM4108k.f6372b = (i4 * f3) + ((-i3) * f4);
            }
        }
        if (i5 != 8) {
            c1844cM4108k.m4089a(this, i5);
        }
        m4100c(c1844cM4108k);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00de  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m4100c(p136r.C1844c r17) {
        /*
            Method dump skipped, instruction units count: 415
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p136r.C1846e.m4100c(r.c):void");
    }

    /* JADX INFO: renamed from: d */
    public final void m4101d(C1850i c1850i, int i3) {
        int i4 = c1850i.f6401c;
        if (i4 == -1) {
            c1850i.f6403e = i3;
            c1850i.f6404f = true;
            int i5 = c1850i.f6408j;
            for (int i6 = 0; i6 < i5; i6++) {
                c1850i.f6407i[i6].m4095g(c1850i, false);
            }
            c1850i.f6408j = 0;
            return;
        }
        if (i4 == -1) {
            C1844c c1844cM4108k = m4108k();
            c1844cM4108k.f6371a = c1850i;
            float f3 = i3;
            c1850i.f6403e = f3;
            c1844cM4108k.f6372b = f3;
            c1844cM4108k.f6375e = true;
            m4100c(c1844cM4108k);
            return;
        }
        C1844c c1844c = this.f6382e[i4];
        if (c1844c.f6375e) {
            c1844c.f6372b = i3;
            return;
        }
        if (c1844c.f6374d.mo4088k() == 0) {
            c1844c.f6375e = true;
            c1844c.f6372b = i3;
            return;
        }
        C1844c c1844cM4108k2 = m4108k();
        if (i3 < 0) {
            c1844cM4108k2.f6372b = i3 * (-1);
            c1844cM4108k2.f6374d.mo4085h(c1850i, 1.0f);
        } else {
            c1844cM4108k2.f6372b = i3;
            c1844cM4108k2.f6374d.mo4085h(c1850i, -1.0f);
        }
        m4100c(c1844cM4108k2);
    }

    /* JADX INFO: renamed from: e */
    public final void m4102e(C1850i c1850i, C1850i c1850i2, int i3, int i4) {
        boolean z3 = false;
        if (i4 == 8 && c1850i2.f6404f && c1850i.f6401c == -1) {
            c1850i.f6403e = c1850i2.f6403e + i3;
            c1850i.f6404f = true;
            int i5 = c1850i.f6408j;
            for (int i6 = 0; i6 < i5; i6++) {
                c1850i.f6407i[i6].m4095g(c1850i, false);
            }
            c1850i.f6408j = 0;
            return;
        }
        C1844c c1844cM4108k = m4108k();
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z3 = true;
            }
            c1844cM4108k.f6372b = i3;
        }
        if (z3) {
            c1844cM4108k.f6374d.mo4085h(c1850i, 1.0f);
            c1844cM4108k.f6374d.mo4085h(c1850i2, -1.0f);
        } else {
            c1844cM4108k.f6374d.mo4085h(c1850i, -1.0f);
            c1844cM4108k.f6374d.mo4085h(c1850i2, 1.0f);
        }
        if (i4 != 8) {
            c1844cM4108k.m4089a(this, i4);
        }
        m4100c(c1844cM4108k);
    }

    /* JADX INFO: renamed from: f */
    public final void m4103f(C1850i c1850i, C1850i c1850i2, int i3, int i4) {
        C1844c c1844cM4108k = m4108k();
        C1850i c1850iM4109l = m4109l();
        c1850iM4109l.f6402d = 0;
        c1844cM4108k.m4090b(c1850i, c1850i2, c1850iM4109l, i3);
        if (i4 != 8) {
            c1844cM4108k.f6374d.mo4085h(m4106i(i4), (int) (c1844cM4108k.f6374d.mo4080c(c1850iM4109l) * (-1.0f)));
        }
        m4100c(c1844cM4108k);
    }

    /* JADX INFO: renamed from: g */
    public final void m4104g(C1850i c1850i, C1850i c1850i2, int i3, int i4) {
        C1844c c1844cM4108k = m4108k();
        C1850i c1850iM4109l = m4109l();
        c1850iM4109l.f6402d = 0;
        c1844cM4108k.m4091c(c1850i, c1850i2, c1850iM4109l, i3);
        if (i4 != 8) {
            c1844cM4108k.f6374d.mo4085h(m4106i(i4), (int) (c1844cM4108k.f6374d.mo4080c(c1850iM4109l) * (-1.0f)));
        }
        m4100c(c1844cM4108k);
    }

    /* JADX INFO: renamed from: h */
    public final void m4105h(C1844c c1844c) {
        boolean z3 = f6377p;
        C1803m c1803m = this.f6388k;
        if (z3) {
            C1844c c1844c2 = this.f6382e[this.f6386i];
            if (c1844c2 != null) {
                ((C0296d) c1803m.f6220f).m572b(c1844c2);
            }
        } else {
            C1844c c1844c3 = this.f6382e[this.f6386i];
            if (c1844c3 != null) {
                ((C0296d) c1803m.f6221g).m572b(c1844c3);
            }
        }
        C1844c[] c1844cArr = this.f6382e;
        int i3 = this.f6386i;
        c1844cArr[i3] = c1844c;
        C1850i c1850i = c1844c.f6371a;
        c1850i.f6401c = i3;
        this.f6386i = i3 + 1;
        c1850i.m4122d(c1844c);
    }

    /* JADX INFO: renamed from: i */
    public final C1850i m4106i(int i3) {
        if (this.f6385h + 1 >= this.f6381d) {
            m4110n();
        }
        C1850i c1850iM4098a = m4098a(4);
        int i4 = this.f6378a + 1;
        this.f6378a = i4;
        this.f6385h++;
        c1850iM4098a.f6400b = i4;
        c1850iM4098a.f6402d = i3;
        ((C1850i[]) this.f6388k.f6219e)[i4] = c1850iM4098a;
        C1848g c1848g = this.f6379b;
        c1848g.f6397i.f6392e = c1850iM4098a;
        float[] fArr = c1850iM4098a.f6406h;
        Arrays.fill(fArr, 0.0f);
        fArr[c1850iM4098a.f6402d] = 1.0f;
        c1848g.m4115i(c1850iM4098a);
        return c1850iM4098a;
    }

    /* JADX INFO: renamed from: j */
    public final C1850i m4107j(Object obj) {
        C1850i c1850i = null;
        if (obj == null) {
            return null;
        }
        if (this.f6385h + 1 >= this.f6381d) {
            m4110n();
        }
        if (obj instanceof C1863c) {
            C1863c c1863c = (C1863c) obj;
            c1850i = c1863c.f6461g;
            if (c1850i == null) {
                c1863c.m4145i();
                c1850i = c1863c.f6461g;
            }
            int i3 = c1850i.f6400b;
            C1803m c1803m = this.f6388k;
            if (i3 == -1 || i3 > this.f6378a || ((C1850i[]) c1803m.f6219e)[i3] == null) {
                if (i3 != -1) {
                    c1850i.m4121c();
                }
                int i4 = this.f6378a + 1;
                this.f6378a = i4;
                this.f6385h++;
                c1850i.f6400b = i4;
                c1850i.f6410l = 1;
                ((C1850i[]) c1803m.f6219e)[i4] = c1850i;
            }
        }
        return c1850i;
    }

    /* JADX INFO: renamed from: k */
    public final C1844c m4108k() {
        boolean z3 = f6377p;
        C1803m c1803m = this.f6388k;
        if (z3) {
            C1844c c1844c = (C1844c) ((C0296d) c1803m.f6220f).mo571a();
            if (c1844c == null) {
                return new C1845d(c1803m);
            }
            c1844c.f6371a = null;
            c1844c.f6374d.clear();
            c1844c.f6372b = 0.0f;
            c1844c.f6375e = false;
            return c1844c;
        }
        C1844c c1844c2 = (C1844c) ((C0296d) c1803m.f6221g).mo571a();
        if (c1844c2 == null) {
            return new C1844c(c1803m);
        }
        c1844c2.f6371a = null;
        c1844c2.f6374d.clear();
        c1844c2.f6372b = 0.0f;
        c1844c2.f6375e = false;
        return c1844c2;
    }

    /* JADX INFO: renamed from: l */
    public final C1850i m4109l() {
        if (this.f6385h + 1 >= this.f6381d) {
            m4110n();
        }
        C1850i c1850iM4098a = m4098a(3);
        int i3 = this.f6378a + 1;
        this.f6378a = i3;
        this.f6385h++;
        c1850iM4098a.f6400b = i3;
        ((C1850i[]) this.f6388k.f6219e)[i3] = c1850iM4098a;
        return c1850iM4098a;
    }

    /* JADX INFO: renamed from: n */
    public final void m4110n() {
        int i3 = this.f6380c * 2;
        this.f6380c = i3;
        this.f6382e = (C1844c[]) Arrays.copyOf(this.f6382e, i3);
        C1803m c1803m = this.f6388k;
        c1803m.f6219e = (C1850i[]) Arrays.copyOf((C1850i[]) c1803m.f6219e, this.f6380c);
        int i4 = this.f6380c;
        this.f6384g = new boolean[i4];
        this.f6381d = i4;
        this.f6387j = i4;
    }

    /* JADX INFO: renamed from: o */
    public final void m4111o(C1848g c1848g) {
        C1803m c1803m;
        int i3 = 0;
        while (true) {
            if (i3 >= this.f6386i) {
                break;
            }
            C1844c c1844c = this.f6382e[i3];
            int i4 = 1;
            if (c1844c.f6371a.f6410l != 1) {
                float f3 = 0.0f;
                if (c1844c.f6372b < 0.0f) {
                    boolean z3 = false;
                    int i5 = 0;
                    while (!z3) {
                        i5 += i4;
                        float f4 = Float.MAX_VALUE;
                        int i6 = -1;
                        int i7 = -1;
                        int i8 = 0;
                        int i9 = 0;
                        while (true) {
                            int i10 = this.f6386i;
                            c1803m = this.f6388k;
                            if (i8 >= i10) {
                                break;
                            }
                            C1844c c1844c2 = this.f6382e[i8];
                            if (c1844c2.f6371a.f6410l != i4 && !c1844c2.f6375e && c1844c2.f6372b < f3) {
                                int i11 = i4;
                                while (i11 < this.f6385h) {
                                    C1850i c1850i = ((C1850i[]) c1803m.f6219e)[i11];
                                    float fMo4080c = c1844c2.f6374d.mo4080c(c1850i);
                                    if (fMo4080c > f3) {
                                        for (int i12 = 0; i12 < 9; i12++) {
                                            float f5 = c1850i.f6405g[i12] / fMo4080c;
                                            if ((f5 < f4 && i12 == i9) || i12 > i9) {
                                                i9 = i12;
                                                f4 = f5;
                                                i6 = i8;
                                                i7 = i11;
                                            }
                                        }
                                    }
                                    i11++;
                                    f3 = 0.0f;
                                }
                            }
                            i8++;
                            f3 = 0.0f;
                            i4 = 1;
                        }
                        if (i6 != -1) {
                            C1844c c1844c3 = this.f6382e[i6];
                            c1844c3.f6371a.f6401c = -1;
                            c1844c3.m4094f(((C1850i[]) c1803m.f6219e)[i7]);
                            C1850i c1850i2 = c1844c3.f6371a;
                            c1850i2.f6401c = i6;
                            c1850i2.m4122d(c1844c3);
                        } else {
                            z3 = true;
                        }
                        if (i5 > this.f6385h / 2) {
                            z3 = true;
                        }
                        f3 = 0.0f;
                        i4 = 1;
                    }
                }
            }
            i3++;
        }
        m4112p(c1848g);
        for (int i13 = 0; i13 < this.f6386i; i13++) {
            C1844c c1844c4 = this.f6382e[i13];
            c1844c4.f6371a.f6403e = c1844c4.f6372b;
        }
    }

    /* JADX INFO: renamed from: p */
    public final void m4112p(C1844c c1844c) {
        for (int i3 = 0; i3 < this.f6385h; i3++) {
            this.f6384g[i3] = false;
        }
        boolean z3 = false;
        int i4 = 0;
        while (!z3) {
            i4++;
            if (i4 >= this.f6385h * 2) {
                return;
            }
            C1850i c1850i = c1844c.f6371a;
            if (c1850i != null) {
                this.f6384g[c1850i.f6400b] = true;
            }
            C1850i c1850iMo4092d = c1844c.mo4092d(this.f6384g);
            if (c1850iMo4092d != null) {
                boolean[] zArr = this.f6384g;
                int i5 = c1850iMo4092d.f6400b;
                if (zArr[i5]) {
                    return;
                } else {
                    zArr[i5] = true;
                }
            }
            if (c1850iMo4092d != null) {
                float f3 = Float.MAX_VALUE;
                int i6 = -1;
                for (int i7 = 0; i7 < this.f6386i; i7++) {
                    C1844c c1844c2 = this.f6382e[i7];
                    if (c1844c2.f6371a.f6410l != 1 && !c1844c2.f6375e && c1844c2.f6374d.mo4079b(c1850iMo4092d)) {
                        float fMo4080c = c1844c2.f6374d.mo4080c(c1850iMo4092d);
                        if (fMo4080c < 0.0f) {
                            float f4 = (-c1844c2.f6372b) / fMo4080c;
                            if (f4 < f3) {
                                i6 = i7;
                                f3 = f4;
                            }
                        }
                    }
                }
                if (i6 > -1) {
                    C1844c c1844c3 = this.f6382e[i6];
                    c1844c3.f6371a.f6401c = -1;
                    c1844c3.m4094f(c1850iMo4092d);
                    C1850i c1850i2 = c1844c3.f6371a;
                    c1850i2.f6401c = i6;
                    c1850i2.m4122d(c1844c3);
                }
            } else {
                z3 = true;
            }
        }
    }

    /* JADX INFO: renamed from: q */
    public final void m4113q() {
        boolean z3 = f6377p;
        C1803m c1803m = this.f6388k;
        int i3 = 0;
        if (z3) {
            while (true) {
                C1844c[] c1844cArr = this.f6382e;
                if (i3 >= c1844cArr.length) {
                    return;
                }
                C1844c c1844c = c1844cArr[i3];
                if (c1844c != null) {
                    ((C0296d) c1803m.f6220f).m572b(c1844c);
                }
                this.f6382e[i3] = null;
                i3++;
            }
        } else {
            while (true) {
                C1844c[] c1844cArr2 = this.f6382e;
                if (i3 >= c1844cArr2.length) {
                    return;
                }
                C1844c c1844c2 = c1844cArr2[i3];
                if (c1844c2 != null) {
                    ((C0296d) c1803m.f6221g).m572b(c1844c2);
                }
                this.f6382e[i3] = null;
                i3++;
            }
        }
    }

    /* JADX INFO: renamed from: r */
    public final void m4114r() {
        C1803m c1803m;
        int i3 = 0;
        while (true) {
            c1803m = this.f6388k;
            C1850i[] c1850iArr = (C1850i[]) c1803m.f6219e;
            if (i3 >= c1850iArr.length) {
                break;
            }
            C1850i c1850i = c1850iArr[i3];
            if (c1850i != null) {
                c1850i.m4121c();
            }
            i3++;
        }
        C0296d c0296d = (C0296d) c1803m.f6222h;
        C1850i[] c1850iArr2 = this.f6389l;
        int length = this.f6390m;
        c0296d.getClass();
        if (length > c1850iArr2.length) {
            length = c1850iArr2.length;
        }
        for (int i4 = 0; i4 < length; i4++) {
            C1850i c1850i2 = c1850iArr2[i4];
            int i5 = c0296d.f797c;
            Object[] objArr = c0296d.f796b;
            if (i5 < objArr.length) {
                objArr[i5] = c1850i2;
                c0296d.f797c = i5 + 1;
            }
        }
        this.f6390m = 0;
        Arrays.fill((C1850i[]) c1803m.f6219e, (Object) null);
        this.f6378a = 0;
        C1848g c1848g = this.f6379b;
        c1848g.f6396h = 0;
        c1848g.f6372b = 0.0f;
        this.f6385h = 1;
        for (int i6 = 0; i6 < this.f6386i; i6++) {
            this.f6382e[i6].getClass();
        }
        m4113q();
        this.f6386i = 0;
        if (f6377p) {
            this.f6391n = new C1845d(c1803m);
        } else {
            this.f6391n = new C1844c(c1803m);
        }
    }
}
