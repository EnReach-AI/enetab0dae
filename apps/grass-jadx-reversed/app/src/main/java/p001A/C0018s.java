package p001A;

/* JADX INFO: renamed from: A.s */
/* JADX INFO: loaded from: classes.dex */
public final class C0018s {

    /* JADX INFO: renamed from: k */
    public static final C0018s f46k;

    /* JADX INFO: renamed from: a */
    public final float f47a;

    /* JADX INFO: renamed from: b */
    public final float f48b;

    /* JADX INFO: renamed from: c */
    public final float f49c;

    /* JADX INFO: renamed from: d */
    public final float f50d;

    /* JADX INFO: renamed from: e */
    public final float f51e;

    /* JADX INFO: renamed from: f */
    public final float f52f;

    /* JADX INFO: renamed from: g */
    public final float[] f53g;

    /* JADX INFO: renamed from: h */
    public final float f54h;

    /* JADX INFO: renamed from: i */
    public final float f55i;

    /* JADX INFO: renamed from: j */
    public final float f56j;

    static {
        float[] fArr = AbstractC0001b.f8c;
        float fM11l = (float) ((((double) AbstractC0001b.m11l()) * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = AbstractC0001b.f6a;
        float f3 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f4 = fArr3[0] * f3;
        float f5 = fArr[1];
        float f6 = (fArr3[1] * f5) + f4;
        float f7 = fArr[2];
        float f8 = (fArr3[2] * f7) + f6;
        float[] fArr4 = fArr2[1];
        float f9 = (fArr4[2] * f7) + (fArr4[1] * f5) + (fArr4[0] * f3);
        float[] fArr5 = fArr2[2];
        float f10 = (f7 * fArr5[2]) + (f5 * fArr5[1]) + (f3 * fArr5[0]);
        float f11 = ((double) 1.0f) >= 0.9d ? 0.69f : 0.655f;
        float fExp = (1.0f - (((float) Math.exp(((-fM11l) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d = fExp;
        if (d > 1.0d) {
            fExp = 1.0f;
        } else if (d < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f8) * fExp) + 1.0f) - fExp, (((100.0f / f9) * fExp) + 1.0f) - fExp, (((100.0f / f10) * fExp) + 1.0f) - fExp};
        float f12 = 1.0f / ((5.0f * fM11l) + 1.0f);
        float f13 = f12 * f12 * f12 * f12;
        float f14 = 1.0f - f13;
        float fCbrt = (0.1f * f14 * f14 * ((float) Math.cbrt(((double) fM11l) * 5.0d))) + (f13 * fM11l);
        float fM11l2 = AbstractC0001b.m11l() / fArr[1];
        double d3 = fM11l2;
        float fSqrt = ((float) Math.sqrt(d3)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d3, 0.2d));
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * fCbrt) * f8)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * fCbrt) * f9)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[2] * fCbrt) * f10)) / 100.0d, 0.42d)};
        float f15 = fArr7[0];
        float f16 = (f15 * 400.0f) / (f15 + 27.13f);
        float f17 = fArr7[1];
        float f18 = (f17 * 400.0f) / (f17 + 27.13f);
        float f19 = fArr7[2];
        float[] fArr8 = {f16, f18, (400.0f * f19) / (f19 + 27.13f)};
        f46k = new C0018s(fM11l2, ((fArr8[2] * 0.05f) + (fArr8[0] * 2.0f) + fArr8[1]) * fPow, fPow, fPow, f11, 1.0f, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public C0018s(float f3, float f4, float f5, float f6, float f7, float f8, float[] fArr, float f9, float f10, float f11) {
        this.f52f = f3;
        this.f47a = f4;
        this.f48b = f5;
        this.f49c = f6;
        this.f50d = f7;
        this.f51e = f8;
        this.f53g = fArr;
        this.f54h = f9;
        this.f55i = f10;
        this.f56j = f11;
    }
}
