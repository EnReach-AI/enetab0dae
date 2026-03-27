package p047P0;

import p042N0.AbstractC0547o;
import p042N0.EnumC0548p;

/* JADX INFO: renamed from: P0.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0576c extends AbstractC0547o {

    /* JADX INFO: renamed from: d */
    public final C0576c f1434d;

    /* JADX INFO: renamed from: e */
    public C0576c f1435e;

    /* JADX INFO: renamed from: f */
    public String f1436f;

    /* JADX INFO: renamed from: g */
    public C0575b f1437g;

    /* JADX INFO: renamed from: h */
    public boolean f1438h;

    /* JADX INFO: renamed from: i */
    public boolean f1439i;

    public C0576c(int i3, C0576c c0576c, C0575b c0575b, boolean z3) {
        this.f1308a = i3;
        this.f1434d = c0576c;
        this.f1437g = c0575b;
        this.f1309b = -1;
        this.f1438h = z3;
        this.f1439i = false;
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: a */
    public final String mo1213a() {
        return this.f1436f;
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: b */
    public final Object mo1214b() {
        return null;
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: c */
    public final AbstractC0547o mo1215c() {
        return this.f1434d;
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: g */
    public final void mo1219g(Object obj) {
    }

    /* JADX INFO: renamed from: i */
    public final void m1294i(StringBuilder sb) {
        C0576c c0576c = this.f1434d;
        if (c0576c != null) {
            c0576c.m1294i(sb);
        }
        int i3 = this.f1308a;
        if (i3 == 2) {
            sb.append('{');
            if (this.f1436f != null) {
                sb.append('\"');
                sb.append(this.f1436f);
                sb.append('\"');
            } else {
                sb.append('?');
            }
            sb.append('}');
            return;
        }
        if (i3 != 1) {
            sb.append("/");
            return;
        }
        sb.append('[');
        int i4 = this.f1309b;
        if (i4 < 0) {
            i4 = 0;
        }
        sb.append(i4);
        sb.append(']');
    }

    /* JADX INFO: renamed from: j */
    public final C0575b m1295j(C0575b c0575b) {
        int i3 = this.f1308a;
        if (i3 == 2) {
            return c0575b;
        }
        this.f1309b++;
        if (i3 == 1) {
            c0575b.getClass();
            return c0575b;
        }
        c0575b.getClass();
        return c0575b;
    }

    /* JADX INFO: renamed from: k */
    public final C0576c m1296k(C0575b c0575b, boolean z3) {
        C0576c c0576c = this.f1435e;
        if (c0576c == null) {
            C0576c c0576c2 = new C0576c(1, this, c0575b, z3);
            this.f1435e = c0576c2;
            return c0576c2;
        }
        c0576c.f1308a = 1;
        c0576c.f1437g = c0575b;
        c0576c.f1309b = -1;
        c0576c.f1436f = null;
        c0576c.f1438h = z3;
        c0576c.f1439i = false;
        return c0576c;
    }

    /* JADX INFO: renamed from: l */
    public final C0576c m1297l(C0575b c0575b, boolean z3) {
        C0576c c0576c = this.f1435e;
        if (c0576c == null) {
            C0576c c0576c2 = new C0576c(2, this, c0575b, z3);
            this.f1435e = c0576c2;
            return c0576c2;
        }
        c0576c.f1308a = 2;
        c0576c.f1437g = c0575b;
        c0576c.f1309b = -1;
        c0576c.f1436f = null;
        c0576c.f1438h = z3;
        c0576c.f1439i = false;
        return c0576c;
    }

    /* JADX INFO: renamed from: m */
    public final EnumC0548p m1298m() {
        if (!this.f1438h) {
            this.f1438h = true;
            return this.f1308a == 2 ? EnumC0548p.START_OBJECT : EnumC0548p.START_ARRAY;
        }
        if (!this.f1439i || this.f1308a != 2) {
            return null;
        }
        this.f1439i = false;
        return EnumC0548p.FIELD_NAME;
    }

    @Override // p042N0.AbstractC0547o
    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        m1294i(sb);
        return sb.toString();
    }
}
