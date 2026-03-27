package p008B2;

import java.util.List;
import java.util.Map;
import java.util.Set;
import p039M0.AbstractC0493h0;
import p071Y0.AbstractC0752p;
import p083b2.AbstractC1056a;
import p083b2.InterfaceC1059d;
import p086c2.AbstractC1085d;
import p086c2.C1093l;
import p086c2.C1094m;
import p119m2.AbstractC1766e;
import p161x2.InterfaceC2012a;
import p167z2.C2100l;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.d0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0093d0 implements InterfaceC2095g, InterfaceC0106k {

    /* JADX INFO: renamed from: a */
    public final String f269a;

    /* JADX INFO: renamed from: b */
    public final C0068H f270b;

    /* JADX INFO: renamed from: c */
    public final int f271c;

    /* JADX INFO: renamed from: d */
    public int f272d;

    /* JADX INFO: renamed from: e */
    public final String[] f273e;

    /* JADX INFO: renamed from: f */
    public final List[] f274f;

    /* JADX INFO: renamed from: g */
    public final boolean[] f275g;

    /* JADX INFO: renamed from: h */
    public Map f276h;

    /* JADX INFO: renamed from: i */
    public final InterfaceC1059d f277i;

    /* JADX INFO: renamed from: j */
    public final InterfaceC1059d f278j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC1059d f279k;

    public AbstractC0093d0(String str, C0068H c0068h, int i3) {
        AbstractC1766e.m3920e("serialName", str);
        this.f269a = str;
        this.f270b = c0068h;
        this.f271c = i3;
        this.f272d = -1;
        String[] strArr = new String[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            strArr[i4] = "[UNINITIALIZED]";
        }
        this.f273e = strArr;
        int i5 = this.f271c;
        this.f274f = new List[i5];
        this.f275g = new boolean[i5];
        this.f276h = C1094m.f3783e;
        this.f277i = AbstractC1056a.m2815b(new C0091c0(this, 1));
        this.f278j = AbstractC1056a.m2815b(new C0091c0(this, 2));
        this.f279k = AbstractC1056a.m2815b(new C0091c0(this, 0));
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: a */
    public final String mo230a(int i3) {
        return this.f273e[i3];
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: b */
    public boolean mo231b() {
        return false;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: c */
    public final int mo232c(String str) {
        AbstractC1766e.m3920e("name", str);
        Integer num = (Integer) this.f276h.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: d */
    public final String mo233d() {
        return this.f269a;
    }

    @Override // p008B2.InterfaceC0106k
    /* JADX INFO: renamed from: e */
    public final Set mo264e() {
        return this.f276h.keySet();
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: f */
    public final boolean mo234f() {
        return false;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: g */
    public final List mo235g(int i3) {
        List list = this.f274f[i3];
        return list == null ? C1093l.f3782e : list;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: h */
    public InterfaceC2095g mo236h(int i3) {
        return ((InterfaceC2012a[]) this.f277i.getValue())[i3].mo221c();
    }

    public int hashCode() {
        return ((Number) this.f279k.getValue()).intValue();
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: i */
    public AbstractC0493h0 mo237i() {
        return C2100l.f7424c;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: j */
    public final boolean mo238j(int i3) {
        return this.f275g[i3];
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: k */
    public final List mo239k() {
        return C1093l.f3782e;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: l */
    public final int mo240l() {
        return this.f271c;
    }

    public String toString() {
        return AbstractC1085d.m2834x(AbstractC0752p.m1938j(0, this.f271c), ", ", this.f269a + '(', ")", new C0085Z(1, this), 24);
    }
}
