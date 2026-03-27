package p069X0;

import com.fasterxml.jackson.databind.deser.AbstractC1142i;
import com.fasterxml.jackson.databind.deser.C1141h;
import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.concurrent.ConcurrentHashMap;
import p005B.AbstractC0032g;
import p042N0.AbstractC0535c;
import p042N0.AbstractC0540h;
import p042N0.AbstractC0545m;
import p042N0.AbstractC0546n;
import p042N0.AbstractC0549q;
import p042N0.C0537e;
import p042N0.EnumC0548p;
import p042N0.InterfaceC0557y;
import p047P0.C0575b;
import p078a1.C0850b;
import p088d1.C1306a;
import p109j1.C1512t;
import p109j1.C1517y;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: X0.z */
/* JADX INFO: loaded from: classes.dex */
public final class C0735z extends AbstractC0549q implements Serializable {
    private static final long serialVersionUID = 2;

    /* JADX INFO: renamed from: e */
    public final C0717h f2094e;

    /* JADX INFO: renamed from: f */
    public final AbstractC1142i f2095f;

    /* JADX INFO: renamed from: g */
    public final C0537e f2096g;

    /* JADX INFO: renamed from: h */
    public final C0575b f2097h;

    /* JADX INFO: renamed from: i */
    public final AbstractC0721l f2098i;

    /* JADX INFO: renamed from: j */
    public final AbstractC0722m f2099j;

    /* JADX INFO: renamed from: k */
    public final Object f2100k;

    /* JADX INFO: renamed from: l */
    public final ConcurrentHashMap f2101l;

    /* JADX INFO: renamed from: m */
    public transient AbstractC0721l f2102m;

    public C0735z(C1306a c1306a, C0717h c0717h, AbstractC0721l abstractC0721l) {
        this.f2094e = c0717h;
        this.f2095f = c1306a.f2091k;
        this.f2101l = c1306a.f2093m;
        this.f2096g = c1306a.f2085e;
        this.f2098i = abstractC0721l;
        this.f2100k = null;
        C0703E c0703e = c0717h.f2486i;
        if (c0703e != null) {
            c0703e.m1688c();
        } else {
            c0717h.m1820r(EnumC0719j.UNWRAP_ROOT_VALUE);
        }
        this.f2099j = m1926h(abstractC0721l);
        this.f2097h = null;
    }

    @Override // p042N0.AbstractC0549q
    /* JADX INFO: renamed from: a */
    public final InterfaceC0557y mo1221a(AbstractC0545m abstractC0545m) throws C0850b {
        InterfaceC0557y interfaceC0557y;
        m1922d("p", abstractC0545m);
        Object obj = this.f2100k;
        if (obj != null) {
            return (AbstractC0725p) m1923e(abstractC0545m, obj);
        }
        C0717h c0717h = this.f2094e;
        int i3 = c0717h.f1993w;
        if (i3 != 0) {
            abstractC0545m.mo1179X(c0717h.f1992v, i3);
        }
        int i4 = c0717h.f1995y;
        if (i4 != 0) {
            abstractC0545m.mo1178W(c0717h.f1994x, i4);
        }
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        if (enumC0548pMo1190e == null && (enumC0548pMo1190e = abstractC0545m.mo1177V()) == null) {
            return null;
        }
        C1141h c1141h = (C1141h) this.f2095f;
        c1141h.getClass();
        C1141h c1141h2 = new C1141h(c1141h, c0717h, abstractC0545m);
        if (enumC0548pMo1190e == EnumC0548p.VALUE_NULL) {
            c0717h.f1988r.getClass();
            interfaceC0557y = C1512t.f5463e;
        } else {
            AbstractC0721l abstractC0721lM1925g = m1925g();
            AbstractC0721l abstractC0721lM1925g2 = m1925g();
            ConcurrentHashMap concurrentHashMap = this.f2101l;
            AbstractC0722m abstractC0722mM1856u = (AbstractC0722m) concurrentHashMap.get(abstractC0721lM1925g2);
            if (abstractC0722mM1856u == null) {
                abstractC0722mM1856u = c1141h2.m1856u(abstractC0721lM1925g2);
                if (abstractC0722mM1856u == null) {
                    c1141h2.mo1713k("Cannot find a deserializer for type " + abstractC0721lM1925g2);
                    throw null;
                }
                concurrentHashMap.put(abstractC0721lM1925g2, abstractC0722mM1856u);
            }
            interfaceC0557y = (AbstractC0725p) c1141h2.m2975b0(abstractC0545m, abstractC0721lM1925g, abstractC0722mM1856u, null);
        }
        abstractC0545m.mo1186c();
        if (c0717h.m1820r(EnumC0719j.FAIL_ON_TRAILING_TOKENS)) {
            m1927i(abstractC0545m, c1141h2, m1925g());
        }
        return interfaceC0557y;
    }

