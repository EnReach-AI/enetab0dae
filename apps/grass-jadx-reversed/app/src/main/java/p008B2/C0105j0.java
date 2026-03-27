package p008B2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import p083b2.C1068m;
import p086c2.AbstractC1084c;
import p119m2.AbstractC1766e;
import p135q2.InterfaceC1840a;
import p148u0.AbstractC1946e;
import p161x2.InterfaceC2012a;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.j0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0105j0 extends AbstractC0120r {

    /* JADX INFO: renamed from: b */
    public final InterfaceC1840a f294b;

    /* JADX INFO: renamed from: c */
    public final C0088b f295c;

    public C0105j0(InterfaceC1840a interfaceC1840a, InterfaceC2012a interfaceC2012a) {
        super(interfaceC2012a);
        this.f294b = interfaceC1840a;
        InterfaceC2095g interfaceC2095gMo221c = interfaceC2012a.mo221c();
        AbstractC1766e.m3920e("elementDesc", interfaceC2095gMo221c);
        this.f295c = new C0088b(interfaceC2095gMo221c, 0);
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return this.f295c;
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: d */
    public final Object mo241d() {
        return new ArrayList();
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: e */
    public final int mo242e(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        AbstractC1766e.m3920e("<this>", arrayList);
        return arrayList.size();
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: f */
    public final Iterator mo243f(Object obj) {
        Object[] objArr = (Object[]) obj;
        AbstractC1766e.m3920e("<this>", objArr);
        return new C1068m(objArr);
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: g */
    public final int mo222g(Object obj) {
        Object[] objArr = (Object[]) obj;
        AbstractC1766e.m3920e("<this>", objArr);
        return objArr.length;
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: j */
    public final Object mo224j(Object obj) {
        AbstractC1766e.m3920e("<this>", null);
        AbstractC1084c.m2829w(null);
        throw null;
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: k */
    public final Object mo244k(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        AbstractC1766e.m3920e("<this>", arrayList);
        InterfaceC1840a interfaceC1840a = this.f294b;
        AbstractC1766e.m3920e("eClass", interfaceC1840a);
        Object objNewInstance = Array.newInstance((Class<?>) AbstractC1946e.m4344b(interfaceC1840a), arrayList.size());
        AbstractC1766e.m3918c("null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>", objNewInstance);
        Object[] array = arrayList.toArray((Object[]) objNewInstance);
        AbstractC1766e.m3919d("toArray(...)", array);
        return array;
    }

    @Override // p008B2.AbstractC0120r
    /* JADX INFO: renamed from: l */
    public final void mo262l(Object obj, int i3, Object obj2) {
        ArrayList arrayList = (ArrayList) obj;
        AbstractC1766e.m3920e("<this>", arrayList);
        arrayList.add(i3, obj2);
    }
}
