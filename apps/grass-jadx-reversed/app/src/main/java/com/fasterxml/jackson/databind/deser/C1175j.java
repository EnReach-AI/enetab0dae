package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.JsonDeserializer$None;
import com.fasterxml.jackson.databind.deser.impl.C1149a;
import com.fasterxml.jackson.databind.deser.impl.C1160l;
import com.fasterxml.jackson.databind.deser.impl.C1169u;
import com.fasterxml.jackson.databind.deser.impl.ErrorThrowingDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p005B.AbstractC0032g;
import p039M0.EnumC0499n;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0712c;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.AbstractC0730u;
import p069X0.C0702D;
import p069X0.C0717h;
import p069X0.EnumC0731v;
import p071Y0.C0744h;
import p074Z0.AbstractC0832r;
import p074Z0.C0815a;
import p074Z0.C0829o;
import p078a1.C0850b;
import p082b1.C1005A;
import p082b1.C1006B;
import p082b1.C1011G;
import p082b1.C1013I;
import p082b1.C1015K;
import p082b1.C1019O;
import p082b1.C1033d;
import p082b1.C1043n;
import p114l1.AbstractC1665g;
import p114l1.C1666h;
import p118m1.AbstractC1745j;
import p118m1.C1740e;
import p118m1.C1752q;
import p118m1.InterfaceC1748m;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.j */
/* JADX INFO: loaded from: classes.dex */
public final class C1175j implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: f */
    public final HashMap f4040f = new HashMap(8);

    /* JADX INFO: renamed from: e */
    public final C1752q f4039e = new C1752q(Math.min(64, 500), 2000);

    /* JADX INFO: renamed from: b */
    public static AbstractC0722m m3015b(AbstractC0718i abstractC0718i, AbstractC1176k abstractC1176k, AbstractC0721l abstractC0721l) throws C0850b {
        AbstractC0722m abstractC0722mMo1849n;
        C1005A c1005a;
        AbstractC0721l abstractC0721lMo1866E;
        AbstractC0721l abstractC0721lMo1786p0;
        Object objMo1759c;
        AbstractC0722m abstractC0722mMo1849n2;
        AbstractC0721l abstractC0721lMo1877l;
        Object objMo1791s;
        AbstractC0730u abstractC0730uMo1834L;
        AbstractC0721l abstractC0721l2;
        C1005A c1005aM1818p;
        boolean z3;
        C0717h c0717h = abstractC0718i.f1998g;
        if (abstractC0721l.mo1884s() || abstractC0721l.mo1890y() || abstractC0721l.mo1885t()) {
            abstractC1176k.mo2939c(abstractC0721l);
        }
        C1005A c1005aM1818p2 = c0717h.m1818p(abstractC0721l);
        AbstractC0832r abstractC0832r = abstractC0718i.f1998g;
        AbstractC0711b abstractC0711bM2149d = abstractC0832r.m2149d();
        C1033d c1033d = c1005aM1818p2.f3582e;
        Object objMo1773j = abstractC0711bM2149d.mo1773j(c1033d);
        if (objMo1773j == null) {
            abstractC0722mMo1849n = null;
        } else {
            abstractC0722mMo1849n = abstractC0718i.mo1849n(objMo1773j);
            Object objMo1771i = abstractC0832r.m2149d().mo1771i(c1033d);
            InterfaceC1748m interfaceC1748mM1812d = objMo1771i == null ? null : abstractC0718i.m1812d(objMo1771i);
            if (interfaceC1748mM1812d != null) {
                abstractC0718i.mo1711f();
                abstractC0722mMo1849n = new StdDelegatingDeserializer(interfaceC1748mM1812d, ((C1160l) interfaceC1748mM1812d).f4009a, abstractC0722mMo1849n);
            }
        }
        if (abstractC0722mMo1849n != null) {
            return abstractC0722mMo1849n;
        }
        AbstractC0711b abstractC0711bM2149d2 = abstractC0832r.m2149d();
        if (abstractC0711bM2149d2 == null) {
            c1005a = c1005aM1818p2;
            abstractC0721lMo1786p0 = abstractC0721l;
        } else {
            if (!abstractC0721l.mo1890y() || (abstractC0721lMo1877l = abstractC0721l.mo1877l()) == null || abstractC0721lMo1877l.f2038g != null || (objMo1791s = abstractC0711bM2149d2.mo1791s(c1033d)) == null || (abstractC0730uMo1834L = abstractC0718i.mo1834L(objMo1791s)) == null) {
                c1005a = c1005aM1818p2;
                abstractC0721lMo1866E = abstractC0721l;
            } else {
                C1666h c1666h = (C1666h) ((AbstractC1665g) abstractC0721l);
                c1005a = c1005aM1818p2;
                abstractC0721lMo1866E = new C1666h(c1666h.f2036e, c1666h.f5913l, c1666h.f5911j, c1666h.f5912k, c1666h.f5903n.mo1870I(abstractC0730uMo1834L), c1666h.f5904o, c1666h.f2038g, c1666h.f2039h, c1666h.f2040i);
            }
            AbstractC0721l abstractC0721lMo1874i = abstractC0721lMo1866E.mo1874i();
            if (abstractC0721lMo1874i != null && abstractC0721lMo1874i.f2038g == null && (objMo1759c = abstractC0711bM2149d2.mo1759c(c1033d)) != null) {
                if (objMo1759c instanceof AbstractC0722m) {
                    abstractC0722mMo1849n2 = (AbstractC0722m) objMo1759c;
                } else {
                    Class cls = (Class) objMo1759c;
                    if (cls == JsonDeserializer$None.class || AbstractC1745j.m3897t(cls)) {
                        cls = null;
                    }
                    abstractC0722mMo1849n2 = cls != null ? abstractC0718i.mo1849n(cls) : null;
                }
                if (abstractC0722mMo1849n2 != null) {
                    abstractC0721lMo1866E = abstractC0721lMo1866E.mo1866E(abstractC0722mMo1849n2);
                }
            }
            abstractC0721lMo1786p0 = abstractC0711bM2149d2.mo1786p0(abstractC0832r, c1033d, abstractC0721lMo1866E);
        }
        if (abstractC0721lMo1786p0 != abstractC0721l) {
            abstractC0721l2 = abstractC0721lMo1786p0;
            c1005aM1818p = c0717h.m1818p(abstractC0721lMo1786p0);
        } else {
            abstractC0721l2 = abstractC0721l;
            c1005aM1818p = c1005a;
        }
        C1033d c1033d2 = c1005aM1818p.f3582e;
        AbstractC0711b abstractC0711b = c1005aM1818p.f3581d;
        Class clsMo1730B = abstractC0711b == null ? null : abstractC0711b.mo1730B(c1033d2);
        Class<?> cls2 = abstractC0721l2.f2036e;
        if (clsMo1730B == null) {
            InterfaceC1748m interfaceC1748mM2697e = abstractC0711b == null ? null : c1005aM1818p.m2697e(abstractC0711b.mo1771i(c1033d2));
            if (interfaceC1748mM2697e == null) {
                return m3016c(abstractC0718i, abstractC1176k, abstractC0721l2, c1005aM1818p);
            }
            abstractC0718i.mo1711f();
            AbstractC0721l abstractC0721l3 = ((C1160l) interfaceC1748mM2697e).f4009a;
            if (!abstractC0721l3.m1883r(cls2)) {
                c1005aM1818p = c0717h.m1818p(abstractC0721l3);
            }
            return new StdDelegatingDeserializer(interfaceC1748mM2697e, abstractC0721l3, m3016c(abstractC0718i, abstractC1176k, abstractC0721l3, c1005aM1818p));
        }
        C1138e c1138e = (C1138e) abstractC1176k;
        c1138e.getClass();
        AbstractC0721l abstractC0721lM3775c = abstractC0832r.m2157l(EnumC0731v.INFER_BUILDER_TYPE_BINDINGS) ? abstractC0718i.mo1711f().m3775c(null, clsMo1730B, abstractC0721l2.mo1873h()) : abstractC0718i.m1848m(clsMo1730B);
        C0815a c0815a = abstractC0832r.f2481f;
        ((C1006B) c0815a.f2420f).getClass();
        C1033d c1033dM2702c = C1006B.m2702c(abstractC0832r, abstractC0721lM3775c, abstractC0832r);
        ((C1011G) c0815a.f2423i).getClass();
        AbstractC0711b abstractC0711bM2149d3 = abstractC0832r.m2157l(EnumC0731v.USE_ANNOTATIONS) ? abstractC0832r.m2149d() : null;
        C0744h c0744hMo1731C = abstractC0711bM2149d3 == null ? null : abstractC0711bM2149d3.mo1731C(c1033dM2702c);
        C1005A c1005a2 = new C1005A(new C1019O(abstractC0832r, false, abstractC0721lM3775c, c1033dM2702c, new C1013I(abstractC0832r, c0744hMo1731C == null ? "with" : c0744hMo1731C.f2105b)));
        try {
            AbstractC1208x abstractC1208xM2946p = c1138e.m2946p(abstractC0718i, c1005a2);
            C1137d c1137d = new C1137d(c1005a2, abstractC0718i);
            c1137d.f3939i = abstractC1208xM2946p;
            c1138e.m2957s(abstractC0718i, c1005a2, c1137d);
            C1138e.m2955u(abstractC0718i, c1005a2, c1137d);
            c1138e.m2956r(abstractC0718i, c1005a2, c1137d);
            C1138e.m2954t(c1005a2, c1137d);
            C1033d c1033d3 = c1005a2.f3582e;
            AbstractC0711b abstractC0711b2 = c1005a2.f3581d;
            C0744h c0744hMo1731C2 = abstractC0711b2 == null ? null : abstractC0711b2.mo1731C(c1033d3);
            String str = c0744hMo1731C2 == null ? "build" : c0744hMo1731C2.f2104a;
            Map map = (Map) c1033d3.m2777i().f3713f;
            C1043n c1043n = map == null ? null : (C1043n) map.get(new C1015K(str, null));
            if (c1043n != null && abstractC0832r.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                AbstractC1745j.m3882e(c1043n.f3704h, abstractC0832r.m2157l(EnumC0731v.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            c1137d.f3943m = c1043n;
            C0829o c0829o = c1138e.f3929e;
            if (c0829o.m2146c()) {
                C1740e c1740eM2144a = c0829o.m2144a();
                if (c1740eM2144a.hasNext()) {
                    AbstractC0032g.m162t(c1740eM2144a.next());
                    throw null;
                }
            }
            C1043n c1043n2 = c1137d.f3943m;
            AbstractC0712c abstractC0712c = c1137d.f3933c;
            AbstractC0718i abstractC0718i2 = c1137d.f3932b;
            if (c1043n2 != null) {
                Class<?> returnType = c1043n2.f3704h.getReturnType();
                if (returnType != cls2 && !returnType.isAssignableFrom(cls2) && !cls2.isAssignableFrom(returnType)) {
                    AbstractC0721l abstractC0721l4 = abstractC0712c.f1980a;
                    abstractC0718i2.mo1713k("Build method `" + c1137d.f3943m.mo2800j() + "` has wrong return type (" + AbstractC1745j.m3890m(returnType) + "), not compatible with POJO type (" + AbstractC1745j.m3895r(abstractC0721l2) + ")");
                    throw null;
                }
            } else if (!str.isEmpty()) {
                abstractC0718i2.mo1713k(AbstractC0032g.m156n("Builder class ", AbstractC1745j.m3895r(abstractC0712c.f1980a), " does not have build method (name: '", str, "')"));
                throw null;
            }
            Collection collectionValues = c1137d.f3934d.values();
            c1137d.m2949b(collectionValues);
            Map mapM2948a = c1137d.m2948a(collectionValues);
            Boolean boolM1015b = abstractC0712c.mo1800b().m1015b(EnumC0499n.f1148f);
            C0717h c0717h2 = c1137d.f3931a;
            C1149a c1149a = new C1149a(boolM1015b == null ? c0717h2.m2157l(EnumC0731v.ACCEPT_CASE_INSENSITIVE_PROPERTIES) : boolM1015b.booleanValue(), collectionValues, mapM2948a, c0717h2.f2481f.f2427m);
            c1149a.m2983c();
            boolean z4 = !c0717h2.m2157l(EnumC0731v.DEFAULT_VIEW_INCLUSION);
            if (z4) {
                z3 = z4;
            } else {
                Iterator it = collectionValues.iterator();
                while (it.hasNext()) {
                    if (((AbstractC1204t) it.next()).mo3036x()) {
                        z3 = true;
                        break;
                    }
                }
                z3 = z4;
            }
            BuilderBasedDeserializer builderBasedDeserializer = new BuilderBasedDeserializer(c1137d, c1137d.f3933c, abstractC0721l2, c1137d.f3940j != null ? c1149a.m2989i(new C1169u(c1137d.f3940j, C0702D.f1916l)) : c1149a, c1137d.f3936f, c1137d.f3937g, c1137d.f3942l, c1137d.f3938h, z3);
            if (!c0829o.m2146c()) {
                return builderBasedDeserializer;
            }
            C1740e c1740eM2144a2 = c0829o.m2144a();
            if (!c1740eM2144a2.hasNext()) {
                return builderBasedDeserializer;
            }
            AbstractC0032g.m162t(c1740eM2144a2.next());
            throw null;
        } catch (IllegalArgumentException e3) {
            throw new C0850b((Closeable) abstractC0718i.f2002k, AbstractC1745j.m3886i(e3));
        } catch (NoClassDefFoundError e4) {
            return new ErrorThrowingDeserializer(e4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:506:0x0840, code lost:
    
        if (r10.endsWith("DataSource") != false) goto L543;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0697  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x06f6  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0701  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x070e  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x0767  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x079b  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x07ac  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x07b8  */
    /* JADX WARN: Removed duplicated region for block: B:486:0x07f1  */
    /* JADX WARN: Removed duplicated region for block: B:595:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:604:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p069X0.AbstractC0722m m3016c(p069X0.AbstractC0718i r22, com.fasterxml.jackson.databind.deser.AbstractC1176k r23, p069X0.AbstractC0721l r24, p082b1.C1005A r25) throws p078a1.C0850b {
        /*
            Method dump skipped, instruction units count: 2370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.C1175j.m3016c(X0.i, com.fasterxml.jackson.databind.deser.k, X0.l, b1.A):X0.m");
    }

    /* JADX INFO: renamed from: d */
    public static boolean m3017d(AbstractC0721l abstractC0721l) {
        if (!abstractC0721l.mo1887v()) {
            return false;
        }
        AbstractC0721l abstractC0721lMo1874i = abstractC0721l.mo1874i();
        if (abstractC0721lMo1874i == null || (abstractC0721lMo1874i.f2038g == null && abstractC0721lMo1874i.f2039h == null)) {
            return abstractC0721l.mo1890y() && abstractC0721l.mo1877l().f2038g != null;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x01c2, code lost:
    
        throw new java.lang.IllegalArgumentException("Unsuitable method (" + r8 + ") decorated with @JsonCreator (for Enum type " + r11.getName() + ")");
     */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0282  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p069X0.AbstractC0730u m3018e(p069X0.AbstractC0718i r20, com.fasterxml.jackson.databind.deser.AbstractC1176k r21, p069X0.AbstractC0721l r22) throws p078a1.C0850b {
        /*
            Method dump skipped, instruction units count: 949
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.C1175j.m3018e(X0.i, com.fasterxml.jackson.databind.deser.k, X0.l):X0.u");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: a */
    public final AbstractC0722m m3019a(AbstractC0718i abstractC0718i, AbstractC1176k abstractC1176k, AbstractC0721l abstractC0721l) throws C0850b {
        try {
            AbstractC0722m abstractC0722mM3015b = m3015b(abstractC0718i, abstractC1176k, abstractC0721l);
            if (abstractC0722mM3015b == 0) {
                return null;
            }
            boolean z3 = !m3017d(abstractC0721l) && abstractC0722mM3015b.isCachable();
            if (abstractC0722mM3015b instanceof InterfaceC1179n) {
                HashMap map = this.f4040f;
                map.put(abstractC0721l, abstractC0722mM3015b);
                ((InterfaceC1179n) abstractC0722mM3015b).resolve(abstractC0718i);
                map.remove(abstractC0721l);
            }
            if (z3) {
                this.f4039e.f6129g.m3120f(abstractC0721l, abstractC0722mM3015b, false);
            }
            return abstractC0722mM3015b;
        } catch (IllegalArgumentException e3) {
            abstractC0718i.mo1713k(AbstractC1745j.m3886i(e3));
            throw null;
        }
    }

    /* JADX INFO: renamed from: f */
    public final AbstractC0722m m3020f(AbstractC0718i abstractC0718i, AbstractC1176k abstractC1176k, AbstractC0721l abstractC0721l) throws C0850b {
        AbstractC0722m abstractC0722m;
        if (abstractC0721l == null) {
            throw new IllegalArgumentException("Null JavaType passed");
        }
        AbstractC0722m abstractC0722mM3019a = m3017d(abstractC0721l) ? null : (AbstractC0722m) this.f4039e.f6129g.get(abstractC0721l);
        if (abstractC0722mM3019a == null) {
            synchronized (this.f4040f) {
                try {
                    abstractC0722mM3019a = m3017d(abstractC0721l) ? null : (AbstractC0722m) this.f4039e.f6129g.get(abstractC0721l);
                    if (abstractC0722mM3019a == null) {
                        int size = this.f4040f.size();
                        if (size <= 0 || (abstractC0722m = (AbstractC0722m) this.f4040f.get(abstractC0721l)) == null) {
                            try {
                                abstractC0722mM3019a = m3019a(abstractC0718i, abstractC1176k, abstractC0721l);
                            } finally {
                                if (size == 0 && this.f4040f.size() > 0) {
                                    this.f4040f.clear();
                                }
                            }
                        } else {
                            abstractC0722mM3019a = abstractC0722m;
                        }
                    }
                } finally {
                }
            }
            if (abstractC0722mM3019a == null) {
                Class cls = abstractC0721l.f2036e;
                Annotation[] annotationArr = AbstractC1745j.f6110a;
                if ((cls.getModifiers() & 1536) == 0) {
                    abstractC0718i.mo1713k("Cannot find a Value deserializer for type " + abstractC0721l);
                    throw null;
                }
                abstractC0718i.mo1713k("Cannot find a Value deserializer for abstract type " + abstractC0721l);
                throw null;
            }
        }
        return abstractC0722mM3019a;
    }

    public Object writeReplace() {
        this.f4040f.clear();
        return this;
    }
}
