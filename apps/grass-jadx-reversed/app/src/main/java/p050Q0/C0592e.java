package p050Q0;

/* JADX INFO: renamed from: Q0.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0592e {

    /* JADX INFO: renamed from: a */
    public static final char[] f1514a = AbstractC0589b.m1335b(true);

    /* JADX INFO: renamed from: b */
    public static final byte[] f1515b = AbstractC0589b.m1334a(true);

    /* JADX INFO: renamed from: c */
    public static final C0592e f1516c = new C0592e();

    /* JADX INFO: renamed from: a */
    public static int m1338a(int i3, int i4) {
        if (i4 >= 56320 && i4 <= 57343) {
            return (i4 - 56320) + ((i3 - 55296) << 10) + 65536;
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i3) + ", second 0x" + Integer.toHexString(i4) + "; illegal combination");
    }

    /* JADX INFO: renamed from: b */
    public static void m1339b(int i3) {
        throw new IllegalArgumentException(C0599l.m1370c(i3));
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x010d, code lost:
    
        if (r7 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0113, code lost:
    
        return java.util.Arrays.copyOfRange(r2, 0, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0114, code lost:
    
        r7.f1843i = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x011a, code lost:
    
        return r7.m1639f();
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0101 A[SYNTHETIC] */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] m1340c(java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p050Q0.C0592e.m1340c(java.lang.String):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:
    
        r11 = new char[]{'\\', 0, '0', '0', 0, 0};
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0045, code lost:
    
        r14 = r8 + 1;
        r8 = r17.charAt(r8);
        r15 = r4[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004f, code lost:
    
        if (r15 >= 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0051, code lost:
    
        r11[1] = 'u';
        r15 = p050Q0.C0592e.f1514a;
        r11[4] = r15[r8 >> 4];
        r11[5] = r15[r8 & 15];
        r12 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0068, code lost:
    
        r11[1] = (char) r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006b, code lost:
    
        r8 = r10 + r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006e, code lost:
    
        if (r8 <= r2.length) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0070, code lost:
    
        r8 = r2.length - r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0072, code lost:
    
        if (r8 <= 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0074, code lost:
    
        java.lang.System.arraycopy(r11, 0, r2, r10, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0077, code lost:
    
        if (r9 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0079, code lost:
    
        r9 = new p066W0.C0690q(null);
        r9.f1876h = r2;
        r9.f1877i = r2.length;
        r9.f1871c = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0085, code lost:
    
        r2 = r9.m1658k();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0089, code lost:
    
        r12 = r12 - r8;
        java.lang.System.arraycopy(r11, r8, r2, 0, r12);
        r10 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0096, code lost:
    
        throw new java.lang.IllegalStateException(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0097, code lost:
    
        java.lang.System.arraycopy(r11, 0, r2, r10, r12);
        r10 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
    
        r12 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
    
        if (r11 != null) goto L11;
     */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static char[] m1341d(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p050Q0.C0592e.m1341d(java.lang.String):char[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x015c, code lost:
    
        if (r6 != null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0162, code lost:
    
        return java.util.Arrays.copyOfRange(r1, 0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0163, code lost:
    
        r6.f1843i = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0169, code lost:
    
        return r6.m1639f();
     */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] m1342e(java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p050Q0.C0592e.m1342e(java.lang.String):byte[]");
    }
}
