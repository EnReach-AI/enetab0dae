package p066W0;

import p042N0.AbstractC0540h;

/* JADX INFO: renamed from: W0.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0677d extends AbstractC0679f {

    /* JADX INFO: renamed from: h */
    public static final C0677d f1844h;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: g */
    public final String f1847g;

    /* JADX INFO: renamed from: f */
    public final int f1846f = 2;

    /* JADX INFO: renamed from: e */
    public final char[] f1845e = new char[32];

    static {
        String property;
        try {
            property = System.getProperty("line.separator");
        } catch (Throwable unused) {
            property = "\n";
        }
        f1844h = new C0677d(property);
    }

    public C0677d(String str) {
        int i3 = 0;
        for (int i4 = 0; i4 < 16; i4++) {
            "  ".getChars(0, 2, this.f1845e, i3);
            i3 += 2;
        }
        this.f1847g = str;
    }

    @Override // p066W0.AbstractC0679f
    /* JADX INFO: renamed from: b */
    public final void mo1640b(AbstractC0540h abstractC0540h, int i3) {
        abstractC0540h.mo1113F(this.f1847g);
        if (i3 <= 0) {
            return;
        }
        int length = i3 * this.f1846f;
        while (true) {
            char[] cArr = this.f1845e;
            if (length <= cArr.length) {
                abstractC0540h.mo1114G(cArr, length);
                return;
            } else {
                abstractC0540h.mo1114G(cArr, cArr.length);
                length -= cArr.length;
            }
        }
    }
}
