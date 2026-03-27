package p082b1;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p039M0.C0453A;
import p039M0.EnumC0511z;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0721l;
import p069X0.C0707I;
import p069X0.EnumC0731v;
import p071Y0.EnumC0747k;
import p074Z0.AbstractC0832r;
import p074Z0.AbstractC0833s;
import p114l1.AbstractC1671m;
import p114l1.C1674p;
import p114l1.C1675q;
import p118m1.AbstractC1745j;
import p118m1.InterfaceC1737b;

/* JADX INFO: renamed from: b1.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1034e {

    /* JADX INFO: renamed from: a */
    public final AbstractC0711b f3679a;

    /* JADX INFO: renamed from: b */
    public final boolean f3680b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC1008D f3681c;

    /* JADX INFO: renamed from: d */
    public final Object f3682d;

    /* JADX INFO: renamed from: e */
    public Object f3683e;

    /* JADX INFO: renamed from: f */
    public final Serializable f3684f;

    public C1034e(AbstractC0832r abstractC0832r, AbstractC0721l abstractC0721l, InterfaceC1008D interfaceC1008D) {
        Class cls = abstractC0721l.f2036e;
        this.f3683e = cls;
        this.f3681c = interfaceC1008D;
        this.f3682d = abstractC0721l.mo1873h();
        abstractC0832r.getClass();
        AbstractC0711b abstractC0711bM2149d = abstractC0832r.m2157l(EnumC0731v.USE_ANNOTATIONS) ? abstractC0832r.m2149d() : null;
        this.f3679a = abstractC0711bM2149d;
        this.f3684f = interfaceC1008D != null ? interfaceC1008D.mo2158a(cls) : null;
        this.f3680b = (abstractC0711bM2149d == null || (AbstractC1745j.m3898u(cls) && abstractC0721l.mo1887v())) ? false : true;
    }

    /* JADX INFO: renamed from: d */
    public static void m2779d(AbstractC0721l abstractC0721l, ArrayList arrayList, boolean z3) {
        int length;
        Class cls = abstractC0721l.f2036e;
        if (z3) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (((AbstractC0721l) arrayList.get(i3)).f2036e == cls) {
                    return;
                }
            }
            arrayList.add(abstractC0721l);
            if (cls == List.class || cls == Map.class) {
                return;
            }
        }
        AbstractC0721l[] abstractC0721lArr = ((AbstractC1671m) abstractC0721l).f5912k;
        List listEmptyList = (abstractC0721lArr == null || (length = abstractC0721lArr.length) == 0) ? Collections.emptyList() : length != 1 ? Arrays.asList(abstractC0721lArr) : Collections.singletonList(abstractC0721lArr[0]);
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            m2779d((AbstractC0721l) it.next(), arrayList, true);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m2780e(AbstractC0721l abstractC0721l, ArrayList arrayList, boolean z3) {
        int length;
        Class cls = abstractC0721l.f2036e;
        if (cls == Object.class || cls == Enum.class) {
            return;
        }
        if (z3) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (((AbstractC0721l) arrayList.get(i3)).f2036e == cls) {
                    return;
                }
            }
            arrayList.add(abstractC0721l);
        }
        AbstractC0721l[] abstractC0721lArr = ((AbstractC1671m) abstractC0721l).f5912k;
        List listEmptyList = (abstractC0721lArr == null || (length = abstractC0721lArr.length) == 0) ? Collections.emptyList() : length != 1 ? Arrays.asList(abstractC0721lArr) : Collections.singletonList(abstractC0721lArr[0]);
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            m2779d((AbstractC0721l) it.next(), arrayList, true);
        }
        AbstractC0721l abstractC0721lMo1879n = abstractC0721l.mo1879n();
        if (abstractC0721lMo1879n != null) {
            m2780e(abstractC0721lMo1879n, arrayList, true);
        }
    }

    /* JADX INFO: renamed from: h */
    public static C1033d m2781h(AbstractC0832r abstractC0832r, Class cls) {
        if (cls.isArray() && (abstractC0832r == null || ((AbstractC0833s) abstractC0832r).f2484g.mo2158a(cls) == null)) {
            return new C1033d(cls);
        }
        C1034e c1034e = new C1034e(abstractC0832r, cls, abstractC0832r);
        List listEmptyList = Collections.emptyList();
        InterfaceC1737b interfaceC1737bM2786g = c1034e.m2786g(listEmptyList);
        C1675q c1675q = abstractC0832r.f2481f.f2419e;
        return new C1033d(null, cls, listEmptyList, (Class) c1034e.f3684f, interfaceC1737bM2786g, (C1674p) c1034e.f3682d, c1034e.f3679a, abstractC0832r, c1675q, c1034e.f3680b);
    }

    /* JADX INFO: renamed from: a */
    public AbstractC1055z m2782a(AbstractC1055z abstractC1055z, Annotation[] annotationArr) {
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                if (!abstractC1055z.mo2809h(annotation)) {
                    abstractC1055z = abstractC1055z.mo2806a(annotation);
                    if (this.f3679a.mo1780m0(annotation)) {
                        abstractC1055z = m2784c(abstractC1055z, annotation);
                    }
                }
            }
        }
        return abstractC1055z;
    }

    /* JADX INFO: renamed from: b */
    public AbstractC1055z m2783b(AbstractC1055z abstractC1055z, Class cls, Class cls2) {
        if (cls2 != null) {
            abstractC1055z = m2782a(abstractC1055z, AbstractC1745j.m3887j(cls2));
            Iterator it = AbstractC1745j.m3889l(cls2, cls, false).iterator();
            while (it.hasNext()) {
                abstractC1055z = m2782a(abstractC1055z, AbstractC1745j.m3887j((Class) it.next()));
            }
        }
        return abstractC1055z;
    }

    /* JADX INFO: renamed from: c */
    public AbstractC1055z m2784c(AbstractC1055z abstractC1055z, Annotation annotation) {
        for (Annotation annotation2 : AbstractC1745j.m3887j(annotation.annotationType())) {
            if (!(annotation2 instanceof Target) && !(annotation2 instanceof Retention) && !abstractC1055z.mo2809h(annotation2)) {
                abstractC1055z = abstractC1055z.mo2806a(annotation2);
                if (this.f3679a.mo1780m0(annotation2)) {
                    abstractC1055z = m2784c(abstractC1055z, annotation2);
                }
            }
        }
        return abstractC1055z;
    }

    /* JADX INFO: renamed from: f */
    public AbstractC0721l m2785f(AbstractC1031b abstractC1031b, boolean z3, AbstractC0721l abstractC0721l) {
        AbstractC0711b abstractC0711b = this.f3679a;
        AbstractC0721l abstractC0721lMo1788q0 = abstractC0711b.mo1788q0((C0707I) this.f3681c, abstractC1031b, abstractC0721l);
        if (abstractC0721lMo1788q0 != abstractC0721l) {
            Class<?> cls = abstractC0721lMo1788q0.f2036e;
            Class<?> cls2 = abstractC0721l.f2036e;
            if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + abstractC1031b.mo2767d() + "': class " + cls.getName() + " not a super-type of (declared) class " + cls2.getName());
            }
            abstractC0721l = abstractC0721lMo1788q0;
            z3 = true;
        }
        EnumC0747k enumC0747kMo1749U = abstractC0711b.mo1749U(abstractC1031b);
        if (enumC0747kMo1749U != null && enumC0747kMo1749U != EnumC0747k.f2110g) {
            z3 = enumC0747kMo1749U == EnumC0747k.f2109f;
        }
        if (z3) {
            return abstractC0721l.mo1868G();
        }
        return null;
    }

    /* JADX INFO: renamed from: g */
    public InterfaceC1737b m2786g(List list) {
        C1051v c1051v = AbstractC1055z.f3728b;
        if (this.f3679a == null) {
            return c1051v;
        }
        InterfaceC1008D interfaceC1008D = this.f3681c;
        boolean z3 = interfaceC1008D != null && (!(interfaceC1008D instanceof C1026W) || ((C1026W) interfaceC1008D).m2765b());
        boolean z4 = this.f3680b;
        if (!z3 && !z4) {
            return c1051v;
        }
        AbstractC1055z abstractC1055zM2783b = C1049t.f3718e;
        Class cls = (Class) this.f3683e;
        Class cls2 = (Class) this.f3684f;
        if (cls2 != null) {
            abstractC1055zM2783b = m2783b(abstractC1055zM2783b, cls, cls2);
        }
        if (z4) {
            abstractC1055zM2783b = m2782a(abstractC1055zM2783b, AbstractC1745j.m3887j(cls));
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC0721l abstractC0721l = (AbstractC0721l) it.next();
            if (z3) {
                Class cls3 = abstractC0721l.f2036e;
                abstractC1055zM2783b = m2783b(abstractC1055zM2783b, cls3, interfaceC1008D.mo2158a(cls3));
            }
            if (z4) {
                abstractC1055zM2783b = m2782a(abstractC1055zM2783b, AbstractC1745j.m3887j(abstractC0721l.f2036e));
            }
        }
        if (z3) {
            abstractC1055zM2783b = m2783b(abstractC1055zM2783b, Object.class, interfaceC1008D.mo2158a(Object.class));
        }
        return abstractC1055zM2783b.mo2808c();
    }

    public C1034e(C0707I c0707i, C1005A c1005a) {
        this.f3681c = c0707i;
        this.f3682d = c1005a;
        C0453A c0453a = C0453A.f1095i;
        AbstractC0711b abstractC0711b = c1005a.f3581d;
        C0453A c0453aM989a = abstractC0711b != null ? c0453a.m989a(abstractC0711b.mo1739K(c1005a.f3582e)) : c0453a;
        c0707i.mo2150e(c1005a.f1980a.f2036e);
        C0453A c0453aM989a2 = c0453aM989a.m989a(c0453a);
        C0453A c0453a2 = c0707i.f2490m.f2448f;
        this.f3684f = c0453a2 == null ? c0453aM989a2 : c0453a2.m989a(c0453aM989a2);
        this.f3680b = c0453aM989a2.f1096e == EnumC0511z.f1185h;
        this.f3679a = c0707i.m2149d();
    }

    public C1034e(AbstractC0832r abstractC0832r, Class cls, InterfaceC1008D interfaceC1008D) {
        this.f3683e = cls;
        this.f3681c = interfaceC1008D;
        this.f3682d = C1674p.f5927k;
        if (abstractC0832r == null) {
            this.f3679a = null;
            this.f3684f = null;
        } else {
            this.f3679a = abstractC0832r.m2157l(EnumC0731v.USE_ANNOTATIONS) ? abstractC0832r.m2149d() : null;
            this.f3684f = interfaceC1008D != null ? interfaceC1008D.mo2158a(cls) : null;
        }
        this.f3680b = this.f3679a != null;
    }
}
