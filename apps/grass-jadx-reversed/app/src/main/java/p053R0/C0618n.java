package p053R0;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: R0.n */
/* JADX INFO: loaded from: classes.dex */
public final class C0618n extends AbstractC0605a {

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f1585b;

    @Override // p053R0.AbstractC0605a
    /* JADX INFO: renamed from: c */
    public final long mo1381c() {
        switch (this.f1585b) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return Double.doubleToRawLongBits(Double.NaN);
            default:
                return Float.floatToRawIntBits(Float.NaN);
        }
    }

    @Override // p053R0.AbstractC0605a
    /* JADX INFO: renamed from: d */
    public final long mo1382d() {
        switch (this.f1585b) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return Double.doubleToRawLongBits(Double.NEGATIVE_INFINITY);
            default:
                return Float.floatToRawIntBits(Float.NEGATIVE_INFINITY);
        }
    }

    @Override // p053R0.AbstractC0605a
    /* JADX INFO: renamed from: f */
    public final long mo1384f() {
        switch (this.f1585b) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return Double.doubleToRawLongBits(Double.POSITIVE_INFINITY);
            default:
                return Float.floatToRawIntBits(Float.POSITIVE_INFINITY);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0089  */
    @Override // p053R0.AbstractC0605a
    /* JADX INFO: renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long mo1385h(java.lang.CharSequence r5, int r6, boolean r7, long r8, int r10, boolean r11, int r12) {
        /*
            r4 = this;
            int r0 = r4.f1585b
            switch(r0) {
                case 0: goto L58;
                default: goto L5;
            }
        L5:
            r0 = 0
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 != 0) goto L12
            if (r7 == 0) goto L10
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L3f
        L10:
            r7 = 0
            goto L3f
        L12:
            r0 = 2143289344(0x7fc00000, float:NaN)
            r1 = 38
            r2 = -45
            if (r11 == 0) goto L37
            if (r2 > r12) goto L35
            if (r12 > r1) goto L35
            float r10 = p053R0.AbstractC0608d.m1411d(r7, r8, r12)
            r1 = 1
            long r8 = r8 + r1
            float r7 = p053R0.AbstractC0608d.m1411d(r7, r8, r12)
            boolean r8 = java.lang.Float.isNaN(r10)
            if (r8 != 0) goto L35
            int r7 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r7 != 0) goto L35
            r7 = r10
            goto L3f
        L35:
            r7 = r0
            goto L3f
        L37:
            if (r2 > r10) goto L35
            if (r10 > r1) goto L35
            float r7 = p053R0.AbstractC0608d.m1411d(r7, r8, r10)
        L3f:
            boolean r8 = java.lang.Float.isNaN(r7)
            if (r8 == 0) goto L52
            r7 = 0
            java.lang.CharSequence r5 = r5.subSequence(r7, r6)
            java.lang.String r5 = r5.toString()
            float r7 = java.lang.Float.parseFloat(r5)
        L52:
            int r5 = java.lang.Float.floatToRawIntBits(r7)
            long r5 = (long) r5
            return r5
        L58:
            r0 = 0
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 != 0) goto L66
            if (r7 == 0) goto L63
            r7 = -9223372036854775808
            goto L93
        L63:
            r7 = 0
            goto L93
        L66:
            r0 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            r2 = 308(0x134, float:4.32E-43)
            r3 = -325(0xfffffffffffffebb, float:NaN)
            if (r11 == 0) goto L8b
            if (r3 > r12) goto L89
            if (r12 > r2) goto L89
            double r10 = p053R0.AbstractC0608d.m1410c(r7, r8, r12)
            r2 = 1
            long r8 = r8 + r2
            double r7 = p053R0.AbstractC0608d.m1410c(r7, r8, r12)
            boolean r9 = java.lang.Double.isNaN(r10)
            if (r9 != 0) goto L89
            int r7 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r7 != 0) goto L89
            r7 = r10
            goto L93
        L89:
            r7 = r0
            goto L93
        L8b:
            if (r3 > r10) goto L89
            if (r10 > r2) goto L89
            double r7 = p053R0.AbstractC0608d.m1410c(r7, r8, r10)
        L93:
            boolean r9 = java.lang.Double.isNaN(r7)
            if (r9 == 0) goto La6
            r7 = 0
            java.lang.CharSequence r5 = r5.subSequence(r7, r6)
            java.lang.String r5 = r5.toString()
            double r7 = java.lang.Double.parseDouble(r5)
        La6:
            long r5 = java.lang.Double.doubleToRawLongBits(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p053R0.C0618n.mo1385h(java.lang.CharSequence, int, boolean, long, int, boolean, int):long");
    }

    @Override // p053R0.AbstractC0605a
    /* JADX INFO: renamed from: i */
    public final long mo1386i(CharSequence charSequence, int i3, boolean z3, long j2, int i4, boolean z4, int i5) {
        double dScalb;
        float fScalb;
        switch (this.f1585b) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                int i6 = z4 ? i5 : i4;
                if (-1022 > i6 || i6 > 1023) {
                    dScalb = Double.NaN;
                } else {
                    dScalb = Math.scalb(1.0d, i6) * Math.abs(j2);
                    if (z3) {
                        dScalb = -dScalb;
                    }
                }
                if (Double.isNaN(dScalb)) {
                    dScalb = Double.parseDouble(charSequence.subSequence(0, i3).toString());
                }
                return Double.doubleToRawLongBits(dScalb);
            default:
                if (z4) {
                    i4 = i5;
                }
                if (-126 > i4 || i4 > 127) {
                    fScalb = Float.NaN;
                } else {
                    fScalb = Math.scalb(1.0f, i4) * Math.abs(j2);
                    if (z3) {
                        fScalb = -fScalb;
                    }
                }
                if (Float.isNaN(fScalb)) {
                    fScalb = Float.parseFloat(charSequence.subSequence(0, i3).toString());
                }
                return Float.floatToRawIntBits(fScalb);
        }
    }
}
