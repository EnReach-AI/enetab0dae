package p109j1;

import java.util.ArrayList;
import java.util.Iterator;
import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0725p;
import p100g1.AbstractC1399h;

/* JADX INFO: renamed from: j1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1493a extends AbstractC1498f {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: f */
    public final ArrayList f5424f;

    public C1493a(C1505m c1505m) {
        super(c1505m);
        this.f5424f = new ArrayList();
    }

    @Override // p042N0.InterfaceC0557y
    /* JADX INFO: renamed from: b */
    public final EnumC0548p mo1240b() {
        return EnumC0548p.START_ARRAY;
    }

    @Override // p109j1.AbstractC1494b, p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: c */
    public final void mo1909c(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        ArrayList arrayList = this.f5424f;
        int size = arrayList.size();
        abstractC0540h.mo1119L(this);
        for (int i3 = 0; i3 < size; i3++) {
            ((AbstractC0725p) arrayList.get(i3)).mo1909c(abstractC0540h, abstractC0709K);
        }
        abstractC0540h.mo1142o();
    }

    @Override // p069X0.AbstractC0726q, p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: d */
    public final void mo1908d(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
        C0672b c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, abstractC1399h.m3406d(EnumC0548p.START_ARRAY, this));
        Iterator it = this.f5424f.iterator();
        while (it.hasNext()) {
            ((AbstractC1494b) ((AbstractC0725p) it.next())).mo1909c(abstractC0540h, abstractC0709K);
        }
        abstractC1399h.mo3104f(abstractC0540h, c0672bMo3103e);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof C1493a)) {
            return this.f5424f.equals(((C1493a) obj).f5424f);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5424f.hashCode();
    }

    @Override // p069X0.AbstractC0726q
    public final boolean isEmpty() {
        return this.f5424f.isEmpty();
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: j */
    public final Iterator mo1902j() {
        return this.f5424f.iterator();
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: l */
    public final AbstractC0725p mo1904l(String str) {
        return null;
    }

    @Override // p069X0.AbstractC0725p
    /* JADX INFO: renamed from: m */
    public final int mo1905m() {
        return 1;
    }

    /* JADX INFO: renamed from: p */
    public final void m3542p(AbstractC0725p abstractC0725p) {
        if (abstractC0725p == null) {
            this.f5435e.getClass();
            abstractC0725p = C1512t.f5463e;
        }
        this.f5424f.add(abstractC0725p);
    }
}
