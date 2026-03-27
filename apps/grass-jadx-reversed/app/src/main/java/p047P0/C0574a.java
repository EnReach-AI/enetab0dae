package p047P0;

import java.math.BigDecimal;
import java.math.BigInteger;
import p042N0.AbstractC0545m;
import p042N0.AbstractC0547o;
import p042N0.C0533a;
import p042N0.C0541i;
import p042N0.C0542j;
import p042N0.EnumC0544l;
import p042N0.EnumC0548p;
import p066W0.AbstractC0685l;
import p118m1.C1742g;

/* JADX INFO: renamed from: P0.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0574a extends AbstractC0685l {

    /* JADX INFO: renamed from: h */
    public boolean f1426h;

    /* JADX INFO: renamed from: i */
    public int f1427i;

    /* JADX INFO: renamed from: j */
    public EnumC0548p f1428j;

    /* JADX INFO: renamed from: k */
    public C0576c f1429k;

    /* JADX INFO: renamed from: l */
    public C0576c f1430l;

    /* JADX INFO: renamed from: m */
    public C0575b f1431m;

    /* JADX INFO: renamed from: n */
    public int f1432n;

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: A */
    public final short mo1156A() {
        return this.f1860g.mo1156A();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: B */
    public final String mo1157B() {
        return this.f1428j == EnumC0548p.FIELD_NAME ? mo1188d() : this.f1860g.mo1157B();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: C */
    public final char[] mo1158C() {
        return this.f1428j == EnumC0548p.FIELD_NAME ? mo1188d().toCharArray() : this.f1860g.mo1158C();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: D */
    public final int mo1159D() {
        return this.f1428j == EnumC0548p.FIELD_NAME ? mo1188d().length() : this.f1860g.mo1159D();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: E */
    public final int mo1160E() {
        if (this.f1428j == EnumC0548p.FIELD_NAME) {
            return 0;
        }
        return this.f1860g.mo1160E();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: F */
    public final C0541i mo1161F() {
        return this.f1860g.mo1161F();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: H */
    public final int mo1163H() {
        return this.f1860g.mo1163H();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: I */
    public final long mo1164I() {
        return this.f1860g.mo1164I();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: J */
    public final String mo1165J() {
        return this.f1428j == EnumC0548p.FIELD_NAME ? mo1188d() : this.f1860g.mo1165J();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: K */
    public final boolean mo1166K() {
        return this.f1428j != null;
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: L */
    public final boolean mo1167L() {
        if (this.f1428j == EnumC0548p.FIELD_NAME) {
            return false;
        }
        return this.f1860g.mo1167L();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: M */
    public final boolean mo1168M(EnumC0548p enumC0548p) {
        return this.f1428j == enumC0548p;
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: N */
    public final boolean mo1169N() {
        EnumC0548p enumC0548p = this.f1428j;
        return enumC0548p != null && enumC0548p.f1328h == 5;
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: Q */
    public final boolean mo1172Q() {
        return this.f1428j == EnumC0548p.START_ARRAY;
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: R */
    public final boolean mo1173R() {
        return this.f1428j == EnumC0548p.START_OBJECT;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0165  */
    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: V */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p042N0.EnumC0548p mo1177V() throws p042N0.C0542j {
        /*
            Method dump skipped, instruction units count: 796
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p047P0.C0574a.mo1177V():N0.p");
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: Y */
    public final int mo1180Y(C0533a c0533a, C1742g c1742g) {
        return this.f1860g.mo1180Y(c0533a, c1742g);
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: c */
    public final void mo1186c() {
        if (this.f1428j != null) {
            this.f1428j = null;
        }
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: c0 */
    public final AbstractC0545m mo1187c0() throws C0542j {
        EnumC0548p enumC0548p = this.f1428j;
        if (enumC0548p != EnumC0548p.START_OBJECT && enumC0548p != EnumC0548p.START_ARRAY) {
            return this;
        }
        int i3 = 1;
        while (true) {
            EnumC0548p enumC0548pMo1177V = mo1177V();
            if (enumC0548pMo1177V == null) {
                return this;
            }
            if (enumC0548pMo1177V.f1329i) {
                i3++;
            } else if (enumC0548pMo1177V.f1330j && i3 - 1 == 0) {
                return this;
            }
        }
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: d */
    public final String mo1188d() {
        C0576c c0576c = this.f1430l;
        if (c0576c == null) {
            c0576c = this.f1429k;
        }
        EnumC0548p enumC0548p = this.f1428j;
        if (enumC0548p != EnumC0548p.START_OBJECT && enumC0548p != EnumC0548p.START_ARRAY) {
            return c0576c.f1436f;
        }
        C0576c c0576c2 = c0576c.f1434d;
        if (c0576c2 == null) {
            return null;
        }
        return c0576c2.f1436f;
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: e */
    public final EnumC0548p mo1190e() {
        return this.f1428j;
    }

    /* JADX INFO: renamed from: e0 */
    public final EnumC0548p m1291e0(C0576c c0576c) throws C0542j {
        this.f1430l = c0576c;
        EnumC0548p enumC0548pM1298m = c0576c.m1298m();
        if (enumC0548pM1298m != null) {
            return enumC0548pM1298m;
        }
        while (c0576c != this.f1429k) {
            C0576c c0576c2 = this.f1430l;
            C0576c c0576c3 = c0576c2.f1434d;
            if (c0576c3 == c0576c) {
                c0576c = c0576c2;
            } else {
                while (true) {
                    if (c0576c3 == null) {
                        c0576c = null;
                        break;
                    }
                    C0576c c0576c4 = c0576c3.f1434d;
                    if (c0576c4 == c0576c) {
                        c0576c = c0576c3;
                        break;
                    }
                    c0576c3 = c0576c4;
                }
            }
            this.f1430l = c0576c;
            if (c0576c == null) {
                throw new C0542j(this, "Unexpected problem: chain of filtered context broken");
            }
            EnumC0548p enumC0548pM1298m2 = c0576c.m1298m();
            if (enumC0548pM1298m2 != null) {
                return enumC0548pM1298m2;
            }
        }
        throw new C0542j(this, "Internal error: failed to locate expected buffered tokens");
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: f */
    public final int mo1191f() {
        EnumC0548p enumC0548p = this.f1428j;
        if (enumC0548p == null) {
            return 0;
        }
        return enumC0548p.f1328h;
    }

    /* JADX INFO: renamed from: f0 */
    public final EnumC0548p m1292f0(C0576c c0576c) {
        C0575b c0575bM1295j;
        boolean z3;
        while (true) {
            EnumC0548p enumC0548pMo1177V = this.f1860g.mo1177V();
            if (enumC0548pMo1177V == null) {
                return enumC0548pMo1177V;
            }
            int i3 = this.f1427i;
            C0575b c0575b = C0575b.f1433a;
            int i4 = enumC0548pMo1177V.f1328h;
            if (i4 == 1) {
                C0575b c0575b2 = this.f1431m;
                if (c0575b2 == c0575b) {
                    this.f1429k = this.f1429k.m1297l(c0575b2, true);
                    return enumC0548pMo1177V;
                }
                if (c0575b2 == null) {
                    this.f1860g.mo1187c0();
                } else {
                    C0575b c0575bM1295j2 = this.f1429k.m1295j(c0575b2);
                    if (c0575bM1295j2 == null) {
                        this.f1860g.mo1187c0();
                    } else {
                        this.f1431m = c0575bM1295j2;
                        if (c0575bM1295j2 == c0575b) {
                            this.f1429k = this.f1429k.m1297l(c0575bM1295j2, true);
                            return m1291e0(c0576c);
                        }
                        if (i3 == 3) {
                            this.f1429k = this.f1429k.m1296k(c0575bM1295j2, true);
                            return m1291e0(c0576c);
                        }
                        this.f1429k = this.f1429k.m1297l(c0575bM1295j2, false);
                    }
                }
            } else if (i4 == 2) {
                C0576c c0576c2 = this.f1429k;
                C0575b c0575b3 = c0576c2.f1437g;
                boolean z4 = c0576c2 == c0576c;
                z3 = z4 && c0576c2.f1438h;
                C0576c c0576c3 = c0576c2.f1434d;
                this.f1429k = c0576c3;
                this.f1431m = c0576c3.f1437g;
                if (z3) {
                    return enumC0548pMo1177V;
                }
                if (z4) {
                    return null;
                }
            } else if (i4 == 3) {
                C0575b c0575bM1295j3 = this.f1429k.m1295j(this.f1431m);
                if (c0575bM1295j3 == null) {
                    this.f1860g.mo1187c0();
                } else {
                    this.f1431m = c0575bM1295j3;
                    if (c0575bM1295j3 == c0575b) {
                        this.f1429k = this.f1429k.m1296k(c0575bM1295j3, true);
                        return m1291e0(c0576c);
                    }
                    if (i3 == 3) {
                        this.f1429k = this.f1429k.m1296k(c0575bM1295j3, true);
                        return m1291e0(c0576c);
                    }
                    this.f1429k = this.f1429k.m1296k(c0575bM1295j3, false);
                }
            } else if (i4 == 4) {
                C0576c c0576c4 = this.f1429k;
                C0575b c0575b4 = c0576c4.f1437g;
                boolean z5 = c0576c4 == c0576c;
                z3 = z5 && c0576c4.f1438h;
                C0576c c0576c5 = c0576c4.f1434d;
                this.f1429k = c0576c5;
                this.f1431m = c0576c5.f1437g;
                if (z3) {
                    return enumC0548pMo1177V;
                }
                if (z5) {
                    return null;
                }
            } else if (i4 != 5) {
                C0575b c0575b5 = this.f1431m;
                if (c0575b5 == c0575b) {
                    return m1291e0(c0576c);
                }
                if (c0575b5 != null && ((c0575bM1295j = this.f1429k.m1295j(c0575b5)) == c0575b || c0575bM1295j != null)) {
                    if (m1293g0()) {
                        return m1291e0(c0576c);
                    }
                }
            } else {
                String strMo1198m = this.f1860g.mo1198m();
                C0576c c0576c6 = this.f1429k;
                c0576c6.f1436f = strMo1198m;
                c0576c6.f1439i = true;
                C0575b c0575b6 = c0576c6.f1437g;
                if (c0575b6 == c0575b) {
                    this.f1431m = c0575b6;
                    return m1291e0(c0576c);
                }
                if (c0575b6 == null) {
                    this.f1860g.mo1177V();
                    this.f1860g.mo1187c0();
                } else {
                    this.f1431m = c0575b6;
                    if (c0575b6 != c0575b) {
                        continue;
                    } else {
                        if (m1293g0()) {
                            return m1291e0(c0576c);
                        }
                        C0576c c0576c7 = this.f1429k;
                        c0576c7.f1436f = strMo1198m;
                        c0576c7.f1439i = true;
                        this.f1431m = c0576c7.f1437g;
                    }
                }
            }
        }
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: g */
    public final BigInteger mo1192g() {
        return this.f1860g.mo1192g();
    }

    /* JADX INFO: renamed from: g0 */
    public final boolean m1293g0() {
        int i3 = this.f1432n;
        if (i3 != 0 && !this.f1426h) {
            return false;
        }
        this.f1432n = i3 + 1;
        return true;
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: h */
    public final byte[] mo1193h(C0533a c0533a) {
        return this.f1860g.mo1193h(c0533a);
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: i */
    public final boolean mo1194i() {
        return this.f1860g.mo1194i();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: j */
    public final byte mo1195j() {
        return this.f1860g.mo1195j();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: l */
    public final C0541i mo1197l() {
        return this.f1860g.mo1197l();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: m */
    public final String mo1198m() {
        C0576c c0576c = this.f1430l;
        if (c0576c == null) {
            c0576c = this.f1429k;
        }
        EnumC0548p enumC0548p = this.f1428j;
        if (enumC0548p != EnumC0548p.START_OBJECT && enumC0548p != EnumC0548p.START_ARRAY) {
            return c0576c.f1436f;
        }
        C0576c c0576c2 = c0576c.f1434d;
        if (c0576c2 == null) {
            return null;
        }
        return c0576c2.f1436f;
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: n */
    public final EnumC0548p mo1199n() {
        return this.f1428j;
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: o */
    public final BigDecimal mo1200o() {
        return this.f1860g.mo1200o();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: p */
    public final double mo1201p() {
        return this.f1860g.mo1201p();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: q */
    public final Object mo1202q() {
        return this.f1860g.mo1202q();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: r */
    public final float mo1203r() {
        return this.f1860g.mo1203r();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: s */
    public final int mo1204s() {
        return this.f1860g.mo1204s();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: t */
    public final long mo1205t() {
        return this.f1860g.mo1205t();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: u */
    public final EnumC0544l mo1206u() {
        return this.f1860g.mo1206u();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: v */
    public final Number mo1207v() {
        return this.f1860g.mo1207v();
    }

    @Override // p066W0.AbstractC0685l, p042N0.AbstractC0545m
    /* JADX INFO: renamed from: y */
    public final AbstractC0547o mo1210y() {
        C0576c c0576c = this.f1430l;
        return c0576c != null ? c0576c : this.f1429k;
    }
}
