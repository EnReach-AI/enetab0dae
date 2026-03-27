package p015D2;

import p011C2.AbstractC0157j;
import p011C2.C0148a;
import p011C2.C0154g;
import p119m2.AbstractC1766e;
import p148u0.AbstractC1944c;
import p161x2.C2015d;
import p161x2.InterfaceC2012a;
import p166z0.C2068f;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: D2.v */
/* JADX INFO: loaded from: classes.dex */
public final class C0198v {

    /* JADX INFO: renamed from: a */
    public final C0181e f467a;

    /* JADX INFO: renamed from: b */
    public final C0148a f468b;

    /* JADX INFO: renamed from: c */
    public final EnumC0202z f469c;

    /* JADX INFO: renamed from: d */
    public final C0198v[] f470d;

    /* JADX INFO: renamed from: e */
    public final C2068f f471e;

    /* JADX INFO: renamed from: f */
    public final C0154g f472f;

    /* JADX INFO: renamed from: g */
    public boolean f473g;

    public C0198v(C0181e c0181e, C0148a c0148a, EnumC0202z enumC0202z, C0198v[] c0198vArr) {
        AbstractC1766e.m3920e("composer", c0181e);
        AbstractC1766e.m3920e("json", c0148a);
        AbstractC1766e.m3920e("mode", enumC0202z);
        this.f467a = c0181e;
        this.f468b = c0148a;
        this.f469c = enumC0202z;
        this.f470d = c0198vArr;
        this.f471e = c0148a.f358b;
        this.f472f = c0148a.f357a;
        int iOrdinal = enumC0202z.ordinal();
        if (c0198vArr != null) {
            C0198v c0198v = c0198vArr[iOrdinal];
            if (c0198v == null && c0198v == this) {
                return;
            }
            c0198vArr[iOrdinal] = this;
        }
    }

    /* JADX INFO: renamed from: a */
    public final C0198v m349a(InterfaceC2095g interfaceC2095g) {
        C0198v c0198v;
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        C0148a c0148a = this.f468b;
        EnumC0202z enumC0202zM331m = AbstractC0190n.m331m(c0148a, interfaceC2095g);
        char c3 = enumC0202zM331m.f487e;
        C0181e c0181e = this.f467a;
        c0181e.m308f(c3);
        c0181e.mo304b();
        if (this.f469c == enumC0202zM331m) {
            return this;
        }
        C0198v[] c0198vArr = this.f470d;
        return (c0198vArr == null || (c0198v = c0198vArr[enumC0202zM331m.ordinal()]) == null) ? new C0198v(c0181e, c0148a, enumC0202zM331m, c0198vArr) : c0198v;
    }

