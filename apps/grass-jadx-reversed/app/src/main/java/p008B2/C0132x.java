package p008B2;

import p039M0.AbstractC0473V;
import p115l2.InterfaceC1678a;
import p119m2.AbstractC1767f;
import p167z2.C2098j;
import p167z2.C2100l;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.x */
/* JADX INFO: loaded from: classes.dex */
public final class C0132x extends AbstractC1767f implements InterfaceC1678a {

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f341f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ String f342g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ C0134y f343h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0132x(int i3, String str, C0134y c0134y) {
        super(0);
        this.f341f = i3;
        this.f342g = str;
        this.f343h = c0134y;
    }

    @Override // p115l2.InterfaceC1678a
    /* JADX INFO: renamed from: a */
    public final Object mo263a() {
        int i3 = this.f341f;
        InterfaceC2095g[] interfaceC2095gArr = new InterfaceC2095g[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            interfaceC2095gArr[i4] = AbstractC0473V.m993E(this.f342g + '.' + this.f343h.f273e[i4], C2100l.f7427f, new InterfaceC2095g[0], C2098j.f7421f);
        }
        return interfaceC2095gArr;
    }
}
