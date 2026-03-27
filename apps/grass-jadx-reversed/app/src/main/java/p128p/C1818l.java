package p128p;

/* JADX INFO: renamed from: p.l */
/* JADX INFO: loaded from: classes.dex */
public final class C1818l implements Cloneable {

    /* JADX INFO: renamed from: h */
    public static final Object f6298h = new Object();

    /* JADX INFO: renamed from: e */
    public int[] f6299e;

    /* JADX INFO: renamed from: f */
    public Object[] f6300f;

    /* JADX INFO: renamed from: g */
    public int f6301g;

    public C1818l() {
        int i3;
        int i4 = 4;
        while (true) {
            i3 = 40;
            if (i4 >= 32) {
                break;
            }
            int i5 = (1 << i4) - 12;
            if (40 <= i5) {
                i3 = i5;
                break;
            }
            i4++;
        }
        int i6 = i3 / 4;
        this.f6299e = new int[i6];
        this.f6300f = new Object[i6];
    }

    /* JADX INFO: renamed from: a */
    public final void m4042a(int i3, Object obj) {
        int i4 = this.f6301g;
        if (i4 != 0 && i3 <= this.f6299e[i4 - 1]) {
            m4045d(i3, obj);
            return;
        }
        if (i4 >= this.f6299e.length) {
            int i5 = (i4 + 1) * 4;
            int i6 = 4;
            while (true) {
                if (i6 >= 32) {
                    break;
                }
                int i7 = (1 << i6) - 12;
                if (i5 <= i7) {
                    i5 = i7;
                    break;
                }
                i6++;
            }
            int i8 = i5 / 4;
            int[] iArr = new int[i8];
            Object[] objArr = new Object[i8];
            int[] iArr2 = this.f6299e;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f6300f;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f6299e = iArr;
            this.f6300f = objArr;
        }
        this.f6299e[i4] = i3;
        this.f6300f[i4] = obj;
        this.f6301g = i4 + 1;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C1818l clone() {
        try {
            C1818l c1818l = (C1818l) super.clone();
            c1818l.f6299e = (int[]) this.f6299e.clone();
            c1818l.f6300f = (Object[]) this.f6300f.clone();
            return c1818l;
        } catch (CloneNotSupportedException e3) {
            throw new AssertionError(e3);
        }
    }

    /* JADX INFO: renamed from: c */
    public final Object m4044c(int i3, Integer num) {
        Object obj;
        int iM4021a = AbstractC1810d.m4021a(this.f6301g, i3, this.f6299e);
        return (iM4021a < 0 || (obj = this.f6300f[iM4021a]) == f6298h) ? num : obj;
    }

    /* JADX INFO: renamed from: d */
    public final void m4045d(int i3, Object obj) {
        int iM4021a = AbstractC1810d.m4021a(this.f6301g, i3, this.f6299e);
        if (iM4021a >= 0) {
            this.f6300f[iM4021a] = obj;
            return;
        }
        int i4 = ~iM4021a;
        int i5 = this.f6301g;
        if (i4 < i5) {
            Object[] objArr = this.f6300f;
            if (objArr[i4] == f6298h) {
                this.f6299e[i4] = i3;
                objArr[i4] = obj;
                return;
            }
        }
        if (i5 >= this.f6299e.length) {
            int i6 = (i5 + 1) * 4;
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
            int i9 = i6 / 4;
            int[] iArr = new int[i9];
            Object[] objArr2 = new Object[i9];
            int[] iArr2 = this.f6299e;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f6300f;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f6299e = iArr;
            this.f6300f = objArr2;
        }
        int i10 = this.f6301g - i4;
        if (i10 != 0) {
            int[] iArr3 = this.f6299e;
            int i11 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i11, i10);
            Object[] objArr4 = this.f6300f;
            System.arraycopy(objArr4, i4, objArr4, i11, this.f6301g - i4);
        }
        this.f6299e[i4] = i3;
        this.f6300f[i4] = obj;
        this.f6301g++;
    }

    public final String toString() {
        int i3 = this.f6301g;
        if (i3 <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i3 * 28);
        sb.append('{');
        for (int i4 = 0; i4 < this.f6301g; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(this.f6299e[i4]);
            sb.append('=');
            Object obj = this.f6300f[i4];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
