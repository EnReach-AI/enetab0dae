package p023H;

/* JADX INFO: renamed from: H.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0238a {

    /* JADX INFO: renamed from: e */
    public static final byte[] f582e = new byte[1792];

    /* JADX INFO: renamed from: a */
    public final CharSequence f583a;

    /* JADX INFO: renamed from: b */
    public final int f584b;

    /* JADX INFO: renamed from: c */
    public int f585c;

    /* JADX INFO: renamed from: d */
    public char f586d;

    static {
        for (int i3 = 0; i3 < 1792; i3++) {
            f582e[i3] = Character.getDirectionality(i3);
        }
    }

    public C0238a(CharSequence charSequence) {
        this.f583a = charSequence;
        this.f584b = charSequence.length();
    }

    /* JADX INFO: renamed from: a */
    public final byte m476a() {
        int i3 = this.f585c - 1;
        CharSequence charSequence = this.f583a;
        char cCharAt = charSequence.charAt(i3);
        this.f586d = cCharAt;
        if (Character.isLowSurrogate(cCharAt)) {
            int iCodePointBefore = Character.codePointBefore(charSequence, this.f585c);
            this.f585c -= Character.charCount(iCodePointBefore);
            return Character.getDirectionality(iCodePointBefore);
        }
        this.f585c--;
        char c3 = this.f586d;
        return c3 < 1792 ? f582e[c3] : Character.getDirectionality(c3);
    }
}
