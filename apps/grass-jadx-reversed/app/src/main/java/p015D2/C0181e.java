package p015D2;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import p023H.C0243f;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: D2.e */
/* JADX INFO: loaded from: classes.dex */
public class C0181e {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f421a;

    /* JADX INFO: renamed from: b */
    public boolean f422b;

    /* JADX INFO: renamed from: c */
    public Object f423c;

    /* JADX INFO: renamed from: a */
    public boolean m303a() {
        return this.f422b;
    }

    /* JADX INFO: renamed from: b */
    public void mo304b() {
        this.f422b = true;
    }

    /* JADX INFO: renamed from: c */
    public boolean m305c(CharSequence charSequence, int i3) {
        if (charSequence == null || i3 < 0 || charSequence.length() - i3 < 0) {
            throw new IllegalArgumentException();
        }
        C0243f c0243f = (C0243f) this.f423c;
        if (c0243f == null) {
            return m303a();
        }
        int iM483a = c0243f.m483a(charSequence, i3);
        if (iM483a == 0) {
            return true;
        }
        if (iM483a != 1) {
            return m303a();
        }
        return false;
    }

    /* JADX INFO: renamed from: d */
    public void mo306d() {
        this.f422b = false;
    }

    /* JADX INFO: renamed from: e */
    public void mo307e(byte b3) {
        long j2 = b3;
        C0192p c0192p = (C0192p) this.f423c;
        c0192p.getClass();
        c0192p.m337d(String.valueOf(j2));
    }

    /* JADX INFO: renamed from: f */
    public void m308f(char c3) {
        C0192p c0192p = (C0192p) this.f423c;
        c0192p.m335b(c0192p.f443f, 1);
        char[] cArr = (char[]) c0192p.f444g;
        int i3 = c0192p.f443f;
        c0192p.f443f = i3 + 1;
        cArr[i3] = c3;
    }

    /* JADX INFO: renamed from: g */
    public void mo309g(int i3) {
        long j2 = i3;
        C0192p c0192p = (C0192p) this.f423c;
        c0192p.getClass();
        c0192p.m337d(String.valueOf(j2));
    }

    /* JADX INFO: renamed from: h */
    public void mo310h(long j2) {
        C0192p c0192p = (C0192p) this.f423c;
        c0192p.getClass();
        c0192p.m337d(String.valueOf(j2));
    }

    /* JADX INFO: renamed from: i */
    public void m311i(String str) {
        AbstractC1766e.m3920e("v", str);
        ((C0192p) this.f423c).m337d(str);
    }

    /* JADX INFO: renamed from: j */
    public void mo312j(short s3) {
        long j2 = s3;
        C0192p c0192p = (C0192p) this.f423c;
        c0192p.getClass();
        c0192p.m337d(String.valueOf(j2));
    }

    /* JADX INFO: renamed from: k */
    public void mo313k(String str) {
        byte b3;
        AbstractC1766e.m3920e("value", str);
        C0192p c0192p = (C0192p) this.f423c;
        c0192p.getClass();
        c0192p.m335b(c0192p.f443f, str.length() + 2);
        char[] cArr = (char[]) c0192p.f444g;
        int i3 = c0192p.f443f;
        int i4 = i3 + 1;
        cArr[i3] = '\"';
        int length = str.length();
        str.getChars(0, length, cArr, i4);
        int i5 = length + i4;
        int i6 = i4;
        while (i6 < i5) {
            char c3 = cArr[i6];
            byte[] bArr = AbstractC0201y.f481b;
            if (c3 < bArr.length && bArr[c3] != 0) {
                int length2 = str.length();
                for (int i7 = i6 - i4; i7 < length2; i7++) {
                    c0192p.m335b(i6, 2);
                    char cCharAt = str.charAt(i7);
                    byte[] bArr2 = AbstractC0201y.f481b;
                    if (cCharAt >= bArr2.length || (b3 = bArr2[cCharAt]) == 0) {
                        int i8 = i6 + 1;
                        ((char[]) c0192p.f444g)[i6] = cCharAt;
                        i6 = i8;
                    } else {
                        if (b3 == 1) {
                            String str2 = AbstractC0201y.f480a[cCharAt];
                            AbstractC1766e.m3917b(str2);
                            c0192p.m335b(i6, str2.length());
                            str2.getChars(0, str2.length(), (char[]) c0192p.f444g, i6);
                            int length3 = str2.length() + i6;
                            c0192p.f443f = length3;
                            i6 = length3;
                        } else {
                            char[] cArr2 = (char[]) c0192p.f444g;
                            cArr2[i6] = '\\';
                            cArr2[i6 + 1] = (char) b3;
                            i6 += 2;
                            c0192p.f443f = i6;
                        }
                    }
                }
                c0192p.m335b(i6, 1);
                ((char[]) c0192p.f444g)[i6] = '\"';
                c0192p.f443f = i6 + 1;
                return;
            }
            i6++;
        }
        cArr[i5] = '\"';
        c0192p.f443f = i5 + 1;
    }

    /* JADX INFO: renamed from: l */
    public void mo314l() {
    }

    /* JADX INFO: renamed from: m */
    public void mo315m() {
    }

    public String toString() {
        switch (this.f421a) {
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                String str = this.f422b ? "Applink" : "Unclassified";
                String str2 = (String) this.f423c;
                if (str2 == null) {
                    return str;
                }
                return str + "(" + str2 + ")";
            default:
                return super.toString();
        }
    }

    public /* synthetic */ C0181e(Object obj, boolean z3, int i3) {
        this.f421a = i3;
        this.f423c = obj;
        this.f422b = z3;
    }

    public C0181e(C0192p c0192p) {
        this.f421a = 0;
        this.f423c = c0192p;
        this.f422b = true;
    }

    public C0181e(C0243f c0243f, boolean z3) {
        this.f421a = 1;
        this.f421a = 1;
        this.f423c = c0243f;
        this.f422b = z3;
    }
}
