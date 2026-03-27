package p042N0;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import p001A.C0009j;
import p005B.AbstractC0032g;
import p025H1.C0283l;
import p050Q0.C0590c;
import p050Q0.C0597j;
import p050Q0.C0599l;
import p058T0.C0636a;
import p058T0.C0641f;
import p058T0.C0642g;
import p058T0.C0644i;
import p061U0.C0655b;
import p061U0.C0657d;
import p061U0.C0658e;
import p066W0.AbstractC0675b;
import p066W0.C0674a;
import p066W0.C0680g;
import p136r.AbstractC1849h;

/* JADX INFO: renamed from: N0.e */
/* JADX INFO: loaded from: classes.dex */
public class C0537e extends AbstractC0556x {

    /* JADX INFO: renamed from: o */
    public static final int f1240o;

    /* JADX INFO: renamed from: p */
    public static final int f1241p;

    /* JADX INFO: renamed from: q */
    public static final int f1242q;

    /* JADX INFO: renamed from: r */
    public static final C0597j f1243r;
    private static final long serialVersionUID = 2;

    /* JADX INFO: renamed from: e */
    public final transient C0658e f1244e;

    /* JADX INFO: renamed from: f */
    public final transient C0655b f1245f;

    /* JADX INFO: renamed from: g */
    public final int f1246g;

    /* JADX INFO: renamed from: h */
    public final int f1247h;

    /* JADX INFO: renamed from: i */
    public final int f1248i;

    /* JADX INFO: renamed from: j */
    public AbstractC0549q f1249j;

    /* JADX INFO: renamed from: k */
    public final C0553u f1250k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC0551s f1251l;

    /* JADX INFO: renamed from: m */
    public final int f1252m;

    /* JADX INFO: renamed from: n */
    public final char f1253n;

    static {
        int[] iArr = new int[5];
        System.arraycopy(AbstractC1849h.f6398a, 0, iArr, 0, 5);
        int iM147e = 0;
        for (int i3 : iArr) {
            if (i3 == 0) {
                throw null;
            }
            iM147e |= AbstractC0032g.m147e(i3);
        }
        f1240o = iM147e;
        int i4 = 0;
        for (EnumC0543k enumC0543k : EnumC0543k.values()) {
            if (enumC0543k.f1296e) {
                i4 |= enumC0543k.f1297f;
            }
        }
        f1241p = i4;
        int i5 = 0;
        for (EnumC0539g enumC0539g : EnumC0539g.values()) {
            if (enumC0539g.f1266e) {
                i5 |= enumC0539g.f1267f;
            }
        }
        f1242q = i5;
        f1243r = C0680g.f1849l;
    }

