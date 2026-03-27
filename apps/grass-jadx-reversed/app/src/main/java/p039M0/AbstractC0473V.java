package p039M0;

import android.view.View;
import android.view.ViewParent;
import java.util.Collection;
import java.util.Set;
import java.util.WeakHashMap;
import p003A1.C0023a;
import p004A2.InterfaceC0024a;
import p004A2.InterfaceC0025b;
import p025H1.C0275d;
import p025H1.C0277f;
import p025H1.C0278g;
import p025H1.C0280i;
import p029J.AbstractC0313H;
import p029J.AbstractC0323S;
import p033K0.AbstractC0406d;
import p073Z.AbstractC0763I;
import p073Z.AbstractC0811w;
import p073Z.C0774U;
import p086c2.AbstractC1084c;
import p115l2.InterfaceC1689l;
import p118m1.C1751p;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1770i;
import p142s2.AbstractC1900o;
import p161x2.C2017f;
import p161x2.InterfaceC2012a;
import p167z2.C2089a;
import p167z2.C2096h;
import p167z2.C2100l;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: M0.V */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0473V implements InterfaceC0025b, InterfaceC0024a {
    /* JADX INFO: renamed from: C */
    public static C1751p m991C(Set set, Set set2) {
        if (set2 == null && (set == null || set.isEmpty())) {
            return null;
        }
        return new C1751p(set, set2);
    }

    /* JADX INFO: renamed from: D */
    public static final C2096h m992D(String str, InterfaceC2095g[] interfaceC2095gArr, InterfaceC1689l interfaceC1689l) {
        if (!(!AbstractC1900o.m4231h(str))) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        }
        C2089a c2089a = new C2089a(str);
        interfaceC1689l.mo249f(c2089a);
        return new C2096h(str, C2100l.f7424c, c2089a.f7387c.size(), AbstractC1084c.m2828B(interfaceC2095gArr), c2089a);
    }

    /* JADX INFO: renamed from: E */
    public static final C2096h m993E(String str, AbstractC0493h0 abstractC0493h0, InterfaceC2095g[] interfaceC2095gArr, InterfaceC1689l interfaceC1689l) {
        AbstractC1766e.m3920e("serialName", str);
        AbstractC1766e.m3920e("builder", interfaceC1689l);
        if (!(!AbstractC1900o.m4231h(str))) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        }
        if (!(!abstractC0493h0.equals(C2100l.f7424c))) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead".toString());
        }
        C2089a c2089a = new C2089a(str);
        interfaceC1689l.mo249f(c2089a);
        return new C2096h(str, abstractC0493h0, c2089a.f7387c.size(), AbstractC1084c.m2828B(interfaceC2095gArr), c2089a);
    }

    /* JADX INFO: renamed from: F */
    public static int m994F(C0774U c0774u, AbstractC0811w abstractC0811w, View view, View view2, AbstractC0763I abstractC0763I, boolean z3) {
        if (abstractC0763I.m2027v() == 0 || c0774u.m2047b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z3) {
            return Math.abs(AbstractC0763I.m1958D(view) - AbstractC0763I.m1958D(view2)) + 1;
        }
        return Math.min(abstractC0811w.mo2123l(), abstractC0811w.mo2113b(view2) - abstractC0811w.mo2116e(view));
    }

    /* JADX INFO: renamed from: G */
    public static int m995G(C0774U c0774u, AbstractC0811w abstractC0811w, View view, View view2, AbstractC0763I abstractC0763I, boolean z3, boolean z4) {
        if (abstractC0763I.m2027v() == 0 || c0774u.m2047b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z4 ? Math.max(0, (c0774u.m2047b() - Math.max(AbstractC0763I.m1958D(view), AbstractC0763I.m1958D(view2))) - 1) : Math.max(0, Math.min(AbstractC0763I.m1958D(view), AbstractC0763I.m1958D(view2)));
        if (z3) {
            return Math.round((iMax * (Math.abs(abstractC0811w.mo2113b(view2) - abstractC0811w.mo2116e(view)) / (Math.abs(AbstractC0763I.m1958D(view) - AbstractC0763I.m1958D(view2)) + 1))) + (abstractC0811w.mo2122k() - abstractC0811w.mo2116e(view)));
        }
        return iMax;
    }

    /* JADX INFO: renamed from: H */
    public static int m996H(C0774U c0774u, AbstractC0811w abstractC0811w, View view, View view2, AbstractC0763I abstractC0763I, boolean z3) {
        if (abstractC0763I.m2027v() == 0 || c0774u.m2047b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z3) {
            return c0774u.m2047b();
        }
        return (int) (((abstractC0811w.mo2113b(view2) - abstractC0811w.mo2116e(view)) / (Math.abs(AbstractC0763I.m1958D(view) - AbstractC0763I.m1958D(view2)) + 1)) * c0774u.m2047b());
    }

    /* JADX INFO: renamed from: I */
    public static AbstractC0406d m997I(int i3) {
        if (i3 != 0 && i3 == 1) {
            return new C0275d();
        }
        return new C0280i();
    }

    /* JADX INFO: renamed from: K */
    public static void m998K(View view, C0278g c0278g) {
        C0023a c0023a = c0278g.f719e.f698b;
        if (c0023a == null || !c0023a.f74a) {
            return;
        }
        float fM636i = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            fM636i += AbstractC0313H.m636i((View) parent);
        }
        C0277f c0277f = c0278g.f719e;
        if (c0277f.f709m != fM636i) {
            c0277f.f709m = fM636i;
            c0278g.m550n();
        }
    }

    /* JADX INFO: renamed from: L */
    public static boolean m999L(Object obj, Collection collection, Collection collection2) {
        if (collection == null && collection2 == null) {
            return false;
        }
        return collection2 == null ? collection.contains(obj) : collection == null ? !collection2.contains(obj) : !collection2.contains(obj) || collection.contains(obj);
    }

    @Override // p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: A */
    public double mo90A() {
        m1000J();
        throw null;
    }

    @Override // p004A2.InterfaceC0024a
    /* JADX INFO: renamed from: B */
    public char mo76B(InterfaceC2095g interfaceC2095g, int i3) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        return mo97o();
    }

    /* JADX INFO: renamed from: J */
    public void m1000J() {
        throw new C2017f(AbstractC1770i.m3927a(getClass()) + " can't retrieve untyped values");
    }

    @Override // p004A2.InterfaceC0024a
    /* JADX INFO: renamed from: a */
    public boolean mo77a(InterfaceC2095g interfaceC2095g, int i3) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        return mo92g();
    }

    @Override // p004A2.InterfaceC0024a
    /* JADX INFO: renamed from: b */
    public byte mo78b(InterfaceC2095g interfaceC2095g, int i3) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        return mo98r();
    }

    @Override // p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: c */
    public abstract long mo91c();

    @Override // p004A2.InterfaceC0024a
    /* JADX INFO: renamed from: d */
    public double mo79d(InterfaceC2095g interfaceC2095g, int i3) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        return mo90A();
    }

    @Override // p004A2.InterfaceC0024a
    /* JADX INFO: renamed from: e */
    public float mo80e(InterfaceC2095g interfaceC2095g, int i3) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        return mo102x();
    }

    @Override // p004A2.InterfaceC0024a
    /* JADX INFO: renamed from: f */
    public int mo81f(InterfaceC2095g interfaceC2095g, int i3) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        return mo93h();
    }

    @Override // p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: g */
    public boolean mo92g() {
        m1000J();
        throw null;
    }

    @Override // p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: h */
    public abstract int mo93h();

    @Override // p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: i */
    public InterfaceC0024a mo94i(InterfaceC2095g interfaceC2095g) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        return this;
    }

    @Override // p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: j */
    public boolean mo95j() {
        return true;
    }

    @Override // p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: k */
    public Object mo96k(InterfaceC2012a interfaceC2012a) {
        AbstractC1766e.m3920e("deserializer", interfaceC2012a);
        return interfaceC2012a.mo220b(this);
    }

    @Override // p004A2.InterfaceC0024a
    /* JADX INFO: renamed from: l */
    public String mo82l(InterfaceC2095g interfaceC2095g, int i3) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        return mo101v();
    }

    @Override // p004A2.InterfaceC0024a
    /* JADX INFO: renamed from: m */
    public short mo83m(InterfaceC2095g interfaceC2095g, int i3) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        return mo100u();
    }

    @Override // p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: o */
    public char mo97o() {
        m1000J();
        throw null;
    }

    /* JADX INFO: renamed from: p */
    public Object mo85p(InterfaceC2095g interfaceC2095g, int i3, InterfaceC2012a interfaceC2012a, Object obj) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        AbstractC1766e.m3920e("deserializer", interfaceC2012a);
        return mo96k(interfaceC2012a);
    }

    @Override // p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: r */
    public abstract byte mo98r();

    @Override // p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: s */
    public InterfaceC0025b mo99s(InterfaceC2095g interfaceC2095g) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        return this;
    }

    @Override // p004A2.InterfaceC0024a
    /* JADX INFO: renamed from: t */
    public InterfaceC0025b mo87t(InterfaceC2095g interfaceC2095g, int i3) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        return mo99s(interfaceC2095g.mo236h(i3));
    }

    @Override // p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: u */
    public abstract short mo100u();

    @Override // p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: v */
    public String mo101v() {
        m1000J();
        throw null;
    }

    /* JADX INFO: renamed from: w */
    public void mo88w(InterfaceC2095g interfaceC2095g) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
    }

    @Override // p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: x */
    public float mo102x() {
        m1000J();
        throw null;
    }

    @Override // p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: y */
    public int mo103y(InterfaceC2095g interfaceC2095g) {
        AbstractC1766e.m3920e("enumDescriptor", interfaceC2095g);
        m1000J();
        throw null;
    }

    @Override // p004A2.InterfaceC0024a
    /* JADX INFO: renamed from: z */
    public long mo89z(InterfaceC2095g interfaceC2095g, int i3) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        return mo91c();
    }
}
