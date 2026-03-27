package p069X0;

import com.fasterxml.jackson.databind.deser.AbstractC1135b;
import com.fasterxml.jackson.databind.deser.AbstractC1142i;
import com.fasterxml.jackson.databind.deser.AbstractC1177l;
import com.fasterxml.jackson.databind.deser.C1138e;
import com.fasterxml.jackson.databind.deser.C1141h;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import p005B.AbstractC0032g;
import p039M0.C0453A;
import p039M0.C0466N;
import p042N0.AbstractC0534b;
import p042N0.AbstractC0540h;
import p042N0.AbstractC0545m;
import p042N0.AbstractC0546n;
import p042N0.AbstractC0549q;
import p042N0.C0537e;
import p042N0.EnumC0539g;
import p042N0.EnumC0548p;
import p042N0.InterfaceC0550r;
import p042N0.InterfaceC0557y;
import p050Q0.C0596i;
import p066W0.C0680g;
import p066W0.C0690q;
import p066W0.InterfaceC0681h;
import p074Z0.AbstractC0827m;
import p074Z0.C0815a;
import p074Z0.C0818d;
import p074Z0.C0822h;
import p074Z0.C0828n;
import p074Z0.C0829o;
import p078a1.C0850b;
import p082b1.C1006B;
import p082b1.C1011G;
import p082b1.C1014J;
import p082b1.C1026W;
import p082b1.C1029Z;
import p103h1.C1425m;
import p106i1.C1448a;
import p106i1.C1449b;
import p109j1.C1512t;
import p109j1.C1515w;
import p109j1.C1517y;
import p112k1.AbstractC1640h;
import p112k1.C1637e;
import p112k1.C1639g;
import p114l1.C1675q;
import p118m1.AbstractC1745j;
import p118m1.C1727B;
import p118m1.C1752q;
import p118m1.C1761z;

/* JADX INFO: renamed from: X0.y */
/* JADX INFO: loaded from: classes.dex */
public class C0734y extends AbstractC0549q implements Serializable {

    /* JADX INFO: renamed from: n */
    public static final C0815a f2084n;
    private static final long serialVersionUID = 2;

    /* JADX INFO: renamed from: e */
    public final C0537e f2085e;

    /* JADX INFO: renamed from: f */
    public final C1675q f2086f;

    /* JADX INFO: renamed from: g */
    public final C0707I f2087g;

    /* JADX INFO: renamed from: h */
    public final AbstractC1640h f2088h;

    /* JADX INFO: renamed from: i */
    public final C1637e f2089i;

    /* JADX INFO: renamed from: j */
    public C0717h f2090j;

    /* JADX INFO: renamed from: k */
    public AbstractC1142i f2091k;

    /* JADX INFO: renamed from: l */
    public LinkedHashSet f2092l;

    /* JADX INFO: renamed from: m */
    public final ConcurrentHashMap f2093m;

    static {
        C1014J c1014j = new C1014J();
        c1014j.f3603e = new C1752q(48, 48);
        c1014j.f3604f = true;
        f2084n = new C0815a(null, c1014j, C1675q.f5933h, C1727B.f6032q, Locale.getDefault(), AbstractC0534b.f1228b, new C1011G());
    }

    public C0734y() {
        this(null);
    }

    @Override // p042N0.AbstractC0549q
    /* JADX INFO: renamed from: a */
    public InterfaceC0557y mo1221a(AbstractC0545m abstractC0545m) {
        m1911d("p", abstractC0545m);
        C0717h c0717h = this.f2090j;
        if (abstractC0545m.mo1190e() == null && abstractC0545m.mo1177V() == null) {
            return null;
        }
        AbstractC0725p abstractC0725p = (AbstractC0725p) m1914g(c0717h, abstractC0545m, this.f2086f.m3780j(AbstractC0725p.class));
        if (abstractC0725p != null) {
            return abstractC0725p;
        }
        this.f2090j.f1988r.getClass();
        return C1512t.f5463e;
    }

