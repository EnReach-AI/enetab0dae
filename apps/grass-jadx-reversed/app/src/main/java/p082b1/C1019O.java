package p082b1;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import p039M0.C0480b;
import p039M0.EnumC0495j;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0721l;
import p069X0.C0703E;
import p069X0.EnumC0731v;
import p074Z0.AbstractC0832r;
import p077a0.C0846e;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: b1.O */
/* JADX INFO: loaded from: classes.dex */
public final class C1019O {

    /* JADX INFO: renamed from: a */
    public final AbstractC0832r f3615a;

    /* JADX INFO: renamed from: b */
    public final C1013I f3616b;

    /* JADX INFO: renamed from: c */
    public final boolean f3617c;

    /* JADX INFO: renamed from: d */
    public final AbstractC0721l f3618d;

    /* JADX INFO: renamed from: e */
    public final C1033d f3619e;

    /* JADX INFO: renamed from: f */
    public final C1029Z f3620f;

    /* JADX INFO: renamed from: g */
    public final AbstractC0711b f3621g;

    /* JADX INFO: renamed from: h */
    public final boolean f3622h;

    /* JADX INFO: renamed from: i */
    public final boolean f3623i;

    /* JADX INFO: renamed from: j */
    public boolean f3624j;

    /* JADX INFO: renamed from: k */
    public LinkedHashMap f3625k;

    /* JADX INFO: renamed from: l */
    public LinkedList f3626l;

    /* JADX INFO: renamed from: m */
    public LinkedList f3627m;

    /* JADX INFO: renamed from: n */
    public LinkedList f3628n;

    /* JADX INFO: renamed from: o */
    public LinkedList f3629o;

    /* JADX INFO: renamed from: p */
    public LinkedList f3630p;

    /* JADX INFO: renamed from: q */
    public LinkedList f3631q;

    /* JADX INFO: renamed from: r */
    public LinkedList f3632r;

    /* JADX INFO: renamed from: s */
    public HashSet f3633s;

    /* JADX INFO: renamed from: t */
    public LinkedHashMap f3634t;

    public C1019O(AbstractC0832r abstractC0832r, boolean z3, AbstractC0721l abstractC0721l, C1033d c1033d, C1013I c1013i) {
        this.f3615a = abstractC0832r;
        this.f3617c = z3;
        this.f3618d = abstractC0721l;
        this.f3619e = c1033d;
        this.f3623i = AbstractC1745j.m3901x(abstractC0721l.f2036e);
        abstractC0832r.getClass();
        if (abstractC0832r.m2157l(EnumC0731v.USE_ANNOTATIONS)) {
            this.f3622h = true;
            this.f3621g = abstractC0832r.m2149d();
        } else {
            this.f3622h = false;
            this.f3621g = AbstractC1017M.f3608e;
        }
        this.f3620f = abstractC0832r.mo2152g(abstractC0721l.f2036e, c1033d);
        this.f3616b = c1013i;
        abstractC0832r.m2157l(EnumC0731v.USE_STD_BEAN_NAMING);
    }

