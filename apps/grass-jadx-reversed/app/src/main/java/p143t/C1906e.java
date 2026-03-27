package p143t;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p140s.AbstractC1869i;
import p140s.C1864d;
import p140s.C1865e;
import p140s.C1868h;
import p147u.C1929e;

/* JADX INFO: renamed from: t.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1906e {

    /* JADX INFO: renamed from: a */
    public C1865e f6660a;

    /* JADX INFO: renamed from: b */
    public boolean f6661b;

    /* JADX INFO: renamed from: c */
    public boolean f6662c;

    /* JADX INFO: renamed from: d */
    public C1865e f6663d;

    /* JADX INFO: renamed from: e */
    public ArrayList f6664e;

    /* JADX INFO: renamed from: f */
    public C1929e f6665f;

    /* JADX INFO: renamed from: g */
    public C1903b f6666g;

    /* JADX INFO: renamed from: h */
    public ArrayList f6667h;

    /* JADX INFO: renamed from: a */
    public final void m4241a(C1907f c1907f, int i3, ArrayList arrayList, C1912k c1912k) {
        AbstractC1914m abstractC1914m = c1907f.f6671d;
        if (abstractC1914m.f6688c == null) {
            C1865e c1865e = this.f6660a;
            if (abstractC1914m == c1865e.f6494d || abstractC1914m == c1865e.f6495e) {
                return;
            }
            if (c1912k == null) {
                c1912k = new C1912k();
                c1912k.f6682a = null;
                c1912k.f6683b = new ArrayList();
                c1912k.f6682a = abstractC1914m;
                arrayList.add(c1912k);
            }
            abstractC1914m.f6688c = c1912k;
            c1912k.f6683b.add(abstractC1914m);
            C1907f c1907f2 = abstractC1914m.f6693h;
            for (InterfaceC1905d interfaceC1905d : c1907f2.f6678k) {
                if (interfaceC1905d instanceof C1907f) {
                    m4241a((C1907f) interfaceC1905d, i3, arrayList, c1912k);
                }
            }
            C1907f c1907f3 = abstractC1914m.f6694i;
            for (InterfaceC1905d interfaceC1905d2 : c1907f3.f6678k) {
                if (interfaceC1905d2 instanceof C1907f) {
                    m4241a((C1907f) interfaceC1905d2, i3, arrayList, c1912k);
                }
            }
            if (i3 == 1 && (abstractC1914m instanceof C1913l)) {
                for (InterfaceC1905d interfaceC1905d3 : ((C1913l) abstractC1914m).f6684k.f6678k) {
                    if (interfaceC1905d3 instanceof C1907f) {
                        m4241a((C1907f) interfaceC1905d3, i3, arrayList, c1912k);
                    }
                }
            }
            Iterator it = c1907f2.f6679l.iterator();
            while (it.hasNext()) {
                m4241a((C1907f) it.next(), i3, arrayList, c1912k);
            }
            Iterator it2 = c1907f3.f6679l.iterator();
            while (it2.hasNext()) {
                m4241a((C1907f) it2.next(), i3, arrayList, c1912k);
            }
            if (i3 == 1 && (abstractC1914m instanceof C1913l)) {
                Iterator it3 = ((C1913l) abstractC1914m).f6684k.f6679l.iterator();
                while (it3.hasNext()) {
                    m4241a((C1907f) it3.next(), i3, arrayList, c1912k);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:167:0x0268 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0206 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0191 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0008 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0195  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m4242b(p140s.C1865e r20) {
        /*
            Method dump skipped, instruction units count: 795
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p143t.C1906e.m4242b(s.e):void");
    }

    /* JADX INFO: renamed from: c */
    public final void m4243c() {
        ArrayList<AbstractC1914m> arrayList = this.f6664e;
        arrayList.clear();
        C1865e c1865e = this.f6663d;
        c1865e.f6494d.mo4236f();
        C1913l c1913l = c1865e.f6495e;
        c1913l.mo4236f();
        arrayList.add(c1865e.f6494d);
        arrayList.add(c1913l);
        HashSet hashSet = null;
        for (C1864d c1864d : c1865e.f6517d0) {
            if (c1864d instanceof C1868h) {
                C1909h c1909h = new C1909h(c1864d);
                c1864d.f6494d.mo4236f();
                c1864d.f6495e.mo4236f();
                c1909h.f6691f = ((C1868h) c1864d).f6590h0;
                arrayList.add(c1909h);
            } else {
                if (c1864d.m4161q()) {
                    if (c1864d.f6490b == null) {
                        c1864d.f6490b = new C1904c(c1864d, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(c1864d.f6490b);
                } else {
                    arrayList.add(c1864d.f6494d);
                }
                if (c1864d.m4162r()) {
                    if (c1864d.f6492c == null) {
                        c1864d.f6492c = new C1904c(c1864d, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(c1864d.f6492c);
                } else {
                    arrayList.add(c1864d.f6495e);
                }
                if (c1864d instanceof AbstractC1869i) {
                    arrayList.add(new C1910i(c1864d));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((AbstractC1914m) it.next()).mo4236f();
        }
        for (AbstractC1914m abstractC1914m : arrayList) {
            if (abstractC1914m.f6687b != c1865e) {
                abstractC1914m.mo4234d();
            }
        }
        ArrayList arrayList2 = this.f6667h;
        arrayList2.clear();
        C1865e c1865e2 = this.f6660a;
        m4245e(c1865e2.f6494d, 0, arrayList2);
        m4245e(c1865e2.f6495e, 1, arrayList2);
        this.f6661b = false;
    }

    /* JADX INFO: renamed from: d */
    public final int m4244d(C1865e c1865e, int i3) {
        ArrayList arrayList;
        int i4;
        int i5;
        long jMax;
        float f3;
        C1865e c1865e2 = c1865e;
        ArrayList arrayList2 = this.f6667h;
        int size = arrayList2.size();
        int i6 = 0;
        long jMax2 = 0;
        while (i6 < size) {
            AbstractC1914m abstractC1914m = ((C1912k) arrayList2.get(i6)).f6682a;
            if (!(abstractC1914m instanceof C1904c) ? !(i3 != 0 ? (abstractC1914m instanceof C1913l) : (abstractC1914m instanceof C1911j)) : ((C1904c) abstractC1914m).f6691f != i3) {
                C1907f c1907f = (i3 == 0 ? c1865e2.f6494d : c1865e2.f6495e).f6693h;
                C1907f c1907f2 = (i3 == 0 ? c1865e2.f6494d : c1865e2.f6495e).f6694i;
                boolean zContains = abstractC1914m.f6693h.f6679l.contains(c1907f);
                C1907f c1907f3 = abstractC1914m.f6694i;
                boolean zContains2 = c1907f3.f6679l.contains(c1907f2);
                long jMo4237j = abstractC1914m.mo4237j();
                C1907f c1907f4 = abstractC1914m.f6693h;
                if (zContains && zContains2) {
                    long jM4256b = C1912k.m4256b(c1907f4, 0L);
                    ArrayList arrayList3 = arrayList2;
                    i4 = size;
                    long jM4255a = C1912k.m4255a(c1907f3, 0L);
                    long j2 = jM4256b - jMo4237j;
                    int i7 = c1907f3.f6673f;
                    arrayList = arrayList3;
                    i5 = i6;
                    if (j2 >= (-i7)) {
                        j2 += (long) i7;
                    }
                    long j3 = (-jM4255a) - jMo4237j;
                    long j4 = c1907f4.f6673f;
                    long j5 = j3 - j4;
                    if (j5 >= j4) {
                        j5 -= j4;
                    }
                    C1864d c1864d = abstractC1914m.f6687b;
                    if (i3 == 0) {
                        f3 = c1864d.f6480S;
                    } else if (i3 == 1) {
                        f3 = c1864d.f6481T;
                    } else {
                        c1864d.getClass();
                        f3 = -1.0f;
                    }
                    float f4 = f3 > 0.0f ? (long) ((j2 / (1.0f - f3)) + (j5 / f3)) : 0L;
                    jMax = (((long) c1907f4.f6673f) + ((((long) ((f4 * f3) + 0.5f)) + jMo4237j) + ((long) (((1.0f - f3) * f4) + 0.5f)))) - ((long) c1907f3.f6673f);
                } else {
                    arrayList = arrayList2;
                    i4 = size;
                    i5 = i6;
                    jMax = zContains ? Math.max(C1912k.m4256b(c1907f4, c1907f4.f6673f), ((long) c1907f4.f6673f) + jMo4237j) : zContains2 ? Math.max(-C1912k.m4255a(c1907f3, c1907f3.f6673f), ((long) (-c1907f3.f6673f)) + jMo4237j) : (abstractC1914m.mo4237j() + ((long) c1907f4.f6673f)) - ((long) c1907f3.f6673f);
                }
            } else {
                arrayList = arrayList2;
                i4 = size;
                i5 = i6;
                jMax = 0;
            }
            jMax2 = Math.max(jMax2, jMax);
            i6 = i5 + 1;
            c1865e2 = c1865e;
            size = i4;
            arrayList2 = arrayList;
        }
        return (int) jMax2;
    }

    /* JADX INFO: renamed from: e */
    public final void m4245e(AbstractC1914m abstractC1914m, int i3, ArrayList arrayList) {
        C1907f c1907f;
        Iterator it = abstractC1914m.f6693h.f6678k.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            c1907f = abstractC1914m.f6694i;
            if (!zHasNext) {
                break;
            }
            InterfaceC1905d interfaceC1905d = (InterfaceC1905d) it.next();
            if (interfaceC1905d instanceof C1907f) {
                m4241a((C1907f) interfaceC1905d, i3, arrayList, null);
            } else if (interfaceC1905d instanceof AbstractC1914m) {
                m4241a(((AbstractC1914m) interfaceC1905d).f6693h, i3, arrayList, null);
            }
        }
        for (InterfaceC1905d interfaceC1905d2 : c1907f.f6678k) {
            if (interfaceC1905d2 instanceof C1907f) {
                m4241a((C1907f) interfaceC1905d2, i3, arrayList, null);
            } else if (interfaceC1905d2 instanceof AbstractC1914m) {
                m4241a(((AbstractC1914m) interfaceC1905d2).f6694i, i3, arrayList, null);
            }
        }
        if (i3 == 1) {
            for (InterfaceC1905d interfaceC1905d3 : ((C1913l) abstractC1914m).f6684k.f6678k) {
                if (interfaceC1905d3 instanceof C1907f) {
                    m4241a((C1907f) interfaceC1905d3, i3, arrayList, null);
                }
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m4246f(int i3, int i4, int i5, int i6, C1864d c1864d) {
        C1903b c1903b = this.f6666g;
        c1903b.f6648a = i3;
        c1903b.f6649b = i5;
        c1903b.f6650c = i4;
        c1903b.f6651d = i6;
        this.f6665f.m4326a(c1864d, c1903b);
        c1864d.m4169y(c1903b.f6652e);
        c1864d.m4166v(c1903b.f6653f);
        c1864d.f6513w = c1903b.f6655h;
        int i7 = c1903b.f6654g;
        c1864d.f6477P = i7;
        c1864d.f6513w = i7 > 0;
    }

    /* JADX INFO: renamed from: g */
    public final void m4247g() {
        C1902a c1902a;
        for (C1864d c1864d : this.f6660a.f6517d0) {
            if (!c1864d.f6488a) {
                int[] iArr = c1864d.f6493c0;
                boolean z3 = false;
                int i3 = iArr[0];
                int i4 = iArr[1];
                int i5 = c1864d.f6500j;
                int i6 = c1864d.f6501k;
                boolean z4 = i3 == 2 || (i3 == 3 && i5 == 1);
                if (i4 == 2 || (i4 == 3 && i6 == 1)) {
                    z3 = true;
                }
                C1911j c1911j = c1864d.f6494d;
                C1908g c1908g = c1911j.f6690e;
                boolean z5 = c1908g.f6677j;
                C1913l c1913l = c1864d.f6495e;
                C1908g c1908g2 = c1913l.f6690e;
                boolean z6 = c1908g2.f6677j;
                if (z5 && z6) {
                    m4246f(1, c1908g.f6674g, 1, c1908g2.f6674g, c1864d);
                    c1864d.f6488a = true;
                } else if (z5 && z3) {
                    m4246f(1, c1908g.f6674g, 2, c1908g2.f6674g, c1864d);
                    if (i4 == 3) {
                        c1913l.f6690e.f6680m = c1864d.m4153i();
                    } else {
                        c1913l.f6690e.mo4250d(c1864d.m4153i());
                        c1864d.f6488a = true;
                    }
                } else if (z6 && z4) {
                    m4246f(2, c1908g.f6674g, 1, c1908g2.f6674g, c1864d);
                    if (i3 == 3) {
                        c1911j.f6690e.f6680m = c1864d.m4156l();
                    } else {
                        c1911j.f6690e.mo4250d(c1864d.m4156l());
                        c1864d.f6488a = true;
                    }
                }
                if (c1864d.f6488a && (c1902a = c1913l.f6685l) != null) {
                    c1902a.mo4250d(c1864d.f6477P);
                }
            }
        }
    }
}
