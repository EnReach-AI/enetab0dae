package p112k1;

import com.fasterxml.jackson.databind.ser.impl.AbstractC1223k;
import com.fasterxml.jackson.databind.ser.impl.C1219g;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import p001A.C0009j;
import p005B.AbstractC0032g;
import p039M0.EnumC0511z;
import p042N0.AbstractC0540h;
import p050Q0.C0597j;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.AbstractC0728s;
import p069X0.C0703E;
import p069X0.EnumC0708J;
import p078a1.C0850b;
import p082b1.AbstractC1007C;
import p082b1.AbstractC1041l;
import p082b1.C1039j;
import p082b1.C1043n;
import p100g1.AbstractC1399h;
import p103h1.AbstractC1431s;
import p109j1.C1514v;
import p118m1.AbstractC1745j;
import p118m1.AbstractC1757v;
import p118m1.InterfaceC1737b;

/* JADX INFO: renamed from: k1.c */
/* JADX INFO: loaded from: classes.dex */
public class C1635c extends AbstractC1642j {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: g */
    public final C0597j f5810g;

    /* JADX INFO: renamed from: h */
    public final C0703E f5811h;

    /* JADX INFO: renamed from: i */
    public final AbstractC0721l f5812i;

    /* JADX INFO: renamed from: j */
    public final AbstractC0721l f5813j;

    /* JADX INFO: renamed from: k */
    public AbstractC0721l f5814k;

    /* JADX INFO: renamed from: l */
    public final AbstractC1041l f5815l;

    /* JADX INFO: renamed from: m */
    public transient Method f5816m;

    /* JADX INFO: renamed from: n */
    public transient Field f5817n;

    /* JADX INFO: renamed from: o */
    public AbstractC0728s f5818o;

    /* JADX INFO: renamed from: p */
    public AbstractC0728s f5819p;

    /* JADX INFO: renamed from: q */
    public AbstractC1399h f5820q;

    /* JADX INFO: renamed from: r */
    public transient AbstractC1223k f5821r;

    /* JADX INFO: renamed from: s */
    public final boolean f5822s;

    /* JADX INFO: renamed from: t */
    public final Object f5823t;

    /* JADX INFO: renamed from: u */
    public final Class[] f5824u;

    /* JADX INFO: renamed from: v */
    public final transient HashMap f5825v;

    public C1635c(AbstractC1007C abstractC1007C, AbstractC1041l abstractC1041l, InterfaceC1737b interfaceC1737b, AbstractC0721l abstractC0721l, AbstractC0728s abstractC0728s, AbstractC1431s abstractC1431s, AbstractC0721l abstractC0721l2, boolean z3, Object obj, Class[] clsArr) {
        super(abstractC1007C.mo2707b());
        this.f5815l = abstractC1041l;
        this.f5810g = new C0597j(abstractC1007C.mo1808f());
        abstractC1007C.mo2722u();
        this.f5811h = null;
        this.f5812i = abstractC0721l;
        this.f5818o = abstractC0728s;
        this.f5821r = abstractC0728s == null ? C1219g.f4140b : null;
        this.f5820q = abstractC1431s;
        this.f5813j = abstractC0721l2;
        if (abstractC1041l instanceof C1039j) {
            this.f5816m = null;
            this.f5817n = ((C1039j) abstractC1041l).f3694g;
        } else if (abstractC1041l instanceof C1043n) {
            this.f5816m = ((C1043n) abstractC1041l).f3704h;
            this.f5817n = null;
        } else {
            this.f5816m = null;
            this.f5817n = null;
        }
        this.f5822s = z3;
        this.f5823t = obj;
        this.f5819p = null;
        this.f5824u = clsArr;
    }

    @Override // p069X0.InterfaceC0714e
    /* JADX INFO: renamed from: a */
    public final C0703E mo1803a() {
        return new C0703E(this.f5810g.f1531e, null);
    }

