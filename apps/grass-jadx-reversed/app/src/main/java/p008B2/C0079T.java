package p008B2;

import java.util.Map;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p004A2.InterfaceC0024a;
import p004A2.InterfaceC0025b;
import p015D2.C0198v;
import p039M0.AbstractC0473V;
import p083b2.C1061f;
import p119m2.AbstractC1766e;
import p161x2.C2017f;
import p161x2.InterfaceC2012a;
import p167z2.C2100l;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.T */
/* JADX INFO: loaded from: classes.dex */
public final class C0079T implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2012a f246a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2012a f247b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f248c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC2095g f249d;

    public C0079T(InterfaceC2012a interfaceC2012a, InterfaceC2012a interfaceC2012a2, byte b3) {
        this.f246a = interfaceC2012a;
        this.f247b = interfaceC2012a2;
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        AbstractC1766e.m3920e("encoder", c0198v);
        C0198v c0198vM349a = c0198v.m349a(mo221c());
        c0198vM349a.m362n(mo221c(), 0, this.f246a, m250d(obj));
        c0198vM349a.m362n(mo221c(), 1, this.f247b, m251e(obj));
        c0198vM349a.m366r(mo221c());
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        InterfaceC2095g interfaceC2095gMo221c = mo221c();
        InterfaceC0024a interfaceC0024aMo94i = interfaceC0025b.mo94i(interfaceC2095gMo221c);
        Object obj = AbstractC0089b0.f262c;
        Object objMo85p = obj;
        Object objMo85p2 = objMo85p;
        while (true) {
            int iMo86q = interfaceC0024aMo94i.mo86q(mo221c());
            if (iMo86q == -1) {
                if (objMo85p == obj) {
                    throw new C2017f("Element 'key' is missing");
                }
                if (objMo85p2 == obj) {
                    throw new C2017f("Element 'value' is missing");
                }
                Object objM252f = m252f(objMo85p, objMo85p2);
                interfaceC0024aMo94i.mo88w(interfaceC2095gMo221c);
                return objM252f;
            }
            if (iMo86q == 0) {
                objMo85p = interfaceC0024aMo94i.mo85p(mo221c(), 0, this.f246a, null);
            } else {
                if (iMo86q != 1) {
                    throw new C2017f("Invalid index: " + iMo86q);
                }
                objMo85p2 = interfaceC0024aMo94i.mo85p(mo221c(), 1, this.f247b, null);
            }
        }
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        switch (this.f248c) {
        }
        return this.f249d;
    }

    /* JADX INFO: renamed from: d */
    public final Object m250d(Object obj) {
        switch (this.f248c) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                Map.Entry entry = (Map.Entry) obj;
                AbstractC1766e.m3920e("<this>", entry);
                return entry.getKey();
            default:
                C1061f c1061f = (C1061f) obj;
                AbstractC1766e.m3920e("<this>", c1061f);
                return c1061f.f3736e;
        }
    }

    /* JADX INFO: renamed from: e */
    public final Object m251e(Object obj) {
        switch (this.f248c) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                Map.Entry entry = (Map.Entry) obj;
                AbstractC1766e.m3920e("<this>", entry);
                return entry.getValue();
            default:
                C1061f c1061f = (C1061f) obj;
                AbstractC1766e.m3920e("<this>", c1061f);
                return c1061f.f3737f;
        }
    }

    /* JADX INFO: renamed from: f */
    public final Object m252f(Object obj, Object obj2) {
        switch (this.f248c) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return new C0077Q(obj, obj2);
            default:
                return new C1061f(obj, obj2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0079T(InterfaceC2012a interfaceC2012a, InterfaceC2012a interfaceC2012a2, int i3) {
        this(interfaceC2012a, interfaceC2012a2, (byte) 0);
        this.f248c = i3;
        switch (i3) {
            case 1:
                this(interfaceC2012a, interfaceC2012a2, (byte) 0);
                this.f249d = AbstractC0473V.m992D("kotlin.Pair", new InterfaceC2095g[0], new C0078S(interfaceC2012a, interfaceC2012a2, 1));
                break;
            default:
                this.f249d = AbstractC0473V.m993E("kotlin.collections.Map.Entry", C2100l.f7426e, new InterfaceC2095g[0], new C0078S(interfaceC2012a, interfaceC2012a2, 0));
                break;
        }
    }
}
