package p167z2;

import androidx.lifecycle.C0961F;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p008B2.AbstractC0089b0;
import p008B2.C0085Z;
import p008B2.InterfaceC0106k;
import p039M0.AbstractC0493h0;
import p071Y0.AbstractC0752p;
import p082b1.C1046q;
import p083b2.C1061f;
import p083b2.C1065j;
import p083b2.C1068m;
import p086c2.AbstractC1085d;
import p086c2.AbstractC1087f;
import p086c2.AbstractC1097p;
import p086c2.C1096o;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: z2.h */
/* JADX INFO: loaded from: classes.dex */
public final class C2096h implements InterfaceC2095g, InterfaceC0106k {

    /* JADX INFO: renamed from: a */
    public final String f7406a;

    /* JADX INFO: renamed from: b */
    public final AbstractC0493h0 f7407b;

    /* JADX INFO: renamed from: c */
    public final int f7408c;

    /* JADX INFO: renamed from: d */
    public final List f7409d;

    /* JADX INFO: renamed from: e */
    public final HashSet f7410e;

    /* JADX INFO: renamed from: f */
    public final String[] f7411f;

    /* JADX INFO: renamed from: g */
    public final InterfaceC2095g[] f7412g;

    /* JADX INFO: renamed from: h */
    public final List[] f7413h;

    /* JADX INFO: renamed from: i */
    public final boolean[] f7414i;

    /* JADX INFO: renamed from: j */
    public final Map f7415j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC2095g[] f7416k;

    /* JADX INFO: renamed from: l */
    public final C1065j f7417l;

    public C2096h(String str, AbstractC0493h0 abstractC0493h0, int i3, List list, C2089a c2089a) {
        AbstractC1766e.m3920e("serialName", str);
        this.f7406a = str;
        this.f7407b = abstractC0493h0;
        this.f7408c = i3;
        this.f7409d = c2089a.f7386b;
        ArrayList arrayList = c2089a.f7387c;
        AbstractC1766e.m3920e("<this>", arrayList);
        HashSet hashSet = new HashSet(AbstractC1097p.m2840i(AbstractC1087f.m2838v(arrayList, 12)));
        AbstractC1085d.m2835y(arrayList, hashSet);
        this.f7410e = hashSet;
        int i4 = 0;
        this.f7411f = (String[]) arrayList.toArray(new String[0]);
        this.f7412g = AbstractC0089b0.m256c(c2089a.f7389e);
        this.f7413h = (List[]) c2089a.f7390f.toArray(new List[0]);
        ArrayList arrayList2 = c2089a.f7391g;
        AbstractC1766e.m3920e("<this>", arrayList2);
        boolean[] zArr = new boolean[arrayList2.size()];
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            zArr[i4] = ((Boolean) it.next()).booleanValue();
            i4++;
        }
        this.f7414i = zArr;
        String[] strArr = this.f7411f;
        AbstractC1766e.m3920e("<this>", strArr);
        C1046q c1046q = new C1046q(1, new C0961F(1, strArr));
        ArrayList arrayList3 = new ArrayList(AbstractC1087f.m2838v(c1046q, 10));
        Iterator it2 = c1046q.iterator();
        while (true) {
            C1068m c1068m = (C1068m) it2;
            if (!((Iterator) c1068m.f3752g).hasNext()) {
                this.f7415j = AbstractC1097p.m2842k(arrayList3);
                this.f7416k = AbstractC0089b0.m256c(list);
                this.f7417l = new C1065j(new C0961F(3, this));
                return;
            }
            C1096o c1096o = (C1096o) c1068m.next();
            arrayList3.add(new C1061f(c1096o.f3786b, Integer.valueOf(c1096o.f3785a)));
        }
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: a */
    public final String mo230a(int i3) {
        return this.f7411f[i3];
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: b */
    public final boolean mo231b() {
        return false;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: c */
    public final int mo232c(String str) {
        AbstractC1766e.m3920e("name", str);
        Integer num = (Integer) this.f7415j.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: d */
    public final String mo233d() {
        return this.f7406a;
    }

    @Override // p008B2.InterfaceC0106k
    /* JADX INFO: renamed from: e */
    public final Set mo264e() {
        return this.f7410e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2096h) {
            InterfaceC2095g interfaceC2095g = (InterfaceC2095g) obj;
            if (AbstractC1766e.m3916a(mo233d(), interfaceC2095g.mo233d()) && Arrays.equals(this.f7416k, ((C2096h) obj).f7416k) && mo240l() == interfaceC2095g.mo240l()) {
                int iMo240l = mo240l();
                for (int i3 = 0; i3 < iMo240l; i3++) {
                    if (AbstractC1766e.m3916a(mo236h(i3).mo233d(), interfaceC2095g.mo236h(i3).mo233d()) && AbstractC1766e.m3916a(mo236h(i3).mo237i(), interfaceC2095g.mo236h(i3).mo237i())) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: f */
    public final boolean mo234f() {
        return false;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: g */
    public final List mo235g(int i3) {
        return this.f7413h[i3];
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: h */
    public final InterfaceC2095g mo236h(int i3) {
        return this.f7412g[i3];
    }

    public final int hashCode() {
        return ((Number) this.f7417l.getValue()).intValue();
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: i */
    public final AbstractC0493h0 mo237i() {
        return this.f7407b;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: j */
    public final boolean mo238j(int i3) {
        return this.f7414i[i3];
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: k */
    public final List mo239k() {
        return this.f7409d;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: l */
    public final int mo240l() {
        return this.f7408c;
    }

    public final String toString() {
        return AbstractC1085d.m2834x(AbstractC0752p.m1938j(0, this.f7408c), ", ", this.f7406a + '(', ")", new C0085Z(5, this), 24);
    }
}
