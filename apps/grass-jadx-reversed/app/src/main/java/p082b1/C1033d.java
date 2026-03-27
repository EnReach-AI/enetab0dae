package p082b1;

import com.facebook.C1100C;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p001A.C0009j;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0721l;
import p114l1.C1674p;
import p114l1.C1675q;
import p118m1.AbstractC1745j;
import p118m1.InterfaceC1737b;

/* JADX INFO: renamed from: b1.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1033d extends AbstractC1031b implements InterfaceC1027X {

    /* JADX INFO: renamed from: s */
    public static final C1100C f3664s = new C1100C(null, Collections.emptyList(), Collections.emptyList(), 4);

    /* JADX INFO: renamed from: e */
    public final AbstractC0721l f3665e;

    /* JADX INFO: renamed from: f */
    public final Class f3666f;

    /* JADX INFO: renamed from: g */
    public final C1674p f3667g;

    /* JADX INFO: renamed from: h */
    public final List f3668h;

    /* JADX INFO: renamed from: i */
    public final AbstractC0711b f3669i;

    /* JADX INFO: renamed from: j */
    public final C1675q f3670j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC1008D f3671k;

    /* JADX INFO: renamed from: l */
    public final Class f3672l;

    /* JADX INFO: renamed from: m */
    public final boolean f3673m;

    /* JADX INFO: renamed from: n */
    public final InterfaceC1737b f3674n;

    /* JADX INFO: renamed from: o */
    public C1100C f3675o;

    /* JADX INFO: renamed from: p */
    public C1046q f3676p;

    /* JADX INFO: renamed from: q */
    public List f3677q;

    /* JADX INFO: renamed from: r */
    public transient Boolean f3678r;

    public C1033d(AbstractC0721l abstractC0721l, Class cls, List list, Class cls2, InterfaceC1737b interfaceC1737b, C1674p c1674p, AbstractC0711b abstractC0711b, InterfaceC1008D interfaceC1008D, C1675q c1675q, boolean z3) {
        this.f3665e = abstractC0721l;
        this.f3666f = cls;
        this.f3668h = list;
        this.f3672l = cls2;
        this.f3674n = interfaceC1737b;
        this.f3667g = c1674p;
        this.f3669i = abstractC0711b;
        this.f3671k = interfaceC1008D;
        this.f3670j = c1675q;
        this.f3673m = z3;
    }

    @Override // p082b1.InterfaceC1027X
    /* JADX INFO: renamed from: b */
    public final AbstractC0721l mo42b(Type type) {
        return this.f3670j.m3774b(null, type, this.f3667g);
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: c */
    public final Annotation mo2774c(Class cls) {
        return this.f3674n.mo442a(cls);
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: d */
    public final String mo2767d() {
        return this.f3666f.getName();
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: e */
    public final Class mo2768e() {
        return this.f3666f;
    }

    @Override // p082b1.AbstractC1031b
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return AbstractC1745j.m3896s(obj, C1033d.class) && ((C1033d) obj).f3666f == this.f3666f;
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: f */
    public final AbstractC0721l mo2769f() {
        return this.f3665e;
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: g */
    public final boolean mo2775g(Class[] clsArr) {
        return this.f3674n.mo454o(clsArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x0223 A[PHI: r1 r2 r3 r8
      0x0223: PHI (r1v25 X0.l) = (r1v3 X0.l), (r1v3 X0.l), (r1v11 X0.l) binds: [B:125:0x0221, B:131:0x0238, B:252:0x0223] A[DONT_GENERATE, DONT_INLINE]
      0x0223: PHI (r2v15 int) = (r2v2 int), (r2v2 int), (r2v8 int) binds: [B:125:0x0221, B:131:0x0238, B:252:0x0223] A[DONT_GENERATE, DONT_INLINE]
      0x0223: PHI (r3v29 java.util.ArrayList) = (r3v4 java.util.ArrayList), (r3v4 java.util.ArrayList), (r3v10 java.util.ArrayList) binds: [B:125:0x0221, B:131:0x0238, B:252:0x0223] A[DONT_GENERATE, DONT_INLINE]
      0x0223: PHI (r8v16 java.lang.Class) = (r8v1 java.lang.Class), (r8v1 java.lang.Class), (r8v5 java.lang.Class) binds: [B:125:0x0221, B:131:0x0238, B:252:0x0223] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x017f  */
    /* JADX INFO: renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.C1100C m2776h() {
        /*
            Method dump skipped, instruction units count: 946
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p082b1.C1033d.m2776h():com.facebook.C");
    }

    @Override // p082b1.AbstractC1031b
    public final int hashCode() {
        return this.f3666f.getName().hashCode();
    }

    /* JADX INFO: renamed from: i */
    public final C1046q m2777i() {
        InterfaceC1008D interfaceC1008D;
        Class clsMo2158a;
        C1046q c1046q = this.f3676p;
        if (c1046q == null) {
            AbstractC0721l abstractC0721l = this.f3665e;
            if (abstractC0721l == null) {
                c1046q = new C1046q();
            } else {
                C1045p c1045p = new C1045p(this.f3669i, this.f3671k, this.f3673m);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Class cls = this.f3672l;
                Class cls2 = abstractC0721l.f2036e;
                c1045p.m2803i(this, cls2, linkedHashMap, cls);
                Iterator it = this.f3668h.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    interfaceC1008D = c1045p.f3710e;
                    Class clsMo2158a2 = null;
                    if (!zHasNext) {
                        break;
                    }
                    AbstractC0721l abstractC0721l2 = (AbstractC0721l) it.next();
                    if (interfaceC1008D != null) {
                        clsMo2158a2 = interfaceC1008D.mo2158a(abstractC0721l2.f2036e);
                    }
                    c1045p.m2803i(new C0009j(this.f3670j, 20, abstractC0721l2.mo1873h()), abstractC0721l2.f2036e, linkedHashMap, clsMo2158a2);
                }
                if (interfaceC1008D != null && (clsMo2158a = interfaceC1008D.mo2158a(Object.class)) != null) {
                    c1045p.m2804j(this, cls2, linkedHashMap, clsMo2158a);
                    if (((AbstractC0711b) c1045p.f3731a) != null && !linkedHashMap.isEmpty()) {
                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                            C1015K c1015k = (C1015K) entry.getKey();
                            if ("hashCode".equals(c1015k.f3606a) && c1015k.f3607b.length == 0) {
                                try {
                                    Method declaredMethod = Object.class.getDeclaredMethod(c1015k.f3606a, null);
                                    if (declaredMethod != null) {
                                        C1044o c1044o = (C1044o) entry.getValue();
                                        c1044o.f3709c = c1045p.m2812f(c1044o.f3709c, declaredMethod.getDeclaredAnnotations());
                                        c1044o.f3708b = declaredMethod;
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
                if (linkedHashMap.isEmpty()) {
                    c1046q = new C1046q();
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap.size());
                    for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                        C1044o c1044o2 = (C1044o) entry2.getValue();
                        Method method = c1044o2.f3708b;
                        C1043n c1043n = method == null ? null : new C1043n(c1044o2.f3707a, method, c1044o2.f3709c.mo2807b(), null);
                        if (c1043n != null) {
                            linkedHashMap2.put(entry2.getKey(), c1043n);
                        }
                    }
                    C1046q c1046q2 = new C1046q();
                    c1046q2.f3713f = linkedHashMap2;
                    c1046q = c1046q2;
                }
            }
            this.f3676p = c1046q;
        }
        return c1046q;
    }

    /* JADX INFO: renamed from: j */
    public final List m2778j() {
        Map mapM2793i;
        List listEmptyList = this.f3677q;
        if (listEmptyList == null) {
            AbstractC0721l abstractC0721l = this.f3665e;
            if (abstractC0721l == null || (mapM2793i = new C1037h(this.f3669i, this.f3670j, this.f3671k, this.f3673m).m2793i(this, abstractC0721l)) == null) {
                listEmptyList = Collections.emptyList();
            } else {
                ArrayList arrayList = new ArrayList(mapM2793i.size());
                for (C1040k c1040k : mapM2793i.values()) {
                    arrayList.add(new C1039j(c1040k.f3696a, c1040k.f3697b, c1040k.f3698c.mo2807b()));
                }
                listEmptyList = arrayList;
            }
            this.f3677q = listEmptyList;
        }
        return listEmptyList;
    }

    @Override // p082b1.AbstractC1031b
    public final String toString() {
        return "[AnnotedClass " + this.f3666f.getName() + "]";
    }

    public C1033d(Class cls) {
        this.f3665e = null;
        this.f3666f = cls;
        this.f3668h = Collections.emptyList();
        this.f3672l = null;
        this.f3674n = AbstractC1055z.f3728b;
        this.f3667g = C1674p.f5927k;
        this.f3669i = null;
        this.f3671k = null;
        this.f3670j = null;
        this.f3673m = false;
    }
}
