package p082b1;

import com.fasterxml.jackson.databind.JsonDeserializer$None;
import com.fasterxml.jackson.databind.JsonSerializer$None;
import com.fasterxml.jackson.databind.ext.AbstractC1211c;
import com.fasterxml.jackson.databind.ser.impl.C1213a;
import com.fasterxml.jackson.databind.ser.std.RawSerializer;
import java.io.Closeable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p005B.AbstractC0032g;
import p033K0.AbstractC0406d;
import p039M0.AbstractC0473V;
import p039M0.AbstractC0487e0;
import p039M0.C0453A;
import p039M0.C0455C;
import p039M0.C0466N;
import p039M0.C0480b;
import p039M0.C0500o;
import p039M0.C0502q;
import p039M0.C0508w;
import p039M0.EnumC0460H;
import p039M0.EnumC0471T;
import p039M0.EnumC0472U;
import p039M0.EnumC0481b0;
import p039M0.EnumC0490g;
import p039M0.EnumC0495j;
import p039M0.EnumC0499n;
import p039M0.EnumC0501p;
import p039M0.EnumC0511z;
import p039M0.InterfaceC0454B;
import p039M0.InterfaceC0456D;
import p039M0.InterfaceC0457E;
import p039M0.InterfaceC0458F;
import p039M0.InterfaceC0459G;
import p039M0.InterfaceC0461I;
import p039M0.InterfaceC0462J;
import p039M0.InterfaceC0463K;
import p039M0.InterfaceC0464L;
import p039M0.InterfaceC0465M;
import p039M0.InterfaceC0467O;
import p039M0.InterfaceC0468P;
import p039M0.InterfaceC0469Q;
import p039M0.InterfaceC0470S;
import p039M0.InterfaceC0474W;
import p039M0.InterfaceC0475X;
import p039M0.InterfaceC0476Y;
import p039M0.InterfaceC0477Z;
import p039M0.InterfaceC0478a;
import p039M0.InterfaceC0479a0;
import p039M0.InterfaceC0482c;
import p039M0.InterfaceC0484d;
import p039M0.InterfaceC0486e;
import p039M0.InterfaceC0488f;
import p039M0.InterfaceC0492h;
import p039M0.InterfaceC0494i;
import p039M0.InterfaceC0496k;
import p039M0.InterfaceC0497l;
import p039M0.InterfaceC0498m;
import p039M0.InterfaceC0503r;
import p039M0.InterfaceC0504s;
import p039M0.InterfaceC0505t;
import p039M0.InterfaceC0506u;
import p039M0.InterfaceC0507v;
import p039M0.InterfaceC0509x;
import p039M0.InterfaceC0510y;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0729t;
import p069X0.C0702D;
import p069X0.C0703E;
import p069X0.C0710a;
import p069X0.C0724o;
import p069X0.EnumC0731v;
import p071Y0.C0744h;
import p071Y0.EnumC0747k;
import p071Y0.InterfaceC0737a;
import p071Y0.InterfaceC0739c;
import p071Y0.InterfaceC0740d;
import p071Y0.InterfaceC0741e;
import p071Y0.InterfaceC0742f;
import p071Y0.InterfaceC0743g;
import p071Y0.InterfaceC0745i;
import p071Y0.InterfaceC0748l;
import p071Y0.InterfaceC0749m;
import p071Y0.InterfaceC0750n;
import p071Y0.InterfaceC0751o;
import p074Z0.AbstractC0832r;
import p100g1.C1394c;
import p103h1.AbstractC1429q;
import p103h1.C1426n;
import p112k1.AbstractC1645m;
import p114l1.AbstractC1665g;
import p114l1.C1675q;
import p118m1.AbstractC1745j;
import p118m1.AbstractC1747l;
import p118m1.AbstractC1757v;
import p118m1.C1726A;
import p118m1.C1752q;
import p118m1.C1753r;
import p118m1.C1754s;
import p118m1.C1756u;

/* JADX INFO: renamed from: b1.J */
/* JADX INFO: loaded from: classes.dex */
public final class C1014J extends AbstractC0711b {

    /* JADX INFO: renamed from: g */
    public static final Class[] f3601g = {InterfaceC0748l.class, InterfaceC0479a0.class, InterfaceC0503r.class, InterfaceC0474W.class, InterfaceC0464L.class, InterfaceC0476Y.class, InterfaceC0494i.class, InterfaceC0458F.class};

    /* JADX INFO: renamed from: h */
    public static final Class[] f3602h = {InterfaceC0742f.class, InterfaceC0479a0.class, InterfaceC0503r.class, InterfaceC0474W.class, InterfaceC0476Y.class, InterfaceC0494i.class, InterfaceC0458F.class, InterfaceC0459G.class};
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public transient C1752q f3603e;

    /* JADX INFO: renamed from: f */
    public boolean f3604f;

    static {
        try {
            int i3 = AbstractC1211c.f4118a;
        } catch (Throwable th) {
            AbstractC0406d.m904n(th);
        }
    }

    /* JADX INFO: renamed from: s0 */
    public static Class m2734s0(Class cls) {
        if (cls == null || AbstractC1745j.m3897t(cls)) {
            return null;
        }
        return cls;
    }

    /* JADX INFO: renamed from: t0 */
    public static C0724o m2735t0(IllegalArgumentException illegalArgumentException, String str) {
        return new C0724o((Closeable) null, str, illegalArgumentException);
    }

