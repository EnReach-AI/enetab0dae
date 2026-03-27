package p008B2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p011C2.C0148a;
import p011C2.InterfaceC0164q;
import p015D2.AbstractC0190n;
import p039M0.AbstractC0473V;
import p086c2.C1094m;
import p115l2.InterfaceC1678a;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1767f;
import p167z2.C2099k;
import p167z2.C2100l;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.z */
/* JADX INFO: loaded from: classes.dex */
public final class C0136z extends AbstractC1767f implements InterfaceC1678a {

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f349f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Object f350g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ Object f351h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0136z(C0068H c0068h) {
        super(0);
        this.f349f = 1;
        this.f350g = "kotlin.Unit";
        this.f351h = c0068h;
    }

    @Override // p115l2.InterfaceC1678a
    /* JADX INFO: renamed from: a */
    public final Object mo263a() {
        String[] strArrNames;
        switch (this.f349f) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0058A c0058a = (C0058A) this.f351h;
                c0058a.getClass();
                Enum[] enumArr = c0058a.f205a;
                C0134y c0134y = new C0134y(enumArr.length, (String) this.f350g);
                for (Enum r02 : enumArr) {
                    String strName = r02.name();
                    AbstractC1766e.m3920e("name", strName);
                    int i3 = c0134y.f272d + 1;
                    c0134y.f272d = i3;
                    String[] strArr = c0134y.f273e;
                    strArr[i3] = strName;
                    c0134y.f275g[i3] = false;
                    c0134y.f274f[i3] = null;
                    if (i3 == c0134y.f271c - 1) {
                        HashMap map = new HashMap();
                        int length = strArr.length;
                        for (int i4 = 0; i4 < length; i4++) {
                            map.put(strArr[i4], Integer.valueOf(i4));
                        }
                        c0134y.f276h = map;
                    }
                }
                return c0134y;
            case 1:
                return AbstractC0473V.m993E((String) this.f350g, C2100l.f7427f, new InterfaceC2095g[0], new C0085Z(0, (C0068H) this.f351h));
            default:
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                C0148a c0148a = (C0148a) this.f350g;
                boolean z3 = c0148a.f357a.f378m;
                InterfaceC2095g interfaceC2095g = (InterfaceC2095g) this.f351h;
                boolean z4 = z3 && AbstractC1766e.m3916a(interfaceC2095g.mo237i(), C2099k.f7423d);
                AbstractC0190n.m330l(c0148a, interfaceC2095g);
                int iMo240l = interfaceC2095g.mo240l();
                for (int i5 = 0; i5 < iMo240l; i5++) {
                    List listMo235g = interfaceC2095g.mo235g(i5);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : listMo235g) {
                        if (obj instanceof InterfaceC0164q) {
                            arrayList.add(obj);
                        }
                    }
                    String lowerCase = null;
                    InterfaceC0164q interfaceC0164q = (InterfaceC0164q) (arrayList.size() == 1 ? arrayList.get(0) : null);
                    if (interfaceC0164q != null && (strArrNames = interfaceC0164q.names()) != null) {
                        for (String lowerCase2 : strArrNames) {
                            if (z4) {
                                lowerCase2 = lowerCase2.toLowerCase(Locale.ROOT);
                                AbstractC1766e.m3919d("this as java.lang.String).toLowerCase(Locale.ROOT)", lowerCase2);
                            }
                            AbstractC0190n.m322d(linkedHashMap, interfaceC2095g, lowerCase2, i5);
                        }
                    }
                    if (z4) {
                        lowerCase = interfaceC2095g.mo230a(i5).toLowerCase(Locale.ROOT);
                        AbstractC1766e.m3919d("this as java.lang.String).toLowerCase(Locale.ROOT)", lowerCase);
                    }
                    if (lowerCase != null) {
                        AbstractC0190n.m322d(linkedHashMap, interfaceC2095g, lowerCase, i5);
                    }
                }
                return linkedHashMap.isEmpty() ? C1094m.f3783e : linkedHashMap;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0136z(Object obj, int i3, Object obj2) {
        super(0);
        this.f349f = i3;
        this.f351h = obj;
        this.f350g = obj2;
    }
}
