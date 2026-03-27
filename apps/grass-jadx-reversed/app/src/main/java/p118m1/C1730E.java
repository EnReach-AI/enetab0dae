package p118m1;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.TreeMap;
import p042N0.AbstractC0540h;
import p042N0.AbstractC0545m;
import p042N0.AbstractC0547o;
import p042N0.AbstractC0549q;
import p042N0.C0533a;
import p042N0.C0538f;
import p042N0.C0553u;
import p042N0.EnumC0539g;
import p042N0.EnumC0548p;
import p042N0.InterfaceC0551s;
import p050Q0.C0597j;
import p058T0.C0640e;

/* JADX INFO: renamed from: m1.E */
/* JADX INFO: loaded from: classes.dex */
public final class C1730E extends AbstractC0540h {

    /* JADX INFO: renamed from: t */
    public static final int f6055t;

    /* JADX INFO: renamed from: f */
    public AbstractC0549q f6056f;

    /* JADX INFO: renamed from: g */
    public AbstractC0547o f6057g;

    /* JADX INFO: renamed from: h */
    public int f6058h;

    /* JADX INFO: renamed from: i */
    public C0553u f6059i;

    /* JADX INFO: renamed from: j */
    public boolean f6060j;

    /* JADX INFO: renamed from: k */
    public boolean f6061k;

    /* JADX INFO: renamed from: l */
    public boolean f6062l;

    /* JADX INFO: renamed from: m */
    public C1729D f6063m;

    /* JADX INFO: renamed from: n */
    public C1729D f6064n;

    /* JADX INFO: renamed from: o */
    public int f6065o;

    /* JADX INFO: renamed from: p */
    public Object f6066p;

    /* JADX INFO: renamed from: q */
    public Object f6067q;

    /* JADX INFO: renamed from: r */
    public boolean f6068r;

    /* JADX INFO: renamed from: s */
    public C0640e f6069s;

