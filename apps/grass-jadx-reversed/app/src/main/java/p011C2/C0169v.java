package p011C2;

import java.util.List;
import p008B2.C0065E;
import p008B2.C0115o0;
import p039M0.AbstractC0493h0;
import p086c2.C1093l;
import p119m2.AbstractC1766e;
import p167z2.C2100l;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: C2.v */
/* JADX INFO: loaded from: classes.dex */
public final class C0169v implements InterfaceC2095g {

    /* JADX INFO: renamed from: b */
    public static final C0169v f402b = new C0169v();

    /* JADX INFO: renamed from: c */
    public static final String f403c = "kotlinx.serialization.json.JsonObject";

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C0065E f404a;

    public C0169v() {
        C0115o0 c0115o0 = C0115o0.f310a;
        C0160m c0160m = C0160m.f390a;
        C0115o0 c0115o02 = C0115o0.f310a;
        C0160m c0160m2 = C0160m.f390a;
        InterfaceC2095g interfaceC2095gMo221c = c0115o02.mo221c();
        InterfaceC2095g interfaceC2095gMo221c2 = c0160m2.mo221c();
        AbstractC1766e.m3920e("keyDesc", interfaceC2095gMo221c);
        AbstractC1766e.m3920e("valueDesc", interfaceC2095gMo221c2);
        this.f404a = new C0065E("kotlin.collections.LinkedHashMap", interfaceC2095gMo221c, interfaceC2095gMo221c2);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: a */
    public final String mo230a(int i3) {
        this.f404a.getClass();
        return String.valueOf(i3);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: b */
    public final boolean mo231b() {
        this.f404a.getClass();
        return false;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: c */
    public final int mo232c(String str) {
        AbstractC1766e.m3920e("name", str);
        return this.f404a.mo232c(str);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: d */
    public final String mo233d() {
        return f403c;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: f */
    public final boolean mo234f() {
        this.f404a.getClass();
        return false;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: g */
    public final List mo235g(int i3) {
        this.f404a.mo235g(i3);
        return C1093l.f3782e;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: h */
    public final InterfaceC2095g mo236h(int i3) {
        return this.f404a.mo236h(i3);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: i */
    public final AbstractC0493h0 mo237i() {
        this.f404a.getClass();
        return C2100l.f7426e;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: j */
    public final boolean mo238j(int i3) {
        this.f404a.mo238j(i3);
        return false;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: k */
    public final List mo239k() {
        this.f404a.getClass();
        return C1093l.f3782e;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: l */
    public final int mo240l() {
        return this.f404a.f220d;
    }
}
