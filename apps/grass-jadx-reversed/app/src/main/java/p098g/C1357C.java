package p098g;

/* JADX INFO: renamed from: g.C */
/* JADX INFO: loaded from: classes.dex */
public final class C1357C {

    /* JADX INFO: renamed from: d */
    public static C1357C f4827d;

    /* JADX INFO: renamed from: a */
    public long f4828a;

    /* JADX INFO: renamed from: b */
    public long f4829b;

    /* JADX INFO: renamed from: c */
    public int f4830c;

    /* JADX INFO: renamed from: a */
    public final void m3311a(long j2, double d, double d3) {
        double d4 = (0.01720197f * ((j2 - 946728000000L) / 8.64E7f)) + 6.24006f;
        double dSin = (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + (Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (Math.sin(d4) * 0.03341960161924362d) + d4 + 1.796593063d + 3.141592653589793d;
        double dSin2 = (Math.sin(2.0d * dSin) * (-0.0069d)) + (Math.sin(d4) * 0.0053d) + ((double) (Math.round(((double) (r3 - 9.0E-4f)) - r7) + 9.0E-4f)) + ((-d3) / 360.0d);
        double dAsin = Math.asin(Math.sin(0.4092797040939331d) * Math.sin(dSin));
        double d5 = 0.01745329238474369d * d;
        double dSin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(dAsin) * Math.sin(d5))) / (Math.cos(dAsin) * Math.cos(d5));
        if (dSin3 >= 1.0d) {
            this.f4830c = 1;
            this.f4828a = -1L;
            this.f4829b = -1L;
        } else {
            if (dSin3 <= -1.0d) {
                this.f4830c = 0;
                this.f4828a = -1L;
                this.f4829b = -1L;
                return;
            }
            double dAcos = (float) (Math.acos(dSin3) / 6.283185307179586d);
            this.f4828a = Math.round((dSin2 + dAcos) * 8.64E7d) + 946728000000L;
            long jRound = Math.round((dSin2 - dAcos) * 8.64E7d) + 946728000000L;
            this.f4829b = jRound;
            if (jRound >= j2 || this.f4828a <= j2) {
                this.f4830c = 1;
            } else {
                this.f4830c = 0;
            }
        }
    }
}
