package p008B2;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p039M0.AbstractC0473V;
import p083b2.C1077v;
import p086c2.C1093l;
import p115l2.InterfaceC1689l;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1767f;
import p119m2.C1763b;
import p131p2.C1832f;
import p161x2.C2015d;
import p167z2.C2089a;
import p167z2.C2096h;
import p167z2.C2098j;
import p167z2.C2099k;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.Z */
/* JADX INFO: loaded from: classes.dex */
public final class C0085Z extends AbstractC1767f implements InterfaceC1689l {

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f256f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Object f257g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0085Z(int i3, Object obj) {
        super(1);
        this.f256f = i3;
        this.f257g = obj;
    }

    @Override // p115l2.InterfaceC1689l
    /* JADX INFO: renamed from: f */
    public final Object mo249f(Object obj) {
        switch (this.f256f) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C2089a c2089a = (C2089a) obj;
                AbstractC1766e.m3920e("$this$buildSerialDescriptor", c2089a);
                ((C0068H) this.f257g).getClass();
                c2089a.f7386b = C1093l.f3782e;
                return C1077v.f3761a;
            case 1:
                int iIntValue = ((Number) obj).intValue();
                StringBuilder sb = new StringBuilder();
                AbstractC0093d0 abstractC0093d0 = (AbstractC0093d0) this.f257g;
                sb.append(abstractC0093d0.f273e[iIntValue]);
                sb.append(": ");
                sb.append(abstractC0093d0.mo236h(iIntValue).mo233d());
                return sb.toString();
            case 2:
                C2089a c2089a2 = (C2089a) obj;
                AbstractC1766e.m3920e("$this$buildClassSerialDescriptor", c2089a2);
                C0117p0 c0117p0 = (C0117p0) this.f257g;
                C2089a.m4643a(c2089a2, "first", c0117p0.f312a.mo221c());
                C2089a.m4643a(c2089a2, "second", c0117p0.f313b.mo221c());
                C2089a.m4643a(c2089a2, "third", c0117p0.f314c.mo221c());
                return C1077v.f3761a;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                C1832f c1832f = (C1832f) obj;
                AbstractC1766e.m3920e("it", c1832f);
                CharSequence charSequence = (CharSequence) this.f257g;
                AbstractC1766e.m3920e("<this>", charSequence);
                return charSequence.subSequence(c1832f.f6338e, c1832f.f6339f + 1).toString();
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                C2089a c2089a3 = (C2089a) obj;
                AbstractC1766e.m3920e("$this$buildSerialDescriptor", c2089a3);
                C2089a.m4643a(c2089a3, "type", C0115o0.f311b);
                C2089a.m4643a(c2089a3, "value", AbstractC0473V.m993E("kotlinx.serialization.Polymorphic<" + ((C1763b) ((C2015d) this.f257g).f7170a).m3915b() + '>', C2099k.f7422c, new InterfaceC2095g[0], C2098j.f7421f));
                c2089a3.f7386b = C1093l.f3782e;
                return C1077v.f3761a;
            default:
                int iIntValue2 = ((Number) obj).intValue();
                StringBuilder sb2 = new StringBuilder();
                C2096h c2096h = (C2096h) this.f257g;
                sb2.append(c2096h.f7411f[iIntValue2]);
                sb2.append(": ");
                sb2.append(c2096h.f7412g[iIntValue2].mo233d());
                return sb2.toString();
        }
    }
}
