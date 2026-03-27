package p001A;

import android.graphics.Color;

/* JADX INFO: renamed from: A.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0000a {

    /* JADX INFO: renamed from: a */
    public final float f0a;

    /* JADX INFO: renamed from: b */
    public final float f1b;

    /* JADX INFO: renamed from: c */
    public final float f2c;

    /* JADX INFO: renamed from: d */
    public final float f3d;

    /* JADX INFO: renamed from: e */
    public final float f4e;

    /* JADX INFO: renamed from: f */
    public final float f5f;

    public C0000a(float f3, float f4, float f5, float f6, float f7, float f8) {
        this.f0a = f3;
        this.f1b = f4;
        this.f2c = f5;
        this.f3d = f6;
        this.f4e = f7;
        this.f5f = f8;
    }

    /* JADX INFO: renamed from: a */
    public static C0000a m0a(int i3) {
        C0018s c0018s = C0018s.f46k;
        float fM6e = AbstractC0001b.m6e(Color.red(i3));
        float fM6e2 = AbstractC0001b.m6e(Color.green(i3));
        float fM6e3 = AbstractC0001b.m6e(Color.blue(i3));
        float[][] fArr = AbstractC0001b.f9d;
        float[] fArr2 = fArr[0];
        float f3 = (fArr2[2] * fM6e3) + (fArr2[1] * fM6e2) + (fArr2[0] * fM6e);
        float[] fArr3 = fArr[1];
        float f4 = (fArr3[2] * fM6e3) + (fArr3[1] * fM6e2) + (fArr3[0] * fM6e);
        float[] fArr4 = fArr[2];
        float[] fArr5 = {f3, f4, (fM6e3 * fArr4[2]) + (fM6e2 * fArr4[1]) + (fM6e * fArr4[0])};
        float[][] fArr6 = AbstractC0001b.f6a;
        float f5 = fArr5[0];
        float[] fArr7 = fArr6[0];
        float f6 = fArr7[0] * f5;
        float f7 = fArr5[1];
        float f8 = (fArr7[1] * f7) + f6;
        float f9 = fArr5[2];
        float f10 = (fArr7[2] * f9) + f8;
        float[] fArr8 = fArr6[1];
        float f11 = (fArr8[2] * f9) + (fArr8[1] * f7) + (fArr8[0] * f5);
        float[] fArr9 = fArr6[2];
        float f12 = (f9 * fArr9[2]) + (f7 * fArr9[1]) + (f5 * fArr9[0]);
        float[] fArr10 = c0018s.f53g;
        float f13 = fArr10[0] * f10;
        float f14 = fArr10[1] * f11;
        float f15 = fArr10[2] * f12;
        float fAbs = Math.abs(f13);
        float f16 = c0018s.f54h;
        float fPow = (float) Math.pow(((double) (fAbs * f16)) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (Math.abs(f14) * f16)) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (Math.abs(f15) * f16)) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f13) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f14) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f15) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d = fSignum3;
        float f17 = ((float) (((((double) fSignum2) * (-12.0d)) + (((double) fSignum) * 11.0d)) + d)) / 11.0f;
        float f18 = ((float) (((double) (fSignum + fSignum2)) - (d * 2.0d))) / 9.0f;
        float f19 = fSignum2 * 20.0f;
        float f20 = ((21.0f * fSignum3) + ((fSignum * 20.0f) + f19)) / 20.0f;
        float f21 = (((fSignum * 40.0f) + f19) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f18, f17)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f22 = fAtan2;
        float f23 = (3.1415927f * f22) / 180.0f;
        float f24 = f21 * c0018s.f48b;
        float f25 = c0018s.f47a;
        float f26 = c0018s.f50d;
        float fPow4 = ((float) Math.pow(f24 / f25, c0018s.f56j * f26)) * 100.0f;
        Math.sqrt(fPow4 / 100.0f);
        float f27 = f25 + 4.0f;
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, c0018s.f52f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) (((double) f22) < 20.14d ? 360.0f + f22 : f22)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * c0018s.f51e) * c0018s.f49c) * ((float) Math.sqrt((f18 * f18) + (f17 * f17)))) / (f20 + 0.305f), 0.9d)) * ((float) Math.sqrt(((double) fPow4) / 100.0d));
        float f28 = c0018s.f55i * fPow5;
        Math.sqrt((r4 * f26) / f27);
        float f29 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((f28 * 0.0228f) + 1.0f)) * 43.85965f;
        double d3 = f23;
        return new C0000a(f22, fPow5, fPow4, f29, fLog * ((float) Math.cos(d3)), fLog * ((float) Math.sin(d3)));
    }

    /* JADX INFO: renamed from: b */
    public static C0000a m1b(float f3, float f4, float f5) {
        C0018s c0018s = C0018s.f46k;
        float f6 = c0018s.f50d;
        Math.sqrt(((double) f3) / 100.0d);
        float f7 = c0018s.f47a + 4.0f;
        float f8 = c0018s.f55i * f4;
        Math.sqrt(((f4 / ((float) Math.sqrt(r1))) * c0018s.f50d) / f7);
        float f9 = (1.7f * f3) / ((0.007f * f3) + 1.0f);
        float fLog = ((float) Math.log((((double) f8) * 0.0228d) + 1.0d)) * 43.85965f;
        double d = (3.1415927f * f5) / 180.0f;
        return new C0000a(f5, f4, f3, f9, fLog * ((float) Math.cos(d)), fLog * ((float) Math.sin(d)));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m2c(p001A.C0018s r17) {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p001A.C0000a.m2c(A.s):int");
    }
}
