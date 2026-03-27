package p023H;

import android.text.SpannableStringBuilder;
import p015D2.C0181e;

/* JADX INFO: renamed from: H.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0239b {

    /* JADX INFO: renamed from: d */
    public static final String f587d;

    /* JADX INFO: renamed from: e */
    public static final String f588e;

    /* JADX INFO: renamed from: f */
    public static final C0239b f589f;

    /* JADX INFO: renamed from: g */
    public static final C0239b f590g;

    /* JADX INFO: renamed from: a */
    public final boolean f591a;

    /* JADX INFO: renamed from: b */
    public final int f592b;

    /* JADX INFO: renamed from: c */
    public final C0181e f593c;

    static {
        C0181e c0181e = AbstractC0244g.f601c;
        f587d = Character.toString((char) 8206);
        f588e = Character.toString((char) 8207);
        f589f = new C0239b(false);
        f590g = new C0239b(true);
    }

    public C0239b(boolean z3) {
        C0181e c0181e = AbstractC0244g.f601c;
        this.f591a = z3;
        this.f592b = 2;
        this.f593c = c0181e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0070, code lost:
    
        if (r1 != 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
    
        if (r2 == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0079, code lost:
    
        if (r0.f585c <= 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007f, code lost:
    
        switch(r0.m476a()) {
            case 14: goto L66;
            case 15: goto L66;
            case 16: goto L65;
            case 17: goto L65;
            case 18: goto L64;
            default: goto L70;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0083, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0086, code lost:
    
        if (r1 != r3) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0089, code lost:
    
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008c, code lost:
    
        if (r1 != r3) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008f, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:?, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:?, code lost:
    
        return 0;
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m477a(java.lang.CharSequence r9) {
        /*
            H.a r0 = new H.a
            r0.<init>(r9)
            r9 = 0
            r0.f585c = r9
            r1 = r9
            r2 = r1
            r3 = r2
        Lb:
            int r4 = r0.f585c
            int r5 = r0.f584b
            r6 = 1
            r7 = -1
            if (r4 >= r5) goto L70
            if (r1 != 0) goto L70
            java.lang.CharSequence r5 = r0.f583a
            char r4 = r5.charAt(r4)
            r0.f586d = r4
            boolean r4 = java.lang.Character.isHighSurrogate(r4)
            if (r4 == 0) goto L37
            int r4 = r0.f585c
            int r4 = java.lang.Character.codePointAt(r5, r4)
            int r5 = r0.f585c
            int r8 = java.lang.Character.charCount(r4)
            int r8 = r8 + r5
            r0.f585c = r8
            byte r4 = java.lang.Character.getDirectionality(r4)
            goto L4b
        L37:
            int r4 = r0.f585c
            int r4 = r4 + r6
            r0.f585c = r4
            char r4 = r0.f586d
            r5 = 1792(0x700, float:2.511E-42)
            if (r4 >= r5) goto L47
            byte[] r5 = p023H.C0238a.f582e
            r4 = r5[r4]
            goto L4b
        L47:
            byte r4 = java.lang.Character.getDirectionality(r4)
        L4b:
            if (r4 == 0) goto L6a
            if (r4 == r6) goto L66
            r5 = 2
            if (r4 == r5) goto L66
            r5 = 9
            if (r4 == r5) goto Lb
            switch(r4) {
                case 14: goto L62;
                case 15: goto L62;
                case 16: goto L5e;
                case 17: goto L5e;
                case 18: goto L5a;
                default: goto L59;
            }
        L59:
            goto L6e
        L5a:
            int r3 = r3 + (-1)
            r2 = r9
            goto Lb
        L5e:
            int r3 = r3 + 1
            r2 = r6
            goto Lb
        L62:
            int r3 = r3 + 1
            r2 = r7
            goto Lb
        L66:
            if (r3 != 0) goto L6e
        L68:
            r9 = r6
            goto L8f
        L6a:
            if (r3 != 0) goto L6e
        L6c:
            r9 = r7
            goto L8f
        L6e:
            r1 = r3
            goto Lb
        L70:
            if (r1 != 0) goto L73
            goto L8f
        L73:
            if (r2 == 0) goto L77
            r9 = r2
            goto L8f
        L77:
            int r2 = r0.f585c
            if (r2 <= 0) goto L8f
            byte r2 = r0.m476a()
            switch(r2) {
                case 14: goto L8c;
                case 15: goto L8c;
                case 16: goto L86;
                case 17: goto L86;
                case 18: goto L83;
                default: goto L82;
            }
        L82:
            goto L77
        L83:
            int r3 = r3 + 1
            goto L77
        L86:
            if (r1 != r3) goto L89
            goto L68
        L89:
            int r3 = r3 + (-1)
            goto L77
        L8c:
            if (r1 != r3) goto L89
            goto L6c
        L8f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p023H.C0239b.m477a(java.lang.CharSequence):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0041, code lost:
    
        return 1;
     */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m478b(java.lang.CharSequence r7) {
        /*
            H.a r0 = new H.a
            r0.<init>(r7)
            int r7 = r0.f584b
            r0.f585c = r7
            r7 = 0
            r1 = r7
        Lb:
            r2 = r1
        Lc:
            int r3 = r0.f585c
            if (r3 <= 0) goto L41
            byte r3 = r0.m476a()
            r4 = -1
            if (r3 == 0) goto L3b
            r5 = 1
            if (r3 == r5) goto L35
            r6 = 2
            if (r3 == r6) goto L35
            r6 = 9
            if (r3 == r6) goto Lc
            switch(r3) {
                case 14: goto L31;
                case 15: goto L31;
                case 16: goto L2a;
                case 17: goto L2a;
                case 18: goto L27;
                default: goto L24;
            }
        L24:
            if (r2 != 0) goto Lc
            goto L40
        L27:
            int r1 = r1 + 1
            goto Lc
        L2a:
            if (r2 != r1) goto L2e
        L2c:
            r7 = r5
            goto L41
        L2e:
            int r1 = r1 + (-1)
            goto Lc
        L31:
            if (r2 != r1) goto L2e
        L33:
            r7 = r4
            goto L41
        L35:
            if (r1 != 0) goto L38
            goto L2c
        L38:
            if (r2 != 0) goto Lc
            goto L40
        L3b:
            if (r1 != 0) goto L3e
            goto L33
        L3e:
            if (r2 != 0) goto Lc
        L40:
            goto Lb
        L41:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p023H.C0239b.m478b(java.lang.CharSequence):int");
    }

    /* JADX INFO: renamed from: c */
    public final SpannableStringBuilder m479c(CharSequence charSequence) {
        C0181e c0181e = AbstractC0244g.f601c;
        if (charSequence == null) {
            return null;
        }
        boolean zM305c = c0181e.m305c(charSequence, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i3 = this.f592b & 2;
        String str = "";
        String str2 = f588e;
        String str3 = f587d;
        boolean z3 = this.f591a;
        if (i3 != 0) {
            boolean zM305c2 = (zM305c ? AbstractC0244g.f600b : AbstractC0244g.f599a).m305c(charSequence, charSequence.length());
            spannableStringBuilder.append((CharSequence) ((z3 || !(zM305c2 || m477a(charSequence) == 1)) ? (!z3 || (zM305c2 && m477a(charSequence) != -1)) ? "" : str2 : str3));
        }
        if (zM305c != z3) {
            spannableStringBuilder.append(zM305c ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        boolean zM305c3 = (zM305c ? AbstractC0244g.f600b : AbstractC0244g.f599a).m305c(charSequence, charSequence.length());
        if (!z3 && (zM305c3 || m478b(charSequence) == 1)) {
            str = str3;
        } else if (z3 && (!zM305c3 || m478b(charSequence) == -1)) {
            str = str2;
        }
        spannableStringBuilder.append((CharSequence) str);
        return spannableStringBuilder;
    }
}
