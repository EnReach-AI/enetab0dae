package p112k1;

import com.fasterxml.jackson.databind.JsonSerializer$None;
import com.fasterxml.jackson.databind.ser.impl.C1227o;
import java.io.IOException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import p039M0.AbstractC0485d0;
import p042N0.AbstractC0540h;
import p050Q0.C0597j;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0728s;
import p069X0.C0703E;
import p069X0.C0707I;
import p069X0.C0724o;
import p069X0.EnumC0708J;
import p069X0.EnumC0731v;
import p078a1.C0850b;
import p082b1.AbstractC1031b;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: k1.h */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1640h extends AbstractC0709K implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: s */
    public transient AbstractMap f5836s;

    /* JADX INFO: renamed from: t */
    public transient ArrayList f5837t;

    /* JADX INFO: renamed from: u */
    public transient AbstractC0540h f5838u;

    /* JADX INFO: renamed from: K */
    public static IOException m3722K(AbstractC0540h abstractC0540h, Exception exc) {
        if (exc instanceof IOException) {
            return (IOException) exc;
        }
        String strM3886i = AbstractC1745j.m3886i(exc);
        if (strM3886i == null) {
            strM3886i = "[no message for " + exc.getClass().getName() + "]";
        }
        return new C0724o(abstractC0540h, strM3886i, exc);
    }

    @Override // p069X0.AbstractC0709K
    /* JADX INFO: renamed from: E */
    public final Object mo1705E(Class cls) {
        if (cls == null) {
            return null;
        }
        C0707I c0707i = this.f1966e;
        c0707i.m2153h();
        return AbstractC1745j.m3885h(cls, c0707i.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS));
    }

    @Override // p069X0.AbstractC0709K
    /* JADX INFO: renamed from: F */
    public final boolean mo1706F(Object obj) throws C0850b {
        if (obj == null) {
            return true;
        }
        try {
            return obj.equals(null);
        } catch (Exception e3) {
            String str = "Problem determining whether filter of type '" + obj.getClass().getName() + "' should filter out `null` values: (" + e3.getClass().getName() + ") " + AbstractC1745j.m3886i(e3);
            Class<?> cls = obj.getClass();
            AbstractC0540h abstractC0540h = this.f5838u;
            m1811c(cls);
            C0850b c0850b = new C0850b(abstractC0540h, str);
            c0850b.initCause(e3);
            throw c0850b;
        }
    }

    @Override // p069X0.AbstractC0709K
    /* JADX INFO: renamed from: I */
    public final AbstractC0728s mo1709I(AbstractC1031b abstractC1031b, Object obj) throws C0850b {
        AbstractC0728s abstractC0728s;
        if (obj instanceof AbstractC0728s) {
            abstractC0728s = (AbstractC0728s) obj;
        } else {
            if (!(obj instanceof Class)) {
                abstractC1031b.mo2769f();
                mo1713k("AnnotationIntrospector returned serializer definition of type " + obj.getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
                throw null;
            }
            Class cls = (Class) obj;
            if (cls == JsonSerializer$None.class || AbstractC1745j.m3897t(cls)) {
                return null;
            }
            if (!AbstractC0728s.class.isAssignableFrom(cls)) {
                abstractC1031b.mo2769f();
                mo1713k("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<JsonSerializer>");
                throw null;
            }
            C0707I c0707i = this.f1966e;
            c0707i.m2153h();
            abstractC0728s = (AbstractC0728s) AbstractC1745j.m3885h(cls, c0707i.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS));
        }
        if (abstractC0728s instanceof InterfaceC1643k) {
            ((InterfaceC1643k) abstractC0728s).resolve(this);
        }
        return abstractC0728s;
    }

    /* JADX INFO: renamed from: J */
    public final void m3723J(AbstractC0540h abstractC0540h, Object obj, AbstractC0728s abstractC0728s, C0703E c0703e) throws IOException {
        try {
            abstractC0540h.mo1120M();
            C0707I c0707i = this.f1966e;
            C0597j c0597j = c0703e.f1930g;
            if (c0597j == null) {
                String str = c0703e.f1928e;
                c0597j = c0707i == null ? new C0597j(str) : new C0597j(str);
                c0703e.f1930g = c0597j;
            }
            abstractC0540h.mo1144q(c0597j);
            abstractC0728s.serialize(obj, abstractC0540h, this);
            abstractC0540h.mo1143p();
        } catch (Exception e3) {
            throw m3722K(abstractC0540h, e3);
        }
    }

    /* JADX INFO: renamed from: L */
    public final void m3724L(AbstractC0540h abstractC0540h, Object obj) {
        this.f5838u = abstractC0540h;
        if (obj == null) {
            try {
                this.f1973l.serialize(null, abstractC0540h, this);
                return;
            } catch (Exception e3) {
                throw m3722K(abstractC0540h, e3);
            }
        }
        Class<?> cls = obj.getClass();
        AbstractC0728s abstractC0728sM1726x = m1726x(cls);
        C0707I c0707i = this.f1966e;
        C0703E c0703e = c0707i.f2486i;
        if (c0703e == null) {
            if (c0707i.m1698r(EnumC0708J.WRAP_ROOT_VALUE)) {
                C0703E c0703eM3913a = c0707i.f2486i;
                if (c0703eM3913a == null) {
                    c0703eM3913a = c0707i.f2489l.m3913a(c0707i, cls);
                }
                m3723J(abstractC0540h, obj, abstractC0728sM1726x, c0703eM3913a);
                return;
            }
        } else if (!c0703e.m1688c()) {
            m3723J(abstractC0540h, obj, abstractC0728sM1726x, c0703e);
            return;
        }
        try {
            abstractC0728sM1726x.serialize(obj, abstractC0540h, this);
        } catch (Exception e4) {
            throw m3722K(abstractC0540h, e4);
        }
    }

    @Override // p069X0.AbstractC0709K
    /* JADX INFO: renamed from: u */
    public final C1227o mo1723u(Object obj, AbstractC0485d0 abstractC0485d0) {
        AbstractC0485d0 abstractC0485d0Mo1005e;
        AbstractMap abstractMap = this.f5836s;
        if (abstractMap == null) {
            this.f5836s = this.f1966e.m1698r(EnumC0708J.USE_EQUALITY_FOR_OBJECT_ID) ? new HashMap() : new IdentityHashMap();
        } else {
            C1227o c1227o = (C1227o) abstractMap.get(obj);
            if (c1227o != null) {
                return c1227o;
            }
        }
        ArrayList arrayList = this.f5837t;
        if (arrayList == null) {
            this.f5837t = new ArrayList(8);
        } else {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                abstractC0485d0Mo1005e = (AbstractC0485d0) this.f5837t.get(i3);
                if (abstractC0485d0Mo1005e.mo1001a(abstractC0485d0)) {
                    break;
                }
            }
        }
        abstractC0485d0Mo1005e = null;
        if (abstractC0485d0Mo1005e == null) {
            abstractC0485d0Mo1005e = abstractC0485d0.mo1005e();
            this.f5837t.add(abstractC0485d0Mo1005e);
        }
        C1227o c1227o2 = new C1227o(abstractC0485d0Mo1005e);
        this.f5836s.put(obj, c1227o2);
        return c1227o2;
    }
}
