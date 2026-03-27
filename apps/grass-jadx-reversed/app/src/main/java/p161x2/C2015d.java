package p161x2;

import androidx.lifecycle.C0961F;
import p004A2.InterfaceC0024a;
import p004A2.InterfaceC0025b;
import p005B.AbstractC0032g;
import p008B2.AbstractC0089b0;
import p015D2.C0198v;
import p083b2.AbstractC1056a;
import p083b2.InterfaceC1059d;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1772k;
import p119m2.C1763b;
import p135q2.InterfaceC1840a;
import p148u0.AbstractC1944c;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: x2.d */
/* JADX INFO: loaded from: classes.dex */
public final class C2015d implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1840a f7170a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1059d f7171b = AbstractC1056a.m2815b(new C0961F(2, this));

    public C2015d(C1763b c1763b) {
        this.f7170a = c1763b;
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("value", obj);
        AbstractC1944c.m4341c(this, c0198v, obj);
        throw null;
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        InterfaceC0024a interfaceC0024aMo94i = interfaceC0025b.mo94i(mo221c());
        String strMo82l = null;
        while (true) {
            int iMo86q = interfaceC0024aMo94i.mo86q(mo221c());
            if (iMo86q == -1) {
                throw new IllegalArgumentException(AbstractC0032g.m152j("Polymorphic value has not been read for class ", strMo82l).toString());
            }
            if (iMo86q != 0) {
                if (iMo86q == 1) {
                    if (strMo82l == null) {
                        throw new IllegalArgumentException("Cannot read polymorphic value before its type token".toString());
                    }
                    m4466d(interfaceC0024aMo94i);
                    AbstractC0089b0.m261h(strMo82l, this.f7170a);
                    throw null;
                }
                StringBuilder sb = new StringBuilder("Invalid index in polymorphic deserialization of ");
                if (strMo82l == null) {
                    strMo82l = "unknown class";
                }
                sb.append(strMo82l);
                sb.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                sb.append(iMo86q);
                throw new C2017f(sb.toString());
            }
            strMo82l = interfaceC0024aMo94i.mo82l(mo221c(), iMo86q);
        }
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return (InterfaceC2095g) this.f7171b.getValue();
    }

    /* JADX INFO: renamed from: d */
    public final void m4466d(InterfaceC0024a interfaceC0024a) {
        AbstractC1766e.m3920e("decoder", interfaceC0024a);
        interfaceC0024a.mo84n().getClass();
        AbstractC1766e.m3920e("baseClass", this.f7170a);
        AbstractC1772k.m3930b(1, null);
    }

    public final String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + this.f7170a + ')';
    }
}
