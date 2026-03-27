package p008B2;

import p004A2.InterfaceC0025b;
import p005B.AbstractC0032g;
import p015D2.C0198v;
import p119m2.AbstractC1766e;
import p125o0.AbstractC1800j;
import p146t2.AbstractC1923b;
import p146t2.C1922a;
import p146t2.EnumC1924c;
import p161x2.InterfaceC2012a;
import p167z2.C2093e;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.v */
/* JADX INFO: loaded from: classes.dex */
public final class C0128v implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public static final C0128v f330a = new C0128v();

    /* JADX INFO: renamed from: b */
    public static final C0101h0 f331b = new C0101h0("kotlin.time.Duration", C2093e.f7405k);

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        long j2;
        long j3 = ((C1922a) obj).f6731e;
        AbstractC1766e.m3920e("encoder", c0198v);
        int i3 = C1922a.f6730h;
        StringBuilder sb = new StringBuilder();
        if (j3 < 0) {
            sb.append('-');
        }
        sb.append("PT");
        boolean z3 = true;
        if (j3 < 0) {
            j2 = ((-(j3 >> 1)) << 1) + ((long) (((int) j3) & 1));
            int i4 = AbstractC1923b.f6732a;
        } else {
            j2 = j3;
        }
        long jM4317f = C1922a.m4317f(j2, EnumC1924c.HOURS);
        int iM4317f = C1922a.m4315d(j2) ? 0 : (int) (C1922a.m4317f(j2, EnumC1924c.MINUTES) % ((long) 60));
        int iM4317f2 = C1922a.m4315d(j2) ? 0 : (int) (C1922a.m4317f(j2, EnumC1924c.SECONDS) % ((long) 60));
        int iM4314c = C1922a.m4314c(j2);
        if (C1922a.m4315d(j3)) {
            jM4317f = 9999999999999L;
        }
        boolean z4 = jM4317f != 0;
        boolean z5 = (iM4317f2 == 0 && iM4314c == 0) ? false : true;
        if (iM4317f == 0 && (!z5 || !z4)) {
            z3 = false;
        }
        if (z4) {
            sb.append(jM4317f);
            sb.append('H');
        }
        if (z3) {
            sb.append(iM4317f);
            sb.append('M');
        }
        if (z5 || (!z4 && !z3)) {
            C1922a.m4313b(sb, iM4317f2, iM4314c, 9, "S", true);
        }
        String string = sb.toString();
        AbstractC1766e.m3919d("toString(...)", string);
        c0198v.m365q(string);
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        int i3 = C1922a.f6730h;
        String strMo101v = interfaceC0025b.mo101v();
        AbstractC1766e.m3920e("value", strMo101v);
        try {
            return new C1922a(AbstractC1800j.m3983a(strMo101v));
        } catch (IllegalArgumentException e3) {
            throw new IllegalArgumentException(AbstractC0032g.m154l("Invalid ISO duration string format: '", strMo101v, "'."), e3);
        }
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return f331b;
    }
}
