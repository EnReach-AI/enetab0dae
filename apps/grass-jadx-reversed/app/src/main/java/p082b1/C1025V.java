package p082b1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import p005B.AbstractC0032g;
import p019F0.C0221e;
import p039M0.C0453A;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0721l;
import p069X0.C0702D;
import p069X0.C0703E;
import p069X0.C0710a;
import p074Z0.AbstractC0832r;
import p077a0.C0846e;
import p114l1.C1675q;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: b1.V */
/* JADX INFO: loaded from: classes.dex */
public final class C1025V extends AbstractC1007C implements Comparable {

    /* JADX INFO: renamed from: q */
    public static final C0710a f3640q = new C0710a(1, "");

    /* JADX INFO: renamed from: f */
    public final boolean f3641f;

    /* JADX INFO: renamed from: g */
    public final AbstractC0832r f3642g;

    /* JADX INFO: renamed from: h */
    public final AbstractC0711b f3643h;

    /* JADX INFO: renamed from: i */
    public final C0703E f3644i;

    /* JADX INFO: renamed from: j */
    public final C0703E f3645j;

    /* JADX INFO: renamed from: k */
    public C0846e f3646k;

    /* JADX INFO: renamed from: l */
    public C0846e f3647l;

    /* JADX INFO: renamed from: m */
    public C0846e f3648m;

    /* JADX INFO: renamed from: n */
    public C0846e f3649n;

    /* JADX INFO: renamed from: o */
    public transient C0702D f3650o;

    /* JADX INFO: renamed from: p */
    public transient C0710a f3651p;

    public C1025V(AbstractC0832r abstractC0832r, AbstractC0711b abstractC0711b, boolean z3, C0703E c0703e, C0703E c0703e2) {
        this.f3642g = abstractC0832r;
        this.f3643h = abstractC0711b;
        this.f3645j = c0703e;
        this.f3644i = c0703e2;
        this.f3641f = z3;
    }

    /* JADX INFO: renamed from: C */
    public static boolean m2749C(C0846e c0846e) {
        while (c0846e != null) {
            if (((C0703E) c0846e.f2517g) != null && c0846e.f2512b) {
                return true;
            }
            c0846e = (C0846e) c0846e.f2516f;
        }
        return false;
    }

    /* JADX INFO: renamed from: D */
    public static boolean m2750D(C0846e c0846e) {
        while (c0846e != null) {
            if (((C0703E) c0846e.f2517g) != null && (!r0.f1928e.isEmpty())) {
                return true;
            }
            c0846e = (C0846e) c0846e.f2516f;
        }
        return false;
    }

    /* JADX INFO: renamed from: E */
    public static boolean m2751E(C0846e c0846e) {
        C0703E c0703e;
        while (c0846e != null) {
            if (!c0846e.f2514d && (c0703e = (C0703E) c0846e.f2517g) != null && (!c0703e.f1928e.isEmpty())) {
                return true;
            }
            c0846e = (C0846e) c0846e.f2516f;
        }
        return false;
    }

    /* JADX INFO: renamed from: F */
    public static boolean m2752F(C0846e c0846e) {
        while (c0846e != null) {
            if (c0846e.f2514d) {
                return true;
            }
            c0846e = (C0846e) c0846e.f2516f;
        }
        return false;
    }

    /* JADX INFO: renamed from: G */
    public static boolean m2753G(C0846e c0846e) {
        while (c0846e != null) {
            if (c0846e.f2513c) {
                return true;
            }
            c0846e = (C0846e) c0846e.f2516f;
        }
        return false;
    }

    /* JADX INFO: renamed from: H */
    public static C0846e m2754H(C0846e c0846e, C0221e c0221e) {
        AbstractC1041l abstractC1041l = (AbstractC1041l) ((AbstractC1041l) c0846e.f2515e).mo2773n(c0221e);
        C0846e c0846e2 = (C0846e) c0846e.f2516f;
        if (c0846e2 != null) {
            c0846e = c0846e.m2179i(m2754H(c0846e2, c0221e));
        }
        if (abstractC1041l == c0846e.f2515e) {
            return c0846e;
        }
        return new C0846e(abstractC1041l, (C0846e) c0846e.f2516f, (C0703E) c0846e.f2517g, c0846e.f2512b, c0846e.f2513c, c0846e.f2514d);
    }

    /* JADX INFO: renamed from: J */
    public static Set m2755J(C0846e c0846e, Set set) {
        C0703E c0703e;
        while (c0846e != null) {
            if (c0846e.f2512b && (c0703e = (C0703E) c0846e.f2517g) != null) {
                if (set == null) {
                    set = new HashSet();
                }
                set.add(c0703e);
            }
            c0846e = (C0846e) c0846e.f2516f;
        }
        return set;
    }

