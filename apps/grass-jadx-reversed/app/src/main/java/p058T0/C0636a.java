package p058T0;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import p005B.AbstractC0032g;
import p025H1.C0283l;

/* JADX INFO: renamed from: T0.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0636a {

    /* JADX INFO: renamed from: a */
    public final C0283l f1630a;

    /* JADX INFO: renamed from: c */
    public final byte[] f1632c;

    /* JADX INFO: renamed from: d */
    public int f1633d;

    /* JADX INFO: renamed from: e */
    public int f1634e;

    /* JADX INFO: renamed from: h */
    public int f1637h;

    /* JADX INFO: renamed from: g */
    public boolean f1636g = true;

    /* JADX INFO: renamed from: b */
    public final InputStream f1631b = null;

    /* JADX INFO: renamed from: f */
    public final boolean f1635f = false;

    public C0636a(int i3, int i4, C0283l c0283l, byte[] bArr) {
        this.f1630a = c0283l;
        this.f1632c = bArr;
        this.f1633d = i3;
        this.f1634e = i3 + i4;
    }

    /* JADX INFO: renamed from: c */
    public static void m1459c(String str) throws CharConversionException {
        throw new CharConversionException(AbstractC0032g.m154l("Unsupported UCS-4 endianness (", str, ") detected"));
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x010d  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p045O0.AbstractC0570b m1460a(int r31, p042N0.AbstractC0549q r32, p061U0.C0655b r33, p061U0.C0658e r34, int r35) throws java.io.CharConversionException {
        /*
            Method dump skipped, instruction units count: 503
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p058T0.C0636a.m1460a(int, N0.q, U0.b, U0.e, int):O0.b");
    }

    /* JADX INFO: renamed from: b */
    public final boolean m1461b(int i3) throws IOException {
        int i4;
        int i5 = this.f1634e - this.f1633d;
        while (i5 < i3) {
            InputStream inputStream = this.f1631b;
            if (inputStream == null) {
                i4 = -1;
            } else {
                int i6 = this.f1634e;
                byte[] bArr = this.f1632c;
                i4 = inputStream.read(bArr, i6, bArr.length - i6);
            }
            if (i4 < 1) {
                return false;
            }
            this.f1634e += i4;
            i5 += i4;
        }
        return true;
    }
}
