package p039M0;

import java.io.Serializable;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: renamed from: M0.q */
/* JADX INFO: loaded from: classes.dex */
public final class C0502q implements Serializable {

    /* JADX INFO: renamed from: l */
    public static final C0502q f1168l = new C0502q();
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final String f1169e;

    /* JADX INFO: renamed from: f */
    public final EnumC0501p f1170f;

    /* JADX INFO: renamed from: g */
    public final Locale f1171g;

    /* JADX INFO: renamed from: h */
    public final String f1172h;

    /* JADX INFO: renamed from: i */
    public final Boolean f1173i;

    /* JADX INFO: renamed from: j */
    public final C0500o f1174j;

    /* JADX INFO: renamed from: k */
    public transient TimeZone f1175k;

    public C0502q() {
        this("", EnumC0501p.f1157e, "", "", C0500o.f1154c, null);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1014a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    /* JADX INFO: renamed from: b */
    public final Boolean m1015b(EnumC0499n enumC0499n) {
        C0500o c0500o = this.f1174j;
        c0500o.getClass();
        int iOrdinal = 1 << enumC0499n.ordinal();
        if ((c0500o.f1156b & iOrdinal) != 0) {
            return Boolean.FALSE;
        }
        if ((iOrdinal & c0500o.f1155a) != 0) {
            return Boolean.TRUE;
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public final TimeZone m1016c() {
        TimeZone timeZone = this.f1175k;
        if (timeZone != null) {
            return timeZone;
        }
        String str = this.f1172h;
        if (str == null) {
            return null;
        }
        TimeZone timeZone2 = TimeZone.getTimeZone(str);
        this.f1175k = timeZone2;
        return timeZone2;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m1017d() {
        String str;
        return (this.f1175k == null && ((str = this.f1172h) == null || str.isEmpty())) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0039 A[PHI: r1
      0x0039: PHI (r1v3 M0.o) = (r1v1 M0.o), (r1v2 M0.o), (r1v1 M0.o), (r1v1 M0.o) binds: [B:26:0x0037, B:40:0x0058, B:38:0x0055, B:30:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p039M0.C0502q m1018e(p039M0.C0502q r10) {
        /*
            r9 = this;
            if (r10 == 0) goto L81
            M0.q r0 = p039M0.C0502q.f1168l
            if (r10 == r0) goto L81
            if (r10 != r9) goto La
            goto L81
        La:
            if (r9 != r0) goto Ld
            return r10
        Ld:
            java.lang.String r0 = r10.f1169e
            if (r0 == 0) goto L1a
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L18
            goto L1a
        L18:
            r2 = r0
            goto L1d
        L1a:
            java.lang.String r0 = r9.f1169e
            goto L18
        L1d:
            M0.p r0 = p039M0.EnumC0501p.f1157e
            M0.p r1 = r10.f1170f
            if (r1 != r0) goto L27
            M0.p r0 = r9.f1170f
            r3 = r0
            goto L28
        L27:
            r3 = r1
        L28:
            java.util.Locale r0 = r10.f1171g
            if (r0 != 0) goto L2e
            java.util.Locale r0 = r9.f1171g
        L2e:
            r4 = r0
            M0.o r0 = r10.f1174j
            M0.o r1 = r9.f1174j
            if (r1 != 0) goto L37
        L35:
            r7 = r0
            goto L5e
        L37:
            if (r0 != 0) goto L3b
        L39:
            r0 = r1
            goto L35
        L3b:
            int r5 = r0.f1156b
            int r6 = r0.f1155a
            if (r5 != 0) goto L44
            if (r6 != 0) goto L44
            goto L39
        L44:
            int r7 = r1.f1156b
            int r8 = r1.f1155a
            if (r8 != 0) goto L4d
            if (r7 != 0) goto L4d
            goto L35
        L4d:
            int r0 = ~r5
            r0 = r0 & r8
            r0 = r0 | r6
            int r6 = ~r6
            r6 = r6 & r7
            r5 = r5 | r6
            if (r0 != r8) goto L58
            if (r5 != r7) goto L58
            goto L39
        L58:
            M0.o r1 = new M0.o
            r1.<init>(r0, r5)
            goto L39
        L5e:
            java.lang.Boolean r0 = r10.f1173i
            if (r0 != 0) goto L64
            java.lang.Boolean r0 = r9.f1173i
        L64:
            r8 = r0
            java.lang.String r0 = r10.f1172h
            if (r0 == 0) goto L75
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L70
            goto L75
        L70:
            java.util.TimeZone r10 = r10.f1175k
        L72:
            r6 = r10
            r5 = r0
            goto L7a
        L75:
            java.util.TimeZone r10 = r9.f1175k
            java.lang.String r0 = r9.f1172h
            goto L72
        L7a:
            M0.q r10 = new M0.q
            r1 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r10
        L81:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p039M0.C0502q.m1018e(M0.q):M0.q");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C0502q.class) {
            return false;
        }
        C0502q c0502q = (C0502q) obj;
        if (this.f1170f == c0502q.f1170f && this.f1174j.equals(c0502q.f1174j)) {
            return m1014a(this.f1173i, c0502q.f1173i) && m1014a(this.f1172h, c0502q.f1172h) && m1014a(this.f1169e, c0502q.f1169e) && m1014a(this.f1175k, c0502q.f1175k) && m1014a(this.f1171g, c0502q.f1171g);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f1172h;
        int iHashCode = str == null ? 1 : str.hashCode();
        String str2 = this.f1169e;
        if (str2 != null) {
            iHashCode ^= str2.hashCode();
        }
        int iHashCode2 = this.f1170f.hashCode() + iHashCode;
        Boolean bool = this.f1173i;
        if (bool != null) {
            iHashCode2 ^= bool.hashCode();
        }
        Locale locale = this.f1171g;
        if (locale != null) {
            iHashCode2 += locale.hashCode();
        }
        return this.f1174j.hashCode() ^ iHashCode2;
    }

    public final String toString() {
        return "JsonFormat.Value(pattern=" + this.f1169e + ",shape=" + this.f1170f + ",lenient=" + this.f1173i + ",locale=" + this.f1171g + ",timezone=" + this.f1172h + ",features=" + this.f1174j + ")";
    }

    public C0502q(String str, EnumC0501p enumC0501p, String str2, String str3, C0500o c0500o, Boolean bool) {
        this(str, enumC0501p, (str2 == null || str2.length() == 0 || "##default".equals(str2)) ? null : new Locale(str2), (str3 == null || str3.length() == 0 || "##default".equals(str3)) ? null : str3, null, c0500o, bool);
    }

    public C0502q(String str, EnumC0501p enumC0501p, Locale locale, String str2, TimeZone timeZone, C0500o c0500o, Boolean bool) {
        this.f1169e = str == null ? "" : str;
        this.f1170f = enumC0501p == null ? EnumC0501p.f1157e : enumC0501p;
        this.f1171g = locale;
        this.f1175k = timeZone;
        this.f1172h = str2;
        this.f1174j = c0500o == null ? C0500o.f1154c : c0500o;
        this.f1173i = bool;
    }
}
