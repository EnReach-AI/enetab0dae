package p136r;

import java.util.Arrays;
import p125o0.C1803m;

/* JADX INFO: renamed from: r.j */
/* JADX INFO: loaded from: classes.dex */
public final class C1851j implements InterfaceC1843b {

    /* JADX INFO: renamed from: a */
    public int f6411a = 16;

    /* JADX INFO: renamed from: b */
    public final int[] f6412b = new int[16];

    /* JADX INFO: renamed from: c */
    public int[] f6413c = new int[16];

    /* JADX INFO: renamed from: d */
    public int[] f6414d = new int[16];

    /* JADX INFO: renamed from: e */
    public float[] f6415e = new float[16];

    /* JADX INFO: renamed from: f */
    public int[] f6416f = new int[16];

    /* JADX INFO: renamed from: g */
    public int[] f6417g = new int[16];

    /* JADX INFO: renamed from: h */
    public int f6418h = 0;

    /* JADX INFO: renamed from: i */
    public int f6419i = -1;

    /* JADX INFO: renamed from: j */
    public final C1844c f6420j;

    /* JADX INFO: renamed from: k */
    public final C1803m f6421k;

    public C1851j(C1844c c1844c, C1803m c1803m) {
        this.f6420j = c1844c;
        this.f6421k = c1803m;
        clear();
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: a */
    public final float mo4078a(int i3) {
        int i4 = this.f6418h;
        int i5 = this.f6419i;
        for (int i6 = 0; i6 < i4; i6++) {
            if (i6 == i3) {
                return this.f6415e[i5];
            }
            i5 = this.f6417g[i5];
            if (i5 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: b */
    public final boolean mo4079b(C1850i c1850i) {
        return m4125n(c1850i) != -1;
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: c */
    public final float mo4080c(C1850i c1850i) {
        int iM4125n = m4125n(c1850i);
        if (iM4125n != -1) {
            return this.f6415e[iM4125n];
        }
        return 0.0f;
    }

    @Override // p136r.InterfaceC1843b
    public final void clear() {
        int i3 = this.f6418h;
        for (int i4 = 0; i4 < i3; i4++) {
            C1850i c1850iMo4082e = mo4082e(i4);
            if (c1850iMo4082e != null) {
                c1850iMo4082e.m4120b(this.f6420j);
            }
        }
        for (int i5 = 0; i5 < this.f6411a; i5++) {
            this.f6414d[i5] = -1;
            this.f6413c[i5] = -1;
        }
        for (int i6 = 0; i6 < 16; i6++) {
            this.f6412b[i6] = -1;
        }
        this.f6418h = 0;
        this.f6419i = -1;
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: d */
    public final float mo4081d(C1850i c1850i, boolean z3) {
        int[] iArr;
        int i3;
        int iM4125n = m4125n(c1850i);
        if (iM4125n == -1) {
            return 0.0f;
        }
        int i4 = c1850i.f6400b;
        int i5 = i4 % 16;
        int[] iArr2 = this.f6412b;
        int i6 = iArr2[i5];
        if (i6 != -1) {
            if (this.f6414d[i6] == i4) {
                int[] iArr3 = this.f6413c;
                iArr2[i5] = iArr3[i6];
                iArr3[i6] = -1;
            } else {
                while (true) {
                    iArr = this.f6413c;
                    i3 = iArr[i6];
                    if (i3 == -1 || this.f6414d[i3] == i4) {
                        break;
                    }
                    i6 = i3;
                }
                if (i3 != -1 && this.f6414d[i3] == i4) {
                    iArr[i6] = iArr[i3];
                    iArr[i3] = -1;
                }
            }
        }
        float f3 = this.f6415e[iM4125n];
        if (this.f6419i == iM4125n) {
            this.f6419i = this.f6417g[iM4125n];
        }
        this.f6414d[iM4125n] = -1;
        int[] iArr4 = this.f6416f;
        int i7 = iArr4[iM4125n];
        if (i7 != -1) {
            int[] iArr5 = this.f6417g;
            iArr5[i7] = iArr5[iM4125n];
        }
        int i8 = this.f6417g[iM4125n];
        if (i8 != -1) {
            iArr4[i8] = iArr4[iM4125n];
        }
        this.f6418h--;
        c1850i.f6409k--;
        if (z3) {
            c1850i.m4120b(this.f6420j);
        }
        return f3;
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: e */
    public final C1850i mo4082e(int i3) {
        int i4 = this.f6418h;
        if (i4 == 0) {
            return null;
        }
        int i5 = this.f6419i;
        for (int i6 = 0; i6 < i4; i6++) {
            if (i6 == i3 && i5 != -1) {
                return ((C1850i[]) this.f6421k.f6219e)[this.f6414d[i5]];
            }
            i5 = this.f6417g[i5];
            if (i5 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: f */
    public final void mo4083f(C1850i c1850i, float f3, boolean z3) {
        if (f3 <= -0.001f || f3 >= 0.001f) {
            int iM4125n = m4125n(c1850i);
            if (iM4125n == -1) {
                mo4085h(c1850i, f3);
                return;
            }
            float[] fArr = this.f6415e;
            float f4 = fArr[iM4125n] + f3;
            fArr[iM4125n] = f4;
            if (f4 <= -0.001f || f4 >= 0.001f) {
                return;
            }
            fArr[iM4125n] = 0.0f;
            mo4081d(c1850i, z3);
        }
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: g */
    public final void mo4084g(float f3) {
        int i3 = this.f6418h;
        int i4 = this.f6419i;
        for (int i5 = 0; i5 < i3; i5++) {
            float[] fArr = this.f6415e;
            fArr[i4] = fArr[i4] / f3;
            i4 = this.f6417g[i4];
            if (i4 == -1) {
                return;
            }
        }
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: h */
    public final void mo4085h(C1850i c1850i, float f3) {
        if (f3 > -0.001f && f3 < 0.001f) {
            mo4081d(c1850i, true);
            return;
        }
        int i3 = 0;
        if (this.f6418h == 0) {
            m4124m(0, c1850i, f3);
            m4123l(c1850i, 0);
            this.f6419i = 0;
            return;
        }
        int iM4125n = m4125n(c1850i);
        if (iM4125n != -1) {
            this.f6415e[iM4125n] = f3;
            return;
        }
        int i4 = this.f6418h + 1;
        int i5 = this.f6411a;
        if (i4 >= i5) {
            int i6 = i5 * 2;
            this.f6414d = Arrays.copyOf(this.f6414d, i6);
            this.f6415e = Arrays.copyOf(this.f6415e, i6);
            this.f6416f = Arrays.copyOf(this.f6416f, i6);
            this.f6417g = Arrays.copyOf(this.f6417g, i6);
            this.f6413c = Arrays.copyOf(this.f6413c, i6);
            for (int i7 = this.f6411a; i7 < i6; i7++) {
                this.f6414d[i7] = -1;
                this.f6413c[i7] = -1;
            }
            this.f6411a = i6;
        }
        int i8 = this.f6418h;
        int i9 = this.f6419i;
        int i10 = -1;
        for (int i11 = 0; i11 < i8; i11++) {
            int i12 = this.f6414d[i9];
            int i13 = c1850i.f6400b;
            if (i12 == i13) {
                this.f6415e[i9] = f3;
                return;
            }
            if (i12 < i13) {
                i10 = i9;
            }
            i9 = this.f6417g[i9];
            if (i9 == -1) {
                break;
            }
        }
        while (true) {
            if (i3 >= this.f6411a) {
                i3 = -1;
                break;
            } else if (this.f6414d[i3] == -1) {
                break;
            } else {
                i3++;
            }
        }
        m4124m(i3, c1850i, f3);
        if (i10 != -1) {
            this.f6416f[i3] = i10;
            int[] iArr = this.f6417g;
            iArr[i3] = iArr[i10];
            iArr[i10] = i3;
        } else {
            this.f6416f[i3] = -1;
            if (this.f6418h > 0) {
                this.f6417g[i3] = this.f6419i;
                this.f6419i = i3;
            } else {
                this.f6417g[i3] = -1;
            }
        }
        int i14 = this.f6417g[i3];
        if (i14 != -1) {
            this.f6416f[i14] = i3;
        }
        m4123l(c1850i, i3);
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: i */
    public final float mo4086i(C1844c c1844c, boolean z3) {
        float fMo4080c = mo4080c(c1844c.f6371a);
        mo4081d(c1844c.f6371a, z3);
        C1851j c1851j = (C1851j) c1844c.f6374d;
        int i3 = c1851j.f6418h;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = c1851j.f6414d[i5];
            if (i6 != -1) {
                mo4083f(((C1850i[]) this.f6421k.f6219e)[i6], c1851j.f6415e[i5] * fMo4080c, z3);
                i4++;
            }
            i5++;
        }
        return fMo4080c;
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: j */
    public final void mo4087j() {
        int i3 = this.f6418h;
        int i4 = this.f6419i;
        for (int i5 = 0; i5 < i3; i5++) {
            float[] fArr = this.f6415e;
            fArr[i4] = fArr[i4] * (-1.0f);
            i4 = this.f6417g[i4];
            if (i4 == -1) {
                return;
            }
        }
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: k */
    public final int mo4088k() {
        return this.f6418h;
    }

    /* JADX INFO: renamed from: l */
    public final void m4123l(C1850i c1850i, int i3) {
        int[] iArr;
        int i4 = c1850i.f6400b % 16;
        int[] iArr2 = this.f6412b;
        int i5 = iArr2[i4];
        if (i5 == -1) {
            iArr2[i4] = i3;
        } else {
            while (true) {
                iArr = this.f6413c;
                int i6 = iArr[i5];
                if (i6 == -1) {
                    break;
                } else {
                    i5 = i6;
                }
            }
            iArr[i5] = i3;
        }
        this.f6413c[i3] = -1;
    }

    /* JADX INFO: renamed from: m */
    public final void m4124m(int i3, C1850i c1850i, float f3) {
        this.f6414d[i3] = c1850i.f6400b;
        this.f6415e[i3] = f3;
        this.f6416f[i3] = -1;
        this.f6417g[i3] = -1;
        c1850i.m4119a(this.f6420j);
        c1850i.f6409k++;
        this.f6418h++;
    }

    /* JADX INFO: renamed from: n */
    public final int m4125n(C1850i c1850i) {
        if (this.f6418h == 0) {
            return -1;
        }
        int i3 = c1850i.f6400b;
        int i4 = this.f6412b[i3 % 16];
        if (i4 == -1) {
            return -1;
        }
        if (this.f6414d[i4] == i3) {
            return i4;
        }
        do {
            i4 = this.f6413c[i4];
            if (i4 == -1) {
                break;
            }
        } while (this.f6414d[i4] != i3);
        if (i4 != -1 && this.f6414d[i4] == i3) {
            return i4;
        }
        return -1;
    }

    public final String toString() {
        String strM4117a = hashCode() + " { ";
        int i3 = this.f6418h;
        for (int i4 = 0; i4 < i3; i4++) {
            C1850i c1850iMo4082e = mo4082e(i4);
            if (c1850iMo4082e != null) {
                String str = strM4117a + c1850iMo4082e + " = " + mo4078a(i4) + " ";
                int iM4125n = m4125n(c1850iMo4082e);
                String strM4117a2 = AbstractC1849h.m4117a(str, "[p: ");
                int i5 = this.f6416f[iM4125n];
                C1803m c1803m = this.f6421k;
                String strM4117a3 = AbstractC1849h.m4117a(i5 != -1 ? strM4117a2 + ((C1850i[]) c1803m.f6219e)[this.f6414d[this.f6416f[iM4125n]]] : AbstractC1849h.m4117a(strM4117a2, "none"), ", n: ");
                strM4117a = AbstractC1849h.m4117a(this.f6417g[iM4125n] != -1 ? strM4117a3 + ((C1850i[]) c1803m.f6219e)[this.f6414d[this.f6417g[iM4125n]]] : AbstractC1849h.m4117a(strM4117a3, "none"), "]");
            }
        }
        return AbstractC1849h.m4117a(strM4117a, " }");
    }
}
