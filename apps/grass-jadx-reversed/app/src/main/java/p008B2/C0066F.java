package p008B2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p004A2.InterfaceC0024a;
import p015D2.C0198v;
import p086c2.AbstractC1097p;
import p119m2.AbstractC1766e;
import p161x2.InterfaceC2012a;
import p167z2.AbstractC2094f;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.F */
/* JADX INFO: loaded from: classes.dex */
public final class C0066F extends AbstractC0086a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2012a f221a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2012a f222b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f223c;

    /* JADX INFO: renamed from: d */
    public final C0065E f224d;

    public C0066F(InterfaceC2012a interfaceC2012a, InterfaceC2012a interfaceC2012a2, byte b3) {
        this.f221a = interfaceC2012a;
        this.f222b = interfaceC2012a2;
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        AbstractC1766e.m3920e("encoder", c0198v);
        mo222g(obj);
        InterfaceC2095g interfaceC2095gMo221c = mo221c();
        AbstractC1766e.m3920e("descriptor", interfaceC2095gMo221c);
        C0198v c0198vM349a = c0198v.m349a(interfaceC2095gMo221c);
        Iterator itMo243f = mo243f(obj);
        int i3 = 0;
        while (itMo243f.hasNext()) {
            Map.Entry entry = (Map.Entry) itMo243f.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i4 = i3 + 1;
            c0198vM349a.m362n(mo221c(), i3, this.f221a, key);
            i3 += 2;
            c0198vM349a.m362n(mo221c(), i4, this.f222b, value);
        }
        c0198vM349a.m366r(interfaceC2095gMo221c);
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        switch (this.f223c) {
        }
        return this.f224d;
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: d */
    public final Object mo241d() {
        switch (this.f223c) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return new HashMap();
            default:
                return new LinkedHashMap();
        }
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: e */
    public final int mo242e(Object obj) {
        switch (this.f223c) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                HashMap map = (HashMap) obj;
                AbstractC1766e.m3920e("<this>", map);
                return map.size() * 2;
            default:
                LinkedHashMap linkedHashMap = (LinkedHashMap) obj;
                AbstractC1766e.m3920e("<this>", linkedHashMap);
                return linkedHashMap.size() * 2;
        }
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: f */
    public final Iterator mo243f(Object obj) {
        switch (this.f223c) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                Map map = (Map) obj;
                AbstractC1766e.m3920e("<this>", map);
                return map.entrySet().iterator();
            default:
                Map map2 = (Map) obj;
                AbstractC1766e.m3920e("<this>", map2);
                return map2.entrySet().iterator();
        }
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: g */
    public final int mo222g(Object obj) {
        switch (this.f223c) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                Map map = (Map) obj;
                AbstractC1766e.m3920e("<this>", map);
                return map.size();
            default:
                Map map2 = (Map) obj;
                AbstractC1766e.m3920e("<this>", map2);
                return map2.size();
        }
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: j */
    public final Object mo224j(Object obj) {
        switch (this.f223c) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractC1766e.m3920e("<this>", null);
                return new HashMap((Map) null);
            default:
                AbstractC1766e.m3920e("<this>", null);
                return new LinkedHashMap((Map) null);
        }
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: k */
    public final Object mo244k(Object obj) {
        switch (this.f223c) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                HashMap map = (HashMap) obj;
                AbstractC1766e.m3920e("<this>", map);
                return map;
            default:
                LinkedHashMap linkedHashMap = (LinkedHashMap) obj;
                AbstractC1766e.m3920e("<this>", linkedHashMap);
                return linkedHashMap;
        }
    }

    @Override // p008B2.AbstractC0086a
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final void mo223i(InterfaceC0024a interfaceC0024a, int i3, Map map, boolean z3) {
        int iMo86q;
        AbstractC1766e.m3920e("builder", map);
        Object objMo85p = interfaceC0024a.mo85p(mo221c(), i3, this.f221a, null);
        if (z3) {
            iMo86q = interfaceC0024a.mo86q(mo221c());
            if (iMo86q != i3 + 1) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + i3 + ", returned index for value: " + iMo86q).toString());
            }
        } else {
            iMo86q = i3 + 1;
        }
        boolean zContainsKey = map.containsKey(objMo85p);
        InterfaceC2012a interfaceC2012a = this.f222b;
        map.put(objMo85p, (!zContainsKey || (interfaceC2012a.mo221c().mo237i() instanceof AbstractC2094f)) ? interfaceC0024a.mo85p(mo221c(), iMo86q, interfaceC2012a, null) : interfaceC0024a.mo85p(mo221c(), iMo86q, interfaceC2012a, AbstractC1097p.m2839h(map, objMo85p)));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0066F(InterfaceC2012a interfaceC2012a, InterfaceC2012a interfaceC2012a2, int i3) {
        this(interfaceC2012a, interfaceC2012a2, (byte) 0);
        this.f223c = i3;
        switch (i3) {
            case 1:
                AbstractC1766e.m3920e("kSerializer", interfaceC2012a);
                AbstractC1766e.m3920e("vSerializer", interfaceC2012a2);
                this(interfaceC2012a, interfaceC2012a2, (byte) 0);
                InterfaceC2095g interfaceC2095gMo221c = interfaceC2012a.mo221c();
                InterfaceC2095g interfaceC2095gMo221c2 = interfaceC2012a2.mo221c();
                AbstractC1766e.m3920e("keyDesc", interfaceC2095gMo221c);
                AbstractC1766e.m3920e("valueDesc", interfaceC2095gMo221c2);
                this.f224d = new C0065E("kotlin.collections.LinkedHashMap", interfaceC2095gMo221c, interfaceC2095gMo221c2);
                break;
            default:
                AbstractC1766e.m3920e("kSerializer", interfaceC2012a);
                AbstractC1766e.m3920e("vSerializer", interfaceC2012a2);
                InterfaceC2095g interfaceC2095gMo221c3 = interfaceC2012a.mo221c();
                InterfaceC2095g interfaceC2095gMo221c4 = interfaceC2012a2.mo221c();
                AbstractC1766e.m3920e("keyDesc", interfaceC2095gMo221c3);
                AbstractC1766e.m3920e("valueDesc", interfaceC2095gMo221c4);
                this.f224d = new C0065E("kotlin.collections.HashMap", interfaceC2095gMo221c3, interfaceC2095gMo221c4);
                break;
        }
    }
}
