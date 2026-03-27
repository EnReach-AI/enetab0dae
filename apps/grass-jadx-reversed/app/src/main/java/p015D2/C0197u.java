package p015D2;

import java.util.Arrays;
import p001A.C0003d;
import p004A2.InterfaceC0024a;
import p004A2.InterfaceC0025b;
import p005B.AbstractC0032g;
import p011C2.AbstractC0156i;
import p011C2.C0148a;
import p011C2.C0154g;
import p039M0.AbstractC0473V;
import p119m2.AbstractC1766e;
import p142s2.AbstractC1892g;
import p161x2.C2013b;
import p161x2.C2015d;
import p161x2.C2017f;
import p161x2.InterfaceC2012a;
import p166z0.C2068f;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: D2.u */
/* JADX INFO: loaded from: classes.dex */
public final class C0197u extends AbstractC0473V implements InterfaceC0025b, InterfaceC0024a {

    /* JADX INFO: renamed from: a */
    public final C0148a f460a;

    /* JADX INFO: renamed from: b */
    public final EnumC0202z f461b;

    /* JADX INFO: renamed from: c */
    public final C0200x f462c;

    /* JADX INFO: renamed from: d */
    public final C2068f f463d;

    /* JADX INFO: renamed from: e */
    public int f464e;

    /* JADX INFO: renamed from: f */
    public final C0154g f465f;

    /* JADX INFO: renamed from: g */
    public final C0188l f466g;

    public C0197u(C0148a c0148a, EnumC0202z enumC0202z, C0200x c0200x, InterfaceC2095g interfaceC2095g, AbstractC0196t abstractC0196t) {
        AbstractC1766e.m3920e("json", c0148a);
        AbstractC1766e.m3920e("lexer", c0200x);
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        this.f460a = c0148a;
        this.f461b = enumC0202z;
        this.f462c = c0200x;
        this.f463d = c0148a.f358b;
        this.f464e = -1;
        C0154g c0154g = c0148a.f357a;
        this.f465f = c0154g;
        this.f466g = c0154g.f371f ? null : new C0188l(interfaceC2095g);
    }

    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: A */
    public final double mo90A() {
        C0200x c0200x = this.f462c;
        String strM380k = c0200x.m380k();
        try {
            double d = Double.parseDouble(strM380k);
            if (this.f460a.f357a.f376k || !(Double.isInfinite(d) || Double.isNaN(d))) {
                return d;
            }
            AbstractC0190n.m332n(c0200x, Double.valueOf(d));
            throw null;
        } catch (IllegalArgumentException unused) {
            C0200x.m369o(c0200x, AbstractC0032g.m153k("Failed to parse type 'double' for input '", strM380k, '\''), 0, null, 6);
            throw null;
        }
    }

    /* JADX INFO: renamed from: M */
    public final AbstractC0156i m347M() {
        return new C0195s(this.f460a.f357a, this.f462c).m344e();
    }

