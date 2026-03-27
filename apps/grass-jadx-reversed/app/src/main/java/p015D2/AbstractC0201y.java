package p015D2;

import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: D2.y */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0201y {

    /* JADX INFO: renamed from: a */
    public static final String[] f480a;

    /* JADX INFO: renamed from: b */
    public static final byte[] f481b;

    static {
        String[] strArr = new String[93];
        for (int i3 = 0; i3 < 32; i3++) {
            strArr[i3] = "\\u" + m395b(i3 >> 12) + m395b(i3 >> 8) + m395b(i3 >> 4) + m395b(i3);
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f480a = strArr;
        byte[] bArr = new byte[93];
        for (int i4 = 0; i4 < 32; i4++) {
            bArr[i4] = 1;
        }
        bArr[34] = 34;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = 98;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
        f481b = bArr;
    }

    /* JADX INFO: renamed from: a */
    public static final void m394a(StringBuilder sb, String str) {
        AbstractC1766e.m3920e("value", str);
        sb.append('\"');
        int length = str.length();
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char cCharAt = str.charAt(i4);
            String[] strArr = f480a;
            if (cCharAt < strArr.length && strArr[cCharAt] != null) {
                sb.append((CharSequence) str, i3, i4);
                sb.append(strArr[cCharAt]);
                i3 = i4 + 1;
            }
        }
        if (i3 != 0) {
            sb.append((CharSequence) str, i3, str.length());
        } else {
            sb.append(str);
        }
        sb.append('\"');
    }

    /* JADX INFO: renamed from: b */
    public static final char m395b(int i3) {
        int i4 = i3 & 15;
        return (char) (i4 < 10 ? i4 + 48 : i4 + 87);
    }
}
