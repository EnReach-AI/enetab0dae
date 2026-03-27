package p069X0;

import com.fasterxml.jackson.databind.deser.impl.C1160l;
import com.fasterxml.jackson.databind.ser.impl.C1224l;
import com.fasterxml.jackson.databind.ser.impl.C1225m;
import com.fasterxml.jackson.databind.ser.impl.C1227o;
import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;
import com.fasterxml.jackson.databind.ser.impl.TypeWrappedSerializer;
import com.fasterxml.jackson.databind.ser.impl.UnknownSerializer;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import java.text.DateFormat;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import p001A.C0009j;
import p005B.AbstractC0032g;
import p039M0.AbstractC0485d0;
import p042N0.AbstractC0540h;
import p074Z0.AbstractC0825k;
import p074Z0.AbstractC0832r;
import p074Z0.C0824j;
import p078a1.C0850b;
import p078a1.C0853e;
import p082b1.AbstractC1007C;
import p082b1.AbstractC1031b;
import p082b1.C1005A;
import p082b1.C1033d;
import p103h1.AbstractC1431s;
import p112k1.AbstractC1634b;
import p112k1.AbstractC1640h;
import p112k1.AbstractC1644l;
import p112k1.C1637e;
import p112k1.InterfaceC1638f;
import p112k1.InterfaceC1643k;
import p114l1.C1675q;
import p118m1.AbstractC1745j;
import p118m1.C1732G;
import p118m1.C1752q;
import p118m1.InterfaceC1748m;