    /* JADX INFO: renamed from: N */
    public final C0148a m348N() {
        return this.f460a;
    }

    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: c */
    public final long mo91c() {
        return this.f462c.m378i();
    }

    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: g */
    public final boolean mo92g() {
        boolean z3;
        boolean z4 = this.f465f.f368c;
        C0200x c0200x = this.f462c;
        if (!z4) {
            return c0200x.m372c(c0200x.m390v());
        }
        int iM390v = c0200x.m390v();
        String str = c0200x.f479e;
        if (iM390v == str.length()) {
            C0200x.m369o(c0200x, "EOF", 0, null, 6);
            throw null;
        }
        if (str.charAt(iM390v) == '\"') {
            iM390v++;
            z3 = true;
        } else {
            z3 = false;
        }
        boolean zM372c = c0200x.m372c(iM390v);
        if (!z3) {
            return zM372c;
        }
        if (c0200x.f475a == str.length()) {
            C0200x.m369o(c0200x, "EOF", 0, null, 6);
            throw null;
        }
        if (str.charAt(c0200x.f475a) == '\"') {
            c0200x.f475a++;
            return zM372c;
        }
        C0200x.m369o(c0200x, "Expected closing quotation mark", 0, null, 6);
        throw null;
    }

    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: h */
    public final int mo93h() {
        C0200x c0200x = this.f462c;
        long jM378i = c0200x.m378i();
        int i3 = (int) jM378i;
        if (jM378i == i3) {
            return i3;
        }
        C0200x.m369o(c0200x, "Failed to parse int for input '" + jM378i + '\'', 0, null, 6);
        throw null;
    }

    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: i */
    public final InterfaceC0024a mo94i(InterfaceC2095g interfaceC2095g) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        C0148a c0148a = this.f460a;
        EnumC0202z enumC0202zM331m = AbstractC0190n.m331m(c0148a, interfaceC2095g);
        C0200x c0200x = this.f462c;
        C0003d c0003d = c0200x.f476b;
        c0003d.getClass();
        int i3 = c0003d.f15b + 1;
        c0003d.f15b = i3;
        Object[] objArr = (Object[]) c0003d.f16c;
        if (i3 == objArr.length) {
            int i4 = i3 * 2;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, i4);
            AbstractC1766e.m3919d("copyOf(this, newSize)", objArrCopyOf);
            c0003d.f16c = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf((int[]) c0003d.f17d, i4);
            AbstractC1766e.m3919d("copyOf(this, newSize)", iArrCopyOf);
            c0003d.f17d = iArrCopyOf;
        }
        ((Object[]) c0003d.f16c)[i3] = interfaceC2095g;
        c0200x.m377h(enumC0202zM331m.f487e);
        if (c0200x.m387s() != 4) {
            int iOrdinal = enumC0202zM331m.ordinal();
            return (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) ? new C0197u(this.f460a, enumC0202zM331m, this.f462c, interfaceC2095g, null) : (this.f461b == enumC0202zM331m && c0148a.f357a.f371f) ? this : new C0197u(this.f460a, enumC0202zM331m, this.f462c, interfaceC2095g, null);
        }
        C0200x.m369o(c0200x, "Unexpected leading comma", 0, null, 6);
        throw null;
    }

    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: j */
    public final boolean mo95j() {
        C0188l c0188l = this.f466g;
        return ((c0188l != null ? c0188l.f439b : false) || this.f462c.m392x(true)) ? false : true;
    }

    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: k */
    public final Object mo96k(InterfaceC2012a interfaceC2012a) {
        C0200x c0200x = this.f462c;
        C0148a c0148a = this.f460a;
        AbstractC1766e.m3920e("deserializer", interfaceC2012a);
        try {
            if ((interfaceC2012a instanceof C2015d) && !c0148a.f357a.f374i) {
                if (c0200x.m386r(AbstractC0190n.m325g(c0148a, interfaceC2012a.mo221c()), this.f465f.f368c) != null) {
                    ((C2015d) interfaceC2012a).m4466d(this);
                }
                return AbstractC0190n.m326h(this, interfaceC2012a);
            }
            return interfaceC2012a.mo220b(this);
        } catch (C2013b e3) {
            String message = e3.getMessage();
            AbstractC1766e.m3917b(message);
            if (AbstractC1892g.m4217j(message, "at path")) {
                throw e3;
            }
            String str = e3.getMessage() + " at path: " + c0200x.f476b.m19c();
            AbstractC1766e.m3920e("missingFields", null);
            throw new C2013b(str, e3);
        }
    }

    @Override // p004A2.InterfaceC0024a
    /* JADX INFO: renamed from: n */
    public final C2068f mo84n() {
        return this.f463d;
    }

    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: o */
    public final char mo97o() {
        C0200x c0200x = this.f462c;
        String strM380k = c0200x.m380k();
        if (strM380k.length() == 1) {
            return strM380k.charAt(0);
        }
        C0200x.m369o(c0200x, AbstractC0032g.m153k("Expected single char, but got '", strM380k, '\''), 0, null, 6);
        throw null;
    }

    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0024a
    /* JADX INFO: renamed from: p */
    public final Object mo85p(InterfaceC2095g interfaceC2095g, int i3, InterfaceC2012a interfaceC2012a, Object obj) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        AbstractC1766e.m3920e("deserializer", interfaceC2012a);
        boolean z3 = this.f461b == EnumC0202z.MAP && (i3 & 1) == 0;
        C0200x c0200x = this.f462c;
        if (z3) {
            C0003d c0003d = c0200x.f476b;
            int[] iArr = (int[]) c0003d.f17d;
            int i4 = c0003d.f15b;
            if (iArr[i4] == -2) {
                ((Object[]) c0003d.f16c)[i4] = C0191o.f441a;
            }
        }
        Object objMo85p = super.mo85p(interfaceC2095g, i3, interfaceC2012a, obj);
        if (z3) {
            C0003d c0003d2 = c0200x.f476b;
            int[] iArr2 = (int[]) c0003d2.f17d;
            int i5 = c0003d2.f15b;
            if (iArr2[i5] != -2) {
                int i6 = i5 + 1;
                c0003d2.f15b = i6;
                Object[] objArr = (Object[]) c0003d2.f16c;
                if (i6 == objArr.length) {
                    int i7 = i6 * 2;
                    Object[] objArrCopyOf = Arrays.copyOf(objArr, i7);
                    AbstractC1766e.m3919d("copyOf(this, newSize)", objArrCopyOf);
                    c0003d2.f16c = objArrCopyOf;
                    int[] iArrCopyOf = Arrays.copyOf((int[]) c0003d2.f17d, i7);
                    AbstractC1766e.m3919d("copyOf(this, newSize)", iArrCopyOf);
                    c0003d2.f17d = iArrCopyOf;
                }
            }
            Object[] objArr2 = (Object[]) c0003d2.f16c;
            int i8 = c0003d2.f15b;
            objArr2[i8] = objMo85p;
            ((int[]) c0003d2.f17d)[i8] = -2;
        }
        return objMo85p;
    }

    /* JADX WARN: Code restructure failed: missing block: B:161:0x02a7, code lost:
    
        r11 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00fb, code lost:
    
        if (r11 == null) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00fd, code lost:
    
        r1 = r11.f438a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0101, code lost:
    
        if (r9 >= 64) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0103, code lost:
    
        r1.f337c |= 1 << r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x010d, code lost:
    
        r3 = (r9 >>> 6) - 1;
        r1 = r1.f338d;
        r1[r3] = (1 << (r9 & 63)) | r1[r3];
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0084  */
    @Override // p004A2.InterfaceC0024a
    /* JADX INFO: renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int mo86q(p167z2.InterfaceC2095g r20) {
        /*
            Method dump skipped, instruction units count: 714
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p015D2.C0197u.mo86q(z2.g):int");
    }

    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: r */
    public final byte mo98r() {
        C0200x c0200x = this.f462c;
        long jM378i = c0200x.m378i();
        byte b3 = (byte) jM378i;
        if (jM378i == b3) {
            return b3;
        }
        C0200x.m369o(c0200x, "Failed to parse byte for input '" + jM378i + '\'', 0, null, 6);
        throw null;
    }

    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: s */
    public final InterfaceC0025b mo99s(InterfaceC2095g interfaceC2095g) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        return AbstractC0199w.m368a(interfaceC2095g) ? new C0185i(this.f462c, this.f460a) : this;
    }

    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: u */
    public final short mo100u() {
        C0200x c0200x = this.f462c;
        long jM378i = c0200x.m378i();
        short s3 = (short) jM378i;
        if (jM378i == s3) {
            return s3;
        }
        C0200x.m369o(c0200x, "Failed to parse short for input '" + jM378i + '\'', 0, null, 6);
        throw null;
    }

    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: v */
    public final String mo101v() {
        boolean z3 = this.f465f.f368c;
        C0200x c0200x = this.f462c;
        return z3 ? c0200x.m381l() : c0200x.m379j();
    }

    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0024a
    /* JADX INFO: renamed from: w */
    public final void mo88w(InterfaceC2095g interfaceC2095g) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        if (this.f460a.f357a.f367b && interfaceC2095g.mo240l() == 0) {
            while (mo86q(interfaceC2095g) != -1) {
            }
        }
        char c3 = this.f461b.f488f;
        C0200x c0200x = this.f462c;
        c0200x.m377h(c3);
        C0003d c0003d = c0200x.f476b;
        int i3 = c0003d.f15b;
        int[] iArr = (int[]) c0003d.f17d;
        if (iArr[i3] == -2) {
            iArr[i3] = -1;
            c0003d.f15b = i3 - 1;
        }
        int i4 = c0003d.f15b;
        if (i4 != -1) {
            c0003d.f15b = i4 - 1;
        }
    }

    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: x */
    public final float mo102x() {
        C0200x c0200x = this.f462c;
        String strM380k = c0200x.m380k();
        try {
            float f3 = Float.parseFloat(strM380k);
            if (this.f460a.f357a.f376k || !(Float.isInfinite(f3) || Float.isNaN(f3))) {
                return f3;
            }
            AbstractC0190n.m332n(c0200x, Float.valueOf(f3));
            throw null;
        } catch (IllegalArgumentException unused) {
            C0200x.m369o(c0200x, AbstractC0032g.m153k("Failed to parse type 'float' for input '", strM380k, '\''), 0, null, 6);
            throw null;
        }
    }

    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: y */
    public final int mo103y(InterfaceC2095g interfaceC2095g) {
        AbstractC1766e.m3920e("enumDescriptor", interfaceC2095g);
        String strMo101v = mo101v();
        String strConcat = " at path ".concat(this.f462c.f476b.m19c());
        C0148a c0148a = this.f460a;
        AbstractC1766e.m3920e("<this>", interfaceC2095g);
        AbstractC1766e.m3920e("json", c0148a);
        AbstractC1766e.m3920e("name", strMo101v);
        AbstractC1766e.m3920e("suffix", strConcat);
        int iM328j = AbstractC0190n.m328j(interfaceC2095g, c0148a, strMo101v);
        if (iM328j != -3) {
            return iM328j;
        }
        throw new C2017f(interfaceC2095g.mo233d() + " does not contain element with name '" + strMo101v + '\'' + strConcat);
    }
}
