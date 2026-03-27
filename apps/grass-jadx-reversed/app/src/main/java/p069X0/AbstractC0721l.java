package p069X0;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import p064V0.AbstractC0671a;
import p114l1.AbstractC1671m;
import p114l1.C1674p;
import p114l1.C1675q;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: X0.l */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0721l extends AbstractC0671a implements Serializable, Type {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final Class f2036e;

    /* JADX INFO: renamed from: f */
    public final int f2037f;

    /* JADX INFO: renamed from: g */
    public final Object f2038g;

    /* JADX INFO: renamed from: h */
    public final Object f2039h;

    /* JADX INFO: renamed from: i */
    public final boolean f2040i;

    public AbstractC0721l(Class cls, int i3, Object obj, Object obj2, boolean z3) {
        this.f2036e = cls;
        this.f2037f = cls.hashCode() + (i3 * 31);
        this.f2038g = obj;
        this.f2039h = obj2;
        this.f2040i = z3;
    }

    /* JADX INFO: renamed from: A */
    public final boolean m1862A(Class cls) {
        Class cls2 = this.f2036e;
        return cls2 == cls || cls2.isAssignableFrom(cls);
    }

    /* JADX INFO: renamed from: B */
    public abstract AbstractC0721l mo1863B(Class cls, C1674p c1674p, AbstractC0721l abstractC0721l, AbstractC0721l[] abstractC0721lArr);

    /* JADX INFO: renamed from: C */
    public abstract AbstractC0721l mo1864C(AbstractC0721l abstractC0721l);

    /* JADX INFO: renamed from: D */
    public abstract AbstractC0721l mo1865D(Object obj);

    /* JADX INFO: renamed from: E */
    public abstract AbstractC0721l mo1866E(AbstractC0722m abstractC0722m);

    /* JADX INFO: renamed from: F */
    public AbstractC0721l mo1867F(AbstractC0721l abstractC0721l) {
        Object obj = abstractC0721l.f2039h;
        AbstractC0721l abstractC0721lMo1869H = obj != this.f2039h ? mo1869H(obj) : this;
        Object obj2 = this.f2038g;
        Object obj3 = abstractC0721l.f2038g;
        return obj3 != obj2 ? abstractC0721lMo1869H.mo1870I(obj3) : abstractC0721lMo1869H;
    }

    /* JADX INFO: renamed from: G */
    public abstract AbstractC0721l mo1868G();

    /* JADX INFO: renamed from: H */
    public abstract AbstractC0721l mo1869H(Object obj);

    /* JADX INFO: renamed from: I */
    public abstract AbstractC0721l mo1870I(Object obj);

    public abstract boolean equals(Object obj);

    /* JADX INFO: renamed from: f */
    public final AbstractC0721l m1871f(int i3) {
        AbstractC0721l abstractC0721lM3764d = ((AbstractC1671m) this).f5913l.m3764d(i3);
        return abstractC0721lM3764d == null ? C1675q.m3773n() : abstractC0721lM3764d;
    }

    /* JADX INFO: renamed from: g */
    public abstract AbstractC0721l mo1872g(Class cls);

    /* JADX INFO: renamed from: h */
    public abstract C1674p mo1873h();

    public int hashCode() {
        return this.f2037f;
    }

    /* JADX INFO: renamed from: i */
    public AbstractC0721l mo1874i() {
        return null;
    }

    /* JADX INFO: renamed from: j */
    public abstract StringBuilder mo1875j(StringBuilder sb);

    /* JADX INFO: renamed from: k */
    public abstract StringBuilder mo1876k(StringBuilder sb);

    /* JADX INFO: renamed from: l */
    public AbstractC0721l mo1877l() {
        return null;
    }

    @Override // p064V0.AbstractC0671a
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public AbstractC0721l mo1628a() {
        return null;
    }

    /* JADX INFO: renamed from: n */
    public abstract AbstractC0721l mo1879n();

    /* JADX INFO: renamed from: o */
    public boolean mo1880o() {
        return true;
    }

    /* JADX INFO: renamed from: p */
    public boolean mo1881p() {
        return ((AbstractC1671m) this).f5913l.f5929f.length > 0;
    }

    /* JADX INFO: renamed from: q */
    public boolean mo1882q() {
        return (this.f2039h == null && this.f2038g == null) ? false : true;
    }

    /* JADX INFO: renamed from: r */
    public final boolean m1883r(Class cls) {
        return this.f2036e == cls;
    }

    /* JADX INFO: renamed from: s */
    public boolean mo1884s() {
        return Modifier.isAbstract(this.f2036e.getModifiers());
    }

    /* JADX INFO: renamed from: t */
    public boolean mo1885t() {
        return false;
    }

    public abstract String toString();

    /* JADX INFO: renamed from: u */
    public boolean mo1886u() {
        Class cls = this.f2036e;
        if ((cls.getModifiers() & 1536) == 0) {
            return true;
        }
        return cls.isPrimitive();
    }

    /* JADX INFO: renamed from: v */
    public abstract boolean mo1887v();

    /* JADX INFO: renamed from: w */
    public final boolean m1888w() {
        Annotation[] annotationArr = AbstractC1745j.f6110a;
        return Enum.class.isAssignableFrom(this.f2036e);
    }

    /* JADX INFO: renamed from: x */
    public final boolean m1889x() {
        return this.f2036e == Object.class;
    }

    /* JADX INFO: renamed from: y */
    public boolean mo1890y() {
        return false;
    }

    /* JADX INFO: renamed from: z */
    public final boolean m1891z(Class cls) {
        Class cls2 = this.f2036e;
        return cls2 == cls || cls.isAssignableFrom(cls2);
    }
}
