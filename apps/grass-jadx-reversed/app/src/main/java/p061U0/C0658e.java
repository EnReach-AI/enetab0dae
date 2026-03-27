package p061U0;

import java.util.BitSet;
import java.util.concurrent.atomic.AtomicReference;
import p005B.AbstractC0032g;

/* JADX INFO: renamed from: U0.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0658e {

    /* JADX INFO: renamed from: a */
    public final C0658e f1785a;

    /* JADX INFO: renamed from: b */
    public final AtomicReference f1786b;

    /* JADX INFO: renamed from: c */
    public final int f1787c;

    /* JADX INFO: renamed from: d */
    public final int f1788d;

    /* JADX INFO: renamed from: e */
    public boolean f1789e;

    /* JADX INFO: renamed from: f */
    public String[] f1790f;

    /* JADX INFO: renamed from: g */
    public C0656c[] f1791g;

    /* JADX INFO: renamed from: h */
    public int f1792h;

    /* JADX INFO: renamed from: i */
    public int f1793i;

    /* JADX INFO: renamed from: j */
    public int f1794j;

    /* JADX INFO: renamed from: k */
    public int f1795k;

    /* JADX INFO: renamed from: l */
    public boolean f1796l;

    /* JADX INFO: renamed from: m */
    public BitSet f1797m;

    public C0658e(int i3) {
        this.f1785a = null;
        this.f1787c = i3;
        this.f1789e = true;
        this.f1788d = -1;
        this.f1796l = false;
        this.f1795k = 0;
        this.f1786b = new AtomicReference(new C0657d(new String[64], new C0656c[32]));
    }

    /* JADX INFO: renamed from: a */
    public final int m1616a(int i3) {
        int i4 = i3 + (i3 >>> 15);
        int i5 = i4 ^ (i4 << 7);
        return (i5 + (i5 >>> 3)) & this.f1794j;
    }

    /* JADX INFO: renamed from: b */
    public final int m1617b(String str) {
        int length = str.length();
        int iCharAt = this.f1787c;
        for (int i3 = 0; i3 < length; i3++) {
            iCharAt = (iCharAt * 33) + str.charAt(i3);
        }
        if (iCharAt == 0) {
            return 1;
        }
        return iCharAt;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0085 A[EDGE_INSN: B:113:0x0085->B:48:0x0085 BREAK  A[LOOP:1: B:34:0x0062->B:46:0x0081], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081 A[LOOP:1: B:34:0x0062->B:46:0x0081, LOOP_END] */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m1618c(int r18, int r19, int r20, char[] r21) throws com.fasterxml.jackson.core.exc.C1131b {
        /*
            Method dump skipped, instruction units count: 533
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p061U0.C0658e.m1618c(int, int, int, char[]):java.lang.String");
    }

    public C0658e(C0658e c0658e, int i3, int i4, C0657d c0657d) {
        this.f1785a = c0658e;
        this.f1787c = i4;
        this.f1786b = null;
        this.f1788d = i3;
        this.f1789e = AbstractC0032g.m144b(2, i3);
        String[] strArr = c0657d.f1783c;
        this.f1790f = strArr;
        this.f1791g = c0657d.f1784d;
        this.f1792h = c0657d.f1781a;
        this.f1795k = c0657d.f1782b;
        int length = strArr.length;
        this.f1793i = length - (length >> 2);
        this.f1794j = length - 1;
        this.f1796l = true;
    }
}
