package p011C2;

import java.util.List;
import p008B2.C0088b;
import p033K0.AbstractC0405c;
import p039M0.AbstractC0493h0;
import p086c2.C1093l;
import p119m2.AbstractC1766e;
import p167z2.C2100l;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: C2.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0151d implements InterfaceC2095g {

    /* JADX INFO: renamed from: b */
    public static final C0151d f361b = new C0151d();

    /* JADX INFO: renamed from: c */
    public static final String f362c = "kotlinx.serialization.json.JsonArray";

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C0088b f363a;

    public C0151d() {
        C0160m c0160m = C0160m.f390a;
        this.f363a = (C0088b) AbstractC0405c.m882a().f264c;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: a */
    public final String mo230a(int i3) {
        this.f363a.getClass();
        return String.valueOf(i3);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: b */
    public final boolean mo231b() {
        this.f363a.getClass();
        return false;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: c */
    public final int mo232c(String str) {
        AbstractC1766e.m3920e("name", str);
        return this.f363a.mo232c(str);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: d */
    public final String mo233d() {
        return f362c;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: f */
    public final boolean mo234f() {
        this.f363a.getClass();
        return false;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: g */
    public final List mo235g(int i3) {
        this.f363a.mo235g(i3);
        return C1093l.f3782e;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: h */
    public final InterfaceC2095g mo236h(int i3) {
        return this.f363a.mo236h(i3);
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: i */
    public final AbstractC0493h0 mo237i() {
        this.f363a.getClass();
        return C2100l.f7425d;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: j */
    public final boolean mo238j(int i3) {
        this.f363a.mo238j(i3);
        return false;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: k */
    public final List mo239k() {
        this.f363a.getClass();
        return C1093l.f3782e;
    }

    @Override // p167z2.InterfaceC2095g
    /* JADX INFO: renamed from: l */
    public final int mo240l() {
        return this.f363a.f235b;
    }
}
