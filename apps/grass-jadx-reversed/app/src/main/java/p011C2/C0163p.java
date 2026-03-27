package p011C2;

import java.util.Iterator;
import p004A2.InterfaceC0025b;
import p008B2.AbstractC0103i0;
import p008B2.C0101h0;
import p008B2.C0135y0;
import p015D2.AbstractC0190n;
import p015D2.C0198v;
import p083b2.C1072q;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1770i;
import p119m2.C1763b;
import p125o0.AbstractC1794d;
import p125o0.AbstractC1800j;
import p135q2.InterfaceC1840a;
import p142s2.AbstractC1891f;
import p142s2.AbstractC1893h;
import p142s2.AbstractC1899n;
import p142s2.AbstractC1900o;
import p142s2.C1890e;
import p161x2.InterfaceC2012a;
import p167z2.C2093e;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: C2.p */
/* JADX INFO: loaded from: classes.dex */
public final class C0163p implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public static final C0163p f396a = new C0163p();

    /* JADX INFO: renamed from: b */
    public static final C0101h0 f397b;

    static {
        C2093e c2093e = C2093e.f7405k;
        if (!(!AbstractC1900o.m4231h("kotlinx.serialization.json.JsonLiteral"))) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        }
        Iterator it = AbstractC0103i0.f292a.keySet().iterator();
        while (it.hasNext()) {
            String strM3915b = ((C1763b) ((InterfaceC1840a) it.next())).m3915b();
            AbstractC1766e.m3917b(strM3915b);
            String strM266a = AbstractC0103i0.m266a(strM3915b);
            if ("kotlinx.serialization.json.JsonLiteral".equalsIgnoreCase("kotlin." + strM266a) || "kotlinx.serialization.json.JsonLiteral".equalsIgnoreCase(strM266a)) {
                throw new IllegalArgumentException(AbstractC1893h.m4227d("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name kotlinx.serialization.json.JsonLiteral there already exist " + AbstractC0103i0.m266a(strM266a) + "Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
            }
        }
        f397b = new C0101h0("kotlinx.serialization.json.JsonLiteral", c2093e);
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        C1890e c1890e;
        C0162o c0162o = (C0162o) obj;
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("value", c0162o);
        AbstractC1800j.m3984b(c0198v);
        boolean z3 = c0162o.f393e;
        String str = c0162o.f395g;
        if (z3) {
            c0198v.m365q(str);
            return;
        }
        InterfaceC2095g interfaceC2095g = c0162o.f394f;
        if (interfaceC2095g != null) {
            c0198v.m357i(interfaceC2095g).m365q(str);
            return;
        }
        Long lM4230g = AbstractC1899n.m4230g(str);
        if (lM4230g != null) {
            c0198v.m360l(lM4230g.longValue());
            return;
        }
        C1072q c1072qM3957o = AbstractC1794d.m3957o(str);
        if (c1072qM3957o != null) {
            c0198v.m357i(C0135y0.f348b).m360l(c1072qM3957o.f3756e);
            return;
        }
        Boolean bool = null;
        try {
            c1890e = AbstractC1891f.f6645a;
            c1890e.getClass();
        } catch (NumberFormatException unused) {
        }
        Double dValueOf = c1890e.f6644e.matcher(str).matches() ? Double.valueOf(Double.parseDouble(str)) : null;
        if (dValueOf != null) {
            c0198v.m353e(dValueOf.doubleValue());
            return;
        }
        if (str.equals("true")) {
            bool = Boolean.TRUE;
        } else if (str.equals("false")) {
            bool = Boolean.FALSE;
        }
        if (bool != null) {
            c0198v.m350b(bool.booleanValue());
        } else {
            c0198v.m365q(str);
        }
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        AbstractC0156i abstractC0156iM347M = AbstractC1800j.m3986d(interfaceC0025b).m347M();
        if (abstractC0156iM347M instanceof C0162o) {
            return (C0162o) abstractC0156iM347M;
        }
        throw AbstractC0190n.m321c(-1, "Unexpected JSON element, expected JsonLiteral, had " + AbstractC1770i.m3927a(abstractC0156iM347M.getClass()), abstractC0156iM347M.toString());
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return f397b;
    }
}
