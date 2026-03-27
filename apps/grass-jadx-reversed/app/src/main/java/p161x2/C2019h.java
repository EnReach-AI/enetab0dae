package p161x2;

import java.util.ArrayList;
import java.util.List;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p017E2.AbstractC0208a;
import p033K0.AbstractC0405c;
import p115l2.InterfaceC1693p;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1767f;
import p135q2.InterfaceC1840a;
import p148u0.AbstractC1946e;

/* JADX INFO: renamed from: x2.h */
/* JADX INFO: loaded from: classes.dex */
public final class C2019h extends AbstractC1767f implements InterfaceC1693p {

    /* JADX INFO: renamed from: g */
    public static final C2019h f7174g = new C2019h(2, 0);

    /* JADX INFO: renamed from: h */
    public static final C2019h f7175h = new C2019h(2, 1);

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f7176f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2019h(int i3, int i4) {
        super(i3);
        this.f7176f = i4;
    }

    @Override // p115l2.InterfaceC1693p
    /* JADX INFO: renamed from: c */
    public final Object mo317c(Object obj, Object obj2) {
        switch (this.f7176f) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                InterfaceC1840a interfaceC1840a = (InterfaceC1840a) obj;
                List list = (List) obj2;
                AbstractC1766e.m3920e("clazz", interfaceC1840a);
                AbstractC1766e.m3920e("types", list);
                ArrayList arrayListM4351i = AbstractC1946e.m4351i(AbstractC0208a.f512a, list, true);
                AbstractC1766e.m3917b(arrayListM4351i);
                return AbstractC1946e.m4348f(interfaceC1840a, arrayListM4351i, new C2018g(list, 0));
            default:
                InterfaceC1840a interfaceC1840a2 = (InterfaceC1840a) obj;
                List list2 = (List) obj2;
                AbstractC1766e.m3920e("clazz", interfaceC1840a2);
                AbstractC1766e.m3920e("types", list2);
                ArrayList arrayListM4351i2 = AbstractC1946e.m4351i(AbstractC0208a.f512a, list2, true);
                AbstractC1766e.m3917b(arrayListM4351i2);
                InterfaceC2012a interfaceC2012aM4348f = AbstractC1946e.m4348f(interfaceC1840a2, arrayListM4351i2, new C2018g(list2, 1));
                if (interfaceC2012aM4348f != null) {
                    return AbstractC0405c.m888j(interfaceC2012aM4348f);
                }
                return null;
        }
    }
}
