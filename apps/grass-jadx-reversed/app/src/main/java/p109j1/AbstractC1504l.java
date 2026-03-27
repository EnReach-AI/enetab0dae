package p109j1;

import com.fasterxml.jackson.databind.deser.C1141h;
import java.io.IOException;
import p042N0.AbstractC0540h;
import p042N0.AbstractC0545m;
import p042N0.AbstractC0546n;
import p042N0.C0537e;
import p042N0.EnumC0536d;
import p042N0.EnumC0548p;
import p042N0.InterfaceC0550r;
import p047P0.C0574a;
import p047P0.C0575b;
import p047P0.C0576c;
import p066W0.C0674a;
import p066W0.C0676c;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.C0699A;
import p069X0.C0701C;
import p069X0.C0707I;
import p069X0.C0717h;
import p069X0.C0724o;
import p069X0.C0735z;
import p069X0.EnumC0719j;
import p088d1.C1306a;

/* JADX INFO: renamed from: j1.l */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1504l {

    /* JADX INFO: renamed from: a */
    public static final C1306a f5447a;

    /* JADX INFO: renamed from: b */
    public static final C0701C f5448b;

    /* JADX INFO: renamed from: c */
    public static final C0735z f5449c;

    static {
        C1306a c1306a = new C1306a(new C0537e(null));
        f5447a = c1306a;
        f5448b = new C0701C(c1306a, c1306a.f2087g);
        C0707I c0707i = c1306a.f2087g;
        new C0701C(c1306a, c0707i);
        InterfaceC0550r interfaceC0550r = c0707i.f1934q;
        C0699A c0699a = C0699A.f1905g;
        if (interfaceC0550r == null) {
            interfaceC0550r = C0701C.f1909k;
        }
        if (c0699a != (interfaceC0550r == null ? c0699a : new C0699A(interfaceC0550r))) {
        }
        f5449c = new C0735z(c1306a, c1306a.f2090j, c1306a.f2086f.m3780j(AbstractC0725p.class));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: a */
    public static AbstractC0725p m3549a(byte[] bArr) throws IOException {
        C0735z c0735z = f5449c;
        c0735z.m1922d("content", bArr);
        AbstractC0545m abstractC0545mM1102s = c0735z.f2096g.m1102s(bArr);
        C0717h c0717h = c0735z.f2094e;
        int i3 = c0717h.f1993w;
        if (i3 != 0) {
            abstractC0545mM1102s.mo1179X(c0717h.f1992v, i3);
        }
        int i4 = c0717h.f1995y;
        if (i4 != 0) {
            abstractC0545mM1102s.mo1178W(c0717h.f1994x, i4);
        }
        C0575b c0575b = c0735z.f2097h;
        if (c0575b != null && !C0574a.class.isInstance(abstractC0545mM1102s)) {
            C0574a c0574a = new C0574a(abstractC0545mM1102s);
            c0574a.f1431m = c0575b;
            c0574a.f1429k = new C0576c(0, null, c0575b, true);
            c0574a.f1427i = 1;
            c0574a.f1426h = false;
            abstractC0545mM1102s = c0574a;
        }
        try {
            C1141h c1141h = (C1141h) c0735z.f2095f;
            c1141h.getClass();
            C1141h c1141h2 = new C1141h(c1141h, c0717h, abstractC0545mM1102s);
            int i5 = c0717h.f1993w;
            if (i5 != 0) {
                abstractC0545mM1102s.mo1179X(c0717h.f1992v, i5);
            }
            int i6 = c0717h.f1995y;
            if (i6 != 0) {
                abstractC0545mM1102s.mo1178W(c0717h.f1994x, i6);
            }
            EnumC0548p enumC0548pMo1190e = abstractC0545mM1102s.mo1190e();
            if (enumC0548pMo1190e == null && (enumC0548pMo1190e = abstractC0545mM1102s.mo1177V()) == null) {
                c1141h2.m1842T("No content to map due to end-of-input", new Object[0]);
                throw null;
            }
            EnumC0548p enumC0548p = EnumC0548p.VALUE_NULL;
            AbstractC0721l abstractC0721l = c0735z.f2098i;
            Object objM2975b0 = c0735z.f2100k;
            if (enumC0548pMo1190e == enumC0548p) {
                if (objM2975b0 == null) {
                    objM2975b0 = c0735z.m1924f(c1141h2).getNullValue(c1141h2);
                }
            } else if (enumC0548pMo1190e != EnumC0548p.END_ARRAY && enumC0548pMo1190e != EnumC0548p.END_OBJECT) {
                objM2975b0 = c1141h2.m2975b0(abstractC0545mM1102s, abstractC0721l, c0735z.m1924f(c1141h2), objM2975b0);
            }
            if (c0717h.m1820r(EnumC0719j.FAIL_ON_TRAILING_TOKENS)) {
                c0735z.m1927i(abstractC0545mM1102s, c1141h2, abstractC0721l);
            }
            abstractC0545mM1102s.close();
            return (AbstractC0725p) objM2975b0;
        } finally {
        }
    }

    /* JADX INFO: renamed from: b */
    public static byte[] m3550b(Object obj) {
        byte[] bArr;
        C1306a c1306a = f5447a;
        C0537e c0537e = c1306a.f2085e;
        try {
            C0676c c0676c = new C0676c(c0537e.m1095l());
            try {
                AbstractC0540h abstractC0540hM1098o = c0537e.m1098o(c0676c, EnumC0536d.UTF8);
                c1306a.f2087g.m1696p(abstractC0540hM1098o);
                c1306a.m1916i(abstractC0540hM1098o, obj);
                byte[] bArrM1639f = c0676c.m1639f();
                c0676c.m1638e();
                C0674a c0674a = c0676c.f1839e;
                if (c0674a != null && (bArr = c0676c.f1842h) != null) {
                    c0674a.f1834a.set(2, bArr);
                    c0676c.f1842h = null;
                }
                return bArrM1639f;
            } finally {
            }
        } catch (AbstractC0546n e3) {
            throw e3;
        } catch (IOException e4) {
            throw C0724o.m1893f(e4);
        }
    }
}
