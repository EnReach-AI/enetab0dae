package p136r;

import java.util.Arrays;
import p125o0.C1803m;

/* JADX INFO: renamed from: r.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1842a implements InterfaceC1843b {

    /* JADX INFO: renamed from: b */
    public final C1844c f6362b;

    /* JADX INFO: renamed from: c */
    public final C1803m f6363c;

    /* JADX INFO: renamed from: a */
    public int f6361a = 0;

    /* JADX INFO: renamed from: d */
    public int f6364d = 8;

    /* JADX INFO: renamed from: e */
    public int[] f6365e = new int[8];

    /* JADX INFO: renamed from: f */
    public int[] f6366f = new int[8];

    /* JADX INFO: renamed from: g */
    public float[] f6367g = new float[8];

    /* JADX INFO: renamed from: h */
    public int f6368h = -1;

    /* JADX INFO: renamed from: i */
    public int f6369i = -1;

    /* JADX INFO: renamed from: j */
    public boolean f6370j = false;

    public C1842a(C1844c c1844c, C1803m c1803m) {
        this.f6362b = c1844c;
        this.f6363c = c1803m;
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: a */
    public final float mo4078a(int i3) {
        int i4 = this.f6368h;
        for (int i5 = 0; i4 != -1 && i5 < this.f6361a; i5++) {
            if (i5 == i3) {
                return this.f6367g[i4];
            }
            i4 = this.f6366f[i4];
        }
        return 0.0f;
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: b */
    public final boolean mo4079b(C1850i c1850i) {
        int i3 = this.f6368h;
        if (i3 == -1) {
            return false;
        }
        for (int i4 = 0; i3 != -1 && i4 < this.f6361a; i4++) {
            if (this.f6365e[i3] == c1850i.f6400b) {
                return true;
            }
            i3 = this.f6366f[i3];
        }
        return false;
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: c */
    public final float mo4080c(C1850i c1850i) {
        int i3 = this.f6368h;
        for (int i4 = 0; i3 != -1 && i4 < this.f6361a; i4++) {
            if (this.f6365e[i3] == c1850i.f6400b) {
                return this.f6367g[i3];
            }
            i3 = this.f6366f[i3];
        }
        return 0.0f;
    }

    @Override // p136r.InterfaceC1843b
    public final void clear() {
        int i3 = this.f6368h;
        for (int i4 = 0; i3 != -1 && i4 < this.f6361a; i4++) {
            C1850i c1850i = ((C1850i[]) this.f6363c.f6219e)[this.f6365e[i3]];
            if (c1850i != null) {
                c1850i.m4120b(this.f6362b);
            }
            i3 = this.f6366f[i3];
        }
        this.f6368h = -1;
        this.f6369i = -1;
        this.f6370j = false;
        this.f6361a = 0;
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: d */
    public final float mo4081d(C1850i c1850i, boolean z3) {
        int i3 = this.f6368h;
        if (i3 == -1) {
            return 0.0f;
        }
        int i4 = 0;
        int i5 = -1;
        while (i3 != -1 && i4 < this.f6361a) {
            if (this.f6365e[i3] == c1850i.f6400b) {
                if (i3 == this.f6368h) {
                    this.f6368h = this.f6366f[i3];
                } else {
                    int[] iArr = this.f6366f;
                    iArr[i5] = iArr[i3];
                }
                if (z3) {
                    c1850i.m4120b(this.f6362b);
                }
                c1850i.f6409k--;
                this.f6361a--;
                this.f6365e[i3] = -1;
                if (this.f6370j) {
                    this.f6369i = i3;
                }
                return this.f6367g[i3];
            }
            i4++;
            i5 = i3;
            i3 = this.f6366f[i3];
        }
        return 0.0f;
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: e */
    public final C1850i mo4082e(int i3) {
        int i4 = this.f6368h;
        for (int i5 = 0; i4 != -1 && i5 < this.f6361a; i5++) {
            if (i5 == i3) {
                return ((C1850i[]) this.f6363c.f6219e)[this.f6365e[i4]];
            }
            i4 = this.f6366f[i4];
        }
        return null;
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: f */
    public final void mo4083f(C1850i c1850i, float f3, boolean z3) {
        if (f3 <= -0.001f || f3 >= 0.001f) {
            int i3 = this.f6368h;
            C1844c c1844c = this.f6362b;
            if (i3 == -1) {
                this.f6368h = 0;
                this.f6367g[0] = f3;
                this.f6365e[0] = c1850i.f6400b;
                this.f6366f[0] = -1;
                c1850i.f6409k++;
                c1850i.m4119a(c1844c);
                this.f6361a++;
                if (this.f6370j) {
                    return;
                }
                int i4 = this.f6369i + 1;
                this.f6369i = i4;
                int[] iArr = this.f6365e;
                if (i4 >= iArr.length) {
                    this.f6370j = true;
                    this.f6369i = iArr.length - 1;
                    return;
                }
                return;
            }
            int i5 = -1;
            for (int i6 = 0; i3 != -1 && i6 < this.f6361a; i6++) {
                int i7 = this.f6365e[i3];
                int i8 = c1850i.f6400b;
                if (i7 == i8) {
                    float[] fArr = this.f6367g;
                    float f4 = fArr[i3] + f3;
                    if (f4 > -0.001f && f4 < 0.001f) {
                        f4 = 0.0f;
                    }
                    fArr[i3] = f4;
                    if (f4 == 0.0f) {
                        if (i3 == this.f6368h) {
                            this.f6368h = this.f6366f[i3];
                        } else {
                            int[] iArr2 = this.f6366f;
                            iArr2[i5] = iArr2[i3];
                        }
                        if (z3) {
                            c1850i.m4120b(c1844c);
                        }
                        if (this.f6370j) {
                            this.f6369i = i3;
                        }
                        c1850i.f6409k--;
                        this.f6361a--;
                        return;
                    }
                    return;
                }
                if (i7 < i8) {
                    i5 = i3;
                }
                i3 = this.f6366f[i3];
            }
            int length = this.f6369i;
            int i9 = length + 1;
            if (this.f6370j) {
                int[] iArr3 = this.f6365e;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i9;
            }
            int[] iArr4 = this.f6365e;
            if (length >= iArr4.length && this.f6361a < iArr4.length) {
                int i10 = 0;
                while (true) {
                    int[] iArr5 = this.f6365e;
                    if (i10 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i10] == -1) {
                        length = i10;
                        break;
                    }
                    i10++;
                }
            }
            int[] iArr6 = this.f6365e;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i11 = this.f6364d * 2;
                this.f6364d = i11;
                this.f6370j = false;
                this.f6369i = length - 1;
                this.f6367g = Arrays.copyOf(this.f6367g, i11);
                this.f6365e = Arrays.copyOf(this.f6365e, this.f6364d);
                this.f6366f = Arrays.copyOf(this.f6366f, this.f6364d);
            }
            this.f6365e[length] = c1850i.f6400b;
            this.f6367g[length] = f3;
            if (i5 != -1) {
                int[] iArr7 = this.f6366f;
                iArr7[length] = iArr7[i5];
                iArr7[i5] = length;
            } else {
                this.f6366f[length] = this.f6368h;
                this.f6368h = length;
            }
            c1850i.f6409k++;
            c1850i.m4119a(c1844c);
            this.f6361a++;
            if (!this.f6370j) {
                this.f6369i++;
            }
            int i12 = this.f6369i;
            int[] iArr8 = this.f6365e;
            if (i12 >= iArr8.length) {
                this.f6370j = true;
                this.f6369i = iArr8.length - 1;
            }
        }
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: g */
    public final void mo4084g(float f3) {
        int i3 = this.f6368h;
        for (int i4 = 0; i3 != -1 && i4 < this.f6361a; i4++) {
            float[] fArr = this.f6367g;
            fArr[i3] = fArr[i3] / f3;
            i3 = this.f6366f[i3];
        }
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: h */
    public final void mo4085h(C1850i c1850i, float f3) {
        if (f3 == 0.0f) {
            mo4081d(c1850i, true);
            return;
        }
        int i3 = this.f6368h;
        C1844c c1844c = this.f6362b;
        if (i3 == -1) {
            this.f6368h = 0;
            this.f6367g[0] = f3;
            this.f6365e[0] = c1850i.f6400b;
            this.f6366f[0] = -1;
            c1850i.f6409k++;
            c1850i.m4119a(c1844c);
            this.f6361a++;
            if (this.f6370j) {
                return;
            }
            int i4 = this.f6369i + 1;
            this.f6369i = i4;
            int[] iArr = this.f6365e;
            if (i4 >= iArr.length) {
                this.f6370j = true;
                this.f6369i = iArr.length - 1;
                return;
            }
            return;
        }
        int i5 = -1;
        for (int i6 = 0; i3 != -1 && i6 < this.f6361a; i6++) {
            int i7 = this.f6365e[i3];
            int i8 = c1850i.f6400b;
            if (i7 == i8) {
                this.f6367g[i3] = f3;
                return;
            }
            if (i7 < i8) {
                i5 = i3;
            }
            i3 = this.f6366f[i3];
        }
        int length = this.f6369i;
        int i9 = length + 1;
        if (this.f6370j) {
            int[] iArr2 = this.f6365e;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i9;
        }
        int[] iArr3 = this.f6365e;
        if (length >= iArr3.length && this.f6361a < iArr3.length) {
            int i10 = 0;
            while (true) {
                int[] iArr4 = this.f6365e;
                if (i10 >= iArr4.length) {
                    break;
                }
                if (iArr4[i10] == -1) {
                    length = i10;
                    break;
                }
                i10++;
            }
        }
        int[] iArr5 = this.f6365e;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i11 = this.f6364d * 2;
            this.f6364d = i11;
            this.f6370j = false;
            this.f6369i = length - 1;
            this.f6367g = Arrays.copyOf(this.f6367g, i11);
            this.f6365e = Arrays.copyOf(this.f6365e, this.f6364d);
            this.f6366f = Arrays.copyOf(this.f6366f, this.f6364d);
        }
        this.f6365e[length] = c1850i.f6400b;
        this.f6367g[length] = f3;
        if (i5 != -1) {
            int[] iArr6 = this.f6366f;
            iArr6[length] = iArr6[i5];
            iArr6[i5] = length;
        } else {
            this.f6366f[length] = this.f6368h;
            this.f6368h = length;
        }
        c1850i.f6409k++;
        c1850i.m4119a(c1844c);
        int i12 = this.f6361a + 1;
        this.f6361a = i12;
        if (!this.f6370j) {
            this.f6369i++;
        }
        int[] iArr7 = this.f6365e;
        if (i12 >= iArr7.length) {
            this.f6370j = true;
        }
        if (this.f6369i >= iArr7.length) {
            this.f6370j = true;
            this.f6369i = iArr7.length - 1;
        }
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: i */
    public final float mo4086i(C1844c c1844c, boolean z3) {
        float fMo4080c = mo4080c(c1844c.f6371a);
        mo4081d(c1844c.f6371a, z3);
        InterfaceC1843b interfaceC1843b = c1844c.f6374d;
        int iMo4088k = interfaceC1843b.mo4088k();
        for (int i3 = 0; i3 < iMo4088k; i3++) {
            C1850i c1850iMo4082e = interfaceC1843b.mo4082e(i3);
            mo4083f(c1850iMo4082e, interfaceC1843b.mo4080c(c1850iMo4082e) * fMo4080c, z3);
        }
        return fMo4080c;
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: j */
    public final void mo4087j() {
        int i3 = this.f6368h;
        for (int i4 = 0; i3 != -1 && i4 < this.f6361a; i4++) {
            float[] fArr = this.f6367g;
            fArr[i3] = fArr[i3] * (-1.0f);
            i3 = this.f6366f[i3];
        }
    }

    @Override // p136r.InterfaceC1843b
    /* JADX INFO: renamed from: k */
    public final int mo4088k() {
        return this.f6361a;
    }

    public final String toString() {
        int i3 = this.f6368h;
        String str = "";
        for (int i4 = 0; i3 != -1 && i4 < this.f6361a; i4++) {
            str = (AbstractC1849h.m4117a(str, " -> ") + this.f6367g[i3] + " : ") + ((C1850i[]) this.f6363c.f6219e)[this.f6365e[i3]];
            i3 = this.f6366f[i3];
        }
        return str;
    }
}
