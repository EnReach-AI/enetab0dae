package p128p;

/* JADX INFO: renamed from: p.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1811e implements Cloneable {

    /* JADX INFO: renamed from: i */
    public static final Object f6269i = new Object();

    /* JADX INFO: renamed from: e */
    public boolean f6270e = false;

    /* JADX INFO: renamed from: f */
    public long[] f6271f;

    /* JADX INFO: renamed from: g */
    public Object[] f6272g;

    /* JADX INFO: renamed from: h */
    public int f6273h;

    public C1811e() {
        int i3;
        int i4 = 4;
        while (true) {
            i3 = 80;
            if (i4 >= 32) {
                break;
            }
            int i5 = (1 << i4) - 12;
            if (80 <= i5) {
                i3 = i5;
                break;
            }
            i4++;
        }
        int i6 = i3 / 8;
        this.f6271f = new long[i6];
        this.f6272g = new Object[i6];
    }

    /* JADX INFO: renamed from: a */
    public final void m4023a() {
        int i3 = this.f6273h;
        Object[] objArr = this.f6272g;
        for (int i4 = 0; i4 < i3; i4++) {
            objArr[i4] = null;
        }
        this.f6273h = 0;
        this.f6270e = false;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C1811e clone() {
        try {
            C1811e c1811e = (C1811e) super.clone();
            c1811e.f6271f = (long[]) this.f6271f.clone();
            c1811e.f6272g = (Object[]) this.f6272g.clone();
            return c1811e;
        } catch (CloneNotSupportedException e3) {
            throw new AssertionError(e3);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m4025c() {
        int i3 = this.f6273h;
        long[] jArr = this.f6271f;
        Object[] objArr = this.f6272g;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            Object obj = objArr[i5];
            if (obj != f6269i) {
                if (i5 != i4) {
                    jArr[i4] = jArr[i5];
                    objArr[i4] = obj;
                    objArr[i5] = null;
                }
                i4++;
            }
        }
        this.f6270e = false;
        this.f6273h = i4;
    }

    /* JADX INFO: renamed from: d */
    public final Object m4026d(long j2, Long l3) {
        Object obj;
        int iM4022b = AbstractC1810d.m4022b(this.f6271f, this.f6273h, j2);
        return (iM4022b < 0 || (obj = this.f6272g[iM4022b]) == f6269i) ? l3 : obj;
    }

    /* JADX INFO: renamed from: e */
    public final void m4027e(long j2, Object obj) {
        int iM4022b = AbstractC1810d.m4022b(this.f6271f, this.f6273h, j2);
        if (iM4022b >= 0) {
            this.f6272g[iM4022b] = obj;
            return;
        }
        int i3 = ~iM4022b;
        int i4 = this.f6273h;
        if (i3 < i4) {
            Object[] objArr = this.f6272g;
            if (objArr[i3] == f6269i) {
                this.f6271f[i3] = j2;
                objArr[i3] = obj;
                return;
            }
        }
        if (this.f6270e && i4 >= this.f6271f.length) {
            m4025c();
            i3 = ~AbstractC1810d.m4022b(this.f6271f, this.f6273h, j2);
        }
        int i5 = this.f6273h;
        if (i5 >= this.f6271f.length) {
            int i6 = (i5 + 1) * 8;
            int i7 = 4;
            while (true) {
                if (i7 >= 32) {
                    break;
                }
                int i8 = (1 << i7) - 12;
                if (i6 <= i8) {
                    i6 = i8;
                    break;
                }
                i7++;
            }
            int i9 = i6 / 8;
            long[] jArr = new long[i9];
            Object[] objArr2 = new Object[i9];
            long[] jArr2 = this.f6271f;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f6272g;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f6271f = jArr;
            this.f6272g = objArr2;
        }
        int i10 = this.f6273h - i3;
        if (i10 != 0) {
            long[] jArr3 = this.f6271f;
            int i11 = i3 + 1;
            System.arraycopy(jArr3, i3, jArr3, i11, i10);
            Object[] objArr4 = this.f6272g;
            System.arraycopy(objArr4, i3, objArr4, i11, this.f6273h - i3);
        }
        this.f6271f[i3] = j2;
        this.f6272g[i3] = obj;
        this.f6273h++;
    }

    /* JADX INFO: renamed from: f */
    public final int m4028f() {
        if (this.f6270e) {
            m4025c();
        }
        return this.f6273h;
    }

    /* JADX INFO: renamed from: g */
    public final Object m4029g(int i3) {
        if (this.f6270e) {
            m4025c();
        }
        return this.f6272g[i3];
    }

    public final String toString() {
        if (m4028f() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f6273h * 28);
        sb.append('{');
        for (int i3 = 0; i3 < this.f6273h; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            if (this.f6270e) {
                m4025c();
            }
            sb.append(this.f6271f[i3]);
            sb.append('=');
            Object objM4029g = m4029g(i3);
            if (objM4029g != this) {
                sb.append(objM4029g);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
