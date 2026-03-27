package p042N0;

import com.fasterxml.jackson.core.exc.C1130a;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import p005B.AbstractC0032g;
import p066W0.C0684k;
import p118m1.C1742g;

/* JADX INFO: renamed from: N0.m */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0545m implements Closeable {

    /* JADX INFO: renamed from: f */
    public static final C0684k f1305f = C0684k.m1644a(EnumC0552t.values());

    /* JADX INFO: renamed from: e */
    public int f1306e = C0537e.f1241p;

    /* JADX INFO: renamed from: A */
    public short mo1156A() throws C1130a {
        int iMo1204s = mo1204s();
        if (iMo1204s >= -32768 && iMo1204s <= 32767) {
            return (short) iMo1204s;
        }
        String strM154l = AbstractC0032g.m154l("Numeric value (", mo1157B(), ") out of range of Java short");
        EnumC0548p enumC0548p = EnumC0548p.NOT_AVAILABLE;
        throw new C1130a(this, strM154l);
    }

    /* JADX INFO: renamed from: B */
    public abstract String mo1157B();

    /* JADX INFO: renamed from: C */
    public abstract char[] mo1158C();

    /* JADX INFO: renamed from: D */
    public abstract int mo1159D();

    /* JADX INFO: renamed from: E */
    public abstract int mo1160E();

    /* JADX INFO: renamed from: F */
    public abstract C0541i mo1161F();

    /* JADX INFO: renamed from: G */
    public Object mo1162G() {
        return null;
    }

    /* JADX INFO: renamed from: H */
    public abstract int mo1163H();

    /* JADX INFO: renamed from: I */
    public abstract long mo1164I();

    /* JADX INFO: renamed from: J */
    public abstract String mo1165J();

    /* JADX INFO: renamed from: K */
    public abstract boolean mo1166K();

    /* JADX INFO: renamed from: L */
    public abstract boolean mo1167L();

    /* JADX INFO: renamed from: M */
    public abstract boolean mo1168M(EnumC0548p enumC0548p);

    /* JADX INFO: renamed from: N */
    public abstract boolean mo1169N();

    /* JADX INFO: renamed from: O */
    public final boolean m1170O(EnumC0554v enumC0554v) {
        return enumC0554v.f1345g.m1155a(this.f1306e);
    }

    /* JADX INFO: renamed from: P */
    public abstract boolean mo1171P();

    /* JADX INFO: renamed from: Q */
    public abstract boolean mo1172Q();

    /* JADX INFO: renamed from: R */
    public abstract boolean mo1173R();

    /* JADX INFO: renamed from: S */
    public abstract boolean mo1174S();

    /* JADX INFO: renamed from: T */
    public String mo1175T() {
        if (mo1177V() == EnumC0548p.FIELD_NAME) {
            return mo1198m();
        }
        return null;
    }

    /* JADX INFO: renamed from: U */
    public String mo1176U() {
        if (mo1177V() == EnumC0548p.VALUE_STRING) {
            return mo1157B();
        }
        return null;
    }

    /* JADX INFO: renamed from: V */
    public abstract EnumC0548p mo1177V();

    /* JADX INFO: renamed from: W */
    public void mo1178W(int i3, int i4) {
    }

    /* JADX INFO: renamed from: X */
    public void mo1179X(int i3, int i4) {
        mo1185b0((i3 & i4) | (this.f1306e & (~i4)));
    }

    /* JADX INFO: renamed from: Y */
    public abstract int mo1180Y(C0533a c0533a, C1742g c1742g);

    /* JADX INFO: renamed from: Z */
    public boolean mo1181Z() {
        return false;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo1182a() {
        return false;
    }

    /* JADX INFO: renamed from: a0 */
    public void mo1183a0(Object obj) {
        AbstractC0547o abstractC0547oMo1210y = mo1210y();
        if (abstractC0547oMo1210y != null) {
            abstractC0547oMo1210y.mo1219g(obj);
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean mo1184b() {
        return false;
    }

    /* JADX INFO: renamed from: b0 */
    public AbstractC0545m mo1185b0(int i3) {
        this.f1306e = i3;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public abstract void mo1186c();

    /* JADX INFO: renamed from: c0 */
    public abstract AbstractC0545m mo1187c0();

    /* JADX INFO: renamed from: d */
    public String mo1188d() {
        return mo1198m();
    }

    /* JADX INFO: renamed from: d0 */
    public C0553u mo1189d0() {
        return C0553u.f1339e;
    }

    /* JADX INFO: renamed from: e */
    public abstract EnumC0548p mo1190e();

    /* JADX INFO: renamed from: f */
    public abstract int mo1191f();

    /* JADX INFO: renamed from: g */
    public abstract BigInteger mo1192g();

    /* JADX INFO: renamed from: h */
    public abstract byte[] mo1193h(C0533a c0533a);

    /* JADX INFO: renamed from: i */
    public boolean mo1194i() throws C0542j {
        EnumC0548p enumC0548pMo1190e = mo1190e();
        if (enumC0548pMo1190e == EnumC0548p.VALUE_TRUE) {
            return true;
        }
        if (enumC0548pMo1190e == EnumC0548p.VALUE_FALSE) {
            return false;
        }
        throw new C0542j(this, "Current token (" + enumC0548pMo1190e + ") not of boolean type");
    }

    /* JADX INFO: renamed from: j */
    public byte mo1195j() throws C1130a {
        int iMo1204s = mo1204s();
        if (iMo1204s >= -128 && iMo1204s <= 255) {
            return (byte) iMo1204s;
        }
        String strM154l = AbstractC0032g.m154l("Numeric value (", mo1157B(), ") out of range of Java byte");
        EnumC0548p enumC0548p = EnumC0548p.NOT_AVAILABLE;
        throw new C1130a(this, strM154l);
    }

    /* JADX INFO: renamed from: k */
    public abstract AbstractC0549q mo1196k();

    /* JADX INFO: renamed from: l */
    public abstract C0541i mo1197l();

    /* JADX INFO: renamed from: m */
    public abstract String mo1198m();

    /* JADX INFO: renamed from: n */
    public abstract EnumC0548p mo1199n();

    /* JADX INFO: renamed from: o */
    public abstract BigDecimal mo1200o();

    /* JADX INFO: renamed from: p */
    public abstract double mo1201p();

    /* JADX INFO: renamed from: q */
    public Object mo1202q() {
        return null;
    }

    /* JADX INFO: renamed from: r */
    public abstract float mo1203r();

    /* JADX INFO: renamed from: s */
    public abstract int mo1204s();

    /* JADX INFO: renamed from: t */
    public abstract long mo1205t();

    /* JADX INFO: renamed from: u */
    public abstract EnumC0544l mo1206u();

    /* JADX INFO: renamed from: v */
    public abstract Number mo1207v();

    /* JADX INFO: renamed from: w */
    public Object mo1208w() {
        return mo1207v();
    }

    /* JADX INFO: renamed from: x */
    public Object mo1209x() {
        return null;
    }

    /* JADX INFO: renamed from: y */
    public abstract AbstractC0547o mo1210y();

    /* JADX INFO: renamed from: z */
    public abstract C0684k mo1211z();
}
