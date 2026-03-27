package p073Z;

/* JADX INFO: renamed from: Z.g0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0793g0 {

    /* JADX INFO: renamed from: a */
    public int f2285a;

    /* JADX INFO: renamed from: b */
    public int f2286b;

    /* JADX INFO: renamed from: c */
    public int f2287c;

    /* JADX INFO: renamed from: d */
    public int f2288d;

    /* JADX INFO: renamed from: e */
    public int f2289e;

    /* JADX INFO: renamed from: a */
    public final boolean m2084a() {
        int i3 = this.f2285a;
        int i4 = 2;
        if ((i3 & 7) != 0) {
            int i5 = this.f2288d;
            int i6 = this.f2286b;
            if (((i5 > i6 ? 1 : i5 == i6 ? 2 : 4) & i3) == 0) {
                return false;
            }
        }
        if ((i3 & 112) != 0) {
            int i7 = this.f2288d;
            int i8 = this.f2287c;
            if ((((i7 > i8 ? 1 : i7 == i8 ? 2 : 4) << 4) & i3) == 0) {
                return false;
            }
        }
        if ((i3 & 1792) != 0) {
            int i9 = this.f2289e;
            int i10 = this.f2286b;
            if ((((i9 > i10 ? 1 : i9 == i10 ? 2 : 4) << 8) & i3) == 0) {
                return false;
            }
        }
        if ((i3 & 28672) != 0) {
            int i11 = this.f2289e;
            int i12 = this.f2287c;
            if (i11 > i12) {
                i4 = 1;
            } else if (i11 != i12) {
                i4 = 4;
            }
            if ((i3 & (i4 << 12)) == 0) {
                return false;
            }
        }
        return true;
    }
}