    /* JADX INFO: renamed from: f */
    public static boolean m2739f(C1025V c1025v, List list) {
        if (list != null) {
            String str = c1025v.f3645j.f1928e;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (((C1025V) list.get(i3)).f3645j.f1928e.equals(str)) {
                    list.set(i3, c1025v);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: g */
    public static boolean m2740g(List list) {
        do {
            AbstractC1041l abstractC1041l = (AbstractC1041l) list.get(0);
            AbstractC1041l abstractC1041l2 = (AbstractC1041l) list.get(1);
            if (abstractC1041l instanceof C1039j) {
                if (!(abstractC1041l2 instanceof C1043n)) {
                    return false;
                }
                list.remove(0);
            } else {
                if (!(abstractC1041l instanceof C1043n) || !(abstractC1041l2 instanceof C1039j)) {
                    return false;
                }
                list.remove(1);
            }
        } while (list.size() > 1);
        return true;
    }

    /* JADX INFO: renamed from: a */
    public final void m2741a(LinkedHashMap linkedHashMap, C1047r c1047r, String str) {
        String str2;
        C1025V c1025vM2745e;
        AbstractC0711b abstractC0711b = this.f3621g;
        if (str != null) {
            str2 = str;
        } else {
            abstractC0711b.mo1785p(c1047r);
            str2 = "";
        }
        C0703E c0703eMo1794v = abstractC0711b.mo1794v(c1047r);
        boolean z3 = (c0703eMo1794v == null || c0703eMo1794v.m1688c()) ? false : true;
        if (!z3) {
            if (str2.isEmpty()) {
                return;
            }
            EnumC0495j enumC0495jMo1763e = abstractC0711b.mo1763e(this.f3615a, c1047r.f3714g);
            boolean z4 = str != null;
            if ((enumC0495jMo1763e == null || enumC0495jMo1763e == EnumC0495j.f1145h) && !z4) {
                return;
            } else {
                c0703eMo1794v = C0703E.m1686a(str2);
            }
        }
        String strM2742b = m2742b(str2);
        if (z3 && strM2742b.isEmpty()) {
            String str3 = c0703eMo1794v.f1928e;
            c1025vM2745e = (C1025V) linkedHashMap.get(str3);
            if (c1025vM2745e == null) {
                c1025vM2745e = new C1025V(this.f3615a, this.f3621g, this.f3617c, c0703eMo1794v, c0703eMo1794v);
                linkedHashMap.put(str3, c1025vM2745e);
            }
        } else {
            c1025vM2745e = m2745e(linkedHashMap, strM2742b);
        }
        C1025V c1025v = c1025vM2745e;
        c1025v.f3647l = new C0846e(c1047r, c1025v.f3647l, c0703eMo1794v, z3, true, false);
        this.f3626l.add(c1025v);
    }

    /* JADX INFO: renamed from: b */
    public final String m2742b(String str) {
        return str;
    }

    /* JADX INFO: renamed from: c */
    public final void m2743c(String str) {
        if (this.f3617c || str == null) {
            return;
        }
        if (this.f3633s == null) {
            this.f3633s = new HashSet();
        }
        this.f3633s.add(str);
    }

    /* JADX INFO: renamed from: d */
    public final void m2744d(C0480b c0480b, AbstractC1041l abstractC1041l) {
        if (c0480b == null) {
            return;
        }
        if (this.f3634t == null) {
            this.f3634t = new LinkedHashMap();
        }
        LinkedHashMap linkedHashMap = this.f3634t;
        Object obj = c0480b.f1120e;
        AbstractC1041l abstractC1041l2 = (AbstractC1041l) linkedHashMap.put(obj, abstractC1041l);
        if (abstractC1041l2 == null || abstractC1041l2.getClass() != abstractC1041l.getClass()) {
            return;
        }
        m2747i("Duplicate injectable value with id '%s' (of type %s)", obj, AbstractC1745j.m3883f(obj));
        throw null;
    }

    /* JADX INFO: renamed from: e */
    public final C1025V m2745e(LinkedHashMap linkedHashMap, String str) {
        C1025V c1025v = (C1025V) linkedHashMap.get(str);
        if (c1025v != null) {
            return c1025v;
        }
        C0703E c0703eM1686a = C0703E.m1686a(str);
        C1025V c1025v2 = new C1025V(this.f3615a, this.f3621g, this.f3617c, c0703eM1686a, c0703eM1686a);
        linkedHashMap.put(str, c1025v2);
        return c1025v2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:199:0x03ba, code lost:
    
        r12 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x056f A[PHI: r13
      0x056f: PHI (r13v40 M0.H) = (r13v39 M0.H), (r13v41 M0.H) binds: [B:337:0x05b2, B:313:0x056d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:494:0x08b0  */
    /* JADX INFO: renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2746h() {
        /*
            Method dump skipped, instruction units count: 2761
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p082b1.C1019O.m2746h():void");
    }

    /* JADX INFO: renamed from: i */
    public final void m2747i(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        throw new IllegalArgumentException("Problem with definition of " + this.f3619e + ": " + str);
    }
}