/* JADX INFO: renamed from: X0.K */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0709K extends AbstractC0715f {

    /* JADX INFO: renamed from: q */
    public static final FailingSerializer f1964q = new FailingSerializer("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");

    /* JADX INFO: renamed from: r */
    public static final UnknownSerializer f1965r = new UnknownSerializer();

    /* JADX INFO: renamed from: e */
    public final C0707I f1966e;

    /* JADX INFO: renamed from: f */
    public final Class f1967f;

    /* JADX INFO: renamed from: g */
    public final AbstractC1644l f1968g;

    /* JADX INFO: renamed from: h */
    public final C0009j f1969h;

    /* JADX INFO: renamed from: i */
    public transient AbstractC0825k f1970i;

    /* JADX INFO: renamed from: j */
    public final AbstractC0728s f1971j;

    /* JADX INFO: renamed from: k */
    public final AbstractC0728s f1972k;

    /* JADX INFO: renamed from: l */
    public final AbstractC0728s f1973l;

    /* JADX INFO: renamed from: m */
    public final AbstractC0728s f1974m;

    /* JADX INFO: renamed from: n */
    public final C1225m f1975n;

    /* JADX INFO: renamed from: o */
    public DateFormat f1976o;

    /* JADX INFO: renamed from: p */
    public final boolean f1977p;

    public AbstractC0709K() {
        this.f1971j = f1965r;
        this.f1973l = NullSerializer.instance;
        this.f1974m = f1964q;
        this.f1966e = null;
        this.f1968g = null;
        this.f1969h = new C0009j(24);
        this.f1975n = null;
        this.f1967f = null;
        this.f1970i = null;
        this.f1977p = true;
    }

    /* JADX INFO: renamed from: A */
    public final Object m1701A(Object obj) {
        Object obj2;
        C0824j c0824j = (C0824j) this.f1970i;
        Map map = c0824j.f2457f;
        if (map == null || (obj2 = map.get(obj)) == null) {
            return c0824j.f2456e.get(obj);
        }
        if (obj2 == C0824j.f2455h) {
            return null;
        }
        return obj2;
    }

    /* JADX INFO: renamed from: B */
    public final AbstractC0728s m1702B(Class cls) {
        return cls == Object.class ? this.f1971j : new UnknownSerializer(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: C */
    public final AbstractC0728s m1703C(AbstractC0728s abstractC0728s, InterfaceC0714e interfaceC0714e) {
        return (abstractC0728s == 0 || !(abstractC0728s instanceof InterfaceC1638f)) ? abstractC0728s : ((InterfaceC1638f) abstractC0728s).createContextual(this, interfaceC0714e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: D */
    public final AbstractC0728s m1704D(AbstractC0728s abstractC0728s, InterfaceC0714e interfaceC0714e) {
        return (abstractC0728s == 0 || !(abstractC0728s instanceof InterfaceC1638f)) ? abstractC0728s : ((InterfaceC1638f) abstractC0728s).createContextual(this, interfaceC0714e);
    }

    /* JADX INFO: renamed from: E */
    public abstract Object mo1705E(Class cls);

    /* JADX INFO: renamed from: F */
    public abstract boolean mo1706F(Object obj);

    /* JADX INFO: renamed from: G */
    public final void m1707G(C1005A c1005a, AbstractC1007C abstractC1007C, String str, Object... objArr) throws C0850b {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        throw new C0850b(((AbstractC1640h) this).f5838u, "Invalid definition for property " + AbstractC0715f.m1810b(abstractC1007C.mo1808f()) + " (of type " + AbstractC1745j.m3903z(c1005a.f1980a.f2036e) + "): " + str);
    }

    /* JADX INFO: renamed from: H */
    public final void m1708H(AbstractC0712c abstractC0712c, String str, Object... objArr) throws C0850b {
        String strM3903z = AbstractC1745j.m3903z(abstractC0712c.f1980a.f2036e);
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        throw new C0850b(((AbstractC1640h) this).f5838u, AbstractC0032g.m155m("Invalid type definition for type ", strM3903z, ": ", str));
    }

    /* JADX INFO: renamed from: I */
    public abstract AbstractC0728s mo1709I(AbstractC1031b abstractC1031b, Object obj);

    @Override // p069X0.AbstractC0715f
    /* JADX INFO: renamed from: e */
    public final AbstractC0832r mo1710e() {
        return this.f1966e;
    }

    @Override // p069X0.AbstractC0715f
    /* JADX INFO: renamed from: f */
    public final C1675q mo1711f() {
        return this.f1966e.f2481f.f2419e;
    }

    @Override // p069X0.AbstractC0715f
    /* JADX INFO: renamed from: g */
    public final C0853e mo1712g(AbstractC0721l abstractC0721l, String str, String str2) {
        return new C0853e(null, AbstractC0715f.m1809a("Could not resolve type id '" + str + "' as a subtype of " + AbstractC1745j.m3895r(abstractC0721l), str2));
    }

    @Override // p069X0.AbstractC0715f
    /* JADX INFO: renamed from: k */
    public final Object mo1713k(String str) throws C0850b {
        throw new C0850b(((AbstractC1640h) this).f5838u, str);
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
    /* JADX INFO: renamed from: l */
    public final AbstractC0728s m1714l(AbstractC0721l abstractC0721l) throws C0724o {
        try {
            AbstractC0728s abstractC0728sM1716n = m1716n(abstractC0721l);
            if (abstractC0728sM1716n != 0) {
                C0009j c0009j = this.f1969h;
                synchronized (c0009j) {
                    try {
                        C1752q c1752q = (C1752q) c0009j.f30f;
                        if (c1752q.f6129g.m3120f(new C1732G(abstractC0721l, false), abstractC0728sM1716n, false) == null) {
                            ((AtomicReference) c0009j.f31g).set(null);
                        }
                        if (abstractC0728sM1716n instanceof InterfaceC1643k) {
                            ((InterfaceC1643k) abstractC0728sM1716n).resolve(this);
                        }
                    } finally {
                    }
                }
            }
            return abstractC0728sM1716n;
        } catch (IllegalArgumentException e3) {
            throw new C0724o(((AbstractC1640h) this).f5838u, AbstractC1745j.m3886i(e3), e3);
        }
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
    /* JADX INFO: renamed from: m */
    public final AbstractC0728s m1715m(Class cls) throws C0850b {
        AbstractC0721l abstractC0721lM2148c = this.f1966e.m2148c(cls);
        try {
            AbstractC0728s abstractC0728sM1716n = m1716n(abstractC0721lM2148c);
            if (abstractC0728sM1716n != 0) {
                C0009j c0009j = this.f1969h;
                synchronized (c0009j) {
                    try {
                        C1752q c1752q = (C1752q) c0009j.f30f;
                        Object objM3120f = c1752q.f6129g.m3120f(new C1732G(cls, false), abstractC0728sM1716n, false);
                        C1752q c1752q2 = (C1752q) c0009j.f30f;
                        Object objM3120f2 = c1752q2.f6129g.m3120f(new C1732G(abstractC0721lM2148c, false), abstractC0728sM1716n, false);
                        if (objM3120f == null || objM3120f2 == null) {
                            ((AtomicReference) c0009j.f31g).set(null);
                        }
                        if (abstractC0728sM1716n instanceof InterfaceC1643k) {
                            ((InterfaceC1643k) abstractC0728sM1716n).resolve(this);
                        }
                    } finally {
                    }
                }
            }
            return abstractC0728sM1716n;
        } catch (IllegalArgumentException e3) {
            mo1713k(AbstractC1745j.m3886i(e3));
            throw null;
        }
    }

    /* JADX INFO: renamed from: n */
    public final AbstractC0728s m1716n(AbstractC0721l abstractC0721l) throws C0850b {
        AbstractC0721l abstractC0721lMo1788q0;
        C1637e c1637e = (C1637e) this.f1968g;
        c1637e.getClass();
        C0707I c0707i = this.f1966e;
        C1005A c1005aM1697q = c0707i.m1697q(abstractC0721l);
        C1033d c1033d = c1005aM1697q.f3582e;
        AbstractC0728s abstractC0728sM3711e = AbstractC1634b.m3711e(this, c1033d);
        if (abstractC0728sM3711e != null) {
            return abstractC0728sM3711e;
        }
        AbstractC0711b abstractC0711bM2149d = c0707i.m2149d();
        boolean z3 = false;
        if (abstractC0711bM2149d == null) {
            abstractC0721lMo1788q0 = abstractC0721l;
        } else {
            try {
                abstractC0721lMo1788q0 = abstractC0711bM2149d.mo1788q0(c0707i, c1033d, abstractC0721l);
            } catch (C0724o e3) {
                m1708H(c1005aM1697q, e3.getMessage(), new Object[0]);
                throw null;
            }
        }
        if (abstractC0721lMo1788q0 != abstractC0721l) {
            if (!abstractC0721lMo1788q0.m1883r(abstractC0721l.f2036e)) {
                c1005aM1697q = c0707i.m1697q(abstractC0721lMo1788q0);
            }
            z3 = true;
        }
        AbstractC0711b abstractC0711b = c1005aM1697q.f3581d;
        InterfaceC1748m interfaceC1748mM2697e = abstractC0711b != null ? c1005aM1697q.m2697e(abstractC0711b.mo1746R(c1005aM1697q.f3582e)) : null;
        if (interfaceC1748mM2697e == null) {
            return c1637e.m3720h(this, abstractC0721lMo1788q0, c1005aM1697q, z3);
        }
        mo1711f();
        Class cls = abstractC0721lMo1788q0.f2036e;
        AbstractC0721l abstractC0721l2 = ((C1160l) interfaceC1748mM2697e).f4009a;
        if (!abstractC0721l2.m1883r(cls)) {
            c1005aM1697q = c0707i.m1697q(abstractC0721l2);
            abstractC0728sM3711e = AbstractC1634b.m3711e(this, c1005aM1697q.f3582e);
        }
        if (abstractC0728sM3711e == null && !abstractC0721l2.m1889x()) {
            abstractC0728sM3711e = c1637e.m3720h(this, abstractC0721l2, c1005aM1697q, true);
        }
        return new StdDelegatingSerializer(interfaceC1748mM2697e, abstractC0721l2, abstractC0728sM3711e);
    }

    /* JADX INFO: renamed from: o */
    public final DateFormat m1717o() {
        DateFormat dateFormat = this.f1976o;
        if (dateFormat != null) {
            return dateFormat;
        }
        DateFormat dateFormat2 = (DateFormat) this.f1966e.f2481f.f2426l.clone();
        this.f1976o = dateFormat2;
        return dateFormat2;
    }

    /* JADX INFO: renamed from: p */
    public final AbstractC0721l m1718p(AbstractC0721l abstractC0721l, Class cls) {
        return abstractC0721l.m1883r(cls) ? abstractC0721l : this.f1966e.f2481f.f2419e.m3779i(abstractC0721l, cls, true);
    }

    /* JADX INFO: renamed from: q */
    public final void m1719q(AbstractC0540h abstractC0540h) {
        if (this.f1977p) {
            abstractC0540h.mo1146s();
        } else {
            this.f1973l.serialize(null, abstractC0540h, this);
        }
    }

    /* JADX INFO: renamed from: r */
    public final AbstractC0728s m1720r(AbstractC0721l abstractC0721l, InterfaceC0714e interfaceC0714e) {
        AbstractC0728s abstractC0728sM3094a = this.f1975n.m3094a(abstractC0721l);
        return (abstractC0728sM3094a == null && (abstractC0728sM3094a = this.f1969h.m39Q(abstractC0721l)) == null && (abstractC0728sM3094a = m1714l(abstractC0721l)) == null) ? m1702B(abstractC0721l.f2036e) : m1704D(abstractC0728sM3094a, interfaceC0714e);
    }

    /* JADX INFO: renamed from: s */
    public final AbstractC0728s m1721s(Class cls, InterfaceC0714e interfaceC0714e) {
        AbstractC0728s abstractC0728sM3095b = this.f1975n.m3095b(cls);
        if (abstractC0728sM3095b == null) {
            C0009j c0009j = this.f1969h;
            AbstractC0728s abstractC0728sM40R = c0009j.m40R(cls);
            if (abstractC0728sM40R == null) {
                abstractC0728sM3095b = c0009j.m39Q(this.f1966e.m2148c(cls));
                if (abstractC0728sM3095b == null && (abstractC0728sM3095b = m1715m(cls)) == null) {
                    return m1702B(cls);
                }
            } else {
                abstractC0728sM3095b = abstractC0728sM40R;
            }
        }
        return m1704D(abstractC0728sM3095b, interfaceC0714e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: t */
    public final AbstractC0728s m1722t(AbstractC0721l abstractC0721l, InterfaceC0714e interfaceC0714e) {
        AbstractC0728s abstractC0728sMo3713a = this.f1968g.mo3713a(this, abstractC0721l, this.f1972k);
        if (abstractC0728sMo3713a instanceof InterfaceC1643k) {
            ((InterfaceC1643k) abstractC0728sMo3713a).resolve(this);
        }
        return m1704D(abstractC0728sMo3713a, interfaceC0714e);
    }

    /* JADX INFO: renamed from: u */
    public abstract C1227o mo1723u(Object obj, AbstractC0485d0 abstractC0485d0);

    /* JADX INFO: renamed from: v */
    public final AbstractC0728s m1724v(AbstractC0721l abstractC0721l, InterfaceC0714e interfaceC0714e) {
        AbstractC0728s abstractC0728sM3094a = this.f1975n.m3094a(abstractC0721l);
        return (abstractC0728sM3094a == null && (abstractC0728sM3094a = this.f1969h.m39Q(abstractC0721l)) == null && (abstractC0728sM3094a = m1714l(abstractC0721l)) == null) ? m1702B(abstractC0721l.f2036e) : m1703C(abstractC0728sM3094a, interfaceC0714e);
    }

    /* JADX INFO: renamed from: w */
    public final AbstractC0728s m1725w(Class cls, InterfaceC0714e interfaceC0714e) {
        AbstractC0728s abstractC0728sM3095b = this.f1975n.m3095b(cls);
        if (abstractC0728sM3095b == null) {
            C0009j c0009j = this.f1969h;
            AbstractC0728s abstractC0728sM40R = c0009j.m40R(cls);
            if (abstractC0728sM40R == null) {
                abstractC0728sM3095b = c0009j.m39Q(this.f1966e.m2148c(cls));
                if (abstractC0728sM3095b == null && (abstractC0728sM3095b = m1715m(cls)) == null) {
                    return m1702B(cls);
                }
            } else {
                abstractC0728sM3095b = abstractC0728sM40R;
            }
        }
        return m1703C(abstractC0728sM3095b, interfaceC0714e);
    }

    /* JADX INFO: renamed from: x */
    public final AbstractC0728s m1726x(Class cls) {
        AbstractC0728s abstractC0728s;
        AbstractC0728s abstractC0728s2;
        C1225m c1225m = this.f1975n;
        c1225m.getClass();
        C1224l c1224l = c1225m.f4152a[(cls.getName().hashCode() + 1) & c1225m.f4153b];
        if (c1224l == null) {
            abstractC0728s = null;
        } else if (c1224l.f4149c != cls || !c1224l.f4151e) {
            while (true) {
                c1224l = c1224l.f4148b;
                if (c1224l == null) {
                    break;
                }
                if (c1224l.f4149c == cls && c1224l.f4151e) {
                    abstractC0728s = c1224l.f4147a;
                    break;
                }
            }
        } else {
            abstractC0728s = c1224l.f4147a;
        }
        if (abstractC0728s != null) {
            return abstractC0728s;
        }
        C0009j c0009j = this.f1969h;
        synchronized (c0009j) {
            abstractC0728s2 = (AbstractC0728s) ((C1752q) c0009j.f30f).f6129g.get(new C1732G(cls, true));
        }
        if (abstractC0728s2 != null) {
            return abstractC0728s2;
        }
        AbstractC0728s abstractC0728sM1728z = m1728z(cls, null);
        AbstractC1644l abstractC1644l = this.f1968g;
        C0707I c0707i = this.f1966e;
        AbstractC1431s abstractC1431sMo3714b = abstractC1644l.mo3714b(c0707i, c0707i.m2148c(cls));
        if (abstractC1431sMo3714b != null) {
            abstractC0728sM1728z = new TypeWrappedSerializer(abstractC1431sMo3714b.mo3422g(null), abstractC0728sM1728z);
        }
        C0009j c0009j2 = this.f1969h;
        synchronized (c0009j2) {
            try {
                if (((C1752q) c0009j2.f30f).f6129g.m3120f(new C1732G(cls, true), abstractC0728sM1728z, false) == null) {
                    ((AtomicReference) c0009j2.f31g).set(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return abstractC0728sM1728z;
    }

    /* JADX INFO: renamed from: y */
    public final AbstractC0728s m1727y(AbstractC0721l abstractC0721l, InterfaceC0714e interfaceC0714e) throws C0724o {
        if (abstractC0721l == null) {
            throw new C0724o(((AbstractC1640h) this).f5838u, "Null passed for `valueType` of `findValueSerializer()`", (Throwable) null);
        }
        AbstractC0728s abstractC0728sM3094a = this.f1975n.m3094a(abstractC0721l);
        return (abstractC0728sM3094a == null && (abstractC0728sM3094a = this.f1969h.m39Q(abstractC0721l)) == null && (abstractC0728sM3094a = m1714l(abstractC0721l)) == null) ? m1702B(abstractC0721l.f2036e) : m1704D(abstractC0728sM3094a, interfaceC0714e);
    }

    /* JADX INFO: renamed from: z */
    public final AbstractC0728s m1728z(Class cls, InterfaceC0714e interfaceC0714e) {
        AbstractC0728s abstractC0728sM3095b = this.f1975n.m3095b(cls);
        if (abstractC0728sM3095b == null) {
            C0009j c0009j = this.f1969h;
            AbstractC0728s abstractC0728sM40R = c0009j.m40R(cls);
            if (abstractC0728sM40R == null) {
                abstractC0728sM3095b = c0009j.m39Q(this.f1966e.m2148c(cls));
                if (abstractC0728sM3095b == null && (abstractC0728sM3095b = m1715m(cls)) == null) {
                    return m1702B(cls);
                }
            } else {
                abstractC0728sM3095b = abstractC0728sM40R;
            }
        }
        return m1704D(abstractC0728sM3095b, interfaceC0714e);
    }

    public AbstractC0709K(AbstractC0709K abstractC0709K, C0707I c0707i, AbstractC1644l abstractC1644l) {
        this.f1971j = f1965r;
        this.f1973l = NullSerializer.instance;
        FailingSerializer failingSerializer = f1964q;
        this.f1974m = failingSerializer;
        this.f1968g = abstractC1644l;
        this.f1966e = c0707i;
        C0009j c0009j = abstractC0709K.f1969h;
        this.f1969h = c0009j;
        this.f1971j = abstractC0709K.f1971j;
        this.f1972k = abstractC0709K.f1972k;
        AbstractC0728s abstractC0728s = abstractC0709K.f1973l;
        this.f1973l = abstractC0728s;
        this.f1974m = abstractC0709K.f1974m;
        this.f1977p = abstractC0728s == failingSerializer;
        this.f1967f = c0707i.f2487j;
        this.f1970i = c0707i.f2488k;
        C1225m c1225m = (C1225m) ((AtomicReference) c0009j.f31g).get();
        if (c1225m == null) {
            synchronized (c0009j) {
                c1225m = (C1225m) ((AtomicReference) c0009j.f31g).get();
                if (c1225m == null) {
                    C1225m c1225m2 = new C1225m((C1752q) c0009j.f30f);
                    ((AtomicReference) c0009j.f31g).set(c1225m2);
                    c1225m = c1225m2;
                }
            }
        }
        this.f1975n = c1225m;
    }
}
