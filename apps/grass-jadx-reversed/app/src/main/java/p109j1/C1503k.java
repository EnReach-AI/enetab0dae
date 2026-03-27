package p109j1;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import p005B.AbstractC0032g;
import p042N0.AbstractC0540h;
import p053R0.C0607c;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0725p;
import p069X0.AbstractC0726q;

/* JADX INFO: renamed from: j1.k */
/* JADX INFO: loaded from: classes.dex */
public final class C1503k extends AbstractC0726q {

    /* JADX INFO: renamed from: e */
    public final AbstractC1494b f5445e;

    /* JADX INFO: renamed from: f */
    public AbstractC0709K f5446f;

    public C1503k(AbstractC1494b abstractC1494b) {
        this.f5445e = abstractC1494b;
    }

    @Override // p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: c */
    public final void mo1909c(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        this.f5446f = abstractC0709K;
        AbstractC1494b abstractC1494b = this.f5445e;
        if (abstractC1494b instanceof C1514v) {
            ((C1514v) abstractC1494b).f5464f.size();
            abstractC0540h.mo1122O(this);
            m3548e(abstractC0540h, new C0607c(), abstractC1494b.mo1903k());
        } else {
            if (!(abstractC1494b instanceof C1493a)) {
                abstractC1494b.mo1909c(abstractC0540h, abstractC0709K);
                return;
            }
            C1493a c1493a = (C1493a) abstractC1494b;
            c1493a.f5424f.size();
            abstractC0540h.mo1119L(this);
            m3548e(abstractC0540h, new C0607c(), c1493a.f5424f.iterator());
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m3548e(AbstractC0540h abstractC0540h, C0607c c0607c, Iterator it) {
        AbstractC0725p abstractC0725p;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (next instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) next;
                    abstractC0540h.mo1145r((String) entry.getKey());
                    abstractC0725p = (AbstractC0725p) entry.getValue();
                } else {
                    abstractC0725p = (AbstractC0725p) next;
                }
                if (abstractC0725p instanceof C1514v) {
                    c0607c.m1400m(it);
                    it = abstractC0725p.mo1903k();
                    ((C1514v) abstractC0725p).f5464f.size();
                    abstractC0540h.mo1122O(abstractC0725p);
                } else if (abstractC0725p instanceof C1493a) {
                    c0607c.m1400m(it);
                    C1493a c1493a = (C1493a) abstractC0725p;
                    Iterator it2 = c1493a.f5424f.iterator();
                    c1493a.f5424f.size();
                    abstractC0540h.mo1119L(abstractC0725p);
                    it = it2;
                } else if (abstractC0725p instanceof C1515w) {
                    try {
                        ((C1515w) abstractC0725p).mo1909c(abstractC0540h, this.f5446f);
                    } catch (IOException | RuntimeException e3) {
                        abstractC0540h.mo1125R(AbstractC0032g.m156n("[ERROR: (", e3.getClass().getName(), ") ", e3.getMessage(), "]"));
                    }
                } else {
                    abstractC0725p.mo1909c(abstractC0540h, this.f5446f);
                }
            } else {
                if (abstractC0540h.mo1133f().m1216d()) {
                    abstractC0540h.mo1142o();
                } else {
                    abstractC0540h.mo1143p();
                }
                int i3 = c0607c.f1566f;
                if (i3 == 0) {
                    it = null;
                } else {
                    Iterator[] itArr = (Iterator[]) c0607c.f1568h;
                    int i4 = i3 - 1;
                    c0607c.f1566f = i4;
                    it = itArr[i4];
                }
                if (it == null) {
                    return;
                }
            }
        }
    }
}