    static {
        int i3 = 0;
        for (EnumC0539g enumC0539g : EnumC0539g.values()) {
            if (enumC0539g.f1266e) {
                i3 |= enumC0539g.f1267f;
            }
        }
        f6055t = i3;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: A */
    public final void mo1108A(short s3) {
        m3855Z(EnumC0548p.VALUE_NUMBER_INT, Short.valueOf(s3));
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: B */
    public final void mo1109B(Object obj) {
        if (obj == null) {
            mo1146s();
            return;
        }
        if (obj.getClass() == byte[].class || (obj instanceof C1760y)) {
            m3855Z(EnumC0548p.VALUE_EMBEDDED_OBJECT, obj);
            return;
        }
        AbstractC0549q abstractC0549q = this.f6056f;
        if (abstractC0549q == null) {
            m3855Z(EnumC0548p.VALUE_EMBEDDED_OBJECT, obj);
        } else {
            abstractC0549q.mo1223c(this, obj);
        }
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: C */
    public final void mo1110C(Object obj) {
        this.f6067q = obj;
        this.f6068r = true;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: D */
    public final void mo1111D(char c3) {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: E */
    public final void mo1112E(InterfaceC0551s interfaceC0551s) {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: F */
    public final void mo1113F(String str) {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: G */
    public final void mo1114G(char[] cArr, int i3) {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: I */
    public final void mo1116I(String str) {
        EnumC0548p enumC0548p = EnumC0548p.VALUE_EMBEDDED_OBJECT;
        C1760y c1760y = new C1760y();
        c1760y.f6138e = str;
        m3855Z(enumC0548p, c1760y);
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: J */
    public final void mo1117J() {
        this.f6069s.m1472n();
        m3853X(EnumC0548p.START_ARRAY);
        this.f6069s = this.f6069s.m1467i();
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: K */
    public final void mo1118K(Object obj) {
        this.f6069s.m1472n();
        m3853X(EnumC0548p.START_ARRAY);
        this.f6069s = this.f6069s.m1468j(obj);
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: L */
    public final void mo1119L(Object obj) {
        this.f6069s.m1472n();
        m3853X(EnumC0548p.START_ARRAY);
        this.f6069s = this.f6069s.m1468j(obj);
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: M */
    public final void mo1120M() {
        this.f6069s.m1472n();
        m3853X(EnumC0548p.START_OBJECT);
        this.f6069s = this.f6069s.m1469k();
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: N */
    public final void mo1121N(Object obj) {
        this.f6069s.m1472n();
        m3853X(EnumC0548p.START_OBJECT);
        this.f6069s = this.f6069s.m1470l(obj);
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: O */
    public final void mo1122O(Object obj) {
        this.f6069s.m1472n();
        m3853X(EnumC0548p.START_OBJECT);
        this.f6069s = this.f6069s.m1470l(obj);
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: P */
    public final void mo1123P(int i3, char[] cArr, int i4) {
        mo1125R(new String(cArr, i3, i4));
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: Q */
    public final void mo1124Q(InterfaceC0551s interfaceC0551s) {
        if (interfaceC0551s == null) {
            mo1146s();
        } else {
            m3855Z(EnumC0548p.VALUE_STRING, interfaceC0551s);
        }
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: R */
    public final void mo1125R(String str) {
        if (str == null) {
            mo1146s();
        } else {
            m3855Z(EnumC0548p.VALUE_STRING, str);
        }
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: S */
    public final void mo1126S(Object obj) {
        this.f6066p = obj;
        this.f6068r = true;
    }

    /* JADX INFO: renamed from: V */
    public final void m3851V(Object obj) {
        C1729D c1729d = null;
        if (this.f6068r) {
            C1729D c1729d2 = this.f6064n;
            int i3 = this.f6065o;
            EnumC0548p enumC0548p = EnumC0548p.FIELD_NAME;
            Object obj2 = this.f6067q;
            Object obj3 = this.f6066p;
            if (i3 < 16) {
                c1729d2.f6053c[i3] = obj;
                long jOrdinal = enumC0548p.ordinal();
                if (i3 > 0) {
                    jOrdinal <<= i3 << 2;
                }
                c1729d2.f6052b = jOrdinal | c1729d2.f6052b;
                c1729d2.m3848b(obj2, i3, obj3);
            } else {
                c1729d2.getClass();
                C1729D c1729d3 = new C1729D();
                c1729d2.f6051a = c1729d3;
                c1729d3.f6053c[0] = obj;
                c1729d3.f6052b = ((long) enumC0548p.ordinal()) | c1729d3.f6052b;
                c1729d3.m3848b(obj2, 0, obj3);
                c1729d = c1729d2.f6051a;
            }
        } else {
            C1729D c1729d4 = this.f6064n;
            int i4 = this.f6065o;
            EnumC0548p enumC0548p2 = EnumC0548p.FIELD_NAME;
            if (i4 < 16) {
                c1729d4.f6053c[i4] = obj;
                long jOrdinal2 = enumC0548p2.ordinal();
                if (i4 > 0) {
                    jOrdinal2 <<= i4 << 2;
                }
                c1729d4.f6052b |= jOrdinal2;
            } else {
                c1729d4.getClass();
                C1729D c1729d5 = new C1729D();
                c1729d4.f6051a = c1729d5;
                c1729d5.f6053c[0] = obj;
                c1729d5.f6052b = ((long) enumC0548p2.ordinal()) | c1729d5.f6052b;
                c1729d = c1729d4.f6051a;
            }
        }
        if (c1729d == null) {
            this.f6065o++;
        } else {
            this.f6064n = c1729d;
            this.f6065o = 1;
        }
    }

    /* JADX INFO: renamed from: W */
    public final void m3852W(StringBuilder sb) {
        Object objM3849c = this.f6064n.m3849c(this.f6065o - 1);
        if (objM3849c != null) {
            sb.append("[objectId=");
            sb.append(String.valueOf(objM3849c));
            sb.append(']');
        }
        C1729D c1729d = this.f6064n;
        int i3 = this.f6065o - 1;
        TreeMap treeMap = c1729d.f6054d;
        Object obj = treeMap == null ? null : treeMap.get(Integer.valueOf(i3 + i3));
        if (obj != null) {
            sb.append("[typeId=");
            sb.append(String.valueOf(obj));
            sb.append(']');
        }
    }

    /* JADX INFO: renamed from: X */
    public final void m3853X(EnumC0548p enumC0548p) {
        C1729D c1729dM3847a;
        if (this.f6068r) {
            C1729D c1729d = this.f6064n;
            int i3 = this.f6065o;
            Object obj = this.f6067q;
            Object obj2 = this.f6066p;
            c1729d.getClass();
            if (i3 < 16) {
                long jOrdinal = enumC0548p.ordinal();
                if (i3 > 0) {
                    jOrdinal <<= i3 << 2;
                }
                c1729d.f6052b = jOrdinal | c1729d.f6052b;
                c1729d.m3848b(obj, i3, obj2);
                c1729dM3847a = null;
            } else {
                C1729D c1729d2 = new C1729D();
                c1729d.f6051a = c1729d2;
                c1729d2.f6052b = ((long) enumC0548p.ordinal()) | c1729d2.f6052b;
                c1729d2.m3848b(obj, 0, obj2);
                c1729dM3847a = c1729d.f6051a;
            }
        } else {
            c1729dM3847a = this.f6064n.m3847a(this.f6065o, enumC0548p);
        }
        if (c1729dM3847a == null) {
            this.f6065o++;
        } else {
            this.f6064n = c1729dM3847a;
            this.f6065o = 1;
        }
    }

    /* JADX INFO: renamed from: Y */
    public final void m3854Y(EnumC0548p enumC0548p) {
        C1729D c1729dM3847a;
        this.f6069s.m1472n();
        if (this.f6068r) {
            C1729D c1729d = this.f6064n;
            int i3 = this.f6065o;
            Object obj = this.f6067q;
            Object obj2 = this.f6066p;
            c1729d.getClass();
            if (i3 < 16) {
                long jOrdinal = enumC0548p.ordinal();
                if (i3 > 0) {
                    jOrdinal <<= i3 << 2;
                }
                c1729d.f6052b = jOrdinal | c1729d.f6052b;
                c1729d.m3848b(obj, i3, obj2);
                c1729dM3847a = null;
            } else {
                C1729D c1729d2 = new C1729D();
                c1729d.f6051a = c1729d2;
                c1729d2.f6052b = ((long) enumC0548p.ordinal()) | c1729d2.f6052b;
                c1729d2.m3848b(obj, 0, obj2);
                c1729dM3847a = c1729d.f6051a;
            }
        } else {
            c1729dM3847a = this.f6064n.m3847a(this.f6065o, enumC0548p);
        }
        if (c1729dM3847a == null) {
            this.f6065o++;
        } else {
            this.f6064n = c1729dM3847a;
            this.f6065o = 1;
        }
    }

    /* JADX INFO: renamed from: Z */
    public final void m3855Z(EnumC0548p enumC0548p, Object obj) {
        this.f6069s.m1472n();
        C1729D c1729d = null;
        if (this.f6068r) {
            C1729D c1729d2 = this.f6064n;
            int i3 = this.f6065o;
            Object obj2 = this.f6067q;
            Object obj3 = this.f6066p;
            if (i3 < 16) {
                c1729d2.f6053c[i3] = obj;
                long jOrdinal = enumC0548p.ordinal();
                if (i3 > 0) {
                    jOrdinal <<= i3 << 2;
                }
                c1729d2.f6052b = jOrdinal | c1729d2.f6052b;
                c1729d2.m3848b(obj2, i3, obj3);
            } else {
                c1729d2.getClass();
                C1729D c1729d3 = new C1729D();
                c1729d2.f6051a = c1729d3;
                c1729d3.f6053c[0] = obj;
                c1729d3.f6052b = ((long) enumC0548p.ordinal()) | c1729d3.f6052b;
                c1729d3.m3848b(obj2, 0, obj3);
                c1729d = c1729d2.f6051a;
            }
        } else {
            C1729D c1729d4 = this.f6064n;
            int i4 = this.f6065o;
            if (i4 < 16) {
                c1729d4.f6053c[i4] = obj;
                long jOrdinal2 = enumC0548p.ordinal();
                if (i4 > 0) {
                    jOrdinal2 <<= i4 << 2;
                }
                c1729d4.f6052b = jOrdinal2 | c1729d4.f6052b;
            } else {
                c1729d4.getClass();
                C1729D c1729d5 = new C1729D();
                c1729d4.f6051a = c1729d5;
                c1729d5.f6053c[0] = obj;
                c1729d5.f6052b = ((long) enumC0548p.ordinal()) | c1729d5.f6052b;
                c1729d = c1729d4.f6051a;
            }
        }
        if (c1729d == null) {
            this.f6065o++;
        } else {
            this.f6064n = c1729d;
            this.f6065o = 1;
        }
    }

    /* JADX INFO: renamed from: a0 */
    public final void m3856a0(AbstractC0545m abstractC0545m) {
        Object objMo1162G = abstractC0545m.mo1162G();
        this.f6066p = objMo1162G;
        if (objMo1162G != null) {
            this.f6068r = true;
        }
        Object objMo1209x = abstractC0545m.mo1209x();
        this.f6067q = objMo1209x;
        if (objMo1209x != null) {
            this.f6068r = true;
        }
    }

    /* JADX INFO: renamed from: b0 */
    public final void m3857b0(AbstractC0545m abstractC0545m) throws C0538f {
        int i3 = 1;
        while (true) {
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            if (enumC0548pMo1177V == null) {
                return;
            }
            int iOrdinal = enumC0548pMo1177V.ordinal();
            if (iOrdinal == 1) {
                if (this.f6062l) {
                    m3856a0(abstractC0545m);
                }
                mo1120M();
            } else if (iOrdinal == 2) {
                mo1143p();
                i3--;
                if (i3 == 0) {
                    return;
                }
            } else if (iOrdinal == 3) {
                if (this.f6062l) {
                    m3856a0(abstractC0545m);
                }
                mo1117J();
            } else if (iOrdinal == 4) {
                mo1142o();
                i3--;
                if (i3 == 0) {
                    return;
                }
            } else if (iOrdinal != 5) {
                m3858c0(abstractC0545m, enumC0548pMo1177V);
            } else {
                if (this.f6062l) {
                    m3856a0(abstractC0545m);
                }
                mo1145r(abstractC0545m.mo1188d());
            }
            i3++;
        }
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: c */
    public final boolean mo1130c() {
        return this.f6061k;
    }

    /* JADX INFO: renamed from: c0 */
    public final void m3858c0(AbstractC0545m abstractC0545m, EnumC0548p enumC0548p) {
        if (this.f6062l) {
            m3856a0(abstractC0545m);
        }
        switch (enumC0548p.ordinal()) {
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                mo1109B(abstractC0545m.mo1202q());
                return;
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                if (!abstractC0545m.mo1167L()) {
                    mo1125R(abstractC0545m.mo1157B());
                    return;
                } else {
                    mo1123P(abstractC0545m.mo1160E(), abstractC0545m.mo1158C(), abstractC0545m.mo1159D());
                    return;
                }
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                int iOrdinal = abstractC0545m.mo1206u().ordinal();
                if (iOrdinal == 0) {
                    mo1149v(abstractC0545m.mo1204s());
                    return;
                } else if (iOrdinal != 2) {
                    mo1150w(abstractC0545m.mo1205t());
                    return;
                } else {
                    m3855Z(EnumC0548p.VALUE_NUMBER_INT, abstractC0545m.mo1208w());
                    return;
                }
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                m3855Z(EnumC0548p.VALUE_NUMBER_FLOAT, abstractC0545m.mo1208w());
                return;
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                mo1140m(true);
                return;
            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                mo1140m(false);
                return;
            case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                mo1146s();
                return;
            default:
                throw new RuntimeException("Internal error: unexpected token: " + enumC0548p);
        }
    }

    @Override // p042N0.AbstractC0540h, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: d */
    public final boolean mo1131d() {
        return this.f6060j;
    }

    /* JADX INFO: renamed from: d0 */
    public final void m3859d0(C1730E c1730e) throws C0538f {
        if (!this.f6060j) {
            this.f6060j = c1730e.f6060j;
        }
        if (!this.f6061k) {
            this.f6061k = c1730e.f6061k;
        }
        this.f6062l = this.f6060j || this.f6061k;
        C1728C c1728cM3861f0 = c1730e.m3861f0(c1730e.f6056f);
        while (c1728cM3861f0.mo1177V() != null) {
            m3862g0(c1728cM3861f0);
        }
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: e */
    public final AbstractC0540h mo1132e(EnumC0539g enumC0539g) {
        this.f6058h = (~enumC0539g.f1267f) & this.f6058h;
        return this;
    }

    /* JADX INFO: renamed from: e0 */
    public final C1728C m3860e0(AbstractC0545m abstractC0545m) {
        C1728C c1728c = new C1728C(this.f6063m, abstractC0545m.mo1196k(), this.f6060j, this.f6061k, this.f6057g, abstractC0545m.mo1189d0());
        c1728c.f6049z = abstractC0545m.mo1161F();
        return c1728c;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: f */
    public final C0640e mo1133f() {
        return this.f6069s;
    }

    /* JADX INFO: renamed from: f0 */
    public final C1728C m3861f0(AbstractC0549q abstractC0549q) {
        return new C1728C(this.f6063m, abstractC0549q, this.f6060j, this.f6061k, this.f6057g, this.f6059i);
    }

    @Override // p042N0.AbstractC0540h, java.io.Flushable
    public final void flush() {
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: g */
    public final boolean mo1134g(EnumC0539g enumC0539g) {
        return (enumC0539g.f1267f & this.f6058h) != 0;
    }

    /* JADX INFO: renamed from: g0 */
    public final void m3862g0(AbstractC0545m abstractC0545m) throws C0538f {
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        if (enumC0548pMo1190e == EnumC0548p.FIELD_NAME) {
            if (this.f6062l) {
                m3856a0(abstractC0545m);
            }
            mo1145r(abstractC0545m.mo1188d());
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        } else if (enumC0548pMo1190e == null) {
            throw new IllegalStateException("No token available from argument `JsonParser`");
        }
        int iOrdinal = enumC0548pMo1190e.ordinal();
        if (iOrdinal == 1) {
            if (this.f6062l) {
                m3856a0(abstractC0545m);
            }
            mo1120M();
            m3857b0(abstractC0545m);
            return;
        }
        if (iOrdinal == 2) {
            mo1143p();
            return;
        }
        if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                m3858c0(abstractC0545m, enumC0548pMo1190e);
                return;
            } else {
                mo1142o();
                return;
            }
        }
        if (this.f6062l) {
            m3856a0(abstractC0545m);
        }
        mo1117J();
        m3857b0(abstractC0545m);
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: h */
    public final AbstractC0540h mo1135h(int i3, int i4) {
        this.f6058h = (i3 & i4) | (this.f6058h & (~i4));
        return this;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: k */
    public final int mo1138k(C0533a c0533a, InputStream inputStream, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: l */
    public final void mo1139l(C0533a c0533a, byte[] bArr, int i3, int i4) {
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i3, bArr2, 0, i4);
        mo1109B(bArr2);
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: m */
    public final void mo1140m(boolean z3) {
        m3854Y(z3 ? EnumC0548p.VALUE_TRUE : EnumC0548p.VALUE_FALSE);
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: n */
    public final void mo1141n(Object obj) {
        m3855Z(EnumC0548p.VALUE_EMBEDDED_OBJECT, obj);
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: o */
    public final void mo1142o() {
        C1729D c1729dM3847a = this.f6064n.m3847a(this.f6065o, EnumC0548p.END_ARRAY);
        if (c1729dM3847a == null) {
            this.f6065o++;
        } else {
            this.f6064n = c1729dM3847a;
            this.f6065o = 1;
        }
        C0640e c0640e = this.f6069s.f1658d;
        if (c0640e != null) {
            this.f6069s = c0640e;
        }
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: p */
    public final void mo1143p() {
        C1729D c1729dM3847a = this.f6064n.m3847a(this.f6065o, EnumC0548p.END_OBJECT);
        if (c1729dM3847a == null) {
            this.f6065o++;
        } else {
            this.f6064n = c1729dM3847a;
            this.f6065o = 1;
        }
        C0640e c0640e = this.f6069s.f1658d;
        if (c0640e != null) {
            this.f6069s = c0640e;
        }
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: q */
    public final void mo1144q(InterfaceC0551s interfaceC0551s) throws C0538f {
        this.f6069s.m1471m(((C0597j) interfaceC0551s).f1531e);
        m3851V(interfaceC0551s);
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: r */
    public final void mo1145r(String str) throws C0538f {
        this.f6069s.m1471m(str);
        m3851V(str);
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: s */
    public final void mo1146s() {
        m3854Y(EnumC0548p.VALUE_NULL);
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: t */
    public final void mo1147t(double d) {
        m3855Z(EnumC0548p.VALUE_NUMBER_FLOAT, Double.valueOf(d));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[TokenBuffer: ");
        C1728C c1728cM3861f0 = m3861f0(this.f6056f);
        int i3 = 0;
        boolean z3 = this.f6060j || this.f6061k;
        while (true) {
            try {
                EnumC0548p enumC0548pMo1177V = c1728cM3861f0.mo1177V();
                if (enumC0548pMo1177V == null) {
                    break;
                }
                if (z3) {
                    m3852W(sb);
                }
                if (i3 < 100) {
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append(enumC0548pMo1177V.toString());
                    if (enumC0548pMo1177V == EnumC0548p.FIELD_NAME) {
                        sb.append('(');
                        sb.append(c1728cM3861f0.mo1188d());
                        sb.append(')');
                    }
                }
                i3++;
            } catch (IOException e3) {
                throw new IllegalStateException(e3);
            }
        }
        if (i3 >= 100) {
            sb.append(" ... (truncated ");
            sb.append(i3 - 100);
            sb.append(" entries)");
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: u */
    public final void mo1148u(float f3) {
        m3855Z(EnumC0548p.VALUE_NUMBER_FLOAT, Float.valueOf(f3));
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: v */
    public final void mo1149v(int i3) {
        m3855Z(EnumC0548p.VALUE_NUMBER_INT, Integer.valueOf(i3));
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: w */
    public final void mo1150w(long j2) {
        m3855Z(EnumC0548p.VALUE_NUMBER_INT, Long.valueOf(j2));
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: x */
    public final void mo1151x(String str) {
        m3855Z(EnumC0548p.VALUE_NUMBER_FLOAT, str);
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: y */
    public final void mo1152y(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            mo1146s();
        } else {
            m3855Z(EnumC0548p.VALUE_NUMBER_FLOAT, bigDecimal);
        }
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: z */
    public final void mo1153z(BigInteger bigInteger) {
        if (bigInteger == null) {
            mo1146s();
        } else {
            m3855Z(EnumC0548p.VALUE_NUMBER_INT, bigInteger);
        }
    }
}