    @Override // p069X0.InterfaceC0714e
    /* JADX INFO: renamed from: c */
    public final AbstractC1041l mo1805c() {
        return this.f5815l;
    }

    @Override // p118m1.InterfaceC1758w
    /* JADX INFO: renamed from: f */
    public final String mo1808f() {
        return this.f5810g.f1531e;
    }

    @Override // p069X0.InterfaceC0714e
    public final AbstractC0721l getType() {
        return this.f5812i;
    }

    /* JADX INFO: renamed from: h */
    public void mo3096h(C1514v c1514v, AbstractC0725p abstractC0725p) {
        c1514v.m3559s(this.f5810g.f1531e, abstractC0725p);
    }

    /* JADX INFO: renamed from: i */
    public AbstractC0728s mo3097i(AbstractC1223k abstractC1223k, Class cls, AbstractC0709K abstractC0709K) {
        C0009j c0009j;
        AbstractC0721l abstractC0721l = this.f5814k;
        if (abstractC0721l != null) {
            AbstractC0721l abstractC0721lM1718p = abstractC0709K.m1718p(abstractC0721l, cls);
            abstractC1223k.getClass();
            AbstractC0728s abstractC0728sM1724v = abstractC0709K.m1724v(abstractC0721lM1718p, this);
            c0009j = new C0009j(abstractC0728sM1724v, 22, abstractC1223k.mo3091b(abstractC0721lM1718p.f2036e, abstractC0728sM1724v));
        } else {
            abstractC1223k.getClass();
            AbstractC0728s abstractC0728sM1725w = abstractC0709K.m1725w(cls, this);
            c0009j = new C0009j(abstractC0728sM1725w, 22, abstractC1223k.mo3091b(cls, abstractC0728sM1725w));
        }
        AbstractC1223k abstractC1223k2 = (AbstractC1223k) c0009j.f31g;
        if (abstractC1223k != abstractC1223k2) {
            this.f5821r = abstractC1223k2;
        }
        return (AbstractC0728s) c0009j.f30f;
    }

    /* JADX INFO: renamed from: j */
    public final boolean m3716j(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC0728s abstractC0728s) throws C0850b {
        if (abstractC0728s.usesObjectId()) {
            return false;
        }
        if (abstractC0709K.f1966e.m1698r(EnumC0708J.FAIL_ON_SELF_REFERENCES)) {
            if (!(abstractC0728s instanceof BeanSerializerBase)) {
                return false;
            }
            abstractC0709K.mo1713k("Direct self-reference leading to cycle");
            throw null;
        }
        if (!abstractC0709K.f1966e.m1698r(EnumC0708J.WRITE_SELF_REFERENCES_AS_NULL)) {
            return false;
        }
        if (this.f5819p == null) {
            return true;
        }
        if (!abstractC0540h.mo1133f().m1216d()) {
            abstractC0540h.mo1144q(this.f5810g);
        }
        this.f5819p.serialize(null, abstractC0540h, abstractC0709K);
        return true;
    }

    /* JADX INFO: renamed from: k */
    public void mo3084k(AbstractC0728s abstractC0728s) {
        AbstractC0728s abstractC0728s2 = this.f5819p;
        if (abstractC0728s2 != null && abstractC0728s2 != abstractC0728s) {
            throw new IllegalStateException(AbstractC0032g.m155m("Cannot override _nullSerializer: had a ", AbstractC1745j.m3883f(this.f5819p), ", trying to set to ", AbstractC1745j.m3883f(abstractC0728s)));
        }
        this.f5819p = abstractC0728s;
    }

    /* JADX INFO: renamed from: l */
    public void mo3085l(AbstractC0728s abstractC0728s) {
        AbstractC0728s abstractC0728s2 = this.f5818o;
        if (abstractC0728s2 != null && abstractC0728s2 != abstractC0728s) {
            throw new IllegalStateException(AbstractC0032g.m155m("Cannot override _serializer: had a ", AbstractC1745j.m3883f(this.f5818o), ", trying to set to ", AbstractC1745j.m3883f(abstractC0728s)));
        }
        this.f5818o = abstractC0728s;
    }

