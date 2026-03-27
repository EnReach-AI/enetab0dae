package p058T0;

import p005B.AbstractC0032g;
import p042N0.AbstractC0540h;
import p042N0.AbstractC0547o;
import p042N0.C0538f;
import p125o0.C1803m;

/* JADX INFO: renamed from: T0.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0640e extends AbstractC0547o {

    /* JADX INFO: renamed from: d */
    public final C0640e f1658d;

    /* JADX INFO: renamed from: e */
    public C1803m f1659e;

    /* JADX INFO: renamed from: f */
    public C0640e f1660f;

    /* JADX INFO: renamed from: g */
    public String f1661g;

    /* JADX INFO: renamed from: h */
    public Object f1662h;

    /* JADX INFO: renamed from: i */
    public boolean f1663i;

    public C0640e(int i3, C0640e c0640e, C1803m c1803m) {
        this.f1308a = i3;
        this.f1658d = c0640e;
        this.f1659e = c1803m;
        this.f1309b = -1;
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: a */
    public final String mo1213a() {
        return this.f1661g;
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: b */
    public final Object mo1214b() {
        return this.f1662h;
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: c */
    public final AbstractC0547o mo1215c() {
        return this.f1658d;
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: g */
    public final void mo1219g(Object obj) {
        this.f1662h = obj;
    }

    /* JADX INFO: renamed from: i */
    public final C0640e m1467i() {
        C0640e c0640e = this.f1660f;
        if (c0640e == null) {
            C1803m c1803m = this.f1659e;
            C0640e c0640e2 = new C0640e(1, this, c1803m != null ? c1803m.m3999j() : null);
            this.f1660f = c0640e2;
            return c0640e2;
        }
        c0640e.f1308a = 1;
        c0640e.f1309b = -1;
        c0640e.f1661g = null;
        c0640e.f1663i = false;
        c0640e.f1662h = null;
        C1803m c1803m2 = c0640e.f1659e;
        if (c1803m2 != null) {
            c1803m2.f6219e = null;
            c1803m2.f6221g = null;
            c1803m2.f6222h = null;
        }
        return c0640e;
    }

    /* JADX INFO: renamed from: j */
    public final C0640e m1468j(Object obj) {
        C0640e c0640e = this.f1660f;
        if (c0640e == null) {
            C1803m c1803m = this.f1659e;
            C0640e c0640e2 = new C0640e(1, this, c1803m != null ? c1803m.m3999j() : null, obj);
            this.f1660f = c0640e2;
            return c0640e2;
        }
        c0640e.f1308a = 1;
        c0640e.f1309b = -1;
        c0640e.f1661g = null;
        c0640e.f1663i = false;
        c0640e.f1662h = obj;
        C1803m c1803m2 = c0640e.f1659e;
        if (c1803m2 != null) {
            c1803m2.f6219e = null;
            c1803m2.f6221g = null;
            c1803m2.f6222h = null;
        }
        return c0640e;
    }

    /* JADX INFO: renamed from: k */
    public final C0640e m1469k() {
        C0640e c0640e = this.f1660f;
        if (c0640e == null) {
            C1803m c1803m = this.f1659e;
            C0640e c0640e2 = new C0640e(2, this, c1803m != null ? c1803m.m3999j() : null);
            this.f1660f = c0640e2;
            return c0640e2;
        }
        c0640e.f1308a = 2;
        c0640e.f1309b = -1;
        c0640e.f1661g = null;
        c0640e.f1663i = false;
        c0640e.f1662h = null;
        C1803m c1803m2 = c0640e.f1659e;
        if (c1803m2 != null) {
            c1803m2.f6219e = null;
            c1803m2.f6221g = null;
            c1803m2.f6222h = null;
        }
        return c0640e;
    }

    /* JADX INFO: renamed from: l */
    public final C0640e m1470l(Object obj) {
        C0640e c0640e = this.f1660f;
        if (c0640e == null) {
            C1803m c1803m = this.f1659e;
            C0640e c0640e2 = new C0640e(2, this, c1803m != null ? c1803m.m3999j() : null, obj);
            this.f1660f = c0640e2;
            return c0640e2;
        }
        c0640e.f1308a = 2;
        c0640e.f1309b = -1;
        c0640e.f1661g = null;
        c0640e.f1663i = false;
        c0640e.f1662h = obj;
        C1803m c1803m2 = c0640e.f1659e;
        if (c1803m2 != null) {
            c1803m2.f6219e = null;
            c1803m2.f6221g = null;
            c1803m2.f6222h = null;
        }
        return c0640e;
    }

    /* JADX INFO: renamed from: m */
    public final int m1471m(String str) throws C0538f {
        if (this.f1308a != 2 || this.f1663i) {
            return 4;
        }
        this.f1663i = true;
        this.f1661g = str;
        C1803m c1803m = this.f1659e;
        if (c1803m == null || !c1803m.m4002m(str)) {
            return this.f1309b < 0 ? 0 : 1;
        }
        String strM154l = AbstractC0032g.m154l("Duplicate field '", str, "'");
        Object obj = c1803m.f6220f;
        throw new C0538f(strM154l, obj instanceof AbstractC0540h ? (AbstractC0540h) obj : null);
    }

    /* JADX INFO: renamed from: n */
    public final int m1472n() {
        int i3 = this.f1308a;
        if (i3 == 2) {
            if (!this.f1663i) {
                return 5;
            }
            this.f1663i = false;
            this.f1309b++;
            return 2;
        }
        if (i3 == 1) {
            int i4 = this.f1309b;
            this.f1309b = i4 + 1;
            return i4 < 0 ? 0 : 1;
        }
        int i5 = this.f1309b + 1;
        this.f1309b = i5;
        return i5 == 0 ? 0 : 3;
    }

    public C0640e(int i3, C0640e c0640e, C1803m c1803m, Object obj) {
        this.f1308a = i3;
        this.f1658d = c0640e;
        this.f1659e = c1803m;
        this.f1309b = -1;
        this.f1662h = obj;
    }
}