    @Override // p042N0.AbstractC0549q
    /* JADX INFO: renamed from: b */
    public final Object mo1222b(InterfaceC0557y interfaceC0557y, Class cls) throws AbstractC0546n {
        try {
            return m1928j(m1929k(interfaceC0557y), cls);
        } catch (AbstractC0546n e3) {
            throw e3;
        } catch (IOException e4) {
            throw C0724o.m1893f(e4);
        }
    }

    @Override // p042N0.AbstractC0549q
    /* JADX INFO: renamed from: c */
    public final void mo1223c(AbstractC0540h abstractC0540h, Object obj) {
        throw new UnsupportedOperationException("Not implemented for ObjectReader");
    }

    /* JADX INFO: renamed from: d */
    public final void m1922d(String str, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(AbstractC0032g.m154l("argument \"", str, "\" is null"));
        }
    }

    /* JADX INFO: renamed from: e */
    public final Object m1923e(AbstractC0545m abstractC0545m, Object obj) throws C0850b {
        C1141h c1141h = (C1141h) this.f2095f;
        c1141h.getClass();
        C0717h c0717h = this.f2094e;
        C1141h c1141h2 = new C1141h(c1141h, c0717h, abstractC0545m);
        int i3 = c0717h.f1993w;
        if (i3 != 0) {
            abstractC0545m.mo1179X(c0717h.f1992v, i3);
        }
        int i4 = c0717h.f1995y;
        if (i4 != 0) {
            abstractC0545m.mo1178W(c0717h.f1994x, i4);
        }
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        if (enumC0548pMo1190e == null && (enumC0548pMo1190e = abstractC0545m.mo1177V()) == null) {
            c1141h2.m1842T("No content to map due to end-of-input", new Object[0]);
            throw null;
        }
        EnumC0548p enumC0548p = EnumC0548p.VALUE_NULL;
        AbstractC0721l abstractC0721l = this.f2098i;
        if (enumC0548pMo1190e == enumC0548p) {
            if (obj == null) {
                obj = m1924f(c1141h2).getNullValue(c1141h2);
            }
        } else if (enumC0548pMo1190e != EnumC0548p.END_ARRAY && enumC0548pMo1190e != EnumC0548p.END_OBJECT) {
            obj = c1141h2.m2975b0(abstractC0545m, abstractC0721l, m1924f(c1141h2), this.f2100k);
        }
        abstractC0545m.mo1186c();
        if (c0717h.m1820r(EnumC0719j.FAIL_ON_TRAILING_TOKENS)) {
            m1927i(abstractC0545m, c1141h2, abstractC0721l);
        }
        return obj;
    }

    /* JADX INFO: renamed from: f */
    public final AbstractC0722m m1924f(C1141h c1141h) throws C0850b {
        AbstractC0722m abstractC0722m = this.f2099j;
        if (abstractC0722m != null) {
            return abstractC0722m;
        }
        AbstractC0721l abstractC0721l = this.f2098i;
        if (abstractC0721l == null) {
            c1141h.mo1713k("No value type configured for ObjectReader");
            throw null;
        }
        ConcurrentHashMap concurrentHashMap = this.f2101l;
        AbstractC0722m abstractC0722m2 = (AbstractC0722m) concurrentHashMap.get(abstractC0721l);
        if (abstractC0722m2 != null) {
            return abstractC0722m2;
        }
        AbstractC0722m abstractC0722mM1856u = c1141h.m1856u(abstractC0721l);
        if (abstractC0722mM1856u != null) {
            concurrentHashMap.put(abstractC0721l, abstractC0722mM1856u);
            return abstractC0722mM1856u;
        }
        c1141h.mo1713k("Cannot find a deserializer for type " + abstractC0721l);
        throw null;
    }

    /* JADX INFO: renamed from: g */
    public final AbstractC0721l m1925g() {
        AbstractC0721l abstractC0721l = this.f2102m;
        if (abstractC0721l != null) {
            return abstractC0721l;
        }
        AbstractC0721l abstractC0721lM3780j = this.f2094e.f2481f.f2419e.m3780j(AbstractC0725p.class);
        this.f2102m = abstractC0721lM3780j;
        return abstractC0721lM3780j;
    }

    /* JADX INFO: renamed from: h */
    public final AbstractC0722m m1926h(AbstractC0721l abstractC0721l) {
        if (abstractC0721l == null) {
            return null;
        }
        EnumC0719j enumC0719j = EnumC0719j.EAGER_DESERIALIZER_FETCH;
        C0717h c0717h = this.f2094e;
        if (!c0717h.m1820r(enumC0719j)) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = this.f2101l;
        AbstractC0722m abstractC0722mM1856u = (AbstractC0722m) concurrentHashMap.get(abstractC0721l);
        if (abstractC0722mM1856u == null) {
            try {
                C1141h c1141h = (C1141h) this.f2095f;
                c1141h.getClass();
                abstractC0722mM1856u = new C1141h(c1141h, c0717h).m1856u(abstractC0721l);
                if (abstractC0722mM1856u != null) {
                    concurrentHashMap.put(abstractC0721l, abstractC0722mM1856u);
                }
            } catch (AbstractC0535c unused) {
            }
        }
        return abstractC0722mM1856u;
    }

    /* JADX INFO: renamed from: i */
    public final void m1927i(AbstractC0545m abstractC0545m, C1141h c1141h, AbstractC0721l abstractC0721l) throws C0850b {
        Object obj;
        EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
        if (enumC0548pMo1177V != null) {
            Annotation[] annotationArr = AbstractC1745j.f6110a;
            Class<?> cls = abstractC0721l == null ? null : abstractC0721l.f2036e;
            if (cls == null && (obj = this.f2100k) != null) {
                cls = obj.getClass();
            }
            AbstractC0718i.m1821U(cls, abstractC0545m, enumC0548pMo1177V);
            throw null;
        }
    }

    /* JADX INFO: renamed from: j */
    public final Object m1928j(AbstractC0545m abstractC0545m, Class cls) {
        C0735z c0735z;
        AbstractC0721l abstractC0721lM2148c = this.f2094e.m2148c(cls);
        if (abstractC0721lM2148c == null || !abstractC0721lM2148c.equals(this.f2098i)) {
            c0735z = new C0735z(this, this.f2094e, abstractC0721lM2148c, m1926h(abstractC0721lM2148c), this.f2100k);
        } else {
            c0735z = this;
        }
        return c0735z.m1923e(abstractC0545m, c0735z.f2100k);
    }

    /* JADX INFO: renamed from: k */
    public final AbstractC0545m m1929k(InterfaceC0557y interfaceC0557y) {
        C0735z c0735z;
        if (this.f2100k == null) {
            c0735z = this;
        } else {
            c0735z = new C0735z(this, this.f2094e, this.f2098i, this.f2099j, null);
        }
        return new C1517y((AbstractC0725p) interfaceC0557y, c0735z);
    }

    public C0735z(C0735z c0735z, C0717h c0717h, AbstractC0721l abstractC0721l, AbstractC0722m abstractC0722m, Object obj) {
        this.f2094e = c0717h;
        this.f2095f = c0735z.f2095f;
        this.f2101l = c0735z.f2101l;
        this.f2096g = c0735z.f2096g;
        this.f2098i = abstractC0721l;
        this.f2099j = abstractC0722m;
        this.f2100k = obj;
        C0703E c0703e = c0717h.f2486i;
        if (c0703e != null) {
            c0703e.m1688c();
        } else {
            c0717h.m1820r(EnumC0719j.UNWRAP_ROOT_VALUE);
        }
        this.f2097h = c0735z.f2097h;
    }
}
