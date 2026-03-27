package p103h1;

import com.fasterxml.jackson.databind.deser.std.NullifyingDeserializer;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p001A.C0009j;
import p005B.AbstractC0032g;
import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.EnumC0719j;
import p069X0.InterfaceC0714e;
import p078a1.C0853e;
import p100g1.AbstractC1398g;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: h1.p */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1428p extends AbstractC1398g implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final AbstractC1429q f5060e;

    /* JADX INFO: renamed from: f */
    public final AbstractC0721l f5061f;

    /* JADX INFO: renamed from: g */
    public final InterfaceC0714e f5062g;

    /* JADX INFO: renamed from: h */
    public final AbstractC0721l f5063h;

    /* JADX INFO: renamed from: i */
    public final String f5064i;

    /* JADX INFO: renamed from: j */
    public final boolean f5065j;

    /* JADX INFO: renamed from: k */
    public final Map f5066k;

    /* JADX INFO: renamed from: l */
    public AbstractC0722m f5067l;

    public AbstractC1428p(AbstractC0721l abstractC0721l, AbstractC1429q abstractC1429q, String str, boolean z3, AbstractC0721l abstractC0721l2) {
        this.f5061f = abstractC0721l;
        this.f5060e = abstractC1429q;
        Annotation[] annotationArr = AbstractC1745j.f6110a;
        this.f5064i = str == null ? "" : str;
        this.f5065j = z3;
        this.f5066k = new ConcurrentHashMap(16, 0.75f, 2);
        this.f5063h = abstractC0721l2;
        this.f5062g = null;
    }

    /* JADX INFO: renamed from: h */
    public final Object m3439h(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) {
        return m3441j(abstractC0718i, obj instanceof String ? (String) obj : String.valueOf(obj)).deserialize(abstractC0545m, abstractC0718i);
    }

    /* JADX INFO: renamed from: i */
    public final AbstractC0722m m3440i(AbstractC0718i abstractC0718i) {
        AbstractC0722m abstractC0722m;
        AbstractC0721l abstractC0721l = this.f5063h;
        if (abstractC0721l == null) {
            if (abstractC0718i.m1833K(EnumC0719j.FAIL_ON_INVALID_SUBTYPE)) {
                return null;
            }
            return NullifyingDeserializer.instance;
        }
        if (AbstractC1745j.m3897t(abstractC0721l.f2036e)) {
            return NullifyingDeserializer.instance;
        }
        synchronized (this.f5063h) {
            try {
                if (this.f5067l == null) {
                    this.f5067l = abstractC0718i.m1852q(this.f5063h, this.f5062g);
                }
                abstractC0722m = this.f5067l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return abstractC0722m;
    }

    /* JADX INFO: renamed from: j */
    public final AbstractC0722m m3441j(AbstractC0718i abstractC0718i, String str) throws C0853e {
        Map map = this.f5066k;
        AbstractC0722m abstractC0722mM1852q = (AbstractC0722m) map.get(str);
        if (abstractC0722mM1852q == null) {
            AbstractC1429q abstractC1429q = this.f5060e;
            AbstractC0721l abstractC0721lMo3430d = abstractC1429q.mo3430d(abstractC0718i, str);
            InterfaceC0714e interfaceC0714e = this.f5062g;
            AbstractC0721l abstractC0721l = this.f5061f;
            if (abstractC0721lMo3430d == null) {
                AbstractC0722m abstractC0722mM3440i = m3440i(abstractC0718i);
                if (abstractC0722mM3440i == null) {
                    String strMo3427a = abstractC1429q.mo3427a();
                    String strConcat = strMo3427a == null ? "type ids are not statically known" : "known type ids = ".concat(strMo3427a);
                    if (interfaceC0714e != null) {
                        strConcat = strConcat + " (for POJO property '" + interfaceC0714e.mo1808f() + "')";
                    }
                    C0009j c0009j = abstractC0718i.f1998g.f1987q;
                    if (c0009j != null) {
                        AbstractC0032g.m162t(c0009j.f30f);
                        throw null;
                    }
                    if (abstractC0718i.m1833K(EnumC0719j.FAIL_ON_INVALID_SUBTYPE)) {
                        throw abstractC0718i.mo1712g(abstractC0721l, str, strConcat);
                    }
                    return NullifyingDeserializer.instance;
                }
                abstractC0722mM1852q = abstractC0722mM3440i;
            } else {
                if (abstractC0721l != null && abstractC0721l.getClass() == abstractC0721lMo3430d.getClass() && !abstractC0721lMo3430d.mo1881p()) {
                    try {
                        Class cls = abstractC0721lMo3430d.f2036e;
                        abstractC0718i.getClass();
                        abstractC0721lMo3430d = abstractC0721l.m1883r(cls) ? abstractC0721l : abstractC0718i.f1998g.f2481f.f2419e.m3779i(abstractC0721l, cls, false);
                    } catch (IllegalArgumentException e3) {
                        throw abstractC0718i.mo1712g(abstractC0721l, str, e3.getMessage());
                    }
                }
                abstractC0722mM1852q = abstractC0718i.m1852q(abstractC0721lMo3430d, interfaceC0714e);
            }
            map.put(str, abstractC0722mM1852q);
        }
        return abstractC0722mM1852q;
    }

    public final String toString() {
        return "[" + getClass().getName() + "; base-type:" + this.f5061f + "; id-resolver: " + this.f5060e + ']';
    }

    public AbstractC1428p(AbstractC1428p abstractC1428p, InterfaceC0714e interfaceC0714e) {
        this.f5061f = abstractC1428p.f5061f;
        this.f5060e = abstractC1428p.f5060e;
        this.f5064i = abstractC1428p.f5064i;
        this.f5065j = abstractC1428p.f5065j;
        this.f5066k = abstractC1428p.f5066k;
        this.f5063h = abstractC1428p.f5063h;
        this.f5067l = abstractC1428p.f5067l;
        this.f5062g = interfaceC0714e;
    }
}
