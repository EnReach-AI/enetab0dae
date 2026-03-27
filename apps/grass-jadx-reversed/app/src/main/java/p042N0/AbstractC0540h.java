package p042N0;

import java.io.Closeable;
import java.io.Flushable;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import p050Q0.C0597j;
import p058T0.C0640e;
import p064V0.C0672b;
import p066W0.C0684k;
import p136r.AbstractC1849h;

/* JADX INFO: renamed from: N0.h */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0540h implements Closeable, Flushable {

    /* JADX INFO: renamed from: e */
    public InterfaceC0550r f1268e;

    static {
        C0684k.m1644a(EnumC0555w.values());
        EnumC0555w.f1347g.mo1234a();
        EnumC0555w.f1346f.mo1234a();
    }

    /* JADX INFO: renamed from: b */
    public static void m1107b(int i3, int i4) {
        if (i4 > i3) {
            throw new IllegalArgumentException(String.format("invalid argument(s) (offset=%d, length=%d) for input array of %d element", 0, Integer.valueOf(i4), Integer.valueOf(i3)));
        }
    }

    /* JADX INFO: renamed from: A */
    public abstract void mo1108A(short s3);

    /* JADX INFO: renamed from: B */
    public abstract void mo1109B(Object obj);

    /* JADX INFO: renamed from: C */
    public void mo1110C(Object obj) throws C0538f {
        throw new C0538f("No native support for writing Object Ids", this);
    }

    /* JADX INFO: renamed from: D */
    public abstract void mo1111D(char c3);

    /* JADX INFO: renamed from: E */
    public abstract void mo1112E(InterfaceC0551s interfaceC0551s);

    /* JADX INFO: renamed from: F */
    public abstract void mo1113F(String str);

    /* JADX INFO: renamed from: G */
    public abstract void mo1114G(char[] cArr, int i3);

    /* JADX INFO: renamed from: H */
    public void mo1115H(InterfaceC0551s interfaceC0551s) {
        mo1116I(((C0597j) interfaceC0551s).f1531e);
    }

    /* JADX INFO: renamed from: I */
    public abstract void mo1116I(String str);

    /* JADX INFO: renamed from: J */
    public abstract void mo1117J();

    /* JADX INFO: renamed from: K */
    public abstract void mo1118K(Object obj);

    /* JADX INFO: renamed from: L */
    public abstract void mo1119L(Object obj);

    /* JADX INFO: renamed from: M */
    public abstract void mo1120M();

    /* JADX INFO: renamed from: N */
    public abstract void mo1121N(Object obj);

    /* JADX INFO: renamed from: O */
    public abstract void mo1122O(Object obj);

    /* JADX INFO: renamed from: P */
    public abstract void mo1123P(int i3, char[] cArr, int i4);

    /* JADX INFO: renamed from: Q */
    public abstract void mo1124Q(InterfaceC0551s interfaceC0551s);

    /* JADX INFO: renamed from: R */
    public abstract void mo1125R(String str);

    /* JADX INFO: renamed from: S */
    public void mo1126S(Object obj) throws C0538f {
        throw new C0538f("No native support for writing Type Ids", this);
    }

    /* JADX INFO: renamed from: T */
    public final void m1127T(C0672b c0672b) throws C0538f {
        Object obj = c0672b.f1825c;
        boolean zMo1131d = mo1131d();
        EnumC0548p enumC0548p = c0672b.f1828f;
        if (zMo1131d) {
            c0672b.f1829g = false;
            mo1126S(obj);
        } else {
            String strValueOf = obj instanceof String ? (String) obj : String.valueOf(obj);
            c0672b.f1829g = true;
            int i3 = c0672b.f1827e;
            if (enumC0548p != EnumC0548p.START_OBJECT) {
                if (i3 == 0) {
                    throw null;
                }
                if (i3 == 3 || i3 == 4) {
                    c0672b.f1827e = 1;
                    i3 = 1;
                }
            }
            int iM4118b = AbstractC1849h.m4118b(i3);
            if (iM4118b == 1) {
                mo1120M();
                mo1145r(strValueOf);
            } else if (iM4118b == 2) {
                mo1121N(c0672b.f1823a);
                mo1145r(c0672b.f1826d);
                mo1125R(strValueOf);
                return;
            } else if (iM4118b != 3 && iM4118b != 4) {
                mo1117J();
                mo1125R(strValueOf);
            }
        }
        if (enumC0548p == EnumC0548p.START_OBJECT) {
            mo1121N(c0672b.f1823a);
        } else if (enumC0548p == EnumC0548p.START_ARRAY) {
            mo1117J();
        }
    }

    /* JADX INFO: renamed from: U */
    public final void m1128U(C0672b c0672b) {
        EnumC0548p enumC0548p = c0672b.f1828f;
        if (enumC0548p == EnumC0548p.START_OBJECT) {
            mo1143p();
        } else if (enumC0548p == EnumC0548p.START_ARRAY) {
            mo1142o();
        }
        if (c0672b.f1829g) {
            int iM4118b = AbstractC1849h.m4118b(c0672b.f1827e);
            if (iM4118b == 0) {
                mo1142o();
                return;
            }
            if (iM4118b == 2 || iM4118b == 3) {
                return;
            }
            if (iM4118b != 4) {
                mo1143p();
                return;
            }
            Object obj = c0672b.f1825c;
            String strValueOf = obj instanceof String ? (String) obj : String.valueOf(obj);
            mo1145r(c0672b.f1826d);
            mo1125R(strValueOf);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1129a(String str) throws C0538f {
        throw new C0538f(str, this);
    }

    /* JADX INFO: renamed from: c */
    public boolean mo1130c() {
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    /* JADX INFO: renamed from: d */
    public boolean mo1131d() {
        return false;
    }

    /* JADX INFO: renamed from: e */
    public abstract AbstractC0540h mo1132e(EnumC0539g enumC0539g);

    /* JADX INFO: renamed from: f */
    public abstract C0640e mo1133f();

    @Override // java.io.Flushable
    public abstract void flush();

    /* JADX INFO: renamed from: g */
    public abstract boolean mo1134g(EnumC0539g enumC0539g);

    /* JADX INFO: renamed from: h */
    public abstract AbstractC0540h mo1135h(int i3, int i4);

    /* JADX INFO: renamed from: i */
    public void mo1136i(Object obj) {
        C0640e c0640eMo1133f = mo1133f();
        if (c0640eMo1133f != null) {
            c0640eMo1133f.f1662h = obj;
        }
    }

    /* JADX INFO: renamed from: j */
    public void mo1137j() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: k */
    public abstract int mo1138k(C0533a c0533a, InputStream inputStream, int i3);

    /* JADX INFO: renamed from: l */
    public abstract void mo1139l(C0533a c0533a, byte[] bArr, int i3, int i4);

    /* JADX INFO: renamed from: m */
    public abstract void mo1140m(boolean z3);

    /* JADX INFO: renamed from: n */
    public void mo1141n(Object obj) throws C0538f {
        if (obj == null) {
            mo1146s();
        } else {
            if (!(obj instanceof byte[])) {
                throw new C0538f("No native support for writing embedded objects of type ".concat(obj.getClass().getName()), this);
            }
            byte[] bArr = (byte[]) obj;
            mo1139l(AbstractC0534b.f1228b, bArr, 0, bArr.length);
        }
    }

    /* JADX INFO: renamed from: o */
    public abstract void mo1142o();

    /* JADX INFO: renamed from: p */
    public abstract void mo1143p();

    /* JADX INFO: renamed from: q */
    public abstract void mo1144q(InterfaceC0551s interfaceC0551s);

    /* JADX INFO: renamed from: r */
    public abstract void mo1145r(String str);

    /* JADX INFO: renamed from: s */
    public abstract void mo1146s();

    /* JADX INFO: renamed from: t */
    public abstract void mo1147t(double d);

    /* JADX INFO: renamed from: u */
    public abstract void mo1148u(float f3);

    /* JADX INFO: renamed from: v */
    public abstract void mo1149v(int i3);

    /* JADX INFO: renamed from: w */
    public abstract void mo1150w(long j2);

    /* JADX INFO: renamed from: x */
    public abstract void mo1151x(String str);

    /* JADX INFO: renamed from: y */
    public abstract void mo1152y(BigDecimal bigDecimal);

    /* JADX INFO: renamed from: z */
    public abstract void mo1153z(BigInteger bigInteger);
}
