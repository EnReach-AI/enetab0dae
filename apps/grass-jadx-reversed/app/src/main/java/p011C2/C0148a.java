package p011C2;

import p015D2.AbstractC0190n;
import p015D2.C0178b;
import p015D2.C0192p;
import p015D2.C0197u;
import p015D2.C0200x;
import p015D2.EnumC0202z;
import p017E2.AbstractC0208a;
import p019F0.C0221e;
import p086c2.C1083b;
import p119m2.AbstractC1766e;
import p161x2.InterfaceC2012a;
import p166z0.C2068f;

/* JADX INFO: renamed from: C2.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0148a {

    /* JADX INFO: renamed from: d */
    public static final C0148a f356d = new C0148a();

    /* JADX INFO: renamed from: a */
    public final C0154g f357a = new C0154g();

    /* JADX INFO: renamed from: b */
    public final C2068f f358b = AbstractC0208a.f512a;

    /* JADX INFO: renamed from: c */
    public final C0221e f359c = new C0221e(2);

    /* JADX INFO: renamed from: a */
    public final Object m296a(String str, InterfaceC2012a interfaceC2012a) {
        AbstractC1766e.m3920e("string", str);
        C0200x c0200x = new C0200x(str);
        Object objMo96k = new C0197u(this, EnumC0202z.OBJ, c0200x, interfaceC2012a.mo221c(), null).mo96k(interfaceC2012a);
        if (c0200x.m375f() == 10) {
            return objMo96k;
        }
        C0200x.m369o(c0200x, "Expected EOF after parsing, but had " + str.charAt(c0200x.f475a - 1) + " instead", 0, null, 6);
        throw null;
    }

    /* JADX INFO: renamed from: b */
    public final String m297b(InterfaceC2012a interfaceC2012a, Object obj) {
        char[] cArr;
        C0192p c0192p = new C0192p(0);
        C0178b c0178b = C0178b.f416c;
        synchronized (c0178b) {
            C1083b c1083b = c0178b.f417a;
            cArr = null;
            char[] cArr2 = (char[]) (c1083b.isEmpty() ? null : c1083b.removeLast());
            if (cArr2 != null) {
                c0178b.f418b -= cArr2.length;
                cArr = cArr2;
            }
        }
        if (cArr == null) {
            cArr = new char[128];
        }
        c0192p.f444g = cArr;
        try {
            AbstractC0190n.m327i(this, c0192p, interfaceC2012a, obj);
            return c0192p.toString();
        } finally {
            c0192p.m336c();
        }
    }
}