    @Override // p042N0.AbstractC0549q
    /* JADX INFO: renamed from: b */
    public Object mo1222b(InterfaceC0557y interfaceC0557y, Class cls) throws AbstractC0546n {
        Object obj;
        if (interfaceC0557y == null) {
            return null;
        }
        try {
            return (InterfaceC0557y.class.isAssignableFrom(cls) && cls.isAssignableFrom(interfaceC0557y.getClass())) ? interfaceC0557y : (interfaceC0557y.mo1240b() == EnumC0548p.VALUE_EMBEDDED_OBJECT && (interfaceC0557y instanceof C1515w) && ((obj = ((C1515w) interfaceC0557y).f5465e) == null || cls.isInstance(obj))) ? obj : m1917j(m1920m(interfaceC0557y), cls);
        } catch (AbstractC0546n e3) {
            throw e3;
        } catch (IOException e4) {
            throw new IllegalArgumentException(e4.getMessage(), e4);
        }
    }

    @Override // p042N0.AbstractC0549q
    /* JADX INFO: renamed from: c */
    public void mo1223c(AbstractC0540h abstractC0540h, Object obj) throws IOException {
        m1911d("g", abstractC0540h);
        C0707I c0707i = this.f2087g;
        if (c0707i.m1698r(EnumC0708J.INDENT_OUTPUT) && abstractC0540h.f1268e == null) {
            InterfaceC0550r c0680g = c0707i.f1934q;
            if (c0680g instanceof InterfaceC0681h) {
                C0680g c0680g2 = (C0680g) ((InterfaceC0681h) c0680g);
                c0680g2.getClass();
                c0680g = new C0680g(c0680g2);
            }
            abstractC0540h.f1268e = c0680g;
        }
        if (!c0707i.m1698r(EnumC0708J.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) {
            m1915h(c0707i).m3724L(abstractC0540h, obj);
            if (c0707i.m1698r(EnumC0708J.FLUSH_AFTER_WRITE_VALUE)) {
                abstractC0540h.flush();
                return;
            }
            return;
        }
        Closeable closeable = (Closeable) obj;
        try {
            m1915h(c0707i).m3724L(abstractC0540h, obj);
            if (c0707i.m1698r(EnumC0708J.FLUSH_AFTER_WRITE_VALUE)) {
                abstractC0540h.flush();
            }
            closeable.close();
        } catch (Exception e3) {
            AbstractC1745j.m3884g(null, closeable, e3);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m1911d(String str, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(AbstractC0032g.m154l("argument \"", str, "\" is null"));
        }
    }

    /* JADX INFO: renamed from: e */
    public final AbstractC0722m m1912e(C1141h c1141h, AbstractC0721l abstractC0721l) throws C0850b {
        ConcurrentHashMap concurrentHashMap = this.f2093m;
        AbstractC0722m abstractC0722m = (AbstractC0722m) concurrentHashMap.get(abstractC0721l);
        if (abstractC0722m != null) {
            return abstractC0722m;
        }
        AbstractC0722m abstractC0722mM1856u = c1141h.m1856u(abstractC0721l);
        if (abstractC0722mM1856u != null) {
            concurrentHashMap.put(abstractC0721l, abstractC0722mM1856u);
            return abstractC0722mM1856u;
        }
        c1141h.mo1713k("Cannot find a deserializer for type " + abstractC0721l);
        throw null;
    }

    /* JADX INFO: renamed from: f */
    public final Object m1913f(AbstractC0545m abstractC0545m, AbstractC0721l abstractC0721l) throws IOException {
        Object objM2975b0;
        EnumC0548p enumC0548pMo1177V;
        try {
            C0717h c0717h = this.f2090j;
            C1141h c1141h = (C1141h) this.f2091k;
            c1141h.getClass();
            C1141h c1141h2 = new C1141h(c1141h, c0717h, abstractC0545m);
            C0717h c0717h2 = this.f2090j;
            int i3 = c0717h2.f1993w;
            if (i3 != 0) {
                abstractC0545m.mo1179X(c0717h2.f1992v, i3);
            }
            int i4 = c0717h2.f1995y;
            if (i4 != 0) {
                abstractC0545m.mo1178W(c0717h2.f1994x, i4);
            }
            EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
            if (enumC0548pMo1190e == null && (enumC0548pMo1190e = abstractC0545m.mo1177V()) == null) {
                throw new C0850b(abstractC0545m, "No content to map due to end-of-input");
            }
            if (enumC0548pMo1190e == EnumC0548p.VALUE_NULL) {
                objM2975b0 = m1912e(c1141h2, abstractC0721l).getNullValue(c1141h2);
            } else if (enumC0548pMo1190e == EnumC0548p.END_ARRAY || enumC0548pMo1190e == EnumC0548p.END_OBJECT) {
                objM2975b0 = null;
            } else {
                objM2975b0 = c1141h2.m2975b0(abstractC0545m, abstractC0721l, m1912e(c1141h2, abstractC0721l), null);
                c1141h2.m2974a0();
            }
            if (!c0717h.m1820r(EnumC0719j.FAIL_ON_TRAILING_TOKENS) || (enumC0548pMo1177V = abstractC0545m.mo1177V()) == null) {
                abstractC0545m.close();
                return objM2975b0;
            }
            Annotation[] annotationArr = AbstractC1745j.f6110a;
            AbstractC0718i.m1821U(abstractC0721l == null ? null : abstractC0721l.f2036e, abstractC0545m, enumC0548pMo1177V);
            throw null;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (abstractC0545m != null) {
                    try {
                        abstractC0545m.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public final Object m1914g(C0717h c0717h, AbstractC0545m abstractC0545m, AbstractC0721l abstractC0721l) throws C0850b {
        EnumC0548p enumC0548pMo1177V;
        C0717h c0717h2 = this.f2090j;
        int i3 = c0717h2.f1993w;
        if (i3 != 0) {
            abstractC0545m.mo1179X(c0717h2.f1992v, i3);
        }
        int i4 = c0717h2.f1995y;
        if (i4 != 0) {
            abstractC0545m.mo1178W(c0717h2.f1994x, i4);
        }
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        if (enumC0548pMo1190e == null && (enumC0548pMo1190e = abstractC0545m.mo1177V()) == null) {
            throw new C0850b(abstractC0545m, "No content to map due to end-of-input");
        }
        C1141h c1141h = (C1141h) this.f2091k;
        c1141h.getClass();
        C1141h c1141h2 = new C1141h(c1141h, c0717h, abstractC0545m);
        Object nullValue = enumC0548pMo1190e == EnumC0548p.VALUE_NULL ? m1912e(c1141h2, abstractC0721l).getNullValue(c1141h2) : (enumC0548pMo1190e == EnumC0548p.END_ARRAY || enumC0548pMo1190e == EnumC0548p.END_OBJECT) ? null : c1141h2.m2975b0(abstractC0545m, abstractC0721l, m1912e(c1141h2, abstractC0721l), null);
        abstractC0545m.mo1186c();
        if (!c0717h.m1820r(EnumC0719j.FAIL_ON_TRAILING_TOKENS) || (enumC0548pMo1177V = abstractC0545m.mo1177V()) == null) {
            return nullValue;
        }
        Annotation[] annotationArr = AbstractC1745j.f6110a;
        AbstractC0718i.m1821U(abstractC0721l == null ? null : abstractC0721l.f2036e, abstractC0545m, enumC0548pMo1177V);
        throw null;
    }

    /* JADX INFO: renamed from: h */
    public final C1639g m1915h(C0707I c0707i) {
        C1637e c1637e = this.f2089i;
        C1639g c1639g = (C1639g) this.f2088h;
        c1639g.getClass();
        return new C1639g(c1639g, c0707i, c1637e);
    }

    /* JADX INFO: renamed from: i */
    public final void m1916i(AbstractC0540h abstractC0540h, Object obj) {
        C0707I c0707i = this.f2087g;
        if (c0707i.m1698r(EnumC0708J.CLOSE_CLOSEABLE) && (obj instanceof Closeable)) {
            Closeable closeable = (Closeable) obj;
            try {
                m1915h(c0707i).m3724L(abstractC0540h, obj);
            } catch (Exception e3) {
                e = e3;
            }
            try {
                closeable.close();
                abstractC0540h.close();
                return;
            } catch (Exception e4) {
                e = e4;
                closeable = null;
                AbstractC1745j.m3884g(abstractC0540h, closeable, e);
                throw null;
            }
        }
        try {
            m1915h(c0707i).m3724L(abstractC0540h, obj);
            abstractC0540h.close();
        } catch (Exception e5) {
            Annotation[] annotationArr = AbstractC1745j.f6110a;
            abstractC0540h.mo1132e(EnumC0539g.AUTO_CLOSE_JSON_CONTENT);
            try {
                abstractC0540h.close();
            } catch (Exception e6) {
                e5.addSuppressed(e6);
            }
            AbstractC1745j.m3874D(e5);
            AbstractC1745j.m3875E(e5);
            throw new RuntimeException(e5);
        }
    }

    /* JADX INFO: renamed from: j */
    public Object m1917j(AbstractC0545m abstractC0545m, Class cls) {
        m1911d("p", abstractC0545m);
        return m1914g(this.f2090j, abstractC0545m, this.f2086f.m3780j(cls));
    }

    /* JADX INFO: renamed from: k */
    public final Object m1918k(Class cls, String str) throws AbstractC0546n {
        m1911d("content", str);
        try {
            return m1913f(this.f2085e.m1101r(str), this.f2086f.m3780j(cls));
        } catch (AbstractC0546n e3) {
            throw e3;
        } catch (IOException e4) {
            throw C0724o.m1893f(e4);
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m1919l(AbstractC0733x abstractC0733x) {
        m1911d("module", abstractC0733x);
        C1449b c1449b = (C1449b) abstractC0733x;
        String str = c1449b.f5146e;
        if (str == null) {
            throw new IllegalArgumentException("Module without defined name");
        }
        if (c1449b.f5147f == null) {
            throw new IllegalArgumentException("Module without defined version");
        }
        Iterator it = Collections.emptyList().iterator();
        while (it.hasNext()) {
            m1919l((AbstractC0733x) it.next());
        }
        if (this.f2087g.m2157l(EnumC0731v.IGNORE_DUPLICATE_MODULE_REGISTRATIONS)) {
            if (this.f2092l == null) {
                this.f2092l = new LinkedHashSet();
            }
            if (!this.f2092l.add(str)) {
                return;
            }
        }
        C1448a c1448a = c1449b.f5148g;
        if (c1448a != null) {
            AbstractC1135b abstractC1135b = (AbstractC1135b) this.f2091k.f1997f;
            C0829o c0829o = abstractC1135b.f3929e;
            Object[] objArr = c0829o.f2466e;
            int length = objArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), length + 1);
                    if (length > 0) {
                        System.arraycopy(objArr, 0, objArr2, 1, length);
                    }
                    objArr2[0] = c1448a;
                    objArr = objArr2;
                } else if (objArr[i3] != c1448a) {
                    i3++;
                } else if (i3 != 0) {
                    Object[] objArr3 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), length);
                    System.arraycopy(objArr, 0, objArr3, 1, i3);
                    objArr3[0] = c1448a;
                    int i4 = i3 + 1;
                    int i5 = length - i4;
                    if (i5 > 0) {
                        System.arraycopy(objArr, i4, objArr3, i4, i5);
                    }
                    objArr = objArr3;
                }
            }
            C0829o c0829o2 = new C0829o((AbstractC1177l[]) objArr, c0829o.f2467f, c0829o.f2468g, c0829o.f2469h, c0829o.f2470i);
            C1138e c1138e = (C1138e) abstractC1135b;
            if (c1138e.f3929e != c0829o2) {
                AbstractC1745j.m3876F(C1138e.class, c1138e, "withConfig");
                c1138e = new C1138e(c0829o2);
            }
            C1141h c1141h = (C1141h) this.f2091k;
            c1141h.getClass();
            this.f2091k = new C1141h(c1141h, c1138e);
        }
    }

    /* JADX INFO: renamed from: m */
    public AbstractC0545m m1920m(InterfaceC0557y interfaceC0557y) {
        m1911d("n", interfaceC0557y);
        return new C1517y((AbstractC0725p) interfaceC0557y, this);
    }

    /* JADX INFO: renamed from: n */
    public final String m1921n(Object obj) throws AbstractC0546n {
        C0537e c0537e = this.f2085e;
        C0596i c0596i = new C0596i(c0537e.m1095l());
        try {
            AbstractC0540h abstractC0540hM1099p = c0537e.m1099p(c0596i);
            this.f2087g.m1696p(abstractC0540hM1099p);
            m1916i(abstractC0540hM1099p, obj);
            C0690q c0690q = c0596i.f1529e;
            String strM1655h = c0690q.m1655h();
            c0690q.m1661n();
            return strM1655h;
        } catch (AbstractC0546n e3) {
            throw e3;
        } catch (IOException e4) {
            throw C0724o.m1893f(e4);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public C0734y(C0537e c0537e) {
        C0707I c0707iM1695o;
        C0717h c0717hM1817o;
        this.f2093m = new ConcurrentHashMap(64, 0.6f, 2);
        if (c0537e == null) {
            this.f2085e = new C0732w(this);
        } else {
            this.f2085e = c0537e;
            if (c0537e.mo1103t() == null) {
                c0537e.m1105v(this);
            }
        }
        C1425m c1425m = new C1425m();
        C1761z c1761z = new C1761z();
        this.f2086f = C1675q.f5933h;
        C1026W c1026w = new C1026W();
        C1006B c1006b = new C1006B();
        C0815a c0815a = f2084n;
        C0815a c0815a2 = c0815a.f2420f == c1006b ? c0815a : new C0815a(c1006b, (C1014J) c0815a.f2421g, c0815a.f2419e, c0815a.f2426l, c0815a.f2427m, c0815a.f2429o, (C1011G) c0815a.f2423i);
        C0453A c0453a = C0453A.f1095i;
        C0466N c0466n = C0466N.f1104g;
        C1029Z c1029z = C1029Z.f3655j;
        C0822h c0822h = new C0822h();
        c0822h.f2447e = null;
        c0822h.f2448f = c0453a;
        c0822h.f2449g = c0466n;
        c0822h.f2450h = c1029z;
        c0822h.f2451i = null;
        c0822h.f2452j = null;
        C0818d c0818d = new C0818d();
        C0828n c0828n = AbstractC0827m.f2458a;
        this.f2087g = new C0707I(c0815a2, c1425m, c1026w, c1761z, c0822h, c0828n);
        this.f2090j = new C0717h(c0815a2, c1425m, c1026w, c1761z, c0822h, c0818d, c0828n);
        boolean zM1104u = this.f2085e.m1104u();
        C0707I c0707i = this.f2087g;
        EnumC0731v enumC0731v = EnumC0731v.SORT_PROPERTIES_ALPHABETICALLY;
        if (c0707i.m2157l(enumC0731v) ^ zM1104u) {
            int i3 = 0;
            if (zM1104u) {
                C0707I c0707i2 = this.f2087g;
                EnumC0731v[] enumC0731vArr = {enumC0731v};
                c0707i2.getClass();
                long j2 = c0707i2.f2480e;
                long j3 = j2;
                for (int i4 = 0; i4 < 1; i4++) {
                    j3 |= enumC0731vArr[i4].f2083f;
                }
                c0707iM1695o = c0707i2;
                if (j3 != j2) {
                    c0707iM1695o = c0707i2.m1695o(j3);
                }
            } else {
                C0707I c0707i3 = this.f2087g;
                EnumC0731v[] enumC0731vArr2 = {enumC0731v};
                c0707i3.getClass();
                long j4 = c0707i3.f2480e;
                long j5 = j4;
                for (int i5 = 0; i5 < 1; i5++) {
                    j5 &= ~enumC0731vArr2[i5].f2083f;
                }
                c0707iM1695o = c0707i3;
                if (j5 != j4) {
                    c0707iM1695o = c0707i3.m1695o(j5);
                }
            }
            this.f2087g = c0707iM1695o;
            if (zM1104u) {
                C0717h c0717h = this.f2090j;
                EnumC0731v[] enumC0731vArr3 = {enumC0731v};
                c0717h.getClass();
                long j6 = c0717h.f2480e;
                long j7 = j6;
                while (i3 < 1) {
                    j7 |= enumC0731vArr3[i3].f2083f;
                    i3++;
                }
                c0717hM1817o = c0717h;
                if (j7 != j6) {
                    c0717hM1817o = c0717h.m1817o(j7);
                }
            } else {
                C0717h c0717h2 = this.f2090j;
                EnumC0731v[] enumC0731vArr4 = {enumC0731v};
                c0717h2.getClass();
                long j8 = c0717h2.f2480e;
                long j9 = j8;
                while (i3 < 1) {
                    j9 &= ~enumC0731vArr4[i3].f2083f;
                    i3++;
                }
                c0717hM1817o = c0717h2;
                if (j9 != j8) {
                    c0717hM1817o = c0717h2.m1817o(j9);
                }
            }
            this.f2090j = c0717hM1817o;
        }
        this.f2088h = new C1639g();
        this.f2091k = new C1141h(C1138e.f3945g);
        this.f2089i = C1637e.f5835h;
    }
}
