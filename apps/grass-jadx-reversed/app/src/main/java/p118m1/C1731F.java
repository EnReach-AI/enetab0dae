package p118m1;

import p042N0.AbstractC0547o;
import p042N0.C0541i;
import p050Q0.C0590c;
import p058T0.C0638c;

/* JADX INFO: renamed from: m1.F */
/* JADX INFO: loaded from: classes.dex */
public final class C1731F extends AbstractC0547o {

    /* JADX INFO: renamed from: d */
    public final AbstractC0547o f6070d;

    /* JADX INFO: renamed from: e */
    public final C0541i f6071e;

    /* JADX INFO: renamed from: f */
    public String f6072f;

    /* JADX INFO: renamed from: g */
    public Object f6073g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1731F(AbstractC0547o abstractC0547o) {
        super(abstractC0547o);
        C0590c c0590c = C0590c.f1511g;
        this.f6070d = abstractC0547o.mo1215c();
        this.f6072f = abstractC0547o.mo1213a();
        this.f6073g = abstractC0547o.mo1214b();
        if (!(abstractC0547o instanceof C0638c)) {
            this.f6071e = C0541i.f1269k;
        } else {
            C0638c c0638c = (C0638c) abstractC0547o;
            this.f6071e = new C0541i(c0590c, -1L, -1L, c0638c.f1650i, c0638c.f1651j);
        }
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: a */
    public final String mo1213a() {
        return this.f6072f;
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: b */
    public final Object mo1214b() {
        return this.f6073g;
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: c */
    public final AbstractC0547o mo1215c() {
        return this.f6070d;
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: g */
    public final void mo1219g(Object obj) {
        this.f6073g = obj;
    }

    public C1731F(AbstractC0547o abstractC0547o, C0541i c0541i) {
        super(abstractC0547o);
        this.f6070d = abstractC0547o.mo1215c();
        this.f6072f = abstractC0547o.mo1213a();
        this.f6073g = abstractC0547o.mo1214b();
        this.f6071e = c0541i;
    }

    public C1731F() {
        super(0);
        this.f6070d = null;
        this.f6071e = C0541i.f1269k;
    }

    public C1731F(C1731F c1731f, int i3) {
        super(i3);
        this.f6070d = c1731f;
        this.f6071e = c1731f.f6071e;
    }
}
