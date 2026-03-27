package p103h1;

import p039M0.EnumC0471T;
import p069X0.InterfaceC0714e;
import p100g1.AbstractC1399h;

/* JADX INFO: renamed from: h1.f */
/* JADX INFO: loaded from: classes.dex */
public final class C1418f extends AbstractC1431s {

    /* JADX INFO: renamed from: c */
    public final String f5043c;

    public C1418f(AbstractC1429q abstractC1429q, InterfaceC0714e interfaceC0714e, String str) {
        super(abstractC1429q, interfaceC0714e);
        this.f5043c = str;
    }

    @Override // p100g1.AbstractC1399h
    /* JADX INFO: renamed from: a */
    public final AbstractC1399h mo3100a(InterfaceC0714e interfaceC0714e) {
        return this.f5075b == interfaceC0714e ? this : new C1418f(this.f5074a, interfaceC0714e, this.f5043c);
    }

    @Override // p103h1.AbstractC1431s, p100g1.AbstractC1399h
    /* JADX INFO: renamed from: b */
    public final String mo3101b() {
        return this.f5043c;
    }

    @Override // p100g1.AbstractC1399h
    /* JADX INFO: renamed from: c */
    public final EnumC0471T mo3102c() {
        return EnumC0471T.f1110h;
    }
}
