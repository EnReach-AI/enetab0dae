package p059T1;

import java.nio.charset.StandardCharsets;

/* JADX INFO: renamed from: T1.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0647c {

    /* JADX INFO: renamed from: a */
    public final String f1726a;

    /* JADX INFO: renamed from: b */
    public EnumC0650f f1727b;

    /* JADX INFO: renamed from: c */
    public final StringBuilder f1728c;

    /* JADX INFO: renamed from: d */
    public int f1729d;

    /* JADX INFO: renamed from: e */
    public int f1730e;

    /* JADX INFO: renamed from: f */
    public C0649e f1731f;

    /* JADX INFO: renamed from: g */
    public int f1732g;

    public C0647c(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i3 = 0; i3 < length; i3++) {
            char c3 = (char) (bytes[i3] & 255);
            if (c3 == '?' && str.charAt(i3) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c3);
        }
        this.f1726a = sb.toString();
        this.f1727b = EnumC0650f.f1746e;
        this.f1728c = new StringBuilder(str.length());
        this.f1730e = -1;
    }

    /* JADX INFO: renamed from: a */
    public final char m1594a() {
        return this.f1726a.charAt(this.f1729d);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m1595b() {
        return this.f1729d < this.f1726a.length() - this.f1732g;
    }

    /* JADX INFO: renamed from: c */
    public final void m1596c(int i3) {
        C0649e c0649e = this.f1731f;
        if (c0649e == null || i3 > c0649e.f1739b) {
            this.f1731f = C0649e.m1599e(i3, this.f1727b);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m1597d(char c3) {
        this.f1728c.append(c3);
    }
}