    public C0537e(C0537e c0537e, AbstractC0549q abstractC0549q) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f1244e = new C0658e((((int) jCurrentTimeMillis) + ((int) (jCurrentTimeMillis >>> 32))) | 1);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        this.f1245f = new C0655b((((int) jCurrentTimeMillis2) + ((int) (jCurrentTimeMillis2 >>> 32))) | 1);
        this.f1246g = f1240o;
        this.f1247h = f1241p;
        this.f1248i = f1242q;
        this.f1251l = f1243r;
        this.f1249j = abstractC0549q;
        this.f1246g = c0537e.f1246g;
        this.f1247h = c0537e.f1247h;
        this.f1248i = c0537e.f1248i;
        C0553u c0553u = c0537e.f1250k;
        this.f1250k = c0553u == null ? C0553u.f1339e : c0553u;
        this.f1251l = c0537e.f1251l;
        this.f1252m = c0537e.f1252m;
        this.f1253n = c0537e.f1253n;
    }

    /* JADX INFO: renamed from: a */
    public C0590c m1084a(Object obj) {
        return new C0590c(obj, !m1096m());
    }

    /* JADX INFO: renamed from: b */
    public C0283l m1085b(C0590c c0590c, boolean z3) {
        if (c0590c == null) {
            c0590c = C0590c.f1511g;
        }
        return new C0283l(this.f1250k, m1095l(), c0590c, z3);
    }

    /* JADX INFO: renamed from: c */
    public AbstractC0540h m1086c(Writer writer, C0283l c0283l) {
        C0644i c0644i = new C0644i(c0283l, this.f1248i, this.f1249j, writer, this.f1253n);
        int i3 = this.f1252m;
        if (i3 > 0) {
            c0644i.m1464b0(i3);
        }
        InterfaceC0551s interfaceC0551s = this.f1251l;
        if (interfaceC0551s != f1243r) {
            c0644i.f1642n = interfaceC0551s;
        }
        return c0644i;
    }

    /* JADX INFO: renamed from: d */
    public AbstractC0545m m1087d(int i3, int i4, C0283l c0283l, byte[] bArr) {
        return new C0636a(i3, i4, c0283l, bArr).m1460a(this.f1247h, this.f1249j, this.f1245f, this.f1244e, this.f1246g);
    }

    /* JADX INFO: renamed from: e */
    public AbstractC0545m m1088e(Reader reader, C0283l c0283l) {
        AbstractC0549q abstractC0549q = this.f1249j;
        int i3 = this.f1246g;
        C0658e c0658e = this.f1244e;
        return new C0641f(c0283l, this.f1247h, reader, abstractC0549q, new C0658e(c0658e, i3, c0658e.f1787c, (C0657d) c0658e.f1786b.get()));
    }

    /* JADX INFO: renamed from: f */
    public AbstractC0545m m1089f(char[] cArr, int i3, int i4, C0283l c0283l, boolean z3) {
        AbstractC0549q abstractC0549q = this.f1249j;
        int i5 = this.f1246g;
        C0658e c0658e = this.f1244e;
        C0657d c0657d = (C0657d) c0658e.f1786b.get();
        return new C0641f(c0283l, this.f1247h, abstractC0549q, new C0658e(c0658e, i5, c0658e.f1787c, c0657d), cArr, i3, i3 + i4, z3);
    }

    /* JADX INFO: renamed from: g */
    public AbstractC0540h m1090g(C0283l c0283l, OutputStream outputStream) {
        C0642g c0642g = new C0642g(c0283l, this.f1248i, this.f1249j, outputStream, this.f1253n);
        int i3 = this.f1252m;
        if (i3 > 0) {
            c0642g.m1464b0(i3);
        }
        InterfaceC0551s interfaceC0551s = this.f1251l;
        if (interfaceC0551s != f1243r) {
            c0642g.f1642n = interfaceC0551s;
        }
        return c0642g;
    }

    /* JADX INFO: renamed from: h */
    public Writer m1091h(OutputStream outputStream, EnumC0536d enumC0536d, C0283l c0283l) {
        return enumC0536d == EnumC0536d.UTF8 ? new C0599l(c0283l, outputStream) : new OutputStreamWriter(outputStream, enumC0536d.f1237e);
    }

    /* JADX INFO: renamed from: i */
    public final OutputStream m1092i(C0283l c0283l, OutputStream outputStream) {
        return outputStream;
    }

    /* JADX INFO: renamed from: j */
    public final Reader m1093j(Reader reader, C0283l c0283l) {
        return reader;
    }

    /* JADX INFO: renamed from: k */
    public final Writer m1094k(Writer writer, C0283l c0283l) {
        return writer;
    }

    /* JADX INFO: renamed from: l */
    public C0674a m1095l() {
        SoftReference softReference;
        if (!AbstractC0032g.m144b(4, this.f1246g)) {
            return new C0674a();
        }
        ThreadLocal threadLocal = AbstractC0675b.f1837b;
        SoftReference softReference2 = (SoftReference) threadLocal.get();
        C0674a c0674a = softReference2 == null ? null : (C0674a) softReference2.get();
        if (c0674a == null) {
            c0674a = new C0674a();
            C0009j c0009j = AbstractC0675b.f1836a;
            if (c0009j != null) {
                ReferenceQueue referenceQueue = (ReferenceQueue) c0009j.f31g;
                softReference = new SoftReference(c0674a, referenceQueue);
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) c0009j.f30f;
                concurrentHashMap.put(softReference, Boolean.TRUE);
                while (true) {
                    SoftReference softReference3 = (SoftReference) referenceQueue.poll();
                    if (softReference3 == null) {
                        break;
                    }
                    concurrentHashMap.remove(softReference3);
                }
            } else {
                softReference = new SoftReference(c0674a);
            }
            threadLocal.set(softReference);
        }
        return c0674a;
    }

    /* JADX INFO: renamed from: m */
    public boolean m1096m() {
        return false;
    }

    /* JADX INFO: renamed from: n */
    public boolean m1097n() {
        return true;
    }

    /* JADX INFO: renamed from: o */
    public AbstractC0540h m1098o(OutputStream outputStream, EnumC0536d enumC0536d) {
        C0283l c0283lM1085b = m1085b(m1084a(outputStream), false);
        c0283lM1085b.f758d = enumC0536d;
        return enumC0536d == EnumC0536d.UTF8 ? m1090g(c0283lM1085b, m1092i(c0283lM1085b, outputStream)) : m1086c(m1094k(m1091h(outputStream, enumC0536d, c0283lM1085b), c0283lM1085b), c0283lM1085b);
    }

    /* JADX INFO: renamed from: p */
    public AbstractC0540h m1099p(Writer writer) {
        C0283l c0283lM1085b = m1085b(m1084a(writer), false);
        return m1086c(m1094k(writer, c0283lM1085b), c0283lM1085b);
    }

    /* JADX INFO: renamed from: q */
    public AbstractC0545m m1100q(Reader reader) {
        C0283l c0283lM1085b = m1085b(m1084a(reader), false);
        return m1088e(m1093j(reader, c0283lM1085b), c0283lM1085b);
    }

    /* JADX INFO: renamed from: r */
    public AbstractC0545m m1101r(String str) {
        int length = str.length();
        if (length > 32768 || !m1097n()) {
            return m1100q(new StringReader(str));
        }
        C0283l c0283lM1085b = m1085b(m1084a(str), true);
        C0283l.m556a((char[]) c0283lM1085b.f764j);
        char[] cArrM1633b = ((C0674a) c0283lM1085b.f759e).m1633b(0, length);
        c0283lM1085b.f764j = cArrM1633b;
        str.getChars(0, length, cArrM1633b, 0);
        return m1089f(cArrM1633b, 0, length, c0283lM1085b, true);
    }

    public Object readResolve() {
        return new C0537e(this, this.f1249j);
    }

    /* JADX INFO: renamed from: s */
    public AbstractC0545m m1102s(byte[] bArr) {
        return m1087d(0, bArr.length, m1085b(m1084a(bArr), true), bArr);
    }

    /* JADX INFO: renamed from: t */
    public AbstractC0549q mo1103t() {
        return this.f1249j;
    }

    /* JADX INFO: renamed from: u */
    public boolean m1104u() {
        return false;
    }

    /* JADX INFO: renamed from: v */
    public C0537e m1105v(AbstractC0549q abstractC0549q) {
        this.f1249j = abstractC0549q;
        return this;
    }

    public C0537e(AbstractC0549q abstractC0549q) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f1244e = new C0658e((((int) jCurrentTimeMillis) + ((int) (jCurrentTimeMillis >>> 32))) | 1);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        this.f1245f = new C0655b((((int) jCurrentTimeMillis2) + ((int) (jCurrentTimeMillis2 >>> 32))) | 1);
        this.f1246g = f1240o;
        this.f1247h = f1241p;
        this.f1248i = f1242q;
        this.f1251l = f1243r;
        this.f1249j = abstractC0549q;
        this.f1253n = '\"';
        this.f1250k = C0553u.f1339e;
    }
}
