package p103h1;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p039M0.EnumC0471T;
import p042N0.AbstractC0540h;
import p042N0.C0538f;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p069X0.InterfaceC0714e;
import p100g1.AbstractC1399h;

/* JADX INFO: renamed from: h1.c */
/* JADX INFO: loaded from: classes.dex */
public class C1415c extends AbstractC1431s {

    /* JADX INFO: renamed from: d */
    public static final C1415c f5041d = new C1415c(null, 0 == true ? 1 : 0, 0);

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f5042c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1415c(AbstractC1429q abstractC1429q, InterfaceC0714e interfaceC0714e, int i3) {
        super(abstractC1429q, interfaceC0714e);
        this.f5042c = i3;
    }

    @Override // p100g1.AbstractC1399h
    /* JADX INFO: renamed from: a */
    public AbstractC1399h mo3100a(InterfaceC0714e interfaceC0714e) {
        switch (this.f5042c) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return this;
            case 1:
                return mo3422g(interfaceC0714e);
            default:
                return this.f5075b == interfaceC0714e ? this : new C1415c(this.f5074a, interfaceC0714e, 2);
        }
    }

    @Override // p100g1.AbstractC1399h
    /* JADX INFO: renamed from: c */
    public EnumC0471T mo3102c() {
        switch (this.f5042c) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return EnumC0471T.f1111i;
            case 1:
                return EnumC0471T.f1109g;
            default:
                return EnumC0471T.f1108f;
        }
    }

    @Override // p103h1.AbstractC1431s, p100g1.AbstractC1399h
    /* JADX INFO: renamed from: e */
    public C0672b mo3103e(AbstractC0540h abstractC0540h, C0672b c0672b) throws C0538f {
        switch (this.f5042c) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (!c0672b.f1828f.f1329i) {
                    return null;
                }
                if (!abstractC0540h.mo1131d()) {
                    abstractC0540h.m1127T(c0672b);
                    return c0672b;
                }
                c0672b.f1829g = false;
                EnumC0548p enumC0548p = EnumC0548p.START_OBJECT;
                EnumC0548p enumC0548p2 = c0672b.f1828f;
                if (enumC0548p2 == enumC0548p) {
                    abstractC0540h.mo1121N(c0672b.f1823a);
                    return c0672b;
                }
                if (enumC0548p2 != EnumC0548p.START_ARRAY) {
                    return c0672b;
                }
                abstractC0540h.mo1118K(c0672b.f1823a);
                return c0672b;
            default:
                return super.mo3103e(abstractC0540h, c0672b);
        }
    }

    @Override // p103h1.AbstractC1431s, p100g1.AbstractC1399h
    /* JADX INFO: renamed from: f */
    public C0672b mo3104f(AbstractC0540h abstractC0540h, C0672b c0672b) {
        switch (this.f5042c) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (c0672b == null) {
                    return null;
                }
                abstractC0540h.m1128U(c0672b);
                return c0672b;
            default:
                return super.mo3104f(abstractC0540h, c0672b);
        }
    }

    /* JADX INFO: renamed from: g */
    public C1415c mo3422g(InterfaceC0714e interfaceC0714e) {
        return this.f5075b == interfaceC0714e ? this : new C1415c(this.f5074a, interfaceC0714e, 1);
    }
}
