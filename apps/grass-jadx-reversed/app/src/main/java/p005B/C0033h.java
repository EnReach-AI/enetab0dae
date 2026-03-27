package p005B;

import android.graphics.Path;
import android.util.Log;

/* JADX INFO: renamed from: B.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0033h {

    /* JADX INFO: renamed from: a */
    public char f86a;

    /* JADX INFO: renamed from: b */
    public float[] f87b;

    /* JADX INFO: renamed from: a */
    public static void m168a(Path path, float f3, float f4, float f5, float f6, float f7, float f8, float f9, boolean z3, boolean z4) {
        double d;
        double d3;
        double radians = Math.toRadians(f9);
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        double d4 = f3;
        double d5 = f4;
        double d6 = (d5 * dSin) + (d4 * dCos);
        double d7 = d4;
        double d8 = f7;
        double d9 = d6 / d8;
        double d10 = f8;
        double d11 = ((d5 * dCos) + (((double) (-f3)) * dSin)) / d10;
        double d12 = d5;
        double d13 = f6;
        double d14 = ((d13 * dSin) + (((double) f5) * dCos)) / d8;
        double d15 = ((d13 * dCos) + (((double) (-f5)) * dSin)) / d10;
        double d16 = d9 - d14;
        double d17 = d11 - d15;
        double d18 = (d9 + d14) / 2.0d;
        double d19 = (d11 + d15) / 2.0d;
        double d20 = (d17 * d17) + (d16 * d16);
        if (d20 == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double d21 = (1.0d / d20) - 0.25d;
        if (d21 < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + d20);
            float fSqrt = (float) (Math.sqrt(d20) / 1.99999d);
            m168a(path, f3, f4, f5, f6, f7 * fSqrt, f8 * fSqrt, f9, z3, z4);
            return;
        }
        double dSqrt = Math.sqrt(d21);
        double d22 = d16 * dSqrt;
        double d23 = dSqrt * d17;
        if (z3 == z4) {
            d = d18 - d23;
            d3 = d19 + d22;
        } else {
            d = d18 + d23;
            d3 = d19 - d22;
        }
        double dAtan2 = Math.atan2(d11 - d3, d9 - d);
        double dAtan22 = Math.atan2(d15 - d3, d14 - d) - dAtan2;
        if (z4 != (dAtan22 >= 0.0d)) {
            dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
        }
        double d24 = d * d8;
        double d25 = d3 * d10;
        double d26 = (d24 * dCos) - (d25 * dSin);
        double d27 = (d25 * dCos) + (d24 * dSin);
        int iCeil = (int) Math.ceil(Math.abs((dAtan22 * 4.0d) / 3.141592653589793d));
        double dCos2 = Math.cos(radians);
        double dSin2 = Math.sin(radians);
        double dCos3 = Math.cos(dAtan2);
        double dSin3 = Math.sin(dAtan2);
        double d28 = -d8;
        double d29 = d28 * dCos2;
        double d30 = d10 * dSin2;
        double d31 = (d29 * dSin3) - (d30 * dCos3);
        double d32 = d28 * dSin2;
        double d33 = d10 * dCos2;
        double d34 = (dCos3 * d33) + (dSin3 * d32);
        double d35 = d33;
        double d36 = dAtan22 / ((double) iCeil);
        int i3 = 0;
        while (i3 < iCeil) {
            double d37 = dAtan2 + d36;
            double dSin4 = Math.sin(d37);
            double dCos4 = Math.cos(d37);
            double d38 = d36;
            double d39 = (((d8 * dCos2) * dCos4) + d26) - (d30 * dSin4);
            double d40 = d35;
            double d41 = d26;
            double d42 = (d40 * dSin4) + (d8 * dSin2 * dCos4) + d27;
            double d43 = (d29 * dSin4) - (d30 * dCos4);
            double d44 = (dCos4 * d40) + (dSin4 * d32);
            double d45 = d37 - dAtan2;
            double dTan = Math.tan(d45 / 2.0d);
            double dSqrt2 = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d45)) / 3.0d;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) ((d31 * dSqrt2) + d7), (float) ((d34 * dSqrt2) + d12), (float) (d39 - (dSqrt2 * d43)), (float) (d42 - (dSqrt2 * d44)), (float) d39, (float) d42);
            i3++;
            dAtan2 = d37;
            d32 = d32;
            dCos2 = dCos2;
            iCeil = iCeil;
            d34 = d44;
            d8 = d8;
            d31 = d43;
            d7 = d39;
            d12 = d42;
            d26 = d41;
            d36 = d38;
            d35 = d40;
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m169b(C0033h[] c0033hArr, Path path) {
        int i3;
        int i4;
        float[] fArr;
        char c3;
        int i5;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        C0033h[] c0033hArr2 = c0033hArr;
        int i6 = 6;
        float[] fArr2 = new float[6];
        char c4 = 'm';
        int i7 = 0;
        char c5 = 'm';
        int i8 = 0;
        while (i8 < c0033hArr2.length) {
            C0033h c0033h = c0033hArr2[i8];
            char c6 = c0033h.f86a;
            float[] fArr3 = c0033h.f87b;
            float f17 = fArr2[i7];
            float f18 = fArr2[1];
            float f19 = fArr2[2];
            float f20 = fArr2[3];
            float f21 = fArr2[4];
            float f22 = fArr2[5];
            switch (c6) {
                case 'A':
                case 'a':
                    i3 = 7;
                    break;
                case 'C':
                case 'c':
                    i3 = i6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i3 = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i3 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f21, f22);
                    f17 = f21;
                    f19 = f17;
                    f18 = f22;
                    f20 = f18;
                default:
                    i3 = 2;
                    break;
            }
            float f23 = f21;
            float f24 = f22;
            float f25 = f17;
            float f26 = f18;
            int i9 = i7;
            while (i9 < fArr3.length) {
                if (c6 != 'A') {
                    if (c6 != 'C') {
                        if (c6 == 'H') {
                            i4 = i9;
                            fArr = fArr3;
                            c3 = c6;
                            i5 = i8;
                            path.lineTo(fArr[i4], f26);
                            f25 = fArr[i4];
                        } else if (c6 == 'Q') {
                            i4 = i9;
                            fArr = fArr3;
                            c3 = c6;
                            i5 = i8;
                            int i10 = i4 + 1;
                            int i11 = i4 + 2;
                            int i12 = i4 + 3;
                            path.quadTo(fArr[i4], fArr[i10], fArr[i11], fArr[i12]);
                            f3 = fArr[i4];
                            f4 = fArr[i10];
                            f25 = fArr[i11];
                            f26 = fArr[i12];
                        } else if (c6 == 'V') {
                            i4 = i9;
                            fArr = fArr3;
                            c3 = c6;
                            i5 = i8;
                            path.lineTo(f25, fArr[i4]);
                            f26 = fArr[i4];
                        } else if (c6 != 'a') {
                            if (c6 != 'c') {
                                if (c6 == 'h') {
                                    i4 = i9;
                                    path.rLineTo(fArr3[i4], 0.0f);
                                    f25 += fArr3[i4];
                                } else if (c6 == 'q') {
                                    i4 = i9;
                                    float f27 = f26;
                                    float f28 = f25;
                                    int i13 = i4 + 1;
                                    int i14 = i4 + 2;
                                    int i15 = i4 + 3;
                                    path.rQuadTo(fArr3[i4], fArr3[i13], fArr3[i14], fArr3[i15]);
                                    float f29 = f28 + fArr3[i4];
                                    float f30 = fArr3[i13] + f27;
                                    float f31 = f28 + fArr3[i14];
                                    f26 = f27 + fArr3[i15];
                                    f20 = f30;
                                    f19 = f29;
                                    fArr = fArr3;
                                    c3 = c6;
                                    i5 = i8;
                                    f25 = f31;
                                } else if (c6 == 'v') {
                                    i4 = i9;
                                    path.rLineTo(0.0f, fArr3[i4]);
                                    f26 += fArr3[i4];
                                } else if (c6 == 'L') {
                                    i4 = i9;
                                    int i16 = i4 + 1;
                                    path.lineTo(fArr3[i4], fArr3[i16]);
                                    f25 = fArr3[i4];
                                    f26 = fArr3[i16];
                                } else if (c6 == 'M') {
                                    i4 = i9;
                                    f25 = fArr3[i4];
                                    f26 = fArr3[i4 + 1];
                                    if (i4 > 0) {
                                        path.lineTo(f25, f26);
                                    } else {
                                        path.moveTo(f25, f26);
                                        f24 = f26;
                                        f23 = f25;
                                    }
                                } else if (c6 == 'S') {
                                    i4 = i9;
                                    float f32 = f26;
                                    float f33 = f25;
                                    if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                        f11 = (f32 * 2.0f) - f20;
                                        f12 = (f33 * 2.0f) - f19;
                                    } else {
                                        f12 = f33;
                                        f11 = f32;
                                    }
                                    int i17 = i4 + 1;
                                    int i18 = i4 + 2;
                                    int i19 = i4 + 3;
                                    path.cubicTo(f12, f11, fArr3[i4], fArr3[i17], fArr3[i18], fArr3[i19]);
                                    float f34 = fArr3[i4];
                                    float f35 = fArr3[i17];
                                    f25 = fArr3[i18];
                                    f26 = fArr3[i19];
                                    f20 = f35;
                                    f19 = f34;
                                } else if (c6 == 'T') {
                                    i4 = i9;
                                    float f36 = f26;
                                    float f37 = f25;
                                    if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                        f6 = (f37 * 2.0f) - f19;
                                        f7 = (f36 * 2.0f) - f20;
                                    } else {
                                        f6 = f37;
                                        f7 = f36;
                                    }
                                    int i20 = i4 + 1;
                                    path.quadTo(f6, f7, fArr3[i4], fArr3[i20]);
                                    f8 = fArr3[i4];
                                    f10 = fArr3[i20];
                                    f20 = f7;
                                    f19 = f6;
                                    fArr = fArr3;
                                    c3 = c6;
                                    i5 = i8;
                                    f25 = f8;
                                    f26 = f10;
                                } else if (c6 == 'l') {
                                    i4 = i9;
                                    int i21 = i4 + 1;
                                    path.rLineTo(fArr3[i4], fArr3[i21]);
                                    f25 += fArr3[i4];
                                    f26 += fArr3[i21];
                                } else if (c6 == c4) {
                                    i4 = i9;
                                    float f38 = fArr3[i4];
                                    f25 += f38;
                                    float f39 = fArr3[i4 + 1];
                                    f26 += f39;
                                    if (i4 > 0) {
                                        path.rLineTo(f38, f39);
                                    } else {
                                        path.rMoveTo(f38, f39);
                                        f24 = f26;
                                        f23 = f25;
                                    }
                                } else if (c6 == 's') {
                                    if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                        f13 = f26 - f20;
                                        f14 = f25 - f19;
                                    } else {
                                        f14 = 0.0f;
                                        f13 = 0.0f;
                                    }
                                    int i22 = i9 + 1;
                                    int i23 = i9 + 2;
                                    int i24 = i9 + 3;
                                    i4 = i9;
                                    f5 = f26;
                                    float f40 = f25;
                                    path.rCubicTo(f14, f13, fArr3[i9], fArr3[i22], fArr3[i23], fArr3[i24]);
                                    f6 = f40 + fArr3[i4];
                                    f7 = f5 + fArr3[i22];
                                    f8 = f40 + fArr3[i23];
                                    f9 = fArr3[i24];
                                } else if (c6 != 't') {
                                    i4 = i9;
                                } else {
                                    if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                        f15 = f25 - f19;
                                        f16 = f26 - f20;
                                    } else {
                                        f16 = 0.0f;
                                        f15 = 0.0f;
                                    }
                                    int i25 = i9 + 1;
                                    path.rQuadTo(f15, f16, fArr3[i9], fArr3[i25]);
                                    float f41 = f15 + f25;
                                    float f42 = f16 + f26;
                                    f25 += fArr3[i9];
                                    f26 += fArr3[i25];
                                    f20 = f42;
                                    i4 = i9;
                                    fArr = fArr3;
                                    c3 = c6;
                                    i5 = i8;
                                    f19 = f41;
                                }
                                fArr = fArr3;
                                c3 = c6;
                                i5 = i8;
                            } else {
                                i4 = i9;
                                f5 = f26;
                                float f43 = f25;
                                int i26 = i4 + 2;
                                int i27 = i4 + 3;
                                int i28 = i4 + 4;
                                int i29 = i4 + 5;
                                path.rCubicTo(fArr3[i4], fArr3[i4 + 1], fArr3[i26], fArr3[i27], fArr3[i28], fArr3[i29]);
                                f6 = f43 + fArr3[i26];
                                f7 = f5 + fArr3[i27];
                                f8 = f43 + fArr3[i28];
                                f9 = fArr3[i29];
                            }
                            f10 = f9 + f5;
                            f20 = f7;
                            f19 = f6;
                            fArr = fArr3;
                            c3 = c6;
                            i5 = i8;
                            f25 = f8;
                            f26 = f10;
                        } else {
                            i4 = i9;
                            float f44 = f26;
                            float f45 = f25;
                            int i30 = i4 + 5;
                            int i31 = i4 + 6;
                            fArr = fArr3;
                            c3 = c6;
                            i5 = i8;
                            m168a(path, f45, f44, fArr3[i30] + f45, fArr3[i31] + f44, fArr3[i4], fArr3[i4 + 1], fArr3[i4 + 2], fArr3[i4 + 3] != 0.0f, fArr3[i4 + 4] != 0.0f);
                            f25 = f45 + fArr[i30];
                            f26 = f44 + fArr[i31];
                        }
                        i9 = i4 + i3;
                        c5 = c3;
                        c6 = c5;
                        fArr3 = fArr;
                        i8 = i5;
                        c4 = 'm';
                        i7 = 0;
                    } else {
                        i4 = i9;
                        fArr = fArr3;
                        c3 = c6;
                        i5 = i8;
                        int i32 = i4 + 2;
                        int i33 = i4 + 3;
                        int i34 = i4 + 4;
                        int i35 = i4 + 5;
                        path.cubicTo(fArr[i4], fArr[i4 + 1], fArr[i32], fArr[i33], fArr[i34], fArr[i35]);
                        f25 = fArr[i34];
                        f26 = fArr[i35];
                        f3 = fArr[i32];
                        f4 = fArr[i33];
                    }
                    f19 = f3;
                    f20 = f4;
                    i9 = i4 + i3;
                    c5 = c3;
                    c6 = c5;
                    fArr3 = fArr;
                    i8 = i5;
                    c4 = 'm';
                    i7 = 0;
                } else {
                    i4 = i9;
                    fArr = fArr3;
                    c3 = c6;
                    i5 = i8;
                    int i36 = i4 + 5;
                    int i37 = i4 + 6;
                    m168a(path, f25, f26, fArr[i36], fArr[i37], fArr[i4], fArr[i4 + 1], fArr[i4 + 2], fArr[i4 + 3] != 0.0f, fArr[i4 + 4] != 0.0f);
                    f25 = fArr[i36];
                    f26 = fArr[i37];
                }
                f20 = f26;
                f19 = f25;
                i9 = i4 + i3;
                c5 = c3;
                c6 = c5;
                fArr3 = fArr;
                i8 = i5;
                c4 = 'm';
                i7 = 0;
            }
            int i38 = i8;
            int i39 = i7;
            fArr2[i39] = f25;
            fArr2[1] = f26;
            fArr2[2] = f19;
            fArr2[3] = f20;
            fArr2[4] = f23;
            fArr2[5] = f24;
            i8 = i38 + 1;
            i6 = 6;
            c4 = 'm';
            i7 = i39;
            c5 = c0033hArr[i38].f86a;
            c0033hArr2 = c0033hArr;
        }
    }
}
