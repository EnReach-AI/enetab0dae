package p008B2;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p083b2.C1077v;
import p115l2.InterfaceC1689l;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1767f;
import p161x2.InterfaceC2012a;
import p167z2.C2089a;

/* JADX INFO: renamed from: B2.S */
/* JADX INFO: loaded from: classes.dex */
public final class C0078S extends AbstractC1767f implements InterfaceC1689l {

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f243f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ InterfaceC2012a f244g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ InterfaceC2012a f245h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0078S(InterfaceC2012a interfaceC2012a, InterfaceC2012a interfaceC2012a2, int i3) {
        super(1);
        this.f243f = i3;
        this.f244g = interfaceC2012a;
        this.f245h = interfaceC2012a2;
    }

    @Override // p115l2.InterfaceC1689l
    /* JADX INFO: renamed from: f */
    public final Object mo249f(Object obj) {
        switch (this.f243f) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C2089a c2089a = (C2089a) obj;
                AbstractC1766e.m3920e("$this$buildSerialDescriptor", c2089a);
                C2089a.m4643a(c2089a, "key", this.f244g.mo221c());
                C2089a.m4643a(c2089a, "value", this.f245h.mo221c());
                break;
            default:
                C2089a c2089a2 = (C2089a) obj;
                AbstractC1766e.m3920e("$this$buildClassSerialDescriptor", c2089a2);
                C2089a.m4643a(c2089a2, "first", this.f244g.mo221c());
                C2089a.m4643a(c2089a2, "second", this.f245h.mo221c());
                break;
        }
        return C1077v.f3761a;
    }
}
