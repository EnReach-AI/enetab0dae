package p069X0;

import com.facebook.C1106c;
import com.fasterxml.jackson.databind.deser.AbstractC1176k;
import com.fasterxml.jackson.databind.deser.AbstractC1208x;
import com.fasterxml.jackson.databind.deser.C1138e;
import com.fasterxml.jackson.databind.deser.C1175j;
import com.fasterxml.jackson.databind.deser.InterfaceC1139f;
import com.fasterxml.jackson.databind.deser.impl.AbstractC1145C;
import com.fasterxml.jackson.databind.deser.impl.TypeWrappedDeserializer;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import p001A.C0009j;
import p005B.AbstractC0032g;
import p039M0.AbstractC0485d0;
import p042N0.AbstractC0545m;
import p042N0.C0553u;
import p042N0.EnumC0548p;
import p042N0.EnumC0552t;
import p058T0.C0640e;
import p066W0.C0684k;
import p074Z0.AbstractC0832r;
import p074Z0.C0818d;
import p074Z0.C0834t;
import p074Z0.EnumC0816b;
import p078a1.C0850b;
import p078a1.C0851c;
import p078a1.C0853e;
import p082b1.AbstractC1007C;
import p082b1.AbstractC1041l;
import p082b1.C1005A;
import p103h1.AbstractC1428p;
import p114l1.C1675q;
import p114l1.EnumC1664f;
import p118m1.AbstractC1745j;
import p118m1.C1729D;
import p118m1.C1730E;
import p118m1.C1739d;