    /* JADX INFO: renamed from: K */
    public static C0221e m2756K(C0846e c0846e) {
        C0221e c0221e = ((AbstractC1041l) c0846e.f2515e).f3700f;
        C0846e c0846e2 = (C0846e) c0846e.f2516f;
        return c0846e2 != null ? C0221e.m439x(c0221e, m2756K(c0846e2)) : c0221e;
    }

    /* JADX INFO: renamed from: L */
    public static int m2757L(C1043n c1043n) {
        String name = c1043n.f3704h.getName();
        if (!name.startsWith("get") || name.length() <= 3) {
            return (!name.startsWith("is") || name.length() <= 2) ? 3 : 2;
        }
        return 1;
    }

    /* JADX INFO: renamed from: M */
    public static C0221e m2758M(int i3, C0846e... c0846eArr) {
        C0221e c0221eM2756K = m2756K(c0846eArr[i3]);
        do {
            i3++;
            if (i3 >= c0846eArr.length) {
                return c0221eM2756K;
            }
        } while (c0846eArr[i3] == null);
        return C0221e.m439x(c0221eM2756K, m2758M(i3, c0846eArr));
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: A */
    public final boolean mo2704A() {
        return m2749C(this.f3646k) || m2749C(this.f3648m) || m2749C(this.f3649n) || m2749C(this.f3647l);
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: B */
    public final boolean mo2705B() {
        Boolean bool = (Boolean) m2762P(new C1021Q(this, 1));
        return bool != null && bool.booleanValue();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v0 ??, still in use, count: 1, list:
          (r8v0 ?? I:java.lang.Object) from 0x0025: INVOKE (r11v0 ?? I:java.util.HashMap), (r1v11 ?? I:java.lang.Object), (r8v0 ?? I:java.lang.Object) VIRTUAL call: java.util.HashMap.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    /* JADX INFO: renamed from: I */
    public final void m2759I(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v0 ??, still in use, count: 1, list:
          (r8v0 ?? I:java.lang.Object) from 0x0025: INVOKE (r11v0 ?? I:java.util.HashMap), (r1v11 ?? I:java.lang.Object), (r8v0 ?? I:java.lang.Object) VIRTUAL call: java.util.HashMap.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:303)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */

    /* JADX INFO: renamed from: N */
    public final C1043n m2760N(C1043n c1043n, C1043n c1043n2) {
        Class<?> declaringClass = c1043n.f3704h.getDeclaringClass();
        Class<?> declaringClass2 = c1043n2.f3704h.getDeclaringClass();
        if (declaringClass != declaringClass2) {
            if (declaringClass.isAssignableFrom(declaringClass2)) {
                return c1043n2;
            }
            if (declaringClass2.isAssignableFrom(declaringClass)) {
                return c1043n;
            }
        }
        String name = c1043n2.f3704h.getName();
        char c3 = 2;
        char c4 = (!name.startsWith("set") || name.length() <= 3) ? (char) 2 : (char) 1;
        String name2 = c1043n.f3704h.getName();
        if (name2.startsWith("set") && name2.length() > 3) {
            c3 = 1;
        }
        if (c4 != c3) {
            return c4 < c3 ? c1043n2 : c1043n;
        }
        AbstractC0711b abstractC0711b = this.f3643h;
        if (abstractC0711b == null) {
            return null;
        }
        return abstractC0711b.mo1790r0(c1043n, c1043n2);
    }

    /* JADX INFO: renamed from: O */
    public final void m2761O(C1025V c1025v) {
        C0846e c0846eM2171a = this.f3646k;
        C0846e c0846e = c1025v.f3646k;
        if (c0846eM2171a == null) {
            c0846eM2171a = c0846e;
        } else if (c0846e != null) {
            c0846eM2171a = c0846eM2171a.m2171a(c0846e);
        }
        this.f3646k = c0846eM2171a;
        C0846e c0846eM2171a2 = this.f3647l;
        C0846e c0846e2 = c1025v.f3647l;
        if (c0846eM2171a2 == null) {
            c0846eM2171a2 = c0846e2;
        } else if (c0846e2 != null) {
            c0846eM2171a2 = c0846eM2171a2.m2171a(c0846e2);
        }
        this.f3647l = c0846eM2171a2;
        C0846e c0846eM2171a3 = this.f3648m;
        C0846e c0846e3 = c1025v.f3648m;
        if (c0846eM2171a3 == null) {
            c0846eM2171a3 = c0846e3;
        } else if (c0846e3 != null) {
            c0846eM2171a3 = c0846eM2171a3.m2171a(c0846e3);
        }
        this.f3648m = c0846eM2171a3;
        C0846e c0846eM2171a4 = this.f3649n;
        C0846e c0846e4 = c1025v.f3649n;
        if (c0846eM2171a4 == null) {
            c0846eM2171a4 = c0846e4;
        } else if (c0846e4 != null) {
            c0846eM2171a4 = c0846eM2171a4.m2171a(c0846e4);
        }
        this.f3649n = c0846eM2171a4;
    }

    /* JADX INFO: renamed from: P */
    public final Object m2762P(InterfaceC1024U interfaceC1024U) {
        C0846e c0846e;
        C0846e c0846e2;
        if (this.f3643h == null) {
            return null;
        }
        if (this.f3641f) {
            C0846e c0846e3 = this.f3648m;
            if (c0846e3 != null) {
                objMo2748a = interfaceC1024U.mo2748a((AbstractC1041l) c0846e3.f2515e);
            }
        } else {
            C0846e c0846e4 = this.f3647l;
            objMo2748a = c0846e4 != null ? interfaceC1024U.mo2748a((AbstractC1041l) c0846e4.f2515e) : null;
            if (objMo2748a == null && (c0846e = this.f3649n) != null) {
                objMo2748a = interfaceC1024U.mo2748a((AbstractC1041l) c0846e.f2515e);
            }
        }
        return (objMo2748a != null || (c0846e2 = this.f3646k) == null) ? objMo2748a : interfaceC1024U.mo2748a((AbstractC1041l) c0846e2.f2515e);
    }

    /* JADX INFO: renamed from: Q */
    public final AbstractC1041l m2763Q() {
        if (this.f3641f) {
            return m2714m();
        }
        AbstractC1041l abstractC1041lMo2715n = mo2715n();
        if (abstractC1041lMo2715n == null && (abstractC1041lMo2715n = mo2721t()) == null) {
            abstractC1041lMo2715n = mo2717p();
        }
        return abstractC1041lMo2715n == null ? m2714m() : abstractC1041lMo2715n;
    }

    /* JADX INFO: renamed from: R */
    public final void m2764R() {
        C0846e c0846eM2180j = this.f3646k;
        if (c0846eM2180j != null) {
            c0846eM2180j = c0846eM2180j.m2180j();
        }
        this.f3646k = c0846eM2180j;
        C0846e c0846eM2180j2 = this.f3648m;
        if (c0846eM2180j2 != null) {
            c0846eM2180j2 = c0846eM2180j2.m2180j();
        }
        this.f3648m = c0846eM2180j2;
        C0846e c0846eM2180j3 = this.f3649n;
        if (c0846eM2180j3 != null) {
            c0846eM2180j3 = c0846eM2180j3.m2180j();
        }
        this.f3649n = c0846eM2180j3;
        C0846e c0846eM2180j4 = this.f3647l;
        if (c0846eM2180j4 != null) {
            c0846eM2180j4 = c0846eM2180j4.m2180j();
        }
        this.f3647l = c0846eM2180j4;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: a */
    public final C0703E mo2706a() {
        return this.f3644i;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d4  */
    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p069X0.C0702D mo2707b() {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p082b1.C1025V.mo2707b():X0.D");
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        C1025V c1025v = (C1025V) obj;
        if (this.f3647l != null) {
            if (c1025v.f3647l == null) {
                return -1;
            }
        } else if (c1025v.f3647l != null) {
            return 1;
        }
        return mo1808f().compareTo(c1025v.mo1808f());
    }

    @Override // p118m1.InterfaceC1758w
    /* JADX INFO: renamed from: f */
    public final String mo1808f() {
        C0703E c0703e = this.f3644i;
        if (c0703e == null) {
            return null;
        }
        return c0703e.f1928e;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: g */
    public final boolean mo2708g() {
        return (this.f3647l == null && this.f3649n == null && this.f3646k == null) ? false : true;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: h */
    public final boolean mo2709h() {
        return (this.f3648m == null && this.f3646k == null) ? false : true;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: i */
    public final C0453A mo2710i() {
        AbstractC1041l abstractC1041lM2714m = m2714m();
        AbstractC0711b abstractC0711b = this.f3643h;
        C0453A c0453aMo1739K = abstractC0711b == null ? null : abstractC0711b.mo1739K(abstractC1041lM2714m);
        return c0453aMo1739K == null ? C0453A.f1095i : c0453aMo1739K;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: j */
    public final C1018N mo2711j() {
        return (C1018N) m2762P(new C1022S(this, 1));
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: k */
    public final C0710a mo2712k() {
        C0710a c0710a = this.f3651p;
        C0710a c0710a2 = f3640q;
        if (c0710a != null) {
            if (c0710a == c0710a2) {
                return null;
            }
            return c0710a;
        }
        C0710a c0710a3 = (C0710a) m2762P(new C1022S(this, 0));
        if (c0710a3 != null) {
            c0710a2 = c0710a3;
        }
        this.f3651p = c0710a2;
        return c0710a3;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: l */
    public final Class[] mo2713l() {
        return (Class[]) m2762P(new C1021Q(this, 0));
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: n */
    public final C1047r mo2715n() {
        C0846e c0846e = this.f3647l;
        if (c0846e == null) {
            return null;
        }
        do {
            Object obj = c0846e.f2515e;
            if (((C1047r) obj).f3714g instanceof C1036g) {
                return (C1047r) obj;
            }
            c0846e = (C0846e) c0846e.f2516f;
        } while (c0846e != null);
        return (C1047r) this.f3647l.f2515e;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: o */
    public final Iterator mo2716o() {
        C0846e c0846e = this.f3647l;
        if (c0846e == null) {
            return AbstractC1745j.f6112c;
        }
        C1023T c1023t = new C1023T();
        c1023t.f3639e = c0846e;
        return c1023t;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: p */
    public final C1039j mo2717p() {
        C0846e c0846e = this.f3646k;
        if (c0846e == null) {
            return null;
        }
        C1039j c1039j = (C1039j) c0846e.f2515e;
        for (C0846e c0846e2 = (C0846e) c0846e.f2516f; c0846e2 != null; c0846e2 = (C0846e) c0846e2.f2516f) {
            C1039j c1039j2 = (C1039j) c0846e2.f2515e;
            Class<?> declaringClass = c1039j.f3694g.getDeclaringClass();
            Class<?> declaringClass2 = c1039j2.f3694g.getDeclaringClass();
            if (declaringClass != declaringClass2) {
                if (declaringClass.isAssignableFrom(declaringClass2)) {
                    c1039j = c1039j2;
                } else if (declaringClass2.isAssignableFrom(declaringClass)) {
                }
            }
            throw new IllegalArgumentException("Multiple fields representing property \"" + mo1808f() + "\": " + c1039j.mo2800j() + " vs " + c1039j2.mo2800j());
        }
        return c1039j;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p082b1.C1043n mo2718q() {
        /*
            r7 = this;
            a0.e r0 = r7.f3648m
            if (r0 != 0) goto L6
            r0 = 0
            return r0
        L6:
            java.lang.Object r1 = r0.f2516f
            a0.e r1 = (p077a0.C0846e) r1
            if (r1 != 0) goto L11
            java.lang.Object r0 = r0.f2515e
            b1.n r0 = (p082b1.C1043n) r0
            return r0
        L11:
            java.lang.Object r2 = r0.f2515e
            if (r1 == 0) goto L79
            b1.n r2 = (p082b1.C1043n) r2
            java.lang.reflect.Method r3 = r2.f3704h
            java.lang.Class r3 = r3.getDeclaringClass()
            java.lang.Object r4 = r1.f2515e
            b1.n r4 = (p082b1.C1043n) r4
            java.lang.reflect.Method r5 = r4.f3704h
            java.lang.Class r5 = r5.getDeclaringClass()
            if (r3 == r5) goto L37
            boolean r6 = r3.isAssignableFrom(r5)
            if (r6 == 0) goto L30
            goto L43
        L30:
            boolean r3 = r5.isAssignableFrom(r3)
            if (r3 == 0) goto L37
            goto L44
        L37:
            int r3 = m2757L(r4)
            int r5 = m2757L(r2)
            if (r3 == r5) goto L49
            if (r3 >= r5) goto L44
        L43:
            r0 = r1
        L44:
            java.lang.Object r1 = r1.f2516f
            a0.e r1 = (p077a0.C0846e) r1
            goto L11
        L49:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Conflicting getter definitions for property \""
            r1.<init>(r3)
            java.lang.String r3 = r7.mo1808f()
            r1.append(r3)
            java.lang.String r3 = "\": "
            r1.append(r3)
            java.lang.String r2 = r2.mo2800j()
            r1.append(r2)
            java.lang.String r2 = " vs "
            r1.append(r2)
            java.lang.String r2 = r4.mo2800j()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L79:
            a0.e r0 = r0.m2181k()
            r7.f3648m = r0
            b1.n r2 = (p082b1.C1043n) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p082b1.C1025V.mo2718q():b1.n");
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: r */
    public final AbstractC0721l mo2719r() {
        if (this.f3641f) {
            AbstractC1031b abstractC1031bMo2718q = mo2718q();
            return (abstractC1031bMo2718q == null && (abstractC1031bMo2718q = mo2717p()) == null) ? C1675q.m3773n() : abstractC1031bMo2718q.mo2769f();
        }
        AbstractC1031b abstractC1031bMo2715n = mo2715n();
        if (abstractC1031bMo2715n == null) {
            C1043n c1043nMo2721t = mo2721t();
            if (c1043nMo2721t != null) {
                return c1043nMo2721t.mo2791t(0);
            }
            abstractC1031bMo2715n = mo2717p();
        }
        return (abstractC1031bMo2715n == null && (abstractC1031bMo2715n = mo2718q()) == null) ? C1675q.m3773n() : abstractC1031bMo2715n.mo2769f();
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: s */
    public final Class mo2720s() {
        return mo2719r().f2036e;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: t */
    public final C1043n mo2721t() {
        Object obj;
        C0846e c0846e = this.f3649n;
        if (c0846e == null) {
            return null;
        }
        C0846e c0846e2 = (C0846e) c0846e.f2516f;
        if (c0846e2 == null) {
            return (C1043n) c0846e.f2515e;
        }
        while (true) {
            Object obj2 = c0846e.f2515e;
            if (c0846e2 == null) {
                this.f3649n = c0846e.m2181k();
                return (C1043n) obj2;
            }
            Object obj3 = c0846e2.f2515e;
            C1043n c1043nM2760N = m2760N((C1043n) obj2, (C1043n) obj3);
            C0846e c0846e3 = (C0846e) c0846e2.f2516f;
            if (c1043nM2760N != obj2) {
                if (c1043nM2760N != obj3) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(obj2);
                    arrayList.add(obj3);
                    while (true) {
                        obj = c0846e.f2515e;
                        if (c0846e3 == null) {
                            break;
                        }
                        Object obj4 = c0846e3.f2515e;
                        C1043n c1043nM2760N2 = m2760N((C1043n) obj, (C1043n) obj4);
                        if (c1043nM2760N2 != obj) {
                            if (c1043nM2760N2 == obj4) {
                                arrayList.clear();
                                c0846e = c0846e3;
                            } else {
                                arrayList.add(obj4);
                            }
                        }
                        c0846e3 = (C0846e) c0846e3.f2516f;
                    }
                    if (arrayList.isEmpty()) {
                        this.f3649n = c0846e.m2181k();
                        return (C1043n) obj;
                    }
                    throw new IllegalArgumentException(AbstractC0032g.m155m("Conflicting setter definitions for property \"", mo1808f(), "\": ", (String) arrayList.stream().map(new C1020P()).collect(Collectors.joining(" vs "))));
                }
                c0846e = c0846e2;
            }
            c0846e2 = c0846e3;
        }
    }

    public final String toString() {
        return "[Property '" + this.f3644i + "'; ctors: " + this.f3647l + ", field(s): " + this.f3646k + ", getter(s): " + this.f3648m + ", setter(s): " + this.f3649n + "]";
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: u */
    public final C0703E mo2722u() {
        AbstractC0711b abstractC0711b;
        if (m2763Q() == null || (abstractC0711b = this.f3643h) == null) {
            return null;
        }
        abstractC0711b.getClass();
        return null;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: v */
    public final boolean mo2723v() {
        return this.f3647l != null;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: w */
    public final boolean mo2724w() {
        return this.f3646k != null;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: x */
    public final boolean mo2725x(C0703E c0703e) {
        return this.f3644i.equals(c0703e);
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: y */
    public final boolean mo2726y() {
        return this.f3649n != null;
    }

    @Override // p082b1.AbstractC1007C
    /* JADX INFO: renamed from: z */
    public final boolean mo2727z() {
        return m2750D(this.f3646k) || m2750D(this.f3648m) || m2750D(this.f3649n) || m2749C(this.f3647l);
    }

    public C1025V(C1025V c1025v, C0703E c0703e) {
        this.f3642g = c1025v.f3642g;
        this.f3643h = c1025v.f3643h;
        this.f3645j = c1025v.f3645j;
        this.f3644i = c0703e;
        this.f3646k = c1025v.f3646k;
        this.f3647l = c1025v.f3647l;
        this.f3648m = c1025v.f3648m;
        this.f3649n = c1025v.f3649n;
        this.f3641f = c1025v.f3641f;
    }
}