    /* JADX INFO: renamed from: b */
    public final void m350b(boolean z3) {
        if (this.f473g) {
            m365q(String.valueOf(z3));
        } else {
            ((C0192p) this.f467a.f423c).m337d(String.valueOf(z3));
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m351c(byte b3) {
        if (this.f473g) {
            m365q(String.valueOf((int) b3));
        } else {
            this.f467a.mo307e(b3);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m352d(char c3) {
        m365q(String.valueOf(c3));
    }

    /* JADX INFO: renamed from: e */
    public final void m353e(double d) {
        boolean z3 = this.f473g;
        C0181e c0181e = this.f467a;
        if (z3) {
            m365q(String.valueOf(d));
        } else {
            ((C0192p) c0181e.f423c).m337d(String.valueOf(d));
        }
        if (this.f472f.f376k) {
            return;
        }
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw AbstractC0190n.m319a(Double.valueOf(d), ((C0192p) c0181e.f423c).toString());
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m354f(InterfaceC2095g interfaceC2095g, int i3) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        int iOrdinal = this.f469c.ordinal();
        boolean z3 = true;
        C0181e c0181e = this.f467a;
        if (iOrdinal == 1) {
            if (!c0181e.f422b) {
                c0181e.m308f(',');
            }
            c0181e.mo306d();
            return;
        }
        if (iOrdinal == 2) {
            if (c0181e.f422b) {
                this.f473g = true;
                c0181e.mo306d();
                return;
            }
            if (i3 % 2 == 0) {
                c0181e.m308f(',');
                c0181e.mo306d();
            } else {
                c0181e.m308f(':');
                c0181e.mo314l();
                z3 = false;
            }
            this.f473g = z3;
            return;
        }
        if (iOrdinal == 3) {
            if (i3 == 0) {
                this.f473g = true;
            }
            if (i3 == 1) {
                c0181e.m308f(',');
                c0181e.mo314l();
                this.f473g = false;
                return;
            }
            return;
        }
        if (!c0181e.f422b) {
            c0181e.m308f(',');
        }
        c0181e.mo306d();
        C0148a c0148a = this.f468b;
        AbstractC1766e.m3920e("json", c0148a);
        AbstractC0190n.m330l(c0148a, interfaceC2095g);
        m365q(interfaceC2095g.mo230a(i3));
        c0181e.m308f(':');
        c0181e.mo314l();
    }

    /* JADX INFO: renamed from: g */
    public final void m355g(InterfaceC2095g interfaceC2095g, int i3) {
        AbstractC1766e.m3920e("enumDescriptor", interfaceC2095g);
        m365q(interfaceC2095g.mo230a(i3));
    }

    /* JADX INFO: renamed from: h */
    public final void m356h(float f3) {
        boolean z3 = this.f473g;
        C0181e c0181e = this.f467a;
        if (z3) {
            m365q(String.valueOf(f3));
        } else {
            ((C0192p) c0181e.f423c).m337d(String.valueOf(f3));
        }
        if (this.f472f.f376k) {
            return;
        }
        if (Float.isInfinite(f3) || Float.isNaN(f3)) {
            throw AbstractC0190n.m319a(Float.valueOf(f3), ((C0192p) c0181e.f423c).toString());
        }
    }

    /* JADX INFO: renamed from: i */
    public final C0198v m357i(InterfaceC2095g interfaceC2095g) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        boolean zM368a = AbstractC0199w.m368a(interfaceC2095g);
        EnumC0202z enumC0202z = this.f469c;
        C0148a c0148a = this.f468b;
        C0181e c0182f = this.f467a;
        if (zM368a) {
            if (!(c0182f instanceof C0183g)) {
                c0182f = new C0183g((C0192p) c0182f.f423c, this.f473g);
            }
            return new C0198v(c0182f, c0148a, enumC0202z, null);
        }
        if (!interfaceC2095g.mo231b() || !interfaceC2095g.equals(AbstractC0157j.f379a)) {
            return this;
        }
        if (!(c0182f instanceof C0182f)) {
            c0182f = new C0182f((C0192p) c0182f.f423c, this.f473g);
        }
        return new C0198v(c0182f, c0148a, enumC0202z, null);
    }

    /* JADX INFO: renamed from: j */
    public final C0198v m358j(InterfaceC2095g interfaceC2095g, int i3) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        m354f(interfaceC2095g, i3);
        return m357i(interfaceC2095g.mo236h(i3));
    }

    /* JADX INFO: renamed from: k */
    public final void m359k(int i3) {
        if (this.f473g) {
            m365q(String.valueOf(i3));
        } else {
            this.f467a.mo309g(i3);
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m360l(long j2) {
        if (this.f473g) {
            m365q(String.valueOf(j2));
        } else {
            this.f467a.mo310h(j2);
        }
    }

    /* JADX INFO: renamed from: m */
    public final void m361m() {
        this.f467a.m311i("null");
    }

    /* JADX INFO: renamed from: n */
    public final void m362n(InterfaceC2095g interfaceC2095g, int i3, InterfaceC2012a interfaceC2012a, Object obj) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        AbstractC1766e.m3920e("serializer", interfaceC2012a);
        m354f(interfaceC2095g, i3);
        m363o(interfaceC2012a, obj);
    }

    /* JADX INFO: renamed from: o */
    public final void m363o(InterfaceC2012a interfaceC2012a, Object obj) {
        AbstractC1766e.m3920e("serializer", interfaceC2012a);
        if (interfaceC2012a instanceof C2015d) {
            C0148a c0148a = this.f468b;
            if (!c0148a.f357a.f374i) {
                AbstractC0190n.m325g(c0148a, interfaceC2012a.mo221c());
                AbstractC1766e.m3918c("null cannot be cast to non-null type kotlin.Any", obj);
                AbstractC1944c.m4341c((C2015d) interfaceC2012a, this, obj);
                throw null;
            }
        }
        interfaceC2012a.mo219a(this, obj);
    }

    /* JADX INFO: renamed from: p */
    public final void m364p(short s3) {
        if (this.f473g) {
            m365q(String.valueOf((int) s3));
        } else {
            this.f467a.mo312j(s3);
        }
    }

    /* JADX INFO: renamed from: q */
    public final void m365q(String str) {
        AbstractC1766e.m3920e("value", str);
        this.f467a.mo313k(str);
    }

    /* JADX INFO: renamed from: r */
    public final void m366r(InterfaceC2095g interfaceC2095g) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        EnumC0202z enumC0202z = this.f469c;
        char c3 = enumC0202z.f488f;
        C0181e c0181e = this.f467a;
        c0181e.mo315m();
        c0181e.mo306d();
        c0181e.m308f(enumC0202z.f488f);
    }

    /* JADX INFO: renamed from: s */
    public final C2068f m367s() {
        return this.f471e;
    }
}
