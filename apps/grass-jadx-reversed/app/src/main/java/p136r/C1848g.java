package p136r;

import java.util.Arrays;
import p006B0.C0038a;

/* JADX INFO: renamed from: r.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1848g extends C1844c {

    /* JADX INFO: renamed from: f */
    public C1850i[] f6394f;

    /* JADX INFO: renamed from: g */
    public C1850i[] f6395g;

    /* JADX INFO: renamed from: h */
    public int f6396h;

    /* JADX INFO: renamed from: i */
    public C1847f f6397i;

    @Override // p136r.C1844c
    /* JADX INFO: renamed from: d */
    public final C1850i mo4092d(boolean[] zArr) {
        int i3 = -1;
        for (int i4 = 0; i4 < this.f6396h; i4++) {
            C1850i[] c1850iArr = this.f6394f;
            C1850i c1850i = c1850iArr[i4];
            if (!zArr[c1850i.f6400b]) {
                C1847f c1847f = this.f6397i;
                c1847f.f6392e = c1850i;
                int i5 = 8;
                if (i3 == -1) {
                    while (i5 >= 0) {
                        float f3 = c1847f.f6392e.f6406h[i5];
                        if (f3 <= 0.0f) {
                            if (f3 < 0.0f) {
                                i3 = i4;
                                break;
                            }
                            i5--;
                        }
                    }
                } else {
                    C1850i c1850i2 = c1850iArr[i3];
                    while (true) {
                        if (i5 >= 0) {
                            float f4 = c1850i2.f6406h[i5];
                            float f5 = c1847f.f6392e.f6406h[i5];
                            if (f5 == f4) {
                                i5--;
                            } else if (f5 < f4) {
                            }
                        }
                    }
                }
            }
        }
        if (i3 == -1) {
            return null;
        }
        return this.f6394f[i3];
    }

    @Override // p136r.C1844c
    /* JADX INFO: renamed from: h */
    public final void mo4096h(C1844c c1844c, boolean z3) {
        C1850i c1850i = c1844c.f6371a;
        if (c1850i == null) {
            return;
        }
        InterfaceC1843b interfaceC1843b = c1844c.f6374d;
        int iMo4088k = interfaceC1843b.mo4088k();
        for (int i3 = 0; i3 < iMo4088k; i3++) {
            C1850i c1850iMo4082e = interfaceC1843b.mo4082e(i3);
            float fMo4078a = interfaceC1843b.mo4078a(i3);
            C1847f c1847f = this.f6397i;
            c1847f.f6392e = c1850iMo4082e;
            boolean z4 = c1850iMo4082e.f6399a;
            float[] fArr = c1850i.f6406h;
            if (z4) {
                boolean z5 = true;
                for (int i4 = 0; i4 < 9; i4++) {
                    float[] fArr2 = c1847f.f6392e.f6406h;
                    float f3 = (fArr[i4] * fMo4078a) + fArr2[i4];
                    fArr2[i4] = f3;
                    if (Math.abs(f3) < 1.0E-4f) {
                        c1847f.f6392e.f6406h[i4] = 0.0f;
                    } else {
                        z5 = false;
                    }
                }
                if (z5) {
                    c1847f.f6393f.m4116j(c1847f.f6392e);
                }
            } else {
                for (int i5 = 0; i5 < 9; i5++) {
                    float f4 = fArr[i5];
                    if (f4 != 0.0f) {
                        float f5 = f4 * fMo4078a;
                        if (Math.abs(f5) < 1.0E-4f) {
                            f5 = 0.0f;
                        }
                        c1847f.f6392e.f6406h[i5] = f5;
                    } else {
                        c1847f.f6392e.f6406h[i5] = 0.0f;
                    }
                }
                m4115i(c1850iMo4082e);
            }
            this.f6372b = (c1844c.f6372b * fMo4078a) + this.f6372b;
        }
        m4116j(c1850i);
    }

    /* JADX INFO: renamed from: i */
    public final void m4115i(C1850i c1850i) {
        int i3;
        int i4 = this.f6396h + 1;
        C1850i[] c1850iArr = this.f6394f;
        if (i4 > c1850iArr.length) {
            C1850i[] c1850iArr2 = (C1850i[]) Arrays.copyOf(c1850iArr, c1850iArr.length * 2);
            this.f6394f = c1850iArr2;
            this.f6395g = (C1850i[]) Arrays.copyOf(c1850iArr2, c1850iArr2.length * 2);
        }
        C1850i[] c1850iArr3 = this.f6394f;
        int i5 = this.f6396h;
        c1850iArr3[i5] = c1850i;
        int i6 = i5 + 1;
        this.f6396h = i6;
        if (i6 > 1 && c1850iArr3[i5].f6400b > c1850i.f6400b) {
            int i7 = 0;
            while (true) {
                i3 = this.f6396h;
                if (i7 >= i3) {
                    break;
                }
                this.f6395g[i7] = this.f6394f[i7];
                i7++;
            }
            Arrays.sort(this.f6395g, 0, i3, new C0038a(5));
            for (int i8 = 0; i8 < this.f6396h; i8++) {
                this.f6394f[i8] = this.f6395g[i8];
            }
        }
        c1850i.f6399a = true;
        c1850i.m4119a(this);
    }

    /* JADX INFO: renamed from: j */
    public final void m4116j(C1850i c1850i) {
        int i3 = 0;
        while (i3 < this.f6396h) {
            if (this.f6394f[i3] == c1850i) {
                while (true) {
                    int i4 = this.f6396h;
                    if (i3 >= i4 - 1) {
                        this.f6396h = i4 - 1;
                        c1850i.f6399a = false;
                        return;
                    } else {
                        C1850i[] c1850iArr = this.f6394f;
                        int i5 = i3 + 1;
                        c1850iArr[i3] = c1850iArr[i5];
                        i3 = i5;
                    }
                }
            } else {
                i3++;
            }
        }
    }

    @Override // p136r.C1844c
    public final String toString() {
        String str = " goal -> (" + this.f6372b + ") : ";
        for (int i3 = 0; i3 < this.f6396h; i3++) {
            C1850i c1850i = this.f6394f[i3];
            C1847f c1847f = this.f6397i;
            c1847f.f6392e = c1850i;
            str = str + c1847f + " ";
        }
        return str;
    }
}