/* JADX INFO: renamed from: X0.i */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0718i extends AbstractC0715f implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final C1175j f1996e;

    /* JADX INFO: renamed from: f */
    public final AbstractC1176k f1997f;

    /* JADX INFO: renamed from: g */
    public final C0717h f1998g;

    /* JADX INFO: renamed from: h */
    public final int f1999h;

    /* JADX INFO: renamed from: i */
    public final C0684k f2000i;

    /* JADX INFO: renamed from: j */
    public final Class f2001j;

    /* JADX INFO: renamed from: k */
    public final transient AbstractC0545m f2002k;

    /* JADX INFO: renamed from: l */
    public transient C1739d f2003l;

    /* JADX INFO: renamed from: m */
    public transient C1106c f2004m;

    /* JADX INFO: renamed from: n */
    public transient DateFormat f2005n;

    /* JADX INFO: renamed from: o */
    public C0009j f2006o;

    public AbstractC0718i(AbstractC1176k abstractC1176k) {
        if (abstractC1176k == null) {
            throw new NullPointerException("Cannot pass null DeserializerFactory");
        }
        this.f1997f = abstractC1176k;
        this.f1996e = new C1175j();
        this.f1999h = 0;
        this.f2000i = null;
        this.f1998g = null;
        this.f2001j = null;
    }

    /* JADX INFO: renamed from: U */
    public static void m1821U(Class cls, AbstractC0545m abstractC0545m, EnumC0548p enumC0548p) throws C0850b {
        throw new C0850b((Closeable) abstractC0545m, "Trailing token (of type " + enumC0548p + ") found after value (bound as " + AbstractC1745j.m3903z(cls) + "): not allowed as per `DeserializationFeature.FAIL_ON_TRAILING_TOKENS`");
    }

    /* JADX INFO: renamed from: Z */
    public static C0850b m1822Z(AbstractC0545m abstractC0545m, EnumC0548p enumC0548p, String str) {
        return new C0850b((Closeable) abstractC0545m, AbstractC0715f.m1809a("Unexpected token (" + abstractC0545m.mo1190e() + "), expected " + enumC0548p, str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: A */
    public final AbstractC0722m m1823A(AbstractC0722m abstractC0722m, InterfaceC0714e interfaceC0714e, AbstractC0721l abstractC0721l) {
        boolean z3 = abstractC0722m instanceof InterfaceC1139f;
        AbstractC0722m abstractC0722m2 = abstractC0722m;
        if (z3) {
            this.f2006o = new C0009j(abstractC0721l, 25, this.f2006o);
            try {
                AbstractC0722m abstractC0722mCreateContextual = ((InterfaceC1139f) abstractC0722m).createContextual(this, interfaceC0714e);
            } finally {
                this.f2006o = (C0009j) this.f2006o.f31g;
            }
        }
        return abstractC0722m2;
    }

    /* JADX INFO: renamed from: B */
    public final void m1824B(AbstractC0545m abstractC0545m, AbstractC0721l abstractC0721l) throws C0850b {
        m1826D(abstractC0721l, abstractC0545m.mo1190e(), abstractC0545m, null, new Object[0]);
        throw null;
    }

    /* JADX INFO: renamed from: C */
    public final void m1825C(AbstractC0545m abstractC0545m, Class cls) throws C0850b {
        m1826D(m1848m(cls), abstractC0545m.mo1190e(), abstractC0545m, null, new Object[0]);
        throw null;
    }

    /* JADX INFO: renamed from: D */
    public final void m1826D(AbstractC0721l abstractC0721l, EnumC0548p enumC0548p, AbstractC0545m abstractC0545m, String str, Object... objArr) throws C0850b {
        String str2;
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        C0009j c0009j = this.f1998g.f1987q;
        if (c0009j != null) {
            AbstractC0032g.m162t(c0009j.f30f);
            throw null;
        }
        if (str == null) {
            String strM3895r = AbstractC1745j.m3895r(abstractC0721l);
            if (enumC0548p == null) {
                str = AbstractC0032g.m152j("Unexpected end-of-input when trying read value of type ", strM3895r);
            } else {
                switch (enumC0548p.ordinal()) {
                    case 1:
                    case 2:
                    case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                        str2 = "Object value";
                        break;
                    case FromStringDeserializer.Std.STD_URI /* 3 */:
                    case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                        str2 = "Array value";
                        break;
                    case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                        str2 = "Embedded Object";
                        break;
                    case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                        str2 = "String value";
                        break;
                    case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                        str2 = "Integer value";
                        break;
                    case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                        str2 = "Floating-point value";
                        break;
                    case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                    case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                        str2 = "Boolean value";
                        break;
                    case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                        str2 = "Null value";
                        break;
                    default:
                        str2 = "[Unavailable value]";
                        break;
                }
                str = "Cannot deserialize value of type " + strM3895r + " from " + str2 + " (token `JsonToken." + enumC0548p + "`)";
            }
        }
        if (enumC0548p != null && enumC0548p.f1332l) {
            abstractC0545m.mo1157B();
        }
        m1842T(str, new Object[0]);
        throw null;
    }

    /* JADX INFO: renamed from: E */
    public final void m1827E(Class cls, String str, String str2, Object... objArr) throws C0851c {
        if (objArr.length > 0) {
            str2 = String.format(str2, objArr);
        }
        C0009j c0009j = this.f1998g.f1987q;
        if (c0009j != null) {
            AbstractC0032g.m162t(c0009j.f30f);
            throw null;
        }
        throw new C0851c(this.f2002k, "Cannot deserialize Map key of type " + AbstractC1745j.m3903z(cls) + " from String " + AbstractC0715f.m1810b(str) + ": " + str2, str);
    }

    /* JADX INFO: renamed from: F */
    public final void m1828F(Class cls, Number number, String str, Object... objArr) throws C0851c {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        C0009j c0009j = this.f1998g.f1987q;
        if (c0009j != null) {
            AbstractC0032g.m162t(c0009j.f30f);
            throw null;
        }
        throw new C0851c(this.f2002k, "Cannot deserialize value of type " + AbstractC1745j.m3903z(cls) + " from number " + String.valueOf(number) + ": " + str, number);
    }

    /* JADX INFO: renamed from: G */
    public final void m1829G(Class cls, String str, String str2, Object... objArr) throws C0851c {
        if (objArr.length > 0) {
            str2 = String.format(str2, objArr);
        }
        C0009j c0009j = this.f1998g.f1987q;
        if (c0009j == null) {
            throw m1846Y(str, cls, str2);
        }
        AbstractC0032g.m162t(c0009j.f30f);
        throw null;
    }

    /* JADX INFO: renamed from: H */
    public final boolean m1830H(int i3) {
        return (i3 & this.f1999h) != 0;
    }

    /* JADX INFO: renamed from: I */
    public final C0850b m1831I(Class cls, Throwable th) {
        String strM3886i;
        if (th == null) {
            strM3886i = "N/A";
        } else {
            strM3886i = AbstractC1745j.m3886i(th);
            if (strM3886i == null) {
                strM3886i = AbstractC1745j.m3903z(th.getClass());
            }
        }
        String strM155m = AbstractC0032g.m155m("Cannot construct instance of ", AbstractC1745j.m3903z(cls), ", problem: ", strM3886i);
        m1848m(cls);
        return new C0850b(this.f2002k, strM155m, th);
    }

    /* JADX INFO: renamed from: J */
    public final boolean m1832J(EnumC0552t enumC0552t) {
        C0684k c0684k = this.f2000i;
        c0684k.getClass();
        return (enumC0552t.mo1234a() & c0684k.f1859a) != 0;
    }

    /* JADX INFO: renamed from: K */
    public final boolean m1833K(EnumC0719j enumC0719j) {
        return (enumC0719j.f2035f & this.f1999h) != 0;
    }

    /* JADX INFO: renamed from: L */
    public abstract AbstractC0730u mo1834L(Object obj);

    /* JADX INFO: renamed from: M */
    public final C1106c m1835M() {
        C1106c c1106c = this.f2004m;
        if (c1106c == null) {
            return new C1106c();
        }
        this.f2004m = null;
        return c1106c;
    }

    /* JADX INFO: renamed from: N */
    public final Date m1836N(String str) {
        try {
            DateFormat dateFormat = this.f2005n;
            if (dateFormat == null) {
                dateFormat = (DateFormat) this.f1998g.f2481f.f2426l.clone();
                this.f2005n = dateFormat;
            }
            return dateFormat.parse(str);
        } catch (ParseException e3) {
            throw new IllegalArgumentException(AbstractC0032g.m155m("Failed to parse Date value '", str, "': ", AbstractC1745j.m3886i(e3)));
        }
    }

    /* JADX INFO: renamed from: O */
    public final Object m1837O(AbstractC0545m abstractC0545m, Class cls) throws C0850b {
        AbstractC0721l abstractC0721lM3780j = mo1711f().m3780j(cls);
        AbstractC0722m abstractC0722mM1856u = m1856u(abstractC0721lM3780j);
        if (abstractC0722mM1856u != null) {
            return abstractC0722mM1856u.deserialize(abstractC0545m, this);
        }
        mo1713k("Could not find JsonDeserializer for type " + AbstractC1745j.m3895r(abstractC0721lM3780j));
        throw null;
    }

    /* JADX INFO: renamed from: P */
    public final void m1838P(C1005A c1005a, AbstractC1007C abstractC1007C, String str, Object... objArr) throws C0850b {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        Annotation[] annotationArr = AbstractC1745j.f6110a;
        throw new C0850b((Closeable) this.f2002k, "Invalid definition for property " + AbstractC1745j.m3880c(abstractC1007C.mo1808f()) + " (of type " + AbstractC1745j.m3903z(c1005a.f1980a.f2036e) + "): " + str);
    }

    /* JADX INFO: renamed from: Q */
    public final void m1839Q(AbstractC0712c abstractC0712c, String str, Object... objArr) throws C0850b {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        throw new C0850b((Closeable) this.f2002k, AbstractC0032g.m155m("Invalid type definition for type ", AbstractC1745j.m3903z(abstractC0712c.f1980a.f2036e), ": ", str));
    }

    /* JADX INFO: renamed from: R */
    public final void m1840R(InterfaceC0714e interfaceC0714e, String str, Object... objArr) throws C0850b {
        AbstractC1041l abstractC1041lMo1805c;
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        if (interfaceC0714e != null) {
            interfaceC0714e.getType();
        }
        C0850b c0850b = new C0850b(this.f2002k, str);
        if (interfaceC0714e == null || (abstractC1041lMo1805c = interfaceC0714e.mo1805c()) == null) {
            throw c0850b;
        }
        c0850b.mo1816d(interfaceC0714e.mo1808f(), abstractC1041lMo1805c.mo2770i());
        throw c0850b;
    }

    /* JADX INFO: renamed from: S */
    public final void m1841S(AbstractC0722m abstractC0722m, String str, Object... objArr) throws C0850b {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        abstractC0722m.handledType();
        throw new C0850b((Closeable) this.f2002k, str);
    }

    /* JADX INFO: renamed from: T */
    public final void m1842T(String str, Object... objArr) throws C0850b {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        throw new C0850b(this.f2002k, str);
    }

    /* JADX INFO: renamed from: V */
    public final void m1843V(EnumC0548p enumC0548p, String str, Object... objArr) throws C0850b {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        AbstractC0545m abstractC0545m = this.f2002k;
        throw new C0850b(abstractC0545m, AbstractC0715f.m1809a("Unexpected token (" + abstractC0545m.mo1190e() + "), expected " + enumC0548p, str));
    }

    /* JADX INFO: renamed from: W */
    public final void m1844W(AbstractC0722m abstractC0722m, EnumC0548p enumC0548p, String str, Object... objArr) throws C0850b {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        abstractC0722m.handledType();
        throw m1822Z(this.f2002k, enumC0548p, str);
    }

    /* JADX INFO: renamed from: X */
    public final void m1845X(C1106c c1106c) {
        C1106c c1106c2 = this.f2004m;
        if (c1106c2 != null) {
            Object[] objArr = (Object[]) c1106c.f3844d;
            int length = objArr == null ? 0 : objArr.length;
            Object[] objArr2 = (Object[]) c1106c2.f3844d;
            if (length < (objArr2 != null ? objArr2.length : 0)) {
                return;
            }
        }
        this.f2004m = c1106c;
    }

    /* JADX INFO: renamed from: Y */
    public final C0851c m1846Y(String str, Class cls, String str2) {
        return new C0851c(this.f2002k, "Cannot deserialize value of type " + AbstractC1745j.m3903z(cls) + " from String " + AbstractC0715f.m1810b(str) + ": " + str2, str);
    }

    @Override // p069X0.AbstractC0715f
    /* JADX INFO: renamed from: e */
    public final AbstractC0832r mo1710e() {
        return this.f1998g;
    }

    @Override // p069X0.AbstractC0715f
    /* JADX INFO: renamed from: f */
    public final C1675q mo1711f() {
        return this.f1998g.f2481f.f2419e;
    }

    @Override // p069X0.AbstractC0715f
    /* JADX INFO: renamed from: g */
    public final C0853e mo1712g(AbstractC0721l abstractC0721l, String str, String str2) {
        return new C0853e(this.f2002k, AbstractC0715f.m1809a(AbstractC0032g.m155m("Could not resolve type id '", str, "' as a subtype of ", AbstractC1745j.m3895r(abstractC0721l)), str2));
    }

    @Override // p069X0.AbstractC0715f
    /* JADX INFO: renamed from: k */
    public final Object mo1713k(String str) throws C0850b {
        throw new C0850b((Closeable) this.f2002k, str);
    }

    /* JADX INFO: renamed from: l */
    public final C1730E m1847l(AbstractC0545m abstractC0545m) {
        C1730E c1730e = new C1730E();
        c1730e.f6059i = C0553u.f1339e;
        c1730e.f6068r = false;
        c1730e.f6056f = abstractC0545m.mo1196k();
        c1730e.f6059i = abstractC0545m.mo1189d0();
        c1730e.f6057g = abstractC0545m.mo1210y();
        c1730e.f6058h = C1730E.f6055t;
        c1730e.f6069s = new C0640e(0, null, null);
        C1729D c1729d = new C1729D();
        c1730e.f6064n = c1729d;
        c1730e.f6063m = c1729d;
        c1730e.f6065o = 0;
        c1730e.f6060j = abstractC0545m.mo1184b();
        boolean zMo1182a = abstractC0545m.mo1182a();
        c1730e.f6061k = zMo1182a;
        c1730e.f6062l = c1730e.f6060j || zMo1182a;
        m1833K(EnumC0719j.USE_BIG_DECIMAL_FOR_FLOATS);
        return c1730e;
    }

    /* JADX INFO: renamed from: m */
    public final AbstractC0721l m1848m(Class cls) {
        if (cls == null) {
            return null;
        }
        return this.f1998g.m2148c(cls);
    }

    /* JADX INFO: renamed from: n */
    public abstract AbstractC0722m mo1849n(Object obj);

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        if (r9.m1820r(p069X0.EnumC0719j.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
    
        if (r9.m1820r(p069X0.EnumC0719j.ACCEPT_FLOAT_AS_INT) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0081, code lost:
    
        if (r8 == p114l1.EnumC1664f.f5901q) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0087  */
    /* JADX INFO: renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p074Z0.EnumC0816b m1850o(p114l1.EnumC1664f r8, java.lang.Class r9, p074Z0.EnumC0819e r10) {
        /*
            r7 = this;
            X0.h r9 = r7.f1998g
            Z0.d r0 = r9.f1989s
            r0.getClass()
            Z0.t r1 = r0.f2438f
            Z0.b[] r1 = r1.f2436e
            int r2 = r10.ordinal()
            r1 = r1[r2]
            if (r1 == 0) goto L15
            goto L89
        L15:
            int r1 = r10.ordinal()
            Z0.b r2 = p074Z0.EnumC0816b.f2432g
            Z0.b r3 = p074Z0.EnumC0816b.f2431f
            Z0.b r4 = p074Z0.EnumC0816b.f2430e
            r5 = 2
            l1.f r6 = p114l1.EnumC1664f.f5894j
            if (r1 == r5) goto L3f
            r5 = 3
            if (r1 == r5) goto L34
            r5 = 7
            if (r1 == r5) goto L2b
            goto L4d
        L2b:
            X0.j r8 = p069X0.EnumC0719j.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT
            boolean r8 = r9.m1820r(r8)
            if (r8 == 0) goto L4b
            goto L85
        L34:
            if (r8 != r6) goto L4d
            X0.j r8 = p069X0.EnumC0719j.ACCEPT_FLOAT_AS_INT
            boolean r8 = r9.m1820r(r8)
            if (r8 == 0) goto L4b
            goto L83
        L3f:
            l1.f r1 = p114l1.EnumC1664f.f5897m
            if (r8 != r1) goto L4d
            X0.j r1 = p069X0.EnumC0719j.FAIL_ON_NUMBERS_FOR_ENUMS
            boolean r1 = r9.m1820r(r1)
            if (r1 == 0) goto L4d
        L4b:
            r1 = r4
            goto L89
        L4d:
            l1.f r1 = p114l1.EnumC1664f.f5895k
            if (r8 == r1) goto L5e
            if (r8 == r6) goto L5e
            l1.f r5 = p114l1.EnumC1664f.f5896l
            if (r8 == r5) goto L5e
            l1.f r5 = p114l1.EnumC1664f.f5900p
            if (r8 != r5) goto L5c
            goto L5e
        L5c:
            r5 = 0
            goto L5f
        L5e:
            r5 = 1
        L5f:
            if (r5 == 0) goto L70
            X0.v r6 = p069X0.EnumC0731v.ALLOW_COERCION_OF_SCALARS
            boolean r6 = r9.m2157l(r6)
            if (r6 != 0) goto L70
            if (r8 != r1) goto L4b
            Z0.e r1 = p074Z0.EnumC0819e.f2439e
            if (r10 == r1) goto L70
            goto L4b
        L70:
            Z0.e r1 = p074Z0.EnumC0819e.f2444j
            if (r10 != r1) goto L87
            if (r5 != 0) goto L85
            X0.j r10 = p069X0.EnumC0719j.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT
            boolean r9 = r9.m1820r(r10)
            if (r9 == 0) goto L7f
            goto L85
        L7f:
            l1.f r9 = p114l1.EnumC1664f.f5901q
            if (r8 != r9) goto L4b
        L83:
            r1 = r3
            goto L89
        L85:
            r1 = r2
            goto L89
        L87:
            Z0.b r1 = r0.f2437e
        L89:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p069X0.AbstractC0718i.m1850o(l1.f, java.lang.Class, Z0.e):Z0.b");
    }

    /* JADX INFO: renamed from: p */
    public final EnumC0816b m1851p(EnumC1664f enumC1664f, Class cls) {
        EnumC0816b enumC0816b = EnumC0816b.f2430e;
        C0717h c0717h = this.f1998g;
        C0818d c0818d = c0717h.f1989s;
        c0818d.getClass();
        C0834t c0834t = c0818d.f2438f;
        c0834t.getClass();
        EnumC0816b enumC0816b2 = c0834t.f2436e[9];
        if (Boolean.FALSE.equals(null)) {
            return enumC0816b;
        }
        if (enumC0816b2 == null) {
            boolean z3 = enumC1664f == EnumC1664f.f5895k || enumC1664f == EnumC1664f.f5894j || enumC1664f == EnumC1664f.f5896l || enumC1664f == EnumC1664f.f5900p;
            enumC0816b2 = EnumC0816b.f2432g;
            if (!z3 && !c0717h.m1820r(EnumC0719j.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) {
                return enumC0816b;
            }
        }
        return enumC0816b2;
    }

    /* JADX INFO: renamed from: q */
    public final AbstractC0722m m1852q(AbstractC0721l abstractC0721l, InterfaceC0714e interfaceC0714e) {
        return m1823A(this.f1996e.m3020f(this, this.f1997f, abstractC0721l), interfaceC0714e, abstractC0721l);
    }

    /* JADX INFO: renamed from: r */
    public final Object m1853r(Object obj) {
        Annotation[] annotationArr = AbstractC1745j.f6110a;
        m1815j(obj == null ? null : obj.getClass(), String.format("No 'injectableValues' configured, cannot inject value with id [%s]", obj));
        throw null;
    }

    /* JADX INFO: renamed from: s */
    public final AbstractC0730u m1854s(AbstractC0721l abstractC0721l) throws C0850b {
        try {
            C1175j c1175j = this.f1996e;
            AbstractC1176k abstractC1176k = this.f1997f;
            c1175j.getClass();
            return C1175j.m3018e(this, abstractC1176k, abstractC0721l);
        } catch (IllegalArgumentException e3) {
            mo1713k(AbstractC1745j.m3886i(e3));
            throw null;
        }
    }

    /* JADX INFO: renamed from: t */
    public abstract AbstractC1145C mo1855t(Object obj, AbstractC0485d0 abstractC0485d0);

    /* JADX INFO: renamed from: u */
    public final AbstractC0722m m1856u(AbstractC0721l abstractC0721l) {
        C1175j c1175j = this.f1996e;
        AbstractC1176k abstractC1176k = this.f1997f;
        AbstractC0722m abstractC0722mM1823A = m1823A(c1175j.m3020f(this, abstractC1176k, abstractC0721l), null, abstractC0721l);
        AbstractC1428p abstractC1428pMo2938b = abstractC1176k.mo2938b(this.f1998g, abstractC0721l);
        return abstractC1428pMo2938b != null ? new TypeWrappedDeserializer(abstractC1428pMo2938b.mo3404f(null), abstractC0722mM1823A) : abstractC0722mM1823A;
    }

    /* JADX INFO: renamed from: v */
    public final C1739d m1857v() {
        if (this.f2003l == null) {
            C1739d c1739d = new C1739d();
            c1739d.f6090a = null;
            c1739d.f6091b = null;
            c1739d.f6092c = null;
            c1739d.f6093d = null;
            c1739d.f6094e = null;
            c1739d.f6095f = null;
            c1739d.f6096g = null;
            this.f2003l = c1739d;
        }
        return this.f2003l;
    }

    /* JADX INFO: renamed from: w */
    public final void m1858w(AbstractC0722m abstractC0722m) throws C0850b {
        if (this.f1998g.m2157l(EnumC0731v.IGNORE_MERGE_FOR_UNMERGEABLE)) {
            return;
        }
        throw new C0850b((Closeable) this.f2002k, AbstractC0032g.m154l("Invalid configuration: values of type ", AbstractC1745j.m3895r(m1848m(abstractC0722m.handledType())), " cannot be merged"));
    }

    /* JADX INFO: renamed from: x */
    public final void m1859x(Class cls, Throwable th) throws C0850b {
        C0009j c0009j = this.f1998g.f1987q;
        if (c0009j != null) {
            AbstractC0032g.m162t(c0009j.f30f);
            throw null;
        }
        AbstractC1745j.m3874D(th);
        if (!m1833K(EnumC0719j.WRAP_EXCEPTIONS)) {
            AbstractC1745j.m3875E(th);
        }
        throw m1831I(cls, th);
    }

    /* JADX INFO: renamed from: y */
    public final Object m1860y(Class cls, AbstractC1208x abstractC1208x, String str, Object... objArr) throws C0850b {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        C0009j c0009j = this.f1998g.f1987q;
        if (c0009j != null) {
            AbstractC0032g.m162t(c0009j.f30f);
            throw null;
        }
        if (abstractC1208x == null) {
            m1815j(cls, AbstractC0032g.m155m("Cannot construct instance of ", AbstractC1745j.m3903z(cls), ": ", str));
            throw null;
        }
        if (abstractC1208x.mo3006l()) {
            throw new C0850b((Closeable) this.f2002k, AbstractC0032g.m155m("Cannot construct instance of ", AbstractC1745j.m3903z(cls), " (although at least one Creator exists): ", str));
        }
        m1815j(cls, AbstractC0032g.m155m("Cannot construct instance of ", AbstractC1745j.m3903z(cls), " (no Creators, like default constructor, exist): ", str));
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: z */
    public final AbstractC0722m m1861z(AbstractC0722m abstractC0722m, InterfaceC0714e interfaceC0714e, AbstractC0721l abstractC0721l) {
        boolean z3 = abstractC0722m instanceof InterfaceC1139f;
        AbstractC0722m abstractC0722m2 = abstractC0722m;
        if (z3) {
            this.f2006o = new C0009j(abstractC0721l, 25, this.f2006o);
            try {
                AbstractC0722m abstractC0722mCreateContextual = ((InterfaceC1139f) abstractC0722m).createContextual(this, interfaceC0714e);
            } finally {
                this.f2006o = (C0009j) this.f2006o.f31g;
            }
        }
        return abstractC0722m2;
    }

    public AbstractC0718i(AbstractC0718i abstractC0718i, C1138e c1138e) {
        this.f1996e = abstractC0718i.f1996e;
        this.f1997f = c1138e;
        this.f1998g = abstractC0718i.f1998g;
        this.f1999h = abstractC0718i.f1999h;
        this.f2000i = abstractC0718i.f2000i;
        this.f2001j = abstractC0718i.f2001j;
        this.f2002k = abstractC0718i.f2002k;
    }

    public AbstractC0718i(AbstractC0718i abstractC0718i, C0717h c0717h, AbstractC0545m abstractC0545m) {
        this.f1996e = abstractC0718i.f1996e;
        this.f1997f = abstractC0718i.f1997f;
        this.f2000i = abstractC0545m == null ? null : abstractC0545m.mo1211z();
        this.f1998g = c0717h;
        this.f1999h = c0717h.f1991u;
        this.f2001j = c0717h.f2487j;
        this.f2002k = abstractC0545m;
    }

    public AbstractC0718i(AbstractC0718i abstractC0718i, C0717h c0717h) {
        this.f1996e = abstractC0718i.f1996e;
        this.f1997f = abstractC0718i.f1997f;
        this.f2000i = null;
        this.f1998g = c0717h;
        this.f1999h = c0717h.f1991u;
        this.f2001j = null;
        this.f2002k = null;
    }
}
