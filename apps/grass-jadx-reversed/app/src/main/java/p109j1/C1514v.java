package p109j1;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0725p;
import p069X0.C0707I;
import p069X0.EnumC0708J;
import p074Z0.EnumC0831q;
import p100g1.AbstractC1399h;

/* JADX INFO: renamed from: j1.v */
/* JADX INFO: loaded from: classes.dex */
public final class C1514v extends AbstractC1498f {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: f */
    public final LinkedHashMap f5464f;

    public C1514v(C1505m c1505m) {
        super(c1505m);
        this.f5464f = new LinkedHashMap();
    }

    @Override // p042N0.InterfaceC0557y
    /* JADX INFO: renamed from: b */
    public final EnumC0548p mo1240b() {
        return EnumC0548p.START_OBJECT;
    }

    @Override // p109j1.AbstractC1494b, p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: c */
    public final void mo1909c(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        if (abstractC0709K != null) {
            EnumC0708J enumC0708J = EnumC0708J.WRITE_EMPTY_JSON_ARRAYS;
            C0707I c0707i = abstractC0709K.f1966e;
            boolean z3 = !c0707i.m1698r(enumC0708J);
            boolean z4 = !c0707i.f2491n.m2143a(EnumC0831q.f2476g);
            if (z3 || z4) {
                abstractC0540h.mo1121N(this);
                m3558r(abstractC0540h, abstractC0709K, z3, z4);
                abstractC0540h.mo1143p();
                return;
            }
        }
        abstractC0540h.mo1121N(this);
        for (Map.Entry entry : this.f5464f.entrySet()) {
            AbstractC0725p abstractC0725p = (AbstractC0725p) entry.getValue();
            abstractC0540h.mo1145r((String) entry.getKey());
            abstractC0725p.mo1909c(abstractC0540h, abstractC0709K);
        }
        abstractC0540h.mo1143p();
    }

    @Override // p069X0.AbstractC0726q, p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: d */
    public final void mo1908d(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
        boolean z3;
        boolean z4;
        if (abstractC0709K != null) {
            EnumC0708J enumC0708J = EnumC0708J.WRITE_EMPTY_JSON_ARRAYS;
            C0707I c0707i = abstractC0709K.f1966e;
            z3 = !c0707i.m1698r(enumC0708J);
            z4 = !c0707i.f2491n.m2143a(EnumC0831q.f2476g);
        } else {
            z3 = false;
            z4 = false;
        }
        C0672b c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, abstractC1399h.m3406d(EnumC0548p.START_OBJECT, this));
        if (z3 || z4) {
            m3558r(abstractC0540h, abstractC0709K, z3, z4);
        } else {
            for (Map.Entry entry : this.f5464f.entrySet()) {
                AbstractC0725p abstractC0725p = (AbstractC0725p) entry.getValue();
                abstractC0540h.mo1145r((String) entry.getKey());
                abstractC0725p.mo1909c(abstractC0540h, abstractC0709K);
            }
        }
        abstractC1399h.mo3104f(abstractC0540h, c0672bMo3103e);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof C1514v)) {
            return this.f5464f.equals(((C1514v) obj).f5464f);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5464f.hashCode();
    }

    @Override // p069X0.AbstractC0726q
    public final boolean isEmpty() {
        return this.f5464f.isEmpty();
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: j */
    public final Iterator mo1902j() {
        return this.f5464f.values().iterator();
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: k */
    public final Iterator mo1903k() {
        return this.f5464f.entrySet().iterator();
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: l */
    public final AbstractC0725p mo1904l(String str) {
        return (AbstractC0725p) this.f5464f.get(str);
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: m */
    public final int mo1905m() {
        return 7;
    }

    /* JADX INFO: renamed from: p */
    public final void m3556p(String str, String str2) {
        AbstractC0725p abstractC0725pM3551a;
        C1505m c1505m = this.f5435e;
        if (str2 == null) {
            c1505m.getClass();
            abstractC0725pM3551a = C1512t.f5463e;
        } else {
            c1505m.getClass();
            abstractC0725pM3551a = C1505m.m3551a(str2);
        }
        this.f5464f.put(str, abstractC0725pM3551a);
    }

    /* JADX INFO: renamed from: q */
    public final AbstractC0725p m3557q(String str, AbstractC0725p abstractC0725p) {
        if (abstractC0725p == null) {
            this.f5435e.getClass();
            abstractC0725p = C1512t.f5463e;
        }
        return (AbstractC0725p) this.f5464f.put(str, abstractC0725p);
    }

    /* JADX INFO: renamed from: r */
    public final void m3558r(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, boolean z3, boolean z4) {
        for (Map.Entry entry : this.f5464f.entrySet()) {
            AbstractC1494b abstractC1494b = (AbstractC1494b) entry.getValue();
            if (z3) {
                abstractC1494b.getClass();
                if (!(abstractC1494b instanceof C1493a) || !abstractC1494b.isEmpty()) {
                }
            }
            if (!z4 || abstractC1494b.mo1905m() != 5) {
                abstractC0540h.mo1145r((String) entry.getKey());
                abstractC1494b.mo1909c(abstractC0540h, abstractC0709K);
            }
        }
    }

    /* JADX INFO: renamed from: s */
    public final void m3559s(String str, AbstractC0725p abstractC0725p) {
        if (abstractC0725p == null) {
            this.f5435e.getClass();
            abstractC0725p = C1512t.f5463e;
        }
        this.f5464f.put(str, abstractC0725p);
    }
}
