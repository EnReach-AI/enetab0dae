package p041N;

/* JADX INFO: renamed from: N.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0513a {

    /* JADX INFO: renamed from: a */
    public int f1190a;

    /* JADX INFO: renamed from: b */
    public int f1191b;

    /* JADX INFO: renamed from: c */
    public float f1192c;

    /* JADX INFO: renamed from: d */
    public float f1193d;

    /* JADX INFO: renamed from: e */
    public long f1194e;

    /* JADX INFO: renamed from: f */
    public long f1195f;

    /* JADX INFO: renamed from: g */
    public long f1196g;

    /* JADX INFO: renamed from: h */
    public float f1197h;

    /* JADX INFO: renamed from: i */
    public int f1198i;

    /* JADX INFO: renamed from: a */
    public final float m1021a(long j2) {
        if (j2 < this.f1194e) {
            return 0.0f;
        }
        long j3 = this.f1196g;
        if (j3 < 0 || j2 < j3) {
            return ViewOnTouchListenerC0519g.m1035b((j2 - r0) / this.f1190a, 0.0f, 1.0f) * 0.5f;
        }
        float f3 = this.f1197h;
        return (ViewOnTouchListenerC0519g.m1035b((j2 - j3) / this.f1198i, 0.0f, 1.0f) * f3) + (1.0f - f3);
    }
}
