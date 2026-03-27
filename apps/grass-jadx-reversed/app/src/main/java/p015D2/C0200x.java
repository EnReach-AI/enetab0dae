package p015D2;

import p001A.C0003d;
import p005B.AbstractC0032g;
import p119m2.AbstractC1766e;
import p142s2.AbstractC1892g;

/* JADX INFO: renamed from: D2.x */
/* JADX INFO: loaded from: classes.dex */
public final class C0200x {

    /* JADX INFO: renamed from: a */
    public int f475a;

    /* JADX INFO: renamed from: b */
    public final C0003d f476b;

    /* JADX INFO: renamed from: c */
    public String f477c;

    /* JADX INFO: renamed from: d */
    public final StringBuilder f478d;

    /* JADX INFO: renamed from: e */
    public final String f479e;

    public C0200x(String str) {
        AbstractC1766e.m3920e("source", str);
        C0003d c0003d = new C0003d();
        c0003d.f16c = new Object[8];
        int[] iArr = new int[8];
        for (int i3 = 0; i3 < 8; i3++) {
            iArr[i3] = -1;
        }
        c0003d.f17d = iArr;
        c0003d.f15b = -1;
        this.f476b = c0003d;
        this.f478d = new StringBuilder();
        this.f479e = str;
    }

    /* JADX INFO: renamed from: o */
    public static /* synthetic */ void m369o(C0200x c0200x, String str, int i3, String str2, int i4) {
        if ((i4 & 2) != 0) {
            i3 = c0200x.f475a;
        }
        if ((i4 & 4) != 0) {
            str2 = "";
        }
        c0200x.m383n(i3, str, str2);
        throw null;
    }

    /* JADX INFO: renamed from: a */
    public final int m370a(CharSequence charSequence, int i3) {
        int i4 = i3 + 4;
        if (i4 < charSequence.length()) {
            this.f478d.append((char) (m385q(charSequence, i3 + 3) + (m385q(charSequence, i3) << 12) + (m385q(charSequence, i3 + 1) << 8) + (m385q(charSequence, i3 + 2) << 4)));
            return i4;
        }
        this.f475a = i3;
        if (i4 < charSequence.length()) {
            return m370a(charSequence, this.f475a);
        }
        m369o(this, "Unexpected EOF during unicode escape", 0, null, 6);
        throw null;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m371b() {
        int i3 = this.f475a;
        if (i3 == -1) {
            return false;
        }
        while (true) {
            String str = this.f479e;
            if (i3 >= str.length()) {
                this.f475a = i3;
                return false;
            }
            char cCharAt = str.charAt(i3);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f475a = i3;
                return !(cCharAt == '}' || cCharAt == ']' || cCharAt == ':' || cCharAt == ',');
            }
            i3++;
        }
    }

    /* JADX INFO: renamed from: c */
    public final boolean m372c(int i3) {
        int iM389u = m389u(i3);
        String str = this.f479e;
        if (iM389u >= str.length() || iM389u == -1) {
            m369o(this, "EOF", 0, null, 6);
            throw null;
        }
        int i4 = iM389u + 1;
        int iCharAt = str.charAt(iM389u) | ' ';
        if (iCharAt == 102) {
            m373d(i4, "alse");
            return false;
        }
        if (iCharAt == 116) {
            m373d(i4, "rue");
            return true;
        }
        m369o(this, "Expected valid boolean literal prefix, but had '" + m380k() + '\'', 0, null, 6);
        throw null;
    }

