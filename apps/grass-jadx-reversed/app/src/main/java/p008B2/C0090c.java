package p008B2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p119m2.AbstractC1766e;
import p161x2.InterfaceC2012a;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0090c extends AbstractC0120r {

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f263b;

    /* JADX INFO: renamed from: c */
    public final AbstractC0073M f264c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0090c(InterfaceC2012a interfaceC2012a, int i3) {
        super(interfaceC2012a);
        this.f263b = i3;
        switch (i3) {
            case 1:
                AbstractC1766e.m3920e("eSerializer", interfaceC2012a);
                super(interfaceC2012a);
                InterfaceC2095g interfaceC2095gMo221c = interfaceC2012a.mo221c();
                AbstractC1766e.m3920e("elementDesc", interfaceC2095gMo221c);
                this.f264c = new C0088b(interfaceC2095gMo221c, 2);
                break;
            case 2:
                AbstractC1766e.m3920e("eSerializer", interfaceC2012a);
                super(interfaceC2012a);
                InterfaceC2095g interfaceC2095gMo221c2 = interfaceC2012a.mo221c();
                AbstractC1766e.m3920e("elementDesc", interfaceC2095gMo221c2);
                this.f264c = new C0088b(interfaceC2095gMo221c2, 3);
                break;
            default:
                AbstractC1766e.m3920e("element", interfaceC2012a);
                InterfaceC2095g interfaceC2095gMo221c3 = interfaceC2012a.mo221c();
                AbstractC1766e.m3920e("elementDesc", interfaceC2095gMo221c3);
                this.f264c = new C0088b(interfaceC2095gMo221c3, 1);
                break;
        }
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        switch (this.f263b) {
        }
        return (C0088b) this.f264c;
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: d */
    public final Object mo241d() {
        switch (this.f263b) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return new ArrayList();
            case 1:
                return new HashSet();
            default:
                return new LinkedHashSet();
        }
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: e */
    public final int mo242e(Object obj) {
        switch (this.f263b) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ArrayList arrayList = (ArrayList) obj;
                AbstractC1766e.m3920e("<this>", arrayList);
                return arrayList.size();
            case 1:
                HashSet hashSet = (HashSet) obj;
                AbstractC1766e.m3920e("<this>", hashSet);
                return hashSet.size();
            default:
                LinkedHashSet linkedHashSet = (LinkedHashSet) obj;
                AbstractC1766e.m3920e("<this>", linkedHashSet);
                return linkedHashSet.size();
        }
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: f */
    public final Iterator mo243f(Object obj) {
        Collection collection = (Collection) obj;
        AbstractC1766e.m3920e("<this>", collection);
        return collection.iterator();
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: g */
    public final int mo222g(Object obj) {
        Collection collection = (Collection) obj;
        AbstractC1766e.m3920e("<this>", collection);
        return collection.size();
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: j */
    public final Object mo224j(Object obj) {
        switch (this.f263b) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractC1766e.m3920e("<this>", null);
                return new ArrayList((Collection) null);
            case 1:
                AbstractC1766e.m3920e("<this>", null);
                return new HashSet((Collection) null);
            default:
                AbstractC1766e.m3920e("<this>", null);
                return new LinkedHashSet((Collection) null);
        }
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: k */
    public final Object mo244k(Object obj) {
        switch (this.f263b) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ArrayList arrayList = (ArrayList) obj;
                AbstractC1766e.m3920e("<this>", arrayList);
                return arrayList;
            case 1:
                HashSet hashSet = (HashSet) obj;
                AbstractC1766e.m3920e("<this>", hashSet);
                return hashSet;
            default:
                LinkedHashSet linkedHashSet = (LinkedHashSet) obj;
                AbstractC1766e.m3920e("<this>", linkedHashSet);
                return linkedHashSet;
        }
    }

    @Override // p008B2.AbstractC0120r
    /* JADX INFO: renamed from: l */
    public final void mo262l(Object obj, int i3, Object obj2) {
        switch (this.f263b) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ArrayList arrayList = (ArrayList) obj;
                AbstractC1766e.m3920e("<this>", arrayList);
                arrayList.add(i3, obj2);
                break;
            case 1:
                HashSet hashSet = (HashSet) obj;
                AbstractC1766e.m3920e("<this>", hashSet);
                hashSet.add(obj2);
                break;
            default:
                LinkedHashSet linkedHashSet = (LinkedHashSet) obj;
                AbstractC1766e.m3920e("<this>", linkedHashSet);
                linkedHashSet.add(obj2);
                break;
        }
    }
}