    /* JADX INFO: renamed from: u0 */
    public static C1426n m2736u0(AbstractC0832r abstractC0832r, AbstractC1031b abstractC1031b) {
        C1426n c1426n;
        InterfaceC0474W interfaceC0474W = (InterfaceC0474W) abstractC1031b.mo2774c(InterfaceC0474W.class);
        InterfaceC0750n interfaceC0750n = (InterfaceC0750n) abstractC1031b.mo2774c(InterfaceC0750n.class);
        AbstractC1429q abstractC1429q = null;
        if (interfaceC0750n != null) {
            if (interfaceC0474W == null) {
                return null;
            }
            Class clsValue = interfaceC0750n.value();
            abstractC0832r.m2153h();
            c1426n = (C1426n) AbstractC1745j.m3885h(clsValue, abstractC0832r.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS));
        } else {
            if (interfaceC0474W == null) {
                return null;
            }
            EnumC0472U enumC0472UUse = interfaceC0474W.use();
            EnumC0472U enumC0472U = EnumC0472U.f1113f;
            if (enumC0472UUse == enumC0472U) {
                C1426n c1426n2 = new C1426n();
                c1426n2.f5052a = enumC0472U;
                c1426n2.f5057f = null;
                c1426n2.f5054c = null;
                return c1426n2;
            }
            c1426n = new C1426n();
        }
        InterfaceC0749m interfaceC0749m = (InterfaceC0749m) abstractC1031b.mo2774c(InterfaceC0749m.class);
        if (interfaceC0749m != null) {
            Class clsValue2 = interfaceC0749m.value();
            abstractC0832r.m2153h();
            abstractC1429q = (AbstractC1429q) AbstractC1745j.m3885h(clsValue2, abstractC0832r.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS));
        }
        EnumC0472U enumC0472UUse2 = interfaceC0474W.use();
        if (enumC0472UUse2 == null) {
            c1426n.getClass();
            throw new IllegalArgumentException("idType cannot be null");
        }
        c1426n.f5052a = enumC0472UUse2;
        c1426n.f5057f = abstractC1429q;
        c1426n.f5054c = enumC0472UUse2.f1118e;
        EnumC0471T enumC0471TInclude = interfaceC0474W.include();
        if (enumC0471TInclude == EnumC0471T.f1110h && (abstractC1031b instanceof C1033d)) {
            enumC0471TInclude = EnumC0471T.f1107e;
        }
        if (enumC0471TInclude == null) {
            throw new IllegalArgumentException("includeAs cannot be null");
        }
        c1426n.f5053b = enumC0471TInclude;
        String strProperty = interfaceC0474W.property();
        if (strProperty == null || strProperty.isEmpty()) {
            strProperty = c1426n.f5052a.f1118e;
        }
        c1426n.f5054c = strProperty;
        Class clsDefaultImpl = interfaceC0474W.defaultImpl();
        if (clsDefaultImpl != AbstractC0473V.class && !clsDefaultImpl.isAnnotation()) {
            c1426n.f5056e = clsDefaultImpl;
        }
        c1426n.f5055d = interfaceC0474W.visible();
        return c1426n;
    }

    /* JADX INFO: renamed from: v0 */
    public static boolean m2737v0(AbstractC0721l abstractC0721l, Class cls) {
        return abstractC0721l.f2036e.isPrimitive() ? abstractC0721l.m1883r(AbstractC1745j.m3871A(cls)) : cls.isPrimitive() && cls == AbstractC1745j.m3871A(abstractC0721l.f2036e);
    }

    /* JADX INFO: renamed from: w0 */
    public static boolean m2738w0(Class cls, Class cls2) {
        return cls.isPrimitive() ? cls == AbstractC1745j.m3871A(cls2) : cls2.isPrimitive() && cls2 == AbstractC1745j.m3871A(cls);
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: A */
    public final C1018N mo1729A(AbstractC1031b abstractC1031b, C1018N c1018n) {
        InterfaceC0506u interfaceC0506u = (InterfaceC0506u) abstractC1031b.mo2774c(InterfaceC0506u.class);
        if (interfaceC0506u == null) {
            return c1018n;
        }
        if (c1018n == null) {
            c1018n = C1018N.f3609f;
        }
        boolean zAlwaysAsId = interfaceC0506u.alwaysAsId();
        return c1018n.f3614e == zAlwaysAsId ? c1018n : new C1018N(c1018n.f3610a, c1018n.f3613d, c1018n.f3611b, zAlwaysAsId, c1018n.f3612c);
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: B */
    public final Class mo1730B(C1033d c1033d) {
        InterfaceC0742f interfaceC0742f = (InterfaceC0742f) c1033d.f3674n.mo442a(InterfaceC0742f.class);
        if (interfaceC0742f == null) {
            return null;
        }
        return m2734s0(interfaceC0742f.builder());
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: C */
    public final C0744h mo1731C(C1033d c1033d) {
        InterfaceC0745i interfaceC0745i = (InterfaceC0745i) c1033d.mo2774c(InterfaceC0745i.class);
        if (interfaceC0745i == null) {
            return null;
        }
        String strBuildMethodName = interfaceC0745i.buildMethodName();
        String strWithPrefix = interfaceC0745i.withPrefix();
        C0744h c0744h = new C0744h();
        c0744h.f2104a = strBuildMethodName;
        c0744h.f2105b = strWithPrefix;
        return c0744h;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: D */
    public final EnumC0460H mo1732D(AbstractC1031b abstractC1031b) {
        InterfaceC0461I interfaceC0461I = (InterfaceC0461I) abstractC1031b.mo2774c(InterfaceC0461I.class);
        if (interfaceC0461I != null) {
            return interfaceC0461I.access();
        }
        return null;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: E */
    public final List mo1733E(AbstractC1041l abstractC1041l) {
        InterfaceC0484d interfaceC0484d = (InterfaceC0484d) abstractC1041l.mo2774c(InterfaceC0484d.class);
        if (interfaceC0484d == null) {
            return null;
        }
        String[] strArrValue = interfaceC0484d.value();
        int length = strArrValue.length;
        if (length == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(length);
        for (String str : strArrValue) {
            arrayList.add(C0703E.m1686a(str));
        }
        return arrayList;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: F */
    public final C1426n mo1734F(AbstractC0832r abstractC0832r, AbstractC1041l abstractC1041l, AbstractC0721l abstractC0721l) {
        if (abstractC0721l.mo1874i() != null) {
            return m2736u0(abstractC0832r, abstractC1041l);
        }
        throw new IllegalArgumentException("Must call method with a container or reference type (got " + abstractC0721l + ")");
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: G */
    public final String mo1735G(AbstractC1031b abstractC1031b) {
        InterfaceC0461I interfaceC0461I = (InterfaceC0461I) abstractC1031b.mo2774c(InterfaceC0461I.class);
        if (interfaceC0461I == null) {
            return null;
        }
        String strDefaultValue = interfaceC0461I.defaultValue();
        if (strDefaultValue.isEmpty()) {
            return null;
        }
        return strDefaultValue;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: H */
    public final String mo1736H(AbstractC1031b abstractC1031b) {
        InterfaceC0462J interfaceC0462J = (InterfaceC0462J) abstractC1031b.mo2774c(InterfaceC0462J.class);
        if (interfaceC0462J == null) {
            return null;
        }
        return interfaceC0462J.value();
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: I */
    public final C0508w mo1737I(AbstractC1031b abstractC1031b) {
        Set setEmptySet;
        InterfaceC0509x interfaceC0509x = (InterfaceC0509x) abstractC1031b.mo2774c(InterfaceC0509x.class);
        if (interfaceC0509x == null) {
            return C0508w.f1176j;
        }
        C0508w c0508w = C0508w.f1176j;
        String[] strArrValue = interfaceC0509x.value();
        if (strArrValue == null || strArrValue.length == 0) {
            setEmptySet = Collections.emptySet();
        } else {
            HashSet hashSet = new HashSet(strArrValue.length);
            for (String str : strArrValue) {
                hashSet.add(str);
            }
            setEmptySet = hashSet;
        }
        boolean zIgnoreUnknown = interfaceC0509x.ignoreUnknown();
        boolean zAllowGetters = interfaceC0509x.allowGetters();
        boolean zAllowSetters = interfaceC0509x.allowSetters();
        return C0508w.m1019a(setEmptySet, zIgnoreUnknown, zAllowGetters, zAllowSetters, false) ? C0508w.f1176j : new C0508w(setEmptySet, zIgnoreUnknown, zAllowGetters, zAllowSetters, false);
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: J */
    public final C0508w mo1738J(AbstractC1031b abstractC1031b) {
        return mo1737I(abstractC1031b);
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: K */
    public final C0453A mo1739K(AbstractC1031b abstractC1031b) {
        C0453A c0453a;
        InterfaceC0748l interfaceC0748l;
        InterfaceC0454B interfaceC0454B = (InterfaceC0454B) abstractC1031b.mo2774c(InterfaceC0454B.class);
        EnumC0511z enumC0511z = EnumC0511z.f1186i;
        if (interfaceC0454B == null) {
            c0453a = C0453A.f1095i;
        } else {
            C0453A c0453a2 = C0453A.f1095i;
            EnumC0511z enumC0511zValue = interfaceC0454B.value();
            EnumC0511z enumC0511zContent = interfaceC0454B.content();
            if (enumC0511zValue == enumC0511z && enumC0511zContent == enumC0511z) {
                c0453a = c0453a2;
            } else {
                Class clsValueFilter = interfaceC0454B.valueFilter();
                if (clsValueFilter == Void.class) {
                    clsValueFilter = null;
                }
                Class clsContentFilter = interfaceC0454B.contentFilter();
                c0453a = new C0453A(enumC0511zValue, enumC0511zContent, clsValueFilter, clsContentFilter != Void.class ? clsContentFilter : null);
            }
        }
        if (c0453a.f1096e != enumC0511z || (interfaceC0748l = (InterfaceC0748l) abstractC1031b.mo2774c(InterfaceC0748l.class)) == null) {
            return c0453a;
        }
        int iOrdinal = interfaceC0748l.include().ordinal();
        return iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? c0453a : c0453a.m990b(EnumC0511z.f1184g) : c0453a.m990b(EnumC0511z.f1185h) : c0453a.m990b(EnumC0511z.f1183f) : c0453a.m990b(EnumC0511z.f1182e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.HashSet] */
    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: L */
    public final C0455C mo1740L(AbstractC1031b abstractC1031b) {
        ?? EmptySet;
        InterfaceC0456D interfaceC0456D = (InterfaceC0456D) abstractC1031b.mo2774c(InterfaceC0456D.class);
        if (interfaceC0456D == null) {
            return C0455C.f1100f;
        }
        String[] strArrValue = interfaceC0456D.value();
        if (strArrValue == null || strArrValue.length == 0) {
            EmptySet = Collections.emptySet();
        } else {
            EmptySet = new HashSet(strArrValue.length);
            for (String str : strArrValue) {
                EmptySet.add(str);
            }
        }
        return new C0455C(EmptySet);
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: M */
    public final Integer mo1741M(AbstractC1031b abstractC1031b) {
        int iIndex;
        InterfaceC0461I interfaceC0461I = (InterfaceC0461I) abstractC1031b.mo2774c(InterfaceC0461I.class);
        if (interfaceC0461I == null || (iIndex = interfaceC0461I.index()) == -1) {
            return null;
        }
        return Integer.valueOf(iIndex);
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: N */
    public final C1426n mo1742N(AbstractC0832r abstractC0832r, AbstractC1041l abstractC1041l, AbstractC0721l abstractC0721l) {
        if (abstractC0721l.mo1887v() || abstractC0721l.mo1629b()) {
            return null;
        }
        return m2736u0(abstractC0832r, abstractC1041l);
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: O */
    public final C0710a mo1743O(AbstractC1041l abstractC1041l) {
        InterfaceC0458F interfaceC0458F = (InterfaceC0458F) abstractC1041l.mo2774c(InterfaceC0458F.class);
        if (interfaceC0458F != null) {
            return new C0710a(1, interfaceC0458F.value());
        }
        InterfaceC0494i interfaceC0494i = (InterfaceC0494i) abstractC1041l.mo2774c(InterfaceC0494i.class);
        if (interfaceC0494i != null) {
            return new C0710a(2, interfaceC0494i.value());
        }
        return null;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: P */
    public final C0703E mo1744P(C1033d c1033d) {
        InterfaceC0465M interfaceC0465M = (InterfaceC0465M) c1033d.f3674n.mo442a(InterfaceC0465M.class);
        if (interfaceC0465M == null) {
            return null;
        }
        String strNamespace = interfaceC0465M.namespace();
        return C0703E.m1687b(interfaceC0465M.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: Q */
    public final Object mo1745Q(AbstractC1041l abstractC1041l) {
        Class clsM2734s0;
        InterfaceC0748l interfaceC0748l = (InterfaceC0748l) abstractC1041l.mo2774c(InterfaceC0748l.class);
        if (interfaceC0748l == null || (clsM2734s0 = m2734s0(interfaceC0748l.contentConverter())) == null || clsM2734s0 == AbstractC1747l.class) {
            return null;
        }
        return clsM2734s0;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: R */
    public final Object mo1746R(AbstractC1031b abstractC1031b) {
        Class clsM2734s0;
        InterfaceC0748l interfaceC0748l = (InterfaceC0748l) abstractC1031b.mo2774c(InterfaceC0748l.class);
        if (interfaceC0748l == null || (clsM2734s0 = m2734s0(interfaceC0748l.converter())) == null || clsM2734s0 == AbstractC1747l.class) {
            return null;
        }
        return clsM2734s0;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: S */
    public final String[] mo1747S(C1033d c1033d) {
        InterfaceC0463K interfaceC0463K = (InterfaceC0463K) c1033d.mo2774c(InterfaceC0463K.class);
        if (interfaceC0463K == null) {
            return null;
        }
        return interfaceC0463K.value();
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: T */
    public final Boolean mo1748T(AbstractC1031b abstractC1031b) {
        InterfaceC0463K interfaceC0463K = (InterfaceC0463K) abstractC1031b.mo2774c(InterfaceC0463K.class);
        if (interfaceC0463K == null || !interfaceC0463K.alphabetic()) {
            return null;
        }
        return Boolean.TRUE;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: U */
    public final EnumC0747k mo1749U(AbstractC1031b abstractC1031b) {
        InterfaceC0748l interfaceC0748l = (InterfaceC0748l) abstractC1031b.mo2774c(InterfaceC0748l.class);
        if (interfaceC0748l == null) {
            return null;
        }
        return interfaceC0748l.typing();
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: V */
    public final Object mo1750V(AbstractC1031b abstractC1031b) {
        Class clsUsing;
        InterfaceC0748l interfaceC0748l = (InterfaceC0748l) abstractC1031b.mo2774c(InterfaceC0748l.class);
        if (interfaceC0748l != null && (clsUsing = interfaceC0748l.using()) != JsonSerializer$None.class) {
            return clsUsing;
        }
        InterfaceC0464L interfaceC0464L = (InterfaceC0464L) abstractC1031b.mo2774c(InterfaceC0464L.class);
        if (interfaceC0464L == null || !interfaceC0464L.value()) {
            return null;
        }
        return new RawSerializer(abstractC1031b.mo2768e());
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: W */
    public final C0466N mo1751W(AbstractC1031b abstractC1031b) {
        InterfaceC0467O interfaceC0467O = (InterfaceC0467O) abstractC1031b.mo2774c(InterfaceC0467O.class);
        C0466N c0466n = C0466N.f1104g;
        if (interfaceC0467O == null) {
            return c0466n;
        }
        EnumC0481b0 enumC0481b0Nulls = interfaceC0467O.nulls();
        EnumC0481b0 enumC0481b0ContentNulls = interfaceC0467O.contentNulls();
        EnumC0481b0 enumC0481b0 = EnumC0481b0.f1125h;
        if (enumC0481b0Nulls == null) {
            enumC0481b0Nulls = enumC0481b0;
        }
        if (enumC0481b0ContentNulls == null) {
            enumC0481b0ContentNulls = enumC0481b0;
        }
        return (enumC0481b0Nulls == enumC0481b0 && enumC0481b0ContentNulls == enumC0481b0) ? c0466n : new C0466N(enumC0481b0Nulls, enumC0481b0ContentNulls);
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: X */
    public final List mo1752X(AbstractC1031b abstractC1031b) {
        InterfaceC0469Q interfaceC0469Q = (InterfaceC0469Q) abstractC1031b.mo2774c(InterfaceC0469Q.class);
        if (interfaceC0469Q == null) {
            return null;
        }
        InterfaceC0468P[] interfaceC0468PArrValue = interfaceC0469Q.value();
        if (!interfaceC0469Q.failOnRepeatedNames()) {
            ArrayList arrayList = new ArrayList(interfaceC0468PArrValue.length);
            for (InterfaceC0468P interfaceC0468P : interfaceC0468PArrValue) {
                arrayList.add(new C1394c(interfaceC0468P.value(), interfaceC0468P.name()));
                for (String str : interfaceC0468P.names()) {
                    arrayList.add(new C1394c(interfaceC0468P.value(), str));
                }
            }
            return arrayList;
        }
        String strMo2767d = abstractC1031b.mo2767d();
        ArrayList arrayList2 = new ArrayList(interfaceC0468PArrValue.length);
        HashSet hashSet = new HashSet();
        for (InterfaceC0468P interfaceC0468P2 : interfaceC0468PArrValue) {
            String strName = interfaceC0468P2.name();
            if (!strName.isEmpty() && hashSet.contains(strName)) {
                throw new IllegalArgumentException(AbstractC0032g.m156n("Annotated type [", strMo2767d, "] got repeated subtype name [", strName, "]"));
            }
            hashSet.add(strName);
            arrayList2.add(new C1394c(interfaceC0468P2.value(), strName));
            for (String str2 : interfaceC0468P2.names()) {
                if (!str2.isEmpty() && hashSet.contains(str2)) {
                    throw new IllegalArgumentException(AbstractC0032g.m156n("Annotated type [", strMo2767d, "] got repeated subtype name [", str2, "]"));
                }
                hashSet.add(str2);
                arrayList2.add(new C1394c(interfaceC0468P2.value(), str2));
            }
        }
        return arrayList2;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: Y */
    public final String mo1753Y(C1033d c1033d) {
        InterfaceC0475X interfaceC0475X = (InterfaceC0475X) c1033d.f3674n.mo442a(InterfaceC0475X.class);
        if (interfaceC0475X == null) {
            return null;
        }
        return interfaceC0475X.value();
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: Z */
    public final C1426n mo1754Z(AbstractC0721l abstractC0721l, AbstractC0832r abstractC0832r, C1033d c1033d) {
        return m2736u0(abstractC0832r, c1033d);
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: a */
    public final void mo1755a(AbstractC0832r abstractC0832r, C1033d c1033d, ArrayList arrayList) {
        Class cls;
        InterfaceC0741e interfaceC0741e = (InterfaceC0741e) c1033d.f3674n.mo442a(InterfaceC0741e.class);
        if (interfaceC0741e == null) {
            return;
        }
        boolean zPrepend = interfaceC0741e.prepend();
        InterfaceC0739c[] interfaceC0739cArrAttrs = interfaceC0741e.attrs();
        int length = interfaceC0739cArrAttrs.length;
        AbstractC0721l abstractC0721lM2148c = null;
        int i3 = 0;
        while (true) {
            cls = c1033d.f3666f;
            if (i3 >= length) {
                break;
            }
            if (abstractC0721lM2148c == null) {
                abstractC0721lM2148c = abstractC0832r.m2148c(Object.class);
            }
            InterfaceC0739c interfaceC0739c = interfaceC0739cArrAttrs[i3];
            C0702D c0702d = interfaceC0739c.required() ? C0702D.f1916l : C0702D.f1917m;
            String strValue = interfaceC0739c.value();
            String strPropName = interfaceC0739c.propName();
            String strPropNamespace = interfaceC0739c.propNamespace();
            C0703E c0703eM1686a = strPropName.isEmpty() ? C0703E.f1926h : (strPropNamespace == null || strPropNamespace.isEmpty()) ? C0703E.m1686a(strPropName) : C0703E.m1687b(strPropName, strPropNamespace);
            if (!(!c0703eM1686a.f1928e.isEmpty())) {
                c0703eM1686a = C0703E.m1686a(strValue);
            }
            C1213a c1213a = new C1213a(strValue, C1726A.m3836C(abstractC0832r, new C1028Y(c1033d, cls, strValue, abstractC0721lM2148c), c0703eM1686a, c0702d, interfaceC0739c.include()), c1033d.f3674n, abstractC0721lM2148c);
            if (zPrepend) {
                arrayList.add(i3, c1213a);
            } else {
                arrayList.add(c1213a);
            }
            i3++;
        }
        InterfaceC0740d[] interfaceC0740dArrProps = interfaceC0741e.props();
        if (interfaceC0740dArrProps.length > 0) {
            InterfaceC0740d interfaceC0740d = interfaceC0740dArrProps[0];
            C0702D c0702d2 = interfaceC0740d.required() ? C0702D.f1916l : C0702D.f1917m;
            String strName = interfaceC0740d.name();
            String strNamespace = interfaceC0740d.namespace();
            C0703E c0703eM1686a2 = !strName.isEmpty() ? (strNamespace == null || strNamespace.isEmpty()) ? C0703E.m1686a(strName) : C0703E.m1687b(strName, strNamespace) : C0703E.f1926h;
            C1726A.m3836C(abstractC0832r, new C1028Y(c1033d, cls, c0703eM1686a2.f1928e, abstractC0832r.m2148c(interfaceC0740d.type())), c0703eM1686a2, c0702d2, interfaceC0740d.include());
            Class clsValue = interfaceC0740d.value();
            abstractC0832r.m2153h();
            ((C1213a) ((AbstractC1645m) AbstractC1745j.m3885h(clsValue, abstractC0832r.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS)))).getClass();
            throw new IllegalStateException("Should not be called on this type");
        }
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: a0 */
    public final AbstractC1757v mo1756a0(AbstractC1041l abstractC1041l) {
        InterfaceC0476Y interfaceC0476Y = (InterfaceC0476Y) abstractC1041l.mo2774c(InterfaceC0476Y.class);
        if (interfaceC0476Y == null || !interfaceC0476Y.enabled()) {
            return null;
        }
        String strPrefix = interfaceC0476Y.prefix();
        String strSuffix = interfaceC0476Y.suffix();
        C1756u c1756u = AbstractC1757v.f6136e;
        boolean z3 = (strPrefix == null || strPrefix.isEmpty()) ? false : true;
        boolean z4 = (strSuffix == null || strSuffix.isEmpty()) ? false : true;
        return z3 ? z4 ? new C1753r(strPrefix, strSuffix) : new C1754s(0, strPrefix) : z4 ? new C1754s(1, strSuffix) : AbstractC1757v.f6136e;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: b */
    public final C1029Z mo1757b(C1033d c1033d, C1029Z c1029z) {
        InterfaceC0492h interfaceC0492h = (InterfaceC0492h) c1033d.f3674n.mo442a(InterfaceC0492h.class);
        if (interfaceC0492h == null) {
            return c1029z;
        }
        c1029z.getClass();
        EnumC0490g enumC0490g = interfaceC0492h.getterVisibility();
        EnumC0490g enumC0490g2 = EnumC0490g.f1135h;
        EnumC0490g enumC0490g3 = c1029z.f3657e;
        EnumC0490g enumC0490g4 = enumC0490g == enumC0490g2 ? enumC0490g3 : enumC0490g;
        EnumC0490g enumC0490gIsGetterVisibility = interfaceC0492h.isGetterVisibility();
        EnumC0490g enumC0490g5 = c1029z.f3658f;
        EnumC0490g enumC0490g6 = enumC0490gIsGetterVisibility == enumC0490g2 ? enumC0490g5 : enumC0490gIsGetterVisibility;
        EnumC0490g enumC0490g7 = interfaceC0492h.setterVisibility();
        EnumC0490g enumC0490g8 = c1029z.f3659g;
        if (enumC0490g7 == enumC0490g2) {
            enumC0490g7 = enumC0490g8;
        }
        EnumC0490g enumC0490gCreatorVisibility = interfaceC0492h.creatorVisibility();
        EnumC0490g enumC0490g9 = c1029z.f3660h;
        if (enumC0490gCreatorVisibility == enumC0490g2) {
            enumC0490gCreatorVisibility = enumC0490g9;
        }
        EnumC0490g enumC0490gFieldVisibility = interfaceC0492h.fieldVisibility();
        EnumC0490g enumC0490g10 = c1029z.f3661i;
        if (enumC0490gFieldVisibility == enumC0490g2) {
            enumC0490gFieldVisibility = enumC0490g10;
        }
        return (enumC0490g4 == enumC0490g3 && enumC0490g6 == enumC0490g5 && enumC0490g7 == enumC0490g8 && enumC0490gCreatorVisibility == enumC0490g9 && enumC0490gFieldVisibility == enumC0490g10) ? c1029z : new C1029Z(enumC0490g4, enumC0490g6, enumC0490g7, enumC0490gCreatorVisibility, enumC0490gFieldVisibility);
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: b0 */
    public final Object mo1758b0(C1033d c1033d) {
        InterfaceC0751o interfaceC0751o = (InterfaceC0751o) c1033d.f3674n.mo442a(InterfaceC0751o.class);
        if (interfaceC0751o == null) {
            return null;
        }
        return interfaceC0751o.value();
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: c */
    public final Object mo1759c(AbstractC1031b abstractC1031b) {
        Class clsContentUsing;
        InterfaceC0742f interfaceC0742f = (InterfaceC0742f) abstractC1031b.mo2774c(InterfaceC0742f.class);
        if (interfaceC0742f == null || (clsContentUsing = interfaceC0742f.contentUsing()) == JsonDeserializer$None.class) {
            return null;
        }
        return clsContentUsing;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: c0 */
    public final Class[] mo1760c0(AbstractC1031b abstractC1031b) {
        InterfaceC0479a0 interfaceC0479a0 = (InterfaceC0479a0) abstractC1031b.mo2774c(InterfaceC0479a0.class);
        if (interfaceC0479a0 == null) {
            return null;
        }
        return interfaceC0479a0.value();
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: d */
    public final Object mo1761d(AbstractC1031b abstractC1031b) {
        Class clsContentUsing;
        InterfaceC0748l interfaceC0748l = (InterfaceC0748l) abstractC1031b.mo2774c(InterfaceC0748l.class);
        if (interfaceC0748l == null || (clsContentUsing = interfaceC0748l.contentUsing()) == JsonSerializer$None.class) {
            return null;
        }
        return clsContentUsing;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: d0 */
    public final Boolean mo1762d0(AbstractC1041l abstractC1041l) {
        InterfaceC0486e interfaceC0486e = (InterfaceC0486e) abstractC1041l.mo2774c(InterfaceC0486e.class);
        if (interfaceC0486e == null) {
            return null;
        }
        return Boolean.valueOf(interfaceC0486e.enabled());
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: e */
    public final EnumC0495j mo1763e(AbstractC0832r abstractC0832r, AbstractC1031b abstractC1031b) {
        InterfaceC0496k interfaceC0496k = (InterfaceC0496k) abstractC1031b.mo2774c(InterfaceC0496k.class);
        if (interfaceC0496k != null) {
            return interfaceC0496k.mode();
        }
        if (!this.f3604f || !abstractC0832r.m2157l(EnumC0731v.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES)) {
            return null;
        }
        boolean z3 = abstractC1031b instanceof C1036g;
        return null;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: e0 */
    public final boolean mo1764e0(C1043n c1043n) {
        return c1043n.m2801m(InterfaceC0486e.class);
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: f */
    public final EnumC0495j mo1765f(AbstractC1031b abstractC1031b) {
        InterfaceC0496k interfaceC0496k = (InterfaceC0496k) abstractC1031b.mo2774c(InterfaceC0496k.class);
        if (interfaceC0496k == null) {
            return null;
        }
        return interfaceC0496k.mode();
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: f0 */
    public final Boolean mo1766f0(AbstractC1041l abstractC1041l) {
        InterfaceC0488f interfaceC0488f = (InterfaceC0488f) abstractC1041l.mo2774c(InterfaceC0488f.class);
        if (interfaceC0488f == null) {
            return null;
        }
        return Boolean.valueOf(interfaceC0488f.enabled());
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: g */
    public final Enum mo1767g(Class cls) {
        Annotation[] annotationArr = AbstractC1745j.f6110a;
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() && field.getAnnotation(InterfaceC0497l.class) != null) {
                String name = field.getName();
                for (Enum r8 : (Enum[]) cls.getEnumConstants()) {
                    if (name.equals(r8.name())) {
                        return r8;
                    }
                }
            }
        }
        return null;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: g0 */
    public final Boolean mo1768g0(AbstractC1041l abstractC1041l) {
        InterfaceC0457E interfaceC0457E = (InterfaceC0457E) abstractC1041l.mo2774c(InterfaceC0457E.class);
        if (interfaceC0457E == null) {
            return null;
        }
        return Boolean.valueOf(interfaceC0457E.value());
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: h */
    public final Object mo1769h(AbstractC1041l abstractC1041l) {
        Class clsM2734s0;
        InterfaceC0742f interfaceC0742f = (InterfaceC0742f) abstractC1041l.mo2774c(InterfaceC0742f.class);
        if (interfaceC0742f == null || (clsM2734s0 = m2734s0(interfaceC0742f.contentConverter())) == null || clsM2734s0 == AbstractC1747l.class) {
            return null;
        }
        return clsM2734s0;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: h0 */
    public final Boolean mo1770h0(AbstractC1041l abstractC1041l) {
        InterfaceC0477Z interfaceC0477Z = (InterfaceC0477Z) abstractC1041l.mo2774c(InterfaceC0477Z.class);
        if (interfaceC0477Z == null) {
            return null;
        }
        return Boolean.valueOf(interfaceC0477Z.value());
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: i */
    public final Object mo1771i(AbstractC1031b abstractC1031b) {
        Class clsM2734s0;
        InterfaceC0742f interfaceC0742f = (InterfaceC0742f) abstractC1031b.mo2774c(InterfaceC0742f.class);
        if (interfaceC0742f == null || (clsM2734s0 = m2734s0(interfaceC0742f.converter())) == null || clsM2734s0 == AbstractC1747l.class) {
            return null;
        }
        return clsM2734s0;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: i0 */
    public final boolean mo1772i0(C1043n c1043n) {
        InterfaceC0477Z interfaceC0477Z = (InterfaceC0477Z) c1043n.mo2774c(InterfaceC0477Z.class);
        return interfaceC0477Z != null && interfaceC0477Z.value();
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: j */
    public final Object mo1773j(AbstractC1031b abstractC1031b) {
        Class clsUsing;
        InterfaceC0742f interfaceC0742f = (InterfaceC0742f) abstractC1031b.mo2774c(InterfaceC0742f.class);
        if (interfaceC0742f == null || (clsUsing = interfaceC0742f.using()) == JsonDeserializer$None.class) {
            return null;
        }
        return clsUsing;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: j0 */
    public final boolean mo1774j0(AbstractC1031b abstractC1031b) {
        InterfaceC0496k interfaceC0496k = (InterfaceC0496k) abstractC1031b.mo2774c(InterfaceC0496k.class);
        if (interfaceC0496k != null) {
            return interfaceC0496k.mode() != EnumC0495j.f1145h;
        }
        if (this.f3604f) {
            boolean z3 = abstractC1031b instanceof C1036g;
        }
        return false;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: k */
    public final void mo1775k(Class cls, Enum[] enumArr, String[][] strArr) {
        InterfaceC0484d interfaceC0484d;
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() && (interfaceC0484d = (InterfaceC0484d) field.getAnnotation(InterfaceC0484d.class)) != null) {
                String[] strArrValue = interfaceC0484d.value();
                if (strArrValue.length != 0) {
                    String name = field.getName();
                    int length = enumArr.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        if (name.equals(enumArr[i3].name())) {
                            strArr[i3] = strArrValue;
                        }
                    }
                }
            }
        }
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: k0 */
    public final boolean mo1776k0(AbstractC1041l abstractC1041l) {
        InterfaceC0507v interfaceC0507v = (InterfaceC0507v) abstractC1041l.mo2774c(InterfaceC0507v.class);
        if (interfaceC0507v != null) {
            return interfaceC0507v.value();
        }
        return false;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: l */
    public final Object mo1777l(C1033d c1033d) {
        InterfaceC0737a interfaceC0737a = (InterfaceC0737a) c1033d.f3674n.mo442a(InterfaceC0737a.class);
        if (interfaceC0737a == null) {
            return null;
        }
        return interfaceC0737a.value();
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: l0 */
    public final Boolean mo1778l0(AbstractC1041l abstractC1041l) {
        InterfaceC0461I interfaceC0461I = (InterfaceC0461I) abstractC1041l.mo2774c(InterfaceC0461I.class);
        if (interfaceC0461I != null) {
            return Boolean.valueOf(interfaceC0461I.required());
        }
        return null;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: m */
    public final String[] mo1779m(Class cls, Enum[] enumArr, String[] strArr) {
        InterfaceC0461I interfaceC0461I;
        HashMap map = null;
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() && (interfaceC0461I = (InterfaceC0461I) field.getAnnotation(InterfaceC0461I.class)) != null) {
                String strValue = interfaceC0461I.value();
                if (!strValue.isEmpty()) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put(field.getName(), strValue);
                }
            }
        }
        if (map != null) {
            int length = enumArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                String str = (String) map.get(enumArr[i3].name());
                if (str != null) {
                    strArr[i3] = str;
                }
            }
        }
        return strArr;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: m0 */
    public final boolean mo1780m0(Annotation annotation) {
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        String name = clsAnnotationType.getName();
        Boolean bool = (Boolean) this.f3603e.f6129g.get(name);
        if (bool == null) {
            Boolean boolValueOf = Boolean.valueOf(clsAnnotationType.getAnnotation(InterfaceC0478a.class) != null);
            this.f3603e.f6129g.m3120f(name, boolValueOf, true);
            bool = boolValueOf;
        }
        return bool.booleanValue();
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: n */
    public final Object mo1781n(AbstractC1031b abstractC1031b) {
        InterfaceC0498m interfaceC0498m = (InterfaceC0498m) abstractC1031b.mo2774c(InterfaceC0498m.class);
        if (interfaceC0498m == null) {
            return null;
        }
        String strValue = interfaceC0498m.value();
        if (strValue.isEmpty()) {
            return null;
        }
        return strValue;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: n0 */
    public final Boolean mo1782n0(C1033d c1033d) {
        InterfaceC0510y interfaceC0510y = (InterfaceC0510y) c1033d.f3674n.mo442a(InterfaceC0510y.class);
        if (interfaceC0510y == null) {
            return null;
        }
        return Boolean.valueOf(interfaceC0510y.value());
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: o */
    public final C0502q mo1783o(AbstractC1031b abstractC1031b) {
        InterfaceC0503r interfaceC0503r = (InterfaceC0503r) abstractC1031b.mo2774c(InterfaceC0503r.class);
        if (interfaceC0503r == null) {
            return null;
        }
        String strPattern = interfaceC0503r.pattern();
        EnumC0501p enumC0501pShape = interfaceC0503r.shape();
        String strLocale = interfaceC0503r.locale();
        String strTimezone = interfaceC0503r.timezone();
        EnumC0499n[] enumC0499nArrWith = interfaceC0503r.with();
        EnumC0499n[] enumC0499nArrWithout = interfaceC0503r.without();
        int iOrdinal = 0;
        for (EnumC0499n enumC0499n : enumC0499nArrWith) {
            iOrdinal |= 1 << enumC0499n.ordinal();
        }
        int iOrdinal2 = 0;
        for (EnumC0499n enumC0499n2 : enumC0499nArrWithout) {
            iOrdinal2 |= 1 << enumC0499n2.ordinal();
        }
        return new C0502q(strPattern, enumC0501pShape, strLocale, strTimezone, new C0500o(iOrdinal, iOrdinal2), interfaceC0503r.lenient().m1007a());
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: o0 */
    public final Boolean mo1784o0(AbstractC1041l abstractC1041l) {
        return Boolean.valueOf(abstractC1041l.m2801m(InterfaceC0470S.class));
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: p */
    public final void mo1785p(AbstractC1041l abstractC1041l) {
        if (abstractC1041l instanceof C1047r) {
            AbstractC1048s abstractC1048s = ((C1047r) abstractC1041l).f3714g;
        }
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: p0 */
    public final AbstractC0721l mo1786p0(AbstractC0832r abstractC0832r, AbstractC1031b abstractC1031b, AbstractC0721l abstractC0721l) throws C0724o {
        C1675q c1675q = abstractC0832r.f2481f.f2419e;
        InterfaceC0742f interfaceC0742f = (InterfaceC0742f) abstractC1031b.mo2774c(InterfaceC0742f.class);
        Class clsM2734s0 = interfaceC0742f == null ? null : m2734s0(interfaceC0742f.m1930as());
        if (clsM2734s0 != null && !abstractC0721l.m1883r(clsM2734s0) && !m2737v0(abstractC0721l, clsM2734s0)) {
            try {
                abstractC0721l = c1675q.m3779i(abstractC0721l, clsM2734s0, false);
            } catch (IllegalArgumentException e3) {
                throw m2735t0(e3, String.format("Failed to narrow type %s with annotation (value %s), from '%s': %s", abstractC0721l, clsM2734s0.getName(), abstractC1031b.mo2767d(), e3.getMessage()));
            }
        }
        if (abstractC0721l.mo1890y()) {
            AbstractC0721l abstractC0721lMo1877l = abstractC0721l.mo1877l();
            Class clsM2734s02 = interfaceC0742f == null ? null : m2734s0(interfaceC0742f.keyAs());
            if (clsM2734s02 != null && !m2737v0(abstractC0721lMo1877l, clsM2734s02)) {
                try {
                    abstractC0721l = ((AbstractC1665g) abstractC0721l).mo3750M(c1675q.m3779i(abstractC0721lMo1877l, clsM2734s02, false));
                } catch (IllegalArgumentException e4) {
                    throw m2735t0(e4, String.format("Failed to narrow key type of %s with concrete-type annotation (value %s), from '%s': %s", abstractC0721l, clsM2734s02.getName(), abstractC1031b.mo2767d(), e4.getMessage()));
                }
            }
        }
        AbstractC0721l abstractC0721lMo1874i = abstractC0721l.mo1874i();
        if (abstractC0721lMo1874i == null) {
            return abstractC0721l;
        }
        Class clsM2734s03 = interfaceC0742f != null ? m2734s0(interfaceC0742f.contentAs()) : null;
        if (clsM2734s03 == null || m2737v0(abstractC0721lMo1874i, clsM2734s03)) {
            return abstractC0721l;
        }
        try {
            return abstractC0721l.mo1864C(c1675q.m3779i(abstractC0721lMo1874i, clsM2734s03, false));
        } catch (IllegalArgumentException e5) {
            throw m2735t0(e5, String.format("Failed to narrow value type of %s with concrete-type annotation (value %s), from '%s': %s", abstractC0721l, clsM2734s03.getName(), abstractC1031b.mo2767d(), e5.getMessage()));
        }
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: q */
    public final C0480b mo1787q(AbstractC1041l abstractC1041l) {
        String name;
        InterfaceC0482c interfaceC0482c = (InterfaceC0482c) abstractC1041l.mo2774c(InterfaceC0482c.class);
        if (interfaceC0482c == null) {
            return null;
        }
        String strValue = interfaceC0482c.value();
        Boolean boolM1007a = interfaceC0482c.useInput().m1007a();
        String str = "".equals(strValue) ? null : strValue;
        C0480b c0480b = (str == null && boolM1007a == null) ? C0480b.f1119g : new C0480b(str, boolM1007a);
        Object obj = c0480b.f1120e;
        if (obj != null) {
            return c0480b;
        }
        if (abstractC1041l instanceof C1043n) {
            C1043n c1043n = (C1043n) abstractC1041l;
            name = c1043n.f3704h.getParameterCount() == 0 ? abstractC1041l.mo2768e().getName() : c1043n.mo2792u(0).getName();
        } else {
            name = abstractC1041l.mo2768e().getName();
        }
        return name.equals(obj) ? c0480b : new C0480b(name, c0480b.f1121f);
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: q0 */
    public final AbstractC0721l mo1788q0(AbstractC0832r abstractC0832r, AbstractC1031b abstractC1031b, AbstractC0721l abstractC0721l) throws C0724o {
        AbstractC0721l abstractC0721lMo1868G;
        AbstractC0721l abstractC0721lMo1868G2;
        C1675q c1675q = abstractC0832r.f2481f.f2419e;
        InterfaceC0748l interfaceC0748l = (InterfaceC0748l) abstractC1031b.mo2774c(InterfaceC0748l.class);
        Class<?> clsM2734s0 = interfaceC0748l == null ? null : m2734s0(interfaceC0748l.m1931as());
        if (clsM2734s0 != null) {
            if (abstractC0721l.m1883r(clsM2734s0)) {
                abstractC0721l = abstractC0721l.mo1868G();
            } else {
                Class<?> cls = abstractC0721l.f2036e;
                try {
                    if (clsM2734s0.isAssignableFrom(cls)) {
                        c1675q.getClass();
                        abstractC0721l = C1675q.m3769g(abstractC0721l, clsM2734s0);
                    } else if (cls.isAssignableFrom(clsM2734s0)) {
                        abstractC0721l = c1675q.m3779i(abstractC0721l, clsM2734s0, false);
                    } else {
                        if (!m2738w0(cls, clsM2734s0)) {
                            throw new C0724o(null, String.format("Cannot refine serialization type %s into %s; types not related", abstractC0721l, clsM2734s0.getName()));
                        }
                        abstractC0721l = abstractC0721l.mo1868G();
                    }
                } catch (IllegalArgumentException e3) {
                    throw m2735t0(e3, String.format("Failed to widen type %s with annotation (value %s), from '%s': %s", abstractC0721l, clsM2734s0.getName(), abstractC1031b.mo2767d(), e3.getMessage()));
                }
            }
        }
        if (abstractC0721l.mo1890y()) {
            AbstractC0721l abstractC0721lMo1877l = abstractC0721l.mo1877l();
            Class<?> clsM2734s02 = interfaceC0748l == null ? null : m2734s0(interfaceC0748l.keyAs());
            if (clsM2734s02 != null) {
                if (abstractC0721lMo1877l.m1883r(clsM2734s02)) {
                    abstractC0721lMo1868G2 = abstractC0721lMo1877l.mo1868G();
                } else {
                    Class<?> cls2 = abstractC0721lMo1877l.f2036e;
                    try {
                        if (clsM2734s02.isAssignableFrom(cls2)) {
                            c1675q.getClass();
                            abstractC0721lMo1868G2 = C1675q.m3769g(abstractC0721lMo1877l, clsM2734s02);
                        } else if (cls2.isAssignableFrom(clsM2734s02)) {
                            abstractC0721lMo1868G2 = c1675q.m3779i(abstractC0721lMo1877l, clsM2734s02, false);
                        } else {
                            if (!m2738w0(cls2, clsM2734s02)) {
                                throw new C0724o(null, String.format("Cannot refine serialization key type %s into %s; types not related", abstractC0721lMo1877l, clsM2734s02.getName()));
                            }
                            abstractC0721lMo1868G2 = abstractC0721lMo1877l.mo1868G();
                        }
                    } catch (IllegalArgumentException e4) {
                        throw m2735t0(e4, String.format("Failed to widen key type of %s with concrete-type annotation (value %s), from '%s': %s", abstractC0721l, clsM2734s02.getName(), abstractC1031b.mo2767d(), e4.getMessage()));
                    }
                }
                abstractC0721l = ((AbstractC1665g) abstractC0721l).mo3750M(abstractC0721lMo1868G2);
            }
        }
        AbstractC0721l abstractC0721lMo1874i = abstractC0721l.mo1874i();
        if (abstractC0721lMo1874i == null) {
            return abstractC0721l;
        }
        Class<?> clsM2734s03 = interfaceC0748l == null ? null : m2734s0(interfaceC0748l.contentAs());
        if (clsM2734s03 == null) {
            return abstractC0721l;
        }
        if (abstractC0721lMo1874i.m1883r(clsM2734s03)) {
            abstractC0721lMo1868G = abstractC0721lMo1874i.mo1868G();
        } else {
            Class<?> cls3 = abstractC0721lMo1874i.f2036e;
            try {
                if (clsM2734s03.isAssignableFrom(cls3)) {
                    c1675q.getClass();
                    abstractC0721lMo1868G = C1675q.m3769g(abstractC0721lMo1874i, clsM2734s03);
                } else if (cls3.isAssignableFrom(clsM2734s03)) {
                    abstractC0721lMo1868G = c1675q.m3779i(abstractC0721lMo1874i, clsM2734s03, false);
                } else {
                    if (!m2738w0(cls3, clsM2734s03)) {
                        throw new C0724o(null, String.format("Cannot refine serialization content type %s into %s; types not related", abstractC0721lMo1874i, clsM2734s03.getName()));
                    }
                    abstractC0721lMo1868G = abstractC0721lMo1874i.mo1868G();
                }
            } catch (IllegalArgumentException e5) {
                throw m2735t0(e5, String.format("Internal error: failed to refine value type of %s with concrete-type annotation (value %s), from '%s': %s", abstractC0721l, clsM2734s03.getName(), abstractC1031b.mo2767d(), e5.getMessage()));
            }
        }
        return abstractC0721l.mo1864C(abstractC0721lMo1868G);
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: r */
    public final Object mo1789r(AbstractC1041l abstractC1041l) {
        C0480b c0480bMo1787q = mo1787q(abstractC1041l);
        if (c0480bMo1787q == null) {
            return null;
        }
        return c0480bMo1787q.f1120e;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: r0 */
    public final C1043n mo1790r0(C1043n c1043n, C1043n c1043n2) {
        Class clsMo2792u = c1043n.mo2792u(0);
        Class clsMo2792u2 = c1043n2.mo2792u(0);
        if (clsMo2792u.isPrimitive()) {
            if (clsMo2792u2.isPrimitive()) {
                return null;
            }
            return c1043n;
        }
        if (clsMo2792u2.isPrimitive()) {
            return c1043n2;
        }
        if (clsMo2792u == String.class) {
            if (clsMo2792u2 != String.class) {
                return c1043n;
            }
        } else if (clsMo2792u2 == String.class) {
            return c1043n2;
        }
        return null;
    }

    public Object readResolve() {
        if (this.f3603e == null) {
            this.f3603e = new C1752q(48, 48);
        }
        return this;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: s */
    public final Object mo1791s(AbstractC1031b abstractC1031b) {
        Class clsKeyUsing;
        InterfaceC0742f interfaceC0742f = (InterfaceC0742f) abstractC1031b.mo2774c(InterfaceC0742f.class);
        if (interfaceC0742f == null || (clsKeyUsing = interfaceC0742f.keyUsing()) == AbstractC0729t.class) {
            return null;
        }
        return clsKeyUsing;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: t */
    public final Object mo1792t(AbstractC1031b abstractC1031b) {
        Class clsKeyUsing;
        InterfaceC0748l interfaceC0748l = (InterfaceC0748l) abstractC1031b.mo2774c(InterfaceC0748l.class);
        if (interfaceC0748l == null || (clsKeyUsing = interfaceC0748l.keyUsing()) == JsonSerializer$None.class) {
            return null;
        }
        return clsKeyUsing;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: u */
    public final Boolean mo1793u(AbstractC1041l abstractC1041l) {
        InterfaceC0459G interfaceC0459G = (InterfaceC0459G) abstractC1041l.mo2774c(InterfaceC0459G.class);
        if (interfaceC0459G == null) {
            return null;
        }
        return interfaceC0459G.value().m1007a();
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: v */
    public final C0703E mo1794v(AbstractC1031b abstractC1031b) {
        boolean z3;
        InterfaceC0467O interfaceC0467O = (InterfaceC0467O) abstractC1031b.mo2774c(InterfaceC0467O.class);
        if (interfaceC0467O != null) {
            String strValue = interfaceC0467O.value();
            if (!strValue.isEmpty()) {
                return C0703E.m1686a(strValue);
            }
            z3 = true;
        } else {
            z3 = false;
        }
        InterfaceC0461I interfaceC0461I = (InterfaceC0461I) abstractC1031b.mo2774c(InterfaceC0461I.class);
        if (interfaceC0461I != null) {
            String strNamespace = interfaceC0461I.namespace();
            return C0703E.m1687b(interfaceC0461I.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
        }
        if (z3 || abstractC1031b.mo2775g(f3602h)) {
            return C0703E.f1926h;
        }
        return null;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: w */
    public final C0703E mo1795w(AbstractC1041l abstractC1041l) {
        boolean z3;
        InterfaceC0504s interfaceC0504s = (InterfaceC0504s) abstractC1041l.mo2774c(InterfaceC0504s.class);
        if (interfaceC0504s != null) {
            String strValue = interfaceC0504s.value();
            if (!strValue.isEmpty()) {
                return C0703E.m1686a(strValue);
            }
            z3 = true;
        } else {
            z3 = false;
        }
        InterfaceC0461I interfaceC0461I = (InterfaceC0461I) abstractC1041l.mo2774c(InterfaceC0461I.class);
        if (interfaceC0461I != null) {
            String strNamespace = interfaceC0461I.namespace();
            return C0703E.m1687b(interfaceC0461I.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
        }
        if (z3 || abstractC1041l.mo2775g(f3601g)) {
            return C0703E.f1926h;
        }
        return null;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: x */
    public final Object mo1796x(C1033d c1033d) {
        InterfaceC0743g interfaceC0743g = (InterfaceC0743g) c1033d.f3674n.mo442a(InterfaceC0743g.class);
        if (interfaceC0743g == null) {
            return null;
        }
        return interfaceC0743g.value();
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: y */
    public final Object mo1797y(AbstractC1031b abstractC1031b) {
        Class clsNullsUsing;
        InterfaceC0748l interfaceC0748l = (InterfaceC0748l) abstractC1031b.mo2774c(InterfaceC0748l.class);
        if (interfaceC0748l == null || (clsNullsUsing = interfaceC0748l.nullsUsing()) == JsonSerializer$None.class) {
            return null;
        }
        return clsNullsUsing;
    }

    @Override // p069X0.AbstractC0711b
    /* JADX INFO: renamed from: z */
    public final C1018N mo1798z(AbstractC1031b abstractC1031b) {
        InterfaceC0505t interfaceC0505t = (InterfaceC0505t) abstractC1031b.mo2774c(InterfaceC0505t.class);
        if (interfaceC0505t == null || interfaceC0505t.generator() == AbstractC0487e0.class) {
            return null;
        }
        return new C1018N(C0703E.m1686a(interfaceC0505t.property()), interfaceC0505t.scope(), interfaceC0505t.generator(), false, interfaceC0505t.resolver());
    }
}
