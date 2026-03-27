package p161x2;

import java.lang.reflect.InvocationTargetException;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p008B2.AbstractC0089b0;
import p008B2.AbstractC0103i0;
import p033K0.AbstractC0405c;
import p115l2.InterfaceC1689l;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1767f;
import p135q2.InterfaceC1840a;

/* JADX INFO: renamed from: x2.i */
/* JADX INFO: loaded from: classes.dex */
public final class C2020i extends AbstractC1767f implements InterfaceC1689l {

    /* JADX INFO: renamed from: g */
    public static final C2020i f7177g = new C2020i(1, 0);

    /* JADX INFO: renamed from: h */
    public static final C2020i f7178h = new C2020i(1, 1);

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f7179f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2020i(int i3, int i4) {
        super(i3);
        this.f7179f = i4;
    }

    @Override // p115l2.InterfaceC1689l
    /* JADX INFO: renamed from: f */
    public final Object mo249f(Object obj) throws IllegalAccessException, InvocationTargetException {
        switch (this.f7179f) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                InterfaceC1840a interfaceC1840a = (InterfaceC1840a) obj;
                AbstractC1766e.m3920e("it", interfaceC1840a);
                InterfaceC2012a interfaceC2012aM257d = AbstractC0089b0.m257d(interfaceC1840a, new InterfaceC2012a[0]);
                return interfaceC2012aM257d == null ? (InterfaceC2012a) AbstractC0103i0.f292a.get(interfaceC1840a) : interfaceC2012aM257d;
            default:
                InterfaceC1840a interfaceC1840a2 = (InterfaceC1840a) obj;
                AbstractC1766e.m3920e("it", interfaceC1840a2);
                InterfaceC2012a interfaceC2012aM257d2 = AbstractC0089b0.m257d(interfaceC1840a2, new InterfaceC2012a[0]);
                if (interfaceC2012aM257d2 == null) {
                    interfaceC2012aM257d2 = (InterfaceC2012a) AbstractC0103i0.f292a.get(interfaceC1840a2);
                }
                if (interfaceC2012aM257d2 != null) {
                    return AbstractC0405c.m888j(interfaceC2012aM257d2);
                }
                return null;
        }
    }
}
