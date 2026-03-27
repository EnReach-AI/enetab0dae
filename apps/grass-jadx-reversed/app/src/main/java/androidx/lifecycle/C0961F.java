package androidx.lifecycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p008B2.AbstractC0089b0;
import p008B2.C0085Z;
import p039M0.AbstractC0473V;
import p063V.AbstractC0668b;
import p063V.C0667a;
import p063V.C0669c;
import p063V.C0670d;
import p083b2.C1068m;
import p115l2.InterfaceC1678a;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1767f;
import p119m2.AbstractC1770i;
import p135q2.InterfaceC1840a;
import p148u0.AbstractC1946e;
import p161x2.C2015d;
import p167z2.C2090b;
import p167z2.C2091c;
import p167z2.C2096h;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: androidx.lifecycle.F */
/* JADX INFO: loaded from: classes.dex */
public final class C0961F extends AbstractC1767f implements InterfaceC1678a {

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f3290f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Object f3291g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0961F(int i3, Object obj) {
        super(0);
        this.f3290f = i3;
        this.f3291g = obj;
    }

    @Override // p115l2.InterfaceC1678a
    /* JADX INFO: renamed from: a */
    public final Object mo263a() {
        AbstractC0668b abstractC0668bMo2197a;
        switch (this.f3290f) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                InterfaceC0967L interfaceC0967L = (InterfaceC0967L) this.f3291g;
                AbstractC1766e.m3920e("<this>", interfaceC0967L);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new C0670d(AbstractC1946e.m4344b(AbstractC1770i.m3927a(C0963H.class))));
                Object[] array = arrayList.toArray(new C0670d[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                C0670d[] c0670dArr = (C0670d[]) array;
                C0670d[] c0670dArr2 = (C0670d[]) Arrays.copyOf(c0670dArr, c0670dArr.length);
                AbstractC1766e.m3920e("initializers", c0670dArr2);
                C0966K c0966kMo2198c = interfaceC0967L.mo2198c();
                AbstractC1766e.m3919d("owner.viewModelStore", c0966kMo2198c);
                if (interfaceC0967L instanceof InterfaceC0975h) {
                    abstractC0668bMo2197a = ((InterfaceC0975h) interfaceC0967L).mo2197a();
                    AbstractC1766e.m3919d("{\n        owner.defaultV…ModelCreationExtras\n    }", abstractC0668bMo2197a);
                } else {
                    abstractC0668bMo2197a = C0667a.f1819b;
                }
                AbstractC1766e.m3920e("defaultCreationExtras", abstractC0668bMo2197a);
                HashMap map = c0966kMo2198c.f3303a;
                AbstractC0964I abstractC0964I = (AbstractC0964I) map.get("androidx.lifecycle.internal.SavedStateHandlesVM");
                if (!C0963H.class.isInstance(abstractC0964I)) {
                    C0669c c0669c = new C0669c(abstractC0668bMo2197a);
                    c0669c.f1820a.put(C0965J.f3302b, "androidx.lifecycle.internal.SavedStateHandlesVM");
                    try {
                        AbstractC0964I abstractC0964I2 = null;
                        for (C0670d c0670d : c0670dArr2) {
                            if (AbstractC1766e.m3916a(c0670d.f1821a, C0963H.class)) {
                                Object objMo249f = c0670d.f1822b.mo249f(c0669c);
                                abstractC0964I2 = objMo249f instanceof AbstractC0964I ? (AbstractC0964I) objMo249f : null;
                            }
                        }
                        if (abstractC0964I2 == null) {
                            throw new IllegalArgumentException("No initializer set for given class ".concat(C0963H.class.getName()));
                        }
                        AbstractC0964I abstractC0964I3 = (AbstractC0964I) map.put("androidx.lifecycle.internal.SavedStateHandlesVM", abstractC0964I2);
                        if (abstractC0964I3 != null) {
                            abstractC0964I3.mo1631a();
                        }
                        abstractC0964I = abstractC0964I2;
                    } catch (AbstractMethodError unused) {
                        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
                    }
                } else if (abstractC0964I == null) {
                    throw new NullPointerException("null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
                }
                return (C0963H) abstractC0964I;
            case 1:
                Object[] objArr = (Object[]) this.f3291g;
                AbstractC1766e.m3920e("array", objArr);
                return new C1068m(objArr);
            case 2:
                C2015d c2015d = (C2015d) this.f3291g;
                C2096h c2096hM993E = AbstractC0473V.m993E("kotlinx.serialization.Polymorphic", C2091c.f7395c, new InterfaceC2095g[0], new C0085Z(4, c2015d));
                InterfaceC1840a interfaceC1840a = c2015d.f7170a;
                AbstractC1766e.m3920e("context", interfaceC1840a);
                return new C2090b(c2096hM993E, interfaceC1840a);
            default:
                C2096h c2096h = (C2096h) this.f3291g;
                return Integer.valueOf(AbstractC0089b0.m258e(c2096h, c2096h.f7416k));
        }
    }
}
