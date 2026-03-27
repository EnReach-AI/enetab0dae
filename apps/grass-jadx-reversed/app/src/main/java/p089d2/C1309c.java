package p089d2;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p115l2.InterfaceC1693p;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1767f;

/* JADX INFO: renamed from: d2.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1309c extends AbstractC1767f implements InterfaceC1693p {

    /* JADX INFO: renamed from: g */
    public static final C1309c f4669g = new C1309c(2, 0);

    /* JADX INFO: renamed from: h */
    public static final C1309c f4670h = new C1309c(2, 1);

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f4671f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1309c(int i3, int i4) {
        super(i3);
        this.f4671f = i4;
    }

    @Override // p115l2.InterfaceC1693p
    /* JADX INFO: renamed from: c */
    public final Object mo317c(Object obj, Object obj2) {
        C1311e c1311e;
        switch (this.f4671f) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                String str = (String) obj;
                InterfaceC1315i interfaceC1315i = (InterfaceC1315i) obj2;
                AbstractC1766e.m3920e("acc", str);
                AbstractC1766e.m3920e("element", interfaceC1315i);
                if (str.length() == 0) {
                    return interfaceC1315i.toString();
                }
                return str + ", " + interfaceC1315i;
            default:
                InterfaceC1317k interfaceC1317k = (InterfaceC1317k) obj;
                InterfaceC1315i interfaceC1315i2 = (InterfaceC1315i) obj2;
                AbstractC1766e.m3920e("acc", interfaceC1317k);
                AbstractC1766e.m3920e("element", interfaceC1315i2);
                InterfaceC1317k interfaceC1317kMinusKey = interfaceC1317k.minusKey(interfaceC1315i2.getKey());
                C1318l c1318l = C1318l.f4678e;
                if (interfaceC1317kMinusKey == c1318l) {
                    return interfaceC1315i2;
                }
                C1313g c1313g = C1313g.f4676a;
                InterfaceC1314h interfaceC1314h = (InterfaceC1314h) interfaceC1317kMinusKey.get(c1313g);
                if (interfaceC1314h == null) {
                    c1311e = new C1311e(interfaceC1317kMinusKey, interfaceC1315i2);
                } else {
                    InterfaceC1317k interfaceC1317kMinusKey2 = interfaceC1317kMinusKey.minusKey(c1313g);
                    if (interfaceC1317kMinusKey2 == c1318l) {
                        return new C1311e(interfaceC1315i2, interfaceC1314h);
                    }
                    c1311e = new C1311e(new C1311e(interfaceC1317kMinusKey2, interfaceC1315i2), interfaceC1314h);
                }
                return c1311e;
        }
    }
}
