package p136r;

/* JADX INFO: renamed from: r.f */
/* JADX INFO: loaded from: classes.dex */
public final class C1847f implements Comparable {

    /* JADX INFO: renamed from: e */
    public C1850i f6392e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ C1848g f6393f;

    public C1847f(C1848g c1848g) {
        this.f6393f = c1848g;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f6392e.f6400b - ((C1850i) obj).f6400b;
    }

    public final String toString() {
        String str = "[ ";
        if (this.f6392e != null) {
            for (int i3 = 0; i3 < 9; i3++) {
                str = str + this.f6392e.f6406h[i3] + " ";
            }
        }
        return str + "] " + this.f6392e;
    }
}