    /* JADX INFO: renamed from: d */
    public final void m373d(int i3, String str) {
        String str2 = this.f479e;
        if (str2.length() - i3 < str.length()) {
            m369o(this, "Unexpected end of boolean literal", 0, null, 6);
            throw null;
        }
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            if (str.charAt(i4) != (str2.charAt(i3 + i4) | ' ')) {
                m369o(this, "Expected valid boolean literal prefix, but had '" + m380k() + '\'', 0, null, 6);
                throw null;
            }
        }
        this.f475a = str.length() + i3;
    }

    /* JADX INFO: renamed from: e */
    public final String m374e() {
        m377h('\"');
        int i3 = this.f475a;
        String str = this.f479e;
        int iM4221n = AbstractC1892g.m4221n(str, '\"', i3, false, 4);
        if (iM4221n == -1) {
            m380k();
            m384p((byte) 1, false);
            throw null;
        }
        int i4 = i3;
        while (i4 < iM4221n) {
            if (str.charAt(i4) == '\\') {
                int iM389u = this.f475a;
                char cCharAt = str.charAt(i4);
                boolean z3 = false;
                while (cCharAt != '\"') {
                    if (cCharAt == '\\') {
                        this.f478d.append((CharSequence) str, iM389u, i4);
                        int iM389u2 = m389u(i4 + 1);
                        if (iM389u2 == -1) {
                            m369o(this, "Expected escape sequence to continue, got EOF", 0, null, 6);
                            throw null;
                        }
                        int iM370a = iM389u2 + 1;
                        char cCharAt2 = str.charAt(iM389u2);
                        if (cCharAt2 == 'u') {
                            iM370a = m370a(str, iM370a);
                        } else {
                            char c3 = cCharAt2 < 'u' ? C0180d.f419a[cCharAt2] : (char) 0;
                            if (c3 == 0) {
                                m369o(this, "Invalid escaped char '" + cCharAt2 + '\'', 0, null, 6);
                                throw null;
                            }
                            this.f478d.append(c3);
                        }
                        iM389u = m389u(iM370a);
                        if (iM389u == -1) {
                            m369o(this, "Unexpected EOF", iM389u, null, 4);
                            throw null;
                        }
                    } else {
                        i4++;
                        if (i4 >= str.length()) {
                            this.f478d.append((CharSequence) str, iM389u, i4);
                            iM389u = m389u(i4);
                            if (iM389u == -1) {
                                m369o(this, "Unexpected EOF", iM389u, null, 4);
                                throw null;
                            }
                        } else {
                            continue;
                            cCharAt = str.charAt(i4);
                        }
                    }
                    i4 = iM389u;
                    z3 = true;
                    cCharAt = str.charAt(i4);
                }
                String string = !z3 ? str.subSequence(iM389u, i4).toString() : m382m(iM389u, i4);
                this.f475a = i4 + 1;
                return string;
            }
            i4++;
        }
        this.f475a = iM4221n + 1;
        String strSubstring = str.substring(i3, iM4221n);
        AbstractC1766e.m3919d("this as java.lang.String…ing(startIndex, endIndex)", strSubstring);
        return strSubstring;
    }

    /* JADX INFO: renamed from: f */
    public final byte m375f() {
        byte bM324f;
        do {
            int i3 = this.f475a;
            if (i3 == -1) {
                return (byte) 10;
            }
            String str = this.f479e;
            if (i3 >= str.length()) {
                return (byte) 10;
            }
            int i4 = this.f475a;
            this.f475a = i4 + 1;
            bM324f = AbstractC0190n.m324f(str.charAt(i4));
        } while (bM324f == 3);
        return bM324f;
    }

    /* JADX INFO: renamed from: g */
    public final byte m376g(byte b3) {
        byte bM375f = m375f();
        if (bM375f == b3) {
            return bM375f;
        }
        m384p(b3, true);
        throw null;
    }

    /* JADX INFO: renamed from: h */
    public final void m377h(char c3) {
        if (this.f475a == -1) {
            m393y(c3);
            throw null;
        }
        while (true) {
            int i3 = this.f475a;
            String str = this.f479e;
            if (i3 >= str.length()) {
                this.f475a = -1;
                m393y(c3);
                throw null;
            }
            int i4 = this.f475a;
            this.f475a = i4 + 1;
            char cCharAt = str.charAt(i4);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                if (cCharAt == c3) {
                    return;
                }
                m393y(c3);
                throw null;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0197, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0198, code lost:
    
        m369o(r19, "Numeric value overflow", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x019e, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01a4, code lost:
    
        throw new p069X0.C0706H();
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01a5, code lost:
    
        if (r14 == false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01ac, code lost:
    
        if (r8 == Long.MIN_VALUE) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01af, code lost:
    
        return -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01b0, code lost:
    
        m369o(r19, "Numeric value overflow", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01b6, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01b7, code lost:
    
        m369o(r19, "Expected numeric literal", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01bc, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:?, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00f7, code lost:
    
        m369o(r19, "Unexpected symbol '" + r5 + "' in numeric literal", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0110, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0117, code lost:
    
        if (r12 == r1) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0119, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x011b, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x011c, code lost:
    
        if (r1 == r12) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x011e, code lost:
    
        if (r14 == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0122, code lost:
    
        if (r1 == (r12 - 1)) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x012a, code lost:
    
        if (r3 == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x012c, code lost:
    
        if (r2 == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0136, code lost:
    
        if (r18.charAt(r12) != '\"') goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0138, code lost:
    
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x013b, code lost:
    
        m369o(r19, "Expected closing quotation mark", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0143, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0144, code lost:
    
        m369o(r19, r17, 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x014c, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x014d, code lost:
    
        r19.f475a = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x014f, code lost:
    
        if (r13 == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0151, code lost:
    
        r1 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0154, code lost:
    
        if (r16 != false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0156, code lost:
    
        r3 = java.lang.Math.pow(10.0d, -r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0160, code lost:
    
        if (r16 != true) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0162, code lost:
    
        r3 = java.lang.Math.pow(10.0d, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0167, code lost:
    
        r1 = r1 * r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x016c, code lost:
    
        if (r1 > 9.223372036854776E18d) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0172, code lost:
    
        if (r1 < (-9.223372036854776E18d)) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x017a, code lost:
    
        if (java.lang.Math.floor(r1) != r1) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x017c, code lost:
    
        r8 = (long) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x017e, code lost:
    
        m369o(r19, "Can't convert " + r1 + " to Long", 0, null, 6);
     */
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long m378i() {
        /*
            Method dump skipped, instruction units count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p015D2.C0200x.m378i():long");
    }

    /* JADX INFO: renamed from: j */
    public final String m379j() {
        String str = this.f477c;
        if (str == null) {
            return m374e();
        }
        AbstractC1766e.m3917b(str);
        this.f477c = null;
        return str;
    }

    /* JADX INFO: renamed from: k */
    public final String m380k() {
        String str = this.f477c;
        if (str != null) {
            AbstractC1766e.m3917b(str);
            this.f477c = null;
            return str;
        }
        int iM390v = m390v();
        String str2 = this.f479e;
        if (iM390v >= str2.length() || iM390v == -1) {
            m369o(this, "EOF", iM390v, null, 4);
            throw null;
        }
        byte bM324f = AbstractC0190n.m324f(str2.charAt(iM390v));
        if (bM324f == 1) {
            return m379j();
        }
        if (bM324f != 0) {
            m369o(this, "Expected beginning of the string, but got " + str2.charAt(iM390v), 0, null, 6);
            throw null;
        }
        boolean z3 = false;
        while (AbstractC0190n.m324f(str2.charAt(iM390v)) == 0) {
            iM390v++;
            if (iM390v >= str2.length()) {
                this.f478d.append((CharSequence) str2, this.f475a, iM390v);
                int iM389u = m389u(iM390v);
                if (iM389u == -1) {
                    this.f475a = iM390v;
                    return m382m(0, 0);
                }
                iM390v = iM389u;
                z3 = true;
            }
        }
        String string = !z3 ? str2.subSequence(this.f475a, iM390v).toString() : m382m(this.f475a, iM390v);
        this.f475a = iM390v;
        return string;
    }

    /* JADX INFO: renamed from: l */
    public final String m381l() {
        String strM380k = m380k();
        if (AbstractC1766e.m3916a(strM380k, "null")) {
            if (this.f479e.charAt(this.f475a - 1) != '\"') {
                m369o(this, "Unexpected 'null' value instead of string literal", 0, null, 6);
                throw null;
            }
        }
        return strM380k;
    }

    /* JADX INFO: renamed from: m */
    public final String m382m(int i3, int i4) {
        this.f478d.append((CharSequence) this.f479e, i3, i4);
        StringBuilder sb = this.f478d;
        String string = sb.toString();
        AbstractC1766e.m3919d("toString(...)", string);
        sb.setLength(0);
        return string;
    }

    /* JADX INFO: renamed from: n */
    public final void m383n(int i3, String str, String str2) {
        AbstractC1766e.m3920e("message", str);
        AbstractC1766e.m3920e("hint", str2);
        throw AbstractC0190n.m321c(i3, str + " at path: " + this.f476b.m19c() + (str2.length() == 0 ? "" : "\n".concat(str2)), this.f479e);
    }

    /* JADX INFO: renamed from: p */
    public final void m384p(byte b3, boolean z3) {
        String strM333o = AbstractC0190n.m333o(b3);
        int i3 = z3 ? this.f475a - 1 : this.f475a;
        int i4 = this.f475a;
        String str = this.f479e;
        m369o(this, AbstractC0032g.m156n("Expected ", strM333o, ", but had '", (i4 == str.length() || i3 < 0) ? "EOF" : String.valueOf(str.charAt(i3)), "' instead"), i3, null, 4);
        throw null;
    }

    /* JADX INFO: renamed from: q */
    public final int m385q(CharSequence charSequence, int i3) {
        char cCharAt = charSequence.charAt(i3);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        m369o(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, null, 6);
        throw null;
    }

    /* JADX INFO: renamed from: r */
    public final String m386r(String str, boolean z3) {
        AbstractC1766e.m3920e("keyToMatch", str);
        int i3 = this.f475a;
        try {
            if (m375f() != 6) {
                return null;
            }
            if (!AbstractC1766e.m3916a(m388t(z3), str)) {
                return null;
            }
            this.f477c = null;
            if (m375f() != 5) {
                return null;
            }
            return m388t(z3);
        } finally {
            this.f475a = i3;
            this.f477c = null;
        }
    }

    /* JADX INFO: renamed from: s */
    public final byte m387s() {
        int i3 = this.f475a;
        while (true) {
            int iM389u = m389u(i3);
            if (iM389u == -1) {
                this.f475a = iM389u;
                return (byte) 10;
            }
            char cCharAt = this.f479e.charAt(iM389u);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f475a = iM389u;
                return AbstractC0190n.m324f(cCharAt);
            }
            i3 = iM389u + 1;
        }
    }

    /* JADX INFO: renamed from: t */
    public final String m388t(boolean z3) {
        String strM379j;
        byte bM387s = m387s();
        if (z3) {
            if (bM387s != 1 && bM387s != 0) {
                return null;
            }
            strM379j = m380k();
        } else {
            if (bM387s != 1) {
                return null;
            }
            strM379j = m379j();
        }
        this.f477c = strM379j;
        return strM379j;
    }

    public final String toString() {
        return "JsonReader(source='" + ((Object) this.f479e) + "', currentPosition=" + this.f475a + ')';
    }

    /* JADX INFO: renamed from: u */
    public final int m389u(int i3) {
        if (i3 < this.f479e.length()) {
            return i3;
        }
        return -1;
    }

    /* JADX INFO: renamed from: v */
    public final int m390v() {
        char cCharAt;
        int i3 = this.f475a;
        if (i3 == -1) {
            return i3;
        }
        while (true) {
            String str = this.f479e;
            if (i3 >= str.length() || !((cCharAt = str.charAt(i3)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
                break;
            }
            i3++;
        }
        this.f475a = i3;
        return i3;
    }

    /* JADX INFO: renamed from: w */
    public final boolean m391w() {
        int iM390v = m390v();
        String str = this.f479e;
        if (iM390v == str.length() || iM390v == -1 || str.charAt(iM390v) != ',') {
            return false;
        }
        this.f475a++;
        return true;
    }

    /* JADX INFO: renamed from: x */
    public final boolean m392x(boolean z3) {
        int iM389u = m389u(m390v());
        String str = this.f479e;
        int length = str.length() - iM389u;
        if (length < 4 || iM389u == -1) {
            return false;
        }
        for (int i3 = 0; i3 < 4; i3++) {
            if ("null".charAt(i3) != str.charAt(iM389u + i3)) {
                return false;
            }
        }
        if (length > 4 && AbstractC0190n.m324f(str.charAt(iM389u + 4)) == 0) {
            return false;
        }
        if (!z3) {
            return true;
        }
        this.f475a = iM389u + 4;
        return true;
    }

    /* JADX INFO: renamed from: y */
    public final void m393y(char c3) {
        int i3 = this.f475a;
        if (i3 > 0 && c3 == '\"') {
            try {
                this.f475a = i3 - 1;
                String strM380k = m380k();
                this.f475a = i3;
                if (AbstractC1766e.m3916a(strM380k, "null")) {
                    m383n(this.f475a - 1, "Expected string literal but 'null' literal was found", "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls to default values.");
                    throw null;
                }
            } catch (Throwable th) {
                this.f475a = i3;
                throw th;
            }
        }
        m384p(AbstractC0190n.m324f(c3), true);
        throw null;
    }
}