    /* JADX INFO: renamed from: m */
    public C1635c mo3086m(AbstractC1757v abstractC1757v) {
        C0597j c0597j = this.f5810g;
        String strMo3911a = abstractC1757v.mo3911a(c0597j.f1531e);
        return strMo3911a.equals(c0597j.f1531e) ? this : new C1635c(this, C0703E.m1686a(strMo3911a));
    }

    /* JADX INFO: renamed from: n */
    public void mo3087n(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        Method method = this.f5816m;
        Object objInvoke = method == null ? this.f5817n.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
            AbstractC0728s abstractC0728s = this.f5819p;
            if (abstractC0728s != null) {
                abstractC0728s.serialize(null, abstractC0540h, abstractC0709K);
                return;
            } else {
                abstractC0540h.mo1146s();
                return;
            }
        }
        AbstractC0728s abstractC0728sMo3097i = this.f5818o;
        if (abstractC0728sMo3097i == null) {
            Class<?> cls = objInvoke.getClass();
            AbstractC1223k abstractC1223k = this.f5821r;
            AbstractC0728s abstractC0728sMo3092c = abstractC1223k.mo3092c(cls);
            abstractC0728sMo3097i = abstractC0728sMo3092c == null ? mo3097i(abstractC1223k, cls, abstractC0709K) : abstractC0728sMo3092c;
        }
        Object obj2 = this.f5823t;
        if (obj2 != null) {
            if (EnumC0511z.f1184g == obj2) {
                if (abstractC0728sMo3097i.isEmpty(abstractC0709K, objInvoke)) {
                    m3717p(abstractC0540h, abstractC0709K);
                    return;
                }
            } else if (obj2.equals(objInvoke)) {
                m3717p(abstractC0540h, abstractC0709K);
                return;
            }
        }
        if (objInvoke == obj && m3716j(abstractC0540h, abstractC0709K, abstractC0728sMo3097i)) {
            return;
        }
        AbstractC1399h abstractC1399h = this.f5820q;
        if (abstractC1399h == null) {
            abstractC0728sMo3097i.serialize(objInvoke, abstractC0540h, abstractC0709K);
        } else {
            abstractC0728sMo3097i.serializeWithType(objInvoke, abstractC0540h, abstractC0709K, abstractC1399h);
        }
    }

    /* JADX INFO: renamed from: o */
    public void mo3088o(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        Method method = this.f5816m;
        Object objInvoke = method == null ? this.f5817n.get(obj) : method.invoke(obj, null);
        C0597j c0597j = this.f5810g;
        Object obj2 = this.f5823t;
        if (objInvoke == null) {
            if ((obj2 == null || !abstractC0709K.mo1706F(obj2)) && this.f5819p != null) {
                abstractC0540h.mo1144q(c0597j);
                this.f5819p.serialize(null, abstractC0540h, abstractC0709K);
                return;
            }
            return;
        }
        AbstractC0728s abstractC0728sMo3097i = this.f5818o;
        if (abstractC0728sMo3097i == null) {
            Class<?> cls = objInvoke.getClass();
            AbstractC1223k abstractC1223k = this.f5821r;
            AbstractC0728s abstractC0728sMo3092c = abstractC1223k.mo3092c(cls);
            abstractC0728sMo3097i = abstractC0728sMo3092c == null ? mo3097i(abstractC1223k, cls, abstractC0709K) : abstractC0728sMo3092c;
        }
        if (obj2 != null) {
            if (EnumC0511z.f1184g == obj2) {
                if (abstractC0728sMo3097i.isEmpty(abstractC0709K, objInvoke)) {
                    return;
                }
            } else if (obj2.equals(objInvoke)) {
                return;
            }
        }
        if (objInvoke == obj && m3716j(abstractC0540h, abstractC0709K, abstractC0728sMo3097i)) {
            return;
        }
        abstractC0540h.mo1144q(c0597j);
        AbstractC1399h abstractC1399h = this.f5820q;
        if (abstractC1399h == null) {
            abstractC0728sMo3097i.serialize(objInvoke, abstractC0540h, abstractC0709K);
        } else {
            abstractC0728sMo3097i.serializeWithType(objInvoke, abstractC0540h, abstractC0709K, abstractC1399h);
        }
    }

    /* JADX INFO: renamed from: p */
    public final void m3717p(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        AbstractC0728s abstractC0728s = this.f5819p;
        if (abstractC0728s != null) {
            abstractC0728s.serialize(null, abstractC0540h, abstractC0709K);
        } else {
            abstractC0540h.mo1146s();
        }
    }

    public Object readResolve() {
        AbstractC1041l abstractC1041l = this.f5815l;
        if (abstractC1041l instanceof C1039j) {
            this.f5816m = null;
            this.f5817n = (Field) abstractC1041l.mo2771k();
        } else if (abstractC1041l instanceof C1043n) {
            this.f5816m = (Method) abstractC1041l.mo2771k();
            this.f5817n = null;
        }
        if (this.f5818o == null) {
            this.f5821r = C1219g.f4140b;
        }
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("property '");
        sb.append(this.f5810g.f1531e);
        sb.append("' (");
        if (this.f5816m != null) {
            sb.append("via method ");
            sb.append(this.f5816m.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this.f5816m.getName());
        } else if (this.f5817n != null) {
            sb.append("field \"");
            sb.append(this.f5817n.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this.f5817n.getName());
        } else {
            sb.append("virtual");
        }
        AbstractC0728s abstractC0728s = this.f5818o;
        if (abstractC0728s == null) {
            sb.append(", no static serializer");
        } else {
            sb.append(", static serializer of type ".concat(abstractC0728s.getClass().getName()));
        }
        sb.append(')');
        return sb.toString();
    }

    public C1635c(C1635c c1635c, C0597j c0597j) {
        super(c1635c);
        this.f5810g = c0597j;
        this.f5811h = c1635c.f5811h;
        this.f5815l = c1635c.f5815l;
        this.f5812i = c1635c.f5812i;
        this.f5816m = c1635c.f5816m;
        this.f5817n = c1635c.f5817n;
        this.f5818o = c1635c.f5818o;
        this.f5819p = c1635c.f5819p;
        if (c1635c.f5825v != null) {
            this.f5825v = new HashMap(c1635c.f5825v);
        }
        this.f5813j = c1635c.f5813j;
        this.f5821r = c1635c.f5821r;
        this.f5822s = c1635c.f5822s;
        this.f5823t = c1635c.f5823t;
        this.f5824u = c1635c.f5824u;
        this.f5820q = c1635c.f5820q;
        this.f5814k = c1635c.f5814k;
    }

    public C1635c(C1635c c1635c, C0703E c0703e) {
        super(c1635c);
        this.f5810g = new C0597j(c0703e.f1928e);
        this.f5811h = c1635c.f5811h;
        this.f5812i = c1635c.f5812i;
        this.f5815l = c1635c.f5815l;
        this.f5816m = c1635c.f5816m;
        this.f5817n = c1635c.f5817n;
        this.f5818o = c1635c.f5818o;
        this.f5819p = c1635c.f5819p;
        if (c1635c.f5825v != null) {
            this.f5825v = new HashMap(c1635c.f5825v);
        }
        this.f5813j = c1635c.f5813j;
        this.f5821r = c1635c.f5821r;
        this.f5822s = c1635c.f5822s;
        this.f5823t = c1635c.f5823t;
        this.f5824u = c1635c.f5824u;
        this.f5820q = c1635c.f5820q;
        this.f5814k = c1635c.f5814k;
    }

    public C1635c(C1635c c1635c) {
        this(c1635c, c1635c.f5810g);
    }
}
