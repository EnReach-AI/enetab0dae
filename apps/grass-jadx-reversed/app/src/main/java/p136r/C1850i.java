package p136r;

import java.util.Arrays;

/* JADX INFO: renamed from: r.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1850i {

    /* JADX INFO: renamed from: a */
    public boolean f6399a;

    /* JADX INFO: renamed from: e */
    public float f6403e;

    /* JADX INFO: renamed from: l */
    public int f6410l;

    /* JADX INFO: renamed from: b */
    public int f6400b = -1;

    /* JADX INFO: renamed from: c */
    public int f6401c = -1;

    /* JADX INFO: renamed from: d */
    public int f6402d = 0;

    /* JADX INFO: renamed from: f */
    public boolean f6404f = false;

    /* JADX INFO: renamed from: g */
    public final float[] f6405g = new float[9];

    /* JADX INFO: renamed from: h */
    public final float[] f6406h = new float[9];

    /* JADX INFO: renamed from: i */
    public C1844c[] f6407i = new C1844c[16];

    /* JADX INFO: renamed from: j */
    public int f6408j = 0;

    /* JADX INFO: renamed from: k */
    public int f6409k = 0;

    public C1850i(int i3) {
        this.f6410l = i3;
    }

    /* JADX INFO: renamed from: a */
    public final void m4119a(C1844c c1844c) {
        int i3 = 0;
        while (true) {
            int i4 = this.f6408j;
            if (i3 >= i4) {
                C1844c[] c1844cArr = this.f6407i;
                if (i4 >= c1844cArr.length) {
                    this.f6407i = (C1844c[]) Arrays.copyOf(c1844cArr, c1844cArr.length * 2);
                }
                C1844c[] c1844cArr2 = this.f6407i;
                int i5 = this.f6408j;
                c1844cArr2[i5] = c1844c;
                this.f6408j = i5 + 1;
                return;
            }
            if (this.f6407i[i3] == c1844c) {
                return;
            } else {
                i3++;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m4120b(C1844c c1844c) {
        int i3 = this.f6408j;
        int i4 = 0;
        while (i4 < i3) {
            if (this.f6407i[i4] == c1844c) {
                while (i4 < i3 - 1) {
                    C1844c[] c1844cArr = this.f6407i;
                    int i5 = i4 + 1;
                    c1844cArr[i4] = c1844cArr[i5];
                    i4 = i5;
                }
                this.f6408j--;
                return;
            }
            i4++;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m4121c() {
        this.f6410l = 5;
        this.f6402d = 0;
        this.f6400b = -1;
        this.f6401c = -1;
        this.f6403e = 0.0f;
        this.f6404f = false;
        int i3 = this.f6408j;
        for (int i4 = 0; i4 < i3; i4++) {
            this.f6407i[i4] = null;
        }
        this.f6408j = 0;
        this.f6409k = 0;
        this.f6399a = false;
        Arrays.fill(this.f6406h, 0.0f);
    }

    /* JADX INFO: renamed from: d */
    public final void m4122d(C1844c c1844c) {
        int i3 = this.f6408j;
        for (int i4 = 0; i4 < i3; i4++) {
            this.f6407i[i4].mo4096h(c1844c, false);
        }
        this.f6408j = 0;
    }

    public final String toString() {
        return "" + this.f6400b;
    }
}
