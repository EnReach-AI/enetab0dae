package p143t;

import java.util.ArrayList;
import java.util.Iterator;
import p136r.AbstractC1849h;
import p140s.C1863c;
import p140s.C1864d;
import p140s.C1865e;

/* JADX INFO: renamed from: t.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1904c extends AbstractC1914m {

    /* JADX INFO: renamed from: k */
    public final ArrayList f6658k;

    /* JADX INFO: renamed from: l */
    public int f6659l;

    public C1904c(C1864d c1864d, int i3) {
        C1864d c1864d2;
        super(c1864d);
        this.f6658k = new ArrayList();
        this.f6691f = i3;
        C1864d c1864d3 = this.f6687b;
        C1864d c1864dM4155k = c1864d3.m4155k(i3);
        while (true) {
            C1864d c1864d4 = c1864dM4155k;
            c1864d2 = c1864d3;
            c1864d3 = c1864d4;
            if (c1864d3 == null) {
                break;
            } else {
                c1864dM4155k = c1864d3.m4155k(this.f6691f);
            }
        }
        this.f6687b = c1864d2;
        int i4 = this.f6691f;
        AbstractC1914m abstractC1914m = i4 == 0 ? c1864d2.f6494d : i4 == 1 ? c1864d2.f6495e : null;
        ArrayList<AbstractC1914m> arrayList = this.f6658k;
        arrayList.add(abstractC1914m);
        C1864d c1864dM4154j = c1864d2.m4154j(this.f6691f);
        while (c1864dM4154j != null) {
            int i5 = this.f6691f;
            arrayList.add(i5 == 0 ? c1864dM4154j.f6494d : i5 == 1 ? c1864dM4154j.f6495e : null);
            c1864dM4154j = c1864dM4154j.m4154j(this.f6691f);
        }
        for (AbstractC1914m abstractC1914m2 : arrayList) {
            int i6 = this.f6691f;
            if (i6 == 0) {
                abstractC1914m2.f6687b.f6490b = this;
            } else if (i6 == 1) {
                abstractC1914m2.f6687b.f6492c = this;
            }
        }
        if (this.f6691f == 0 && ((C1865e) this.f6687b.f6470I).f6521h0 && arrayList.size() > 1) {
            this.f6687b = ((AbstractC1914m) arrayList.get(arrayList.size() - 1)).f6687b;
        }
        this.f6659l = this.f6691f == 0 ? this.f6687b.f6485X : this.f6687b.f6486Y;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x01c2 A[PHI: r2 r25
      0x01c2: PHI (r2v71 int) = (r2v67 int), (r2v76 int) binds: [B:120:0x01c0, B:111:0x01a0] A[DONT_GENERATE, DONT_INLINE]
      0x01c2: PHI (r25v1 float) = (r25v0 float), (r25v3 float) binds: [B:120:0x01c0, B:111:0x01a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0155  */
    @Override // p143t.InterfaceC1905d
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo4233a(p143t.InterfaceC1905d r27) {
        /*
            Method dump skipped, instruction units count: 999
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p143t.C1904c.mo4233a(t.d):void");
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: d */
    public final void mo4234d() {
        ArrayList arrayList = this.f6658k;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((AbstractC1914m) it.next()).mo4234d();
        }
        int size = arrayList.size();
        if (size < 1) {
            return;
        }
        C1864d c1864d = ((AbstractC1914m) arrayList.get(0)).f6687b;
        C1864d c1864d2 = ((AbstractC1914m) arrayList.get(size - 1)).f6687b;
        int i3 = this.f6691f;
        C1907f c1907f = this.f6694i;
        C1907f c1907f2 = this.f6693h;
        if (i3 == 0) {
            C1863c c1863c = c1864d.f6514x;
            C1863c c1863c2 = c1864d2.f6516z;
            C1907f c1907fM4260i = AbstractC1914m.m4260i(c1863c, 0);
            int iM4139c = c1863c.m4139c();
            C1864d c1864dM4239m = m4239m();
            if (c1864dM4239m != null) {
                iM4139c = c1864dM4239m.f6514x.m4139c();
            }
            if (c1907fM4260i != null) {
                AbstractC1914m.m4258b(c1907f2, c1907fM4260i, iM4139c);
            }
            C1907f c1907fM4260i2 = AbstractC1914m.m4260i(c1863c2, 0);
            int iM4139c2 = c1863c2.m4139c();
            C1864d c1864dM4240n = m4240n();
            if (c1864dM4240n != null) {
                iM4139c2 = c1864dM4240n.f6516z.m4139c();
            }
            if (c1907fM4260i2 != null) {
                AbstractC1914m.m4258b(c1907f, c1907fM4260i2, -iM4139c2);
            }
        } else {
            C1863c c1863c3 = c1864d.f6515y;
            C1863c c1863c4 = c1864d2.f6462A;
            C1907f c1907fM4260i3 = AbstractC1914m.m4260i(c1863c3, 1);
            int iM4139c3 = c1863c3.m4139c();
            C1864d c1864dM4239m2 = m4239m();
            if (c1864dM4239m2 != null) {
                iM4139c3 = c1864dM4239m2.f6515y.m4139c();
            }
            if (c1907fM4260i3 != null) {
                AbstractC1914m.m4258b(c1907f2, c1907fM4260i3, iM4139c3);
            }
            C1907f c1907fM4260i4 = AbstractC1914m.m4260i(c1863c4, 1);
            int iM4139c4 = c1863c4.m4139c();
            C1864d c1864dM4240n2 = m4240n();
            if (c1864dM4240n2 != null) {
                iM4139c4 = c1864dM4240n2.f6462A.m4139c();
            }
            if (c1907fM4260i4 != null) {
                AbstractC1914m.m4258b(c1907f, c1907fM4260i4, -iM4139c4);
            }
        }
        c1907f2.f6668a = this;
        c1907f.f6668a = this;
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: e */
    public final void mo4235e() {
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f6658k;
            if (i3 >= arrayList.size()) {
                return;
            }
            ((AbstractC1914m) arrayList.get(i3)).mo4235e();
            i3++;
        }
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: f */
    public final void mo4236f() {
        this.f6688c = null;
        Iterator it = this.f6658k.iterator();
        while (it.hasNext()) {
            ((AbstractC1914m) it.next()).mo4236f();
        }
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: j */
    public final long mo4237j() {
        ArrayList arrayList = this.f6658k;
        int size = arrayList.size();
        long jMo4237j = 0;
        for (int i3 = 0; i3 < size; i3++) {
            AbstractC1914m abstractC1914m = (AbstractC1914m) arrayList.get(i3);
            jMo4237j = ((long) abstractC1914m.f6694i.f6673f) + abstractC1914m.mo4237j() + jMo4237j + ((long) abstractC1914m.f6693h.f6673f);
        }
        return jMo4237j;
    }

    @Override // p143t.AbstractC1914m
    /* JADX INFO: renamed from: k */
    public final boolean mo4238k() {
        ArrayList arrayList = this.f6658k;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!((AbstractC1914m) arrayList.get(i3)).mo4238k()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: m */
    public final C1864d m4239m() {
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f6658k;
            if (i3 >= arrayList.size()) {
                return null;
            }
            C1864d c1864d = ((AbstractC1914m) arrayList.get(i3)).f6687b;
            if (c1864d.f6483V != 8) {
                return c1864d;
            }
            i3++;
        }
    }

    /* JADX INFO: renamed from: n */
    public final C1864d m4240n() {
        ArrayList arrayList = this.f6658k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            C1864d c1864d = ((AbstractC1914m) arrayList.get(size)).f6687b;
            if (c1864d.f6483V != 8) {
                return c1864d;
            }
        }
        return null;
    }

    public final String toString() {
        String strConcat = "ChainRun ".concat(this.f6691f == 0 ? "horizontal : " : "vertical : ");
        for (AbstractC1914m abstractC1914m : this.f6658k) {
            strConcat = AbstractC1849h.m4117a(AbstractC1849h.m4117a(strConcat, "<") + abstractC1914m, "> ");
        }
        return strConcat;
    }
}
