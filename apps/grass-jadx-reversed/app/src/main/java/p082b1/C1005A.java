package p082b1;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import p039M0.C0502q;
import p039M0.EnumC0495j;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0712c;
import p069X0.AbstractC0721l;
import p069X0.C0703E;
import p069X0.EnumC0731v;
import p074Z0.AbstractC0832r;
import p118m1.AbstractC1745j;
import p118m1.AbstractC1747l;
import p118m1.InterfaceC1748m;

/* JADX INFO: renamed from: b1.A */
/* JADX INFO: loaded from: classes.dex */
public final class C1005A extends AbstractC0712c {

    /* JADX INFO: renamed from: j */
    public static final Class[] f3578j = new Class[0];

    /* JADX INFO: renamed from: b */
    public final C1019O f3579b;

    /* JADX INFO: renamed from: c */
    public final AbstractC0832r f3580c;

    /* JADX INFO: renamed from: d */
    public final AbstractC0711b f3581d;

    /* JADX INFO: renamed from: e */
    public final C1033d f3582e;

    /* JADX INFO: renamed from: f */
    public Class[] f3583f;

    /* JADX INFO: renamed from: g */
    public boolean f3584g;

    /* JADX INFO: renamed from: h */
    public List f3585h;

    /* JADX INFO: renamed from: i */
    public final C1018N f3586i;

    public C1005A(C1019O c1019o) {
        super(c1019o.f3618d);
        this.f3579b = c1019o;
        AbstractC0832r abstractC0832r = c1019o.f3615a;
        this.f3580c = abstractC0832r;
        if (abstractC0832r == null) {
            this.f3581d = null;
        } else {
            this.f3581d = abstractC0832r.m2149d();
        }
        C1033d c1033d = c1019o.f3619e;
        this.f3582e = c1033d;
        AbstractC0711b abstractC0711b = c1019o.f3621g;
        C1018N c1018nMo1798z = abstractC0711b.mo1798z(c1033d);
        this.f3586i = c1018nMo1798z != null ? abstractC0711b.mo1729A(c1033d, c1018nMo1798z) : c1018nMo1798z;
    }

    /* JADX INFO: renamed from: g */
    public static C1005A m2696g(AbstractC0721l abstractC0721l, AbstractC0832r abstractC0832r, C1033d c1033d) {
        return new C1005A(abstractC0832r, abstractC0721l, c1033d, Collections.emptyList());
    }

    @Override // p069X0.AbstractC0712c
    /* JADX INFO: renamed from: a */
    public final Class[] mo1799a() {
        if (!this.f3584g) {
            this.f3584g = true;
            AbstractC0711b abstractC0711b = this.f3581d;
            Class[] clsArrMo1760c0 = abstractC0711b == null ? null : abstractC0711b.mo1760c0(this.f3582e);
            if (clsArrMo1760c0 == null && !this.f3580c.m2157l(EnumC0731v.DEFAULT_VIEW_INCLUSION)) {
                clsArrMo1760c0 = f3578j;
            }
            this.f3583f = clsArrMo1760c0;
        }
        return this.f3583f;
    }

    @Override // p069X0.AbstractC0712c
    /* JADX INFO: renamed from: b */
    public final C0502q mo1800b() {
        C0502q c0502qMo1783o;
        C1033d c1033d = this.f3582e;
        AbstractC0711b abstractC0711b = this.f3581d;
        if (abstractC0711b == null || (c0502qMo1783o = abstractC0711b.mo1783o(c1033d)) == null) {
            c0502qMo1783o = null;
        }
        C0502q c0502qMo2151f = this.f3580c.mo2151f(c1033d.f3666f);
        return c0502qMo2151f != null ? c0502qMo1783o == null ? c0502qMo2151f : c0502qMo1783o.m1018e(c0502qMo2151f) : c0502qMo1783o;
    }

    @Override // p069X0.AbstractC0712c
    /* JADX INFO: renamed from: c */
    public final AbstractC1041l mo1801c() {
        C1019O c1019o = this.f3579b;
        if (c1019o == null) {
            return null;
        }
        if (!c1019o.f3624j) {
            c1019o.m2746h();
        }
        LinkedList linkedList = c1019o.f3632r;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() <= 1 || C1019O.m2740g(c1019o.f3632r)) {
            return (AbstractC1041l) c1019o.f3632r.get(0);
        }
        c1019o.m2747i("Multiple 'as-value' properties defined (%s vs %s)", c1019o.f3632r.get(0), c1019o.f3632r.get(1));
        throw null;
    }

    @Override // p069X0.AbstractC0712c
    /* JADX INFO: renamed from: d */
    public final List mo1802d() {
        Class clsMo2792u;
        List<C1043n> list = (List) this.f3582e.m2776h().f3801h;
        if (list.isEmpty()) {
            return list;
        }
        ArrayList arrayList = null;
        for (C1043n c1043n : list) {
            if (this.f1980a.f2036e.isAssignableFrom(c1043n.f3704h.getReturnType())) {
                EnumC0495j enumC0495jMo1763e = this.f3581d.mo1763e(this.f3580c, c1043n);
                if (enumC0495jMo1763e == null || enumC0495jMo1763e == EnumC0495j.f1145h) {
                    Method method = c1043n.f3704h;
                    String name = method.getName();
                    if ((!"valueOf".equals(name) || method.getParameterCount() != 1) && (!"fromString".equals(name) || method.getParameterCount() != 1 || ((clsMo2792u = c1043n.mo2792u(0)) != String.class && !CharSequence.class.isAssignableFrom(clsMo2792u)))) {
                    }
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(c1043n);
            }
        }
        return arrayList == null ? Collections.emptyList() : arrayList;
    }

    /* JADX INFO: renamed from: e */
    public final InterfaceC1748m m2697e(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof InterfaceC1748m) {
            return (InterfaceC1748m) obj;
        }
        if (!(obj instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + obj.getClass().getName() + "; expected type Converter or Class<Converter> instead");
        }
        Class cls = (Class) obj;
        if (cls == AbstractC1747l.class || AbstractC1745j.m3897t(cls)) {
            return null;
        }
        if (InterfaceC1748m.class.isAssignableFrom(cls)) {
            AbstractC0832r abstractC0832r = this.f3580c;
            abstractC0832r.m2153h();
            return (InterfaceC1748m) AbstractC1745j.m3885h(cls, abstractC0832r.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS));
        }
        throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<Converter>");
    }

    /* JADX INFO: renamed from: f */
    public final List m2698f() {
        if (this.f3585h == null) {
            C1019O c1019o = this.f3579b;
            if (!c1019o.f3624j) {
                c1019o.m2746h();
            }
            this.f3585h = new ArrayList(c1019o.f3625k.values());
        }
        return this.f3585h;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m2699h(C0703E c0703e) {
        AbstractC1007C abstractC1007C;
        Iterator it = m2698f().iterator();
        while (true) {
            if (!it.hasNext()) {
                abstractC1007C = null;
                break;
            }
            abstractC1007C = (AbstractC1007C) it.next();
            if (abstractC1007C.mo2725x(c0703e)) {
                break;
            }
        }
        return abstractC1007C != null;
    }

    public C1005A(AbstractC0832r abstractC0832r, AbstractC0721l abstractC0721l, C1033d c1033d, List list) {
        super(abstractC0721l);
        this.f3579b = null;
        this.f3580c = abstractC0832r;
        if (abstractC0832r == null) {
            this.f3581d = null;
        } else {
            this.f3581d = abstractC0832r.m2149d();
        }
        this.f3582e = c1033d;
        this.f3585h = list;
    }
}
