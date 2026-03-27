package p058T0;

import p005B.AbstractC0032g;
import p042N0.AbstractC0545m;
import p042N0.AbstractC0547o;
import p042N0.C0542j;
import p125o0.C1803m;

/* JADX INFO: renamed from: T0.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0638c extends AbstractC0547o {

    /* JADX INFO: renamed from: d */
    public final C0638c f1645d;

    /* JADX INFO: renamed from: e */
    public C1803m f1646e;

    /* JADX INFO: renamed from: f */
    public C0638c f1647f;

    /* JADX INFO: renamed from: g */
    public String f1648g;

    /* JADX INFO: renamed from: h */
    public Object f1649h;

    /* JADX INFO: renamed from: i */
    public int f1650i;

    /* JADX INFO: renamed from: j */
    public int f1651j;

    public C0638c(C0638c c0638c, int i3, C1803m c1803m, int i4, int i5, int i6) {
        this.f1645d = c0638c;
        this.f1646e = c1803m;
        this.f1308a = i4;
        this.f1650i = i5;
        this.f1651j = i6;
        this.f1309b = -1;
        this.f1310c = i3;
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: a */
    public final String mo1213a() {
        return this.f1648g;
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: b */
    public final Object mo1214b() {
        return this.f1649h;
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: c */
    public final AbstractC0547o mo1215c() {
        return this.f1645d;
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: g */
    public final void mo1219g(Object obj) {
        this.f1649h = obj;
    }

    /* JADX INFO: renamed from: i */
    public final boolean m1465i() {
        int i3 = this.f1309b + 1;
        this.f1309b = i3;
        return this.f1308a != 0 && i3 > 0;
    }

    /* JADX INFO: renamed from: j */
    public final void m1466j(String str) throws C0542j {
        this.f1648g = str;
        C1803m c1803m = this.f1646e;
        if (c1803m == null || !c1803m.m4002m(str)) {
            return;
        }
        Object obj = c1803m.f6220f;
        throw new C0542j(obj instanceof AbstractC0545m ? (AbstractC0545m) obj : null, AbstractC0032g.m154l("Duplicate field '", str, "'"));
    }
}
