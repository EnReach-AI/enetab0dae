package p144t0;

/* JADX INFO: renamed from: t0.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1915a {

    /* JADX INFO: renamed from: a */
    public float[] f6696a;

    /* JADX INFO: renamed from: b */
    public int[] f6697b;

    /* JADX INFO: renamed from: c */
    public int f6698c;

    public C1915a(int[] iArr) {
        this.f6697b = iArr;
        int i3 = 1;
        for (int i4 : iArr) {
            i3 *= i4;
        }
        this.f6698c = i3;
        this.f6696a = new float[i3];
    }
}
