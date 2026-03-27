package p110k;

/* JADX INFO: renamed from: k.I0 */
/* JADX INFO: loaded from: classes.dex */
public final class C1536I0 {

    /* JADX INFO: renamed from: a */
    public int f5499a;

    /* JADX INFO: renamed from: b */
    public int f5500b;

    /* JADX INFO: renamed from: c */
    public int f5501c;

    /* JADX INFO: renamed from: d */
    public int f5502d;

    /* JADX INFO: renamed from: e */
    public int f5503e;

    /* JADX INFO: renamed from: f */
    public int f5504f;

    /* JADX INFO: renamed from: g */
    public boolean f5505g;

    /* JADX INFO: renamed from: h */
    public boolean f5506h;

    /* JADX INFO: renamed from: a */
    public final void m3600a(int i3, int i4) {
        this.f5501c = i3;
        this.f5502d = i4;
        this.f5506h = true;
        if (this.f5505g) {
            if (i4 != Integer.MIN_VALUE) {
                this.f5499a = i4;
            }
            if (i3 != Integer.MIN_VALUE) {
                this.f5500b = i3;
                return;
            }
            return;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f5499a = i3;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.f5500b = i4;
        }
    }
}
